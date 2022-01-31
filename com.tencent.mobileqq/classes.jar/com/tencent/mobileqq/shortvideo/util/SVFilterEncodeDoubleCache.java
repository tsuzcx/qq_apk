package com.tencent.mobileqq.shortvideo.util;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

public class SVFilterEncodeDoubleCache
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SVFilterEncodeDoubleCache.SharedMemoryCache jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache = new SVFilterEncodeDoubleCache.SharedMemoryCache(0);
  private SVFilterEncodeDoubleCache.SharedMemoryCache b = new SVFilterEncodeDoubleCache.SharedMemoryCache(1);
  
  public SVFilterEncodeDoubleCache.SharedMemoryCache a()
  {
    if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache).getAndSet(1) == 0) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache;
    }
    if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.b).getAndSet(1) == 0) {
      return this.b;
    }
    return null;
  }
  
  public void a()
  {
    SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache).getAndSet(0);
    SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.b).getAndSet(0);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache).getAndAdd(0) == 0)
    {
      bool1 = bool2;
      if (SVFilterEncodeDoubleCache.SharedMemoryCache.a(this.b).getAndAdd(0) == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("SharedMemoryCacheProcessor");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      PtvFilterUtils.a(this.jdField_a_of_type_AndroidOsHandlerThread);
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache
 * JD-Core Version:    0.7.0.1
 */