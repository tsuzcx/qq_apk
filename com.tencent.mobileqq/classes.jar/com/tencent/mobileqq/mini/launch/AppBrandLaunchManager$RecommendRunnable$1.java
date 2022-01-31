package com.tencent.mobileqq.mini.launch;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetRecommendAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class AppBrandLaunchManager$RecommendRunnable$1
  implements MiniAppCmdInterface
{
  AppBrandLaunchManager$RecommendRunnable$1(AppBrandLaunchManager.RecommendRunnable paramRecommendRunnable) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramJSONObject != null)
    {
      long l = paramJSONObject.optLong("retCode");
      localObject1 = paramJSONObject.optString("errMsg");
      QLog.e("DesktopDataManager-Recommend", 1, "getRecommendAppList, retCode = " + l + ", errMsg = " + (String)localObject1);
    }
    if ((paramBoolean) && (paramJSONObject != null))
    {
      AppBrandLaunchManager.access$800(this.this$1.this$0).remove(AppBrandLaunchManager.RecommendRunnable.access$700(this.this$1));
      QLog.e("DesktopDataManager-Recommend", 1, "getRecommendAppList suc : " + paramJSONObject.toString());
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface)) {
        ((DesktopDataManager)((AppRuntime)localObject1).getManager(336)).clearRecommendExposureList();
      }
      paramJSONObject = (INTERFACE.StGetRecommendAppListRsp)paramJSONObject.opt("response");
      if (paramJSONObject != null)
      {
        Object localObject2 = paramJSONObject.recommendModule.get();
        localObject1 = MiniAppUtils.getAppInterface();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            INTERFACE.StModuleInfo localStModuleInfo = (INTERFACE.StModuleInfo)((Iterator)localObject2).next();
            if (localObject1 != null) {
              ((DesktopDataManager)((AppInterface)localObject1).getManager(336)).updateModuleInfo(localStModuleInfo);
            }
          }
        }
        MiniAppUtils.saveGdtCookie((COMM.StCommonExt)paramJSONObject.extInfo.get());
        return;
      }
      QLog.e("DesktopDataManager-Recommend", 1, "getRecommendAppList recommendModuleInfos is null.");
      return;
    }
    QLog.e("DesktopDataManager-Recommend", 1, "getRecommendAppList fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.RecommendRunnable.1
 * JD-Core Version:    0.7.0.1
 */