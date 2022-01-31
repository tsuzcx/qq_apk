package com.tencent.upload.request;

import com.tencent.upload.network.session.IUploadSession.RequestListener;

public abstract interface IActionRequest
{
  public abstract byte[] encode();
  
  public abstract int getCmdId();
  
  public abstract IUploadSession.RequestListener getListener();
  
  public abstract int getRequestId();
  
  public abstract Object getTag();
  
  public abstract int getTaskId();
  
  public abstract boolean needTimeout();
  
  public abstract void setListener(IUploadSession.RequestListener paramRequestListener);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setTaskId(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.request.IActionRequest
 * JD-Core Version:    0.7.0.1
 */