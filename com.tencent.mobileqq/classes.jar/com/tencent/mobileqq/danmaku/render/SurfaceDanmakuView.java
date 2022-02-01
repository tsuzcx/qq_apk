package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceDanmakuView
  implements SurfaceHolder.Callback, IDanmakuView
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private IDanmakuView.CallBack jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
  private volatile Object jdField_a_of_type_JavaLangObject;
  private volatile ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile Object jdField_b_of_type_JavaLangObject;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  public SurfaceDanmakuView(SurfaceView paramSurfaceView)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView = paramSurfaceView;
    this.jdField_a_of_type_AndroidViewSurfaceView.setWillNotCacheDrawing(true);
    this.jdField_a_of_type_AndroidViewSurfaceView.setDrawingCacheEnabled(false);
    this.jdField_a_of_type_AndroidViewSurfaceView.setWillNotDraw(true);
    this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderMediaOverlay(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
  }
  
  private boolean a()
  {
    c();
    return (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock != null) && (this.jdField_a_of_type_JavaLangObject != null) && (this.jdField_b_of_type_JavaLangObject != null);
  }
  
  private Canvas b()
  {
    if (DanmakuDependImp.a().a().b()) {
      return this.jdField_a_of_type_AndroidViewSurfaceHolder.lockHardwareCanvas();
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    e();
    Canvas localCanvas2;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangObject != null)) {
      try
      {
        Canvas localCanvas1 = this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().lockHardwareCanvas();
      }
      catch (Exception localException)
      {
        Logger.a("SurfaceDanmakuView", "Exception locking surface", localException);
      }
    } else {
      localCanvas2 = null;
    }
    if (localCanvas2 != null) {
      return localCanvas2;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return null;
  }
  
  private void b(Canvas paramCanvas)
  {
    if (DanmakuDependImp.a().a().b())
    {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramCanvas);
      return;
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().unlockCanvasAndPost(paramCanvas);
    if (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock != null) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  private boolean b()
  {
    return (VideoDanmakuConfig.a()) && (((Build.VERSION.SDK_INT == 23) && (a())) || (DanmakuDependImp.a().a().b()));
  }
  
  private void c()
  {
    d();
    e();
  }
  
  private void d()
  {
    Object localObject = DanmakuDependImp.a().a().a(SurfaceView.class, "mSurfaceLock", this.jdField_a_of_type_AndroidViewSurfaceView);
    if ((localObject instanceof ReentrantLock)) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = ((ReentrantLock)localObject);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaLangObject = DanmakuDependImp.a().a().a(SurfaceView.class, "mDrawingStopped", this.jdField_a_of_type_AndroidViewSurfaceView);
    this.jdField_b_of_type_JavaLangObject = DanmakuDependImp.a().a().a(SurfaceView.class, "mWindow", this.jdField_a_of_type_AndroidViewSurfaceView);
    if ((this.jdField_a_of_type_JavaLangObject instanceof Boolean)) {
      this.jdField_a_of_type_Boolean = ((Boolean)this.jdField_a_of_type_JavaLangObject).booleanValue();
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidViewSurfaceView.getY();
  }
  
  public Canvas a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return b();
    }
    return this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 75	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/DanmakuDependImp;
    //   3: invokevirtual 78	com/tencent/mobileqq/danmaku/DanmakuDependImp:a	()Lcom/tencent/mobileqq/danmaku/IDanmakuDepend;
    //   6: ldc 27
    //   8: ldc 135
    //   10: aload_0
    //   11: getfield 25	com/tencent/mobileqq/danmaku/render/SurfaceDanmakuView:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   14: invokeinterface 138 4 0
    //   19: checkcast 87	java/util/concurrent/locks/ReentrantLock
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 25	com/tencent/mobileqq/danmaku/render/SurfaceDanmakuView:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   27: invokevirtual 44	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   30: invokeinterface 99 1 0
    //   35: astore_2
    //   36: ldc 101
    //   38: ldc 158
    //   40: iconst_1
    //   41: anewarray 160	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: getstatic 166	java/lang/Long:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 170	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore_3
    //   54: aload_3
    //   55: iconst_1
    //   56: invokevirtual 175	java/lang/reflect/Method:setAccessible	(Z)V
    //   59: ldc 101
    //   61: ldc 177
    //   63: invokevirtual 181	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   66: astore 4
    //   68: aload 4
    //   70: iconst_1
    //   71: invokevirtual 184	java/lang/reflect/Field:setAccessible	(Z)V
    //   74: aload 4
    //   76: aload_2
    //   77: invokevirtual 188	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 162	java/lang/Long
    //   83: astore 5
    //   85: new 190	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc 193
    //   98: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 6
    //   104: aload 5
    //   106: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc 202
    //   112: aload 6
    //   114: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 209	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: invokevirtual 213	java/lang/Long:longValue	()J
    //   125: lconst_0
    //   126: lcmp
    //   127: ifeq +18 -> 145
    //   130: aload_3
    //   131: aconst_null
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload 5
    //   140: aastore
    //   141: invokevirtual 217	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 4
    //   147: aload_2
    //   148: lconst_0
    //   149: invokevirtual 221	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   152: ldc 202
    //   154: ldc 223
    //   156: invokestatic 225	com/tencent/mobileqq/danmaku/util/Logger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: new 190	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   166: astore_2
    //   167: aload_2
    //   168: ldc 227
    //   170: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_2
    //   175: aload_1
    //   176: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 202
    //   182: aload_2
    //   183: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 209	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_1
    //   190: ifnull +78 -> 268
    //   193: aload_1
    //   194: invokevirtual 230	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   197: ifeq +71 -> 268
    //   200: goto +57 -> 257
    //   203: astore_2
    //   204: goto +65 -> 269
    //   207: astore_2
    //   208: ldc 202
    //   210: ldc 232
    //   212: aload_2
    //   213: invokestatic 111	com/tencent/mobileqq/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: new 190	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   223: astore_2
    //   224: aload_2
    //   225: ldc 227
    //   227: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_2
    //   232: aload_1
    //   233: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 202
    //   239: aload_2
    //   240: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 209	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload_1
    //   247: ifnull +21 -> 268
    //   250: aload_1
    //   251: invokevirtual 230	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   254: ifeq +14 -> 268
    //   257: ldc 202
    //   259: ldc 234
    //   261: invokestatic 209	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_1
    //   265: invokevirtual 114	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   268: return
    //   269: new 190	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   276: astore_3
    //   277: aload_3
    //   278: ldc 227
    //   280: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_3
    //   285: aload_1
    //   286: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 202
    //   292: aload_3
    //   293: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 209	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_1
    //   300: ifnull +21 -> 321
    //   303: aload_1
    //   304: invokevirtual 230	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   307: ifeq +14 -> 321
    //   310: ldc 202
    //   312: ldc 234
    //   314: invokestatic 209	com/tencent/mobileqq/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_1
    //   318: invokevirtual 114	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   321: aload_2
    //   322: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	SurfaceDanmakuView
    //   22	296	1	localReentrantLock	ReentrantLock
    //   35	148	2	localObject1	Object
    //   203	1	2	localObject2	Object
    //   207	6	2	localException	Exception
    //   223	99	2	localStringBuilder1	StringBuilder
    //   53	240	3	localObject3	Object
    //   66	80	4	localField	java.lang.reflect.Field
    //   83	56	5	localLong	java.lang.Long
    //   92	21	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	145	203	finally
    //   145	159	203	finally
    //   208	216	203	finally
    //   36	145	207	java/lang/Exception
    //   145	159	207	java/lang/Exception
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramCanvas);
      return;
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(IDanmakuView.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack = paramCallBack;
  }
  
  public void b() {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.m();
    }
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("surfaceChanged, width = ");
    paramSurfaceHolder.append(paramInt2);
    paramSurfaceHolder.append(", height = ");
    paramSurfaceHolder.append(paramInt3);
    Logger.c("SurfaceDanmakuView", paramSurfaceHolder.toString());
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.l();
    }
    this.jdField_b_of_type_Boolean = b();
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("surfaceCreated, isHardwareAccelerateEnable = ");
    paramSurfaceHolder.append(this.jdField_b_of_type_Boolean);
    Logger.c("SurfaceDanmakuView", paramSurfaceHolder.toString());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.n();
    }
    Logger.c("SurfaceDanmakuView", "surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.SurfaceDanmakuView
 * JD-Core Version:    0.7.0.1
 */