package com.tencent.qqmini.minigame.manager;

import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.core.utils.FileInfo;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;

final class EnginePackageManager$3
  implements Runnable
{
  public void run()
  {
    Object localObject = FileUtils.getFiles(EnginePackageManager.access$400(), false, 0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      Version localVersion1 = EnginePackageManager.access$500();
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "deleteOldVersionTritonEngine local:" + localVersion1);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
        if (localFileInfo.isDirectory())
        {
          Version localVersion2 = EnginePackageManager.access$600(localFileInfo);
          if (localVersion1.compareTo(localVersion2) >= 0)
          {
            GameLog.getInstance().i("GameEnvManager[MiniEng]", "deleteOldVersionTritonEngine delete:" + localVersion2);
            FileUtils.deleteFile(localFileInfo.getPath());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.EnginePackageManager.3
 * JD-Core Version:    0.7.0.1
 */