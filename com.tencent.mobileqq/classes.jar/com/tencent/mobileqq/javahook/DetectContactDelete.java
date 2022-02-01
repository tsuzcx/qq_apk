package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import java.util.concurrent.ConcurrentHashMap;

public class DetectContactDelete
{
  static HookMethodCallback jdField_a_of_type_ComTencentMobileqqJavahooksdkHookMethodCallback = new DetectContactDelete.1();
  private static ConcurrentHashMap<Long, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  static HookMethodCallback b = new DetectContactDelete.2();
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(Thread.currentThread().getId()), Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.DetectContactDelete
 * JD-Core Version:    0.7.0.1
 */