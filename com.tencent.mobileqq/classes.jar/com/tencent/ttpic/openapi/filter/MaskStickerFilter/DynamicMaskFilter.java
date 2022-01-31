package com.tencent.ttpic.openapi.filter.MaskStickerFilter;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.List;

public class DynamicMaskFilter
  extends NormalVideoFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\nuniform vec2 canvasSize;\nuniform float alpha;\nuniform int maskType;\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 resultFore = texColor.rgb;\n     if (maskType == 1) {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     } else if (maskType == 2) {\n         resultFore.rgb = max(canvasColor.rgb, texColor.rgb);\n     } else {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     }\n     texColor.a = resultFore.r;\n     vec4 resultColor = vec4(resultFore, texColor.a);\n     return resultColor;\n }\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate / oneOverZ);\n    texColor.a = texColor.a * alpha;\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n";
  private static final int LENTH_POINTS_ANGLE = 4;
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\nconst float PI = 3.14159;\nuniform mat4 u_MVPMatrix;\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n    return m;\n}\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos = texMatRotateXY * framePos;\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        framePos = texMatTranslateAfter * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n        framePos = u_MVPMatrix * framePos;\n    }\n    gl_Position = framePos / framePos.w;\n    canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n    oneOverZ = 1.0 / framePos.w;\n    textureCoordinate = inputTextureCoordinate / framePos.w;\n}\n";
  private String TAG = DynamicMaskFilter.class.getSimpleName();
  private Point canvasCenter;
  private float[] mPositions = new float[8];
  private float[] mTexCoords = new float[8];
  private int maskType = 1;
  
  public DynamicMaskFilter(StickerItem paramStickerItem, String paramString, int paramInt)
  {
    super(paramStickerItem, paramString, "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\nconst float PI = 3.14159;\nuniform mat4 u_MVPMatrix;\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n    return m;\n}\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos = texMatRotateXY * framePos;\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        framePos = texMatTranslateAfter * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n        framePos = u_MVPMatrix * framePos;\n    }\n    gl_Position = framePos / framePos.w;\n    canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n    oneOverZ = 1.0 / framePos.w;\n    textureCoordinate = inputTextureCoordinate / framePos.w;\n}\n", "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\nuniform vec2 canvasSize;\nuniform float alpha;\nuniform int maskType;\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 resultFore = texColor.rgb;\n     if (maskType == 1) {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     } else if (maskType == 2) {\n         resultFore.rgb = max(canvasColor.rgb, texColor.rgb);\n     } else {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     }\n     texColor.a = resultFore.r;\n     vec4 resultColor = vec4(resultFore, texColor.a);\n     return resultColor;\n }\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate / oneOverZ);\n    texColor.a = texColor.a * alpha;\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n");
    this.maskType = paramInt;
  }
  
  public static boolean isValidItem(StickerItem paramStickerItem)
  {
    if (paramStickerItem == null) {}
    while ((paramStickerItem.alignFacePoints == null) || (paramStickerItem.alignFacePoints.length <= 0) || (paramStickerItem.anchorPoint == null) || (paramStickerItem.anchorPoint.length < 2) || (paramStickerItem.scalePivots == null) || (paramStickerItem.scalePivots.length < 2)) {
      return false;
    }
    return true;
  }
  
  private boolean isValidPoint(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.x > this.width) || (paramPoint.y < 0) || (paramPoint.y > this.height)) {
      return false;
    }
    return true;
  }
  
  public void initParams()
  {
    super.initParams();
    addParam(new UniformParam.IntParam("maskType", this.maskType));
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("texScale", 1.0F));
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean isBodyNeeded()
  {
    return this.item.type == VideoFilterFactory.POSITION_TYPE.BODY.type;
  }
  
  public void updatePositions(List<PointF> paramList)
  {
    super.updatePositions(paramList);
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    int i;
    label70:
    PointF localPointF2;
    double d1;
    double d2;
    if (this.item.alignFacePoints.length == 1)
    {
      i = this.item.alignFacePoints[0];
      localPointF2 = (PointF)paramList.get(i);
      PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      localPointF3.x = ((float)(localPointF3.x / this.mFaceDetScale));
      localPointF3.y = ((float)(localPointF3.y / this.mFaceDetScale));
      float f1 = localPointF3.x - this.item.anchorPoint[0];
      float f2 = localPointF3.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(f1, this.item.height + f2, f1 + f3, f2, this.width, this.height), (float)this.triggerCtrlItem.getAudioScaleFactor()));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF3.x - this.canvasCenter.x, localPointF3.y - this.canvasCenter.y));
      localPointF3 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF3.x = ((float)(localPointF3.x / this.mFaceDetScale));
      localPointF3.y = ((float)(localPointF3.y / this.mFaceDetScale));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x / this.mFaceDetScale));
      paramList.y = ((float)(paramList.y / this.mFaceDetScale));
      d1 = Math.pow(localPointF3.x - paramList.x, 2.0D);
      d1 = Math.sqrt(Math.pow(localPointF3.y - paramList.y, 2.0D) + d1) / this.item.scaleFactor;
      if (this.item.maxScaledWidth == 0) {
        break label682;
      }
      d2 = this.item.maxScaledWidth / this.item.width;
      if (d1 <= d2) {
        break label682;
      }
      d1 = d2;
    }
    label682:
    for (;;)
    {
      d2 = d1;
      if (this.item.minScaledWidth != 0)
      {
        double d3 = this.item.minScaledWidth / this.item.width;
        d2 = d1;
        if (d1 < d3) {
          d2 = d3;
        }
      }
      addParam(new UniformParam.FloatParam("texScale", (float)d2));
      if (this.item.alignFacePoints.length <= 1) {
        break;
      }
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, (float)Math.atan2(localPointF1.y - localPointF2.y, localPointF1.x - localPointF2.x) - this.item.angle));
      return;
      i = this.item.alignFacePoints[1];
      break label70;
    }
  }
  
  public void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    int i;
    double d1;
    double d2;
    if (this.item.alignFacePoints.length == 1)
    {
      i = this.item.alignFacePoints[0];
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      localPointF1.x = ((float)(localPointF1.x / this.mFaceDetScale));
      localPointF1.y = ((float)(localPointF1.y / this.mFaceDetScale));
      paramFloat = localPointF1.x - this.item.anchorPoint[0];
      float f1 = localPointF1.y - this.item.anchorPoint[1];
      float f2 = this.item.width;
      setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(paramFloat, this.item.height + f1, paramFloat + f2, f1, this.width, this.height), (float)this.triggerCtrlItem.getAudioScaleFactor()));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF1.x - this.canvasCenter.x, localPointF1.y - this.canvasCenter.y));
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF1.x = ((float)(localPointF1.x / this.mFaceDetScale));
      localPointF1.y = ((float)(localPointF1.y / this.mFaceDetScale));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x / this.mFaceDetScale));
      paramList.y = ((float)(paramList.y / this.mFaceDetScale));
      d1 = Math.pow(localPointF1.x - paramList.x, 2.0D);
      d1 = Math.sqrt(Math.pow(localPointF1.y - paramList.y, 2.0D) + d1) / this.item.scaleFactor;
      if (this.item.maxScaledWidth == 0) {
        break label699;
      }
      d2 = this.item.maxScaledWidth / this.item.width;
      if (d1 <= d2) {
        break label699;
      }
      d1 = d2;
    }
    label699:
    for (;;)
    {
      d2 = d1;
      if (this.item.minScaledWidth != 0)
      {
        double d3 = this.item.minScaledWidth / this.item.width;
        d2 = d1;
        if (d1 < d3) {
          d2 = d3;
        }
      }
      addParam(new UniformParam.FloatParam("texScale", (float)d2));
      if (this.item.support3D == 1)
      {
        addParam(new UniformParam.Float3fParam("texRotate", paramArrayOfFloat[0], paramArrayOfFloat[1], -paramArrayOfFloat[2] - this.item.angle));
        return;
        i = this.item.alignFacePoints[1];
        break;
      }
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, -paramArrayOfFloat[2] - this.item.angle));
      return;
    }
  }
  
  public void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt)
  {
    super.updatePositionsForMultiAnchor(paramList, paramInt);
    if ((CollectionUtils.isEmpty(paramList)) || (!isValidItem(this.item)))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1;
    if (paramInt == 4)
    {
      paramInt = 0;
      while (paramInt < 4)
      {
        int i = this.item.anchorPoint[(paramInt * 2)];
        int j = this.item.anchorPoint[(paramInt * 2 + 1)];
        this.mTexCoords[(paramInt * 2)] = (i / this.item.width);
        this.mTexCoords[(paramInt * 2 + 1)] = (j / this.item.height);
        paramInt += 1;
      }
      paramInt = 0;
      while (paramInt < 4)
      {
        localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[paramInt]);
        this.mPositions[(paramInt * 2)] = ((float)(localPointF1.x / (this.width * this.mFaceDetScale) * 2.0D - 1.0D));
        this.mPositions[(paramInt * 2 + 1)] = ((float)(localPointF1.y / (this.height * this.mFaceDetScale) * 2.0D - 1.0D));
        paramInt += 1;
      }
      setPositions(this.mPositions);
      setTexCords(this.mTexCoords);
    }
    for (;;)
    {
      addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
      addParam(new UniformParam.FloatParam("texScale", 1.0F));
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
      return;
      if (paramInt == 2)
      {
        localPointF1 = new PointF(this.item.anchorPoint[0], this.item.anchorPoint[1]);
        Object localObject = new PointF(this.item.anchorPoint[2], this.item.anchorPoint[3]);
        PointF localPointF2 = (PointF)paramList.get(this.item.alignFacePoints[0]);
        PointF localPointF3 = (PointF)paramList.get(this.item.alignFacePoints[1]);
        paramList = new PointF((float)(localPointF2.x / this.mFaceDetScale), (float)(localPointF2.y / this.mFaceDetScale));
        localPointF2 = new PointF((float)(localPointF3.x / this.mFaceDetScale), (float)(localPointF3.y / this.mFaceDetScale));
        float f1 = AlgoUtils.getDistance(paramList, localPointF2) / AlgoUtils.getDistance(localPointF1, (PointF)localObject);
        this.mPositions[0] = 0.0F;
        this.mPositions[1] = 0.0F;
        this.mPositions[2] = (this.item.width * f1);
        this.mPositions[3] = 0.0F;
        this.mPositions[4] = (this.item.width * f1);
        this.mPositions[5] = (this.item.height * f1);
        this.mPositions[6] = 0.0F;
        this.mPositions[7] = (this.item.height * f1);
        this.mTexCoords[0] = 0.0F;
        this.mTexCoords[1] = 0.0F;
        this.mTexCoords[2] = 1.0F;
        this.mTexCoords[3] = 0.0F;
        this.mTexCoords[4] = 1.0F;
        this.mTexCoords[5] = 1.0F;
        this.mTexCoords[6] = 0.0F;
        this.mTexCoords[7] = 1.0F;
        float f2 = (float)Math.atan2(((PointF)localObject).y - localPointF1.y, ((PointF)localObject).x - localPointF1.x);
        float f3 = (float)Math.atan2(localPointF2.y - paramList.y, localPointF2.x - paramList.x);
        localObject = new Matrix();
        ((Matrix)localObject).postTranslate(-localPointF1.x * f1, f1 * -localPointF1.y);
        ((Matrix)localObject).postRotate((float)((f3 - f2) * 180.0F / 3.141592653589793D));
        ((Matrix)localObject).postTranslate(paramList.x, paramList.y);
        ((Matrix)localObject).mapPoints(this.mPositions);
        paramInt = 0;
        while (paramInt < 4)
        {
          this.mPositions[(paramInt * 2)] = (this.mPositions[(paramInt * 2)] / this.width * 2.0F - 1.0F);
          this.mPositions[(paramInt * 2 + 1)] = (this.mPositions[(paramInt * 2 + 1)] / this.height * 2.0F - 1.0F);
          paramInt += 1;
        }
        setPositions(this.mPositions);
        setTexCords(this.mTexCoords);
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.MaskStickerFilter.DynamicMaskFilter
 * JD-Core Version:    0.7.0.1
 */