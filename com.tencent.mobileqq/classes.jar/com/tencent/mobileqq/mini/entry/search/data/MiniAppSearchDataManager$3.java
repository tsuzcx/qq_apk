package com.tencent.mobileqq.mini.entry.search.data;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_SEARCH.MiniAppSearch.StSearchAppRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppSearchDataManager$3
  implements MiniAppCmdInterface
{
  MiniAppSearchDataManager$3(MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject arg2)
  {
    boolean bool = true;
    Object localObject1;
    if ((paramBoolean) && (??? != null))
    {
      long l = ???.optLong("retCode");
      localObject1 = ???.optString("errMsg");
      QLog.d("MiniAppSearchDataManager", 1, "loadMoreSearchAppRequest, retCode = " + l + ", errMsg = " + (String)localObject1);
      if (l != 0L) {
        return;
      }
      localObject1 = (MiniAppSearch.StSearchAppRsp)???.opt("searchAppResponse");
      if (localObject1 != null) {
        MiniAppSearchDataManager.access$600(this.this$0, ((MiniAppSearch.StSearchAppRsp)localObject1).appList.get());
      }
    }
    for (;;)
    {
      synchronized (MiniAppSearchDataManager.access$200(this.this$0))
      {
        MiniAppSearchDataManager localMiniAppSearchDataManager = this.this$0;
        if (((MiniAppSearch.StSearchAppRsp)localObject1).isFinished.get() == 1)
        {
          paramBoolean = bool;
          MiniAppSearchDataManager.access$302(localMiniAppSearchDataManager, paramBoolean);
          MiniAppSearchDataManager.access$402(this.this$0, (COMM.StCommonExt)((MiniAppSearch.StSearchAppRsp)localObject1).extInfo.get());
          synchronized (MiniAppSearchDataManager.access$200(this.this$0))
          {
            MiniAppSearchDataManager.access$502(this.this$0, false);
            return;
          }
        }
        paramBoolean = false;
      }
      QLog.e("MiniAppSearchDataManager", 1, "loadMoreSearchAppRequest, isSuccess = " + paramBoolean + ", ret = " + ???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.3
 * JD-Core Version:    0.7.0.1
 */