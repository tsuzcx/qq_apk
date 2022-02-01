package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class m
{
  private static m a;
  private static Context b;
  
  static m a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new m();
        }
      }
      finally {}
    }
    b = paramContext.getApplicationContext();
    return a;
  }
  
  /* Error */
  private Properties e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_2
    //   8: astore_1
    //   9: aload_0
    //   10: invokevirtual 35	com/tencent/smtt/sdk/m:a	()Ljava/io/File;
    //   13: astore 6
    //   15: aload_2
    //   16: astore_1
    //   17: new 37	java/util/Properties
    //   20: dup
    //   21: invokespecial 38	java/util/Properties:<init>	()V
    //   24: astore 4
    //   26: aload_3
    //   27: astore_1
    //   28: aload 6
    //   30: ifnull +48 -> 78
    //   33: aload_2
    //   34: astore_1
    //   35: new 40	java/io/BufferedInputStream
    //   38: dup
    //   39: new 42	java/io/FileInputStream
    //   42: dup
    //   43: aload 6
    //   45: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: invokespecial 48	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_2
    //   52: aload 4
    //   54: aload_2
    //   55: invokevirtual 51	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   58: aload_2
    //   59: astore_1
    //   60: goto +18 -> 78
    //   63: astore_1
    //   64: goto +73 -> 137
    //   67: astore_3
    //   68: goto +44 -> 112
    //   71: astore_3
    //   72: aload 5
    //   74: astore_2
    //   75: goto +37 -> 112
    //   78: aload_1
    //   79: ifnull +15 -> 94
    //   82: aload_1
    //   83: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   86: aload 4
    //   88: areturn
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   94: aload 4
    //   96: areturn
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: aload_3
    //   101: astore_1
    //   102: goto +35 -> 137
    //   105: astore_3
    //   106: aconst_null
    //   107: astore 4
    //   109: aload 5
    //   111: astore_2
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   118: aload_2
    //   119: ifnull +15 -> 134
    //   122: aload_2
    //   123: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   126: aload 4
    //   128: areturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   134: aload 4
    //   136: areturn
    //   137: aload_2
    //   138: ifnull +15 -> 153
    //   141: aload_2
    //   142: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   145: goto +8 -> 153
    //   148: astore_2
    //   149: aload_2
    //   150: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	m
    //   8	52	1	localObject1	Object
    //   63	20	1	localObject2	Object
    //   89	10	1	localIOException1	IOException
    //   101	13	1	localObject3	Object
    //   129	25	1	localIOException2	IOException
    //   1	141	2	localObject4	Object
    //   148	2	2	localIOException3	IOException
    //   6	21	3	localObject5	Object
    //   67	1	3	localException1	java.lang.Exception
    //   71	1	3	localException2	java.lang.Exception
    //   97	4	3	localObject6	Object
    //   105	10	3	localException3	java.lang.Exception
    //   24	111	4	localProperties	Properties
    //   3	107	5	localObject7	Object
    //   13	31	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	58	63	finally
    //   52	58	67	java/lang/Exception
    //   35	52	71	java/lang/Exception
    //   82	86	89	java/io/IOException
    //   9	15	97	finally
    //   17	26	97	finally
    //   35	52	97	finally
    //   114	118	97	finally
    //   9	15	105	java/lang/Exception
    //   17	26	105	java/lang/Exception
    //   122	126	129	java/io/IOException
    //   141	145	148	java/io/IOException
  }
  
  File a()
  {
    p.a();
    File localFile = new File(p.s(b), "tbscoreinstall.txt");
    if (!localFile.exists()) {
      try
      {
        localFile.createNewFile();
        return localFile;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return null;
      }
    }
    return localIOException;
  }
  
  void a(int paramInt)
  {
    a("dexopt_retry_num", paramInt);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a("copy_core_ver", paramInt1);
    a("copy_status", paramInt2);
  }
  
  void a(String paramString)
  {
    a("install_apk_path", paramString);
  }
  
  void a(String paramString, int paramInt)
  {
    a(paramString, String.valueOf(paramInt));
  }
  
  /* Error */
  void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 6
    //   11: astore_3
    //   12: aload_0
    //   13: invokespecial 106	com/tencent/smtt/sdk/m:e	()Ljava/util/Properties;
    //   16: astore 7
    //   18: aload 5
    //   20: astore_3
    //   21: aload 7
    //   23: ifnull +96 -> 119
    //   26: aload 6
    //   28: astore_3
    //   29: aload 7
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 110	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   36: pop
    //   37: aload 6
    //   39: astore_3
    //   40: aload_0
    //   41: invokevirtual 35	com/tencent/smtt/sdk/m:a	()Ljava/io/File;
    //   44: astore_2
    //   45: aload 5
    //   47: astore_3
    //   48: aload_2
    //   49: ifnull +70 -> 119
    //   52: aload 6
    //   54: astore_3
    //   55: new 112	java/io/FileOutputStream
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: astore_2
    //   64: new 115	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   71: astore_3
    //   72: aload_3
    //   73: ldc 118
    //   75: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: ldc 124
    //   88: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 7
    //   94: aload_2
    //   95: aload_3
    //   96: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 132	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   102: aload_2
    //   103: astore_3
    //   104: goto +15 -> 119
    //   107: astore_1
    //   108: goto +51 -> 159
    //   111: astore_3
    //   112: aload_2
    //   113: astore_1
    //   114: aload_3
    //   115: astore_2
    //   116: goto +28 -> 144
    //   119: aload_3
    //   120: ifnull +38 -> 158
    //   123: aload_3
    //   124: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   127: return
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   133: return
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: goto +22 -> 159
    //   140: astore_2
    //   141: aload 4
    //   143: astore_1
    //   144: aload_1
    //   145: astore_3
    //   146: aload_2
    //   147: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: aload_2
    //   160: ifnull +15 -> 175
    //   163: aload_2
    //   164: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   167: goto +8 -> 175
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 57	java/io/IOException:printStackTrace	()V
    //   175: aload_1
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	m
    //   0	177	1	paramString1	String
    //   0	177	2	paramString2	String
    //   11	93	3	localObject1	Object
    //   111	25	3	localException	java.lang.Exception
    //   145	1	3	str	String
    //   4	138	4	localObject2	Object
    //   7	39	5	localObject3	Object
    //   1	52	6	localObject4	Object
    //   16	77	7	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   64	102	107	finally
    //   64	102	111	java/lang/Exception
    //   123	127	128	java/io/IOException
    //   154	158	128	java/io/IOException
    //   12	18	134	finally
    //   29	37	134	finally
    //   40	45	134	finally
    //   55	64	134	finally
    //   146	150	134	finally
    //   12	18	140	java/lang/Exception
    //   29	37	140	java/lang/Exception
    //   40	45	140	java/lang/Exception
    //   55	64	140	java/lang/Exception
    //   163	167	170	java/io/IOException
  }
  
  int b()
  {
    return c("install_core_ver");
  }
  
  int b(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return -1;
  }
  
  void b(int paramInt)
  {
    a("unzip_retry_num", paramInt);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    a("tpatch_ver", paramInt1);
    a("tpatch_status", paramInt2);
  }
  
  int c()
  {
    return b("install_status");
  }
  
  int c(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return 0;
  }
  
  void c(int paramInt)
  {
    a("incrupdate_status", paramInt);
  }
  
  void c(int paramInt1, int paramInt2)
  {
    a("install_core_ver", paramInt1);
    a("install_status", paramInt2);
  }
  
  int d()
  {
    return b("incrupdate_status");
  }
  
  String d(String paramString)
  {
    Properties localProperties = e();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return localProperties.getProperty(paramString);
    }
    return null;
  }
  
  void d(int paramInt)
  {
    a("unlzma_status", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.m
 * JD-Core Version:    0.7.0.1
 */