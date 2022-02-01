package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import java.io.File;

public class NavigateBackUtils
{
  public static final String NAVIGATE_BACK_APPID_FILE_PATH = PATH_WXAPKG_ROOT + "navigateback_appid";
  public static final String PATH_WXAPKG_ROOT = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/";
  public static final String TAG = "NavigateBackUtils";
  
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
    //   4: ifeq +63 -> 67
    //   7: new 80	java/io/BufferedReader
    //   10: dup
    //   11: new 82	java/io/FileReader
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 84	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   19: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_2
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokevirtual 93	java/io/BufferedReader:close	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 93	java/io/BufferedReader:close	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_2
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: astore_0
    //   51: ldc 10
    //   53: ldc 95
    //   55: aload_2
    //   56: invokestatic 101	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_1
    //   60: ifnull +7 -> 67
    //   63: aload_1
    //   64: invokevirtual 93	java/io/BufferedReader:close	()V
    //   67: ldc 103
    //   69: areturn
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 93	java/io/BufferedReader:close	()V
    //   81: aload_1
    //   82: athrow
    //   83: astore_0
    //   84: aload_2
    //   85: areturn
    //   86: astore_0
    //   87: goto -20 -> 67
    //   90: astore_0
    //   91: goto -10 -> 81
    //   94: astore_1
    //   95: goto -22 -> 73
    //   98: astore_2
    //   99: goto -50 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   22	42	1	localBufferedReader	java.io.BufferedReader
    //   70	12	1	localObject1	Object
    //   94	1	1	localObject2	Object
    //   29	16	2	str	String
    //   46	39	2	localException1	java.lang.Exception
    //   98	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	23	46	java/lang/Exception
    //   7	23	70	finally
    //   40	44	83	java/lang/Exception
    //   63	67	86	java/lang/Exception
    //   77	81	90	java/lang/Exception
    //   25	30	94	finally
    //   32	36	94	finally
    //   51	59	94	finally
    //   25	30	98	java/lang/Exception
    //   32	36	98	java/lang/Exception
  }
  
  public static void writeTagAppid(String paramString)
  {
    writeTagAppidInner(new File(NAVIGATE_BACK_APPID_FILE_PATH), paramString);
  }
  
  /* Error */
  private static void writeTagAppidInner(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 110	java/io/BufferedWriter
    //   3: dup
    //   4: new 112	java/io/FileWriter
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 113	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   12: invokespecial 116	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_0
    //   18: aload_2
    //   19: aload_1
    //   20: invokevirtual 119	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   23: aload_2
    //   24: astore_0
    //   25: aload_2
    //   26: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   29: aload_2
    //   30: ifnull +7 -> 37
    //   33: aload_2
    //   34: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   37: return
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: astore_0
    //   43: ldc 10
    //   45: ldc 95
    //   47: aload_3
    //   48: invokestatic 101	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   51: aload_1
    //   52: ifnull -15 -> 37
    //   55: aload_1
    //   56: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   59: return
    //   60: astore_0
    //   61: return
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: ifnull +7 -> 73
    //   69: aload_0
    //   70: invokevirtual 120	java/io/BufferedWriter:close	()V
    //   73: aload_1
    //   74: athrow
    //   75: astore_0
    //   76: return
    //   77: astore_0
    //   78: goto -5 -> 73
    //   81: astore_1
    //   82: goto -17 -> 65
    //   85: astore_3
    //   86: aload_2
    //   87: astore_1
    //   88: goto -47 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramFile	File
    //   0	91	1	paramString	String
    //   15	72	2	localBufferedWriter	java.io.BufferedWriter
    //   38	10	3	localException1	java.lang.Exception
    //   85	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	16	38	java/lang/Exception
    //   55	59	60	java/lang/Exception
    //   0	16	62	finally
    //   33	37	75	java/lang/Exception
    //   69	73	77	java/lang/Exception
    //   18	23	81	finally
    //   25	29	81	finally
    //   43	51	81	finally
    //   18	23	85	java/lang/Exception
    //   25	29	85	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.NavigateBackUtils
 * JD-Core Version:    0.7.0.1
 */