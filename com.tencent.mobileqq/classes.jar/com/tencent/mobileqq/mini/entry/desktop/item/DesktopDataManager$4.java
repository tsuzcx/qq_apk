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
    Object localObject;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      if (l != 0L)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("sendModuleRequest, retCode = ");
        paramJSONObject.append(l);
        paramJSONObject.append(", errMsg = ");
        paramJSONObject.append((String)localObject);
        QLog.e("DesktopDataManager", 1, paramJSONObject.toString());
        return;
      }
      paramJSONObject = (INTERFACE.StGetDropdownAppListRsp)paramJSONObject.opt("response");
      if (paramJSONObject != null) {
        DesktopDataManager.access$900(this.this$0, paramJSONObject.modules.get());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendUserAppListRequestV2, isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", ret = ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.4
 * JD-Core Version:    0.7.0.1
 */