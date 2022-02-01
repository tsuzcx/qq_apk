package com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class KandianHostProxyBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new KandianHostProxyBuilder.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.hostproxy.KandianHostProxyBuilder
 * JD-Core Version:    0.7.0.1
 */