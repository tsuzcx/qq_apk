package com.tencent.xaction.openapi.api;

import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

@QAPI(process={"all"})
public abstract interface IXADownload
  extends QRouteApi
{
  public static final String SCID;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XA_");
    localStringBuilder.append(ApkUtils.b(BaseApplication.getContext()).replaceAll("\\.", ""));
    SCID = localStringBuilder.toString();
  }
  
  public abstract File getDownloadPath();
  
  public abstract File getInstallRoot();
  
  public abstract boolean isNoNeedDownload();
  
  public abstract void onComplete(int paramInt);
  
  public abstract void requestDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IXADownload
 * JD-Core Version:    0.7.0.1
 */