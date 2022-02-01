package com.tencent.upload.network.session;

import com.tencent.upload.request.IActionRequest;

final class UploadSession$RequestWrapper
{
  public final IActionRequest request;
  public Runnable runnable;
  public long startTime;
  
  public UploadSession$RequestWrapper(IActionRequest paramIActionRequest)
  {
    this.request = paramIActionRequest;
    this.startTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.UploadSession.RequestWrapper
 * JD-Core Version:    0.7.0.1
 */