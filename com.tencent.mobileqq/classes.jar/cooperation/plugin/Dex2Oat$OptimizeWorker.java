package cooperation.plugin;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class Dex2Oat$OptimizeWorker
  implements Runnable
{
  private static String jdField_a_of_type_JavaLangString;
  private final Dex2Oat.ResultCallback jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback;
  private final File jdField_a_of_type_JavaIoFile;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private final boolean jdField_a_of_type_Boolean;
  private final File b;
  
  Dex2Oat$OptimizeWorker(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, AtomicInteger paramAtomicInteger, CountDownLatch paramCountDownLatch, Dex2Oat.ResultCallback paramResultCallback)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile1;
    this.b = paramFile2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = paramCountDownLatch;
    this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback = paramResultCallback;
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4: invokestatic 43	cooperation/plugin/Dex2Oat:a	(Ljava/io/File;)Z
    //   7: ifne +83 -> 90
    //   10: aload_0
    //   11: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   14: ifnull +76 -> 90
    //   17: aload_0
    //   18: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   26: astore_2
    //   27: aload_0
    //   28: getfield 25	cooperation/plugin/Dex2Oat$OptimizeWorker:b	Ljava/io/File;
    //   31: astore_3
    //   32: new 45	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   39: astore 4
    //   41: aload 4
    //   43: ldc 48
    //   45: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: aload_0
    //   52: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   55: invokevirtual 58	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: ldc 60
    //   66: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: aload_2
    //   72: aload_3
    //   73: new 62	java/io/IOException
    //   76: dup
    //   77: aload 4
    //   79: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 68	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   85: invokeinterface 73 4 0
    //   90: aload_0
    //   91: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   94: ifnull +20 -> 114
    //   97: aload_0
    //   98: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   101: aload_0
    //   102: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   105: aload_0
    //   106: getfield 25	cooperation/plugin/Dex2Oat$OptimizeWorker:b	Ljava/io/File;
    //   109: invokeinterface 76 3 0
    //   114: aload_0
    //   115: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   118: aload_0
    //   119: getfield 25	cooperation/plugin/Dex2Oat$OptimizeWorker:b	Ljava/io/File;
    //   122: invokestatic 79	cooperation/plugin/Dex2Oat:a	(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   130: invokevirtual 58	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: aload_1
    //   134: iconst_0
    //   135: invokestatic 85	dalvik/system/DexFile:loadDex	(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
    //   138: pop
    //   139: aload_0
    //   140: getfield 29	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   143: invokevirtual 91	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   146: pop
    //   147: aload_0
    //   148: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   151: ifnull +99 -> 250
    //   154: aload_0
    //   155: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   158: aload_0
    //   159: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   162: aload_0
    //   163: getfield 25	cooperation/plugin/Dex2Oat$OptimizeWorker:b	Ljava/io/File;
    //   166: new 54	java/io/File
    //   169: dup
    //   170: aload_1
    //   171: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: invokeinterface 95 4 0
    //   179: goto +71 -> 250
    //   182: astore_1
    //   183: goto +75 -> 258
    //   186: astore_1
    //   187: new 45	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   194: astore_2
    //   195: aload_2
    //   196: ldc 97
    //   198: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_2
    //   203: aload_0
    //   204: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   207: invokevirtual 58	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   210: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: ldc 99
    //   216: aload_2
    //   217: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: aload_1
    //   221: invokestatic 105	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   224: pop
    //   225: aload_0
    //   226: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   229: ifnull +21 -> 250
    //   232: aload_0
    //   233: getfield 33	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback	Lcooperation/plugin/Dex2Oat$ResultCallback;
    //   236: aload_0
    //   237: getfield 23	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   240: aload_0
    //   241: getfield 25	cooperation/plugin/Dex2Oat$OptimizeWorker:b	Ljava/io/File;
    //   244: aload_1
    //   245: invokeinterface 73 4 0
    //   250: aload_0
    //   251: getfield 31	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   254: invokevirtual 110	java/util/concurrent/CountDownLatch:countDown	()V
    //   257: return
    //   258: aload_0
    //   259: getfield 31	cooperation/plugin/Dex2Oat$OptimizeWorker:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   262: invokevirtual 110	java/util/concurrent/CountDownLatch:countDown	()V
    //   265: aload_1
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	OptimizeWorker
    //   21	150	1	localObject1	Object
    //   182	1	1	localObject2	Object
    //   186	80	1	localThrowable	java.lang.Throwable
    //   26	191	2	localObject3	Object
    //   31	42	3	localFile	File
    //   39	39	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	90	182	finally
    //   90	114	182	finally
    //   114	179	182	finally
    //   187	250	182	finally
    //   0	90	186	java/lang/Throwable
    //   90	114	186	java/lang/Throwable
    //   114	179	186	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat.OptimizeWorker
 * JD-Core Version:    0.7.0.1
 */