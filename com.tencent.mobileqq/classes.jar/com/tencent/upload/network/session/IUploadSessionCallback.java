package com.tencent.upload.network.session;

public abstract interface IUploadSessionCallback
{
  public abstract void onOpenFailed(IUploadSession paramIUploadSession, int paramInt, String paramString);
  
  public abstract void onOpenSucceed(IUploadSession paramIUploadSession);
  
  public abstract void onSessionClosed(IUploadSession paramIUploadSession);
  
  public abstract void onSessionError(IUploadSession paramIUploadSession, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.session.IUploadSessionCallback
 * JD-Core Version:    0.7.0.1
 */