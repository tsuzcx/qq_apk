package com.tencent.qav;

import android.content.Context;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.observer.FilterableObserver;
import com.tencent.qav.observer.ObserverDispatcher;

public class QavSDK
  implements IQavSDK
{
  private static volatile QavSDK a;
  private Context b;
  private long c;
  private VideoChannelInterface d;
  private QavCtrl e;
  private boolean f = false;
  
  public static QavSDK a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QavSDK();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    try
    {
      AVLog.c("QavSDK", String.format("initSDK context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), paramVideoChannelInterface }));
      if (this.f)
      {
        AVLog.b("QavSDK", "initSDK has init before");
        return;
      }
      try
      {
        this.b = paramContext.getApplicationContext();
        this.c = paramLong;
        this.d = paramVideoChannelInterface;
        if (this.e == null)
        {
          paramContext = new MultiOperatorImpl(this.b, this.c, this.d);
          this.e = new QavCtrl(this.b, paramContext);
        }
        this.f = true;
      }
      catch (Throwable paramContext)
      {
        AVLog.a("QavSDK", "initSDK fail.", paramContext);
        this.e = null;
        this.f = false;
      }
      return;
    }
    finally {}
  }
  
  public void a(QavCtrl paramQavCtrl)
  {
    this.e = paramQavCtrl;
  }
  
  public void a(FilterableObserver paramFilterableObserver)
  {
    ObserverDispatcher.b().a(paramFilterableObserver, true);
  }
  
  public void b()
  {
    try
    {
      ObserverDispatcher.b().a();
      if (this.e != null)
      {
        this.e.d();
        this.e = null;
      }
      this.b = null;
      this.c = 0L;
      this.d = null;
      this.f = false;
      return;
    }
    finally {}
  }
  
  public void b(FilterableObserver paramFilterableObserver)
  {
    ObserverDispatcher.b().a(paramFilterableObserver);
  }
  
  public IMultiOperator c()
  {
    QavCtrl localQavCtrl = this.e;
    if (localQavCtrl != null) {
      return localQavCtrl.c();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.QavSDK
 * JD-Core Version:    0.7.0.1
 */