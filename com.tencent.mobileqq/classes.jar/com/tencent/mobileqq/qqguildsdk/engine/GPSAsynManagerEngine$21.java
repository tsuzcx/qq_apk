package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.gprosdk.GProChannelMemberInfos;
import com.tencent.gprosdk.IGProFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.manager.AudioChannelMgr;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GPSAsynManagerEngine$21
  implements IGProFetchAudioChannelUserListCallback
{
  GPSAsynManagerEngine$21(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString) {}
  
  public void onGetAudioChannelUsers(int paramInt, String paramString, ArrayList<GProChannelMemberInfos> paramArrayList)
  {
    if (paramInt == 0)
    {
      paramString = new ArrayList();
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          GProChannelMemberInfos localGProChannelMemberInfos = (GProChannelMemberInfos)paramArrayList.next();
          String str = GProConvert.a(localGProChannelMemberInfos.getChannleId());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("guildId:");
          localStringBuilder.append(this.a);
          localStringBuilder.append(" channelId:");
          localStringBuilder.append(str);
          localStringBuilder.append(" ChannelMemberMax:");
          localStringBuilder.append(localGProChannelMemberInfos.getChannelMemberMax());
          GProLog.a("【gpro_sdk】", true, localStringBuilder.toString());
          paramString.add(new ChannelMemberInfos(this.a, localGProChannelMemberInfos));
          if (this.b.d().f(str, localGProChannelMemberInfos.getChannelMemberMax())) {
            this.b.a(5, "tryRrefreshAllAudioChannelSimpleInfo", str);
          }
        }
      }
      this.b.g().a(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.21
 * JD-Core Version:    0.7.0.1
 */