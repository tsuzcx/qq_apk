package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.SwitchFaceUtil;
import com.tencent.ttpic.openapi.util.SwitchFaceUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FaceCopyFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "//Need Sync FaceOffFragmentShaderExt.dat\n\nprecision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying float pointVisValue;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\n\nuniform float alpha;\nuniform int enableFaceOff;\nuniform float enableAlphaFromGray;\nuniform float enableAlphaFromGrayNew;\nuniform int blendMode;\nuniform int blendIris;\nuniform float level1;\nuniform float level2;\nuniform float filterSkin;\n\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\n\nuniform int leftEyeClosed; // deprecated\nuniform int rightEyeClosed; // deprecated\nuniform float leftEyeCloseAlpha;\nuniform float rightEyeCloseAlpha;\n\nvec3 blendColorWithMode(vec4 texColor, vec4 canvasColor, int colorBlendMode)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    vec3 resultFore = texColor.rgb;\n    if (colorBlendMode <= 1){ //default, since used most, put on top\n\n    } else if (colorBlendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (colorBlendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (colorBlendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (colorBlendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (colorBlendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (colorBlendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    return resultFore;\n}\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor) {\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    if (blendMode <= 12) {\n        resultFore = blendColorWithMode(texColor, canvasColor, blendMode);\n    } else if (blendMode == 13){   //highlight for lips\n        if (texColor.a > 0.0001) {\n            if(canvasColor.r >= level1) {\n                texColor.rgb = vec3(1.0, 1.0, 1.0);\n                //if(canvasColor.r < 0.6) {\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05;\n                //}\n            } else if (canvasColor.r >= level2) {\n               if (level1 > level2) {\n                   float f = (canvasColor.r - level2) / (level1 - level2);\n                   texColor.rgb = texColor.rgb + (vOne - texColor.rgb) * f;\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05 * f;\n               }\n            }\n        }\n        resultFore = canvasColor.rgb * texColor.rgb;\n        resultFore = clamp(resultFore, 0.0001, 0.9999);\n    } else if (blendMode == 14){   // iris\n         vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n         float dist1 = sqrt((curPos.x - center1.x) * (curPos.x - center1.x) + (curPos.y - center1.y) * (curPos.y - center1.y));\n         float dist2 = sqrt((curPos.x - center2.x) * (curPos.x - center2.x) + (curPos.y - center2.y) * (curPos.y - center2.y));\n         if (dist1 < radius1 && leftEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center1.x) / radius1 / 2.0;\n             float _y = (curPos.y - center1.y) / radius1 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * leftEyeCloseAlpha;\n         } else if (dist2 < radius2 && rightEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center2.x) / radius2 / 2.0;\n             float _y = (curPos.y - center2.y) / radius2 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * rightEyeCloseAlpha;\n         } else {\n            texColor.a = 0.0;\n         }\n         //resultFore = texColor.rgb;\n         //texColor.a = 1.0;\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 grayColor = texture2D(inputImageTexture3, grayTextureCoordinate);\n    vec4 maskColor = texture2D(inputImageTexture5, grayTextureCoordinate);\n\n    if (enableFaceOff == 1) {\n        if (texColor.a > 0.0) {\n            texColor = texColor / vec4(texColor.a, texColor.a, texColor.a, 1.0);\n        }\n        if(enableAlphaFromGray > 0.0){\n            float grayAlpha = (1.0 - mix(maskColor.r, grayColor.r, enableAlphaFromGrayNew));\n            texColor.a = texColor.a * grayAlpha * alpha;\n        } else {\n            texColor.a = texColor.a * alpha;\n        }\n    }\n\n    float confidence = smoothstep(0.7, 1.0, pointVisValue);\n\n    texColor.a = texColor.a * confidence;\n\n//    if(confidence >= 0.0){\n//            texColor.a = texColor.a * confidence;\n//    }\n\n    texColor.rgb = texColor.rgb * texColor.a;\n    float skin_p = clamp((canvasColor.r - 0.2) * 4.0, 0.0, 1.0);\n    texColor.a *= mix(1.0, skin_p, filterSkin);\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n }\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nattribute float pointsVisValue;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying float pointVisValue;\n\nuniform vec2 canvasSize;\nuniform float positionRotate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    grayTextureCoordinate = inputGrayTextureCoordinate;\n    pointVisValue = pointsVisValue;\n}";
  private float[] faceVertices = new float[276];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[276];
  private List<List<PointF>> mFaceLists;
  private int mFaceTex;
  private float[] texVertices = new float[276];
  
  public FaceCopyFilter()
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF));
    initParams();
    this.mFaceLists = new ArrayList();
    this.mFaceTex = -1;
  }
  
  float distanceFrom(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  List<PointF> faceSwapFacePoint(List<PointF> paramList)
  {
    if (paramList.size() != 97) {
      return null;
    }
    float f1 = ((PointF)paramList.get(9)).x;
    float f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    PointF localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(41), (PointF)paramList.get(51));
    double d = 3.141592653589793D + Math.atan2(f1 - f2, f3 + f4);
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 19)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    localArrayList.add(paramList.get(90));
    localArrayList.add(paramList.get(91));
    localArrayList.add(paramList.get(92));
    localArrayList.add(paramList.get(93));
    localArrayList.add(paramList.get(94));
    localArrayList.add(paramList.get(95));
    localArrayList.add(paramList.get(96));
    PointF localPointF2 = midBetween((PointF)paramList.get(56), (PointF)paramList.get(62));
    PointF localPointF3 = new PointF();
    f1 = distanceFrom((PointF)paramList.get(9), localPointF2);
    localPointF3.x = (((PointF)paramList.get(9)).x + 2.0F * f1 / 8.0F * (float)Math.sin(0.0F));
    localPointF3.y = (((PointF)paramList.get(9)).y - 2.0F * f1 / 8.0F * (float)Math.cos(0.0F));
    localArrayList.add(localPointF3);
    i = 1;
    while (i < 6)
    {
      localPointF3 = new PointF();
      localPointF3.x = (((PointF)paramList.get(9)).x + (i + 2) * f1 / 8.0F * (float)Math.sin(0.0F));
      localPointF3.y = (((PointF)paramList.get(9)).y - (i + 2) * f1 / 8.0F * (float)Math.cos(0.0F));
      localArrayList.add(localPointF3);
      i += 1;
    }
    localArrayList.add(localPointF2);
    localArrayList.add(paramList.get(83));
    localArrayList.add(paramList.get(84));
    localArrayList.add(midBetween((PointF)paramList.get(89), (PointF)paramList.get(84)));
    localArrayList.add(paramList.get(89));
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(d));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    return AlgoUtils.mapPoints(localArrayList, localMatrix);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("inputGrayTextureCoordinate", SwitchFaceUtil.initMaterialFaceTexCoords(faceSwapFacePoint(SwitchFaceUtil.getFullCoords(SwitchFaceUtil.getGrayCoords(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY))), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(138);
  }
  
  public void initParams()
  {
    Bitmap localBitmap = SwitchFaceUtil.getGrayBitmap(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY);
    if (!BitmapUtils.isLegal(localBitmap)) {
      return;
    }
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.mFaceTex, 33986));
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture3", localBitmap, 33987, true));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    addParam(new UniformParam.FloatParam("enableAlphaFromGray", 1.0F));
    addParam(new UniformParam.FloatParam("filterSkin", 0.0F));
  }
  
  PointF midBetween(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  public void renderProcess(Set<Integer> paramSet)
  {
    if ((!paramSet.contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value))) || (this.mFaceLists.size() < 2))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      OnDrawFrameGLSL();
      renderTexture(this.mFaceTex, this.width, this.height);
    }
    for (;;)
    {
      return;
      paramSet = faceSwapFacePoint(SwitchFaceUtil.getFullCoords(VideoMaterial.copyList((List)this.mFaceLists.get(0))));
      VideoMaterial.flipYPoints(paramSet, (int)(this.height * this.mFaceDetScale));
      setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(paramSet, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.texVertices));
      int i = 1;
      while (i < this.mFaceLists.size())
      {
        paramSet = faceSwapFacePoint(SwitchFaceUtil.getFullCoords(VideoMaterial.copyList((List)this.mFaceLists.get(i))));
        VideoMaterial.flipYPoints(paramSet, (int)(this.height * this.mFaceDetScale));
        setPositions(SwitchFaceUtil.initFacePositions(paramSet, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
        setCoordNum(138);
        OnDrawFrameGLSL();
        renderTexture(this.mFaceTex, this.width, this.height);
        i += 1;
      }
    }
  }
  
  public void setFaceParams(List<List<PointF>> paramList, int paramInt)
  {
    this.mFaceLists = paramList;
    this.mFaceTex = paramInt;
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.mFaceTex, 33986));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceCopyFilter
 * JD-Core Version:    0.7.0.1
 */