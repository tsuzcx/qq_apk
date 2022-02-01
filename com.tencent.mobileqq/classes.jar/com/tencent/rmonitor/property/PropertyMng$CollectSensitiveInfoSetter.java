package com.tencent.rmonitor.property;

import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;

class PropertyMng$CollectSensitiveInfoSetter
  implements IPropertySetter
{
  public boolean a(Object paramObject)
  {
    if ((paramObject instanceof Boolean))
    {
      ConfigProxy.INSTANCE.getConfig().a("CAN_COLLECT_SENSITIVE_INFO", ((Boolean)paramObject).booleanValue());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.CollectSensitiveInfoSetter
 * JD-Core Version:    0.7.0.1
 */