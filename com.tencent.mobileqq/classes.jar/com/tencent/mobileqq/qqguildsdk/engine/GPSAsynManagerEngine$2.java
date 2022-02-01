package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetGProUserCallback;
import java.util.Iterator;
import java.util.List;

class GPSAsynManagerEngine$2
  implements IGetGProUserCallback
{
  GPSAsynManagerEngine$2(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, IGetUserInfoCallback paramIGetUserInfoCallback, List paramList1, List paramList2) {}
  
  public void a(int paramInt, String paramString, List<GProUserInfo> paramList, List<String> paramList1)
  {
    if (paramInt != 0)
    {
      paramList = new StringBuilder();
      paramList.append("guildId : ");
      paramList.append(this.a);
      GProLog.b("【gpro_sdk】", true, "sdk callback", "fetchSvrUserList", "gain svr user list", paramInt, paramString, paramList.toString());
      this.b.onGetUserInfo(paramInt, paramString, this.c, this.d);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramList1 = (GProUserInfo)paramList.next();
      this.c.add(paramList1);
      this.d.remove(paramList1.a());
    }
    this.b.onGetUserInfo(paramInt, paramString, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.2
 * JD-Core Version:    0.7.0.1
 */