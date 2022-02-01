package com.tencent.rmonitor.property;

import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;

class PropertyMng$ConfigFlagSetter
  implements IStringPropertySetter
{
  public boolean a(String paramString)
  {
    if ("force_refresh_config".equals(paramString))
    {
      ConfigProxy.INSTANCE.getConfig().a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.ConfigFlagSetter
 * JD-Core Version:    0.7.0.1
 */