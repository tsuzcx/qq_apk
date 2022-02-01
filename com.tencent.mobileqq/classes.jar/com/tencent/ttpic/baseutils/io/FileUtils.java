package com.tencent.ttpic.baseutils.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FileUtils
{
  public static final String MD5_SALT = "aekit";
  public static final String PIC_POSTFIX_JPEG = ".jpg";
  public static final String PIC_POSTFIX_MP4 = ".mp4";
  public static final String PIC_POSTFIX_PNG = ".png";
  public static final String PIC_POSTFIX_WEBP = ".webp";
  public static final String RES_POSTFIX_ENCRYPTED_GLB = ".dat";
  public static final String RES_POSTFIX_ENCRYPTED_GLTF = ".datf";
  public static final String RES_POSTFIX_GLB = ".glb";
  public static final String RES_POSTFIX_GLTF = ".gltf";
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  public static final FileUtils.AssetFileComparator SIMPLE_ASSET_COMPARATOR = new FileUtils.2();
  public static final FileUtils.AssetFileComparator SIMPLE_ASSET_MD5_COMPARATOR = new FileUtils.3();
  public static final FileUtils.FileComparator SIMPLE_FILE_COMPARATOR = new FileUtils.4();
  private static final String TAG = FileUtils.class.getSimpleName();
  
  public static void CopyAssetsMaterialToExternalStorage(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      String[] arrayOfString = paramContext.getAssets().list(paramString);
      if (arrayOfString.length > 0)
      {
        new File(paramContext.getExternalFilesDir(null).getAbsolutePath() + File.separator + paramString).mkdirs();
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          paramString = paramString + File.separator + str;
          CopyAssetsMaterialToExternalStorage(paramContext, paramString);
          paramString = paramString.substring(0, paramString.lastIndexOf(File.separator));
          i += 1;
        }
      }
      copyAssets(paramContext, paramString, paramContext.getExternalFilesDir(null).getAbsolutePath() + File.separator + paramString);
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean assetAndPathExist(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      AssetManager localAssetManager;
      if (paramString.startsWith("assets")) {
        localAssetManager = paramContext.getAssets();
      }
      try
      {
        paramContext = paramString.substring(paramString.lastIndexOf("/") + 1);
        paramString = localAssetManager.list(paramString.substring(0, paramString.lastIndexOf("/")).replace("assets://", ""));
        if (paramString != null)
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            localAssetManager = paramString[i];
            boolean bool = TextUtils.equals(localAssetManager.substring(localAssetManager.lastIndexOf("/") + 1), paramContext);
            if (bool) {
              return true;
            }
            i += 1;
          }
          return new File(paramString).exists();
        }
      }
      catch (IOException paramContext) {}
    }
    return false;
  }
  
  public static void asyncCopyFile(InputStream paramInputStream, String paramString, FileUtils.OnFileCopyListener paramOnFileCopyListener)
  {
    paramInputStream = new FileUtils.FileCopyTask(paramInputStream, paramString);
    paramInputStream.setOnFileCopyListener(paramOnFileCopyListener);
    paramInputStream.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[0]);
  }
  
  /* Error */
  public static String checkAssetsPhoto(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore_0
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   24: aload_1
    //   25: areturn
    //   26: astore_2
    //   27: aconst_null
    //   28: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   31: aload_1
    //   32: ldc 218
    //   34: invokevirtual 132	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   37: iconst_m1
    //   38: if_icmpeq +68 -> 106
    //   41: new 99	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: iconst_0
    //   50: aload_1
    //   51: bipush 46
    //   53: invokevirtual 221	java/lang/String:lastIndexOf	(I)I
    //   56: iconst_1
    //   57: iadd
    //   58: invokevirtual 136	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 223
    //   66: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   104: aload_0
    //   105: athrow
    //   106: new 99	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   113: aload_1
    //   114: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 11
    //   119: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_2
    //   126: aload_0
    //   127: aload_2
    //   128: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore_3
    //   132: aload_3
    //   133: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: aconst_null
    //   140: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   143: new 99	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   150: aload_1
    //   151: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 20
    //   156: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_2
    //   163: aload_0
    //   164: aload_2
    //   165: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   168: astore_3
    //   169: aload_3
    //   170: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   173: aload_2
    //   174: areturn
    //   175: astore_0
    //   176: aconst_null
    //   177: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   180: aload_0
    //   181: athrow
    //   182: astore_2
    //   183: aconst_null
    //   184: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   187: new 99	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   194: aload_1
    //   195: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 17
    //   200: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore_1
    //   207: aload_0
    //   208: aload_1
    //   209: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   212: astore_0
    //   213: aload_0
    //   214: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   217: aload_1
    //   218: areturn
    //   219: astore_0
    //   220: aconst_null
    //   221: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   224: aload_0
    //   225: athrow
    //   226: astore_0
    //   227: aconst_null
    //   228: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   238: aload_0
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	Context
    //   0	240	1	paramString	String
    //   19	2	2	localInputStream1	InputStream
    //   26	1	2	localIOException1	IOException
    //   125	12	2	str1	String
    //   138	1	2	localIOException2	IOException
    //   162	12	2	str2	String
    //   182	1	2	localIOException3	IOException
    //   131	39	3	localInputStream2	InputStream
    // Exception table:
    //   from	to	target	type
    //   14	20	26	java/io/IOException
    //   14	20	85	finally
    //   73	79	92	java/io/IOException
    //   73	79	99	finally
    //   126	132	138	java/io/IOException
    //   126	132	175	finally
    //   163	169	182	java/io/IOException
    //   163	169	219	finally
    //   207	213	226	java/io/IOException
    //   207	213	233	finally
  }
  
  public static String checkPhoto(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = null;
    }
    String str2;
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = paramString;
        } while (new File(paramString).exists());
        str1 = paramString;
      } while (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") != -1);
      str1 = paramString + ".jpg";
      if (new File(str1).exists()) {
        return str1;
      }
      str2 = paramString + ".png";
      str1 = paramString;
    } while (!new File(str2).exists());
    return str2;
  }
  
  public static void clearDir(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isDirectory()) {
        clearDir(localFile);
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    paramFile.delete();
  }
  
  public static void clearDirs(File[] paramArrayOfFile)
  {
    if (paramArrayOfFile == null) {}
    for (;;)
    {
      return;
      int j = paramArrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        clearDir(paramArrayOfFile[i]);
        i += 1;
      }
    }
  }
  
  private static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    return copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_MD5_COMPARATOR);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    return performCopyAssetsFile(paramContext, paramString1, paramString2, paramAssetFileComparator);
  }
  
  public static void copyAssetsToSDCard(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    try
    {
      String[] arrayOfString = paramContext.getAssets().list(paramString1);
      if (arrayOfString.length > 0)
      {
        new File(paramString2).mkdirs();
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          paramString1 = paramString1 + File.separator + str;
          copyAssetsToSDCard(paramContext, paramString1, paramString2 + File.separator + str);
          paramString1 = paramString1.substring(0, paramString1.lastIndexOf(File.separator));
          i += 1;
        }
      }
      copyAssets(paramContext, paramString1, paramString2);
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_1
    //   13: invokevirtual 183	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_1
    //   20: invokevirtual 239	java/io/File:delete	()Z
    //   23: pop
    //   24: new 266	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 268	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: new 270	java/io/BufferedInputStream
    //   36: dup
    //   37: new 272	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 275	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: invokestatic 281	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   52: sipush 4096
    //   55: invokevirtual 285	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   58: astore 5
    //   60: aload_0
    //   61: aload 5
    //   63: invokevirtual 289	java/io/BufferedInputStream:read	([B)I
    //   66: istore_2
    //   67: iload_2
    //   68: iconst_m1
    //   69: if_icmpeq +52 -> 121
    //   72: aload_1
    //   73: aload 5
    //   75: iconst_0
    //   76: iload_2
    //   77: invokevirtual 293	java/io/FileOutputStream:write	([BII)V
    //   80: aload_1
    //   81: invokevirtual 296	java/io/FileOutputStream:flush	()V
    //   84: goto -24 -> 60
    //   87: astore 5
    //   89: aload_0
    //   90: astore 5
    //   92: aload_1
    //   93: astore_0
    //   94: aload 5
    //   96: astore_1
    //   97: aload_0
    //   98: ifnull +7 -> 105
    //   101: aload_0
    //   102: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   105: iload 4
    //   107: istore_3
    //   108: aload_1
    //   109: ifnull +10 -> 119
    //   112: aload_1
    //   113: invokevirtual 298	java/io/BufferedInputStream:close	()V
    //   116: iload 4
    //   118: istore_3
    //   119: iload_3
    //   120: ireturn
    //   121: invokestatic 281	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   124: aload 5
    //   126: invokevirtual 302	com/tencent/ttpic/baseutils/io/ByteArrayPool:returnBuf	([B)V
    //   129: iconst_1
    //   130: istore_3
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   139: aload_0
    //   140: ifnull -21 -> 119
    //   143: aload_0
    //   144: invokevirtual 298	java/io/BufferedInputStream:close	()V
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_0
    //   150: iconst_1
    //   151: ireturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 7
    //   157: astore_0
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   166: iload 4
    //   168: istore_3
    //   169: aload_0
    //   170: ifnull -51 -> 119
    //   173: aload_0
    //   174: invokevirtual 298	java/io/BufferedInputStream:close	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   193: aload 5
    //   195: ifnull +8 -> 203
    //   198: aload 5
    //   200: invokevirtual 298	java/io/BufferedInputStream:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: astore_1
    //   206: goto -67 -> 139
    //   209: astore_0
    //   210: goto -105 -> 105
    //   213: astore_0
    //   214: iconst_0
    //   215: ireturn
    //   216: astore_1
    //   217: goto -51 -> 166
    //   220: astore_1
    //   221: goto -28 -> 193
    //   224: astore_1
    //   225: goto -22 -> 203
    //   228: astore_0
    //   229: goto -44 -> 185
    //   232: astore 6
    //   234: aload_0
    //   235: astore 5
    //   237: aload 6
    //   239: astore_0
    //   240: goto -55 -> 185
    //   243: astore_0
    //   244: aload 7
    //   246: astore_0
    //   247: goto -89 -> 158
    //   250: astore 5
    //   252: goto -94 -> 158
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_0
    //   258: aload 6
    //   260: astore_1
    //   261: goto -164 -> 97
    //   264: astore_0
    //   265: aload_1
    //   266: astore_0
    //   267: aload 6
    //   269: astore_1
    //   270: goto -173 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramFile1	File
    //   0	273	1	paramFile2	File
    //   66	11	2	i	int
    //   107	62	3	bool1	boolean
    //   10	157	4	bool2	boolean
    //   4	70	5	arrayOfByte	byte[]
    //   87	1	5	localIOException	IOException
    //   90	146	5	localFile	File
    //   250	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   7	1	6	localObject1	Object
    //   232	36	6	localObject2	Object
    //   1	244	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	60	87	java/io/IOException
    //   60	67	87	java/io/IOException
    //   72	84	87	java/io/IOException
    //   121	129	87	java/io/IOException
    //   143	147	149	java/io/IOException
    //   12	24	152	java/lang/OutOfMemoryError
    //   24	33	152	java/lang/OutOfMemoryError
    //   173	177	179	java/io/IOException
    //   12	24	182	finally
    //   24	33	182	finally
    //   135	139	205	java/io/IOException
    //   101	105	209	java/io/IOException
    //   112	116	213	java/io/IOException
    //   162	166	216	java/io/IOException
    //   189	193	220	java/io/IOException
    //   198	203	224	java/io/IOException
    //   33	49	228	finally
    //   49	60	232	finally
    //   60	67	232	finally
    //   72	84	232	finally
    //   121	129	232	finally
    //   33	49	243	java/lang/OutOfMemoryError
    //   49	60	250	java/lang/OutOfMemoryError
    //   60	67	250	java/lang/OutOfMemoryError
    //   72	84	250	java/lang/OutOfMemoryError
    //   121	129	250	java/lang/OutOfMemoryError
    //   12	24	255	java/io/IOException
    //   24	33	255	java/io/IOException
    //   33	49	264	java/io/IOException
  }
  
  public static boolean copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if ((paramInputStream == null) || (paramOutputStream == null)) {
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return true;
    }
    catch (Exception paramInputStream)
    {
      LogUtils.e(paramInputStream);
    }
    for (;;)
    {
      paramOutputStream.flush();
    }
  }
  
  /* Error */
  public static boolean copyFile(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: new 266	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: sipush 4096
    //   12: newarray byte
    //   14: astore_3
    //   15: aload_0
    //   16: aload_3
    //   17: invokevirtual 308	java/io/InputStream:read	([B)I
    //   20: istore_2
    //   21: iload_2
    //   22: ifle +24 -> 46
    //   25: aload_1
    //   26: aload_3
    //   27: iconst_0
    //   28: iload_2
    //   29: invokevirtual 311	java/io/OutputStream:write	([BII)V
    //   32: goto -17 -> 15
    //   35: astore_3
    //   36: aload_0
    //   37: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   40: aload_1
    //   41: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   50: aload_1
    //   51: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_0
    //   60: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   63: aload_1
    //   64: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   67: aload_3
    //   68: athrow
    //   69: astore_3
    //   70: goto -11 -> 59
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -40 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramInputStream	InputStream
    //   0	79	1	paramString	String
    //   20	9	2	i	int
    //   14	13	3	arrayOfByte	byte[]
    //   35	1	3	localException	Exception
    //   56	12	3	localObject1	Object
    //   69	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	15	35	java/lang/Exception
    //   15	21	35	java/lang/Exception
    //   25	32	35	java/lang/Exception
    //   0	9	56	finally
    //   9	15	69	finally
    //   15	21	69	finally
    //   25	32	69	finally
    //   0	9	73	java/lang/Exception
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    return copyFile(paramString1, paramString2, SIMPLE_FILE_COMPARATOR);
  }
  
  /* Error */
  private static boolean copyFile(String paramString1, String paramString2, FileUtils.FileComparator paramFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +10 -> 17
    //   10: aload_1
    //   11: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   20: ldc_w 329
    //   23: invokestatic 332	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 97	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 6
    //   38: aload 6
    //   40: invokevirtual 183	java/io/File:exists	()Z
    //   43: ifeq +51 -> 94
    //   46: aload_2
    //   47: ifnull +34 -> 81
    //   50: aload_2
    //   51: aload_0
    //   52: aload 6
    //   54: invokeinterface 337 3 0
    //   59: ifeq +22 -> 81
    //   62: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   65: ldc_w 339
    //   68: invokestatic 342	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aconst_null
    //   72: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   75: aconst_null
    //   76: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   79: iconst_1
    //   80: ireturn
    //   81: aload 6
    //   83: invokevirtual 230	java/io/File:isDirectory	()Z
    //   86: ifeq +8 -> 94
    //   89: aload 6
    //   91: invokestatic 346	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   94: aload 6
    //   96: invokevirtual 350	java/io/File:getParentFile	()Ljava/io/File;
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 353	java/io/File:isFile	()Z
    //   104: ifeq +7 -> 111
    //   107: aload_1
    //   108: invokestatic 346	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   111: aload_1
    //   112: invokevirtual 183	java/io/File:exists	()Z
    //   115: ifne +49 -> 164
    //   118: aload_1
    //   119: invokevirtual 124	java/io/File:mkdirs	()Z
    //   122: ifne +42 -> 164
    //   125: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   128: new 99	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 355
    //   138: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: invokevirtual 107	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   145: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 332	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aconst_null
    //   155: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   158: aconst_null
    //   159: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   162: iconst_0
    //   163: ireturn
    //   164: new 272	java/io/FileInputStream
    //   167: dup
    //   168: aload_0
    //   169: invokespecial 356	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_2
    //   174: invokevirtual 360	java/io/InputStream:available	()I
    //   177: istore_3
    //   178: iload_3
    //   179: ifgt +20 -> 199
    //   182: iconst_0
    //   183: istore 4
    //   185: aload 5
    //   187: astore_0
    //   188: aload_2
    //   189: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   192: aload_0
    //   193: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   196: iload 4
    //   198: ireturn
    //   199: new 362	java/io/BufferedOutputStream
    //   202: dup
    //   203: new 266	java/io/FileOutputStream
    //   206: dup
    //   207: aload 6
    //   209: invokespecial 268	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   212: invokespecial 364	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   215: astore_0
    //   216: sipush 1024
    //   219: newarray byte
    //   221: astore_1
    //   222: aload_2
    //   223: aload_1
    //   224: invokevirtual 308	java/io/InputStream:read	([B)I
    //   227: istore_3
    //   228: iload_3
    //   229: ifle +62 -> 291
    //   232: aload_0
    //   233: aload_1
    //   234: iconst_0
    //   235: iload_3
    //   236: invokevirtual 311	java/io/OutputStream:write	([BII)V
    //   239: goto -17 -> 222
    //   242: astore 5
    //   244: aload_2
    //   245: astore_1
    //   246: aload 5
    //   248: astore_2
    //   249: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   252: ldc_w 366
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload_2
    //   262: invokevirtual 367	java/lang/Throwable:toString	()Ljava/lang/String;
    //   265: aastore
    //   266: invokestatic 371	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   269: invokestatic 332	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 6
    //   274: invokestatic 346	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   277: aload_1
    //   278: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   281: aload_0
    //   282: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   285: iconst_0
    //   286: istore 4
    //   288: goto -92 -> 196
    //   291: iconst_1
    //   292: istore 4
    //   294: goto -106 -> 188
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_2
    //   300: aconst_null
    //   301: astore_0
    //   302: aload_2
    //   303: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   306: aload_0
    //   307: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   310: aload_1
    //   311: athrow
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_0
    //   315: goto -13 -> 302
    //   318: astore_1
    //   319: goto -17 -> 302
    //   322: astore 5
    //   324: aload_1
    //   325: astore_2
    //   326: aload 5
    //   328: astore_1
    //   329: goto -27 -> 302
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: aconst_null
    //   336: astore_0
    //   337: goto -88 -> 249
    //   340: astore_0
    //   341: aload_2
    //   342: astore_1
    //   343: aload_0
    //   344: astore_2
    //   345: aconst_null
    //   346: astore_0
    //   347: goto -98 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramString1	String
    //   0	350	1	paramString2	String
    //   0	350	2	paramFileComparator	FileUtils.FileComparator
    //   177	59	3	i	int
    //   183	110	4	bool	boolean
    //   1	185	5	localObject1	Object
    //   242	5	5	localThrowable	Throwable
    //   322	5	5	localObject2	Object
    //   36	237	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   216	222	242	java/lang/Throwable
    //   222	228	242	java/lang/Throwable
    //   232	239	242	java/lang/Throwable
    //   38	46	297	finally
    //   50	71	297	finally
    //   81	94	297	finally
    //   94	111	297	finally
    //   111	154	297	finally
    //   164	173	297	finally
    //   173	178	312	finally
    //   199	216	312	finally
    //   216	222	318	finally
    //   222	228	318	finally
    //   232	239	318	finally
    //   249	277	322	finally
    //   38	46	332	java/lang/Throwable
    //   50	71	332	java/lang/Throwable
    //   81	94	332	java/lang/Throwable
    //   94	111	332	java/lang/Throwable
    //   111	154	332	java/lang/Throwable
    //   164	173	332	java/lang/Throwable
    //   173	178	340	java/lang/Throwable
    //   199	216	340	java/lang/Throwable
  }
  
  /* Error */
  public static void copyRawSafe(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 377	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 383	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore 4
    //   10: new 97	java/io/File
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: new 266	java/io/FileOutputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_0
    //   30: aload 4
    //   32: invokestatic 387	com/tencent/ttpic/baseutils/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   35: astore 5
    //   37: aload_2
    //   38: astore_0
    //   39: aload_3
    //   40: invokevirtual 391	java/io/File:length	()J
    //   43: aload 5
    //   45: arraylength
    //   46: i2l
    //   47: lcmp
    //   48: ifeq +17 -> 65
    //   51: aload_2
    //   52: astore_0
    //   53: aload 5
    //   55: aload_2
    //   56: invokestatic 394	com/tencent/ttpic/baseutils/io/IOUtils:write	([BLjava/io/OutputStream;)V
    //   59: aload_2
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 296	java/io/FileOutputStream:flush	()V
    //   65: aload 4
    //   67: invokevirtual 395	java/io/InputStream:close	()V
    //   70: aload_2
    //   71: ifnull +11 -> 82
    //   74: aload_2
    //   75: invokevirtual 296	java/io/FileOutputStream:flush	()V
    //   78: aload_2
    //   79: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   82: return
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   88: return
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_0
    //   94: aload_3
    //   95: invokevirtual 396	java/lang/Exception:printStackTrace	()V
    //   98: aload 4
    //   100: invokevirtual 395	java/io/InputStream:close	()V
    //   103: aload_2
    //   104: ifnull -22 -> 82
    //   107: aload_2
    //   108: invokevirtual 296	java/io/FileOutputStream:flush	()V
    //   111: aload_2
    //   112: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   115: return
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   121: return
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_0
    //   127: aload 4
    //   129: invokevirtual 399	java/io/InputStream:reset	()V
    //   132: aload_2
    //   133: astore_0
    //   134: aload 4
    //   136: aload_2
    //   137: invokestatic 401	com/tencent/ttpic/baseutils/io/FileUtils:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   140: pop
    //   141: aload 4
    //   143: invokevirtual 395	java/io/InputStream:close	()V
    //   146: aload_2
    //   147: ifnull -65 -> 82
    //   150: aload_2
    //   151: invokevirtual 296	java/io/FileOutputStream:flush	()V
    //   154: aload_2
    //   155: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   158: return
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   164: return
    //   165: astore_3
    //   166: aload_2
    //   167: astore_0
    //   168: aload_3
    //   169: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   172: goto -31 -> 141
    //   175: astore_3
    //   176: aload_0
    //   177: astore_2
    //   178: aload_3
    //   179: astore_0
    //   180: aload 4
    //   182: invokevirtual 395	java/io/InputStream:close	()V
    //   185: aload_2
    //   186: ifnull +11 -> 197
    //   189: aload_2
    //   190: invokevirtual 296	java/io/FileOutputStream:flush	()V
    //   193: aload_2
    //   194: invokevirtual 297	java/io/FileOutputStream:close	()V
    //   197: aload_0
    //   198: athrow
    //   199: astore_2
    //   200: aload_2
    //   201: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_0
    //   208: aconst_null
    //   209: astore_2
    //   210: goto -30 -> 180
    //   213: astore_0
    //   214: goto -89 -> 125
    //   217: astore_3
    //   218: goto -126 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramContext	Context
    //   0	221	1	paramInt	int
    //   0	221	2	paramString	String
    //   18	22	3	localFile	File
    //   89	6	3	localException1	Exception
    //   165	4	3	localIOException	IOException
    //   175	4	3	localObject	Object
    //   217	1	3	localException2	Exception
    //   8	173	4	localInputStream	InputStream
    //   35	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   65	70	83	java/io/IOException
    //   74	82	83	java/io/IOException
    //   10	28	89	java/lang/Exception
    //   98	103	116	java/io/IOException
    //   107	115	116	java/io/IOException
    //   10	28	122	java/lang/OutOfMemoryError
    //   141	146	159	java/io/IOException
    //   150	158	159	java/io/IOException
    //   127	132	165	java/io/IOException
    //   134	141	165	java/io/IOException
    //   30	37	175	finally
    //   39	51	175	finally
    //   53	59	175	finally
    //   61	65	175	finally
    //   94	98	175	finally
    //   127	132	175	finally
    //   134	141	175	finally
    //   168	172	175	finally
    //   180	185	199	java/io/IOException
    //   189	197	199	java/io/IOException
    //   10	28	207	finally
    //   30	37	213	java/lang/OutOfMemoryError
    //   39	51	213	java/lang/OutOfMemoryError
    //   53	59	213	java/lang/OutOfMemoryError
    //   61	65	213	java/lang/OutOfMemoryError
    //   30	37	217	java/lang/Exception
    //   39	51	217	java/lang/Exception
    //   53	59	217	java/lang/Exception
    //   61	65	217	java/lang/Exception
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  public static void delete(@Nullable File paramFile)
  {
    if (paramFile == null) {}
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
    } while (!paramFile.isDirectory());
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      delete(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void delete(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    delete(new File(paramString));
  }
  
  public static void deleteAllFilesOfDir(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        deleteAllFilesOfDir(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  public static void deleteFiles(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1).listFiles(new FileUtils.1(paramString2));
      if (paramString1 != null)
      {
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          paramString1[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public static boolean exists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.indexOf("assets") < 0) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static String genSeperateFileDir(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
    }
    return str;
  }
  
  /* Error */
  private static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokevirtual 431	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 436	android/content/res/AssetFileDescriptor:getLength	()J
    //   20: lstore_3
    //   21: aload_0
    //   22: ifnull +7 -> 29
    //   25: aload_0
    //   26: invokevirtual 437	android/content/res/AssetFileDescriptor:close	()V
    //   29: lload_3
    //   30: lreturn
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   36: lload_3
    //   37: lreturn
    //   38: astore_0
    //   39: aconst_null
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 437	android/content/res/AssetFileDescriptor:close	()V
    //   49: aload 6
    //   51: aload_1
    //   52: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 360	java/io/InputStream:available	()I
    //   60: istore_2
    //   61: iload_2
    //   62: i2l
    //   63: lstore_3
    //   64: aload_0
    //   65: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   68: lload_3
    //   69: lreturn
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   75: goto -26 -> 49
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 437	android/content/res/AssetFileDescriptor:close	()V
    //   89: aload_1
    //   90: athrow
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   96: goto -7 -> 89
    //   99: astore_0
    //   100: aload 5
    //   102: astore_0
    //   103: aload_0
    //   104: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   107: ldc2_w 438
    //   110: lreturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -7 -> 114
    //   124: astore_1
    //   125: goto -22 -> 103
    //   128: astore_1
    //   129: goto -48 -> 81
    //   132: astore 7
    //   134: goto -93 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramContext	Context
    //   0	137	1	paramString	String
    //   60	2	2	i	int
    //   20	49	3	l	long
    //   1	100	5	localObject	Object
    //   7	43	6	localAssetManager	AssetManager
    //   132	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   25	29	31	java/io/IOException
    //   9	16	38	java/io/IOException
    //   45	49	70	java/io/IOException
    //   9	16	78	finally
    //   85	89	91	java/io/IOException
    //   49	56	99	java/io/IOException
    //   49	56	111	finally
    //   56	61	120	finally
    //   56	61	124	java/io/IOException
    //   16	21	128	finally
    //   16	21	132	java/io/IOException
  }
  
  /* Error */
  public static String getAssetsMD5(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload 7
    //   5: astore 6
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload 7
    //   13: astore 6
    //   15: aload_1
    //   16: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +11 -> 30
    //   22: aload_2
    //   23: ifnonnull +10 -> 33
    //   26: aload 7
    //   28: astore 6
    //   30: aload 6
    //   32: areturn
    //   33: aload_0
    //   34: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   37: astore_0
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: astore_0
    //   44: aload_0
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 360	java/io/InputStream:available	()I
    //   50: istore_3
    //   51: iload_3
    //   52: ifgt +24 -> 76
    //   55: aload 7
    //   57: astore 6
    //   59: aload_0
    //   60: ifnull -30 -> 30
    //   63: aload_0
    //   64: invokevirtual 395	java/io/InputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: aload_0
    //   71: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   74: aconst_null
    //   75: areturn
    //   76: aload_0
    //   77: astore_1
    //   78: ldc_w 443
    //   81: invokestatic 449	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   84: astore 8
    //   86: aload_0
    //   87: astore_1
    //   88: sipush 4096
    //   91: newarray byte
    //   93: astore 6
    //   95: aload_0
    //   96: astore_1
    //   97: aload_0
    //   98: aload 6
    //   100: invokevirtual 308	java/io/InputStream:read	([B)I
    //   103: istore_3
    //   104: iload_3
    //   105: ifle +45 -> 150
    //   108: aload_0
    //   109: astore_1
    //   110: aload 8
    //   112: aload 6
    //   114: iconst_0
    //   115: iload_3
    //   116: invokevirtual 452	java/security/MessageDigest:update	([BII)V
    //   119: goto -24 -> 95
    //   122: astore_2
    //   123: aload_0
    //   124: astore_1
    //   125: aload_2
    //   126: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   129: aload 7
    //   131: astore 6
    //   133: aload_0
    //   134: ifnull -104 -> 30
    //   137: aload_0
    //   138: invokevirtual 395	java/io/InputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   148: aconst_null
    //   149: areturn
    //   150: aload_0
    //   151: astore_1
    //   152: aload 8
    //   154: aload_2
    //   155: invokevirtual 456	java/lang/String:getBytes	()[B
    //   158: invokevirtual 458	java/security/MessageDigest:update	([B)V
    //   161: aload_0
    //   162: astore_1
    //   163: new 99	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   170: astore 6
    //   172: aload_0
    //   173: astore_1
    //   174: aload 8
    //   176: invokevirtual 461	java/security/MessageDigest:digest	()[B
    //   179: astore 8
    //   181: aload_0
    //   182: astore_1
    //   183: aload 8
    //   185: arraylength
    //   186: istore 4
    //   188: iconst_0
    //   189: istore_3
    //   190: goto +96 -> 286
    //   193: aload_0
    //   194: astore_1
    //   195: aload 6
    //   197: aload_2
    //   198: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_0
    //   203: astore_1
    //   204: aload 6
    //   206: iload 5
    //   208: invokestatic 466	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   211: invokevirtual 469	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   214: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: iload_3
    //   219: iconst_1
    //   220: iadd
    //   221: istore_3
    //   222: goto +64 -> 286
    //   225: aload_0
    //   226: astore_1
    //   227: aload 6
    //   229: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore_2
    //   233: aload_2
    //   234: astore_1
    //   235: aload_1
    //   236: astore 6
    //   238: aload_0
    //   239: ifnull -209 -> 30
    //   242: aload_0
    //   243: invokevirtual 395	java/io/InputStream:close	()V
    //   246: aload_1
    //   247: areturn
    //   248: astore_0
    //   249: aload_0
    //   250: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   253: aload_1
    //   254: areturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: aload_1
    //   259: ifnull +7 -> 266
    //   262: aload_1
    //   263: invokevirtual 395	java/io/InputStream:close	()V
    //   266: aload_0
    //   267: athrow
    //   268: astore_1
    //   269: aload_1
    //   270: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   273: goto -7 -> 266
    //   276: astore_0
    //   277: goto -19 -> 258
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_0
    //   283: goto -160 -> 123
    //   286: iload_3
    //   287: iload 4
    //   289: if_icmpge -64 -> 225
    //   292: aload 8
    //   294: iload_3
    //   295: baload
    //   296: sipush 255
    //   299: iand
    //   300: istore 5
    //   302: iload 5
    //   304: bipush 16
    //   306: if_icmpge +10 -> 316
    //   309: ldc_w 471
    //   312: astore_2
    //   313: goto -120 -> 193
    //   316: ldc 172
    //   318: astore_2
    //   319: goto -126 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramContext	Context
    //   0	322	1	paramString1	String
    //   0	322	2	paramString2	String
    //   50	245	3	i	int
    //   186	104	4	j	int
    //   206	101	5	k	int
    //   5	232	6	localObject1	Object
    //   1	129	7	localObject2	Object
    //   84	209	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	69	java/lang/Exception
    //   46	51	122	java/lang/Exception
    //   78	86	122	java/lang/Exception
    //   88	95	122	java/lang/Exception
    //   97	104	122	java/lang/Exception
    //   110	119	122	java/lang/Exception
    //   152	161	122	java/lang/Exception
    //   163	172	122	java/lang/Exception
    //   174	181	122	java/lang/Exception
    //   183	188	122	java/lang/Exception
    //   195	202	122	java/lang/Exception
    //   204	218	122	java/lang/Exception
    //   227	233	122	java/lang/Exception
    //   137	141	143	java/lang/Exception
    //   242	246	248	java/lang/Exception
    //   38	44	255	finally
    //   262	266	268	java/lang/Exception
    //   46	51	276	finally
    //   78	86	276	finally
    //   88	95	276	finally
    //   97	104	276	finally
    //   110	119	276	finally
    //   125	129	276	finally
    //   152	161	276	finally
    //   163	172	276	finally
    //   174	181	276	finally
    //   183	188	276	finally
    //   195	202	276	finally
    //   204	218	276	finally
    //   227	233	276	finally
    //   38	44	280	java/lang/Exception
  }
  
  private static long getFileLength(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return -1L;
    }
    return paramString.length();
  }
  
  public static String getFileName(String paramString)
  {
    LogUtils.v(TAG, "[getFileName] path = " + paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".");
      int j = paramString.lastIndexOf("/");
      localObject1 = localObject2;
      if (j >= 0)
      {
        localObject1 = localObject2;
        if (i > j) {
          localObject1 = paramString.substring(j + 1, i);
        }
      }
    }
    LogUtils.v(TAG, "[getFileName] return title = " + (String)localObject1);
    return localObject1;
  }
  
  public static String getFileNameFromUrl(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while ((i == -1) || (i == paramString.length() - 1));
    return paramString.substring(i + 1);
  }
  
  public static String getFileNameWithSuffixByPath(String paramString)
  {
    LogUtils.v(TAG, "[getFileNameWithSuffixByPath] path = " + paramString);
    String str = null;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.substring(paramString.lastIndexOf("/") + 1);
    }
    LogUtils.v(TAG, "[getFileNameWithSuffixByPath] return title = " + str);
    return str;
  }
  
  public static String getFileSuffixFromUrl(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf(".");
    } while ((i == -1) || (i == paramString.length() - 1));
    return paramString.substring(i + 1);
  }
  
  public static String getFinalVideoName()
  {
    return String.format("selfiee_%s.mp4", new Object[] { new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) });
  }
  
  public static long getFolderSize(File paramFile)
  {
    for (;;)
    {
      try
      {
        paramFile = paramFile.listFiles();
        l1 = 0L;
        i = 0;
        l2 = l1;
        paramFile.printStackTrace();
      }
      catch (Exception paramFile)
      {
        try
        {
          if (i >= paramFile.length) {
            break label69;
          }
          if (paramFile[i].isDirectory())
          {
            l2 = l1 + getFolderSize(paramFile[i]);
            l1 = l2;
          }
          else
          {
            l2 = paramFile[i].length();
            l1 += l2;
          }
        }
        catch (Exception paramFile)
        {
          long l1;
          int i;
          long l2;
          break label62;
          i += 1;
        }
        paramFile = paramFile;
        l1 = 0L;
      }
      label62:
      l2 = l1;
      label69:
      return l2;
    }
  }
  
  public static String getMD5(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists()) {}
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      int k;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        paramString1 = new FileInputStream(paramString1);
        byte[] arrayOfByte = new byte[4096];
        i = paramString1.read(arrayOfByte);
        if (i != -1)
        {
          ((MessageDigest)localObject).update(arrayOfByte, 0, i);
          continue;
        }
        ((MessageDigest)localObject).update(paramString2.getBytes());
        paramString1.close();
        paramString2 = new StringBuilder();
        localObject = ((MessageDigest)localObject).digest();
        j = localObject.length;
        i = 0;
      }
      catch (Exception paramString1) {}
      paramString2.append(paramString1);
      paramString2.append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label135;
      paramString1 = paramString2.toString();
      return paramString1;
      return null;
      label135:
      if (i < j)
      {
        k = localObject[i] & 0xFF;
        if (k < 16) {
          paramString1 = "0";
        } else {
          paramString1 = "";
        }
      }
    }
  }
  
  public static String getPostfix(String paramString)
  {
    return paramString.substring(paramString.lastIndexOf("."));
  }
  
  public static String getRealDirPath(String paramString)
  {
    return getRealPath(paramString.substring(0, paramString.lastIndexOf(File.separator)));
  }
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("assets://")) {
      return paramString;
    }
    return paramString.substring("assets://".length());
  }
  
  public static String getSHA1(String paramString)
  {
    if (new File(paramString).exists()) {}
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int i;
      int j;
      int k;
      try
      {
        localObject2 = MessageDigest.getInstance("SHA-1");
        paramString = new FileInputStream(paramString);
        localObject1 = new byte[4096];
        i = paramString.read((byte[])localObject1);
        if (i != -1)
        {
          ((MessageDigest)localObject2).update((byte[])localObject1, 0, i);
          continue;
        }
        paramString.close();
        localObject1 = new StringBuilder();
        localObject2 = ((MessageDigest)localObject2).digest();
        j = localObject2.length;
        i = 0;
      }
      catch (Exception paramString) {}
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label129;
      paramString = ((StringBuilder)localObject1).toString();
      return paramString;
      return null;
      label129:
      if (i < j)
      {
        k = localObject2[i] & 0xFF;
        if (k < 16) {
          paramString = "0";
        } else {
          paramString = "";
        }
      }
    }
  }
  
  public static String getWritableDir(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (DeviceUtils.canWriteFile(str, false)) {
        return str;
      }
      i += 1;
    }
    return "";
  }
  
  public static boolean hasFiles(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!exists(paramString)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        paramString = new File(paramString);
        bool1 = bool2;
      } while (!paramString.isDirectory());
      paramString = paramString.list();
      if (paramString == null) {
        break;
      }
      bool1 = bool2;
    } while (paramString.length > 0);
    return false;
  }
  
  public static boolean isDirectoryWritable(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory())) {}
    do
    {
      return false;
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
    } while (!paramString.isDirectory());
    try
    {
      boolean bool = paramString.canWrite();
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean isFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static String load(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.startsWith("assets://")) {
      return loadAssetsString(paramContext, getRealPath(paramString));
    }
    return loadSdCardFileString(paramString);
  }
  
  public static String load(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    if (paramString1.startsWith("assets://")) {
      return loadAssetsString(paramContext, getRealPath(paramString1) + File.separator + paramString2);
    }
    return loadSdCardFileString(paramString1 + File.separator + paramString2);
  }
  
  public static byte[] loadAssetsByteArray(Context paramContext, String paramString)
  {
    try
    {
      paramString = paramContext.getAssets().open(paramString);
      paramContext = new byte[paramString.available()];
      LogUtils.e(paramString);
    }
    catch (Exception paramString)
    {
      try
      {
        paramString.read(paramContext);
        paramString.close();
        return paramContext;
      }
      catch (Exception paramString)
      {
        break label31;
      }
      paramString = paramString;
      paramContext = null;
    }
    label31:
    return paramContext;
  }
  
  /* Error */
  public static String loadAssetsString(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 99	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload_0
    //   15: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: new 548	java/io/BufferedReader
    //   26: dup
    //   27: new 550	java/io/InputStreamReader
    //   30: dup
    //   31: aload_0
    //   32: ldc_w 552
    //   35: invokespecial 553	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 556	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_2
    //   42: aload_2
    //   43: invokevirtual 559	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +47 -> 95
    //   51: aload 5
    //   53: aload_1
    //   54: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 5
    //   60: ldc_w 561
    //   63: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: goto -25 -> 42
    //   70: astore_3
    //   71: aload_0
    //   72: astore_1
    //   73: aload_2
    //   74: astore_0
    //   75: aload_3
    //   76: astore_2
    //   77: aload_2
    //   78: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   81: aload_0
    //   82: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   85: aload_1
    //   86: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   89: aload 5
    //   91: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: areturn
    //   95: aload_2
    //   96: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   99: aload_0
    //   100: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   103: goto -14 -> 89
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_3
    //   110: astore_2
    //   111: aload_2
    //   112: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   115: aload_0
    //   116: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   119: aload_1
    //   120: athrow
    //   121: astore_1
    //   122: aload_3
    //   123: astore_2
    //   124: goto -13 -> 111
    //   127: astore_1
    //   128: goto -17 -> 111
    //   131: astore_2
    //   132: aload_1
    //   133: astore_3
    //   134: aload_2
    //   135: astore_1
    //   136: aload_0
    //   137: astore_2
    //   138: aload_3
    //   139: astore_0
    //   140: goto -29 -> 111
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_0
    //   146: aload 4
    //   148: astore_1
    //   149: goto -72 -> 77
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_3
    //   155: aload_0
    //   156: astore_1
    //   157: aload_3
    //   158: astore_0
    //   159: goto -82 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramContext	Context
    //   0	162	1	paramString	String
    //   41	83	2	localObject1	Object
    //   131	4	2	localObject2	Object
    //   137	1	2	localContext	Context
    //   143	1	2	localIOException1	IOException
    //   152	1	2	localIOException2	IOException
    //   1	1	3	localObject3	Object
    //   70	53	3	localIOException3	IOException
    //   133	25	3	str	String
    //   3	144	4	localObject4	Object
    //   12	78	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   42	47	70	java/io/IOException
    //   51	67	70	java/io/IOException
    //   14	23	106	finally
    //   23	42	121	finally
    //   42	47	127	finally
    //   51	67	127	finally
    //   77	81	131	finally
    //   14	23	143	java/io/IOException
    //   23	42	152	java/io/IOException
  }
  
  /* Error */
  public static byte[] loadByteArray(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: aload 5
    //   11: astore_2
    //   12: aload_1
    //   13: ldc 35
    //   15: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   18: ifeq +36 -> 54
    //   21: aload 4
    //   23: astore_3
    //   24: aload 5
    //   26: astore_2
    //   27: aload_0
    //   28: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   31: aload_1
    //   32: invokestatic 515	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_0
    //   39: aload_0
    //   40: astore_3
    //   41: aload_0
    //   42: astore_2
    //   43: aload_0
    //   44: invokestatic 566	com/tencent/ttpic/baseutils/io/FileUtils:loadByteArray	(Ljava/io/InputStream;)[B
    //   47: astore_1
    //   48: aload_0
    //   49: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   52: aload_1
    //   53: areturn
    //   54: aload 4
    //   56: astore_3
    //   57: aload 5
    //   59: astore_2
    //   60: new 272	java/io/FileInputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 356	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   68: astore_0
    //   69: goto -30 -> 39
    //   72: astore_0
    //   73: aload_3
    //   74: astore_2
    //   75: aload_0
    //   76: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   79: aload_3
    //   80: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   83: iconst_0
    //   84: newarray byte
    //   86: areturn
    //   87: astore_0
    //   88: aload_2
    //   89: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramContext	Context
    //   0	94	1	paramString	String
    //   11	78	2	localObject1	Object
    //   8	72	3	localObject2	Object
    //   4	51	4	localObject3	Object
    //   1	57	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   12	21	72	java/io/IOException
    //   27	39	72	java/io/IOException
    //   43	48	72	java/io/IOException
    //   60	69	72	java/io/IOException
    //   12	21	87	finally
    //   27	39	87	finally
    //   43	48	87	finally
    //   60	69	87	finally
    //   75	79	87	finally
  }
  
  /* Error */
  public static byte[] loadByteArray(InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore 4
    //   7: new 568	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 569	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore_3
    //   15: aload_3
    //   16: astore_2
    //   17: aload_0
    //   18: aload 4
    //   20: invokevirtual 308	java/io/InputStream:read	([B)I
    //   23: istore_1
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +35 -> 61
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 570	java/io/ByteArrayOutputStream:write	([BII)V
    //   39: goto -24 -> 15
    //   42: astore_2
    //   43: aload_3
    //   44: astore_0
    //   45: aload_2
    //   46: astore_3
    //   47: aload_0
    //   48: astore_2
    //   49: aload_3
    //   50: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   53: aload_0
    //   54: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   57: iconst_0
    //   58: newarray byte
    //   60: areturn
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: invokevirtual 571	java/io/ByteArrayOutputStream:flush	()V
    //   67: aload_3
    //   68: astore_2
    //   69: aload_3
    //   70: invokevirtual 573	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: astore_0
    //   74: aload_3
    //   75: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   87: aload_0
    //   88: athrow
    //   89: astore_0
    //   90: goto -7 -> 83
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_0
    //   96: goto -49 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramInputStream	InputStream
    //   23	13	1	i	int
    //   16	15	2	localObject1	Object
    //   42	4	2	localIOException1	IOException
    //   48	36	2	localObject2	Object
    //   14	61	3	localObject3	Object
    //   93	1	3	localIOException2	IOException
    //   5	28	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	24	42	java/io/IOException
    //   31	39	42	java/io/IOException
    //   63	67	42	java/io/IOException
    //   69	74	42	java/io/IOException
    //   0	15	80	finally
    //   17	24	89	finally
    //   31	39	89	finally
    //   49	53	89	finally
    //   63	67	89	finally
    //   69	74	89	finally
    //   0	15	93	java/io/IOException
  }
  
  /* Error */
  public static String loadRawResourceString(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 550	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 377	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: iload_1
    //   9: invokevirtual 383	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   12: invokespecial 576	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: new 548	java/io/BufferedReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 556	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: new 99	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_2
    //   34: invokevirtual 559	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +31 -> 72
    //   44: aload_3
    //   45: aload 4
    //   47: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: bipush 10
    //   54: invokevirtual 579	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -25 -> 33
    //   61: astore_3
    //   62: aload_0
    //   63: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   66: aload_2
    //   67: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   76: aload_2
    //   77: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   80: aload_3
    //   81: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: areturn
    //   85: astore_3
    //   86: aload_0
    //   87: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   90: aload_2
    //   91: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   94: aload_3
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramContext	Context
    //   0	96	1	paramInt	int
    //   24	67	2	localBufferedReader	java.io.BufferedReader
    //   32	20	3	localStringBuilder	StringBuilder
    //   61	20	3	localIOException	IOException
    //   85	10	3	localObject	Object
    //   37	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   33	39	61	java/io/IOException
    //   44	58	61	java/io/IOException
    //   33	39	85	finally
    //   44	58	85	finally
  }
  
  /* Error */
  public static String loadSdCardFileString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 99	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   9: astore 4
    //   11: new 272	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 356	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: new 548	java/io/BufferedReader
    //   23: dup
    //   24: new 550	java/io/InputStreamReader
    //   27: dup
    //   28: aload_2
    //   29: ldc_w 552
    //   32: invokespecial 553	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   35: invokespecial 556	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 559	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +51 -> 96
    //   48: aload 4
    //   50: aload_1
    //   51: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: ldc_w 561
    //   60: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: goto -25 -> 39
    //   67: astore_3
    //   68: aload_2
    //   69: astore_1
    //   70: aload_3
    //   71: astore_2
    //   72: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   75: aload_2
    //   76: invokevirtual 582	java/io/IOException:getMessage	()Ljava/lang/String;
    //   79: invokestatic 342	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   86: aload_1
    //   87: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   90: aload 4
    //   92: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: areturn
    //   96: aload_0
    //   97: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   100: aload_2
    //   101: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   104: goto -14 -> 90
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_0
    //   113: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   116: aload_2
    //   117: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: goto -13 -> 112
    //   128: astore_1
    //   129: goto -17 -> 112
    //   132: astore_3
    //   133: aload_1
    //   134: astore_2
    //   135: aload_3
    //   136: astore_1
    //   137: goto -25 -> 112
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -71 -> 72
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_2
    //   150: astore_1
    //   151: aload_3
    //   152: astore_2
    //   153: goto -81 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   1	86	1	localObject1	Object
    //   107	14	1	localObject2	Object
    //   122	1	1	localObject3	Object
    //   128	6	1	localObject4	Object
    //   136	15	1	localObject5	Object
    //   19	116	2	localObject6	Object
    //   140	10	2	localIOException1	IOException
    //   152	1	2	localObject7	Object
    //   67	4	3	localIOException2	IOException
    //   132	4	3	localObject8	Object
    //   146	6	3	localIOException3	IOException
    //   9	82	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   39	44	67	java/io/IOException
    //   48	64	67	java/io/IOException
    //   11	20	107	finally
    //   20	39	122	finally
    //   39	44	128	finally
    //   48	64	128	finally
    //   72	82	132	finally
    //   11	20	140	java/io/IOException
    //   20	39	146	java/io/IOException
  }
  
  public static String md5ForBase64Data(String paramString)
  {
    int j = 0;
    Object localObject = new char[16];
    Object tmp10_8 = localObject;
    tmp10_8[0] = 114;
    Object tmp16_10 = tmp10_8;
    tmp16_10[1] = 68;
    Object tmp22_16 = tmp16_10;
    tmp22_16[2] = 122;
    Object tmp28_22 = tmp22_16;
    tmp28_22[3] = 111;
    Object tmp34_28 = tmp28_22;
    tmp34_28[4] = 105;
    Object tmp40_34 = tmp34_28;
    tmp40_34[5] = 101;
    Object tmp46_40 = tmp40_34;
    tmp46_40[6] = 53;
    Object tmp53_46 = tmp46_40;
    tmp53_46[7] = 101;
    Object tmp60_53 = tmp53_46;
    tmp60_53[8] = 51;
    Object tmp67_60 = tmp60_53;
    tmp67_60[9] = 111;
    Object tmp74_67 = tmp67_60;
    tmp74_67[10] = 110;
    Object tmp81_74 = tmp74_67;
    tmp81_74[11] = 103;
    Object tmp88_81 = tmp81_74;
    tmp88_81[12] = 102;
    Object tmp95_88 = tmp88_81;
    tmp95_88[13] = 122;
    Object tmp102_95 = tmp95_88;
    tmp102_95[14] = 49;
    Object tmp109_102 = tmp102_95;
    tmp109_102[15] = 108;
    tmp109_102;
    paramString = new StringBuffer(paramString);
    int i = 0;
    while (i < localObject.length)
    {
      paramString.append(localObject[i]);
      i += 1;
    }
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.toString().getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int k = paramString.length;
      i = j;
      while (i < k)
      {
        ((StringBuffer)localObject).append(String.format("%02x", new Object[] { Integer.valueOf(paramString[i] & 0xFF) }));
        i += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static void merge(List<String> paramList, File paramFile)
  {
    paramFile = new FileOutputStream(paramFile);
    byte[] arrayOfByte = new byte[1024];
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FileInputStream localFileInputStream = new FileInputStream(new File((String)paramList.next()));
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramFile.write(arrayOfByte, 0, i);
      }
      paramFile.flush();
      localFileInputStream.close();
    }
    paramFile.close();
  }
  
  public static boolean move(File paramFile, String paramString)
  {
    return paramFile.renameTo(new File(new File(paramString), paramFile.getName()));
  }
  
  /* Error */
  private static boolean performCopyAssetsFile(Context paramContext, String paramString1, String paramString2, FileUtils.AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +10 -> 17
    //   10: aload_2
    //   11: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   20: ldc_w 329
    //   23: invokestatic 332	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: astore 8
    //   34: new 97	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 7
    //   44: aload 7
    //   46: invokevirtual 183	java/io/File:exists	()Z
    //   49: ifeq +52 -> 101
    //   52: aload_3
    //   53: ifnull +35 -> 88
    //   56: aload_3
    //   57: aload_0
    //   58: aload_1
    //   59: aload 7
    //   61: invokeinterface 652 4 0
    //   66: ifeq +22 -> 88
    //   69: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   72: ldc_w 339
    //   75: invokestatic 342	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aconst_null
    //   79: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   82: aconst_null
    //   83: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   86: iconst_1
    //   87: ireturn
    //   88: aload 7
    //   90: invokevirtual 230	java/io/File:isDirectory	()Z
    //   93: ifeq +8 -> 101
    //   96: aload 7
    //   98: invokestatic 346	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   101: aload 7
    //   103: invokevirtual 350	java/io/File:getParentFile	()Ljava/io/File;
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 353	java/io/File:isFile	()Z
    //   111: ifeq +7 -> 118
    //   114: aload_0
    //   115: invokestatic 346	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   118: aload_0
    //   119: invokevirtual 183	java/io/File:exists	()Z
    //   122: ifne +49 -> 171
    //   125: aload_0
    //   126: invokevirtual 124	java/io/File:mkdirs	()Z
    //   129: ifne +42 -> 171
    //   132: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   135: new 99	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 355
    //   145: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 107	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   152: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 332	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aconst_null
    //   162: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   165: aconst_null
    //   166: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   169: iconst_0
    //   170: ireturn
    //   171: aload 8
    //   173: aload_1
    //   174: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 360	java/io/InputStream:available	()I
    //   182: istore 4
    //   184: iload 4
    //   186: ifgt +20 -> 206
    //   189: iconst_0
    //   190: istore 5
    //   192: aload 6
    //   194: astore_1
    //   195: aload_0
    //   196: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   199: aload_1
    //   200: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   203: iload 5
    //   205: ireturn
    //   206: new 362	java/io/BufferedOutputStream
    //   209: dup
    //   210: new 266	java/io/FileOutputStream
    //   213: dup
    //   214: aload 7
    //   216: invokespecial 268	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   219: invokespecial 364	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   222: astore_2
    //   223: sipush 1024
    //   226: newarray byte
    //   228: astore_1
    //   229: aload_0
    //   230: aload_1
    //   231: invokevirtual 308	java/io/InputStream:read	([B)I
    //   234: istore 4
    //   236: iload 4
    //   238: ifle +63 -> 301
    //   241: aload_2
    //   242: aload_1
    //   243: iconst_0
    //   244: iload 4
    //   246: invokevirtual 311	java/io/OutputStream:write	([BII)V
    //   249: goto -20 -> 229
    //   252: astore_3
    //   253: aload_0
    //   254: astore_1
    //   255: aload_2
    //   256: astore_0
    //   257: aload_3
    //   258: astore_2
    //   259: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   262: ldc_w 654
    //   265: iconst_1
    //   266: anewarray 4	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: aload_2
    //   272: invokevirtual 367	java/lang/Throwable:toString	()Ljava/lang/String;
    //   275: aastore
    //   276: invokestatic 371	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokestatic 332	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload 7
    //   284: invokestatic 346	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   287: aload_1
    //   288: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   291: aload_0
    //   292: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   295: iconst_0
    //   296: istore 5
    //   298: goto -95 -> 203
    //   301: aload_2
    //   302: astore_1
    //   303: iconst_1
    //   304: istore 5
    //   306: goto -111 -> 195
    //   309: astore_1
    //   310: aconst_null
    //   311: astore_0
    //   312: aconst_null
    //   313: astore_2
    //   314: aload_0
    //   315: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   318: aload_2
    //   319: invokestatic 344	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   322: aload_1
    //   323: athrow
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: goto -13 -> 314
    //   330: astore_1
    //   331: goto -17 -> 314
    //   334: astore_2
    //   335: aload_1
    //   336: astore_3
    //   337: aload_2
    //   338: astore_1
    //   339: aload_0
    //   340: astore_2
    //   341: aload_3
    //   342: astore_0
    //   343: goto -29 -> 314
    //   346: astore_2
    //   347: aconst_null
    //   348: astore_1
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -92 -> 259
    //   354: astore_2
    //   355: aload_0
    //   356: astore_1
    //   357: aconst_null
    //   358: astore_0
    //   359: goto -100 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	paramContext	Context
    //   0	362	1	paramString1	String
    //   0	362	2	paramString2	String
    //   0	362	3	paramAssetFileComparator	FileUtils.AssetFileComparator
    //   182	63	4	i	int
    //   190	115	5	bool	boolean
    //   1	192	6	localObject	Object
    //   42	241	7	localFile	File
    //   32	140	8	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   223	229	252	java/lang/Throwable
    //   229	236	252	java/lang/Throwable
    //   241	249	252	java/lang/Throwable
    //   44	52	309	finally
    //   56	78	309	finally
    //   88	101	309	finally
    //   101	118	309	finally
    //   118	161	309	finally
    //   171	178	309	finally
    //   178	184	324	finally
    //   206	223	324	finally
    //   223	229	330	finally
    //   229	236	330	finally
    //   241	249	330	finally
    //   259	287	334	finally
    //   44	52	346	java/lang/Throwable
    //   56	78	346	java/lang/Throwable
    //   88	101	346	java/lang/Throwable
    //   101	118	346	java/lang/Throwable
    //   118	161	346	java/lang/Throwable
    //   171	178	346	java/lang/Throwable
    //   178	184	354	java/lang/Throwable
    //   206	223	354	java/lang/Throwable
  }
  
  public static byte[] readBytes(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    for (;;)
    {
      if (i < paramInt) {
        try
        {
          int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
          if (j != -1) {
            i += j;
          }
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    return arrayOfByte;
  }
  
  /* Error */
  public static byte[] readFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 97	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 183	java/io/File:exists	()Z
    //   24: ifeq -17 -> 7
    //   27: aload 4
    //   29: invokevirtual 391	java/io/File:length	()J
    //   32: l2i
    //   33: istore_2
    //   34: new 568	java/io/ByteArrayOutputStream
    //   37: dup
    //   38: iload_2
    //   39: invokespecial 664	java/io/ByteArrayOutputStream:<init>	(I)V
    //   42: astore_0
    //   43: new 272	java/io/FileInputStream
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: astore 8
    //   54: iload_2
    //   55: sipush 4096
    //   58: if_icmpge +73 -> 131
    //   61: aload_0
    //   62: astore 5
    //   64: aload 8
    //   66: astore 4
    //   68: invokestatic 281	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   71: sipush 4096
    //   74: invokevirtual 285	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   77: astore 6
    //   79: aload 6
    //   81: astore 4
    //   83: iconst_0
    //   84: istore_1
    //   85: aload 4
    //   87: astore 6
    //   89: iload_1
    //   90: iload_2
    //   91: if_icmpge +90 -> 181
    //   94: aload_0
    //   95: astore 5
    //   97: aload 8
    //   99: astore 4
    //   101: aload 8
    //   103: aload 6
    //   105: invokevirtual 509	java/io/FileInputStream:read	([B)I
    //   108: istore_3
    //   109: aload_0
    //   110: astore 5
    //   112: aload 8
    //   114: astore 4
    //   116: aload_0
    //   117: aload 6
    //   119: iconst_0
    //   120: iload_3
    //   121: invokevirtual 570	java/io/ByteArrayOutputStream:write	([BII)V
    //   124: iload_1
    //   125: iload_3
    //   126: iadd
    //   127: istore_1
    //   128: goto -39 -> 89
    //   131: aload_0
    //   132: astore 5
    //   134: aload 8
    //   136: astore 4
    //   138: invokestatic 281	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   141: sipush 12288
    //   144: invokevirtual 285	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   147: astore 6
    //   149: aload 6
    //   151: astore 4
    //   153: goto -70 -> 83
    //   156: astore 4
    //   158: aload_0
    //   159: astore 5
    //   161: aload 8
    //   163: astore 4
    //   165: invokestatic 281	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   168: sipush 4096
    //   171: invokevirtual 285	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   174: astore 6
    //   176: iconst_0
    //   177: istore_1
    //   178: goto -89 -> 89
    //   181: aload_0
    //   182: astore 5
    //   184: aload 8
    //   186: astore 4
    //   188: invokestatic 281	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   191: aload 6
    //   193: invokevirtual 302	com/tencent/ttpic/baseutils/io/ByteArrayPool:returnBuf	([B)V
    //   196: aload_0
    //   197: astore 5
    //   199: aload 8
    //   201: astore 4
    //   203: aload_0
    //   204: invokevirtual 573	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   207: astore 6
    //   209: aload 6
    //   211: astore 4
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 665	java/io/ByteArrayOutputStream:close	()V
    //   221: aload 4
    //   223: astore_0
    //   224: aload 8
    //   226: ifnull +11 -> 237
    //   229: aload 8
    //   231: invokevirtual 510	java/io/FileInputStream:close	()V
    //   234: aload 4
    //   236: astore_0
    //   237: aload_0
    //   238: areturn
    //   239: astore_0
    //   240: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   243: ldc_w 667
    //   246: aload_0
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   254: aload 4
    //   256: astore_0
    //   257: goto -20 -> 237
    //   260: astore 6
    //   262: aconst_null
    //   263: astore 7
    //   265: aconst_null
    //   266: astore_0
    //   267: aload 7
    //   269: astore 5
    //   271: aload_0
    //   272: astore 4
    //   274: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   277: ldc_w 672
    //   280: aload 6
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   289: aload 7
    //   291: ifnull +8 -> 299
    //   294: aload 7
    //   296: invokevirtual 665	java/io/ByteArrayOutputStream:close	()V
    //   299: aload_0
    //   300: ifnull +7 -> 307
    //   303: aload_0
    //   304: invokevirtual 510	java/io/FileInputStream:close	()V
    //   307: aconst_null
    //   308: astore_0
    //   309: goto -72 -> 237
    //   312: astore_0
    //   313: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   316: ldc_w 667
    //   319: aload_0
    //   320: iconst_0
    //   321: anewarray 4	java/lang/Object
    //   324: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   327: aconst_null
    //   328: astore_0
    //   329: goto -92 -> 237
    //   332: astore 6
    //   334: aconst_null
    //   335: astore_0
    //   336: aconst_null
    //   337: astore 4
    //   339: aload_0
    //   340: ifnull +7 -> 347
    //   343: aload_0
    //   344: invokevirtual 665	java/io/ByteArrayOutputStream:close	()V
    //   347: aload 4
    //   349: ifnull +8 -> 357
    //   352: aload 4
    //   354: invokevirtual 510	java/io/FileInputStream:close	()V
    //   357: aload 6
    //   359: athrow
    //   360: astore_0
    //   361: getstatic 60	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   364: ldc_w 667
    //   367: aload_0
    //   368: iconst_0
    //   369: anewarray 4	java/lang/Object
    //   372: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   375: goto -18 -> 357
    //   378: astore 6
    //   380: aconst_null
    //   381: astore 4
    //   383: goto -44 -> 339
    //   386: astore 6
    //   388: aload 5
    //   390: astore_0
    //   391: goto -52 -> 339
    //   394: astore 6
    //   396: aconst_null
    //   397: astore 4
    //   399: aload_0
    //   400: astore 7
    //   402: aload 4
    //   404: astore_0
    //   405: goto -138 -> 267
    //   408: astore 6
    //   410: aload_0
    //   411: astore 7
    //   413: aload 8
    //   415: astore_0
    //   416: goto -149 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	paramString	String
    //   84	94	1	i	int
    //   33	59	2	j	int
    //   108	19	3	k	int
    //   17	135	4	localObject1	Object
    //   156	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   163	240	4	localObject2	Object
    //   62	327	5	localObject3	Object
    //   77	133	6	localObject4	Object
    //   260	21	6	localException1	Exception
    //   332	26	6	localObject5	Object
    //   378	1	6	localObject6	Object
    //   386	1	6	localObject7	Object
    //   394	1	6	localException2	Exception
    //   408	1	6	localException3	Exception
    //   263	149	7	str	String
    //   52	362	8	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   68	79	156	java/lang/OutOfMemoryError
    //   138	149	156	java/lang/OutOfMemoryError
    //   217	221	239	java/io/IOException
    //   229	234	239	java/io/IOException
    //   27	43	260	java/lang/Exception
    //   294	299	312	java/io/IOException
    //   303	307	312	java/io/IOException
    //   27	43	332	finally
    //   343	347	360	java/io/IOException
    //   352	357	360	java/io/IOException
    //   43	54	378	finally
    //   68	79	386	finally
    //   101	109	386	finally
    //   116	124	386	finally
    //   138	149	386	finally
    //   165	176	386	finally
    //   188	196	386	finally
    //   203	209	386	finally
    //   274	289	386	finally
    //   43	54	394	java/lang/Exception
    //   68	79	408	java/lang/Exception
    //   101	109	408	java/lang/Exception
    //   116	124	408	java/lang/Exception
    //   138	149	408	java/lang/Exception
    //   165	176	408	java/lang/Exception
    //   188	196	408	java/lang/Exception
    //   203	209	408	java/lang/Exception
  }
  
  /* Error */
  public static String readTextFileFromRaw(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 377	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 383	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore_0
    //   9: new 550	java/io/InputStreamReader
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 576	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 548	java/io/BufferedReader
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 556	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore_3
    //   27: new 99	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   34: astore 4
    //   36: aload_3
    //   37: invokevirtual 559	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 5
    //   42: aload 5
    //   44: ifnull +38 -> 82
    //   47: aload 4
    //   49: aload 5
    //   51: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: bipush 10
    //   59: invokevirtual 579	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: goto -27 -> 36
    //   66: astore 4
    //   68: aload_0
    //   69: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   72: aload_2
    //   73: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   76: aload_3
    //   77: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   80: aconst_null
    //   81: areturn
    //   82: aload_0
    //   83: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   86: aload_2
    //   87: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   90: aload_3
    //   91: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   94: aload 4
    //   96: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: areturn
    //   100: astore 4
    //   102: aload_0
    //   103: invokestatic 216	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   106: aload_2
    //   107: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   110: aload_3
    //   111: invokestatic 563	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   114: aload 4
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContext	Context
    //   0	117	1	paramInt	int
    //   17	90	2	localInputStreamReader	java.io.InputStreamReader
    //   26	85	3	localBufferedReader	java.io.BufferedReader
    //   34	22	4	localStringBuilder	StringBuilder
    //   66	29	4	localIOException	IOException
    //   100	15	4	localObject	Object
    //   40	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   36	42	66	java/io/IOException
    //   47	63	66	java/io/IOException
    //   36	42	100	finally
    //   47	63	100	finally
  }
  
  /* Error */
  public static String readTxtFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 99	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   16: astore 5
    //   18: aload_1
    //   19: ldc 35
    //   21: invokevirtual 167	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: ifeq +189 -> 213
    //   27: aload_0
    //   28: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   31: aload_1
    //   32: ldc 35
    //   34: invokevirtual 482	java/lang/String:length	()I
    //   37: invokevirtual 170	java/lang/String:substring	(I)Ljava/lang/String;
    //   40: invokevirtual 210	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: astore_0
    //   44: new 548	java/io/BufferedReader
    //   47: dup
    //   48: new 550	java/io/InputStreamReader
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 576	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 556	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_1
    //   60: aload_1
    //   61: astore_3
    //   62: aload_0
    //   63: astore_2
    //   64: aload_1
    //   65: invokevirtual 559	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 4
    //   70: aload 4
    //   72: ifnull +51 -> 123
    //   75: aload_1
    //   76: astore_3
    //   77: aload_0
    //   78: astore_2
    //   79: aload 5
    //   81: aload 4
    //   83: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: goto -27 -> 60
    //   90: astore 4
    //   92: aload_1
    //   93: astore_3
    //   94: aload_0
    //   95: astore_2
    //   96: aload 4
    //   98: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 675	java/io/BufferedReader:close	()V
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 395	java/io/InputStream:close	()V
    //   117: aload 5
    //   119: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: areturn
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 675	java/io/BufferedReader:close	()V
    //   131: aload_0
    //   132: ifnull -15 -> 117
    //   135: aload_0
    //   136: invokevirtual 395	java/io/InputStream:close	()V
    //   139: goto -22 -> 117
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   147: goto -30 -> 117
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   155: goto -24 -> 131
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   163: goto -54 -> 109
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   171: goto -54 -> 117
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 675	java/io/BufferedReader:close	()V
    //   187: aload_0
    //   188: ifnull +7 -> 195
    //   191: aload_0
    //   192: invokevirtual 395	java/io/InputStream:close	()V
    //   195: aload_1
    //   196: athrow
    //   197: astore_2
    //   198: aload_2
    //   199: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   202: goto -15 -> 187
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   210: goto -15 -> 195
    //   213: new 548	java/io/BufferedReader
    //   216: dup
    //   217: new 677	java/io/FileReader
    //   220: dup
    //   221: aload_1
    //   222: invokespecial 678	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   225: invokespecial 556	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   228: astore_1
    //   229: aload_1
    //   230: astore_0
    //   231: aload_1
    //   232: invokevirtual 559	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   235: astore_2
    //   236: aload_2
    //   237: ifnull +41 -> 278
    //   240: aload_1
    //   241: astore_0
    //   242: aload 5
    //   244: aload_2
    //   245: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: goto -20 -> 229
    //   252: astore_2
    //   253: aload_1
    //   254: astore_0
    //   255: aload_2
    //   256: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   259: aload_1
    //   260: ifnull -143 -> 117
    //   263: aload_1
    //   264: invokevirtual 675	java/io/BufferedReader:close	()V
    //   267: goto -150 -> 117
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   275: goto -158 -> 117
    //   278: aload_1
    //   279: ifnull -162 -> 117
    //   282: aload_1
    //   283: invokevirtual 675	java/io/BufferedReader:close	()V
    //   286: goto -169 -> 117
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   294: goto -177 -> 117
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_0
    //   300: aload_0
    //   301: ifnull +7 -> 308
    //   304: aload_0
    //   305: invokevirtual 675	java/io/BufferedReader:close	()V
    //   308: aload_1
    //   309: athrow
    //   310: astore_0
    //   311: aload_0
    //   312: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   315: goto -7 -> 308
    //   318: astore_1
    //   319: goto -19 -> 300
    //   322: astore_2
    //   323: aconst_null
    //   324: astore_1
    //   325: goto -72 -> 253
    //   328: astore_1
    //   329: aconst_null
    //   330: astore_3
    //   331: goto -152 -> 179
    //   334: astore_1
    //   335: aload_2
    //   336: astore_0
    //   337: goto -158 -> 179
    //   340: astore 4
    //   342: aconst_null
    //   343: astore_0
    //   344: aconst_null
    //   345: astore_1
    //   346: goto -254 -> 92
    //   349: astore 4
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -261 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramContext	Context
    //   0	356	1	paramString	String
    //   63	33	2	localContext	Context
    //   197	2	2	localIOException1	IOException
    //   235	10	2	str1	String
    //   252	4	2	localIOException2	IOException
    //   322	14	2	localIOException3	IOException
    //   61	270	3	str2	String
    //   68	14	4	str3	String
    //   90	7	4	localIOException4	IOException
    //   340	1	4	localIOException5	IOException
    //   349	1	4	localIOException6	IOException
    //   16	227	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	70	90	java/io/IOException
    //   79	87	90	java/io/IOException
    //   135	139	142	java/io/IOException
    //   127	131	150	java/io/IOException
    //   105	109	158	java/io/IOException
    //   113	117	166	java/io/IOException
    //   27	44	174	finally
    //   183	187	197	java/io/IOException
    //   191	195	205	java/io/IOException
    //   231	236	252	java/io/IOException
    //   242	249	252	java/io/IOException
    //   263	267	270	java/io/IOException
    //   282	286	289	java/io/IOException
    //   213	229	297	finally
    //   304	308	310	java/io/IOException
    //   231	236	318	finally
    //   242	249	318	finally
    //   255	259	318	finally
    //   213	229	322	java/io/IOException
    //   44	60	328	finally
    //   64	70	334	finally
    //   79	87	334	finally
    //   96	101	334	finally
    //   27	44	340	java/io/IOException
    //   44	60	349	java/io/IOException
  }
  
  /* Error */
  public static com.tencent.ttpic.baseutils.bitmap.BitmapUtils.SAVE_STATUS save(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 97	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 350	java/io/File:getParentFile	()Ljava/io/File;
    //   13: invokevirtual 183	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_2
    //   20: invokevirtual 350	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 124	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: new 266	java/io/FileOutputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   35: astore_2
    //   36: aload_2
    //   37: astore_0
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 682	java/io/OutputStream:write	([B)V
    //   43: aload_2
    //   44: astore_0
    //   45: getstatic 688	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   48: astore_1
    //   49: aload_2
    //   50: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   53: aload_1
    //   54: areturn
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_3
    //   61: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   64: aload_1
    //   65: astore_0
    //   66: getstatic 691	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   69: astore_2
    //   70: aload_1
    //   71: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   74: aload_2
    //   75: areturn
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: goto -7 -> 79
    //   89: astore_3
    //   90: aload_2
    //   91: astore_1
    //   92: goto -34 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramString	String
    //   0	95	1	paramArrayOfByte	byte[]
    //   8	83	2	localObject	Object
    //   55	6	3	localException1	Exception
    //   89	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   27	36	55	java/lang/Exception
    //   27	36	76	finally
    //   38	43	85	finally
    //   45	49	85	finally
    //   60	64	85	finally
    //   66	70	85	finally
    //   38	43	89	java/lang/Exception
    //   45	49	89	java/lang/Exception
  }
  
  /* Error */
  public static void save(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 266	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 268	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: new 693	java/io/BufferedWriter
    //   17: dup
    //   18: new 695	java/io/OutputStreamWriter
    //   21: dup
    //   22: aload_2
    //   23: ldc_w 552
    //   26: invokespecial 698	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   29: invokespecial 701	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   32: astore_0
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 703	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   42: aload_0
    //   43: invokestatic 705	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   46: return
    //   47: astore_2
    //   48: aconst_null
    //   49: astore_0
    //   50: aload 4
    //   52: astore_1
    //   53: aload_2
    //   54: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   57: aload_1
    //   58: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   61: aload_0
    //   62: invokestatic 705	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   65: return
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_3
    //   70: astore_1
    //   71: aload_2
    //   72: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   75: aload_1
    //   76: invokestatic 705	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   79: aload_0
    //   80: athrow
    //   81: astore_0
    //   82: aload_3
    //   83: astore_1
    //   84: goto -13 -> 71
    //   87: astore_3
    //   88: aload_0
    //   89: astore_1
    //   90: aload_3
    //   91: astore_0
    //   92: goto -21 -> 71
    //   95: astore_3
    //   96: aload_1
    //   97: astore_2
    //   98: aload_0
    //   99: astore_1
    //   100: aload_3
    //   101: astore_0
    //   102: goto -31 -> 71
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: goto -59 -> 53
    //   115: astore_3
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: astore_2
    //   120: goto -67 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramFile	File
    //   0	123	1	paramString	String
    //   13	26	2	localFileOutputStream	FileOutputStream
    //   47	7	2	localException1	Exception
    //   68	52	2	localObject1	Object
    //   1	82	3	localObject2	Object
    //   87	4	3	localObject3	Object
    //   95	6	3	localObject4	Object
    //   105	6	3	localException2	Exception
    //   115	4	3	localException3	Exception
    //   3	48	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   5	14	47	java/lang/Exception
    //   5	14	66	finally
    //   14	33	81	finally
    //   33	38	87	finally
    //   53	57	95	finally
    //   14	33	105	java/lang/Exception
    //   33	38	115	java/lang/Exception
  }
  
  /* Error */
  public static void saveFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 693	java/io/BufferedWriter
    //   5: dup
    //   6: new 708	java/io/FileWriter
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 709	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 701	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: aload_1
    //   22: invokevirtual 703	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: invokestatic 705	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   29: return
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_3
    //   36: invokestatic 317	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   39: aload_1
    //   40: invokestatic 705	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   43: return
    //   44: astore_0
    //   45: aload_3
    //   46: astore_1
    //   47: aload_1
    //   48: invokestatic 705	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   51: aload_0
    //   52: athrow
    //   53: astore_2
    //   54: aload_0
    //   55: astore_1
    //   56: aload_2
    //   57: astore_0
    //   58: goto -11 -> 47
    //   61: astore_3
    //   62: aload_2
    //   63: astore_1
    //   64: goto -31 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramString1	String
    //   0	67	1	paramString2	String
    //   17	9	2	localBufferedWriter	java.io.BufferedWriter
    //   53	10	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   30	16	3	localIOException1	IOException
    //   61	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   2	18	30	java/io/IOException
    //   2	18	44	finally
    //   20	25	53	finally
    //   35	39	53	finally
    //   20	25	61	java/io/IOException
  }
  
  public static String toBase64(String paramString)
  {
    try
    {
      paramString = new FileInputStream(new File(paramString));
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject = new Base64OutputStream(localByteArrayOutputStream, 2);
      byte[] arrayOfByte = new byte[4096];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        ((Base64OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      ((Base64OutputStream)localObject).flush();
      ((Base64OutputStream)localObject).close();
      localObject = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      try
      {
        localByteArrayOutputStream.close();
        paramString.close();
        return localObject;
      }
      catch (Exception paramString)
      {
        return localObject;
      }
      return null;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.io.FileUtils
 * JD-Core Version:    0.7.0.1
 */