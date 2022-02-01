package com.tencent.mobileqq.magicface.magicfaceaction;

import android.os.Vibrator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceSensorOperation;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Action
{
  public ActionGlobalData a;
  public String b;
  public List<MagicfacePlayRes> c = new ArrayList();
  MagicfacePlayRes d;
  public int e = -1;
  public int f = 1;
  public MagicfacePlayManager g;
  public boolean h;
  public ActionProcess i;
  public volatile boolean j = false;
  volatile boolean k = false;
  int l = 0;
  Vibrator m;
  public boolean n = false;
  CountDownLatch o = new CountDownLatch(1);
  MagicfaceDecoder.MagicPlayListener p = new Action.1(this);
  TimerTask q = new Action.2(this);
  
  public void a(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    int i2 = ((ActionProcess)localObject).d;
    int i1 = i2;
    if (this.i.d > 0)
    {
      i1 = i2;
      if (this.i.d < 40) {
        i1 = this.i.d * 2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("==stopValue=");
      ((StringBuilder)localObject).append(i1);
      QLog.i("Action", 2, ((StringBuilder)localObject).toString());
    }
    if ("end".equalsIgnoreCase(this.i.c))
    {
      if (paramInt >= i1) {
        e();
      }
      return;
    }
    if (("stop".equalsIgnoreCase(this.i.a)) && (paramInt >= i1) && ("mic".equalsIgnoreCase(this.i.b)))
    {
      e();
      if (paramMagicfaceSensorOperation != null) {
        paramMagicfaceSensorOperation.a();
      }
    }
    else if ("record".equalsIgnoreCase(this.i.a))
    {
      paramMagicfaceSensorOperation = this.a;
      paramMagicfaceSensorOperation.i += this.i.a(paramInt);
      if (this.a.m != null)
      {
        paramMagicfaceSensorOperation = this.a;
        paramMagicfaceSensorOperation.k = paramMagicfaceSensorOperation.m.a(this.a.i, this.a.p);
      }
    }
  }
  
  public boolean a()
  {
    this.j = false;
    b();
    this.f = this.d.e;
    this.g.a(this.d.j);
    this.g.a(this.p);
    this.g.a(this.d);
    try
    {
      this.o.await();
      label63:
      if ((this.d.f != null) && (this.d.f.length() > 0)) {
        this.g.a(this.d.f);
      }
      if ((this.m != null) && (this.d.k)) {
        this.m.cancel();
      }
      if ((this.j) && (!this.h)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Action", 2, "===Magicaction is stop====");
      }
      return true;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  void b()
  {
    int i1 = this.c.size();
    if (i1 == 1)
    {
      this.d = ((MagicfacePlayRes)this.c.get(0));
      return;
    }
    if ((i1 > 1) && (this.a.i >= 0))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        MagicfacePlayRes localMagicfacePlayRes = (MagicfacePlayRes)localIterator.next();
        if ((localMagicfacePlayRes.a <= this.a.i) && (localMagicfacePlayRes.b > this.a.i)) {
          this.d = localMagicfacePlayRes;
        }
      }
    }
  }
  
  public void b(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    ActionProcess localActionProcess = this.i;
    if (localActionProcess == null) {
      return;
    }
    if ("end".equalsIgnoreCase(localActionProcess.c))
    {
      if (paramMagicfaceSensorOperation != null) {
        e();
      }
      return;
    }
    if (("stop".equalsIgnoreCase(this.i.a)) && ("touch".equalsIgnoreCase(this.i.b)) && (this.i.e == paramInt))
    {
      e();
      if (paramMagicfaceSensorOperation != null) {
        paramMagicfaceSensorOperation.a();
      }
    }
  }
  
  void c()
  {
    if (this.e > 0) {
      ThreadManager.getTimer().schedule(this.q, this.e * 1000);
    }
  }
  
  public void d()
  {
    this.j = true;
  }
  
  public void e()
  {
    this.k = true;
    this.g.b();
    this.q.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.Action
 * JD-Core Version:    0.7.0.1
 */