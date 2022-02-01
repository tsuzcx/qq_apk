package com.tencent.rmonitor.property;

import com.tencent.rmonitor.common.logger.Logger;

class PropertyMng$LoggerPropertySetter
  implements IPropertySetter, IStringPropertySetter
{
  public boolean a(Object paramObject)
  {
    try
    {
      Logger.b.a(((Integer)paramObject).intValue());
      return true;
    }
    catch (Throwable paramObject)
    {
      Logger.b.a("PropertyMng", paramObject);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Logger.b.a(Integer.parseInt(paramString));
      return true;
    }
    catch (Throwable paramString)
    {
      Logger.b.a("PropertyMng", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.property.PropertyMng.LoggerPropertySetter
 * JD-Core Version:    0.7.0.1
 */