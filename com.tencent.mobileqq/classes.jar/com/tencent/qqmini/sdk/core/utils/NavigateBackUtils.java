package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import java.io.File;

public class NavigateBackUtils
{
  public static final String NAVIGATE_BACK_APPID_FILE_PATH;
  public static final String PATH_WXAPKG_ROOT;
  public static final String TAG = "NavigateBackUtils";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppLoaderFactory.g().getContext().getFilesDir().getPath());
    localStringBuilder.append("/mini/");
    PATH_WXAPKG_ROOT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PATH_WXAPKG_ROOT);
    localStringBuilder.append("navigateback_appid");
    NAVIGATE_BACK_APPID_FILE_PATH = localStringBuilder.toString();
  }
  
  public static void clearTag()
  {
    deleteFile(new File(NAVIGATE_BACK_APPID_FILE_PATH));
  }
  
  private static void deleteFile(File paramFile)
  {
    if (paramFile.exists()) {
      paramFile.delete();
    }
  }
  
  public static String getTagAppid()
  {
    return getTagAppidInner(new File(NAVIGATE_BACK_APPID_FILE_PATH));
  }
  
  /* Error */
  private static String getTagAppidInner(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 68	java/io/File:exists	()Z
    //   4: ifeq +88 -> 92
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_1
    //   11: new 80	java/io/BufferedReader
    //   14: dup
    //   15: new 82	java/io/FileReader
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 84	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   23: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_1
    //   32: aload_0
    //   33: invokevirtual 93	java/io/BufferedReader:close	()V
    //   36: aload_0
    //   37: invokevirtual 93	java/io/BufferedReader:close	()V
    //   40: aload_1
    //   41: areturn
    //   42: astore_2
    //   43: aload_0
    //   44: astore_1
    //   45: aload_2
    //   46: astore_0
    //   47: goto +35 -> 82
    //   50: astore_2
    //   51: goto +10 -> 61
    //   54: astore_0
    //   55: goto +27 -> 82
    //   58: astore_2
    //   59: aload_3
    //   60: astore_0
    //   61: aload_0
    //   62: astore_1
    //   63: ldc 10
    //   65: ldc 95
    //   67: aload_2
    //   68: invokestatic 101	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_0
    //   72: ifnull +20 -> 92
    //   75: aload_0
    //   76: invokevirtual 93	java/io/BufferedReader:close	()V
    //   79: goto +13 -> 92
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 93	java/io/BufferedReader:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: ldc 103
    //   94: areturn
    //   95: astore_0
    //   96: aload_1
    //   97: areturn
    //   98: astore_0
    //   99: goto -7 -> 92
    //   102: astore_1
    //   103: goto -13 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramFile	File
    //   10	87	1	localObject1	Object
    //   102	1	1	localException1	java.lang.Exception
    //   42	4	2	localObject2	Object
    //   50	1	2	localException2	java.lang.Exception
    //   58	10	2	localException3	java.lang.Exception
    //   8	52	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	36	42	finally
    //   27	36	50	java/lang/Exception
    //   11	27	54	finally
    //   63	71	54	finally
    //   11	27	58	java/lang/Exception
    //   36	40	95	java/lang/Exception
    //   75	79	98	java/lang/Exception
    //   86	90	102	java/lang/Exception
  }
  
  public static void writeTagAppid(String paramString)
  {
    writeTagAppidInner(new File(NAVIGATE_BACK_APPID_FILE_PATH), paramString);
  }
  
  /* Error */
  private static void writeTagAppidInner(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 110	java/io/BufferedWriter
    //   7: dup
    //   8: new 112	java/io/FileWriter
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 113	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   16: invokespecial 116	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   19: astore_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 119	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   29: aload_0
    //   30: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: astore_2
    //   37: aload_1
    //   38: astore_0
    //   39: goto +33 -> 72
    //   42: astore_1
    //   43: goto +10 -> 53
    //   46: astore_0
    //   47: goto +25 -> 72
    //   50: astore_1
    //   51: aload_3
    //   52: astore_0
    //   53: aload_0
    //   54: astore_2
    //   55: ldc 10
    //   57: ldc 95
    //   59: aload_1
    //   60: invokestatic 101	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   71: return
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   80: aload_0
    //   81: athrow
    //   82: astore_0
    //   83: return
    //   84: astore_1
    //   85: goto -5 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramFile	File
    //   0	88	1	paramString	String
    //   3	74	2	localFile	File
    //   1	51	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	29	34	finally
    //   20	29	42	java/lang/Exception
    //   4	20	46	finally
    //   55	63	46	finally
    //   4	20	50	java/lang/Exception
    //   29	33	82	java/lang/Exception
    //   67	71	82	java/lang/Exception
    //   76	80	84	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.NavigateBackUtils
 * JD-Core Version:    0.7.0.1
 */