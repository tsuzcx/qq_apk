package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float2sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class StickerDisplacementBlurFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision lowp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nvarying highp vec4 textureShift_1;\nuniform vec2 leftEyeSize[3];\nuniform vec2 leftEyeCenter[3];\nuniform vec2 rightEyeSize[3];\nuniform vec2 rightEyeCenter[3];\nuniform float cos_t[3];\nuniform float sin_t[3];\nuniform int faceCount;\nuniform vec2 canvasSize;\n\nfloat getEllipseDist(vec2 point, vec2 center, vec2 boundingSize, float cos_value, float sin_value) {\n  vec2 translate = (point - center);\n  vec2 v = vec2(dot(translate, vec2(cos_value, sin_value)), dot(translate, vec2(-sin_value, cos_value)));\n  float d2 = 2.0 * sqrt(dot(v / boundingSize, v / boundingSize));\n  return d2;\n}\nfloat eye_getLeftEyeFineDist(vec2 center, vec2 size, float cos_value, float sin_value) {\n  return getEllipseDist(textureCoordinate * canvasSize, center, size, cos_value, sin_value);\n}\nfloat eye_getRightEyeFineDist(vec2 center, vec2 size, float cos_value, float sin_value) {\n  return getEllipseDist(textureCoordinate * canvasSize, center, size, cos_value, sin_value);\n}\nvoid main() {\n    mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n    float eyeAlpha = 1.0;\n    for (int i = 0; i < faceCount; ++i) {\n      float leftDist = eye_getLeftEyeFineDist(leftEyeCenter[i], leftEyeSize[i], cos_t[i], sin_t[i]);\n      float rightDist = eye_getRightEyeFineDist(rightEyeCenter[i], rightEyeSize[i], cos_t[i], sin_t[i]);\n      eyeAlpha = eyeAlpha * smoothstep(0.0, 1.5, leftDist) * smoothstep(0.0, 1.5, rightDist);\n    }\n    gl_FragColor = vec4(sum * 0.3333, eyeAlpha);\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec4 textureShift_1;\n\nvoid main() {\n    gl_Position = position;\n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureShift_1 = vec4(inputTextureCoordinate.xy - singleStepOffset, inputTextureCoordinate.xy + singleStepOffset);\n}";
  private float[] cos_t = new float[3];
  private float[] leftEyeCenter = new float[6];
  private float[] leftEyeSize = new float[6];
  private float[] rightEyeCenter = new float[6];
  private float[] rightEyeSize = new float[6];
  private float[] sin_t = new float[3];
  private BaseFilter veticalFilter = new BaseFilter("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec4 textureShift_1;\n\nvoid main() {\n    gl_Position = position;\n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureShift_1 = vec4(inputTextureCoordinate.xy - singleStepOffset, inputTextureCoordinate.xy + singleStepOffset);\n}", "precision lowp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nvarying highp vec4 textureShift_1;\nuniform vec2 leftEyeSize[3];\nuniform vec2 leftEyeCenter[3];\nuniform vec2 rightEyeSize[3];\nuniform vec2 rightEyeCenter[3];\nuniform float cos_t[3];\nuniform float sin_t[3];\nuniform int faceCount;\nuniform vec2 canvasSize;\n\nfloat getEllipseDist(vec2 point, vec2 center, vec2 boundingSize, float cos_value, float sin_value) {\n  vec2 translate = (point - center);\n  vec2 v = vec2(dot(translate, vec2(cos_value, sin_value)), dot(translate, vec2(-sin_value, cos_value)));\n  float d2 = 2.0 * sqrt(dot(v / boundingSize, v / boundingSize));\n  return d2;\n}\nfloat eye_getLeftEyeFineDist(vec2 center, vec2 size, float cos_value, float sin_value) {\n  return getEllipseDist(textureCoordinate * canvasSize, center, size, cos_value, sin_value);\n}\nfloat eye_getRightEyeFineDist(vec2 center, vec2 size, float cos_value, float sin_value) {\n  return getEllipseDist(textureCoordinate * canvasSize, center, size, cos_value, sin_value);\n}\nvoid main() {\n    mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n    float eyeAlpha = 1.0;\n    for (int i = 0; i < faceCount; ++i) {\n      float leftDist = eye_getLeftEyeFineDist(leftEyeCenter[i], leftEyeSize[i], cos_t[i], sin_t[i]);\n      float rightDist = eye_getRightEyeFineDist(rightEyeCenter[i], rightEyeSize[i], cos_t[i], sin_t[i]);\n      eyeAlpha = eyeAlpha * smoothstep(0.0, 1.5, leftDist) * smoothstep(0.0, 1.5, rightDist);\n    }\n    gl_FragColor = vec4(sum * 0.3333, eyeAlpha);\n}\n");
  
  public StickerDisplacementBlurFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying vec2 textureCoordinate;\nvarying vec4 textureShift_1;\n\nvoid main() {\n    gl_Position = position;\n    vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureShift_1 = vec4(inputTextureCoordinate.xy - singleStepOffset, inputTextureCoordinate.xy + singleStepOffset);\n}", "precision lowp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nvarying highp vec4 textureShift_1;\nuniform vec2 leftEyeSize[3];\nuniform vec2 leftEyeCenter[3];\nuniform vec2 rightEyeSize[3];\nuniform vec2 rightEyeCenter[3];\nuniform float cos_t[3];\nuniform float sin_t[3];\nuniform int faceCount;\nuniform vec2 canvasSize;\n\nfloat getEllipseDist(vec2 point, vec2 center, vec2 boundingSize, float cos_value, float sin_value) {\n  vec2 translate = (point - center);\n  vec2 v = vec2(dot(translate, vec2(cos_value, sin_value)), dot(translate, vec2(-sin_value, cos_value)));\n  float d2 = 2.0 * sqrt(dot(v / boundingSize, v / boundingSize));\n  return d2;\n}\nfloat eye_getLeftEyeFineDist(vec2 center, vec2 size, float cos_value, float sin_value) {\n  return getEllipseDist(textureCoordinate * canvasSize, center, size, cos_value, sin_value);\n}\nfloat eye_getRightEyeFineDist(vec2 center, vec2 size, float cos_value, float sin_value) {\n  return getEllipseDist(textureCoordinate * canvasSize, center, size, cos_value, sin_value);\n}\nvoid main() {\n    mediump vec3 sum = texture2D(inputImageTexture, textureCoordinate).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.xy).rgb;\n    sum += texture2D(inputImageTexture, textureShift_1.zw).rgb;\n    float eyeAlpha = 1.0;\n    for (int i = 0; i < faceCount; ++i) {\n      float leftDist = eye_getLeftEyeFineDist(leftEyeCenter[i], leftEyeSize[i], cos_t[i], sin_t[i]);\n      float rightDist = eye_getRightEyeFineDist(rightEyeCenter[i], rightEyeSize[i], cos_t[i], sin_t[i]);\n      eyeAlpha = eyeAlpha * smoothstep(0.0, 1.5, leftDist) * smoothstep(0.0, 1.5, rightDist);\n    }\n    gl_FragColor = vec4(sum * 0.3333, eyeAlpha);\n}\n");
    initParams();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    setNextFilter(this.veticalFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 0.004166667F));
    addParam(new UniformParam.FloatParam("texelHeightOffset", 0.0F));
    addParam(new UniformParam.Float1sParam("sin_t", this.sin_t));
    addParam(new UniformParam.Float1sParam("cos_t", this.cos_t));
    addParam(new UniformParam.Float2sParam("leftEyeCenter", this.leftEyeCenter));
    addParam(new UniformParam.Float2sParam("leftEyeSize", this.leftEyeSize));
    addParam(new UniformParam.Float2sParam("rightEyeCenter", this.rightEyeCenter));
    addParam(new UniformParam.Float2sParam("rightEyeSize", this.rightEyeSize));
    addParam(new UniformParam.IntParam("faceCount", 0));
    addParam(new UniformParam.Float2fParam("canvasSize", 1.0F, 1.0F));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelWidthOffset", 0.0F));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelHeightOffset", 0.003125F));
    this.veticalFilter.addParam(new UniformParam.Float1sParam("sin_t", this.sin_t));
    this.veticalFilter.addParam(new UniformParam.Float1sParam("cos_t", this.cos_t));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("leftEyeCenter", this.leftEyeCenter));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("leftEyeSize", this.leftEyeSize));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("rightEyeCenter", this.rightEyeCenter));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("rightEyeSize", this.rightEyeSize));
    this.veticalFilter.addParam(new UniformParam.IntParam("faceCount", 0));
    this.veticalFilter.addParam(new UniformParam.Float2fParam("canvasSize", 1.0F, 1.0F));
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    this.veticalFilter.setPositions(paramArrayOfFloat);
    return super.setPositions(paramArrayOfFloat);
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    this.veticalFilter.setTexCords(paramArrayOfFloat);
    return super.setTexCords(paramArrayOfFloat);
  }
  
  public void updateParam(PTFaceAttr paramPTFaceAttr, float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 1.5F / paramFloat1));
    this.veticalFilter.addParam(new UniformParam.FloatParam("texelHeightOffset", 1.5F / paramFloat2));
    int j = Math.min(paramPTFaceAttr.getAllFacePoints().size(), 3);
    this.veticalFilter.addParam(new UniformParam.IntParam("faceCount", j));
    double d1 = paramFloat1;
    double d2 = paramPTFaceAttr.getFaceDetectScale();
    Double.isNaN(d1);
    int k = (int)(d1 * d2);
    d1 = paramFloat2;
    d2 = paramPTFaceAttr.getFaceDetectScale();
    Double.isNaN(d1);
    int m = (int)(d1 * d2);
    int i = 0;
    while (i < j)
    {
      List localList = (List)paramPTFaceAttr.getAllFacePoints().get(i);
      d1 = (float)Math.atan2(((PointF)localList.get(53)).y - ((PointF)localList.get(43)).y, ((PointF)localList.get(53)).x - ((PointF)localList.get(43)).x);
      paramFloat1 = (float)Math.cos(d1);
      paramFloat2 = (float)Math.sin(d1);
      this.cos_t[i] = paramFloat1;
      this.sin_t[i] = paramFloat2;
      float[] arrayOfFloat = this.leftEyeSize;
      int n = i * 2;
      arrayOfFloat[n] = AlgoUtils.getDistance((PointF)localList.get(39), (PointF)localList.get(35));
      arrayOfFloat = this.leftEyeSize;
      int i1 = n + 1;
      arrayOfFloat[i1] = AlgoUtils.getDistance((PointF)localList.get(41), (PointF)localList.get(37));
      this.leftEyeCenter[n] = ((PointF)localList.get(43)).x;
      this.leftEyeCenter[i1] = ((PointF)localList.get(43)).y;
      this.rightEyeSize[n] = AlgoUtils.getDistance((PointF)localList.get(45), (PointF)localList.get(49));
      this.rightEyeSize[i1] = AlgoUtils.getDistance((PointF)localList.get(51), (PointF)localList.get(47));
      this.rightEyeCenter[n] = ((PointF)localList.get(53)).x;
      this.rightEyeCenter[i1] = ((PointF)localList.get(53)).y;
      i += 1;
    }
    this.veticalFilter.addParam(new UniformParam.Float1sParam("sin_t", this.sin_t));
    this.veticalFilter.addParam(new UniformParam.Float1sParam("cos_t", this.cos_t));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("leftEyeCenter", this.leftEyeCenter));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("leftEyeSize", this.leftEyeSize));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("rightEyeCenter", this.rightEyeCenter));
    this.veticalFilter.addParam(new UniformParam.Float2sParam("rightEyeSize", this.rightEyeSize));
    this.veticalFilter.addParam(new UniformParam.Float2fParam("canvasSize", k, m));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.StickerDisplacementBlurFilter
 * JD-Core Version:    0.7.0.1
 */