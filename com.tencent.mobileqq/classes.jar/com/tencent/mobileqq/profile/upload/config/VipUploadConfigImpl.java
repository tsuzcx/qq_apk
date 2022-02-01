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
  
  public boolean enableV6Route()
  {
    return QzoneConfig.getInstance().getConfig("QzoneUploadSetting", "UploadEnableV6Route", 0) == 1;
  }
  
  public int getAppId()
  {
    return 1000027;
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
  
  public long getCurrentUin()
  {
    return this.a;
  }
  
  public int getDataTimeout()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "DataTimeout", 60);
  }
  
  public String getDeviceInfo()
  {
    return PlatformInfor.g().getDeviceInfor();
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
  
  public String getMaxSegmentSizeArray()
  {
    return null;
  }
  
  public String getMobileLogUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "PhotoURL4", "mobilelog.upqzfile.com");
  }
  
  public String getMobileLogUrlV6()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_MobileLogV6");
  }
  
  public String getNetworkUnavailableRetCodes()
  {
    return QzoneConfig.getInstance().getConfig("QzoneUploadSetting", "UploadNetworkUnavailableRetCode", "113,101,100");
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
  
  public String getOtherOptUrlV6()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_OTHERUP_V6");
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
  
  public String getPhotoOptUrlV6()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_PICUPV6");
  }
  
  public float getPictureQuality(String paramString)
  {
    return 0.0F;
  }
  
  public String getQUA3()
  {
    return QUA.getQUA3();
  }
  
  public long getRecentRouteExpire()
  {
    return 604800000L;
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
  
  public String getVideoHostUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "VideoURL_UP");
  }
  
  public String getVideoOptUrl()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_VIDEOUP");
  }
  
  public String getVideoOptUrlV6()
  {
    return QzoneConfig.getInstance().getConfig("PhotoSvrList", "OptimumIP_VIDEOUPV6");
  }
  
  public int getWifiOperator()
  {
    return QzoneConfig.getInstance().getConfig("ExtraConfig", "WifiCarrierType", 0);
  }
  
  public long getWtAppId()
  {
    return 0L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl
 * JD-Core Version:    0.7.0.1
 */