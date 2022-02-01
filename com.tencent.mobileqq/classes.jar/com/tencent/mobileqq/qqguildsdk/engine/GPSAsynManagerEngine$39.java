package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.data.AppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.manager.AppChannelMgr;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchAppChnnPreInfoListCallback;
import java.util.List;

class GPSAsynManagerEngine$39
  implements IFetchAppChnnPreInfoListCallback
{
  GPSAsynManagerEngine$39(GPSAsynManagerEngine paramGPSAsynManagerEngine, List paramList1, List paramList2, String paramString) {}
  
  public void a(int paramInt, String paramString, List<AppChnnPreInfo> paramList, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reqChannelIds: ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", reqList size:");
    ((StringBuilder)localObject).append(this.b.size());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("channelIds:");
    localStringBuilder.append(paramList1);
    GProLog.b("【gpro_sdk】", false, "sdk callback", "tryRrefreshAllAppChnnPreInfoForGuest", (String)localObject, paramInt, paramString, localStringBuilder.toString());
    if (paramInt == 0)
    {
      this.d.h().a(this.c, paramList, paramList1, paramList2);
      this.d.a(52, "onAppChnnPreInfoListUpdated", this.c, paramList2, paramList3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.39
 * JD-Core Version:    0.7.0.1
 */