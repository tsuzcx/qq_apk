package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.AppConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class TroopFileTransferManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Thread.sleep(3000L);
      Object localObject = new File(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
      if (!((File)localObject).isDirectory()) {
        return;
      }
      localObject = ((File)localObject).listFiles(new TroopFileTransferManager.1.1(this));
      if (localObject == null) {
        return;
      }
      if (localObject.length < 100) {
        return;
      }
      ArrayList localArrayList = new ArrayList(localObject.length);
      int k = localObject.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        localArrayList.add(Long.valueOf(localObject[i].lastModified()));
        i += 1;
      }
      Collections.sort(localArrayList);
      long l = ((Long)localArrayList.get(localArrayList.size() - 100)).longValue();
      k = localObject.length;
      i = j;
      while (i < k)
      {
        localArrayList = localObject[i];
        if (localArrayList.lastModified() < l) {
          localArrayList.deleteOnExit();
        }
        i += 1;
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.1
 * JD-Core Version:    0.7.0.1
 */