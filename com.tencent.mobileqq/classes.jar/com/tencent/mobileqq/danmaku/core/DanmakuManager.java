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
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.render.BaseDanmakuRender;
import com.tencent.mobileqq.danmaku.render.DanmakuViewFactory;
import com.tencent.mobileqq.danmaku.render.IDanmakuView;
import com.tencent.mobileqq.danmaku.render.IDanmakuView.CallBack;
import com.tencent.mobileqq.danmaku.render.SurfaceDanmakuView;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.DanmakuDrawTimer;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.danmaku.util.DanmakuUncaughtExceptionHandler;
import com.tencent.mobileqq.danmaku.util.DanmakuUtils;
import com.tencent.mobileqq.danmaku.util.DrawUtils;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DanmakuManager
  implements View.OnTouchListener, IDanmakuView.CallBack
{
  private static final DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("00.00");
  private static final DecimalFormat jdField_b_of_type_JavaTextDecimalFormat = new DecimalFormat("00");
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private final AbsWindow jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow;
  private final CacheDrawManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager;
  private final DanmakuDataSource jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource;
  private final DanmakuFactory jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuFactory;
  private DanmakuManager.DanmakuHandlerCallback jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$DanmakuHandlerCallback = new DanmakuManager.DanmakuHandlerCallback(this, null);
  private volatile DanmakuManager.IDanmakuListener jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener;
  private final DanmakuMeasureManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager;
  private DanmakuContext jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext;
  private final IDanmakuView jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView;
  private final DanmakuDrawTimer jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer;
  private final PlayerTimer jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer;
  private String jdField_a_of_type_JavaLangString;
  private final List<BaseDanmaku> jdField_a_of_type_JavaUtilList = new LinkedList();
  private final Queue<TouchPoint> jdField_a_of_type_JavaUtilQueue = new LinkedBlockingDeque();
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
  
  public DanmakuManager(View paramView, DanmakuContext paramDanmakuContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramDanmakuContext;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView = DanmakuViewFactory.a(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.a(this);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer = new PlayerTimer();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer = new DanmakuDrawTimer();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager = new CacheDrawManager();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager = new DanmakuMeasureManager(paramDanmakuContext);
    paramView = new DanmakuManager.DanmakuComparator();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource = new DanmakuDataSource(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer, paramView);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow = AbsWindow.a(paramDanmakuContext, this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager, paramView, this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer, this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuFactory = new DanmakuFactory(paramDanmakuContext);
  }
  
  private void A()
  {
    Logger.c("DanmakuManager", "handleRelease()");
    C();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager.a();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.a();
    B();
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BaseDanmakuRender)((Iterator)localObject).next()).a();
        }
      }
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (DanmakuUtils.a()) {
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
    Logger.c("DanmakuManager", "handleClear()");
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.c();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener != null) {
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        TouchPoint localTouchPoint = (TouchPoint)this.jdField_a_of_type_JavaUtilQueue.poll();
        BaseDanmaku localBaseDanmaku = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a(localTouchPoint);
        if (Logger.jdField_a_of_type_Int >= 4) {
          Logger.a("DanmakuManager", new Object[] { "handleClick:", localTouchPoint, ",currentTime:", Long.valueOf(a()) });
        }
        DanmakuDependImp.a().a().a().post(new DanmakuManager.1(this, localBaseDanmaku, localTouchPoint));
      }
    }
    Logger.a("DanmakuManager", "message click");
  }
  
  private void F()
  {
    Logger.c("surface_lock", "handleClearDrawingCache");
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
      Canvas localCanvas = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.a();
      StringBuilder localStringBuilder;
      Object localObject4;
      if (localCanvas != null)
      {
        localObject1 = localCanvas;
        localObject3 = localCanvas;
        DrawUtils.a(localCanvas);
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
        Logger.c("surface_lock", localObject4);
        if (localCanvas != null) {}
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.a(localCanvas);
          Logger.c("surface_lock", "clearDrawing unlockCanvas " + localCanvas.hashCode());
          DanmakuDependImp.a().a().a().post(new DanmakuManager.2(this));
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
              Logger.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localCanvas.hashCode(), localThrowable1);
            }
          }
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.a(localThrowable2);
        Logger.c("surface_lock", "clearDrawing unlockCanvas " + localThrowable2.hashCode());
        DanmakuDependImp.a().a().a().post(new DanmakuManager.2(this));
        throw localObject2;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          if (localThrowable2 != null) {
            Logger.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable2.hashCode(), localThrowable4);
          }
        }
      }
    }
    catch (Throwable localThrowable3)
    {
      if (localThrowable1 != null)
      {
        localObject3 = localThrowable1;
        Logger.a("surface_lock", "clearDrawing lockCanvas exception: " + localThrowable1.hashCode(), localThrowable3);
      }
      if (localThrowable1 != null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.a(localThrowable1);
        Logger.c("surface_lock", "clearDrawing unlockCanvas " + localThrowable1.hashCode());
        DanmakuDependImp.a().a().a().post(new DanmakuManager.2(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (localThrowable1 != null) {
            Logger.a("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + localThrowable1.hashCode(), localThrowable2);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b())
    {
      long l2 = a();
      long l3 = l2 - this.jdField_c_of_type_Long;
      this.jdField_a_of_type_Int += 1;
      this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int + l3));
      if (l3 > 16L)
      {
        this.jdField_b_of_type_Int += 1;
        if (Logger.jdField_a_of_type_Int >= 5) {
          Logger.d("DanmakuManager", "a draw block:" + l3);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
      if (this.jdField_a_of_type_Int % 60 == 1)
      {
        localStringBuilder = new StringBuilder().append(Logger.jdField_a_of_type_Int).append(",t:").append(DanmakuUtils.a(a())).append(",f:");
        if (this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.c() != 0L) {
          break label475;
        }
        l1 = 1L;
        localStringBuilder = localStringBuilder.append(1000L / l1).append(",ds:").append(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a()).append(",ts:").append(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a()).append(",mt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(this.jdField_d_of_type_Long - this.jdField_c_of_type_Long)).append(",lt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(this.jdField_e_of_type_Long - this.jdField_d_of_type_Long)).append(",dt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(l2 - this.jdField_e_of_type_Long)).append(",tt:").append(jdField_b_of_type_JavaTextDecimalFormat.format(l3)).append(",jp:").append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_b_of_type_Int * 100.0F / this.jdField_a_of_type_Int)).append("%,at:").append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_c_of_type_Int / this.jdField_a_of_type_Int)).append(",fd:");
        if (localObject != null) {
          break label486;
        }
      }
    }
    label475:
    label486:
    for (Object localObject = "null";; localObject = DanmakuUtils.a(((BaseDanmaku)localObject).d()))
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject + ",cs:" + jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.a() / 1024.0F / 1024.0F) + ",uc:" + jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.b() * 100.0F / this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.c()));
      if (this.jdField_a_of_type_JavaLangString != null) {
        DrawUtils.a(paramCanvas, this.jdField_a_of_type_JavaLangString);
      }
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.c();
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
      this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.b();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a();
      if (Logger.jdField_a_of_type_Int >= 3) {
        Logger.c("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private boolean a(ClickResult paramClickResult)
  {
    return (c()) && (paramClickResult.jdField_a_of_type_Int != -1);
  }
  
  private void b(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("handleSeek() msg.obj is null = ");
    if (paramMessage.obj == null) {}
    for (boolean bool = true;; bool = false)
    {
      Logger.c("DanmakuManager", bool);
      if (paramMessage.obj != null)
      {
        this.jdField_b_of_type_Long = ((Long)paramMessage.obj).longValue();
        this.jdField_d_of_type_Boolean = true;
        t();
      }
      if (Logger.jdField_a_of_type_Int >= 5) {
        Logger.a("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private void b(List<BaseDanmaku> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)paramList.next();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a(localBaseDanmaku).a(localBaseDanmaku);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuFactory.a(localBaseDanmaku);
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
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView instanceof SurfaceDanmakuView;
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
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DanmakuDrawThreadPriority_" + this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b(), this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b());
        this.jdField_a_of_type_AndroidOsHandlerThread.setUncaughtExceptionHandler(new DanmakuUncaughtExceptionHandler());
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$DanmakuHandlerCallback);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.d("DanmakuManager", new Object[] { localThrowable });
        return;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$DanmakuHandlerCallback);
  }
  
  private void n()
  {
    p();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.c();
      this.jdField_d_of_type_Boolean = false;
    }
    try
    {
      if (Logger.jdField_a_of_type_Int >= 4) {
        this.jdField_c_of_type_Long = a();
      }
      o();
      if (Logger.jdField_a_of_type_Int >= 4) {
        this.jdField_d_of_type_Long = a();
      }
      q();
      if (Logger.jdField_a_of_type_Int >= 4) {
        this.jdField_e_of_type_Long = a();
      }
      r();
      s();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.a("DanmakuManager", localThrowable.toString(), localThrowable);
    }
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
    if (Logger.jdField_a_of_type_Int >= 4)
    {
      int i = ((List)localObject).size();
      if (i > 0) {
        Logger.b("DanmakuManager", new Object[] { "new danmaku to draw:", Integer.valueOf(i) });
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      if (localBaseDanmaku.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a()))
      {
        if (Logger.jdField_a_of_type_Int >= 4) {
          Logger.c("DanmakuManager", new Object[] { "before measure ", localBaseDanmaku, " is out side" });
        }
        this.jdField_a_of_type_JavaUtilList.add(localBaseDanmaku);
      }
      else
      {
        if ((Logger.jdField_a_of_type_Int >= 4) && (localBaseDanmaku.h())) {
          Logger.b("DanmakuManager", "must show danmaku upload to Windown :" + localBaseDanmaku);
        }
        Logger.c("DanmakuManager", "upload, danmaku = " + localBaseDanmaku);
        localBaseDanmaku.c(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a());
        this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a(localBaseDanmaku);
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a(b());
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.b();
    if (Logger.jdField_a_of_type_Int >= 5) {
      Logger.a("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a()), ",lastInterval:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.c()) });
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.b();
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
    //   5: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   8: invokeinterface 282 1 0
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +48 -> 65
    //   20: aload 4
    //   22: astore_2
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokestatic 287	com/tencent/mobileqq/danmaku/util/DrawUtils:a	(Landroid/graphics/Canvas;)V
    //   31: aload 4
    //   33: astore_2
    //   34: aload 4
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 132	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow	Lcom/tencent/mobileqq/danmaku/core/AbsWindow;
    //   41: aload 4
    //   43: aload_0
    //   44: getfield 98	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer	Lcom/tencent/mobileqq/danmaku/tool/PlayerTimer;
    //   47: invokevirtual 588	com/tencent/mobileqq/danmaku/tool/PlayerTimer:a	()J
    //   50: invokevirtual 625	com/tencent/mobileqq/danmaku/core/AbsWindow:a	(Landroid/graphics/Canvas;J)V
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
    //   80: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   83: aload 4
    //   85: invokeinterface 306 2 0
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: aload_0
    //   94: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
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
    //   139: invokestatic 330	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   188: invokestatic 330	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_2
    //   192: ifnull +173 -> 365
    //   195: aload_0
    //   196: monitorenter
    //   197: aload_0
    //   198: getfield 274	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_c_of_type_Boolean	Z
    //   201: ifeq +69 -> 270
    //   204: aload_0
    //   205: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
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
    //   250: invokestatic 330	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   271: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
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
    //   297: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   300: aload_3
    //   301: invokeinterface 306 2 0
    //   306: aload_0
    //   307: monitorexit
    //   308: aload_2
    //   309: athrow
    //   310: aload_0
    //   311: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
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
    //   359: invokestatic 330	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a());
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.d();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      Bitmap localBitmap = localBaseDanmaku.a();
      if (localBitmap != null)
      {
        localBaseDanmaku.a(null);
        localBaseDanmaku.h();
        this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.a(localBitmap);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener.b(this.jdField_a_of_type_JavaUtilList);
    }
    b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void t()
  {
    Logger.c("DanmakuManager", "handleResume()");
    if (!this.jdField_b_of_type_Boolean)
    {
      long l = a();
      this.jdField_a_of_type_Long = (l - this.jdField_b_of_type_Long);
      if (Logger.jdField_a_of_type_Int >= 5) {
        Logger.b("DanmakuManager", "handleResume, mBaseTime = " + this.jdField_a_of_type_Long + ", currentTime = " + l + ", mPauseTime = " + this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.b();
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    u();
    if (Logger.jdField_a_of_type_Int >= 5) {
      Logger.b("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.jdField_b_of_type_Long), ",mBaseTime:", Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  private void u()
  {
    Logger.a("DanmakuManager", "resumeUpdateMessage()");
    if (d()) {
      a(4);
    }
  }
  
  private void v()
  {
    Logger.a("DanmakuManager", "removeUpdateMessage()");
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    }
  }
  
  private void w()
  {
    Logger.a("DanmakuManager", "handelUpdate()");
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
    Logger.c("DanmakuManager", "handlePause()");
    v();
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a()) {}
    for (long l = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a();; l = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a())
    {
      this.jdField_b_of_type_Long = l;
      if (Logger.jdField_a_of_type_Int >= 5) {
        Logger.a("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
    }
  }
  
  private void y()
  {
    Logger.c("DanmakuManager", "handleQuit()");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.b();
    Logger.c("DanmakuManager", "message quit");
  }
  
  private void z()
  {
    Logger.c("DanmakuManager", "handleConfigChanged()");
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.b();
    Logger.c("DanmakuManager", "message config changed");
  }
  
  public long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  public BaseDanmaku a(int paramInt, Object paramObject)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuFactory.a(paramInt, paramObject);
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    Logger.a("DanmakuManager", "start() time = " + paramLong);
    m();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = Long.valueOf(paramLong);
    c(localMessage);
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    paramPoint.y = ((int)(paramPoint.y - this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.a()));
    paramPoint = new TouchPoint(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a(), paramPoint, paramInt);
    if (Logger.jdField_a_of_type_Int >= 4) {
      Logger.a("DanmakuManager", new Object[] { "addClickPoint:", paramPoint });
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 10;
    c(paramPoint);
  }
  
  public void a(DanmakuManager.IDanmakuListener paramIDanmakuListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener = paramIDanmakuListener;
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    paramBaseDanmaku.b(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a());
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager.a(paramBaseDanmaku, new DanmakuManager.5(this));
  }
  
  public void a(List<BaseDanmaku> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager.a(paramList, new DanmakuManager.6(this));
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow instanceof R2LWindow)) {
      return (((R2LWindow)this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow).a()) || ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a()));
    }
    return false;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a()) {
      return a() - this.jdField_a_of_type_Long;
    }
    long l = a();
    if (l - this.f >= 200L)
    {
      this.f = l;
      l = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a();
      this.g = l;
      return l;
    }
    return l + this.g - this.f;
  }
  
  public void b()
  {
    Logger.a("DanmakuManager", "resume()");
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    c(localMessage);
  }
  
  public void b(long paramLong)
  {
    Logger.a("DanmakuManager", "seek(): postime = " + paramLong);
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
          Logger.a("DanmakuManager", "isPrepared() = " + bool + ", mIsSurfaceCreated = " + this.jdField_c_of_type_Boolean + ", mIsQuited = " + this.jdField_a_of_type_Boolean + ", mIsPlaying = " + this.jdField_b_of_type_Boolean);
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void c()
  {
    Logger.c("DanmakuManager", "pause()");
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
    Logger.c("DanmakuManager", "clearDrawingCache()");
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
    Logger.a("DanmakuManager", "clear");
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    c(localMessage);
    H();
  }
  
  public void f()
  {
    Logger.a("DanmakuManager", "quit(); mIsQuited = true");
    this.jdField_a_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    c(localMessage);
  }
  
  public void g()
  {
    Logger.a("DanmakuManager", "release() mIsQuited = " + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      f();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    c(localMessage);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener = null;
  }
  
  public void h()
  {
    Logger.a("DanmakuManager", "notifyConfigChanged()");
    m();
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    c(localMessage);
  }
  
  public void i()
  {
    Logger.c("surface_lock", "surfaceCreated");
  }
  
  public void j()
  {
    Logger.c("surface_lock", "surfaceChanged");
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
      Logger.c("surface_lock", "surfaceDestroyed");
      return;
    }
    finally {}
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$DanmakuHandlerCallback = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView.b();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (Logger.jdField_a_of_type_Int >= 4) {
        Logger.a("DanmakuManager", new Object[] { "onClick:", paramMotionEvent });
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0) {
        a(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()), 0);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager
 * JD-Core Version:    0.7.0.1
 */