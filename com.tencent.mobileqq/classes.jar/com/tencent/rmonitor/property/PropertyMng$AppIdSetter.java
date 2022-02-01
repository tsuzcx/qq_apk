package com.tencent.rmonitor.property;

import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.jvm.JvmStatic;

class PropertyMng$AppIdSetter
  implements IStringPropertySetter
{
  @JvmStatic
  private void b(String paramString)
  {
    BaseInfo.userMeta.appKey = paramString;
  }
  
  private void c(String paramString)
  {
    BaseInfo.userMeta.appId = paramString;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      paramString = paramString.split("-");
      if (paramString.length >= 2)
      {
        b(paramString[0]);
        c(paramString[1]);
        return true;
      }
    }
    catch (Throwable paramString)
    {
      Logger.b.a("PropertyMng", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.AppIdSetter
 * JD-Core Version:    0.7.0.1
 */