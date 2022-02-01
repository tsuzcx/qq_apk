package me.weishu.epic.art.entry;

import java.util.HashMap;
import java.util.Map;

public class Entry
{
  private static final Object[] a;
  private static Map<Class<?>, String> b;
  
  static
  {
    int i = 0;
    a = new Object[0];
    b = new HashMap();
    Class[] arrayOfClass = new Class[8];
    arrayOfClass[0] = Boolean.TYPE;
    arrayOfClass[1] = Byte.TYPE;
    arrayOfClass[2] = Character.TYPE;
    arrayOfClass[3] = Short.TYPE;
    arrayOfClass[4] = Integer.TYPE;
    arrayOfClass[5] = Long.TYPE;
    arrayOfClass[6] = Float.TYPE;
    arrayOfClass[7] = Double.TYPE;
    int j = arrayOfClass.length;
    for (;;)
    {
      if (i >= j)
      {
        b.put(Object.class, "referenceBridge");
        b.put(Void.TYPE, "voidBridge");
        return;
      }
      Class localClass = arrayOfClass[i];
      Map localMap = b;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localClass.getName()));
      localStringBuilder.append("Bridge");
      localMap.put(localClass, localStringBuilder.toString());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry
 * JD-Core Version:    0.7.0.1
 */