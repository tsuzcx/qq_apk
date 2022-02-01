package com.tencent.mobileqq.pic;

import android.support.annotation.NonNull;
import java.util.concurrent.atomic.AtomicInteger;

public class PicPreDownloaderCore$PicPreDownRunner
  implements Runnable
{
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  
  PicPreDownloaderCore$PicPreDownRunner(PicPreDownloaderCore paramPicPreDownloaderCore, Runnable paramRunnable, String paramString)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaLangRunnable.run();
    PicPreDownloaderCore.a(this.this$0).decrementAndGet();
    PicPreDownloaderCore.a(this.this$0);
  }
  
  @NonNull
  public String toString()
  {
    return "PicPreDownloader ," + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore.PicPreDownRunner
 * JD-Core Version:    0.7.0.1
 */