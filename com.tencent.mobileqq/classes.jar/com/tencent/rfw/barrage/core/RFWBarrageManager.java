package com.tencent.rfw.barrage.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.RFWBarrageContext;
import com.tencent.rfw.barrage.inject.RFWWindowConfig;
import com.tencent.rfw.barrage.render.IRFWBarrageView;
import com.tencent.rfw.barrage.render.IRFWBarrageView.CallBack;
import com.tencent.rfw.barrage.render.RFWBarrageViewFactory;
import com.tencent.rfw.barrage.render.RFWBaseBarrageRender;
import com.tencent.rfw.barrage.tool.RFWBarrageDrawTimer;
import com.tencent.rfw.barrage.tool.RFWBarrageThreadManager;
import com.tencent.rfw.barrage.tool.RFWBasePlayerTimer;
import com.tencent.rfw.barrage.tool.RFWClickResult;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import com.tencent.rfw.barrage.util.RFWBarrageThreadUtils;
import com.tencent.rfw.barrage.util.RFWQQUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class RFWBarrageManager
  implements View.OnTouchListener, IRFWBarrageView.CallBack
{
  protected volatile AtomicBoolean a = new AtomicBoolean(false);
  protected volatile boolean b = true;
  protected long c;
  protected long d;
  protected RFWBarrageContext e;
  protected final Queue<RFWTouchPoint> f = new LinkedBlockingDeque();
  protected final RFWAbsWindow g;
  protected volatile RFWBarrageManager.IBarrageListener h;
  private volatile AtomicBoolean i = new AtomicBoolean(false);
  private volatile AtomicBoolean j = new AtomicBoolean(false);
  private volatile AtomicBoolean k = new AtomicBoolean(false);
  private Handler l;
  private IRFWBarrageView m;
  private final RFWBarrageDataSource n;
  private final RFWBarrageFactory o;
  private final RFWCacheDrawManager p;
  private final RFWBarrageMeasureManager q;
  private final RFWBasePlayerTimer r;
  private final RFWBarrageDrawTimer s;
  private long t;
  private long u;
  private final List<RFWBaseBarrage> v = new ArrayList();
  private Set<Integer> w = new CopyOnWriteArraySet();
  private final View x;
  private RFWBarrageManager.BarrageHandlerCallback y = new RFWBarrageManager.BarrageHandlerCallback(this, null);
  private boolean z = false;
  
  public RFWBarrageManager(View paramView, RFWBarrageContext paramRFWBarrageContext)
  {
    this.e = paramRFWBarrageContext;
    this.x = paramView;
    q();
    this.r = new RFWBasePlayerTimer();
    this.s = new RFWBarrageDrawTimer();
    this.p = new RFWCacheDrawManager();
    this.q = new RFWBarrageMeasureManager(paramRFWBarrageContext);
    paramView = new RFWBarrageComparator();
    this.n = new RFWBarrageDataSource(this.r, paramView);
    this.g = RFWAbsWindow.a(paramRFWBarrageContext, this.p, paramView, this.r, this.s);
    this.o = new RFWBarrageFactory(paramRFWBarrageContext);
  }
  
  private void A()
  {
    this.g.d();
  }
  
  /* Error */
  private void B()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 159	com/tencent/rfw/barrage/core/RFWBarrageManager:m	Lcom/tencent/rfw/barrage/render/IRFWBarrageView;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload 5
    //   19: astore_2
    //   20: invokestatic 164	com/tencent/rfw/barrage/util/RFWQQUtils:b	()Z
    //   23: ifeq +33 -> 56
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: astore_2
    //   32: ldc 166
    //   34: iconst_2
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: ldc 168
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: aload_0
    //   46: invokevirtual 172	java/lang/Object:hashCode	()I
    //   49: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: aastore
    //   53: invokestatic 183	com/tencent/rfw/barrage/util/RFWBarrageLogger:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload 4
    //   58: astore_3
    //   59: aload 5
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 159	com/tencent/rfw/barrage/core/RFWBarrageManager:m	Lcom/tencent/rfw/barrage/render/IRFWBarrageView;
    //   66: invokeinterface 188 1 0
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: astore_2
    //   79: aload_0
    //   80: invokevirtual 190	com/tencent/rfw/barrage/core/RFWBarrageManager:g	()Z
    //   83: istore_1
    //   84: iload_1
    //   85: ifne +10 -> 95
    //   88: aload_0
    //   89: aload 4
    //   91: invokespecial 193	com/tencent/rfw/barrage/core/RFWBarrageManager:a	(Landroid/graphics/Canvas;)V
    //   94: return
    //   95: aload 4
    //   97: astore_3
    //   98: aload 4
    //   100: astore_2
    //   101: invokestatic 164	com/tencent/rfw/barrage/util/RFWQQUtils:b	()Z
    //   104: ifeq +33 -> 137
    //   107: aload 4
    //   109: astore_3
    //   110: aload 4
    //   112: astore_2
    //   113: ldc 166
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: ldc 195
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_0
    //   127: invokevirtual 172	java/lang/Object:hashCode	()I
    //   130: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 183	com/tencent/rfw/barrage/util/RFWBarrageLogger:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 4
    //   139: astore_2
    //   140: aload 4
    //   142: ifnull +39 -> 181
    //   145: aload 4
    //   147: astore_3
    //   148: aload 4
    //   150: astore_2
    //   151: aload 4
    //   153: invokestatic 198	com/tencent/rfw/barrage/util/RFWDrawUtils:a	(Landroid/graphics/Canvas;)V
    //   156: aload 4
    //   158: astore_3
    //   159: aload 4
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 145	com/tencent/rfw/barrage/core/RFWBarrageManager:g	Lcom/tencent/rfw/barrage/core/RFWAbsWindow;
    //   166: aload 4
    //   168: aload_0
    //   169: getfield 111	com/tencent/rfw/barrage/core/RFWBarrageManager:r	Lcom/tencent/rfw/barrage/tool/RFWBasePlayerTimer;
    //   172: invokevirtual 201	com/tencent/rfw/barrage/tool/RFWBasePlayerTimer:a	()J
    //   175: invokevirtual 204	com/tencent/rfw/barrage/core/RFWAbsWindow:a	(Landroid/graphics/Canvas;J)V
    //   178: aload 4
    //   180: astore_2
    //   181: aload_0
    //   182: aload_2
    //   183: invokespecial 193	com/tencent/rfw/barrage/core/RFWBarrageManager:a	(Landroid/graphics/Canvas;)V
    //   186: return
    //   187: astore_2
    //   188: goto +75 -> 263
    //   191: astore 5
    //   193: aload_2
    //   194: astore_3
    //   195: new 206	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   202: astore 6
    //   204: aload_2
    //   205: astore_3
    //   206: aload 6
    //   208: ldc 209
    //   210: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: ifnonnull +10 -> 225
    //   218: ldc 215
    //   220: astore 4
    //   222: goto +14 -> 236
    //   225: aload_2
    //   226: astore_3
    //   227: aload_2
    //   228: invokevirtual 172	java/lang/Object:hashCode	()I
    //   231: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: astore 4
    //   236: aload_2
    //   237: astore_3
    //   238: aload 6
    //   240: aload 4
    //   242: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_2
    //   247: astore_3
    //   248: ldc 166
    //   250: aload 6
    //   252: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: aload 5
    //   257: invokestatic 225	com/tencent/rfw/barrage/util/RFWBarrageLogger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -79 -> 181
    //   263: aload_0
    //   264: aload_3
    //   265: invokespecial 193	com/tencent/rfw/barrage/core/RFWBarrageManager:a	(Landroid/graphics/Canvas;)V
    //   268: goto +5 -> 273
    //   271: aload_2
    //   272: athrow
    //   273: goto -2 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	RFWBarrageManager
    //   83	2	1	bool	boolean
    //   19	164	2	localObject1	Object
    //   187	85	2	localObject2	Object
    //   16	249	3	localObject3	Object
    //   12	229	4	localObject4	Object
    //   9	51	5	localObject5	Object
    //   191	65	5	localThrowable	Throwable
    //   202	49	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	26	187	finally
    //   32	56	187	finally
    //   62	73	187	finally
    //   79	84	187	finally
    //   101	107	187	finally
    //   113	137	187	finally
    //   151	156	187	finally
    //   162	178	187	finally
    //   195	204	187	finally
    //   206	214	187	finally
    //   227	236	187	finally
    //   238	246	187	finally
    //   248	260	187	finally
    //   20	26	191	java/lang/Throwable
    //   32	56	191	java/lang/Throwable
    //   62	73	191	java/lang/Throwable
    //   79	84	191	java/lang/Throwable
    //   101	107	191	java/lang/Throwable
    //   113	137	191	java/lang/Throwable
    //   151	156	191	java/lang/Throwable
    //   162	178	191	java/lang/Throwable
  }
  
  private void C()
  {
    Object localObject = this.g;
    if (localObject != null) {
      localObject = ((RFWAbsWindow)localObject).a();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)((Iterator)localObject).next();
        localRFWBaseBarrage.l();
        Bitmap localBitmap = localRFWBaseBarrage.K();
        if (localBitmap != null)
        {
          localRFWBaseBarrage.a(null);
          localRFWBaseBarrage.O();
          this.p.a(localBitmap);
          this.v.add(localRFWBaseBarrage);
        }
      }
    }
    this.g.b();
    b(this.v);
    a(this.v);
    this.v.clear();
  }
  
  private void D()
  {
    RFWBarrageDataSource localRFWBarrageDataSource = this.n;
    int i1;
    if (localRFWBarrageDataSource == null) {
      i1 = -1;
    } else {
      i1 = localRFWBarrageDataSource.c();
    }
    if (i1 > 0)
    {
      if (i1 > 10) {
        return;
      }
      if (this.z)
      {
        RFWBarrageLogger.b("RFWBarrageManager", "[handleDataSourceLoadMore] handle data source load more flag == true.");
        return;
      }
      a(true);
      F();
    }
  }
  
  private void E()
  {
    if (this.h == null) {
      return;
    }
    this.h.a();
  }
  
  private void F()
  {
    if (this.h == null) {
      return;
    }
    this.h.b();
  }
  
  private void G()
  {
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleStart] handle barrage resume, hash code: ", Integer.valueOf(hashCode()) });
    if (!this.j.get())
    {
      this.t = (j() - this.u);
      RFWBarrageDrawTimer localRFWBarrageDrawTimer = this.s;
      if (localRFWBarrageDrawTimer != null) {
        localRFWBarrageDrawTimer.d();
      }
    }
    this.j.set(true);
    H();
  }
  
  private void H()
  {
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[resumeUpdateMessage] resume update message, hash code: ", Integer.valueOf(hashCode()) });
    if (i()) {
      a(4);
    }
  }
  
  private void I()
  {
    Handler localHandler = this.l;
    if (localHandler != null) {
      localHandler.removeMessages(4);
    }
  }
  
  private void J()
  {
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handlePause] handle pause message, hash code: ", Integer.valueOf(hashCode()) });
    I();
    this.j.set(false);
    long l1;
    if (this.e.d()) {
      l1 = this.r.a();
    } else {
      l1 = this.s.b();
    }
    this.u = l1;
  }
  
  private void K()
  {
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleQuit] handle quit message start, hash code: ", Integer.valueOf(hashCode()) });
    this.i.set(true);
    Object localObject = this.e;
    if (localObject != null) {
      ((RFWBarrageContext)localObject).f();
    }
    localObject = this.n;
    if (localObject != null) {
      ((RFWBarrageDataSource)localObject).b();
    }
    localObject = this.w;
    if (localObject != null) {
      ((Set)localObject).clear();
    }
    localObject = this.p;
    if (localObject != null) {
      ((RFWCacheDrawManager)localObject).b();
    }
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleQuit] handle quit message end, hash code: ", Integer.valueOf(hashCode()) });
  }
  
  private void L()
  {
    RFWBarrageLogger.c("RFWBarrageManager", "[handleConfigChanged] reload config start.");
    Object localObject = this.g;
    if (localObject != null) {
      ((RFWAbsWindow)localObject).c();
    }
    localObject = this.n;
    if (localObject != null) {
      ((RFWBarrageDataSource)localObject).d();
    }
    RFWBarrageLogger.c("RFWBarrageManager", "[handleConfigChanged] reload config end.");
  }
  
  private void M()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = ((RFWBarrageContext)localObject).h();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RFWBaseBarrageRender)((Iterator)localObject).next()).a();
    }
  }
  
  private void N()
  {
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleClear] handle clear message, hash code: ", Integer.valueOf(hashCode()) });
    Object localObject = this.g;
    if (localObject != null) {
      ((RFWAbsWindow)localObject).e();
    }
    localObject = this.e;
    if (localObject != null) {
      ((RFWBarrageContext)localObject).f();
    }
    localObject = this.n;
    if (localObject != null) {
      ((RFWBarrageDataSource)localObject).b();
    }
    localObject = this.w;
    if (localObject != null) {
      ((Set)localObject).clear();
    }
    a();
  }
  
  private void O()
  {
    if (this.h == null)
    {
      RFWBarrageLogger.b("RFWBarrageManager", "[handleClick] barrage listener should not be null.");
      return;
    }
    if (this.f == null)
    {
      RFWBarrageLogger.b("RFWBarrageManager", "[handleClick] touch points should not be null.");
      return;
    }
    if (this.g == null)
    {
      RFWBarrageLogger.b("RFWBarrageManager", "[handleClick] r2l window should not be null.");
      return;
    }
    while (!this.f.isEmpty())
    {
      RFWTouchPoint localRFWTouchPoint = (RFWTouchPoint)this.f.poll();
      RFWBaseBarrage localRFWBaseBarrage = this.g.a(localRFWTouchPoint);
      if (RFWQQUtils.b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleClick] point: ");
        localStringBuilder.append(localRFWTouchPoint);
        localStringBuilder.append(" | currentTime:");
        localStringBuilder.append(j());
        RFWBarrageLogger.a("RFWBarrageManager", localStringBuilder.toString());
      }
      RFWBarrageThreadUtils.a().a(new RFWBarrageManager.ClickBarrageRunnableImpl(this, localRFWTouchPoint, localRFWBaseBarrage));
    }
    if (RFWQQUtils.b()) {
      RFWBarrageLogger.a("RFWBarrageManager", "[handleClick] message click.");
    }
  }
  
  private boolean P()
  {
    if (v()) {
      return (u()) && (this.l != null);
    }
    return this.l != null;
  }
  
  private void Q()
  {
    RFWBarrageLogger.c("RFWBarrageManager", new Object[] { "[handleClearDrawingCache] handle clear drawing cache, hash code: ", Integer.valueOf(hashCode()) });
    I();
    if (this.k.get()) {
      R();
    }
  }
  
  /* Error */
  private void R()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 159	com/tencent/rfw/barrage/core/RFWBarrageManager:m	Lcom/tencent/rfw/barrage/render/IRFWBarrageView;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aconst_null
    //   11: astore_1
    //   12: aconst_null
    //   13: astore_2
    //   14: aload_3
    //   15: invokeinterface 188 1 0
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: ifnull +162 -> 186
    //   27: aload_3
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: aload_3
    //   32: invokestatic 198	com/tencent/rfw/barrage/util/RFWDrawUtils:a	(Landroid/graphics/Canvas;)V
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: astore_1
    //   39: new 206	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   46: astore 5
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: astore_1
    //   52: aload 5
    //   54: ldc_w 432
    //   57: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: ifnonnull +10 -> 72
    //   65: ldc 215
    //   67: astore 4
    //   69: goto +16 -> 85
    //   72: aload_3
    //   73: astore_2
    //   74: aload_3
    //   75: astore_1
    //   76: aload_3
    //   77: invokevirtual 172	java/lang/Object:hashCode	()I
    //   80: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: astore 4
    //   85: aload_3
    //   86: astore_2
    //   87: aload_3
    //   88: astore_1
    //   89: aload 5
    //   91: aload 4
    //   93: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_3
    //   98: astore_2
    //   99: aload_3
    //   100: astore_1
    //   101: ldc 166
    //   103: aload 5
    //   105: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 359	com/tencent/rfw/barrage/util/RFWBarrageLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_3
    //   112: astore_2
    //   113: goto +73 -> 186
    //   116: astore_1
    //   117: goto +62 -> 179
    //   120: astore_3
    //   121: aload_1
    //   122: astore_2
    //   123: aload_1
    //   124: ifnull +62 -> 186
    //   127: aload_1
    //   128: astore_2
    //   129: new 206	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   136: astore 4
    //   138: aload_1
    //   139: astore_2
    //   140: aload 4
    //   142: ldc_w 434
    //   145: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: astore_2
    //   151: aload 4
    //   153: aload_1
    //   154: invokevirtual 172	java/lang/Object:hashCode	()I
    //   157: invokevirtual 437	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: astore_2
    //   163: ldc 166
    //   165: aload 4
    //   167: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: aload_3
    //   171: invokestatic 225	com/tencent/rfw/barrage/util/RFWBarrageLogger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_1
    //   175: astore_2
    //   176: goto +10 -> 186
    //   179: aload_0
    //   180: aload_2
    //   181: invokespecial 193	com/tencent/rfw/barrage/core/RFWBarrageManager:a	(Landroid/graphics/Canvas;)V
    //   184: aload_1
    //   185: athrow
    //   186: aload_0
    //   187: aload_2
    //   188: invokespecial 193	com/tencent/rfw/barrage/core/RFWBarrageManager:a	(Landroid/graphics/Canvas;)V
    //   191: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	RFWBarrageManager
    //   11	90	1	localObject1	Object
    //   116	69	1	localObject2	Object
    //   13	175	2	localObject3	Object
    //   4	108	3	localObject4	Object
    //   120	51	3	localThrowable	Throwable
    //   67	99	4	localObject5	Object
    //   46	58	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	21	116	finally
    //   31	35	116	finally
    //   39	48	116	finally
    //   52	61	116	finally
    //   76	85	116	finally
    //   89	97	116	finally
    //   101	111	116	finally
    //   129	138	116	finally
    //   140	149	116	finally
    //   151	161	116	finally
    //   163	174	116	finally
    //   14	21	120	java/lang/Throwable
    //   31	35	120	java/lang/Throwable
    //   39	48	120	java/lang/Throwable
    //   52	61	120	java/lang/Throwable
    //   76	85	120	java/lang/Throwable
    //   89	97	120	java/lang/Throwable
    //   101	111	120	java/lang/Throwable
  }
  
  private void a(int paramInt)
  {
    if (this.l == null) {
      return;
    }
    if (P())
    {
      this.l.removeMessages(paramInt);
      this.l.sendEmptyMessage(paramInt);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.l == null) {
      return;
    }
    if (P())
    {
      this.l.removeMessages(paramInt);
      this.l.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {
      return;
    }
    if (this.m == null) {
      return;
    }
    try
    {
      if (RFWQQUtils.b()) {
        RFWBarrageLogger.a("RFWBarrageManager", "[safeUnlockCanvas] unlock start.");
      }
      if (this.k.get()) {
        this.m.a(paramCanvas);
      } else {
        this.m.c();
      }
      if (RFWQQUtils.b())
      {
        RFWBarrageLogger.a("RFWBarrageManager", "[safeUnlockCanvas] unlock end.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unlockCanvas exception ");
      localStringBuilder.append(paramCanvas.hashCode());
      RFWBarrageLogger.a("RFWBarrageManager", localStringBuilder.toString(), localThrowable);
    }
  }
  
  private void a(RFWTouchPoint paramRFWTouchPoint, RFWBaseBarrage paramRFWBaseBarrage)
  {
    if (this.h == null) {
      return;
    }
    if (paramRFWBaseBarrage == null)
    {
      this.h.a(false);
      return;
    }
    paramRFWTouchPoint.a(paramRFWBaseBarrage.F(), paramRFWBaseBarrage.G());
    RFWClickResult localRFWClickResult = paramRFWBaseBarrage.a(paramRFWTouchPoint);
    if (a(localRFWClickResult))
    {
      this.h.a(true);
      if (localRFWClickResult.b) {
        this.g.b(paramRFWBaseBarrage);
      }
      this.h.a(paramRFWBaseBarrage, paramRFWTouchPoint, localRFWClickResult);
      return;
    }
    this.h.a(false);
  }
  
  private void a(List<RFWBaseBarrage> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)paramList.next();
      Object localObject = this.e.a(localRFWBaseBarrage);
      if (localObject != null) {
        ((RFWBaseBarrageRender)localObject).c(localRFWBaseBarrage);
      }
      localObject = this.o;
      if (localObject != null) {
        ((RFWBarrageFactory)localObject).a(localRFWBaseBarrage);
      }
    }
  }
  
  private void b(List<RFWBaseBarrage> paramList)
  {
    if (this.h == null) {
      return;
    }
    this.h.a(paramList);
  }
  
  private void c(Message paramMessage)
  {
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleStart] handle barrage start, hash code: ", Integer.valueOf(hashCode()) });
    this.i.set(false);
    this.a.set(true);
    if (paramMessage.obj != null) {
      this.u = ((Long)paramMessage.obj).longValue();
    } else {
      this.u = 0L;
    }
    paramMessage = this.w;
    if (paramMessage != null) {
      paramMessage.clear();
    }
    paramMessage = this.s;
    if (paramMessage != null)
    {
      paramMessage.d();
      this.s.a();
    }
  }
  
  private void c(RFWBaseBarrage paramRFWBaseBarrage)
  {
    int i1;
    if (paramRFWBaseBarrage == null) {
      i1 = -1;
    } else {
      i1 = paramRFWBaseBarrage.hashCode();
    }
    if (i1 != -1) {
      this.w.remove(Integer.valueOf(i1));
    }
    int i3 = this.w.size();
    paramRFWBaseBarrage = this.n;
    int i2;
    if (paramRFWBaseBarrage == null) {
      i2 = 0;
    } else {
      i2 = paramRFWBaseBarrage.c();
    }
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleLeftDrawEnd] barrage: ", Integer.valueOf(i1), " | screenShowCount: ", Integer.valueOf(i3), " | queueCount: ", Integer.valueOf(i2) });
    y();
  }
  
  private void d(RFWBaseBarrage paramRFWBaseBarrage)
  {
    int i1;
    if (paramRFWBaseBarrage == null) {
      i1 = -1;
    } else {
      i1 = paramRFWBaseBarrage.hashCode();
    }
    if (i1 != -1) {
      this.w.add(Integer.valueOf(i1));
    }
    int i3 = this.w.size();
    paramRFWBaseBarrage = this.n;
    int i2;
    if (paramRFWBaseBarrage == null) {
      i2 = 0;
    } else {
      i2 = paramRFWBaseBarrage.c();
    }
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleLeftDrawStart] barrage: ", Integer.valueOf(i1), " | screenShowCount: ", Integer.valueOf(i3), " | queueCount: ", Integer.valueOf(i2) });
    D();
  }
  
  private void e(RFWBaseBarrage paramRFWBaseBarrage)
  {
    int i1;
    if (paramRFWBaseBarrage == null) {
      i1 = -1;
    } else {
      i1 = paramRFWBaseBarrage.hashCode();
    }
    if (i1 != -1) {
      this.w.remove(Integer.valueOf(i1));
    }
    int i3 = this.w.size();
    paramRFWBaseBarrage = this.n;
    int i2;
    if (paramRFWBaseBarrage == null) {
      i2 = 0;
    } else {
      i2 = paramRFWBaseBarrage.c();
    }
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handlerLeftDrawDelete] barrage: ", Integer.valueOf(i1), " | screenShowCount: ", Integer.valueOf(i3), " | queueCount: ", Integer.valueOf(i2) });
    y();
  }
  
  private void q()
  {
    r();
    Object localObject = this.x;
    if (localObject == null)
    {
      RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handlerCreateBarrageView] current base barrage view should not is null, hash code: ", Integer.valueOf(hashCode()) });
      return;
    }
    this.m = RFWBarrageViewFactory.a((View)localObject);
    localObject = this.m;
    if (localObject == null)
    {
      RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[createBarrageView] create barrage view should not is null, hash code: ", Integer.valueOf(hashCode()) });
      return;
    }
    int i1;
    if (localObject == null) {
      i1 = -1;
    } else {
      i1 = localObject.hashCode();
    }
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[createBarrageView] create barrage view, barrage: ", Integer.valueOf(i1), " | manager: ", Integer.valueOf(hashCode()) });
    this.m.a(this);
    this.m.a(this);
  }
  
  private void r()
  {
    Handler localHandler = this.l;
    if (localHandler == null) {
      return;
    }
    localHandler.removeMessages(4);
  }
  
  private void s()
  {
    RFWBarrageLogger.b("RFWBarrageManager", "[destroy] barrage logger destroy...");
    this.y = null;
    Handler localHandler = this.l;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.l = null;
    }
  }
  
  private void t()
  {
    if (!v())
    {
      this.l = new Handler(Looper.getMainLooper(), this.y);
      return;
    }
    if ((!u()) || (this.l == null)) {
      try
      {
        this.l = new Handler(RFWBarrageThreadManager.a(this.e).c(), this.y);
        return;
      }
      catch (Throwable localThrowable)
      {
        RFWBarrageLogger.d("RFWBarrageManager", new Object[] { localThrowable });
      }
    }
  }
  
  private boolean u()
  {
    HandlerThread localHandlerThread = RFWBarrageThreadManager.a(this.e).b();
    return (localHandlerThread != null) && (localHandlerThread.isAlive());
  }
  
  private boolean v()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void w()
  {
    if (RFWQQUtils.b()) {
      RFWBarrageLogger.a("RFWBarrageManager", "[quit] send quit message.");
    }
    this.i.set(true);
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    b(localMessage);
  }
  
  private void x()
  {
    Iterator localIterator = this.n.a().iterator();
    while (localIterator.hasNext())
    {
      RFWBaseBarrage localRFWBaseBarrage = (RFWBaseBarrage)localIterator.next();
      localIterator.remove();
      if ((localRFWBaseBarrage.a(this.r.a())) && (!localRFWBaseBarrage.p()))
      {
        this.v.add(localRFWBaseBarrage);
      }
      else
      {
        localRFWBaseBarrage.h(this.s.b());
        localRFWBaseBarrage.a(new RFWBarrageManager.HitLeftSideCallback(this));
        this.g.a(localRFWBaseBarrage);
      }
    }
  }
  
  private void y()
  {
    int i2 = this.w.size();
    RFWBarrageDataSource localRFWBarrageDataSource = this.n;
    int i1;
    if (localRFWBarrageDataSource == null) {
      i1 = 0;
    } else {
      i1 = localRFWBarrageDataSource.c();
    }
    if (i2 <= 0)
    {
      if (i1 > 0) {
        return;
      }
      E();
    }
  }
  
  private void z()
  {
    this.r.a(k());
    this.s.c();
  }
  
  public RFWBaseBarrage a(int paramInt, Object paramObject)
  {
    return this.o.a(paramInt, paramObject);
  }
  
  public void a()
  {
    RFWBarrageDataSource localRFWBarrageDataSource = this.n;
    if (localRFWBarrageDataSource == null) {
      return;
    }
    localRFWBarrageDataSource.b();
    this.w.clear();
  }
  
  public void a(long paramLong)
  {
    if (RFWQQUtils.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[start] start time: ");
      ((StringBuilder)localObject).append(paramLong);
      RFWBarrageLogger.a("RFWBarrageManager", ((StringBuilder)localObject).toString());
    }
    t();
    Object localObject = Message.obtain();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = Long.valueOf(paramLong);
    b((Message)localObject);
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    if (this.m == null)
    {
      if (paramPoint == null) {
        paramInt = 0;
      } else {
        paramInt = paramPoint.x;
      }
      int i1;
      if (paramPoint == null) {
        i1 = 0;
      } else {
        i1 = paramPoint.y;
      }
      RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[addClickPoint] add click point x: ", Integer.valueOf(paramInt), " | y: ", Integer.valueOf(i1) });
      return;
    }
    paramPoint.y = ((int)(paramPoint.y - this.m.b()));
    paramPoint = new RFWTouchPoint(this.s.b(), paramPoint, paramInt);
    this.f.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 9;
    b(paramPoint);
  }
  
  protected void a(Message paramMessage)
  {
    int i1 = hashCode();
    Object localObject;
    if (paramMessage == null) {
      localObject = null;
    } else {
      localObject = paramMessage.obj;
    }
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleSeek] handle seek message, hash code: ", Integer.valueOf(i1), " | msg value: ", localObject });
    if (paramMessage.obj != null)
    {
      this.u = ((Long)paramMessage.obj).longValue();
      this.a.set(true);
      G();
    }
  }
  
  public void a(RFWBarrageManager.IBarrageListener paramIBarrageListener)
  {
    this.h = paramIBarrageListener;
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    RFWBarrageMeasureManager localRFWBarrageMeasureManager = this.q;
    if (localRFWBarrageMeasureManager == null) {
      return;
    }
    localRFWBarrageMeasureManager.a(paramRFWBaseBarrage);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateLoadMoreFlag] update isNotifyLoadMore: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" | current: ");
    localStringBuilder.append(this.z);
    RFWBarrageLogger.c("RFWBarrageManager", localStringBuilder.toString());
    this.z = paramBoolean;
  }
  
  protected boolean a(RFWClickResult paramRFWClickResult)
  {
    boolean bool2 = h();
    boolean bool1;
    if (paramRFWClickResult.a != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[isClickValid] isStartedAndBarrageViewCreated: ", Boolean.valueOf(bool2), " |isNotRegionInvalid: ", Boolean.valueOf(bool1) });
    return (bool2) && (bool1);
  }
  
  public void b()
  {
    a(0L);
  }
  
  protected void b(Message paramMessage)
  {
    if (this.l == null) {
      return;
    }
    if (P()) {
      this.l.sendMessage(paramMessage);
    }
  }
  
  public void b(RFWBaseBarrage paramRFWBaseBarrage)
  {
    RFWBarrageDataSource localRFWBarrageDataSource = this.n;
    if (localRFWBarrageDataSource == null) {
      return;
    }
    localRFWBarrageDataSource.a(paramRFWBaseBarrage);
  }
  
  public void c()
  {
    if (RFWQQUtils.b()) {
      RFWBarrageLogger.a("RFWBarrageManager", "[resume] send resume message.");
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    b(localMessage);
  }
  
  public void d()
  {
    if (RFWQQUtils.b()) {
      RFWBarrageLogger.c("RFWBarrageManager", "[pause] send pause message.");
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    b(localMessage);
  }
  
  public void e()
  {
    if (RFWQQUtils.b()) {
      RFWBarrageLogger.a("RFWBarrageManager", new Object[] { "[release] send release message, quited: ", Boolean.valueOf(this.i.get()) });
    }
    M();
    if (!this.i.get()) {
      w();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    b(localMessage);
    this.h = null;
  }
  
  protected void f()
  {
    z();
    if (this.a.get())
    {
      this.g.e();
      this.a.set(false);
    }
    try
    {
      x();
      A();
      B();
      C();
      return;
    }
    catch (Throwable localThrowable)
    {
      RFWBarrageLogger.a("RFWBarrageManager", localThrowable.toString(), localThrowable);
    }
  }
  
  public boolean g()
  {
    return (this.k.get()) && (!this.i.get()) && (this.j.get());
  }
  
  public boolean h()
  {
    return (this.k.get()) && (!this.i.get()) && (P());
  }
  
  public boolean i()
  {
    return (!this.i.get()) && (this.j.get());
  }
  
  public long j()
  {
    return SystemClock.uptimeMillis();
  }
  
  public long k()
  {
    RFWBarrageContext localRFWBarrageContext = this.e;
    if (localRFWBarrageContext == null) {
      return 0L;
    }
    if (localRFWBarrageContext.d()) {
      return j() - this.t;
    }
    long l1 = j();
    long l2 = this.c;
    if (l1 - l2 >= 30000L)
    {
      this.c = l1;
      l1 = this.e.e();
      this.d = l1;
      return l1;
    }
    return this.d + l1 - l2;
  }
  
  public void l()
  {
    RFWBarrageLogger.c("RFWBarrageManager", "[onBarrageViewCreated] barrage view create...");
  }
  
  public void m()
  {
    RFWBarrageLogger.c("RFWBarrageManager", "[onBarrageViewChanged] barrage view change...");
    this.k.set(true);
    H();
  }
  
  public void n()
  {
    RFWBarrageLogger.c("RFWBarrageManager", "[onBarrageViewDestroyed] barrage view destroyed...");
    this.k.set(false);
    try
    {
      if (this.l == null) {
        return;
      }
      Looper localLooper = this.l.getLooper();
      if (localLooper == null) {
        return;
      }
      if (localLooper.getThread() != Looper.getMainLooper().getThread()) {
        localLooper.getThread().join(9);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    RFWBarrageLogger.b("RFWBarrageManager", "[onBarrageViewDestroyed] barrage view destroyed...");
  }
  
  protected void o()
  {
    I();
    if (g())
    {
      long l1 = j();
      f();
      a(4, l1 + 8L - j());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.b) {
      return false;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      a(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()), 0);
      return RFWBarrageContext.a().f();
    }
    return false;
  }
  
  protected void p()
  {
    RFWBarrageLogger.b("RFWBarrageManager", new Object[] { "[handleRelease] handle release message, hash code: ", Integer.valueOf(hashCode()) });
    Q();
    r();
    s();
    N();
    Object localObject = this.q;
    if (localObject != null) {
      ((RFWBarrageMeasureManager)localObject).a();
    }
    localObject = this.p;
    if (localObject != null) {
      ((RFWCacheDrawManager)localObject).a();
    }
    localObject = this.w;
    if (localObject != null) {
      ((Set)localObject).clear();
    }
    localObject = this.m;
    if (localObject != null) {
      ((IRFWBarrageView)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.core.RFWBarrageManager
 * JD-Core Version:    0.7.0.1
 */