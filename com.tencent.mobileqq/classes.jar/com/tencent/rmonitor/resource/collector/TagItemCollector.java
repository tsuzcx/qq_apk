package com.tencent.rmonitor.resource.collector;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.meta.SceneMeta;
import com.tencent.rmonitor.base.plugin.listener.IResourceListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.resource.RunTimeEnv;
import com.tencent.rmonitor.resource.meta.NetFlow;
import com.tencent.rmonitor.resource.meta.PerfItem;
import com.tencent.rmonitor.resource.meta.TagItem;
import com.tencent.rmonitor.resource.reflect.ReflectIoModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class TagItemCollector
  implements Handler.Callback, ITagItemCollector
{
  private final Vector<TagItem> a = new Vector(100);
  private final ReflectIoModule b;
  private final DataCollector c;
  private final ConcurrentHashMap<String, TagItem> d;
  private final Handler e = new Handler(ThreadManager.e(), this);
  private ITagItemCollectorListener f;
  private volatile String g = "";
  private volatile String h = "";
  
  public TagItemCollector(ReflectIoModule paramReflectIoModule, DataCollector paramDataCollector)
  {
    this.b = paramReflectIoModule;
    this.c = paramDataCollector;
    this.d = new ConcurrentHashMap();
  }
  
  private long a(long paramLong)
  {
    long l = paramLong;
    if (paramLong == 9223372036854775807L) {
      l = 0L;
    }
    return l;
  }
  
  private void a(TagItem paramTagItem)
  {
    this.g = paramTagItem.stage;
    this.h = paramTagItem.extraInfo;
    if (!RunTimeEnv.a()) {
      c(paramTagItem);
    }
    FpsCollector.a().a(paramTagItem.stage);
    this.d.put(paramTagItem.tagKey, paramTagItem);
    this.a.add(paramTagItem);
  }
  
  private void a(@NonNull TagItem paramTagItem1, @NonNull TagItem paramTagItem2)
  {
    double d1 = System.currentTimeMillis();
    Double.isNaN(d1);
    paramTagItem2.eventTime = (d1 / 1000.0D);
    paramTagItem2.duringTime = ((paramTagItem2.eventTime - paramTagItem1.eventTime) * 1000.0D);
    c(paramTagItem1, paramTagItem2);
    b(paramTagItem1, paramTagItem2);
  }
  
  private void a(TagItem paramTagItem1, TagItem paramTagItem2, boolean paramBoolean)
  {
    ArrayList localArrayList = ListenerManager.d.a();
    if (localArrayList.isEmpty()) {
      return;
    }
    if ((paramBoolean) || (e()))
    {
      SceneMeta localSceneMeta = paramTagItem2.sceneMeta;
      localSceneMeta.duration = (((paramTagItem1.eventTime - paramTagItem2.eventTime) * 1000.0D));
      localSceneMeta.stage = paramTagItem2.stage;
      localSceneMeta.fps = a(paramTagItem1.fps);
      localSceneMeta.ioCnt = a(paramTagItem1.ioCount);
      localSceneMeta.ioSize = a(paramTagItem1.ioBytes);
      localSceneMeta.netPack = a(paramTagItem1.netFlowPackets);
      localSceneMeta.netRec = a(paramTagItem1.netFlowReceiveBytes);
      localSceneMeta.netSend = a(paramTagItem1.netFlowReceiveBytes);
      paramTagItem1 = localArrayList.iterator();
      while (paramTagItem1.hasNext()) {
        ((IResourceListener)paramTagItem1.next()).onEndScene(localSceneMeta);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if ("RMONITOR_APP_LAUNCH".equals(paramString)) {
      return true;
    }
    return PluginController.b.b(138);
  }
  
  private void b(TagItem paramTagItem)
  {
    Object localObject = paramTagItem.matchTagItem;
    a((TagItem)localObject, paramTagItem);
    paramTagItem.fps = FpsCollector.a().b(((TagItem)localObject).stage);
    boolean bool = RunTimeEnv.a();
    if (bool)
    {
      ITagItemCollectorListener localITagItemCollectorListener = this.f;
      if (localITagItemCollectorListener != null) {
        localITagItemCollectorListener.a();
      }
    }
    a(paramTagItem, (TagItem)localObject, bool);
    this.a.add(paramTagItem);
    this.d.remove(paramTagItem.tagKey);
    if (this.a.size() > 100)
    {
      localObject = this.f;
      if (localObject != null) {
        ((ITagItemCollectorListener)localObject).b();
      }
    }
    if (this.g.equals(paramTagItem.stage))
    {
      this.g = "";
      if (this.h.equals(paramTagItem.extraInfo)) {
        this.h = "";
      }
    }
  }
  
  private void b(@NonNull TagItem paramTagItem1, @NonNull TagItem paramTagItem2)
  {
    if ((paramTagItem1.ioCount != 9223372036854775807L) && (paramTagItem1.ioBytes != 9223372036854775807L))
    {
      long[] arrayOfLong = this.b.a();
      if ((arrayOfLong != null) && (arrayOfLong.length == 2))
      {
        paramTagItem2.ioCount = (arrayOfLong[0] - paramTagItem1.ioCount);
        paramTagItem2.ioBytes = (arrayOfLong[1] - paramTagItem1.ioBytes);
      }
    }
  }
  
  private void c(@NonNull TagItem paramTagItem)
  {
    Object localObject = this.c.a(true);
    paramTagItem.netFlowReceiveBytes = ((NetFlow)localObject).rxBytes;
    paramTagItem.netFlowSendBytes = ((NetFlow)localObject).txBytes;
    if ((9223372036854775807L != ((NetFlow)localObject).rxPackets) && (9223372036854775807L != ((NetFlow)localObject).txPackets)) {
      paramTagItem.netFlowPackets = (((NetFlow)localObject).rxPackets + ((NetFlow)localObject).txPackets);
    } else {
      paramTagItem.netFlowPackets = 9223372036854775807L;
    }
    localObject = this.b.a();
    if ((localObject != null) && (localObject.length == 2))
    {
      paramTagItem.ioCount = localObject[0];
      paramTagItem.ioBytes = localObject[1];
    }
  }
  
  private void c(@NonNull TagItem paramTagItem1, @NonNull TagItem paramTagItem2)
  {
    if ((paramTagItem1.netFlowSendBytes != 9223372036854775807L) && (paramTagItem1.netFlowReceiveBytes != 9223372036854775807L))
    {
      NetFlow localNetFlow = this.c.a(true);
      if ((9223372036854775807L != localNetFlow.rxBytes) && (9223372036854775807L != localNetFlow.txPackets))
      {
        paramTagItem2.netFlowReceiveBytes = (localNetFlow.rxBytes - paramTagItem1.netFlowReceiveBytes);
        paramTagItem2.netFlowSendBytes = (localNetFlow.txBytes - paramTagItem1.netFlowSendBytes);
      }
      if ((9223372036854775807L != localNetFlow.rxPackets) && (9223372036854775807L != localNetFlow.txPackets))
      {
        paramTagItem2.netFlowPackets = (localNetFlow.rxPackets + localNetFlow.txPackets - paramTagItem1.netFlowPackets);
        return;
      }
      paramTagItem2.netFlowPackets = 9223372036854775807L;
    }
  }
  
  private boolean e()
  {
    return ConfigProxy.INSTANCE.getConfig().b("NEED_AUTHORIZATION");
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(ITagItemCollectorListener paramITagItemCollectorListener)
  {
    this.f = paramITagItemCollectorListener;
  }
  
  public void a(PerfItem paramPerfItem)
  {
    if (RunTimeEnv.b())
    {
      Iterator localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (TagItem)this.d.get(localObject);
        if (localObject != null)
        {
          ((TagItem)localObject).sceneMeta.cpu = Math.max(((TagItem)localObject).sceneMeta.cpu, paramPerfItem.cpuRate);
          ((TagItem)localObject).sceneMeta.memory = Math.max(((TagItem)localObject).sceneMeta.memory, paramPerfItem.memory);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!a(paramString1)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
      TagItem localTagItem = new TagItem();
      localTagItem.tagKey = ((String)localObject);
      double d1 = l;
      Double.isNaN(d1);
      localTagItem.eventTime = (d1 / 1000.0D);
      localTagItem.stage = paramString1;
      localTagItem.extraInfo = paramString2;
      localTagItem.tagId = l;
      localTagItem.type = 0;
      Message.obtain(this.e, 1, localTagItem).sendToTarget();
    }
  }
  
  public String b()
  {
    return this.h;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    TagItem localTagItem1 = (TagItem)this.d.get(localObject);
    if (localTagItem1 == null) {
      return;
    }
    TagItem localTagItem2 = new TagItem();
    localTagItem2.matchTagItem = localTagItem1;
    localTagItem2.tagKey = ((String)localObject);
    localTagItem2.stage = paramString1;
    localTagItem2.extraInfo = paramString2;
    localTagItem2.tagId = localTagItem1.tagId;
    localTagItem2.type = 1;
    Message.obtain(this.e, 2, localTagItem2).sendToTarget();
  }
  
  public int c()
  {
    return this.a.size();
  }
  
  public Vector<TagItem> d()
  {
    Vector localVector = (Vector)this.a.clone();
    this.a.clear();
    return localVector;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2) {
        b((TagItem)paramMessage.obj);
      }
    }
    else {
      a((TagItem)paramMessage.obj);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.TagItemCollector
 * JD-Core Version:    0.7.0.1
 */