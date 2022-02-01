import com.tencent.mobileqq.dinifly.ImageAssetDelegate;

class nhw
  implements ImageAssetDelegate
{
  nhw(nhv paramnhv) {}
  
  /* Error */
  @android.support.annotation.Nullable
  public android.graphics.Bitmap fetchBitmap(com.tencent.mobileqq.dinifly.LottieImageAsset paramLottieImageAsset)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 29	com/tencent/mobileqq/dinifly/LottieImageAsset:getFileName	()Ljava/lang/String;
    //   4: astore_1
    //   5: new 31	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: getfield 12	nhw:a	Lnhv;
    //   16: getfield 37	nhv:a	Ljava/lang/String;
    //   19: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore_1
    //   30: new 46	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 53	java/io/File:exists	()Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifne +57 -> 100
    //   46: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +37 -> 86
    //   52: ldc 60
    //   54: iconst_2
    //   55: new 31	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   62: ldc 62
    //   64: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_2
    //   68: invokevirtual 65	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc 67
    //   73: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: iconst_0
    //   87: ifeq +11 -> 98
    //   90: new 73	java/lang/NullPointerException
    //   93: dup
    //   94: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   97: athrow
    //   98: aconst_null
    //   99: areturn
    //   100: aload_1
    //   101: invokestatic 79	nhu:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   104: astore_1
    //   105: iconst_0
    //   106: ifeq +11 -> 117
    //   109: new 73	java/lang/NullPointerException
    //   112: dup
    //   113: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   116: athrow
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: ldc 60
    //   122: iconst_2
    //   123: ldc 81
    //   125: aload_1
    //   126: invokestatic 85	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: iconst_0
    //   130: ifeq -32 -> 98
    //   133: new 73	java/lang/NullPointerException
    //   136: dup
    //   137: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   140: athrow
    //   141: astore_1
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: iconst_0
    //   146: ifeq +11 -> 157
    //   149: new 73	java/lang/NullPointerException
    //   152: dup
    //   153: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   156: athrow
    //   157: aload_3
    //   158: athrow
    //   159: astore_1
    //   160: aconst_null
    //   161: areturn
    //   162: astore_3
    //   163: goto -46 -> 117
    //   166: astore_1
    //   167: goto -10 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	nhw
    //   0	170	1	paramLottieImageAsset	com.tencent.mobileqq.dinifly.LottieImageAsset
    //   41	27	2	bool	boolean
    //   144	14	3	localObject	Object
    //   162	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	42	119	java/lang/Throwable
    //   46	86	119	java/lang/Throwable
    //   100	105	119	java/lang/Throwable
    //   133	141	141	java/lang/Exception
    //   0	42	144	finally
    //   46	86	144	finally
    //   100	105	144	finally
    //   120	129	144	finally
    //   90	98	159	java/lang/Exception
    //   109	117	162	java/lang/Exception
    //   149	157	166	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhw
 * JD-Core Version:    0.7.0.1
 */