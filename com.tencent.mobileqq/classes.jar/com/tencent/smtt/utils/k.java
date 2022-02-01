package com.tencent.smtt.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

public class k
  implements Runnable
{
  public static String a = "TBSFileLock";
  private static Object f = new Object();
  private static Object g = new Object();
  private static HashMap<k, Object> h = null;
  private static Handler i = null;
  File b = null;
  RandomAccessFile c = null;
  FileLock d = null;
  long e = 0L;
  
  public k(File paramFile, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".lock");
    this.b = new File(paramFile, localStringBuilder.toString());
  }
  
  Handler a()
  {
    if (i == null) {
      try
      {
        if (i == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("QBFileLock.Thread");
          localHandlerThread.start();
          i = new Handler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return i;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>> release lock: ");
      localStringBuilder.append(this.b.getName());
      Log.d((String)localObject1, localStringBuilder.toString());
      localObject1 = this.d;
      if (localObject1 != null)
      {
        try
        {
          this.d.release();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        this.d = null;
      }
      RandomAccessFile localRandomAccessFile = this.c;
      if (localRandomAccessFile != null)
      {
        try
        {
          this.c.close();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        this.c = null;
      }
      if ((i != null) && (this.e > 0L)) {
        i.removeCallbacks(this);
      }
      if (paramBoolean) {
        d();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new 113	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_0
    //   8: getfield 43	com/tencent/smtt/utils/k:b	Ljava/io/File;
    //   11: ldc 126
    //   13: invokespecial 127	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: putfield 45	com/tencent/smtt/utils/k:c	Ljava/io/RandomAccessFile;
    //   19: goto +12 -> 31
    //   22: astore_3
    //   23: goto +221 -> 244
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   31: aload_0
    //   32: getfield 45	com/tencent/smtt/utils/k:c	Ljava/io/RandomAccessFile;
    //   35: ifnull +195 -> 230
    //   38: aload_0
    //   39: getfield 45	com/tencent/smtt/utils/k:c	Ljava/io/RandomAccessFile;
    //   42: invokevirtual 131	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +181 -> 230
    //   52: aload_0
    //   53: getfield 49	com/tencent/smtt/utils/k:e	J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +16 -> 74
    //   61: aload_0
    //   62: invokevirtual 133	com/tencent/smtt/utils/k:a	()Landroid/os/Handler;
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 49	com/tencent/smtt/utils/k:e	J
    //   70: invokevirtual 137	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   73: pop
    //   74: aconst_null
    //   75: astore 4
    //   77: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   80: lstore_1
    //   81: aload 6
    //   83: invokevirtual 149	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   86: astore 5
    //   88: aload 5
    //   90: astore_3
    //   91: aload 5
    //   93: ifnull +26 -> 119
    //   96: aload 5
    //   98: astore_3
    //   99: goto +63 -> 162
    //   102: astore_3
    //   103: aload_3
    //   104: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   107: getstatic 93	com/tencent/smtt/utils/k:a	Ljava/lang/String;
    //   110: ldc 151
    //   112: invokestatic 103	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload 4
    //   118: astore_3
    //   119: ldc2_w 152
    //   122: invokestatic 159	java/lang/Thread:sleep	(J)V
    //   125: goto +10 -> 135
    //   128: astore 4
    //   130: aload 4
    //   132: invokevirtual 160	java/lang/InterruptedException:printStackTrace	()V
    //   135: aload_3
    //   136: astore 4
    //   138: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   141: lload_1
    //   142: lsub
    //   143: invokestatic 166	java/lang/Math:abs	(J)J
    //   146: ldc2_w 167
    //   149: lcmp
    //   150: iflt -69 -> 81
    //   153: getstatic 93	com/tencent/smtt/utils/k:a	Ljava/lang/String;
    //   156: ldc 170
    //   158: invokestatic 103	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   161: pop
    //   162: aload_0
    //   163: aload_3
    //   164: putfield 47	com/tencent/smtt/utils/k:d	Ljava/nio/channels/FileLock;
    //   167: getstatic 93	com/tencent/smtt/utils/k:a	Ljava/lang/String;
    //   170: astore_3
    //   171: new 51	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   178: astore 4
    //   180: aload 4
    //   182: ldc 172
    //   184: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 4
    //   190: aload_0
    //   191: getfield 43	com/tencent/smtt/utils/k:b	Ljava/io/File;
    //   194: invokevirtual 98	java/io/File:getName	()Ljava/lang/String;
    //   197: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 4
    //   203: ldc 174
    //   205: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 4
    //   211: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   214: lload_1
    //   215: lsub
    //   216: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_3
    //   221: aload 4
    //   223: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 103	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   229: pop
    //   230: aload_0
    //   231: getfield 47	com/tencent/smtt/utils/k:d	Ljava/nio/channels/FileLock;
    //   234: ifnull +7 -> 241
    //   237: aload_0
    //   238: invokevirtual 179	com/tencent/smtt/utils/k:c	()V
    //   241: aload_0
    //   242: monitorexit
    //   243: return
    //   244: aload_0
    //   245: monitorexit
    //   246: goto +5 -> 251
    //   249: aload_3
    //   250: athrow
    //   251: goto -2 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	k
    //   80	135	1	l	long
    //   22	1	3	localObject1	Object
    //   26	2	3	localException1	Exception
    //   90	9	3	localObject2	Object
    //   102	2	3	localException2	Exception
    //   118	132	3	localObject3	Object
    //   75	42	4	localObject4	Object
    //   128	3	4	localInterruptedException	java.lang.InterruptedException
    //   136	86	4	localObject5	Object
    //   86	11	5	localFileLock	FileLock
    //   45	37	6	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   2	19	22	finally
    //   27	31	22	finally
    //   31	47	22	finally
    //   52	74	22	finally
    //   77	81	22	finally
    //   81	88	22	finally
    //   103	116	22	finally
    //   119	125	22	finally
    //   130	135	22	finally
    //   138	162	22	finally
    //   162	230	22	finally
    //   230	241	22	finally
    //   2	19	26	java/lang/Exception
    //   81	88	102	java/lang/Exception
    //   119	125	128	java/lang/InterruptedException
  }
  
  void c()
  {
    synchronized (g)
    {
      if (h == null) {
        h = new HashMap();
      }
      h.put(this, f);
      return;
    }
  }
  
  void d()
  {
    synchronized (g)
    {
      if (h == null) {
        return;
      }
      h.remove(this);
      return;
    }
  }
  
  public void e()
  {
    a(true);
  }
  
  public void run()
  {
    Log.d(a, ">>> releaseLock on TimeOut");
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.k
 * JD-Core Version:    0.7.0.1
 */