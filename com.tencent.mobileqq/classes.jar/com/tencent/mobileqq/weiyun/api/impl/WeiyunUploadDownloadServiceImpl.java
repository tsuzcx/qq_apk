package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Application;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.weiyun.TransmissionHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.sdk.download.WyDownloader;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;
import java.util.concurrent.ConcurrentHashMap;

public class WeiyunUploadDownloadServiceImpl
  implements IWeiyunUploadDownloadService
{
  private static final String TAG = "WeiyunDownloadServiceIPC";
  private static String WEIYUN_MINIAPP_PROCESS_NAME;
  private ConcurrentHashMap<String, Long> mDownloadTaskMap = new ConcurrentHashMap();
  private QIPCModule module = new WeiyunUploadDownloadServiceImpl.WeiyunDownloadServiceQIPCModule(this, "Module_WeiyunDownloadService");
  
  public DownloadFile createDownloadFile(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5)
  {
    return TransmissionHelper.a(paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, paramString5);
  }
  
  public UploadFile createUploadFile(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    return TransmissionHelper.b(paramString, paramUploadBatch, paramInt);
  }
  
  public UploadFile createUploadFile4Backup(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    return TransmissionHelper.a(paramString, paramUploadBatch, paramInt);
  }
  
  public String download(DownloadFile paramDownloadFile, String paramString, boolean paramBoolean, IDownloadStatusListener paramIDownloadStatusListener)
  {
    return WyDownloader.a().a(paramDownloadFile, paramString, paramBoolean, paramIDownloadStatusListener);
  }
  
  public void downloadImage(String paramString1, String paramString2, String paramString3, IDownloadListener paramIDownloadListener)
  {
    WyDownloader.a().a(paramString1, paramString2, paramString3, paramIDownloadListener);
  }
  
  public String downloadShare(String paramString1, String paramString2, String paramString3, String paramString4, IDownloadStatusListener paramIDownloadStatusListener)
  {
    return WyDownloader.a().a(paramString1, paramString2, paramString3, paramString4, paramIDownloadStatusListener);
  }
  
  public QIPCModule getIPCModule()
  {
    return this.module;
  }
  
  public String getWeiyunMiniappProcessName()
  {
    return WEIYUN_MINIAPP_PROCESS_NAME;
  }
  
  public void initTransmission(Application paramApplication, boolean paramBoolean)
  {
    TransmissionHelper.a(paramApplication, paramBoolean);
  }
  
  public void onLoginOrLogout(boolean paramBoolean, long paramLong)
  {
    TransmissionHelper.a(paramBoolean, paramLong);
  }
  
  public boolean removeJob(String paramString)
  {
    return WyDownloader.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunUploadDownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */