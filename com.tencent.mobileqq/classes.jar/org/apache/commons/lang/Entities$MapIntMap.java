package org.apache.commons.lang;

import java.util.Map;

abstract class Entities$MapIntMap
  implements Entities.EntityMap
{
  protected final Map mapNameToValue;
  protected final Map mapValueToName;
  
  Entities$MapIntMap(Map paramMap1, Map paramMap2)
  {
    this.mapNameToValue = paramMap1;
    this.mapValueToName = paramMap2;
  }
  
  public void add(String paramString, int paramInt)
  {
    this.mapNameToValue.put(paramString, new Integer(paramInt));
    this.mapValueToName.put(new Integer(paramInt), paramString);
  }
  
  public String name(int paramInt)
  {
    return (String)this.mapValueToName.get(new Integer(paramInt));
  }
  
  public int value(String paramString)
  {
    paramString = this.mapNameToValue.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return ((Integer)paramString).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.Entities.MapIntMap
 * JD-Core Version:    0.7.0.1
 */