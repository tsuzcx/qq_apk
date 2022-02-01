package cooperation.qzone.util;

import android.content.Context;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.File;
import java.util.HashMap;

public class WnsProxyUtils
{
  private static final String KEY_REQ_DATA = "req";
  private static HashMap<String, String> mSDCardName2PathMap = new HashMap();
  private static long maxAvailableSize;
  private static String maxAvailableSizePath = "";
  private static String storeRootPath = "";
  
  private static boolean fullUrlForKey(Uri paramUri)
  {
    boolean bool2 = false;
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("_query");
      boolean bool1 = bool2;
      if (str != null) {
        if (!"1".equals(str))
        {
          boolean bool3 = "true".equals(str);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramUri) {}
    return false;
  }
  
  public static String getCacheData(Uri paramUri)
  {
    paramUri = new File(getCachedFileName(BaseApplicationImpl.getContext(), paramUri));
    if (!paramUri.exists()) {
      return null;
    }
    return getFileData(paramUri.getAbsolutePath());
  }
  
  public static String getCacheData(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      paramString = new File(getCachedFileName(BaseApplicationImpl.getContext(), paramString));
      if ((paramString == null) || (!paramString.exists())) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("WnsProxyUtils", 2, "getCacheData", paramString);
        paramString = null;
      }
    }
    return getFileData(paramString.getAbsolutePath());
  }
  
  public static String getCachedFileName(Context paramContext, Uri paramUri)
  {
    String str = getStorePath("file");
    if (fullUrlForKey(paramUri)) {}
    for (paramContext = paramUri.toString();; paramContext = paramUri.getAuthority() + paramUri.getPath())
    {
      paramContext = MD5.toMD5(paramContext);
      return str + paramContext + ".txt";
    }
  }
  
  /* Error */
  private static String getFileData(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +12 -> 17
    //   8: aload_0
    //   9: invokevirtual 138	java/lang/String:length	()I
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 140	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_1
    //   31: invokevirtual 144	java/io/FileInputStream:available	()I
    //   34: newarray byte
    //   36: astore_2
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 148	java/io/FileInputStream:read	([B)I
    //   44: pop
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: ldc 150
    //   50: invokestatic 156	org/apache/http/util/EncodingUtils:getString	([BLjava/lang/String;)Ljava/lang/String;
    //   53: astore_2
    //   54: aload_2
    //   55: astore_0
    //   56: aload_0
    //   57: astore_2
    //   58: aload_1
    //   59: ifnull -42 -> 17
    //   62: aload_1
    //   63: invokevirtual 159	java/io/FileInputStream:close	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_1
    //   69: aload_1
    //   70: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   84: aload_3
    //   85: astore_2
    //   86: aload_1
    //   87: ifnull -70 -> 17
    //   90: aload_1
    //   91: invokevirtual 159	java/io/FileInputStream:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   112: aload_3
    //   113: astore_2
    //   114: aload_1
    //   115: ifnull -98 -> 17
    //   118: aload_1
    //   119: invokevirtual 159	java/io/FileInputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_2
    //   137: invokevirtual 164	java/lang/OutOfMemoryError:printStackTrace	()V
    //   140: aload_3
    //   141: astore_2
    //   142: aload_1
    //   143: ifnull -126 -> 17
    //   146: aload_1
    //   147: invokevirtual 159	java/io/FileInputStream:close	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 159	java/io/FileInputStream:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   177: goto -7 -> 170
    //   180: astore_1
    //   181: goto -19 -> 162
    //   184: astore_2
    //   185: goto -51 -> 134
    //   188: astore_2
    //   189: goto -83 -> 106
    //   192: astore_2
    //   193: goto -115 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramString	String
    //   27	36	1	localFileInputStream	java.io.FileInputStream
    //   68	2	1	localIOException1	java.io.IOException
    //   77	70	1	localObject1	Object
    //   159	12	1	localObject2	Object
    //   180	1	1	localObject3	Object
    //   3	55	2	localObject4	Object
    //   75	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   85	1	2	localObject5	Object
    //   103	6	2	localIOException2	java.io.IOException
    //   113	1	2	localObject6	Object
    //   131	6	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   141	1	2	localObject7	Object
    //   184	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   188	1	2	localIOException3	java.io.IOException
    //   192	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	140	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   62	66	68	java/io/IOException
    //   19	28	75	java/io/FileNotFoundException
    //   90	94	96	java/io/IOException
    //   19	28	103	java/io/IOException
    //   118	122	124	java/io/IOException
    //   19	28	131	java/lang/OutOfMemoryError
    //   146	150	152	java/io/IOException
    //   19	28	159	finally
    //   166	170	172	java/io/IOException
    //   30	37	180	finally
    //   39	45	180	finally
    //   47	54	180	finally
    //   80	84	180	finally
    //   108	112	180	finally
    //   136	140	180	finally
    //   30	37	184	java/lang/OutOfMemoryError
    //   39	45	184	java/lang/OutOfMemoryError
    //   47	54	184	java/lang/OutOfMemoryError
    //   30	37	188	java/io/IOException
    //   39	45	188	java/io/IOException
    //   47	54	188	java/io/IOException
    //   30	37	192	java/io/FileNotFoundException
    //   39	45	192	java/io/FileNotFoundException
    //   47	54	192	java/io/FileNotFoundException
  }
  
  private static String getStorePath(String paramString)
  {
    String str2 = QZoneFilePath.ROOT_QZONE_PATH;
    String str1 = paramString;
    if (!paramString.startsWith(File.separator)) {
      str1 = File.separator + paramString;
    }
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    paramString = new File(str2 + paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    str1 = paramString.getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    return paramString;
  }
  
  public static final String getTempCacheData(String paramString)
  {
    try
    {
      paramString = new File(getTempCachedFileName(Uri.parse(paramString)));
      if ((paramString == null) || (!paramString.exists())) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("WnsProxyUtils", 2, "getUrlKey", paramString);
        paramString = null;
      }
    }
    return getFileData(paramString.getAbsolutePath());
  }
  
  public static String getTempCachedFileName(Uri paramUri)
  {
    String str = getStorePath("file");
    if (fullUrlForKey(paramUri)) {}
    for (paramUri = paramUri.toString();; paramUri = paramUri.getAuthority() + paramUri.getPath())
    {
      paramUri = MD5.toMD5(paramUri);
      return str + paramUri + "_temp.txt";
    }
  }
  
  public static String getUrlKey(Uri paramUri)
  {
    if (fullUrlForKey(paramUri)) {
      return paramUri.toString();
    }
    return paramUri.getAuthority() + paramUri.getPath();
  }
  
  public static String getUrlKey(String paramString)
  {
    try
    {
      Object localObject = Uri.parse(paramString);
      if (fullUrlForKey((Uri)localObject)) {
        return ((Uri)localObject).toString();
      }
      localObject = ((Uri)localObject).getAuthority() + ((Uri)localObject).getPath();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WnsProxyUtils", 2, "getUrlKey", localThrowable);
    }
    return paramString;
  }
  
  public static boolean hasProxyParam(Uri paramUri)
  {
    boolean bool2 = false;
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("_proxy");
      boolean bool1 = bool2;
      if (str != null) {
        if (!"1".equals(str))
        {
          boolean bool3 = "true".equals(str);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramUri) {}
    return false;
  }
  
  public static boolean hasProxyParam(String paramString)
  {
    try
    {
      boolean bool = hasProxyParam(Uri.parse(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  /* Error */
  private static boolean isStorageReallyCanwrite(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 202	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 206	java/lang/Thread:getId	()J
    //   8: lstore_2
    //   9: new 58	java/io/File
    //   12: dup
    //   13: new 114	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 208
    //   26: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_2
    //   30: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 75	java/io/File:exists	()Z
    //   44: ifeq +22 -> 66
    //   47: aload_0
    //   48: invokevirtual 214	java/io/File:delete	()Z
    //   51: ifeq +8 -> 59
    //   54: aload_0
    //   55: invokevirtual 217	java/io/File:createNewFile	()Z
    //   58: istore_1
    //   59: aload_0
    //   60: invokevirtual 214	java/io/File:delete	()Z
    //   63: pop
    //   64: iload_1
    //   65: ireturn
    //   66: aload_0
    //   67: invokevirtual 217	java/io/File:createNewFile	()Z
    //   70: istore_1
    //   71: goto -12 -> 59
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 218	java/lang/Throwable:printStackTrace	()V
    //   81: aload_0
    //   82: invokevirtual 214	java/io/File:delete	()Z
    //   85: pop
    //   86: iconst_0
    //   87: ireturn
    //   88: astore 4
    //   90: aload_0
    //   91: invokevirtual 214	java/io/File:delete	()Z
    //   94: pop
    //   95: aload 4
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   1	70	1	bool	boolean
    //   8	22	2	l	long
    //   74	3	4	localThrowable	Throwable
    //   88	8	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	74	java/lang/Throwable
    //   47	59	74	java/lang/Throwable
    //   66	71	74	java/lang/Throwable
    //   40	47	88	finally
    //   47	59	88	finally
    //   66	71	88	finally
    //   76	81	88	finally
  }
  
  /* Error */
  private static void updateStorage(String paramString)
  {
    // Byte code:
    //   0: new 58	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 75	java/io/File:exists	()Z
    //   13: ifeq +111 -> 124
    //   16: new 221	java/io/BufferedReader
    //   19: dup
    //   20: new 223	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 226	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 229	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +85 -> 125
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc 234
    //   48: invokevirtual 176	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   51: ifeq -19 -> 32
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: ldc 236
    //   59: invokevirtual 240	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore_3
    //   63: aload_1
    //   64: astore_0
    //   65: aload_3
    //   66: arraylength
    //   67: iconst_3
    //   68: if_icmplt -36 -> 32
    //   71: aload_3
    //   72: iconst_2
    //   73: aaload
    //   74: astore_2
    //   75: aload_3
    //   76: iconst_1
    //   77: aaload
    //   78: astore_3
    //   79: aload_1
    //   80: astore_0
    //   81: new 58	java/io/File
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 75	java/io/File:exists	()Z
    //   92: ifeq -60 -> 32
    //   95: aload_1
    //   96: astore_0
    //   97: getstatic 24	cooperation/qzone/util/WnsProxyUtils:mSDCardName2PathMap	Ljava/util/HashMap;
    //   100: aload_3
    //   101: aload_2
    //   102: invokevirtual 244	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: goto -74 -> 32
    //   109: astore_2
    //   110: aload_1
    //   111: astore_0
    //   112: aload_2
    //   113: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 246	java/io/BufferedReader:close	()V
    //   124: return
    //   125: aload_1
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 246	java/io/BufferedReader:close	()V
    //   131: aload_1
    //   132: ifnull -8 -> 124
    //   135: aload_1
    //   136: invokevirtual 246	java/io/BufferedReader:close	()V
    //   139: return
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   145: return
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   151: return
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 246	java/io/BufferedReader:close	()V
    //   163: aload_1
    //   164: athrow
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   170: goto -7 -> 163
    //   173: astore_1
    //   174: goto -19 -> 155
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: goto -70 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   31	105	1	localBufferedReader	java.io.BufferedReader
    //   152	12	1	localObject1	Object
    //   173	1	1	localObject2	Object
    //   179	1	1	localObject3	Object
    //   38	64	2	str	String
    //   109	4	2	localException1	Exception
    //   177	1	2	localException2	Exception
    //   62	39	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	109	java/lang/Exception
    //   45	54	109	java/lang/Exception
    //   56	63	109	java/lang/Exception
    //   65	71	109	java/lang/Exception
    //   81	95	109	java/lang/Exception
    //   97	106	109	java/lang/Exception
    //   127	131	109	java/lang/Exception
    //   135	139	140	java/io/IOException
    //   120	124	146	java/io/IOException
    //   16	32	152	finally
    //   159	163	165	java/io/IOException
    //   34	39	173	finally
    //   45	54	173	finally
    //   56	63	173	finally
    //   65	71	173	finally
    //   81	95	173	finally
    //   97	106	173	finally
    //   112	116	173	finally
    //   127	131	173	finally
    //   16	32	177	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.WnsProxyUtils
 * JD-Core Version:    0.7.0.1
 */