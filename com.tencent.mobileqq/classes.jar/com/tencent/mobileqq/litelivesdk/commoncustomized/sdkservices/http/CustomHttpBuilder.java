package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class CustomHttpBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    CustomHttpService localCustomHttpService = new CustomHttpService();
    localCustomHttpService.init(new CustomHttpBuilder.1(this, paramServiceAccessor));
    return localCustomHttpService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpBuilder
 * JD-Core Version:    0.7.0.1
 */