package com.tencent.qqperf.opt.threadpriority;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadRegulator$CpuBusyness
  extends RecyclablePool.Recyclable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  long b;
  
  public void recycle()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    super.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadRegulator.CpuBusyness
 * JD-Core Version:    0.7.0.1
 */