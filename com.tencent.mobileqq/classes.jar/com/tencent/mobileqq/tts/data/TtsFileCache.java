package com.tencent.mobileqq.tts.data;

import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.MobileQQ;

public class TtsFileCache
  implements IFileCacheDataSource
{
  public static final String a;
  private static final byte[] b = new byte[0];
  private static volatile TtsFileCache c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getCacheDir().getAbsolutePath());
    localStringBuilder.append("/tts_cache/");
    a = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tts_cache: ");
      localStringBuilder.append(a);
      QLog.d("TtsFileCache", 2, localStringBuilder.toString());
    }
  }
  
  public static TtsFileCache a()
  {
    if (c == null) {
      synchronized (b)
      {
        if (c == null) {
          c = new TtsFileCache();
        }
      }
    }
    return c;
  }
  
  public InputStream a(String paramString)
  {
    return b(MD5Coding.encodeHexStr(paramString));
  }
  
  /* Error */
  public void a(String paramString, java.io.ByteArrayOutputStream paramByteArrayOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 84	com/tencent/mobileqq/tts/data/TtsFileCache:b	()V
    //   6: aload_1
    //   7: invokestatic 75	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 7
    //   12: aload 7
    //   14: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifne +209 -> 228
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore 4
    //   31: aload 4
    //   33: astore_1
    //   34: new 16	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   41: astore 8
    //   43: aload 4
    //   45: astore_1
    //   46: aload 8
    //   48: getstatic 46	com/tencent/mobileqq/tts/data/TtsFileCache:a	Ljava/lang/String;
    //   51: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: astore_1
    //   58: aload 8
    //   60: aload 7
    //   62: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: astore_1
    //   69: new 92	java/io/FileOutputStream
    //   72: dup
    //   73: aload 8
    //   75: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   81: astore 4
    //   83: aload_2
    //   84: aload 4
    //   86: invokevirtual 101	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   89: aload 4
    //   91: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   94: goto +134 -> 228
    //   97: astore_1
    //   98: ldc 56
    //   100: iconst_1
    //   101: ldc 106
    //   103: aload_1
    //   104: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto +121 -> 228
    //   110: astore_2
    //   111: aload 4
    //   113: astore_1
    //   114: goto +91 -> 205
    //   117: astore_1
    //   118: aload 4
    //   120: astore_2
    //   121: aload_1
    //   122: astore 4
    //   124: goto +22 -> 146
    //   127: astore_1
    //   128: aload 4
    //   130: astore_2
    //   131: aload_1
    //   132: astore 4
    //   134: goto +44 -> 178
    //   137: astore_2
    //   138: goto +67 -> 205
    //   141: astore 4
    //   143: aload 5
    //   145: astore_2
    //   146: aload_2
    //   147: astore_1
    //   148: ldc 56
    //   150: iconst_1
    //   151: ldc 106
    //   153: aload 4
    //   155: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_2
    //   159: ifnull +69 -> 228
    //   162: aload_2
    //   163: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   166: goto +62 -> 228
    //   169: astore_1
    //   170: goto -72 -> 98
    //   173: astore 4
    //   175: aload 6
    //   177: astore_2
    //   178: aload_2
    //   179: astore_1
    //   180: ldc 56
    //   182: iconst_1
    //   183: ldc 106
    //   185: aload 4
    //   187: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aload_2
    //   191: ifnull +37 -> 228
    //   194: aload_2
    //   195: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   198: goto +30 -> 228
    //   201: astore_1
    //   202: goto -104 -> 98
    //   205: aload_1
    //   206: ifnull +20 -> 226
    //   209: aload_1
    //   210: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   213: goto +13 -> 226
    //   216: astore_1
    //   217: ldc 56
    //   219: iconst_1
    //   220: ldc 106
    //   222: aload_1
    //   223: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: athrow
    //   228: aload_0
    //   229: monitorexit
    //   230: return
    //   231: astore_1
    //   232: aload_0
    //   233: monitorexit
    //   234: goto +5 -> 239
    //   237: aload_1
    //   238: athrow
    //   239: goto -2 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	TtsFileCache
    //   0	242	1	paramString	String
    //   0	242	2	paramByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   17	2	3	bool	boolean
    //   29	104	4	localObject1	Object
    //   141	13	4	localException	Exception
    //   173	13	4	localIOException	IOException
    //   23	121	5	localObject2	Object
    //   26	150	6	localObject3	Object
    //   10	51	7	str	String
    //   41	33	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   89	94	97	java/lang/Exception
    //   83	89	110	finally
    //   83	89	117	java/lang/Exception
    //   83	89	127	java/io/IOException
    //   34	43	137	finally
    //   46	55	137	finally
    //   58	66	137	finally
    //   69	83	137	finally
    //   148	158	137	finally
    //   180	190	137	finally
    //   34	43	141	java/lang/Exception
    //   46	55	141	java/lang/Exception
    //   58	66	141	java/lang/Exception
    //   69	83	141	java/lang/Exception
    //   162	166	169	java/lang/Exception
    //   34	43	173	java/io/IOException
    //   46	55	173	java/io/IOException
    //   58	66	173	java/io/IOException
    //   69	83	173	java/io/IOException
    //   194	198	201	java/lang/Exception
    //   209	213	216	java/lang/Exception
    //   2	18	231	finally
    //   89	94	231	finally
    //   98	107	231	finally
    //   162	166	231	finally
    //   194	198	231	finally
    //   209	213	231	finally
    //   217	226	231	finally
    //   226	228	231	finally
  }
  
  public InputStream b(String paramString)
  {
    Object localObject = new File(a);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TtsFileCache", 1, "get: dir does not exist");
      }
      if (!((File)localObject).mkdirs())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TtsFileCache", 1, "get: mkdir failed");
        }
        return null;
      }
    }
    localObject = ((File)localObject).listFiles();
    int m = localObject.length;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (localObject[i].getName().equals(paramString))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j == 0) {
      return null;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append(paramString);
      paramString = new BufferedInputStream(new FileInputStream(((StringBuilder)localObject).toString()));
      return paramString;
    }
    catch (IOException paramString)
    {
      QLog.e("TtsFileCache", 1, "get failed: ", paramString);
    }
    return null;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        Object localObject = new File(a);
        if (!((File)localObject).exists()) {
          return;
        }
        File[] arrayOfFile = ((File)localObject).listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        if (i < j)
        {
          localObject = arrayOfFile[i];
          boolean bool = ((File)localObject).delete();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("delete cache: ");
            localStringBuilder.append(((File)localObject).getName());
            if (bool)
            {
              localObject = "succ";
              localStringBuilder.append((String)localObject);
              QLog.d("TtsFileCache", 1, localStringBuilder.toString());
            }
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("TtsFileCache", 1, "clearCache Exception: ", localException);
      }
      String str = "failed";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.TtsFileCache
 * JD-Core Version:    0.7.0.1
 */