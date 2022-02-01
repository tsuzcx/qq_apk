package org.apache.commons.lang.text;

import java.util.Map;

public abstract class StrLookup
{
  private static final StrLookup NONE_LOOKUP = new StrLookup.MapStrLookup(null);
  private static final StrLookup SYSTEM_PROPERTIES_LOOKUP;
  
  static
  {
    try
    {
      localObject = new StrLookup.MapStrLookup(System.getProperties());
    }
    catch (SecurityException localSecurityException)
    {
      Object localObject;
      label25:
      break label25;
    }
    localObject = NONE_LOOKUP;
    SYSTEM_PROPERTIES_LOOKUP = (StrLookup)localObject;
  }
  
  public static StrLookup mapLookup(Map paramMap)
  {
    return new StrLookup.MapStrLookup(paramMap);
  }
  
  public static StrLookup noneLookup()
  {
    return NONE_LOOKUP;
  }
  
  public static StrLookup systemPropertiesLookup()
  {
    return SYSTEM_PROPERTIES_LOOKUP;
  }
  
  public abstract String lookup(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrLookup
 * JD-Core Version:    0.7.0.1
 */