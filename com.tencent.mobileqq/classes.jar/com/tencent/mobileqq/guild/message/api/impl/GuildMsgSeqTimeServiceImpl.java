package com.tencent.mobileqq.guild.message.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.GuildMsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyMsgHandler;
import com.tencent.mobileqq.guild.message.unread.ChannelMsgReadedReportHandler;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.guild.message.unread.GuildMsgReadedUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class GuildMsgSeqTimeServiceImpl
  extends Observable
  implements IGuildMsgSeqTimeService
{
  private final String TAG = "GuildMsgSeqTimeServiceImpl";
  private AppRuntime appRuntime;
  private EntityManager mEm;
  private HashMap<String, IGuildMsgSeqTimeService.MsgSeqTimeItem> mLatestHasSeenMsgMap = new HashMap();
  private ConcurrentHashMap<String, GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue> msgSeqTimeItemMap = new ConcurrentHashMap();
  private ArrayList<String> syncSaveList = new ArrayList();
  
  private void initLoadDB()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.mEm.query(GuildMsgSeqTimeItem.class, false, null, null, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GuildMsgSeqTimeItem localGuildMsgSeqTimeItem = (GuildMsgSeqTimeItem)((Iterator)localObject).next();
        this.msgSeqTimeItemMap.put(localGuildMsgSeqTimeItem.channelId, GuildMsgReadedUtils.a(localGuildMsgSeqTimeItem));
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initLoadDB time:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject).append("(ms)");
    QLog.i("GuildMsgSeqTimeServiceImpl", 1, ((StringBuilder)localObject).toString());
  }
  
  private void notifyUnreadCntSeqChange(String paramString)
  {
    setChanged();
    notifyObservers(paramString);
  }
  
  private boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.mEm.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.mEm.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.mEm.update(paramEntity);
      }
    }
    return false;
  }
  
  private boolean verifyLastLocalMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMsgSeqTimeItem == null) {
        return false;
      }
      if (!this.msgSeqTimeItemMap.containsKey(paramString2)) {
        return true;
      }
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        if (???.c.a > paramMsgSeqTimeItem.a)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("verifyLastLocalMsgSeq error guildid:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" channelid:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" localMsgSeq:");
          localStringBuilder.append(???.c.toString());
          localStringBuilder.append(" msgSeqTimeItemSvr:");
          localStringBuilder.append(paramMsgSeqTimeItem.toString());
          QLog.e("GuildMsgSeqTimeServiceImpl", 1, localStringBuilder.toString());
          ???.c.a(paramMsgSeqTimeItem);
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  public void addDecreaseMsgSeq(String paramString1, String paramString2, DecreaseMsgSeqInfo paramDecreaseMsgSeqInfo)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramDecreaseMsgSeqInfo == null) {
        return;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(paramString1, paramString2));
      paramString1 = (GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2);
      int j = 0;
      int i = j;
      try
      {
        if (paramDecreaseMsgSeqInfo.msgSeq > paramString1.e.a)
        {
          i = j;
          if (!paramString1.h.contains(paramDecreaseMsgSeqInfo))
          {
            paramString1.h.add(paramDecreaseMsgSeqInfo);
            i = 1;
          }
        }
        if (i != 0)
        {
          saveEntityAsync(paramString2);
          notifyUnreadCntSeqChange(paramString2);
        }
        return;
      }
      finally {}
    }
  }
  
  protected void delDecreaseMsgSeq(String arg1, long paramLong)
  {
    if (!TextUtils.isEmpty(???))
    {
      if (!this.msgSeqTimeItemMap.containsKey(???)) {
        return;
      }
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = ???.h.iterator();
        while (localIterator.hasNext())
        {
          DecreaseMsgSeqInfo localDecreaseMsgSeqInfo = (DecreaseMsgSeqInfo)localIterator.next();
          if (localDecreaseMsgSeqInfo.msgSeq > paramLong) {
            localHashSet.add(localDecreaseMsgSeqInfo);
          }
        }
        ???.h = localHashSet;
        return;
      }
    }
  }
  
  public HashSet<DecreaseMsgSeqInfo> getDecreaseMsgSeqList(String arg1)
  {
    if ((!TextUtils.isEmpty(???)) && (this.msgSeqTimeItemMap.containsKey(???))) {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        HashSet localHashSet = (HashSet)???.h.clone();
        return localHashSet;
      }
    }
    return new HashSet();
  }
  
  public GuildEventFlowTimeItem getEventFlowTimeItem(String arg1)
  {
    if ((!TextUtils.isEmpty(???)) && (this.msgSeqTimeItemMap.containsKey(???))) {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        GuildEventFlowTimeItem localGuildEventFlowTimeItem = ???.i.clone();
        return localGuildEventFlowTimeItem;
      }
    }
    return null;
  }
  
  public long getExpiredMsgSeq(String arg1)
  {
    if ((!TextUtils.isEmpty(???)) && (this.msgSeqTimeItemMap.containsKey(???))) {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        long l = ???.g;
        return l;
      }
    }
    return 0L;
  }
  
  public IGuildMsgSeqTimeService.MsgSeqTimeItem getLastLocallMsgSeq(String arg1)
  {
    if ((!TextUtils.isEmpty(???)) && (this.msgSeqTimeItemMap.containsKey(???))) {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ???.c.b();
        return localMsgSeqTimeItem;
      }
    }
    return new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  }
  
  public IGuildMsgSeqTimeService.MsgSeqTimeItem getLastLocallVisibleMsgSeq(String arg1)
  {
    if ((!TextUtils.isEmpty(???)) && (this.msgSeqTimeItemMap.containsKey(???))) {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ???.f.b();
        return localMsgSeqTimeItem;
      }
    }
    return new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  }
  
  public IGuildMsgSeqTimeService.MsgSeqTimeItem getLastSvrMsgSeq(String arg1)
  {
    if ((!TextUtils.isEmpty(???)) && (this.msgSeqTimeItemMap.containsKey(???))) {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ???.d.b();
        return localMsgSeqTimeItem;
      }
    }
    return new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  }
  
  public IGuildMsgSeqTimeService.MsgSeqTimeItem getLatestHasSeenMsg(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.mLatestHasSeenMsgMap.containsKey(paramString)) && (this.mLatestHasSeenMsgMap.get(paramString) != null))
      {
        paramString = ((IGuildMsgSeqTimeService.MsgSeqTimeItem)this.mLatestHasSeenMsgMap.get(paramString)).b();
        return paramString;
      }
      return null;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public IGuildMsgSeqTimeService.MsgSeqTimeItem getReadedMsgSeq(String arg1)
  {
    if ((!TextUtils.isEmpty(???)) && (this.msgSeqTimeItemMap.containsKey(???))) {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(???))
      {
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ???.e.b();
        return localMsgSeqTimeItem;
      }
    }
    return new IGuildMsgSeqTimeService.MsgSeqTimeItem();
  }
  
  public IGuildMsgSeqTimeService.MsgSeqTimeItem getReportSeqTimeItem(String paramString, boolean paramBoolean)
  {
    return ((ChannelMsgReadedReportHandler)((AppInterface)this.appRuntime).getBusinessHandler(ChannelMsgReadedReportHandler.class.getName())).a(paramString, paramBoolean);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    this.mEm = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    initLoadDB();
  }
  
  public void onDestroy() {}
  
  protected void saveEntityAsync(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.syncSaveList)
    {
      boolean bool = this.syncSaveList.isEmpty();
      if (!this.syncSaveList.contains(paramString)) {
        this.syncSaveList.add(paramString);
      }
      if (bool) {
        ThreadManager.excute(new GuildMsgSeqTimeServiceImpl.1(this), 32, null, true);
      }
      return;
    }
  }
  
  public void setEventFlowTimeItem(String arg1, String paramString2, long paramLong)
  {
    if (!TextUtils.isEmpty(???))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(???, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        ???.i.registProxyTime = paramLong;
        saveEntityAsync(paramString2);
        return;
      }
    }
  }
  
  public void setEventFlowTimeItem(String arg1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(???))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(???, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        ???.i.eventBeginTime = paramLong1;
        ???.i.eventEndTime = paramLong2;
        ???.i.cookie = paramArrayOfByte;
        saveEntityAsync(paramString2);
        return;
      }
    }
  }
  
  public void setEventFlowTimeItem(String arg1, String paramString2, GuildEventFlowTimeItem paramGuildEventFlowTimeItem)
  {
    if (!TextUtils.isEmpty(???))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(???, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        ???.i = paramGuildEventFlowTimeItem;
        saveEntityAsync(paramString2);
        return;
      }
    }
  }
  
  public void setExpiredMsgSeq(String arg1, String paramString2, long paramLong)
  {
    if (!TextUtils.isEmpty(???))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(???, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        ???.g = paramLong;
        saveEntityAsync(paramString2);
        return;
      }
    }
  }
  
  public boolean setLastLocalMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMsgSeqTimeItem == null) {
        return false;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(paramString1, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        if (paramMsgSeqTimeItem.a <= ???.c.a) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLastLocalMsgSeq guildid:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" channelid:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" localMsgSeqTimeItem(old):");
          localStringBuilder.append(???.c.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, localStringBuilder.toString());
        }
        ???.c.a(paramMsgSeqTimeItem);
        if (QLog.isColorLevel())
        {
          paramMsgSeqTimeItem = new StringBuilder();
          paramMsgSeqTimeItem.append("setLastLocalMsgSeq guildid:");
          paramMsgSeqTimeItem.append(paramString1);
          paramMsgSeqTimeItem.append(" channelid:");
          paramMsgSeqTimeItem.append(paramString2);
          paramMsgSeqTimeItem.append(" localMsgSeqTimeItem(new):");
          paramMsgSeqTimeItem.append(???.c.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, paramMsgSeqTimeItem.toString());
        }
        saveEntityAsync(paramString2);
        return true;
      }
    }
    return false;
  }
  
  public boolean setLastLocalVisibleMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMsgSeqTimeItem == null) {
        return false;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(paramString1, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        if (paramMsgSeqTimeItem.a <= ???.f.a) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLastLocalVisibleMsgSeq guildid:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" channelid:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" localVisibleMsgSeqTimeItem(old):");
          localStringBuilder.append(???.f.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, localStringBuilder.toString());
        }
        ???.f.a(paramMsgSeqTimeItem);
        if (QLog.isColorLevel())
        {
          paramMsgSeqTimeItem = new StringBuilder();
          paramMsgSeqTimeItem.append("setLastLocalVisibleMsgSeq guildid:");
          paramMsgSeqTimeItem.append(paramString1);
          paramMsgSeqTimeItem.append(" channelid:");
          paramMsgSeqTimeItem.append(paramString2);
          paramMsgSeqTimeItem.append(" localVisibleMsgSeqTimeItem(new):");
          paramMsgSeqTimeItem.append(???.f.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, paramMsgSeqTimeItem.toString());
        }
        saveEntityAsync(paramString2);
        return true;
      }
    }
    return false;
  }
  
  public boolean setLastSvrMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMsgSeqTimeItem == null) {
        return false;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(paramString1, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        if (paramMsgSeqTimeItem.a <= ???.d.a) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLastSvrMsgSeq guildid:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" channelid:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" svrMsgSeqTimeItem(old):");
          localStringBuilder.append(???.d.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, localStringBuilder.toString());
        }
        ???.d.a(paramMsgSeqTimeItem);
        if (QLog.isColorLevel())
        {
          paramMsgSeqTimeItem = new StringBuilder();
          paramMsgSeqTimeItem.append("setLastSvrMsgSeq guildid:");
          paramMsgSeqTimeItem.append(paramString1);
          paramMsgSeqTimeItem.append(" channelid:");
          paramMsgSeqTimeItem.append(paramString2);
          paramMsgSeqTimeItem.append(" svrMsgSeqTimeItem(new):");
          paramMsgSeqTimeItem.append(???.d.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, paramMsgSeqTimeItem.toString());
        }
        saveEntityAsync(paramString2);
        notifyUnreadCntSeqChange(paramString2);
        return true;
      }
    }
    return false;
  }
  
  public void setLatestHasSeenMsg(String paramString, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.mLatestHasSeenMsgMap.put(paramString, paramMsgSeqTimeItem);
      return;
    }
    finally {}
  }
  
  public boolean setReadedMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMsgSeqTimeItem == null) {
        return false;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(paramString1, paramString2));
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        if (paramMsgSeqTimeItem.a <= ???.e.a) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setReadedMsgSeq guildid:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" channelid:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" readedMsgSeqTimeItem(old):");
          localStringBuilder.append(???.e.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, localStringBuilder.toString());
        }
        ???.e.a(paramMsgSeqTimeItem);
        if (QLog.isColorLevel())
        {
          paramMsgSeqTimeItem = new StringBuilder();
          paramMsgSeqTimeItem.append("setReadedMsgSeq guildid:");
          paramMsgSeqTimeItem.append(paramString1);
          paramMsgSeqTimeItem.append(" channelid:");
          paramMsgSeqTimeItem.append(paramString2);
          paramMsgSeqTimeItem.append(" readedMsgSeqTimeItem(new):");
          paramMsgSeqTimeItem.append(???.e.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, paramMsgSeqTimeItem.toString());
        }
        delDecreaseMsgSeq(paramString2, ???.e.a);
        saveEntityAsync(paramString2);
        if (paramBoolean) {
          notifyUnreadCntSeqChange(paramString2);
        }
        return true;
      }
    }
    return false;
  }
  
  public void updateLastSeqAndTime(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        IGuildMsgSeqTimeService localIGuildMsgSeqTimeService;
        long l1;
        if (localIGuildMessageUtilsApi.isLocalOnlyMsg(localMessageRecord))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GuildMsgSeqTimeServiceImpl", 2, "updateLastSeqAndTime. isLocalOnlyMsg = true, will not update last seq");
          }
        }
        else
        {
          localIGuildMsgSeqTimeService = (IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(localMessageRecord.getExtInfoFromExtStr("GUILD_MSG_CNT_NAME"));
          l1 = l2;
        }
        catch (Exception localException)
        {
          label108:
          IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem;
          String str;
          break label108;
        }
        localMsgSeqTimeItem = new IGuildMsgSeqTimeService.MsgSeqTimeItem(localMessageRecord.shmsgseq, l1, localMessageRecord.time, localIGuildMessageUtilsApi.getMsgMetaFromMr(localMessageRecord));
        str = String.valueOf(localIGuildMessageUtilsApi.getGuildIdFromMR(localMessageRecord));
        localIGuildMsgSeqTimeService.setLastLocalMsgSeq(str, localMessageRecord.frienduin, localMsgSeqTimeItem);
        if (localIGuildMessageUtilsApi.isMsgVisible(localMessageRecord)) {
          localIGuildMsgSeqTimeService.setLastLocalVisibleMsgSeq(str, localMessageRecord.frienduin, localMsgSeqTimeItem);
        }
        localIGuildMsgSeqTimeService.setLastSvrMsgSeq(str, localMessageRecord.frienduin, localMsgSeqTimeItem);
        ((IGuildRegisterProxyMsgHandler)((AppInterface)this.appRuntime).getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName())).a(localMessageRecord.time);
      }
    }
    else
    {
      return;
    }
  }
  
  public boolean verifyLastLocalVisibleMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMsgSeqTimeItem == null) {
        return false;
      }
      if (!this.msgSeqTimeItemMap.containsKey(paramString2)) {
        return true;
      }
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        if (???.f.a > paramMsgSeqTimeItem.a)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("verifyLastLocalVisibleMsgSeq error guildid:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" channelid:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" localMsgSeq:");
          localStringBuilder.append(???.f.toString());
          localStringBuilder.append(" msgSeqTimeItemSvr:");
          localStringBuilder.append(paramMsgSeqTimeItem.toString());
          QLog.e("GuildMsgSeqTimeServiceImpl", 1, localStringBuilder.toString());
          ???.f.a(paramMsgSeqTimeItem);
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean verifyLastSvrMsgSeq(String paramString1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramMsgSeqTimeItem != null))
    {
      verifyLastLocalMsgSeq(paramString1, paramString2, paramMsgSeqTimeItem);
      verifyLastLocalVisibleMsgSeq(paramString1, paramString2, paramMsgSeqTimeItem);
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(paramString1, paramString2));
      GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue localGuildMsgSeqTimeValue = (GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("verifyLastSvrMsgSeq guildid:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" channelid:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" svrMsgSeqTimeItem(old):");
        localStringBuilder.append(localGuildMsgSeqTimeValue.d.toString());
        QLog.i("GuildMsgSeqTimeServiceImpl", 2, localStringBuilder.toString());
      }
      try
      {
        localGuildMsgSeqTimeValue.d.a(paramMsgSeqTimeItem);
        if (QLog.isColorLevel())
        {
          paramMsgSeqTimeItem = new StringBuilder();
          paramMsgSeqTimeItem.append("verifyLastSvrMsgSeq guildid:");
          paramMsgSeqTimeItem.append(paramString1);
          paramMsgSeqTimeItem.append(" channelid:");
          paramMsgSeqTimeItem.append(paramString2);
          paramMsgSeqTimeItem.append(" svrMsgSeqTimeItem(new):");
          paramMsgSeqTimeItem.append(localGuildMsgSeqTimeValue.d.toString());
          QLog.i("GuildMsgSeqTimeServiceImpl", 2, paramMsgSeqTimeItem.toString());
        }
        saveEntityAsync(paramString2);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public boolean verifyReadedMsgSeq(String arg1, String paramString2, IGuildMsgSeqTimeService.MsgSeqTimeItem paramMsgSeqTimeItem)
  {
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool1 = false;
    if (!bool2)
    {
      if (paramMsgSeqTimeItem == null) {
        return false;
      }
      this.msgSeqTimeItemMap.putIfAbsent(paramString2, new GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue(???, paramString2));
    }
    for (;;)
    {
      synchronized ((GuildMsgSeqTimeServiceImpl.GuildMsgSeqTimeValue)this.msgSeqTimeItemMap.get(paramString2))
      {
        if ((!???.e.a()) || (???.e.a <= paramMsgSeqTimeItem.a)) {
          break label183;
        }
        if (!bool1)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("verifyReadedMsgSeq error readedMsgSeq:");
          localStringBuilder.append(???.e.toString());
          localStringBuilder.append(" readMsgSeqTimeItemSvr:");
          localStringBuilder.append(paramMsgSeqTimeItem.toString());
          QLog.e("GuildMsgSeqTimeServiceImpl", 1, localStringBuilder.toString());
        }
        ???.e.a(paramMsgSeqTimeItem);
        delDecreaseMsgSeq(paramString2, ???.e.a);
        saveEntityAsync(paramString2);
        return bool1;
      }
      return false;
      label183:
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMsgSeqTimeServiceImpl
 * JD-Core Version:    0.7.0.1
 */