package com.tencent.mobileqq.shortvideo.hwcodec;

import java.util.concurrent.atomic.AtomicReference;

public class SVHwAutoSegmentMgr
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  public AtomicReference<SVHwEncoder> a;
  private long b = 0L;
  
  public SVHwAutoSegmentMgr()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramLong;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    if (((this.b - this.jdField_a_of_type_Long) / HwEnvData.jdField_a_of_type_Int == this.jdField_a_of_type_Int + 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null))
    {
      float f = (float)(paramLong2 * 1000.0D / paramLong1);
      ((SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).a(f, -1);
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwAutoSegmentMgr
 * JD-Core Version:    0.7.0.1
 */