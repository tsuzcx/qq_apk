package com.tencent.mobileqq.olympic.view;

import agor;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.qphone.base.util.QLog;

public class ScannerAnimView
  extends SurfaceView
  implements Handler.Callback, SurfaceHolder.Callback
{
  private float jdField_a_of_type_Float = 0.9F;
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private ScannerAnimView.OnScanAnimEndListener jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView$OnScanAnimEndListener;
  String jdField_a_of_type_JavaLangString = Build.MODEL.toLowerCase();
  public boolean a;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private Handler jdField_b_of_type_AndroidOsHandler;
  String jdField_b_of_type_JavaLangString = Build.MANUFACTURER.toLowerCase();
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 32;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  
  public ScannerAnimView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public ScannerAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public ScannerAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat < 0.5F)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Float = 0.0F;
    }
    for (this.jdField_c_of_type_Float = (paramFloat / 0.5F);; this.jdField_c_of_type_Float = 1.0F)
    {
      this.jdField_a_of_type_Float = (0.9F + 0.1F * paramFloat);
      return;
      this.jdField_a_of_type_Int = ((int)((paramFloat - 0.5F) / 0.5F * 255.0F));
      this.jdField_b_of_type_Float = ((paramFloat - 0.5F) / 0.5F);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (((this.jdField_c_of_type_Float <= this.jdField_b_of_type_Float) && (this.jdField_a_of_type_Int <= 0)) || (this.jdField_a_of_type_AndroidGraphicsRect == null)) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      i = (int)(this.jdField_a_of_type_AndroidGraphicsRect.width() * this.jdField_a_of_type_Float);
      j = (int)(this.jdField_a_of_type_AndroidGraphicsRect.height() * this.jdField_a_of_type_Float);
      k = (this.jdField_a_of_type_AndroidGraphicsRect.width() - i) / 2 + this.jdField_a_of_type_AndroidGraphicsRect.left;
      m = (this.jdField_a_of_type_AndroidGraphicsRect.width() - j) / 2 + this.jdField_a_of_type_AndroidGraphicsRect.top;
      int i1 = k + i;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845631);
      if (this.jdField_c_of_type_Float > this.jdField_b_of_type_Float)
      {
        int n = (int)(this.jdField_b_of_type_Int * this.jdField_a_of_type_Float);
        int i2 = (int)(this.jdField_b_of_type_Float * (i - n * 2)) + k + n;
        int i3 = m + this.jdField_c_of_type_Int;
        int i4 = (int)((this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) * (i - n * 2));
        paramCanvas.drawLine(i2, i3, i2 + i4, i3, this.jdField_a_of_type_AndroidGraphicsPaint);
        i2 = i1 - (int)(this.jdField_b_of_type_Float * (i - n * 2)) - n;
        i3 = m + j - this.jdField_c_of_type_Int;
        i4 = (int)((this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) * (i - n * 2));
        paramCanvas.drawLine(i2, i3, i2 - i4, i3, this.jdField_a_of_type_AndroidGraphicsPaint);
        i1 -= this.jdField_c_of_type_Int;
        i2 = (int)(this.jdField_b_of_type_Float * (j - n * 2)) + m + n;
        i3 = (int)((this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) * (j - n * 2));
        paramCanvas.drawLine(i1, i2, i1, i2 + i3, this.jdField_a_of_type_AndroidGraphicsPaint);
        i1 = this.jdField_c_of_type_Int + k;
        i2 = m + j - (int)(this.jdField_b_of_type_Float * (j - n * 2)) - n;
        n = (int)((this.jdField_c_of_type_Float - this.jdField_b_of_type_Float) * (j - n * 2));
        paramCanvas.drawLine(i1, i2, i1, i2 - n, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    } while (this.jdField_a_of_type_Int <= 0);
    if (this.jdField_a_of_type_Float >= 1.0F) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, m, k + i, m + j);
    }
  }
  
  private void b()
  {
    setZOrderOnTop(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.g = AIOUtils.a(1.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1291845631);
    this.jdField_b_of_type_Int = AIOUtils.a(14.5F, getResources());
    this.jdField_c_of_type_Int = AIOUtils.a(3.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842954);
    if (ScanEntranceDPC.a().jdField_a_of_type_Boolean) {
      this.jdField_d_of_type_Int = 24;
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private void b(float paramFloat)
  {
    if (paramFloat < 0.125F)
    {
      this.jdField_a_of_type_Int = ((int)((1.0F - paramFloat / 0.125F) * 255.0F));
      this.jdField_a_of_type_Float = (1.0F - paramFloat / 0.125F * 0.04F);
      return;
    }
    this.jdField_a_of_type_Float = 0.96F;
    if (paramFloat < 0.25F)
    {
      this.jdField_a_of_type_Int = ((int)((paramFloat - 0.125F) / 0.125F * 255.0F));
      return;
    }
    if (paramFloat < 0.375F)
    {
      this.jdField_a_of_type_Int = ((int)((1.0F - (paramFloat - 0.25F) / 0.125F) * 255.0F));
      return;
    }
    if (paramFloat < 0.5F)
    {
      this.jdField_a_of_type_Int = ((int)((paramFloat - 0.375F) / 0.125F * 255.0F));
      return;
    }
    this.jdField_a_of_type_Int = ((int)((1.0F - (paramFloat - 0.5F) / 0.5F) * 255.0F));
  }
  
  private boolean b()
  {
    return ("meizu".equals(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (("u20".equals(this.jdField_a_of_type_JavaLangString)) || ("mx6".equals(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.contains("m1")) || (this.jdField_a_of_type_JavaLangString.contains("m2")) || (this.jdField_a_of_type_JavaLangString.contains("m3")) || (this.jdField_a_of_type_JavaLangString.contains("m6")) || (this.jdField_a_of_type_JavaLangString.contains("m5")));
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.9F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = 255;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView$OnScanAnimEndListener != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(10, 1, 0);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Int = 255;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  private void f()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.96F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_c_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView$OnScanAnimEndListener != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(10, 0, 0);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 4
    //   10: astore_2
    //   11: aload 5
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 155	com/tencent/mobileqq/olympic/view/ScannerAnimView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   18: astore 6
    //   20: aload 4
    //   22: astore_2
    //   23: aload 5
    //   25: astore_1
    //   26: aload 6
    //   28: monitorenter
    //   29: aload_3
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 155	com/tencent/mobileqq/olympic/view/ScannerAnimView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   35: invokeinterface 260 1 0
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +32 -> 74
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: iconst_0
    //   49: getstatic 266	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   52: invokevirtual 270	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: aload_2
    //   59: invokespecial 272	com/tencent/mobileqq/olympic/view/ScannerAnimView:a	(Landroid/graphics/Canvas;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 70	com/tencent/mobileqq/olympic/view/ScannerAnimView:jdField_a_of_type_Long	J
    //   69: lconst_1
    //   70: ladd
    //   71: putfield 70	com/tencent/mobileqq/olympic/view/ScannerAnimView:jdField_a_of_type_Long	J
    //   74: aload_2
    //   75: astore_1
    //   76: aload 6
    //   78: monitorexit
    //   79: aload_2
    //   80: ifnull +13 -> 93
    //   83: aload_0
    //   84: getfield 155	com/tencent/mobileqq/olympic/view/ScannerAnimView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   87: aload_2
    //   88: invokeinterface 275 2 0
    //   93: return
    //   94: astore_3
    //   95: aload 6
    //   97: monitorexit
    //   98: aload_1
    //   99: astore_2
    //   100: aload_3
    //   101: athrow
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: ldc_w 277
    //   108: iconst_2
    //   109: new 279	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 282
    //   119: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 289	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: ifnull -43 -> 93
    //   139: aload_0
    //   140: getfield 155	com/tencent/mobileqq/olympic/view/ScannerAnimView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   143: aload_2
    //   144: invokeinterface 275 2 0
    //   149: return
    //   150: astore_1
    //   151: ldc_w 277
    //   154: iconst_2
    //   155: new 279	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 299
    //   165: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 300	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: return
    //   182: astore_1
    //   183: ldc_w 277
    //   186: iconst_2
    //   187: new 279	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 299
    //   197: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 300	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: return
    //   214: astore_2
    //   215: aload_1
    //   216: ifnull +13 -> 229
    //   219: aload_0
    //   220: getfield 155	com/tencent/mobileqq/olympic/view/ScannerAnimView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   223: aload_1
    //   224: invokeinterface 275 2 0
    //   229: aload_2
    //   230: athrow
    //   231: astore_1
    //   232: ldc_w 277
    //   235: iconst_2
    //   236: new 279	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 299
    //   246: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 300	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 292	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: goto -33 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	ScannerAnimView
    //   13	92	1	localObject1	java.lang.Object
    //   150	19	1	localThrowable1	java.lang.Throwable
    //   182	42	1	localThrowable2	java.lang.Throwable
    //   231	19	1	localThrowable3	java.lang.Throwable
    //   10	134	2	localObject2	java.lang.Object
    //   214	16	2	localObject3	java.lang.Object
    //   7	23	3	localObject4	java.lang.Object
    //   94	7	3	localObject5	java.lang.Object
    //   102	21	3	localException	Exception
    //   1	20	4	localObject6	java.lang.Object
    //   4	20	5	localObject7	java.lang.Object
    //   18	78	6	localSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   31	41	94	finally
    //   47	55	94	finally
    //   57	62	94	finally
    //   64	74	94	finally
    //   76	79	94	finally
    //   95	98	94	finally
    //   14	20	102	java/lang/Exception
    //   26	29	102	java/lang/Exception
    //   100	102	102	java/lang/Exception
    //   139	149	150	java/lang/Throwable
    //   83	93	182	java/lang/Throwable
    //   14	20	214	finally
    //   26	29	214	finally
    //   100	102	214	finally
    //   105	135	214	finally
    //   219	229	231	java/lang/Throwable
  }
  
  private void h()
  {
    int i = 1;
    long l = System.currentTimeMillis();
    int j = 0;
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      l -= this.jdField_b_of_type_Long;
      if ((l < 800L) && (l >= 0L)) {
        a((float)l * 1.0F / 800.0F);
      }
    }
    for (;;)
    {
      g();
      if ((i != 0) && (this.jdField_a_of_type_AndroidOsHandler != null) && (getVisibility() == 0) && ((this.jdField_b_of_type_Boolean) || ((!this.jdField_b_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Int);
      }
      return;
      if (l >= 800L) {
        d();
      }
      i = 0;
      continue;
      i = j;
      if (!this.jdField_b_of_type_Boolean)
      {
        i = j;
        if (!this.jdField_d_of_type_Boolean)
        {
          l -= this.jdField_c_of_type_Long;
          if ((l < 400L) && (l >= 0L))
          {
            b((float)l * 1.0F / 400.0F);
            float f1 = (float)l * 1.0F / 400.0F;
            i = 1;
          }
          else
          {
            i = j;
            if (l >= 400L)
            {
              f();
              i = j;
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    if (getVisibility() != 0)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(11);
      Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(11, 1, 0);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (!this.jdField_d_of_type_Boolean) {
        f();
      }
      if (!paramBoolean) {
        break label139;
      }
      d();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Int);
      }
      if (b()) {
        postInvalidateDelayed(400L);
      }
      return;
      label139:
      c();
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    label93:
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Long = -1L;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (!this.jdField_c_of_type_Boolean) {
          d();
        }
        if (!paramBoolean) {
          break label93;
        }
        f();
      }
      while (paramBoolean)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(11);
        Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(11, 0, 0);
        this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
        e();
      }
    } while ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_d_of_type_Int);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      h();
      return false;
      if (paramMessage.arg1 == 1) {}
      for (int i = 0;; i = 4)
      {
        setVisibility(i);
        return false;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView$OnScanAnimEndListener == null);
    ScannerAnimView.OnScanAnimEndListener localOnScanAnimEndListener = this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView$OnScanAnimEndListener;
    if (paramMessage.arg1 == 1) {}
    for (;;)
    {
      localOnScanAnimEndListener.a(bool);
      return false;
      bool = false;
    }
  }
  
  public void setBoxRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void setOnScanAnimEndListener(ScannerAnimView.OnScanAnimEndListener paramOnScanAnimEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScannerAnimView$OnScanAnimEndListener = paramOnScanAnimEndListener;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt2;
    this.f = paramInt3;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ScannerAnimView_ANIM_THREAD");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    if (this.jdField_b_of_type_Boolean)
    {
      if ((!this.jdField_a_of_type_Boolean) && (b())) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new agor(this), 400L);
      }
    }
    else {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      QLog.e("ScannerAnimView", 2, "surfaceDestroyed error = " + paramSurfaceHolder.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScannerAnimView
 * JD-Core Version:    0.7.0.1
 */