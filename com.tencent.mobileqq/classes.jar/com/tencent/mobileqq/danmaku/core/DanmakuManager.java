package com.tencent.mobileqq.danmaku.core;

import amox;
import ampa;
import ampc;
import ampd;
import ampe;
import ampg;
import amph;
import ampi;
import ampj;
import ampk;
import ampl;
import ampn;
import ampo;
import ampx;
import amqo;
import amqq;
import amqu;
import amqv;
import amqw;
import amrb;
import amrc;
import amrh;
import amrl;
import amrn;
import amro;
import amrp;
import amrq;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DanmakuManager
  implements amqv, View.OnTouchListener
{
  private static final DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("00.00");
  private static final DecimalFormat jdField_b_of_type_JavaTextDecimalFormat = new DecimalFormat("00");
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final ampc jdField_a_of_type_Ampc;
  private final ampd jdField_a_of_type_Ampd;
  private final ampe jdField_a_of_type_Ampe;
  private final ampg jdField_a_of_type_Ampg;
  private ampj jdField_a_of_type_Ampj = new ampj(this, null);
  private volatile ampk jdField_a_of_type_Ampk;
  private final ampl jdField_a_of_type_Ampl;
  private ampx jdField_a_of_type_Ampx;
  private final amqu jdField_a_of_type_Amqu;
  private final amrc jdField_a_of_type_Amrc;
  private final amrh jdField_a_of_type_Amrh;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private String jdField_a_of_type_JavaLangString;
  private final List<ampo> jdField_a_of_type_JavaUtilList = new LinkedList();
  private final Queue<amrl> jdField_a_of_type_JavaUtilQueue = new LinkedBlockingDeque();
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private volatile boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private volatile boolean jdField_e_of_type_Boolean = true;
  private long f;
  private long g;
  
  public DanmakuManager(View paramView, ampx paramampx)
  {
    this.jdField_a_of_type_Ampx = paramampx;
    this.jdField_a_of_type_Amqu = amqq.a(paramView);
    if (this.jdField_a_of_type_Amqu != null)
    {
      this.jdField_a_of_type_Amqu.a(this);
      this.jdField_a_of_type_Amqu.a(this);
    }
    this.jdField_a_of_type_Amrh = new amrh();
    this.jdField_a_of_type_Amrc = new amrc();
    this.jdField_a_of_type_Ampd = new ampd();
    this.jdField_a_of_type_Ampl = new ampl(paramampx);
    paramView = new DanmakuManager.DanmakuComparator();
    this.jdField_a_of_type_Ampe = new ampe(this.jdField_a_of_type_Amrh, paramView);
    this.jdField_a_of_type_Ampc = ampc.a(paramampx, this.jdField_a_of_type_Ampd, paramView, this.jdField_a_of_type_Amrh, this.jdField_a_of_type_Amrc);
    this.jdField_a_of_type_Ampg = new ampg(paramampx);
  }
  
  private void A()
  {
    amrq.c("DanmakuManager", "handleRelease()");
    C();
    this.jdField_a_of_type_Ampl.a();
    this.jdField_a_of_type_Ampd.a();
    B();
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_Ampx != null)
    {
      Object localObject = this.jdField_a_of_type_Ampx.a();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((amqo)((Iterator)localObject).next()).a();
        }
      }
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (amro.a()) {
        this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
  }
  
  private void D()
  {
    amrq.c("DanmakuManager", "handleClear()");
    this.jdField_a_of_type_Ampc.c();
    this.jdField_a_of_type_Ampx.b();
    this.jdField_a_of_type_Ampe.a();
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_Ampk != null) {
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        amrl localamrl = (amrl)this.jdField_a_of_type_JavaUtilQueue.poll();
        ampo localampo = this.jdField_a_of_type_Ampc.a(localamrl);
        if (amrq.jdField_a_of_type_Int >= 4) {
          amrq.a("DanmakuManager", new Object[] { "handleClick:", localamrl, ",currentTime:", Long.valueOf(a()) });
        }
        amox.a().a().a().post(new DanmakuManager.1(this, localampo, localamrl));
      }
    }
    amrq.a("DanmakuManager", "message click");
  }
  
  private void F()
  {
    amrq.c("surface_lock", "handleClearDrawingCache");
    v();
    try
    {
      if (!this.jdField_c_of_type_Boolean) {
        return;
      }
      G();
      return;
    }
    finally {}
  }
  
  private void G()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Canvas localCanvas = this.jdField_a_of_type_Amqu.a();
      localObject1 = localCanvas;
      localObject3 = localCanvas;
      StringBuilder localStringBuilder = new StringBuilder().append("clearDrawing lockCanvas ");
      Object localObject4;
      if (localCanvas == null) {
        localObject4 = "null";
      }
      for (;;)
      {
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        amrq.c("surface_lock", localObject4);
        if (localCanvas != null)
        {
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          amrp.a(localCanvas);
        }
        if (localCanvas != null) {}
        try
        {
          this.jdField_a_of_type_Amqu.a(localCanvas);
          amrq.c("surface_lock", "clearDrawing unlockCanvas " + localCanvas.hashCode());
          amox.a().a().a().post(new DanmakuManager.2(this));
          return;
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          int i = localCanvas.hashCode();
          localObject4 = Integer.valueOf(i);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            amrq.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localCanvas.hashCode(), localThrowable1);
          }
        }
      }
      try
      {
        this.jdField_a_of_type_Amqu.a(localThrowable2);
        amrq.c("surface_lock", "clearDrawing unlockCanvas " + localThrowable2.hashCode());
        amox.a().a().a().post(new DanmakuManager.2(this));
        throw localObject2;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          amrq.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable2.hashCode(), localThrowable4);
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      localObject3 = localThrowable1;
      amrq.a("surface_lock", "clearDrawing lockCanvas exception: " + localThrowable1.hashCode(), localThrowable3);
      if (localThrowable1 != null) {}
      try
      {
        this.jdField_a_of_type_Amqu.a(localThrowable1);
        amrq.c("surface_lock", "clearDrawing unlockCanvas " + localThrowable1.hashCode());
        amox.a().a().a().post(new DanmakuManager.2(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          amrq.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable1.hashCode(), localThrowable2);
        }
      }
    }
    finally
    {
      if (localThrowable2 == null) {}
    }
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_Ampe != null) {
      this.jdField_a_of_type_Ampe.a();
    }
  }
  
  private void a(int paramInt)
  {
    if (g())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (g())
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(paramInt);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    StringBuilder localStringBuilder;
    long l1;
    if (this.jdField_a_of_type_Ampx.b())
    {
      long l2 = a();
      long l3 = l2 - this.jdField_c_of_type_Long;
      this.jdField_a_of_type_Int += 1;
      this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int + l3));
      if (l3 > 16L)
      {
        this.jdField_b_of_type_Int += 1;
        if (amrq.jdField_a_of_type_Int >= 5) {
          amrq.d("DanmakuManager", "a draw block:" + l3);
        }
      }
      localObject = this.jdField_a_of_type_Ampe.a();
      if (this.jdField_a_of_type_Int % 60 == 1)
      {
        localStringBuilder = new StringBuilder().append(amrq.jdField_a_of_type_Int).append(",t:").append(amro.a(a())).append(",f:");
        if (this.jdField_a_of_type_Amrc.c() != 0L) {
          break label475;
        }
        l1 = 1L;
        localStringBuilder = localStringBuilder.append(1000L / l1).append(",ds:").append(this.jdField_a_of_type_Ampc.a()).append(",ts:").append(this.jdField_a_of_type_Ampe.a()).append(",mt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long)).append(",lt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(this.jdField_e_of_type_Long - this.jdField_d_of_type_Long)).append(",dt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(l2 - this.jdField_e_of_type_Long)).append(",tt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(l3)).append(",jp:").append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_b_of_type_Int * 100.0F / this.jdField_a_of_type_Int)).append("%,at:").append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_c_of_type_Int / this.jdField_a_of_type_Int)).append(",fd:");
        if (localObject != null) {
          break label486;
        }
      }
    }
    label475:
    label486:
    for (Object localObject = "null";; localObject = amro.a(((ampo)localObject).d()))
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject + ",cs:" + jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_Ampd.a() / 1024.0F / 1024.0F) + ",uc:" + jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_Ampd.b() * 100.0F / this.jdField_a_of_type_Ampd.c()));
      if (this.jdField_a_of_type_JavaLangString != null) {
        amrp.a(paramCanvas, this.jdField_a_of_type_JavaLangString);
      }
      return;
      l1 = this.jdField_a_of_type_Amrc.c();
      break;
    }
  }
  
  private void a(Message paramMessage)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    if (paramMessage.obj != null) {}
    for (this.jdField_b_of_type_Long = ((Long)paramMessage.obj).longValue();; this.jdField_b_of_type_Long = 0L)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Amrc.b();
      this.jdField_a_of_type_Amrc.a();
      if (amrq.jdField_a_of_type_Int >= 3) {
        amrq.c("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private boolean a(amrb paramamrb)
  {
    return (c()) && (paramamrb.jdField_a_of_type_Int != -1);
  }
  
  private void b(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleSeek() msg.obj is null = ");
    if (paramMessage.obj == null) {}
    for (boolean bool = true;; bool = false)
    {
      amrq.c("DanmakuManager", bool);
      if (paramMessage.obj != null)
      {
        this.jdField_b_of_type_Long = ((Long)paramMessage.obj).longValue();
        this.jdField_d_of_type_Boolean = true;
        t();
      }
      if (amrq.jdField_a_of_type_Int >= 5) {
        amrq.a("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private void b(List<ampo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ampo localampo = (ampo)paramList.next();
      this.jdField_a_of_type_Ampx.a(localampo).a(localampo);
      this.jdField_a_of_type_Ampg.a(localampo);
    }
  }
  
  private void c(Message paramMessage)
  {
    if (g()) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive());
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_Amqu instanceof amqw;
  }
  
  private boolean g()
  {
    if (f()) {
      if ((!e()) || (this.jdField_a_of_type_AndroidOsHandler == null)) {}
    }
    while (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private void m()
  {
    if (f())
    {
      if (!e()) {}
      try
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuDrawThreadPriority_" + this.jdField_a_of_type_Ampx.b(), this.jdField_a_of_type_Ampx.b());
        this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new amrn());
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_Ampj);
        return;
      }
      catch (Throwable localThrowable)
      {
        amrq.d("DanmakuManager", new Object[] { localThrowable });
        return;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_Ampj);
  }
  
  private void n()
  {
    p();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_Ampc.c();
      this.jdField_d_of_type_Boolean = false;
    }
    try
    {
      if (amrq.jdField_a_of_type_Int >= 4) {
        this.jdField_c_of_type_Long = a();
      }
      o();
      if (amrq.jdField_a_of_type_Int >= 4) {
        this.jdField_d_of_type_Long = a();
      }
      q();
      if (amrq.jdField_a_of_type_Int >= 4) {
        this.jdField_e_of_type_Long = a();
      }
      r();
      s();
      return;
    }
    catch (Throwable localThrowable)
    {
      amrq.a("DanmakuManager", localThrowable.toString(), localThrowable);
    }
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_Ampe.a();
    if (amrq.jdField_a_of_type_Int >= 4)
    {
      int i = ((List)localObject).size();
      if (i > 0) {
        amrq.b("DanmakuManager", new Object[] { "new danmaku to draw:", Integer.valueOf(i) });
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ampo localampo = (ampo)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      if (localampo.a(this.jdField_a_of_type_Amrh.a()))
      {
        if (amrq.jdField_a_of_type_Int >= 4) {
          amrq.c("DanmakuManager", new Object[] { "before measure ", localampo, " is out side" });
        }
        this.jdField_a_of_type_JavaUtilList.add(localampo);
      }
      else
      {
        if ((amrq.jdField_a_of_type_Int >= 4) && (localampo.h())) {
          amrq.b("DanmakuManager", "must show danmaku upload to Windown :" + localampo);
        }
        amrq.c("DanmakuManager", "upload, danmaku = " + localampo);
        localampo.c(this.jdField_a_of_type_Amrc.a());
        this.jdField_a_of_type_Ampc.a(localampo);
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_Amrh.a(b());
    this.jdField_a_of_type_Amrc.b();
    if (amrq.jdField_a_of_type_Int >= 5) {
      amrq.a("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.jdField_a_of_type_Amrc.a()), ",lastInterval:", Long.valueOf(this.jdField_a_of_type_Amrc.c()) });
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Ampc.b();
  }
  
  /* Error */
  private void r()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amqu	Lamqu;
    //   8: invokeinterface 282 1 0
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +48 -> 65
    //   20: aload 4
    //   22: astore_2
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokestatic 305	amrp:a	(Landroid/graphics/Canvas;)V
    //   31: aload 4
    //   33: astore_2
    //   34: aload 4
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 132	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Ampc	Lampc;
    //   41: aload 4
    //   43: aload_0
    //   44: getfield 98	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amrh	Lamrh;
    //   47: invokevirtual 588	amrh:a	()J
    //   50: invokevirtual 625	ampc:a	(Landroid/graphics/Canvas;J)V
    //   53: aload 4
    //   55: astore_2
    //   56: aload 4
    //   58: astore_3
    //   59: aload_0
    //   60: aload 4
    //   62: invokespecial 626	com/tencent/mobileqq/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   65: aload 4
    //   67: ifnull +298 -> 365
    //   70: aload_0
    //   71: monitorenter
    //   72: aload_0
    //   73: getfield 274	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_c_of_type_Boolean	Z
    //   76: ifeq +17 -> 93
    //   79: aload_0
    //   80: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amqu	Lamqu;
    //   83: aload 4
    //   85: invokeinterface 306 2 0
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: aload_0
    //   94: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amqu	Lamqu;
    //   97: invokeinterface 627 1 0
    //   102: goto -12 -> 90
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: ldc_w 267
    //   114: new 284	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 629
    //   124: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 4
    //   129: invokevirtual 312	java/lang/Object:hashCode	()I
    //   132: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aload_2
    //   139: invokestatic 330	amrq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   142: return
    //   143: astore 5
    //   145: aload_2
    //   146: astore_3
    //   147: new 284	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 631
    //   157: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: astore 6
    //   162: aload_2
    //   163: ifnonnull +91 -> 254
    //   166: ldc_w 293
    //   169: astore 4
    //   171: aload_2
    //   172: astore_3
    //   173: ldc_w 267
    //   176: aload 6
    //   178: aload 4
    //   180: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload 5
    //   188: invokestatic 330	amrq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_2
    //   192: ifnull +173 -> 365
    //   195: aload_0
    //   196: monitorenter
    //   197: aload_0
    //   198: getfield 274	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_c_of_type_Boolean	Z
    //   201: ifeq +69 -> 270
    //   204: aload_0
    //   205: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amqu	Lamqu;
    //   208: aload_2
    //   209: invokeinterface 306 2 0
    //   214: aload_0
    //   215: monitorexit
    //   216: return
    //   217: astore_3
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_3
    //   221: athrow
    //   222: astore_3
    //   223: ldc_w 267
    //   226: new 284	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 629
    //   236: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 312	java/lang/Object:hashCode	()I
    //   243: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: aload_3
    //   250: invokestatic 330	amrq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: return
    //   254: aload_2
    //   255: astore_3
    //   256: aload_2
    //   257: invokevirtual 312	java/lang/Object:hashCode	()I
    //   260: istore_1
    //   261: iload_1
    //   262: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: astore 4
    //   267: goto -96 -> 171
    //   270: aload_0
    //   271: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amqu	Lamqu;
    //   274: invokeinterface 627 1 0
    //   279: goto -65 -> 214
    //   282: astore_2
    //   283: aload_3
    //   284: ifnull +24 -> 308
    //   287: aload_0
    //   288: monitorenter
    //   289: aload_0
    //   290: getfield 274	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_c_of_type_Boolean	Z
    //   293: ifeq +17 -> 310
    //   296: aload_0
    //   297: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amqu	Lamqu;
    //   300: aload_3
    //   301: invokeinterface 306 2 0
    //   306: aload_0
    //   307: monitorexit
    //   308: aload_2
    //   309: athrow
    //   310: aload_0
    //   311: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Amqu	Lamqu;
    //   314: invokeinterface 627 1 0
    //   319: goto -13 -> 306
    //   322: astore 4
    //   324: aload_0
    //   325: monitorexit
    //   326: aload 4
    //   328: athrow
    //   329: astore 4
    //   331: ldc_w 267
    //   334: new 284	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 629
    //   344: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_3
    //   348: invokevirtual 312	java/lang/Object:hashCode	()I
    //   351: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload 4
    //   359: invokestatic 330	amrq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   362: goto -54 -> 308
    //   365: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	DanmakuManager
    //   260	2	1	i	int
    //   3	53	2	localObject1	Object
    //   105	4	2	localObject2	Object
    //   110	147	2	localThrowable1	Throwable
    //   282	27	2	localObject3	Object
    //   1	172	3	localObject4	Object
    //   217	4	3	localObject5	Object
    //   222	28	3	localThrowable2	Throwable
    //   255	93	3	localObject6	Object
    //   13	253	4	localObject7	Object
    //   322	5	4	localObject8	Object
    //   329	29	4	localThrowable3	Throwable
    //   143	44	5	localThrowable4	Throwable
    //   160	17	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   72	90	105	finally
    //   90	92	105	finally
    //   93	102	105	finally
    //   106	108	105	finally
    //   70	72	110	java/lang/Throwable
    //   108	110	110	java/lang/Throwable
    //   4	15	143	java/lang/Throwable
    //   26	31	143	java/lang/Throwable
    //   37	53	143	java/lang/Throwable
    //   59	65	143	java/lang/Throwable
    //   197	214	217	finally
    //   214	216	217	finally
    //   218	220	217	finally
    //   270	279	217	finally
    //   195	197	222	java/lang/Throwable
    //   220	222	222	java/lang/Throwable
    //   4	15	282	finally
    //   26	31	282	finally
    //   37	53	282	finally
    //   59	65	282	finally
    //   147	162	282	finally
    //   173	191	282	finally
    //   256	261	282	finally
    //   289	306	322	finally
    //   306	308	322	finally
    //   310	319	322	finally
    //   324	326	322	finally
    //   287	289	329	java/lang/Throwable
    //   326	329	329	java/lang/Throwable
  }
  
  private void s()
  {
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Ampc.a());
    this.jdField_a_of_type_Ampc.d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ampo localampo = (ampo)localIterator.next();
      Bitmap localBitmap = localampo.a();
      if (localBitmap != null)
      {
        localampo.a(null);
        localampo.h();
        this.jdField_a_of_type_Ampd.a(localBitmap);
      }
    }
    if (this.jdField_a_of_type_Ampk != null) {
      this.jdField_a_of_type_Ampk.b(this.jdField_a_of_type_JavaUtilList);
    }
    b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void t()
  {
    amrq.c("DanmakuManager", "handleResume()");
    if (!this.jdField_b_of_type_Boolean)
    {
      long l = a();
      this.jdField_a_of_type_Long = (l - this.jdField_b_of_type_Long);
      if (amrq.jdField_a_of_type_Int >= 5) {
        amrq.b("DanmakuManager", "handleResume, mBaseTime = " + this.jdField_a_of_type_Long + ", currentTime = " + l + ", mPauseTime = " + this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Amrc.b();
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    u();
    if (amrq.jdField_a_of_type_Int >= 5) {
      amrq.b("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.jdField_b_of_type_Long), ",mBaseTime:", Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  private void u()
  {
    amrq.a("DanmakuManager", "resumeUpdateMessage()");
    if (d()) {
      a(4);
    }
  }
  
  private void v()
  {
    amrq.a("DanmakuManager", "removeUpdateMessage()");
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    }
  }
  
  private void w()
  {
    amrq.a("DanmakuManager", "handelUpdate()");
    v();
    if (b())
    {
      long l = a();
      n();
      a(4, l + 16L - a());
    }
  }
  
  private void x()
  {
    amrq.c("DanmakuManager", "handlePause()");
    v();
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ampx.a()) {}
    for (long l = this.jdField_a_of_type_Amrh.a();; l = this.jdField_a_of_type_Amrc.a())
    {
      this.jdField_b_of_type_Long = l;
      if (amrq.jdField_a_of_type_Int >= 5) {
        amrq.a("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private void y()
  {
    amrq.c("DanmakuManager", "handleQuit()");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ampx.b();
    this.jdField_a_of_type_Ampe.a();
    this.jdField_a_of_type_Ampd.b();
    amrq.c("DanmakuManager", "message quit");
  }
  
  private void z()
  {
    amrq.c("DanmakuManager", "handleConfigChanged()");
    this.jdField_a_of_type_Ampc.a();
    this.jdField_a_of_type_Ampe.b();
    amrq.c("DanmakuManager", "message config changed");
  }
  
  public long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  public ampo a(int paramInt, Object paramObject)
  {
    return this.jdField_a_of_type_Ampg.a(paramInt, paramObject);
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    amrq.a("DanmakuManager", "start() time = " + paramLong);
    m();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = Long.valueOf(paramLong);
    c(localMessage);
  }
  
  public void a(ampk paramampk)
  {
    this.jdField_a_of_type_Ampk = paramampk;
  }
  
  public void a(ampo paramampo)
  {
    paramampo.b(this.jdField_a_of_type_Amrh.a());
    this.jdField_a_of_type_Ampl.a(paramampo, new amph(this));
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    paramPoint.y = ((int)(paramPoint.y - this.jdField_a_of_type_Amqu.a()));
    paramPoint = new amrl(this.jdField_a_of_type_Amrc.a(), paramPoint, paramInt);
    if (amrq.jdField_a_of_type_Int >= 4) {
      amrq.a("DanmakuManager", new Object[] { "addClickPoint:", paramPoint });
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 10;
    c(paramPoint);
  }
  
  public void a(List<ampo> paramList)
  {
    this.jdField_a_of_type_Ampl.a(paramList, new ampi(this));
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Ampc instanceof ampn)) {
      return (((ampn)this.jdField_a_of_type_Ampc).a()) || ((this.jdField_a_of_type_Ampe != null) && (this.jdField_a_of_type_Ampe.a()));
    }
    return false;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Ampx.a()) {
      return a() - this.jdField_a_of_type_Long;
    }
    long l = a();
    if (l - this.f >= 200L)
    {
      this.f = l;
      l = this.jdField_a_of_type_Ampx.a();
      this.g = l;
      return l;
    }
    return l + this.g - this.f;
  }
  
  public void b()
  {
    amrq.a("DanmakuManager", "resume()");
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    c(localMessage);
  }
  
  public void b(long paramLong)
  {
    amrq.a("DanmakuManager", "seek(): postime = " + paramLong);
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    localMessage.obj = Long.valueOf(paramLong);
    c(localMessage);
  }
  
  public boolean b()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
        {
          bool = true;
          amrq.a("DanmakuManager", "isPrepared() = " + bool + ", mIsSurfaceCreated = " + this.jdField_c_of_type_Boolean + ", mIsQuited = " + this.jdField_a_of_type_Boolean + ", mIsPlaying = " + this.jdField_b_of_type_Boolean);
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void c()
  {
    amrq.c("DanmakuManager", "pause()");
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    c(localMessage);
  }
  
  public boolean c()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && (g()))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void d()
  {
    amrq.c("DanmakuManager", "clearDrawingCache()");
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    c(localMessage);
  }
  
  public boolean d()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  public void e()
  {
    amrq.a("DanmakuManager", "clear");
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    c(localMessage);
    H();
  }
  
  public void f()
  {
    amrq.a("DanmakuManager", "quit(); mIsQuited = true");
    this.jdField_a_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    c(localMessage);
  }
  
  public void g()
  {
    amrq.a("DanmakuManager", "release() mIsQuited = " + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      f();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    c(localMessage);
    this.jdField_a_of_type_Ampk = null;
  }
  
  public void h()
  {
    amrq.a("DanmakuManager", "notifyConfigChanged()");
    m();
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    c(localMessage);
  }
  
  public void i()
  {
    amrq.c("surface_lock", "surfaceCreated");
  }
  
  public void j()
  {
    amrq.c("surface_lock", "surfaceChanged");
    try
    {
      this.jdField_c_of_type_Boolean = true;
      u();
      return;
    }
    finally {}
  }
  
  public void k()
  {
    try
    {
      this.jdField_c_of_type_Boolean = false;
      amrq.c("surface_lock", "surfaceDestroyed");
      return;
    }
    finally {}
  }
  
  public void l()
  {
    this.jdField_a_of_type_Ampj = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Amqu != null) {
      this.jdField_a_of_type_Amqu.b();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (amrq.jdField_a_of_type_Int >= 4) {
        amrq.a("DanmakuManager", new Object[] { "onClick:", paramMotionEvent });
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0) {
        a(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()), 0);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager
 * JD-Core Version:    0.7.0.1
 */