package dov.com.qq.im;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;

public class SystemUtil
{
  private static long a;
  
  /* Error */
  private static long a()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_0
    //   2: new 18	java/io/File
    //   5: dup
    //   6: ldc 20
    //   8: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: new 25	java/io/BufferedReader
    //   16: dup
    //   17: new 27	java/io/InputStreamReader
    //   20: dup
    //   21: new 29	java/io/FileInputStream
    //   24: dup
    //   25: aload 4
    //   27: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore 5
    //   38: aload 5
    //   40: astore 4
    //   42: aload 5
    //   44: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 6
    //   49: aload 5
    //   51: astore 4
    //   53: aload 6
    //   55: aload 6
    //   57: bipush 58
    //   59: invokevirtual 48	java/lang/String:indexOf	(I)I
    //   62: iconst_1
    //   63: iadd
    //   64: aload 6
    //   66: bipush 107
    //   68: invokevirtual 48	java/lang/String:indexOf	(I)I
    //   71: invokevirtual 52	java/lang/String:substring	(II)Ljava/lang/String;
    //   74: invokevirtual 55	java/lang/String:trim	()Ljava/lang/String;
    //   77: invokestatic 61	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   80: lstore_2
    //   81: lload_2
    //   82: ldc2_w 62
    //   85: lmul
    //   86: lstore_2
    //   87: lload_2
    //   88: lstore_0
    //   89: aload 5
    //   91: ifnull +10 -> 101
    //   94: aload 5
    //   96: invokevirtual 66	java/io/BufferedReader:close	()V
    //   99: lload_2
    //   100: lstore_0
    //   101: lload_0
    //   102: lreturn
    //   103: astore 4
    //   105: ldc 68
    //   107: new 70	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   114: ldc 73
    //   116: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: invokevirtual 80	java/io/IOException:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 89	dov/com/qq/im/ae/util/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 4
    //   135: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   138: lload_2
    //   139: lreturn
    //   140: astore 6
    //   142: aconst_null
    //   143: astore 5
    //   145: aload 5
    //   147: astore 4
    //   149: aload 6
    //   151: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   154: aload 5
    //   156: astore 4
    //   158: ldc 68
    //   160: new 70	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   167: ldc 95
    //   169: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 6
    //   174: invokevirtual 96	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 89	dov/com/qq/im/ae/util/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 5
    //   188: ifnull -87 -> 101
    //   191: aload 5
    //   193: invokevirtual 66	java/io/BufferedReader:close	()V
    //   196: lconst_0
    //   197: lreturn
    //   198: astore 4
    //   200: ldc 68
    //   202: new 70	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   209: ldc 73
    //   211: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 4
    //   216: invokevirtual 80	java/io/IOException:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 89	dov/com/qq/im/ae/util/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 4
    //   230: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   233: lconst_0
    //   234: lreturn
    //   235: astore 5
    //   237: aconst_null
    //   238: astore 4
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 66	java/io/BufferedReader:close	()V
    //   250: aload 5
    //   252: athrow
    //   253: astore 4
    //   255: ldc 68
    //   257: new 70	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   264: ldc 73
    //   266: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 4
    //   271: invokevirtual 80	java/io/IOException:getMessage	()Ljava/lang/String;
    //   274: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 89	dov/com/qq/im/ae/util/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 4
    //   285: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   288: goto -38 -> 250
    //   291: astore 5
    //   293: goto -53 -> 240
    //   296: astore 6
    //   298: goto -153 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	101	0	l1	long
    //   80	59	2	l2	long
    //   11	41	4	localObject1	Object
    //   103	31	4	localIOException1	java.io.IOException
    //   147	10	4	localObject2	Object
    //   198	31	4	localIOException2	java.io.IOException
    //   238	8	4	localObject3	Object
    //   253	31	4	localIOException3	java.io.IOException
    //   36	156	5	localBufferedReader	java.io.BufferedReader
    //   235	16	5	localObject4	Object
    //   291	1	5	localObject5	Object
    //   47	18	6	str	java.lang.String
    //   140	33	6	localException1	java.lang.Exception
    //   296	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   94	99	103	java/io/IOException
    //   13	38	140	java/lang/Exception
    //   191	196	198	java/io/IOException
    //   13	38	235	finally
    //   245	250	253	java/io/IOException
    //   42	49	291	finally
    //   53	81	291	finally
    //   149	154	291	finally
    //   158	186	291	finally
    //   42	49	296	java/lang/Exception
    //   53	81	296	java/lang/Exception
  }
  
  public static long a(Context paramContext)
  {
    if (a != 0L) {
      return a;
    }
    ActivityManager.MemoryInfo localMemoryInfo;
    if (Build.VERSION.SDK_INT > 16)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
    }
    for (a = localMemoryInfo.totalMem;; a = a()) {
      return a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.SystemUtil
 * JD-Core Version:    0.7.0.1
 */