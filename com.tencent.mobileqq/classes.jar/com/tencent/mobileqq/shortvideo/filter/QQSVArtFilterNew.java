package com.tencent.mobileqq.shortvideo.filter;

import android.os.Build.VERSION;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.processor.ArtFilterProcessor;
import com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class QQSVArtFilterNew
  extends QQBaseFilter
{
  public static final String TAG = "QQSVArtFilter";
  private int frameCount = 0;
  private int initHeight = 640;
  private int initWidth = 480;
  private RenderBuffer mFilterOutFBO;
  private BaseQmcfProcessor mProcessor = null;
  private RenderBuffer mSoInFBO;
  private int mSoInTexture;
  private RenderBuffer mSoOutFBO;
  private int mSoOutTexture;
  private boolean shouldInitTexture = false;
  private TextureRender textureRender;
  
  public QQSVArtFilterNew(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    QmcfManager.getInstance().setCurrQmcfMode(0);
    this.mProcessor = new ArtFilterProcessor(this.initWidth, this.initHeight);
  }
  
  private void initTexture()
  {
    Object localObject = this.mSoInFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mSoOutFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mFilterOutFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.textureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    int i = this.mProcessor.getInputWidth();
    int j = this.mProcessor.getInputHeight();
    int k = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1;
    if (k >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mSoInFBO = new RenderBuffer(i, j, 33984, bool1);
    i = this.mProcessor.getInputWidth();
    j = this.mProcessor.getInputHeight();
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.mSoOutFBO = new RenderBuffer(i, j, 33984, bool1);
    this.mFilterOutFBO = new RenderBuffer(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), 33984);
    this.textureRender = new TextureRender();
  }
  
  public boolean isFilterWork()
  {
    return QmcfManager.getInstance().getCurrQmcfMode() == 1;
  }
  
  public void onDrawFrame()
  {
    if (QmcfManager.getInstance().getCurrQmcfMode() != 1)
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    try
    {
      this.mProcessor.doInit();
      if (this.shouldInitTexture)
      {
        this.frameCount = 0;
        initTexture();
        this.shouldInitTexture = false;
        this.mOutputTextureID = this.mInputTextureID;
        return;
      }
      this.mSoInFBO.bind();
      this.textureRender.drawTexture(3553, this.mInputTextureID, null, null);
      this.mSoInFBO.unbind();
      this.mSoInTexture = this.mSoInFBO.getTexId();
      this.mSoOutTexture = this.mSoOutFBO.getTexId();
      this.mProcessor.doProcess(this.mSoInTexture, this.mSoOutTexture);
      this.mFilterOutFBO.bind();
      this.textureRender.drawTexture(3553, this.mSoOutTexture, null, null);
      this.mFilterOutFBO.unbind();
      this.mOutputTextureID = this.mFilterOutFBO.getTexId();
      QQFilterLogManager.setFilterStatus("QQSVArtFilter", true);
      int i = this.frameCount + 1;
      this.frameCount = i;
      if (i < 3)
      {
        this.mOutputTextureID = this.mInputTextureID;
        return;
      }
    }
    catch (Error localError)
    {
      QmcfManager.getInstance().setQmcfRunSupported(false, false, 1);
      this.mOutputTextureID = this.mInputTextureID;
      SLog.e("QQSVArtFilter", "process excep!", localError);
      return;
    }
    catch (Exception localException)
    {
      QmcfManager.getInstance().setQmcfRunSupported(false, false, 1);
      this.mOutputTextureID = this.mInputTextureID;
      SLog.e("QQSVArtFilter", "process excep!", localException);
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if (SLog.isEnable()) {
      SLog.d("QQSVArtFilter", "onSurfaceChange");
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      int i = this.initHeight;
      paramInt1 = paramInt1 * i / paramInt2;
      paramInt1 -= paramInt1 % 4;
      if (paramInt1 != this.initWidth)
      {
        this.initWidth = paramInt1;
        this.mProcessor.setInputSize(this.initWidth, i);
        if (SLog.isEnable()) {
          SLog.d("QQSVArtFilter", String.format("onSurfaceChange resize input width[%d], height[%d]", new Object[] { Integer.valueOf(this.initWidth), Integer.valueOf(this.initHeight) }));
        }
        this.shouldInitTexture = true;
        this.mProcessor.doDestroy();
      }
    }
  }
  
  public void onSurfaceCreate()
  {
    if (SLog.isEnable()) {
      SLog.d("QQSVArtFilter", "onSurfaceCreate");
    }
    this.shouldInitTexture = true;
  }
  
  public void onSurfaceDestroy()
  {
    QmcfManager.getInstance().destroy();
    this.mProcessor.doDestroy();
    if (SLog.isEnable()) {
      SLog.d("QQSVArtFilter", "onSurfaceDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQSVArtFilterNew
 * JD-Core Version:    0.7.0.1
 */