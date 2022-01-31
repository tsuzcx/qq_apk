package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.q;
import com.tencent.wxop.stat.event.EventType;
import com.tencent.wxop.stat.event.e;
import java.util.Map;

class aq
{
  private static volatile long f = 0L;
  private e a;
  private StatReportStrategy b = null;
  private boolean c = false;
  private Context d = null;
  private long e = System.currentTimeMillis();
  
  public aq(e parame)
  {
    this.a = parame;
    this.b = StatConfig.getStatSendStrategy();
    this.c = parame.f();
    this.d = parame.e();
  }
  
  private void a(h paramh)
  {
    i.b(StatServiceImpl.e()).a(this.a, paramh);
  }
  
  private void b()
  {
    if ((this.a.d() != null) && (this.a.d().isSendImmediately())) {
      this.b = StatReportStrategy.INSTANT;
    }
    if ((StatConfig.j) && (a.a(StatServiceImpl.e()).e())) {
      this.b = StatReportStrategy.INSTANT;
    }
    if (StatConfig.isDebugEnable()) {
      StatServiceImpl.f().i("strategy=" + this.b.name());
    }
    switch (ag.a[this.b.ordinal()])
    {
    default: 
      StatServiceImpl.f().error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
    }
    do
    {
      do
      {
        return;
        c();
        return;
        au.a(this.d).a(this.a, null, this.c, false);
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + StatServiceImpl.c + ",difftime=" + (StatServiceImpl.c - this.e));
        }
        if (StatServiceImpl.c == 0L)
        {
          StatServiceImpl.c = q.a(this.d, "last_period_ts", 0L);
          if (this.e > StatServiceImpl.c) {
            StatServiceImpl.e(this.d);
          }
          long l = this.e + StatConfig.getSendPeriodMinutes() * 60 * 1000;
          if (StatServiceImpl.c > l) {
            StatServiceImpl.c = l;
          }
          d.a(this.d).a();
        }
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + StatServiceImpl.c + ",difftime=" + (StatServiceImpl.c - this.e));
        }
      } while (this.e <= StatServiceImpl.c);
      StatServiceImpl.e(this.d);
      return;
      au.a(this.d).a(this.a, null, this.c, false);
      return;
      au.a(this.d).a(this.a, new ar(this), this.c, true);
      return;
      if (a.a(StatServiceImpl.e()).c() == 1)
      {
        c();
        return;
      }
      au.a(this.d).a(this.a, null, this.c, false);
      return;
    } while (!l.e(this.d));
    a(new as(this));
  }
  
  private void c()
  {
    if ((au.b().a > 0) && (StatConfig.l))
    {
      au.b().a(this.a, null, this.c, true);
      au.b().a(-1);
      return;
    }
    a(new at(this));
  }
  
  private boolean d()
  {
    if (StatConfig.h > 0)
    {
      if (this.e > StatServiceImpl.l())
      {
        StatServiceImpl.m().clear();
        StatServiceImpl.a(this.e + StatConfig.i);
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("clear methodsCalledLimitMap, nextLimitCallClearTime=" + StatServiceImpl.l());
        }
      }
      Integer localInteger1 = Integer.valueOf(this.a.a().a());
      Integer localInteger2 = (Integer)StatServiceImpl.m().get(localInteger1);
      if (localInteger2 != null)
      {
        StatServiceImpl.m().put(localInteger1, Integer.valueOf(localInteger2.intValue() + 1));
        if (localInteger2.intValue() > StatConfig.h)
        {
          if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f().e("event " + this.a.g() + " was discard, cause of called limit, current:" + localInteger2 + ", limit:" + StatConfig.h + ", period:" + StatConfig.i + " ms");
          }
          return true;
        }
      }
      else
      {
        StatServiceImpl.m().put(localInteger1, Integer.valueOf(1));
      }
    }
    return false;
  }
  
  public void a()
  {
    if (d()) {}
    do
    {
      return;
      if ((StatConfig.m > 0) && (this.e >= f))
      {
        StatServiceImpl.flushDataToDB(this.d);
        f = this.e + StatConfig.n;
        if (StatConfig.isDebugEnable()) {
          StatServiceImpl.f().i("nextFlushTime=" + f);
        }
      }
      if (!a.a(this.d).f()) {
        break;
      }
      if (StatConfig.isDebugEnable()) {
        StatServiceImpl.f().i("sendFailedCount=" + StatServiceImpl.a);
      }
      if (!StatServiceImpl.a())
      {
        b();
        return;
      }
      au.a(this.d).a(this.a, null, this.c, false);
    } while (this.e - StatServiceImpl.b <= 1800000L);
    StatServiceImpl.d(this.d);
    return;
    au.a(this.d).a(this.a, null, this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.aq
 * JD-Core Version:    0.7.0.1
 */