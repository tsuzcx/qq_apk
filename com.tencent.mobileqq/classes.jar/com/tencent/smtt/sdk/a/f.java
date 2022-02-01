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
    //   0: new 36	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 39	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 43	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: invokevirtual 49	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +87 -> 107
    //   23: aload_2
    //   24: astore_1
    //   25: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   28: new 51	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   35: ldc 54
    //   37: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 73	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_2
    //   54: astore_1
    //   55: new 2	com/tencent/smtt/sdk/a/f
    //   58: dup
    //   59: aload_0
    //   60: aload_2
    //   61: aload_3
    //   62: invokespecial 75	com/tencent/smtt/sdk/a/f:<init>	(Ljava/io/File;Ljava/io/FileOutputStream;Ljava/nio/channels/FileLock;)V
    //   65: astore_3
    //   66: aload_2
    //   67: ifnull +7 -> 74
    //   70: aload_2
    //   71: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   74: aload_3
    //   75: areturn
    //   76: astore_0
    //   77: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   80: new 51	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   87: ldc 80
    //   89: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   96: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_3
    //   106: areturn
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   121: new 51	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   128: ldc 80
    //   130: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   137: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: goto -31 -> 115
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_2
    //   152: aload_2
    //   153: astore_1
    //   154: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   157: new 51	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   164: ldc 88
    //   166: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   173: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 90
    //   178: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_3
    //   182: invokevirtual 91	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   185: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_2
    //   195: ifnull -80 -> 115
    //   198: aload_2
    //   199: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   202: goto -87 -> 115
    //   205: astore_0
    //   206: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   209: new 51	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   216: ldc 80
    //   218: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   225: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: goto -119 -> 115
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_1
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 78	java/io/FileOutputStream:close	()V
    //   248: aload_0
    //   249: athrow
    //   250: astore_1
    //   251: getstatic 18	com/tencent/smtt/sdk/a/f:a	Ljava/lang/String;
    //   254: new 51	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   261: ldc 80
    //   263: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   270: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 86	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: goto -31 -> 248
    //   282: astore_0
    //   283: goto -43 -> 240
    //   286: astore_3
    //   287: goto -135 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramFile	File
    //   10	235	1	localFileOutputStream1	FileOutputStream
    //   250	17	1	localIOException	IOException
    //   8	191	2	localFileOutputStream2	FileOutputStream
    //   18	88	3	localObject	Object
    //   149	33	3	localThrowable1	java.lang.Throwable
    //   286	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   70	74	76	java/io/IOException
    //   111	115	117	java/io/IOException
    //   0	9	149	java/lang/Throwable
    //   198	202	205	java/io/IOException
    //   0	9	237	finally
    //   244	248	250	java/io/IOException
    //   11	19	282	finally
    //   25	53	282	finally
    //   55	66	282	finally
    //   154	194	282	finally
    //   11	19	286	java/lang/Throwable
    //   25	53	286	java/lang/Throwable
    //   55	66	286	java/lang/Throwable
  }
  
  public void a()
  {
    TbsLog.i(a, "Deleting lock file: " + this.b.getAbsolutePath());
    this.d.release();
    this.c.close();
    if (!this.b.delete()) {
      throw new IOException("Failed to delete lock file: " + this.b.getAbsolutePath());
    }
  }
  
  public void b()
  {
    try
    {
      a();
      return;
    }
    catch (IOException localIOException)
    {
      TbsLog.e(a, "Failed to release process lock file: " + this.b.getAbsolutePath() + " error: " + localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */