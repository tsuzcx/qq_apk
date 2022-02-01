package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class DesktopDataManager$14
  implements MiniAppCmdInterface
{
  DesktopDataManager$14(DesktopDataManager paramDesktopDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    DesktopDataManager.access$2402(this.this$0, false);
    long l = 0L;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      if (l != 0L)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("loadMoreRencentApp, retCode = ");
        paramJSONObject.append(l);
        paramJSONObject.append(", errMsg = ");
        paramJSONObject.append((String)localObject);
        QLog.e("DesktopDataManager", 1, paramJSONObject.toString());
        return;
      }
      paramJSONObject = (INTERFACE.StGetDropdownAppListRsp)paramJSONObject.opt("response");
      if (paramJSONObject != null)
      {
        int i;
        if (paramJSONObject.modules.get() != null) {
          i = paramJSONObject.modules.get().size();
        } else {
          i = 0;
        }
        if (i <= 0) {
          DesktopDataManager.access$2502(this.this$0, false);
        }
        DesktopDataManager.access$2600(this.this$0, paramJSONObject.modules.get());
        DesktopDataManager.access$2702(this.this$0, (COMM.StCommonExt)paramJSONObject.extInfo.get());
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("loadMoreRencentApp, retCode = ");
        paramJSONObject.append(l);
        paramJSONObject.append(", errMsg = ");
        paramJSONObject.append((String)localObject);
        paramJSONObject.append(" count = ");
        paramJSONObject.append(i);
        QLog.d("DesktopDataManager", 1, paramJSONObject.toString());
        return;
      }
      QLog.e("DesktopDataManager", 1, "loadMoreRencentApp failed, response is null.");
      return;
    }
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("retCode");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadMoreRencentApp, isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ret = ");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(", retCode = ");
    ((StringBuilder)localObject).append(l);
    QLog.e("DesktopDataManager", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.14
 * JD-Core Version:    0.7.0.1
 */