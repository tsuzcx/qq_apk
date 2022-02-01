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
  private static String TAG = "FileUtils";
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[YTUtils.loadLibrary] ");
      localStringBuilder.append(System.getProperty("java.library.path"));
      YtLogger.i(str, localStringBuilder.toString());
      System.loadLibrary(paramString);
      mLoadedLibrary.put(paramString, "loaded");
    }
  }
  
  /* Error */
  public static StringBuilder readAssetFile(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 84	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 123
    //   6: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: new 126	java/io/BufferedReader
    //   18: dup
    //   19: new 128	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: invokevirtual 140	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   30: aload_1
    //   31: invokevirtual 35	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +34 -> 81
    //   50: aload 4
    //   52: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: ldc 123
    //   57: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifne +11 -> 71
    //   63: aload 4
    //   65: ldc 157
    //   67: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: aload_1
    //   74: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -37 -> 41
    //   81: aload_0
    //   82: invokevirtual 158	java/io/BufferedReader:close	()V
    //   85: aload 4
    //   87: areturn
    //   88: astore_0
    //   89: new 160	java/lang/RuntimeException
    //   92: dup
    //   93: ldc 162
    //   95: aload_0
    //   96: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    //   100: astore_1
    //   101: aload_0
    //   102: astore_2
    //   103: aload_1
    //   104: astore_0
    //   105: goto +29 -> 134
    //   108: astore_1
    //   109: aload_0
    //   110: astore_2
    //   111: aload_1
    //   112: astore_0
    //   113: goto +10 -> 123
    //   116: astore_0
    //   117: goto +17 -> 134
    //   120: astore_0
    //   121: aload_3
    //   122: astore_2
    //   123: new 160	java/lang/RuntimeException
    //   126: dup
    //   127: ldc 162
    //   129: aload_0
    //   130: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: athrow
    //   134: aload_2
    //   135: ifnull +22 -> 157
    //   138: aload_2
    //   139: invokevirtual 158	java/io/BufferedReader:close	()V
    //   142: goto +15 -> 157
    //   145: astore_0
    //   146: new 160	java/lang/RuntimeException
    //   149: dup
    //   150: ldc 162
    //   152: aload_0
    //   153: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: athrow
    //   157: goto +5 -> 162
    //   160: aload_0
    //   161: athrow
    //   162: goto -2 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramContext	android.content.Context
    //   0	165	1	paramString	String
    //   14	125	2	localObject1	Object
    //   12	110	3	localObject2	Object
    //   9	77	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   81	85	88	java/io/IOException
    //   41	46	100	finally
    //   50	71	100	finally
    //   71	78	100	finally
    //   41	46	108	java/io/IOException
    //   50	71	108	java/io/IOException
    //   71	78	108	java/io/IOException
    //   15	41	116	finally
    //   123	134	116	finally
    //   15	41	120	java/io/IOException
    //   138	142	145	java/io/IOException
  }
  
  /* Error */
  public static StringBuilder readFile(String paramString)
  {
    // Byte code:
    //   0: new 37	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: new 84	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 123
    //   15: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload_2
    //   21: invokevirtual 169	java/io/File:isFile	()Z
    //   24: istore_1
    //   25: aconst_null
    //   26: astore_3
    //   27: aconst_null
    //   28: astore_0
    //   29: iload_1
    //   30: ifne +5 -> 35
    //   33: aconst_null
    //   34: areturn
    //   35: new 126	java/io/BufferedReader
    //   38: dup
    //   39: new 128	java/io/InputStreamReader
    //   42: dup
    //   43: new 171	java/io/FileInputStream
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 174	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +34 -> 98
    //   67: aload 4
    //   69: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: ldc 123
    //   74: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifne +11 -> 88
    //   80: aload 4
    //   82: ldc 157
    //   84: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: aload_0
    //   91: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: goto -37 -> 58
    //   98: aload_2
    //   99: invokevirtual 158	java/io/BufferedReader:close	()V
    //   102: aload 4
    //   104: areturn
    //   105: astore_0
    //   106: new 160	java/lang/RuntimeException
    //   109: dup
    //   110: ldc 162
    //   112: aload_0
    //   113: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: athrow
    //   117: astore_3
    //   118: aload_2
    //   119: astore_0
    //   120: aload_3
    //   121: astore_2
    //   122: goto +29 -> 151
    //   125: astore_3
    //   126: aload_2
    //   127: astore_0
    //   128: aload_3
    //   129: astore_2
    //   130: goto +10 -> 140
    //   133: astore_2
    //   134: goto +17 -> 151
    //   137: astore_2
    //   138: aload_3
    //   139: astore_0
    //   140: new 160	java/lang/RuntimeException
    //   143: dup
    //   144: ldc 162
    //   146: aload_2
    //   147: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: athrow
    //   151: aload_0
    //   152: ifnull +22 -> 174
    //   155: aload_0
    //   156: invokevirtual 158	java/io/BufferedReader:close	()V
    //   159: goto +15 -> 174
    //   162: astore_0
    //   163: new 160	java/lang/RuntimeException
    //   166: dup
    //   167: ldc 162
    //   169: aload_0
    //   170: invokespecial 165	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: athrow
    //   174: goto +5 -> 179
    //   177: aload_2
    //   178: athrow
    //   179: goto -2 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   24	6	1	bool	boolean
    //   8	122	2	localObject1	Object
    //   133	1	2	localObject2	Object
    //   137	41	2	localIOException1	java.io.IOException
    //   26	1	3	localObject3	Object
    //   117	4	3	localObject4	Object
    //   125	14	3	localIOException2	java.io.IOException
    //   18	85	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   98	102	105	java/io/IOException
    //   58	63	117	finally
    //   67	88	117	finally
    //   88	95	117	finally
    //   58	63	125	java/io/IOException
    //   67	88	125	java/io/IOException
    //   88	95	125	java/io/IOException
    //   35	58	133	finally
    //   140	151	133	finally
    //   35	58	137	java/io/IOException
    //   155	159	162	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.FileUtils
 * JD-Core Version:    0.7.0.1
 */