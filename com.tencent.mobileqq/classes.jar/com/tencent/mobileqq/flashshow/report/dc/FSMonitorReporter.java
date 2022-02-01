package com.tencent.mobileqq.flashshow.report.dc;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FSMonitorReporter
  implements SimpleEventReceiver, IGuardInterface
{
  private static volatile FSMonitorReporter a;
  private boolean b;
  private long c;
  private long d;
  
  private FSMonitorReporter()
  {
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this);
    }
  }
  
  public static FSMonitorReporter a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSMonitorReporter();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt)
  {
    if (!k())
    {
      QLog.e("FSMonitorReporter", 1, "reportActivateTime invalid timeStamp");
      return;
    }
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(null, null).a(999).b(999).r(String.valueOf(paramInt)).s(String.valueOf(j())).t(String.valueOf(i())));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportActivateTime exitType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,getCurActivateTime:");
    localStringBuilder.append(j());
    localStringBuilder.append("ms ,getTotalActivateTime:");
    localStringBuilder.append(i());
    localStringBuilder.append("ms");
    QLog.d("FSMonitorReporter", 1, localStringBuilder.toString());
  }
  
  private long i()
  {
    return System.currentTimeMillis() - this.c;
  }
  
  private long j()
  {
    return System.currentTimeMillis() - this.d;
  }
  
  private boolean k()
  {
    return (this.c > 0L) && (this.d > 0L);
  }
  
  public void b()
  {
    this.c = System.currentTimeMillis();
    this.d = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activate timeStamp:");
    localStringBuilder.append(this.c);
    QLog.d("FSMonitorReporter", 1, localStringBuilder.toString());
    this.b = true;
  }
  
  public void c()
  {
    this.b = false;
    this.c = 0L;
    this.d = 0L;
    QLog.d("FSMonitorReporter", 1, "inActivate");
  }
  
  public void d()
  {
    if (!this.b) {
      return;
    }
    QLog.d("FSMonitorReporter", 1, "flashShow enter foreground");
    this.d = System.currentTimeMillis();
  }
  
  public void e()
  {
    if (!this.b) {
      return;
    }
    QLog.d("FSMonitorReporter", 1, "flashShow enter background");
    a(2);
  }
  
  public void f()
  {
    if (!this.b) {
      return;
    }
    QLog.d("FSMonitorReporter", 1, "flashShow onFrameTabSelected");
    this.d = System.currentTimeMillis();
  }
  
  public void g()
  {
    if (!this.b) {
      return;
    }
    QLog.d("FSMonitorReporter", 1, "flashShow onFrameTabUnSelected");
    a(1);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ASEngineTabStatusEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    if (!this.b) {
      return;
    }
    QLog.d("FSMonitorReporter", 1, "flashShow onIndividualFolderPageClose");
    a(3);
  }
  
  public void onApplicationBackground()
  {
    e();
  }
  
  public void onApplicationForeground()
  {
    d();
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ASEngineTabStatusEvent))
    {
      if (((ASEngineTabStatusEvent)paramSimpleBaseEvent).isSelected())
      {
        f();
        return;
      }
      g();
    }
  }
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSMonitorReporter
 * JD-Core Version:    0.7.0.1
 */