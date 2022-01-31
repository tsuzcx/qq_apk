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
import com.tencent.qphone.base.util.QLog;
import veg;

public class ShakeImageView
  extends ImageView
  implements SensorEventListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.0F };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c = 1.0F;
  
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
    return (int)(0.3F * (paramFloat1 - paramFloat2) + paramFloat2);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getContext().getSystemService("sensor"));
  }
  
  private float[] a(SensorEvent paramSensorEvent)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = a(paramSensorEvent.values[0] * 50.0F, this.jdField_a_of_type_ArrayOfFloat[0]);
    this.jdField_a_of_type_ArrayOfFloat[1] = a(paramSensorEvent.values[1] * 50.0F, this.jdField_a_of_type_ArrayOfFloat[1]);
    this.jdField_a_of_type_ArrayOfFloat[2] = a(paramSensorEvent.values[2] * 50.0F, this.jdField_a_of_type_ArrayOfFloat[2]);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      veg.e("ShakeImageView", "onAttachedToWindow but mSensorManager is null.");
    }
    if ((getVisibility() != 8) && (this.jdField_a_of_type_AndroidHardwareSensor != null) && (this.jdField_a_of_type_AndroidHardwareSensorManager != null))
    {
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(9);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 1);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {
      veg.e("ShakeImageView", "onDetachedFromWindow but mSensorManager is null.");
    }
    if ((this.jdField_a_of_type_AndroidHardwareSensor != null) && (this.jdField_a_of_type_AndroidHardwareSensorManager != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f3 = 0.0F;
    System.currentTimeMillis();
    float f2;
    float f1;
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      int i = (this.jdField_a_of_type_Int - getMeasuredWidth()) / 2;
      int j = (this.jdField_b_of_type_Int - getMeasuredHeight()) / 2;
      f2 = -i - this.jdField_a_of_type_Float * i / 400.0F * this.c;
      f1 = f2;
      if (f2 < -i * 2) {
        f1 = -i * 2;
      }
      f2 = f1;
      if (f1 > 0.0F) {
        f2 = 0.0F;
      }
      float f4 = -j - this.jdField_b_of_type_Float * j / 400.0F * this.c;
      f1 = f4;
      if (f4 < -j * 2) {
        f1 = -j * 2;
      }
      if (f1 <= 0.0F) {
        break label179;
      }
      f1 = f3;
    }
    label179:
    for (;;)
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, f2, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      System.currentTimeMillis();
      return;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    paramSensorEvent = a(paramSensorEvent);
    this.jdField_a_of_type_Float = paramSensorEvent[0];
    this.jdField_b_of_type_Float = paramSensorEvent[1];
    invalidate();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((getVisibility() != 8) && (this.jdField_a_of_type_AndroidHardwareSensor == null))
    {
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(9);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 1);
    }
  }
  
  public void setImage(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramFloat >= 0.0F) {}
    for (this.c = 1.0F; (paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2); this.c = -1.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      return;
    }
    paramFloat = paramInt1 / paramBitmap.getWidth();
    float f = paramInt2 / paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramFloat, f);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ShakeImageView", 1, "setImage OutOfMemory: " + localOutOfMemoryError.getMessage());
      System.gc();
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, false);
        return;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        QLog.e("ShakeImageView", 1, "setImage OutOfMemory again: " + paramBitmap.getMessage());
      }
    }
  }
  
  /* Error */
  public void setImage(java.lang.String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: iload_2
    //   5: putfield 119	com/tencent/mobileqq/profile/view/ShakeImageView:jdField_a_of_type_Int	I
    //   8: aload_0
    //   9: iload_3
    //   10: putfield 121	com/tencent/mobileqq/profile/view/ShakeImageView:jdField_b_of_type_Int	I
    //   13: fload 4
    //   15: fconst_0
    //   16: fcmpl
    //   17: iflt +75 -> 92
    //   20: aload_0
    //   21: fconst_1
    //   22: putfield 22	com/tencent/mobileqq/profile/view/ShakeImageView:c	F
    //   25: new 208	java/io/BufferedInputStream
    //   28: dup
    //   29: new 210	java/io/FileInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 213	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 216	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_1
    //   42: astore 6
    //   44: aload_1
    //   45: invokestatic 222	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   48: astore 7
    //   50: aload_1
    //   51: astore 6
    //   53: aload 7
    //   55: invokevirtual 160	android/graphics/Bitmap:getWidth	()I
    //   58: iload_2
    //   59: if_icmpne +42 -> 101
    //   62: aload_1
    //   63: astore 6
    //   65: aload 7
    //   67: invokevirtual 163	android/graphics/Bitmap:getHeight	()I
    //   70: iload_3
    //   71: if_icmpne +30 -> 101
    //   74: aload_1
    //   75: astore 6
    //   77: aload_0
    //   78: aload 7
    //   80: putfield 123	com/tencent/mobileqq/profile/view/ShakeImageView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 225	java/io/BufferedInputStream:close	()V
    //   91: return
    //   92: aload_0
    //   93: ldc 164
    //   95: putfield 22	com/tencent/mobileqq/profile/view/ShakeImageView:c	F
    //   98: goto -73 -> 25
    //   101: iload_2
    //   102: i2f
    //   103: fstore 4
    //   105: aload_1
    //   106: astore 6
    //   108: fload 4
    //   110: aload 7
    //   112: invokevirtual 160	android/graphics/Bitmap:getWidth	()I
    //   115: i2f
    //   116: fdiv
    //   117: fstore 4
    //   119: aload_1
    //   120: astore 6
    //   122: iload_3
    //   123: i2f
    //   124: aload 7
    //   126: invokevirtual 163	android/graphics/Bitmap:getHeight	()I
    //   129: i2f
    //   130: fdiv
    //   131: fstore 5
    //   133: aload_1
    //   134: astore 6
    //   136: new 166	android/graphics/Matrix
    //   139: dup
    //   140: invokespecial 167	android/graphics/Matrix:<init>	()V
    //   143: astore 8
    //   145: aload_1
    //   146: astore 6
    //   148: aload 8
    //   150: fload 4
    //   152: fload 5
    //   154: invokevirtual 171	android/graphics/Matrix:postScale	(FF)Z
    //   157: pop
    //   158: aload_1
    //   159: astore 6
    //   161: aload_0
    //   162: aload 7
    //   164: iconst_0
    //   165: iconst_0
    //   166: aload 7
    //   168: invokevirtual 160	android/graphics/Bitmap:getWidth	()I
    //   171: aload 7
    //   173: invokevirtual 163	android/graphics/Bitmap:getHeight	()I
    //   176: aload 8
    //   178: iconst_0
    //   179: invokestatic 175	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   182: putfield 123	com/tencent/mobileqq/profile/view/ShakeImageView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   185: aload_1
    //   186: astore 6
    //   188: aload 7
    //   190: invokevirtual 228	android/graphics/Bitmap:recycle	()V
    //   193: goto -110 -> 83
    //   196: astore 6
    //   198: aload_0
    //   199: aconst_null
    //   200: putfield 123	com/tencent/mobileqq/profile/view/ShakeImageView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   203: ldc 78
    //   205: iconst_1
    //   206: ldc 230
    //   208: aload 6
    //   210: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: ifnull -123 -> 91
    //   217: aload_1
    //   218: invokevirtual 225	java/io/BufferedInputStream:close	()V
    //   221: return
    //   222: astore_1
    //   223: ldc 78
    //   225: iconst_1
    //   226: ldc 230
    //   228: aload_1
    //   229: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   232: return
    //   233: astore_1
    //   234: ldc 78
    //   236: iconst_1
    //   237: ldc 230
    //   239: aload_1
    //   240: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   243: return
    //   244: astore 7
    //   246: aconst_null
    //   247: astore_1
    //   248: aload_1
    //   249: astore 6
    //   251: ldc 78
    //   253: iconst_1
    //   254: ldc 230
    //   256: aload 7
    //   258: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: aload_1
    //   262: ifnull -171 -> 91
    //   265: aload_1
    //   266: invokevirtual 225	java/io/BufferedInputStream:close	()V
    //   269: return
    //   270: astore_1
    //   271: ldc 78
    //   273: iconst_1
    //   274: ldc 230
    //   276: aload_1
    //   277: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: return
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 6
    //   285: aload 6
    //   287: ifnull +8 -> 295
    //   290: aload 6
    //   292: invokevirtual 225	java/io/BufferedInputStream:close	()V
    //   295: aload_1
    //   296: athrow
    //   297: astore 6
    //   299: ldc 78
    //   301: iconst_1
    //   302: ldc 230
    //   304: aload 6
    //   306: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: goto -14 -> 295
    //   312: astore_1
    //   313: goto -28 -> 285
    //   316: astore 7
    //   318: aload_1
    //   319: astore 6
    //   321: aload 7
    //   323: astore_1
    //   324: goto -39 -> 285
    //   327: astore 7
    //   329: goto -81 -> 248
    //   332: astore 6
    //   334: aload 7
    //   336: astore_1
    //   337: goto -139 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	this	ShakeImageView
    //   0	340	1	paramString	java.lang.String
    //   0	340	2	paramInt1	int
    //   0	340	3	paramInt2	int
    //   0	340	4	paramFloat	float
    //   131	22	5	f	float
    //   42	145	6	str1	java.lang.String
    //   196	13	6	localException1	java.lang.Exception
    //   249	42	6	str2	java.lang.String
    //   297	8	6	localIOException	java.io.IOException
    //   319	1	6	str3	java.lang.String
    //   332	1	6	localException2	java.lang.Exception
    //   1	188	7	localBitmap	Bitmap
    //   244	13	7	localOutOfMemoryError1	OutOfMemoryError
    //   316	6	7	localObject	java.lang.Object
    //   327	8	7	localOutOfMemoryError2	OutOfMemoryError
    //   143	34	8	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   44	50	196	java/lang/Exception
    //   53	62	196	java/lang/Exception
    //   65	74	196	java/lang/Exception
    //   77	83	196	java/lang/Exception
    //   108	119	196	java/lang/Exception
    //   122	133	196	java/lang/Exception
    //   136	145	196	java/lang/Exception
    //   148	158	196	java/lang/Exception
    //   161	185	196	java/lang/Exception
    //   188	193	196	java/lang/Exception
    //   217	221	222	java/io/IOException
    //   87	91	233	java/io/IOException
    //   25	41	244	java/lang/OutOfMemoryError
    //   265	269	270	java/io/IOException
    //   25	41	281	finally
    //   290	295	297	java/io/IOException
    //   44	50	312	finally
    //   53	62	312	finally
    //   65	74	312	finally
    //   77	83	312	finally
    //   108	119	312	finally
    //   122	133	312	finally
    //   136	145	312	finally
    //   148	158	312	finally
    //   161	185	312	finally
    //   188	193	312	finally
    //   251	261	312	finally
    //   198	213	316	finally
    //   44	50	327	java/lang/OutOfMemoryError
    //   53	62	327	java/lang/OutOfMemoryError
    //   65	74	327	java/lang/OutOfMemoryError
    //   77	83	327	java/lang/OutOfMemoryError
    //   108	119	327	java/lang/OutOfMemoryError
    //   122	133	327	java/lang/OutOfMemoryError
    //   136	145	327	java/lang/OutOfMemoryError
    //   148	158	327	java/lang/OutOfMemoryError
    //   161	185	327	java/lang/OutOfMemoryError
    //   188	193	327	java/lang/OutOfMemoryError
    //   25	41	332	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ShakeImageView
 * JD-Core Version:    0.7.0.1
 */