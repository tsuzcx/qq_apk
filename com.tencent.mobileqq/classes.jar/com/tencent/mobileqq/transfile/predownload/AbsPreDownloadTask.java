package com.tencent.mobileqq.transfile.predownload;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class AbsPreDownloadTask
{
  static final String TAG = "PreDownload.Task";
  public QQAppInterface app;
  protected PreDownloadController ctrl;
  public String key;
  protected Handler subHandler;
  public Object userData;
  
  protected AbsPreDownloadTask(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.key = paramString;
    this.app = paramQQAppInterface;
    this.ctrl = ((PreDownloadController)paramQQAppInterface.getManager(193));
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
    return super.toString() + "[" + this.key + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
 * JD-Core Version:    0.7.0.1
 */