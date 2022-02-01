package com.tencent.mobileqq.transfile.predownload;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IPreDownloadController
  extends IRuntimeService
{
  public static final int BUSINESS_DEFINE_STAT = 10000;
  public static final int BUSINESS_ONLINE_STATUS_ANIMATION = 10096;
  public static final int BUSINESS_QWALLET_RES = 10069;
  
  public abstract AbsPreDownloadTask cancelPreDownload(String paramString);
  
  public abstract boolean couldDownload();
  
  public abstract String getPreDownloadPath(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract boolean isEnable();
  
  public abstract void onAppBackground();
  
  public abstract void onAppForeground();
  
  public abstract void onAppLiteStart(boolean paramBoolean);
  
  public abstract void onTaskEnd(AbsPreDownloadTask paramAbsPreDownloadTask);
  
  public abstract void preDownloadSuccess(String paramString, long paramLong);
  
  public abstract boolean requestPreDownload(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, AbsPreDownloadTask paramAbsPreDownloadTask);
  
  public abstract void startPreDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.IPreDownloadController
 * JD-Core Version:    0.7.0.1
 */