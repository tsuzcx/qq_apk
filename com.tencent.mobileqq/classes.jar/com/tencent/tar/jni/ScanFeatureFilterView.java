package com.tencent.tar.jni;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
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
import aqdy;
import bkxe;
import bkxf;
import bkxg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.Random;

public class ScanFeatureFilterView
  extends SurfaceView
  implements Handler.Callback, SurfaceHolder.Callback
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 600L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private bkxe jdField_a_of_type_Bkxe;
  private volatile boolean jdField_a_of_type_Boolean;
  bkxg[][] jdField_a_of_type_Array2dOfBkxg = (bkxg[][])null;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = -1;
  private int h = -1;
  private int i = 1;
  private int j = 2;
  private int k = this.h;
  private int l = 300;
  private int m;
  private int n;
  private final int o;
  
  public ScanFeatureFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    this.o = a(getContext(), 10.0F);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130845214);
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
  }
  
  public static float a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return 1.0F;
    case 0: 
      return 0.3F;
    case 1: 
      return 0.5F;
    }
    return 0.8F;
  }
  
  private float a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return (float)Math.sin((float)((paramInt1 + paramInt2 * paramFloat1) * 3.141592653589793D) * paramFloat2);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 255;
    case 0: 
      return 63;
    case 1: 
      return 127;
    case 2: 
      return 191;
    }
    return 229;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static long a()
  {
    return System.currentTimeMillis();
  }
  
  public static int b(int paramInt)
  {
    return aqdy.a.nextInt(paramInt);
  }
  
  private void b()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null) && (getVisibility() == 0))
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 30L);
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 196	com/tencent/tar/jni/ScanFeatureFilterView:b	()V
    //   4: aload_0
    //   5: getfield 173	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_Boolean	Z
    //   8: ifne +26 -> 34
    //   11: aload_0
    //   12: getfield 198	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_Bkxe	Lbkxe;
    //   15: ifnull +19 -> 34
    //   18: aload_0
    //   19: invokevirtual 179	com/tencent/tar/jni/ScanFeatureFilterView:getVisibility	()I
    //   22: bipush 8
    //   24: if_icmpeq +10 -> 34
    //   27: aload_0
    //   28: getfield 200	com/tencent/tar/jni/ScanFeatureFilterView:jdField_c_of_type_Boolean	Z
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
    //   50: getfield 118	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
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
    //   67: getfield 118	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   70: invokeinterface 204 1 0
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +29 -> 106
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 198	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_Bkxe	Lbkxe;
    //   86: ifnull +20 -> 106
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: iconst_0
    //   93: getstatic 210	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   96: invokevirtual 216	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: aload_2
    //   103: invokevirtual 219	com/tencent/tar/jni/ScanFeatureFilterView:a	(Landroid/graphics/Canvas;)V
    //   106: aload_2
    //   107: astore_1
    //   108: aload 6
    //   110: monitorexit
    //   111: aload_2
    //   112: ifnull -78 -> 34
    //   115: aload_0
    //   116: getfield 118	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   119: aload_2
    //   120: invokeinterface 222 2 0
    //   125: return
    //   126: astore_1
    //   127: ldc 224
    //   129: iconst_2
    //   130: new 226	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   137: ldc 229
    //   139: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 237	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: return
    //   156: astore_3
    //   157: aload 6
    //   159: monitorexit
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: athrow
    //   164: astore_3
    //   165: aload_2
    //   166: astore_1
    //   167: ldc 224
    //   169: iconst_2
    //   170: new 226	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   177: ldc 247
    //   179: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_3
    //   183: invokevirtual 248	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_2
    //   196: ifnull -162 -> 34
    //   199: aload_0
    //   200: getfield 118	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   203: aload_2
    //   204: invokeinterface 222 2 0
    //   209: return
    //   210: astore_1
    //   211: ldc 224
    //   213: iconst_2
    //   214: new 226	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   221: ldc 229
    //   223: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: invokevirtual 237	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: return
    //   240: astore_2
    //   241: aload_1
    //   242: ifnull +13 -> 255
    //   245: aload_0
    //   246: getfield 118	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   249: aload_1
    //   250: invokeinterface 222 2 0
    //   255: aload_2
    //   256: athrow
    //   257: astore_1
    //   258: ldc 224
    //   260: iconst_2
    //   261: new 226	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   268: ldc 229
    //   270: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: invokevirtual 237	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   277: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: goto -31 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	ScanFeatureFilterView
    //   48	60	1	localObject1	Object
    //   126	35	1	localThrowable1	Throwable
    //   166	1	1	localObject2	Object
    //   210	40	1	localThrowable2	Throwable
    //   257	17	1	localThrowable3	Throwable
    //   45	159	2	localObject3	Object
    //   240	16	2	localObject4	Object
    //   42	23	3	localObject5	Object
    //   156	7	3	localObject6	Object
    //   164	19	3	localException	Exception
    //   36	20	4	localObject7	Object
    //   39	20	5	localObject8	Object
    //   53	105	6	localSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   115	125	126	java/lang/Throwable
    //   66	76	156	finally
    //   82	89	156	finally
    //   91	99	156	finally
    //   101	106	156	finally
    //   108	111	156	finally
    //   157	160	156	finally
    //   49	55	164	java/lang/Exception
    //   61	64	164	java/lang/Exception
    //   162	164	164	java/lang/Exception
    //   199	209	210	java/lang/Throwable
    //   49	55	240	finally
    //   61	64	240	finally
    //   162	164	240	finally
    //   167	195	240	finally
    //   245	255	257	java/lang/Throwable
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.k == this.i) && (this.jdField_a_of_type_Bkxe != null) && (!this.jdField_a_of_type_Bkxe.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bkxe.jdField_a_of_type_Bkxf != null))
    {
      int i2;
      Object localObject;
      if (!this.jdField_b_of_type_Boolean)
      {
        i1 = 0;
        while (i1 < this.m)
        {
          i2 = 0;
          while (i2 < this.n)
          {
            if (this.jdField_a_of_type_Array2dOfBkxg[i1][i2] == null) {
              this.jdField_a_of_type_Array2dOfBkxg[i1][i2] = new bkxg();
            }
            i3 = b(4);
            this.jdField_a_of_type_Array2dOfBkxg[i1][i2].jdField_b_of_type_Float = a(i3);
            this.jdField_a_of_type_Array2dOfBkxg[i1][i2].jdField_a_of_type_Float = a(i3);
            i2 += 1;
          }
          i1 += 1;
        }
        localObject = this.jdField_a_of_type_Bkxe.jdField_a_of_type_Bkxf;
        this.jdField_a_of_type_Long = a();
        i1 = 0;
        while (i1 < ((bkxf)localObject).a())
        {
          i3 = ((bkxf)localObject).a(i1, 0);
          i2 = ((bkxf)localObject).a(i1, 1);
          if ((i3 > this.o) && (i2 > this.o))
          {
            i3 /= this.o;
            i2 /= this.o;
            if ((i3 < this.n) && (i2 < this.m))
            {
              bkxg localbkxg = this.jdField_a_of_type_Array2dOfBkxg[i2][i3];
              localbkxg.jdField_b_of_type_Boolean = true;
              localbkxg.jdField_b_of_type_Long = (b(10) * 50);
              localbkxg.jdField_a_of_type_Long = (this.jdField_a_of_type_Long + localbkxg.jdField_b_of_type_Long);
              localbkxg.jdField_a_of_type_Int = (i3 * this.o);
              localbkxg.jdField_b_of_type_Int = (this.o * i2);
            }
          }
          i1 += 1;
        }
        this.jdField_b_of_type_Boolean = true;
      }
      int i1 = 0;
      this.jdField_b_of_type_Long = (a() - this.jdField_a_of_type_Long);
      int i3 = 0;
      int i4;
      while (i3 < this.m)
      {
        i4 = 0;
        if (i4 < this.n)
        {
          localObject = this.jdField_a_of_type_Array2dOfBkxg[i3][i4];
          i2 = i1;
          if (localObject != null) {
            if (((bkxg)localObject).jdField_b_of_type_Boolean) {}
          }
          for (;;)
          {
            i4 += 1;
            break;
            if (this.jdField_b_of_type_Long < ((bkxg)localObject).jdField_b_of_type_Long)
            {
              i1 += 1;
            }
            else
            {
              float f3 = a(0, 1, ((bkxg)localObject).a(this.l, this.jdField_b_of_type_Long - ((bkxg)localObject).jdField_b_of_type_Long), 1.0F);
              float f2 = 255.0F * f3;
              float f1 = f2;
              if (f2 > 255.0F) {
                f1 = 255.0F;
              }
              f2 = f3;
              if (f3 > 1.0F) {
                f2 = 1.0F;
              }
              ((bkxg)localObject).jdField_b_of_type_Float = f1;
              ((bkxg)localObject).jdField_a_of_type_Float = f2;
              if (((bkxg)localObject).jdField_a_of_type_Boolean)
              {
                ((bkxg)localObject).a();
              }
              else
              {
                i1 += 1;
                this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)f1);
                i2 = i1;
                if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
                {
                  i2 = i1;
                  if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
                  {
                    int i7 = this.o * i4;
                    i2 = this.o * i3;
                    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
                    int i5 = (int)(i7 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * f2 / 2.0F);
                    int i6 = (int)(i2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * f2 / 2.0F);
                    i7 = (int)(i7 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * f2 / 2.0F);
                    f1 = i2;
                    ((Rect)localObject).set(i5, i6, i7, (int)(f2 * this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2.0F + f1));
                    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
                    i2 = i1;
                  }
                }
                i1 = i2;
              }
            }
          }
        }
        i3 += 1;
      }
      if (i1 <= 16)
      {
        i1 = 0;
        while (i1 < this.m)
        {
          i2 = 0;
          while (i2 < this.n)
          {
            if (this.jdField_a_of_type_Array2dOfBkxg[i1][i2] == null) {
              this.jdField_a_of_type_Array2dOfBkxg[i1][i2] = new bkxg();
            }
            this.jdField_a_of_type_Array2dOfBkxg[i1][i2].a();
            i2 += 1;
          }
          i1 += 1;
        }
        this.jdField_a_of_type_Long = a();
        paramCanvas = this.jdField_a_of_type_Bkxe.jdField_a_of_type_Bkxf;
        i1 = 0;
        while (i1 < paramCanvas.a())
        {
          i2 = paramCanvas.a(i1, 0);
          i3 = paramCanvas.a(i1, 1);
          if ((i2 > this.o) && (i3 > this.o))
          {
            i2 /= this.o;
            i3 /= this.o;
            if ((i2 < this.n) && (i3 < this.m))
            {
              localObject = this.jdField_a_of_type_Array2dOfBkxg[i3][i2];
              i4 = b(4);
              ((bkxg)localObject).jdField_b_of_type_Float = a(i4);
              ((bkxg)localObject).jdField_a_of_type_Float = a(i4);
              ((bkxg)localObject).jdField_b_of_type_Long = (b(10) * 50);
              ((bkxg)localObject).jdField_a_of_type_Long = (this.jdField_a_of_type_Long + ((bkxg)localObject).jdField_b_of_type_Long);
              ((bkxg)localObject).jdField_a_of_type_Int = (i2 * this.o);
              ((bkxg)localObject).jdField_b_of_type_Int = (this.o * i3);
              ((bkxg)localObject).jdField_b_of_type_Boolean = true;
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      try
      {
        c();
      }
      catch (Throwable paramMessage) {}
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("ScanFeatureFilterView", 2, "onSizeChanged ");
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = getMeasuredWidth();
    this.jdField_b_of_type_Int = getMeasuredHeight();
    this.n = (this.jdField_a_of_type_Int / this.o);
    this.m = (this.jdField_b_of_type_Int / this.o);
    this.jdField_a_of_type_Array2dOfBkxg = ((bkxg[][])Array.newInstance(bkxg.class, new int[] { this.m, this.n }));
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("ScanFeatureFilterView", 2, "create ");
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("FeaturePointDetecto_thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    QLog.d("ScanFeatureFilterView", 2, "surfaceDestroyed ");
    try
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      QLog.e("ScanFeatureFilterView", 2, "surfaceDestroyed error = " + paramSurfaceHolder.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tar.jni.ScanFeatureFilterView
 * JD-Core Version:    0.7.0.1
 */