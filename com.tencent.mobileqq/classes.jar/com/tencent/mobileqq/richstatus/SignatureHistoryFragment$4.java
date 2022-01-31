package com.tencent.mobileqq.richstatus;

class SignatureHistoryFragment$4
  implements Runnable
{
  SignatureHistoryFragment$4(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 27
    //   8: iconst_2
    //   9: new 29	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   16: ldc 32
    //   18: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 45	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 12	com/tencent/mobileqq/richstatus/SignatureHistoryFragment$4:this$0	Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;
    //   39: invokevirtual 59	com/tencent/mobileqq/richstatus/SignatureHistoryFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   42: ifnonnull +4 -> 46
    //   45: return
    //   46: aload_0
    //   47: getfield 12	com/tencent/mobileqq/richstatus/SignatureHistoryFragment$4:this$0	Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;
    //   50: invokevirtual 59	com/tencent/mobileqq/richstatus/SignatureHistoryFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   53: getfield 65	android/support/v4/app/FragmentActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull -15 -> 45
    //   63: aload_0
    //   64: getfield 12	com/tencent/mobileqq/richstatus/SignatureHistoryFragment$4:this$0	Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;
    //   67: invokevirtual 69	com/tencent/mobileqq/richstatus/SignatureHistoryFragment:getResources	()Landroid/content/res/Resources;
    //   70: ldc 70
    //   72: invokevirtual 76	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   75: istore_1
    //   76: aload 5
    //   78: invokevirtual 81	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 12	com/tencent/mobileqq/richstatus/SignatureHistoryFragment$4:this$0	Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;
    //   85: invokestatic 85	com/tencent/mobileqq/richstatus/SignatureHistoryFragment:a	(Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;)Ljava/lang/String;
    //   88: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq +165 -> 256
    //   94: invokestatic 96	azyk:b	()Ljava/lang/String;
    //   97: astore_3
    //   98: new 98	java/io/File
    //   101: dup
    //   102: aload_3
    //   103: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore 6
    //   108: new 103	android/graphics/BitmapFactory$Options
    //   111: dup
    //   112: invokespecial 104	android/graphics/BitmapFactory$Options:<init>	()V
    //   115: astore 4
    //   117: new 106	java/io/FileInputStream
    //   120: dup
    //   121: aload 6
    //   123: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: astore 6
    //   128: aload 4
    //   130: aload 6
    //   132: iload_1
    //   133: iload_1
    //   134: invokestatic 114	bacm:a	(Ljava/io/InputStream;II)D
    //   137: d2i
    //   138: putfield 118	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   141: aload 6
    //   143: invokevirtual 123	java/io/InputStream:close	()V
    //   146: aload_3
    //   147: aload 4
    //   149: invokestatic 128	azvq:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   152: astore_3
    //   153: aload_3
    //   154: astore_2
    //   155: aload_3
    //   156: ifnull +16 -> 172
    //   159: aload_3
    //   160: aload_3
    //   161: invokevirtual 134	android/graphics/Bitmap:getWidth	()I
    //   164: aload_3
    //   165: invokevirtual 137	android/graphics/Bitmap:getHeight	()I
    //   168: invokestatic 140	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   171: astore_2
    //   172: aload_2
    //   173: astore_3
    //   174: aload_2
    //   175: ifnonnull +17 -> 192
    //   178: aload 5
    //   180: aload_0
    //   181: getfield 12	com/tencent/mobileqq/richstatus/SignatureHistoryFragment$4:this$0	Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;
    //   184: invokestatic 85	com/tencent/mobileqq/richstatus/SignatureHistoryFragment:a	(Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;)Ljava/lang/String;
    //   187: iconst_1
    //   188: invokevirtual 143	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   191: astore_3
    //   192: aload_3
    //   193: ifnull -148 -> 45
    //   196: aload_0
    //   197: getfield 12	com/tencent/mobileqq/richstatus/SignatureHistoryFragment$4:this$0	Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;
    //   200: invokestatic 146	com/tencent/mobileqq/richstatus/SignatureHistoryFragment:a	(Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;)Landroid/os/Handler;
    //   203: iconst_2
    //   204: invokevirtual 152	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   207: astore_2
    //   208: aload_2
    //   209: aload_3
    //   210: putfield 158	android/os/Message:obj	Ljava/lang/Object;
    //   213: aload_0
    //   214: getfield 12	com/tencent/mobileqq/richstatus/SignatureHistoryFragment$4:this$0	Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;
    //   217: invokestatic 146	com/tencent/mobileqq/richstatus/SignatureHistoryFragment:a	(Lcom/tencent/mobileqq/richstatus/SignatureHistoryFragment;)Landroid/os/Handler;
    //   220: aload_2
    //   221: invokevirtual 162	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   224: pop
    //   225: return
    //   226: astore_3
    //   227: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +13 -> 243
    //   233: ldc 164
    //   235: iconst_2
    //   236: aload_3
    //   237: invokevirtual 165	java/lang/Exception:toString	()Ljava/lang/String;
    //   240: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto -71 -> 172
    //   246: astore 4
    //   248: aload_3
    //   249: astore_2
    //   250: aload 4
    //   252: astore_3
    //   253: goto -26 -> 227
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -86 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	4
    //   75	59	1	i	int
    //   34	224	2	localObject1	Object
    //   97	113	3	localObject2	Object
    //   226	23	3	localException1	java.lang.Exception
    //   252	1	3	localObject3	Object
    //   115	33	4	localOptions	android.graphics.BitmapFactory.Options
    //   246	5	4	localException2	java.lang.Exception
    //   56	123	5	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   106	36	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   94	153	226	java/lang/Exception
    //   159	172	246	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.4
 * JD-Core Version:    0.7.0.1
 */