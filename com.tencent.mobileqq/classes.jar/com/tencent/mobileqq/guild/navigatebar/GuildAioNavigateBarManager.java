package com.tencent.mobileqq.guild.navigatebar;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.GuildMessageBoxObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.navigatebar.BaseAioNavigateBarManager;
import com.tencent.mobileqq.troop.navigatebar.NavConstants;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class GuildAioNavigateBarManager
  extends BaseAioNavigateBarManager
  implements Manager
{
  final String a = "GuildAioNavigateBarManager";
  protected final ConcurrentHashMap<String, List<GuildMessageNavigateInfo>> b = new ConcurrentHashMap();
  volatile boolean c = false;
  public HashMap<String, Long> d = new HashMap();
  private boolean f = true;
  private GuildMessageBoxObserver g = new GuildAioNavigateBarManager.1(this);
  
  public GuildAioNavigateBarManager() {}
  
  public GuildAioNavigateBarManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    a();
  }
  
  private List<Long> a(String paramString, int paramInt, boolean paramBoolean)
  {
    c();
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder("getMultiNavigateSeqList, channelId = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", type = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", seqList = ");
    localStringBuilder.append(" isMsgSeq:");
    localStringBuilder.append(paramBoolean);
    if (this.b.containsKey(paramString))
    {
      paramString = (List)this.b.get(paramString);
      if (ListUtils.a(paramString))
      {
        localStringBuilder.append("null");
        paramString = new StringBuilder();
        paramString.append(" getMultiNavigateSeqList ");
        paramString.append(localStringBuilder.toString());
        paramString.append(" resultList.size () ");
        paramString.append(localArrayList.size());
        QLog.d("GuildAioNavigateBarManager", 1, paramString.toString());
        return localArrayList;
      }
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        GuildMessageNavigateInfo localGuildMessageNavigateInfo = (GuildMessageNavigateInfo)paramString.get(i);
        if ((localGuildMessageNavigateInfo.status != GuildMessageNavigateInfo.STATUS_DELETE) && ((localGuildMessageNavigateInfo.type == paramInt) || (paramInt == 0))) {
          if (paramBoolean)
          {
            localArrayList.add(Long.valueOf(localGuildMessageNavigateInfo.msgseq));
            localStringBuilder.append(localGuildMessageNavigateInfo.msgseq);
            localStringBuilder.append(",");
          }
          else
          {
            localArrayList.add(Long.valueOf(localGuildMessageNavigateInfo.shmsgseq));
            localStringBuilder.append(localGuildMessageNavigateInfo.shmsgseq);
            localStringBuilder.append(",");
          }
        }
        i += 1;
      }
    }
    paramString = new StringBuilder();
    paramString.append(" getMultiNavigateSeqList2 ");
    paramString.append(localStringBuilder.toString());
    paramString.append(" resultList.size () ");
    paramString.append(localArrayList.size());
    QLog.d("GuildAioNavigateBarManager", 1, paramString.toString());
    return localArrayList;
  }
  
  private void f()
  {
    Object localObject1 = (IGuildMessageBoxDataService)this.e.getRuntimeService(IGuildMessageBoxDataService.class, "");
    if (localObject1 == null)
    {
      QLog.d("GuildAioNavigateBarManager", 1, "[initGuildAtMeNavigateInfo] msgBoxDataService == null");
      return;
    }
    localObject1 = ((IGuildMessageBoxDataService)localObject1).getAllChannelMsgEventList();
    if (localObject1 == null)
    {
      QLog.d("GuildAioNavigateBarManager", 1, "[initGuildAtMeNavigateInfo] msgEventMap == null");
      return;
    }
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (localEntry.getValue() != null))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[initGuildAtMeNavigateInfo] channel: ");
        ((StringBuilder)localObject2).append(localEntry.getValue());
        ((StringBuilder)localObject2).append(",  eventList size");
        ((StringBuilder)localObject2).append(((List)localEntry.getValue()).size());
        QLog.d("GuildAioNavigateBarManager", 1, ((StringBuilder)localObject2).toString());
        localObject2 = ((List)localEntry.getValue()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (ChannelMsgEvent)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((ChannelMsgEvent)localObject3).eventType == 1L))
          {
            GuildMessageNavigateInfo localGuildMessageNavigateInfo = new GuildMessageNavigateInfo();
            localGuildMessageNavigateInfo.channelId = ((String)localEntry.getKey());
            localGuildMessageNavigateInfo.type = 23;
            localGuildMessageNavigateInfo.shmsgseq = ((ChannelMsgEvent)localObject3).msgSeq;
            localGuildMessageNavigateInfo.msgseq = ((ChannelMsgEvent)localObject3).msgSeq;
            localObject3 = (List)this.b.get(localGuildMessageNavigateInfo.channelId);
            if (localObject3 != null)
            {
              ((List)localObject3).add(localGuildMessageNavigateInfo);
            }
            else
            {
              localObject3 = new ArrayList();
              ((List)localObject3).add(localGuildMessageNavigateInfo);
              this.b.put(localGuildMessageNavigateInfo.channelId, localObject3);
            }
          }
        }
        b((String)localEntry.getKey());
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    try
    {
      paramInt = c(paramString);
      return paramInt;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public long a(String paramString)
  {
    try
    {
      boolean bool = this.d.containsKey(paramString);
      long l = -1L;
      if (bool)
      {
        paramString = (Long)this.d.remove(paramString);
        if (paramString != null) {
          l = paramString.longValue();
        }
        return l;
      }
      return -1L;
    }
    finally {}
  }
  
  public long a(String paramString, long paramLong)
  {
    try
    {
      if (this.b.containsKey(paramString))
      {
        Object localObject = (List)this.b.get(paramString);
        boolean bool = ListUtils.a((Collection)localObject);
        if (bool) {
          return 0L;
        }
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          paramString = (GuildMessageNavigateInfo)((List)localObject).get(i);
          if (paramString.msgseq == paramLong)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" getMultiNavShMsgSeqByUinSeq ");
            ((StringBuilder)localObject).append(paramLong);
            QLog.d("GuildAioNavigateBarManager", 1, ((StringBuilder)localObject).toString());
            paramLong = paramString.shmsgseq;
            return paramLong;
          }
          i -= 1;
        }
      }
      return 0L;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  protected void a()
  {
    ThreadManager.excute(new GuildAioNavigateBarManager.2(this), 32, null, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    c(paramString, paramInt2);
    a(true);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString2, Object paramObject)
  {
    try
    {
      boolean bool = a(paramInt1);
      if (!bool) {
        return;
      }
      a(paramString1, paramInt2, paramLong1, paramLong2, paramString2, paramObject);
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2, Object paramObject)
  {
    if (paramInt <= 0) {
      return;
    }
    try
    {
      localGuildMessageNavigateInfo = new GuildMessageNavigateInfo();
      localGuildMessageNavigateInfo.type = paramInt;
      localGuildMessageNavigateInfo.channelId = paramString1;
      localGuildMessageNavigateInfo.shmsgseq = paramLong1;
      localGuildMessageNavigateInfo.msgseq = paramLong2;
      localGuildMessageNavigateInfo.summary = paramString2;
      localGuildMessageNavigateInfo.extObj = paramObject;
      if (localGuildMessageNavigateInfo.type == 1) {
        a(false);
      }
      paramString2 = new StringBuilder();
      paramString2.append("addGuildMsgNavigateInfo, mHasAt = ");
      paramString2.append(this.f);
      QLog.d("GuildAioNavigateBarManager", 1, paramString2.toString());
      localList = (List)this.b.get(paramString1);
      if (ListUtils.a(localList)) {
        break label434;
      }
      if (GuildAioNavigateUtil.a())
      {
        localGuildMessageNavigateInfo.status = GuildMessageNavigateInfo.STATUS_ADD;
        if (!localList.contains(localGuildMessageNavigateInfo)) {
          localList.add(localGuildMessageNavigateInfo);
        }
        paramString2 = new StringBuilder();
        paramString2.append("addGuildMsgNavigateInfo  guildMessageNavigateInfoList = ");
        paramString2.append(localList);
        QLog.d("GuildAioNavigateBarManager", 1, paramString2.toString());
        b(paramString1);
        break label509;
      }
      paramObject = null;
      i = localList.size() - 1;
    }
    finally
    {
      for (;;)
      {
        GuildMessageNavigateInfo localGuildMessageNavigateInfo;
        List localList;
        int i;
        int j;
        for (;;)
        {
          throw paramString1;
        }
        i -= 1;
      }
    }
    paramString2 = paramObject;
    if (i >= 0)
    {
      if (paramInt != ((GuildMessageNavigateInfo)localList.get(i)).type) {
        break label523;
      }
      paramString2 = (GuildMessageNavigateInfo)localList.get(i);
    }
    j = NavConstants.a(paramInt);
    if ((paramInt != 1) && (paramString2 != null) && (paramString2.status != GuildMessageNavigateInfo.STATUS_DELETE) && (!MessageNavInfo.a(NavConstants.a(paramString2.type), paramString2.shmsgseq, j, paramLong1)))
    {
      paramString1 = new StringBuilder();
      paramString1.append("addGuildMsgNavigateInfo, but do not need update, shMsgSeq = ");
      paramString1.append(paramLong1);
      QLog.d("GuildAioNavigateBarManager", 1, paramString1.toString());
    }
    else
    {
      if (i >= 0) {
        localList.remove(i);
      }
      a(paramString2, localGuildMessageNavigateInfo, paramInt);
      localList.add(localGuildMessageNavigateInfo);
      paramString2 = new StringBuilder();
      paramString2.append("addGuildMsgNavigateInfo  guildMessageNavigateInfoList = ");
      paramString2.append(localList);
      QLog.d("GuildAioNavigateBarManager", 1, paramString2.toString());
      b(paramString1);
      break label509;
      label434:
      paramString2 = new StringBuilder();
      paramString2.append("addGuildMsgNavigateInfo,  param= ");
      paramString2.append(localGuildMessageNavigateInfo);
      QLog.d("GuildAioNavigateBarManager", 1, paramString2.toString());
      localGuildMessageNavigateInfo.status = GuildMessageNavigateInfo.STATUS_ADD;
      paramString2 = new ArrayList();
      paramString2.add(localGuildMessageNavigateInfo);
      this.b.put(paramString1, paramString2);
    }
    label509:
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt == 10014;
  }
  
  public List<Long> b(String paramString, int paramInt)
  {
    try
    {
      paramString = a(paramString, paramInt, true);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected void b(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.b.containsKey(paramString)))
      {
        Collections.sort((List)this.b.get(paramString), new GuildAioNavigateBarManager.NavigationMsgComparator());
        return;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public int c(String paramString)
  {
    try
    {
      paramString = d(paramString);
      if (paramString != null)
      {
        int i = paramString.type;
        return i;
      }
      return -1;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.c;
      if (bool) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initGuildMessageNavigateInfo before, ");
        ((StringBuilder)localObject1).append(e());
        QLog.d("GuildAioNavigateBarManager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (ArrayList)this.e.getEntityManagerFactory().createEntityManager().query(GuildMessageNavigateInfo.class, false, null, null, null, null, null, null);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (GuildMessageNavigateInfo)((Iterator)localObject1).next();
          if ((localObject3 != null) && (!TextUtils.isEmpty(((GuildMessageNavigateInfo)localObject3).channelId)))
          {
            Object localObject4 = (List)this.b.get(((GuildMessageNavigateInfo)localObject3).channelId);
            if (localObject4 != null)
            {
              localObject3 = ((List)localObject4).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (GuildMessageNavigateInfo)((Iterator)localObject3).next();
                if ((localObject4 != null) && (((GuildMessageNavigateInfo)localObject4).status == GuildMessageNavigateInfo.STATUS_ADD)) {
                  ((GuildMessageNavigateInfo)localObject4).status = GuildMessageNavigateInfo.STATUS_MODIFY;
                }
              }
            }
            else
            {
              ((GuildMessageNavigateInfo)localObject3).status = GuildMessageNavigateInfo.STATUS_NORMAL;
              localObject4 = new ArrayList();
              ((List)localObject4).add(localObject3);
              this.b.put(((GuildMessageNavigateInfo)localObject3).channelId, localObject4);
              b(((GuildMessageNavigateInfo)localObject3).channelId);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("mapGuildNavigateInfo , ");
              ((StringBuilder)localObject3).append(this.b.size());
              QLog.d("GuildAioNavigateBarManager", 1, ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
      f();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initGuildMessageNavigateInfo after, ");
        ((StringBuilder)localObject1).append(e());
        QLog.d("GuildAioNavigateBarManager", 2, ((StringBuilder)localObject1).toString());
      }
      this.e.addObserver(this.g);
      this.c = true;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearGuildMsgNavigateInfo: channelId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("GuildAioNavigateBarManager", 1, ((StringBuilder)localObject).toString());
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      c();
      if (!this.b.containsKey(paramString)) {
        break label203;
      }
      localObject = (List)this.b.get(paramString);
      bool = ListUtils.a((Collection)localObject);
      if (bool) {
        return;
      }
      i = ((List)localObject).size() - 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int i;
        GuildMessageNavigateInfo localGuildMessageNavigateInfo;
        for (;;)
        {
          label203:
          throw paramString;
        }
        i -= 1;
      }
    }
    if (i >= 0)
    {
      localGuildMessageNavigateInfo = (GuildMessageNavigateInfo)((List)localObject).get(i);
      if ((paramInt == localGuildMessageNavigateInfo.type) || (paramInt == 0)) {
        if (localGuildMessageNavigateInfo.status == GuildMessageNavigateInfo.STATUS_ADD) {
          ((List)localObject).remove(i);
        } else {
          localGuildMessageNavigateInfo.status = GuildMessageNavigateInfo.STATUS_DELETE;
        }
      }
    }
    else
    {
      if (((List)localObject).isEmpty()) {
        this.b.remove(paramString);
      }
      return;
    }
  }
  
  @Nullable
  GuildMessageNavigateInfo d(String paramString)
  {
    c();
    if (this.b.containsKey(paramString))
    {
      paramString = (List)this.b.get(paramString);
      if (ListUtils.a(paramString)) {
        return null;
      }
      int j = paramString.size();
      int i = 0;
      while (i < j)
      {
        GuildMessageNavigateInfo localGuildMessageNavigateInfo = (GuildMessageNavigateInfo)paramString.get(i);
        if (localGuildMessageNavigateInfo.status == GuildMessageNavigateInfo.STATUS_DELETE) {
          i += 1;
        } else {
          return localGuildMessageNavigateInfo;
        }
      }
    }
    return null;
  }
  
  protected void d()
  {
    for (;;)
    {
      try
      {
        c();
        i = 0;
        Iterator localIterator1 = this.b.entrySet().iterator();
        if (!localIterator1.hasNext()) {
          continue;
        }
        localEntry = (Map.Entry)localIterator1.next();
        localList = (List)localEntry.getValue();
        localIterator2 = localList.iterator();
        j = i;
      }
      finally
      {
        int i;
        Map.Entry localEntry;
        List localList;
        Iterator localIterator2;
        GuildMessageNavigateInfo localGuildMessageNavigateInfo;
        continue;
        throw localObject;
        continue;
        int j = 1;
        continue;
      }
      if (localIterator2.hasNext())
      {
        localGuildMessageNavigateInfo = (GuildMessageNavigateInfo)localIterator2.next();
        if ((localGuildMessageNavigateInfo != null) && (localGuildMessageNavigateInfo.type != 23))
        {
          if (localGuildMessageNavigateInfo.status == GuildMessageNavigateInfo.STATUS_ADD)
          {
            this.e.getProxyManagerInner().doAddMsgQueue(localGuildMessageNavigateInfo.channelId, 10014, localGuildMessageNavigateInfo.getTableName(), localGuildMessageNavigateInfo, 3, null);
            continue;
          }
          if (localGuildMessageNavigateInfo.status == GuildMessageNavigateInfo.STATUS_MODIFY)
          {
            this.e.getProxyManagerInner().doAddMsgQueue(localGuildMessageNavigateInfo.channelId, 10014, localGuildMessageNavigateInfo.getTableName(), localGuildMessageNavigateInfo, 4, null);
            continue;
          }
          if (localGuildMessageNavigateInfo.status == GuildMessageNavigateInfo.STATUS_DELETE)
          {
            localIterator2.remove();
            this.e.getProxyManagerInner().doAddMsgQueue(localGuildMessageNavigateInfo.channelId, 10014, localGuildMessageNavigateInfo.getTableName(), localGuildMessageNavigateInfo, 5, null);
          }
        }
      }
      else
      {
        i = j;
        if (localList.isEmpty())
        {
          this.b.remove(localEntry.getKey());
          i = j;
        }
      }
    }
    if (i != 0) {
      this.e.getProxyManagerInner().saveNotify();
    }
  }
  
  public Object e(String paramString)
  {
    try
    {
      paramString = d(paramString);
      if (paramString != null)
      {
        paramString = paramString.extObj;
        return paramString;
      }
      return null;
    }
    finally {}
  }
  
  protected String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mapGuildNavigateInfo: size = ");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(" {");
    Iterator localIterator = this.b.entrySet().iterator();
    int i = 0;
    int j;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject = (Map.Entry)localIterator.next();
      List localList = (List)((Map.Entry)localObject).getValue();
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append(": size = ");
      if (localList == null) {
        j = 0;
      } else {
        j = localList.size();
      }
      localStringBuilder.append(j);
      localStringBuilder.append("->{ ");
      if (localList != null)
      {
        localObject = localList.iterator();
        j = 0;
        int k;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localStringBuilder.append(((GuildMessageNavigateInfo)((Iterator)localObject).next()).toString());
          localStringBuilder.append(" ");
          k = j + 1;
          j = k;
        } while (k < 10);
      }
      localStringBuilder.append(" } ");
      j = i + 1;
      i = j;
    } while (j < 20);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public void onDestroy()
  {
    d();
    this.e.removeObserver(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioNavigateBarManager
 * JD-Core Version:    0.7.0.1
 */