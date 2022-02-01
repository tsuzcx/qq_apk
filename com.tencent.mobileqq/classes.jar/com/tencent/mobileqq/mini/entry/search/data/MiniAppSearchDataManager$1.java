package com.tencent.mobileqq.mini.entry.search.data;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_SEARCH.MiniAppSearch.StGetHotSearchAppsRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppSearchDataManager$1
  implements MiniAppCmdInterface
{
  MiniAppSearchDataManager$1(MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject arg2)
  {
    if ((paramBoolean) && (??? != null))
    {
      long l = ???.optLong("retCode");
      Object localObject1 = ???.optString("errMsg");
      QLog.d("MiniAppSearchDataManager", 1, "sendHotSearchAppRequest, retCode = " + l + ", errMsg = " + (String)localObject1);
      if (l != 0L) {
        return;
      }
      localObject1 = (MiniAppSearch.StGetHotSearchAppsRsp)???.opt("getHotSearchAppsResponse");
      MiniAppSearchDataManager.access$000(this.this$0, (MiniAppSearch.StGetHotSearchAppsRsp)localObject1);
      synchronized (MiniAppSearchDataManager.access$100(this.this$0))
      {
        MiniAppSearchDataManager.access$202(this.this$0, (COMM.StCommonExt)((MiniAppSearch.StGetHotSearchAppsRsp)localObject1).extInfo.get());
        return;
      }
    }
    QLog.e("MiniAppSearchDataManager", 1, "sendHotSearchAppRequest, isSuccess = " + paramBoolean + ", ret = " + ???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.1
 * JD-Core Version:    0.7.0.1
 */