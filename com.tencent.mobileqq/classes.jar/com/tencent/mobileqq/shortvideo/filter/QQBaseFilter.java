package com.tencent.mobileqq.shortvideo.filter;

import java.util.concurrent.atomic.AtomicInteger;

public class QQBaseFilter
{
  static final int CREATED = 1;
  static final int INITED = 2;
  static final int UNINIT = 0;
  protected boolean mCaptureMode;
  private QQFilterRenderManager mFilterRenderManagerInstance = null;
  protected int mFilterType;
  protected int mInputTextureID;
  protected int mOutputTextureID;
  protected AtomicInteger mQuoteCount = new AtomicInteger(0);
  protected Object mSpecificParam;
  protected int mStatus = 0;
  
  public QQBaseFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.mFilterType = paramInt;
    this.mFilterRenderManagerInstance = paramQQFilterRenderManager;
  }
  
  public int getFilterType()
  {
    return this.mFilterType;
  }
  
  public int getIntputTextureID()
  {
    return this.mInputTextureID;
  }
  
  public int getOutputTextureID()
  {
    return this.mOutputTextureID;
  }
  
  public QQFilterRenderManager getQQFilterRenderManager()
  {
    return this.mFilterRenderManagerInstance;
  }
  
  public Object getSpecificParam()
  {
    return this.mSpecificParam;
  }
  
  public boolean isFilterWork()
  {
    return false;
  }
  
  public boolean needFaceDetect()
  {
    return false;
  }
  
  public void onChangeCamera(int paramInt) {}
  
  public void onDrawFrame() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onSurfaceChange(int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreate() {}
  
  public void onSurfaceDestroy() {}
  
  protected void parseSpecificParam() {}
  
  public void setCaptureMode(boolean paramBoolean)
  {
    this.mCaptureMode = paramBoolean;
  }
  
  public void setInputTextureID(int paramInt)
  {
    this.mInputTextureID = paramInt;
  }
  
  public void setOutputTextureID(int paramInt)
  {
    this.mOutputTextureID = paramInt;
  }
  
  public void setSpecificParam(Object paramObject)
  {
    this.mSpecificParam = paramObject;
    parseSpecificParam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
 * JD-Core Version:    0.7.0.1
 */