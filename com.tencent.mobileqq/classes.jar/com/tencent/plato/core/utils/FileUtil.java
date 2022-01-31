package com.tencent.plato.core.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil
{
  public static String loadAsset(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramContext = readStream2String(paramContext.getAssets().open(paramString));
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String loadFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while (!paramString.exists());
    try
    {
      paramString = readStream2String(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String loadFileOrAsset(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("/android_asset/")) {
        return loadAsset(paramContext, paramString.substring("/android_asset/".length()));
      }
      return loadFile(paramString);
    }
    return null;
  }
  
  public static byte[] readStream2Byte(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramInputStream;
  }
  
  /* Error */
  public static String readStream2String(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_3
    //   6: astore_2
    //   7: new 103	java/lang/StringBuilder
    //   10: dup
    //   11: aload_0
    //   12: invokevirtual 106	java/io/InputStream:available	()I
    //   15: bipush 10
    //   17: iadd
    //   18: invokespecial 109	java/lang/StringBuilder:<init>	(I)V
    //   21: astore 5
    //   23: aload_3
    //   24: astore_2
    //   25: new 111	java/io/BufferedReader
    //   28: dup
    //   29: new 113	java/io/InputStreamReader
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 116	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 119	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_3
    //   41: sipush 4096
    //   44: newarray char
    //   46: astore_2
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 122	java/io/BufferedReader:read	([C)I
    //   52: istore_1
    //   53: iload_1
    //   54: ifle +41 -> 95
    //   57: aload 5
    //   59: aload_2
    //   60: iconst_0
    //   61: iload_1
    //   62: invokevirtual 126	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: goto -19 -> 47
    //   69: astore 4
    //   71: aload_3
    //   72: astore_2
    //   73: aload 4
    //   75: invokevirtual 38	java/io/IOException:printStackTrace	()V
    //   78: aload_3
    //   79: astore_2
    //   80: aload 4
    //   82: invokestatic 132	com/tencent/plato/core/utils/PLog:dumpStack	(Ljava/lang/Throwable;)V
    //   85: aload_3
    //   86: invokestatic 137	com/tencent/plato/core/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   89: aload_0
    //   90: invokestatic 137	com/tencent/plato/core/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   93: aconst_null
    //   94: areturn
    //   95: aload 5
    //   97: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_2
    //   101: aload_3
    //   102: invokestatic 137	com/tencent/plato/core/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   105: aload_0
    //   106: invokestatic 137	com/tencent/plato/core/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   109: aload_2
    //   110: areturn
    //   111: astore_3
    //   112: aload_2
    //   113: invokestatic 137	com/tencent/plato/core/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   116: aload_0
    //   117: invokestatic 137	com/tencent/plato/core/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   120: aload_3
    //   121: athrow
    //   122: astore 4
    //   124: aload_3
    //   125: astore_2
    //   126: aload 4
    //   128: astore_3
    //   129: goto -17 -> 112
    //   132: astore_2
    //   133: aload 4
    //   135: astore_3
    //   136: aload_2
    //   137: astore 4
    //   139: goto -68 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramInputStream	InputStream
    //   52	10	1	i	int
    //   6	120	2	localObject1	Object
    //   132	5	2	localIOException1	IOException
    //   1	101	3	localBufferedReader	java.io.BufferedReader
    //   111	14	3	localObject2	Object
    //   128	8	3	localObject3	Object
    //   3	1	4	localObject4	Object
    //   69	12	4	localIOException2	IOException
    //   122	12	4	localObject5	Object
    //   137	1	4	localObject6	Object
    //   21	75	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	47	69	java/io/IOException
    //   47	53	69	java/io/IOException
    //   57	66	69	java/io/IOException
    //   95	101	69	java/io/IOException
    //   7	23	111	finally
    //   25	41	111	finally
    //   73	78	111	finally
    //   80	85	111	finally
    //   41	47	122	finally
    //   47	53	122	finally
    //   57	66	122	finally
    //   95	101	122	finally
    //   7	23	132	java/io/IOException
    //   25	41	132	java/io/IOException
  }
  
  public static void saveToFile(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramString1 = new File(Ev.appContext().getFilesDir() + "/" + paramString1);
    }
    try
    {
      if (paramString1.exists()) {
        paramString1.delete();
      }
      paramString1.createNewFile();
      FileOutputStream localFileOutputStream = Ev.appContext().openFileOutput(paramString1.getName(), 0);
      localFileOutputStream.write(paramString2.getBytes());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      Toast.makeText(Ev.appContext(), "文件已保存：\n" + paramString1.getName(), 1).show();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */