package dov.com.tencent.mobileqq.richmedia.capture.util;

public final class CameraHdrSetting$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 22	azzu:a	()Z
    //   3: ifeq +117 -> 120
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 5
    //   16: astore_1
    //   17: new 24	java/io/File
    //   20: dup
    //   21: getstatic 30	bjed:b	Ljava/lang/String;
    //   24: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 6
    //   29: aload 5
    //   31: astore_1
    //   32: aload 6
    //   34: invokevirtual 36	java/io/File:exists	()Z
    //   37: ifne +12 -> 49
    //   40: aload 5
    //   42: astore_1
    //   43: aload 6
    //   45: invokevirtual 39	java/io/File:createNewFile	()Z
    //   48: pop
    //   49: aload 4
    //   51: astore_2
    //   52: aload 5
    //   54: astore_1
    //   55: aload 6
    //   57: invokevirtual 36	java/io/File:exists	()Z
    //   60: ifeq +52 -> 112
    //   63: aload 4
    //   65: astore_2
    //   66: aload 5
    //   68: astore_1
    //   69: aload 6
    //   71: invokevirtual 42	java/io/File:isFile	()Z
    //   74: ifeq +38 -> 112
    //   77: aload 5
    //   79: astore_1
    //   80: new 44	java/io/BufferedWriter
    //   83: dup
    //   84: new 46	java/io/FileWriter
    //   87: dup
    //   88: getstatic 30	bjed:b	Ljava/lang/String;
    //   91: invokespecial 47	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   94: invokespecial 50	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   97: astore_2
    //   98: aload_2
    //   99: getstatic 53	bjed:jdField_a_of_type_Boolean	Z
    //   102: invokestatic 59	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   105: invokevirtual 62	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: invokevirtual 65	java/io/BufferedWriter:flush	()V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 68	java/io/BufferedWriter:close	()V
    //   120: return
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   126: return
    //   127: astore_1
    //   128: aload_3
    //   129: astore_2
    //   130: aload_1
    //   131: astore_3
    //   132: aload_2
    //   133: astore_1
    //   134: getstatic 73	bjed:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   137: iconst_1
    //   138: ldc 75
    //   140: aload_3
    //   141: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_2
    //   145: ifnull -25 -> 120
    //   148: aload_2
    //   149: invokevirtual 68	java/io/BufferedWriter:close	()V
    //   152: return
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   158: return
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: astore_1
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 68	java/io/BufferedWriter:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_2
    //   175: aload_2
    //   176: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   179: goto -7 -> 172
    //   182: astore_1
    //   183: goto -19 -> 164
    //   186: astore_3
    //   187: goto -55 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	1
    //   16	64	1	localObject1	Object
    //   121	2	1	localIOException1	java.io.IOException
    //   127	4	1	localThrowable1	java.lang.Throwable
    //   133	1	1	localObject2	Object
    //   153	8	1	localIOException2	java.io.IOException
    //   163	10	1	localObject3	Object
    //   182	1	1	localObject4	Object
    //   51	118	2	localObject5	Object
    //   174	2	2	localIOException3	java.io.IOException
    //   7	134	3	localObject6	Object
    //   159	4	3	localObject7	Object
    //   186	1	3	localThrowable2	java.lang.Throwable
    //   12	52	4	localObject8	Object
    //   9	69	5	localObject9	Object
    //   27	43	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   116	120	121	java/io/IOException
    //   17	29	127	java/lang/Throwable
    //   32	40	127	java/lang/Throwable
    //   43	49	127	java/lang/Throwable
    //   55	63	127	java/lang/Throwable
    //   69	77	127	java/lang/Throwable
    //   80	98	127	java/lang/Throwable
    //   148	152	153	java/io/IOException
    //   17	29	159	finally
    //   32	40	159	finally
    //   43	49	159	finally
    //   55	63	159	finally
    //   69	77	159	finally
    //   80	98	159	finally
    //   134	144	159	finally
    //   168	172	174	java/io/IOException
    //   98	112	182	finally
    //   98	112	186	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.util.CameraHdrSetting.1
 * JD-Core Version:    0.7.0.1
 */