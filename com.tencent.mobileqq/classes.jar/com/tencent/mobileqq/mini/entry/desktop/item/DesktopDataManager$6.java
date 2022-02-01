package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

final class DesktopDataManager$6
  implements Runnable
{
  DesktopDataManager$6(List paramList) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 != null)
    {
      localObject1 = ((AppInterface)localObject1).getCurrentAccountUin();
      Object localObject2 = BaseApplication.getContext();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append("mini_app_desktop");
      localObject2 = ((BaseApplication)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
      localObject1 = new LinkedHashSet();
      localObject3 = this.val$appList.iterator();
      int i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)((Iterator)localObject3).next();
        if (localDesktopItemInfo != null)
        {
          if (localDesktopItemInfo.getModuleType() == 1)
          {
            if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
              ((Set)localObject1).add(DesktopDataManager.access$1200(((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.appId, i, 1));
            } else if ((localDesktopItemInfo instanceof DesktopAppModuleInfo)) {
              ((Set)localObject1).add(DesktopDataManager.access$1300(((DesktopAppModuleInfo)localDesktopItemInfo).moduleTitle, i, 1));
            }
          }
          else if (localDesktopItemInfo.getModuleType() == 2)
          {
            if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
              ((Set)localObject1).add(DesktopDataManager.access$1200(((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.appId, i, 2));
            } else if ((localDesktopItemInfo instanceof DesktopAppModuleInfo)) {
              ((Set)localObject1).add(DesktopDataManager.access$1300(((DesktopAppModuleInfo)localDesktopItemInfo).moduleTitle, i, 2));
            }
          }
          else if (localDesktopItemInfo.getModuleType() == 3)
          {
            if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
              ((Set)localObject1).add(DesktopDataManager.access$1200(((DesktopAppInfo)localDesktopItemInfo).mMiniAppInfo.appId, i, 3));
            } else if ((localDesktopItemInfo instanceof DesktopAppModuleInfo)) {
              ((Set)localObject1).add(DesktopDataManager.access$1300(((DesktopAppModuleInfo)localDesktopItemInfo).moduleTitle, i, 3));
            }
          }
          else
          {
            if (localDesktopItemInfo.getModuleType() == 8) {
              continue;
            }
            if (localDesktopItemInfo.getModuleType() == 0)
            {
              if ((localDesktopItemInfo instanceof DesktopSearchInfo)) {
                ((Set)localObject1).add(DesktopDataManager.access$1200(((DesktopSearchInfo)localDesktopItemInfo).mAppInfo.appId, i, 0));
              }
            }
            else
            {
              Object localObject4;
              if ((localDesktopItemInfo.getModuleType() == 4) && ((localDesktopItemInfo instanceof DesktopRecommendModuleInfo)))
              {
                localObject4 = (DesktopRecommendModuleInfo)localDesktopItemInfo;
                if ((((DesktopRecommendModuleInfo)localObject4).moduleInfo != null) && (((DesktopRecommendModuleInfo)localObject4).moduleInfo.title.get() != null)) {
                  ((Set)localObject1).add(DesktopDataManager.access$1300(((DesktopRecommendModuleInfo)localObject4).moduleInfo.title.get(), i, localDesktopItemInfo.getModuleType()));
                }
              }
              else if ((localDesktopItemInfo.getModuleType() == 5) && ((localDesktopItemInfo instanceof DesktopFriendsPkModuleInfo)))
              {
                localObject4 = (DesktopFriendsPkModuleInfo)localDesktopItemInfo;
                if ((((DesktopFriendsPkModuleInfo)localObject4).moduleInfo != null) && (((DesktopFriendsPkModuleInfo)localObject4).moduleInfo.title.get() != null)) {
                  ((Set)localObject1).add(DesktopDataManager.access$1300(((DesktopFriendsPkModuleInfo)localObject4).moduleInfo.title.get(), i, localDesktopItemInfo.getModuleType()));
                }
              }
              else if ((localDesktopItemInfo.getModuleType() == 6) && ((localDesktopItemInfo instanceof DesktopPopularModuleInfo)))
              {
                ((Set)localObject1).add(DesktopDataManager.access$1300(((DesktopPopularModuleInfo)localDesktopItemInfo).title, i, localDesktopItemInfo.getModuleType()));
              }
              else if ((localDesktopItemInfo.getModuleType() == 7) && ((localDesktopItemInfo instanceof DesktopDittoInfo)))
              {
                ((Set)localObject1).add(DesktopDataManager.access$1300(((DesktopDittoInfo)localDesktopItemInfo).title, i, localDesktopItemInfo.getModuleType()));
              }
            }
          }
          i += 1;
        }
      }
      ((SharedPreferences)localObject2).edit().putStringSet("key_mini_app_desktop_position_info", (Set)localObject1).apply();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setDesktopAppPositionInfoToSp, position info: ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("DesktopDataManager", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.6
 * JD-Core Version:    0.7.0.1
 */