package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import java.util.Iterator;
import java.util.List;

class UniformDownloader$1
  implements Runnable
{
  UniformDownloader$1(UniformDownloader paramUniformDownloader, Bundle paramBundle, int paramInt, String paramString) {}
  
  public void run()
  {
    if (UniformDownloader.a(this.this$0, false, UniformDownloader.a(this.this$0))) {
      this.this$0.b();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.this$0));
      }
      Iterator localIterator = UniformDownloader.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)localIterator.next();
        if (localIUniformDownloaderListener != null) {
          localIUniformDownloaderListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader.1
 * JD-Core Version:    0.7.0.1
 */