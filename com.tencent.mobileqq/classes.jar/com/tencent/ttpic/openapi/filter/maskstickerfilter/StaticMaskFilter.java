package com.tencent.ttpic.openapi.filter.maskstickerfilter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.filter.NormalVideoFilter;
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
    initParams();
  }
  
  private void initFabbyPositionAdjust()
  {
    if (this.item.aspectMode == 1)
    {
      setPositions(GlUtil.ORIGIN_POSITION_COORDS);
      return;
    }
    double d1 = this.width;
    double d2 = this.height;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    d2 = this.item.width;
    double d3 = this.item.height;
    Double.isNaN(d2);
    Double.isNaN(d3);
    d2 /= d3;
    if (d1 >= d2)
    {
      d1 = this.width;
      Double.isNaN(d1);
      d1 /= 720.0D;
      d3 = this.width;
      Double.isNaN(d3);
      j = (int)(d3 / d2);
      d2 = j;
      d3 = this.item.position[1];
      Double.isNaN(d2);
      int k = (int)(d2 * d3);
      d2 = this.width;
      d3 = this.item.position[0];
      Double.isNaN(d2);
      i = (int)(d2 * d3);
      j = k - (j - this.height) / 2;
      f1 = i;
      d2 = j;
      d3 = this.item.height;
      Double.isNaN(d3);
      Double.isNaN(d2);
      f2 = (float)(d2 + d3 * d1);
      d2 = i;
      d3 = this.item.width;
      Double.isNaN(d3);
      Double.isNaN(d2);
      setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), j, this.width, this.height));
      return;
    }
    d1 = this.height;
    Double.isNaN(d1);
    d1 = d1 / 720.0D * d2;
    d3 = this.height;
    Double.isNaN(d3);
    int j = (int)(d3 * d2);
    d2 = this.height;
    d3 = this.item.position[1];
    Double.isNaN(d2);
    int i = (int)(d2 * d3);
    d2 = j;
    d3 = this.item.position[0];
    Double.isNaN(d2);
    j = (int)(d2 * d3) - (j - this.width) / 2;
    float f1 = j;
    d2 = i;
    d3 = this.item.height;
    Double.isNaN(d3);
    Double.isNaN(d2);
    float f2 = (float)(d2 + d3 * d1);
    d2 = j;
    d3 = this.item.width;
    Double.isNaN(d3);
    Double.isNaN(d2);
    setPositions(AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), i, this.width, this.height));
  }
  
  private void updateRelativeParams(int paramInt, float paramFloat)
  {
    if (this.relativePivotsPts == null) {
      this.relativePivotsPts = new ArrayList();
    }
    if (this.relativePosPts == null) {
      this.relativePosPts = new ArrayList();
    }
    this.relativePivotsPts.clear();
    this.relativePosPts.clear();
    if ((paramInt != 0) && (paramInt != 180)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    int j = 720;
    int i;
    if (paramInt != 0) {
      i = 720;
    } else {
      i = 960;
    }
    if (paramInt != 0) {
      j = 960;
    }
    float f1;
    if (paramInt != 0) {
      f1 = 0.75F;
    } else {
      f1 = 1.333333F;
    }
    if (paramInt == 0) {
      paramFloat = 1.0F / paramFloat;
    }
    float f2;
    float f3;
    float f4;
    if (paramFloat < f1)
    {
      f1 = j;
      localObject = this.relativePivotsPts;
      f2 = i / 2;
      f3 = j / 2;
      ((List)localObject).add(new PointF(f2, f3));
      localObject = this.relativePivotsPts;
      f4 = i;
      paramFloat = (f4 - paramFloat * f1) / 2.0F;
      ((List)localObject).add(new PointF(paramFloat, 0.0F));
      this.relativePivotsPts.add(new PointF(f2, 0.0F));
      localObject = this.relativePivotsPts;
      f4 -= paramFloat;
      ((List)localObject).add(new PointF(f4, 0.0F));
      this.relativePivotsPts.add(new PointF(paramFloat, f3));
      this.relativePivotsPts.add(new PointF(f4, f3));
      this.relativePivotsPts.add(new PointF(paramFloat, f1));
      this.relativePivotsPts.add(new PointF(f2, f1));
      this.relativePivotsPts.add(new PointF(f4, f1));
    }
    else
    {
      f1 = i;
      f4 = f1 / paramFloat;
      localObject = this.relativePivotsPts;
      paramFloat = i / 2;
      f2 = j / 2;
      ((List)localObject).add(new PointF(paramFloat, f2));
      localObject = this.relativePivotsPts;
      f3 = j;
      f4 = (f3 - f4) / 2.0F;
      ((List)localObject).add(new PointF(0.0F, f4));
      this.relativePivotsPts.add(new PointF(paramFloat, f4));
      this.relativePivotsPts.add(new PointF(f1, f4));
      this.relativePivotsPts.add(new PointF(0.0F, f2));
      this.relativePivotsPts.add(new PointF(f1, f2));
      localObject = this.relativePivotsPts;
      f2 = f3 - f4;
      ((List)localObject).add(new PointF(0.0F, f2));
      this.relativePivotsPts.add(new PointF(paramFloat, f2));
      this.relativePivotsPts.add(new PointF(f1, f2));
    }
    Object localObject = this.relativePivotsPts.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PointF localPointF = (PointF)((Iterator)localObject).next();
      this.relativePosPts.add(new PointF(localPointF.x / i, localPointF.y / j));
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
    if ((this.item != null) && (this.item.position != null) && (this.item.position.length >= 2))
    {
      if (!this.item.orienting) {
        paramInt = 0;
      }
      updateRelativeParams(paramInt, this.ratio);
      int i1 = this.item.width;
      int n = this.item.height;
      int j;
      int i;
      Object localObject1;
      float f1;
      float f2;
      double d2;
      double d1;
      double d3;
      if (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)
      {
        int k = 960;
        int m = 720;
        j = k;
        i = m;
        if (paramInt != 90) {
          if (paramInt == 270)
          {
            j = k;
            i = m;
          }
          else
          {
            j = 720;
            i = 960;
          }
        }
        localObject1 = this.relativePivotsPts;
        List localList = this.relativePosPts;
        Object localObject2 = this.item.scalePivots;
        f1 = 1.0F;
        if ((localObject2 != null) && (this.item.relativeScaleType == 0)) {
          f1 = AlgoUtils.getDistance((PointF)((List)localObject1).get(this.item.scalePivots[0]), (PointF)((List)localObject1).get(this.item.scalePivots[1])) / this.item.scaleFactor;
        }
        f2 = f1 * this.scaleFactor;
        float f3 = this.width / this.height;
        d2 = 1.333333333333333D;
        if ((paramInt != 90) && (paramInt != 270)) {
          d1 = 0.75D;
        } else {
          d1 = 1.333333333333333D;
        }
        float f4 = (float)d1;
        f1 = f2;
        if (this.item.relativeScaleType == 1)
        {
          f1 = f2;
          if (f3 < f4) {
            f1 = f2 * (f3 / f4);
          }
        }
        k = (int)(i1 * f1);
        m = (int)(n * f1);
        localObject2 = new float[2];
        localObject1 = localObject2;
        if (this.item.alignFacePoints != null)
        {
          localObject1 = localObject2;
          if (this.item.alignFacePoints.length >= 1) {
            if (this.item.alignFacePoints.length == 1)
            {
              localObject1 = localObject2;
              if (this.item.alignFacePoints[0] < localList.size())
              {
                localObject1 = new float[2];
                localObject1[0] = ((PointF)localList.get(this.item.alignFacePoints[0])).x;
                localObject1[1] = ((PointF)localList.get(this.item.alignFacePoints[0])).y;
              }
            }
            else
            {
              localObject1 = localObject2;
              if (this.item.alignFacePoints.length == 2)
              {
                localObject1 = localObject2;
                if (this.item.alignFacePoints[0] < localList.size())
                {
                  localObject1 = localObject2;
                  if (this.item.alignFacePoints[1] < localList.size())
                  {
                    localObject1 = new float[2];
                    localObject1[0] = ((((PointF)localList.get(this.item.alignFacePoints[0])).x + ((PointF)localList.get(this.item.alignFacePoints[1])).x) / 2.0F);
                    localObject1[1] = ((((PointF)localList.get(this.item.alignFacePoints[0])).y + ((PointF)localList.get(this.item.alignFacePoints[1])).y) / 2.0F);
                  }
                }
              }
            }
          }
        }
        if ((this.item.anchorPoint != null) && (this.item.anchorPoint.length >= 2))
        {
          this.item.position[0] = (localObject1[0] - this.item.anchorPoint[0] * f1 / j);
          this.item.position[1] = (localObject1[1] - this.item.anchorPoint[1] * f1 / i);
        }
        d3 = f3;
        d1 = d2;
        if (paramInt != 90) {
          if (paramInt == 270) {
            d1 = d2;
          } else {
            d1 = 0.75D;
          }
        }
        if (d3 >= d1)
        {
          f1 = this.width / j;
          if ((paramInt != 90) && (paramInt != 270))
          {
            d1 = this.width;
            Double.isNaN(d1);
            d1 /= 0.75D;
          }
          else
          {
            d1 = this.width;
            Double.isNaN(d1);
            d1 *= 0.75D;
          }
          j = (int)d1;
          d1 = j;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          paramInt = (int)(d1 * d2);
          d1 = this.width;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          j = (j - this.height) / 2;
          f2 = i;
          f3 = paramInt - j;
          localObject1 = AlgoUtils.calPositions(f2, f3 + m * f1, f2 + k * f1, f3, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        else
        {
          f1 = this.height / i;
          if ((paramInt != 90) && (paramInt != 270))
          {
            d1 = this.height;
            Double.isNaN(d1);
            d1 *= 0.75D;
          }
          else
          {
            d1 = this.height;
            Double.isNaN(d1);
            d1 /= 0.75D;
          }
          paramInt = (int)d1;
          d1 = this.height;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          d1 = paramInt;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          f2 = (int)(d1 * d2) - (paramInt - this.width) / 2;
          f3 = i;
          localObject1 = AlgoUtils.calPositions(f2, f3 + m * f1, f2 + k * f1, f3, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        if (this.item.angle > 0.0F)
        {
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle));
          addParam(new UniformParam.IntParam("texNeedTransform", 1));
        }
      }
      else
      {
        d1 = this.width;
        d2 = this.height;
        Double.isNaN(d1);
        Double.isNaN(d2);
        if (d1 / d2 >= 0.75D)
        {
          d1 = this.width;
          Double.isNaN(d1);
          d1 /= 720.0D;
          d2 = this.width;
          Double.isNaN(d2);
          i = (int)(d2 / 0.75D);
          d2 = i;
          d3 = this.item.position[1];
          Double.isNaN(d2);
          j = (int)(d2 * d3);
          d2 = this.width;
          d3 = this.item.position[0];
          Double.isNaN(d2);
          paramInt = (int)(d2 * d3);
          i = j - (i - this.height) / 2;
          f1 = paramInt;
          d2 = i;
          d3 = n;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f2 = (float)(d2 + d3 * d1);
          d2 = paramInt;
          d3 = i1;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localObject1 = AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), i, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        else
        {
          d1 = this.height;
          Double.isNaN(d1);
          d1 /= 960.0D;
          d2 = this.height;
          Double.isNaN(d2);
          i = (int)(d2 * 0.75D);
          d2 = this.height;
          d3 = this.item.position[1];
          Double.isNaN(d2);
          paramInt = (int)(d2 * d3);
          d2 = i;
          d3 = this.item.position[0];
          Double.isNaN(d2);
          i = (int)(d2 * d3) - (i - this.width) / 2;
          f1 = i;
          d2 = paramInt;
          d3 = n;
          Double.isNaN(d3);
          Double.isNaN(d2);
          f2 = (float)(d2 + d3 * d1);
          d2 = i;
          d3 = i1;
          Double.isNaN(d3);
          Double.isNaN(d2);
          localObject1 = AlgoUtils.calPositions(f1, f2, (float)(d2 + d3 * d1), paramInt, this.width, this.height);
          if (this.item.scaleDirection == 0) {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor));
          } else {
            setPositions(AlgoUtils.adjustPosition((float[])localObject1, this.audioScaleFactor, this.item.anchorPointAudio, this.item.scaleDirection));
          }
        }
        if (this.item.angle > 0.0F)
        {
          d1 = this.height;
          d2 = this.item.position[1];
          Double.isNaN(d1);
          d3 = this.item.height * 0.5F;
          Double.isNaN(d3);
          paramInt = (int)(d1 * (d2 - 0.5D) + d3);
          d1 = this.width;
          d2 = this.item.position[0];
          Double.isNaN(d1);
          d3 = this.item.width * 0.5F;
          Double.isNaN(d3);
          addParam(new UniformParam.Float2fParam("texAnchor", (int)(d1 * (d2 - 0.5D) + d3), paramInt));
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle));
          addParam(new UniformParam.IntParam("texNeedTransform", 1));
        }
      }
      return;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  public void initPositions()
  {
    if ((this.item != null) && (this.item.position != null) && (this.item.position.length >= 2))
    {
      double d1 = this.width;
      Double.isNaN(d1);
      d1 /= 720.0D;
      double d2 = this.height;
      double d3 = this.item.position[1];
      Double.isNaN(d2);
      int i = (int)(d2 * (1.0D - d3));
      d2 = this.width;
      d3 = this.item.position[0];
      Double.isNaN(d2);
      int j = (int)(d2 * d3);
      float f1 = j;
      float f2 = i;
      d2 = this.item.width;
      Double.isNaN(d2);
      float f3 = j + (int)(d2 * d1);
      d2 = i;
      d3 = this.item.height;
      Double.isNaN(d3);
      Double.isNaN(d2);
      setPositions(AlgoUtils.calPositions(f1, f2, f3, (int)(d2 - d3 * d1), this.width, this.height));
      this.initialized = true;
      return;
    }
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  public void setPostScale(float paramFloat)
  {
    this.scaleFactor = paramFloat;
  }
  
  public void setRatio(float paramFloat)
  {
    this.ratio = paramFloat;
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
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
    if ((this.width != paramInt1) || (this.height != paramInt2)) {
      if (this.item.isFabbyMvItem) {
        initFabbyPositionAdjust();
      } else {
        initPositionAdjusted(0);
      }
    }
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.maskstickerfilter.StaticMaskFilter
 * JD-Core Version:    0.7.0.1
 */