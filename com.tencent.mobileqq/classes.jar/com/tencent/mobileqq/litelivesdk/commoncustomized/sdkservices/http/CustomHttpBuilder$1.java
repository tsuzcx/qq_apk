package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import com.tencent.falco.base.libapi.http.HttpInterface.HttpComponentAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class CustomHttpBuilder$1
  implements HttpInterface.HttpComponentAdapter
{
  CustomHttpBuilder$1(CustomHttpBuilder paramCustomHttpBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public LogInterface getLog()
  {
    return (LogInterface)this.a.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpBuilder.1
 * JD-Core Version:    0.7.0.1
 */