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
    Object localObject;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendGuessYouLikeRequest, retCode = ");
      localStringBuilder.append(l);
      localStringBuilder.append(", errMsg = ");
      localStringBuilder.append((String)localObject);
      QLog.d("MiniAppSearchDataManager", 1, localStringBuilder.toString());
      if (l != 0L) {
        return;
      }
      paramJSONObject = (STORE_APP_CLIENT.StGetGuessYouLikeRsp)paramJSONObject.opt("searchGuessYouLikeResponse");
      if (paramJSONObject != null) {
        MiniAppSearchDataManager.access$700(this.this$0, paramJSONObject.appList.get());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendGuessYouLikeRequest, isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", ret = ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.e("MiniAppSearchDataManager", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.3
 * JD-Core Version:    0.7.0.1
 */