package com.tencent.mobileqq.transfile.predownload;

import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;

public abstract interface HttpEngineTask$IHttpEngineTask
  extends INetEngine.INetEngineListener
{
  public abstract void onPreDownloadStart(HttpEngineTask paramHttpEngineTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask
 * JD-Core Version:    0.7.0.1
 */