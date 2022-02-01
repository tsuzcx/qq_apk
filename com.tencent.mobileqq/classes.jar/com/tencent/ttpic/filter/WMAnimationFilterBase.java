package com.tencent.ttpic.filter;

import android.graphics.RectF;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class WMAnimationFilterBase
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform float texAlpha;\n\nvoid main(void)\n{\n     vec4 tmpFragColor = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = tmpFragColor * texAlpha;\n}";
  private static final String TAG = WMAnimationFilterBase.class.getSimpleName();
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\n\nconst float PI = 3.14159;\n\nuniform mat4 u_MVPMatrix;\n\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 posMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos = texMatRotateXY * framePos;\n\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        framePos = texMatTranslateAfter * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n\n        framePos = u_MVPMatrix * framePos;\n\n    }\n    gl_Position = framePos;\n    textureCoordinate = inputTextureCoordinate;\n}";
  protected List<WMAnimationFilterBase.AnimationTimePoint> mAnimationTimePoints = new ArrayList();
  private int mDuration;
  protected float mRatio;
  protected long mStartDelay;
  private long mStartTime;
  
  public WMAnimationFilterBase(WMElement paramWMElement, int paramInt1, int paramInt2, int paramInt3)
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform int texNeedTransform;\nuniform vec2 canvasSize;\nuniform vec2 texAnchor;\nuniform float texScale;\nuniform vec3 texRotate;\n\nconst float PI = 3.14159;\n\nuniform mat4 u_MVPMatrix;\n\nmat4 texMatTranslateBefore = mat4(1.0, 0.0, 0.0, 0.0,\n                                  0.0, 1.0, 0.0, 0.0,\n                                  0.0, 0.0, 1.0, 0.0,\n                                  0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatScale = mat4(1.0, 0.0, 0.0, 0.0,\n                        0.0, 1.0, 0.0, 0.0,\n                        0.0, 0.0, 1.0, 0.0,\n                        0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatRotateXY = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 posMatRotate = mat4(1.0, 0.0, 0.0, 0.0,\n                         0.0, 1.0, 0.0, 0.0,\n                         0.0, 0.0, 1.0, 0.0,\n                         0.0, 0.0, 0.0, 1.0);\n\nmat4 texMatTranslateAfter = mat4(1.0, 0.0, 0.0, 0.0,\n                                 0.0, 1.0, 0.0, 0.0,\n                                 0.0, 0.0, 1.0, 0.0,\n                                 0.0, 0.0, 0.0, 1.0);\n\nmat4 mat4RotationYXZ(mat4 m, float xRadians, float yRadians, float zRadians) {\n    /*\n     |  cycz + sxsysz   czsxsy - cysz   cxsy  0 |\n M = |  cxsz            cxcz           -sx    0 |\n     |  cysxsz - czsy   cyczsx + sysz   cxcy  0 |\n     |  0               0               0     1 |\n\n     where cA = cos(A), sA = sin(A) for A = x,y,z\n     */\n\n    float cx = cos(xRadians);\n    float sx = sin(xRadians);\n    float cy = cos(yRadians);\n    float sy = sin(yRadians);\n    float cz = cos(zRadians);\n    float sz = sin(zRadians);\n\n    m[0][0] = (cy * cz) + (sx * sy * sz);\n    m[0][1] = cx * sz;\n    m[0][2] = (cy * sx * sz) - (cz * sy);\n    m[0][3] = 0.0;\n\n    m[1][0] = (cz * sx * sy) - (cy * sz);\n    m[1][1] = cx * cz;\n    m[1][2] = (cy * cz * sx) + (sy * sz);\n    m[1][3] = 0.0;\n\n    m[2][0] = cx * sy;\n    m[2][1] = -sx;\n    m[2][2] = cx * cy;\n    m[2][3] = 0.0;\n\n    m[3][0] = 0.0;\n    m[3][1] = 0.0;\n    m[3][2] = 0.0;\n    m[3][3] = 1.0;\n\n    return m;\n}\n\nvoid main(){\n    vec4 framePos = position;\n    if (texNeedTransform > 0) {\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        texMatTranslateBefore[3][0] = -texAnchor.x;\n        texMatTranslateBefore[3][1] = -texAnchor.y;\n\n        texMatScale[0][0] = texScale;\n        texMatScale[1][1] = texScale;\n\n        texMatRotate = mat4RotationYXZ(texMatRotate, 0.0, 0.0, texRotate.z);\n        texMatRotateXY = mat4RotationYXZ(texMatRotateXY, texRotate.x, texRotate.y, 0.0);\n\n        texMatTranslateAfter[3][0] = texAnchor.x;\n        texMatTranslateAfter[3][1] = texAnchor.y;\n\n        framePos = texMatRotate * texMatScale * texMatTranslateBefore * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos = texMatRotateXY * framePos;\n\n        framePos.x = framePos.x * canvasSize.x * 0.5;\n        framePos.y = framePos.y * canvasSize.y * 0.5;\n\n        framePos = texMatTranslateAfter * framePos;\n\n        framePos.x = framePos.x * 2.0 / canvasSize.x;\n        framePos.y = framePos.y * 2.0 / canvasSize.y;\n\n        framePos.x = framePos.x * 1.5 ;\n        framePos.y = framePos.y * 1.5 ;\n\n        framePos = u_MVPMatrix * framePos;\n\n    }\n    gl_Position = framePos;\n    textureCoordinate = inputTextureCoordinate;\n}", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture2;\nuniform float texAlpha;\n\nvoid main(void)\n{\n     vec4 tmpFragColor = texture2D(inputImageTexture2, textureCoordinate);\n     gl_FragColor = tmpFragColor * texAlpha;\n}");
    initParams(paramWMElement, paramInt1, paramInt2, paramInt3);
  }
  
  private void initParams(WMElement paramWMElement, int paramInt1, int paramInt2, int paramInt3)
  {
    addParam(new UniformParam.IntParam("texNeedTransform", 1));
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new UniformParam.Float2fParam("texAnchor", (paramWMElement.finalContentRect.left + paramWMElement.finalContentRect.right) / 2.0F - paramInt1 / 2, (paramWMElement.finalContentRect.top + paramWMElement.finalContentRect.bottom) / 2.0F - paramInt2 / 2));
    addParam(new UniformParam.FloatParam("texScale", 1.0F));
    addParam(new UniformParam.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    addParam(new UniformParam.FloatParam("texAlpha", 1.0F));
    this.mStartTime = System.currentTimeMillis();
    this.mDuration = paramInt3;
    this.mStartDelay = 0L;
    this.mRatio = 1.0F;
    initAnimationTimePoints();
  }
  
  public void apply()
  {
    super.apply();
    resetStartTime();
  }
  
  protected float getAnimationValue(long paramLong)
  {
    if (paramLong - this.mStartTime - this.mStartDelay > 0L)
    {
      paramLong = (paramLong - this.mStartTime - this.mStartDelay) % ((this.mDuration * this.mRatio) + this.mStartDelay);
      int i = 1;
      while (i < this.mAnimationTimePoints.size())
      {
        WMAnimationFilterBase.AnimationTimePoint localAnimationTimePoint1 = (WMAnimationFilterBase.AnimationTimePoint)this.mAnimationTimePoints.get(i - 1);
        WMAnimationFilterBase.AnimationTimePoint localAnimationTimePoint2 = (WMAnimationFilterBase.AnimationTimePoint)this.mAnimationTimePoints.get(i);
        if ((float)paramLong <= (float)localAnimationTimePoint2.timePoint * this.mRatio)
        {
          if (this.mRatio == 0.0F) {
            return localAnimationTimePoint2.value;
          }
          float f1 = ((float)paramLong - (float)localAnimationTimePoint1.timePoint * this.mRatio) * 1.0F / ((float)localAnimationTimePoint2.timePoint * this.mRatio - (float)localAnimationTimePoint1.timePoint * this.mRatio);
          float f2 = localAnimationTimePoint1.value;
          return (localAnimationTimePoint2.value - localAnimationTimePoint1.value) * f1 + f2;
        }
        i += 1;
      }
    }
    return 0.0F;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  protected abstract void initAnimationTimePoints();
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void resetStartTime()
  {
    this.mStartTime = System.currentTimeMillis();
  }
  
  protected abstract void setAnimationParams(long paramLong);
  
  public void updateParams(WMElement paramWMElement, int paramInt1, int paramInt2, long paramLong)
  {
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new UniformParam.Float2fParam("texAnchor", (paramWMElement.finalContentRect.left + paramWMElement.finalContentRect.right) / 2.0F - paramInt1 / 2, (paramWMElement.finalContentRect.top + paramWMElement.finalContentRect.bottom) / 2.0F - paramInt2 / 2));
    setAnimationParams(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMAnimationFilterBase
 * JD-Core Version:    0.7.0.1
 */