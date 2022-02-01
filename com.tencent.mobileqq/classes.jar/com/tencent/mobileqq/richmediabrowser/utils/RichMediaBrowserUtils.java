package com.tencent.mobileqq.richmediabrowser.utils;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;

public class RichMediaBrowserUtils
{
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(paramInt);
    paramArrayList.add(localActionSheetItem);
    return localActionSheetItem;
  }
  
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, String paramString, int paramInt2)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = a(paramInt1, paramArrayList);
    paramArrayList = paramString;
    if (paramString == null) {
      paramArrayList = "";
    }
    localActionSheetItem.argus = paramArrayList;
    localActionSheetItem.firstLineCount = paramInt2;
    return localActionSheetItem;
  }
  
  public static Runnable a(View paramView, URLDrawable paramURLDrawable)
  {
    int i;
    if ((paramURLDrawable.getStatus() != 0) && (paramURLDrawable.getStatus() != 4)) {
      i = 0;
    } else {
      i = 1;
    }
    RichMediaBrowserUtils.1 local1 = null;
    if (i != 0)
    {
      local1 = new RichMediaBrowserUtils.1(paramURLDrawable, paramView);
      paramView.postDelayed(local1, 200L);
    }
    return local1;
  }
  
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +76 -> 77
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +69 -> 77
    //   11: aconst_null
    //   12: astore_3
    //   13: new 64	java/io/BufferedOutputStream
    //   16: dup
    //   17: new 66	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: ldc 70
    //   27: invokespecial 73	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   30: astore_1
    //   31: aload_0
    //   32: getstatic 79	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   35: bipush 70
    //   37: aload_1
    //   38: invokevirtual 85	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   41: istore_2
    //   42: aload_1
    //   43: invokevirtual 90	java/io/OutputStream:flush	()V
    //   46: aload_1
    //   47: invokevirtual 93	java/io/OutputStream:close	()V
    //   50: iload_2
    //   51: ireturn
    //   52: astore_3
    //   53: aload_1
    //   54: astore_0
    //   55: aload_3
    //   56: astore_1
    //   57: goto +6 -> 63
    //   60: astore_1
    //   61: aload_3
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +11 -> 75
    //   67: aload_0
    //   68: invokevirtual 90	java/io/OutputStream:flush	()V
    //   71: aload_0
    //   72: invokevirtual 93	java/io/OutputStream:close	()V
    //   75: aload_1
    //   76: athrow
    //   77: iconst_0
    //   78: ireturn
    //   79: astore_0
    //   80: goto -34 -> 46
    //   83: astore_3
    //   84: goto -13 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramBitmap	android.graphics.Bitmap
    //   0	87	1	paramString	String
    //   41	10	2	bool	boolean
    //   12	1	3	localObject1	Object
    //   52	10	3	localObject2	Object
    //   83	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   31	42	52	finally
    //   13	31	60	finally
    //   42	46	79	java/io/IOException
    //   67	71	83	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils
 * JD-Core Version:    0.7.0.1
 */