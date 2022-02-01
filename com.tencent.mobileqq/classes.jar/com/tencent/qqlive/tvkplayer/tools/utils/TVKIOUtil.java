package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.ByteArrayOutputStream;
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

public class TVKIOUtil
{
  private static final String PROTOCOL_ASSET = "asset";
  private static final String PROTOCOL_FILE = "file";
  private static final String PROTOCOL_HTTP = "http";
  private static final String PROTOCOL_HTTPS = "https";
  
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
    //   25: invokevirtual 30	java/io/File:exists	()Z
    //   28: ifeq -8 -> 20
    //   31: aload_1
    //   32: invokevirtual 30	java/io/File:exists	()Z
    //   35: ifne +34 -> 69
    //   38: aload_1
    //   39: invokevirtual 44	java/io/File:getParentFile	()Ljava/io/File;
    //   42: astore 6
    //   44: iload_3
    //   45: istore_2
    //   46: aload 6
    //   48: ifnull -28 -> 20
    //   51: aload 6
    //   53: invokevirtual 30	java/io/File:exists	()Z
    //   56: ifne +13 -> 69
    //   59: iload_3
    //   60: istore_2
    //   61: aload 6
    //   63: invokevirtual 47	java/io/File:mkdirs	()Z
    //   66: ifeq -46 -> 20
    //   69: new 49	java/io/FileInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: astore_0
    //   78: new 54	java/io/FileOutputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: astore_1
    //   87: aload_0
    //   88: aload_1
    //   89: invokestatic 58	com/tencent/qqlive/tvkplayer/tools/utils/TVKIOUtil:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   92: istore_2
    //   93: iload_2
    //   94: istore_3
    //   95: aload_0
    //   96: ifnull +7 -> 103
    //   99: aload_0
    //   100: invokevirtual 61	java/io/FileInputStream:close	()V
    //   103: iload_3
    //   104: istore_2
    //   105: aload_1
    //   106: ifnull -86 -> 20
    //   109: aload_1
    //   110: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   113: iload_3
    //   114: ireturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   120: iload_3
    //   121: ireturn
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   127: goto -24 -> 103
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_0
    //   133: aload 5
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 61	java/io/FileInputStream:close	()V
    //   144: iload_3
    //   145: istore_2
    //   146: aload_0
    //   147: ifnull -127 -> 20
    //   150: aload_0
    //   151: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   168: goto -24 -> 144
    //   171: astore_1
    //   172: aconst_null
    //   173: astore_0
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 61	java/io/FileInputStream:close	()V
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   192: aload_1
    //   193: athrow
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   199: goto -17 -> 182
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   207: goto -15 -> 192
    //   210: astore_1
    //   211: goto -37 -> 174
    //   214: astore 5
    //   216: aload_1
    //   217: astore 4
    //   219: aload 5
    //   221: astore_1
    //   222: goto -48 -> 174
    //   225: astore_1
    //   226: aconst_null
    //   227: astore 4
    //   229: aload_0
    //   230: astore_1
    //   231: aload 4
    //   233: astore_0
    //   234: goto -98 -> 136
    //   237: astore 4
    //   239: aload_0
    //   240: astore 4
    //   242: aload_1
    //   243: astore_0
    //   244: aload 4
    //   246: astore_1
    //   247: goto -111 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramFile1	File
    //   0	250	1	paramFile2	File
    //   9	137	2	i	int
    //   7	138	3	j	int
    //   1	231	4	localFile1	File
    //   237	1	4	localFileNotFoundException	FileNotFoundException
    //   240	5	4	localFile2	File
    //   4	130	5	localObject1	Object
    //   214	6	5	localObject2	Object
    //   42	20	6	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   109	113	115	java/io/IOException
    //   99	103	122	java/io/IOException
    //   69	78	130	java/io/FileNotFoundException
    //   150	154	156	java/io/IOException
    //   140	144	163	java/io/IOException
    //   69	78	171	finally
    //   178	182	194	java/io/IOException
    //   187	192	202	java/io/IOException
    //   78	87	210	finally
    //   87	93	214	finally
    //   78	87	225	java/io/FileNotFoundException
    //   87	93	237	java/io/FileNotFoundException
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
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
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
    if (paramFile == null) {}
    do
    {
      return false;
      paramFile = paramFile.getParentFile();
      if ((paramFile != null) && (!paramFile.exists())) {
        return paramFile.mkdirs();
      }
      if ((paramFile != null) && (paramFile.exists()) && (!paramFile.isDirectory()) && (paramFile.canWrite()) && (paramFile.delete())) {
        return paramFile.mkdirs();
      }
    } while (paramFile == null);
    return paramFile.isDirectory();
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
        localMatcher = Pattern.compile("^(\\w+):/{2,3}(.*)").matcher(paramString);
        str = paramString;
      } while (!localMatcher.find());
      str = paramString;
    } while (!localMatcher.group(1).equals("asset"));
    return localMatcher.group(2);
  }
  
  public static final String getProtocol(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "file";
    }
    paramString = Pattern.compile("^(\\w+):/{2,3}").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return "file";
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
  
  /* Error */
  public static byte[] read(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_1
    //   4: aload_0
    //   5: ifnull +40 -> 45
    //   8: aload_2
    //   9: astore_1
    //   10: aload_0
    //   11: invokevirtual 30	java/io/File:exists	()Z
    //   14: ifeq +31 -> 45
    //   17: new 49	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokestatic 176	com/tencent/qqlive/tvkplayer/tools/utils/TVKIOUtil:read	(Ljava/io/InputStream;)[B
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_0
    //   36: ifnull +9 -> 45
    //   39: aload_0
    //   40: invokevirtual 177	java/io/InputStream:close	()V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_1
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   52: aload_2
    //   53: areturn
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: ifnull -15 -> 45
    //   63: aload_0
    //   64: invokevirtual 177	java/io/InputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 177	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: athrow
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   94: goto -7 -> 87
    //   97: astore_1
    //   98: goto -19 -> 79
    //   101: astore_1
    //   102: goto -45 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   3	56	1	localObject1	Object
    //   76	12	1	localObject2	Object
    //   97	1	1	localObject3	Object
    //   101	1	1	localFileNotFoundException	FileNotFoundException
    //   1	57	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   39	43	47	java/io/IOException
    //   17	26	54	java/io/FileNotFoundException
    //   63	67	69	java/io/IOException
    //   17	26	76	finally
    //   83	87	89	java/io/IOException
    //   26	31	97	finally
    //   26	31	101	java/io/FileNotFoundException
  }
  
  public static byte[] read(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
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
          paramFile.delete();
          return;
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static boolean write(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iload 5
    //   5: istore 4
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: iload 5
    //   13: istore 4
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: arraylength
    //   21: ifgt +10 -> 31
    //   24: iload 5
    //   26: istore 4
    //   28: iload 4
    //   30: ireturn
    //   31: aload_0
    //   32: invokevirtual 30	java/io/File:exists	()Z
    //   35: ifne +41 -> 76
    //   38: aload_0
    //   39: invokevirtual 44	java/io/File:getParentFile	()Ljava/io/File;
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +15 -> 61
    //   49: iload 5
    //   51: istore 4
    //   53: aload 7
    //   55: invokevirtual 47	java/io/File:mkdirs	()Z
    //   58: ifeq -30 -> 28
    //   61: aload_0
    //   62: invokevirtual 85	java/io/File:createNewFile	()Z
    //   65: istore 6
    //   67: iload 5
    //   69: istore 4
    //   71: iload 6
    //   73: ifeq -45 -> 28
    //   76: aconst_null
    //   77: astore 7
    //   79: new 54	java/io/FileOutputStream
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: astore_0
    //   88: aload_0
    //   89: aload_1
    //   90: iload_2
    //   91: iload_3
    //   92: invokevirtual 77	java/io/OutputStream:write	([BII)V
    //   95: iconst_1
    //   96: istore 4
    //   98: aload_0
    //   99: ifnull -71 -> 28
    //   102: aload_0
    //   103: invokevirtual 198	java/io/OutputStream:close	()V
    //   106: iconst_1
    //   107: ireturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: iload 5
    //   120: istore 4
    //   122: aload_0
    //   123: ifnull -95 -> 28
    //   126: aload_0
    //   127: invokevirtual 198	java/io/OutputStream:close	()V
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: aload 7
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 198	java/io/OutputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   158: goto -7 -> 151
    //   161: astore_0
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 7
    //   166: aload_0
    //   167: astore_1
    //   168: aload 7
    //   170: astore_0
    //   171: goto -28 -> 143
    //   174: astore_1
    //   175: goto -57 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramFile	File
    //   0	178	1	paramArrayOfByte	byte[]
    //   0	178	2	paramInt1	int
    //   0	178	3	paramInt2	int
    //   5	116	4	bool1	boolean
    //   1	118	5	bool2	boolean
    //   65	7	6	bool3	boolean
    //   42	99	7	localFile	File
    //   164	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   102	106	108	java/io/IOException
    //   79	88	115	java/lang/Exception
    //   126	130	132	java/io/IOException
    //   79	88	139	finally
    //   147	151	153	java/io/IOException
    //   61	67	161	java/io/IOException
    //   88	95	164	finally
    //   88	95	174	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKIOUtil
 * JD-Core Version:    0.7.0.1
 */