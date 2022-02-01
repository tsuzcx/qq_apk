package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;

final class RouteFactory$2
  implements IRouteIPProvider
{
  public String getBakIps()
  {
    return UploadGlobalConfig.getConfig().getVideoBakUrl();
  }
  
  public String getHostUrl()
  {
    return UploadGlobalConfig.getConfig().getVideoHostUrl();
  }
  
  public String getOptIps()
  {
    return UploadGlobalConfig.getConfig().getVideoOptUrl();
  }
  
  public String getV6HostUrl()
  {
    return "v6.video.upqzfile.com";
  }
  
  public String getV6OptIps()
  {
    return UploadGlobalConfig.getConfig().getVideoOptUrlV6();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteFactory.2
 * JD-Core Version:    0.7.0.1
 */