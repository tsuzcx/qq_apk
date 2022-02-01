package cooperation.ilive.lite.service;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class IliveMsfChannelServiceBuilder
  implements ThreadCenter.HandlerKeyable, BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new IliveMsfChannelService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveMsfChannelServiceBuilder
 * JD-Core Version:    0.7.0.1
 */