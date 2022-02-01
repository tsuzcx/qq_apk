package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.util.Log;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

class DesktopDataManager$16
  implements Runnable
{
  DesktopDataManager$16(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    try
    {
      localObject1 = QzoneConfig.getInstance().getConfig("qqminiapp", "dropDownDefaultRecomendApps", "[{\"appId\":\"1108291530\",\"appName\":\"游戏中心\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/78bccc3685c866d1b1e3ba5a43f77b88_200.jpg\",\"type\":3},{\"appId\":\"1108805017\",\"appName\":\"世界争霸\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/4be819263a88be6a827855456bc32c50_200.jpg\",\"type\":3},{\"appId\":\"1109508198\",\"appName\":\"胡莱三国\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/91628b538edf7291c30c2d81814a9e79_200.jpg\",\"type\":3},{\"appId\":\"1109836759\",\"appName\":\"火柴人神射手\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/6ba3fba6b84d3e940da0822c32a4f630_200.jpg\",\"type\":3},{\"appId\":\"1109694952\",\"appName\":\"天天电音\",\"icon\":\"https://miniapp.gtimg.cn/public/appicon/9adccd998e1d81772fb7db6b80e2e6f2_200.jpg\",\"type\":3}]");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new DesktopAppModuleInfo(2, "好友在玩"));
      localObject1 = new JSONArray((String)localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        localObject2 = MiniAppInfo.from((INTERFACE.StApiAppInfo)INTERFACE.StApiAppInfo.class.cast(GdtJsonPbUtil.a(new INTERFACE.StApiAppInfo(), localObject2)));
        DesktopAppInfo localDesktopAppInfo = new DesktopAppInfo(2, (MiniAppInfo)localObject2);
        ((DesktopAppInfo)localDesktopAppInfo).fromBackup = 1;
        localArrayList.add(localDesktopAppInfo);
        localStringBuilder.append(((MiniAppInfo)localObject2).name);
        localStringBuilder.append(", ");
        i += 1;
      }
      if (localArrayList.size() > 0) {
        this.this$0.runOnMainThread(new DesktopDataManager.16.1(this, localArrayList, localStringBuilder));
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("useLocalDataIfRequestFailed, backupList size: ");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("useLocalDataIfRequestFailed, exception: ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(localException));
      QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.16
 * JD-Core Version:    0.7.0.1
 */