package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    if (paramFile1 == null) {
      return paramFile2;
    }
    File localFile = paramFile1;
    if (paramFile2 != null)
    {
      if (!paramFile2.exists()) {
        return paramFile1;
      }
      if (!paramFile1.exists()) {
        return paramFile2;
      }
      if (paramFile1.lastModified() > paramFile2.lastModified()) {
        return paramFile1;
      }
      localFile = paramFile2;
    }
    return localFile;
  }
  
  /* Error */
  public static int copy(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +161 -> 162
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_0
    //   11: invokevirtual 51	java/io/File:exists	()Z
    //   14: ifne +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_1
    //   20: invokevirtual 51	java/io/File:exists	()Z
    //   23: ifne +30 -> 53
    //   26: aload_1
    //   27: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnonnull +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_3
    //   38: invokevirtual 51	java/io/File:exists	()Z
    //   41: ifne +12 -> 53
    //   44: aload_3
    //   45: invokevirtual 68	java/io/File:mkdirs	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: aconst_null
    //   54: astore_3
    //   55: aconst_null
    //   56: astore 4
    //   58: new 70	java/io/FileInputStream
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: astore_0
    //   67: new 75	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: astore_1
    //   76: aload_0
    //   77: aload_1
    //   78: invokestatic 79	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLIOUtil:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   81: istore_2
    //   82: aload_0
    //   83: invokevirtual 82	java/io/FileInputStream:close	()V
    //   86: aload_1
    //   87: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   90: iload_2
    //   91: ireturn
    //   92: astore 4
    //   94: aload_0
    //   95: astore_3
    //   96: aload 4
    //   98: astore_0
    //   99: goto +25 -> 124
    //   102: goto +44 -> 146
    //   105: astore 5
    //   107: aload 4
    //   109: astore_1
    //   110: aload_0
    //   111: astore_3
    //   112: aload 5
    //   114: astore_0
    //   115: goto +9 -> 124
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_3
    //   121: aload 4
    //   123: astore_1
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 82	java/io/FileInputStream:close	()V
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_3
    //   145: astore_1
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 82	java/io/FileInputStream:close	()V
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 83	java/io/FileOutputStream:close	()V
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_0
    //   165: goto -23 -> 142
    //   168: astore_1
    //   169: aload_3
    //   170: astore_1
    //   171: goto -25 -> 146
    //   174: astore_3
    //   175: goto -73 -> 102
    //   178: astore_0
    //   179: goto -93 -> 86
    //   182: astore_0
    //   183: iload_2
    //   184: ireturn
    //   185: astore_3
    //   186: goto -54 -> 132
    //   189: astore_1
    //   190: goto -50 -> 140
    //   193: astore_0
    //   194: goto -40 -> 154
    //   197: astore_0
    //   198: iconst_0
    //   199: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramFile1	File
    //   0	200	1	paramFile2	File
    //   81	103	2	i	int
    //   30	140	3	localFile	File
    //   174	1	3	localFileNotFoundException	FileNotFoundException
    //   185	1	3	localIOException	IOException
    //   56	1	4	localObject1	Object
    //   92	30	4	localObject2	Object
    //   105	8	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   76	82	92	finally
    //   67	76	105	finally
    //   58	67	118	finally
    //   58	67	164	java/io/FileNotFoundException
    //   67	76	168	java/io/FileNotFoundException
    //   76	82	174	java/io/FileNotFoundException
    //   82	86	178	java/io/IOException
    //   86	90	182	java/io/IOException
    //   128	132	185	java/io/IOException
    //   136	140	189	java/io/IOException
    //   150	154	193	java/io/IOException
    //   158	162	197	java/io/IOException
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte;
    int i;
    if (paramInputStream != null)
    {
      if (paramOutputStream == null) {
        return 0;
      }
      arrayOfByte = new byte[1024];
      i = 0;
    }
    try
    {
      for (;;)
      {
        int j = paramInputStream.read(arrayOfByte);
        if (j <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, j);
        i += j;
      }
      return i;
    }
    catch (IOException paramInputStream) {}
    return 0;
    return i;
  }
  
  public static boolean createFile(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if (!paramFile.exists()) {
      if (!createParentDirectories(paramFile)) {
        return false;
      }
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
    if ((paramString != null) && (paramString.length() > 0)) {
      return createFile(new File(paramString));
    }
    return false;
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
    if (paramString == null) {
      return null;
    }
    Matcher localMatcher = PATH_PATTERN.matcher(paramString);
    String str = paramString;
    if (localMatcher.find())
    {
      str = paramString;
      if (localMatcher.group(1).equals("asset")) {
        str = localMatcher.group(2);
      }
    }
    return str;
  }
  
  public static String getProtocol(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "file";
      }
      paramString = PROTOCOL_PATTERN.matcher(paramString);
      if (paramString.find()) {
        return paramString.group(1);
      }
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
  
  /* Error */
  public static InputStream open(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 147	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLIOUtil:getProtocol	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: ldc 13
    //   8: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +19 -> 30
    //   14: aload_1
    //   15: invokestatic 153	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLIOUtil:getPath	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: invokevirtual 159	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: aload_1
    //   24: invokevirtual 164	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_0
    //   28: aload_0
    //   29: areturn
    //   30: aload_2
    //   31: ldc 16
    //   33: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +19 -> 55
    //   39: aload_1
    //   40: invokestatic 153	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLIOUtil:getPath	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_0
    //   44: new 70	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   52: astore_0
    //   53: aload_0
    //   54: areturn
    //   55: aload_2
    //   56: ldc 19
    //   58: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifne +17 -> 78
    //   64: aload_2
    //   65: ldc 22
    //   67: invokevirtual 134	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +6 -> 76
    //   73: goto +5 -> 78
    //   76: aconst_null
    //   77: areturn
    //   78: new 167	java/net/URL
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 168	java/net/URL:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 172	java/net/URL:openStream	()Ljava/io/InputStream;
    //   89: astore_0
    //   90: aload_0
    //   91: areturn
    //   92: astore_0
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramContext	android.content.Context
    //   0	101	1	paramString	String
    //   4	61	2	str	String
    // Exception table:
    //   from	to	target	type
    //   19	28	92	java/io/IOException
    //   44	53	95	java/lang/Exception
    //   78	90	98	java/lang/Exception
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
    if ((paramString != null) && (paramString.length() > 0)) {
      return openInputStream(new File(paramString));
    }
    return null;
  }
  
  public static OutputStream openOutputStream(File paramFile)
  {
    if (paramFile != null) {
      if (!createFile(paramFile)) {
        return null;
      }
    }
    try
    {
      paramFile = new FileOutputStream(paramFile);
      return paramFile;
    }
    catch (FileNotFoundException paramFile) {}
    return null;
    return null;
  }
  
  public static OutputStream openOutputStream(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return openOutputStream(new File(paramString));
    }
    return null;
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
            localObject = paramFile.listFiles();
            if (localObject == null) {
              return;
            }
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              recursiveDelete(localObject[i]);
              i += 1;
            }
          }
          boolean bool = paramFile.delete();
          paramFile = new StringBuilder();
          paramFile.append("recursiveDelete: delete=");
          paramFile.append(bool);
          TPDLProxyLog.d("TPDLIOUtil", 0, "tpdlnative", paramFile.toString());
          return;
        }
      }
      catch (Exception paramFile)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recursiveDelete failed, error:");
        ((StringBuilder)localObject).append(paramFile.toString());
        TPDLProxyLog.d("TPDLIOUtil", 0, "tpdlnative", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  /* Error */
  public static boolean write(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +240 -> 241
    //   4: aload_1
    //   5: ifnull +236 -> 241
    //   8: aload_1
    //   9: arraylength
    //   10: ifgt +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual 51	java/io/File:exists	()Z
    //   19: ifne +37 -> 56
    //   22: aload_0
    //   23: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   26: astore 5
    //   28: aload 5
    //   30: ifnull +13 -> 43
    //   33: aload 5
    //   35: invokevirtual 68	java/io/File:mkdirs	()Z
    //   38: ifne +5 -> 43
    //   41: iconst_0
    //   42: ireturn
    //   43: aload_0
    //   44: invokevirtual 103	java/io/File:createNewFile	()Z
    //   47: istore 4
    //   49: iload 4
    //   51: ifne +5 -> 56
    //   54: iconst_0
    //   55: ireturn
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 5
    //   62: new 75	java/io/FileOutputStream
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: astore_0
    //   71: aload_0
    //   72: aload_1
    //   73: iload_2
    //   74: iload_3
    //   75: invokevirtual 95	java/io/OutputStream:write	([BII)V
    //   78: aload_0
    //   79: invokevirtual 222	java/io/OutputStream:close	()V
    //   82: iconst_1
    //   83: ireturn
    //   84: astore_0
    //   85: new 196	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   92: astore_1
    //   93: aload_1
    //   94: ldc 224
    //   96: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: aload_0
    //   102: invokevirtual 225	java/io/IOException:toString	()Ljava/lang/String;
    //   105: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: ldc 8
    //   111: iconst_0
    //   112: ldc 208
    //   114: aload_1
    //   115: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 228	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore 5
    //   125: aload_0
    //   126: astore_1
    //   127: aload 5
    //   129: astore_0
    //   130: goto +10 -> 140
    //   133: goto +61 -> 194
    //   136: astore_0
    //   137: aload 5
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +51 -> 192
    //   144: aload_1
    //   145: invokevirtual 222	java/io/OutputStream:close	()V
    //   148: goto +44 -> 192
    //   151: astore_1
    //   152: new 196	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   159: astore 5
    //   161: aload 5
    //   163: ldc 224
    //   165: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: aload_1
    //   172: invokevirtual 225	java/io/IOException:toString	()Ljava/lang/String;
    //   175: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: ldc 8
    //   181: iconst_0
    //   182: ldc 208
    //   184: aload 5
    //   186: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 228	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: athrow
    //   194: aload_0
    //   195: ifnull +46 -> 241
    //   198: aload_0
    //   199: invokevirtual 222	java/io/OutputStream:close	()V
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: new 196	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   212: astore_1
    //   213: aload_1
    //   214: ldc 224
    //   216: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_1
    //   221: aload_0
    //   222: invokevirtual 225	java/io/IOException:toString	()Ljava/lang/String;
    //   225: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: ldc 8
    //   231: iconst_0
    //   232: ldc 208
    //   234: aload_1
    //   235: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 228	com/tencent/thumbplayer/core/downloadproxy/utils/TPDLProxyLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   241: iconst_0
    //   242: ireturn
    //   243: astore_0
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_0
    //   247: aload 6
    //   249: astore_0
    //   250: goto -56 -> 194
    //   253: astore_1
    //   254: goto -121 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramFile	File
    //   0	257	1	paramArrayOfByte	byte[]
    //   0	257	2	paramInt1	int
    //   0	257	3	paramInt2	int
    //   47	3	4	bool	boolean
    //   26	35	5	localFile	File
    //   123	15	5	localObject1	Object
    //   159	26	5	localStringBuilder	StringBuilder
    //   57	191	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   78	82	84	java/io/IOException
    //   71	78	123	finally
    //   62	71	136	finally
    //   144	148	151	java/io/IOException
    //   198	202	204	java/io/IOException
    //   43	49	243	java/io/IOException
    //   62	71	246	java/lang/Exception
    //   71	78	253	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil
 * JD-Core Version:    0.7.0.1
 */