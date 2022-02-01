package com.tencent.mobileqq.mini.entry.search.data;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_SEARCH.MiniAppSearch.StSearchAppRsp;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppSearchDataManager$2
  implements MiniAppCmdInterface
{
  MiniAppSearchDataManager$2(MiniAppSearchDataManager paramMiniAppSearchDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject arg2)
  {
    boolean bool = true;
    Object localObject1;
    Object localObject4;
    if ((paramBoolean) && (??? != null))
    {
      long l = ???.optLong("retCode");
      localObject1 = ???.optString("errMsg");
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("sendSearchAppRequest, retCode = ");
      ((StringBuilder)localObject4).append(l);
      ((StringBuilder)localObject4).append(", errMsg = ");
      ((StringBuilder)localObject4).append((String)localObject1);
      QLog.d("MiniAppSearchDataManager", 1, ((StringBuilder)localObject4).toString());
      if (l != 0L) {
        return;
      }
      localObject1 = (MiniAppSearch.StSearchAppRsp)???.opt("searchAppResponse");
      if (localObject1 == null) {
        break label254;
      }
      MiniAppSearchDataManager.access$300(this.this$0, ((MiniAppSearch.StSearchAppRsp)localObject1).appList.get(), ((MiniAppSearch.StSearchAppRsp)localObject1).searchExtInfo.get(), ((MiniAppSearch.StSearchAppRsp)localObject1).rcmdList.get());
    }
    for (;;)
    {
      synchronized (MiniAppSearchDataManager.access$100(this.this$0))
      {
        localObject4 = this.this$0;
        if (((MiniAppSearch.StSearchAppRsp)localObject1).isFinished.get() != 1) {
          break label283;
        }
        paramBoolean = bool;
        MiniAppSearchDataManager.access$402((MiniAppSearchDataManager)localObject4, paramBoolean);
        MiniAppSearchDataManager.access$502(this.this$0, (COMM.StCommonExt)((MiniAppSearch.StSearchAppRsp)localObject1).extInfo.get());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendSearchAppRequest, isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", ret = ");
      localStringBuilder.append(???);
      QLog.e("MiniAppSearchDataManager", 1, localStringBuilder.toString());
      label254:
      synchronized (MiniAppSearchDataManager.access$100(this.this$0))
      {
        MiniAppSearchDataManager.access$602(this.this$0, false);
        return;
      }
      label283:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.2
 * JD-Core Version:    0.7.0.1
 */