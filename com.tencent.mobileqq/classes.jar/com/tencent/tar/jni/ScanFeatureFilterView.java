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
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130845249);
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
  }
  
  public static float a(int paramInt)
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
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.removeMessages(100);
      }
      localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.sendEmptyMessageDelayed(100, 30L);
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 221	com/tencent/tar/jni/ScanFeatureFilterView:b	()V
    //   4: aload_0
    //   5: getfield 82	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_Boolean	Z
    //   8: ifne +299 -> 307
    //   11: aload_0
    //   12: getfield 73	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_ComTencentTarJniARScanInfo	Lcom/tencent/tar/jni/ARScanInfo;
    //   15: ifnull +292 -> 307
    //   18: aload_0
    //   19: invokevirtual 204	com/tencent/tar/jni/ScanFeatureFilterView:getVisibility	()I
    //   22: bipush 8
    //   24: if_icmpeq +283 -> 307
    //   27: aload_0
    //   28: getfield 223	com/tencent/tar/jni/ScanFeatureFilterView:jdField_c_of_type_Boolean	Z
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
    //   70: invokeinterface 227 1 0
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
    //   93: getstatic 233	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   96: invokevirtual 239	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_0
    //   102: aload_2
    //   103: invokevirtual 242	com/tencent/tar/jni/ScanFeatureFilterView:a	(Landroid/graphics/Canvas;)V
    //   106: aload_2
    //   107: astore_1
    //   108: aload 6
    //   110: monitorexit
    //   111: aload_2
    //   112: ifnull +139 -> 251
    //   115: aload_0
    //   116: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   119: aload_2
    //   120: invokeinterface 245 2 0
    //   125: return
    //   126: astore_1
    //   127: new 247	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   134: astore_2
    //   135: aload_2
    //   136: ldc 250
    //   138: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_2
    //   143: aload_1
    //   144: invokevirtual 258	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc_w 260
    //   154: iconst_2
    //   155: aload_2
    //   156: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: return
    //   163: astore_3
    //   164: aload 6
    //   166: monitorexit
    //   167: aload_1
    //   168: astore_2
    //   169: aload_3
    //   170: athrow
    //   171: astore_1
    //   172: goto +80 -> 252
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: new 247	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   185: astore 4
    //   187: aload_1
    //   188: astore_2
    //   189: aload 4
    //   191: ldc_w 270
    //   194: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: astore_2
    //   200: aload 4
    //   202: aload_3
    //   203: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   206: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_1
    //   211: astore_2
    //   212: ldc_w 260
    //   215: iconst_2
    //   216: aload 4
    //   218: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_1
    //   225: ifnull +26 -> 251
    //   228: aload_0
    //   229: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   232: aload_1
    //   233: invokeinterface 245 2 0
    //   238: return
    //   239: astore_1
    //   240: new 247	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   247: astore_2
    //   248: goto -113 -> 135
    //   251: return
    //   252: aload_2
    //   253: ifnull +52 -> 305
    //   256: aload_0
    //   257: getfield 139	com/tencent/tar/jni/ScanFeatureFilterView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   260: aload_2
    //   261: invokeinterface 245 2 0
    //   266: goto +39 -> 305
    //   269: astore_2
    //   270: new 247	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: ldc 250
    //   281: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_3
    //   286: aload_2
    //   287: invokevirtual 258	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   290: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: ldc_w 260
    //   297: iconst_2
    //   298: aload_3
    //   299: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 268	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_1
    //   306: athrow
    //   307: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	ScanFeatureFilterView
    //   48	60	1	localObject1	Object
    //   126	42	1	localThrowable1	Throwable
    //   171	62	1	localCanvas	Canvas
    //   239	67	1	localThrowable2	Throwable
    //   45	216	2	localObject2	Object
    //   269	18	2	localThrowable3	Throwable
    //   42	23	3	localObject3	Object
    //   163	7	3	localObject4	Object
    //   175	28	3	localException	Exception
    //   277	22	3	localStringBuilder1	StringBuilder
    //   36	181	4	localStringBuilder2	StringBuilder
    //   39	20	5	localObject5	Object
    //   53	112	6	localSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   115	125	126	java/lang/Throwable
    //   66	76	163	finally
    //   82	89	163	finally
    //   91	99	163	finally
    //   101	106	163	finally
    //   108	111	163	finally
    //   164	167	163	finally
    //   49	55	171	finally
    //   61	64	171	finally
    //   169	171	171	finally
    //   178	187	171	finally
    //   189	198	171	finally
    //   200	210	171	finally
    //   212	224	171	finally
    //   49	55	175	java/lang/Exception
    //   61	64	175	java/lang/Exception
    //   169	171	175	java/lang/Exception
    //   228	238	239	java/lang/Throwable
    //   256	266	269	java/lang/Throwable
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.l == this.j))
    {
      Object localObject = this.jdField_a_of_type_ComTencentTarJniARScanInfo;
      if ((localObject != null) && (!((ARScanInfo)localObject).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentTarJniARScanInfo.jdField_a_of_type_ComTencentTarJniARScanInfo$QBMatrix != null))
      {
        int i2;
        int i4;
        if (!this.jdField_b_of_type_Boolean)
        {
          i1 = 0;
          while (i1 < this.p)
          {
            i2 = 0;
            while (i2 < this.q)
            {
              localObject = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint;
              if (localObject[i1][i2] == null) {
                localObject[i1][i2] = new ScanFeatureFilterView.FeaturePoint();
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
            i2 = ((ARScanInfo.QBMatrix)localObject).a(i1, 0);
            i3 = ((ARScanInfo.QBMatrix)localObject).a(i1, 1);
            i4 = this.r;
            if ((i2 > i4) && (i3 > i4))
            {
              i2 /= i4;
              i3 /= i4;
              if ((i2 < this.q) && (i3 < this.p))
              {
                ScanFeatureFilterView.FeaturePoint localFeaturePoint = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i3][i2];
                localFeaturePoint.jdField_b_of_type_Boolean = true;
                localFeaturePoint.jdField_b_of_type_Long = (b(10) * 50);
                localFeaturePoint.jdField_a_of_type_Long = (this.jdField_a_of_type_Long + localFeaturePoint.jdField_b_of_type_Long);
                i4 = this.r;
                localFeaturePoint.jdField_a_of_type_Int = (i2 * i4);
                localFeaturePoint.jdField_b_of_type_Int = (i3 * i4);
              }
            }
            i1 += 1;
          }
          this.jdField_b_of_type_Boolean = true;
        }
        this.jdField_b_of_type_Long = (a() - this.jdField_a_of_type_Long);
        int i3 = 0;
        int i1 = 0;
        while (i3 < this.p)
        {
          i4 = 0;
          while (i4 < this.q)
          {
            localObject = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i3][i4];
            i2 = i1;
            if (localObject != null) {
              if (!((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Boolean)
              {
                i2 = i1;
              }
              else
              {
                if (this.jdField_b_of_type_Long >= ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long) {
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
                  f3 = a(0, 1, ((ScanFeatureFilterView.FeaturePoint)localObject).a(this.o, this.jdField_b_of_type_Long - ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long), 1.0F);
                  f2 = 255.0F;
                  f1 = f3 * 255.0F;
                  if (f1 <= 255.0F) {
                    f2 = f1;
                  }
                  f1 = f3;
                  if (f3 > 1.0F) {
                    f1 = 1.0F;
                  }
                  ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Float = f2;
                  ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Float = f1;
                  if (!((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Boolean) {
                    break;
                  }
                  ((ScanFeatureFilterView.FeaturePoint)localObject).a();
                  i2 = i1;
                }
                i1 += 1;
                this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)f2);
                localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
                i2 = i1;
              } while (localObject == null);
              i2 = i1;
            } while (((Bitmap)localObject).isRecycled());
            i2 = this.r;
            localObject = this.jdField_a_of_type_AndroidGraphicsRect;
            float f2 = i4 * i2;
            int i5 = (int)(f2 - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * f1 / 2.0F);
            float f3 = i2 * i3;
            ((Rect)localObject).set(i5, (int)(f3 - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * f1 / 2.0F), (int)(f2 + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * f1 / 2.0F), (int)(f3 + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * f1 / 2.0F));
            paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
            label713:
            i4 += 1;
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
              paramCanvas = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint;
              if (paramCanvas[i1][i2] == null) {
                paramCanvas[i1][i2] = new ScanFeatureFilterView.FeaturePoint();
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
            i4 = this.r;
            if ((i2 > i4) && (i3 > i4))
            {
              i2 /= i4;
              i3 /= i4;
              if ((i2 < this.q) && (i3 < this.p))
              {
                localObject = this.jdField_a_of_type_Array2dOfComTencentTarJniScanFeatureFilterView$FeaturePoint[i3][i2];
                i4 = b(4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Float = a(i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Float = a(i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long = (b(10) * 50);
                ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Long = (this.jdField_a_of_type_Long + ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Long);
                i4 = this.r;
                ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_a_of_type_Int = (i2 * i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Int = (i3 * i4);
                ((ScanFeatureFilterView.FeaturePoint)localObject).jdField_b_of_type_Boolean = true;
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
    if ((paramObject != null) && (!this.jdField_a_of_type_Boolean))
    {
      try
      {
        this.jdField_a_of_type_ComTencentTarJniARScanInfo = ((ARScanInfo)paramObject);
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      this.l = this.j;
      a(true);
      return;
    }
    this.l = this.i;
  }
  
  void a(boolean paramBoolean)
  {
    Handler localHandler;
    if (!paramBoolean)
    {
      localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.removeMessages(100);
      }
    }
    if (paramBoolean)
    {
      localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if ((localHandler != null) && (!localHandler.hasMessages(100))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
      }
    }
  }
  
  public void a(int[] paramArrayOfInt, ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_b_of_type_Int == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList(paramArrayList.size() / 2);
      int i1 = this.jdField_a_of_type_Int / paramInt2;
      i1 = this.jdField_b_of_type_Int / paramInt1;
      boolean bool = false;
      i1 = 0;
      while (i1 < paramArrayList.size() / 2)
      {
        int i2 = i1 * 2;
        float f1 = ((Integer)paramArrayList.get(i2)).intValue();
        float f2 = ((Integer)paramArrayList.get(i2 + 1)).intValue();
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
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {}
    try
    {
      c();
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
    this.jdField_a_of_type_Int = getMeasuredWidth();
    this.jdField_b_of_type_Int = getMeasuredHeight();
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.r;
    this.q = (paramInt1 / paramInt2);
    this.p = (this.jdField_b_of_type_Int / paramInt2);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("surfaceDestroyed error = ");
      localStringBuilder.append(paramSurfaceHolder.getMessage());
      QLog.e("ScanFeatureFilterView", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tar.jni.ScanFeatureFilterView
 * JD-Core Version:    0.7.0.1
 */