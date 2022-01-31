package com.tencent.mobileqq.javahook;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class AsyncTaskMonitor
{
  private static Map jdField_a_of_type_JavaUtilMap;
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static Set b = new HashSet();
  
  static
  {
    try
    {
      Class localClass1 = Class.forName("com.tencent.image.NativeGifImage$NativeDecodeFrameTask");
      Class localClass2 = Class.forName("com.tencent.image.NativeGifIndex8$NativeDecodeFrameTask");
      Class localClass3 = Class.forName("com.tencent.mobileqq.vas.PendantInfo$DecodeNextFrameTask");
      b.add(localClass1);
      b.add(localClass2);
      b.add(localClass3);
      jdField_a_of_type_JavaUtilMap = new WeakHashMap();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.AsyncTaskMonitor
 * JD-Core Version:    0.7.0.1
 */