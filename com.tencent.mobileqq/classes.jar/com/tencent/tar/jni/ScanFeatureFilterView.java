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
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 600L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private ARScanInfo jdField_a_of_type_ComTencentTarJniARScanInfo = null;
  private volatile boolean jdField_a_of_type_Boolean = false;
  ScanFeatureFilterView.FeaturePoint[][] jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint = (ScanFeatureFilterView.FeaturePoint[][])null;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = -1;
  private int h = -1;
  private int i = 0;
  private int j = 1;
  private int k = 2;
  private int l = this.h;
  private int m = 0;
  private int n = 0;
  private int o = 300;
  private int p = 0;
  private int q = 0;
  private final int r;
  
  public ScanFeatureFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    this.r = a(getContext(), 10.0F);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130845376);
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
    return MathUtils.a.nextInt(paramInt);
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
    //   1: invokespecial 215	com/tencent/tar/jni/ScanFeatureFilterView:b	()V
    //   4: aload_0
    //   5: getfield 82	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_Boolean	Z
    //   8: ifne +26 -> 34
    //   11: aload_0
    //   12: getfield 73	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_ComTencentTarJniARScanInfo	Lcom/tencent/tar/jni/ARScanInfo;
    //   15: ifnull +19 -> 34
    //   18: aload_0
    //   19: invokevirtual 198	com/tencent/tar/jni/ScanFeatureFilterView:getVisibility	()I
    //   22: bipush 8
    //   24: if_icmpeq +10 -> 34
    //   27: aload_0
    //   28: getfield 217	com/tencent/tar/jni/ScanFeatureFilterView:jdField_c_of_type_Boolean	Z
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
    //   50: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
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
    //   67: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   70: invokeinterface 221 1 0
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +29 -> 106
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 73	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_ComTencentTarJniARScanInfo	Lcom/tencent/tar/jni/ARScanInfo;
    //   86: ifnull +20 -> 106
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: iconst_0
    //   93: getstatic 227	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   96: invokevirtual 233	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: aload_2
    //   103: invokevirtual 236	com/tencent/tar/jni/ScanFeatureFilterView:a	(Landroid/graphics/Canvas;)V
    //   106: aload_2
    //   107: astore_1
    //   108: aload 6
    //   110: monitorexit
    //   111: aload_2
    //   112: ifnull -78 -> 34
    //   115: aload_0
    //   116: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   119: aload_2
    //   120: invokeinterface 239 2 0
    //   125: return
    //   126: astore_1
    //   127: ldc 241
    //   129: iconst_2
    //   130: new 243	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   137: ldc 246
    //   139: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 254	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   167: ldc 241
    //   169: iconst_2
    //   170: new 243	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 264
    //   180: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_3
    //   184: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_2
    //   197: ifnull -163 -> 34
    //   200: aload_0
    //   201: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   204: aload_2
    //   205: invokeinterface 239 2 0
    //   210: return
    //   211: astore_1
    //   212: ldc 241
    //   214: iconst_2
    //   215: new 243	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   222: ldc 246
    //   224: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokevirtual 254	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: return
    //   241: astore_2
    //   242: aload_1
    //   243: ifnull +13 -> 256
    //   246: aload_0
    //   247: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   250: aload_1
    //   251: invokeinterface 239 2 0
    //   256: aload_2
    //   257: athrow
    //   258: astore_1
    //   259: ldc 241
    //   261: iconst_2
    //   262: new 243	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   269: ldc 246
    //   271: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_1
    //   275: invokevirtual 254	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: goto -31 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	ScanFeatureFilterView
    //   48	60	1	localObject1	Object
    //   126	35	1	localThrowable1	Throwable
    //   166	1	1	localObject2	Object
    //   211	40	1	localThrowable2	Throwable
    //   258	17	1	localThrowable3	Throwable
    //   45	160	2	localObject3	Object
    //   241	16	2	localObject4	Object
    //   42	23	3	localObject5	Object
    //   156	7	3	localObject6	Object
    //   164	20	3	localException	Exception
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
    //   200	210	211	java/lang/Throwable
    //   49	55	241	finally
    //   61	64	241	finally
    //   162	164	241	finally
    //   167	196	241	finally
    //   246	256	258	java/lang/Throwable
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.l == this.j) && (this.jdField_a_of_type_ComTencentTarJniARScanInfo != null) && (!this.jdField_a_of_type_ComTencentTarJniARScanInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentTarJniARScanInfo.jdField_a_of_type_ComTencentTarJniARScanInfo$QBMatrix != null))
    {
      int i2;
      Object localObject;
      if (!this.jdField_b_of_type_Boolean)
      {
        i1 = 0;
        while (i1 < this.p)
        {
          i2 = 0;
          while (i2 < this.q)
          {
            if (this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i1][i2] == null) {
              this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i1][i2] = new ScanFeatureFilterView.FeaturePoint();
            }
            i3 = b(4);
            this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i1][i2].jdField_b_of_type_Float = a(i3);
            this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i1][i2].jdField_a_of_type_Float = a(i3);
            i2 += 1;
          }
          i1 += 1;
        }
        localObject = this.jdField_a_of_type_ComTencentTarJniARScanInfo.jdField_a_of_type_ComTencentTarJniARScanInfo$QBMatrix;
        this.jdField_a_of_type_Long = a();
        i1 = 0;
        while (i1 < ((ARScanInfo.QBMatrix)localObject).a())
        {
          i3 = ((ARScanInfo.QBMatrix)localObject).a(i1, 0);
          i2 = ((ARScanInfo.QBMatrix)localObject).a(i1, 1);
          if ((i3 > this.r) && (i2 > this.r))
          {
            i3 /= this.r;
            i2 /= this.r;
            if ((i3 < this.q) && (i2 < this.p))
            {
              ScanFeatureFilterView.FeaturePoint localFeaturePoint = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i2][i3];
              localFeaturePoint.jdField_b_of_type_Boolean = true;
              localFeaturePoint.jdField_b_of_type_Long = (b(10) * 50);
              localFeaturePoint.jdField_a_of_type_Long = (this.jdField_a_of_type_Long + localFeaturePoint.jdField_b_of_type_Long);
              localFeaturePoint.jdField_a_of_type_Int = (i3 * this.r);
              localFeaturePoint.jdField_b_of_type_Int = (this.r * i2);
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
      while (i3 < this.p)
      {
        i4 = 0;
        if (i4 < this.q)
        {
          localObject = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i3][i4];
          i2 = i1;
          if (localObject != null) {
            if (((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Boolean) {}
          }
          for (;;)
          {
            i4 += 1;
            break;
            if (this.jdField_b_of_type_Long < ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long)
            {
              i1 += 1;
            }
            else
            {
              float f3 = a(0, 1, ((ScanFeatureFilterView.FeaturePoint)localObject).a(this.o, this.jdField_b_of_type_Long - ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long), 1.0F);
              float f2 = 255.0F * f3;
              float f1 = f2;
              if (f2 > 255.0F) {
                f1 = 255.0F;
              }
              f2 = f3;
              if (f3 > 1.0F) {
                f2 = 1.0F;
              }
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Float = f1;
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Float = f2;
              if (((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Boolean)
              {
                ((ScanFeatureFilterView.FeaturePoint)localObject).a();
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
                    int i7 = this.r * i4;
                    i2 = this.r * i3;
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
        while (i1 < this.p)
        {
          i2 = 0;
          while (i2 < this.q)
          {
            if (this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i1][i2] == null) {
              this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i1][i2] = new ScanFeatureFilterView.FeaturePoint();
            }
            this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i1][i2].a();
            i2 += 1;
          }
          i1 += 1;
        }
        this.jdField_a_of_type_Long = a();
        paramCanvas = this.jdField_a_of_type_ComTencentTarJniARScanInfo.jdField_a_of_type_ComTencentTarJniARScanInfo$QBMatrix;
        i1 = 0;
        while (i1 < paramCanvas.a())
        {
          i2 = paramCanvas.a(i1, 0);
          i3 = paramCanvas.a(i1, 1);
          if ((i2 > this.r) && (i3 > this.r))
          {
            i2 /= this.r;
            i3 /= this.r;
            if ((i2 < this.q) && (i3 < this.p))
            {
              localObject = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i3][i2];
              i4 = b(4);
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Float = a(i4);
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Float = a(i4);
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long = (b(10) * 50);
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Long = (this.jdField_a_of_type_Long + ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long);
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Int = (i2 * this.r);
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Int = (this.r * i3);
              ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Boolean = true;
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (this.jdField_a_of_type_Boolean))
    {
      this.l = this.i;
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentTarJniARScanInfo = ((ARScanInfo)paramObject);
      this.l = this.j;
      a(true);
      return;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(100))) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
    }
  }
  
  public void a(int[] paramArrayOfInt, ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size() / 2);
    int i1 = this.jdField_a_of_type_Int / paramInt2;
    i1 = this.jdField_b_of_type_Int / paramInt1;
    i1 = 0;
    while (i1 < paramArrayList.size() / 2)
    {
      float f1 = ((Integer)paramArrayList.get(i1 * 2)).intValue();
      float f2 = ((Integer)paramArrayList.get(i1 * 2 + 1)).intValue();
      float f3 = this.jdField_a_of_type_Int / paramInt1;
      float f4 = this.jdField_b_of_type_Int / paramInt2;
      localArrayList.add(new Point((int)(f1 * f3), (int)(f2 * f4)));
      i1 += 1;
    }
    if (paramArrayOfInt[0] == 0) {
      bool = true;
    }
    a(ARScanInfo.a(bool, localArrayList));
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
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("ScanFeatureFilterView", 2, "onSizeChanged ");
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = getMeasuredWidth();
    this.jdField_b_of_type_Int = getMeasuredHeight();
    this.q = (this.jdField_a_of_type_Int / this.r);
    this.p = (this.jdField_b_of_type_Int / this.r);
    this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint = ((ScanFeatureFilterView.FeaturePoint[][])Array.newInstance(ScanFeatureFilterView.FeaturePoint.class, new int[] { this.p, this.q }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tar.jni.ScanFeatureFilterView
 * JD-Core Version:    0.7.0.1
 */