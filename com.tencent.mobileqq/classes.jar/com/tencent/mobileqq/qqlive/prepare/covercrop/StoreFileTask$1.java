package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

class StoreFileTask$1
  implements Runnable
{
  public void run()
  {
    new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks();
    Object localObject = this.this$0;
    localObject = StoreFileTask.a((StoreFileTask)localObject, StoreFileTask.a((StoreFileTask)localObject));
    ThreadManager.getUIHandler().post(new StoreFileTask.1.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.StoreFileTask.1
 * JD-Core Version:    0.7.0.1
 */