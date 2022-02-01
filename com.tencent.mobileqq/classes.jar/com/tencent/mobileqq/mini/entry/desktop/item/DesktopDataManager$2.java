package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;

class DesktopDataManager$2
  implements Runnable
{
  DesktopDataManager$2(DesktopDataManager paramDesktopDataManager, COMM.StCommonExt paramStCommonExt, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (!DesktopDataManager.access$100(this.this$0, this.val$extInfo))
    {
      String str = MiniAppUtils.getSpDesktopGdtCookie();
      COMM.Entry localEntry = new COMM.Entry();
      localEntry.key.set("gdt_cookie");
      localEntry.value.set(str);
      this.val$extInfo.mapInfo.get().add(localEntry);
    }
    if (this.val$recommendAppList.isEmpty()) {
      this.val$recommendAppList.addAll(this.this$0.parseRecommendExposureFromSp());
    }
    DesktopDataManager.access$200(this.this$0, this.val$extInfo, this.val$recommendAppList, new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.2
 * JD-Core Version:    0.7.0.1
 */