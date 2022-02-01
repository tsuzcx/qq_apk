package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.GuildGuestMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildMessageCache;
import com.tencent.mobileqq.guild.message.GuildOfflineMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildOnlineMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildRoamMessageEventFlowProcessor;
import com.tencent.mobileqq.guild.message.GuildRoamMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildSystemMessageProcessor;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.base.IGuildMessageProcessor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class GuildMsgFactoryImpl
  implements IGuildMsgFactory
{
  private final String TAG = "GuildMsgFactoryImpl";
  private AppRuntime app;
  private GuildMessageCache msgCache = new GuildMessageCache();
  protected Map<Integer, IGuildMessageProcessor> processorMap = new ConcurrentHashMap();
  
  public IGuildMessageProcessor getMessageProcessor(int paramInt)
  {
    if (!this.processorMap.containsKey(Integer.valueOf(paramInt))) {}
    for (;;)
    {
      synchronized (this.processorMap)
      {
        if (!this.processorMap.containsKey(Integer.valueOf(paramInt)))
        {
          Object localObject1;
          if (paramInt == 0)
          {
            localObject1 = new GuildRoamMessageProcessor((AppInterface)this.app);
          }
          else if (1 == paramInt)
          {
            localObject1 = new GuildOfflineMessageProcessor((AppInterface)this.app);
          }
          else if (2 == paramInt)
          {
            localObject1 = new GuildOnlineMessageProcessor((AppInterface)this.app);
          }
          else if (3 == paramInt)
          {
            localObject1 = new GuildSystemMessageProcessor((AppInterface)this.app);
          }
          else if (4 == paramInt)
          {
            localObject1 = new GuildGuestMessageProcessor((AppInterface)this.app);
          }
          else
          {
            if (5 != paramInt) {
              break label226;
            }
            localObject1 = new GuildRoamMessageEventFlowProcessor((AppInterface)this.app);
          }
          if (localObject1 == null) {
            return null;
          }
          this.processorMap.put(Integer.valueOf(paramInt), localObject1);
        }
      }
      return (IGuildMessageProcessor)this.processorMap.get(Integer.valueOf(paramInt));
      label226:
      Object localObject3 = null;
    }
  }
  
  public GuildMessageCache getMsgCache()
  {
    return this.msgCache;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.msgCache.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMsgFactoryImpl
 * JD-Core Version:    0.7.0.1
 */