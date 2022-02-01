package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CustomDownLoadBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    paramServiceAccessor = new CustomDownloaService();
    paramServiceAccessor.init(new CustomDownLoadBuilder.1(this));
    return paramServiceAccessor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download.CustomDownLoadBuilder
 * JD-Core Version:    0.7.0.1
 */