package com.tencent.upload.network.session;

import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.request.IActionRequest;

public abstract interface IUploadSession
{
  public abstract void cancel(int paramInt);
  
  public abstract void close();
  
  public abstract String getConnectedIp();
  
  public abstract IUploadSession.SessionState getState();
  
  public abstract UploadRoute getUploadRoute();
  
  public abstract boolean isExpired();
  
  public abstract boolean isIdle();
  
  public abstract boolean open(UploadRoute paramUploadRoute);
  
  public abstract boolean open(UploadRoute paramUploadRoute, int paramInt);
  
  public abstract boolean send(IActionRequest paramIActionRequest, IUploadSession.RequestListener paramRequestListener);
  
  public abstract void setBusy(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.IUploadSession
 * JD-Core Version:    0.7.0.1
 */