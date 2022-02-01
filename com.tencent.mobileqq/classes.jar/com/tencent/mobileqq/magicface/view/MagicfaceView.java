package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import awzg;
import awzj;

public class MagicfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, awzg
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private awzj jdField_a_of_type_Awzj;
  public volatile boolean a;
  private volatile boolean b;
  
  public MagicfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: iconst_0
    //   7: istore 8
    //   9: aload 10
    //   11: astore 9
    //   13: aload_0
    //   14: invokevirtual 40	com/tencent/mobileqq/magicface/view/MagicfaceView:getWidth	()I
    //   17: i2f
    //   18: fstore 5
    //   20: aload 10
    //   22: astore 9
    //   24: aload_0
    //   25: invokevirtual 43	com/tencent/mobileqq/magicface/view/MagicfaceView:getHeight	()I
    //   28: i2f
    //   29: fstore 6
    //   31: aload 10
    //   33: astore 9
    //   35: aload_0
    //   36: getfield 27	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   39: aconst_null
    //   40: invokeinterface 47 2 0
    //   45: astore 10
    //   47: new 49	android/graphics/Paint
    //   50: dup
    //   51: invokespecial 51	android/graphics/Paint:<init>	()V
    //   54: astore 9
    //   56: aload 9
    //   58: new 53	android/graphics/PorterDuffXfermode
    //   61: dup
    //   62: getstatic 59	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   65: invokespecial 62	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   68: invokevirtual 66	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   71: pop
    //   72: aload 10
    //   74: aload 9
    //   76: invokevirtual 72	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   79: aload 9
    //   81: new 53	android/graphics/PorterDuffXfermode
    //   84: dup
    //   85: getstatic 75	android/graphics/PorterDuff$Mode:SRC	Landroid/graphics/PorterDuff$Mode;
    //   88: invokespecial 62	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   91: invokevirtual 66	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   94: pop
    //   95: aload 9
    //   97: iconst_1
    //   98: invokevirtual 79	android/graphics/Paint:setFilterBitmap	(Z)V
    //   101: aload 9
    //   103: iconst_1
    //   104: invokevirtual 82	android/graphics/Paint:setAntiAlias	(Z)V
    //   107: fload 5
    //   109: fload 6
    //   111: fcmpg
    //   112: ifge +91 -> 203
    //   115: fload 5
    //   117: iload_2
    //   118: i2f
    //   119: fdiv
    //   120: fstore 5
    //   122: fload 6
    //   124: iload_3
    //   125: i2f
    //   126: fdiv
    //   127: fstore 4
    //   129: iconst_0
    //   130: istore 7
    //   132: aload_0
    //   133: getfield 84	com/tencent/mobileqq/magicface/view/MagicfaceView:b	Z
    //   136: ifne +106 -> 242
    //   139: fload 6
    //   141: f2i
    //   142: iconst_2
    //   143: idiv
    //   144: iload_3
    //   145: i2f
    //   146: fload 5
    //   148: fmul
    //   149: fconst_2
    //   150: fdiv
    //   151: f2i
    //   152: isub
    //   153: i2f
    //   154: fload 5
    //   156: fdiv
    //   157: f2i
    //   158: istore 8
    //   160: aload 10
    //   162: fload 5
    //   164: fload 5
    //   166: invokevirtual 88	android/graphics/Canvas:scale	(FF)V
    //   169: aload 10
    //   171: aload_1
    //   172: iconst_0
    //   173: iload_2
    //   174: iload 7
    //   176: iload 8
    //   178: iload_2
    //   179: iload_3
    //   180: iconst_1
    //   181: aload 9
    //   183: invokevirtual 92	android/graphics/Canvas:drawBitmap	([IIIIIIIZLandroid/graphics/Paint;)V
    //   186: aload 10
    //   188: ifnull +14 -> 202
    //   191: aload_0
    //   192: getfield 27	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   195: aload 10
    //   197: invokeinterface 96 2 0
    //   202: return
    //   203: fload 6
    //   205: iload_3
    //   206: i2f
    //   207: fdiv
    //   208: fstore 4
    //   210: fload 5
    //   212: f2i
    //   213: istore 7
    //   215: iload 7
    //   217: iconst_2
    //   218: idiv
    //   219: iload_2
    //   220: i2f
    //   221: fload 4
    //   223: fmul
    //   224: fconst_2
    //   225: fdiv
    //   226: f2i
    //   227: isub
    //   228: i2f
    //   229: fload 4
    //   231: fdiv
    //   232: f2i
    //   233: istore 7
    //   235: fload 4
    //   237: fstore 5
    //   239: goto -107 -> 132
    //   242: aload 10
    //   244: fload 5
    //   246: fload 4
    //   248: invokevirtual 88	android/graphics/Canvas:scale	(FF)V
    //   251: goto -82 -> 169
    //   254: astore 9
    //   256: aload 10
    //   258: astore_1
    //   259: aload 9
    //   261: astore 10
    //   263: aload_1
    //   264: astore 9
    //   266: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +35 -> 304
    //   272: aload_1
    //   273: astore 9
    //   275: ldc 104
    //   277: iconst_2
    //   278: new 106	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   285: ldc 109
    //   287: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 10
    //   292: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   295: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload_1
    //   305: ifnull -103 -> 202
    //   308: aload_0
    //   309: getfield 27	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   312: aload_1
    //   313: invokeinterface 96 2 0
    //   318: return
    //   319: astore_1
    //   320: aload 9
    //   322: ifnull +14 -> 336
    //   325: aload_0
    //   326: getfield 27	com/tencent/mobileqq/magicface/view/MagicfaceView:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   329: aload 9
    //   331: invokeinterface 96 2 0
    //   336: aload_1
    //   337: athrow
    //   338: astore_1
    //   339: aload 10
    //   341: astore 9
    //   343: goto -23 -> 320
    //   346: astore 10
    //   348: aload 11
    //   350: astore_1
    //   351: goto -88 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	MagicfaceView
    //   0	354	1	paramArrayOfInt	int[]
    //   0	354	2	paramInt1	int
    //   0	354	3	paramInt2	int
    //   127	120	4	f1	float
    //   18	227	5	f2	float
    //   29	175	6	f3	float
    //   130	104	7	i	int
    //   7	170	8	j	int
    //   11	171	9	localObject1	java.lang.Object
    //   254	6	9	localThrowable1	java.lang.Throwable
    //   264	78	9	localObject2	java.lang.Object
    //   1	339	10	localObject3	java.lang.Object
    //   346	1	10	localThrowable2	java.lang.Throwable
    //   4	345	11	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   47	107	254	java/lang/Throwable
    //   115	129	254	java/lang/Throwable
    //   132	169	254	java/lang/Throwable
    //   169	186	254	java/lang/Throwable
    //   215	235	254	java/lang/Throwable
    //   242	251	254	java/lang/Throwable
    //   13	20	319	finally
    //   24	31	319	finally
    //   35	47	319	finally
    //   266	272	319	finally
    //   275	304	319	finally
    //   47	107	338	finally
    //   115	129	338	finally
    //   132	169	338	finally
    //   169	186	338	finally
    //   215	235	338	finally
    //   242	251	338	finally
    //   13	20	346	java/lang/Throwable
    //   24	31	346	java/lang/Throwable
    //   35	47	346	java/lang/Throwable
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
  
  public void setSurfaceCreatelistener(awzj paramawzj)
  {
    this.jdField_a_of_type_Awzj = paramawzj;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Awzj != null) {
      this.jdField_a_of_type_Awzj.a();
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceView
 * JD-Core Version:    0.7.0.1
 */