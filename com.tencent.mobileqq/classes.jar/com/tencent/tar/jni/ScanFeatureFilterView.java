package com.tencent.tar.jni;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.armap.sensor.rotation.MathUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ScanFeatureFilterView
  extends SurfaceView
  implements Handler.Callback, SurfaceHolder.Callback, CameraPointsExtract.OnReceiveResultListener
{
  private final int A;
  private SurfaceHolder B;
  private boolean C;
  private HandlerThread D;
  private Handler E;
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = -1;
  ScanFeatureFilterView.FeaturePoint[][] h = (ScanFeatureFilterView.FeaturePoint[][])null;
  private int i = -1;
  private int j = 0;
  private int k = 1;
  private int l = 2;
  private int m = this.i;
  private int n = 0;
  private int o = 0;
  private Bitmap p;
  private ARScanInfo q = null;
  private Paint r = new Paint();
  private volatile boolean s = false;
  private Rect t = new Rect();
  private int u = 300;
  private long v = 600L;
  private long w;
  private boolean x = false;
  private int y = 0;
  private int z = 0;
  
  public ScanFeatureFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    this.A = a(getContext(), 10.0F);
    this.p = BitmapFactory.decodeResource(paramContext.getResources(), 2130846705);
    setZOrderOnTop(true);
    this.B = getHolder();
    this.B.setFormat(-2);
    this.B.addCallback(this);
  }
  
  private float a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    double d1 = paramInt1 + paramFloat1 * paramInt2;
    Double.isNaN(d1);
    return (float)Math.sin(paramFloat2 * (float)(d1 * 3.141592653589793D));
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return 255;
          }
          return 229;
        }
        return 191;
      }
      return 127;
    }
    return 63;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static float b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 1.0F;
        }
        return 0.8F;
      }
      return 0.5F;
    }
    return 0.3F;
  }
  
  public static long b()
  {
    return System.currentTimeMillis();
  }
  
  public static int c(int paramInt)
  {
    return MathUtils.a.nextInt(paramInt);
  }
  
  private void c()
  {
    if ((!this.s) && (this.E != null) && (getVisibility() == 0))
    {
      Handler localHandler = this.E;
      if (localHandler != null) {
        localHandler.removeMessages(100);
      }
      localHandler = this.E;
      if (localHandler != null) {
        localHandler.sendEmptyMessageDelayed(100, 30L);
      }
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 234	com/tencent/tar/jni/ScanFeatureFilterView:c	()V
    //   4: aload_0
    //   5: getfield 95	com/tencent/tar/jni/ScanFeatureFilterView:s	Z
    //   8: ifne +301 -> 309
    //   11: aload_0
    //   12: getfield 86	com/tencent/tar/jni/ScanFeatureFilterView:q	Lcom/tencent/tar/jni/ARScanInfo;
    //   15: ifnull +294 -> 309
    //   18: aload_0
    //   19: invokevirtual 217	com/tencent/tar/jni/ScanFeatureFilterView:getVisibility	()I
    //   22: bipush 8
    //   24: if_icmpeq +285 -> 309
    //   27: aload_0
    //   28: getfield 236	com/tencent/tar/jni/ScanFeatureFilterView:C	Z
    //   31: ifne +4 -> 35
    //   34: return
    //   35: aconst_null
    //   36: astore 4
    //   38: aconst_null
    //   39: astore 5
    //   41: aconst_null
    //   42: astore_3
    //   43: aload 4
    //   45: astore_2
    //   46: aload 5
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 152	com/tencent/tar/jni/ScanFeatureFilterView:B	Landroid/view/SurfaceHolder;
    //   53: astore 6
    //   55: aload 4
    //   57: astore_2
    //   58: aload 5
    //   60: astore_1
    //   61: aload 6
    //   63: monitorenter
    //   64: aload_3
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 152	com/tencent/tar/jni/ScanFeatureFilterView:B	Landroid/view/SurfaceHolder;
    //   70: invokeinterface 240 1 0
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +29 -> 106
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 86	com/tencent/tar/jni/ScanFeatureFilterView:q	Lcom/tencent/tar/jni/ARScanInfo;
    //   86: ifnull +20 -> 106
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: iconst_0
    //   93: getstatic 246	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   96: invokevirtual 252	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: aload_2
    //   103: invokevirtual 255	com/tencent/tar/jni/ScanFeatureFilterView:a	(Landroid/graphics/Canvas;)V
    //   106: aload_2
    //   107: astore_1
    //   108: aload 6
    //   110: monitorexit
    //   111: aload_2
    //   112: ifnull +140 -> 252
    //   115: aload_0
    //   116: getfield 152	com/tencent/tar/jni/ScanFeatureFilterView:B	Landroid/view/SurfaceHolder;
    //   119: aload_2
    //   120: invokeinterface 258 2 0
    //   125: return
    //   126: astore_1
    //   127: new 260	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   134: astore_2
    //   135: aload_2
    //   136: ldc_w 263
    //   139: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: aload_1
    //   145: invokevirtual 271	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   148: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc_w 273
    //   155: iconst_2
    //   156: aload_2
    //   157: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: return
    //   164: astore_3
    //   165: aload 6
    //   167: monitorexit
    //   168: aload_1
    //   169: astore_2
    //   170: aload_3
    //   171: athrow
    //   172: astore_1
    //   173: goto +80 -> 253
    //   176: astore_3
    //   177: aload_1
    //   178: astore_2
    //   179: new 260	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   186: astore 4
    //   188: aload_1
    //   189: astore_2
    //   190: aload 4
    //   192: ldc_w 283
    //   195: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: astore_2
    //   201: aload 4
    //   203: aload_3
    //   204: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   207: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: astore_2
    //   213: ldc_w 273
    //   216: iconst_2
    //   217: aload 4
    //   219: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_1
    //   226: ifnull +26 -> 252
    //   229: aload_0
    //   230: getfield 152	com/tencent/tar/jni/ScanFeatureFilterView:B	Landroid/view/SurfaceHolder;
    //   233: aload_1
    //   234: invokeinterface 258 2 0
    //   239: return
    //   240: astore_1
    //   241: new 260	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   248: astore_2
    //   249: goto -114 -> 135
    //   252: return
    //   253: aload_2
    //   254: ifnull +53 -> 307
    //   257: aload_0
    //   258: getfield 152	com/tencent/tar/jni/ScanFeatureFilterView:B	Landroid/view/SurfaceHolder;
    //   261: aload_2
    //   262: invokeinterface 258 2 0
    //   267: goto +40 -> 307
    //   270: astore_2
    //   271: new 260	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   278: astore_3
    //   279: aload_3
    //   280: ldc_w 263
    //   283: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_3
    //   288: aload_2
    //   289: invokevirtual 271	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   292: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: ldc_w 273
    //   299: iconst_2
    //   300: aload_3
    //   301: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload_1
    //   308: athrow
    //   309: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	ScanFeatureFilterView
    //   48	60	1	localObject1	Object
    //   126	43	1	localThrowable1	Throwable
    //   172	62	1	localCanvas	Canvas
    //   240	68	1	localThrowable2	Throwable
    //   45	217	2	localObject2	Object
    //   270	19	2	localThrowable3	Throwable
    //   42	23	3	localObject3	Object
    //   164	7	3	localObject4	Object
    //   176	28	3	localException	Exception
    //   278	23	3	localStringBuilder1	StringBuilder
    //   36	182	4	localStringBuilder2	StringBuilder
    //   39	20	5	localObject5	Object
    //   53	113	6	localSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   115	125	126	java/lang/Throwable
    //   66	76	164	finally
    //   82	89	164	finally
    //   91	99	164	finally
    //   101	106	164	finally
    //   108	111	164	finally
    //   165	168	164	finally
    //   49	55	172	finally
    //   61	64	172	finally
    //   170	172	172	finally
    //   179	188	172	finally
    //   190	199	172	finally
    //   201	211	172	finally
    //   213	225	172	finally
    //   49	55	176	java/lang/Exception
    //   61	64	176	java/lang/Exception
    //   170	172	176	java/lang/Exception
    //   229	239	240	java/lang/Throwable
    //   257	267	270	java/lang/Throwable
  }
  
  protected void a()
  {
    this.r.setColor(this.g);
    this.r.setStyle(Paint.Style.FILL);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((!this.s) && (this.m == this.k))
    {
      Object localObject = this.q;
      if ((localObject != null) && (!((ARScanInfo)localObject).a) && (this.q.b != null))
      {
        int i2;
        int i4;
        if (!this.x)
        {
          i1 = 0;
          while (i1 < this.y)
          {
            i2 = 0;
            while (i2 < this.z)
            {
              localObject = this.h;
              if (localObject[i1][i2] == null) {
                localObject[i1][i2] = new ScanFeatureFilterView.FeaturePoint();
              }
              i3 = c(4);
              this.h[i1][i2].d = a(i3);
              this.h[i1][i2].c = b(i3);
              i2 += 1;
            }
            i1 += 1;
          }
          localObject = this.q.b;
          this.v = b();
          i1 = 0;
          while (i1 < ((ARScanInfo.QBMatrix)localObject).a())
          {
            i2 = ((ARScanInfo.QBMatrix)localObject).a(i1, 0);
            i3 = ((ARScanInfo.QBMatrix)localObject).a(i1, 1);
            i4 = this.A;
            if ((i2 > i4) && (i3 > i4))
            {
              i2 /= i4;
              i3 /= i4;
              if ((i2 < this.z) && (i3 < this.y))
              {
                ScanFeatureFilterView.FeaturePoint localFeaturePoint = this.h[i3][i2];
                localFeaturePoint.h = true;
                localFeaturePoint.f = (c(10) * 50);
                localFeaturePoint.e = (this.v + localFeaturePoint.f);
                i4 = this.A;
                localFeaturePoint.a = (i2 * i4);
                localFeaturePoint.b = (i3 * i4);
              }
            }
            i1 += 1;
          }
          this.x = true;
        }
        this.w = (b() - this.v);
        int i3 = 0;
        int i1 = 0;
        while (i3 < this.y)
        {
          i4 = 0;
          while (i4 < this.z)
          {
            localObject = this.h[i3][i4];
            i2 = i1;
            if (localObject != null) {
              if (!((ScanFeatureFilterView.FeaturePoint)localObject).h)
              {
                i2 = i1;
              }
              else
              {
                if (this.w >= ((ScanFeatureFilterView.FeaturePoint)localObject).f) {
                  break label460;
                }
                i2 = i1 + 1;
              }
            }
            label460:
            float f1;
            do
            {
              do
              {
                for (;;)
                {
                  i1 = i2;
                  break label713;
                  f3 = a(0, 1, ((ScanFeatureFilterView.FeaturePoint)localObject).a(this.u, this.w - ((ScanFeatureFilterView.FeaturePoint)localObject).f), 1.0F);
                  f2 = 255.0F;
                  f1 = f3 * 255.0F;
                  if (f1 <= 255.0F) {
                    f2 = f1;
                  }
                  f1 = f3;
                  if (f3 > 1.0F) {
                    f1 = 1.0F;
                  }
                  ((ScanFeatureFilterView.FeaturePoint)localObject).d = f2;
                  ((ScanFeatureFilterView.FeaturePoint)localObject).c = f1;
                  if (!((ScanFeatureFilterView.FeaturePoint)localObject).g) {
                    break;
                  }
                  ((ScanFeatureFilterView.FeaturePoint)localObject).a();
                  i2 = i1;
                }
                i1 += 1;
                this.r.setAlpha((int)f2);
                localObject = this.p;
                i2 = i1;
              } while (localObject == null);
              i2 = i1;
            } while (((Bitmap)localObject).isRecycled());
            i2 = this.A;
            localObject = this.t;
            float f2 = i4 * i2;
            int i5 = (int)(f2 - this.p.getWidth() * f1 / 2.0F);
            float f3 = i2 * i3;
            ((Rect)localObject).set(i5, (int)(f3 - this.p.getHeight() * f1 / 2.0F), (int)(f2 + this.p.getWidth() * f1 / 2.0F), (int)(f3 + this.p.getHeight() * f1 / 2.0F));
            paramCanvas.drawBitmap(this.p, null, this.t, this.r);
            label713:
            i4 += 1;
          }
          i3 += 1;
        }
        if (i1 <= 16)
        {
          i1 = 0;
          while (i1 < this.y)
          {
            i2 = 0;
            while (i2 < this.z)
            {
              paramCanvas = this.h;
              if (paramCanvas[i1][i2] == null) {
                paramCanvas[i1][i2] = new ScanFeatureFilterView.FeaturePoint();
              }
              this.h[i1][i2].a();
              i2 += 1;
            }
            i1 += 1;
          }
          this.v = b();
          paramCanvas = this.q.b;
          i1 = 0;
          while (i1 < paramCanvas.a())
          {
            i2 = paramCanvas.a(i1, 0);
            i3 = paramCanvas.a(i1, 1);
            i4 = this.A;
            if ((i2 > i4) && (i3 > i4))
            {
              i2 /= i4;
              i3 /= i4;
              if ((i2 < this.z) && (i3 < this.y))
              {
                localObject = this.h[i3][i2];
                i4 = c(4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).d = a(i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).c = b(i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).f = (c(10) * 50);
                ((ScanFeatureFilterView.FeaturePoint)localObject).e = (this.v + ((ScanFeatureFilterView.FeaturePoint)localObject).f);
                i4 = this.A;
                ((ScanFeatureFilterView.FeaturePoint)localObject).a = (i2 * i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).b = (i3 * i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).h = true;
              }
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject != null) && (!this.s))
    {
      try
      {
        this.q = ((ARScanInfo)paramObject);
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      this.m = this.k;
      a(true);
      return;
    }
    this.m = this.j;
  }
  
  void a(boolean paramBoolean)
  {
    Handler localHandler;
    if (!paramBoolean)
    {
      localHandler = this.E;
      if (localHandler != null) {
        localHandler.removeMessages(100);
      }
    }
    if (paramBoolean)
    {
      localHandler = this.E;
      if ((localHandler != null) && (!localHandler.hasMessages(100))) {
        this.E.sendEmptyMessage(100);
      }
    }
  }
  
  public void a(int[] paramArrayOfInt, ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    if (this.a != 0)
    {
      if (this.b == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList(paramArrayList.size() / 2);
      int i1 = this.a / paramInt2;
      i1 = this.b / paramInt1;
      boolean bool = false;
      i1 = 0;
      while (i1 < paramArrayList.size() / 2)
      {
        int i2 = i1 * 2;
        float f1 = ((Integer)paramArrayList.get(i2)).intValue();
        float f2 = ((Integer)paramArrayList.get(i2 + 1)).intValue();
        float f3 = this.a / paramInt1;
        float f4 = this.b / paramInt2;
        localArrayList.add(new Point((int)(f1 * f3), (int)(f2 * f4)));
        i1 += 1;
      }
      if (paramArrayOfInt[0] == 0) {
        bool = true;
      }
      a(ARScanInfo.a(bool, localArrayList));
    }
  }
  
  public ARScanInfo.QBMatrix getFeature()
  {
    ARScanInfo localARScanInfo = this.q;
    if (localARScanInfo != null) {
      return localARScanInfo.b;
    }
    return null;
  }
  
  public ScanFeatureFilterView.FeaturePoint[][] getFeaturePoints()
  {
    return this.h;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {}
    try
    {
      d();
      label16:
      return true;
    }
    catch (Throwable paramMessage)
    {
      break label16;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("ScanFeatureFilterView", 2, "onSizeChanged ");
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = getMeasuredWidth();
    this.b = getMeasuredHeight();
    paramInt1 = this.a;
    paramInt2 = this.A;
    this.z = (paramInt1 / paramInt2);
    this.y = (this.b / paramInt2);
    this.h = ((ScanFeatureFilterView.FeaturePoint[][])Array.newInstance(ScanFeatureFilterView.FeaturePoint.class, new int[] { this.y, this.z }));
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("ScanFeatureFilterView", 2, "create ");
    this.C = true;
    this.D = new HandlerThread("FeaturePointDetecto_thread");
    this.D.start();
    this.E = new Handler(this.D.getLooper(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("ScanFeatureFilterView", 2, "surfaceDestroyed ");
    try
    {
      this.C = false;
      this.E.removeCallbacksAndMessages(null);
      this.D.quit();
      this.D = null;
      this.E = null;
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("surfaceDestroyed error = ");
      localStringBuilder.append(paramSurfaceHolder.getMessage());
      QLog.e("ScanFeatureFilterView", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tar.jni.ScanFeatureFilterView
 * JD-Core Version:    0.7.0.1
 */