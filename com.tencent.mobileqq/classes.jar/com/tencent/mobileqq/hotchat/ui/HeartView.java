package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class HeartView
  extends ImageView
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private static Paint jdField_a_of_type_AndroidGraphicsPaint;
  private static Bitmap b;
  protected final int a;
  private boolean jdField_a_of_type_Boolean = true;
  protected final int b;
  
  public HeartView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130845204;
    this.jdField_b_of_type_Int = 2130845203;
  }
  
  public HeartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130845204;
    this.jdField_b_of_type_Int = 2130845203;
  }
  
  public HeartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2130845204;
    this.jdField_b_of_type_Int = 2130845203;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 52	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   3: ifnonnull +15 -> 18
    //   6: aload_0
    //   7: invokevirtual 56	com/tencent/mobileqq/hotchat/ui/HeartView:getResources	()Landroid/content/res/Resources;
    //   10: ldc 16
    //   12: invokestatic 62	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   15: putstatic 52	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   18: getstatic 64	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   21: ifnonnull +15 -> 36
    //   24: aload_0
    //   25: invokevirtual 56	com/tencent/mobileqq/hotchat/ui/HeartView:getResources	()Landroid/content/res/Resources;
    //   28: ldc 19
    //   30: invokestatic 62	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   33: putstatic 64	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   36: getstatic 66	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   39: ifnonnull +14 -> 53
    //   42: new 68	android/graphics/Paint
    //   45: dup
    //   46: iconst_3
    //   47: invokespecial 71	android/graphics/Paint:<init>	(I)V
    //   50: putstatic 66	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   53: getstatic 73	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   56: ifnonnull +13 -> 69
    //   59: new 75	android/graphics/Canvas
    //   62: dup
    //   63: invokespecial 77	android/graphics/Canvas:<init>	()V
    //   66: putstatic 73	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   69: getstatic 52	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   72: astore_2
    //   73: getstatic 64	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   76: astore_3
    //   77: aload_3
    //   78: invokevirtual 81	android/graphics/Bitmap:getWidth	()I
    //   81: aload_3
    //   82: invokevirtual 84	android/graphics/Bitmap:getHeight	()I
    //   85: invokestatic 86	com/tencent/mobileqq/hotchat/ui/HeartView:a	(II)Landroid/graphics/Bitmap;
    //   88: astore 4
    //   90: aload 4
    //   92: ifnonnull +5 -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: getstatic 73	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsCanvas	Landroid/graphics/Canvas;
    //   100: astore 5
    //   102: aload 5
    //   104: aload 4
    //   106: invokevirtual 90	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   109: getstatic 66	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_AndroidGraphicsPaint	Landroid/graphics/Paint;
    //   112: astore 6
    //   114: aload_0
    //   115: getfield 23	com/tencent/mobileqq/hotchat/ui/HeartView:jdField_a_of_type_Boolean	Z
    //   118: ifeq +78 -> 196
    //   121: aload 5
    //   123: aload_3
    //   124: fconst_0
    //   125: fconst_0
    //   126: aload 6
    //   128: invokevirtual 94	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   131: aload 6
    //   133: new 96	android/graphics/PorterDuffColorFilter
    //   136: dup
    //   137: iload_1
    //   138: getstatic 102	android/graphics/PorterDuff$Mode:SRC_ATOP	Landroid/graphics/PorterDuff$Mode;
    //   141: invokespecial 105	android/graphics/PorterDuffColorFilter:<init>	(ILandroid/graphics/PorterDuff$Mode;)V
    //   144: invokevirtual 109	android/graphics/Paint:setColorFilter	(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   147: pop
    //   148: aload 5
    //   150: aload_2
    //   151: aload_3
    //   152: invokevirtual 81	android/graphics/Bitmap:getWidth	()I
    //   155: aload_2
    //   156: invokevirtual 81	android/graphics/Bitmap:getWidth	()I
    //   159: isub
    //   160: i2f
    //   161: fconst_2
    //   162: fdiv
    //   163: aload_3
    //   164: invokevirtual 84	android/graphics/Bitmap:getHeight	()I
    //   167: aload_2
    //   168: invokevirtual 84	android/graphics/Bitmap:getHeight	()I
    //   171: isub
    //   172: i2f
    //   173: fconst_2
    //   174: fdiv
    //   175: aload 6
    //   177: invokevirtual 94	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   180: aload 6
    //   182: aconst_null
    //   183: invokevirtual 109	android/graphics/Paint:setColorFilter	(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   186: pop
    //   187: aload 5
    //   189: aconst_null
    //   190: invokevirtual 90	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   193: aload 4
    //   195: areturn
    //   196: aload 6
    //   198: new 96	android/graphics/PorterDuffColorFilter
    //   201: dup
    //   202: iload_1
    //   203: getstatic 102	android/graphics/PorterDuff$Mode:SRC_ATOP	Landroid/graphics/PorterDuff$Mode;
    //   206: invokespecial 105	android/graphics/PorterDuffColorFilter:<init>	(ILandroid/graphics/PorterDuff$Mode;)V
    //   209: invokevirtual 109	android/graphics/Paint:setColorFilter	(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   212: pop
    //   213: aload 5
    //   215: aload_3
    //   216: fconst_0
    //   217: fconst_0
    //   218: aload 6
    //   220: invokevirtual 94	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   223: goto -43 -> 180
    //   226: astore_2
    //   227: aconst_null
    //   228: areturn
    //   229: astore_2
    //   230: aconst_null
    //   231: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	HeartView
    //   0	232	1	paramInt	int
    //   72	96	2	localBitmap1	Bitmap
    //   226	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   229	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   76	140	3	localBitmap2	Bitmap
    //   88	106	4	localBitmap3	Bitmap
    //   100	114	5	localCanvas	Canvas
    //   112	107	6	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   24	36	226	java/lang/OutOfMemoryError
    //   6	18	229	java/lang/OutOfMemoryError
  }
  
  public void setColor(int paramInt)
  {
    Bitmap localBitmap = a(paramInt);
    if (localBitmap != null)
    {
      super.setImageBitmap(localBitmap);
      return;
    }
    super.setImageResource(2130845204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.HeartView
 * JD-Core Version:    0.7.0.1
 */