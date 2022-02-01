package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class o
{
  private static o e;
  public boolean a = false;
  private Context b = null;
  private File c = null;
  private boolean d = false;
  private File f = null;
  
  private o(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    b();
  }
  
  public static o a()
  {
    try
    {
      o localo = e;
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static o a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new o(paramContext);
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
    //   10: getfield 31	com/tencent/smtt/utils/o:f	Ljava/io/File;
    //   13: ifnonnull +13 -> 26
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: aload_0
    //   20: invokespecial 83	com/tencent/smtt/utils/o:d	()Ljava/io/File;
    //   23: putfield 31	com/tencent/smtt/utils/o:f	Ljava/io/File;
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 31	com/tencent/smtt/utils/o:f	Ljava/io/File;
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
    //   51: getfield 31	com/tencent/smtt/utils/o:f	Ljava/io/File;
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
    //   97: putfield 27	com/tencent/smtt/utils/o:a	Z
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
    //   0	191	0	this	o
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
    //   3: astore 5
    //   5: aload_0
    //   6: invokespecial 83	com/tencent/smtt/utils/o:d	()Ljava/io/File;
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
    //   56: astore 4
    //   58: new 95	java/util/Properties
    //   61: dup
    //   62: invokespecial 96	java/util/Properties:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: aload 4
    //   69: invokevirtual 99	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   72: aload_3
    //   73: ldc 101
    //   75: aload_0
    //   76: getfield 27	com/tencent/smtt/utils/o:a	Z
    //   79: invokestatic 130	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   82: invokevirtual 134	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   85: pop
    //   86: aload_3
    //   87: ldc 136
    //   89: aload_0
    //   90: getfield 29	com/tencent/smtt/utils/o:d	Z
    //   93: invokestatic 130	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   96: invokevirtual 134	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   99: pop
    //   100: new 138	java/io/BufferedOutputStream
    //   103: dup
    //   104: new 140	java/io/FileOutputStream
    //   107: dup
    //   108: aload_1
    //   109: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   112: invokespecial 144	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   115: astore_1
    //   116: aload_3
    //   117: aload_1
    //   118: aconst_null
    //   119: invokevirtual 148	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   122: aload 4
    //   124: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   127: goto +8 -> 135
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   135: aload_1
    //   136: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   139: return
    //   140: astore_3
    //   141: aload_1
    //   142: astore_2
    //   143: aload_3
    //   144: astore_1
    //   145: aload 4
    //   147: astore_3
    //   148: goto +71 -> 219
    //   151: astore_3
    //   152: goto +13 -> 165
    //   155: astore_1
    //   156: aload 4
    //   158: astore_3
    //   159: goto +60 -> 219
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_1
    //   165: aload 4
    //   167: astore_2
    //   168: goto +15 -> 183
    //   171: astore_1
    //   172: aconst_null
    //   173: astore_3
    //   174: goto +45 -> 219
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_1
    //   180: aload 5
    //   182: astore_2
    //   183: aload_3
    //   184: invokevirtual 76	java/lang/Throwable:printStackTrace	()V
    //   187: aload_2
    //   188: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   191: goto +8 -> 199
    //   194: astore_2
    //   195: aload_2
    //   196: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   199: aload_1
    //   200: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   203: return
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   209: return
    //   210: astore 4
    //   212: aload_2
    //   213: astore_3
    //   214: aload_1
    //   215: astore_2
    //   216: aload 4
    //   218: astore_1
    //   219: aload_3
    //   220: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   223: goto +8 -> 231
    //   226: astore_3
    //   227: aload_3
    //   228: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   231: aload_2
    //   232: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   235: goto +8 -> 243
    //   238: astore_2
    //   239: aload_2
    //   240: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   243: aload_1
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	o
    //   9	2	1	localFile	File
    //   22	2	1	localException1	java.lang.Exception
    //   35	74	1	localException2	java.lang.Exception
    //   115	30	1	localObject1	Object
    //   155	1	1	localObject2	Object
    //   164	1	1	localObject3	Object
    //   171	1	1	localObject4	Object
    //   179	21	1	localObject5	Object
    //   204	11	1	localException3	java.lang.Exception
    //   218	26	1	localObject6	Object
    //   1	1	2	localObject7	Object
    //   130	2	2	localException4	java.lang.Exception
    //   142	46	2	localObject8	Object
    //   194	19	2	localException5	java.lang.Exception
    //   215	17	2	localObject9	Object
    //   238	2	2	localException6	java.lang.Exception
    //   65	52	3	localProperties	java.util.Properties
    //   140	4	3	localObject10	Object
    //   147	1	3	localBufferedInputStream1	java.io.BufferedInputStream
    //   151	1	3	localThrowable1	Throwable
    //   158	1	3	localBufferedInputStream2	java.io.BufferedInputStream
    //   162	1	3	localThrowable2	Throwable
    //   173	1	3	localObject11	Object
    //   177	7	3	localThrowable3	Throwable
    //   213	7	3	localException7	java.lang.Exception
    //   226	2	3	localException8	java.lang.Exception
    //   56	110	4	localBufferedInputStream3	java.io.BufferedInputStream
    //   210	7	4	localObject12	Object
    //   3	178	5	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	22	java/lang/Exception
    //   27	35	35	java/lang/Exception
    //   122	127	130	java/lang/Exception
    //   116	122	140	finally
    //   116	122	151	java/lang/Throwable
    //   58	116	155	finally
    //   58	116	162	java/lang/Throwable
    //   5	10	171	finally
    //   41	58	171	finally
    //   5	10	177	java/lang/Throwable
    //   41	58	177	java/lang/Throwable
    //   187	191	194	java/lang/Exception
    //   135	139	204	java/lang/Exception
    //   199	203	204	java/lang/Exception
    //   183	187	210	finally
    //   219	223	226	java/lang/Exception
    //   231	235	238	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.o
 * JD-Core Version:    0.7.0.1
 */