import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tdg
  extends ten
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean c;
  private boolean d;
  
  public tdg(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(false, true);
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 34	android/graphics/Bitmap:getWidth	()I
    //   16: istore 6
    //   18: aload_0
    //   19: invokevirtual 37	android/graphics/Bitmap:getHeight	()I
    //   22: istore 7
    //   24: iload 6
    //   26: iload 7
    //   28: if_icmple +108 -> 136
    //   31: iload 7
    //   33: istore_3
    //   34: iload 6
    //   36: iload 7
    //   38: if_icmple +104 -> 142
    //   41: iload 6
    //   43: iload 7
    //   45: isub
    //   46: iconst_2
    //   47: idiv
    //   48: istore 4
    //   50: iload 7
    //   52: iload 6
    //   54: if_icmple +94 -> 148
    //   57: iload 7
    //   59: iload 6
    //   61: isub
    //   62: iconst_2
    //   63: idiv
    //   64: istore 5
    //   66: aload_0
    //   67: iload 4
    //   69: iload 5
    //   71: iload_3
    //   72: iload_3
    //   73: aconst_null
    //   74: iconst_0
    //   75: invokestatic 41	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   78: astore 8
    //   80: aload 8
    //   82: astore_0
    //   83: iload 6
    //   85: iload 7
    //   87: imul
    //   88: sipush 8000
    //   91: if_icmple +63 -> 154
    //   94: ldc2_w 42
    //   97: iload_3
    //   98: iload_3
    //   99: imul
    //   100: i2d
    //   101: ddiv
    //   102: dstore_1
    //   103: dload_1
    //   104: invokestatic 49	java/lang/Math:sqrt	(D)D
    //   107: dstore_1
    //   108: iload_3
    //   109: i2d
    //   110: dload_1
    //   111: dmul
    //   112: d2i
    //   113: istore_3
    //   114: aload_0
    //   115: iload_3
    //   116: iload_3
    //   117: iconst_1
    //   118: invokestatic 53	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   121: astore 8
    //   123: aload_0
    //   124: invokevirtual 56	android/graphics/Bitmap:recycle	()V
    //   127: aconst_null
    //   128: astore_0
    //   129: aload 8
    //   131: ifnonnull +130 -> 261
    //   134: aload_0
    //   135: areturn
    //   136: iload 6
    //   138: istore_3
    //   139: goto -105 -> 34
    //   142: iconst_0
    //   143: istore 4
    //   145: goto -95 -> 50
    //   148: iconst_0
    //   149: istore 5
    //   151: goto -85 -> 66
    //   154: aload_0
    //   155: astore 8
    //   157: goto -28 -> 129
    //   160: astore 8
    //   162: invokestatic 61	java/lang/System:gc	()V
    //   165: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +15 -> 183
    //   171: ldc 69
    //   173: iconst_2
    //   174: aload 8
    //   176: iconst_0
    //   177: anewarray 71	java/lang/Object
    //   180: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   183: aload 9
    //   185: astore 8
    //   187: goto -58 -> 129
    //   190: astore 8
    //   192: aload 10
    //   194: astore 9
    //   196: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +15 -> 214
    //   202: ldc 69
    //   204: iconst_2
    //   205: aload 8
    //   207: iconst_0
    //   208: anewarray 71	java/lang/Object
    //   211: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   214: aload 9
    //   216: astore 8
    //   218: goto -89 -> 129
    //   221: astore 8
    //   223: aload 10
    //   225: astore 9
    //   227: goto -31 -> 196
    //   230: astore 10
    //   232: aload 8
    //   234: astore 9
    //   236: aload 10
    //   238: astore 8
    //   240: goto -44 -> 196
    //   243: astore 8
    //   245: goto -83 -> 162
    //   248: astore 10
    //   250: aload 8
    //   252: astore 9
    //   254: aload 10
    //   256: astore 8
    //   258: goto -96 -> 162
    //   261: aload 8
    //   263: astore_0
    //   264: goto -130 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramBitmap	Bitmap
    //   102	9	1	d1	double
    //   33	106	3	i	int
    //   48	96	4	j	int
    //   64	86	5	k	int
    //   16	121	6	m	int
    //   22	66	7	n	int
    //   78	78	8	localBitmap	Bitmap
    //   160	15	8	localOutOfMemoryError1	OutOfMemoryError
    //   185	1	8	localObject1	Object
    //   190	16	8	localException1	Exception
    //   216	1	8	localObject2	Object
    //   221	12	8	localException2	Exception
    //   238	1	8	localException3	Exception
    //   243	8	8	localOutOfMemoryError2	OutOfMemoryError
    //   256	6	8	localOutOfMemoryError3	OutOfMemoryError
    //   4	249	9	localObject3	Object
    //   1	223	10	localObject4	Object
    //   230	7	10	localException4	Exception
    //   248	7	10	localOutOfMemoryError4	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   12	24	160	java/lang/OutOfMemoryError
    //   41	50	160	java/lang/OutOfMemoryError
    //   57	66	160	java/lang/OutOfMemoryError
    //   66	80	160	java/lang/OutOfMemoryError
    //   12	24	190	java/lang/Exception
    //   41	50	190	java/lang/Exception
    //   57	66	190	java/lang/Exception
    //   66	80	190	java/lang/Exception
    //   103	108	221	java/lang/Exception
    //   114	123	221	java/lang/Exception
    //   123	127	230	java/lang/Exception
    //   103	108	243	java/lang/OutOfMemoryError
    //   114	123	243	java/lang/OutOfMemoryError
    //   123	127	248	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i <= 0) || (j <= 0));
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (localBitmap != null) {}
      try
      {
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(-1);
        paramDrawable.setBounds(0, 0, i, j);
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      catch (Exception paramDrawable)
      {
        urk.e("WeChatImageJob", "drawableToBitmapWhiteBg " + paramDrawable.getMessage());
        return null;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap1 = null;
    if (paramBitmap != null)
    {
      if (!paramBitmap.isMutable()) {
        break label202;
      }
      localBitmap1 = paramBitmap;
    }
    for (;;)
    {
      Canvas localCanvas = new Canvas(localBitmap1);
      Bitmap localBitmap2 = bacm.a(BaseApplicationImpl.sApplication.getResources(), 2130845716);
      float f1 = paramBitmap.getWidth() / 2.0F;
      float f2 = paramBitmap.getHeight() / 2.0F;
      Object localObject;
      int i;
      int j;
      if (localBitmap2.getWidth() <= f1)
      {
        localObject = localBitmap2;
        if (localBitmap2.getHeight() <= f2) {}
      }
      else
      {
        float f3 = localBitmap2.getWidth();
        float f4 = localBitmap2.getHeight();
        localObject = new Matrix();
        ((Matrix)localObject).postScale(f1 / f3, f2 / f4);
        i = (int)f3;
        j = (int)f4;
      }
      try
      {
        localObject = Bitmap.createBitmap(localBitmap2, 0, 0, i, j, (Matrix)localObject, true);
        localBitmap2.recycle();
        localCanvas.drawBitmap((Bitmap)localObject, paramBitmap.getWidth() / 2 - ((Bitmap)localObject).getWidth() / 2, paramBitmap.getHeight() / 2 - ((Bitmap)localObject).getHeight() / 2, new Paint());
        ((Bitmap)localObject).recycle();
        return localBitmap1;
        label202:
        localBitmap1 = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localObject = localBitmap2;
          if (QLog.isColorLevel())
          {
            QLog.e("WeChatImageJob", 2, localOutOfMemoryError, new Object[0]);
            localObject = localBitmap2;
          }
        }
      }
    }
  }
  
  public static Bitmap c(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
    } while ((i <= 0) || (j <= 0));
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (localBitmap != null)
      {
        Paint localPaint = new Paint();
        localPaint.setColor(-1);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawRect(0.0F, 0.0F, i, j, localPaint);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      }
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  public void a()
  {
    Object localObject3;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      localObject3 = c(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      Object localObject1 = localObject3;
      if (this.c) {
        localObject1 = azsq.a(bacm.c((Bitmap)localObject3, 70, 70));
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = azsq.a(bacm.a(0));
      }
      localObject3 = a((Bitmap)localObject3);
      localObject1 = localObject3;
      if (this.d) {}
      try
      {
        localObject1 = b((Bitmap)localObject3);
        a("WeChatImageJob_out_bitmap", localObject1);
        b(true);
        return;
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject3 = a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          continue;
        }
        b(false);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          urk.c("WeChatImageJob", "addPlayIconInBitmapForWeChat oom error" + localOutOfMemoryError.getMessage());
          Object localObject2 = localObject3;
        }
      }
    }
  }
  
  public void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (paramMap.containsKey("WeChatImageJob_in_bitmap")) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)a("WeChatImageJob_in_bitmap"));
      }
      if (paramMap.containsKey("WeChatImageJob_in_drawable")) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)a("WeChatImageJob_in_drawable"));
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdg
 * JD-Core Version:    0.7.0.1
 */