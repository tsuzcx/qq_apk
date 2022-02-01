package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;

public class ShakeImageView
  extends ImageView
  implements SensorEventListener
{
  float[] a = { 0.0F, 0.0F, 0.0F };
  private SensorManager b;
  private Sensor c;
  private Bitmap d;
  private int e;
  private int f;
  private float g;
  private float h;
  private Paint i;
  private float j = 1.0F;
  
  public ShakeImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ShakeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ShakeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat2 + (paramFloat1 - paramFloat2) * 0.3F);
  }
  
  private void a()
  {
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.b = ((SensorManager)getContext().getSystemService("sensor"));
  }
  
  private float[] a(SensorEvent paramSensorEvent)
  {
    this.a[0] = a(paramSensorEvent.values[0] * 50.0F, this.a[0]);
    this.a[1] = a(paramSensorEvent.values[1] * 50.0F, this.a[1]);
    this.a[2] = a(paramSensorEvent.values[2] * 50.0F, this.a[2]);
    return this.a;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.b == null) {
      SLog.e("ShakeImageView", "onAttachedToWindow but mSensorManager is null.");
    }
    if ((getVisibility() != 8) && (this.c != null))
    {
      SensorManager localSensorManager = this.b;
      if (localSensorManager != null)
      {
        this.c = localSensorManager.getDefaultSensor(9);
        this.b.registerListener(this, this.c, 1);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.b == null) {
      SLog.e("ShakeImageView", "onDetachedFromWindow but mSensorManager is null.");
    }
    if (this.c != null)
    {
      SensorManager localSensorManager = this.b;
      if (localSensorManager != null) {
        localSensorManager.unregisterListener(this);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    int k = this.e;
    if ((k > 0) && (this.f > 0) && (this.d != null))
    {
      int m = (k - getMeasuredWidth()) / 2;
      k = (this.f - getMeasuredHeight()) / 2;
      int n = -m;
      float f1 = n - this.g * m / 400.0F * this.j;
      float f2 = n * 2;
      if (f1 < f2) {
        f1 = f2;
      }
      f2 = f1;
      if (f1 > 0.0F) {
        f2 = 0.0F;
      }
      m = -k;
      f1 = m - this.h * k / 400.0F * this.j;
      float f3 = m * 2;
      if (f1 < f3) {
        f1 = f3;
      }
      f3 = f1;
      if (f1 > 0.0F) {
        f3 = 0.0F;
      }
      paramCanvas.drawBitmap(this.d, f2, f3, this.i);
    }
    System.currentTimeMillis();
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    paramSensorEvent = a(paramSensorEvent);
    this.g = paramSensorEvent[0];
    this.h = paramSensorEvent[1];
    invalidate();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((getVisibility() != 8) && (this.c == null))
    {
      this.c = this.b.getDefaultSensor(9);
      this.b.registerListener(this, this.c, 1);
    }
  }
  
  public void setImage(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    if (paramFloat >= 0.0F) {
      this.j = 1.0F;
    } else {
      this.j = -1.0F;
    }
    if ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      this.d = paramBitmap;
      return;
    }
    paramFloat = paramInt1 / paramBitmap.getWidth();
    float f1 = paramInt2 / paramBitmap.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(paramFloat, f1);
    try
    {
      this.d = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setImage OutOfMemory: ");
      localStringBuilder.append(localOutOfMemoryError.getMessage());
      QLog.e("ShakeImageView", 1, localStringBuilder.toString());
      System.gc();
      try
      {
        this.d = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, false);
        return;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setImage OutOfMemory again: ");
        ((StringBuilder)localObject).append(paramBitmap.getMessage());
        QLog.e("ShakeImageView", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  /* Error */
  public void setImage(java.lang.String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_2
    //   2: putfield 125	com/tencent/mobileqq/profile/view/ShakeImageView:e	I
    //   5: aload_0
    //   6: iload_3
    //   7: putfield 127	com/tencent/mobileqq/profile/view/ShakeImageView:f	I
    //   10: fload 4
    //   12: fconst_0
    //   13: fcmpl
    //   14: iflt +11 -> 25
    //   17: aload_0
    //   18: fconst_1
    //   19: putfield 29	com/tencent/mobileqq/profile/view/ShakeImageView:j	F
    //   22: goto +9 -> 31
    //   25: aload_0
    //   26: ldc 162
    //   28: putfield 29	com/tencent/mobileqq/profile/view/ShakeImageView:j	F
    //   31: aconst_null
    //   32: astore 7
    //   34: aconst_null
    //   35: astore 6
    //   37: new 214	java/io/BufferedInputStream
    //   40: dup
    //   41: new 216	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 219	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 222	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_1
    //   53: aload_1
    //   54: astore 6
    //   56: aload_1
    //   57: invokestatic 228	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   60: astore 7
    //   62: aload_1
    //   63: astore 6
    //   65: aload 7
    //   67: invokevirtual 167	android/graphics/Bitmap:getWidth	()I
    //   70: iload_2
    //   71: if_icmpne +27 -> 98
    //   74: aload_1
    //   75: astore 6
    //   77: aload 7
    //   79: invokevirtual 170	android/graphics/Bitmap:getHeight	()I
    //   82: iload_3
    //   83: if_icmpne +15 -> 98
    //   86: aload_1
    //   87: astore 6
    //   89: aload_0
    //   90: aload 7
    //   92: putfield 129	com/tencent/mobileqq/profile/view/ShakeImageView:d	Landroid/graphics/Bitmap;
    //   95: goto +91 -> 186
    //   98: aload_1
    //   99: astore 6
    //   101: iload_2
    //   102: i2f
    //   103: aload 7
    //   105: invokevirtual 167	android/graphics/Bitmap:getWidth	()I
    //   108: i2f
    //   109: fdiv
    //   110: fstore 4
    //   112: aload_1
    //   113: astore 6
    //   115: iload_3
    //   116: i2f
    //   117: aload 7
    //   119: invokevirtual 170	android/graphics/Bitmap:getHeight	()I
    //   122: i2f
    //   123: fdiv
    //   124: fstore 5
    //   126: aload_1
    //   127: astore 6
    //   129: new 172	android/graphics/Matrix
    //   132: dup
    //   133: invokespecial 173	android/graphics/Matrix:<init>	()V
    //   136: astore 8
    //   138: aload_1
    //   139: astore 6
    //   141: aload 8
    //   143: fload 4
    //   145: fload 5
    //   147: invokevirtual 177	android/graphics/Matrix:postScale	(FF)Z
    //   150: pop
    //   151: aload_1
    //   152: astore 6
    //   154: aload_0
    //   155: aload 7
    //   157: iconst_0
    //   158: iconst_0
    //   159: aload 7
    //   161: invokevirtual 167	android/graphics/Bitmap:getWidth	()I
    //   164: aload 7
    //   166: invokevirtual 170	android/graphics/Bitmap:getHeight	()I
    //   169: aload 8
    //   171: iconst_0
    //   172: invokestatic 181	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   175: putfield 129	com/tencent/mobileqq/profile/view/ShakeImageView:d	Landroid/graphics/Bitmap;
    //   178: aload_1
    //   179: astore 6
    //   181: aload 7
    //   183: invokevirtual 231	android/graphics/Bitmap:recycle	()V
    //   186: aload_1
    //   187: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   190: return
    //   191: astore 7
    //   193: goto +21 -> 214
    //   196: astore 7
    //   198: goto +53 -> 251
    //   201: astore_1
    //   202: goto +80 -> 282
    //   205: astore 6
    //   207: aload 7
    //   209: astore_1
    //   210: aload 6
    //   212: astore 7
    //   214: aload_1
    //   215: astore 6
    //   217: ldc 85
    //   219: iconst_1
    //   220: ldc 236
    //   222: aload 7
    //   224: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload_1
    //   228: ifnull +52 -> 280
    //   231: aload_1
    //   232: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   235: return
    //   236: astore_1
    //   237: ldc 85
    //   239: iconst_1
    //   240: ldc 236
    //   242: aload_1
    //   243: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   246: return
    //   247: astore 7
    //   249: aconst_null
    //   250: astore_1
    //   251: aload_1
    //   252: astore 6
    //   254: aload_0
    //   255: aconst_null
    //   256: putfield 129	com/tencent/mobileqq/profile/view/ShakeImageView:d	Landroid/graphics/Bitmap;
    //   259: aload_1
    //   260: astore 6
    //   262: ldc 85
    //   264: iconst_1
    //   265: ldc 236
    //   267: aload 7
    //   269: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload_1
    //   273: ifnull +7 -> 280
    //   276: aload_1
    //   277: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   280: return
    //   281: astore_1
    //   282: aload 6
    //   284: ifnull +23 -> 307
    //   287: aload 6
    //   289: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   292: goto +15 -> 307
    //   295: astore 6
    //   297: ldc 85
    //   299: iconst_1
    //   300: ldc 236
    //   302: aload 6
    //   304: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload_1
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	ShakeImageView
    //   0	309	1	paramString	java.lang.String
    //   0	309	2	paramInt1	int
    //   0	309	3	paramInt2	int
    //   0	309	4	paramFloat	float
    //   124	22	5	f1	float
    //   35	145	6	str1	java.lang.String
    //   205	6	6	localOutOfMemoryError1	OutOfMemoryError
    //   215	73	6	str2	java.lang.String
    //   295	8	6	localIOException	java.io.IOException
    //   32	150	7	localBitmap	Bitmap
    //   191	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   196	12	7	localException1	java.lang.Exception
    //   212	11	7	localObject	Object
    //   247	21	7	localException2	java.lang.Exception
    //   136	34	8	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   56	62	191	java/lang/OutOfMemoryError
    //   65	74	191	java/lang/OutOfMemoryError
    //   77	86	191	java/lang/OutOfMemoryError
    //   89	95	191	java/lang/OutOfMemoryError
    //   101	112	191	java/lang/OutOfMemoryError
    //   115	126	191	java/lang/OutOfMemoryError
    //   129	138	191	java/lang/OutOfMemoryError
    //   141	151	191	java/lang/OutOfMemoryError
    //   154	178	191	java/lang/OutOfMemoryError
    //   181	186	191	java/lang/OutOfMemoryError
    //   56	62	196	java/lang/Exception
    //   65	74	196	java/lang/Exception
    //   77	86	196	java/lang/Exception
    //   89	95	196	java/lang/Exception
    //   101	112	196	java/lang/Exception
    //   115	126	196	java/lang/Exception
    //   129	138	196	java/lang/Exception
    //   141	151	196	java/lang/Exception
    //   154	178	196	java/lang/Exception
    //   181	186	196	java/lang/Exception
    //   37	53	201	finally
    //   217	227	201	finally
    //   37	53	205	java/lang/OutOfMemoryError
    //   186	190	236	java/io/IOException
    //   231	235	236	java/io/IOException
    //   276	280	236	java/io/IOException
    //   37	53	247	java/lang/Exception
    //   56	62	281	finally
    //   65	74	281	finally
    //   77	86	281	finally
    //   89	95	281	finally
    //   101	112	281	finally
    //   115	126	281	finally
    //   129	138	281	finally
    //   141	151	281	finally
    //   154	178	281	finally
    //   181	186	281	finally
    //   254	259	281	finally
    //   262	272	281	finally
    //   287	292	295	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ShakeImageView
 * JD-Core Version:    0.7.0.1
 */