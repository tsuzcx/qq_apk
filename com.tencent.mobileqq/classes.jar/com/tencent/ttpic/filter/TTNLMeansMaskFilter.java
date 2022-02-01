package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class TTNLMeansMaskFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n varying float textureSkinOpacity;\n varying vec2 textureCoordinate;\n uniform vec2 textureSize;\n \n vec4 meanColor(vec4 iColor) {\n     float horStep = 1.0 / textureSize.x;\n     float verStep = 1.0 / textureSize.y;\n     vec4 sumColor = iColor;\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, 0.0));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(horStep, 0.0));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(0.0, -verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(0.0, verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, -verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(horStep, -verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(horStep, verStep));\n     return vec4(sumColor.rgb/9.0, iColor.a);\n }\n \n lowp vec3 rgb2hsv(lowp vec3 c) {\n     lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n     highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n     highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n     highp float d = q.x - min(q.w, q.y);\n     highp float e = 1.0e-10;\n     lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n     return hsv;\n }\n \n void main() {\n     vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 mColor = meanColor(iColor);\n     lowp vec3 hsv = rgb2hsv(mColor.rgb);\n     mediump float p1 = clamp((max(iColor.r, mColor.r) - 0.2) * 4.0, 0.0, 1.0);\n     mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n     mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n     mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n     mediump float p2 = min(max(p2_left, p2_right), p2_value);\n     mediump float p = max(p1, p2) * textureSkinOpacity;\n     gl_FragColor = vec4(p, p, p, 1.0);\n }\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute float inputSkinOpacity;\n \n varying vec2 textureCoordinate;\n varying float textureSkinOpacity;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = position.xy * 0.5 + 0.5;\n     textureSkinOpacity = inputSkinOpacity;\n }\n";
  private float[] eyeOpacity = { 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F };
  private float[] globalOpacity = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  
  public TTNLMeansMaskFilter()
  {
    super("attribute vec4 position;\n attribute float inputSkinOpacity;\n \n varying vec2 textureCoordinate;\n varying float textureSkinOpacity;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = position.xy * 0.5 + 0.5;\n     textureSkinOpacity = inputSkinOpacity;\n }\n", "precision highp float;\n uniform sampler2D inputImageTexture;\n varying float textureSkinOpacity;\n varying vec2 textureCoordinate;\n uniform vec2 textureSize;\n \n vec4 meanColor(vec4 iColor) {\n     float horStep = 1.0 / textureSize.x;\n     float verStep = 1.0 / textureSize.y;\n     vec4 sumColor = iColor;\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, 0.0));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(horStep, 0.0));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(0.0, -verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(0.0, verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, -verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(horStep, -verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, verStep));\n     sumColor += texture2D(inputImageTexture, textureCoordinate+vec2(horStep, verStep));\n     return vec4(sumColor.rgb/9.0, iColor.a);\n }\n \n lowp vec3 rgb2hsv(lowp vec3 c) {\n     lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n     highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n     highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n     highp float d = q.x - min(q.w, q.y);\n     highp float e = 1.0e-10;\n     lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n     return hsv;\n }\n \n void main() {\n     vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     vec4 mColor = meanColor(iColor);\n     lowp vec3 hsv = rgb2hsv(mColor.rgb);\n     mediump float p1 = clamp((max(iColor.r, mColor.r) - 0.2) * 4.0, 0.0, 1.0);\n     mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n     mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n     mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n     mediump float p2 = min(max(p2_left, p2_right), p2_value);\n     mediump float p = max(p1, p2) * textureSkinOpacity;\n     gl_FragColor = vec4(p, p, p, 1.0);\n }\n");
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("inputSkinOpacity", this.globalOpacity);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float2fParam("textureSize", 720.0F, 960.0F));
  }
  
  public void updateGlobalAttribute()
  {
    addAttribParam("inputSkinOpacity", this.globalOpacity);
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void updateLeftEyeAttribute(List<PointF> paramList)
  {
    addAttribParam("inputSkinOpacity", this.eyeOpacity);
    paramList = AlgoUtils.getLeftEyeRectF(paramList);
    float f1 = paramList.left;
    float f2 = paramList.top;
    float f3 = paramList.right;
    float f4 = paramList.bottom;
    double d1 = this.width;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int i = (int)(d1 * d2);
    d1 = this.height;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    setPositions(AlgoUtils.calPositions(f1, f2, f3, f4, i, (int)(d1 * d2)));
  }
  
  public void updateRightEyeAttribute(List<PointF> paramList)
  {
    addAttribParam("inputSkinOpacity", this.eyeOpacity);
    paramList = AlgoUtils.getRightEyeRectF(paramList);
    float f1 = paramList.left;
    float f2 = paramList.top;
    float f3 = paramList.right;
    float f4 = paramList.bottom;
    double d1 = this.width;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int i = (int)(d1 * d2);
    d1 = this.height;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    setPositions(AlgoUtils.calPositions(f1, f2, f3, f4, i, (int)(d1 * d2)));
  }
  
  public void updateSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.Float2fParam("textureSize", paramFloat1, paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.TTNLMeansMaskFilter
 * JD-Core Version:    0.7.0.1
 */