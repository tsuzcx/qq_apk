package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
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
    //   129: invokevirtual 61	java/io/FileInputStream:close	()V
    //   132: iload_3
    //   133: istore_2
    //   134: aload_0
    //   135: ifnull -115 -> 20
    //   138: aload_0
    //   139: invokevirtual 62	java/io/FileOutputStream:close	()V
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
    //   155: invokevirtual 61	java/io/FileInputStream:close	()V
    //   158: aload 4
    //   160: ifnull +8 -> 168
    //   163: aload 4
    //   165: invokevirtual 62	java/io/FileOutputStream:close	()V
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
  
  public static boolean isExternalStorageMounted()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = "mounted".equals(Environment.getExternalStorageState());
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
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
    //   27: invokestatic 182	com/tencent/qqlive/tvkplayer/tools/utils/TVKIOUtil:read	(Ljava/io/InputStream;)[B
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_0
    //   36: ifnull +9 -> 45
    //   39: aload_0
    //   40: invokevirtual 183	java/io/InputStream:close	()V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_1
    //   46: areturn
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull -8 -> 45
    //   56: aload_0
    //   57: invokevirtual 183	java/io/InputStream:close	()V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: areturn
    //   65: astore_1
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: ifnull +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 183	java/io/InputStream:close	()V
    //   76: aload_1
    //   77: athrow
    //   78: astore_0
    //   79: aload_2
    //   80: areturn
    //   81: astore_0
    //   82: goto -6 -> 76
    //   85: astore_1
    //   86: goto -18 -> 68
    //   89: astore_1
    //   90: goto -40 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramFile	File
    //   3	49	1	localObject1	Object
    //   65	12	1	localObject2	Object
    //   85	1	1	localObject3	Object
    //   89	1	1	localFileNotFoundException	FileNotFoundException
    //   1	79	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	26	47	java/io/FileNotFoundException
    //   56	60	62	java/io/IOException
    //   17	26	65	finally
    //   39	43	78	java/io/IOException
    //   72	76	81	java/io/IOException
    //   26	31	85	finally
    //   26	31	89	java/io/FileNotFoundException
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
    catch (IOException paramInputStream) {}
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
      catch (Exception paramFile) {}
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
    //   62: invokevirtual 82	java/io/File:createNewFile	()Z
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
    //   92: invokevirtual 74	java/io/OutputStream:write	([BII)V
    //   95: iconst_1
    //   96: istore 4
    //   98: aload_0
    //   99: ifnull -71 -> 28
    //   102: aload_0
    //   103: invokevirtual 203	java/io/OutputStream:close	()V
    //   106: iconst_1
    //   107: ireturn
    //   108: astore_0
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: iload 5
    //   116: istore 4
    //   118: aload_0
    //   119: ifnull -91 -> 28
    //   122: aload_0
    //   123: invokevirtual 203	java/io/OutputStream:close	()V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_0
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload 7
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 203	java/io/OutputStream:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: goto -6 -> 143
    //   152: astore 7
    //   154: aload_0
    //   155: astore_1
    //   156: aload 7
    //   158: astore_0
    //   159: goto -24 -> 135
    //   162: astore_1
    //   163: goto -49 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramFile	File
    //   0	166	1	paramArrayOfByte	byte[]
    //   0	166	2	paramInt1	int
    //   0	166	3	paramInt2	int
    //   5	112	4	bool1	boolean
    //   1	114	5	bool2	boolean
    //   65	7	6	bool3	boolean
    //   42	91	7	localFile	File
    //   152	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   102	106	108	java/io/IOException
    //   79	88	111	java/lang/Exception
    //   122	126	128	java/io/IOException
    //   79	88	131	finally
    //   61	67	145	java/io/IOException
    //   139	143	148	java/io/IOException
    //   88	95	152	finally
    //   88	95	162	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKIOUtil
 * JD-Core Version:    0.7.0.1
 */