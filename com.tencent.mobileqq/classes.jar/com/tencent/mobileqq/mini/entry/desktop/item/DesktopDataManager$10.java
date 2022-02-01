package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DesktopDataManager$10
  implements Runnable
{
  DesktopDataManager$10(DesktopDataManager paramDesktopDataManager, INTERFACE.StModuleInfo paramStModuleInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.val$moduleInfo != null) && (this.val$moduleInfo.useOld.get() == 1)) {
          return;
        }
        if ((this.val$moduleInfo != null) && (DesktopDataManager.access$1600(this.this$0) != null) && (this.val$moduleInfo.useOld.get() == 0) && (this.val$moduleInfo.userAppList.get() != null) && (this.val$moduleInfo.userAppList.get().size() > 0))
        {
          Object localObject1 = new DesktopAppModuleInfo(this.val$moduleInfo.moduleType.get(), this.val$moduleInfo.title.get());
          if (((DesktopAppModuleInfo)localObject1).getModuleType() == 2) {
            DesktopDataManager.access$1700(this.this$0).clear();
          }
          localArrayList = new ArrayList();
          Object localObject2 = this.val$moduleInfo.userAppList.get().iterator();
          boolean bool = ((Iterator)localObject2).hasNext();
          i = 0;
          if (bool)
          {
            Object localObject3 = (INTERFACE.StUserAppInfo)((Iterator)localObject2).next();
            localObject3 = new DesktopAppInfo(this.val$moduleInfo.moduleType.get(), MiniAppInfo.from((INTERFACE.StUserAppInfo)localObject3));
            if ((((DesktopAppModuleInfo)localObject1).getModuleType() == 2) && (((DesktopAppInfo)localObject3).mMiniAppInfo != null))
            {
              RecommendAppInfo localRecommendAppInfo = new RecommendAppInfo(((DesktopAppInfo)localObject3).mMiniAppInfo.appId, 0, System.currentTimeMillis());
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("updateModuleInfo add ");
              localStringBuilder.append(localRecommendAppInfo.toString());
              QLog.d("DesktopDataManager-Recommend", 2, localStringBuilder.toString());
              DesktopDataManager.access$1700(this.this$0).add(localRecommendAppInfo);
            }
            localArrayList.add(localObject3);
            continue;
          }
          if (i >= DesktopDataManager.access$1600(this.this$0).size()) {
            break label650;
          }
          localObject1 = (DesktopItemInfo)DesktopDataManager.access$1600(this.this$0).get(i);
          if ((!(localObject1 instanceof DesktopAppInfo)) || (((DesktopItemInfo)localObject1).mModuleType != this.val$moduleInfo.moduleType.get())) {
            break label643;
          }
          localObject1 = (DesktopAppInfo)localObject1;
          if ((((DesktopAppInfo)localObject1).mMiniAppInfo == null) || (((DesktopAppInfo)localObject1).mMiniAppInfo.isSpecialMiniApp())) {
            break label643;
          }
          localObject1 = DesktopDataManager.access$1600(this.this$0).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (DesktopItemInfo)((Iterator)localObject1).next();
            if ((!(localObject2 instanceof DesktopAppInfo)) || (((DesktopItemInfo)localObject2).mModuleType != this.val$moduleInfo.moduleType.get())) {
              continue;
            }
            localObject2 = (DesktopAppInfo)localObject2;
            if ((((DesktopAppInfo)localObject2).mMiniAppInfo == null) || (((DesktopAppInfo)localObject2).mMiniAppInfo.isSpecialMiniApp())) {
              continue;
            }
            ((Iterator)localObject1).remove();
            continue;
          }
          if ((i != -1) && (localArrayList.size() > 0)) {
            DesktopDataManager.access$1600(this.this$0).addAll(i, localArrayList);
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateModuleInfo, recommend list: ");
          ((StringBuilder)localObject1).append(localArrayList.toString());
          QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject1).toString());
        }
        DesktopDataManager.access$1800(this.this$0);
        DesktopDataManager.access$1900(DesktopDataManager.access$1600(this.this$0));
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(DesktopDataManager.access$1600(this.this$0));
        DesktopDataManager.access$2000(this.this$0, localArrayList);
        if (DesktopDataManager.access$1500(this.this$0) != null)
        {
          DesktopDataManager.access$1500(this.this$0).onDataChanged();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DesktopDataManager-Recommend", 2, "updateModuleInfo error!!!", localThrowable);
      }
      return;
      label643:
      i += 1;
      continue;
      label650:
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.10
 * JD-Core Version:    0.7.0.1
 */