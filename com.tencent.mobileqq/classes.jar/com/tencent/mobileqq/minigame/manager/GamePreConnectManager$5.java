package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import java.util.ArrayList;

final class GamePreConnectManager$5
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(GameWnsUtils.downloaderPreConnectHost());
    MiniappDownloadUtil.getInstance().preConnectHost(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager.5
 * JD-Core Version:    0.7.0.1
 */