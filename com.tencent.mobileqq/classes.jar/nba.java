import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class nba
  implements ImageAssetDelegate
{
  nba(naz paramnaz) {}
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 12	nba:a	Lnaz;
    //   6: getfield 28	naz:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: invokevirtual 34	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: new 36	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   19: aload_0
    //   20: getfield 12	nba:a	Lnaz;
    //   23: getfield 40	naz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 50	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   33: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokevirtual 59	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: new 61	android/graphics/BitmapFactory$Options
    //   50: dup
    //   51: invokespecial 62	android/graphics/BitmapFactory$Options:<init>	()V
    //   54: astore_3
    //   55: aload_2
    //   56: astore_1
    //   57: aload_3
    //   58: iconst_0
    //   59: putfield 66	android/graphics/BitmapFactory$Options:inScaled	Z
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: aconst_null
    //   66: checkcast 68	android/graphics/Rect
    //   69: aload_3
    //   70: invokestatic 74	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: invokevirtual 79	java/io/InputStream:close	()V
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 79	java/io/InputStream:close	()V
    //   88: aload_3
    //   89: areturn
    //   90: astore_3
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: astore_1
    //   95: ldc 81
    //   97: iconst_2
    //   98: ldc 83
    //   100: aload_3
    //   101: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 79	java/io/InputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_1
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 79	java/io/InputStream:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_3
    //   127: areturn
    //   128: astore_1
    //   129: goto -17 -> 112
    //   132: astore_2
    //   133: goto -10 -> 123
    //   136: astore_3
    //   137: aload_1
    //   138: astore_2
    //   139: aload_3
    //   140: astore_1
    //   141: goto -26 -> 115
    //   144: astore_3
    //   145: goto -52 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	nba
    //   0	148	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   1	119	2	localLottieImageAsset1	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   132	1	2	localException	java.lang.Exception
    //   138	1	2	localLottieImageAsset2	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   54	35	3	localObject1	Object
    //   90	37	3	localThrowable1	java.lang.Throwable
    //   136	4	3	localObject2	Object
    //   144	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	43	90	java/lang/Throwable
    //   2	43	114	finally
    //   84	88	125	java/lang/Exception
    //   108	112	128	java/lang/Exception
    //   119	123	132	java/lang/Exception
    //   47	55	136	finally
    //   57	62	136	finally
    //   64	74	136	finally
    //   76	80	136	finally
    //   95	104	136	finally
    //   47	55	144	java/lang/Throwable
    //   57	62	144	java/lang/Throwable
    //   64	74	144	java/lang/Throwable
    //   76	80	144	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nba
 * JD-Core Version:    0.7.0.1
 */