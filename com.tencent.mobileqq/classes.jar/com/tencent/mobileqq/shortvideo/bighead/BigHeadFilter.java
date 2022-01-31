package com.tencent.mobileqq.shortvideo.bighead;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.processor.BigHeadProcessor;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import java.util.Iterator;
import java.util.List;

public class BigHeadFilter
  extends VideoFilterBase
{
  private static final int NET_HEIGHT = 256;
  private static final int NET_WIDTH = 256;
  public static final String TAG = "BigHeadFilter";
  private static boolean USE_OPTIMIZE_MODE = true;
  public static String sGBigHeadModelPath = null;
  private BigHeadProcessor bigHeadProcessor = null;
  private BigIAnimation mBigHeadAnimation;
  private BigHeadBuckler mBuckler;
  private float mCurrentScaleRatio = 1.3F;
  private boolean mHasInited = false;
  private BigHeadInitFilter mInitFilter;
  private float mMaxScaleRatio = 0.0F;
  private OpencvMaskSmooth mOpenCV;
  private float[] mOutputMaskMatrix = new float[16];
  private Rect mOutputWindows = new Rect();
  private RenderBuffer mRenderBigHead;
  private RenderBuffer mRenderBigHeadBuckle;
  private RenderBuffer mRenderBigMask;
  private RenderBuffer mRenderScreen;
  private float[] mScaleBigMatrix = new float[16];
  private BigHeadMaskSmooth mSmoothFilter;
  private BigHeadMaskManager maskMgr;
  private TextureRender textureRenderBig;
  
  public BigHeadFilter(VideoMaterial paramVideoMaterial)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
    android.opengl.Matrix.setIdentityM(this.mOutputMaskMatrix, 0);
    android.opengl.Matrix.setRotateM(this.mOutputMaskMatrix, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    this.mBigHeadAnimation = new BigHeadAnimationConfig(paramVideoMaterial);
    this.mMaxScaleRatio = this.mBigHeadAnimation.getMaxScale();
    this.bigHeadProcessor = new BigHeadProcessor();
    this.bigHeadProcessor.setInputSize(256, 256);
  }
  
  private void checkBindIsOK()
  {
    if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
      com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil.checkGlError("glCheckFramebufferStatus");
    }
  }
  
  private void convertFaceCoords()
  {
    Object localObject1 = this.mInitFilter.fullFaceCoords;
    int i = this.mInitFilter.getExtendRegion().width();
    float f = this.mInitFilter.getExtendEnlargeRegion().width() * 1.0F / i;
    Object localObject2 = new float[2];
    float[] arrayOfFloat = new float[2];
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      localObject2[0] = localPointF.x;
      localObject2[1] = localPointF.y;
      regionScaleCenter((float[])localObject2, arrayOfFloat, f);
      localPointF.x = arrayOfFloat[0];
      localPointF.y = arrayOfFloat[1];
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PointF)((Iterator)localObject1).next();
      ((PointF)localObject2).x = ((float)(((PointF)localObject2).x * this.mFaceDetScale));
      ((PointF)localObject2).y = ((float)(((PointF)localObject2).y * this.mFaceDetScale));
    }
  }
  
  private void initBigHeadPreProcess(int paramInt1, int paramInt2)
  {
    if (!this.mHasInited)
    {
      this.mInitFilter = new BigHeadInitFilter();
      this.mInitFilter.init();
      this.mInitFilter.updateNetWorkSize(256, 256);
      this.mInitFilter.setMaxScaleRatio(this.mMaxScaleRatio);
      if (!TextUtils.isEmpty(sGBigHeadModelPath)) {
        QmcfManager.getInstance().switchQmcfModel(3, sGBigHeadModelPath);
      }
      this.maskMgr = new BigHeadMaskManager(256, 256);
      this.textureRenderBig = new TextureRender();
      this.mRenderBigHead = new RenderBuffer(false, 0, 0);
      this.mBuckler = new BigHeadBuckler();
      this.mBuckler.init();
      this.mRenderBigHeadBuckle = new RenderBuffer(false, 0, 0);
      this.mRenderScreen = new RenderBuffer(false, paramInt1, paramInt2);
      this.mRenderBigMask = new RenderBuffer(false, 0, 0);
      this.mSmoothFilter = new BigHeadMaskSmooth();
      this.mOpenCV = new OpencvMaskSmooth();
      this.mHasInited = true;
    }
  }
  
  private boolean renderTextureBigHead(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mHasInited) {}
    do
    {
      return true;
      this.mOutputWindows.set(0, 0, paramInt2, paramInt3);
    } while (!this.mInitFilter.getUpdateDataFlag());
    com.tencent.aekit.openrender.util.GlUtil.setBlendMode(false);
    this.mInitFilter.drawTexture(paramInt1);
    int i = this.mInitFilter.getOutputTexture();
    if (SLog.isEnable()) {
      SLog.d("BigHeadFilter", "BigHeadFilter:renderTexture outTexture=" + i);
    }
    int j = this.maskMgr.getSpaceMask();
    this.bigHeadProcessor.doProcess(i, j);
    this.maskMgr.queueMask(j);
    j = this.maskMgr.getMergedMask(false);
    i = this.mInitFilter.getExtendRegion().width();
    int k;
    if (i != this.mRenderBigHead.getWidth())
    {
      GLES20.glDeleteTextures(1, new int[] { this.mRenderBigHead.getTexId() }, 0);
      k = com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil.createTextureAllocate(i, i, false);
      this.mRenderBigHead.setUserTextureId(k);
      this.mRenderBigHead.setSize(i, i);
    }
    this.mRenderBigHead.bind();
    GLES20.glClear(16384);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.textureRenderBig.drawTexture(3553, j, null, this.mOutputMaskMatrix);
    this.mRenderBigHead.unbind();
    j = this.mRenderBigHead.getTexId();
    if (i != this.mRenderBigHeadBuckle.getWidth())
    {
      GLES20.glDeleteTextures(1, new int[] { this.mRenderBigHeadBuckle.getTexId() }, 0);
      k = com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil.createTextureAllocate(i, i, false);
      this.mRenderBigHeadBuckle.setUserTextureId(k);
      this.mRenderBigHeadBuckle.setSize(i, i);
    }
    this.mRenderBigHeadBuckle.bind();
    this.mBuckler.drawTexture(this.mInitFilter.getClippedTextureId(), j, null, null, null);
    this.mRenderBigHeadBuckle.unbind();
    i = this.mInitFilter.getExtendEnlargeRegion().width();
    if (i != this.mRenderBigMask.getWidth())
    {
      GLES20.glDeleteTextures(1, new int[] { this.mRenderBigMask.getTexId() }, 0);
      j = com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil.createTextureAllocate(i, i, false);
      this.mRenderBigMask.setUserTextureId(j);
      this.mRenderBigMask.setSize(i, i);
    }
    this.mRenderBigMask.bind();
    GLES20.glClear(16384);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.textureRenderBig.drawTexture(3553, this.mRenderBigHeadBuckle.getTexId(), null, null);
    this.mRenderBigMask.unbind();
    i = this.mRenderBigMask.getTexId();
    Rect localRect1 = new Rect(0, 0, 0, 0);
    localRect1.setIntersect(this.mOutputWindows, this.mInitFilter.getExtendEnlargeRegion());
    this.mRenderScreen.setUserTextureId(paramInt1);
    this.mRenderScreen.setSize(paramInt2, paramInt3);
    this.mRenderScreen.bind();
    checkBindIsOK();
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glViewport(localRect1.left, localRect1.top, localRect1.width(), localRect1.height());
    Rect localRect2 = this.mInitFilter.getExtendEnlargeRegion();
    if (localRect2.left < 0)
    {
      paramInt1 = -localRect2.left;
      if (localRect2.top >= 0) {
        break label746;
      }
    }
    label746:
    for (paramInt2 = -localRect2.top;; paramInt2 = 0)
    {
      float f1 = paramInt1 * 1.0F / this.mRenderBigMask.getWidth();
      float f2 = paramInt2 * 1.0F / this.mRenderBigMask.getHeight();
      android.opengl.Matrix.setIdentityM(this.mScaleBigMatrix, 0);
      android.opengl.Matrix.translateM(this.mScaleBigMatrix, 0, f1, f2, 0.0F);
      f1 = localRect1.width() * 1.0F / this.mRenderBigMask.getWidth();
      f2 = localRect1.height() * 1.0F / this.mRenderBigMask.getHeight();
      android.opengl.Matrix.scaleM(this.mScaleBigMatrix, 0, f1, f2, 1.0F);
      this.textureRenderBig.drawTexture(3553, i, this.mScaleBigMatrix, null);
      GLES20.glDisable(3042);
      this.mRenderScreen.unbind();
      com.tencent.aekit.openrender.util.GlUtil.setBlendMode(true);
      return true;
      paramInt1 = 0;
      break;
    }
  }
  
  private boolean renderTextureBigHeadOptimize(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mHasInited) {}
    do
    {
      return true;
      this.mOutputWindows.set(0, 0, paramInt2, paramInt3);
    } while (!this.mInitFilter.getUpdateDataFlag());
    com.tencent.aekit.openrender.util.GlUtil.setBlendMode(false);
    this.mInitFilter.drawTextureOptimize(paramInt1);
    int i = this.mInitFilter.getOutputTexture();
    if (SLog.isEnable()) {
      SLog.d("BigHeadFilter", "BigHeadFilter:renderTexture outTexture=" + i);
    }
    int j = this.maskMgr.getSpaceMask();
    this.bigHeadProcessor.doInit();
    this.bigHeadProcessor.doProcess(i, j);
    this.maskMgr.queueMask(j);
    i = this.maskMgr.getMergedMask(false);
    this.mInitFilter.clipAllocateConstTexture(this.mRenderBigHead, this.mMaxScaleRatio);
    this.mRenderBigHead.bind();
    GLES20.glClear(16384);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glViewport(this.mInitFilter.mEnlargeSubRegion.left, this.mInitFilter.mEnlargeSubRegion.top, this.mInitFilter.mEnlargeSubRegion.width(), this.mInitFilter.mEnlargeSubRegion.height());
    this.textureRenderBig.drawTexture(3553, i, null, this.mOutputMaskMatrix);
    this.mRenderBigHead.unbind();
    i = this.mRenderBigHead.getTexId();
    try
    {
      this.mSmoothFilter.drawTexture(i, this.mRenderBigHead.getWidth(), this.mRenderBigHead.getHeight(), this.mInitFilter.inClipMatrix, this.mInitFilter.mEnlargeSubRegion);
      j = this.mSmoothFilter.getOutputTexture();
      i = j;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Rect localRect1;
        Rect localRect2;
        float f1;
        float f2;
        float f3;
        float f4;
        if (SLog.isEnable()) {
          SLog.e("BigHeadFilter", "mSmoothFilter error ", localRuntimeException);
        }
        continue;
        paramInt1 = 0;
        continue;
        paramInt2 = 0;
      }
    }
    this.mOpenCV.processCVMask(i, this.mInitFilter.mEnlargeSubRegion, this.mRenderBigHead.getWidth(), this.mRenderBigHead.getHeight());
    this.mInitFilter.clipAllocateConstTexture(this.mRenderBigHeadBuckle, this.mMaxScaleRatio);
    this.mRenderBigHeadBuckle.bind();
    GLES20.glViewport(this.mInitFilter.mEnlargeSubRegion.left, this.mInitFilter.mEnlargeSubRegion.top, this.mInitFilter.mEnlargeSubRegion.width(), this.mInitFilter.mEnlargeSubRegion.height());
    this.mBuckler.drawTexture(this.mInitFilter.getClippedTextureId(), i, this.mInitFilter.inClipMatrix, this.mInitFilter.inClipMatrix, null);
    this.mRenderBigHeadBuckle.unbind();
    i = this.mRenderBigHeadBuckle.getTexId();
    localRect1 = new Rect(0, 0, 0, 0);
    localRect1.setIntersect(this.mOutputWindows, this.mInitFilter.getExtendEnlargeRegion());
    this.mRenderScreen.setUserTextureId(paramInt1);
    this.mRenderScreen.setSize(paramInt2, paramInt3);
    this.mRenderScreen.bind();
    checkBindIsOK();
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glViewport(localRect1.left, localRect1.top, localRect1.width(), localRect1.height());
    localRect2 = this.mInitFilter.getExtendEnlargeRegion();
    if (localRect2.left < 0)
    {
      paramInt1 = -localRect2.left;
      if (localRect2.top >= 0) {
        break label760;
      }
      paramInt2 = -localRect2.top;
      paramInt3 = this.mInitFilter.mEnlargeSubRegion.left;
      j = this.mInitFilter.mEnlargeSubRegion.top;
      f1 = (paramInt1 + paramInt3) * 1.0F / this.mRenderBigHeadBuckle.getWidth();
      f2 = (paramInt2 + j) * 1.0F / this.mRenderBigHeadBuckle.getHeight();
      f3 = localRect1.width() * 1.0F / this.mRenderBigHeadBuckle.getWidth();
      f4 = localRect1.height() * 1.0F / this.mRenderBigHeadBuckle.getHeight();
      android.opengl.Matrix.setIdentityM(this.mScaleBigMatrix, 0);
      android.opengl.Matrix.translateM(this.mScaleBigMatrix, 0, f1, f2, 0.0F);
      android.opengl.Matrix.scaleM(this.mScaleBigMatrix, 0, f3, f4, 1.0F);
      this.textureRenderBig.drawTexture(3553, i, this.mScaleBigMatrix, null);
      GLES20.glDisable(3042);
      this.mRenderScreen.unbind();
      com.tencent.aekit.openrender.util.GlUtil.setBlendMode(true);
      return true;
    }
  }
  
  private void updateFaceParamData(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if (SLog.isEnable()) {
      SLog.d("BigHeadFilter", "BigHeadFilter:updateFaceParamData");
    }
    this.mCurrentScaleRatio = this.mBigHeadAnimation.getCurrentScale(System.currentTimeMillis());
    this.mInitFilter.setCurrentScaleRatio(this.mCurrentScaleRatio);
    this.mInitFilter.updateParams(paramList, paramArrayOfFloat);
    if (this.mInitFilter.getUpdateDataFlag()) {
      convertFaceCoords();
    }
    while (this.mInitFilter.fullFaceCoords == null) {
      return;
    }
    this.mInitFilter.fullFaceCoords.clear();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    if (SLog.isEnable()) {
      SLog.d("BigHeadFilter", "BigHeadFilter:ApplyGLSLFilter");
    }
  }
  
  public void OnDrawFrameGLSLSuper()
  {
    super.OnDrawFrameGLSLSuper();
    if (SLog.isEnable()) {
      SLog.d("BigHeadFilter", "BigHeadFilter:OnDrawFrameGLSLSuper");
    }
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeRender(paramInt1, paramInt2, paramInt3);
    long l1;
    if (this.mHasInited)
    {
      l1 = System.nanoTime();
      if (!USE_OPTIMIZE_MODE) {
        break label91;
      }
      renderTextureBigHeadOptimize(paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      long l2 = System.nanoTime();
      if (SLog.isEnable()) {
        SLog.d("BigHeadFilter", "BigHead beforeRender cost=" + (float)(l2 - l1) / 1000.0F + " optMode=" + USE_OPTIMIZE_MODE);
      }
      return;
      label91:
      renderTextureBigHead(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    if (this.mHasInited)
    {
      this.mHasInited = false;
      this.mInitFilter.release();
      this.mInitFilter = null;
      this.maskMgr.release();
      this.maskMgr = null;
      String str = this.bigHeadProcessor.doDestroy();
      if (SLog.isEnable()) {
        SLog.d("BigHeadFilter", "BigHeadFilter:BigHead.destroySafe msg= " + str);
      }
      this.textureRenderBig.release();
      this.mRenderBigHead.destroy();
      BigHeadInitFilter.releaseRenderFBOTexture(this.mRenderBigHead);
      this.mBuckler.destroy();
      this.mRenderBigHeadBuckle.destroy();
      BigHeadInitFilter.releaseRenderFBOTexture(this.mRenderBigHeadBuckle);
      this.mRenderBigMask.destroy();
      BigHeadInitFilter.releaseRenderFBOTexture(this.mRenderBigMask);
      this.mRenderScreen.destroy();
      this.mSmoothFilter.destroy();
    }
  }
  
  public int getEvenInt(int paramInt)
  {
    return paramInt - paramInt % 2;
  }
  
  public void initParams()
  {
    if (SLog.isEnable()) {
      SLog.d("BigHeadFilter", "BigHeadFilter:initParams");
    }
  }
  
  public void regionScaleCenter(RectF paramRectF1, RectF paramRectF2, float paramFloat)
  {
    android.graphics.Matrix localMatrix = new android.graphics.Matrix();
    localMatrix.setScale(paramFloat, paramFloat, paramRectF1.centerX(), paramRectF1.centerY());
    localMatrix.mapRect(paramRectF2, paramRectF1);
  }
  
  public void regionScaleCenter(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    int i = this.mInitFilter.zhongxin.x;
    int j = this.mInitFilter.zhongxin.y;
    android.graphics.Matrix localMatrix = new android.graphics.Matrix();
    localMatrix.setScale(paramFloat, paramFloat, i, j);
    localMatrix.mapPoints(paramArrayOfFloat2, paramArrayOfFloat1);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void updatePreview(Object paramObject)
  {
    if (!(paramObject instanceof PTDetectInfo)) {}
    do
    {
      return;
      paramObject = (PTDetectInfo)paramObject;
    } while (!this.mHasInited);
    updateFaceParamData(paramObject.facePoints, paramObject.faceAngles);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if (SLog.isEnable()) {
      SLog.d("BigHeadFilter", "BigHeadFilter:updateVideoSize screenScale=" + paramDouble);
    }
    initBigHeadPreProcess(paramInt1, paramInt2);
    this.mInitFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadFilter
 * JD-Core Version:    0.7.0.1
 */