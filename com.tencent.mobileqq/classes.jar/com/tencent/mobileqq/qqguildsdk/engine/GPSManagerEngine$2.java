package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import com.tencent.mobileqq.qqguildsdk.manager.ChannelListMgr;
import com.tencent.mobileqq.qqguildsdk.manager.GuildListMgr;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadGuildAndChnListCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class GPSManagerEngine$2
  implements ILoadGuildAndChnListCallback
{
  GPSManagerEngine$2(GPSManagerEngine paramGPSManagerEngine) {}
  
  public void a(byte[] paramArrayOfByte, ArrayList<GProGuildInfo> paramArrayList, HashMap<String, GuildInitInfo> paramHashMap, List<GuildMsgNode> paramList)
  {
    this.a.b().a(paramArrayOfByte);
    this.a.b().a(paramArrayList);
    this.a.d().a(paramHashMap);
    if (paramList != null) {
      GPSManagerEngine.a(this.a, paramList);
    }
    paramArrayOfByte = this.a.b().c();
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.size() == 0) {
        return;
      }
      this.a.a(1, "ILoadGuildAndChnListCallback", null);
      paramArrayOfByte = paramArrayOfByte.iterator();
      while (paramArrayOfByte.hasNext())
      {
        paramArrayList = (String)paramArrayOfByte.next();
        this.a.a(2, "ILoadGuildAndChnListCallback", paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine.2
 * JD-Core Version:    0.7.0.1
 */