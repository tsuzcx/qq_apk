package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class ReshapeFaceWidthFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    //gl_FragColor = vec4(inputTextureCoordinate.xy, vec2(0.0, 1.0));\n\n    //vec4 color = vec4(textureCoordinate.x*8.0+0.5, textureCoordinate.y*8.0+0.5, 0.5, 1.0);\n    //gl_FragColor = color;\n\n    //gl_FragColor = vec4(textureCoordinate, textureCoordinate.x, 1.0);\n\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  public static final String VERTEX_SHADER = "precision highp float;\n//uniform mat4 projection;\n//uniform mat4 faceFrame;\n//uniform mat4 stableToImage;\nuniform vec2 leftEyePlainSize;\nuniform vec3 leftEyeCenter;\nuniform vec2 rightEyePlainSize;\nuniform vec3 rightEyeCenter;\nuniform vec2 leftFacePlainSize;\nuniform vec3 leftFaceCenter;\nuniform vec2 rightFacePlainSize;\nuniform vec3 rightFaceCenter;\nuniform float faceWidth;\nuniform vec3 scaleCenter;\nattribute vec4 position;\n//attribute float faceIndex;\n//attribute float depthValue;\nvarying vec2 textureCoordinate;\nuniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll\n\nfloat getElipseMask(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize) {\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n    vec2 sigmas = boundingSize / sigmaScaling;\n    vec2 translate = point - center;\n    //float len = dot(point - center, vec2(cos_t, sin_t));\n    vec2 lengths = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) / sigmas;\n    float mask = exp(-dot(lengths, lengths));\n    return smoothstep(0.2, 0.8, mask);\n}\nfloat getLeftEyeFineMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(1.25, 0.7);\n    return getElipseMask(sigmaScaling, point, leftEyeCenter.xy, leftEyePlainSize);\n}\nfloat getRightEyeFineMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(1.25, 0.7);\n    return getElipseMask(sigmaScaling, point, rightEyeCenter.xy, rightEyePlainSize);\n}\nfloat getLeftFaceMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(0.9, 0.8);\n    return getElipseMask(sigmaScaling, point, leftFaceCenter.xy, leftFacePlainSize);\n}\nfloat getRightFaceMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(0.9, 0.8);\n    return getElipseMask(sigmaScaling, point, rightFaceCenter.xy, rightFacePlainSize);\n}\n\nvec3 getScaledEyesPoint(vec3 originalPoint, vec3 scalingFactors,float scalingFactor,float leftEyeMask, float rightEyeMask) {\n    if (scalingFactor == 0.0) {\n        return originalPoint;\n    }\n    vec3 eyesScaledPoint = originalPoint;\n    vec3 leftEyeScaledPoint = leftEyeCenter + scalingFactors * (originalPoint - leftEyeCenter);\n    eyesScaledPoint = mix(eyesScaledPoint, leftEyeScaledPoint, leftEyeMask);\n    vec3 rightEyeScaledPoint = rightEyeCenter + scalingFactors * (originalPoint - rightEyeCenter);\n    eyesScaledPoint = mix(eyesScaledPoint, rightEyeScaledPoint, rightEyeMask);\n    return mix(originalPoint, eyesScaledPoint, scalingFactor);\n}\n\nvec2 getFaceDistanceFactors() {\n    const float kEyesDistanceXRatio = 0.03662283339;\n    return kEyesDistanceXRatio * vec2(leftFaceCenter.x - rightFaceCenter.x, leftFaceCenter.y - rightFaceCenter.y);\n}\n\nvec2 getFaceDistanceFactors2() {\n    const float kEyesDistanceXRatio = 0.03662283339;\n    return kEyesDistanceXRatio * vec2(abs(position.x - scaleCenter.x), abs(position.y - scaleCenter.y));\n}\n\nvoid main() {\n    const float pi = 3.1415926;\n    //faceIndex;\n    float leftEyeFineMask     = getLeftEyeFineMask(position.xy);\n    float rightEyeFineMask    = getRightEyeFineMask(position.xy);\n    float leftFaceCoarseMask   = getLeftFaceMask(position.xy);\n    float rightFaceCoarseMask  = getRightFaceMask(position.xy);\n    vec3 displacedFacePoint   = position.xyz;\n\n    // width\n    vec2 faceDistanceFactors = getFaceDistanceFactors2();\n    vec3 leftEyeDistancePoint = vec3(displacedFacePoint.xy + faceWidth * faceDistanceFactors, displacedFacePoint.z);\n    displacedFacePoint = mix(displacedFacePoint, leftEyeDistancePoint, leftFaceCoarseMask * (1.0-leftEyeFineMask));\n    vec3 rightEyeDistancePoint = vec3(displacedFacePoint.xy - faceWidth * faceDistanceFactors, displacedFacePoint.z);\n    displacedFacePoint = mix(displacedFacePoint, rightEyeDistancePoint, rightFaceCoarseMask * (1.0-rightEyeFineMask));\n\n    vec2 originalPosition = (vec4(position.xyz, 1.0)).xy;\n    vec2 displacedPosition = (vec4(displacedFacePoint, 1.0)).xy;\n    textureCoordinate = displacedPosition;\n    gl_Position = vec4(originalPosition.x*2.0-1.0, originalPosition.y*2.0-1.0, 0.0, 1.0);\n}";
  private static final int XCOORD_NUM = 128;
  private static final int YCOORD_NUM = 128;
  private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
  private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
  private float[] angles = { 0.0F, 0.0F, 0.0F };
  private float faceWidth = 1.0F;
  private float[] leftEyeCenter = { 0.0F, 0.0F, 0.0F };
  private float[] leftEyePlainSize = { 0.0F, 0.0F };
  private float[] leftFaceCenter = { 0.0F, 0.0F, 0.0F };
  private float[] leftFacePlainSize = { 0.0F, 0.0F };
  private float[] rightEyeCenter = { 0.0F, 0.0F, 0.0F };
  private float[] rightEyePlainSize = { 0.0F, 0.0F };
  private float[] rightFaceCenter = { 0.0F, 0.0F, 0.0F };
  private float[] rightFacePlainSize = { 0.0F, 0.0F };
  private float[] scaleCenter = { 0.0F, 0.0F, 0.0F };
  
  public ReshapeFaceWidthFilter()
  {
    super(BaseFilter.nativeDecrypt("precision highp float;\n//uniform mat4 projection;\n//uniform mat4 faceFrame;\n//uniform mat4 stableToImage;\nuniform vec2 leftEyePlainSize;\nuniform vec3 leftEyeCenter;\nuniform vec2 rightEyePlainSize;\nuniform vec3 rightEyeCenter;\nuniform vec2 leftFacePlainSize;\nuniform vec3 leftFaceCenter;\nuniform vec2 rightFacePlainSize;\nuniform vec3 rightFaceCenter;\nuniform float faceWidth;\nuniform vec3 scaleCenter;\nattribute vec4 position;\n//attribute float faceIndex;\n//attribute float depthValue;\nvarying vec2 textureCoordinate;\nuniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll\n\nfloat getElipseMask(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize) {\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n    vec2 sigmas = boundingSize / sigmaScaling;\n    vec2 translate = point - center;\n    //float len = dot(point - center, vec2(cos_t, sin_t));\n    vec2 lengths = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) / sigmas;\n    float mask = exp(-dot(lengths, lengths));\n    return smoothstep(0.2, 0.8, mask);\n}\nfloat getLeftEyeFineMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(1.25, 0.7);\n    return getElipseMask(sigmaScaling, point, leftEyeCenter.xy, leftEyePlainSize);\n}\nfloat getRightEyeFineMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(1.25, 0.7);\n    return getElipseMask(sigmaScaling, point, rightEyeCenter.xy, rightEyePlainSize);\n}\nfloat getLeftFaceMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(0.9, 0.8);\n    return getElipseMask(sigmaScaling, point, leftFaceCenter.xy, leftFacePlainSize);\n}\nfloat getRightFaceMask(in vec2 point) {\n    const vec2 sigmaScaling = vec2(0.9, 0.8);\n    return getElipseMask(sigmaScaling, point, rightFaceCenter.xy, rightFacePlainSize);\n}\n\nvec3 getScaledEyesPoint(vec3 originalPoint, vec3 scalingFactors,float scalingFactor,float leftEyeMask, float rightEyeMask) {\n    if (scalingFactor == 0.0) {\n        return originalPoint;\n    }\n    vec3 eyesScaledPoint = originalPoint;\n    vec3 leftEyeScaledPoint = leftEyeCenter + scalingFactors * (originalPoint - leftEyeCenter);\n    eyesScaledPoint = mix(eyesScaledPoint, leftEyeScaledPoint, leftEyeMask);\n    vec3 rightEyeScaledPoint = rightEyeCenter + scalingFactors * (originalPoint - rightEyeCenter);\n    eyesScaledPoint = mix(eyesScaledPoint, rightEyeScaledPoint, rightEyeMask);\n    return mix(originalPoint, eyesScaledPoint, scalingFactor);\n}\n\nvec2 getFaceDistanceFactors() {\n    const float kEyesDistanceXRatio = 0.03662283339;\n    return kEyesDistanceXRatio * vec2(leftFaceCenter.x - rightFaceCenter.x, leftFaceCenter.y - rightFaceCenter.y);\n}\n\nvec2 getFaceDistanceFactors2() {\n    const float kEyesDistanceXRatio = 0.03662283339;\n    return kEyesDistanceXRatio * vec2(abs(position.x - scaleCenter.x), abs(position.y - scaleCenter.y));\n}\n\nvoid main() {\n    const float pi = 3.1415926;\n    //faceIndex;\n    float leftEyeFineMask     = getLeftEyeFineMask(position.xy);\n    float rightEyeFineMask    = getRightEyeFineMask(position.xy);\n    float leftFaceCoarseMask   = getLeftFaceMask(position.xy);\n    float rightFaceCoarseMask  = getRightFaceMask(position.xy);\n    vec3 displacedFacePoint   = position.xyz;\n\n    // width\n    vec2 faceDistanceFactors = getFaceDistanceFactors2();\n    vec3 leftEyeDistancePoint = vec3(displacedFacePoint.xy + faceWidth * faceDistanceFactors, displacedFacePoint.z);\n    displacedFacePoint = mix(displacedFacePoint, leftEyeDistancePoint, leftFaceCoarseMask * (1.0-leftEyeFineMask));\n    vec3 rightEyeDistancePoint = vec3(displacedFacePoint.xy - faceWidth * faceDistanceFactors, displacedFacePoint.z);\n    displacedFacePoint = mix(displacedFacePoint, rightEyeDistancePoint, rightFaceCoarseMask * (1.0-rightEyeFineMask));\n\n    vec2 originalPosition = (vec4(position.xyz, 1.0)).xy;\n    vec2 displacedPosition = (vec4(displacedFacePoint, 1.0)).xy;\n    textureCoordinate = displacedPosition;\n    gl_Position = vec4(originalPosition.x*2.0-1.0, originalPosition.y*2.0-1.0, 0.0, 1.0);\n}"), BaseFilter.nativeDecrypt("#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    //gl_FragColor = vec4(inputTextureCoordinate.xy, vec2(0.0, 1.0));\n\n    //vec4 color = vec4(textureCoordinate.x*8.0+0.5, textureCoordinate.y*8.0+0.5, 0.5, 1.0);\n    //gl_FragColor = color;\n\n    //gl_FragColor = vec4(textureCoordinate, textureCoordinate.x, 1.0);\n\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}"));
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    initParams();
    super.ApplyGLSLFilter();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLE_STRIP);
  }
  
  public void initAttribParams()
  {
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatsParam("leftEyePlainSize", this.leftEyePlainSize));
    addParam(new UniformParam.FloatsParam("leftEyeCenter", this.leftEyeCenter));
    addParam(new UniformParam.FloatsParam("rightEyePlainSize", this.rightEyePlainSize));
    addParam(new UniformParam.FloatsParam("rightEyeCenter", this.rightEyeCenter));
    addParam(new UniformParam.FloatsParam("leftFacePlainSize", this.leftFacePlainSize));
    addParam(new UniformParam.FloatsParam("leftFaceCenter", this.leftFaceCenter));
    addParam(new UniformParam.FloatsParam("rightFacePlainSize", this.rightFacePlainSize));
    addParam(new UniformParam.FloatsParam("rightFaceCenter", this.rightFaceCenter));
    addParam(new UniformParam.FloatsParam("scaleCenter", this.scaleCenter));
    addParam(new UniformParam.FloatParam("faceWidth", this.faceWidth));
    addParam(new UniformParam.FloatsParam("angles", this.angles));
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("leftEyePlainSize")) {
      this.leftEyePlainSize = ((float[])paramMap.get("leftEyePlainSize"));
    }
    if (paramMap.containsKey("leftEyeCenter")) {
      this.leftEyeCenter = ((float[])paramMap.get("leftEyeCenter"));
    }
    if (paramMap.containsKey("rightEyePlainSize")) {
      this.rightEyePlainSize = ((float[])paramMap.get("rightEyePlainSize"));
    }
    if (paramMap.containsKey("rightEyeCenter")) {
      this.rightEyeCenter = ((float[])paramMap.get("rightEyeCenter"));
    }
    if (paramMap.containsKey("leftFacePlainSize")) {
      this.leftFacePlainSize = ((float[])paramMap.get("leftFacePlainSize"));
    }
    if (paramMap.containsKey("leftFaceCenter")) {
      this.leftFaceCenter = ((float[])paramMap.get("leftFaceCenter"));
    }
    if (paramMap.containsKey("rightFacePlainSize")) {
      this.rightFacePlainSize = ((float[])paramMap.get("rightFacePlainSize"));
    }
    if (paramMap.containsKey("rightFaceCenter")) {
      this.rightFaceCenter = ((float[])paramMap.get("rightFaceCenter"));
    }
    if (paramMap.containsKey("scaleCenter")) {
      this.scaleCenter = ((float[])paramMap.get("scaleCenter"));
    }
    if (paramMap.containsKey("faceWidth")) {
      this.faceWidth = (((Float)paramMap.get("faceWidth")).floatValue() * 0.007F);
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    initParams();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.ReshapeFaceWidthFilter
 * JD-Core Version:    0.7.0.1
 */