package com.tencent.mobileqq.freshnews.feed;

import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

class NearbyImgLoader$RequestLoadedImgTask
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  URL jdField_a_of_type_JavaNetURL;
  
  public NearbyImgLoader$RequestLoadedImgTask(NearbyImgLoader paramNearbyImgLoader, URL paramURL)
  {
    paramNearbyImgLoader.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_JavaNetURL = paramURL;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaNetURL != null)
    {
      Object localObject1 = new DownloadParams();
      ??? = this.jdField_a_of_type_JavaNetURL;
      ((DownloadParams)localObject1).url = ((URL)???);
      ((DownloadParams)localObject1).urlStr = ((URL)???).toString();
      String str = ((DownloadParams)localObject1).urlStr;
      ??? = new NearbyImgLoader.RequestLoadedImgTask.1(this);
      try
      {
        Object localObject5 = this.this$0.jdField_a_of_type_ComTencentMobileqqTransfileNearbyImgDownloader.loadImageFile((DownloadParams)localObject1, (URLDrawableHandler)???);
        ??? = null;
        localObject1 = ???;
        Object localObject2;
        if (((File)localObject5).exists())
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("task run. file exist, url = ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaNetURL.toString());
            QLog.d("Q.nearby.freshNews", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
          try
          {
            ImageUtil.a(((File)localObject5).getAbsolutePath(), (BitmapFactory.Options)localObject1);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            localOutOfMemoryError2.printStackTrace();
          }
          if (((BitmapFactory.Options)localObject1).outWidth > DeviceInfoUtil.i()) {
            ((BitmapFactory.Options)localObject1).inSampleSize = ((int)(DeviceInfoUtil.i() / ((BitmapFactory.Options)localObject1).outWidth));
          }
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
          try
          {
            localObject1 = ImageUtil.a(((File)localObject5).getAbsolutePath(), (BitmapFactory.Options)localObject1);
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby.freshNews", 2, "decode bitmap oom!");
            }
            localOutOfMemoryError1.printStackTrace();
            localObject2 = ???;
          }
        }
        synchronized (this.this$0.jdField_a_of_type_JavaUtilArrayList)
        {
          localObject5 = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            NearbyImgLoader.OnLoadNearbyImgsCallback localOnLoadNearbyImgsCallback = (NearbyImgLoader.OnLoadNearbyImgsCallback)((Iterator)localObject5).next();
            if (localOnLoadNearbyImgsCallback != null) {
              if (localObject2 == null)
              {
                if (this.jdField_a_of_type_Int < 3)
                {
                  this.this$0.a(new URL(str));
                  this.jdField_a_of_type_Int += 1;
                }
                else
                {
                  localOnLoadNearbyImgsCallback.a(str);
                }
              }
              else {
                localOnLoadNearbyImgsCallback.a(str, localObject2);
              }
            }
          }
        }
        this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndDecrement();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.feed.NearbyImgLoader.RequestLoadedImgTask
 * JD-Core Version:    0.7.0.1
 */