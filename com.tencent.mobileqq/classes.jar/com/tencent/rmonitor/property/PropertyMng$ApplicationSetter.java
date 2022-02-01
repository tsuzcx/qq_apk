package com.tencent.rmonitor.property;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.rmonitor.common.logger.Logger;

class PropertyMng$ApplicationSetter
  implements IPropertySetter
{
  public boolean a(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof Application))
    {
      com.tencent.rmonitor.base.meta.BaseInfo.app = (Application)paramObject;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((paramObject == null) || (!TextUtils.equals(paramObject.getClass().getName(), "android.app.Application"))) {
      Logger.b.w(new String[] { "PropertyMng", "AppInstance is not android.app.Application." });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.ApplicationSetter
 * JD-Core Version:    0.7.0.1
 */