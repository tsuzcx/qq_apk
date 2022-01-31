package com.tencent.ttpic.openapi.filter.MaskStickerFilter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaticMaskFilter
  extends NormalVideoFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\nuniform vec2 canvasSize;\nuniform float alpha;\nuniform int maskType;\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 resultFore = texColor.rgb;\n     if (maskType == 1) {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     } else if (maskType == 2) {\n         resultFore.rgb = max(canvasColor.rgb, texColor.rgb);\n     } else {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     }\n     texColor.a = resultFore.r;\n     vec4 resultColor = vec4(resultFore, texColor.a);\n     return resultColor;\n }\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate / oneOverZ);\n    texColor.a = texColor.a * alpha;\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\nconst float PI = 3.14159;\nuniform mat4 u_MVPMatrix;\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n    return m;\n}\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos = texMatRotateXY * framePos;\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        framePos = texMatTranslateAfter * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n        framePos = u_MVPMatrix * framePos;\n    }\n    gl_Position = framePos / framePos.w;\n    canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n    oneOverZ = 1.0 / framePos.w;\n    textureCoordinate = inputTextureCoordinate / framePos.w;\n}\n";
  private boolean initialized = false;
  private int maskType = 1;
  private float ratio = 0.75F;
  private List<PointF> relativePivotsPts;
  private List<PointF> relativePosPts;
  private float scaleFactor = 1.0F;
  
  public StaticMaskFilter(StickerItem paramStickerItem, String paramString, int paramInt)
  {
    super(paramStickerItem, paramString, "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\nconst float PI = 3.14159;\nuniform mat4 u_MVPMatrix;\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n    return m;\n}\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos = texMatRotateXY * framePos;\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n        framePos = texMatTranslateAfter * framePos;\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n        framePos = u_MVPMatrix * framePos;\n    }\n    gl_Position = framePos / framePos.w;\n    canvasCoordinate = vec2(framePos.x / framePos.w * 0.5 + 0.5, framePos.y / framePos.w * 0.5 + 0.5);\n    oneOverZ = 1.0 / framePos.w;\n    textureCoordinate = inputTextureCoordinate / framePos.w;\n}\n", "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\nuniform vec2 canvasSize;\nuniform float alpha;\nuniform int maskType;\nvec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 resultFore = texColor.rgb;\n     if (maskType == 1) {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     } else if (maskType == 2) {\n         resultFore.rgb = max(canvasColor.rgb, texColor.rgb);\n     } else {\n         resultFore.rgb = min(canvasColor.rgb, texColor.rgb);\n     }\n     texColor.a = resultFore.r;\n     vec4 resultColor = vec4(resultFore, texColor.a);\n     return resultColor;\n }\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate / oneOverZ);\n    texColor.a = texColor.a * alpha;\n    gl_FragColor = blendColor(texColor, canvasColor);\n}\n");
    this.maskType = paramInt;
  }
  
  private void initFabbyPositionAdjust()
  {
    if (this.item.aspectMode == 1)
    {
      setPositions(GlUtil.ORIGIN_POSITION_COORDS);
      return;
    }
    double d2 = this.width / this.height;
    double d1 = this.item.width / this.item.height;
    if (d2 >= d1)
    {
      d2 = this.width / 720.0D;
      j = (int)(this.width / d1);
      int k = (int)(j * this.item.position[1]);
      i = (int)(this.width * this.item.position[0]);
      j = k - (j - this.height) / 2;
      f1 = i;
      f2 = (float)(j + this.item.height * d2);
      d1 = i;
      setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 * this.item.width + d1), j, this.width, this.height));
      return;
    }
    d2 = this.height / 720.0D * d1;
    int j = (int)(this.height * d1);
    int i = (int)(this.height * this.item.position[1]);
    j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
    float f1 = j;
    float f2 = (float)(i + this.item.height * d2);
    d1 = j;
    setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 * this.item.width + d1), i, this.width, this.height));
  }
  
  private void updateRelativeParams(int paramInt, float paramFloat)
  {
    int j = 720;
    if (this.relativePivotsPts == null) {
      this.relativePivotsPts = new ArrayList();
    }
    if (this.relativePosPts == null) {
      this.relativePosPts = new ArrayList();
    }
    this.relativePivotsPts.clear();
    this.relativePosPts.clear();
    int i;
    label81:
    float f;
    if ((paramInt == 0) || (paramInt == 180))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label438;
      }
      i = 720;
      if (paramInt != 0) {
        j = 960;
      }
      if (paramInt == 0) {
        break label446;
      }
      f = 0.75F;
      label97:
      if (paramInt == 0) {
        break label452;
      }
      label101:
      if (paramFloat >= f) {
        break label459;
      }
      paramFloat = j * paramFloat;
      this.relativePivotsPts.add(new PointF(i / 2, j / 2));
      this.relativePivotsPts.add(new PointF((i - paramFloat) / 2.0F, 0.0F));
      this.relativePivotsPts.add(new PointF(i / 2, 0.0F));
      this.relativePivotsPts.add(new PointF(i - (i - paramFloat) / 2.0F, 0.0F));
      this.relativePivotsPts.add(new PointF((i - paramFloat) / 2.0F, j / 2));
      this.relativePivotsPts.add(new PointF(i - (i - paramFloat) / 2.0F, j / 2));
      this.relativePivotsPts.add(new PointF((i - paramFloat) / 2.0F, j));
      this.relativePivotsPts.add(new PointF(i / 2, j));
      this.relativePivotsPts.add(new PointF(i - (i - paramFloat) / 2.0F, j));
    }
    for (;;)
    {
      Iterator localIterator = this.relativePivotsPts.iterator();
      while (localIterator.hasNext())
      {
        PointF localPointF = (PointF)localIterator.next();
        this.relativePosPts.add(new PointF(localPointF.x / i, localPointF.y / j));
      }
      paramInt = 0;
      break;
      label438:
      i = 960;
      break label81;
      label446:
      f = 1.333333F;
      break label97;
      label452:
      paramFloat = 1.0F / paramFloat;
      break label101;
      label459:
      paramFloat = i / paramFloat;
      this.relativePivotsPts.add(new PointF(i / 2, j / 2));
      this.relativePivotsPts.add(new PointF(0.0F, (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i / 2, (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i, (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(0.0F, j / 2));
      this.relativePivotsPts.add(new PointF(i, j / 2));
      this.relativePivotsPts.add(new PointF(0.0F, j - (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i / 2, j - (j - paramFloat) / 2.0F));
      this.relativePivotsPts.add(new PointF(i, j - (j - paramFloat) / 2.0F));
    }
  }
  
  public void clearTextureParam()
  {
    super.clearTextureParam();
    this.initialized = false;
  }
  
  public int getMaskType()
  {
    return this.maskType;
  }
  
  public void initParams()
  {
    super.initParams();
    addParam(new UniformParam.IntParam("maskType", this.maskType));
    addParam(new UniformParam.IntParam("texNeedTransform", -1));
    updateRelativeParams(0, this.ratio);
  }
  
  public void initPositionAdjusted(int paramInt)
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      return;
    }
    if (!this.item.orienting) {
      paramInt = 0;
    }
    updateRelativeParams(paramInt, this.ratio);
    int m = this.item.width;
    int k = this.item.height;
    int i;
    if (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)
    {
      if ((paramInt != 90) && (paramInt != 270)) {
        break label1720;
      }
      i = 720;
    }
    for (int j = 960;; j = 720)
    {
      Object localObject = this.relativePivotsPts;
      List localList = this.relativePosPts;
      float f1;
      float f2;
      double d1;
      label180:
      float f3;
      if (this.item.scalePivots == null)
      {
        f1 = 1.0F;
        f1 *= this.scaleFactor;
        f2 = this.width / this.height;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label752;
        }
        d1 = 1.333333333333333D;
        f3 = (float)d1;
        if ((this.item.relativeScaleType != 1) || (f2 >= f3)) {
          break label1717;
        }
        f1 = f2 / f3 * f1;
      }
      label948:
      label1204:
      label1717:
      for (;;)
      {
        m = (int)(m * f1);
        k = (int)(k * f1);
        float[] arrayOfFloat = new float[2];
        localObject = arrayOfFloat;
        if (this.item.alignFacePoints != null)
        {
          localObject = arrayOfFloat;
          if (this.item.alignFacePoints.length >= 1)
          {
            if (this.item.alignFacePoints.length != 1) {
              break label759;
            }
            localObject = arrayOfFloat;
            if (this.item.alignFacePoints[0] < localList.size()) {
              localObject = new float[] { ((PointF)localList.get(this.item.alignFacePoints[0])).x, ((PointF)localList.get(this.item.alignFacePoints[0])).y };
            }
          }
        }
        label356:
        if ((this.item.anchorPoint != null) && (this.item.anchorPoint.length >= 2))
        {
          this.item.position[0] = (localObject[0] - this.item.anchorPoint[0] * f1 / j);
          this.item.position[1] = (localObject[1] - f1 * this.item.anchorPoint[1] / i);
        }
        double d2 = f2;
        label464:
        label506:
        float f4;
        float f5;
        if ((paramInt == 90) || (paramInt == 270))
        {
          d1 = 1.333333333333333D;
          if (d2 < d1) {
            break label997;
          }
          f1 = this.width / j;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label948;
          }
          paramInt = (int)(this.width * 0.75D);
          j = (int)(paramInt * this.item.position[1]);
          i = (int)(this.width * this.item.position[0]);
          paramInt = j - (paramInt - this.height) / 2;
          f2 = i;
          f3 = paramInt;
          f4 = k;
          f5 = i;
          localObject = AlgoUtils.calPositions(f2, f3 + f4 * f1, f1 * m + f5, paramInt, this.width, this.height);
          if (this.item.scaleDirection != 0) {
            break label962;
          }
          setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor()));
        }
        for (;;)
        {
          if (this.item.angle <= 0.0F) {
            break label1204;
          }
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle));
          addParam(new UniformParam.IntParam("texNeedTransform", 1));
          return;
          if (this.item.relativeScaleType == 0)
          {
            f1 = AlgoUtils.getDistance((PointF)((List)localObject).get(this.item.scalePivots[0]), (PointF)((List)localObject).get(this.item.scalePivots[1])) / this.item.scaleFactor;
            break;
          }
          f1 = 1.0F;
          break;
          label752:
          d1 = 0.75D;
          break label180;
          label759:
          localObject = arrayOfFloat;
          if (this.item.alignFacePoints.length != 2) {
            break label356;
          }
          localObject = arrayOfFloat;
          if (this.item.alignFacePoints[0] >= localList.size()) {
            break label356;
          }
          localObject = arrayOfFloat;
          if (this.item.alignFacePoints[1] >= localList.size()) {
            break label356;
          }
          f3 = ((PointF)localList.get(this.item.alignFacePoints[0])).x;
          f3 = (((PointF)localList.get(this.item.alignFacePoints[1])).x + f3) / 2.0F;
          f4 = ((PointF)localList.get(this.item.alignFacePoints[0])).y;
          localObject = new float[] { f3, (((PointF)localList.get(this.item.alignFacePoints[1])).y + f4) / 2.0F };
          break label356;
          d1 = 0.75D;
          break label464;
          paramInt = (int)(this.width / 0.75D);
          break label506;
          label962:
          setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection));
          continue;
          label997:
          f1 = this.height / i;
          if ((paramInt == 90) || (paramInt == 270)) {}
          for (paramInt = (int)(this.height / 0.75D);; paramInt = (int)(this.height * 0.75D))
          {
            i = (int)(this.height * this.item.position[1]);
            paramInt = (int)(paramInt * this.item.position[0]) - (paramInt - this.width) / 2;
            f2 = paramInt;
            f3 = i;
            f4 = k;
            f5 = paramInt;
            localObject = AlgoUtils.calPositions(f2, f3 + f4 * f1, f1 * m + f5, i, this.width, this.height);
            if (this.item.scaleDirection != 0) {
              break label1171;
            }
            setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor()));
            break;
          }
          setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection));
        }
        break;
        if (this.width / this.height >= 0.75D)
        {
          d1 = this.width / 720.0D;
          i = (int)(this.width / 0.75D);
          j = (int)(i * this.item.position[1]);
          paramInt = (int)(this.width * this.item.position[0]);
          i = j - (i - this.height) / 2;
          f1 = paramInt;
          f2 = (float)(i + k * d1);
          d2 = paramInt;
          localObject = AlgoUtils.calPositions(f1, f2, (float)(d1 * m + d2), i, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor()));
          }
        }
        while (this.item.angle > 0.0F)
        {
          paramInt = (int)(this.height * (this.item.position[1] - 0.5D) + this.item.height * 0.5F);
          addParam(new UniformParam.Float2fParam("texAnchor", (int)(this.width * (this.item.position[0] - 0.5D) + this.item.width * 0.5F), paramInt));
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle));
          addParam(new UniformParam.IntParam("texNeedTransform", 1));
          return;
          setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection));
          continue;
          d1 = this.height / 960.0D;
          i = (int)(this.height * 0.75D);
          paramInt = (int)(this.height * this.item.position[1]);
          i = (int)(i * this.item.position[0]) - (i - this.width) / 2;
          f1 = i;
          f2 = (float)(paramInt + k * d1);
          d2 = i;
          localObject = AlgoUtils.calPositions(f1, f2, (float)(d1 * m + d2), paramInt, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor()));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject, (float)this.triggerCtrlItem.getAudioScaleFactor(), this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        break;
      }
      label1171:
      label1720:
      i = 960;
    }
  }
  
  public void initPositions()
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(GlUtil.EMPTY_POSITIONS);
      return;
    }
    double d = this.width / 720.0D;
    int i = (int)(this.height * (1.0D - this.item.position[1]));
    int j = (int)(this.width * this.item.position[0]);
    setPositions(AlgoUtils.calPositions(j, i, j + (int)(this.item.width * d), (int)(i - d * this.item.height), this.width, this.height));
    this.initialized = true;
  }
  
  public void resetFabbyProgress()
  {
    this.triggered = false;
  }
  
  public void setPostScale(float paramFloat)
  {
    this.scaleFactor = paramFloat;
  }
  
  public void setRatio(float paramFloat)
  {
    this.ratio = paramFloat;
  }
  
  public void updateFabbyProgress(long paramLong)
  {
    if (!this.triggered) {
      this.triggerCtrlItem.setFrameStartTime(paramLong);
    }
    this.triggered = true;
    updateTextureParam((int)((paramLong - this.triggerCtrlItem.getFrameStartTime()) / Math.max(this.item.frameDuration, 1.0D)) % Math.max(this.item.frames, 1), paramLong);
    initFabbyPositionAdjust();
  }
  
  public void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if (this.initialized) {
      return;
    }
    if (this.item.isFabbyMvItem)
    {
      initFabbyPositionAdjust();
      return;
    }
    initPositionAdjusted((int)paramFloat);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if ((this.width != paramInt1) || (this.height != paramInt2))
    {
      if (!this.item.isFabbyMvItem) {
        break label38;
      }
      initFabbyPositionAdjust();
    }
    for (;;)
    {
      super.updateVideoSize(paramInt1, paramInt2, paramDouble);
      return;
      label38:
      initPositionAdjusted(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.MaskStickerFilter.StaticMaskFilter
 * JD-Core Version:    0.7.0.1
 */