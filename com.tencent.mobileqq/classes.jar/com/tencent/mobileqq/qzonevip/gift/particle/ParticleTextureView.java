package com.tencent.mobileqq.qzonevip.gift.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public abstract class ParticleTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  protected Random a;
  protected Matrix b;
  protected Paint c;
  protected ArrayList<ParticleObject> d;
  protected Context e;
  protected int f;
  protected int g;
  protected HandlerThread h;
  protected Handler i;
  protected volatile boolean j = false;
  protected final Object k = new Object();
  protected int l = 0;
  protected ParticleTextureView.ParticleListener m;
  private Surface n;
  private Rect o = new Rect();
  
  public ParticleTextureView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ParticleTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ParticleTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    b(paramInt, 0);
  }
  
  private void a(Context paramContext)
  {
    this.e = paramContext;
    this.a = new Random();
    this.b = new Matrix();
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setColor(-1);
    this.d = new ArrayList();
    setOpaque(false);
    setSurfaceTextureListener(this);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Handler localHandler = this.i;
    if (localHandler == null)
    {
      QLog.i("ParticleTextureView", 1, "sendValidMessage: handle = null ");
      return;
    }
    if (localHandler.hasMessages(paramInt1)) {
      this.i.removeMessages(paramInt1);
    }
    this.i.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  protected float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > paramFloat2) {
      return paramFloat1;
    }
    return this.a.nextFloat() * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  protected int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt1;
    }
    return this.a.nextInt(paramInt2 - paramInt1) + paramInt1;
  }
  
  protected abstract void a(Bitmap[] paramArrayOfBitmap);
  
  protected abstract Bitmap[] a();
  
  protected abstract void b();
  
  protected abstract boolean c();
  
  public void d()
  {
    a(1);
  }
  
  public void e()
  {
    this.j = true;
  }
  
  /* Error */
  protected void f()
  {
    // Byte code:
    //   0: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: getfield 48	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:k	Ljava/lang/Object;
    //   8: astore 7
    //   10: aload 7
    //   12: monitorenter
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 5
    //   19: aload 5
    //   21: astore_3
    //   22: aload 6
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   30: astore 8
    //   32: aload 8
    //   34: ifnonnull +65 -> 99
    //   37: aload_0
    //   38: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   41: ifnull +54 -> 95
    //   44: aload_0
    //   45: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   48: aconst_null
    //   49: invokevirtual 160	android/view/Surface:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   52: goto +43 -> 95
    //   55: astore_3
    //   56: goto +539 -> 595
    //   59: astore_3
    //   60: new 162	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   67: astore 4
    //   69: aload 4
    //   71: ldc 165
    //   73: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 4
    //   79: aload_3
    //   80: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 111
    //   86: iconst_1
    //   87: aload 4
    //   89: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload 7
    //   97: monitorexit
    //   98: return
    //   99: aload 5
    //   101: astore_3
    //   102: aload 6
    //   104: astore 4
    //   106: aload_0
    //   107: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   110: aload_0
    //   111: getfield 55	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:o	Landroid/graphics/Rect;
    //   114: invokevirtual 182	android/view/Surface:lockCanvas	(Landroid/graphics/Rect;)Landroid/graphics/Canvas;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnull +168 -> 289
    //   124: aload 5
    //   126: astore_3
    //   127: aload 5
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   135: invokevirtual 185	android/view/Surface:isValid	()Z
    //   138: ifeq +151 -> 289
    //   141: aload 5
    //   143: astore_3
    //   144: aload 5
    //   146: astore 4
    //   148: aload 5
    //   150: iconst_0
    //   151: getstatic 191	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   154: invokevirtual 197	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   157: aload 5
    //   159: astore_3
    //   160: aload_0
    //   161: getfield 97	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:d	Ljava/util/ArrayList;
    //   164: invokevirtual 201	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   167: astore 4
    //   169: aload 5
    //   171: astore_3
    //   172: aload 4
    //   174: invokeinterface 206 1 0
    //   179: ifeq +110 -> 289
    //   182: aload 5
    //   184: astore_3
    //   185: aload 4
    //   187: invokeinterface 210 1 0
    //   192: checkcast 212	com/tencent/mobileqq/qzonevip/gift/particle/ParticleObject
    //   195: astore 6
    //   197: aload 6
    //   199: ifnull -30 -> 169
    //   202: aload 5
    //   204: astore_3
    //   205: aload 6
    //   207: aload 5
    //   209: aload_0
    //   210: getfield 85	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:c	Landroid/graphics/Paint;
    //   213: aload_0
    //   214: getfield 80	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:b	Landroid/graphics/Matrix;
    //   217: invokevirtual 215	com/tencent/mobileqq/qzonevip/gift/particle/ParticleObject:a	(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Matrix;)V
    //   220: goto -51 -> 169
    //   223: astore 6
    //   225: aload 5
    //   227: astore_3
    //   228: aload 5
    //   230: astore 4
    //   232: new 162	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   239: astore 8
    //   241: aload 5
    //   243: astore_3
    //   244: aload 5
    //   246: astore 4
    //   248: aload 8
    //   250: ldc 217
    //   252: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 5
    //   258: astore_3
    //   259: aload 5
    //   261: astore 4
    //   263: aload 8
    //   265: aload 6
    //   267: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 5
    //   273: astore_3
    //   274: aload 5
    //   276: astore 4
    //   278: ldc 111
    //   280: iconst_1
    //   281: aload 8
    //   283: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_0
    //   290: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   293: ifnull +164 -> 457
    //   296: aload_0
    //   297: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   300: aload 5
    //   302: invokevirtual 160	android/view/Surface:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   305: goto +152 -> 457
    //   308: astore_3
    //   309: new 162	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   316: astore 4
    //   318: aload 4
    //   320: ldc 165
    //   322: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 4
    //   328: aload_3
    //   329: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 4
    //   335: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore_3
    //   339: ldc 111
    //   341: iconst_1
    //   342: aload_3
    //   343: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: goto +111 -> 457
    //   349: astore 4
    //   351: goto +187 -> 538
    //   354: astore 5
    //   356: aload 4
    //   358: astore_3
    //   359: new 162	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   366: astore 6
    //   368: aload 4
    //   370: astore_3
    //   371: aload 6
    //   373: ldc 217
    //   375: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 4
    //   381: astore_3
    //   382: aload 6
    //   384: aload 5
    //   386: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 4
    //   392: astore_3
    //   393: ldc 111
    //   395: iconst_1
    //   396: aload 6
    //   398: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: aload_0
    //   405: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   408: ifnull +49 -> 457
    //   411: aload_0
    //   412: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   415: aload 4
    //   417: invokevirtual 160	android/view/Surface:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   420: goto +37 -> 457
    //   423: astore_3
    //   424: new 162	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   431: astore 4
    //   433: aload 4
    //   435: ldc 165
    //   437: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 4
    //   443: aload_3
    //   444: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 4
    //   450: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: astore_3
    //   454: goto -115 -> 339
    //   457: aload 7
    //   459: monitorexit
    //   460: new 162	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   467: astore_3
    //   468: aload_3
    //   469: ldc 219
    //   471: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_3
    //   476: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   479: lload_1
    //   480: lsub
    //   481: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: ldc 111
    //   487: iconst_1
    //   488: aload_3
    //   489: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 118	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: aload_0
    //   496: getfield 109	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:i	Landroid/os/Handler;
    //   499: ifnull +23 -> 522
    //   502: aload_0
    //   503: getfield 97	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:d	Ljava/util/ArrayList;
    //   506: invokevirtual 226	java/util/ArrayList:size	()I
    //   509: ifeq +13 -> 522
    //   512: aload_0
    //   513: iconst_3
    //   514: aload_0
    //   515: invokevirtual 229	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:getRefreshTime	()I
    //   518: invokespecial 68	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:b	(II)V
    //   521: return
    //   522: aload_0
    //   523: getfield 231	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:m	Lcom/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView$ParticleListener;
    //   526: astore_3
    //   527: aload_3
    //   528: ifnull +9 -> 537
    //   531: aload_3
    //   532: invokeinterface 235 1 0
    //   537: return
    //   538: aload_0
    //   539: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   542: ifnull +50 -> 592
    //   545: aload_0
    //   546: getfield 154	com/tencent/mobileqq/qzonevip/gift/particle/ParticleTextureView:n	Landroid/view/Surface;
    //   549: aload_3
    //   550: invokevirtual 160	android/view/Surface:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   553: goto +39 -> 592
    //   556: astore_3
    //   557: new 162	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   564: astore 5
    //   566: aload 5
    //   568: ldc 165
    //   570: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 5
    //   576: aload_3
    //   577: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: ldc 111
    //   583: iconst_1
    //   584: aload 5
    //   586: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: aload 4
    //   594: athrow
    //   595: aload 7
    //   597: monitorexit
    //   598: goto +5 -> 603
    //   601: aload_3
    //   602: athrow
    //   603: goto -2 -> 601
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	ParticleTextureView
    //   3	477	1	l1	long
    //   21	1	3	localCanvas1	android.graphics.Canvas
    //   55	1	3	localObject1	Object
    //   59	21	3	localThrowable1	java.lang.Throwable
    //   101	173	3	localCanvas2	android.graphics.Canvas
    //   308	21	3	localThrowable2	java.lang.Throwable
    //   338	55	3	localObject2	Object
    //   423	21	3	localThrowable3	java.lang.Throwable
    //   453	97	3	localObject3	Object
    //   556	46	3	localThrowable4	java.lang.Throwable
    //   24	310	4	localObject4	Object
    //   349	67	4	localCanvas3	android.graphics.Canvas
    //   431	162	4	localStringBuilder1	StringBuilder
    //   17	284	5	localCanvas4	android.graphics.Canvas
    //   354	31	5	localThrowable5	java.lang.Throwable
    //   564	21	5	localStringBuilder2	StringBuilder
    //   14	192	6	localParticleObject	ParticleObject
    //   223	43	6	localThrowable6	java.lang.Throwable
    //   366	31	6	localStringBuilder3	StringBuilder
    //   8	588	7	localObject5	Object
    //   30	252	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   37	52	55	finally
    //   60	95	55	finally
    //   95	98	55	finally
    //   289	305	55	finally
    //   309	339	55	finally
    //   339	346	55	finally
    //   404	420	55	finally
    //   424	454	55	finally
    //   457	460	55	finally
    //   538	553	55	finally
    //   557	592	55	finally
    //   592	595	55	finally
    //   595	598	55	finally
    //   37	52	59	java/lang/Throwable
    //   160	169	223	java/lang/Throwable
    //   172	182	223	java/lang/Throwable
    //   185	197	223	java/lang/Throwable
    //   205	220	223	java/lang/Throwable
    //   289	305	308	java/lang/Throwable
    //   26	32	349	finally
    //   106	119	349	finally
    //   131	141	349	finally
    //   148	157	349	finally
    //   160	169	349	finally
    //   172	182	349	finally
    //   185	197	349	finally
    //   205	220	349	finally
    //   232	241	349	finally
    //   248	256	349	finally
    //   263	271	349	finally
    //   278	289	349	finally
    //   359	368	349	finally
    //   371	379	349	finally
    //   382	390	349	finally
    //   393	404	349	finally
    //   26	32	354	java/lang/Throwable
    //   106	119	354	java/lang/Throwable
    //   131	141	354	java/lang/Throwable
    //   148	157	354	java/lang/Throwable
    //   232	241	354	java/lang/Throwable
    //   248	256	354	java/lang/Throwable
    //   263	271	354	java/lang/Throwable
    //   278	289	354	java/lang/Throwable
    //   404	420	423	java/lang/Throwable
    //   538	553	556	java/lang/Throwable
  }
  
  protected abstract int getRefreshTime();
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureAvailable: width = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height = ");
    localStringBuilder.append(paramInt2);
    QLog.i("ParticleTextureView", 1, localStringBuilder.toString());
    this.n = new Surface(paramSurfaceTexture);
    this.f = paramInt1;
    this.g = paramInt2;
    this.o = new Rect(0, 0, paramInt1, paramInt2);
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("Particle-Texture-Thread");
    paramSurfaceTexture.append(UUID.randomUUID());
    this.h = new HandlerThread(paramSurfaceTexture.toString());
    this.h.start();
    this.i = new ParticleTextureView.WorkHandler(this, this.h.getLooper());
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.n = null;
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setParticleListener(ParticleTextureView.ParticleListener paramParticleListener)
  {
    this.m = paramParticleListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
 * JD-Core Version:    0.7.0.1
 */