package com.tencent.ttpic.baseutils.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64OutputStream;
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
  private static final String TAG = "FileUtils";
  
  public static void CopyAssetsMaterialToExternalStorage(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = paramContext.getAssets().list(paramString);
      if (localObject.length > 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramContext.getExternalFilesDir(null).getAbsolutePath());
        localStringBuilder1.append(File.separator);
        localStringBuilder1.append(paramString);
        new File(localStringBuilder1.toString()).mkdirs();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder1 = localObject[i];
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramString);
          localStringBuilder2.append(File.separator);
          localStringBuilder2.append(localStringBuilder1);
          paramString = localStringBuilder2.toString();
          CopyAssetsMaterialToExternalStorage(paramContext, paramString);
          paramString = paramString.substring(0, paramString.lastIndexOf(File.separator));
          i += 1;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getExternalFilesDir(null).getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      copyAssets(paramContext, paramString, ((StringBuilder)localObject).toString());
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean assetAndPathExist(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
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
      }
      return false;
    }
    catch (IOException paramContext) {}
    return new File(paramString).exists();
    return false;
  }
  
  public static void asyncCopyFile(InputStream paramInputStream, String paramString, FileUtils.OnFileCopyListener paramOnFileCopyListener)
  {
    paramInputStream = new FileUtils.FileCopyTask(paramInputStream, paramString);
    paramInputStream.setOnFileCopyListener(paramOnFileCopyListener);
    paramInputStream.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[0]);
  }
  
  public static boolean canWriteFile(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str;
    if (!paramBoolean)
    {
      str = paramString;
      if (!paramString.endsWith(File.separator)) {}
    }
    else
    {
      int i = paramString.lastIndexOf(File.separator);
      str = paramString;
      if (i > -1) {
        str = paramString.substring(0, i);
      }
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append(File.separator);
    paramString.append("test_temp.txt");
    paramString = new File(paramString.toString());
    try
    {
      if (!paramString.getParentFile().exists()) {
        paramString.getParentFile().mkdirs();
      }
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      paramString.delete();
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static String checkAssetsPhoto(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore_0
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   24: aload_1
    //   25: areturn
    //   26: astore_0
    //   27: aconst_null
    //   28: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   31: aload_0
    //   32: athrow
    //   33: aconst_null
    //   34: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   37: aload_1
    //   38: ldc 233
    //   40: invokevirtual 127	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   43: iconst_m1
    //   44: if_icmpeq +66 -> 110
    //   47: new 91	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   54: astore_2
    //   55: aload_2
    //   56: aload_1
    //   57: iconst_0
    //   58: aload_1
    //   59: bipush 46
    //   61: invokevirtual 236	java/lang/String:lastIndexOf	(I)I
    //   64: iconst_1
    //   65: iadd
    //   66: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   69: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: ldc 238
    //   76: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   90: astore_0
    //   91: aload_0
    //   92: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   95: aload_1
    //   96: areturn
    //   97: astore_0
    //   98: aconst_null
    //   99: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   102: aload_0
    //   103: athrow
    //   104: aconst_null
    //   105: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   108: aconst_null
    //   109: areturn
    //   110: new 91	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   117: astore_2
    //   118: aload_2
    //   119: aload_1
    //   120: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_2
    //   125: ldc 11
    //   127: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_2
    //   132: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_2
    //   136: aload_0
    //   137: aload_2
    //   138: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_3
    //   142: aload_3
    //   143: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   146: aload_2
    //   147: areturn
    //   148: astore_0
    //   149: aconst_null
    //   150: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   153: aload_0
    //   154: athrow
    //   155: aconst_null
    //   156: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   159: new 91	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   166: astore_2
    //   167: aload_2
    //   168: aload_1
    //   169: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: ldc 20
    //   176: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_2
    //   181: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: astore_2
    //   185: aload_0
    //   186: aload_2
    //   187: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   190: astore_3
    //   191: aload_3
    //   192: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   195: aload_2
    //   196: areturn
    //   197: astore_0
    //   198: aconst_null
    //   199: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   202: aload_0
    //   203: athrow
    //   204: aconst_null
    //   205: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   208: new 91	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   215: astore_2
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: ldc 17
    //   225: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_2
    //   230: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_1
    //   234: aload_0
    //   235: aload_1
    //   236: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   239: astore_0
    //   240: aload_0
    //   241: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   244: aload_1
    //   245: areturn
    //   246: astore_0
    //   247: aconst_null
    //   248: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   251: aload_0
    //   252: athrow
    //   253: aconst_null
    //   254: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   257: aconst_null
    //   258: areturn
    //   259: astore_2
    //   260: goto -227 -> 33
    //   263: astore_0
    //   264: goto -160 -> 104
    //   267: astore_2
    //   268: goto -113 -> 155
    //   271: astore_2
    //   272: goto -68 -> 204
    //   275: astore_0
    //   276: goto -23 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   0	279	1	paramString	String
    //   19	211	2	localObject	Object
    //   259	1	2	localIOException1	IOException
    //   267	1	2	localIOException2	IOException
    //   271	1	2	localIOException3	IOException
    //   141	51	3	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   14	20	26	finally
    //   85	91	97	finally
    //   136	142	148	finally
    //   185	191	197	finally
    //   234	240	246	finally
    //   14	20	259	java/io/IOException
    //   85	91	263	java/io/IOException
    //   136	142	267	java/io/IOException
    //   185	191	271	java/io/IOException
    //   234	240	275	java/io/IOException
  }
  
  public static String checkPhoto(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (new File(paramString).exists()) {
      return paramString;
    }
    if (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") == -1)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".jpg");
      localObject = ((StringBuilder)localObject).toString();
      if (new File((String)localObject).exists()) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      if (new File((String)localObject).exists()) {
        return localObject;
      }
    }
    return paramString;
  }
  
  public static void clearDir(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isDirectory()) {
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          clearDir(localFile);
        } else {
          localFile.delete();
        }
        i += 1;
      }
      paramFile.delete();
    }
  }
  
  public static void clearDirs(File[] paramArrayOfFile)
  {
    if (paramArrayOfFile == null) {
      return;
    }
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      clearDir(paramArrayOfFile[i]);
      i += 1;
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
    try
    {
      Object localObject = paramContext.getAssets().list(paramString1);
      if (localObject.length > 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(paramString2);
        localStringBuilder1.append(File.separator);
        localStringBuilder1.append(paramString1);
        new File(localStringBuilder1.toString()).mkdirs();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder1 = localObject[i];
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramString1);
          localStringBuilder2.append(File.separator);
          localStringBuilder2.append(localStringBuilder1);
          paramString1 = localStringBuilder2.toString();
          copyAssetsToSDCard(paramContext, paramString1, paramString2);
          paramString1 = paramString1.substring(0, paramString1.lastIndexOf(File.separator));
          i += 1;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString1);
      copyAssets(paramContext, paramString1, ((StringBuilder)localObject).toString());
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
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: invokevirtual 178	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 215	java/io/File:delete	()Z
    //   22: pop
    //   23: new 278	java/io/FileOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_1
    //   32: new 282	java/io/BufferedInputStream
    //   35: dup
    //   36: new 284	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 287	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_0
    //   48: invokestatic 293	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   51: sipush 4096
    //   54: invokevirtual 297	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   57: astore 4
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 301	java/io/BufferedInputStream:read	([B)I
    //   65: istore_2
    //   66: iload_2
    //   67: iconst_m1
    //   68: if_icmpeq +18 -> 86
    //   71: aload_1
    //   72: aload 4
    //   74: iconst_0
    //   75: iload_2
    //   76: invokevirtual 305	java/io/FileOutputStream:write	([BII)V
    //   79: aload_1
    //   80: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   83: goto -24 -> 59
    //   86: invokestatic 293	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   89: aload 4
    //   91: invokevirtual 312	com/tencent/ttpic/baseutils/io/ByteArrayPool:returnBuf	([B)V
    //   94: iconst_1
    //   95: istore_3
    //   96: aload_1
    //   97: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   100: aload_0
    //   101: invokevirtual 314	java/io/BufferedInputStream:close	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: astore 5
    //   108: aload_0
    //   109: astore 4
    //   111: aload 5
    //   113: astore_0
    //   114: goto +28 -> 142
    //   117: goto +53 -> 170
    //   120: goto +76 -> 196
    //   123: astore_0
    //   124: goto +18 -> 142
    //   127: aload 5
    //   129: astore_0
    //   130: goto +40 -> 170
    //   133: aload 6
    //   135: astore_0
    //   136: goto +60 -> 196
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +10 -> 153
    //   146: aload_1
    //   147: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   150: goto +3 -> 153
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 314	java/io/BufferedInputStream:close	()V
    //   163: aload_0
    //   164: athrow
    //   165: aconst_null
    //   166: astore_1
    //   167: aload 5
    //   169: astore_0
    //   170: aload_1
    //   171: ifnull +10 -> 181
    //   174: aload_1
    //   175: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload_0
    //   182: ifnull +32 -> 214
    //   185: aload_0
    //   186: invokevirtual 314	java/io/BufferedInputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: aconst_null
    //   192: astore_1
    //   193: aload 6
    //   195: astore_0
    //   196: aload_1
    //   197: ifnull +10 -> 207
    //   200: aload_1
    //   201: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   204: goto +3 -> 207
    //   207: aload_0
    //   208: ifnull +6 -> 214
    //   211: goto -26 -> 185
    //   214: iconst_0
    //   215: ireturn
    //   216: astore_0
    //   217: goto -26 -> 191
    //   220: astore_0
    //   221: goto -56 -> 165
    //   224: astore_0
    //   225: goto -92 -> 133
    //   228: astore_0
    //   229: goto -102 -> 127
    //   232: astore 4
    //   234: goto -114 -> 120
    //   237: astore 4
    //   239: goto -122 -> 117
    //   242: astore_1
    //   243: goto -143 -> 100
    //   246: astore_0
    //   247: iload_3
    //   248: ireturn
    //   249: astore_1
    //   250: goto -97 -> 153
    //   253: astore_1
    //   254: goto -91 -> 163
    //   257: astore_1
    //   258: goto -77 -> 181
    //   261: astore_1
    //   262: goto -55 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramFile1	File
    //   0	265	1	paramFile2	File
    //   65	11	2	i	int
    //   1	247	3	bool	boolean
    //   9	150	4	localObject1	Object
    //   232	1	4	localIOException	IOException
    //   237	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   3	1	5	localObject2	Object
    //   106	62	5	localObject3	Object
    //   6	188	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   48	59	106	finally
    //   59	66	106	finally
    //   71	83	106	finally
    //   86	94	106	finally
    //   32	48	123	finally
    //   11	23	139	finally
    //   23	32	139	finally
    //   11	23	216	java/io/IOException
    //   23	32	216	java/io/IOException
    //   11	23	220	java/lang/OutOfMemoryError
    //   23	32	220	java/lang/OutOfMemoryError
    //   32	48	224	java/io/IOException
    //   32	48	228	java/lang/OutOfMemoryError
    //   48	59	232	java/io/IOException
    //   59	66	232	java/io/IOException
    //   71	83	232	java/io/IOException
    //   86	94	232	java/io/IOException
    //   48	59	237	java/lang/OutOfMemoryError
    //   59	66	237	java/lang/OutOfMemoryError
    //   71	83	237	java/lang/OutOfMemoryError
    //   86	94	237	java/lang/OutOfMemoryError
    //   96	100	242	java/io/IOException
    //   100	104	246	java/io/IOException
    //   185	189	246	java/io/IOException
    //   146	150	249	java/io/IOException
    //   158	163	253	java/io/IOException
    //   174	178	257	java/io/IOException
    //   200	204	261	java/io/IOException
  }
  
  public static boolean copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null)
    {
      if (paramOutputStream == null) {
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
        paramOutputStream.flush();
      }
      catch (Exception paramInputStream)
      {
        LogUtils.e(paramInputStream);
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  public static boolean copyFile(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: new 278	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 330	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: sipush 4096
    //   12: newarray byte
    //   14: astore_3
    //   15: aload_0
    //   16: aload_3
    //   17: invokevirtual 318	java/io/InputStream:read	([B)I
    //   20: istore_2
    //   21: iload_2
    //   22: ifle +13 -> 35
    //   25: aload_1
    //   26: aload_3
    //   27: iconst_0
    //   28: iload_2
    //   29: invokevirtual 321	java/io/OutputStream:write	([BII)V
    //   32: goto -17 -> 15
    //   35: aload_0
    //   36: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   39: aload_1
    //   40: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   43: iconst_1
    //   44: ireturn
    //   45: astore_3
    //   46: goto +6 -> 52
    //   49: astore_3
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   56: aload_1
    //   57: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   60: aload_3
    //   61: athrow
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_0
    //   65: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   68: aload_1
    //   69: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -15 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramInputStream	InputStream
    //   0	82	1	paramString	String
    //   20	9	2	i	int
    //   14	13	3	arrayOfByte	byte[]
    //   45	1	3	localObject1	Object
    //   49	12	3	localObject2	Object
    //   78	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	15	45	finally
    //   15	21	45	finally
    //   25	32	45	finally
    //   0	9	49	finally
    //   0	9	74	java/lang/Exception
    //   9	15	78	java/lang/Exception
    //   15	21	78	java/lang/Exception
    //   25	32	78	java/lang/Exception
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    return copyFile(paramString1, paramString2, SIMPLE_FILE_COMPARATOR);
  }
  
  /* Error */
  private static boolean copyFile(String paramString1, String paramString2, FileUtils.FileComparator paramFileComparator)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 4
    //   9: iload 5
    //   11: ifne +339 -> 350
    //   14: aload_1
    //   15: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +6 -> 24
    //   21: goto +329 -> 350
    //   24: new 98	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 7
    //   34: aconst_null
    //   35: astore 6
    //   37: aconst_null
    //   38: astore_1
    //   39: aload 7
    //   41: invokevirtual 178	java/io/File:exists	()Z
    //   44: ifeq +51 -> 95
    //   47: aload_2
    //   48: ifnull +34 -> 82
    //   51: aload_2
    //   52: aload_0
    //   53: aload 7
    //   55: invokeinterface 342 3 0
    //   60: ifeq +22 -> 82
    //   63: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   66: ldc_w 346
    //   69: invokestatic 350	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aconst_null
    //   73: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   76: aconst_null
    //   77: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   80: iconst_1
    //   81: ireturn
    //   82: aload 7
    //   84: invokevirtual 245	java/io/File:isDirectory	()Z
    //   87: ifeq +8 -> 95
    //   90: aload 7
    //   92: invokestatic 354	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   95: aload 7
    //   97: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 357	java/io/File:isFile	()Z
    //   105: ifeq +7 -> 112
    //   108: aload_2
    //   109: invokestatic 354	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   112: aload_2
    //   113: invokevirtual 178	java/io/File:exists	()Z
    //   116: ifne +61 -> 177
    //   119: aload_2
    //   120: invokevirtual 119	java/io/File:mkdirs	()Z
    //   123: ifne +54 -> 177
    //   126: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   129: astore_0
    //   130: new 91	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   137: astore 8
    //   139: aload 8
    //   141: ldc_w 359
    //   144: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 8
    //   150: aload_2
    //   151: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   154: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_0
    //   159: aload 8
    //   161: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 361	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aconst_null
    //   168: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   171: aconst_null
    //   172: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   175: iconst_0
    //   176: ireturn
    //   177: new 284	java/io/FileInputStream
    //   180: dup
    //   181: aload_0
    //   182: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   185: astore_2
    //   186: aload_2
    //   187: invokevirtual 366	java/io/InputStream:available	()I
    //   190: ifgt +8 -> 198
    //   193: aconst_null
    //   194: astore_0
    //   195: goto +49 -> 244
    //   198: new 368	java/io/BufferedOutputStream
    //   201: dup
    //   202: new 278	java/io/FileOutputStream
    //   205: dup
    //   206: aload 7
    //   208: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   211: invokespecial 370	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   214: astore_0
    //   215: sipush 1024
    //   218: newarray byte
    //   220: astore_1
    //   221: aload_2
    //   222: aload_1
    //   223: invokevirtual 318	java/io/InputStream:read	([B)I
    //   226: istore_3
    //   227: iload_3
    //   228: ifle +13 -> 241
    //   231: aload_0
    //   232: aload_1
    //   233: iconst_0
    //   234: iload_3
    //   235: invokevirtual 321	java/io/OutputStream:write	([BII)V
    //   238: goto -17 -> 221
    //   241: iconst_1
    //   242: istore 4
    //   244: aload_2
    //   245: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   248: aload_0
    //   249: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   252: iload 4
    //   254: ireturn
    //   255: astore_1
    //   256: goto +10 -> 266
    //   259: astore_1
    //   260: goto +12 -> 272
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_0
    //   266: goto +74 -> 340
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_0
    //   272: aload_2
    //   273: astore 6
    //   275: aload_1
    //   276: astore_2
    //   277: aload 6
    //   279: astore_1
    //   280: goto +15 -> 295
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_0
    //   286: aload 6
    //   288: astore_2
    //   289: goto +51 -> 340
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_0
    //   295: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   298: ldc_w 372
    //   301: iconst_1
    //   302: anewarray 4	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: aload_2
    //   308: invokevirtual 373	java/lang/Throwable:toString	()Ljava/lang/String;
    //   311: aastore
    //   312: invokestatic 377	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   315: invokestatic 361	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload 7
    //   320: invokestatic 354	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   323: aload_1
    //   324: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   327: aload_0
    //   328: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   331: iconst_0
    //   332: ireturn
    //   333: astore 6
    //   335: aload_1
    //   336: astore_2
    //   337: aload 6
    //   339: astore_1
    //   340: aload_2
    //   341: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   344: aload_0
    //   345: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   348: aload_1
    //   349: athrow
    //   350: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   353: ldc_w 379
    //   356: invokestatic 361	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: iconst_0
    //   360: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	paramString1	String
    //   0	361	1	paramString2	String
    //   0	361	2	paramFileComparator	FileUtils.FileComparator
    //   226	9	3	i	int
    //   7	246	4	bool1	boolean
    //   4	6	5	bool2	boolean
    //   35	252	6	localFileComparator	FileUtils.FileComparator
    //   333	5	6	localObject	Object
    //   32	287	7	localFile	File
    //   137	23	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   215	221	255	finally
    //   221	227	255	finally
    //   231	238	255	finally
    //   215	221	259	java/lang/Throwable
    //   221	227	259	java/lang/Throwable
    //   231	238	259	java/lang/Throwable
    //   186	193	263	finally
    //   198	215	263	finally
    //   186	193	269	java/lang/Throwable
    //   198	215	269	java/lang/Throwable
    //   39	47	283	finally
    //   51	72	283	finally
    //   82	95	283	finally
    //   95	112	283	finally
    //   112	167	283	finally
    //   177	186	283	finally
    //   39	47	292	java/lang/Throwable
    //   51	72	292	java/lang/Throwable
    //   82	95	292	java/lang/Throwable
    //   95	112	292	java/lang/Throwable
    //   112	167	292	java/lang/Throwable
    //   177	186	292	java/lang/Throwable
    //   295	323	333	finally
  }
  
  /* Error */
  public static void copyRawSafe(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 385	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 391	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore 5
    //   10: aconst_null
    //   11: astore_3
    //   12: aconst_null
    //   13: astore 4
    //   15: aload 4
    //   17: astore_0
    //   18: new 98	java/io/File
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 6
    //   28: aload 4
    //   30: astore_0
    //   31: new 278	java/io/FileOutputStream
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 330	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_2
    //   41: astore_0
    //   42: aload 5
    //   44: invokestatic 395	com/tencent/ttpic/baseutils/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   47: astore_3
    //   48: aload_2
    //   49: astore_0
    //   50: aload 6
    //   52: invokevirtual 399	java/io/File:length	()J
    //   55: aload_3
    //   56: arraylength
    //   57: i2l
    //   58: lcmp
    //   59: ifeq +16 -> 75
    //   62: aload_2
    //   63: astore_0
    //   64: aload_3
    //   65: aload_2
    //   66: invokestatic 402	com/tencent/ttpic/baseutils/io/IOUtils:write	([BLjava/io/OutputStream;)V
    //   69: aload_2
    //   70: astore_0
    //   71: aload_2
    //   72: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   75: aload 5
    //   77: invokevirtual 403	java/io/InputStream:close	()V
    //   80: aload_2
    //   81: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   84: aload_2
    //   85: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   88: return
    //   89: goto +15 -> 104
    //   92: astore_3
    //   93: goto +58 -> 151
    //   96: astore_2
    //   97: aload_0
    //   98: astore_3
    //   99: aload_2
    //   100: astore_0
    //   101: goto +85 -> 186
    //   104: aload_2
    //   105: astore_0
    //   106: aload 5
    //   108: invokevirtual 406	java/io/InputStream:reset	()V
    //   111: aload_2
    //   112: astore_0
    //   113: aload 5
    //   115: aload_2
    //   116: invokestatic 408	com/tencent/ttpic/baseutils/io/FileUtils:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   119: pop
    //   120: goto +10 -> 130
    //   123: astore_3
    //   124: aload_2
    //   125: astore_0
    //   126: aload_3
    //   127: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   130: aload 5
    //   132: invokevirtual 403	java/io/InputStream:close	()V
    //   135: aload_2
    //   136: ifnull +44 -> 180
    //   139: aload_2
    //   140: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   143: aload_2
    //   144: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   147: return
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: astore_0
    //   153: aload_3
    //   154: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   157: aload 5
    //   159: invokevirtual 403	java/io/InputStream:close	()V
    //   162: aload_2
    //   163: ifnull +17 -> 180
    //   166: aload_2
    //   167: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   170: aload_2
    //   171: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   174: return
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   180: return
    //   181: astore_2
    //   182: aload_0
    //   183: astore_3
    //   184: aload_2
    //   185: astore_0
    //   186: aload 5
    //   188: invokevirtual 403	java/io/InputStream:close	()V
    //   191: aload_3
    //   192: ifnull +19 -> 211
    //   195: aload_3
    //   196: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   199: aload_3
    //   200: invokevirtual 313	java/io/FileOutputStream:close	()V
    //   203: goto +8 -> 211
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   211: aload_0
    //   212: athrow
    //   213: astore_0
    //   214: aload_3
    //   215: astore_2
    //   216: goto -112 -> 104
    //   219: astore_0
    //   220: goto -131 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramContext	Context
    //   0	223	1	paramInt	int
    //   0	223	2	paramString	String
    //   11	54	3	arrayOfByte	byte[]
    //   92	1	3	localException1	Exception
    //   98	1	3	localContext1	Context
    //   123	4	3	localIOException	IOException
    //   148	6	3	localException2	Exception
    //   183	32	3	localContext2	Context
    //   13	16	4	localObject	Object
    //   8	179	5	localInputStream	InputStream
    //   26	25	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   42	48	92	java/lang/Exception
    //   50	62	92	java/lang/Exception
    //   64	69	92	java/lang/Exception
    //   71	75	92	java/lang/Exception
    //   18	28	96	finally
    //   31	40	96	finally
    //   106	111	96	finally
    //   113	120	96	finally
    //   126	130	96	finally
    //   106	111	123	java/io/IOException
    //   113	120	123	java/io/IOException
    //   18	28	148	java/lang/Exception
    //   31	40	148	java/lang/Exception
    //   75	88	175	java/io/IOException
    //   130	135	175	java/io/IOException
    //   139	147	175	java/io/IOException
    //   157	162	175	java/io/IOException
    //   166	174	175	java/io/IOException
    //   42	48	181	finally
    //   50	62	181	finally
    //   64	69	181	finally
    //   71	75	181	finally
    //   153	157	181	finally
    //   186	191	206	java/io/IOException
    //   195	203	206	java/io/IOException
    //   18	28	213	java/lang/OutOfMemoryError
    //   31	40	213	java/lang/OutOfMemoryError
    //   42	48	219	java/lang/OutOfMemoryError
    //   50	62	219	java/lang/OutOfMemoryError
    //   64	69	219	java/lang/OutOfMemoryError
    //   71	75	219	java/lang/OutOfMemoryError
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
  
  public static void delete(@Nullable File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          delete(arrayOfFile[i]);
          i += 1;
        }
        paramFile.delete();
        return;
      }
      paramFile.delete();
    }
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if (paramFile != null)
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
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
      if (!paramBoolean) {
        paramFile.delete();
      }
    }
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
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
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
  
  public static boolean exists(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.indexOf("assets") >= 0) || (new File(paramString).exists())) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String genSeperateFileDir(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.endsWith(File.separator))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  /* Error */
  private static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 7
    //   15: aload 8
    //   17: aload_1
    //   18: invokevirtual 432	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 437	android/content/res/AssetFileDescriptor:getLength	()J
    //   26: lstore_3
    //   27: aload_0
    //   28: ifnull +14 -> 42
    //   31: aload_0
    //   32: invokevirtual 438	android/content/res/AssetFileDescriptor:close	()V
    //   35: lload_3
    //   36: lreturn
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   42: lload_3
    //   43: lreturn
    //   44: astore 5
    //   46: aload_0
    //   47: astore_1
    //   48: aload 5
    //   50: astore_0
    //   51: goto +7 -> 58
    //   54: astore_0
    //   55: aload 7
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +15 -> 74
    //   62: aload_1
    //   63: invokevirtual 438	android/content/res/AssetFileDescriptor:close	()V
    //   66: goto +8 -> 74
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   74: aload_0
    //   75: athrow
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +15 -> 94
    //   82: aload_0
    //   83: invokevirtual 438	android/content/res/AssetFileDescriptor:close	()V
    //   86: goto +8 -> 94
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   94: aload 6
    //   96: astore_0
    //   97: aload 8
    //   99: aload_1
    //   100: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_1
    //   107: astore 5
    //   109: aload_1
    //   110: invokevirtual 366	java/io/InputStream:available	()I
    //   113: istore_2
    //   114: iload_2
    //   115: i2l
    //   116: lstore_3
    //   117: aload_1
    //   118: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   121: lload_3
    //   122: lreturn
    //   123: astore_1
    //   124: aload_0
    //   125: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   128: aload_1
    //   129: athrow
    //   130: aload 5
    //   132: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   135: ldc2_w 439
    //   138: lreturn
    //   139: astore_0
    //   140: goto -64 -> 76
    //   143: astore 7
    //   145: goto -67 -> 78
    //   148: astore_0
    //   149: goto -19 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramContext	Context
    //   0	152	1	paramString	String
    //   113	2	2	i	int
    //   26	96	3	l	long
    //   10	1	5	localObject1	Object
    //   44	5	5	localObject2	Object
    //   107	24	5	str	String
    //   7	88	6	localObject3	Object
    //   13	43	7	localObject4	Object
    //   143	1	7	localIOException	IOException
    //   4	94	8	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   31	35	37	java/io/IOException
    //   22	27	44	finally
    //   15	22	54	finally
    //   62	66	69	java/io/IOException
    //   82	86	89	java/io/IOException
    //   97	104	123	finally
    //   109	114	123	finally
    //   15	22	139	java/io/IOException
    //   22	27	143	java/io/IOException
    //   97	104	148	java/io/IOException
    //   109	114	148	java/io/IOException
  }
  
  /* Error */
  public static String getAssetsMD5(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +262 -> 263
    //   4: aload_1
    //   5: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +255 -> 263
    //   11: aload_2
    //   12: ifnonnull +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   21: astore_0
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_1
    //   31: invokevirtual 366	java/io/InputStream:available	()I
    //   34: istore_3
    //   35: iload_3
    //   36: ifgt +20 -> 56
    //   39: aload_1
    //   40: ifnull +14 -> 54
    //   43: aload_1
    //   44: invokevirtual 403	java/io/InputStream:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_0
    //   50: aload_0
    //   51: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   54: aconst_null
    //   55: areturn
    //   56: aload_1
    //   57: astore_0
    //   58: ldc_w 444
    //   61: invokestatic 450	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   64: astore 7
    //   66: aload_1
    //   67: astore_0
    //   68: sipush 4096
    //   71: newarray byte
    //   73: astore 6
    //   75: aload_1
    //   76: astore_0
    //   77: aload_1
    //   78: aload 6
    //   80: invokevirtual 318	java/io/InputStream:read	([B)I
    //   83: istore 4
    //   85: iconst_0
    //   86: istore_3
    //   87: iload 4
    //   89: ifle +18 -> 107
    //   92: aload_1
    //   93: astore_0
    //   94: aload 7
    //   96: aload 6
    //   98: iconst_0
    //   99: iload 4
    //   101: invokevirtual 453	java/security/MessageDigest:update	([BII)V
    //   104: goto -29 -> 75
    //   107: aload_1
    //   108: astore_0
    //   109: aload 7
    //   111: aload_2
    //   112: invokevirtual 457	java/lang/String:getBytes	()[B
    //   115: invokevirtual 459	java/security/MessageDigest:update	([B)V
    //   118: aload_1
    //   119: astore_0
    //   120: new 91	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   127: astore 6
    //   129: aload_1
    //   130: astore_0
    //   131: aload 7
    //   133: invokevirtual 462	java/security/MessageDigest:digest	()[B
    //   136: astore 7
    //   138: aload_1
    //   139: astore_0
    //   140: aload 7
    //   142: arraylength
    //   143: istore 4
    //   145: goto +120 -> 265
    //   148: aload_1
    //   149: astore_0
    //   150: aload 6
    //   152: aload_2
    //   153: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: astore_0
    //   159: aload 6
    //   161: iload 5
    //   163: invokestatic 467	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   166: invokevirtual 470	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   169: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: iload_3
    //   174: iconst_1
    //   175: iadd
    //   176: istore_3
    //   177: goto +88 -> 265
    //   180: aload_1
    //   181: astore_0
    //   182: aload 6
    //   184: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore_2
    //   188: aload_1
    //   189: ifnull +14 -> 203
    //   192: aload_1
    //   193: invokevirtual 403	java/io/InputStream:close	()V
    //   196: aload_2
    //   197: areturn
    //   198: astore_0
    //   199: aload_0
    //   200: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   203: aload_2
    //   204: areturn
    //   205: astore_1
    //   206: goto +39 -> 245
    //   209: astore_2
    //   210: goto +12 -> 222
    //   213: astore_1
    //   214: aconst_null
    //   215: astore_0
    //   216: goto +29 -> 245
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: astore_0
    //   224: aload_2
    //   225: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: ifnull +14 -> 243
    //   232: aload_1
    //   233: invokevirtual 403	java/io/InputStream:close	()V
    //   236: aconst_null
    //   237: areturn
    //   238: astore_0
    //   239: aload_0
    //   240: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   243: aconst_null
    //   244: areturn
    //   245: aload_0
    //   246: ifnull +15 -> 261
    //   249: aload_0
    //   250: invokevirtual 403	java/io/InputStream:close	()V
    //   253: goto +8 -> 261
    //   256: astore_0
    //   257: aload_0
    //   258: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   261: aload_1
    //   262: athrow
    //   263: aconst_null
    //   264: areturn
    //   265: iload_3
    //   266: iload 4
    //   268: if_icmpge -88 -> 180
    //   271: aload 7
    //   273: iload_3
    //   274: baload
    //   275: sipush 255
    //   278: iand
    //   279: istore 5
    //   281: iload 5
    //   283: bipush 16
    //   285: if_icmpge +10 -> 295
    //   288: ldc_w 472
    //   291: astore_2
    //   292: goto -144 -> 148
    //   295: ldc 167
    //   297: astore_2
    //   298: goto -150 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramString1	String
    //   0	301	2	paramString2	String
    //   34	240	3	i	int
    //   83	186	4	j	int
    //   161	125	5	k	int
    //   73	110	6	localObject1	Object
    //   64	208	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/lang/Exception
    //   192	196	198	java/lang/Exception
    //   30	35	205	finally
    //   58	66	205	finally
    //   68	75	205	finally
    //   77	85	205	finally
    //   94	104	205	finally
    //   109	118	205	finally
    //   120	129	205	finally
    //   131	138	205	finally
    //   140	145	205	finally
    //   150	157	205	finally
    //   159	173	205	finally
    //   182	188	205	finally
    //   224	228	205	finally
    //   30	35	209	java/lang/Exception
    //   58	66	209	java/lang/Exception
    //   68	75	209	java/lang/Exception
    //   77	85	209	java/lang/Exception
    //   94	104	209	java/lang/Exception
    //   109	118	209	java/lang/Exception
    //   120	129	209	java/lang/Exception
    //   131	138	209	java/lang/Exception
    //   140	145	209	java/lang/Exception
    //   150	157	209	java/lang/Exception
    //   159	173	209	java/lang/Exception
    //   182	188	209	java/lang/Exception
    //   22	28	213	finally
    //   22	28	219	java/lang/Exception
    //   232	236	238	java/lang/Exception
    //   249	253	256	java/lang/Exception
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getFileName] path = ");
    localStringBuilder.append(paramString);
    LogUtils.v(str, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".");
      int j = paramString.lastIndexOf("/");
      if ((j >= 0) && (i > j))
      {
        paramString = paramString.substring(j + 1, i);
        break label82;
      }
    }
    paramString = null;
    label82:
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getFileName] return title = ");
    localStringBuilder.append(paramString);
    LogUtils.v(str, localStringBuilder.toString());
    return paramString;
  }
  
  public static String getFileNameFromUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf("/");
    if (i == -1) {
      return null;
    }
    if (i == paramString.length() - 1) {
      return null;
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFileNameWithSuffixByPath(String paramString)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getFileNameWithSuffixByPath] path = ");
    localStringBuilder.append(paramString);
    LogUtils.v(str, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
    } else {
      paramString = null;
    }
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getFileNameWithSuffixByPath] return title = ");
    localStringBuilder.append(paramString);
    LogUtils.v(str, localStringBuilder.toString());
    return paramString;
  }
  
  public static String getFileSuffixFromUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1) {
      return null;
    }
    if (i == paramString.length() - 1) {
      return null;
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFinalVideoName()
  {
    return String.format("selfiee_%s.mp4", new Object[] { new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) });
  }
  
  public static long getFolderSize(File paramFile)
  {
    long l1 = 0L;
    long l2 = l1;
    try
    {
      paramFile = paramFile.listFiles();
      int i = 0;
      long l3;
      for (;;)
      {
        l2 = l1;
        l3 = l1;
        if (i >= paramFile.length) {
          break;
        }
        l2 = l1;
        if (paramFile[i].isDirectory())
        {
          l2 = l1;
          l3 = getFolderSize(paramFile[i]);
          l2 = l3;
        }
        else
        {
          l2 = l1;
          l3 = paramFile[i].length();
          l2 = l3;
        }
        l1 += l2;
        i += 1;
      }
      return l3;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      l3 = l2;
    }
  }
  
  public static String getMD5(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists()) {}
    for (;;)
    {
      Object localObject;
      int j;
      int i;
      int k;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        paramString1 = new FileInputStream(paramString1);
        byte[] arrayOfByte = new byte[4096];
        j = paramString1.read(arrayOfByte);
        i = 0;
        if (j != -1)
        {
          ((MessageDigest)localObject).update(arrayOfByte, 0, j);
          continue;
        }
        ((MessageDigest)localObject).update(paramString2.getBytes());
        paramString1.close();
        paramString2 = new StringBuilder();
        localObject = ((MessageDigest)localObject).digest();
        j = localObject.length;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      paramString2.append(paramString1);
      paramString2.append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label137;
      paramString1 = paramString2.toString();
      return paramString1;
      return null;
      label137:
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
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = paramString;
    if (paramString.startsWith("assets://")) {
      str = paramString.substring(9);
    }
    return str;
  }
  
  public static String getSHA1(String paramString)
  {
    if (new File(paramString).exists()) {}
    for (;;)
    {
      Object localObject2;
      int j;
      int i;
      int k;
      try
      {
        localObject2 = MessageDigest.getInstance("SHA-1");
        paramString = new FileInputStream(paramString);
        localObject1 = new byte[4096];
        j = paramString.read((byte[])localObject1);
        i = 0;
        if (j != -1)
        {
          ((MessageDigest)localObject2).update((byte[])localObject1, 0, j);
          continue;
        }
        paramString.close();
        localObject1 = new StringBuilder();
        localObject2 = ((MessageDigest)localObject2).digest();
        j = localObject2.length;
      }
      catch (Exception paramString)
      {
        Object localObject1;
        return null;
      }
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label131;
      paramString = ((StringBuilder)localObject1).toString();
      return paramString;
      return null;
      label131:
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
      if (canWriteFile(str, false)) {
        return str;
      }
      i += 1;
    }
    return "";
  }
  
  public static boolean hasFiles(String paramString)
  {
    boolean bool1 = exists(paramString);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramString = new File(paramString);
    if (paramString.isDirectory())
    {
      paramString = paramString.list();
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public static boolean isDirectoryWritable(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (!paramString.isDirectory())) {
      return false;
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    if (paramString.isDirectory()) {
      try
      {
        boolean bool = paramString.canWrite();
        return bool;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
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
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString1.startsWith("assets://"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getRealPath(paramString1));
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString2);
        return loadAssetsString(paramContext, localStringBuilder.toString());
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString1);
      paramContext.append(File.separator);
      paramContext.append(paramString2);
      return loadSdCardFileString(paramContext.toString());
    }
    return "";
  }
  
  public static byte[] loadAssetsByteArray(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      paramString = paramContext.getAssets().open(paramString);
      localObject1 = localObject2;
      paramContext = new byte[paramString.available()];
      localObject1 = paramContext;
      paramString.read(paramContext);
      localObject1 = paramContext;
      paramString.close();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      LogUtils.e(paramContext);
    }
    return localObject1;
  }
  
  /* Error */
  public static String loadAssetsString(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 91	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 5
    //   16: aload_0
    //   17: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   20: aload_1
    //   21: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_0
    //   25: aload_3
    //   26: astore_1
    //   27: aload_0
    //   28: astore_2
    //   29: new 545	java/io/BufferedReader
    //   32: dup
    //   33: new 547	java/io/InputStreamReader
    //   36: dup
    //   37: aload_0
    //   38: ldc_w 549
    //   41: invokespecial 550	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   44: invokespecial 553	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore_3
    //   48: aload_3
    //   49: invokevirtual 556	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +22 -> 76
    //   57: aload 6
    //   59: aload_1
    //   60: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 6
    //   66: ldc_w 558
    //   69: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto -25 -> 48
    //   76: aload_3
    //   77: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   80: goto +48 -> 128
    //   83: astore_1
    //   84: aload_3
    //   85: astore_2
    //   86: goto +59 -> 145
    //   89: astore 4
    //   91: goto +24 -> 115
    //   94: astore 4
    //   96: aload 5
    //   98: astore_3
    //   99: goto +16 -> 115
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: goto +40 -> 145
    //   108: astore 4
    //   110: aconst_null
    //   111: astore_0
    //   112: aload 5
    //   114: astore_3
    //   115: aload_3
    //   116: astore_1
    //   117: aload_0
    //   118: astore_2
    //   119: aload 4
    //   121: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   124: aload_3
    //   125: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   128: aload_0
    //   129: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   132: aload 6
    //   134: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: areturn
    //   138: astore_3
    //   139: aload_2
    //   140: astore_0
    //   141: aload_1
    //   142: astore_2
    //   143: aload_3
    //   144: astore_1
    //   145: aload_2
    //   146: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   149: aload_0
    //   150: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   153: goto +5 -> 158
    //   156: aload_1
    //   157: athrow
    //   158: goto -2 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContext	Context
    //   0	161	1	paramString	String
    //   12	134	2	localObject1	Object
    //   10	115	3	localObject2	Object
    //   138	6	3	localObject3	Object
    //   89	1	4	localIOException1	IOException
    //   94	1	4	localIOException2	IOException
    //   108	12	4	localIOException3	IOException
    //   14	99	5	localObject4	Object
    //   7	126	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	53	83	finally
    //   57	73	83	finally
    //   48	53	89	java/io/IOException
    //   57	73	89	java/io/IOException
    //   29	48	94	java/io/IOException
    //   16	25	102	finally
    //   16	25	108	java/io/IOException
    //   29	48	138	finally
    //   119	124	138	finally
  }
  
  /* Error */
  public static byte[] loadByteArray(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: newarray byte
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: aload 5
    //   13: astore_3
    //   14: aload 6
    //   16: astore_2
    //   17: aload_1
    //   18: ldc 35
    //   20: invokevirtual 162	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   23: ifeq +24 -> 47
    //   26: aload 5
    //   28: astore_3
    //   29: aload 6
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   36: aload_1
    //   37: invokestatic 516	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: astore_0
    //   44: goto +18 -> 62
    //   47: aload 5
    //   49: astore_3
    //   50: aload 6
    //   52: astore_2
    //   53: new 284	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: aload_0
    //   63: astore_3
    //   64: aload_0
    //   65: astore_2
    //   66: aload_0
    //   67: invokestatic 563	com/tencent/ttpic/baseutils/io/FileUtils:loadByteArray	(Ljava/io/InputStream;)[B
    //   70: astore_1
    //   71: goto +19 -> 90
    //   74: astore_0
    //   75: goto +21 -> 96
    //   78: astore_0
    //   79: aload_2
    //   80: astore_3
    //   81: aload_0
    //   82: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   85: aload_2
    //   86: astore_0
    //   87: aload 4
    //   89: astore_1
    //   90: aload_0
    //   91: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   94: aload_1
    //   95: areturn
    //   96: aload_3
    //   97: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramContext	Context
    //   0	102	1	paramString	String
    //   16	70	2	localObject1	Object
    //   13	84	3	localObject2	Object
    //   3	85	4	arrayOfByte	byte[]
    //   9	39	5	localObject3	Object
    //   6	45	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	26	74	finally
    //   32	44	74	finally
    //   53	62	74	finally
    //   66	71	74	finally
    //   81	85	74	finally
    //   17	26	78	java/io/IOException
    //   32	44	78	java/io/IOException
    //   53	62	78	java/io/IOException
    //   66	71	78	java/io/IOException
  }
  
  /* Error */
  public static byte[] loadByteArray(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: sipush 1024
    //   10: newarray byte
    //   12: astore 5
    //   14: aload_3
    //   15: astore_2
    //   16: new 565	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 566	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_3
    //   24: aload_0
    //   25: aload 5
    //   27: invokevirtual 318	java/io/InputStream:read	([B)I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +14 -> 47
    //   36: aload_3
    //   37: aload 5
    //   39: iconst_0
    //   40: iload_1
    //   41: invokevirtual 567	java/io/ByteArrayOutputStream:write	([BII)V
    //   44: goto -20 -> 24
    //   47: aload_3
    //   48: invokevirtual 568	java/io/ByteArrayOutputStream:flush	()V
    //   51: aload_3
    //   52: invokevirtual 570	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   55: astore_0
    //   56: aload_3
    //   57: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   60: aload_0
    //   61: areturn
    //   62: astore_0
    //   63: aload_3
    //   64: astore_2
    //   65: goto +33 -> 98
    //   68: astore_2
    //   69: aload_3
    //   70: astore_0
    //   71: aload_2
    //   72: astore_3
    //   73: goto +11 -> 84
    //   76: astore_0
    //   77: goto +21 -> 98
    //   80: astore_3
    //   81: aload 4
    //   83: astore_0
    //   84: aload_0
    //   85: astore_2
    //   86: aload_3
    //   87: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   90: aload_0
    //   91: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   94: iconst_0
    //   95: newarray byte
    //   97: areturn
    //   98: aload_2
    //   99: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   102: goto +5 -> 107
    //   105: aload_0
    //   106: athrow
    //   107: goto -2 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramInputStream	InputStream
    //   30	11	1	i	int
    //   6	59	2	localObject1	Object
    //   68	4	2	localIOException1	IOException
    //   85	14	2	localInputStream	InputStream
    //   4	69	3	localObject2	Object
    //   80	7	3	localIOException2	IOException
    //   1	81	4	localObject3	Object
    //   12	26	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	31	62	finally
    //   36	44	62	finally
    //   47	56	62	finally
    //   24	31	68	java/io/IOException
    //   36	44	68	java/io/IOException
    //   47	56	68	java/io/IOException
    //   7	14	76	finally
    //   16	24	76	finally
    //   86	90	76	finally
    //   7	14	80	java/io/IOException
    //   16	24	80	java/io/IOException
  }
  
  /* Error */
  public static String loadRawResourceString(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 547	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 385	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: iload_1
    //   9: invokevirtual 391	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   12: invokespecial 573	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: new 545	java/io/BufferedReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 553	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: new 91	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_2
    //   34: invokevirtual 556	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +20 -> 61
    //   44: aload_3
    //   45: aload 4
    //   47: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: bipush 10
    //   54: invokevirtual 576	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: goto -25 -> 33
    //   61: aload_0
    //   62: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   65: aload_2
    //   66: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   69: aload_3
    //   70: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: areturn
    //   74: astore_3
    //   75: aload_0
    //   76: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   79: aload_2
    //   80: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   83: aload_3
    //   84: athrow
    //   85: aload_0
    //   86: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   89: aload_2
    //   90: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_3
    //   96: goto -11 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	Context
    //   0	99	1	paramInt	int
    //   24	66	2	localBufferedReader	java.io.BufferedReader
    //   32	38	3	localStringBuilder	StringBuilder
    //   74	10	3	localObject	Object
    //   95	1	3	localIOException	IOException
    //   37	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   33	39	74	finally
    //   44	58	74	finally
    //   33	39	95	java/io/IOException
    //   44	58	95	java/io/IOException
  }
  
  /* Error */
  public static String loadSdCardFileString(String paramString)
  {
    // Byte code:
    //   0: new 91	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 5
    //   16: new 284	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 362	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: astore_2
    //   27: new 545	java/io/BufferedReader
    //   30: dup
    //   31: new 547	java/io/InputStreamReader
    //   34: dup
    //   35: aload_0
    //   36: ldc_w 549
    //   39: invokespecial 550	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   42: invokespecial 553	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_3
    //   46: aload_3
    //   47: invokevirtual 556	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +22 -> 74
    //   55: aload 6
    //   57: aload_1
    //   58: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 6
    //   64: ldc_w 558
    //   67: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -25 -> 46
    //   74: aload_3
    //   75: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   78: goto +54 -> 132
    //   81: astore_1
    //   82: aload_3
    //   83: astore_2
    //   84: goto +65 -> 149
    //   87: astore 4
    //   89: goto +24 -> 113
    //   92: astore 4
    //   94: aload 5
    //   96: astore_3
    //   97: goto +16 -> 113
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: goto +46 -> 149
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_0
    //   110: aload 5
    //   112: astore_3
    //   113: aload_3
    //   114: astore_1
    //   115: aload_0
    //   116: astore_2
    //   117: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   120: aload 4
    //   122: invokevirtual 579	java/io/IOException:getMessage	()Ljava/lang/String;
    //   125: invokestatic 350	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   132: aload_0
    //   133: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aload 6
    //   138: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: areturn
    //   142: astore_3
    //   143: aload_2
    //   144: astore_0
    //   145: aload_1
    //   146: astore_2
    //   147: aload_3
    //   148: astore_1
    //   149: aload_2
    //   150: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   153: aload_0
    //   154: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   157: goto +5 -> 162
    //   160: aload_1
    //   161: athrow
    //   162: goto -2 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramString	String
    //   10	48	1	str	String
    //   81	1	1	localObject1	Object
    //   100	1	1	localObject2	Object
    //   114	47	1	localObject3	Object
    //   12	138	2	localObject4	Object
    //   45	84	3	localObject5	Object
    //   142	6	3	localObject6	Object
    //   87	1	4	localIOException1	IOException
    //   92	1	4	localIOException2	IOException
    //   106	15	4	localIOException3	IOException
    //   14	97	5	localObject7	Object
    //   7	130	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	51	81	finally
    //   55	71	81	finally
    //   46	51	87	java/io/IOException
    //   55	71	87	java/io/IOException
    //   27	46	92	java/io/IOException
    //   16	25	100	finally
    //   16	25	106	java/io/IOException
    //   27	46	142	finally
    //   117	128	142	finally
  }
  
  public static String md5ForBase64Data(String paramString)
  {
    Object localObject = new char[16];
    Object tmp6_5 = localObject;
    tmp6_5[0] = 114;
    Object tmp12_6 = tmp6_5;
    tmp12_6[1] = 68;
    Object tmp18_12 = tmp12_6;
    tmp18_12[2] = 122;
    Object tmp24_18 = tmp18_12;
    tmp24_18[3] = 111;
    Object tmp30_24 = tmp24_18;
    tmp30_24[4] = 105;
    Object tmp36_30 = tmp30_24;
    tmp36_30[5] = 101;
    Object tmp42_36 = tmp36_30;
    tmp42_36[6] = 53;
    Object tmp49_42 = tmp42_36;
    tmp49_42[7] = 101;
    Object tmp56_49 = tmp49_42;
    tmp56_49[8] = 51;
    Object tmp63_56 = tmp56_49;
    tmp63_56[9] = 111;
    Object tmp70_63 = tmp63_56;
    tmp70_63[10] = 110;
    Object tmp77_70 = tmp70_63;
    tmp77_70[11] = 103;
    Object tmp84_77 = tmp77_70;
    tmp84_77[12] = 102;
    Object tmp91_84 = tmp84_77;
    tmp91_84[13] = 122;
    Object tmp98_91 = tmp91_84;
    tmp98_91[14] = 49;
    Object tmp105_98 = tmp98_91;
    tmp105_98[15] = 108;
    tmp105_98;
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
      int j = paramString.length;
      i = 0;
      while (i < j)
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
    //   0: aload_1
    //   1: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore 5
    //   12: iload 7
    //   14: ifne +354 -> 368
    //   17: aload_2
    //   18: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +6 -> 27
    //   24: goto +344 -> 368
    //   27: aload_0
    //   28: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   31: astore 10
    //   33: new 98	java/io/File
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aconst_null
    //   44: astore_2
    //   45: aconst_null
    //   46: astore 8
    //   48: aload 9
    //   50: invokevirtual 178	java/io/File:exists	()Z
    //   53: ifeq +52 -> 105
    //   56: aload_3
    //   57: ifnull +35 -> 92
    //   60: aload_3
    //   61: aload_0
    //   62: aload_1
    //   63: aload 9
    //   65: invokeinterface 649 4 0
    //   70: ifeq +22 -> 92
    //   73: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   76: ldc_w 346
    //   79: invokestatic 350	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aconst_null
    //   83: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   86: aconst_null
    //   87: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   90: iconst_1
    //   91: ireturn
    //   92: aload 9
    //   94: invokevirtual 245	java/io/File:isDirectory	()Z
    //   97: ifeq +8 -> 105
    //   100: aload 9
    //   102: invokestatic 354	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   105: aload 9
    //   107: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 357	java/io/File:isFile	()Z
    //   115: ifeq +7 -> 122
    //   118: aload_0
    //   119: invokestatic 354	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   122: aload_0
    //   123: invokevirtual 178	java/io/File:exists	()Z
    //   126: ifne +57 -> 183
    //   129: aload_0
    //   130: invokevirtual 119	java/io/File:mkdirs	()Z
    //   133: ifne +50 -> 183
    //   136: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   139: astore_1
    //   140: new 91	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   147: astore_3
    //   148: aload_3
    //   149: ldc_w 359
    //   152: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_3
    //   157: aload_0
    //   158: invokevirtual 102	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: aload_3
    //   167: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 361	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aconst_null
    //   174: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   177: aconst_null
    //   178: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   181: iconst_0
    //   182: ireturn
    //   183: aload 10
    //   185: aload_1
    //   186: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 366	java/io/InputStream:available	()I
    //   194: ifgt +8 -> 202
    //   197: aconst_null
    //   198: astore_1
    //   199: goto +52 -> 251
    //   202: new 368	java/io/BufferedOutputStream
    //   205: dup
    //   206: new 278	java/io/FileOutputStream
    //   209: dup
    //   210: aload 9
    //   212: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   215: invokespecial 370	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   218: astore_1
    //   219: sipush 1024
    //   222: newarray byte
    //   224: astore_2
    //   225: aload_0
    //   226: aload_2
    //   227: invokevirtual 318	java/io/InputStream:read	([B)I
    //   230: istore 4
    //   232: iload 4
    //   234: ifle +14 -> 248
    //   237: aload_1
    //   238: aload_2
    //   239: iconst_0
    //   240: iload 4
    //   242: invokevirtual 321	java/io/OutputStream:write	([BII)V
    //   245: goto -20 -> 225
    //   248: iconst_1
    //   249: istore 5
    //   251: aload_0
    //   252: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   255: aload_1
    //   256: astore_0
    //   257: goto +87 -> 344
    //   260: astore_3
    //   261: aload_0
    //   262: astore_2
    //   263: aload_3
    //   264: astore_0
    //   265: goto +93 -> 358
    //   268: astore_2
    //   269: aload_0
    //   270: astore_3
    //   271: aload_1
    //   272: astore_0
    //   273: aload_3
    //   274: astore_1
    //   275: goto +33 -> 308
    //   278: astore_1
    //   279: aload_0
    //   280: astore_2
    //   281: aload_1
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_1
    //   285: goto +73 -> 358
    //   288: astore_2
    //   289: aload_0
    //   290: astore_1
    //   291: aconst_null
    //   292: astore_0
    //   293: goto +15 -> 308
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_1
    //   299: goto +59 -> 358
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_0
    //   305: aload 8
    //   307: astore_1
    //   308: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   311: ldc_w 651
    //   314: iconst_1
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: aload_2
    //   321: invokevirtual 373	java/lang/Throwable:toString	()Ljava/lang/String;
    //   324: aastore
    //   325: invokestatic 377	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   328: invokestatic 361	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 9
    //   333: invokestatic 354	com/tencent/ttpic/baseutils/io/FileUtils:delete	(Ljava/io/File;)V
    //   336: aload_1
    //   337: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   340: iload 6
    //   342: istore 5
    //   344: aload_0
    //   345: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   348: iload 5
    //   350: ireturn
    //   351: astore_3
    //   352: aload_1
    //   353: astore_2
    //   354: aload_0
    //   355: astore_1
    //   356: aload_3
    //   357: astore_0
    //   358: aload_2
    //   359: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   362: aload_1
    //   363: invokestatic 352	com/tencent/ttpic/baseutils/io/FileUtils:closeSilently	(Ljava/io/Closeable;)V
    //   366: aload_0
    //   367: athrow
    //   368: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   371: ldc_w 379
    //   374: invokestatic 361	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: iconst_0
    //   378: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramContext	Context
    //   0	379	1	paramString1	String
    //   0	379	2	paramString2	String
    //   0	379	3	paramAssetFileComparator	FileUtils.AssetFileComparator
    //   230	11	4	i	int
    //   10	339	5	bool1	boolean
    //   7	334	6	bool2	boolean
    //   4	9	7	bool3	boolean
    //   46	260	8	localObject	Object
    //   41	291	9	localFile	File
    //   31	153	10	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   219	225	260	finally
    //   225	232	260	finally
    //   237	245	260	finally
    //   219	225	268	java/lang/Throwable
    //   225	232	268	java/lang/Throwable
    //   237	245	268	java/lang/Throwable
    //   190	197	278	finally
    //   202	219	278	finally
    //   190	197	288	java/lang/Throwable
    //   202	219	288	java/lang/Throwable
    //   48	56	296	finally
    //   60	82	296	finally
    //   92	105	296	finally
    //   105	122	296	finally
    //   122	173	296	finally
    //   183	190	296	finally
    //   48	56	302	java/lang/Throwable
    //   60	82	302	java/lang/Throwable
    //   92	105	302	java/lang/Throwable
    //   105	122	302	java/lang/Throwable
    //   122	173	302	java/lang/Throwable
    //   183	190	302	java/lang/Throwable
    //   308	336	351	finally
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
    //   1: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 98	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 178	java/io/File:exists	()Z
    //   24: ifne +5 -> 29
    //   27: aconst_null
    //   28: areturn
    //   29: aload 4
    //   31: invokevirtual 399	java/io/File:length	()J
    //   34: l2i
    //   35: istore_2
    //   36: new 565	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: iload_2
    //   41: invokespecial 661	java/io/ByteArrayOutputStream:<init>	(I)V
    //   44: astore_0
    //   45: new 284	java/io/FileInputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 285	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 8
    //   56: iload_2
    //   57: sipush 4096
    //   60: if_icmpge +24 -> 84
    //   63: aload_0
    //   64: astore 4
    //   66: aload 8
    //   68: astore 5
    //   70: invokestatic 293	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   73: sipush 4096
    //   76: invokevirtual 297	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   79: astore 6
    //   81: goto +21 -> 102
    //   84: aload_0
    //   85: astore 4
    //   87: aload 8
    //   89: astore 5
    //   91: invokestatic 293	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   94: sipush 12288
    //   97: invokevirtual 297	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   100: astore 6
    //   102: iconst_0
    //   103: istore_1
    //   104: goto +35 -> 139
    //   107: astore 6
    //   109: aload_0
    //   110: astore 7
    //   112: aload 8
    //   114: astore_0
    //   115: goto +164 -> 279
    //   118: aload_0
    //   119: astore 4
    //   121: aload 8
    //   123: astore 5
    //   125: invokestatic 293	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   128: sipush 4096
    //   131: invokevirtual 297	com/tencent/ttpic/baseutils/io/ByteArrayPool:getBuf	(I)[B
    //   134: astore 6
    //   136: goto -34 -> 102
    //   139: iload_1
    //   140: iload_2
    //   141: if_icmpge +40 -> 181
    //   144: aload_0
    //   145: astore 4
    //   147: aload 8
    //   149: astore 5
    //   151: aload 8
    //   153: aload 6
    //   155: invokevirtual 510	java/io/FileInputStream:read	([B)I
    //   158: istore_3
    //   159: aload_0
    //   160: astore 4
    //   162: aload 8
    //   164: astore 5
    //   166: aload_0
    //   167: aload 6
    //   169: iconst_0
    //   170: iload_3
    //   171: invokevirtual 567	java/io/ByteArrayOutputStream:write	([BII)V
    //   174: iload_1
    //   175: iload_3
    //   176: iadd
    //   177: istore_1
    //   178: goto -39 -> 139
    //   181: aload_0
    //   182: astore 4
    //   184: aload 8
    //   186: astore 5
    //   188: invokestatic 293	com/tencent/ttpic/baseutils/io/ByteArrayPool:getGenericInstance	()Lcom/tencent/ttpic/baseutils/io/ByteArrayPool;
    //   191: aload 6
    //   193: invokevirtual 312	com/tencent/ttpic/baseutils/io/ByteArrayPool:returnBuf	([B)V
    //   196: aload_0
    //   197: astore 4
    //   199: aload 8
    //   201: astore 5
    //   203: aload_0
    //   204: invokevirtual 570	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   207: astore 6
    //   209: aload_0
    //   210: invokevirtual 662	java/io/ByteArrayOutputStream:close	()V
    //   213: aload 8
    //   215: invokevirtual 511	java/io/FileInputStream:close	()V
    //   218: aload 6
    //   220: areturn
    //   221: astore_0
    //   222: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   225: ldc_w 664
    //   228: aload_0
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 667	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   236: aload 6
    //   238: areturn
    //   239: astore 4
    //   241: aconst_null
    //   242: astore 5
    //   244: goto +105 -> 349
    //   247: astore 6
    //   249: aconst_null
    //   250: astore 4
    //   252: aload_0
    //   253: astore 7
    //   255: aload 4
    //   257: astore_0
    //   258: goto +21 -> 279
    //   261: astore 4
    //   263: aconst_null
    //   264: astore_0
    //   265: aload_0
    //   266: astore 5
    //   268: goto +81 -> 349
    //   271: astore 6
    //   273: aconst_null
    //   274: astore 7
    //   276: aload 7
    //   278: astore_0
    //   279: aload 7
    //   281: astore 4
    //   283: aload_0
    //   284: astore 5
    //   286: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   289: ldc_w 669
    //   292: aload 6
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 667	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   301: aload 7
    //   303: ifnull +11 -> 314
    //   306: aload 7
    //   308: invokevirtual 662	java/io/ByteArrayOutputStream:close	()V
    //   311: goto +3 -> 314
    //   314: aload_0
    //   315: ifnull +23 -> 338
    //   318: aload_0
    //   319: invokevirtual 511	java/io/FileInputStream:close	()V
    //   322: aconst_null
    //   323: areturn
    //   324: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   327: ldc_w 664
    //   330: aload_0
    //   331: iconst_0
    //   332: anewarray 4	java/lang/Object
    //   335: invokestatic 667	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   338: aconst_null
    //   339: areturn
    //   340: astore 6
    //   342: aload 4
    //   344: astore_0
    //   345: aload 6
    //   347: astore 4
    //   349: aload_0
    //   350: ifnull +10 -> 360
    //   353: aload_0
    //   354: invokevirtual 662	java/io/ByteArrayOutputStream:close	()V
    //   357: goto +3 -> 360
    //   360: aload 5
    //   362: ifnull +25 -> 387
    //   365: aload 5
    //   367: invokevirtual 511	java/io/FileInputStream:close	()V
    //   370: goto +17 -> 387
    //   373: getstatic 344	com/tencent/ttpic/baseutils/io/FileUtils:TAG	Ljava/lang/String;
    //   376: ldc_w 664
    //   379: aload_0
    //   380: iconst_0
    //   381: anewarray 4	java/lang/Object
    //   384: invokestatic 667	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   387: goto +6 -> 393
    //   390: aload 4
    //   392: athrow
    //   393: goto -3 -> 390
    //   396: astore 4
    //   398: goto -280 -> 118
    //   401: astore_0
    //   402: goto -78 -> 324
    //   405: astore_0
    //   406: goto -33 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramString	String
    //   103	75	1	i	int
    //   35	107	2	j	int
    //   158	19	3	k	int
    //   17	181	4	localObject1	Object
    //   239	1	4	localObject2	Object
    //   250	6	4	localObject3	Object
    //   261	1	4	localObject4	Object
    //   281	110	4	localObject5	Object
    //   396	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   68	298	5	localObject6	Object
    //   79	22	6	arrayOfByte1	byte[]
    //   107	1	6	localException1	Exception
    //   134	103	6	arrayOfByte2	byte[]
    //   247	1	6	localException2	Exception
    //   271	22	6	localException3	Exception
    //   340	6	6	localObject7	Object
    //   110	197	7	str	String
    //   54	160	8	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   70	81	107	java/lang/Exception
    //   91	102	107	java/lang/Exception
    //   125	136	107	java/lang/Exception
    //   151	159	107	java/lang/Exception
    //   166	174	107	java/lang/Exception
    //   188	196	107	java/lang/Exception
    //   203	209	107	java/lang/Exception
    //   209	218	221	java/io/IOException
    //   45	56	239	finally
    //   45	56	247	java/lang/Exception
    //   29	45	261	finally
    //   29	45	271	java/lang/Exception
    //   70	81	340	finally
    //   91	102	340	finally
    //   125	136	340	finally
    //   151	159	340	finally
    //   166	174	340	finally
    //   188	196	340	finally
    //   203	209	340	finally
    //   286	301	340	finally
    //   70	81	396	java/lang/OutOfMemoryError
    //   91	102	396	java/lang/OutOfMemoryError
    //   306	311	401	java/io/IOException
    //   318	322	401	java/io/IOException
    //   353	357	405	java/io/IOException
    //   365	370	405	java/io/IOException
  }
  
  /* Error */
  public static String readTextFileFromRaw(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 385	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 391	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore_0
    //   9: new 547	java/io/InputStreamReader
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 573	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 545	java/io/BufferedReader
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 553	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore_3
    //   27: new 91	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   34: astore 4
    //   36: aload_3
    //   37: invokevirtual 556	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 5
    //   42: aload 5
    //   44: ifnull +22 -> 66
    //   47: aload 4
    //   49: aload 5
    //   51: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: bipush 10
    //   59: invokevirtual 576	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: goto -27 -> 36
    //   66: aload_0
    //   67: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   70: aload_2
    //   71: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   74: aload_3
    //   75: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   78: aload 4
    //   80: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: areturn
    //   84: astore 4
    //   86: aload_0
    //   87: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   90: aload_2
    //   91: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   94: aload_3
    //   95: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   98: aload 4
    //   100: athrow
    //   101: aload_0
    //   102: invokestatic 231	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   105: aload_2
    //   106: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   109: aload_3
    //   110: invokestatic 560	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   113: aconst_null
    //   114: areturn
    //   115: astore 4
    //   117: goto -16 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramInt	int
    //   17	89	2	localInputStreamReader	java.io.InputStreamReader
    //   26	84	3	localBufferedReader	java.io.BufferedReader
    //   34	45	4	localStringBuilder	StringBuilder
    //   84	15	4	localObject	Object
    //   115	1	4	localIOException	IOException
    //   40	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   36	42	84	finally
    //   47	63	84	finally
    //   36	42	115	java/io/IOException
    //   47	63	115	java/io/IOException
  }
  
  /* Error */
  public static String readTxtFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 6
    //   19: iload_2
    //   20: ifeq +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: new 91	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   32: astore 8
    //   34: aload_1
    //   35: ldc 35
    //   37: invokevirtual 162	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   40: ifeq +208 -> 248
    //   43: aload_0
    //   44: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   47: aload_1
    //   48: bipush 9
    //   50: invokevirtual 165	java/lang/String:substring	(I)Ljava/lang/String;
    //   53: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   56: astore_0
    //   57: aload 5
    //   59: astore_1
    //   60: aload_0
    //   61: astore_3
    //   62: new 545	java/io/BufferedReader
    //   65: dup
    //   66: new 547	java/io/InputStreamReader
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 573	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   74: invokespecial 553	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   77: astore 4
    //   79: aload 4
    //   81: invokevirtual 556	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +13 -> 99
    //   89: aload 8
    //   91: aload_1
    //   92: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: goto -17 -> 79
    //   99: aload 4
    //   101: invokevirtual 672	java/io/BufferedReader:close	()V
    //   104: goto +8 -> 112
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   112: aload_0
    //   113: ifnull +222 -> 335
    //   116: aload_0
    //   117: invokevirtual 403	java/io/InputStream:close	()V
    //   120: goto +215 -> 335
    //   123: astore_1
    //   124: aload 4
    //   126: astore_3
    //   127: goto +87 -> 214
    //   130: astore 5
    //   132: goto +26 -> 158
    //   135: astore 5
    //   137: aload 6
    //   139: astore 4
    //   141: goto +17 -> 158
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: goto +67 -> 214
    //   150: astore 5
    //   152: aconst_null
    //   153: astore_0
    //   154: aload 6
    //   156: astore 4
    //   158: aload 4
    //   160: astore_1
    //   161: aload_0
    //   162: astore_3
    //   163: aload 5
    //   165: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   168: aload 4
    //   170: ifnull +16 -> 186
    //   173: aload 4
    //   175: invokevirtual 672	java/io/BufferedReader:close	()V
    //   178: goto +8 -> 186
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   186: aload_0
    //   187: ifnull +148 -> 335
    //   190: aload_0
    //   191: invokevirtual 403	java/io/InputStream:close	()V
    //   194: goto +141 -> 335
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   202: goto +133 -> 335
    //   205: astore 4
    //   207: aload_3
    //   208: astore_0
    //   209: aload_1
    //   210: astore_3
    //   211: aload 4
    //   213: astore_1
    //   214: aload_3
    //   215: ifnull +15 -> 230
    //   218: aload_3
    //   219: invokevirtual 672	java/io/BufferedReader:close	()V
    //   222: goto +8 -> 230
    //   225: astore_3
    //   226: aload_3
    //   227: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   230: aload_0
    //   231: ifnull +15 -> 246
    //   234: aload_0
    //   235: invokevirtual 403	java/io/InputStream:close	()V
    //   238: goto +8 -> 246
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   246: aload_1
    //   247: athrow
    //   248: aload 7
    //   250: astore_0
    //   251: new 545	java/io/BufferedReader
    //   254: dup
    //   255: new 674	java/io/FileReader
    //   258: dup
    //   259: aload_1
    //   260: invokespecial 675	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   263: invokespecial 553	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 556	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   271: astore_0
    //   272: aload_0
    //   273: ifnull +13 -> 286
    //   276: aload 8
    //   278: aload_0
    //   279: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: goto -16 -> 267
    //   286: aload_1
    //   287: invokevirtual 672	java/io/BufferedReader:close	()V
    //   290: goto +45 -> 335
    //   293: astore_3
    //   294: aload_1
    //   295: astore_0
    //   296: aload_3
    //   297: astore_1
    //   298: goto +43 -> 341
    //   301: astore_3
    //   302: goto +11 -> 313
    //   305: astore_1
    //   306: goto +35 -> 341
    //   309: astore_3
    //   310: aload 4
    //   312: astore_1
    //   313: aload_1
    //   314: astore_0
    //   315: aload_3
    //   316: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   319: aload_1
    //   320: ifnull +15 -> 335
    //   323: aload_1
    //   324: invokevirtual 672	java/io/BufferedReader:close	()V
    //   327: goto +8 -> 335
    //   330: astore_0
    //   331: aload_0
    //   332: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   335: aload 8
    //   337: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: areturn
    //   341: aload_0
    //   342: ifnull +15 -> 357
    //   345: aload_0
    //   346: invokevirtual 672	java/io/BufferedReader:close	()V
    //   349: goto +8 -> 357
    //   352: astore_0
    //   353: aload_0
    //   354: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   357: goto +5 -> 362
    //   360: aload_1
    //   361: athrow
    //   362: goto -2 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramContext	Context
    //   0	365	1	paramString	String
    //   4	16	2	bool	boolean
    //   9	210	3	localObject1	Object
    //   225	2	3	localIOException1	IOException
    //   293	4	3	localObject2	Object
    //   301	1	3	localIOException2	IOException
    //   309	7	3	localIOException3	IOException
    //   14	160	4	localObject3	Object
    //   205	106	4	localObject4	Object
    //   6	52	5	localObject5	Object
    //   130	1	5	localIOException4	IOException
    //   135	1	5	localIOException5	IOException
    //   150	14	5	localIOException6	IOException
    //   17	138	6	localObject6	Object
    //   11	238	7	localObject7	Object
    //   32	304	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   99	104	107	java/io/IOException
    //   79	85	123	finally
    //   89	96	123	finally
    //   79	85	130	java/io/IOException
    //   89	96	130	java/io/IOException
    //   62	79	135	java/io/IOException
    //   43	57	144	finally
    //   43	57	150	java/io/IOException
    //   173	178	181	java/io/IOException
    //   116	120	197	java/io/IOException
    //   190	194	197	java/io/IOException
    //   62	79	205	finally
    //   163	168	205	finally
    //   218	222	225	java/io/IOException
    //   234	238	241	java/io/IOException
    //   267	272	293	finally
    //   276	283	293	finally
    //   267	272	301	java/io/IOException
    //   276	283	301	java/io/IOException
    //   251	267	305	finally
    //   315	319	305	finally
    //   251	267	309	java/io/IOException
    //   286	290	330	java/io/IOException
    //   323	327	330	java/io/IOException
    //   345	349	352	java/io/IOException
  }
  
  /* Error */
  public static com.tencent.ttpic.baseutils.bitmap.BitmapUtils.SAVE_STATUS save(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 98	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   13: invokevirtual 178	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_2
    //   20: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 119	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aconst_null
    //   28: astore_3
    //   29: aconst_null
    //   30: astore_2
    //   31: new 278	java/io/FileOutputStream
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 330	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 679	java/io/OutputStream:write	([B)V
    //   45: getstatic 685	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   48: astore_1
    //   49: aload_0
    //   50: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aload_0
    //   57: astore_2
    //   58: aload_1
    //   59: astore_0
    //   60: goto +32 -> 92
    //   63: astore_1
    //   64: goto +10 -> 74
    //   67: astore_0
    //   68: goto +24 -> 92
    //   71: astore_1
    //   72: aload_3
    //   73: astore_0
    //   74: aload_0
    //   75: astore_2
    //   76: aload_1
    //   77: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   80: aload_0
    //   81: astore_2
    //   82: getstatic 688	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   85: astore_1
    //   86: aload_0
    //   87: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   90: aload_1
    //   91: areturn
    //   92: aload_2
    //   93: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   0	98	1	paramArrayOfByte	byte[]
    //   8	85	2	localObject1	Object
    //   28	45	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	49	55	finally
    //   40	49	63	java/lang/Exception
    //   31	40	67	finally
    //   76	80	67	finally
    //   82	86	67	finally
    //   31	40	71	java/lang/Exception
  }
  
  /* Error */
  public static void save(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 278	java/io/FileOutputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_0
    //   14: new 690	java/io/BufferedWriter
    //   17: dup
    //   18: new 692	java/io/OutputStreamWriter
    //   21: dup
    //   22: aload_0
    //   23: ldc_w 549
    //   26: invokespecial 695	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   29: invokespecial 698	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   32: astore_2
    //   33: aload_2
    //   34: aload_1
    //   35: invokevirtual 700	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   42: aload_2
    //   43: astore_0
    //   44: goto +48 -> 92
    //   47: astore_1
    //   48: goto +54 -> 102
    //   51: astore_1
    //   52: goto +13 -> 65
    //   55: astore_1
    //   56: aload 4
    //   58: astore_2
    //   59: goto +43 -> 102
    //   62: astore_1
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_0
    //   66: astore_3
    //   67: aload_2
    //   68: astore_0
    //   69: goto +15 -> 84
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_0
    //   75: aload 4
    //   77: astore_2
    //   78: goto +24 -> 102
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_1
    //   85: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   88: aload_3
    //   89: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   92: aload_0
    //   93: invokestatic 702	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   96: return
    //   97: astore_1
    //   98: aload_0
    //   99: astore_2
    //   100: aload_3
    //   101: astore_0
    //   102: aload_0
    //   103: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   106: aload_2
    //   107: invokestatic 702	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramFile	File
    //   0	112	1	paramString	String
    //   32	75	2	localObject1	Object
    //   4	97	3	localFile	File
    //   1	75	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	38	47	finally
    //   33	38	51	java/lang/Exception
    //   14	33	55	finally
    //   14	33	62	java/lang/Exception
    //   5	14	72	finally
    //   5	14	81	java/lang/Exception
    //   84	88	97	finally
  }
  
  /* Error */
  public static void saveFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 690	java/io/BufferedWriter
    //   7: dup
    //   8: new 705	java/io/FileWriter
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 706	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 698	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   19: astore_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 700	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokestatic 702	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: astore_2
    //   33: aload_1
    //   34: astore_0
    //   35: goto +25 -> 60
    //   38: astore_1
    //   39: goto +10 -> 49
    //   42: astore_0
    //   43: goto +17 -> 60
    //   46: astore_1
    //   47: aload_3
    //   48: astore_0
    //   49: aload_0
    //   50: astore_2
    //   51: aload_1
    //   52: invokestatic 328	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   55: aload_0
    //   56: invokestatic 702	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   59: return
    //   60: aload_2
    //   61: invokestatic 702	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramString1	String
    //   0	66	1	paramString2	String
    //   3	58	2	str	String
    //   1	47	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	30	finally
    //   20	25	38	java/io/IOException
    //   4	20	42	finally
    //   51	55	42	finally
    //   4	20	46	java/io/IOException
  }
  
  public static String toBase64(String paramString)
  {
    Object localObject;
    try
    {
      paramString = new FileInputStream(new File(paramString));
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new Base64OutputStream(localByteArrayOutputStream, 2);
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
    }
    catch (Exception paramString)
    {
      ByteArrayOutputStream localByteArrayOutputStream;
      label96:
      break label96;
    }
    try
    {
      localByteArrayOutputStream.close();
      paramString.close();
      return localObject;
    }
    catch (Exception paramString) {}
    return null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.io.FileUtils
 * JD-Core Version:    0.7.0.1
 */