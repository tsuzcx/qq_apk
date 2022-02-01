package com.tencent.mobileqq.mini.entry.search.data;

import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StGetGuessYouLikeRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppSearchDataManager$3
  implements MiniAppCmdInterface
{
  MiniAppSearchDataManager$3(MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      QLog.d("MiniAppSearchDataManager", 1, "sendGuessYouLikeRequest, retCode = " + l + ", errMsg = " + str);
      if (l != 0L) {}
      do
      {
        return;
        paramJSONObject = (STORE_APP_CLIENT.StGetGuessYouLikeRsp)paramJSONObject.opt("searchGuessYouLikeResponse");
      } while (paramJSONObject == null);
      MiniAppSearchDataManager.access$700(this.this$0, paramJSONObject.appList.get());
      return;
    }
    QLog.e("MiniAppSearchDataManager", 1, "sendGuessYouLikeRequest, isSuccess = " + paramBoolean + ", ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.3
 * JD-Core Version:    0.7.0.1
 */