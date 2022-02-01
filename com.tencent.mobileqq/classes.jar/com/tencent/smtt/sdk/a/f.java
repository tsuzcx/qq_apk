package com.tencent.smtt.sdk.a;

import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class f
{
  private static String a = "EmergencyManager";
  private final File b;
  private final FileOutputStream c;
  private final FileLock d;
  
  private f(File paramFile, FileOutputStream paramFileOutputStream, FileLock paramFileLock)
  {
    this.b = paramFile;
    this.c = paramFileOutputStream;
    this.d = paramFileLock;
  }
  
  /* Error */
  public static f a(File paramFile)
  {
    // Byte code:
    //   0: new 34	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 37	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 41	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: invokevirtual 47	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +113 -> 133
    //   23: aload_2
    //   24: astore_1
    //   25: getstatic 49	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   28: astore 4
    //   30: aload_2
    //   31: astore_1
    //   32: new 51	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   39: astore 5
    //   41: aload_2
    //   42: astore_1
    //   43: aload 5
    //   45: ldc 54
    //   47: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: astore_1
    //   53: aload 5
    //   55: aload_0
    //   56: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_2
    //   64: astore_1
    //   65: aload 4
    //   67: aload 5
    //   69: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 73	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_2
    //   76: astore_1
    //   77: new 2	com/tencent/smtt/sdk/a/f
    //   80: dup
    //   81: aload_0
    //   82: aload_2
    //   83: aload_3
    //   84: invokespecial 75	com/tencent/smtt/sdk/a/f:<init>	(Ljava/io/File;Ljava/io/FileOutputStream;Ljava/nio/channels/FileLock;)V
    //   87: astore_3
    //   88: aload_2
    //   89: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   92: aload_3
    //   93: areturn
    //   94: astore_0
    //   95: getstatic 49	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   98: astore_1
    //   99: new 51	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   106: astore_2
    //   107: aload_2
    //   108: ldc 80
    //   110: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_2
    //   115: aload_0
    //   116: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   119: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: aload_2
    //   125: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_3
    //   132: areturn
    //   133: aload_2
    //   134: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_2
    //   140: getstatic 49	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   143: astore_0
    //   144: new 51	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   151: astore_1
    //   152: aload_1
    //   153: ldc 80
    //   155: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: aload_2
    //   161: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_3
    //   179: goto +12 -> 191
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_1
    //   185: goto +109 -> 294
    //   188: astore_3
    //   189: aconst_null
    //   190: astore_2
    //   191: aload_2
    //   192: astore_1
    //   193: getstatic 49	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   196: astore 4
    //   198: aload_2
    //   199: astore_1
    //   200: new 51	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   207: astore 5
    //   209: aload_2
    //   210: astore_1
    //   211: aload 5
    //   213: ldc 88
    //   215: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_2
    //   220: astore_1
    //   221: aload 5
    //   223: aload_0
    //   224: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   227: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_2
    //   232: astore_1
    //   233: aload 5
    //   235: ldc 90
    //   237: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_2
    //   242: astore_1
    //   243: aload 5
    //   245: aload_3
    //   246: invokevirtual 91	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   249: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_2
    //   254: astore_1
    //   255: aload 4
    //   257: aload 5
    //   259: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_2
    //   266: ifnull +25 -> 291
    //   269: aload_2
    //   270: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_2
    //   276: getstatic 49	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   279: astore_0
    //   280: new 51	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   287: astore_1
    //   288: goto -136 -> 152
    //   291: aconst_null
    //   292: areturn
    //   293: astore_0
    //   294: aload_1
    //   295: ifnull +47 -> 342
    //   298: aload_1
    //   299: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   302: goto +40 -> 342
    //   305: astore_1
    //   306: getstatic 49	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   309: astore_2
    //   310: new 51	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   317: astore_3
    //   318: aload_3
    //   319: ldc 80
    //   321: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_3
    //   326: aload_1
    //   327: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: aload_3
    //   336: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: goto +5 -> 347
    //   345: aload_0
    //   346: athrow
    //   347: goto -2 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramFile	File
    //   10	289	1	localObject1	Object
    //   305	22	1	localIOException1	IOException
    //   8	126	2	localObject2	Object
    //   139	22	2	localIOException2	IOException
    //   190	80	2	localObject3	Object
    //   275	1	2	localIOException3	IOException
    //   309	26	2	str1	String
    //   18	114	3	localObject4	Object
    //   178	1	3	localThrowable1	java.lang.Throwable
    //   188	58	3	localThrowable2	java.lang.Throwable
    //   317	19	3	localStringBuilder1	StringBuilder
    //   28	228	4	str2	String
    //   39	219	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   88	92	94	java/io/IOException
    //   133	137	139	java/io/IOException
    //   11	19	178	java/lang/Throwable
    //   25	30	178	java/lang/Throwable
    //   32	41	178	java/lang/Throwable
    //   43	51	178	java/lang/Throwable
    //   53	63	178	java/lang/Throwable
    //   65	75	178	java/lang/Throwable
    //   77	88	178	java/lang/Throwable
    //   0	9	182	finally
    //   0	9	188	java/lang/Throwable
    //   269	273	275	java/io/IOException
    //   11	19	293	finally
    //   25	30	293	finally
    //   32	41	293	finally
    //   43	51	293	finally
    //   53	63	293	finally
    //   65	75	293	finally
    //   77	88	293	finally
    //   193	198	293	finally
    //   200	209	293	finally
    //   211	219	293	finally
    //   221	231	293	finally
    //   233	241	293	finally
    //   243	253	293	finally
    //   255	265	293	finally
    //   298	302	305	java/io/IOException
  }
  
  public void a()
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Deleting lock file: ");
    localStringBuilder.append(this.b.getAbsolutePath());
    TbsLog.i((String)localObject, localStringBuilder.toString());
    this.d.release();
    this.c.close();
    if (this.b.delete()) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to delete lock file: ");
    ((StringBuilder)localObject).append(this.b.getAbsolutePath());
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public void b()
  {
    try
    {
      a();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */