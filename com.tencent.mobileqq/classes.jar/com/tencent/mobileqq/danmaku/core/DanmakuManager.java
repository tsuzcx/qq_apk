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
  protected long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  protected final AbsWindow a;
  private final CacheDrawManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager;
  private final DanmakuDataSource jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource;
  private final DanmakuFactory jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuFactory;
  private DanmakuManager.DanmakuHandlerCallback jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$DanmakuHandlerCallback = new DanmakuManager.DanmakuHandlerCallback(this, null);
  protected volatile DanmakuManager.IDanmakuListener a;
  private final DanmakuMeasureManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager;
  protected DanmakuContext a;
  protected final IDanmakuView a;
  protected DanmakuDrawTimer a;
  private final PlayerTimer jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer;
  private String jdField_a_of_type_JavaLangString;
  private final List<BaseDanmaku> jdField_a_of_type_JavaUtilList = new LinkedList();
  protected final Queue<TouchPoint> a;
  protected boolean a;
  private int jdField_b_of_type_Int;
  protected long b;
  protected volatile boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private volatile boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private volatile boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private volatile boolean jdField_e_of_type_Boolean;
  private long f;
  private long g;
  
  public DanmakuManager(View paramView, DanmakuContext paramDanmakuContext)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedBlockingDeque();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramDanmakuContext;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView = DanmakuViewFactory.a(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView;
    if (paramView != null)
    {
      paramView.a(this);
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
    Logger.c("DanmakuManager", "handleQuit()");
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.b();
    Logger.c("DanmakuManager", "message quit");
  }
  
  private void B()
  {
    Logger.c("DanmakuManager", "handleConfigChanged()");
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.b();
    Logger.c("DanmakuManager", "message config changed");
  }
  
  private void C()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext;
    if (localObject != null)
    {
      localObject = ((DanmakuContext)localObject).a();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BaseDanmakuRender)((Iterator)localObject).next()).a();
        }
      }
    }
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (DanmakuUtils.a())
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
        return;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  private void E()
  {
    Logger.c("DanmakuManager", "handleClear()");
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.c();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
  }
  
  private void F()
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
  
  private void G()
  {
    Logger.c("surface_lock", "handleClearDrawingCache");
    y();
    try
    {
      if (!this.jdField_e_of_type_Boolean) {
        return;
      }
      H();
      return;
    }
    finally {}
  }
  
  /* Error */
  private void H()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   8: invokeinterface 288 1 0
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +89 -> 104
    //   18: aload_3
    //   19: astore_1
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: invokestatic 293	com/tencent/mobileqq/danmaku/util/DrawUtils:a	(Landroid/graphics/Canvas;)V
    //   26: aload_3
    //   27: astore_1
    //   28: aload_3
    //   29: astore_2
    //   30: new 295	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   37: astore 5
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: astore_2
    //   43: aload 5
    //   45: ldc_w 298
    //   48: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: ifnonnull +11 -> 64
    //   56: ldc_w 304
    //   59: astore 4
    //   61: goto +16 -> 77
    //   64: aload_3
    //   65: astore_1
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: invokevirtual 308	java/lang/Object:hashCode	()I
    //   72: invokestatic 313	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: astore 4
    //   77: aload_3
    //   78: astore_1
    //   79: aload_3
    //   80: astore_2
    //   81: aload 5
    //   83: aload 4
    //   85: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_3
    //   90: astore_1
    //   91: aload_3
    //   92: astore_2
    //   93: ldc_w 273
    //   96: aload 5
    //   98: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 147	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: ifnull +92 -> 197
    //   108: aload_0
    //   109: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   112: aload_3
    //   113: invokeinterface 321 2 0
    //   118: new 295	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: ldc_w 323
    //   130: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: aload_3
    //   136: invokevirtual 308	java/lang/Object:hashCode	()I
    //   139: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc_w 273
    //   146: aload_1
    //   147: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 147	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto +44 -> 197
    //   156: astore_1
    //   157: aload_3
    //   158: ifnull +39 -> 197
    //   161: new 295	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   168: astore_2
    //   169: aload_2
    //   170: ldc_w 328
    //   173: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: aload_3
    //   179: invokevirtual 308	java/lang/Object:hashCode	()I
    //   182: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc_w 273
    //   189: aload_2
    //   190: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: aload_1
    //   194: invokestatic 331	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: invokestatic 247	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/DanmakuDependImp;
    //   200: invokevirtual 250	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/IDanmakuDepend;
    //   203: invokeinterface 255 1 0
    //   208: astore_1
    //   209: new 333	com/tencent/mobileqq/danmaku/core/DanmakuManager$2
    //   212: dup
    //   213: aload_0
    //   214: invokespecial 336	com/tencent/mobileqq/danmaku/core/DanmakuManager$2:<init>	(Lcom/tencent/mobileqq/danmaku/core/DanmakuManager;)V
    //   217: astore_2
    //   218: goto +299 -> 517
    //   221: astore_2
    //   222: goto +59 -> 281
    //   225: astore_3
    //   226: aload_2
    //   227: ifnull +176 -> 403
    //   230: aload_2
    //   231: astore_1
    //   232: new 295	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   239: astore 4
    //   241: aload_2
    //   242: astore_1
    //   243: aload 4
    //   245: ldc_w 338
    //   248: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_2
    //   253: astore_1
    //   254: aload 4
    //   256: aload_2
    //   257: invokevirtual 308	java/lang/Object:hashCode	()I
    //   260: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_2
    //   265: astore_1
    //   266: ldc_w 273
    //   269: aload 4
    //   271: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: aload_3
    //   275: invokestatic 331	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: goto +125 -> 403
    //   281: aload_1
    //   282: ifnull +96 -> 378
    //   285: aload_0
    //   286: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   289: aload_1
    //   290: invokeinterface 321 2 0
    //   295: new 295	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   302: astore_3
    //   303: aload_3
    //   304: ldc_w 323
    //   307: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_3
    //   312: aload_1
    //   313: invokevirtual 308	java/lang/Object:hashCode	()I
    //   316: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc_w 273
    //   323: aload_3
    //   324: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 147	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: goto +48 -> 378
    //   333: astore_3
    //   334: aload_1
    //   335: ifnull +43 -> 378
    //   338: new 295	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   345: astore 4
    //   347: aload 4
    //   349: ldc_w 328
    //   352: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 4
    //   358: aload_1
    //   359: invokevirtual 308	java/lang/Object:hashCode	()I
    //   362: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: ldc_w 273
    //   369: aload 4
    //   371: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aload_3
    //   375: invokestatic 331	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   378: invokestatic 247	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/DanmakuDependImp;
    //   381: invokevirtual 250	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/IDanmakuDepend;
    //   384: invokeinterface 255 1 0
    //   389: new 333	com/tencent/mobileqq/danmaku/core/DanmakuManager$2
    //   392: dup
    //   393: aload_0
    //   394: invokespecial 336	com/tencent/mobileqq/danmaku/core/DanmakuManager$2:<init>	(Lcom/tencent/mobileqq/danmaku/core/DanmakuManager;)V
    //   397: invokevirtual 266	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   400: pop
    //   401: aload_2
    //   402: athrow
    //   403: aload_2
    //   404: ifnull +92 -> 496
    //   407: aload_0
    //   408: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   411: aload_2
    //   412: invokeinterface 321 2 0
    //   417: new 295	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   424: astore_1
    //   425: aload_1
    //   426: ldc_w 323
    //   429: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_1
    //   434: aload_2
    //   435: invokevirtual 308	java/lang/Object:hashCode	()I
    //   438: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 273
    //   445: aload_1
    //   446: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 147	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: goto +44 -> 496
    //   455: astore_1
    //   456: aload_2
    //   457: ifnull +39 -> 496
    //   460: new 295	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   467: astore_3
    //   468: aload_3
    //   469: ldc_w 328
    //   472: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_3
    //   477: aload_2
    //   478: invokevirtual 308	java/lang/Object:hashCode	()I
    //   481: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: ldc_w 273
    //   488: aload_3
    //   489: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: aload_1
    //   493: invokestatic 331	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   496: invokestatic 247	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/DanmakuDependImp;
    //   499: invokevirtual 250	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/IDanmakuDepend;
    //   502: invokeinterface 255 1 0
    //   507: astore_1
    //   508: new 333	com/tencent/mobileqq/danmaku/core/DanmakuManager$2
    //   511: dup
    //   512: aload_0
    //   513: invokespecial 336	com/tencent/mobileqq/danmaku/core/DanmakuManager$2:<init>	(Lcom/tencent/mobileqq/danmaku/core/DanmakuManager;)V
    //   516: astore_2
    //   517: aload_1
    //   518: aload_2
    //   519: invokevirtual 266	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   522: pop
    //   523: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	DanmakuManager
    //   3	144	1	localObject1	Object
    //   156	38	1	localThrowable1	Throwable
    //   208	238	1	localObject2	Object
    //   455	38	1	localThrowable2	Throwable
    //   507	11	1	localHandler	Handler
    //   1	217	2	localObject3	Object
    //   221	257	2	localCanvas1	Canvas
    //   516	3	2	local2	DanmakuManager.2
    //   13	166	3	localCanvas2	Canvas
    //   225	50	3	localThrowable3	Throwable
    //   302	22	3	localStringBuilder1	StringBuilder
    //   333	42	3	localThrowable4	Throwable
    //   467	22	3	localStringBuilder2	StringBuilder
    //   59	311	4	localObject4	Object
    //   37	60	5	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   108	153	156	java/lang/Throwable
    //   4	14	221	finally
    //   22	26	221	finally
    //   30	39	221	finally
    //   43	52	221	finally
    //   68	77	221	finally
    //   81	89	221	finally
    //   93	104	221	finally
    //   232	241	221	finally
    //   243	252	221	finally
    //   254	264	221	finally
    //   266	278	221	finally
    //   4	14	225	java/lang/Throwable
    //   22	26	225	java/lang/Throwable
    //   30	39	225	java/lang/Throwable
    //   43	52	225	java/lang/Throwable
    //   68	77	225	java/lang/Throwable
    //   81	89	225	java/lang/Throwable
    //   93	104	225	java/lang/Throwable
    //   285	330	333	java/lang/Throwable
    //   407	452	455	java/lang/Throwable
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
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b())
    {
      long l2 = a();
      long l3 = l2 - this.jdField_e_of_type_Long;
      this.jdField_a_of_type_Int += 1;
      this.jdField_c_of_type_Int = ((int)(this.jdField_c_of_type_Int + l3));
      if (l3 > 16L)
      {
        this.jdField_b_of_type_Int += 1;
        if (Logger.jdField_a_of_type_Int >= 5)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("a draw block:");
          ((StringBuilder)localObject).append(l3);
          Logger.d("DanmakuManager", ((StringBuilder)localObject).toString());
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a();
      if (this.jdField_a_of_type_Int % 60 == 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Logger.jdField_a_of_type_Int);
        localStringBuilder.append(",t:");
        localStringBuilder.append(DanmakuUtils.a(a()));
        localStringBuilder.append(",f:");
        long l1;
        if (this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.c() == 0L) {
          l1 = 1L;
        } else {
          l1 = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.c();
        }
        localStringBuilder.append(1000L / l1);
        localStringBuilder.append(",ds:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a());
        localStringBuilder.append(",ts:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource.a());
        localStringBuilder.append(",mt:");
        localStringBuilder.append(jdField_b_of_type_JavaTextDecimalFormat.format(this.f - this.jdField_e_of_type_Long));
        localStringBuilder.append(",lt:");
        localStringBuilder.append(jdField_b_of_type_JavaTextDecimalFormat.format(this.g - this.f));
        localStringBuilder.append(",dt:");
        localStringBuilder.append(jdField_b_of_type_JavaTextDecimalFormat.format(l2 - this.g));
        localStringBuilder.append(",tt:");
        localStringBuilder.append(jdField_b_of_type_JavaTextDecimalFormat.format(l3));
        localStringBuilder.append(",jp:");
        localStringBuilder.append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_b_of_type_Int * 100.0F / this.jdField_a_of_type_Int));
        localStringBuilder.append("%,at:");
        localStringBuilder.append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_c_of_type_Int / this.jdField_a_of_type_Int));
        localStringBuilder.append(",fd:");
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = DanmakuUtils.a(((BaseDanmaku)localObject).d());
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",cs:");
        localStringBuilder.append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.a() / 1024.0F / 1024.0F));
        localStringBuilder.append(",uc:");
        localStringBuilder.append(jdField_a_of_type_JavaTextDecimalFormat.format(this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.b() * 100.0F / this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.c()));
        this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null) {
        DrawUtils.a(paramCanvas, (String)localObject);
      }
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
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    if (paramMessage.obj != null) {
      this.jdField_d_of_type_Long = ((Long)paramMessage.obj).longValue();
    } else {
      this.jdField_d_of_type_Long = 0L;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.b();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a();
    if (Logger.jdField_a_of_type_Int >= 3) {
      Logger.c("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(this.jdField_d_of_type_Long) });
    }
  }
  
  private boolean e()
  {
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    return (localHandlerThread != null) && (localHandlerThread.isAlive());
  }
  
  private boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView instanceof SurfaceDanmakuView;
  }
  
  private boolean g()
  {
    if (f()) {
      return (e()) && (this.jdField_a_of_type_AndroidOsHandler != null);
    }
    return this.jdField_a_of_type_AndroidOsHandler != null;
  }
  
  private void q()
  {
    if (f())
    {
      if (e()) {
        return;
      }
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DanmakuDrawThreadPriority_");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b());
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.b());
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
  
  private void r()
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
        if ((Logger.jdField_a_of_type_Int >= 4) && (localBaseDanmaku.h()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("must show danmaku upload to Windown :");
          localStringBuilder.append(localBaseDanmaku);
          Logger.b("DanmakuManager", localStringBuilder.toString());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload, danmaku = ");
        localStringBuilder.append(localBaseDanmaku);
        Logger.c("DanmakuManager", localStringBuilder.toString());
        localBaseDanmaku.c(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a());
        this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.a(localBaseDanmaku);
      }
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a(b());
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.b();
    if (Logger.jdField_a_of_type_Int >= 5) {
      Logger.a("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a()), ",lastInterval:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.c()) });
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.b();
  }
  
  /* Error */
  private void u()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   8: invokeinterface 288 1 0
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +39 -> 54
    //   18: aload_3
    //   19: astore_2
    //   20: aload_3
    //   21: astore_1
    //   22: aload_3
    //   23: invokestatic 293	com/tencent/mobileqq/danmaku/util/DrawUtils:a	(Landroid/graphics/Canvas;)V
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 132	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow	Lcom/tencent/mobileqq/danmaku/core/AbsWindow;
    //   34: aload_3
    //   35: aload_0
    //   36: getfield 98	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer	Lcom/tencent/mobileqq/danmaku/tool/PlayerTimer;
    //   39: invokevirtual 541	com/tencent/mobileqq/danmaku/tool/PlayerTimer:a	()J
    //   42: invokevirtual 582	com/tencent/mobileqq/danmaku/core/AbsWindow:a	(Landroid/graphics/Canvas;J)V
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: astore_1
    //   49: aload_0
    //   50: aload_3
    //   51: invokespecial 583	com/tencent/mobileqq/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   54: aload_3
    //   55: ifnull +215 -> 270
    //   58: aload_0
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 280	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_e_of_type_Boolean	Z
    //   64: ifeq +16 -> 80
    //   67: aload_0
    //   68: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   71: aload_3
    //   72: invokeinterface 321 2 0
    //   77: goto +12 -> 89
    //   80: aload_0
    //   81: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   84: invokeinterface 584 1 0
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: astore_2
    //   98: new 295	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   105: astore 4
    //   107: aload_3
    //   108: astore_1
    //   109: aload 4
    //   111: ldc_w 586
    //   114: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 4
    //   120: aload_1
    //   121: invokevirtual 308	java/lang/Object:hashCode	()I
    //   124: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc_w 273
    //   131: aload 4
    //   133: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: aload_2
    //   137: invokestatic 331	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: return
    //   141: astore_1
    //   142: goto +129 -> 271
    //   145: astore 4
    //   147: aload_1
    //   148: astore_2
    //   149: new 295	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   156: astore 5
    //   158: aload_1
    //   159: astore_2
    //   160: aload 5
    //   162: ldc_w 588
    //   165: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: ifnonnull +10 -> 180
    //   173: ldc_w 304
    //   176: astore_3
    //   177: goto +13 -> 190
    //   180: aload_1
    //   181: astore_2
    //   182: aload_1
    //   183: invokevirtual 308	java/lang/Object:hashCode	()I
    //   186: invokestatic 313	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: astore_3
    //   190: aload_1
    //   191: astore_2
    //   192: aload 5
    //   194: aload_3
    //   195: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: astore_2
    //   201: ldc_w 273
    //   204: aload 5
    //   206: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: aload 4
    //   211: invokestatic 331	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload_1
    //   215: ifnull +55 -> 270
    //   218: aload_0
    //   219: monitorenter
    //   220: aload_0
    //   221: getfield 280	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_e_of_type_Boolean	Z
    //   224: ifeq +16 -> 240
    //   227: aload_0
    //   228: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   231: aload_1
    //   232: invokeinterface 321 2 0
    //   237: goto +12 -> 249
    //   240: aload_0
    //   241: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   244: invokeinterface 584 1 0
    //   249: aload_0
    //   250: monitorexit
    //   251: return
    //   252: astore_2
    //   253: aload_0
    //   254: monitorexit
    //   255: aload_2
    //   256: athrow
    //   257: astore_2
    //   258: new 295	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   265: astore 4
    //   267: goto -158 -> 109
    //   270: return
    //   271: aload_2
    //   272: ifnull +85 -> 357
    //   275: aload_0
    //   276: monitorenter
    //   277: aload_0
    //   278: getfield 280	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_e_of_type_Boolean	Z
    //   281: ifeq +16 -> 297
    //   284: aload_0
    //   285: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   288: aload_2
    //   289: invokeinterface 321 2 0
    //   294: goto +12 -> 306
    //   297: aload_0
    //   298: getfield 85	com/tencent/mobileqq/danmaku/core/DanmakuManager:jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView	Lcom/tencent/mobileqq/danmaku/render/IDanmakuView;
    //   301: invokeinterface 584 1 0
    //   306: aload_0
    //   307: monitorexit
    //   308: goto +49 -> 357
    //   311: astore_3
    //   312: aload_0
    //   313: monitorexit
    //   314: aload_3
    //   315: athrow
    //   316: astore_3
    //   317: new 295	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   324: astore 4
    //   326: aload 4
    //   328: ldc_w 586
    //   331: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 4
    //   337: aload_2
    //   338: invokevirtual 308	java/lang/Object:hashCode	()I
    //   341: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: ldc_w 273
    //   348: aload 4
    //   350: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: aload_3
    //   354: invokestatic 331	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: goto +5 -> 362
    //   360: aload_1
    //   361: athrow
    //   362: goto -2 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	DanmakuManager
    //   1	48	1	localObject1	Object
    //   92	4	1	localObject2	Object
    //   108	13	1	localObject3	Object
    //   141	220	1	localCanvas1	Canvas
    //   3	44	2	localObject4	Object
    //   97	40	2	localThrowable1	Throwable
    //   148	53	2	localCanvas2	Canvas
    //   252	4	2	localObject5	Object
    //   257	81	2	localThrowable2	Throwable
    //   13	182	3	localObject6	Object
    //   311	4	3	localObject7	Object
    //   316	38	3	localThrowable3	Throwable
    //   105	27	4	localStringBuilder1	StringBuilder
    //   145	65	4	localThrowable4	Throwable
    //   265	84	4	localStringBuilder2	StringBuilder
    //   156	49	5	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   60	77	92	finally
    //   80	89	92	finally
    //   89	91	92	finally
    //   93	95	92	finally
    //   58	60	97	java/lang/Throwable
    //   95	97	97	java/lang/Throwable
    //   4	14	141	finally
    //   22	26	141	finally
    //   30	45	141	finally
    //   49	54	141	finally
    //   149	158	141	finally
    //   160	169	141	finally
    //   182	190	141	finally
    //   192	199	141	finally
    //   201	214	141	finally
    //   4	14	145	java/lang/Throwable
    //   22	26	145	java/lang/Throwable
    //   30	45	145	java/lang/Throwable
    //   49	54	145	java/lang/Throwable
    //   220	237	252	finally
    //   240	249	252	finally
    //   249	251	252	finally
    //   253	255	252	finally
    //   218	220	257	java/lang/Throwable
    //   255	257	257	java/lang/Throwable
    //   277	294	311	finally
    //   297	306	311	finally
    //   306	308	311	finally
    //   312	314	311	finally
    //   275	277	316	java/lang/Throwable
    //   314	316	316	java/lang/Throwable
  }
  
  private void v()
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
  
  private void w()
  {
    Logger.c("DanmakuManager", "handleResume()");
    if (!this.jdField_d_of_type_Boolean)
    {
      long l = a();
      this.jdField_c_of_type_Long = (l - this.jdField_d_of_type_Long);
      if (Logger.jdField_a_of_type_Int >= 5)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleResume, mBaseTime = ");
        localStringBuilder.append(this.jdField_c_of_type_Long);
        localStringBuilder.append(", currentTime = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", mPauseTime = ");
        localStringBuilder.append(this.jdField_d_of_type_Long);
        Logger.b("DanmakuManager", localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.b();
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    x();
    if (Logger.jdField_a_of_type_Int >= 5) {
      Logger.b("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.jdField_d_of_type_Long), ",mBaseTime:", Long.valueOf(this.jdField_c_of_type_Long) });
    }
  }
  
  private void x()
  {
    Logger.a("DanmakuManager", "resumeUpdateMessage()");
    if (d()) {
      a(4);
    }
  }
  
  private void y()
  {
    Logger.a("DanmakuManager", "removeUpdateMessage()");
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeMessages(4);
    }
  }
  
  private void z()
  {
    Logger.c("DanmakuManager", "handlePause()");
    y();
    this.jdField_d_of_type_Boolean = false;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a()) {
      l = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a();
    } else {
      l = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer.a();
    }
    this.jdField_d_of_type_Long = l;
    if (Logger.jdField_a_of_type_Int >= 5) {
      Logger.a("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.jdField_d_of_type_Long) });
    }
  }
  
  public long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  public DanmakuManager a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public BaseDanmaku a(int paramInt, Object paramObject)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuFactory.a(paramInt, paramObject);
  }
  
  public DanmakuDrawTimer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDanmakuDrawTimer;
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start() time = ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("DanmakuManager", ((StringBuilder)localObject).toString());
    q();
    localObject = Message.obtain();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = Long.valueOf(paramLong);
    b((Message)localObject);
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
    b(paramPoint);
  }
  
  protected void a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSeek() msg.obj is null = ");
    boolean bool;
    if (paramMessage.obj == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    Logger.c("DanmakuManager", localStringBuilder.toString());
    if (paramMessage.obj != null)
    {
      this.jdField_d_of_type_Long = ((Long)paramMessage.obj).longValue();
      this.jdField_a_of_type_Boolean = true;
      w();
    }
    if (Logger.jdField_a_of_type_Int >= 5) {
      Logger.a("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.jdField_d_of_type_Long) });
    }
  }
  
  public void a(DanmakuManager.IDanmakuListener paramIDanmakuListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener = paramIDanmakuListener;
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.b(paramBaseDanmaku);
  }
  
  public void a(List<BaseDanmaku> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager.a(paramList, new DanmakuManager.6(this));
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow;
    boolean bool3 = localObject instanceof R2LWindow;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if (!((R2LWindow)localObject).a())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource;
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (!((DanmakuDataSource)localObject).a()) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean a(ClickResult paramClickResult)
  {
    return (c()) && (paramClickResult.jdField_a_of_type_Int != -1);
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a()) {
      return a() - this.jdField_c_of_type_Long;
    }
    long l1 = a();
    long l2 = this.jdField_a_of_type_Long;
    if (l1 - l2 >= 200L)
    {
      this.jdField_a_of_type_Long = l1;
      l1 = this.jdField_a_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext.a();
      this.jdField_b_of_type_Long = l1;
      return l1;
    }
    return this.jdField_b_of_type_Long + l1 - l2;
  }
  
  public void b()
  {
    Logger.a("DanmakuManager", "resume()");
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    b(localMessage);
  }
  
  public void b(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seek(): postime = ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("DanmakuManager", ((StringBuilder)localObject).toString());
    localObject = Message.obtain();
    ((Message)localObject).what = 5;
    ((Message)localObject).obj = Long.valueOf(paramLong);
    b((Message)localObject);
  }
  
  protected void b(Message paramMessage)
  {
    if (g()) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
    }
  }
  
  public void b(BaseDanmaku paramBaseDanmaku)
  {
    paramBaseDanmaku.b(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a());
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager.a(paramBaseDanmaku, new DanmakuManager.5(this));
  }
  
  public boolean b()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_e_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
        {
          bool = true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isPrepared() = ");
          localStringBuilder.append(bool);
          localStringBuilder.append(", mIsSurfaceCreated = ");
          localStringBuilder.append(this.jdField_e_of_type_Boolean);
          localStringBuilder.append(", mIsQuited = ");
          localStringBuilder.append(this.jdField_c_of_type_Boolean);
          localStringBuilder.append(", mIsPlaying = ");
          localStringBuilder.append(this.jdField_d_of_type_Boolean);
          Logger.a("DanmakuManager", localStringBuilder.toString());
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
    b(localMessage);
  }
  
  public boolean c()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_e_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (g()))
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
    b(localMessage);
  }
  
  public boolean d()
  {
    return (!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean);
  }
  
  public void e()
  {
    Logger.a("DanmakuManager", "clear");
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    b(localMessage);
    o();
  }
  
  public void f()
  {
    Logger.a("DanmakuManager", "quit(); mIsQuited = true");
    this.jdField_c_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    b(localMessage);
  }
  
  public void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release() mIsQuited = ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
    Logger.a("DanmakuManager", ((StringBuilder)localObject).toString());
    C();
    if (!this.jdField_c_of_type_Boolean) {
      f();
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 8;
    b((Message)localObject);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$IDanmakuListener = null;
  }
  
  public void h()
  {
    Logger.a("DanmakuManager", "notifyConfigChanged()");
    q();
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    b(localMessage);
  }
  
  protected void i()
  {
    s();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreAbsWindow.c();
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      if (Logger.jdField_a_of_type_Int >= 4) {
        this.jdField_e_of_type_Long = a();
      }
      r();
      if (Logger.jdField_a_of_type_Int >= 4) {
        this.f = a();
      }
      t();
      if (Logger.jdField_a_of_type_Int >= 4) {
        this.g = a();
      }
      u();
      v();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.a("DanmakuManager", localThrowable.toString(), localThrowable);
    }
  }
  
  protected void j()
  {
    Logger.a("DanmakuManager", "handelUpdate()");
    y();
    if (b())
    {
      long l = a();
      i();
      a(4, l + 16L - a());
    }
  }
  
  protected void k()
  {
    Logger.c("DanmakuManager", "handleRelease()");
    D();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuMeasureManager.a();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreCacheDrawManager.a();
  }
  
  public void l()
  {
    Logger.c("surface_lock", "surfaceCreated");
  }
  
  public void m()
  {
    Logger.c("surface_lock", "surfaceChanged");
    try
    {
      this.jdField_e_of_type_Boolean = true;
      x();
      return;
    }
    finally {}
  }
  
  public void n()
  {
    try
    {
      this.jdField_e_of_type_Boolean = false;
      Logger.c("surface_lock", "surfaceDestroyed");
      return;
    }
    finally {}
  }
  
  public void o()
  {
    DanmakuDataSource localDanmakuDataSource = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuDataSource;
    if (localDanmakuDataSource != null) {
      localDanmakuDataSource.a();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
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
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager$DanmakuHandlerCallback = null;
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView;
    if (localObject != null) {
      ((IDanmakuView)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuManager
 * JD-Core Version:    0.7.0.1
 */