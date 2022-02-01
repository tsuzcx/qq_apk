package com.tencent.mobileqq.transfile.predownload;

import android.os.Handler;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class AbsPreDownloadTask
{
  static final String TAG = "PreDownload.Task";
  protected BaseQQAppInterface app;
  protected IPreDownloadController ctrl;
  public String key;
  protected Handler subHandler;
  public Object userData;
  
  protected AbsPreDownloadTask(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    this.key = paramString;
    this.app = paramBaseQQAppInterface;
    this.ctrl = ((IPreDownloadController)paramBaseQQAppInterface.getRuntimeService(IPreDownloadController.class));
    this.subHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public final void cancel()
  {
    this.subHandler.post(new AbsPreDownloadTask.2(this));
  }
  
  protected abstract void realCancel();
  
  protected abstract void realStart();
  
  public final void start()
  {
    this.subHandler.post(new AbsPreDownloadTask.1(this));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[");
    localStringBuilder.append(this.key);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
 * JD-Core Version:    0.7.0.1
 */