package org.apache.commons.lang;

import java.util.HashMap;
import java.util.Map;

class Entities$PrimitiveEntityMap
  implements Entities.EntityMap
{
  private final Map mapNameToValue = new HashMap();
  private final IntHashMap mapValueToName = new IntHashMap();
  
  public void add(String paramString, int paramInt)
  {
    this.mapNameToValue.put(paramString, new Integer(paramInt));
    this.mapValueToName.put(paramInt, paramString);
  }
  
  public String name(int paramInt)
  {
    return (String)this.mapValueToName.get(paramInt);
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
 * Qualified Name:     org.apache.commons.lang.Entities.PrimitiveEntityMap
 * JD-Core Version:    0.7.0.1
 */