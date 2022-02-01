package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferRender;
import java.util.LinkedList;

public class QQTransferFilter
  extends QQBaseFilter
{
  private static final String TAG = "QQTransferFilter";
  private boolean mEnabled = true;
  private TransferRender mRender = new TransferRender();
  private final LinkedList<Runnable> mRunOnDraw = new LinkedList();
  
  public QQTransferFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(160, paramQQFilterRenderManager);
  }
  
  private void runOnDraw(Runnable paramRunnable)
  {
    synchronized (this.mRunOnDraw)
    {
      this.mRunOnDraw.addLast(paramRunnable);
      return;
    }
  }
  
  private void runPendingOnDrawTasks()
  {
    synchronized (this.mRunOnDraw)
    {
      if (!this.mRunOnDraw.isEmpty()) {
        ((Runnable)this.mRunOnDraw.removeFirst()).run();
      }
    }
  }
  
  public void enable(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public boolean isFilterWork()
  {
    return (this.mEnabled) && (this.mRender.isWorking());
  }
  
  public void onDrawFrame()
  {
    if (this.mEnabled)
    {
      runPendingOnDrawTasks();
      long l = getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp() / 1000000L;
      int i = this.mRender.process(this.mInputTextureID, null, null, l);
      if (i >= 0)
      {
        this.mOutputTextureID = i;
        return;
      }
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    this.mOutputTextureID = this.mInputTextureID;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    this.mRender.onSurfaceChange(paramInt1, paramInt2);
  }
  
  public void onSurfaceDestroy()
  {
    this.mRender.destroy();
  }
  
  public void setSpeedRate(float paramFloat)
  {
    if (!this.mEnabled) {
      return;
    }
    runOnDraw(new QQTransferFilter.2(this, paramFloat));
  }
  
  public void setTransferData(TransferData paramTransferData)
  {
    if (!this.mEnabled) {
      return;
    }
    runOnDraw(new QQTransferFilter.1(this, paramTransferData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQTransferFilter
 * JD-Core Version:    0.7.0.1
 */