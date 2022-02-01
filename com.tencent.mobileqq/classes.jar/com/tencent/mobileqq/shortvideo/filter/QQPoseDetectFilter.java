package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.processor.PoseDetectProcessor;
import com.tencent.mobileqq.shortvideo.dancemachine.tempDir.HumanPoseFilter;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class QQPoseDetectFilter
  extends QQBaseFilter
{
  public static final String TAG = "QQPoseDetectFilter";
  float[] inMvpMatrix = new float[16];
  private int initHeight = 256;
  private int initWidth = 144;
  private HumanPoseFilter mHumanFilter = new HumanPoseFilter(this.initWidth, this.initHeight);
  private PoseDetectProcessor mProcessor = null;
  private RenderBuffer mRenderInFBO;
  private RenderBuffer mRenderOutFBO;
  private RenderBuffer mRenderTmp;
  private int scaleTexture;
  private boolean shouldInitTexture = false;
  private int surfaceHeight;
  private int surfaceWidth;
  private TextureRender textureRender;
  
  public QQPoseDetectFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    QmcfManager.getInstance().setCurrQmcfMode(0);
    this.mProcessor = new PoseDetectProcessor(this.initWidth, this.initHeight);
  }
  
  private void initTexture()
  {
    if (this.mRenderInFBO != null) {
      this.mRenderInFBO.destroy();
    }
    if (this.mRenderOutFBO != null) {
      this.mRenderOutFBO.destroy();
    }
    if (this.textureRender != null) {
      this.textureRender.release();
    }
    if (this.mRenderTmp != null) {
      this.mRenderTmp.destroy();
    }
    int i = this.mProcessor.getInputHeight();
    int j = this.mProcessor.getInputWidth();
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      this.mRenderInFBO = new RenderBuffer(i, j, 33984, bool);
      this.mRenderOutFBO = new RenderBuffer(this.surfaceWidth, this.surfaceHeight, 33984);
      this.mRenderTmp = new RenderBuffer(this.surfaceWidth, this.surfaceHeight);
      this.mHumanFilter.updateFboSize(this.mRenderTmp);
      this.textureRender = new TextureRender();
      return;
    }
  }
  
  public float[] getKeyPoints()
  {
    return this.mProcessor.getKeyPoints();
  }
  
  public int getPoseInitHeight()
  {
    return this.initHeight;
  }
  
  public int getPoseInitWidth()
  {
    return this.initWidth;
  }
  
  public boolean isFilterWork()
  {
    return QmcfManager.getInstance().getCurrQmcfMode() == 2;
  }
  
  public void onDrawFrame()
  {
    try
    {
      this.mProcessor.doInit();
      if (this.shouldInitTexture)
      {
        initTexture();
        this.shouldInitTexture = false;
        this.mOutputTextureID = this.mInputTextureID;
        return;
      }
      Matrix.setIdentityM(this.inMvpMatrix, 0);
      Matrix.setRotateM(this.inMvpMatrix, 0, 180.0F, 1.0F, 0.0F, 0.0F);
      this.mRenderInFBO.bind();
      this.textureRender.drawTexture(3553, this.mInputTextureID, QmcfManager.getInstance().mSTMatrix, this.inMvpMatrix);
      this.mRenderInFBO.unbind();
      this.scaleTexture = this.mRenderInFBO.getTexId();
      this.mProcessor.doProcess(this.scaleTexture, this.mRenderOutFBO.getTexId());
      if ((QmcfManager.isDebugMode) && (this.mHumanFilter != null))
      {
        this.mRenderTmp.setUserTextureId(this.mInputTextureID);
        this.mRenderTmp.bind();
        this.mHumanFilter.updateParams(this.mRenderTmp, this.mProcessor.getKeyPoints());
        this.mHumanFilter.drawFrame(this.mRenderTmp);
      }
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    catch (Exception localException)
    {
      QmcfManager.getInstance().setQmcfRunSupported(false, false, 2);
      this.mOutputTextureID = this.mInputTextureID;
      SLog.e("QQPoseDetectFilter", "process excep!", localException);
      return;
    }
    catch (Error localError)
    {
      QmcfManager.getInstance().setQmcfRunSupported(false, false, 2);
      this.mOutputTextureID = this.mInputTextureID;
      SLog.e("QQPoseDetectFilter", "process excep!", localError);
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if (SLog.isEnable()) {
      SLog.d("QQPoseDetectFilter", "onSurfaceChange");
    }
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.shouldInitTexture = true;
    this.mProcessor.doDestroy();
    if ((this.surfaceWidth > 0) && (this.surfaceHeight > 0) && (QmcfManager.getInstance().getCurrFrameType() != 1))
    {
      this.initWidth = (this.initHeight * this.surfaceWidth / this.surfaceHeight);
      if (this.initWidth < 144) {
        this.initWidth = 144;
      }
      this.mProcessor.setInputSize(this.initWidth, this.initHeight);
      if (QmcfManager.isDebugMode) {
        this.mHumanFilter.updatePoseSize(this.initWidth, this.initHeight);
      }
    }
  }
  
  public void onSurfaceCreate()
  {
    if (SLog.isEnable()) {
      SLog.d("QQPoseDetectFilter", "onSurfaceCreate");
    }
    this.shouldInitTexture = true;
    this.mHumanFilter.initHumanFilter();
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.shouldInitTexture = true;
    this.mProcessor.doDestroy();
    QmcfManager.getInstance().destroy();
    if (SLog.isEnable()) {
      SLog.d("QQPoseDetectFilter", "onSurfaceDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPoseDetectFilter
 * JD-Core Version:    0.7.0.1
 */