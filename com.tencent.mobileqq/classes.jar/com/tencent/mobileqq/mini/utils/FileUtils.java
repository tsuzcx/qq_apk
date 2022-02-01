package com.tencent.mobileqq.mini.utils;

import android.os.Build.VERSION;
import android.system.Os;
import android.system.StructStat;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class FileUtils
{
  private static final String TAG = "[mini] FileUtils";
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
  }
  
  public static String getFileExtension(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i > 0) {
      return paramString.substring(i + 1);
    }
    return "";
  }
  
  public static String getFileExtensionWithDot(String paramString)
  {
    paramString = getFileExtension(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static JSONObject getStats(String paramString)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramString = Os.stat(paramString);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("mode", paramString.st_mode);
        ((JSONObject)localObject).put("size", paramString.st_size);
        ((JSONObject)localObject).put("lastAccessedTime", paramString.st_atime);
        ((JSONObject)localObject).put("lastModifiedTime", paramString.st_mtime);
        return localObject;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStats error. ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("[mini] FileUtils", 1, ((StringBuilder)localObject).toString());
      }
    } else {
      try
      {
        paramString = new File(paramString);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("mode", 0);
        ((JSONObject)localObject).put("size", paramString.length());
        ((JSONObject)localObject).put("lastAccessedTime", paramString.lastModified());
        ((JSONObject)localObject).put("lastModifiedTime", paramString.lastModified());
        return localObject;
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStats error. ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("[mini] FileUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static JSONObject getStatsByDir(String paramString)
  {
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("/", getStats(paramString));
      Object localObject2 = com.tencent.mobileqq.utils.FileUtils.getChildFiles(paramString, true);
      paramString = new File(paramString);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString.getCanonicalPath());
      ((StringBuilder)localObject3).append("/");
      paramString = ((StringBuilder)localObject3).toString();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((JSONObject)localObject1).put(((String)localObject3).replace(paramString, ""), getStats((String)localObject3));
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getStatsByDir error. ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("[mini] FileUtils", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  /* Error */
  public static String readFileFromAssets(String paramString)
  {
    // Byte code:
    //   0: invokestatic 202	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 208	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_0
    //   7: invokevirtual 214	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokevirtual 218	java/io/InputStream:available	()I
    //   17: newarray byte
    //   19: astore_2
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 21	java/io/InputStream:read	([B)I
    //   27: pop
    //   28: aload_1
    //   29: astore_0
    //   30: new 65	java/lang/String
    //   33: dup
    //   34: aload_2
    //   35: ldc 220
    //   37: invokespecial 223	java/lang/String:<init>	([BLjava/lang/String;)V
    //   40: astore_2
    //   41: aload_1
    //   42: ifnull +41 -> 83
    //   45: aload_1
    //   46: invokevirtual 226	java/io/InputStream:close	()V
    //   49: aload_2
    //   50: areturn
    //   51: astore_0
    //   52: new 78	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   59: astore_1
    //   60: aload_1
    //   61: ldc 228
    //   63: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_1
    //   68: aload_0
    //   69: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 230
    //   75: iconst_1
    //   76: aload_1
    //   77: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: areturn
    //   85: astore_2
    //   86: goto +12 -> 98
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_1
    //   92: goto +94 -> 186
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: astore_0
    //   100: new 78	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   107: astore_3
    //   108: aload_1
    //   109: astore_0
    //   110: aload_3
    //   111: ldc 232
    //   113: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_1
    //   118: astore_0
    //   119: aload_3
    //   120: aload_2
    //   121: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: astore_0
    //   127: ldc 230
    //   129: iconst_1
    //   130: aload_3
    //   131: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_1
    //   138: ifnull +41 -> 179
    //   141: aload_1
    //   142: invokevirtual 226	java/io/InputStream:close	()V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_0
    //   148: new 78	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   155: astore_1
    //   156: aload_1
    //   157: ldc 228
    //   159: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_1
    //   164: aload_0
    //   165: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: ldc 230
    //   171: iconst_1
    //   172: aload_1
    //   173: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_2
    //   182: aload_0
    //   183: astore_1
    //   184: aload_2
    //   185: astore_0
    //   186: aload_1
    //   187: ifnull +42 -> 229
    //   190: aload_1
    //   191: invokevirtual 226	java/io/InputStream:close	()V
    //   194: goto +35 -> 229
    //   197: astore_1
    //   198: new 78	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   205: astore_2
    //   206: aload_2
    //   207: ldc 228
    //   209: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: aload_1
    //   215: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 230
    //   221: iconst_1
    //   222: aload_2
    //   223: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   10	181	1	localObject1	Object
    //   197	18	1	localIOException	IOException
    //   19	65	2	localObject2	Object
    //   85	1	2	localException1	Exception
    //   95	26	2	localException2	Exception
    //   181	4	2	localObject3	Object
    //   205	18	2	localStringBuilder1	StringBuilder
    //   107	24	3	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/io/IOException
    //   13	20	85	java/lang/Exception
    //   22	28	85	java/lang/Exception
    //   30	41	85	java/lang/Exception
    //   0	11	89	finally
    //   0	11	95	java/lang/Exception
    //   141	145	147	java/io/IOException
    //   13	20	181	finally
    //   22	28	181	finally
    //   30	41	181	finally
    //   100	108	181	finally
    //   110	117	181	finally
    //   119	125	181	finally
    //   127	137	181	finally
    //   190	194	197	java/io/IOException
  }
  
  public static String readFileToStr(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile = readFileToString(paramFile);
          return paramFile;
        }
      }
      catch (Throwable paramFile)
      {
        QLog.e("[mini] FileUtils", 2, "readFileToStr", paramFile);
        return "";
      }
    }
    return null;
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 38	java/io/File:exists	()Z
    //   13: ifeq +291 -> 304
    //   16: aload_0
    //   17: invokevirtual 246	java/io/File:isDirectory	()Z
    //   20: ifne +242 -> 262
    //   23: aload_0
    //   24: invokevirtual 249	java/io/File:canRead	()Z
    //   27: ifeq +193 -> 220
    //   30: new 251	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 254	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: new 256	java/io/InputStreamReader
    //   42: dup
    //   43: aload_3
    //   44: ldc_w 258
    //   47: invokespecial 261	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 152	java/io/File:length	()J
    //   55: l2i
    //   56: istore_1
    //   57: iload_1
    //   58: sipush 12288
    //   61: if_icmple +53 -> 114
    //   64: sipush 4096
    //   67: newarray char
    //   69: astore_0
    //   70: new 78	java/lang/StringBuilder
    //   73: dup
    //   74: sipush 12288
    //   77: invokespecial 264	java/lang/StringBuilder:<init>	(I)V
    //   80: astore 5
    //   82: aload_2
    //   83: aload_0
    //   84: invokevirtual 267	java/io/InputStreamReader:read	([C)I
    //   87: istore_1
    //   88: iconst_m1
    //   89: iload_1
    //   90: if_icmpeq +15 -> 105
    //   93: aload 5
    //   95: aload_0
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 270	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: goto -20 -> 82
    //   105: aload 5
    //   107: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_0
    //   111: goto +22 -> 133
    //   114: iload_1
    //   115: newarray char
    //   117: astore_0
    //   118: new 65	java/lang/String
    //   121: dup
    //   122: aload_0
    //   123: iconst_0
    //   124: aload_2
    //   125: aload_0
    //   126: invokevirtual 267	java/io/InputStreamReader:read	([C)I
    //   129: invokespecial 273	java/lang/String:<init>	([CII)V
    //   132: astore_0
    //   133: aload_3
    //   134: invokevirtual 226	java/io/InputStream:close	()V
    //   137: aload_0
    //   138: astore_3
    //   139: aload_2
    //   140: invokevirtual 274	java/io/InputStreamReader:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: astore_0
    //   146: goto +24 -> 170
    //   149: aload_2
    //   150: astore_0
    //   151: goto +44 -> 195
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_2
    //   157: goto +13 -> 170
    //   160: aconst_null
    //   161: astore_0
    //   162: goto +33 -> 195
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore_2
    //   170: aload_3
    //   171: ifnull +10 -> 181
    //   174: aload_3
    //   175: invokevirtual 226	java/io/InputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 274	java/io/InputStreamReader:close	()V
    //   189: aload_0
    //   190: athrow
    //   191: aconst_null
    //   192: astore_3
    //   193: aload_3
    //   194: astore_0
    //   195: aload_3
    //   196: ifnull +10 -> 206
    //   199: aload_3
    //   200: invokevirtual 226	java/io/InputStream:close	()V
    //   203: goto +3 -> 206
    //   206: aload_0
    //   207: ifnull +11 -> 218
    //   210: aload 4
    //   212: astore_3
    //   213: aload_0
    //   214: astore_2
    //   215: goto -76 -> 139
    //   218: aconst_null
    //   219: areturn
    //   220: new 78	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   227: astore_2
    //   228: aload_2
    //   229: ldc_w 276
    //   232: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_2
    //   243: ldc_w 278
    //   246: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: new 196	java/io/IOException
    //   253: dup
    //   254: aload_2
    //   255: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokespecial 279	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   261: athrow
    //   262: new 78	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   269: astore_2
    //   270: aload_2
    //   271: ldc_w 276
    //   274: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: aload_0
    //   280: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: ldc_w 281
    //   288: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: new 196	java/io/IOException
    //   295: dup
    //   296: aload_2
    //   297: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokespecial 279	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   303: athrow
    //   304: new 78	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   311: astore_2
    //   312: aload_2
    //   313: ldc_w 276
    //   316: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: aload_0
    //   322: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc_w 283
    //   330: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: new 285	java/io/FileNotFoundException
    //   337: dup
    //   338: aload_2
    //   339: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 286	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   345: astore_0
    //   346: goto +5 -> 351
    //   349: aload_0
    //   350: athrow
    //   351: goto -2 -> 349
    //   354: astore_0
    //   355: goto -164 -> 191
    //   358: astore_0
    //   359: goto -199 -> 160
    //   362: astore_0
    //   363: goto -214 -> 149
    //   366: astore_3
    //   367: aload_0
    //   368: astore_3
    //   369: goto -230 -> 139
    //   372: astore_0
    //   373: aload_3
    //   374: areturn
    //   375: astore_3
    //   376: goto -195 -> 181
    //   379: astore_2
    //   380: goto -191 -> 189
    //   383: astore_2
    //   384: goto -178 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramFile	File
    //   56	59	1	i	int
    //   50	289	2	localObject1	Object
    //   379	1	2	localException1	Exception
    //   383	1	2	localException2	Exception
    //   38	175	3	localObject2	Object
    //   366	1	3	localException3	Exception
    //   368	6	3	localFile	File
    //   375	1	3	localException4	Exception
    //   1	210	4	localObject3	Object
    //   80	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	57	145	finally
    //   64	82	145	finally
    //   82	88	145	finally
    //   93	102	145	finally
    //   105	111	145	finally
    //   114	133	145	finally
    //   39	51	154	finally
    //   30	39	165	finally
    //   30	39	354	java/lang/Exception
    //   39	51	358	java/lang/Exception
    //   51	57	362	java/lang/Exception
    //   64	82	362	java/lang/Exception
    //   82	88	362	java/lang/Exception
    //   93	102	362	java/lang/Exception
    //   105	111	362	java/lang/Exception
    //   114	133	362	java/lang/Exception
    //   133	137	366	java/lang/Exception
    //   139	143	372	java/lang/Exception
    //   174	178	375	java/lang/Exception
    //   185	189	379	java/lang/Exception
    //   199	203	383	java/lang/Exception
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2)
  {
    boolean bool1;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
    }
    catch (IOException localIOException)
    {
      label24:
      boolean bool2;
      break label24;
    }
    bool2 = false;
    break label31;
    bool2 = true;
    try
    {
      label31:
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label44:
      boolean bool1;
      break label44;
    }
    paramString1 = null;
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      label67:
      break label67;
    }
    bool1 = false;
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      label84:
      break label84;
    }
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      return bool2;
    }
    catch (IOException paramString1)
    {
      label98:
      break label98;
    }
    bool1 = false;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */