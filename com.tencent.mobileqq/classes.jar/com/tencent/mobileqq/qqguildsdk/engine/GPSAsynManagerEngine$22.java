package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.gprosdk.GProChannelMemberInfos;
import com.tencent.gprosdk.IGProFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.manager.AudioChannelMgr;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GPSAsynManagerEngine$22
  implements IGProFetchAudioChannelUserListCallback
{
  GPSAsynManagerEngine$22(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString1, String paramString2, IFetchAudioChannelUserListCallback paramIFetchAudioChannelUserListCallback) {}
  
  public void onGetAudioChannelUsers(int paramInt, String paramString, ArrayList<GProChannelMemberInfos> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = paramInt;
    String str = paramString;
    if (paramInt == 0)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        localObject1 = paramArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramArrayList = (GProChannelMemberInfos)((Iterator)localObject1).next();
          str = GProConvert.a(paramArrayList.getChannleId());
          if (this.a.equals(str))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("guildId:");
            ((StringBuilder)localObject1).append(this.b);
            ((StringBuilder)localObject1).append(" channelId:");
            ((StringBuilder)localObject1).append(this.a);
            ((StringBuilder)localObject1).append(" ChannelMemberMax:");
            ((StringBuilder)localObject1).append(paramArrayList.getChannelMemberMax());
            GProLog.a("【gpro_sdk】", true, ((StringBuilder)localObject1).toString());
            localArrayList.add(new ChannelMemberInfos(this.b, paramArrayList));
            if (this.d.d().f(this.a, paramArrayList.getChannelMemberMax())) {
              this.d.a(5, "fetchAudioChannelUserList", this.a);
            }
          }
        }
      }
      if (localArrayList.size() > 0)
      {
        this.d.g().a(this.b, localArrayList);
        localObject1 = this.d.g().b(this.a);
        i = paramInt;
        str = paramString;
      }
      else
      {
        i = -91;
        paramString = new StringBuilder();
        paramString.append("guildId:");
        paramString.append(this.b);
        paramString.append(" channelId:");
        paramString.append(this.a);
        paramString.append("fetchAudioChannelUserList fail. no info");
        GProLog.d("【gpro_sdk】", 1, paramString.toString());
        str = "svr no return this member info";
        localObject1 = localObject2;
      }
    }
    this.c.a(i, str, (IAudioChannelMemberInfos)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.22
 * JD-Core Version:    0.7.0.1
 */