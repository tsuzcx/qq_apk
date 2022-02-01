package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class n
{
  private static n e;
  public boolean a = false;
  private Context b = null;
  private File c = null;
  private boolean d = false;
  private File f = null;
  
  private n(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    b();
  }
  
  public static n a()
  {
    try
    {
      n localn = e;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new n(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  private File d()
  {
    try
    {
      if (this.c == null)
      {
        this.c = new File(QbSdk.getTbsFolderDir(this.b), "core_private");
        if (this.c == null) {
          break label81;
        }
        if (!this.c.isDirectory()) {
          return null;
        }
      }
      File localFile = new File(this.c, "debug.conf");
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return null;
    }
    label81:
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    c();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_2
    //   8: astore_1
    //   9: aload_0
    //   10: getfield 31	com/tencent/smtt/utils/n:f	Ljava/io/File;
    //   13: ifnonnull +13 -> 26
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: aload_0
    //   20: invokespecial 83	com/tencent/smtt/utils/n:d	()Ljava/io/File;
    //   23: putfield 31	com/tencent/smtt/utils/n:f	Ljava/io/File;
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 31	com/tencent/smtt/utils/n:f	Ljava/io/File;
    //   32: astore_3
    //   33: aload_3
    //   34: ifnonnull +6 -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_2
    //   41: astore_1
    //   42: new 85	java/io/BufferedInputStream
    //   45: dup
    //   46: new 87	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: getfield 31	com/tencent/smtt/utils/n:f	Ljava/io/File;
    //   54: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_2
    //   61: new 95	java/util/Properties
    //   64: dup
    //   65: invokespecial 96	java/util/Properties:<init>	()V
    //   68: astore_1
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 99	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   74: aload_1
    //   75: ldc 101
    //   77: ldc 103
    //   79: invokevirtual 107	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_1
    //   83: ldc 103
    //   85: aload_1
    //   86: invokevirtual 113	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +11 -> 100
    //   92: aload_0
    //   93: aload_1
    //   94: invokestatic 119	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   97: putfield 27	com/tencent/smtt/utils/n:a	Z
    //   100: aload_2
    //   101: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   104: goto +56 -> 160
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   112: goto +48 -> 160
    //   115: astore_3
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: astore_2
    //   120: goto +43 -> 163
    //   123: astore_3
    //   124: goto +11 -> 135
    //   127: astore_2
    //   128: goto +35 -> 163
    //   131: astore_3
    //   132: aload 4
    //   134: astore_2
    //   135: aload_2
    //   136: astore_1
    //   137: aload_3
    //   138: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   141: aload_2
    //   142: ifnull +18 -> 160
    //   145: aload_2
    //   146: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   149: goto +11 -> 160
    //   152: astore_1
    //   153: goto +28 -> 181
    //   156: astore_1
    //   157: goto -49 -> 108
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    //   163: aload_1
    //   164: ifnull +15 -> 179
    //   167: aload_1
    //   168: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   171: goto +8 -> 179
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   179: aload_2
    //   180: athrow
    //   181: aload_0
    //   182: monitorexit
    //   183: goto +5 -> 188
    //   186: aload_1
    //   187: athrow
    //   188: goto -2 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	n
    //   8	86	1	localObject1	Object
    //   107	2	1	localException1	java.lang.Exception
    //   117	20	1	localObject2	Object
    //   152	1	1	localObject3	Object
    //   156	12	1	localException2	java.lang.Exception
    //   174	13	1	localException3	java.lang.Exception
    //   6	114	2	localObject4	Object
    //   127	1	2	localObject5	Object
    //   134	46	2	localObject6	Object
    //   32	2	3	localFile	File
    //   115	4	3	localObject7	Object
    //   123	1	3	localThrowable1	Throwable
    //   131	7	3	localThrowable2	Throwable
    //   3	130	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   100	104	107	java/lang/Exception
    //   61	100	115	finally
    //   61	100	123	java/lang/Throwable
    //   9	16	127	finally
    //   18	26	127	finally
    //   28	33	127	finally
    //   42	61	127	finally
    //   137	141	127	finally
    //   9	16	131	java/lang/Throwable
    //   18	26	131	java/lang/Throwable
    //   28	33	131	java/lang/Throwable
    //   42	61	131	java/lang/Throwable
    //   100	104	152	finally
    //   108	112	152	finally
    //   145	149	152	finally
    //   167	171	152	finally
    //   175	179	152	finally
    //   179	181	152	finally
    //   145	149	156	java/lang/Exception
    //   167	171	174	java/lang/Exception
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokespecial 83	com/tencent/smtt/utils/n:d	()Ljava/io/File;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +30 -> 41
    //   14: new 125	java/lang/NullPointerException
    //   17: dup
    //   18: invokespecial 126	java/lang/NullPointerException:<init>	()V
    //   21: athrow
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   27: new 125	java/lang/NullPointerException
    //   30: dup
    //   31: invokespecial 126	java/lang/NullPointerException:<init>	()V
    //   34: athrow
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   40: return
    //   41: new 85	java/io/BufferedInputStream
    //   44: dup
    //   45: new 87	java/io/FileInputStream
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_3
    //   57: new 95	java/util/Properties
    //   60: dup
    //   61: invokespecial 96	java/util/Properties:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 99	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   72: aload 4
    //   74: ldc 101
    //   76: aload_0
    //   77: getfield 27	com/tencent/smtt/utils/n:a	Z
    //   80: invokestatic 130	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   83: invokevirtual 134	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   86: pop
    //   87: aload 4
    //   89: ldc 136
    //   91: aload_0
    //   92: getfield 29	com/tencent/smtt/utils/n:d	Z
    //   95: invokestatic 130	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   98: invokevirtual 134	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   101: pop
    //   102: new 138	java/io/BufferedOutputStream
    //   105: dup
    //   106: new 140	java/io/FileOutputStream
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   114: invokespecial 144	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   117: astore_1
    //   118: aload 4
    //   120: aload_1
    //   121: aconst_null
    //   122: invokevirtual 148	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   125: aload_3
    //   126: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   129: goto +8 -> 137
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   137: aload_1
    //   138: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   141: return
    //   142: astore 4
    //   144: aload_1
    //   145: astore_2
    //   146: aload 4
    //   148: astore_1
    //   149: goto +63 -> 212
    //   152: astore_2
    //   153: goto +10 -> 163
    //   156: astore_1
    //   157: goto +55 -> 212
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: goto +15 -> 178
    //   166: astore_1
    //   167: aconst_null
    //   168: astore_3
    //   169: goto +43 -> 212
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_1
    //   175: aload 4
    //   177: astore_3
    //   178: aload_2
    //   179: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   182: aload_3
    //   183: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   186: goto +8 -> 194
    //   189: astore_2
    //   190: aload_2
    //   191: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   194: aload_1
    //   195: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   198: return
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   204: return
    //   205: astore 4
    //   207: aload_1
    //   208: astore_2
    //   209: aload 4
    //   211: astore_1
    //   212: aload_3
    //   213: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   216: goto +8 -> 224
    //   219: astore_3
    //   220: aload_3
    //   221: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   224: aload_2
    //   225: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   228: goto +8 -> 236
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   236: aload_1
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	n
    //   9	2	1	localFile	File
    //   22	2	1	localException1	java.lang.Exception
    //   35	76	1	localException2	java.lang.Exception
    //   117	32	1	localObject1	Object
    //   156	1	1	localObject2	Object
    //   162	1	1	localObject3	Object
    //   166	1	1	localObject4	Object
    //   174	21	1	localObject5	Object
    //   199	9	1	localException3	java.lang.Exception
    //   211	26	1	localObject6	Object
    //   1	1	2	localObject7	Object
    //   132	2	2	localException4	java.lang.Exception
    //   145	1	2	localObject8	Object
    //   152	1	2	localThrowable1	Throwable
    //   160	1	2	localThrowable2	Throwable
    //   172	7	2	localThrowable3	Throwable
    //   189	2	2	localException5	java.lang.Exception
    //   208	17	2	localObject9	Object
    //   231	2	2	localException6	java.lang.Exception
    //   56	157	3	localObject10	Object
    //   219	2	3	localException7	java.lang.Exception
    //   3	116	4	localProperties	java.util.Properties
    //   142	34	4	localObject11	Object
    //   205	5	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	22	java/lang/Exception
    //   27	35	35	java/lang/Exception
    //   125	129	132	java/lang/Exception
    //   118	125	142	finally
    //   118	125	152	java/lang/Throwable
    //   57	118	156	finally
    //   57	118	160	java/lang/Throwable
    //   5	10	166	finally
    //   41	57	166	finally
    //   5	10	172	java/lang/Throwable
    //   41	57	172	java/lang/Throwable
    //   182	186	189	java/lang/Exception
    //   137	141	199	java/lang/Exception
    //   194	198	199	java/lang/Exception
    //   178	182	205	finally
    //   212	216	219	java/lang/Exception
    //   224	228	231	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */