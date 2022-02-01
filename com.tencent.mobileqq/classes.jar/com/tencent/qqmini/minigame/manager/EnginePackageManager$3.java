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
    Object localObject1 = FileUtils.getFiles(EnginePackageManager.access$400(), false, 0);
    if (localObject1 == null) {
      return;
    }
    Version localVersion = EnginePackageManager.access$500();
    Object localObject2 = GameLog.getInstance();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("deleteOldVersionTritonEngine local:");
    ((StringBuilder)localObject3).append(localVersion);
    ((GameLog)localObject2).i("GameEnvManager[MiniEng]", ((StringBuilder)localObject3).toString());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileInfo)((Iterator)localObject1).next();
      if (((FileInfo)localObject2).isDirectory())
      {
        localObject3 = EnginePackageManager.access$600((FileInfo)localObject2);
        if (localVersion.compareTo((Version)localObject3) >= 0)
        {
          GameLog localGameLog = GameLog.getInstance();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("deleteOldVersionTritonEngine delete:");
          localStringBuilder.append(localObject3);
          localGameLog.i("GameEnvManager[MiniEng]", localStringBuilder.toString());
          FileUtils.deleteFile(((FileInfo)localObject2).getPath());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.EnginePackageManager.3
 * JD-Core Version:    0.7.0.1
 */