package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MagicfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, IMagicFaceView
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private MagicfaceView.SurfaceCreateListener jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener;
  public volatile boolean a;
  private volatile boolean b = false;
  
  public MagicfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
  }
  
  /* Error */
  private void b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: aload 10
    //   8: astore 9
    //   10: aload_0
    //   11: invokevirtual 44	com/tencent/mobileqq/magicface/view/MagicfaceView:getWidth	()I
    //   14: i2f
    //   15: fstore 5
    //   17: aload 10
    //   19: astore 9
    //   21: aload_0
    //   22: invokevirtual 47	com/tencent/mobileqq/magicface/view/MagicfaceView:getHeight	()I
    //   25: i2f
    //   26: fstore 6
    //   28: aload 10
    //   30: astore 9
    //   32: aload_0
    //   33: getfield 31	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   36: aconst_null
    //   37: invokeinterface 51 2 0
    //   42: astore 10
    //   44: new 53	android/graphics/Paint
    //   47: dup
    //   48: invokespecial 55	android/graphics/Paint:<init>	()V
    //   51: astore 9
    //   53: aload 9
    //   55: new 57	android/graphics/PorterDuffXfermode
    //   58: dup
    //   59: getstatic 63	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   62: invokespecial 66	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   65: invokevirtual 70	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   68: pop
    //   69: aload 10
    //   71: aload 9
    //   73: invokevirtual 76	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   76: aload 9
    //   78: new 57	android/graphics/PorterDuffXfermode
    //   81: dup
    //   82: getstatic 79	android/graphics/PorterDuff$Mode:SRC	Landroid/graphics/PorterDuff$Mode;
    //   85: invokespecial 66	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   88: invokevirtual 70	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   91: pop
    //   92: aload 9
    //   94: iconst_1
    //   95: invokevirtual 83	android/graphics/Paint:setFilterBitmap	(Z)V
    //   98: aload 9
    //   100: iconst_1
    //   101: invokevirtual 86	android/graphics/Paint:setAntiAlias	(Z)V
    //   104: fload 5
    //   106: fload 6
    //   108: fcmpg
    //   109: ifge +23 -> 132
    //   112: fload 5
    //   114: iload_2
    //   115: i2f
    //   116: fdiv
    //   117: fstore 5
    //   119: fload 6
    //   121: iload_3
    //   122: i2f
    //   123: fdiv
    //   124: fstore 4
    //   126: iconst_0
    //   127: istore 7
    //   129: goto +35 -> 164
    //   132: fload 6
    //   134: iload_3
    //   135: i2f
    //   136: fdiv
    //   137: fstore 4
    //   139: fload 5
    //   141: f2i
    //   142: iconst_2
    //   143: idiv
    //   144: iload_2
    //   145: i2f
    //   146: fload 4
    //   148: fmul
    //   149: fconst_2
    //   150: fdiv
    //   151: f2i
    //   152: isub
    //   153: i2f
    //   154: fload 4
    //   156: fdiv
    //   157: f2i
    //   158: istore 7
    //   160: fload 4
    //   162: fstore 5
    //   164: aload_0
    //   165: getfield 19	com/tencent/mobileqq/magicface/view/MagicfaceView:b	Z
    //   168: ifne +36 -> 204
    //   171: fload 6
    //   173: f2i
    //   174: iconst_2
    //   175: idiv
    //   176: iload_3
    //   177: i2f
    //   178: fload 5
    //   180: fmul
    //   181: fconst_2
    //   182: fdiv
    //   183: f2i
    //   184: isub
    //   185: i2f
    //   186: fload 5
    //   188: fdiv
    //   189: f2i
    //   190: istore 8
    //   192: aload 10
    //   194: fload 5
    //   196: fload 5
    //   198: invokevirtual 90	android/graphics/Canvas:scale	(FF)V
    //   201: goto +15 -> 216
    //   204: aload 10
    //   206: fload 5
    //   208: fload 4
    //   210: invokevirtual 90	android/graphics/Canvas:scale	(FF)V
    //   213: iconst_0
    //   214: istore 8
    //   216: aload 10
    //   218: aload_1
    //   219: iconst_0
    //   220: iload_2
    //   221: iload 7
    //   223: iload 8
    //   225: iload_2
    //   226: iload_3
    //   227: iconst_1
    //   228: aload 9
    //   230: invokevirtual 94	android/graphics/Canvas:drawBitmap	([IIIIIIIZLandroid/graphics/Paint;)V
    //   233: aload 10
    //   235: ifnull +118 -> 353
    //   238: aload_0
    //   239: getfield 31	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   242: aload 10
    //   244: invokeinterface 98 2 0
    //   249: return
    //   250: astore_1
    //   251: aload 10
    //   253: astore 9
    //   255: goto +99 -> 354
    //   258: astore 9
    //   260: aload 10
    //   262: astore_1
    //   263: aload 9
    //   265: astore 10
    //   267: goto +12 -> 279
    //   270: astore_1
    //   271: goto +83 -> 354
    //   274: astore 10
    //   276: aload 11
    //   278: astore_1
    //   279: aload_1
    //   280: astore 9
    //   282: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +54 -> 339
    //   288: aload_1
    //   289: astore 9
    //   291: new 106	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   298: astore 11
    //   300: aload_1
    //   301: astore 9
    //   303: aload 11
    //   305: ldc 109
    //   307: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_1
    //   312: astore 9
    //   314: aload 11
    //   316: aload 10
    //   318: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   321: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_1
    //   326: astore 9
    //   328: ldc 119
    //   330: iconst_2
    //   331: aload 11
    //   333: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload_1
    //   340: ifnull +13 -> 353
    //   343: aload_0
    //   344: getfield 31	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   347: aload_1
    //   348: invokeinterface 98 2 0
    //   353: return
    //   354: aload 9
    //   356: ifnull +14 -> 370
    //   359: aload_0
    //   360: getfield 31	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   363: aload 9
    //   365: invokeinterface 98 2 0
    //   370: aload_1
    //   371: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	MagicfaceView
    //   0	372	1	paramArrayOfInt	int[]
    //   0	372	2	paramInt1	int
    //   0	372	3	paramInt2	int
    //   124	85	4	f1	float
    //   15	192	5	f2	float
    //   26	146	6	f3	float
    //   127	95	7	i	int
    //   190	34	8	j	int
    //   8	246	9	localObject1	java.lang.Object
    //   258	6	9	localThrowable1	java.lang.Throwable
    //   280	84	9	arrayOfInt	int[]
    //   4	262	10	localObject2	java.lang.Object
    //   274	43	10	localThrowable2	java.lang.Throwable
    //   1	331	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	104	250	finally
    //   112	126	250	finally
    //   132	160	250	finally
    //   164	201	250	finally
    //   204	213	250	finally
    //   216	233	250	finally
    //   44	104	258	java/lang/Throwable
    //   112	126	258	java/lang/Throwable
    //   132	160	258	java/lang/Throwable
    //   164	201	258	java/lang/Throwable
    //   204	213	258	java/lang/Throwable
    //   216	233	258	java/lang/Throwable
    //   10	17	270	finally
    //   21	28	270	finally
    //   32	44	270	finally
    //   282	288	270	finally
    //   291	300	270	finally
    //   303	311	270	finally
    //   314	325	270	finally
    //   328	339	270	finally
    //   10	17	274	java/lang/Throwable
    //   21	28	274	java/lang/Throwable
    //   32	44	274	java/lang/Throwable
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    b(paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setSurfaceCreatelistener(MagicfaceView.SurfaceCreateListener paramSurfaceCreateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener = paramSurfaceCreateListener;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = true;
    paramSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.a();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceView
 * JD-Core Version:    0.7.0.1
 */