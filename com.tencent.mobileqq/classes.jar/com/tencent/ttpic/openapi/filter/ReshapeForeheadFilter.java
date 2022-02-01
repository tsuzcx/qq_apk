package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;
import java.util.Map;

public class ReshapeForeheadFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER_NORMAL = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    //gl_FragColor = vec4(inputTextureCoordinate.xy, vec2(0.0, 1.0));\n\n    //vec4 color = vec4(textureCoordinate.x*8.0+0.5, textureCoordinate.y*8.0+0.5, 0.5, 1.0);\n    //gl_FragColor = color;\n\n    //gl_FragColor = vec4(textureCoordinate, textureCoordinate.x, 1.0);\n\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
  public static final String FRAGMENT_SHADER_VTF = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n\n    //vec2 diffPosition = textureCoordinate;\n    //float ddx = (diffPosition.x + 1.0) / 2.0;\n    //float ddy = (diffPosition.y + 1.0) / 2.0;\n    //diffPosition = vec2(ddx,ddy);\n    //vec2 a = fract(diffPosition * 255.0 / 256.0);\n    //vec2 b = fract(diffPosition * 255.0 * 255.0 / 256.0);\n    //gl_FragColor = vec4(a,b);\n\n    // 新版的 shader 颜色通道中记录的是位移偏移量，只有在最后 combinedFilter 才最终将所有 filter 的位移量叠加，去图上取点。这样的好处是：\n    // 1. 只有 128 * 128 个点\n    // 2. smoothstep 会更平滑，128 * 128 个点取插值，原来的处理方法会使像素点变模糊\n    // 3. 两个矩形交叠的地方，位移处理的先后顺序不影响结果（不能说这是好还是坏，因为 PS 的液化是作用在原图上的）\n\n    // 至于此处要改为 * 255 再 / 255 是为了提升精度（浮点纹理 iOS 不支持，而一个字节只能表示 256 个不同值）\n    // 本来小奇使用了浮点纹理，但是发现有机型不支持，不用浮点纹理又精度不够，所以采用这个方法，变成2个字节表示一个值，提升了精度。\n    vec2 diffPosition = textureCoordinate;\n    diffPosition = 0.5 * (diffPosition + 1.0) * 255.0;  // 0.5 * (diffPosition + 1.0) 是将(-1, 1)间的值转换到(0, 1)，\n    vec2 a = floor(diffPosition) / 255.0;\n    vec2 b = fract(diffPosition);\n    gl_FragColor = vec4(a, b);\n\n\n    //vec2 diffPosition = textureCoordinate;\n    //diffPosition = 0.5 * (diffPosition + 1.0) * 256.0;\n    //vec2 a = floor(diffPosition) / 256.0;\n    //vec2 b = fract(diffPosition);\n    //gl_FragColor = vec4(a, b);\n}\n";
  public static final String VERTEX_SHADER_NORMAL = "precision highp float;\n//uniform mat4 projection;\n//uniform mat4 faceFrame;\n//uniform mat4 stableToImage;\n\nuniform vec2 foreheadSize;\nuniform vec3 foreheadCenter;\nuniform vec2 leftEyebrowPlainSize;\nuniform vec3 leftEyebrowCenter;\nuniform vec2 rightEyebrowPlainSize;\nuniform vec3 rightEyebrowCenter;\nuniform float foreheadHeight;\n\nattribute vec4 position;\nvarying vec2 textureCoordinate;\nuniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll\nuniform vec2 size;\n\nuniform sampler2D inputImageTexture;\n\nfloat my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nfloat getEllipseMask(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize, float a1, float a2) {\n    // un-normalization\n    boundingSize = boundingSize * size;\n    point = point * size;\n    center = center * size;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n    vec2 translate = (point - center);\n    // rotate and scale\n    vec2 v = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) * sigmaScaling;\n\n    float d2 = sqrt(dot(v / boundingSize, v / boundingSize));\n\n    return 1.0 - my_smoothstep(a1, a2, d2);\n}\n\nfloat getLeftEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, leftEyebrowCenter.xy, leftEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getRightEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, rightEyebrowCenter.xy, rightEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getForeheadMask() {\n    const vec2 sigmaScaling = vec2(1.5, 1.5);\n    return getEllipseMask(sigmaScaling, position.xy, foreheadCenter.xy, foreheadSize, 0.4, 1.3);\n}\n\nvec3 getScaledFacePoint2(vec3 originalPoint, vec3 center, vec3 scalingFactors, float mask) {\n    vec3 scaledPoint = center + scalingFactors * (originalPoint - center);\n    return mix(originalPoint, scaledPoint, mask);\n}\n\nvoid main() {\n    const float pi = 3.1415926;\n    float foreheadMask    = getForeheadMask() * (1.0 - getLeftEyebrowMask()) * (1.0 - getRightEyebrowMask());\n    vec3 displacedForeheadPoint   = position.xyz;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n\n    //vec3 displacedForeheadPoint2 = getScaledFacePoint2(displacedForeheadPoint, foreheadCenter, vec3(1.1, 1.1, 1.0), 0.3*foreheadHeight*foreheadMask);\n\n    const float kForeheadLiftingYRatio = 0.05518821053;\n    vec2 foreheadLiftingVector = vec2(0.0, -kForeheadLiftingYRatio * foreheadSize.y);\n    foreheadLiftingVector = vec2(dot(foreheadLiftingVector, vec2(cos_t, -sin_t)), dot(foreheadLiftingVector, vec2(sin_t, cos_t)));\n    vec3 foreheadPositionPoint = vec3(displacedForeheadPoint.xy + foreheadLiftingVector, displacedForeheadPoint.z);\n    displacedForeheadPoint = mix(displacedForeheadPoint, foreheadPositionPoint, foreheadMask * foreheadHeight);\n\n    displacedForeheadPoint = displacedForeheadPoint;\n\n    vec2 originalPosition = (vec4(position.xyz, 1.0)).xy;\n    vec2 displacedPosition = (vec4(displacedForeheadPoint, 1.0)).xy;\n\n    textureCoordinate = displacedPosition;\n    gl_Position = vec4(originalPosition.x*2.0-1.0, originalPosition.y*2.0-1.0, 0.0, 1.0);\n}";
  public static final String VERTEX_SHADER_VTF = "precision highp float;\n//uniform mat4 projection;\n//uniform mat4 faceFrame;\n//uniform mat4 stableToImage;\n\nuniform vec2 foreheadSize;\nuniform vec3 foreheadCenter;\nuniform vec2 leftEyebrowPlainSize;\nuniform vec3 leftEyebrowCenter;\nuniform vec2 rightEyebrowPlainSize;\nuniform vec3 rightEyebrowCenter;\nuniform float foreheadHeight;\n\nattribute vec4 position;\nvarying vec2 textureCoordinate;\nuniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll\nuniform vec2 size;\n\nuniform sampler2D inputImageTexture;\n\nfloat my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nfloat getEllipseMask(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize, float a1, float a2) {\n    // un-normalization\n    boundingSize = boundingSize * size;\n    point = point * size;\n    center = center * size;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n    vec2 translate = (point - center);\n    // rotate and scale\n    vec2 v = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) * sigmaScaling;\n\n    float d2 = sqrt(dot(v / boundingSize, v / boundingSize));\n\n    return 1.0 - my_smoothstep(a1, a2, d2);\n}\n\nfloat getLeftEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, leftEyebrowCenter.xy, leftEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getRightEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, rightEyebrowCenter.xy, rightEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getForeheadMask() {\n    const vec2 sigmaScaling = vec2(1.5, 1.5);\n    return getEllipseMask(sigmaScaling, position.xy, foreheadCenter.xy, foreheadSize, 0.4, 1.3);\n}\n\nvec3 getScaledFacePoint2(vec3 originalPoint, vec3 center, vec3 scalingFactors, float mask) {\n    vec3 scaledPoint = center + scalingFactors * (originalPoint - center);\n    return mix(originalPoint, scaledPoint, mask);\n}\n\nvoid main() {\n    const float pi = 3.1415926;\n    float foreheadMask    = getForeheadMask() * (1.0 - getLeftEyebrowMask()) * (1.0 - getRightEyebrowMask());\n    vec3 displacedForeheadPoint   = position.xyz;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n\n    //vec3 displacedForeheadPoint2 = getScaledFacePoint2(displacedForeheadPoint, foreheadCenter, vec3(1.1, 1.1, 1.0), 0.3*foreheadHeight*foreheadMask);\n\n    const float kForeheadLiftingYRatio = 0.05518821053;\n    vec2 foreheadLiftingVector = vec2(0.0, -kForeheadLiftingYRatio * foreheadSize.y);\n    foreheadLiftingVector = vec2(dot(foreheadLiftingVector, vec2(cos_t, -sin_t)), dot(foreheadLiftingVector, vec2(sin_t, cos_t)));\n    vec3 foreheadPositionPoint = vec3(displacedForeheadPoint.xy + foreheadLiftingVector, displacedForeheadPoint.z);\n    displacedForeheadPoint = mix(displacedForeheadPoint, foreheadPositionPoint, foreheadMask * foreheadHeight);\n\n    displacedForeheadPoint = displacedForeheadPoint;\n\n    vec2 originalPosition = (vec4(position.xyz, 1.0)).xy;\n    vec2 displacedPosition = (vec4(displacedForeheadPoint, 1.0)).xy;\n    highp vec4 color = texture2D(inputImageTexture, position.xy);\n    highp vec2 offset = (color.xy * 255.0 + color.zw) / 127.5 - 1.0;\n    textureCoordinate = offset + displacedPosition - originalPosition;\n\n    gl_Position = vec4(originalPosition.x*2.0-1.0, originalPosition.y*2.0-1.0, 0.0, 1.0);\n}";
  private static final int XCOORD_NUM = 128;
  private static final int YCOORD_NUM = 128;
  private static List<PointF> mFullscreenVerticesPortrait = VideoMaterial.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
  private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterial.genFullScreenVertices(128, 128, 0.0F, 1.0F, 0.0F, 1.0F);
  private float[] angles = { 0.0F, 0.0F, 0.0F };
  private float[] foreheadCenter = { 0.0F, 0.0F, 0.0F };
  private float foreheadHeight;
  private float[] foreheadSize = { 0.0F, 0.0F };
  private float[] leftEyebrowCenter = { 0.0F, 0.0F, 0.0F };
  private float[] leftEyebrowPlainSize = { 0.0F, 0.0F };
  private float meshType;
  private float[] rightEyebrowCenter = { 0.0F, 0.0F, 0.0F };
  private float[] rightEyebrowPlainSize = { 0.0F, 0.0F };
  private float[] size = { 1.0F, 1.0F };
  
  public ReshapeForeheadFilter(ReshapeType paramReshapeType)
  {
    super("precision highp float;\n//uniform mat4 projection;\n//uniform mat4 faceFrame;\n//uniform mat4 stableToImage;\n\nuniform vec2 foreheadSize;\nuniform vec3 foreheadCenter;\nuniform vec2 leftEyebrowPlainSize;\nuniform vec3 leftEyebrowCenter;\nuniform vec2 rightEyebrowPlainSize;\nuniform vec3 rightEyebrowCenter;\nuniform float foreheadHeight;\n\nattribute vec4 position;\nvarying vec2 textureCoordinate;\nuniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll\nuniform vec2 size;\n\nuniform sampler2D inputImageTexture;\n\nfloat my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nfloat getEllipseMask(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize, float a1, float a2) {\n    // un-normalization\n    boundingSize = boundingSize * size;\n    point = point * size;\n    center = center * size;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n    vec2 translate = (point - center);\n    // rotate and scale\n    vec2 v = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) * sigmaScaling;\n\n    float d2 = sqrt(dot(v / boundingSize, v / boundingSize));\n\n    return 1.0 - my_smoothstep(a1, a2, d2);\n}\n\nfloat getLeftEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, leftEyebrowCenter.xy, leftEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getRightEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, rightEyebrowCenter.xy, rightEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getForeheadMask() {\n    const vec2 sigmaScaling = vec2(1.5, 1.5);\n    return getEllipseMask(sigmaScaling, position.xy, foreheadCenter.xy, foreheadSize, 0.4, 1.3);\n}\n\nvec3 getScaledFacePoint2(vec3 originalPoint, vec3 center, vec3 scalingFactors, float mask) {\n    vec3 scaledPoint = center + scalingFactors * (originalPoint - center);\n    return mix(originalPoint, scaledPoint, mask);\n}\n\nvoid main() {\n    const float pi = 3.1415926;\n    float foreheadMask    = getForeheadMask() * (1.0 - getLeftEyebrowMask()) * (1.0 - getRightEyebrowMask());\n    vec3 displacedForeheadPoint   = position.xyz;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n\n    //vec3 displacedForeheadPoint2 = getScaledFacePoint2(displacedForeheadPoint, foreheadCenter, vec3(1.1, 1.1, 1.0), 0.3*foreheadHeight*foreheadMask);\n\n    const float kForeheadLiftingYRatio = 0.05518821053;\n    vec2 foreheadLiftingVector = vec2(0.0, -kForeheadLiftingYRatio * foreheadSize.y);\n    foreheadLiftingVector = vec2(dot(foreheadLiftingVector, vec2(cos_t, -sin_t)), dot(foreheadLiftingVector, vec2(sin_t, cos_t)));\n    vec3 foreheadPositionPoint = vec3(displacedForeheadPoint.xy + foreheadLiftingVector, displacedForeheadPoint.z);\n    displacedForeheadPoint = mix(displacedForeheadPoint, foreheadPositionPoint, foreheadMask * foreheadHeight);\n\n    displacedForeheadPoint = displacedForeheadPoint;\n\n    vec2 originalPosition = (vec4(position.xyz, 1.0)).xy;\n    vec2 displacedPosition = (vec4(displacedForeheadPoint, 1.0)).xy;\n\n    textureCoordinate = displacedPosition;\n    gl_Position = vec4(originalPosition.x*2.0-1.0, originalPosition.y*2.0-1.0, 0.0, 1.0);\n}", "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    //gl_FragColor = vec4(inputTextureCoordinate.xy, vec2(0.0, 1.0));\n\n    //vec4 color = vec4(textureCoordinate.x*8.0+0.5, textureCoordinate.y*8.0+0.5, 0.5, 1.0);\n    //gl_FragColor = color;\n\n    //gl_FragColor = vec4(textureCoordinate, textureCoordinate.x, 1.0);\n\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    float f = 0.0F;
    this.foreheadHeight = 0.0F;
    this.meshType = 0.0F;
    if (paramReshapeType == ReshapeType.VTF) {
      updateFilterShader("precision highp float;\n//uniform mat4 projection;\n//uniform mat4 faceFrame;\n//uniform mat4 stableToImage;\n\nuniform vec2 foreheadSize;\nuniform vec3 foreheadCenter;\nuniform vec2 leftEyebrowPlainSize;\nuniform vec3 leftEyebrowCenter;\nuniform vec2 rightEyebrowPlainSize;\nuniform vec3 rightEyebrowCenter;\nuniform float foreheadHeight;\n\nattribute vec4 position;\nvarying vec2 textureCoordinate;\nuniform vec3 angles; // angles.x: pitch, angles.y: yaw, angles.z: roll\nuniform vec2 size;\n\nuniform sampler2D inputImageTexture;\n\nfloat my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nfloat getEllipseMask(in vec2 sigmaScaling, in vec2 point,in vec2 center, in vec2 boundingSize, float a1, float a2) {\n    // un-normalization\n    boundingSize = boundingSize * size;\n    point = point * size;\n    center = center * size;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n    vec2 translate = (point - center);\n    // rotate and scale\n    vec2 v = vec2(dot(translate, vec2(cos_t, sin_t)), dot(translate, vec2(-sin_t, cos_t))) * sigmaScaling;\n\n    float d2 = sqrt(dot(v / boundingSize, v / boundingSize));\n\n    return 1.0 - my_smoothstep(a1, a2, d2);\n}\n\nfloat getLeftEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, leftEyebrowCenter.xy, leftEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getRightEyebrowMask() {\n    const vec2 sigmaScaling = vec2(1.0, 0.8);\n    return getEllipseMask(sigmaScaling, position.xy, rightEyebrowCenter.xy, rightEyebrowPlainSize, 0.6, 1.0);\n}\nfloat getForeheadMask() {\n    const vec2 sigmaScaling = vec2(1.5, 1.5);\n    return getEllipseMask(sigmaScaling, position.xy, foreheadCenter.xy, foreheadSize, 0.4, 1.3);\n}\n\nvec3 getScaledFacePoint2(vec3 originalPoint, vec3 center, vec3 scalingFactors, float mask) {\n    vec3 scaledPoint = center + scalingFactors * (originalPoint - center);\n    return mix(originalPoint, scaledPoint, mask);\n}\n\nvoid main() {\n    const float pi = 3.1415926;\n    float foreheadMask    = getForeheadMask() * (1.0 - getLeftEyebrowMask()) * (1.0 - getRightEyebrowMask());\n    vec3 displacedForeheadPoint   = position.xyz;\n\n    float cos_t = cos(angles.z);\n    float sin_t = sin(angles.z);\n\n    //vec3 displacedForeheadPoint2 = getScaledFacePoint2(displacedForeheadPoint, foreheadCenter, vec3(1.1, 1.1, 1.0), 0.3*foreheadHeight*foreheadMask);\n\n    const float kForeheadLiftingYRatio = 0.05518821053;\n    vec2 foreheadLiftingVector = vec2(0.0, -kForeheadLiftingYRatio * foreheadSize.y);\n    foreheadLiftingVector = vec2(dot(foreheadLiftingVector, vec2(cos_t, -sin_t)), dot(foreheadLiftingVector, vec2(sin_t, cos_t)));\n    vec3 foreheadPositionPoint = vec3(displacedForeheadPoint.xy + foreheadLiftingVector, displacedForeheadPoint.z);\n    displacedForeheadPoint = mix(displacedForeheadPoint, foreheadPositionPoint, foreheadMask * foreheadHeight);\n\n    displacedForeheadPoint = displacedForeheadPoint;\n\n    vec2 originalPosition = (vec4(position.xyz, 1.0)).xy;\n    vec2 displacedPosition = (vec4(displacedForeheadPoint, 1.0)).xy;\n    highp vec4 color = texture2D(inputImageTexture, position.xy);\n    highp vec2 offset = (color.xy * 255.0 + color.zw) / 127.5 - 1.0;\n    textureCoordinate = offset + displacedPosition - originalPosition;\n\n    gl_Position = vec4(originalPosition.x*2.0-1.0, originalPosition.y*2.0-1.0, 0.0, 1.0);\n}", "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n\n    //vec2 diffPosition = textureCoordinate;\n    //float ddx = (diffPosition.x + 1.0) / 2.0;\n    //float ddy = (diffPosition.y + 1.0) / 2.0;\n    //diffPosition = vec2(ddx,ddy);\n    //vec2 a = fract(diffPosition * 255.0 / 256.0);\n    //vec2 b = fract(diffPosition * 255.0 * 255.0 / 256.0);\n    //gl_FragColor = vec4(a,b);\n\n    // 新版的 shader 颜色通道中记录的是位移偏移量，只有在最后 combinedFilter 才最终将所有 filter 的位移量叠加，去图上取点。这样的好处是：\n    // 1. 只有 128 * 128 个点\n    // 2. smoothstep 会更平滑，128 * 128 个点取插值，原来的处理方法会使像素点变模糊\n    // 3. 两个矩形交叠的地方，位移处理的先后顺序不影响结果（不能说这是好还是坏，因为 PS 的液化是作用在原图上的）\n\n    // 至于此处要改为 * 255 再 / 255 是为了提升精度（浮点纹理 iOS 不支持，而一个字节只能表示 256 个不同值）\n    // 本来小奇使用了浮点纹理，但是发现有机型不支持，不用浮点纹理又精度不够，所以采用这个方法，变成2个字节表示一个值，提升了精度。\n    vec2 diffPosition = textureCoordinate;\n    diffPosition = 0.5 * (diffPosition + 1.0) * 255.0;  // 0.5 * (diffPosition + 1.0) 是将(-1, 1)间的值转换到(0, 1)，\n    vec2 a = floor(diffPosition) / 255.0;\n    vec2 b = fract(diffPosition);\n    gl_FragColor = vec4(a, b);\n\n\n    //vec2 diffPosition = textureCoordinate;\n    //diffPosition = 0.5 * (diffPosition + 1.0) * 256.0;\n    //vec2 a = floor(diffPosition) / 256.0;\n    //vec2 b = fract(diffPosition);\n    //gl_FragColor = vec4(a, b);\n}\n");
    }
    if (paramReshapeType == ReshapeType.NORMAL) {
      f = 0.5F;
    }
    this.meshType = f;
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
    setPositions(VideoMaterial.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterial.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(32897);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatsParam("foreheadSize", this.foreheadSize));
    addParam(new UniformParam.FloatsParam("foreheadCenter", this.foreheadCenter));
    addParam(new UniformParam.FloatsParam("leftEyebrowPlainSize", this.leftEyebrowPlainSize));
    addParam(new UniformParam.FloatsParam("leftEyebrowCenter", this.leftEyebrowCenter));
    addParam(new UniformParam.FloatsParam("rightEyebrowPlainSize", this.rightEyebrowPlainSize));
    addParam(new UniformParam.FloatsParam("rightEyebrowCenter", this.rightEyebrowCenter));
    addParam(new UniformParam.FloatParam("foreheadHeight", this.foreheadHeight));
    addParam(new UniformParam.FloatsParam("angles", this.angles));
    addParam(new UniformParam.FloatsParam("size", this.size));
    addParam(new UniformParam.FloatParam("meshType", this.meshType));
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("leftEyebrowPlainSize")) {
      this.leftEyebrowPlainSize = ((float[])paramMap.get("leftEyebrowPlainSize"));
    }
    if (paramMap.containsKey("leftEyebrowCenter")) {
      this.leftEyebrowCenter = ((float[])paramMap.get("leftEyebrowCenter"));
    }
    if (paramMap.containsKey("rightEyebrowPlainSize")) {
      this.rightEyebrowPlainSize = ((float[])paramMap.get("rightEyebrowPlainSize"));
    }
    if (paramMap.containsKey("rightEyebrowCenter")) {
      this.rightEyebrowCenter = ((float[])paramMap.get("rightEyebrowCenter"));
    }
    if (paramMap.containsKey("foreheadSize")) {
      this.foreheadSize = ((float[])paramMap.get("foreheadSize"));
    }
    if (paramMap.containsKey("foreheadCenter")) {
      this.foreheadCenter = ((float[])paramMap.get("foreheadCenter"));
    }
    if (paramMap.containsKey("angles")) {
      this.angles = ((float[])paramMap.get("angles"));
    }
    if (paramMap.containsKey("foreheadHeight"))
    {
      this.foreheadHeight = (((Float)paramMap.get("foreheadHeight")).floatValue() * 0.024F);
      float f = this.foreheadHeight;
      if (f > 0.0F) {
        this.foreheadHeight = (f * 1.5F);
      }
    }
    if (paramMap.containsKey("size")) {
      this.size = ((float[])paramMap.get("size"));
    }
    initParams();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ReshapeForeheadFilter
 * JD-Core Version:    0.7.0.1
 */