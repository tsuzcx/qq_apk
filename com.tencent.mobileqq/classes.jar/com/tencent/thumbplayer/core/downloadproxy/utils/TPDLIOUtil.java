package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TPDLIOUtil
{
  private static final String FILE_NAME = "TPDLIOUtil";
  private static Pattern PATH_PATTERN = Pattern.compile("^(\\w+):/{2,3}(.*)");
  private static final String PROTOCOL_ASSET = "asset";
  private static final String PROTOCOL_FILE = "file";
  private static final String PROTOCOL_HTTP = "http";
  private static final String PROTOCOL_HTTPS = "https";
  private static Pattern PROTOCOL_PATTERN = Pattern.compile("^(\\w+):/{2,3}");
  
  public static File compare(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {}
    do
    {
      return paramFile2;
      if ((paramFile2 == null) || (!paramFile2.exists())) {
        return paramFile1;
      }
    } while (!paramFile1.exists());
    if (paramFile1.lastModified() > paramFile2.lastModified()) {}
    for (;;)
    {
      return paramFile1;
      paramFile1 = paramFile2;
    }
  }
  
  /* Error */
  public static int copy(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_3
    //   9: istore_2
    //   10: aload_0
    //   11: ifnull +9 -> 20
    //   14: aload_1
    //   15: ifnonnull +7 -> 22
    //   18: iload_3
    //   19: istore_2
    //   20: iload_2
    //   21: ireturn
    //   22: iload_3
    //   23: istore_2
    //   24: aload_0
    //   25: invokevirtual 51	java/io/File:exists	()Z
    //   28: ifeq -8 -> 20
    //   31: aload_1
    //   32: invokevirtual 51	java/io/File:exists	()Z
    //   35: ifne +34 -> 69
    //   38: aload_1
    //   39: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   42: astore 6
    //   44: iload_3
    //   45: istore_2
    //   46: aload 6
    //   48: ifnull -28 -> 20
    //   51: aload 6
    //   53: invokevirtual 51	java/io/File:exists	()Z
    //   56: ifne +13 -> 69
    //   59: iload_3
    //   60: istore_2
    //   61: aload 6
    //   63: invokevirtual 68	java/io/File:mkdirs	()Z
    //   66: ifeq -46 -> 20
    //   69: new 70	java/io/FileInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore_0
    //   78: new 75	java/io/FileOutputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: astore_1
    //   87: aload_0
    //   88: aload_1
    //   89: invokestatic 79	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLIOUtil:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   92: istore_2
    //   93: iload_2
    //   94: istore_3
    //   95: aload_0
    //   96: ifnull +7 -> 103
    //   99: aload_0
    //   100: invokevirtual 82	java/io/FileInputStream:close	()V
    //   103: iload_3
    //   104: istore_2
    //   105: aload_1
    //   106: ifnull -86 -> 20
    //   109: aload_1
    //   110: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   113: iload_3
    //   114: ireturn
    //   115: astore_0
    //   116: iload_3
    //   117: ireturn
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_0
    //   121: aload 5
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 82	java/io/FileInputStream:close	()V
    //   132: iload_3
    //   133: istore_2
    //   134: aload_0
    //   135: ifnull -115 -> 20
    //   138: aload_0
    //   139: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   142: iconst_0
    //   143: ireturn
    //   144: astore_0
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_0
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 82	java/io/FileInputStream:close	()V
    //   158: aload 4
    //   160: ifnull +8 -> 168
    //   163: aload 4
    //   165: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   168: aload_1
    //   169: athrow
    //   170: astore_0
    //   171: goto -68 -> 103
    //   174: astore_1
    //   175: goto -43 -> 132
    //   178: astore_0
    //   179: goto -21 -> 158
    //   182: astore_0
    //   183: goto -15 -> 168
    //   186: astore_1
    //   187: goto -37 -> 150
    //   190: astore 5
    //   192: aload_1
    //   193: astore 4
    //   195: aload 5
    //   197: astore_1
    //   198: goto -48 -> 150
    //   201: astore_1
    //   202: aconst_null
    //   203: astore 4
    //   205: aload_0
    //   206: astore_1
    //   207: aload 4
    //   209: astore_0
    //   210: goto -86 -> 124
    //   213: astore 4
    //   215: aload_0
    //   216: astore 4
    //   218: aload_1
    //   219: astore_0
    //   220: aload 4
    //   222: astore_1
    //   223: goto -99 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramFile1	File
    //   0	226	1	paramFile2	File
    //   9	125	2	i	int
    //   7	126	3	j	int
    //   1	207	4	localFile1	File
    //   213	1	4	localFileNotFoundException	FileNotFoundException
    //   216	5	4	localFile2	File
    //   4	118	5	localObject1	Object
    //   190	6	5	localObject2	Object
    //   42	20	6	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   109	113	115	java/io/IOException
    //   69	78	118	java/io/FileNotFoundException
    //   138	142	144	java/io/IOException
    //   69	78	147	finally
    //   99	103	170	java/io/IOException
    //   128	132	174	java/io/IOException
    //   154	158	178	java/io/IOException
    //   163	168	182	java/io/IOException
    //   78	87	186	finally
    //   87	93	190	finally
    //   78	87	201	java/io/FileNotFoundException
    //   87	93	213	java/io/FileNotFoundException
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    int k = 0;
    i = 0;
    int j = i;
    if (paramInputStream != null)
    {
      if (paramOutputStream != null) {
        break label19;
      }
      j = i;
    }
    for (;;)
    {
      return j;
      label19:
      byte[] arrayOfByte = new byte[1024];
      i = k;
      try
      {
        for (;;)
        {
          k = paramInputStream.read(arrayOfByte);
          j = i;
          if (k <= 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, k);
          i += k;
        }
        return i;
      }
      catch (IOException paramInputStream) {}
    }
  }
  
  public static boolean createFile(File paramFile)
  {
    if (paramFile == null) {}
    while ((!paramFile.exists()) && (!createParentDirectories(paramFile))) {
      return false;
    }
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException paramFile) {}
    return true;
    return false;
  }
  
  public static boolean createFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    return createFile(new File(paramString));
  }
  
  public static boolean createParentDirectories(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    paramFile = paramFile.getParentFile();
    if ((paramFile != null) && (!paramFile.exists())) {
      return paramFile.mkdirs();
    }
    return true;
  }
  
  public static boolean createParentDirectories(String paramString)
  {
    return createParentDirectories(new File(paramString));
  }
  
  public static String getPath(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    Matcher localMatcher;
    do
    {
      do
      {
        return str;
        localMatcher = PATH_PATTERN.matcher(paramString);
        str = paramString;
      } while (!localMatcher.find());
      str = paramString;
    } while (!localMatcher.group(1).equals("asset"));
    return localMatcher.group(2);
  }
  
  public static String getProtocol(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "file";
    }
    paramString = PROTOCOL_PATTERN.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return "file";
  }
  
  public static boolean isExternalStorageMounted()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean isRemoteFile(String paramString)
  {
    paramString = getProtocol(paramString);
    return (paramString.equals("https")) || (paramString.equals("http"));
  }
  
  public static InputStream open(Context paramContext, String paramString)
  {
    Object localObject = null;
    String str = getProtocol(paramString);
    if (str.equals("asset")) {
      paramString = getPath(paramString);
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getAssets().open(paramString);
        return paramContext;
      }
      catch (IOException paramContext) {}
      if (str.equals("file")) {
        paramContext = getPath(paramString);
      }
      try
      {
        paramContext = new FileInputStream(paramContext);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        return null;
      }
      if (!str.equals("http"))
      {
        paramContext = localObject;
        if (!str.equals("https")) {}
      }
      else
      {
        try
        {
          paramContext = new URL(paramString).openStream();
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return null;
        }
      }
    }
    return null;
  }
  
  public static InputStream openInputStream(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      return paramFile;
    }
    catch (FileNotFoundException paramFile) {}
    return null;
  }
  
  public static InputStream openInputStream(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return openInputStream(new File(paramString));
  }
  
  public static OutputStream openOutputStream(File paramFile)
  {
    if ((paramFile == null) || (!createFile(paramFile))) {
      return null;
    }
    try
    {
      paramFile = new FileOutputStream(paramFile);
      return paramFile;
    }
    catch (FileNotFoundException paramFile) {}
    return null;
  }
  
  public static OutputStream openOutputStream(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return openOutputStream(new File(paramString));
  }
  
  public static void recursiveDelete(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          if (paramFile.isDirectory())
          {
            File[] arrayOfFile = paramFile.listFiles();
            if (arrayOfFile == null) {
              return;
            }
            int j = arrayOfFile.length;
            int i = 0;
            while (i < j)
            {
              recursiveDelete(arrayOfFile[i]);
              i += 1;
            }
          }
          boolean bool = paramFile.delete();
          TPDLProxyLog.d("TPDLIOUtil", 0, "tpdlnative", "recursiveDelete: delete=" + bool);
          return;
        }
      }
      catch (Exception paramFile)
      {
        TPDLProxyLog.d("TPDLIOUtil", 0, "tpdlnative", "recursiveDelete failed, error:" + paramFile.toString());
      }
    }
  }
  
  /* Error */
  public static boolean write(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: ifnull +8 -> 13
    //   8: aload_1
    //   9: arraylength
    //   10: ifgt +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual 51	java/io/File:exists	()Z
    //   19: ifne +33 -> 52
    //   22: aload_0
    //   23: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   26: astore 5
    //   28: aload 5
    //   30: ifnull +11 -> 41
    //   33: aload 5
    //   35: invokevirtual 68	java/io/File:mkdirs	()Z
    //   38: ifeq -25 -> 13
    //   41: aload_0
    //   42: invokevirtual 103	java/io/File:createNewFile	()Z
    //   45: istore 4
    //   47: iload 4
    //   49: ifeq -36 -> 13
    //   52: aconst_null
    //   53: astore 5
    //   55: new 75	java/io/FileOutputStream
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: astore_0
    //   64: aload_0
    //   65: aload_1
    //   66: iload_2
    //   67: iload_3
    //   68: invokevirtual 95	java/io/OutputStream:write	([BII)V
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 222	java/io/OutputStream:close	()V
    //   79: iconst_1
    //   80: ireturn
    //   81: astore_0
    //   82: ldc 8
    //   84: iconst_0
    //   85: ldc 196
    //   87: new 198	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   94: ldc 224
    //   96: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 225	java/io/IOException:toString	()Ljava/lang/String;
    //   103: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 228	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   112: goto -33 -> 79
    //   115: astore_0
    //   116: aload 5
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull -107 -> 13
    //   123: aload_0
    //   124: invokevirtual 222	java/io/OutputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_0
    //   130: ldc 8
    //   132: iconst_0
    //   133: ldc 196
    //   135: new 198	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   142: ldc 224
    //   144: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_0
    //   148: invokevirtual 225	java/io/IOException:toString	()Ljava/lang/String;
    //   151: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 228	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +7 -> 173
    //   169: aload_0
    //   170: invokevirtual 222	java/io/OutputStream:close	()V
    //   173: aload_1
    //   174: athrow
    //   175: astore_0
    //   176: ldc 8
    //   178: iconst_0
    //   179: ldc 196
    //   181: new 198	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   188: ldc 224
    //   190: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: invokevirtual 225	java/io/IOException:toString	()Ljava/lang/String;
    //   197: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 228	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   206: goto -33 -> 173
    //   209: astore_0
    //   210: iconst_0
    //   211: ireturn
    //   212: astore_1
    //   213: goto -48 -> 165
    //   216: astore_1
    //   217: goto -98 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramFile	File
    //   0	220	1	paramArrayOfByte	byte[]
    //   0	220	2	paramInt1	int
    //   0	220	3	paramInt2	int
    //   45	3	4	bool	boolean
    //   26	91	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   75	79	81	java/io/IOException
    //   55	64	115	java/lang/Exception
    //   123	127	129	java/io/IOException
    //   55	64	162	finally
    //   169	173	175	java/io/IOException
    //   41	47	209	java/io/IOException
    //   64	71	212	finally
    //   64	71	216	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil
 * JD-Core Version:    0.7.0.1
 */