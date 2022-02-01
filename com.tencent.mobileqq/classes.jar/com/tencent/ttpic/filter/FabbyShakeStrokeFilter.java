package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.Int1sParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.FabbyGLParam.FloatV2Param;
import com.tencent.filter.FabbyGLParam.FloatV4Param;

public class FabbyShakeStrokeFilter
  extends BaseFilter
{
  public static String FRAGMENT_SHADER = "//描边\n#define NOISE fbm\n#define NUM_NOISE_OCTAVES 5\n#define STROKE_TYPE_DEFAULT (0)\n#define STROKE_TYPE_SHAKE (1)\n\n     // 描边\n     precision lowp float;\n\n     varying highp vec2 textureCoordinate;\n\n     uniform sampler2D inputImageTexture;//image\n     uniform sampler2D inputImageTexture2;//mask\n     uniform sampler2D inputImageTexture3;//bg\n\n     uniform float stepX;\n     uniform float stepY;\n     uniform float strokeGapInPixel;\n     uniform float strokeWidthInPixel;\n     uniform vec4 strokeColor;\n\n     uniform float strokeGapInPixelArr[10];\n     uniform float strokeWidthInPixelArr[10];\n     uniform vec4 strokeColorArr[10];\n     uniform vec2 strokeOffsetInPixelArr[10];   // xy上的偏移\n     uniform vec2 strokeShakeAmplitudeArr[10];// 抖动振幅\n     uniform vec2 strokeShakeFrequencyArr[10];// 抖动频率\n     uniform int strokeTypeArr[10];    // 线条类型，0 为默认线条，1为抖动线条\n     uniform int strokeCount;\n\n     uniform float  u_time;\n\n     float alphaForStep(vec2 coordinate, float step_x, float step_y, float weight) {\n         float step_x45 = step_x * 0.7071;\n         float step_y45 = step_y * 0.7071;\n\n         vec4 v3_10 = texture2D(inputImageTexture2, vec2(coordinate.x, coordinate.y+step_y));\n         vec4 v3_11 = texture2D(inputImageTexture2, vec2(coordinate.x+step_x45, coordinate.y+step_y45));\n         vec4 v3_12 = texture2D(inputImageTexture2, vec2(coordinate.x+step_x, coordinate.y));\n         vec4 v3_13 = texture2D(inputImageTexture2, vec2(coordinate.x+step_x45, coordinate.y-step_y45));\n         vec4 v3_14 = texture2D(inputImageTexture2, vec2(coordinate.x, coordinate.y-step_y));\n         vec4 v3_15 = texture2D(inputImageTexture2, vec2(coordinate.x-step_x45, coordinate.y-step_y45));\n         vec4 v3_16 = texture2D(inputImageTexture2, vec2(coordinate.x-step_x, coordinate.y));\n         vec4 v3_17 = texture2D(inputImageTexture2, vec2(coordinate.x-step_x45, coordinate.y+step_y45));\n\n         float avg_r = (v3_10.r+v3_11.r+v3_12.r+v3_13.r+v3_14.r+v3_15.r+v3_16.r+v3_17.r) * 0.125;\n\n         float alpha = step(weight, avg_r);\n         return alpha;\n     }\n\n     float hash(highp vec2 p) {\n        return fract(1e4 * sin(17.0 * p.x + p.y * 0.1) * (0.1 + abs(sin(p.y * 13.0 + p.x))));\n      }\n\n     float noise(highp vec2 x) {\n         vec2 i = floor(x);\n         vec2 f = fract(x);\n\n         // Four corners in 2D of a tile\n         float a = hash(i);\n         float b = hash(i + vec2(1.0, 0.0));\n         float c = hash(i + vec2(0.0, 1.0));\n         float d = hash(i + vec2(1.0, 1.0));\n\n         // Simple 2D lerp using smoothstep envelope between the values.\n         // return vec3(mix(mix(a, b, smoothstep(0.0, 1.0, f.x)),\n         //            mix(c, d, smoothstep(0.0, 1.0, f.x)),\n         //            smoothstep(0.0, 1.0, f.y)));\n\n         // Same code, with the clamps in smoothstep and common subexpressions\n         // optimized away.\n         vec2 u = f * f * (3.0 - 2.0 * f);\n         return mix(a, b, u.x) + (c - a) * u.y * (1.0 - u.x) + (d - b) * u.x * u.y;\n     }\n\n     float fbm(highp vec2 x) {\n         float v = 0.0;\n         float a = 0.5;\n         vec2 shift = vec2(100);\n         // Rotate to reduce axial bias\n         mat2 rot = mat2(cos(0.5), sin(0.5), -sin(0.5), cos(0.50));\n         for (int i = 0; i < NUM_NOISE_OCTAVES; ++i) {\n             v += a * noise(x);\n             x = rot * x * 2.0 + shift;\n             a *= 0.5;\n         }\n         return v;\n     }\n\n     float hash(highp float n) { return fract(sin(n) * 1e4); }\n\n     float noise(highp float x) {\n         float i = floor(x);\n         float f = fract(x);\n         float u = f * f * (3.0 - 2.0 * f);\n         return mix(hash(i), hash(i + 1.0), u);\n     }\n\n     float fbm(highp float x) {\n         float v = 0.0;\n         float a = 0.5;\n         float shift = float(100);\n         for (int i = 0; i < NUM_NOISE_OCTAVES; ++i) {\n             v += a * noise(x);\n             x = x * 2.0 + shift;\n             a *= 0.5;\n         }\n         return v;\n     }\n\n     void main()\n    {\n        vec4 v1 = texture2D(inputImageTexture, textureCoordinate);\n        vec4 v2 = texture2D(inputImageTexture2, textureCoordinate);\n        vec4 bg = texture2D(inputImageTexture3, textureCoordinate);\n\n        float mask = v2.r;\n        vec2 coordinate = textureCoordinate;\n        vec2 uv = coordinate;\n\n        vec4 mixBgColor = mix(bg, v1, mask);\n\n        for (int i = 0; i < strokeCount; i++) {\n            float gapInPixel = strokeGapInPixelArr[i];\n            float widthInPixel = strokeWidthInPixelArr[i];\n            vec4 strokeColor = strokeColorArr[i];\n            vec2 strokeOffsetInPixel = strokeOffsetInPixelArr[i];\n            vec2 strokeShakeAmplitude = strokeShakeAmplitudeArr[i];\n            vec2 strokeShakeFrequency = strokeShakeFrequencyArr[i];\n            int strokeType = strokeTypeArr[i];\n\n            vec2 fbmOffset = vec2(0.0);\n            float fbmOffsetY = 0.0;\n            float fbmOffsetX = 0.0;\n\n            if (STROKE_TYPE_SHAKE == strokeType) {  // 抖动线条计算偏移\n                fbmOffsetX = fbm(uv.xy * 2.0 + u_time * 0.01 * strokeShakeFrequency.x);\n                fbmOffsetY = fbm(uv.xy * 2.0 + u_time * 0.1 * strokeShakeFrequency.y);\n                fbmOffset += vec2((fbmOffsetX - 0.5) * 0.1 * strokeShakeAmplitude.x, (fbmOffsetY - 0.5) * 0.1 * strokeShakeAmplitude.y);\n            }\n\n            float x = stepX * gapInPixel;\n            float y = stepY * gapInPixel;\n            vec2 coord = coordinate + vec2(strokeOffsetInPixel.x * stepX, strokeOffsetInPixel.y * stepY) + fbmOffset;\n            float innerAlpha = alphaForStep(coord, x, y, 0.01);\n\n            x += stepX * widthInPixel;\n            y += stepY * widthInPixel;\n            float outterAlpha = alphaForStep(coord, x, y, 0.01);\n            float resultAlpha = (1.0 - innerAlpha) * outterAlpha;\n\n            mixBgColor = mix(mixBgColor, strokeColor, resultAlpha * strokeColor.a);\n        }\n\n\n        gl_FragColor = mixBgColor;\n\n    }\n";
  private float uTime = 0.0F;
  
  public FabbyShakeStrokeFilter()
  {
    super(FRAGMENT_SHADER);
    initParam();
  }
  
  private void initParam()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.FloatParam("stepX", 0.0F));
    addParam(new UniformParam.FloatParam("stepY", 0.0F));
    addParam(new UniformParam.FloatParam("strokeGapInPixel", 0.0F));
    addParam(new UniformParam.FloatParam("strokeWidthInPixel", 0.0F));
    addParam(new UniformParam.Float4fParam("strokeColor", 0.0F, 0.0F, 0.0F, 1.0F));
    addParam(new UniformParam.IntParam("feather", 0));
    addParam(new FabbyGLParam.FloatV4Param("strokeColorArr", new float[] { 0.0F, 0.0F, 0.0F, 1.0F }));
    addParam(new UniformParam.FloatsParam("strokeGapInPixelArr", new float[] { 0.0F }));
    addParam(new UniformParam.FloatsParam("strokeWidthInPixelArr", new float[] { 7.0F }));
    addParam(new FabbyGLParam.FloatV2Param("strokeOffsetInPixelArr", new float[] { -0.0041F, 0.0082F }));
    addParam(new FabbyGLParam.FloatV2Param("strokeShakeAmplitudeArr", new float[] { 0.0F, 0.0F }));
    addParam(new FabbyGLParam.FloatV2Param("strokeShakeFrequencyArr", new float[] { 0.0F, 0.0F }));
    addParam(new UniformParam.Int1sParam("strokeTypeArr", new int[] { 0 }));
    addParam(new UniformParam.IntParam("strokeCount", 1));
    addParam(new UniformParam.FloatParam("u_time", 0.0F));
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void setBgTex(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
  }
  
  public void setFeather(int paramInt)
  {
    addParam(new UniformParam.IntParam("feather", paramInt));
  }
  
  public void setStepX(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("stepX", paramFloat));
  }
  
  public void setStepY(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("stepY", paramFloat));
  }
  
  public void setStrokeColor(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float4fParam("strokeColor", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]));
  }
  
  public void setStrokeColorArr(float[] paramArrayOfFloat)
  {
    addParam(new FabbyGLParam.FloatV4Param("strokeColorArr", paramArrayOfFloat));
  }
  
  public void setStrokeCount(int paramInt)
  {
    addParam(new UniformParam.IntParam("strokeCount", paramInt));
  }
  
  public void setStrokeGapInPixel(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("strokeGapInPixel", paramFloat));
  }
  
  public void setStrokeGapInPixelArr(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float1sParam("strokeGapInPixelArr", paramArrayOfFloat));
  }
  
  public void setStrokeOffsetInPixelArr(float[] paramArrayOfFloat)
  {
    addParam(new FabbyGLParam.FloatV2Param("strokeOffsetInPixelArr", paramArrayOfFloat));
  }
  
  public void setStrokeShakeAmplitudeArr(float[] paramArrayOfFloat)
  {
    addParam(new FabbyGLParam.FloatV2Param("strokeShakeAmplitudeArr", paramArrayOfFloat));
  }
  
  public void setStrokeShakeFrequencyArr(float[] paramArrayOfFloat)
  {
    addParam(new FabbyGLParam.FloatV2Param("strokeShakeFrequencyArr", paramArrayOfFloat));
  }
  
  public void setStrokeTypeArr(int[] paramArrayOfInt)
  {
    addParam(new UniformParam.Int1sParam("strokeTypeArr", paramArrayOfInt));
  }
  
  public void setStrokeWidthInPixel(float paramFloat)
  {
    addParam(new UniformParam.FloatsParam("strokeWidthInPixelArr", new float[] { paramFloat }));
  }
  
  public void setStrokeWidthInPixelArr(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float1sParam("strokeWidthInPixelArr", paramArrayOfFloat));
  }
  
  public void setmMaskTex(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updateUTime()
  {
    this.uTime += 1.0F;
    float f2 = this.uTime;
    float f1 = f2;
    if (f2 > 10000.0F) {
      f1 = 0.0F;
    }
    this.uTime = f1;
    addParam(new UniformParam.FloatParam("u_time", this.uTime * 2.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyShakeStrokeFilter
 * JD-Core Version:    0.7.0.1
 */