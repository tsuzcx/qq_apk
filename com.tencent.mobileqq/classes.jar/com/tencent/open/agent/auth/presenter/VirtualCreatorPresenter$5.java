package com.tencent.open.agent.auth.presenter;

class VirtualCreatorPresenter$5
  implements Runnable
{
  VirtualCreatorPresenter$5(VirtualCreatorPresenter paramVirtualCreatorPresenter, String paramString, int paramInt1, int paramInt2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 33	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 18	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_1
    //   16: aconst_null
    //   17: astore 4
    //   19: new 38	java/io/BufferedInputStream
    //   22: dup
    //   23: new 40	java/io/FileInputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 43	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore 5
    //   36: new 48	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 49	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore_1
    //   44: aload_1
    //   45: aload 5
    //   47: aload_0
    //   48: getfield 20	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5:jdField_a_of_type_Int	I
    //   51: aload_0
    //   52: getfield 22	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5:b	I
    //   55: invokestatic 54	com/tencent/mobileqq/utils/BaseImageUtil:a	(Ljava/io/InputStream;II)D
    //   58: d2i
    //   59: putfield 57	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   62: aload_0
    //   63: getfield 18	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   66: aload_1
    //   67: invokestatic 62	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: aload_2
    //   74: ifnull +36 -> 110
    //   77: aload_2
    //   78: astore_1
    //   79: aload 4
    //   81: astore_3
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 20	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5:jdField_a_of_type_Int	I
    //   87: aload_0
    //   88: getfield 20	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5:jdField_a_of_type_Int	I
    //   91: invokestatic 67	com/tencent/open/agent/util/AuthorityUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   94: astore 4
    //   96: aload 4
    //   98: astore_1
    //   99: goto +11 -> 110
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: goto +26 -> 133
    //   110: aload_1
    //   111: astore_2
    //   112: aload_2
    //   113: astore_1
    //   114: aload 5
    //   116: invokevirtual 70	java/io/BufferedInputStream:close	()V
    //   119: aload_2
    //   120: astore_1
    //   121: goto +49 -> 170
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_1
    //   127: goto +11 -> 138
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_2
    //   134: astore_3
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: aload_3
    //   139: ifnull +11 -> 150
    //   142: aload 5
    //   144: invokevirtual 70	java/io/BufferedInputStream:close	()V
    //   147: goto +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 70	java/io/BufferedInputStream:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: goto +4 -> 162
    //   161: astore_2
    //   162: ldc 72
    //   164: ldc 74
    //   166: aload_2
    //   167: invokestatic 80	com/tencent/open/agent/util/SSOLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_1
    //   171: ifnonnull +4 -> 175
    //   174: return
    //   175: invokestatic 86	com/tencent/mobileqq/app/ThreadManagerV2:getUIHandlerV2	()Landroid/os/Handler;
    //   178: new 88	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5$1
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 91	com/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5$1:<init>	(Lcom/tencent/open/agent/auth/presenter/VirtualCreatorPresenter$5;Landroid/graphics/Bitmap;)V
    //   187: invokevirtual 97	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   190: pop
    //   191: return
    //   192: astore_3
    //   193: goto -38 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	5
    //   15	169	1	localObject1	Object
    //   11	109	2	localObject2	Object
    //   124	1	2	localObject3	Object
    //   130	6	2	localThrowable1	java.lang.Throwable
    //   137	19	2	localObject4	Object
    //   157	1	2	localException1	java.lang.Exception
    //   161	6	2	localException2	java.lang.Exception
    //   13	69	3	localObject5	Object
    //   102	4	3	localThrowable2	java.lang.Throwable
    //   134	5	3	localThrowable3	java.lang.Throwable
    //   192	1	3	localThrowable4	java.lang.Throwable
    //   17	80	4	localBitmap	android.graphics.Bitmap
    //   34	117	5	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   82	96	102	java/lang/Throwable
    //   36	71	124	finally
    //   36	71	130	java/lang/Throwable
    //   82	96	137	finally
    //   135	137	137	finally
    //   142	147	157	java/lang/Exception
    //   150	155	157	java/lang/Exception
    //   155	157	157	java/lang/Exception
    //   19	36	161	java/lang/Exception
    //   114	119	161	java/lang/Exception
    //   142	147	192	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter.5
 * JD-Core Version:    0.7.0.1
 */