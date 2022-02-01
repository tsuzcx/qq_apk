package com.tencent.qcircle.weseevideo.model.utils;

import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
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
    //   0: aload_0
    //   1: ldc 19
    //   3: iconst_0
    //   4: invokevirtual 25	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 27
    //   13: iconst_1
    //   14: invokeinterface 33 3 0
    //   19: istore 4
    //   21: aload 5
    //   23: invokeinterface 37 1 0
    //   28: pop
    //   29: iload 4
    //   31: ifne +70 -> 101
    //   34: new 39	java/io/File
    //   37: dup
    //   38: aload_3
    //   39: aload_2
    //   40: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: invokevirtual 46	java/io/File:exists	()Z
    //   46: ifeq +55 -> 101
    //   49: new 48	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   56: astore_0
    //   57: aload_0
    //   58: ldc 51
    //   60: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_0
    //   71: ldc 57
    //   73: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_0
    //   84: ldc 59
    //   86: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc 8
    //   92: aload_0
    //   93: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 69	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: return
    //   101: aload_0
    //   102: invokevirtual 73	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   105: astore_0
    //   106: aconst_null
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 6
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   117: astore_0
    //   118: new 39	java/io/File
    //   121: dup
    //   122: aload_3
    //   123: aload_2
    //   124: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: astore_2
    //   128: aload_2
    //   129: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   132: invokevirtual 46	java/io/File:exists	()Z
    //   135: ifne +11 -> 146
    //   138: aload_2
    //   139: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   142: invokevirtual 86	java/io/File:mkdirs	()Z
    //   145: pop
    //   146: new 88	java/io/FileOutputStream
    //   149: dup
    //   150: aload_2
    //   151: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: astore_2
    //   155: aload_0
    //   156: aload_2
    //   157: invokestatic 95	com/tencent/qcircle/weseevideo/model/utils/FileUtils:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   160: aload_2
    //   161: invokevirtual 100	java/io/OutputStream:flush	()V
    //   164: aload_0
    //   165: ifnull +15 -> 180
    //   168: aload_0
    //   169: invokevirtual 105	java/io/InputStream:close	()V
    //   172: goto +8 -> 180
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   180: aload_2
    //   181: invokevirtual 109	java/io/OutputStream:close	()V
    //   184: return
    //   185: astore_3
    //   186: aload_2
    //   187: astore_1
    //   188: aload_0
    //   189: astore_2
    //   190: aload_3
    //   191: astore_0
    //   192: goto +113 -> 305
    //   195: astore_3
    //   196: goto +35 -> 231
    //   199: astore_3
    //   200: aload 5
    //   202: astore_1
    //   203: aload_0
    //   204: astore_2
    //   205: aload_3
    //   206: astore_0
    //   207: goto +98 -> 305
    //   210: astore_3
    //   211: aconst_null
    //   212: astore_2
    //   213: goto +18 -> 231
    //   216: astore_0
    //   217: aconst_null
    //   218: astore_2
    //   219: aload 5
    //   221: astore_1
    //   222: goto +83 -> 305
    //   225: astore_3
    //   226: aconst_null
    //   227: astore_2
    //   228: aload 6
    //   230: astore_0
    //   231: new 48	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   238: astore 5
    //   240: aload 5
    //   242: ldc 111
    //   244: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 5
    //   250: aload_1
    //   251: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 113
    //   257: aload 5
    //   259: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload_3
    //   263: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   266: pop
    //   267: aload_0
    //   268: ifnull +15 -> 283
    //   271: aload_0
    //   272: invokevirtual 105	java/io/InputStream:close	()V
    //   275: goto +8 -> 283
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   283: aload_2
    //   284: ifnull +13 -> 297
    //   287: aload_2
    //   288: invokevirtual 109	java/io/OutputStream:close	()V
    //   291: return
    //   292: astore_0
    //   293: aload_0
    //   294: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   297: return
    //   298: astore_3
    //   299: aload_2
    //   300: astore_1
    //   301: aload_0
    //   302: astore_2
    //   303: aload_3
    //   304: astore_0
    //   305: aload_2
    //   306: ifnull +15 -> 321
    //   309: aload_2
    //   310: invokevirtual 105	java/io/InputStream:close	()V
    //   313: goto +8 -> 321
    //   316: astore_2
    //   317: aload_2
    //   318: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   321: aload_1
    //   322: ifnull +15 -> 337
    //   325: aload_1
    //   326: invokevirtual 109	java/io/OutputStream:close	()V
    //   329: goto +8 -> 337
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   337: aload_0
    //   338: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramContext	android.content.Context
    //   0	339	1	paramString1	String
    //   0	339	2	paramString2	String
    //   0	339	3	paramString3	String
    //   19	11	4	bool	boolean
    //   7	251	5	localObject1	Object
    //   110	119	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   168	172	175	java/io/IOException
    //   155	164	185	finally
    //   155	164	195	java/io/IOException
    //   118	146	199	finally
    //   146	155	199	finally
    //   118	146	210	java/io/IOException
    //   146	155	210	java/io/IOException
    //   112	118	216	finally
    //   112	118	225	java/io/IOException
    //   271	275	278	java/io/IOException
    //   180	184	292	java/io/IOException
    //   287	291	292	java/io/IOException
    //   231	267	298	finally
    //   309	313	316	java/io/IOException
    //   325	329	332	java/io/IOException
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return (paramString.indexOf("assets") >= 0) || (new File(paramString).exists());
  }
  
  public static String getFilePathBySuffix(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (!exists(paramString1))) {
      return "";
    }
    if (paramString1.endsWith(paramString2)) {
      return paramString1;
    }
    paramString1 = new File(paramString1);
    if (paramString1.isDirectory())
    {
      paramString1 = paramString1.listFiles();
      if (paramString1 == null) {
        return null;
      }
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if (localObject.getName().endsWith(paramString2))
        {
          paramString1 = localObject.getAbsolutePath();
          paramString2 = new StringBuilder();
          paramString2.append("getFilePathBySuffix: ");
          paramString2.append(paramString1);
          Logger.i("FileUtils", paramString2.toString());
          return paramString1;
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */