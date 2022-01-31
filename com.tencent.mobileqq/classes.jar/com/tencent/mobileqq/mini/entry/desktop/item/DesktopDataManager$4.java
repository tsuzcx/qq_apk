package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

final class DesktopDataManager$4
  implements Runnable
{
  DesktopDataManager$4(List paramList) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 != null)
    {
      localObject1 = ((AppInterface)localObject1).getCurrentAccountUin();
      localObject1 = BaseApplication.getContext().getSharedPreferences((String)localObject1 + "_" + "mini_app_desktop", 0);
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      Iterator localIterator = this.val$appList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        DesktopItemInfo localDesktopItemInfo = (DesktopItemInfo)localIterator.next();
        if (localDesktopItemInfo != null)
        {
          if (localDesktopItemInfo.getModuleType() == 1) {
            if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
              localLinkedHashSet.add(DesktopDataManager.access$900((DesktopAppInfo)localDesktopItemInfo, i, 1));
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localDesktopItemInfo instanceof DesktopAppModuleInfo))
            {
              localLinkedHashSet.add(DesktopDataManager.access$1000((DesktopAppModuleInfo)localDesktopItemInfo, i, 1));
              continue;
              if (localDesktopItemInfo.getModuleType() == 2)
              {
                if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
                  localLinkedHashSet.add(DesktopDataManager.access$900((DesktopAppInfo)localDesktopItemInfo, i, 2));
                } else if ((localDesktopItemInfo instanceof DesktopAppModuleInfo)) {
                  localLinkedHashSet.add(DesktopDataManager.access$1000((DesktopAppModuleInfo)localDesktopItemInfo, i, 2));
                }
              }
              else if (localDesktopItemInfo.getModuleType() == 3)
              {
                if ((localDesktopItemInfo instanceof DesktopAppInfo)) {
                  localLinkedHashSet.add(DesktopDataManager.access$900((DesktopAppInfo)localDesktopItemInfo, i, 3));
                } else if ((localDesktopItemInfo instanceof DesktopAppModuleInfo)) {
                  localLinkedHashSet.add(DesktopDataManager.access$1000((DesktopAppModuleInfo)localDesktopItemInfo, i, 3));
                }
              }
              else if (localDesktopItemInfo.getModuleType() == 0)
              {
                if ((localDesktopItemInfo instanceof DesktopSearchInfo)) {
                  localLinkedHashSet.add(DesktopDataManager.access$1100((DesktopSearchInfo)localDesktopItemInfo, i, 0));
                }
              }
              else
              {
                Object localObject2;
                if ((localDesktopItemInfo.getModuleType() == 4) && ((localDesktopItemInfo instanceof DesktopRecommendModuleInfo)))
                {
                  localObject2 = (DesktopRecommendModuleInfo)localDesktopItemInfo;
                  if ((((DesktopRecommendModuleInfo)localObject2).moduleInfo != null) && (((DesktopRecommendModuleInfo)localObject2).moduleInfo.title.get() != null)) {
                    localLinkedHashSet.add(DesktopDataManager.access$1200(((DesktopRecommendModuleInfo)localObject2).moduleInfo.title.get(), i, localDesktopItemInfo.getModuleType()));
                  }
                }
                else if ((localDesktopItemInfo.getModuleType() == 5) && ((localDesktopItemInfo instanceof DesktopFriendsPkModuleInfo)))
                {
                  localObject2 = (DesktopFriendsPkModuleInfo)localDesktopItemInfo;
                  if ((((DesktopFriendsPkModuleInfo)localObject2).moduleInfo != null) && (((DesktopFriendsPkModuleInfo)localObject2).moduleInfo.title.get() != null)) {
                    localLinkedHashSet.add(DesktopDataManager.access$1200(((DesktopFriendsPkModuleInfo)localObject2).moduleInfo.title.get(), i, localDesktopItemInfo.getModuleType()));
                  }
                }
                else if ((localDesktopItemInfo.getModuleType() == 6) && ((localDesktopItemInfo instanceof DesktopPopularModuleInfo)))
                {
                  localLinkedHashSet.add(DesktopDataManager.access$1200(((DesktopPopularModuleInfo)localDesktopItemInfo).title, i, localDesktopItemInfo.getModuleType()));
                }
                else if ((localDesktopItemInfo.getModuleType() == 7) && ((localDesktopItemInfo instanceof DesktopDittoInfo)))
                {
                  localLinkedHashSet.add(DesktopDataManager.access$1200(((DesktopDittoInfo)localDesktopItemInfo).title, i, localDesktopItemInfo.getModuleType()));
                }
              }
            }
          }
        }
      }
      ((SharedPreferences)localObject1).edit().putStringSet("key_mini_app_desktop_position_info", localLinkedHashSet).apply();
      QLog.d("DesktopDataManager", 2, "setDesktopAppPositionInfoToSp, position info: " + localLinkedHashSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.4
 * JD-Core Version:    0.7.0.1
 */