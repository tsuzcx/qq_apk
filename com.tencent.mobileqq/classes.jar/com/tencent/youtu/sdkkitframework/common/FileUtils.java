package com.tencent.youtu.sdkkitframework.common;

import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileUtils
{
  private static String TAG = FileUtils.class.getSimpleName();
  private static Map<String, String> mLoadedLibrary = new HashMap();
  
  private FileUtils()
  {
    throw new AssertionError();
  }
  
  public static boolean copyAsset(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    try
    {
      paramAssetManager = paramAssetManager.open(paramString1);
      new File(paramString2).createNewFile();
      paramString1 = new FileOutputStream(paramString2);
      copyFile(paramAssetManager, paramString1);
      paramAssetManager.close();
      paramString1.flush();
      paramString1.close();
      return true;
    }
    catch (Exception paramAssetManager)
    {
      paramAssetManager.printStackTrace();
    }
    return false;
  }
  
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
  
  public static void loadLibrary(String paramString)
  {
    if (mLoadedLibrary.get(paramString) == null)
    {
      YtLogger.i(TAG, "[YTUtils.loadLibrary] " + System.getProperty("java.library.path"));
      System.loadLibrary(paramString);
      mLoadedLibrary.put(paramString, "loaded");
    }
  }
  
  /* Error */
  public static java.lang.StringBuilder readAssetFile(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 88	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 126
    //   6: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: new 129	java/io/BufferedReader
    //   13: dup
    //   14: new 131	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokevirtual 137	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   22: invokevirtual 143	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   25: aload_1
    //   26: invokevirtual 41	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   32: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +68 -> 112
    //   47: aload_1
    //   48: astore_0
    //   49: aload_2
    //   50: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: ldc 126
    //   55: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +12 -> 70
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: ldc 160
    //   66: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: aload_3
    //   74: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -42 -> 36
    //   81: astore_2
    //   82: aload_1
    //   83: astore_0
    //   84: aload_2
    //   85: astore_1
    //   86: new 162	java/lang/RuntimeException
    //   89: dup
    //   90: ldc 164
    //   92: aload_1
    //   93: invokespecial 167	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: astore_2
    //   98: aload_0
    //   99: astore_1
    //   100: aload_2
    //   101: astore_0
    //   102: aload_1
    //   103: ifnull +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 168	java/io/BufferedReader:close	()V
    //   110: aload_0
    //   111: athrow
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 168	java/io/BufferedReader:close	()V
    //   120: aload_2
    //   121: areturn
    //   122: astore_0
    //   123: new 162	java/lang/RuntimeException
    //   126: dup
    //   127: ldc 164
    //   129: aload_0
    //   130: invokespecial 167	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: athrow
    //   134: astore_0
    //   135: new 162	java/lang/RuntimeException
    //   138: dup
    //   139: ldc 164
    //   141: aload_0
    //   142: invokespecial 167	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: athrow
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -47 -> 102
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -69 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	android.content.Context
    //   0	158	1	paramString	String
    //   9	64	2	localStringBuilder1	java.lang.StringBuilder
    //   81	4	2	localIOException	java.io.IOException
    //   97	24	2	localStringBuilder2	java.lang.StringBuilder
    //   42	32	3	str	String
    // Exception table:
    //   from	to	target	type
    //   38	43	81	java/io/IOException
    //   49	61	81	java/io/IOException
    //   63	70	81	java/io/IOException
    //   72	78	81	java/io/IOException
    //   38	43	97	finally
    //   49	61	97	finally
    //   63	70	97	finally
    //   72	78	97	finally
    //   86	97	97	finally
    //   116	120	122	java/io/IOException
    //   106	110	134	java/io/IOException
    //   10	36	146	finally
    //   10	36	152	java/io/IOException
  }
  
  /* Error */
  public static java.lang.StringBuilder readFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 43	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 88	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 126
    //   20: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: astore_3
    //   24: aload 4
    //   26: ifnull +11 -> 37
    //   29: aload 4
    //   31: invokevirtual 172	java/io/File:isFile	()Z
    //   34: ifne +7 -> 41
    //   37: aconst_null
    //   38: astore_0
    //   39: aload_0
    //   40: areturn
    //   41: aload_1
    //   42: astore_0
    //   43: new 129	java/io/BufferedReader
    //   46: dup
    //   47: new 131	java/io/InputStreamReader
    //   50: dup
    //   51: new 174	java/io/FileInputStream
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   63: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore_0
    //   72: aload_0
    //   73: ifnull +62 -> 135
    //   76: aload_3
    //   77: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: ldc 126
    //   82: invokevirtual 158	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifne +10 -> 95
    //   88: aload_3
    //   89: ldc 160
    //   91: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: aload_0
    //   97: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: goto -34 -> 67
    //   104: astore_2
    //   105: aload_1
    //   106: astore_0
    //   107: aload_2
    //   108: astore_1
    //   109: new 162	java/lang/RuntimeException
    //   112: dup
    //   113: ldc 164
    //   115: aload_1
    //   116: invokespecial 167	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: athrow
    //   120: astore_2
    //   121: aload_0
    //   122: astore_1
    //   123: aload_2
    //   124: astore_0
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 168	java/io/BufferedReader:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: aload_3
    //   136: astore_0
    //   137: aload_1
    //   138: ifnull -99 -> 39
    //   141: aload_1
    //   142: invokevirtual 168	java/io/BufferedReader:close	()V
    //   145: aload_3
    //   146: areturn
    //   147: astore_0
    //   148: new 162	java/lang/RuntimeException
    //   151: dup
    //   152: ldc 164
    //   154: aload_0
    //   155: invokespecial 167	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: athrow
    //   159: astore_0
    //   160: new 162	java/lang/RuntimeException
    //   163: dup
    //   164: ldc 164
    //   166: aload_0
    //   167: invokespecial 167	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: athrow
    //   171: astore_0
    //   172: goto -47 -> 125
    //   175: astore_1
    //   176: aload_2
    //   177: astore_0
    //   178: goto -69 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramString	String
    //   1	141	1	localObject1	Object
    //   175	1	1	localIOException1	java.io.IOException
    //   3	1	2	localObject2	Object
    //   104	4	2	localIOException2	java.io.IOException
    //   120	57	2	localObject3	Object
    //   23	123	3	localStringBuilder	java.lang.StringBuilder
    //   12	44	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   67	72	104	java/io/IOException
    //   76	95	104	java/io/IOException
    //   95	101	104	java/io/IOException
    //   43	67	120	finally
    //   109	120	120	finally
    //   141	145	147	java/io/IOException
    //   129	133	159	java/io/IOException
    //   67	72	171	finally
    //   76	95	171	finally
    //   95	101	171	finally
    //   43	67	175	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.FileUtils
 * JD-Core Version:    0.7.0.1
 */