package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class LottieHelper$3$1
  implements ImageAssetDelegate
{
  LottieHelper$3$1(LottieHelper.3 param3) {}
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 12	com/tencent/mobileqq/onlinestatus/utils/LottieHelper$3$1:a	Lcom/tencent/mobileqq/onlinestatus/utils/LottieHelper$3;
    //   6: getfield 29	com/tencent/mobileqq/onlinestatus/utils/LottieHelper$3:e	Landroid/content/Context;
    //   9: invokevirtual 35	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: new 37	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: aload_0
    //   25: getfield 12	com/tencent/mobileqq/onlinestatus/utils/LottieHelper$3$1:a	Lcom/tencent/mobileqq/onlinestatus/utils/LottieHelper$3;
    //   28: getfield 42	com/tencent/mobileqq/onlinestatus/utils/LottieHelper$3:d	Ljava/lang/String;
    //   31: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: aload_1
    //   38: invokevirtual 52	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   41: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: aload 4
    //   48: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 61	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: new 63	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 64	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore_3
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: iconst_0
    //   69: putfield 68	android/graphics/BitmapFactory$Options:inScaled	Z
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: aconst_null
    //   76: checkcast 70	android/graphics/Rect
    //   79: aload_3
    //   80: invokestatic 76	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   83: astore_3
    //   84: aload_2
    //   85: astore_1
    //   86: aload_2
    //   87: invokevirtual 81	java/io/InputStream:close	()V
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 81	java/io/InputStream:close	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_3
    //   101: goto +12 -> 113
    //   104: astore_2
    //   105: aload_3
    //   106: astore_1
    //   107: goto +28 -> 135
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: ldc 83
    //   117: iconst_2
    //   118: ldc 85
    //   120: aload_3
    //   121: invokestatic 91	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 81	java/io/InputStream:close	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_2
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 81	java/io/InputStream:close	()V
    //   143: aload_2
    //   144: athrow
    //   145: astore_1
    //   146: aload_3
    //   147: areturn
    //   148: astore_1
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: goto -9 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	1
    //   0	155	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   12	83	2	localObject1	Object
    //   104	1	2	localObject2	Object
    //   112	17	2	localObject3	Object
    //   134	10	2	localObject4	Object
    //   1	98	3	localObject5	Object
    //   100	6	3	localThrowable1	java.lang.Throwable
    //   110	37	3	localThrowable2	java.lang.Throwable
    //   20	27	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	65	100	java/lang/Throwable
    //   67	72	100	java/lang/Throwable
    //   74	84	100	java/lang/Throwable
    //   86	90	100	java/lang/Throwable
    //   2	55	104	finally
    //   2	55	110	java/lang/Throwable
    //   57	65	134	finally
    //   67	72	134	finally
    //   74	84	134	finally
    //   86	90	134	finally
    //   115	124	134	finally
    //   94	98	145	java/lang/Exception
    //   128	132	148	java/lang/Exception
    //   139	143	151	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.LottieHelper.3.1
 * JD-Core Version:    0.7.0.1
 */