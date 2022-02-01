package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DesktopDataManager$5
  implements MiniAppCmdInterface
{
  DesktopDataManager$5(DesktopDataManager paramDesktopDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject arg2)
  {
    long l = 0L;
    if ((paramBoolean) && (??? != null))
    {
      l = ???.optLong("retCode");
      String str = ???.optString("errMsg");
      if (l != 0L)
      {
        ??? = new StringBuilder();
        ???.append("loadMoreMyApp, retCode = ");
        ???.append(l);
        ???.append(", errMsg = ");
        ???.append(str);
        QLog.e("DesktopDataManager", 1, ???.toString());
        return;
      }
      INTERFACE.StGetDropdownAppListRsp localStGetDropdownAppListRsp = (INTERFACE.StGetDropdownAppListRsp)???.opt("response");
      if (localStGetDropdownAppListRsp != null)
      {
        DesktopDataManager.access$1000(this.this$0, localStGetDropdownAppListRsp.modules.get());
        DesktopDataManager.access$502(this.this$0, (COMM.StCommonExt)localStGetDropdownAppListRsp.extInfo.get());
        if (localStGetDropdownAppListRsp.isFinished.get() == 1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        synchronized (DesktopDataManager.access$700())
        {
          DesktopDataManager.access$808(this.this$0);
          if ((!paramBoolean) && (DesktopDataManager.access$800(this.this$0) <= 4)) {
            this.this$0.loadMoreMyApp((COMM.StCommonExt)localStGetDropdownAppListRsp.extInfo.get());
          }
          ??? = new StringBuilder();
          ???.append("loadMoreMyApp, retCode = ");
          ???.append(l);
          ???.append(", errMsg = ");
          ???.append(str);
          ???.append(", isFinished: ");
          ???.append(paramBoolean);
          ???.append(", requestCount: ");
          ???.append(DesktopDataManager.access$800(this.this$0));
          QLog.d("DesktopDataManager", 1, ???.toString());
          return;
        }
      }
      QLog.e("DesktopDataManager", 1, "loadMoreMyApp failed, response is null.");
      return;
    }
    if (??? != null) {
      l = ???.optLong("retCode");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreMyApp, isSuccess = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ret = ");
    localStringBuilder.append(???);
    localStringBuilder.append(", retCode = ");
    localStringBuilder.append(l);
    QLog.e("DesktopDataManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.5
 * JD-Core Version:    0.7.0.1
 */