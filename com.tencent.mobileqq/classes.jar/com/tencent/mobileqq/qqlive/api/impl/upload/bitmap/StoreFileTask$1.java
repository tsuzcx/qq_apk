package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

class StoreFileTask$1
  implements Runnable
{
  StoreFileTask$1(StoreFileTask paramStoreFileTask, StoreFileTask.OnStorePhotoCallback paramOnStorePhotoCallback) {}
  
  public void run()
  {
    Object localObject;
    if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1)
    {
      localObject = "sdcardfull";
    }
    else
    {
      localObject = this.this$0;
      localObject = StoreFileTask.access$100((StoreFileTask)localObject, StoreFileTask.access$000((StoreFileTask)localObject));
    }
    ThreadManager.getUIHandler().post(new StoreFileTask.1.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask.1
 * JD-Core Version:    0.7.0.1
 */