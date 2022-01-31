package com.tencent.tvkbeacon.core.strategy;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.tvkbeacon.core.event.EventStrategyBean;
import com.tencent.tvkbeacon.core.protocol.strategy.CommonStrategy;
import com.tencent.tvkbeacon.core.protocol.strategy.ModuleStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class f
  implements com.tencent.tvkbeacon.core.b.f
{
  private Context a = null;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 101) {
      com.tencent.tvkbeacon.core.c.c.c("[strategy] com strategy unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    b localb;
    Object localObject1;
    int i;
    for (;;)
    {
      return;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        localb = StrategyQueryModule.getInstance(this.a).getStrategy();
        if (localb == null)
        {
          com.tencent.tvkbeacon.core.c.c.c("[strategy] impossible! common strategy null!", new Object[0]);
          return;
        }
        try
        {
          localObject1 = new CommonStrategy();
          ((CommonStrategy)localObject1).readFrom(new com.tencent.tvkbeacon.core.wup.a(paramArrayOfByte));
          StrategyQueryModule localStrategyQueryModule = StrategyQueryModule.getInstance(this.a);
          com.tencent.tvkbeacon.core.c.c.b("[strategy] -> common strategy: %s", new Object[] { localObject1 });
          if (localb == null)
          {
            i = 0;
            if (i != 0)
            {
              if (paramBoolean)
              {
                com.tencent.tvkbeacon.core.c.c.e("[strategy] update common strategy should save ", new Object[0]);
                c.a(this.a, paramInt, paramArrayOfByte);
              }
              localStrategyQueryModule.notifyStrategyChanged(localb);
            }
            if (!paramBoolean) {
              continue;
            }
            localStrategyQueryModule.setAtLeastAComQuerySuccess(true);
            paramArrayOfByte = EventStrategyBean.getInstance();
            if ((paramArrayOfByte == null) || (!paramArrayOfByte.isStrategyQuerySuccessDaxMax())) {
              continue;
            }
            paramArrayOfByte = com.tencent.tvkbeacon.core.a.c.a(this.a);
            paramInt = paramArrayOfByte.a("today_success_strategy_query_times");
            paramArrayOfByte.a().a("today_success_strategy_query_times", Integer.valueOf(paramInt + 1)).a("last_success_strategy_query_time", Long.valueOf(System.currentTimeMillis())).b();
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          com.tencent.tvkbeacon.core.c.c.a(paramArrayOfByte);
          com.tencent.tvkbeacon.core.c.c.d("[strategy] error to common strategy!", new Object[0]);
          return;
        }
      }
    }
    int k = 0;
    if (!((CommonStrategy)localObject1).url.equals(localb.b()))
    {
      com.tencent.tvkbeacon.core.c.c.b("[strategy] url changed to: %s", new Object[] { ((CommonStrategy)localObject1).url });
      k = 1;
      localb.a(((CommonStrategy)localObject1).url);
    }
    if (((CommonStrategy)localObject1).queryInterval != localb.c())
    {
      com.tencent.tvkbeacon.core.c.c.b("[strategy] QueryPeriod changed to: %d", new Object[] { Integer.valueOf(((CommonStrategy)localObject1).queryInterval) });
      k = 1;
      localb.a(((CommonStrategy)localObject1).queryInterval);
    }
    Object localObject2 = ((CommonStrategy)localObject1).moduleList;
    label344:
    Object localObject3;
    int n;
    label388:
    int j;
    label421:
    int m;
    boolean bool1;
    label492:
    boolean bool2;
    if (localb == null)
    {
      i = 0;
      break label1314;
      localObject1 = ((CommonStrategy)localObject1).cloudParas;
      if (localb == null)
      {
        i = 0;
        break label1325;
      }
    }
    else
    {
      i = 0;
      if (localObject2 != null)
      {
        localObject3 = localb.e();
        if (localObject3 == null) {
          break label1314;
        }
        n = 0;
        i = 0;
        j = i;
        if (n >= ((SparseArray)localObject3).size()) {
          break label1310;
        }
        a locala = (a)((SparseArray)localObject3).valueAt(n);
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label1367;
        }
        ModuleStrategy localModuleStrategy = (ModuleStrategy)localIterator.next();
        m = i;
        if (localModuleStrategy.mId != locala.d()) {
          break label1336;
        }
        com.tencent.tvkbeacon.core.c.c.a("[strategy] server module strategy mid: %d", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
        if (localModuleStrategy.onOff != 1) {
          break label1343;
        }
        bool1 = true;
        if (locala.a() != bool1)
        {
          com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , isUsable changed: %b ", new Object[] { Byte.valueOf(localModuleStrategy.mId), Boolean.valueOf(bool1) });
          i = 1;
          locala.a(bool1);
        }
        if (b.a().i()) {
          break label1349;
        }
        bool1 = true;
        label552:
        String str = b.a().b("stopTest");
        if (str == null) {
          break label1355;
        }
        bool2 = "y".equals(str);
        label576:
        boolean bool3 = com.tencent.tvkbeacon.core.c.c.b;
        if (bool2) {
          break label1361;
        }
        j = 1;
        label589:
        str = com.tencent.tvkbeacon.core.protocol.a.a.a(bool1, j & bool3, locala.a);
        com.tencent.tvkbeacon.core.c.c.b("[net] module strategy url: %s", new Object[] { str });
        j = i;
        if (!str.equals(localModuleStrategy.url))
        {
          com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , url changed: %s", new Object[] { Byte.valueOf(localModuleStrategy.mId), localModuleStrategy.url });
          j = 1;
          locala.a(localModuleStrategy.url);
        }
        if (localModuleStrategy.mId != 1)
        {
          i = j;
          if (localModuleStrategy.mId != 2) {}
        }
        else
        {
          if ((locala.b() == null) || (localModuleStrategy.detail == null)) {
            break label1002;
          }
          i = j;
          if (!locala.b().equals(localModuleStrategy.detail))
          {
            com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            i = 1;
            locala.a(localModuleStrategy.detail);
            StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(localModuleStrategy.mId, localModuleStrategy.detail);
          }
        }
        j = i;
        if (localModuleStrategy.mId == 1)
        {
          if ((locala.c() == null) || (localModuleStrategy.preventEventCode == null)) {
            break label1083;
          }
          if (!locala.c().equals(localModuleStrategy.preventEventCode))
          {
            label839:
            com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            i = 1;
            locala.a(com.tencent.tvkbeacon.core.c.a.a(localModuleStrategy.preventEventCode));
          }
          label876:
          if ((locala.e() == null) || (localModuleStrategy.sampleEvent == null)) {
            break label1102;
          }
          j = i;
          if (locala.e().equals(localModuleStrategy.sampleEvent)) {}
        }
        label914:
        label1083:
        label1102:
        for (;;)
        {
          com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
          j = 1;
          locala.b(com.tencent.tvkbeacon.core.c.a.a(localModuleStrategy.sampleEvent));
          label1002:
          do
          {
            m = j;
            if (localModuleStrategy.mId != 2) {
              break label1336;
            }
            com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , SpeedMonitorStrategy", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            locala.a(localModuleStrategy.sms);
            m = j;
            break label1336;
            i = j;
            if (localModuleStrategy.detail == null) {
              break;
            }
            i = j;
            if (locala.b() != null) {
              break;
            }
            com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(localModuleStrategy.mId) });
            i = 1;
            locala.a(localModuleStrategy.detail);
            StrategyQueryModule.getInstance(this.a).notifyModuleDetailChanged(localModuleStrategy.mId, localModuleStrategy.detail);
            break;
            if (locala.c() != null) {
              break label839;
            }
            if (localModuleStrategy.preventEventCode == null) {
              break label876;
            }
            break label839;
            if (locala.e() != null) {
              break label914;
            }
            j = i;
          } while (localModuleStrategy.sampleEvent == null);
        }
      }
      localObject2 = localb.e();
      if (localObject2 == null) {
        break label1314;
      }
      n = ((SparseArray)localObject2).size();
      m = 0;
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (m < n)
      {
        localObject3 = (a)((SparseArray)localObject2).valueAt(m);
        if (!((a)localObject3).a()) {
          break label1376;
        }
        com.tencent.tvkbeacon.core.c.c.b("[strategy] mid: %d , server not response strategy, sdk local close it!", new Object[] { Integer.valueOf(((a)localObject3).d()) });
        i = 1;
        ((a)localObject3).a(false);
        break label1376;
        k = 0;
        if ((localObject1 != null) && (localb.d() != null))
        {
          i = k;
          if (!((Map)localObject1).equals(localb.d()))
          {
            localb.a((Map)localObject1);
            i = 1;
          }
        }
        else
        {
          i = k;
          if (localObject1 != null)
          {
            i = k;
            if (localb.d() == null)
            {
              localb.a((Map)localObject1);
              i = 1;
            }
          }
        }
      }
      label1310:
      label1314:
      label1325:
      while (i == 0)
      {
        i = j;
        break;
        do
        {
          j = k;
          break;
          i = j;
        } while (i == 0);
        j = 1;
        break label344;
      }
      i = 1;
      break;
      label1336:
      i = m;
      break label421;
      label1343:
      bool1 = false;
      break label492;
      label1349:
      bool1 = false;
      break label552;
      label1355:
      bool2 = false;
      break label576;
      label1361:
      j = 0;
      break label589;
      label1367:
      n += 1;
      break label388;
      label1376:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.f
 * JD-Core Version:    0.7.0.1
 */