package com.tencent.qq.effect.utils;

import android.view.View;
import com.tencent.qq.effect.sensor.SensorParams;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class QEffectUtils
{
  public static boolean fileIsExists(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static String getAssetsFiles(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 31	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 38	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_2
    //   18: ldc 44
    //   20: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload 4
    //   38: invokestatic 53	com/tencent/qq/effect/utils/QEffectUtils:fileIsExists	(Ljava/lang/String;)Z
    //   41: ifne +186 -> 227
    //   44: aload_0
    //   45: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: astore_2
    //   49: aconst_null
    //   50: astore_3
    //   51: aload_2
    //   52: aload_1
    //   53: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 69	java/io/InputStream:available	()I
    //   61: newarray byte
    //   63: astore 5
    //   65: aload_2
    //   66: aload 5
    //   68: invokevirtual 73	java/io/InputStream:read	([B)I
    //   71: pop
    //   72: aload_0
    //   73: aload_1
    //   74: iconst_0
    //   75: invokevirtual 77	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   78: astore_0
    //   79: aload_2
    //   80: astore_1
    //   81: aload_0
    //   82: astore_3
    //   83: aload_0
    //   84: aload 5
    //   86: invokevirtual 83	java/io/FileOutputStream:write	([B)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_0
    //   92: astore_3
    //   93: aload_0
    //   94: invokevirtual 86	java/io/FileOutputStream:flush	()V
    //   97: aload_2
    //   98: ifnull +10 -> 108
    //   101: aload_2
    //   102: invokevirtual 89	java/io/InputStream:close	()V
    //   105: goto +3 -> 108
    //   108: aload_0
    //   109: ifnull +118 -> 227
    //   112: aload_0
    //   113: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   116: aload 4
    //   118: areturn
    //   119: aload_0
    //   120: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   123: aload 4
    //   125: areturn
    //   126: astore 4
    //   128: goto +32 -> 160
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_3
    //   135: astore_2
    //   136: goto +63 -> 199
    //   139: astore 4
    //   141: aconst_null
    //   142: astore_0
    //   143: goto +17 -> 160
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_3
    //   150: astore_2
    //   151: goto +48 -> 199
    //   154: astore 4
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: astore_2
    //   160: aload_2
    //   161: astore_1
    //   162: aload_0
    //   163: astore_3
    //   164: aload 4
    //   166: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   169: aload_2
    //   170: ifnull +10 -> 180
    //   173: aload_2
    //   174: invokevirtual 89	java/io/InputStream:close	()V
    //   177: goto +3 -> 180
    //   180: aload_0
    //   181: ifnull +13 -> 194
    //   184: aload_0
    //   185: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   188: aconst_null
    //   189: areturn
    //   190: aload_0
    //   191: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_0
    //   197: aload_3
    //   198: astore_2
    //   199: aload_1
    //   200: ifnull +10 -> 210
    //   203: aload_1
    //   204: invokevirtual 89	java/io/InputStream:close	()V
    //   207: goto +3 -> 210
    //   210: aload_2
    //   211: ifnull +14 -> 225
    //   214: aload_2
    //   215: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   218: goto +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   225: aload_0
    //   226: athrow
    //   227: aload 4
    //   229: areturn
    //   230: astore_0
    //   231: goto -112 -> 119
    //   234: astore_0
    //   235: goto -45 -> 190
    //   238: astore_1
    //   239: goto -18 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramContext	android.content.Context
    //   0	242	1	paramString	String
    //   7	208	2	localObject	Object
    //   50	148	3	localContext	android.content.Context
    //   34	90	4	str	String
    //   126	1	4	localIOException1	java.io.IOException
    //   139	1	4	localIOException2	java.io.IOException
    //   154	74	4	localIOException3	java.io.IOException
    //   63	22	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   83	89	126	java/io/IOException
    //   93	97	126	java/io/IOException
    //   57	79	131	finally
    //   57	79	139	java/io/IOException
    //   51	57	146	finally
    //   51	57	154	java/io/IOException
    //   83	89	196	finally
    //   93	97	196	finally
    //   164	169	196	finally
    //   101	105	230	java/io/IOException
    //   112	116	230	java/io/IOException
    //   173	177	234	java/io/IOException
    //   184	188	234	java/io/IOException
    //   203	207	238	java/io/IOException
    //   214	218	238	java/io/IOException
  }
  
  public static int getFileLoadType(String paramString)
  {
    if (isEmpty(paramString)) {
      return 0;
    }
    if ((!paramString.contains("http://")) && (!paramString.contains("https://"))) {
      return 1;
    }
    return 2;
  }
  
  public static String getFileType(String paramString)
  {
    if (paramString.contains("a.png")) {
      return "a.png";
    }
    if (paramString.contains("alpha.mp4")) {
      return "alpha.mp4";
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1) {
      return null;
    }
    return paramString.substring(i + 1);
  }
  
  public static float getMaxValue(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramArrayOfInt[0] = (paramInt2 - paramInt1);
    } else if (Math.abs(paramInt2 - paramArrayOfInt[0]) > paramInt3)
    {
      if (paramInt2 - paramArrayOfInt[0] < 0)
      {
        paramArrayOfInt[0] = (paramInt2 + paramInt3);
        paramInt1 = -paramInt3;
      }
      else
      {
        paramArrayOfInt[0] = (paramInt2 - paramInt3);
        paramInt1 = paramInt3;
      }
    }
    else {
      paramInt1 = paramInt2 - paramArrayOfInt[0];
    }
    return paramInt1;
  }
  
  public static File getRealFileName(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString2.split("/");
    paramString1 = new File(paramString1);
    if (arrayOfString.length > 1)
    {
      int i = 0;
      while (i < arrayOfString.length - 1)
      {
        paramString2 = arrayOfString[i];
        try
        {
          String str1 = new String(paramString2.getBytes("8859_1"), "GB2312");
          paramString2 = str1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          localUnsupportedEncodingException1.printStackTrace();
        }
        paramString1 = new File(paramString1, paramString2);
        i += 1;
      }
      if (!paramString1.exists()) {
        paramString1.mkdirs();
      }
      paramString2 = arrayOfString[(arrayOfString.length - 1)];
      try
      {
        String str2 = new String(paramString2.getBytes("8859_1"), "GB2312");
        paramString2 = str2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localUnsupportedEncodingException2.printStackTrace();
      }
      return new File(paramString1, paramString2);
    }
    return new File(paramString1, paramString2);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  /* Error */
  public static String loadShaderFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +393 -> 394
    //   4: aload_0
    //   5: invokevirtual 165	java/lang/String:isEmpty	()Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 15	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 168	java/io/File:isDirectory	()Z
    //   26: ifne +281 -> 307
    //   29: aload_0
    //   30: invokevirtual 22	java/io/File:exists	()Z
    //   33: ifne +6 -> 39
    //   36: goto +271 -> 307
    //   39: new 170	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 173	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_0
    //   48: new 31	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   55: astore_1
    //   56: new 175	java/io/BufferedReader
    //   59: dup
    //   60: new 177	java/io/InputStreamReader
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 180	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   68: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +19 -> 97
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_1
    //   88: ldc 188
    //   90: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: goto -22 -> 72
    //   97: aload_0
    //   98: invokevirtual 89	java/io/InputStream:close	()V
    //   101: goto +38 -> 139
    //   104: astore_0
    //   105: new 31	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   112: astore_2
    //   113: aload_2
    //   114: ldc 190
    //   116: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_2
    //   121: aload_0
    //   122: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   125: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: ldc 192
    //   131: aload_2
    //   132: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: pop
    //   139: aload_1
    //   140: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: areturn
    //   144: astore_1
    //   145: goto +81 -> 226
    //   148: astore_1
    //   149: new 31	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   156: astore_2
    //   157: aload_2
    //   158: ldc 200
    //   160: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: aload_1
    //   166: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   169: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 192
    //   175: aload_2
    //   176: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   182: pop
    //   183: aload_0
    //   184: invokevirtual 89	java/io/InputStream:close	()V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_0
    //   190: new 31	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   197: astore_1
    //   198: aload_1
    //   199: ldc 190
    //   201: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_1
    //   206: aload_0
    //   207: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   210: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: ldc 192
    //   216: aload_1
    //   217: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   223: pop
    //   224: aconst_null
    //   225: areturn
    //   226: aload_0
    //   227: invokevirtual 89	java/io/InputStream:close	()V
    //   230: goto +38 -> 268
    //   233: astore_0
    //   234: new 31	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   241: astore_2
    //   242: aload_2
    //   243: ldc 190
    //   245: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_2
    //   250: aload_0
    //   251: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   254: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 192
    //   260: aload_2
    //   261: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   267: pop
    //   268: aload_1
    //   269: athrow
    //   270: astore_0
    //   271: new 31	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   278: astore_1
    //   279: aload_1
    //   280: ldc 202
    //   282: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: aload_0
    //   288: invokevirtual 203	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   291: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 192
    //   297: aload_1
    //   298: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   304: pop
    //   305: aconst_null
    //   306: areturn
    //   307: new 31	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   314: astore_1
    //   315: aload_1
    //   316: ldc 205
    //   318: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_1
    //   323: aload_0
    //   324: invokevirtual 168	java/io/File:isDirectory	()Z
    //   327: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_1
    //   332: ldc 210
    //   334: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_1
    //   339: aload_0
    //   340: invokevirtual 22	java/io/File:exists	()Z
    //   343: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: ldc 192
    //   349: aload_1
    //   350: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   356: pop
    //   357: aconst_null
    //   358: areturn
    //   359: astore_0
    //   360: new 31	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   367: astore_1
    //   368: aload_1
    //   369: ldc 212
    //   371: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: aload_0
    //   377: invokevirtual 213	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   380: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: ldc 192
    //   386: aload_1
    //   387: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 198	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   393: pop
    //   394: aconst_null
    //   395: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramString	String
    //   55	85	1	localStringBuilder1	StringBuilder
    //   144	1	1	localObject1	Object
    //   148	18	1	localIOException	java.io.IOException
    //   197	190	1	localStringBuilder2	StringBuilder
    //   71	190	2	localObject2	Object
    //   76	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   97	101	104	java/io/IOException
    //   56	72	144	finally
    //   72	77	144	finally
    //   81	94	144	finally
    //   149	183	144	finally
    //   56	72	148	java/io/IOException
    //   72	77	148	java/io/IOException
    //   81	94	148	java/io/IOException
    //   183	187	189	java/io/IOException
    //   226	230	233	java/io/IOException
    //   39	48	270	java/io/FileNotFoundException
    //   13	22	359	java/lang/NullPointerException
  }
  
  /* Error */
  public static String readFile(String paramString)
  {
    // Byte code:
    //   0: new 216	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 217	java/lang/StringBuffer:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_1
    //   13: new 175	java/io/BufferedReader
    //   16: dup
    //   17: new 177	java/io/InputStreamReader
    //   20: dup
    //   21: new 170	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: ldc 220
    //   31: invokespecial 223	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   34: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +13 -> 57
    //   47: aload 4
    //   49: aload_1
    //   50: invokevirtual 226	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   53: pop
    //   54: goto -16 -> 38
    //   57: aload_0
    //   58: invokevirtual 227	java/io/BufferedReader:close	()V
    //   61: goto +44 -> 105
    //   64: astore_2
    //   65: aload_0
    //   66: astore_1
    //   67: aload_2
    //   68: astore_0
    //   69: goto +42 -> 111
    //   72: astore_2
    //   73: goto +10 -> 83
    //   76: astore_0
    //   77: goto +34 -> 111
    //   80: astore_2
    //   81: aload_3
    //   82: astore_0
    //   83: aload_0
    //   84: astore_1
    //   85: aload_2
    //   86: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   89: aload_0
    //   90: ifnull +15 -> 105
    //   93: aload_0
    //   94: invokevirtual 227	java/io/BufferedReader:close	()V
    //   97: goto +8 -> 105
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   105: aload 4
    //   107: invokevirtual 228	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   110: areturn
    //   111: aload_1
    //   112: ifnull +15 -> 127
    //   115: aload_1
    //   116: invokevirtual 227	java/io/BufferedReader:close	()V
    //   119: goto +8 -> 127
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   127: goto +5 -> 132
    //   130: aload_0
    //   131: athrow
    //   132: goto -2 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramString	String
    //   12	104	1	str	String
    //   122	2	1	localIOException1	java.io.IOException
    //   64	4	2	localObject1	Object
    //   72	1	2	localIOException2	java.io.IOException
    //   80	6	2	localIOException3	java.io.IOException
    //   10	72	3	localObject2	Object
    //   7	99	4	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   38	43	64	finally
    //   47	54	64	finally
    //   57	61	64	finally
    //   38	43	72	java/io/IOException
    //   47	54	72	java/io/IOException
    //   57	61	72	java/io/IOException
    //   13	38	76	finally
    //   85	89	76	finally
    //   13	38	80	java/io/IOException
    //   93	97	100	java/io/IOException
    //   115	119	122	java/io/IOException
  }
  
  public static void upZipFile(File paramFile, String paramString)
  {
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    paramFile = new ZipFile(paramFile);
    localObject1 = paramFile.entries();
    byte[] arrayOfByte = new byte[1024];
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject2 = (ZipEntry)((Enumeration)localObject1).nextElement();
      if ((((ZipEntry)localObject2).getName() != null) && (!((ZipEntry)localObject2).getName().contains("../")))
      {
        Object localObject3;
        if (((ZipEntry)localObject2).isDirectory())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(((ZipEntry)localObject2).getName());
          new File(new String(((StringBuilder)localObject3).toString().getBytes("8859_1"), "GB2312")).mkdir();
        }
        else if (!getRealFileName(paramString, ((ZipEntry)localObject2).getName()).exists())
        {
          localObject3 = new BufferedOutputStream(new FileOutputStream(getRealFileName(paramString, ((ZipEntry)localObject2).getName())));
          localObject2 = new BufferedInputStream(paramFile.getInputStream((ZipEntry)localObject2));
          for (;;)
          {
            int i = ((InputStream)localObject2).read(arrayOfByte, 0, 1024);
            if (i == -1) {
              break;
            }
            ((OutputStream)localObject3).write(arrayOfByte, 0, i);
          }
          ((InputStream)localObject2).close();
          ((OutputStream)localObject3).close();
        }
      }
    }
    paramFile.close();
  }
  
  public static void updateGravityData(View paramView, float[] paramArrayOfFloat, SensorParams paramSensorParams, boolean paramBoolean)
  {
    if (paramSensorParams != null)
    {
      int i = (int)(paramArrayOfFloat[0] * paramSensorParams.layerOffsetX * paramSensorParams.speed);
      int j = (int)(paramArrayOfFloat[1] * paramSensorParams.layerOffsetY * paramSensorParams.speed);
      if (!paramSensorParams.isInit)
      {
        paramSensorParams.isInit = true;
        paramSensorParams.offsetX[0] = i;
        paramSensorParams.offsetY[0] = j;
        return;
      }
      paramView.setTranslationX(getMaxValue((int)paramView.getTranslationX(), i, Math.abs(paramSensorParams.layerOffsetX), paramSensorParams.offsetX, paramBoolean));
      paramView.setTranslationY(getMaxValue((int)paramView.getTranslationY(), j, Math.abs(paramSensorParams.layerOffsetY), paramSensorParams.offsetY, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qq.effect.utils.QEffectUtils
 * JD-Core Version:    0.7.0.1
 */