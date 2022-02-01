package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;

final class RouteFactory$4
  implements IRouteIPProvider
{
  public String getBakIps()
  {
    return UploadGlobalConfig.getConfig().getPhotoBakUrl();
  }
  
  public String getHostUrl()
  {
    return null;
  }
  
  public String getOptIps()
  {
    return UploadGlobalConfig.getConfig().getMobileLogUrl();
  }
  
  public String getV6HostUrl()
  {
    return "v6.mobilelog.upqzfile.com";
  }
  
  public String getV6OptIps()
  {
    return UploadGlobalConfig.getConfig().getMobileLogUrlV6();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteFactory.4
 * JD-Core Version:    0.7.0.1
 */