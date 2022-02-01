package com.tencent.rmonitor.property;

import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.IConfigUpdater;

class PropertyMng$ConfigUpdaterSetter
  implements IPropertyUpdater
{
  public boolean a(Object paramObject)
  {
    if ((paramObject instanceof IConfigUpdater))
    {
      ConfigProxy.INSTANCE.getConfig().a((IConfigUpdater)paramObject);
      return true;
    }
    return false;
  }
  
  public boolean b(Object paramObject)
  {
    if ((paramObject instanceof IConfigUpdater))
    {
      ConfigProxy.INSTANCE.getConfig().b((IConfigUpdater)paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.ConfigUpdaterSetter
 * JD-Core Version:    0.7.0.1
 */