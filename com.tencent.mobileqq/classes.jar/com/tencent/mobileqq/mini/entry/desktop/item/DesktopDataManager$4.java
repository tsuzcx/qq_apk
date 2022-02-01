package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DesktopDataManager$4
  implements MiniAppCmdInterface
{
  DesktopDataManager$4(DesktopDataManager paramDesktopDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      if (l != 0L) {
        QLog.e("DesktopDataManager", 1, "sendModuleRequest, retCode = " + l + ", errMsg = " + str);
      }
      do
      {
        return;
        paramJSONObject = (INTERFACE.StGetDropdownAppListRsp)paramJSONObject.opt("response");
      } while (paramJSONObject == null);
      DesktopDataManager.access$900(this.this$0, paramJSONObject.modules.get());
      return;
    }
    QLog.e("DesktopDataManager", 1, "sendUserAppListRequestV2, isSuccess = " + paramBoolean + ", ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.4
 * JD-Core Version:    0.7.0.1
 */