package com.tencent.open.agent.auth;

import android.graphics.Bitmap;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;

public abstract interface IOldAuthorityContract$View
  extends IBaseView
{
  public abstract void a(IOldAuthorityContract.Presenter paramPresenter);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, Bitmap paramBitmap);
  
  public abstract boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, String paramString);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.IOldAuthorityContract.View
 * JD-Core Version:    0.7.0.1
 */