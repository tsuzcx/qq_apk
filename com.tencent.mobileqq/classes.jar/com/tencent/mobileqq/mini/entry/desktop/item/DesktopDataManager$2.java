package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$2
  implements Runnable
{
  DesktopDataManager$2(DesktopDataManager paramDesktopDataManager, COMM.StCommonExt paramStCommonExt, ArrayList paramArrayList, GetAppListV2Scene paramGetAppListV2Scene) {}
  
  public void run()
  {
    Object localObject;
    if (!DesktopDataManager.access$100(this.this$0, this.val$extInfo))
    {
      localObject = MiniAppUtils.getSpDesktopGdtCookie();
      COMM.Entry localEntry = new COMM.Entry();
      localEntry.key.set("gdt_cookie");
      localEntry.value.set((String)localObject);
      this.val$extInfo.mapInfo.get().add(localEntry);
    }
    if (this.val$recommendAppList.isEmpty()) {
      this.val$recommendAppList.addAll(this.this$0.parseRecommendExposureFromSp());
    }
    if (StudyModeManager.h())
    {
      localObject = new COMM.Entry();
      ((COMM.Entry)localObject).key.set("teenager");
      ((COMM.Entry)localObject).value.set(String.valueOf(1));
      this.val$extInfo.mapInfo.get().add(localObject);
      QLog.d("DesktopDataManager", 1, "study mode is true");
    }
    DesktopDataManager.access$200(this.this$0, this.val$extInfo, this.val$recommendAppList, new ArrayList(), this.val$scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.2
 * JD-Core Version:    0.7.0.1
 */