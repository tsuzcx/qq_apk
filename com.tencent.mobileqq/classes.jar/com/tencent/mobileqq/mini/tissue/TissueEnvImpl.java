package com.tencent.mobileqq.mini.tissue;

import bdgc;
import bdgd;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import cooperation.qzone.util.QZLog;
import java.util.List;

public class TissueEnvImpl
  implements bdgc
{
  private static boolean sCheckLibUpdate;
  
  public String getNativeLibDir()
  {
    if (!sCheckLibUpdate)
    {
      localObject = TissueWnsConfig.getBaseLibInfo();
      if (localObject != null) {
        EngineManager.g().installBaseLib((BaseLibInfo)localObject, null);
      }
      sCheckLibUpdate = true;
    }
    Object localObject = EngineManager.g().getEngineList(99);
    if (localObject != null)
    {
      int i = ((List)localObject).size();
      QZLog.i("Tissue", " getInstalledEngineList success " + i);
      if (i > 0)
      {
        localObject = (InstalledEngine)((List)localObject).get(0);
        QZLog.i("Tissue", "verify engine " + localObject);
        if (bdgd.a(((InstalledEngine)localObject).engineDir)) {
          return ((InstalledEngine)localObject).engineDir;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tissue.TissueEnvImpl
 * JD-Core Version:    0.7.0.1
 */