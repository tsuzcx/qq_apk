package com.tencent.ttpic.openapi.filter.maskstickerfilter;

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
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
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
    initParams();
  }
  
  private boolean checkArrayLength(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramInt == 0) {
        return false;
      }
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i] >= paramInt) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isValidItem(StickerItem paramStickerItem)
  {
    boolean bool2 = false;
    if (paramStickerItem == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramStickerItem.alignFacePoints != null)
    {
      bool1 = bool2;
      if (paramStickerItem.alignFacePoints.length > 0)
      {
        bool1 = bool2;
        if (paramStickerItem.anchorPoint != null)
        {
          bool1 = bool2;
          if (paramStickerItem.anchorPoint.length >= 2)
          {
            bool1 = bool2;
            if (paramStickerItem.scalePivots != null)
            {
              bool1 = bool2;
              if (paramStickerItem.scalePivots.length >= 2) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean isValidPoint(Point paramPoint)
  {
    boolean bool2 = false;
    if (paramPoint == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramPoint.x >= 0)
    {
      bool1 = bool2;
      if (paramPoint.x <= this.width)
      {
        bool1 = bool2;
        if (paramPoint.y >= 0)
        {
          bool1 = bool2;
          if (paramPoint.y <= this.height) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int getMaskType()
  {
    return this.maskType;
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
  
  protected void updateCatFacePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    super.updatePositions(paramList);
    if ((!CollectionUtils.isEmpty(paramList)) && (isValidItem(this.item)))
    {
      PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      int i;
      if (this.item.alignFacePoints.length == 1) {
        i = this.item.alignFacePoints[0];
      } else {
        i = this.item.alignFacePoints[1];
      }
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = localPointF1.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(f1, f2 + this.item.height, f1 + f3, f2, this.width, this.height), this.audioScaleFactor));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF1.x - this.canvasCenter.x, localPointF1.y - this.canvasCenter.y));
      if ((paramList.size() > this.item.scalePivots[0]) && (paramList.size() > this.item.scalePivots[1]))
      {
        localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
        paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
        double d1 = Math.sqrt(Math.pow(localPointF1.x - paramList.x, 2.0D) + Math.pow(localPointF1.y - paramList.y, 2.0D));
        double d2 = this.item.scaleFactor;
        Double.isNaN(d2);
        d2 = d1 / d2;
        d1 = d2;
        double d3;
        if (this.item.maxScaledWidth != 0)
        {
          d3 = this.item.maxScaledWidth / this.item.width;
          d1 = d2;
          if (d2 > d3) {
            d1 = d3;
          }
        }
        d2 = d1;
        if (this.item.minScaledWidth != 0)
        {
          d3 = this.item.minScaledWidth / this.item.width;
          d2 = d1;
          if (d1 < d3) {
            d2 = d3;
          }
        }
        addParam(new UniformParam.FloatParam("texScale", (float)d2));
        d1 = paramArrayOfFloat[0];
        Double.isNaN(d1);
        addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, (float)(d1 + 3.141592653589793D + Math.toRadians(paramFloat))));
      }
      return;
    }
    clearTextureParam();
  }
  
  protected void updatePositions(List<PointF> paramList)
  {
    super.updatePositions(paramList);
    if ((!CollectionUtils.isEmpty(paramList)) && (isValidItem(this.item)))
    {
      double d2 = 0.0D;
      double d1 = d2;
      if (VideoMaterial.isGestureItem(this.item))
      {
        d1 = d2;
        if (paramList.size() > 22)
        {
          localPointF1 = (PointF)paramList.get(14);
          localPointF2 = (PointF)paramList.get(22);
          d1 = d2;
          if (localPointF1 != null)
          {
            d1 = d2;
            if (localPointF2 != null)
            {
              f1 = localPointF1.x;
              f2 = localPointF1.y;
              f3 = localPointF2.x;
              float f4 = localPointF2.y;
              if (f1 < f3) {
                d1 = Math.atan2(f4 - f2, f3 - f1);
              } else {
                d1 = Math.atan2(f2 - f4, f1 - f3);
              }
            }
          }
        }
      }
      if (!checkArrayLength(this.item.alignFacePoints, paramList.size())) {
        return;
      }
      PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      int i;
      if (this.item.alignFacePoints.length == 1) {
        i = this.item.alignFacePoints[0];
      } else {
        i = this.item.alignFacePoints[1];
      }
      PointF localPointF2 = (PointF)paramList.get(i);
      PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = localPointF3.x - this.item.anchorPoint[0];
      float f2 = localPointF3.y - this.item.anchorPoint[1];
      float f3 = this.item.width;
      setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(f1, f2 + this.item.height, f1 + f3, f2, this.width, this.height), this.audioScaleFactor));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF3.x - this.canvasCenter.x, localPointF3.y - this.canvasCenter.y));
      if ((paramList.size() > this.item.scalePivots[0]) && (paramList.size() > this.item.scalePivots[1]))
      {
        localPointF3 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
        paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
        d2 = Math.sqrt(Math.pow(localPointF3.x - paramList.x, 2.0D) + Math.pow(localPointF3.y - paramList.y, 2.0D));
        double d3 = this.item.scaleFactor;
        Double.isNaN(d3);
        d3 = d2 / d3;
        d2 = d3;
        double d4;
        if (this.item.maxScaledWidth != 0)
        {
          d4 = this.item.maxScaledWidth / this.item.width;
          d2 = d3;
          if (d3 > d4) {
            d2 = d4;
          }
        }
        d3 = d2;
        if (this.item.minScaledWidth != 0)
        {
          d4 = this.item.minScaledWidth / this.item.width;
          d3 = d2;
          if (d2 < d4) {
            d3 = d4;
          }
        }
        addParam(new UniformParam.FloatParam("texScale", (float)d3));
        if (this.item.alignFacePoints.length > 1)
        {
          f2 = (float)Math.atan2(localPointF1.y - localPointF2.y, localPointF1.x - localPointF2.x);
          f3 = this.item.angle;
          if ((VideoMaterial.isGestureItem(this.item)) && (this.item.needHandRotation == 1)) {
            f1 = 0.0F;
          } else {
            f1 = (float)d1;
          }
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, f2 - f3 + f1));
          return;
        }
        if ((VideoMaterial.isGestureItem(this.item)) && (this.item.needHandRotation == 1)) {
          addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, this.item.angle + (float)d1));
        }
      }
      return;
    }
    clearTextureParam();
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((!CollectionUtils.isEmpty(paramList)) && (paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3) && (isValidItem(this.item)))
    {
      PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      int i;
      if (this.item.alignFacePoints.length == 1) {
        i = this.item.alignFacePoints[0];
      } else {
        i = this.item.alignFacePoints[1];
      }
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      if (VideoMaterial.isFaceItem(this.item))
      {
        d1 = localPointF1.x;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        localPointF1.x = ((float)(d1 / d2));
        d1 = localPointF1.y;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        localPointF1.y = ((float)(d1 / d2));
      }
      paramFloat = localPointF1.x - this.item.anchorPoint[0];
      float f1 = localPointF1.y - this.item.anchorPoint[1];
      float f2 = this.item.width;
      setPositions(AlgoUtils.adjustPosition(AlgoUtils.calPositions(paramFloat, f1 + this.item.height, paramFloat + f2, f1, this.width, this.height), this.audioScaleFactor));
      addParam(new UniformParam.Float2fParam("texAnchor", localPointF1.x - this.canvasCenter.x, localPointF1.y - this.canvasCenter.y));
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      if (VideoMaterial.isFaceItem(this.item))
      {
        d1 = localPointF1.x;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        localPointF1.x = ((float)(d1 / d2));
        d1 = localPointF1.y;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        localPointF1.y = ((float)(d1 / d2));
      }
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      if (VideoMaterial.isFaceItem(this.item))
      {
        d1 = paramList.x;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        paramList.x = ((float)(d1 / d2));
        d1 = paramList.y;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        paramList.y = ((float)(d1 / d2));
      }
      double d1 = Math.sqrt(Math.pow(localPointF1.x - paramList.x, 2.0D) + Math.pow(localPointF1.y - paramList.y, 2.0D));
      double d2 = this.item.scaleFactor;
      Double.isNaN(d2);
      d2 = d1 / d2;
      d1 = d2;
      double d3;
      if (this.item.maxScaledWidth != 0)
      {
        d3 = this.item.maxScaledWidth / this.item.width;
        d1 = d2;
        if (d2 > d3) {
          d1 = d3;
        }
      }
      d2 = d1;
      if (this.item.minScaledWidth != 0)
      {
        d3 = this.item.minScaledWidth / this.item.width;
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
      }
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, -paramArrayOfFloat[2] - this.item.angle));
      return;
    }
    clearTextureParam();
  }
  
  protected void updatePositionsForMultiAnchor(List<PointF> paramList, int paramInt)
  {
    super.updatePositionsForMultiAnchor(paramList, paramInt);
    if ((!CollectionUtils.isEmpty(paramList)) && (isValidItem(this.item)))
    {
      int i = 0;
      int j = 0;
      Object localObject1;
      Object localObject2;
      double d1;
      double d2;
      if (paramInt == 4)
      {
        paramInt = 0;
        for (;;)
        {
          i = j;
          if (paramInt >= 4) {
            break;
          }
          localObject1 = this.item.anchorPoint;
          i = paramInt * 2;
          int k = localObject1[i];
          localObject1 = this.item.anchorPoint;
          int m = i + 1;
          int n = localObject1[m];
          this.mTexCoords[i] = (k / this.item.width);
          this.mTexCoords[m] = (n / this.item.height);
          paramInt += 1;
        }
        while (i < 4)
        {
          localObject1 = (PointF)paramList.get(this.item.alignFacePoints[i]);
          localObject2 = this.mPositions;
          paramInt = i * 2;
          d1 = ((PointF)localObject1).x;
          d2 = this.width;
          double d3 = this.mFaceDetScale;
          Double.isNaN(d2);
          Double.isNaN(d1);
          localObject2[paramInt] = ((float)(d1 / (d2 * d3) * 2.0D - 1.0D));
          localObject2 = this.mPositions;
          d1 = ((PointF)localObject1).y;
          d2 = this.height;
          d3 = this.mFaceDetScale;
          Double.isNaN(d2);
          Double.isNaN(d1);
          localObject2[(paramInt + 1)] = ((float)(d1 / (d2 * d3) * 2.0D - 1.0D));
          i += 1;
        }
        setPositions(this.mPositions);
        setTexCords(this.mTexCoords);
      }
      else if (paramInt == 2)
      {
        localObject1 = new PointF(this.item.anchorPoint[0], this.item.anchorPoint[1]);
        localObject2 = new PointF(this.item.anchorPoint[2], this.item.anchorPoint[3]);
        PointF localPointF = (PointF)paramList.get(this.item.alignFacePoints[0]);
        Object localObject3 = (PointF)paramList.get(this.item.alignFacePoints[1]);
        d1 = localPointF.x;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        float f1 = (float)(d1 / d2);
        d1 = localPointF.y;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        paramList = new PointF(f1, (float)(d1 / d2));
        d1 = ((PointF)localObject3).x;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        f1 = (float)(d1 / d2);
        d1 = ((PointF)localObject3).y;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        localPointF = new PointF(f1, (float)(d1 / d2));
        f1 = AlgoUtils.getDistance(paramList, localPointF) / AlgoUtils.getDistance((PointF)localObject1, (PointF)localObject2);
        localObject3 = this.mPositions;
        localObject3[0] = 0.0F;
        localObject3[1] = 0.0F;
        localObject3[2] = (this.item.width * f1);
        localObject3 = this.mPositions;
        localObject3[3] = 0.0F;
        localObject3[4] = (this.item.width * f1);
        this.mPositions[5] = (this.item.height * f1);
        localObject3 = this.mPositions;
        localObject3[6] = 0.0F;
        localObject3[7] = (this.item.height * f1);
        localObject3 = this.mTexCoords;
        localObject3[0] = 0.0F;
        localObject3[1] = 0.0F;
        localObject3[2] = 1.0F;
        localObject3[3] = 0.0F;
        localObject3[4] = 1.0F;
        localObject3[5] = 1.0F;
        localObject3[6] = 0.0F;
        localObject3[7] = 1.0F;
        float f2 = (float)Math.atan2(((PointF)localObject2).y - ((PointF)localObject1).y, ((PointF)localObject2).x - ((PointF)localObject1).x);
        float f3 = (float)Math.atan2(localPointF.y - paramList.y, localPointF.x - paramList.x);
        localObject2 = new Matrix();
        ((Matrix)localObject2).postTranslate(-((PointF)localObject1).x * f1, -((PointF)localObject1).y * f1);
        d1 = (f3 - f2) * 180.0F;
        Double.isNaN(d1);
        ((Matrix)localObject2).postRotate((float)(d1 / 3.141592653589793D));
        ((Matrix)localObject2).postTranslate(paramList.x, paramList.y);
        ((Matrix)localObject2).mapPoints(this.mPositions);
        paramInt = i;
        while (paramInt < 4)
        {
          paramList = this.mPositions;
          i = paramInt * 2;
          paramList[i] = (paramList[i] / this.width * 2.0F - 1.0F);
          paramList = this.mPositions;
          i += 1;
          paramList[i] = (paramList[i] / this.height * 2.0F - 1.0F);
          paramInt += 1;
        }
        setPositions(this.mPositions);
        setTexCords(this.mTexCoords);
      }
      addParam(new UniformParam.Float2fParam("texAnchor", 0.0F, 0.0F));
      addParam(new UniformParam.FloatParam("texScale", 1.0F));
      addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
      return;
    }
    clearTextureParam();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.maskstickerfilter.DynamicMaskFilter
 * JD-Core Version:    0.7.0.1
 */