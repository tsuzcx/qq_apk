package com.tencent.rfw.barrage.render;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import com.tencent.rfw.barrage.inject.RFWVideoBarrageConfig;
import com.tencent.rfw.barrage.util.RFWBarrageLogger;
import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

public class RFWSurfaceBarrageView
  implements SurfaceHolder.Callback, IRFWBarrageView
{
  private SurfaceView a;
  private SurfaceHolder b;
  private IRFWBarrageView.CallBack c;
  private volatile ReentrantLock d;
  private volatile Object e;
  private volatile boolean f;
  private volatile Object g;
  private volatile boolean h = false;
  
  public RFWSurfaceBarrageView(SurfaceView paramSurfaceView)
  {
    this.a = paramSurfaceView;
    this.a.setWillNotCacheDrawing(true);
    this.a.setDrawingCacheEnabled(false);
    this.a.setWillNotDraw(true);
    this.a.setZOrderMediaOverlay(true);
    this.b = this.a.getHolder();
    this.b.addCallback(this);
    this.b.setFormat(-2);
  }
  
  private Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  private void b(Canvas paramCanvas)
  {
    if (k())
    {
      this.b.unlockCanvasAndPost(paramCanvas);
      return;
    }
    this.b.getSurface().unlockCanvasAndPost(paramCanvas);
    if (this.d != null) {
      this.d.unlock();
    }
  }
  
  private void e()
  {
    f();
    g();
  }
  
  private void f()
  {
    Object localObject = a(SurfaceView.class, "mSurfaceLock", this.a);
    if ((localObject instanceof ReentrantLock)) {
      this.d = ((ReentrantLock)localObject);
    }
  }
  
  private void g()
  {
    this.e = a(SurfaceView.class, "mDrawingStopped", this.a);
    this.g = a(SurfaceView.class, "mWindow", this.a);
    if ((this.e instanceof Boolean)) {
      this.f = ((Boolean)this.e).booleanValue();
    }
  }
  
  private boolean h()
  {
    e();
    return (this.d != null) && (this.e != null) && (this.g != null);
  }
  
  private boolean i()
  {
    return (RFWVideoBarrageConfig.a()) && (((Build.VERSION.SDK_INT == 23) && (h())) || (k()));
  }
  
  private Canvas j()
  {
    if (k()) {
      return this.b.lockHardwareCanvas();
    }
    this.d.lock();
    g();
    Canvas localCanvas2;
    if ((!this.f) && (this.g != null)) {
      try
      {
        Canvas localCanvas1 = this.b.getSurface().lockHardwareCanvas();
      }
      catch (Exception localException)
      {
        RFWBarrageLogger.a("SurfaceDanmakuView", "Exception locking surface", localException);
      }
    } else {
      localCanvas2 = null;
    }
    if (localCanvas2 != null) {
      return localCanvas2;
    }
    this.d.unlock();
    return null;
  }
  
  private boolean k()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public Canvas a()
  {
    if (this.h) {
      return j();
    }
    return this.b.lockCanvas();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.h)
    {
      b(paramCanvas);
      return;
    }
    this.b.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.a.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(IRFWBarrageView.CallBack paramCallBack)
  {
    this.c = paramCallBack;
  }
  
  public float b()
  {
    return this.a.getY();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 33
    //   3: ldc 114
    //   5: aload_0
    //   6: getfield 31	com/tencent/rfw/barrage/render/RFWSurfaceBarrageView:a	Landroid/view/SurfaceView;
    //   9: invokespecial 116	com/tencent/rfw/barrage/render/RFWSurfaceBarrageView:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast 105	java/util/concurrent/locks/ReentrantLock
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 31	com/tencent/rfw/barrage/render/RFWSurfaceBarrageView:a	Landroid/view/SurfaceView;
    //   20: invokevirtual 50	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   23: invokeinterface 98 1 0
    //   28: astore_2
    //   29: ldc 100
    //   31: ldc 184
    //   33: iconst_1
    //   34: anewarray 68	java/lang/Class
    //   37: dup
    //   38: iconst_0
    //   39: getstatic 190	java/lang/Long:TYPE	Ljava/lang/Class;
    //   42: aastore
    //   43: invokevirtual 194	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   46: astore_3
    //   47: aload_3
    //   48: iconst_1
    //   49: invokevirtual 197	java/lang/reflect/Method:setAccessible	(Z)V
    //   52: ldc 100
    //   54: ldc 199
    //   56: invokevirtual 72	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   59: astore 4
    //   61: aload 4
    //   63: iconst_1
    //   64: invokevirtual 77	java/lang/reflect/Field:setAccessible	(Z)V
    //   67: aload 4
    //   69: aload_2
    //   70: invokevirtual 81	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 186	java/lang/Long
    //   76: astore 5
    //   78: new 201	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   85: astore 6
    //   87: aload 6
    //   89: ldc 204
    //   91: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 6
    //   97: aload 5
    //   99: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: ldc 157
    //   105: aload 6
    //   107: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 218	com/tencent/rfw/barrage/util/RFWBarrageLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload 5
    //   115: invokevirtual 222	java/lang/Long:longValue	()J
    //   118: lconst_0
    //   119: lcmp
    //   120: ifeq +18 -> 138
    //   123: aload_3
    //   124: aconst_null
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload 5
    //   133: aastore
    //   134: invokevirtual 226	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: aload 4
    //   140: aload_2
    //   141: lconst_0
    //   142: invokevirtual 230	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   145: ldc 157
    //   147: ldc 232
    //   149: invokestatic 234	com/tencent/rfw/barrage/util/RFWBarrageLogger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: new 201	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   159: astore_2
    //   160: aload_2
    //   161: ldc 236
    //   163: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_2
    //   168: aload_1
    //   169: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 157
    //   175: aload_2
    //   176: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 218	com/tencent/rfw/barrage/util/RFWBarrageLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_1
    //   183: ifnull +78 -> 261
    //   186: aload_1
    //   187: invokevirtual 239	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   190: ifeq +71 -> 261
    //   193: goto +57 -> 250
    //   196: astore_2
    //   197: goto +65 -> 262
    //   200: astore_2
    //   201: ldc 157
    //   203: ldc 241
    //   205: aload_2
    //   206: invokestatic 164	com/tencent/rfw/barrage/util/RFWBarrageLogger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: new 201	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   216: astore_2
    //   217: aload_2
    //   218: ldc 236
    //   220: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: aload_1
    //   226: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: ldc 157
    //   232: aload_2
    //   233: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 218	com/tencent/rfw/barrage/util/RFWBarrageLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_1
    //   240: ifnull +21 -> 261
    //   243: aload_1
    //   244: invokevirtual 239	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   247: ifeq +14 -> 261
    //   250: ldc 157
    //   252: ldc 243
    //   254: invokestatic 218	com/tencent/rfw/barrage/util/RFWBarrageLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_1
    //   258: invokevirtual 108	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   261: return
    //   262: new 201	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   269: astore_3
    //   270: aload_3
    //   271: ldc 236
    //   273: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_3
    //   278: aload_1
    //   279: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: ldc 157
    //   285: aload_3
    //   286: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 218	com/tencent/rfw/barrage/util/RFWBarrageLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_1
    //   293: ifnull +21 -> 314
    //   296: aload_1
    //   297: invokevirtual 239	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   300: ifeq +14 -> 314
    //   303: ldc 157
    //   305: ldc 243
    //   307: invokestatic 218	com/tencent/rfw/barrage/util/RFWBarrageLogger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_1
    //   311: invokevirtual 108	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   314: aload_2
    //   315: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	RFWSurfaceBarrageView
    //   15	296	1	localReentrantLock	ReentrantLock
    //   28	148	2	localObject1	Object
    //   196	1	2	localObject2	Object
    //   200	6	2	localException	Exception
    //   216	99	2	localStringBuilder1	StringBuilder
    //   46	240	3	localObject3	Object
    //   59	80	4	localField	Field
    //   76	56	5	localLong	java.lang.Long
    //   85	21	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	138	196	finally
    //   138	152	196	finally
    //   201	209	196	finally
    //   29	138	200	java/lang/Exception
    //   138	152	200	java/lang/Exception
  }
  
  public void d() {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSurfaceHolder = this.c;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.m();
    }
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("surfaceChanged, width = ");
    paramSurfaceHolder.append(paramInt2);
    paramSurfaceHolder.append(", height = ");
    paramSurfaceHolder.append(paramInt3);
    RFWBarrageLogger.c("SurfaceDanmakuView", paramSurfaceHolder.toString());
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.c;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.l();
    }
    this.h = i();
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("surfaceCreated, isHardwareAccelerateEnable = ");
    paramSurfaceHolder.append(this.h);
    RFWBarrageLogger.c("SurfaceDanmakuView", paramSurfaceHolder.toString());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.c;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.n();
    }
    RFWBarrageLogger.c("SurfaceDanmakuView", "surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.render.RFWSurfaceBarrageView
 * JD-Core Version:    0.7.0.1
 */