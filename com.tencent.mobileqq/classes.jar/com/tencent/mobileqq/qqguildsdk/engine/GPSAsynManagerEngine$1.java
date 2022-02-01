package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetGProUserCallback;
import java.util.Iterator;
import java.util.List;

class GPSAsynManagerEngine$1
  implements IGetGProUserCallback
{
  GPSAsynManagerEngine$1(GPSAsynManagerEngine paramGPSAsynManagerEngine, List paramList1, List paramList2, IGetUserInfoCallback paramIGetUserInfoCallback, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, List<GProUserInfo> paramList, List<String> paramList1)
  {
    if (paramInt == 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GProUserInfo localGProUserInfo = (GProUserInfo)paramList.next();
        this.a.add(localGProUserInfo);
        this.b.remove(localGProUserInfo.a());
      }
      if (this.b.size() == 0)
      {
        this.c.onGetUserInfo(paramInt, paramString, this.a, null);
        paramList = new StringBuilder();
        paramList.append("guildId : ");
        paramList.append(this.d);
        GProLog.a("【gpro_sdk】", false, "sdk callback", "fetchSvrUserList", " db enought", paramInt, paramString, paramList.toString());
        return;
      }
      paramList = new StringBuilder();
      paramList.append("guildId : ");
      paramList.append(this.d);
      GProLog.a("【gpro_sdk】", false, "sdk callback", "fetchSvrUserList", " db result = 0，not enought", paramInt, paramString, paramList.toString());
    }
    else
    {
      paramList = new StringBuilder();
      paramList.append("guildId : ");
      paramList.append(this.d);
      GProLog.b("【gpro_sdk】", true, "sdk callback", "fetchDBUserList", " fail", paramInt, paramString, paramList.toString());
    }
    if (this.e)
    {
      GPSAsynManagerEngine.a(this.f, this.d, this.b, this.c, this.a);
      return;
    }
    paramList = this.c;
    int i;
    if (this.a.size() > 0) {
      i = 0;
    } else {
      i = paramInt;
    }
    paramList.onGetUserInfo(i, paramString, this.a, paramList1);
    paramList = new StringBuilder();
    paramList.append("guildId : ");
    paramList.append(this.d);
    GProLog.a("【gpro_sdk】", false, "sdk callback", "fetchSvrUserList", " db not enought，and not fetch svr", paramInt, paramString, paramList.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.1
 * JD-Core Version:    0.7.0.1
 */