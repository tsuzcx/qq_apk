package com.tencent.upload.network.session;

import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.utils.Const.UploadRetCode;

public abstract interface IUploadSession$RequestListener
{
  public abstract void onRequestError(IActionRequest paramIActionRequest, Const.UploadRetCode paramUploadRetCode, IUploadSession paramIUploadSession);
  
  public abstract void onRequestSended(IActionRequest paramIActionRequest);
  
  public abstract void onRequestTimeout(IActionRequest paramIActionRequest, IUploadSession paramIUploadSession);
  
  public abstract void onResponse(IActionRequest paramIActionRequest, UploadResponse paramUploadResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.session.IUploadSession.RequestListener
 * JD-Core Version:    0.7.0.1
 */