package com.tencent.weseevideo.model.utils;

import android.text.TextUtils;
import com.tencent.tavcut.util.Logger;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils
{
  private static final String TAG = "FileUtils";
  
  /* Error */
  public static void copyAssets(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ldc 19
    //   9: iconst_0
    //   10: invokevirtual 25	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: astore 7
    //   15: aload 7
    //   17: ldc 27
    //   19: iconst_1
    //   20: invokeinterface 33 3 0
    //   25: istore 4
    //   27: aload 7
    //   29: invokeinterface 37 1 0
    //   34: pop
    //   35: iload 4
    //   37: ifne +58 -> 95
    //   40: new 39	java/io/File
    //   43: dup
    //   44: aload_3
    //   45: aload_2
    //   46: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: invokevirtual 46	java/io/File:exists	()Z
    //   52: ifeq +43 -> 95
    //   55: ldc 8
    //   57: new 48	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   64: ldc 51
    //   66: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 57
    //   75: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_3
    //   79: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 59
    //   84: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 69	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: return
    //   95: aload_0
    //   96: invokevirtual 73	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   99: astore_0
    //   100: aload_0
    //   101: aload_1
    //   102: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   105: astore_0
    //   106: new 39	java/io/File
    //   109: dup
    //   110: aload_3
    //   111: aload_2
    //   112: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_2
    //   117: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   120: invokevirtual 46	java/io/File:exists	()Z
    //   123: ifne +11 -> 134
    //   126: aload_2
    //   127: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   130: invokevirtual 86	java/io/File:mkdirs	()Z
    //   133: pop
    //   134: new 88	java/io/FileOutputStream
    //   137: dup
    //   138: aload_2
    //   139: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   142: astore_2
    //   143: aload_0
    //   144: aload_2
    //   145: invokestatic 95	com/tencent/weseevideo/model/utils/FileUtils:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   148: aload_2
    //   149: invokevirtual 100	java/io/OutputStream:flush	()V
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 105	java/io/InputStream:close	()V
    //   160: aload_2
    //   161: ifnull -67 -> 94
    //   164: aload_2
    //   165: invokevirtual 106	java/io/OutputStream:close	()V
    //   168: return
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   174: return
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   180: goto -20 -> 160
    //   183: astore_3
    //   184: aconst_null
    //   185: astore_0
    //   186: aload 5
    //   188: astore_2
    //   189: ldc 111
    //   191: new 48	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   198: ldc 113
    //   200: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload_3
    //   211: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   214: pop
    //   215: aload_0
    //   216: ifnull +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 105	java/io/InputStream:close	()V
    //   223: aload_2
    //   224: ifnull -130 -> 94
    //   227: aload_2
    //   228: invokevirtual 106	java/io/OutputStream:close	()V
    //   231: return
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   237: return
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   243: goto -20 -> 223
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_0
    //   249: aload 6
    //   251: astore_2
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 105	java/io/InputStream:close	()V
    //   260: aload_2
    //   261: ifnull +7 -> 268
    //   264: aload_2
    //   265: invokevirtual 106	java/io/OutputStream:close	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   275: goto -15 -> 260
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   283: goto -15 -> 268
    //   286: astore_1
    //   287: aload 6
    //   289: astore_2
    //   290: goto -38 -> 252
    //   293: astore_1
    //   294: goto -42 -> 252
    //   297: astore_1
    //   298: goto -46 -> 252
    //   301: astore_3
    //   302: aload 5
    //   304: astore_2
    //   305: goto -116 -> 189
    //   308: astore_3
    //   309: goto -120 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramContext	android.content.Context
    //   0	312	1	paramString1	String
    //   0	312	2	paramString2	String
    //   0	312	3	paramString3	String
    //   25	11	4	bool	boolean
    //   4	299	5	localObject1	Object
    //   1	287	6	localObject2	Object
    //   13	15	7	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   164	168	169	java/io/IOException
    //   156	160	175	java/io/IOException
    //   100	106	183	java/io/IOException
    //   227	231	232	java/io/IOException
    //   219	223	238	java/io/IOException
    //   100	106	246	finally
    //   256	260	270	java/io/IOException
    //   264	268	278	java/io/IOException
    //   106	134	286	finally
    //   134	143	286	finally
    //   143	152	293	finally
    //   189	215	297	finally
    //   106	134	301	java/io/IOException
    //   134	143	301	java/io/IOException
    //   143	152	308	java/io/IOException
  }
  
  private static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[16384];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static boolean exists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.indexOf("assets") < 0) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static String getFilePathBySuffix(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    if ((TextUtils.isEmpty(paramString1)) && (!exists(paramString1))) {
      paramString1 = "";
    }
    Object localObject2;
    do
    {
      do
      {
        return paramString1;
        if (paramString1.endsWith(paramString2)) {
          return paramString1;
        }
        localObject2 = new File(paramString1);
        paramString1 = localObject1;
      } while (!((File)localObject2).isDirectory());
      localObject2 = ((File)localObject2).listFiles();
      paramString1 = localObject1;
    } while (localObject2 == null);
    int j = localObject2.length;
    int i = 0;
    for (;;)
    {
      paramString1 = localObject1;
      if (i >= j) {
        break;
      }
      paramString1 = localObject2[i];
      if (paramString1.getName().endsWith(paramString2))
      {
        paramString1 = paramString1.getAbsolutePath();
        Logger.i("FileUtils", "getFilePathBySuffix: " + paramString1);
        return paramString1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */