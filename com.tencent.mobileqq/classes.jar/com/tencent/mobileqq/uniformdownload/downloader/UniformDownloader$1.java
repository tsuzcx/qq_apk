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
    Object localObject = this.this$0;
    if (UniformDownloader.a((UniformDownloader)localObject, false, UniformDownloader.a((UniformDownloader)localObject)))
    {
      this.this$0.b();
      return;
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject != null) {
      ((Bundle)localObject).putBundle("_CB_USERDATA", UniformDownloader.b(this.this$0));
    }
    localObject = UniformDownloader.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)((Iterator)localObject).next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader.1
 * JD-Core Version:    0.7.0.1
 */