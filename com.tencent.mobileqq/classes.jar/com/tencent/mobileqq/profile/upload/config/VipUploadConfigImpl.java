package com.tencent.mobileqq.profile.upload.config;

import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;

public class VipUploadConfigImpl
  implements IUploadConfig
{
  private long a;
  
  public VipUploadConfigImpl(long paramLong)
  {
    this.a = paramLong;
  }
  
  public boolean canHoldSystemLock()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "canHoldSystemLock", 0) == 1;
  }
  
  public boolean enableBitmapNativeAlloc()
  {
    return false;
  }
  
  public int getAlbumMaxPhotoCount()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "AlbumMaxPhotoCount", 10000);
  }
  
  public int getAppId()
  {
    return 1000027;
  }
  
  public String getBackupIp1()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "BackupIP1");
  }
  
  public String getBackupIp2()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "BackupIP2");
  }
  
  public String getChangeRouteRetCodes()
  {
    return QzoneConfig.getInstance().getConfig("QzoneUploadSetting", "UploadChangeRouteRetCode", "104,115,11,2");
  }
  
  public int getCompressToWebpFlag()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "CompressToWebp", 0);
  }
  
  public int getConnectTimeout()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "ConnectTimeout", 20);
  }
  
  public int getCopyFileSizeThreshold()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "CopyFileSizeThreshold", 104857600);
  }
  
  public long getCurrentUin()
  {
    return this.a;
  }
  
  public int getDataTimeout()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "DataTimeout", 60);
  }
  
  public String getDescription()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "Description", null);
  }
  
  public String getDeviceInfo()
  {
    return PlatformInfor.a().b();
  }
  
  public int getDoNotFragment()
  {
    return QzoneConfig.getInstance().getConfig("WNSSettting", "ip_no_pmtu_disc", 1);
  }
  
  public String getExifTagCode(String paramString)
  {
    return null;
  }
  
  public int getGifUploadLimit(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return 0;
    case 3: 
      return QzoneConfig.getInstance().getConfig("PhotoUpload", "GifUploadLimt2G", 819200);
    case 2: 
      return QzoneConfig.getInstance().getConfig("PhotoUpload", "GifUploadLimt3G", 2097152);
    case 6: 
      return QzoneConfig.getInstance().getConfig("PhotoUpload", "GifUploadLimt4G", 5242880);
    }
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "GifUploadLimtWifi", 5242880);
  }
  
  public int getMaxConcurrentNum()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "MaxConcurrentNum", 1);
  }
  
  public int getMaxNum()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "MaxNum", 99);
  }
  
  public String getMaxSegmentSizeArray()
  {
    return null;
  }
  
  public String getMobileLogBackupIp()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "BackupIP_MobileLog");
  }
  
  public String getMobileLogUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "PhotoURL4", "mobilelog.upqzfile.com");
  }
  
  public String getNetworkUnavailableRetCodes()
  {
    return QzoneConfig.getInstance().getConfig("QzoneUploadSetting", "UploadNetworkUnavailableRetCode", "113,101,100");
  }
  
  public String getOptimumIp1()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP1");
  }
  
  public String getOptimumIp2()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP2");
  }
  
  public String getOptimumIpMobileLog()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_MobileLog");
  }
  
  public String getOtherBakUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "BackupIP_OTHERUP");
  }
  
  public String getOtherHostUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OtherURL_UP");
  }
  
  public String getOtherOptUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_OTHERUP");
  }
  
  public String getPhotoBakUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "BackupIP_PICUP");
  }
  
  public String getPhotoHostUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "PhotoURL_UP");
  }
  
  public String getPhotoOptUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_PICUP");
  }
  
  public String getPhotoUrl1()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "PhotoURL1", "qzfileup.qq.com");
  }
  
  public String getPhotoUrl2()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "PhotoURL2", "up.upqzfile.com");
  }
  
  public String getPhotoUrl3()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "PhotoURL3", "up.upqzfilebk.com");
  }
  
  public float getPictureQuality(String paramString)
  {
    return 0.0F;
  }
  
  public String getQUA3()
  {
    return QUA.a();
  }
  
  public long getRecentRouteExpire()
  {
    return 604800000L;
  }
  
  public int getResendCount()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "RetryMaxNum", 3);
  }
  
  public int getTestServer()
  {
    return 0;
  }
  
  public int getTimeoutRetryCount()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "TimeoutRetryCount", 3);
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    return new IUploadConfig.UploadImageSize(640, 1136, 100);
  }
  
  public String getUploadPort()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "UploadPort", "80,443,8080,14000");
  }
  
  public String getVideoBakUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "BackupIP_VIDEOUP");
  }
  
  public int getVideoFileRetryCount()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "VideoFileRetryCount", 3);
  }
  
  public String getVideoHostUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "VideoURL_UP");
  }
  
  public String getVideoOptUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_VIDEOUP");
  }
  
  public int getVideoPartConcurrentCount()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "VideoPartConcurrentCount", 2);
  }
  
  public int getVideoPartRetryCount()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "VideoPartRetryCount", 3);
  }
  
  public int getVideoPartSize()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "VideoPartSize", 262144);
  }
  
  public int getVideoPartSizeFor2G()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "VideoPartSizeFor2G", 65536);
  }
  
  public int getVideoPartSizeFor3G()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "VideoPartSizeFor3G", 131072);
  }
  
  public int getWifiOperator()
  {
    return QzoneConfig.getInstance().getConfig("ExtraConfig", "WifiCarrierType", 0);
  }
  
  public boolean isPictureNeedToCompress(String paramString)
  {
    return true;
  }
  
  public boolean isReleaseMode()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl
 * JD-Core Version:    0.7.0.1
 */