package org.apache.commons.lang.text;

import java.util.Map;

class StrLookup$MapStrLookup
  extends StrLookup
{
  private final Map map;
  
  StrLookup$MapStrLookup(Map paramMap)
  {
    this.map = paramMap;
  }
  
  public String lookup(String paramString)
  {
    Map localMap = this.map;
    if (localMap == null) {
      return null;
    }
    paramString = localMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrLookup.MapStrLookup
 * JD-Core Version:    0.7.0.1
 */