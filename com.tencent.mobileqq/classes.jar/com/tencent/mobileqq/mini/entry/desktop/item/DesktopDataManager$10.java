package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class DesktopDataManager$10
  implements MiniAppCmdInterface
{
  DesktopDataManager$10(DesktopDataManager paramDesktopDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = 0L;
    DesktopDataManager.access$2102(this.this$0, false);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      if (l != 0L)
      {
        QLog.e("DesktopDataManager", 1, "loadMoreRencentApp, retCode = " + l + ", errMsg = " + str);
        return;
      }
      paramJSONObject = (INTERFACE.StGetDropdownAppListRsp)paramJSONObject.opt("response");
      if (paramJSONObject != null)
      {
        if (paramJSONObject.modules.get() != null) {}
        for (int i = paramJSONObject.modules.get().size();; i = 0)
        {
          if (i <= 0) {
            DesktopDataManager.access$2202(this.this$0, false);
          }
          DesktopDataManager.access$2300(this.this$0, paramJSONObject.modules.get());
          DesktopDataManager.access$2402(this.this$0, (COMM.StCommonExt)paramJSONObject.extInfo.get());
          QLog.d("DesktopDataManager", 1, "loadMoreRencentApp, retCode = " + l + ", errMsg = " + str + " count = " + i);
          return;
        }
      }
      QLog.e("DesktopDataManager", 1, "loadMoreRencentApp failed, response is null.");
      return;
    }
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("retCode");
    }
    QLog.e("DesktopDataManager", 1, "loadMoreRencentApp, isSuccess = " + paramBoolean + ", ret = " + paramJSONObject + ", retCode = " + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.10
 * JD-Core Version:    0.7.0.1
 */