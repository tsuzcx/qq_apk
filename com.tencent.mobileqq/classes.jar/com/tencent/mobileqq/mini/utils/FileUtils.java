package com.tencent.mobileqq.mini.utils;

import android.os.Build.VERSION;
import android.system.Os;
import android.system.StructStat;
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
    //   0: invokestatic 182	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 188	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   6: aload_0
    //   7: invokevirtual 194	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokevirtual 198	java/io/InputStream:available	()I
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
    //   30: new 164	java/lang/String
    //   33: dup
    //   34: aload_2
    //   35: ldc 200
    //   37: invokespecial 203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   40: astore_2
    //   41: aload_1
    //   42: ifnull +41 -> 83
    //   45: aload_1
    //   46: invokevirtual 206	java/io/InputStream:close	()V
    //   49: aload_2
    //   50: areturn
    //   51: astore_0
    //   52: new 104	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   59: astore_1
    //   60: aload_1
    //   61: ldc 208
    //   63: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_1
    //   68: aload_0
    //   69: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: ldc 210
    //   75: iconst_1
    //   76: aload_1
    //   77: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   100: new 104	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   107: astore_3
    //   108: aload_1
    //   109: astore_0
    //   110: aload_3
    //   111: ldc 212
    //   113: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_1
    //   118: astore_0
    //   119: aload_3
    //   120: aload_2
    //   121: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: astore_0
    //   127: ldc 210
    //   129: iconst_1
    //   130: aload_3
    //   131: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_1
    //   138: ifnull +41 -> 179
    //   141: aload_1
    //   142: invokevirtual 206	java/io/InputStream:close	()V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_0
    //   148: new 104	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   155: astore_1
    //   156: aload_1
    //   157: ldc 208
    //   159: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_1
    //   164: aload_0
    //   165: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: ldc 210
    //   171: iconst_1
    //   172: aload_1
    //   173: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   191: invokevirtual 206	java/io/InputStream:close	()V
    //   194: goto +35 -> 229
    //   197: astore_1
    //   198: new 104	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   205: astore_2
    //   206: aload_2
    //   207: ldc 208
    //   209: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: aload_1
    //   215: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: ldc 210
    //   221: iconst_1
    //   222: aload_2
    //   223: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   13: ifeq +290 -> 303
    //   16: aload_0
    //   17: invokevirtual 226	java/io/File:isDirectory	()Z
    //   20: ifne +241 -> 261
    //   23: aload_0
    //   24: invokevirtual 229	java/io/File:canRead	()Z
    //   27: ifeq +192 -> 219
    //   30: new 231	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: new 236	java/io/InputStreamReader
    //   42: dup
    //   43: aload_3
    //   44: ldc 238
    //   46: invokespecial 241	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_0
    //   51: invokevirtual 127	java/io/File:length	()J
    //   54: l2i
    //   55: istore_1
    //   56: iload_1
    //   57: sipush 12288
    //   60: if_icmple +53 -> 113
    //   63: sipush 4096
    //   66: newarray char
    //   68: astore_0
    //   69: new 104	java/lang/StringBuilder
    //   72: dup
    //   73: sipush 12288
    //   76: invokespecial 244	java/lang/StringBuilder:<init>	(I)V
    //   79: astore 5
    //   81: aload_2
    //   82: aload_0
    //   83: invokevirtual 247	java/io/InputStreamReader:read	([C)I
    //   86: istore_1
    //   87: iconst_m1
    //   88: iload_1
    //   89: if_icmpeq +15 -> 104
    //   92: aload 5
    //   94: aload_0
    //   95: iconst_0
    //   96: iload_1
    //   97: invokevirtual 250	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: goto -20 -> 81
    //   104: aload 5
    //   106: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: goto +22 -> 132
    //   113: iload_1
    //   114: newarray char
    //   116: astore_0
    //   117: new 164	java/lang/String
    //   120: dup
    //   121: aload_0
    //   122: iconst_0
    //   123: aload_2
    //   124: aload_0
    //   125: invokevirtual 247	java/io/InputStreamReader:read	([C)I
    //   128: invokespecial 253	java/lang/String:<init>	([CII)V
    //   131: astore_0
    //   132: aload_3
    //   133: invokevirtual 206	java/io/InputStream:close	()V
    //   136: aload_0
    //   137: astore_3
    //   138: aload_2
    //   139: invokevirtual 254	java/io/InputStreamReader:close	()V
    //   142: aload_3
    //   143: areturn
    //   144: astore_0
    //   145: goto +24 -> 169
    //   148: aload_2
    //   149: astore_0
    //   150: goto +44 -> 194
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_2
    //   156: goto +13 -> 169
    //   159: aconst_null
    //   160: astore_0
    //   161: goto +33 -> 194
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_3
    //   167: aload_3
    //   168: astore_2
    //   169: aload_3
    //   170: ifnull +10 -> 180
    //   173: aload_3
    //   174: invokevirtual 206	java/io/InputStream:close	()V
    //   177: goto +3 -> 180
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 254	java/io/InputStreamReader:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: aconst_null
    //   191: astore_3
    //   192: aload_3
    //   193: astore_0
    //   194: aload_3
    //   195: ifnull +10 -> 205
    //   198: aload_3
    //   199: invokevirtual 206	java/io/InputStream:close	()V
    //   202: goto +3 -> 205
    //   205: aload_0
    //   206: ifnull +11 -> 217
    //   209: aload 4
    //   211: astore_3
    //   212: aload_0
    //   213: astore_2
    //   214: goto -76 -> 138
    //   217: aconst_null
    //   218: areturn
    //   219: new 104	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   226: astore_2
    //   227: aload_2
    //   228: ldc_w 256
    //   231: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: aload_0
    //   237: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_2
    //   242: ldc_w 258
    //   245: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: new 176	java/io/IOException
    //   252: dup
    //   253: aload_2
    //   254: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   260: athrow
    //   261: new 104	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   268: astore_2
    //   269: aload_2
    //   270: ldc_w 256
    //   273: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_2
    //   278: aload_0
    //   279: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_2
    //   284: ldc_w 261
    //   287: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: new 176	java/io/IOException
    //   294: dup
    //   295: aload_2
    //   296: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   302: athrow
    //   303: new 104	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   310: astore_2
    //   311: aload_2
    //   312: ldc_w 256
    //   315: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_2
    //   320: aload_0
    //   321: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_2
    //   326: ldc_w 263
    //   329: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: new 265	java/io/FileNotFoundException
    //   336: dup
    //   337: aload_2
    //   338: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokespecial 266	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   344: astore_0
    //   345: goto +5 -> 350
    //   348: aload_0
    //   349: athrow
    //   350: goto -2 -> 348
    //   353: astore_0
    //   354: goto -164 -> 190
    //   357: astore_0
    //   358: goto -199 -> 159
    //   361: astore_0
    //   362: goto -214 -> 148
    //   365: astore_3
    //   366: aload_0
    //   367: astore_3
    //   368: goto -230 -> 138
    //   371: astore_0
    //   372: aload_3
    //   373: areturn
    //   374: astore_3
    //   375: goto -195 -> 180
    //   378: astore_2
    //   379: goto -191 -> 188
    //   382: astore_2
    //   383: goto -178 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramFile	File
    //   55	59	1	i	int
    //   49	289	2	localObject1	Object
    //   378	1	2	localException1	Exception
    //   382	1	2	localException2	Exception
    //   38	174	3	localObject2	Object
    //   365	1	3	localException3	Exception
    //   367	6	3	localFile	File
    //   374	1	3	localException4	Exception
    //   1	209	4	localObject3	Object
    //   79	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	56	144	finally
    //   63	81	144	finally
    //   81	87	144	finally
    //   92	101	144	finally
    //   104	110	144	finally
    //   113	132	144	finally
    //   39	50	153	finally
    //   30	39	164	finally
    //   30	39	353	java/lang/Exception
    //   39	50	357	java/lang/Exception
    //   50	56	361	java/lang/Exception
    //   63	81	361	java/lang/Exception
    //   81	87	361	java/lang/Exception
    //   92	101	361	java/lang/Exception
    //   104	110	361	java/lang/Exception
    //   113	132	361	java/lang/Exception
    //   132	136	365	java/lang/Exception
    //   138	142	371	java/lang/Exception
    //   173	177	374	java/lang/Exception
    //   184	188	378	java/lang/Exception
    //   198	202	382	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */