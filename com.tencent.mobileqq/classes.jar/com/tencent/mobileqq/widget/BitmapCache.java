package com.tencent.mobileqq.widget;

class BitmapCache
  implements ImageViewTouchBase.Recycler
{
  private final BitmapCache.Entry[] a;
  
  /* Error */
  public void a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 11	com/tencent/mobileqq/widget/BitmapCache:a	[Lcom/tencent/mobileqq/widget/BitmapCache$Entry;
    //   6: astore 4
    //   8: aload 4
    //   10: arraylength
    //   11: istore_3
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmpge +41 -> 57
    //   19: aload 4
    //   21: iload_2
    //   22: aaload
    //   23: astore 5
    //   25: aload 5
    //   27: getfield 16	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_Int	I
    //   30: iconst_m1
    //   31: if_icmpeq +19 -> 50
    //   34: aload 5
    //   36: getfield 19	com/tencent/mobileqq/widget/BitmapCache$Entry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   39: astore 5
    //   41: aload 5
    //   43: aload_1
    //   44: if_acmpne +6 -> 50
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: iload_2
    //   51: iconst_1
    //   52: iadd
    //   53: istore_2
    //   54: goto -40 -> 14
    //   57: aload_1
    //   58: invokevirtual 25	android/graphics/Bitmap:recycle	()V
    //   61: goto -14 -> 47
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	BitmapCache
    //   0	69	1	paramBitmap	android.graphics.Bitmap
    //   13	41	2	i	int
    //   11	6	3	j	int
    //   6	14	4	arrayOfEntry	BitmapCache.Entry[]
    //   23	19	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	64	finally
    //   25	41	64	finally
    //   57	61	64	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BitmapCache
 * JD-Core Version:    0.7.0.1
 */