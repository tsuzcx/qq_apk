package com.tencent.mobileqq.danmaku.core;

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
import aowq;
import aowt;
import aowv;
import aoww;
import aowx;
import aowz;
import aoxa;
import aoxb;
import aoxc;
import aoxd;
import aoxe;
import aoxg;
import aoxh;
import aoxq;
import aoyh;
import aoyj;
import aoyn;
import aoyo;
import aoyp;
import aoyu;
import aoyv;
import aoza;
import aoze;
import aozg;
import aozh;
import aozi;
import aozj;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DanmakuManager
  implements View.OnTouchListener, aoyo
{
  private static final DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("00.00");
  private static final DecimalFormat jdField_b_of_type_JavaTextDecimalFormat = new DecimalFormat("00");
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final aowv jdField_a_of_type_Aowv;
  private final aoww jdField_a_of_type_Aoww;
  private final aowx jdField_a_of_type_Aowx;
  private final aowz jdField_a_of_type_Aowz;
  private aoxc jdField_a_of_type_Aoxc = new aoxc(this, null);
  private volatile aoxd jdField_a_of_type_Aoxd;
  private final aoxe jdField_a_of_type_Aoxe;
  private aoxq jdField_a_of_type_Aoxq;
  private final aoyn jdField_a_of_type_Aoyn;
  private final aoyv jdField_a_of_type_Aoyv;
  private final aoza jdField_a_of_type_Aoza;
  private String jdField_a_of_type_JavaLangString;
  private final List<aoxh> jdField_a_of_type_JavaUtilList = new LinkedList();
  private final Queue<aoze> jdField_a_of_type_JavaUtilQueue = new LinkedBlockingDeque();
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
  
  public DanmakuManager(View paramView, aoxq paramaoxq)
  {
    this.jdField_a_of_type_Aoxq = paramaoxq;
    this.jdField_a_of_type_Aoyn = aoyj.a(paramView);
    if (this.jdField_a_of_type_Aoyn != null)
    {
      this.jdField_a_of_type_Aoyn.a(this);
      this.jdField_a_of_type_Aoyn.a(this);
    }
    this.jdField_a_of_type_Aoza = new aoza();
    this.jdField_a_of_type_Aoyv = new aoyv();
    this.jdField_a_of_type_Aoww = new aoww();
    this.jdField_a_of_type_Aoxe = new aoxe(paramaoxq);
    paramView = new DanmakuManager.DanmakuComparator();
    this.jdField_a_of_type_Aowx = new aowx(this.jdField_a_of_type_Aoza, paramView);
    this.jdField_a_of_type_Aowv = aowv.a(paramaoxq, this.jdField_a_of_type_Aoww, paramView, this.jdField_a_of_type_Aoza, this.jdField_a_of_type_Aoyv);
    this.jdField_a_of_type_Aowz = new aowz(paramaoxq);
  }
  
  private void A()
  {
    aozj.c("DanmakuManager", "handleRelease()");
    C();
    this.jdField_a_of_type_Aoxe.a();
    this.jdField_a_of_type_Aoww.a();
    B();
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_Aoxq != null)
    {
      Object localObject = this.jdField_a_of_type_Aoxq.a();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((aoyh)((Iterator)localObject).next()).a();
        }
      }
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (aozh.a()) {
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
    aozj.c("DanmakuManager", "handleClear()");
    this.jdField_a_of_type_Aowv.c();
    this.jdField_a_of_type_Aoxq.b();
    this.jdField_a_of_type_Aowx.a();
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_Aoxd != null) {
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        aoze localaoze = (aoze)this.jdField_a_of_type_JavaUtilQueue.poll();
        aoxh localaoxh = this.jdField_a_of_type_Aowv.a(localaoze);
        if (aozj.jdField_a_of_type_Int >= 4) {
          aozj.a("DanmakuManager", new Object[] { "handleClick:", localaoze, ",currentTime:", Long.valueOf(a()) });
        }
        aowq.a().a().a().post(new DanmakuManager.1(this, localaoxh, localaoze));
      }
    }
    aozj.a("DanmakuManager", "message click");
  }
  
  private void F()
  {
    aozj.c("surface_lock", "handleClearDrawingCache");
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
      Canvas localCanvas = this.jdField_a_of_type_Aoyn.a();
      StringBuilder localStringBuilder;
      Object localObject4;
      if (localCanvas != null)
      {
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        aozi.a(localCanvas);
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        localStringBuilder = new StringBuilder().append("clearDrawing lockCanvas ");
        if (localCanvas != null) {
          break label154;
        }
        localObject4 = "null";
      }
      for (;;)
      {
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        aozj.c("surface_lock", localObject4);
        if (localCanvas != null) {}
        try
        {
          this.jdField_a_of_type_Aoyn.a(localCanvas);
          aozj.c("surface_lock", "clearDrawing unlockCanvas " + localCanvas.hashCode());
          aowq.a().a().a().post(new DanmakuManager.2(this));
          return;
          label154:
          localObject1 = localCanvas;
          localObject3 = localCanvas;
          int i = localCanvas.hashCode();
          localObject4 = Integer.valueOf(i);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (localCanvas != null) {
              aozj.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localCanvas.hashCode(), localThrowable1);
            }
          }
        }
      }
      try
      {
        this.jdField_a_of_type_Aoyn.a(localThrowable2);
        aozj.c("surface_lock", "clearDrawing unlockCanvas " + localThrowable2.hashCode());
        aowq.a().a().a().post(new DanmakuManager.2(this));
        throw localObject2;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          if (localThrowable2 != null) {
            aozj.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable2.hashCode(), localThrowable4);
          }
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      if (localThrowable1 != null)
      {
        localObject3 = localThrowable1;
        aozj.a("surface_lock", "clearDrawing lockCanvas exception: " + localThrowable1.hashCode(), localThrowable3);
      }
      if (localThrowable1 != null) {}
      try
      {
        this.jdField_a_of_type_Aoyn.a(localThrowable1);
        aozj.c("surface_lock", "clearDrawing unlockCanvas " + localThrowable1.hashCode());
        aowq.a().a().a().post(new DanmakuManager.2(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (localThrowable1 != null) {
            aozj.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable1.hashCode(), localThrowable2);
          }
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
    if (this.jdField_a_of_type_Aowx != null) {
      this.jdField_a_of_type_Aowx.a();
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
    if (this.jdField_a_of_type_Aoxq.b())
    {
      long l2 = a();
      long l3 = l2 - this.jdField_c_of_type_Long;
      this.jdField_a_of_type_Int += 1;
      this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int + l3));
      if (l3 > 16L)
      {
        this.jdField_b_of_type_Int += 1;
        if (aozj.jdField_a_of_type_Int >= 5) {
          aozj.d("DanmakuManager", "a draw block:" + l3);
        }
      }
      localObject = this.jdField_a_of_type_Aowx.a();
      if (this.jdField_a_of_type_Int % 60 == 1)
      {
        localStringBuilder = new StringBuilder().append(aozj.jdField_a_of_type_Int).append(",t:").append(aozh.a(a())).append(",f:");
        if (this.jdField_a_of_type_Aoyv.c() != 0L) {
          break label475;
        }
        l1 = 1L;
        localStringBuilder = localStringBuilder.append(1000L / l1).append(",ds:").append(this.jdField_a_of_type_Aowv.a()).append(",ts:").append(this.jdField_a_of_type_Aowx.a()).append(",mt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long)).append(",lt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(this.jdField_e_of_type_Long - this.jdField_d_of_type_Long)).append(",dt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(l2 - this.jdField_e_of_type_Long)).append(",tt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(l3)).append(",jp:").append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_b_of_type_Int * 100.0F / this.jdField_a_of_type_Int)).append("%,at:").append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_c_of_type_Int / this.jdField_a_of_type_Int)).append(",fd:");
        if (localObject != null) {
          break label486;
        }
      }
    }
    label475:
    label486:
    for (Object localObject = "null";; localObject = aozh.a(((aoxh)localObject).d()))
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject + ",cs:" + jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_Aoww.a() / 1024.0F / 1024.0F) + ",uc:" + jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_Aoww.b() * 100.0F / this.jdField_a_of_type_Aoww.c()));
      if (this.jdField_a_of_type_JavaLangString != null) {
        aozi.a(paramCanvas, this.jdField_a_of_type_JavaLangString);
      }
      return;
      l1 = this.jdField_a_of_type_Aoyv.c();
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
      this.jdField_a_of_type_Aoyv.b();
      this.jdField_a_of_type_Aoyv.a();
      if (aozj.jdField_a_of_type_Int >= 3) {
        aozj.c("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private boolean a(aoyu paramaoyu)
  {
    return (c()) && (paramaoyu.jdField_a_of_type_Int != -1);
  }
  
  private void b(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleSeek() msg.obj is null = ");
    if (paramMessage.obj == null) {}
    for (boolean bool = true;; bool = false)
    {
      aozj.c("DanmakuManager", bool);
      if (paramMessage.obj != null)
      {
        this.jdField_b_of_type_Long = ((Long)paramMessage.obj).longValue();
        this.jdField_d_of_type_Boolean = true;
        t();
      }
      if (aozj.jdField_a_of_type_Int >= 5) {
        aozj.a("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private void b(List<aoxh> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aoxh localaoxh = (aoxh)paramList.next();
      this.jdField_a_of_type_Aoxq.a(localaoxh).a(localaoxh);
      this.jdField_a_of_type_Aowz.a(localaoxh);
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
    return this.jdField_a_of_type_Aoyn instanceof aoyp;
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
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuDrawThreadPriority_" + this.jdField_a_of_type_Aoxq.b(), this.jdField_a_of_type_Aoxq.b());
        this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new aozg());
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_Aoxc);
        return;
      }
      catch (Throwable localThrowable)
      {
        aozj.d("DanmakuManager", new Object[] { localThrowable });
        return;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_Aoxc);
  }
  
  private void n()
  {
    p();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_Aowv.c();
      this.jdField_d_of_type_Boolean = false;
    }
    try
    {
      if (aozj.jdField_a_of_type_Int >= 4) {
        this.jdField_c_of_type_Long = a();
      }
      o();
      if (aozj.jdField_a_of_type_Int >= 4) {
        this.jdField_d_of_type_Long = a();
      }
      q();
      if (aozj.jdField_a_of_type_Int >= 4) {
        this.jdField_e_of_type_Long = a();
      }
      r();
      s();
      return;
    }
    catch (Throwable localThrowable)
    {
      aozj.a("DanmakuManager", localThrowable.toString(), localThrowable);
    }
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_Aowx.a();
    if (aozj.jdField_a_of_type_Int >= 4)
    {
      int i = ((List)localObject).size();
      if (i > 0) {
        aozj.b("DanmakuManager", new Object[] { "new danmaku to draw:", Integer.valueOf(i) });
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aoxh localaoxh = (aoxh)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      if (localaoxh.a(this.jdField_a_of_type_Aoza.a()))
      {
        if (aozj.jdField_a_of_type_Int >= 4) {
          aozj.c("DanmakuManager", new Object[] { "before measure ", localaoxh, " is out side" });
        }
        this.jdField_a_of_type_JavaUtilList.add(localaoxh);
      }
      else
      {
        if ((aozj.jdField_a_of_type_Int >= 4) && (localaoxh.h())) {
          aozj.b("DanmakuManager", "must show danmaku upload to Windown :" + localaoxh);
        }
        aozj.c("DanmakuManager", "upload, danmaku = " + localaoxh);
        localaoxh.c(this.jdField_a_of_type_Aoyv.a());
        this.jdField_a_of_type_Aowv.a(localaoxh);
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_Aoza.a(b());
    this.jdField_a_of_type_Aoyv.b();
    if (aozj.jdField_a_of_type_Int >= 5) {
      aozj.a("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.jdField_a_of_type_Aoyv.a()), ",lastInterval:", Long.valueOf(this.jdField_a_of_type_Aoyv.c()) });
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Aowv.b();
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
    //   5: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoyn	Laoyn;
    //   8: invokeinterface 282 1 0
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +48 -> 65
    //   20: aload 4
    //   22: astore_2
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokestatic 287	aozi:a	(Landroid/graphics/Canvas;)V
    //   31: aload 4
    //   33: astore_2
    //   34: aload 4
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 132	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aowv	Laowv;
    //   41: aload 4
    //   43: aload_0
    //   44: getfield 98	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoza	Laoza;
    //   47: invokevirtual 588	aoza:a	()J
    //   50: invokevirtual 625	aowv:a	(Landroid/graphics/Canvas;J)V
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
    //   80: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoyn	Laoyn;
    //   83: aload 4
    //   85: invokeinterface 306 2 0
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: aload_0
    //   94: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoyn	Laoyn;
    //   97: invokeinterface 627 1 0
    //   102: goto -12 -> 90
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: ldc_w 267
    //   114: new 289	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 629
    //   124: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload 4
    //   129: invokevirtual 312	java/lang/Object:hashCode	()I
    //   132: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aload_2
    //   139: invokestatic 330	aozj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   142: return
    //   143: astore 5
    //   145: aload_2
    //   146: astore_3
    //   147: new 289	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 631
    //   157: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: astore 6
    //   162: aload_2
    //   163: ifnonnull +91 -> 254
    //   166: ldc_w 298
    //   169: astore 4
    //   171: aload_2
    //   172: astore_3
    //   173: ldc_w 267
    //   176: aload 6
    //   178: aload 4
    //   180: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload 5
    //   188: invokestatic 330	aozj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_2
    //   192: ifnull +173 -> 365
    //   195: aload_0
    //   196: monitorenter
    //   197: aload_0
    //   198: getfield 274	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_c_of_type_Boolean	Z
    //   201: ifeq +69 -> 270
    //   204: aload_0
    //   205: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoyn	Laoyn;
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
    //   226: new 289	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 629
    //   236: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 312	java/lang/Object:hashCode	()I
    //   243: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: aload_3
    //   250: invokestatic 330	aozj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   271: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoyn	Laoyn;
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
    //   297: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoyn	Laoyn;
    //   300: aload_3
    //   301: invokeinterface 306 2 0
    //   306: aload_0
    //   307: monitorexit
    //   308: aload_2
    //   309: athrow
    //   310: aload_0
    //   311: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_Aoyn	Laoyn;
    //   314: invokeinterface 627 1 0
    //   319: goto -13 -> 306
    //   322: astore 4
    //   324: aload_0
    //   325: monitorexit
    //   326: aload 4
    //   328: athrow
    //   329: astore 4
    //   331: ldc_w 267
    //   334: new 289	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 629
    //   344: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_3
    //   348: invokevirtual 312	java/lang/Object:hashCode	()I
    //   351: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload 4
    //   359: invokestatic 330	aozj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Aowv.a());
    this.jdField_a_of_type_Aowv.d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aoxh localaoxh = (aoxh)localIterator.next();
      Bitmap localBitmap = localaoxh.a();
      if (localBitmap != null)
      {
        localaoxh.a(null);
        localaoxh.h();
        this.jdField_a_of_type_Aoww.a(localBitmap);
      }
    }
    if (this.jdField_a_of_type_Aoxd != null) {
      this.jdField_a_of_type_Aoxd.b(this.jdField_a_of_type_JavaUtilList);
    }
    b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void t()
  {
    aozj.c("DanmakuManager", "handleResume()");
    if (!this.jdField_b_of_type_Boolean)
    {
      long l = a();
      this.jdField_a_of_type_Long = (l - this.jdField_b_of_type_Long);
      if (aozj.jdField_a_of_type_Int >= 5) {
        aozj.b("DanmakuManager", "handleResume, mBaseTime = " + this.jdField_a_of_type_Long + ", currentTime = " + l + ", mPauseTime = " + this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Aoyv.b();
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    u();
    if (aozj.jdField_a_of_type_Int >= 5) {
      aozj.b("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.jdField_b_of_type_Long), ",mBaseTime:", Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  private void u()
  {
    aozj.a("DanmakuManager", "resumeUpdateMessage()");
    if (d()) {
      a(4);
    }
  }
  
  private void v()
  {
    aozj.a("DanmakuManager", "removeUpdateMessage()");
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    }
  }
  
  private void w()
  {
    aozj.a("DanmakuManager", "handelUpdate()");
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
    aozj.c("DanmakuManager", "handlePause()");
    v();
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aoxq.a()) {}
    for (long l = this.jdField_a_of_type_Aoza.a();; l = this.jdField_a_of_type_Aoyv.a())
    {
      this.jdField_b_of_type_Long = l;
      if (aozj.jdField_a_of_type_Int >= 5) {
        aozj.a("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private void y()
  {
    aozj.c("DanmakuManager", "handleQuit()");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Aoxq.b();
    this.jdField_a_of_type_Aowx.a();
    this.jdField_a_of_type_Aoww.b();
    aozj.c("DanmakuManager", "message quit");
  }
  
  private void z()
  {
    aozj.c("DanmakuManager", "handleConfigChanged()");
    this.jdField_a_of_type_Aowv.a();
    this.jdField_a_of_type_Aowx.b();
    aozj.c("DanmakuManager", "message config changed");
  }
  
  public long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  public aoxh a(int paramInt, Object paramObject)
  {
    return this.jdField_a_of_type_Aowz.a(paramInt, paramObject);
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    aozj.a("DanmakuManager", "start() time = " + paramLong);
    m();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = Long.valueOf(paramLong);
    c(localMessage);
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    paramPoint.y = ((int)(paramPoint.y - this.jdField_a_of_type_Aoyn.a()));
    paramPoint = new aoze(this.jdField_a_of_type_Aoyv.a(), paramPoint, paramInt);
    if (aozj.jdField_a_of_type_Int >= 4) {
      aozj.a("DanmakuManager", new Object[] { "addClickPoint:", paramPoint });
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 10;
    c(paramPoint);
  }
  
  public void a(aoxd paramaoxd)
  {
    this.jdField_a_of_type_Aoxd = paramaoxd;
  }
  
  public void a(aoxh paramaoxh)
  {
    paramaoxh.b(this.jdField_a_of_type_Aoza.a());
    this.jdField_a_of_type_Aoxe.a(paramaoxh, new aoxa(this));
  }
  
  public void a(List<aoxh> paramList)
  {
    this.jdField_a_of_type_Aoxe.a(paramList, new aoxb(this));
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Aowv instanceof aoxg)) {
      return (((aoxg)this.jdField_a_of_type_Aowv).a()) || ((this.jdField_a_of_type_Aowx != null) && (this.jdField_a_of_type_Aowx.a()));
    }
    return false;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Aoxq.a()) {
      return a() - this.jdField_a_of_type_Long;
    }
    long l = a();
    if (l - this.f >= 200L)
    {
      this.f = l;
      l = this.jdField_a_of_type_Aoxq.a();
      this.g = l;
      return l;
    }
    return l + this.g - this.f;
  }
  
  public void b()
  {
    aozj.a("DanmakuManager", "resume()");
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    c(localMessage);
  }
  
  public void b(long paramLong)
  {
    aozj.a("DanmakuManager", "seek(): postime = " + paramLong);
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
          aozj.a("DanmakuManager", "isPrepared() = " + bool + ", mIsSurfaceCreated = " + this.jdField_c_of_type_Boolean + ", mIsQuited = " + this.jdField_a_of_type_Boolean + ", mIsPlaying = " + this.jdField_b_of_type_Boolean);
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void c()
  {
    aozj.c("DanmakuManager", "pause()");
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
    aozj.c("DanmakuManager", "clearDrawingCache()");
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
    aozj.a("DanmakuManager", "clear");
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    c(localMessage);
    H();
  }
  
  public void f()
  {
    aozj.a("DanmakuManager", "quit(); mIsQuited = true");
    this.jdField_a_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    c(localMessage);
  }
  
  public void g()
  {
    aozj.a("DanmakuManager", "release() mIsQuited = " + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      f();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    c(localMessage);
    this.jdField_a_of_type_Aoxd = null;
  }
  
  public void h()
  {
    aozj.a("DanmakuManager", "notifyConfigChanged()");
    m();
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    c(localMessage);
  }
  
  public void i()
  {
    aozj.c("surface_lock", "surfaceCreated");
  }
  
  public void j()
  {
    aozj.c("surface_lock", "surfaceChanged");
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
      aozj.c("surface_lock", "surfaceDestroyed");
      return;
    }
    finally {}
  }
  
  public void l()
  {
    this.jdField_a_of_type_Aoxc = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Aoyn != null) {
      this.jdField_a_of_type_Aoyn.b();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (aozj.jdField_a_of_type_Int >= 4) {
        aozj.a("DanmakuManager", new Object[] { "onClick:", paramMotionEvent });
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0) {
        a(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()), 0);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager
 * JD-Core Version:    0.7.0.1
 */