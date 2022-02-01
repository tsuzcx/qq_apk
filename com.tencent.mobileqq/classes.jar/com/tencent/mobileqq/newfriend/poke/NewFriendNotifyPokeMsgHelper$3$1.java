package com.tencent.mobileqq.newfriend.poke;

import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class NewFriendNotifyPokeMsgHelper$3$1
  implements ImageAssetDelegate
{
  NewFriendNotifyPokeMsgHelper$3$1(NewFriendNotifyPokeMsgHelper.3 param3) {}
  
  /* Error */
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 12	com/tencent/mobileqq/newfriend/poke/NewFriendNotifyPokeMsgHelper$3$1:a	Lcom/tencent/mobileqq/newfriend/poke/NewFriendNotifyPokeMsgHelper$3;
    //   6: getfield 27	com/tencent/mobileqq/newfriend/poke/NewFriendNotifyPokeMsgHelper$3:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: invokevirtual 33	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: new 35	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: aload_0
    //   25: getfield 12	com/tencent/mobileqq/newfriend/poke/NewFriendNotifyPokeMsgHelper$3$1:a	Lcom/tencent/mobileqq/newfriend/poke/NewFriendNotifyPokeMsgHelper$3;
    //   28: getfield 39	com/tencent/mobileqq/newfriend/poke/NewFriendNotifyPokeMsgHelper$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: aload_1
    //   38: invokevirtual 49	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   41: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: aload 4
    //   48: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 58	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: new 60	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 61	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore_3
    //   65: aload_2
    //   66: astore_1
    //   67: aload_3
    //   68: iconst_0
    //   69: putfield 65	android/graphics/BitmapFactory$Options:inScaled	Z
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: aconst_null
    //   76: checkcast 67	android/graphics/Rect
    //   79: aload_3
    //   80: invokestatic 73	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   83: astore_3
    //   84: aload_2
    //   85: astore_1
    //   86: aload_2
    //   87: invokevirtual 78	java/io/InputStream:close	()V
    //   90: aload_2
    //   91: ifnull +7 -> 98
    //   94: aload_2
    //   95: invokevirtual 78	java/io/InputStream:close	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_3
    //   101: goto +12 -> 113
    //   104: astore_2
    //   105: aload_3
    //   106: astore_1
    //   107: goto +31 -> 138
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: ldc 80
    //   117: iconst_2
    //   118: ldc 82
    //   120: aload_3
    //   121: checkcast 22	java/lang/Exception
    //   124: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 78	java/io/InputStream:close	()V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_2
    //   138: aload_1
    //   139: ifnull +7 -> 146
    //   142: aload_1
    //   143: invokevirtual 78	java/io/InputStream:close	()V
    //   146: aload_2
    //   147: athrow
    //   148: astore_1
    //   149: aload_3
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: goto -9 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	1
    //   0	158	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   12	83	2	localObject1	Object
    //   104	1	2	localObject2	Object
    //   112	20	2	localObject3	Object
    //   137	10	2	localObject4	Object
    //   1	98	3	localObject5	Object
    //   100	6	3	localThrowable1	java.lang.Throwable
    //   110	40	3	localThrowable2	java.lang.Throwable
    //   20	27	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	65	100	java/lang/Throwable
    //   67	72	100	java/lang/Throwable
    //   74	84	100	java/lang/Throwable
    //   86	90	100	java/lang/Throwable
    //   2	55	104	finally
    //   2	55	110	java/lang/Throwable
    //   57	65	137	finally
    //   67	72	137	finally
    //   74	84	137	finally
    //   86	90	137	finally
    //   115	127	137	finally
    //   94	98	148	java/lang/Exception
    //   131	135	151	java/lang/Exception
    //   142	146	154	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper.3.1
 * JD-Core Version:    0.7.0.1
 */