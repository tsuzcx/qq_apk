package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.model.Version;
import java.util.ArrayList;
import java.util.Iterator;

final class GameEnvManager$3
  implements Runnable
{
  public void run()
  {
    Object localObject = FileUtil.getFiles(GameEnvManager.access$300(), false, 0);
    if (localObject == null) {}
    for (;;)
    {
      return;
      Version localVersion1 = GameEnvManager.access$400();
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "deleteOldVersionTritonEngine local:" + localVersion1);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileInfo localFileInfo = (FileInfo)((Iterator)localObject).next();
        if (localFileInfo.c())
        {
          Version localVersion2 = GameEnvManager.access$500(localFileInfo);
          if ((localVersion1 != null) && (localVersion1.compareTo(localVersion2) >= 0))
          {
            GameLog.getInstance().i("GameEnvManager[MiniEng]", "deleteOldVersionTritonEngine delete:" + localVersion2);
            FileUtil.deleteFile(localFileInfo.c());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameEnvManager.3
 * JD-Core Version:    0.7.0.1
 */