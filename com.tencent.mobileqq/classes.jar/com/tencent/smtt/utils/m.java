package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class m
{
  private static m e = null;
  public boolean a = false;
  private Context b = null;
  private File c = null;
  private boolean d = false;
  private File f = null;
  
  private m(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    b();
  }
  
  public static m a()
  {
    try
    {
      m localm = e;
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new m(paramContext);
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
          break label94;
        }
        if (!this.c.isDirectory()) {
          return null;
        }
      }
      File localFile2 = new File(this.c, "debug.conf");
      localFile1 = localFile2;
      if (localFile2 != null)
      {
        localFile1 = localFile2;
        if (!localFile2.exists())
        {
          localFile2.createNewFile();
          localFile1 = localFile2;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        File localFile1;
        localThrowable.printStackTrace();
        Object localObject = null;
      }
    }
    return localFile1;
    label94:
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
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aload_2
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 33	com/tencent/smtt/utils/m:f	Ljava/io/File;
    //   12: ifnonnull +13 -> 25
    //   15: aload_2
    //   16: astore_1
    //   17: aload_0
    //   18: aload_0
    //   19: invokespecial 83	com/tencent/smtt/utils/m:d	()Ljava/io/File;
    //   22: putfield 33	com/tencent/smtt/utils/m:f	Ljava/io/File;
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 33	com/tencent/smtt/utils/m:f	Ljava/io/File;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +31 -> 66
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 85	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   58: goto -8 -> 50
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: aload_2
    //   67: astore_1
    //   68: new 89	java/io/BufferedInputStream
    //   71: dup
    //   72: new 91	java/io/FileInputStream
    //   75: dup
    //   76: aload_0
    //   77: getfield 33	com/tencent/smtt/utils/m:f	Ljava/io/File;
    //   80: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 97	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_2
    //   87: new 99	java/util/Properties
    //   90: dup
    //   91: invokespecial 100	java/util/Properties:<init>	()V
    //   94: astore_1
    //   95: aload_1
    //   96: aload_2
    //   97: invokevirtual 103	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   100: aload_1
    //   101: ldc 105
    //   103: ldc 107
    //   105: invokevirtual 111	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_1
    //   109: ldc 107
    //   111: aload_1
    //   112: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +11 -> 126
    //   118: aload_0
    //   119: aload_1
    //   120: invokestatic 123	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   123: putfield 29	com/tencent/smtt/utils/m:a	Z
    //   126: aload_2
    //   127: ifnull -77 -> 50
    //   130: aload_2
    //   131: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   134: goto -84 -> 50
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   142: goto -92 -> 50
    //   145: astore_1
    //   146: aload_3
    //   147: astore_2
    //   148: aload_1
    //   149: astore_3
    //   150: aload_2
    //   151: astore_1
    //   152: aload_3
    //   153: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull -107 -> 50
    //   160: aload_2
    //   161: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   164: goto -114 -> 50
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   172: goto -122 -> 50
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore_1
    //   199: goto -19 -> 180
    //   202: astore_3
    //   203: goto -53 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	m
    //   7	20	1	localObject1	Object
    //   53	2	1	localException1	java.lang.Exception
    //   61	4	1	localObject2	Object
    //   67	53	1	localObject3	Object
    //   137	2	1	localException2	java.lang.Exception
    //   145	4	1	localThrowable1	Throwable
    //   151	1	1	localObject4	Object
    //   167	10	1	localException3	java.lang.Exception
    //   179	10	1	localObject5	Object
    //   198	1	1	localObject6	Object
    //   3	182	2	localObject7	Object
    //   190	2	2	localException4	java.lang.Exception
    //   5	148	3	localObject8	Object
    //   175	4	3	localObject9	Object
    //   202	1	3	localThrowable2	Throwable
    //   31	3	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   42	50	53	java/lang/Exception
    //   42	50	61	finally
    //   54	58	61	finally
    //   130	134	61	finally
    //   138	142	61	finally
    //   160	164	61	finally
    //   168	172	61	finally
    //   184	188	61	finally
    //   188	190	61	finally
    //   191	195	61	finally
    //   130	134	137	java/lang/Exception
    //   8	15	145	java/lang/Throwable
    //   17	25	145	java/lang/Throwable
    //   27	33	145	java/lang/Throwable
    //   68	87	145	java/lang/Throwable
    //   160	164	167	java/lang/Exception
    //   8	15	175	finally
    //   17	25	175	finally
    //   27	33	175	finally
    //   68	87	175	finally
    //   152	156	175	finally
    //   184	188	190	java/lang/Exception
    //   87	126	198	finally
    //   87	126	202	java/lang/Throwable
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 83	com/tencent/smtt/utils/m:d	()Ljava/io/File;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnonnull +33 -> 45
    //   15: new 85	java/lang/NullPointerException
    //   18: dup
    //   19: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   22: athrow
    //   23: new 85	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   36: goto -13 -> 23
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   44: return
    //   45: new 89	java/io/BufferedInputStream
    //   48: dup
    //   49: new 91	java/io/FileInputStream
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 97	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_2
    //   62: new 99	java/util/Properties
    //   65: dup
    //   66: invokespecial 100	java/util/Properties:<init>	()V
    //   69: astore 4
    //   71: aload 4
    //   73: aload_2
    //   74: invokevirtual 103	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload 4
    //   79: ldc 105
    //   81: aload_0
    //   82: getfield 29	com/tencent/smtt/utils/m:a	Z
    //   85: invokestatic 130	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   88: invokevirtual 134	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   91: pop
    //   92: aload 4
    //   94: ldc 136
    //   96: aload_0
    //   97: getfield 31	com/tencent/smtt/utils/m:d	Z
    //   100: invokestatic 130	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   103: invokevirtual 134	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   106: pop
    //   107: new 138	java/io/BufferedOutputStream
    //   110: dup
    //   111: new 140	java/io/FileOutputStream
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: invokespecial 144	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   123: astore_1
    //   124: aload 4
    //   126: aload_1
    //   127: aconst_null
    //   128: invokevirtual 148	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   131: aload_2
    //   132: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   135: aload_1
    //   136: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   139: return
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   145: return
    //   146: astore_2
    //   147: aload_2
    //   148: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   151: goto -16 -> 135
    //   154: astore_3
    //   155: aconst_null
    //   156: astore 4
    //   158: aload_1
    //   159: astore_2
    //   160: aload 4
    //   162: astore_1
    //   163: aload_3
    //   164: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   167: aload_2
    //   168: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   171: aload_1
    //   172: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   175: return
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   181: return
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   187: goto -16 -> 171
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   197: aload_3
    //   198: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   208: goto -11 -> 197
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   216: goto -15 -> 201
    //   219: astore_1
    //   220: goto -27 -> 193
    //   223: astore 4
    //   225: aload_1
    //   226: astore_3
    //   227: aload 4
    //   229: astore_1
    //   230: goto -37 -> 193
    //   233: astore 4
    //   235: aload_1
    //   236: astore_3
    //   237: aload 4
    //   239: astore_1
    //   240: goto -47 -> 193
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -83 -> 163
    //   249: astore_3
    //   250: goto -87 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	m
    //   3	1	1	localObject1	Object
    //   31	2	1	localException1	java.lang.Exception
    //   39	2	1	localException2	java.lang.Exception
    //   123	13	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   140	19	1	localException3	java.lang.Exception
    //   162	10	1	localObject2	Object
    //   176	2	1	localException4	java.lang.Exception
    //   190	12	1	localObject3	Object
    //   219	7	1	localObject4	Object
    //   229	17	1	localObject5	Object
    //   61	71	2	localBufferedInputStream	java.io.BufferedInputStream
    //   146	2	2	localException5	java.lang.Exception
    //   159	9	2	localException6	java.lang.Exception
    //   182	2	2	localException7	java.lang.Exception
    //   192	2	2	localObject6	Object
    //   203	2	2	localException8	java.lang.Exception
    //   211	2	2	localException9	java.lang.Exception
    //   1	1	3	localObject7	Object
    //   154	44	3	localThrowable1	Throwable
    //   226	11	3	localObject8	Object
    //   243	1	3	localThrowable2	Throwable
    //   249	1	3	localThrowable3	Throwable
    //   69	92	4	localProperties	java.util.Properties
    //   223	5	4	localObject9	Object
    //   233	5	4	localObject10	Object
    //   8	108	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   15	23	31	java/lang/Exception
    //   23	31	39	java/lang/Exception
    //   135	139	140	java/lang/Exception
    //   131	135	146	java/lang/Exception
    //   4	10	154	java/lang/Throwable
    //   45	62	154	java/lang/Throwable
    //   171	175	176	java/lang/Exception
    //   167	171	182	java/lang/Exception
    //   4	10	190	finally
    //   45	62	190	finally
    //   193	197	203	java/lang/Exception
    //   197	201	211	java/lang/Exception
    //   62	124	219	finally
    //   124	131	223	finally
    //   163	167	233	finally
    //   62	124	243	java/lang/Throwable
    //   124	131	249	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */