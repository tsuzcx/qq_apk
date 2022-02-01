package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import com.tencent.falco.base.libapi.http.HttpResponse;
import java.util.concurrent.atomic.AtomicLong;

public abstract class HttpCallbacker
  implements HttpResponse
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private final long jdField_a_of_type_Long = b();
  
  private static long b()
  {
    return System.currentTimeMillis() + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndAdd(1L);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.HttpCallbacker
 * JD-Core Version:    0.7.0.1
 */