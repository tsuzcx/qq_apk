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
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString1.substring(paramString1.lastIndexOf(File.separator));
    paramContext = paramContext.getAssets();
    try
    {
      File localFile = new File(paramString2);
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("create file error! file: ");
        localStringBuilder.append(localFile.getAbsolutePath());
        Log.i("FileHelper", localStringBuilder.toString());
      }
      paramContext = paramContext.open(paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(SEPARATOR);
      paramString1.append(str);
      readInputStream(paramString1.toString(), paramContext);
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean isFileExists(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext.open(paramString).close();
      return true;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static void readInputStream(String paramString, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 13	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_0
    //   11: aload_3
    //   12: invokevirtual 105	java/io/File:delete	()Z
    //   15: pop
    //   16: aload_3
    //   17: invokevirtual 55	java/io/File:exists	()Z
    //   20: ifne +70 -> 90
    //   23: new 107	java/io/FileOutputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 114	java/io/InputStream:available	()I
    //   38: newarray byte
    //   40: astore 4
    //   42: aload_3
    //   43: astore_0
    //   44: aload_1
    //   45: aload 4
    //   47: invokevirtual 118	java/io/InputStream:read	([B)I
    //   50: istore_2
    //   51: iload_2
    //   52: iconst_m1
    //   53: if_icmpeq +16 -> 69
    //   56: aload_3
    //   57: astore_0
    //   58: aload_3
    //   59: aload 4
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 122	java/io/FileOutputStream:write	([BII)V
    //   66: goto -24 -> 42
    //   69: aload_3
    //   70: astore_0
    //   71: aload_3
    //   72: invokevirtual 125	java/io/FileOutputStream:flush	()V
    //   75: aload_3
    //   76: astore_0
    //   77: goto +13 -> 90
    //   80: astore 4
    //   82: goto +43 -> 125
    //   85: astore 4
    //   87: goto +74 -> 161
    //   90: aload_0
    //   91: ifnull +15 -> 106
    //   94: aload_0
    //   95: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   98: goto +8 -> 106
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull +91 -> 198
    //   110: aload_1
    //   111: invokevirtual 100	java/io/InputStream:close	()V
    //   114: return
    //   115: astore_3
    //   116: aconst_null
    //   117: astore_0
    //   118: goto +82 -> 200
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_3
    //   126: astore_0
    //   127: aload 4
    //   129: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   132: aload_3
    //   133: ifnull +15 -> 148
    //   136: aload_3
    //   137: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   140: goto +8 -> 148
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   148: aload_1
    //   149: ifnull +49 -> 198
    //   152: aload_1
    //   153: invokevirtual 100	java/io/InputStream:close	()V
    //   156: return
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_3
    //   161: aload_3
    //   162: astore_0
    //   163: aload 4
    //   165: invokevirtual 127	java/io/FileNotFoundException:printStackTrace	()V
    //   168: aload_3
    //   169: ifnull +15 -> 184
    //   172: aload_3
    //   173: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   176: goto +8 -> 184
    //   179: astore_0
    //   180: aload_0
    //   181: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   184: aload_1
    //   185: ifnull +13 -> 198
    //   188: aload_1
    //   189: invokevirtual 100	java/io/InputStream:close	()V
    //   192: return
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   198: return
    //   199: astore_3
    //   200: aload_0
    //   201: ifnull +15 -> 216
    //   204: aload_0
    //   205: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   208: goto +8 -> 216
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   216: aload_1
    //   217: ifnull +15 -> 232
    //   220: aload_1
    //   221: invokevirtual 100	java/io/InputStream:close	()V
    //   224: goto +8 -> 232
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   232: goto +5 -> 237
    //   235: aload_3
    //   236: athrow
    //   237: goto -2 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramInputStream	InputStream
    //   50	13	2	i	int
    //   8	68	3	localObject1	Object
    //   115	1	3	localObject2	Object
    //   124	49	3	localObject3	Object
    //   199	37	3	localObject4	Object
    //   40	20	4	arrayOfByte	byte[]
    //   80	1	4	localIOException1	IOException
    //   85	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   121	7	4	localIOException2	IOException
    //   157	7	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   34	42	80	java/io/IOException
    //   44	51	80	java/io/IOException
    //   58	66	80	java/io/IOException
    //   71	75	80	java/io/IOException
    //   34	42	85	java/io/FileNotFoundException
    //   44	51	85	java/io/FileNotFoundException
    //   58	66	85	java/io/FileNotFoundException
    //   71	75	85	java/io/FileNotFoundException
    //   94	98	101	java/io/IOException
    //   11	16	115	finally
    //   16	32	115	finally
    //   11	16	121	java/io/IOException
    //   16	32	121	java/io/IOException
    //   136	140	143	java/io/IOException
    //   11	16	157	java/io/FileNotFoundException
    //   16	32	157	java/io/FileNotFoundException
    //   172	176	179	java/io/IOException
    //   110	114	193	java/io/IOException
    //   152	156	193	java/io/IOException
    //   188	192	193	java/io/IOException
    //   34	42	199	finally
    //   44	51	199	finally
    //   58	66	199	finally
    //   71	75	199	finally
    //   127	132	199	finally
    //   163	168	199	finally
    //   204	208	211	java/io/IOException
    //   220	224	227	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.AssetUtil
 * JD-Core Version:    0.7.0.1
 */