package com.tencent.mobileqq.qshadow.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AssetUtil
{
  private static final String SEPARATOR = File.separator;
  private static final String TAG = "FileHelper";
  
  public static void copyFilesFromAssets(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str1 = paramString2;
    if (paramString2.endsWith(SEPARATOR)) {
      str1 = paramString2.substring(0, paramString2.length() - 1);
    }
    label54:
    AssetManager localAssetManager;
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals(SEPARATOR)))
    {
      paramString2 = "";
      localAssetManager = paramContext.getAssets();
    }
    for (;;)
    {
      String str2;
      Object localObject;
      try
      {
        paramString1 = new File(str1);
        if ((!paramString1.exists()) && (!paramString1.mkdirs())) {
          Log.i("FileHelper", "create file error! file: " + paramString1.getAbsolutePath());
        }
        String[] arrayOfString = localAssetManager.list(paramString2);
        if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
          break label340;
        }
        int j = arrayOfString.length;
        paramString1 = "";
        int i = 0;
        if (i >= j) {
          break;
        }
        str2 = arrayOfString[i];
        boolean bool = TextUtils.isEmpty(str2);
        if (bool)
        {
          i += 1;
          continue;
          paramString2 = paramString1;
          if (!paramString1.endsWith(SEPARATOR)) {
            break label54;
          }
          paramString2 = paramString1.substring(0, paramString1.length() - 1);
          break label54;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          paramString1 = paramString2 + SEPARATOR + str2;
        }
        localObject = localAssetManager.list(paramString1);
        if ((!TextUtils.isEmpty(paramString1)) && (localObject != null) && (localObject.length > 0))
        {
          copyFilesFromAssets(paramContext, paramString1, str1 + SEPARATOR + str2);
          continue;
        }
        localObject = localAssetManager.open(paramString1);
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      readInputStream(str1 + SEPARATOR + str2, (InputStream)localObject);
    }
    label340:
    paramString1 = localAssetManager.open(paramString2);
    paramContext = paramString2;
    if (paramString2.contains(SEPARATOR)) {
      paramContext = paramString2.substring(paramString2.lastIndexOf(SEPARATOR), paramString2.length());
    }
    readInputStream(str1 + SEPARATOR + paramContext, paramString1);
  }
  
  public static boolean isFileExists(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.list(paramString1);
      if (paramContext == null) {
        return false;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramContext[i].equals(paramString2.trim());
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  /* Error */
  public static void readInputStream(String paramString, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 13	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 126	java/io/File:delete	()Z
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 65	java/io/File:exists	()Z
    //   18: ifne +221 -> 239
    //   21: new 128	java/io/FileOutputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: astore_3
    //   30: aload_3
    //   31: astore_0
    //   32: aload_1
    //   33: invokevirtual 136	java/io/InputStream:available	()I
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_3
    //   41: astore_0
    //   42: aload_1
    //   43: aload 4
    //   45: invokevirtual 140	java/io/InputStream:read	([B)I
    //   48: istore_2
    //   49: iload_2
    //   50: iconst_m1
    //   51: if_icmpeq +42 -> 93
    //   54: aload_3
    //   55: astore_0
    //   56: aload_3
    //   57: aload 4
    //   59: iconst_0
    //   60: iload_2
    //   61: invokevirtual 144	java/io/FileOutputStream:write	([BII)V
    //   64: goto -24 -> 40
    //   67: astore 4
    //   69: aload_3
    //   70: astore_0
    //   71: aload 4
    //   73: invokevirtual 145	java/io/FileNotFoundException:printStackTrace	()V
    //   76: aload_3
    //   77: ifnull +7 -> 84
    //   80: aload_3
    //   81: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 149	java/io/InputStream:close	()V
    //   92: return
    //   93: aload_3
    //   94: astore_0
    //   95: aload_3
    //   96: invokevirtual 152	java/io/FileOutputStream:flush	()V
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   107: aload_1
    //   108: ifnull -16 -> 92
    //   111: aload_1
    //   112: invokevirtual 149	java/io/InputStream:close	()V
    //   115: return
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   127: goto -20 -> 107
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   135: goto -51 -> 84
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   143: return
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_3
    //   148: aload_3
    //   149: astore_0
    //   150: aload 4
    //   152: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   163: aload_1
    //   164: ifnull -72 -> 92
    //   167: aload_1
    //   168: invokevirtual 149	java/io/InputStream:close	()V
    //   171: return
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   177: return
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   183: goto -20 -> 163
    //   186: astore_3
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: ifnull +7 -> 197
    //   193: aload_0
    //   194: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 149	java/io/InputStream:close	()V
    //   205: aload_3
    //   206: athrow
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   212: goto -15 -> 197
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 101	java/io/IOException:printStackTrace	()V
    //   220: goto -15 -> 205
    //   223: astore_3
    //   224: goto -35 -> 189
    //   227: astore 4
    //   229: goto -81 -> 148
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_3
    //   236: goto -167 -> 69
    //   239: aconst_null
    //   240: astore_3
    //   241: goto -142 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramString	String
    //   0	244	1	paramInputStream	InputStream
    //   48	13	2	i	int
    //   29	131	3	localFileOutputStream	java.io.FileOutputStream
    //   186	20	3	localObject1	Object
    //   223	1	3	localObject2	Object
    //   235	6	3	localObject3	Object
    //   38	20	4	arrayOfByte	byte[]
    //   67	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   144	7	4	localIOException1	IOException
    //   227	1	4	localIOException2	IOException
    //   232	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   32	40	67	java/io/FileNotFoundException
    //   42	49	67	java/io/FileNotFoundException
    //   56	64	67	java/io/FileNotFoundException
    //   95	99	67	java/io/FileNotFoundException
    //   111	115	116	java/io/IOException
    //   103	107	122	java/io/IOException
    //   80	84	130	java/io/IOException
    //   88	92	138	java/io/IOException
    //   9	30	144	java/io/IOException
    //   167	171	172	java/io/IOException
    //   159	163	178	java/io/IOException
    //   9	30	186	finally
    //   193	197	207	java/io/IOException
    //   201	205	215	java/io/IOException
    //   32	40	223	finally
    //   42	49	223	finally
    //   56	64	223	finally
    //   71	76	223	finally
    //   95	99	223	finally
    //   150	155	223	finally
    //   32	40	227	java/io/IOException
    //   42	49	227	java/io/IOException
    //   56	64	227	java/io/IOException
    //   95	99	227	java/io/IOException
    //   9	30	232	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.AssetUtil
 * JD-Core Version:    0.7.0.1
 */