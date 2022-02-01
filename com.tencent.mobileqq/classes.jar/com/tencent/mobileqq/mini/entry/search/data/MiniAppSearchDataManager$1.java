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
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("sendHotSearchAppRequest, retCode = ");
      localStringBuilder2.append(l);
      localStringBuilder2.append(", errMsg = ");
      localStringBuilder2.append((String)localObject1);
      QLog.d("MiniAppSearchDataManager", 1, localStringBuilder2.toString());
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("sendHotSearchAppRequest, isSuccess = ");
    localStringBuilder1.append(paramBoolean);
    localStringBuilder1.append(", ret = ");
    localStringBuilder1.append(???);
    QLog.e("MiniAppSearchDataManager", 1, localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.1
 * JD-Core Version:    0.7.0.1
 */