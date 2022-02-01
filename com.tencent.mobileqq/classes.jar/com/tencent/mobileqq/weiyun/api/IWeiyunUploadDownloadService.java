package com.tencent.mobileqq.weiyun.api;

import android.app.Application;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;

@QAPI(process={"all"})
public abstract interface IWeiyunUploadDownloadService
  extends QRouteApi
{
  public static final String MODULE_NAME = "Module_WeiyunDownloadService";
  
  public abstract DownloadFile createDownloadFile(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5);
  
  public abstract UploadFile createUploadFile(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt);
  
  public abstract UploadFile createUploadFile4Backup(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt);
  
  public abstract String download(DownloadFile paramDownloadFile, String paramString, boolean paramBoolean, IDownloadStatusListener paramIDownloadStatusListener);
  
  public abstract void downloadImage(String paramString1, String paramString2, String paramString3, IDownloadListener paramIDownloadListener);
  
  public abstract String downloadShare(String paramString1, String paramString2, String paramString3, String paramString4, IDownloadStatusListener paramIDownloadStatusListener);
  
  public abstract QIPCModule getIPCModule();
  
  public abstract String getWeiyunMiniappProcessName();
  
  public abstract void initTransmission(Application paramApplication, boolean paramBoolean);
  
  public abstract void onLoginOrLogout(boolean paramBoolean, long paramLong);
  
  public abstract boolean removeJob(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
 * JD-Core Version:    0.7.0.1
 */