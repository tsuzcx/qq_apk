package com.tencent.rmonitor.property;

import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;

class PropertyMng$DeviceIdSetter
  implements IStringPropertySetter
{
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      BaseInfo.userMeta.deviceId = paramString;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.DeviceIdSetter
 * JD-Core Version:    0.7.0.1
 */