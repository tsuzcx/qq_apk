package me.weishu.epic.art.entry;

import java.util.HashMap;
import java.util.Map;

public class Entry64_2
{
  private static Map<Class<?>, String> a = new HashMap();
  
  static
  {
    Class[] arrayOfClass = new Class[8];
    Class localClass = Boolean.TYPE;
    int i = 0;
    arrayOfClass[0] = localClass;
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
        a.put(Void.TYPE, "voidBridge");
        a.put(Object.class, "referenceBridge");
        return;
      }
      localClass = arrayOfClass[i];
      Map localMap = a;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localClass.getName()));
      localStringBuilder.append("Bridge");
      localMap.put(localClass, localStringBuilder.toString());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry64_2
 * JD-Core Version:    0.7.0.1
 */