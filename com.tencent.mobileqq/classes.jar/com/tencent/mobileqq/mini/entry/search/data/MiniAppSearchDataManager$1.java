package com.tencent.mobileqq.mini.entry.search.data;

import NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppSearchDataManager$1
  implements MiniAppCmdInterface
{
  MiniAppSearchDataManager$1(MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      QLog.d("MiniAppSearchDataManager", 1, "sendHotSearchAppRequest, retCode = " + l + ", errMsg = " + str);
      if (l != 0L) {}
      do
      {
        return;
        paramJSONObject = (MiniAppSearch.StGetHotSearchAppsRsp)paramJSONObject.opt("getHotSearchAppsResponse");
      } while (paramJSONObject == null);
      MiniAppSearchDataManager.access$000(this.this$0, paramJSONObject.appList.get(), paramJSONObject.title.get());
      return;
    }
    QLog.e("MiniAppSearchDataManager", 1, "sendHotSearchAppRequest, isSuccess = " + paramBoolean + ", ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.1
 * JD-Core Version:    0.7.0.1
 */