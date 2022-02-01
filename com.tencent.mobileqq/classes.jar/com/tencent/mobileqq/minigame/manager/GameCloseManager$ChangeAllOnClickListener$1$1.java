package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import java.util.ArrayList;

class GameCloseManager$ChangeAllOnClickListener$1$1
  implements Runnable
{
  GameCloseManager$ChangeAllOnClickListener$1$1(GameCloseManager.ChangeAllOnClickListener.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      Object localObject1 = (GameCloseManager.MiniAppViewItem)GameCloseManager.access$600().get(i);
      Object localObject2 = (MiniAppInfo)this.val$recommendApps.get(i);
      if ((localObject1 != null) && (localObject2 != null))
      {
        ((GameCloseManager.MiniAppViewItem)localObject1).setData((MiniAppInfo)localObject2, new GameCloseManager.ChangeAllOnClickListener.1.1.1(this, (MiniAppInfo)localObject2));
        localObject1 = new MiniAppConfig((MiniAppInfo)localObject2);
        localObject2 = new LaunchParam();
        ((LaunchParam)localObject2).scene = 2113;
        ((MiniAppConfig)localObject1).launchParam = ((LaunchParam)localObject2);
        MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject1, "page_view", "expo", "", "");
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.ChangeAllOnClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */