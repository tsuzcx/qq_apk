package com.tencent.upload.uinterface;

public abstract interface IUploadConfig
{
  public abstract boolean canHoldSystemLock();
  
  public abstract boolean enableBitmapNativeAlloc();
  
  public abstract boolean enableV6Route();
  
  public abstract int getAppId();
  
  public abstract String getChangeRouteRetCodes();
  
  public abstract int getCompressToWebpFlag();
  
  public abstract int getConnectTimeout();
  
  public abstract long getCurrentUin();
  
  public abstract int getDataTimeout();
  
  public abstract String getDeviceInfo();
  
  public abstract int getDoNotFragment();
  
  public abstract String getExifTagCode(String paramString);
  
  public abstract int getGifUploadLimit(int paramInt);
  
  public abstract String getMaxSegmentSizeArray();
  
  public abstract String getMobileLogUrl();
  
  public abstract String getMobileLogUrlV6();
  
  public abstract String getNetworkUnavailableRetCodes();
  
  public abstract String getOtherBakUrl();
  
  public abstract String getOtherHostUrl();
  
  public abstract String getOtherOptUrl();
  
  public abstract String getOtherOptUrlV6();
  
  public abstract String getPhotoBakUrl();
  
  public abstract String getPhotoHostUrl();
  
  public abstract String getPhotoOptUrl();
  
  public abstract String getPhotoOptUrlV6();
  
  public abstract float getPictureQuality(String paramString);
  
  public abstract String getQUA3();
  
  public abstract long getRecentRouteExpire();
  
  public abstract int getTimeoutRetryCount();
  
  public abstract IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask);
  
  public abstract String getUploadPort();
  
  public abstract String getVideoBakUrl();
  
  public abstract String getVideoHostUrl();
  
  public abstract String getVideoOptUrl();
  
  public abstract String getVideoOptUrlV6();
  
  public abstract int getWifiOperator();
  
  public abstract boolean isPictureNeedToCompress(String paramString);
  
  public abstract boolean isReleaseMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadConfig
 * JD-Core Version:    0.7.0.1
 */