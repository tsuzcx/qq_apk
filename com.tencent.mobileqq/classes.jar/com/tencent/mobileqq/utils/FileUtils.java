package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileUtils
{
  public static final String FILE_TYPE_APNG = "apng";
  public static final String FILE_TYPE_AVI = "avi";
  public static final String FILE_TYPE_BMP = "bmp";
  public static final String FILE_TYPE_FLV = "flv";
  public static final String FILE_TYPE_GIF = "gif";
  public static final String FILE_TYPE_JPEG = "jpg";
  public static final String FILE_TYPE_MOV = "mov";
  public static final String FILE_TYPE_MP4 = "mp4";
  public static final String FILE_TYPE_PNG = "png";
  public static final String FILE_TYPE_SHARPP = "sharpp";
  public static final String FILE_TYPE_WEBP = "webp";
  public static final String FILE_TYPE_WMV = "wmv";
  public static final long ONE_GB = 1073741824L;
  public static final long ONE_KB = 1024L;
  public static final long ONE_MB = 1048576L;
  public static final int QUICK_MOVE_ARGS_ERROR = 1;
  public static final int QUICK_MOVE_MAKE_TRAGET_PARENT_FILE_FAIL = 2;
  public static final int QUICK_MOVE_RENAME_FAIL = 3;
  public static final int QUICK_MOVE_SUCCESS = 0;
  public static final String TAG = "FileUtils";
  public static String unKnownFileTypeMark = "unknown_";
  
  public static String byteCountToDisplaySize(int paramInt, long paramLong)
  {
    if (paramLong == 0L)
    {
      if (paramInt == 0) {
        return "0.0B";
      }
      if (paramInt == 1) {
        return "0.0K";
      }
    }
    Object localObject1 = null;
    Object localObject2 = new DecimalFormat("0.0");
    float f;
    if (paramLong / 1073741824L > 0L)
    {
      f = (float)paramLong / 1.073742E+009F;
      localObject1 = ((DecimalFormat)localObject2).format(f);
      if (((String)localObject1).endsWith(".0"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((int)f);
        ((StringBuilder)localObject1).append("G");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("G");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    for (;;)
    {
      return localObject1;
      if (paramLong / 1048576L <= 0L) {
        break;
      }
      f = (float)paramLong / 1048576.0F;
      localObject1 = ((DecimalFormat)localObject2).format(f);
      if (((String)localObject1).endsWith(".0"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((int)f);
        ((StringBuilder)localObject1).append("M");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("M");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    long l = paramLong / 1024L;
    if (l > 0L)
    {
      paramInt = (int)l;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("K");
      return ((StringBuilder)localObject1).toString();
    }
    if (paramInt == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((DecimalFormat)localObject2).format(paramLong));
      ((StringBuilder)localObject1).append("B");
      return ((StringBuilder)localObject1).toString();
    }
    if (paramInt == 1)
    {
      paramInt = (int)l;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("K");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static String calcMd5(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      return null;
    }
    long l = localFile.length();
    if (l == 0L) {
      return null;
    }
    return calcMd5(paramString, l);
  }
  
  /* Error */
  public static String calcMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 144	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: lload_1
    //   11: invokestatic 151	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   14: invokestatic 157	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: aload_3
    //   21: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +16 -> 40
    //   27: aconst_null
    //   28: areturn
    //   29: astore_0
    //   30: goto +12 -> 42
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 166	java/io/FileNotFoundException:printStackTrace	()V
    //   38: aconst_null
    //   39: astore_0
    //   40: aload_0
    //   41: areturn
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	paramString	String
    //   0	44	1	paramLong	long
    //   17	4	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	9	29	finally
    //   34	38	29	finally
    //   0	9	33	java/io/FileNotFoundException
  }
  
  public static boolean checkDiskCacheExist()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
    localStringBuilder.append("/");
    localStringBuilder.append("diskcache");
    return fileExists(localStringBuilder.toString());
  }
  
  public static boolean checkMobileQQFolderExist()
  {
    return fileExists(AppConstants.SDCARD_PATH);
  }
  
  public static boolean checkTencentFolderExist()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/");
    return fileExists(localStringBuilder.toString());
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static boolean copyAssetDirsToSdcard(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      try
      {
        AssetManager localAssetManager = paramContext.getAssets();
        String[] arrayOfString = localAssetManager.list(paramString1);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject1 = arrayOfString[i];
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString2);
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject3 = ((StringBuilder)localObject3).toString();
          if (localAssetManager.list((String)localObject2).length == 0)
          {
            copyAssetToFile(paramContext, (String)localObject2, (String)localObject3);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString2);
            localStringBuilder.append(File.separator);
            localStringBuilder.append((String)localObject1);
            localObject1 = new File(localStringBuilder.toString());
            if (!((File)localObject1).exists()) {
              ((File)localObject1).mkdirs();
            }
            copyAssetDirsToSdcard(paramContext, (String)localObject2, (String)localObject3);
          }
          i += 1;
        }
        return true;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean copyAssetToFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: new 229	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 230	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload 5
    //   20: astore 4
    //   22: aload_2
    //   23: astore 5
    //   25: new 232	java/io/BufferedInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokevirtual 209	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   33: aload_1
    //   34: invokevirtual 236	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_0
    //   41: sipush 8192
    //   44: newarray byte
    //   46: astore_1
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 243	java/io/BufferedInputStream:read	([B)I
    //   52: istore_3
    //   53: iload_3
    //   54: iconst_m1
    //   55: if_icmpeq +13 -> 68
    //   58: aload_2
    //   59: aload_1
    //   60: iconst_0
    //   61: iload_3
    //   62: invokevirtual 249	java/io/OutputStream:write	([BII)V
    //   65: goto -18 -> 47
    //   68: aload_0
    //   69: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 251	java/io/OutputStream:close	()V
    //   76: iconst_1
    //   77: ireturn
    //   78: astore_1
    //   79: aload_0
    //   80: astore 4
    //   82: aload_1
    //   83: astore_0
    //   84: goto +79 -> 163
    //   87: astore_1
    //   88: goto +22 -> 110
    //   91: astore_1
    //   92: aload 6
    //   94: astore_0
    //   95: goto +15 -> 110
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +62 -> 163
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: aload 6
    //   109: astore_0
    //   110: aload_0
    //   111: astore 4
    //   113: aload_2
    //   114: astore 5
    //   116: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +19 -> 138
    //   122: aload_0
    //   123: astore 4
    //   125: aload_2
    //   126: astore 5
    //   128: ldc 63
    //   130: iconst_2
    //   131: ldc_w 258
    //   134: aload_1
    //   135: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload_0
    //   139: ifnull +10 -> 149
    //   142: aload_0
    //   143: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   146: goto +3 -> 149
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 251	java/io/OutputStream:close	()V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: aload 5
    //   162: astore_2
    //   163: aload 4
    //   165: ifnull +11 -> 176
    //   168: aload 4
    //   170: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   173: goto +3 -> 176
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 251	java/io/OutputStream:close	()V
    //   184: goto +5 -> 189
    //   187: aload_0
    //   188: athrow
    //   189: goto -2 -> 187
    //   192: astore_0
    //   193: goto -121 -> 72
    //   196: astore_0
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_0
    //   200: goto -51 -> 149
    //   203: astore_0
    //   204: iconst_0
    //   205: ireturn
    //   206: astore_1
    //   207: goto -31 -> 176
    //   210: astore_1
    //   211: goto -27 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramContext	Context
    //   0	214	1	paramString1	String
    //   0	214	2	paramString2	String
    //   52	10	3	i	int
    //   4	165	4	localObject1	Object
    //   1	160	5	str	String
    //   7	101	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	47	78	finally
    //   47	53	78	finally
    //   58	65	78	finally
    //   41	47	87	java/io/IOException
    //   47	53	87	java/io/IOException
    //   58	65	87	java/io/IOException
    //   25	41	91	java/io/IOException
    //   9	18	98	finally
    //   9	18	104	java/io/IOException
    //   25	41	159	finally
    //   116	122	159	finally
    //   128	138	159	finally
    //   68	72	192	java/io/IOException
    //   72	76	196	java/io/IOException
    //   142	146	199	java/io/IOException
    //   153	157	203	java/io/IOException
    //   168	173	206	java/io/IOException
    //   180	184	210	java/io/IOException
  }
  
  public static int copyDirectory(String paramString1, String paramString2, boolean paramBoolean)
  {
    return copyDirectory(paramString1, paramString2, paramBoolean, false, false);
  }
  
  public static int copyDirectory(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return -1;
    }
    paramString1 = paramString1.listFiles();
    if (paramString1 == null) {
      return -1;
    }
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    int i = 0;
    while (i < paramString1.length)
    {
      Object localObject2;
      if (paramString1[i].isDirectory())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1[i].getPath());
        ((StringBuilder)localObject1).append("/");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1[i].getName());
        ((StringBuilder)localObject2).append("/");
        copyDirectory((String)localObject1, ((StringBuilder)localObject2).toString(), paramBoolean1, paramBoolean2, paramBoolean3);
      }
      else
      {
        localObject1 = new File(paramString1[i].getPath());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1[i].getName());
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (((File)localObject1).exists())
        {
          if ((paramBoolean2) && (((File)localObject2).exists()) && (!((File)localObject2).delete()) && (paramBoolean3)) {
            QLog.d("FileUtils", 1, new Object[] { "copyDirectory fail, delete file name:", ((File)localObject1).getPath() });
          }
          if (!((File)localObject2).exists()) {
            try
            {
              ((File)localObject2).createNewFile();
              if ((!copyFile((File)localObject1, (File)localObject2, paramBoolean3)) && (paramBoolean3)) {
                QLog.d("FileUtils", 1, new Object[] { "copyDirectory fail, file name:", ((File)localObject1).getPath() });
              }
            }
            catch (IOException localIOException)
            {
              if (paramBoolean3) {
                QLog.e("FileUtils", 1, "copyDirectory error, ", localIOException);
              }
            }
          }
          if (paramBoolean1) {
            ((File)localObject1).delete();
          }
        }
      }
      i += 1;
    }
    return 0;
  }
  
  public static int copyDocumentItemsToAnotherDocument(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.isDirectory()) {
      return -1;
    }
    Object localObject = new File(paramString2);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      ((File)localObject).mkdirs();
    }
    paramString1 = paramString1.listFiles();
    if (paramString1.length == 0) {
      return -2;
    }
    int i = 0;
    while (i < paramString1.length)
    {
      StringBuilder localStringBuilder;
      if (paramString1[i].isDirectory())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1[i].getPath());
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(paramString1[i]);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("/");
        localStringBuilder.append(paramString1[i].getName());
        copyDocumentItemsToAnotherDocument((String)localObject, localStringBuilder.toString());
      }
      else
      {
        localObject = new File(paramString1[i].getPath());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("/");
        localStringBuilder.append(paramString1[i].getName());
        copyFile((File)localObject, new File(localStringBuilder.toString()));
      }
      i += 1;
    }
    return 1;
  }
  
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    return copyFile(paramFile1, paramFile2, false);
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: invokevirtual 133	java/io/File:exists	()Z
    //   13: ifeq +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 283	java/io/File:delete	()Z
    //   20: pop
    //   21: aload_1
    //   22: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   25: ifnull +21 -> 46
    //   28: aload_1
    //   29: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   32: invokevirtual 133	java/io/File:exists	()Z
    //   35: ifne +11 -> 46
    //   38: aload_1
    //   39: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   42: invokevirtual 224	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: new 229	java/io/FileOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: new 232	java/io/BufferedInputStream
    //   58: dup
    //   59: new 144	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   74: sipush 4096
    //   77: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   80: astore 4
    //   82: aload_0
    //   83: aload 4
    //   85: invokevirtual 243	java/io/BufferedInputStream:read	([B)I
    //   88: istore_3
    //   89: iload_3
    //   90: iconst_m1
    //   91: if_icmpeq +18 -> 109
    //   94: aload_1
    //   95: aload 4
    //   97: iconst_0
    //   98: iload_3
    //   99: invokevirtual 331	java/io/FileOutputStream:write	([BII)V
    //   102: aload_1
    //   103: invokevirtual 334	java/io/FileOutputStream:flush	()V
    //   106: goto -24 -> 82
    //   109: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   112: aload 4
    //   114: invokevirtual 338	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   117: aload_1
    //   118: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   121: goto +18 -> 139
    //   124: astore_1
    //   125: iload_2
    //   126: ifeq +13 -> 139
    //   129: ldc 63
    //   131: iconst_1
    //   132: ldc_w 341
    //   135: aload_1
    //   136: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload_0
    //   140: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   143: goto +18 -> 161
    //   146: astore_0
    //   147: iload_2
    //   148: ifeq +13 -> 161
    //   151: ldc 63
    //   153: iconst_1
    //   154: ldc_w 341
    //   157: aload_0
    //   158: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: iconst_1
    //   162: ireturn
    //   163: astore 5
    //   165: goto +17 -> 182
    //   168: astore 4
    //   170: goto +28 -> 198
    //   173: astore 4
    //   175: goto +40 -> 215
    //   178: astore 5
    //   180: aconst_null
    //   181: astore_0
    //   182: aload_1
    //   183: astore 4
    //   185: aload 5
    //   187: astore_1
    //   188: aload_0
    //   189: astore 5
    //   191: goto +171 -> 362
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_0
    //   198: aload_1
    //   199: astore 5
    //   201: aload 4
    //   203: astore 6
    //   205: aload_0
    //   206: astore 4
    //   208: goto +32 -> 240
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_0
    //   215: aload_1
    //   216: astore 5
    //   218: aload 4
    //   220: astore 6
    //   222: aload_0
    //   223: astore 4
    //   225: goto +102 -> 327
    //   228: astore_1
    //   229: aconst_null
    //   230: astore 5
    //   232: goto +130 -> 362
    //   235: astore 6
    //   237: aconst_null
    //   238: astore 4
    //   240: iload_2
    //   241: ifeq +20 -> 261
    //   244: aload 5
    //   246: astore_0
    //   247: aload 4
    //   249: astore_1
    //   250: ldc 63
    //   252: iconst_1
    //   253: ldc_w 341
    //   256: aload 6
    //   258: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: aload 5
    //   263: ifnull +26 -> 289
    //   266: aload 5
    //   268: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   271: goto +18 -> 289
    //   274: astore_0
    //   275: iload_2
    //   276: ifeq +13 -> 289
    //   279: ldc 63
    //   281: iconst_1
    //   282: ldc_w 341
    //   285: aload_0
    //   286: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: aload 4
    //   291: ifnull +177 -> 468
    //   294: aload 4
    //   296: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   299: iconst_0
    //   300: ireturn
    //   301: astore_0
    //   302: iload_2
    //   303: ifeq +165 -> 468
    //   306: ldc 63
    //   308: iconst_1
    //   309: ldc_w 341
    //   312: aload_0
    //   313: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: iconst_0
    //   317: ireturn
    //   318: astore 6
    //   320: aconst_null
    //   321: astore 4
    //   323: aload 7
    //   325: astore 5
    //   327: iload_2
    //   328: ifeq +92 -> 420
    //   331: aload 5
    //   333: astore_0
    //   334: aload 4
    //   336: astore_1
    //   337: ldc 63
    //   339: iconst_1
    //   340: ldc_w 341
    //   343: aload 6
    //   345: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto +72 -> 420
    //   351: astore 4
    //   353: aload_1
    //   354: astore 5
    //   356: aload 4
    //   358: astore_1
    //   359: aload_0
    //   360: astore 4
    //   362: aload 4
    //   364: ifnull +26 -> 390
    //   367: aload 4
    //   369: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   372: goto +18 -> 390
    //   375: astore_0
    //   376: iload_2
    //   377: ifeq +13 -> 390
    //   380: ldc 63
    //   382: iconst_1
    //   383: ldc_w 341
    //   386: aload_0
    //   387: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   390: aload 5
    //   392: ifnull +26 -> 418
    //   395: aload 5
    //   397: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   400: goto +18 -> 418
    //   403: astore_0
    //   404: iload_2
    //   405: ifeq +13 -> 418
    //   408: ldc 63
    //   410: iconst_1
    //   411: ldc_w 341
    //   414: aload_0
    //   415: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: athrow
    //   420: aload 5
    //   422: ifnull +26 -> 448
    //   425: aload 5
    //   427: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   430: goto +18 -> 448
    //   433: astore_0
    //   434: iload_2
    //   435: ifeq +13 -> 448
    //   438: ldc 63
    //   440: iconst_1
    //   441: ldc_w 341
    //   444: aload_0
    //   445: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   448: aload 4
    //   450: ifnull +18 -> 468
    //   453: aload 4
    //   455: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   458: iconst_0
    //   459: ireturn
    //   460: astore_0
    //   461: iload_2
    //   462: ifeq +6 -> 468
    //   465: goto -159 -> 306
    //   468: iconst_0
    //   469: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramFile1	File
    //   0	470	1	paramFile2	File
    //   0	470	2	paramBoolean	boolean
    //   88	11	3	i	int
    //   4	109	4	arrayOfByte	byte[]
    //   168	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   173	1	4	localIOException1	IOException
    //   183	1	4	localFile1	File
    //   194	8	4	localOutOfMemoryError2	OutOfMemoryError
    //   206	1	4	localFile2	File
    //   211	8	4	localIOException2	IOException
    //   223	112	4	localFile3	File
    //   351	6	4	localObject1	Object
    //   360	94	4	localFile4	File
    //   7	1	5	localObject2	Object
    //   163	1	5	localObject3	Object
    //   178	8	5	localObject4	Object
    //   189	237	5	localObject5	Object
    //   203	18	6	localObject6	Object
    //   235	22	6	localOutOfMemoryError3	OutOfMemoryError
    //   318	26	6	localIOException3	IOException
    //   1	323	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	121	124	java/io/IOException
    //   139	143	146	java/io/IOException
    //   71	82	163	finally
    //   82	89	163	finally
    //   94	106	163	finally
    //   109	117	163	finally
    //   71	82	168	java/lang/OutOfMemoryError
    //   82	89	168	java/lang/OutOfMemoryError
    //   94	106	168	java/lang/OutOfMemoryError
    //   109	117	168	java/lang/OutOfMemoryError
    //   71	82	173	java/io/IOException
    //   82	89	173	java/io/IOException
    //   94	106	173	java/io/IOException
    //   109	117	173	java/io/IOException
    //   55	71	178	finally
    //   55	71	194	java/lang/OutOfMemoryError
    //   55	71	211	java/io/IOException
    //   9	21	228	finally
    //   21	46	228	finally
    //   46	55	228	finally
    //   9	21	235	java/lang/OutOfMemoryError
    //   21	46	235	java/lang/OutOfMemoryError
    //   46	55	235	java/lang/OutOfMemoryError
    //   266	271	274	java/io/IOException
    //   294	299	301	java/io/IOException
    //   9	21	318	java/io/IOException
    //   21	46	318	java/io/IOException
    //   46	55	318	java/io/IOException
    //   250	261	351	finally
    //   337	348	351	finally
    //   367	372	375	java/io/IOException
    //   395	400	403	java/io/IOException
    //   425	430	433	java/io/IOException
    //   453	458	460	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (localFile.exists()) {
      try
      {
        boolean bool = copyFile(localFile, createFile(paramString2));
        return bool;
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("copy fail from ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" to ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" ");
        localStringBuilder.append(localIOException.getMessage());
        QLog.d("FileUtils", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  /* Error */
  public static long copyFileUsingFileChannels(File paramFile1, File paramFile2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: new 144	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokevirtual 364	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore_0
    //   18: new 229	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: invokevirtual 365	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   29: astore_1
    //   30: iload_2
    //   31: i2l
    //   32: lstore 4
    //   34: iload_3
    //   35: i2l
    //   36: lstore 6
    //   38: aload_1
    //   39: aload_0
    //   40: lload 4
    //   42: lload 6
    //   44: invokevirtual 371	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   47: lstore 6
    //   49: aload_0
    //   50: ifnull +7 -> 57
    //   53: aload_0
    //   54: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   57: lload 6
    //   59: lstore 4
    //   61: aload_1
    //   62: ifnull +95 -> 157
    //   65: aload_1
    //   66: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   69: lload 6
    //   71: lreturn
    //   72: astore 9
    //   74: aload_0
    //   75: astore 8
    //   77: aload 9
    //   79: astore_0
    //   80: goto +33 -> 113
    //   83: goto +55 -> 138
    //   86: astore 10
    //   88: aload 9
    //   90: astore_1
    //   91: aload_0
    //   92: astore 8
    //   94: aload 10
    //   96: astore_0
    //   97: goto +16 -> 113
    //   100: aload 8
    //   102: astore_1
    //   103: goto +35 -> 138
    //   106: astore_0
    //   107: aconst_null
    //   108: astore 8
    //   110: aload 9
    //   112: astore_1
    //   113: aload 8
    //   115: ifnull +8 -> 123
    //   118: aload 8
    //   120: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   131: aload_0
    //   132: athrow
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 8
    //   137: astore_1
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   154: lconst_0
    //   155: lstore 4
    //   157: lload 4
    //   159: lreturn
    //   160: astore_0
    //   161: goto -28 -> 133
    //   164: astore_1
    //   165: goto -65 -> 100
    //   168: astore 8
    //   170: goto -87 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile1	File
    //   0	173	1	paramFile2	File
    //   0	173	2	paramInt1	int
    //   0	173	3	paramInt2	int
    //   32	126	4	l1	long
    //   36	34	6	l2	long
    //   1	135	8	localFile	File
    //   168	1	8	localFileNotFoundException	FileNotFoundException
    //   4	1	9	localObject1	Object
    //   72	39	9	localObject2	Object
    //   86	9	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   38	49	72	finally
    //   18	30	86	finally
    //   6	18	106	finally
    //   6	18	160	java/io/FileNotFoundException
    //   18	30	164	java/io/FileNotFoundException
    //   38	49	168	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void copyResToFile(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +137 -> 138
    //   4: iload_1
    //   5: ifeq +133 -> 138
    //   8: aload_2
    //   9: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: invokevirtual 378	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: iload_1
    //   21: invokevirtual 384	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   24: checkcast 386	com/tencent/theme/SkinnableBitmapDrawable
    //   27: astore_3
    //   28: new 128	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokevirtual 133	java/io/File:exists	()Z
    //   41: ifne +24 -> 65
    //   44: aload_0
    //   45: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   48: invokevirtual 224	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_0
    //   53: invokevirtual 292	java/io/File:createNewFile	()Z
    //   56: pop
    //   57: goto +8 -> 65
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   65: new 229	java/io/FileOutputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore_0
    //   74: aload_3
    //   75: invokevirtual 390	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   78: getstatic 396	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload_0
    //   84: invokevirtual 402	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   87: pop
    //   88: aload_0
    //   89: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   92: return
    //   93: astore_3
    //   94: aload_0
    //   95: astore_2
    //   96: aload_3
    //   97: astore_0
    //   98: goto +12 -> 110
    //   101: goto +21 -> 122
    //   104: goto +27 -> 131
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +15 -> 138
    //   126: goto -38 -> 88
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +6 -> 138
    //   135: goto -47 -> 88
    //   138: return
    //   139: astore_0
    //   140: goto -11 -> 129
    //   143: astore_0
    //   144: goto -24 -> 120
    //   147: astore_2
    //   148: goto -44 -> 104
    //   151: astore_2
    //   152: goto -51 -> 101
    //   155: astore_0
    //   156: return
    //   157: astore_2
    //   158: goto -40 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContext	Context
    //   0	161	1	paramInt	int
    //   0	161	2	paramString	String
    //   27	48	3	localSkinnableBitmapDrawable	com.tencent.theme.SkinnableBitmapDrawable
    //   93	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	57	60	java/io/IOException
    //   74	88	93	finally
    //   65	74	107	finally
    //   65	74	139	java/io/IOException
    //   65	74	143	java/lang/OutOfMemoryError
    //   74	88	147	java/io/IOException
    //   74	88	151	java/lang/OutOfMemoryError
    //   88	92	155	java/io/IOException
    //   114	118	157	java/io/IOException
  }
  
  public static File createDirectory(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.mkdirs();
          return paramString;
        }
      }
      else {
        paramString.mkdirs();
      }
    }
    return paramString;
  }
  
  private static boolean createDirectory(File paramFile)
  {
    if (paramFile.exists()) {
      return true;
    }
    if (createDirectory(paramFile.getParentFile())) {
      return paramFile.mkdir();
    }
    return false;
  }
  
  public static VFSFile createDirectoryVFS(String paramString)
  {
    paramString = new VFSFile(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.mkdirs();
          return paramString;
        }
      }
      else {
        paramString.mkdirs();
      }
    }
    return paramString;
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
  
  public static void createFileIfNotExits(String paramString)
  {
    if (!fileExists(paramString)) {
      try
      {
        createFile(paramString);
        return;
      }
      catch (IOException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileUtils", 2, "createFileIfNotExits", paramString);
        }
      }
    }
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
  }
  
  public static void deleteDirectory(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return;
      }
      paramString = new File(paramString);
      File[] arrayOfFile = paramString.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          if (arrayOfFile[i].isDirectory()) {
            deleteDirectory(arrayOfFile[i].getAbsolutePath());
          } else {
            arrayOfFile[i].delete();
          }
          i += 1;
        }
      }
      paramString.delete();
    }
  }
  
  public static void deleteFile(File paramFile)
  {
    try
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          int i = 0;
          while (i < arrayOfFile.length)
          {
            deleteFile(arrayOfFile[i]);
            i += 1;
          }
        }
      }
      paramFile.delete();
      return;
    }
    catch (Exception paramFile)
    {
      label48:
      break label48;
    }
    QLog.e("FileUtils", 1, "deleteFile error");
  }
  
  public static boolean deleteFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  public static void deleteFilesInDirectory(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return;
      }
      paramString = new File(paramString).listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int i = 0;
        while (i < paramString.length)
        {
          if (paramString[i].isDirectory()) {
            deleteDirectory(paramString[i].getAbsolutePath());
          } else {
            paramString[i].delete();
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean deleteVFSFile(String paramString)
  {
    paramString = new VFSFile(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return true;
  }
  
  /* Error */
  public static String encryptFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 128	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 133	java/io/File:exists	()Z
    //   13: ifeq +316 -> 329
    //   16: aload_0
    //   17: invokevirtual 428	java/io/File:isFile	()Z
    //   20: ifne +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: invokestatic 462	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore 5
    //   31: new 144	java/io/FileInputStream
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_0
    //   40: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   43: sipush 8192
    //   46: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   49: astore 6
    //   51: bipush 16
    //   53: newarray char
    //   55: astore_1
    //   56: iconst_0
    //   57: istore_2
    //   58: aload_1
    //   59: iconst_0
    //   60: bipush 48
    //   62: castore
    //   63: aload_1
    //   64: iconst_1
    //   65: bipush 49
    //   67: castore
    //   68: aload_1
    //   69: iconst_2
    //   70: bipush 50
    //   72: castore
    //   73: aload_1
    //   74: iconst_3
    //   75: bipush 51
    //   77: castore
    //   78: aload_1
    //   79: iconst_4
    //   80: bipush 52
    //   82: castore
    //   83: aload_1
    //   84: iconst_5
    //   85: bipush 53
    //   87: castore
    //   88: aload_1
    //   89: bipush 6
    //   91: bipush 54
    //   93: castore
    //   94: aload_1
    //   95: bipush 7
    //   97: bipush 55
    //   99: castore
    //   100: aload_1
    //   101: bipush 8
    //   103: bipush 56
    //   105: castore
    //   106: aload_1
    //   107: bipush 9
    //   109: bipush 57
    //   111: castore
    //   112: aload_1
    //   113: bipush 10
    //   115: bipush 97
    //   117: castore
    //   118: aload_1
    //   119: bipush 11
    //   121: bipush 98
    //   123: castore
    //   124: aload_1
    //   125: bipush 12
    //   127: bipush 99
    //   129: castore
    //   130: aload_1
    //   131: bipush 13
    //   133: bipush 100
    //   135: castore
    //   136: aload_1
    //   137: bipush 14
    //   139: bipush 101
    //   141: castore
    //   142: aload_1
    //   143: bipush 15
    //   145: bipush 102
    //   147: castore
    //   148: aload_0
    //   149: aload 6
    //   151: invokevirtual 463	java/io/FileInputStream:read	([B)I
    //   154: istore_3
    //   155: iload_3
    //   156: ifle +15 -> 171
    //   159: aload 5
    //   161: aload 6
    //   163: iconst_0
    //   164: iload_3
    //   165: invokevirtual 466	java/security/MessageDigest:update	([BII)V
    //   168: goto -20 -> 148
    //   171: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   174: aload 6
    //   176: invokevirtual 338	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   179: aload 5
    //   181: invokevirtual 470	java/security/MessageDigest:digest	()[B
    //   184: astore 5
    //   186: aload 5
    //   188: ifnull +88 -> 276
    //   191: aload 5
    //   193: arraylength
    //   194: ifne +6 -> 200
    //   197: goto +79 -> 276
    //   200: aload 5
    //   202: arraylength
    //   203: iconst_2
    //   204: imul
    //   205: newarray char
    //   207: astore 6
    //   209: iload_2
    //   210: aload 5
    //   212: arraylength
    //   213: if_icmpge +47 -> 260
    //   216: aload 5
    //   218: iload_2
    //   219: baload
    //   220: istore_3
    //   221: iload_2
    //   222: iconst_2
    //   223: imul
    //   224: istore 4
    //   226: aload 6
    //   228: iload 4
    //   230: iconst_1
    //   231: iadd
    //   232: aload_1
    //   233: iload_3
    //   234: bipush 15
    //   236: iand
    //   237: caload
    //   238: castore
    //   239: aload 6
    //   241: iload 4
    //   243: aload_1
    //   244: iload_3
    //   245: iconst_4
    //   246: iushr
    //   247: i2b
    //   248: bipush 15
    //   250: iand
    //   251: caload
    //   252: castore
    //   253: iload_2
    //   254: iconst_1
    //   255: iadd
    //   256: istore_2
    //   257: goto -48 -> 209
    //   260: new 94	java/lang/String
    //   263: dup
    //   264: aload 6
    //   266: invokespecial 473	java/lang/String:<init>	([C)V
    //   269: astore_1
    //   270: aload_0
    //   271: invokevirtual 474	java/io/FileInputStream:close	()V
    //   274: aload_1
    //   275: areturn
    //   276: aload_0
    //   277: invokevirtual 474	java/io/FileInputStream:close	()V
    //   280: aconst_null
    //   281: areturn
    //   282: astore_1
    //   283: goto +12 -> 295
    //   286: goto +21 -> 307
    //   289: goto +31 -> 320
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_0
    //   295: aload_0
    //   296: ifnull +7 -> 303
    //   299: aload_0
    //   300: invokevirtual 474	java/io/FileInputStream:close	()V
    //   303: aload_1
    //   304: athrow
    //   305: aconst_null
    //   306: astore_0
    //   307: aload_0
    //   308: ifnull +19 -> 327
    //   311: aload_0
    //   312: invokevirtual 474	java/io/FileInputStream:close	()V
    //   315: goto +12 -> 327
    //   318: aconst_null
    //   319: astore_0
    //   320: aload_0
    //   321: ifnull +6 -> 327
    //   324: goto -13 -> 311
    //   327: aconst_null
    //   328: areturn
    //   329: aconst_null
    //   330: areturn
    //   331: astore_0
    //   332: goto -14 -> 318
    //   335: astore_0
    //   336: goto -31 -> 305
    //   339: astore_1
    //   340: goto -51 -> 289
    //   343: astore_1
    //   344: goto -58 -> 286
    //   347: astore_0
    //   348: aload_1
    //   349: areturn
    //   350: astore_0
    //   351: aconst_null
    //   352: areturn
    //   353: astore_0
    //   354: goto -51 -> 303
    //   357: astore_0
    //   358: goto -31 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	paramString1	String
    //   0	361	1	paramString2	String
    //   57	200	2	i	int
    //   154	93	3	j	int
    //   224	18	4	k	int
    //   29	188	5	localObject1	Object
    //   49	216	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	56	282	finally
    //   148	155	282	finally
    //   159	168	282	finally
    //   171	186	282	finally
    //   191	197	282	finally
    //   200	209	282	finally
    //   209	216	282	finally
    //   260	270	282	finally
    //   25	40	292	finally
    //   25	40	331	java/io/IOException
    //   25	40	335	java/security/NoSuchAlgorithmException
    //   40	56	339	java/io/IOException
    //   148	155	339	java/io/IOException
    //   159	168	339	java/io/IOException
    //   171	186	339	java/io/IOException
    //   191	197	339	java/io/IOException
    //   200	209	339	java/io/IOException
    //   209	216	339	java/io/IOException
    //   260	270	339	java/io/IOException
    //   40	56	343	java/security/NoSuchAlgorithmException
    //   148	155	343	java/security/NoSuchAlgorithmException
    //   159	168	343	java/security/NoSuchAlgorithmException
    //   171	186	343	java/security/NoSuchAlgorithmException
    //   191	197	343	java/security/NoSuchAlgorithmException
    //   200	209	343	java/security/NoSuchAlgorithmException
    //   209	216	343	java/security/NoSuchAlgorithmException
    //   260	270	343	java/security/NoSuchAlgorithmException
    //   270	274	347	java/io/IOException
    //   276	280	350	java/io/IOException
    //   299	303	353	java/io/IOException
    //   311	315	357	java/io/IOException
  }
  
  /* Error */
  public static String estimateFileType(String paramString)
  {
    // Byte code:
    //   0: ldc_w 477
    //   3: astore_1
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore_2
    //   12: new 144	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_3
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: astore 4
    //   26: iconst_2
    //   27: newarray byte
    //   29: astore 5
    //   31: aload_1
    //   32: astore_0
    //   33: aload_1
    //   34: astore_2
    //   35: aload_1
    //   36: astore 4
    //   38: aload_3
    //   39: aload 5
    //   41: invokevirtual 463	java/io/FileInputStream:read	([B)I
    //   44: iconst_m1
    //   45: if_icmpeq +14 -> 59
    //   48: aload_1
    //   49: astore_2
    //   50: aload_1
    //   51: astore 4
    //   53: aload 5
    //   55: invokestatic 479	com/tencent/mobileqq/utils/FileUtils:estimateFileType	([B)Ljava/lang/String;
    //   58: astore_0
    //   59: aload_0
    //   60: astore_2
    //   61: aload_0
    //   62: astore 4
    //   64: aload_3
    //   65: invokevirtual 474	java/io/FileInputStream:close	()V
    //   68: aload_0
    //   69: astore_2
    //   70: aload_3
    //   71: invokevirtual 474	java/io/FileInputStream:close	()V
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: aload_3
    //   78: astore_2
    //   79: goto +75 -> 154
    //   82: astore 4
    //   84: aload_3
    //   85: astore_0
    //   86: aload_2
    //   87: astore_1
    //   88: aload 4
    //   90: astore_3
    //   91: goto +22 -> 113
    //   94: astore_2
    //   95: aload_3
    //   96: astore_0
    //   97: aload 4
    //   99: astore_1
    //   100: aload_2
    //   101: astore_3
    //   102: goto +35 -> 137
    //   105: astore_0
    //   106: goto +48 -> 154
    //   109: astore_3
    //   110: aload 4
    //   112: astore_0
    //   113: aload_0
    //   114: astore_2
    //   115: aload_3
    //   116: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   119: aload_1
    //   120: astore_2
    //   121: aload_0
    //   122: ifnull +30 -> 152
    //   125: aload_1
    //   126: astore_2
    //   127: aload_0
    //   128: invokevirtual 474	java/io/FileInputStream:close	()V
    //   131: aload_1
    //   132: areturn
    //   133: astore_3
    //   134: aload 5
    //   136: astore_0
    //   137: aload_0
    //   138: astore_2
    //   139: aload_3
    //   140: invokevirtual 166	java/io/FileNotFoundException:printStackTrace	()V
    //   143: aload_1
    //   144: astore_2
    //   145: aload_0
    //   146: ifnull +6 -> 152
    //   149: goto -24 -> 125
    //   152: aload_2
    //   153: areturn
    //   154: aload_2
    //   155: ifnull +7 -> 162
    //   158: aload_2
    //   159: invokevirtual 474	java/io/FileInputStream:close	()V
    //   162: goto +5 -> 167
    //   165: aload_0
    //   166: athrow
    //   167: goto -2 -> 165
    //   170: astore_0
    //   171: aload_2
    //   172: areturn
    //   173: astore_1
    //   174: goto -12 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	String
    //   3	141	1	localObject1	Object
    //   173	1	1	localIOException1	IOException
    //   11	76	2	localObject2	Object
    //   94	7	2	localFileNotFoundException1	FileNotFoundException
    //   114	58	2	localObject3	Object
    //   20	82	3	localObject4	Object
    //   109	7	3	localIOException2	IOException
    //   133	7	3	localFileNotFoundException2	FileNotFoundException
    //   5	58	4	localObject5	Object
    //   82	29	4	localIOException3	IOException
    //   8	127	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	31	76	finally
    //   38	48	76	finally
    //   53	59	76	finally
    //   64	68	76	finally
    //   26	31	82	java/io/IOException
    //   38	48	82	java/io/IOException
    //   53	59	82	java/io/IOException
    //   64	68	82	java/io/IOException
    //   26	31	94	java/io/FileNotFoundException
    //   38	48	94	java/io/FileNotFoundException
    //   53	59	94	java/io/FileNotFoundException
    //   64	68	94	java/io/FileNotFoundException
    //   12	21	105	finally
    //   115	119	105	finally
    //   139	143	105	finally
    //   12	21	109	java/io/IOException
    //   12	21	133	java/io/FileNotFoundException
    //   70	74	170	java/io/IOException
    //   127	131	170	java/io/IOException
    //   158	162	173	java/io/IOException
  }
  
  public static String estimateFileType(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(Integer.toString(paramArrayOfByte[i] & 0xFF));
        str = localStringBuilder.toString();
        i += 1;
      }
      i = Integer.parseInt(str);
      if (i != 6677)
      {
        if (i != 7173)
        {
          if (i != 7784)
          {
            if (i != 7790)
            {
              if (i != 8075)
              {
                if (i != 8273)
                {
                  if (i != 8297)
                  {
                    if (i != 13780)
                    {
                      if (i != 255216)
                      {
                        paramArrayOfByte = new StringBuilder();
                        paramArrayOfByte.append(unKnownFileTypeMark);
                        paramArrayOfByte.append(str);
                        return paramArrayOfByte.toString();
                      }
                      return "jpg";
                    }
                    return "png";
                  }
                  return "rar";
                }
                return "webp";
              }
              return "zip";
            }
            return "exe";
          }
          return "midi";
        }
        return "gif";
      }
      return "bmp";
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(unKnownFileTypeMark);
    paramArrayOfByte.append("");
    return paramArrayOfByte.toString();
  }
  
  /* Error */
  public static String estimateVideoType(String paramString)
  {
    // Byte code:
    //   0: ldc_w 477
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore_3
    //   12: new 144	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: astore 4
    //   22: aload_2
    //   23: astore_3
    //   24: aload_2
    //   25: astore 5
    //   27: bipush 10
    //   29: newarray byte
    //   31: astore 6
    //   33: aload_2
    //   34: astore_0
    //   35: aload_2
    //   36: astore_3
    //   37: aload_2
    //   38: astore 5
    //   40: aload 4
    //   42: aload 6
    //   44: invokevirtual 463	java/io/FileInputStream:read	([B)I
    //   47: iconst_m1
    //   48: if_icmpeq +244 -> 292
    //   51: aload_2
    //   52: astore_3
    //   53: aload_2
    //   54: astore 5
    //   56: new 100	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   63: astore_0
    //   64: iconst_0
    //   65: istore_1
    //   66: aload_2
    //   67: astore_3
    //   68: aload_2
    //   69: astore 5
    //   71: iload_1
    //   72: aload 6
    //   74: arraylength
    //   75: if_icmpge +28 -> 103
    //   78: aload_2
    //   79: astore_3
    //   80: aload_2
    //   81: astore 5
    //   83: aload_0
    //   84: aload 6
    //   86: iload_1
    //   87: baload
    //   88: sipush 255
    //   91: iand
    //   92: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: iload_1
    //   97: iconst_1
    //   98: iadd
    //   99: istore_1
    //   100: goto -34 -> 66
    //   103: aload_2
    //   104: astore_3
    //   105: aload_2
    //   106: astore 5
    //   108: aload_0
    //   109: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: ldc_w 502
    //   115: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifne +305 -> 423
    //   121: aload_2
    //   122: astore_3
    //   123: aload_2
    //   124: astore 5
    //   126: aload_0
    //   127: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: ldc_w 508
    //   133: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: ifeq +6 -> 142
    //   139: goto +284 -> 423
    //   142: aload_2
    //   143: astore_3
    //   144: aload_2
    //   145: astore 5
    //   147: aload_0
    //   148: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: ldc_w 510
    //   154: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifeq +9 -> 166
    //   160: ldc 11
    //   162: astore_0
    //   163: goto +263 -> 426
    //   166: aload_2
    //   167: astore_3
    //   168: aload_2
    //   169: astore 5
    //   171: aload_0
    //   172: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: ldc_w 512
    //   178: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +9 -> 190
    //   184: ldc 41
    //   186: astore_0
    //   187: goto +239 -> 426
    //   190: aload_2
    //   191: astore_3
    //   192: aload_2
    //   193: astore 5
    //   195: aload_0
    //   196: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: ldc_w 514
    //   202: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +9 -> 214
    //   208: ldc 26
    //   210: astore_0
    //   211: goto +215 -> 426
    //   214: aload_2
    //   215: astore_3
    //   216: aload_2
    //   217: astore 5
    //   219: aload_0
    //   220: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: ldc_w 516
    //   226: invokevirtual 506	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifeq +9 -> 238
    //   232: ldc 17
    //   234: astore_0
    //   235: goto +191 -> 426
    //   238: aload_2
    //   239: astore_3
    //   240: aload_2
    //   241: astore 5
    //   243: new 100	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   250: astore 6
    //   252: aload_2
    //   253: astore_3
    //   254: aload_2
    //   255: astore 5
    //   257: aload 6
    //   259: getstatic 491	com/tencent/mobileqq/utils/FileUtils:unKnownFileTypeMark	Ljava/lang/String;
    //   262: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_2
    //   267: astore_3
    //   268: aload_2
    //   269: astore 5
    //   271: aload 6
    //   273: aload_0
    //   274: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: astore_3
    //   280: aload_2
    //   281: astore 5
    //   283: aload 6
    //   285: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: astore_0
    //   289: goto +137 -> 426
    //   292: aload_0
    //   293: astore_3
    //   294: aload_0
    //   295: astore 5
    //   297: aload 4
    //   299: invokevirtual 474	java/io/FileInputStream:close	()V
    //   302: aload_0
    //   303: astore_3
    //   304: aload 4
    //   306: invokevirtual 474	java/io/FileInputStream:close	()V
    //   309: aload_0
    //   310: areturn
    //   311: astore_0
    //   312: goto +86 -> 398
    //   315: astore 5
    //   317: aload 4
    //   319: astore_0
    //   320: aload_3
    //   321: astore_2
    //   322: aload 5
    //   324: astore 4
    //   326: goto +28 -> 354
    //   329: astore_3
    //   330: aload 4
    //   332: astore_0
    //   333: aload 5
    //   335: astore_2
    //   336: aload_3
    //   337: astore 4
    //   339: goto +41 -> 380
    //   342: astore_0
    //   343: aload_3
    //   344: astore 4
    //   346: goto +52 -> 398
    //   349: astore 4
    //   351: aload 5
    //   353: astore_0
    //   354: aload_0
    //   355: astore_3
    //   356: aload 4
    //   358: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   361: aload_2
    //   362: astore_3
    //   363: aload_0
    //   364: ifnull +32 -> 396
    //   367: aload_2
    //   368: astore_3
    //   369: aload_0
    //   370: invokevirtual 474	java/io/FileInputStream:close	()V
    //   373: aload_2
    //   374: areturn
    //   375: astore 4
    //   377: aload 6
    //   379: astore_0
    //   380: aload_0
    //   381: astore_3
    //   382: aload 4
    //   384: invokevirtual 166	java/io/FileNotFoundException:printStackTrace	()V
    //   387: aload_2
    //   388: astore_3
    //   389: aload_0
    //   390: ifnull +6 -> 396
    //   393: goto -26 -> 367
    //   396: aload_3
    //   397: areturn
    //   398: aload 4
    //   400: ifnull +8 -> 408
    //   403: aload 4
    //   405: invokevirtual 474	java/io/FileInputStream:close	()V
    //   408: goto +5 -> 413
    //   411: aload_0
    //   412: athrow
    //   413: goto -2 -> 411
    //   416: astore_0
    //   417: aload_3
    //   418: areturn
    //   419: astore_2
    //   420: goto -12 -> 408
    //   423: ldc 29
    //   425: astore_0
    //   426: goto -134 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString	String
    //   65	35	1	i	int
    //   3	385	2	localObject1	Object
    //   419	1	2	localIOException1	IOException
    //   11	310	3	localObject2	Object
    //   329	15	3	localFileNotFoundException1	FileNotFoundException
    //   355	63	3	localObject3	Object
    //   20	325	4	localObject4	Object
    //   349	8	4	localIOException2	IOException
    //   375	29	4	localFileNotFoundException2	FileNotFoundException
    //   5	291	5	localObject5	Object
    //   315	37	5	localIOException3	IOException
    //   8	370	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	311	finally
    //   40	51	311	finally
    //   56	64	311	finally
    //   71	78	311	finally
    //   83	96	311	finally
    //   108	121	311	finally
    //   126	139	311	finally
    //   147	160	311	finally
    //   171	184	311	finally
    //   195	208	311	finally
    //   219	232	311	finally
    //   243	252	311	finally
    //   257	266	311	finally
    //   271	278	311	finally
    //   283	289	311	finally
    //   297	302	311	finally
    //   27	33	315	java/io/IOException
    //   40	51	315	java/io/IOException
    //   56	64	315	java/io/IOException
    //   71	78	315	java/io/IOException
    //   83	96	315	java/io/IOException
    //   108	121	315	java/io/IOException
    //   126	139	315	java/io/IOException
    //   147	160	315	java/io/IOException
    //   171	184	315	java/io/IOException
    //   195	208	315	java/io/IOException
    //   219	232	315	java/io/IOException
    //   243	252	315	java/io/IOException
    //   257	266	315	java/io/IOException
    //   271	278	315	java/io/IOException
    //   283	289	315	java/io/IOException
    //   297	302	315	java/io/IOException
    //   27	33	329	java/io/FileNotFoundException
    //   40	51	329	java/io/FileNotFoundException
    //   56	64	329	java/io/FileNotFoundException
    //   71	78	329	java/io/FileNotFoundException
    //   83	96	329	java/io/FileNotFoundException
    //   108	121	329	java/io/FileNotFoundException
    //   126	139	329	java/io/FileNotFoundException
    //   147	160	329	java/io/FileNotFoundException
    //   171	184	329	java/io/FileNotFoundException
    //   195	208	329	java/io/FileNotFoundException
    //   219	232	329	java/io/FileNotFoundException
    //   243	252	329	java/io/FileNotFoundException
    //   257	266	329	java/io/FileNotFoundException
    //   271	278	329	java/io/FileNotFoundException
    //   283	289	329	java/io/FileNotFoundException
    //   297	302	329	java/io/FileNotFoundException
    //   12	22	342	finally
    //   356	361	342	finally
    //   382	387	342	finally
    //   12	22	349	java/io/IOException
    //   12	22	375	java/io/FileNotFoundException
    //   304	309	416	java/io/IOException
    //   369	373	416	java/io/IOException
    //   403	408	419	java/io/IOException
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  /* Error */
  public static byte[] fileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 133	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 232	java/io/BufferedInputStream
    //   12: dup
    //   13: new 144	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 6
    //   26: aload 6
    //   28: astore 5
    //   30: aload_0
    //   31: invokevirtual 137	java/io/File:length	()J
    //   34: lstore_3
    //   35: lload_3
    //   36: ldc2_w 522
    //   39: lcmp
    //   40: ifgt +153 -> 193
    //   43: lload_3
    //   44: lconst_0
    //   45: lcmp
    //   46: ifgt +6 -> 52
    //   49: goto +144 -> 193
    //   52: aload 6
    //   54: astore 5
    //   56: lload_3
    //   57: l2i
    //   58: newarray byte
    //   60: astore 7
    //   62: iconst_0
    //   63: istore_1
    //   64: aload 6
    //   66: astore 5
    //   68: iload_1
    //   69: aload 7
    //   71: arraylength
    //   72: if_icmpge +32 -> 104
    //   75: aload 6
    //   77: astore 5
    //   79: aload 6
    //   81: aload 7
    //   83: iload_1
    //   84: aload 7
    //   86: arraylength
    //   87: iload_1
    //   88: isub
    //   89: invokevirtual 528	java/io/InputStream:read	([BII)I
    //   92: istore_2
    //   93: iload_2
    //   94: iflt +10 -> 104
    //   97: iload_1
    //   98: iload_2
    //   99: iadd
    //   100: istore_1
    //   101: goto -37 -> 64
    //   104: aload 6
    //   106: astore 5
    //   108: iload_1
    //   109: aload 7
    //   111: arraylength
    //   112: if_icmpge +65 -> 177
    //   115: aload 6
    //   117: astore 5
    //   119: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +55 -> 177
    //   125: aload 6
    //   127: astore 5
    //   129: new 100	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   136: astore 8
    //   138: aload 6
    //   140: astore 5
    //   142: aload 8
    //   144: ldc_w 530
    //   147: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 6
    //   153: astore 5
    //   155: aload 8
    //   157: aload_0
    //   158: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: astore 5
    //   166: ldc 63
    //   168: iconst_2
    //   169: aload 8
    //   171: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 6
    //   179: invokevirtual 531	java/io/InputStream:close	()V
    //   182: aload 7
    //   184: areturn
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 532	java/lang/Throwable:printStackTrace	()V
    //   190: aload 7
    //   192: areturn
    //   193: aload 6
    //   195: astore 5
    //   197: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +55 -> 255
    //   203: aload 6
    //   205: astore 5
    //   207: new 100	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   214: astore 7
    //   216: aload 6
    //   218: astore 5
    //   220: aload 7
    //   222: ldc_w 534
    //   225: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 6
    //   231: astore 5
    //   233: aload 7
    //   235: lload_3
    //   236: invokevirtual 537	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: astore 5
    //   244: ldc 63
    //   246: iconst_2
    //   247: aload 7
    //   249: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload 6
    //   257: invokevirtual 531	java/io/InputStream:close	()V
    //   260: aconst_null
    //   261: areturn
    //   262: astore_0
    //   263: aload_0
    //   264: invokevirtual 532	java/lang/Throwable:printStackTrace	()V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_0
    //   270: aconst_null
    //   271: astore 5
    //   273: goto +88 -> 361
    //   276: aconst_null
    //   277: astore 6
    //   279: aload 6
    //   281: astore 5
    //   283: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +55 -> 341
    //   289: aload 6
    //   291: astore 5
    //   293: new 100	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   300: astore 7
    //   302: aload 6
    //   304: astore 5
    //   306: aload 7
    //   308: ldc_w 539
    //   311: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 6
    //   317: astore 5
    //   319: aload 7
    //   321: aload_0
    //   322: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 6
    //   328: astore 5
    //   330: ldc 63
    //   332: iconst_2
    //   333: aload 7
    //   335: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 6
    //   343: ifnull +15 -> 358
    //   346: aload 6
    //   348: invokevirtual 531	java/io/InputStream:close	()V
    //   351: aconst_null
    //   352: areturn
    //   353: astore_0
    //   354: aload_0
    //   355: invokevirtual 532	java/lang/Throwable:printStackTrace	()V
    //   358: aconst_null
    //   359: areturn
    //   360: astore_0
    //   361: aload 5
    //   363: ifnull +18 -> 381
    //   366: aload 5
    //   368: invokevirtual 531	java/io/InputStream:close	()V
    //   371: goto +10 -> 381
    //   374: astore 5
    //   376: aload 5
    //   378: invokevirtual 532	java/lang/Throwable:printStackTrace	()V
    //   381: goto +5 -> 386
    //   384: aload_0
    //   385: athrow
    //   386: goto -2 -> 384
    //   389: astore 5
    //   391: goto -115 -> 276
    //   394: astore 5
    //   396: goto -117 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramFile	File
    //   63	50	1	i	int
    //   92	8	2	j	int
    //   34	202	3	l	long
    //   28	339	5	localBufferedInputStream1	java.io.BufferedInputStream
    //   374	3	5	localThrowable1	java.lang.Throwable
    //   389	1	5	localThrowable2	java.lang.Throwable
    //   394	1	5	localThrowable3	java.lang.Throwable
    //   24	323	6	localBufferedInputStream2	java.io.BufferedInputStream
    //   60	274	7	localObject	Object
    //   136	34	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   177	182	185	java/lang/Throwable
    //   255	260	262	java/lang/Throwable
    //   9	26	269	finally
    //   346	351	353	java/lang/Throwable
    //   30	35	360	finally
    //   56	62	360	finally
    //   68	75	360	finally
    //   79	93	360	finally
    //   108	115	360	finally
    //   119	125	360	finally
    //   129	138	360	finally
    //   142	151	360	finally
    //   155	162	360	finally
    //   166	177	360	finally
    //   197	203	360	finally
    //   207	216	360	finally
    //   220	229	360	finally
    //   233	240	360	finally
    //   244	255	360	finally
    //   283	289	360	finally
    //   293	302	360	finally
    //   306	315	360	finally
    //   319	326	360	finally
    //   330	341	360	finally
    //   366	371	374	java/lang/Throwable
    //   9	26	389	java/lang/Throwable
    //   30	35	394	java/lang/Throwable
    //   56	62	394	java/lang/Throwable
    //   68	75	394	java/lang/Throwable
    //   79	93	394	java/lang/Throwable
    //   108	115	394	java/lang/Throwable
    //   119	125	394	java/lang/Throwable
    //   129	138	394	java/lang/Throwable
    //   142	151	394	java/lang/Throwable
    //   155	162	394	java/lang/Throwable
    //   166	177	394	java/lang/Throwable
    //   197	203	394	java/lang/Throwable
    //   207	216	394	java/lang/Throwable
    //   220	229	394	java/lang/Throwable
    //   233	240	394	java/lang/Throwable
    //   244	255	394	java/lang/Throwable
  }
  
  public static float getAvailableExternalMemorySize()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return f * i;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    return -1.0F;
  }
  
  public static float getAvailableInnernalMemorySize()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return f * i;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    return -1.0F;
  }
  
  /* Error */
  public static byte[] getByte(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_0
    //   6: ifnull +249 -> 255
    //   9: new 144	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 4
    //   19: aload 4
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 137	java/io/File:length	()J
    //   26: l2i
    //   27: newarray byte
    //   29: astore 5
    //   31: iconst_0
    //   32: istore_1
    //   33: aload 4
    //   35: astore_3
    //   36: iload_1
    //   37: aload 5
    //   39: arraylength
    //   40: if_icmpge +31 -> 71
    //   43: aload 4
    //   45: astore_3
    //   46: aload 4
    //   48: aload 5
    //   50: iload_1
    //   51: aload 5
    //   53: arraylength
    //   54: iload_1
    //   55: isub
    //   56: invokevirtual 528	java/io/InputStream:read	([BII)I
    //   59: istore_2
    //   60: iload_2
    //   61: iflt +10 -> 71
    //   64: iload_1
    //   65: iload_2
    //   66: iadd
    //   67: istore_1
    //   68: goto -35 -> 33
    //   71: aload 4
    //   73: astore_3
    //   74: iload_1
    //   75: aload 5
    //   77: arraylength
    //   78: if_icmpge +33 -> 111
    //   81: aload 6
    //   83: astore_0
    //   84: aload 4
    //   86: astore_3
    //   87: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +24 -> 114
    //   93: aload 4
    //   95: astore_3
    //   96: ldc 63
    //   98: iconst_2
    //   99: ldc_w 563
    //   102: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload 6
    //   107: astore_0
    //   108: goto +6 -> 114
    //   111: aload 5
    //   113: astore_0
    //   114: aload 4
    //   116: invokevirtual 531	java/io/InputStream:close	()V
    //   119: aload_0
    //   120: areturn
    //   121: astore 4
    //   123: aload_0
    //   124: astore_3
    //   125: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +127 -> 255
    //   131: ldc 63
    //   133: iconst_2
    //   134: ldc_w 565
    //   137: aload 4
    //   139: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_0
    //   143: areturn
    //   144: astore_0
    //   145: goto +24 -> 169
    //   148: astore_0
    //   149: aconst_null
    //   150: astore 5
    //   152: goto +17 -> 169
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_3
    //   158: goto +67 -> 225
    //   161: astore_0
    //   162: aconst_null
    //   163: astore 4
    //   165: aload 4
    //   167: astore 5
    //   169: aload 4
    //   171: astore_3
    //   172: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +16 -> 191
    //   178: aload 4
    //   180: astore_3
    //   181: ldc 63
    //   183: iconst_2
    //   184: ldc_w 567
    //   187: aload_0
    //   188: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload 4
    //   193: ifnull +28 -> 221
    //   196: aload 4
    //   198: invokevirtual 531	java/io/InputStream:close	()V
    //   201: goto +20 -> 221
    //   204: astore_0
    //   205: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +13 -> 221
    //   211: ldc 63
    //   213: iconst_2
    //   214: ldc_w 565
    //   217: aload_0
    //   218: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: aload 5
    //   223: areturn
    //   224: astore_0
    //   225: aload_3
    //   226: ifnull +27 -> 253
    //   229: aload_3
    //   230: invokevirtual 531	java/io/InputStream:close	()V
    //   233: goto +20 -> 253
    //   236: astore_3
    //   237: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +13 -> 253
    //   243: ldc 63
    //   245: iconst_2
    //   246: ldc_w 565
    //   249: aload_3
    //   250: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_0
    //   254: athrow
    //   255: aload_3
    //   256: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramFile	File
    //   32	47	1	i	int
    //   59	8	2	j	int
    //   1	229	3	localObject1	Object
    //   236	20	3	localIOException1	IOException
    //   17	98	4	localFileInputStream	java.io.FileInputStream
    //   121	17	4	localIOException2	IOException
    //   163	34	4	localObject2	Object
    //   29	193	5	localObject3	Object
    //   3	103	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   114	119	121	java/io/IOException
    //   36	43	144	java/lang/Exception
    //   46	60	144	java/lang/Exception
    //   74	81	144	java/lang/Exception
    //   87	93	144	java/lang/Exception
    //   96	105	144	java/lang/Exception
    //   22	31	148	java/lang/Exception
    //   9	19	155	finally
    //   9	19	161	java/lang/Exception
    //   196	201	204	java/io/IOException
    //   22	31	224	finally
    //   36	43	224	finally
    //   46	60	224	finally
    //   74	81	224	finally
    //   87	93	224	finally
    //   96	105	224	finally
    //   172	178	224	finally
    //   181	191	224	finally
    //   229	233	236	java/io/IOException
  }
  
  public static ArrayList<String> getChildFiles(String paramString)
  {
    return getChildFiles(paramString, false);
  }
  
  public static ArrayList<String> getChildFiles(String paramString, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int i = 0;
    try
    {
      int j = localObject.length;
      while (i < j)
      {
        if (localObject[i].isDirectory())
        {
          if (paramBoolean) {
            paramString.add(localObject[i].getCanonicalPath());
          }
          paramString.addAll(getChildFiles(localObject[i].getCanonicalPath(), paramBoolean));
        }
        else
        {
          paramString.add(localObject[i].getCanonicalPath());
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static long getFileAmount(String paramString)
  {
    paramString = new File(paramString);
    boolean bool = paramString.exists();
    long l1 = 0L;
    long l2 = l1;
    if (bool)
    {
      if (paramString.isFile()) {
        return 1L;
      }
      l2 = l1;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles();
        l2 = l1;
        if (paramString != null)
        {
          if (paramString.length <= 0) {
            return 0L;
          }
          int j = paramString.length;
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= j) {
              break;
            }
            Object localObject = paramString[i];
            l2 = l1;
            if (localObject != null)
            {
              l2 = l1;
              if (localObject.exists()) {
                if (localObject.isDirectory()) {
                  l2 = l1 + getFileAmount(localObject.getAbsolutePath());
                } else {
                  l2 = l1 + 1L;
                }
              }
            }
            i += 1;
            l1 = l2;
          }
        }
      }
    }
    return l2;
  }
  
  public static String getFileDirectoryOf(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf("/");
    if (i >= 0) {
      return paramString.substring(0, i + 1);
    }
    return null;
  }
  
  public static String getFileName(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      printStack();
      return "";
    }
    int m = paramString.length();
    int j = paramString.lastIndexOf('/');
    int k = paramString.lastIndexOf('\\');
    int i = j;
    if (k > j) {
      i = k;
    }
    if (i < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileUtils", 2, "filepath without / ?");
      }
      i = 0;
    }
    else
    {
      i = 1 + i;
    }
    String str = paramString.substring(i, m);
    if ((QLog.isColorLevel()) && (str != null) && (str.startsWith(".")))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("InvaildName ,filePath[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("], subName[");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("]");
      QLog.e("FileUtils", 2, ((StringBuilder)localObject1).toString());
    }
    for (Object localObject1 = str; (localObject1 != null) && (((String)localObject1).startsWith(".")); localObject1 = ((String)localObject1).replaceFirst(".", "")) {}
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("InvaildName ,filePath[");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("], subName[");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("]");
        QLog.e("FileUtils", 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = "InvaildName";
    }
    return localObject2;
  }
  
  public static long getFileOrFolderSize(String paramString)
  {
    paramString = new File(paramString);
    boolean bool = paramString.exists();
    long l1 = 0L;
    long l2 = l1;
    if (bool)
    {
      if (paramString.isFile()) {
        return paramString.length();
      }
      l2 = l1;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles();
        l2 = l1;
        if (paramString != null)
        {
          if (paramString.length <= 0) {
            return 0L;
          }
          int j = paramString.length;
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= j) {
              break;
            }
            Object localObject = paramString[i];
            l2 = l1;
            if (localObject != null)
            {
              l2 = l1;
              if (localObject.exists())
              {
                if (localObject.isDirectory()) {}
                for (l2 = getFileOrFolderSize(localObject.getAbsolutePath());; l2 = localObject.length())
                {
                  l2 = l1 + l2;
                  break;
                  l2 = l1;
                  if (!localObject.isFile()) {
                    break;
                  }
                }
              }
            }
            i += 1;
            l1 = l2;
          }
        }
      }
    }
    return l2;
  }
  
  public static String getFileSize(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  /* Error */
  public static long getFileSizes(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 128	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: aload_0
    //   16: invokevirtual 133	java/io/File:exists	()Z
    //   19: ifeq +40 -> 59
    //   22: new 144	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 668	java/io/FileInputStream:available	()I
    //   35: istore_1
    //   36: iload_1
    //   37: i2l
    //   38: lstore_2
    //   39: aload_0
    //   40: invokevirtual 474	java/io/FileInputStream:close	()V
    //   43: lload_2
    //   44: lreturn
    //   45: astore 5
    //   47: aload_0
    //   48: astore 4
    //   50: aload 5
    //   52: astore_0
    //   53: goto +9 -> 62
    //   56: goto +18 -> 74
    //   59: lconst_0
    //   60: lreturn
    //   61: astore_0
    //   62: aload 4
    //   64: ifnull +8 -> 72
    //   67: aload 4
    //   69: invokevirtual 474	java/io/FileInputStream:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: aload_0
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 474	java/io/FileInputStream:close	()V
    //   82: lconst_0
    //   83: lreturn
    //   84: astore_0
    //   85: aload 5
    //   87: astore_0
    //   88: goto -14 -> 74
    //   91: astore 4
    //   93: goto -37 -> 56
    //   96: astore_0
    //   97: lload_2
    //   98: lreturn
    //   99: astore 4
    //   101: goto -29 -> 72
    //   104: astore_0
    //   105: lconst_0
    //   106: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   35	2	1	i	int
    //   38	60	2	l	long
    //   4	64	4	str	String
    //   91	1	4	localException	Exception
    //   99	1	4	localIOException	IOException
    //   1	1	5	localObject1	Object
    //   45	41	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	36	45	finally
    //   6	31	61	finally
    //   6	31	84	java/lang/Exception
    //   31	36	91	java/lang/Exception
    //   39	43	96	java/io/IOException
    //   67	72	99	java/io/IOException
    //   78	82	104	java/io/IOException
  }
  
  public static float getTotalExternalMemorySize()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getBlockCount();
      int i = ((StatFs)localObject).getBlockSize();
      return f * i;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    return -1.0F;
  }
  
  public static float getTotalInnernalMemorySize()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getBlockCount();
      int i = ((StatFs)localObject).getBlockSize();
      return f * i;
    }
    catch (Exception localException)
    {
      label32:
      break label32;
    }
    return -1.0F;
  }
  
  public static String getUnitFileName(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!new File(localFile, paramString2).exists()) {
      return paramString2;
    }
    Object localObject;
    if (paramString2.lastIndexOf('.') < 0)
    {
      paramString1 = "";
    }
    else
    {
      paramString1 = paramString2.substring(0, paramString2.lastIndexOf('.'));
      localObject = paramString2.substring(paramString1.length(), paramString2.length());
      paramString2 = paramString1;
      paramString1 = (String)localObject;
    }
    int i = 1;
    for (;;)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(")");
      ((StringBuilder)localObject).append(paramString1);
      localObject = ((StringBuilder)localObject).toString();
      if (!new File(localFile, (String)localObject).exists()) {
        break;
      }
      i += 1;
    }
    return localObject;
  }
  
  public static boolean hasSDCardAndWritable()
  {
    boolean bool3 = false;
    for (;;)
    {
      try
      {
        File localFile = Environment.getExternalStorageDirectory();
        if ((localFile.exists()) && (localFile.canWrite()))
        {
          bool1 = true;
          boolean bool2 = QLog.isColorLevel();
          if (bool2)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("existAndCanWrite=");
            localStringBuilder.append(bool1);
            localStringBuilder.append(" externalDir.canWrite()= ");
            localStringBuilder.append(localFile.canWrite());
            localStringBuilder.append(" state=");
            localStringBuilder.append(Environment.getExternalStorageState().equals("mounted"));
            QLog.e("FileUtils", 2, localStringBuilder.toString());
          }
          boolean bool4 = Environment.getExternalStorageState().equals("mounted");
          bool2 = bool3;
          if (bool4)
          {
            bool2 = bool3;
            if (bool1) {
              bool2 = true;
            }
          }
          return bool2;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileUtils", 2, "hasSDCardAndWritable", localException);
        }
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  public static boolean isAssetsFileExist(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext.open(paramString).close();
      return true;
    }
    catch (IOException paramContext)
    {
      label15:
      break label15;
    }
    return false;
  }
  
  public static boolean isEmptyFile(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      if (paramString.length() <= 0L) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean isLocalPath(String paramString)
  {
    return (paramString != null) && ((paramString.startsWith(AppConstants.SDCARD_ROOT)) || (paramString.startsWith("/data/media/")) || (new File(paramString).exists()));
  }
  
  public static boolean isPicFile(String paramString)
  {
    paramString = estimateFileType(paramString);
    return (paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"));
  }
  
  public static boolean isPicFileByExt(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean justOnExistFileAndAddSuffix(String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    File localFile = new File(paramString1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramStringBuffer.toString());
    localObject = new File(((StringBuilder)localObject).toString());
    boolean bool;
    if (!localFile.exists()) {
      bool = localFile.mkdirs();
    } else {
      bool = true;
    }
    if ((localFile.exists()) && (((File)localObject).exists()))
    {
      paramStringBuffer.insert(paramStringBuffer.indexOf(paramString2), "(0)");
      for (paramString2 = (String)localObject; paramString2.exists(); paramString2 = new File(paramString2.toString()))
      {
        int i = paramStringBuffer.lastIndexOf("(") + 1;
        int j = paramStringBuffer.lastIndexOf(")");
        paramStringBuffer.replace(i, j, String.valueOf(Integer.parseInt(paramStringBuffer.substring(i, j)) + 1));
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(paramStringBuffer);
      }
    }
    return bool;
  }
  
  @TargetApi(9)
  public static List<FileUtils.StorageInfo> listAvaliableExternalStorage(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramContext = (StorageManager)paramContext.getSystemService("storage");
      Object localObject1 = StorageManager.class.getMethod("getVolumeList", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Object[])((Method)localObject1).invoke(paramContext, new Object[0]);
      if (localObject1 != null)
      {
        int i = 0;
        while (i < localObject1.length)
        {
          Object localObject2 = localObject1[i];
          FileUtils.StorageInfo localStorageInfo = new FileUtils.StorageInfo((String)localObject2.getClass().getMethod("getPath", new Class[0]).invoke(localObject2, new Object[0]));
          Object localObject3 = new File(localStorageInfo.path);
          if ((((File)localObject3).exists()) && (((File)localObject3).isDirectory()) && (((File)localObject3).canWrite()))
          {
            localObject3 = localObject2.getClass().getMethod("isRemovable", new Class[0]);
            try
            {
              localStorageInfo.state = ((String)StorageManager.class.getMethod("getVolumeState", new Class[] { String.class }).invoke(paramContext, new Object[] { localStorageInfo.path }));
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            if (localStorageInfo.isMounted())
            {
              localStorageInfo.isRemoveable = ((Boolean)((Method)localObject3).invoke(localObject2, new Object[0])).booleanValue();
              localArrayList.add(localStorageInfo);
            }
          }
          i += 1;
        }
      }
      localArrayList.trimToSize();
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
    }
    return localArrayList;
  }
  
  public static boolean mergeFiles(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return mergeFiles(new File(paramString1).listFiles(), paramString2, false);
  }
  
  /* Error */
  public static boolean mergeFiles(File[] paramArrayOfFile, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: ifnull +306 -> 310
    //   7: aload_0
    //   8: arraylength
    //   9: ifeq +301 -> 310
    //   12: aload_1
    //   13: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_3
    //   23: iload_3
    //   24: aload_0
    //   25: arraylength
    //   26: if_icmpge +38 -> 64
    //   29: aload_0
    //   30: iload_3
    //   31: aaload
    //   32: ifnull +30 -> 62
    //   35: aload_0
    //   36: iload_3
    //   37: aaload
    //   38: invokevirtual 133	java/io/File:exists	()Z
    //   41: ifeq +21 -> 62
    //   44: aload_0
    //   45: iload_3
    //   46: aaload
    //   47: invokevirtual 428	java/io/File:isFile	()Z
    //   50: ifne +5 -> 55
    //   53: iconst_0
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: iadd
    //   58: istore_3
    //   59: goto -36 -> 23
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_0
    //   65: arraylength
    //   66: iconst_1
    //   67: if_icmpne +18 -> 85
    //   70: aload_0
    //   71: iconst_0
    //   72: aaload
    //   73: new 128	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 815	java/io/File:renameTo	(Ljava/io/File;)Z
    //   84: ireturn
    //   85: new 128	java/io/File
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore 6
    //   95: aconst_null
    //   96: astore_1
    //   97: aconst_null
    //   98: astore 8
    //   100: aconst_null
    //   101: astore 9
    //   103: aconst_null
    //   104: astore 7
    //   106: new 229	java/io/FileOutputStream
    //   109: dup
    //   110: aload 6
    //   112: iconst_1
    //   113: invokespecial 818	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   116: astore 6
    //   118: aload 6
    //   120: invokevirtual 365	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   123: astore 8
    //   125: iconst_0
    //   126: istore_3
    //   127: aload_0
    //   128: arraylength
    //   129: istore 5
    //   131: iload_3
    //   132: iload 5
    //   134: if_icmpge +50 -> 184
    //   137: new 144	java/io/FileInputStream
    //   140: dup
    //   141: aload_0
    //   142: iload_3
    //   143: aaload
    //   144: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   147: invokevirtual 364	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   150: astore_1
    //   151: aload 8
    //   153: aload_1
    //   154: aload 8
    //   156: invokevirtual 821	java/nio/channels/FileChannel:size	()J
    //   159: aload_1
    //   160: invokevirtual 821	java/nio/channels/FileChannel:size	()J
    //   163: invokevirtual 371	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   166: pop2
    //   167: aload_1
    //   168: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   171: iload_3
    //   172: iconst_1
    //   173: iadd
    //   174: istore_3
    //   175: goto -48 -> 127
    //   178: aload_1
    //   179: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: aload 8
    //   186: invokevirtual 372	java/nio/channels/FileChannel:close	()V
    //   189: aload 6
    //   191: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   194: iload_2
    //   195: ifeq +26 -> 221
    //   198: iload 4
    //   200: istore_3
    //   201: iload_3
    //   202: aload_0
    //   203: arraylength
    //   204: if_icmpge +17 -> 221
    //   207: aload_0
    //   208: iload_3
    //   209: aaload
    //   210: invokevirtual 283	java/io/File:delete	()Z
    //   213: pop
    //   214: iload_3
    //   215: iconst_1
    //   216: iadd
    //   217: istore_3
    //   218: goto -17 -> 201
    //   221: iconst_1
    //   222: ireturn
    //   223: astore_0
    //   224: goto +74 -> 298
    //   227: astore_1
    //   228: aload 6
    //   230: astore_0
    //   231: aload_1
    //   232: astore 6
    //   234: goto +25 -> 259
    //   237: astore_1
    //   238: aload 6
    //   240: astore_0
    //   241: aload_1
    //   242: astore 6
    //   244: goto +37 -> 281
    //   247: astore_0
    //   248: aload_1
    //   249: astore 6
    //   251: goto +47 -> 298
    //   254: astore 6
    //   256: aload 8
    //   258: astore_0
    //   259: aload_0
    //   260: astore_1
    //   261: aload 6
    //   263: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   266: aload_0
    //   267: ifnull +7 -> 274
    //   270: aload_0
    //   271: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore 6
    //   278: aload 9
    //   280: astore_0
    //   281: aload_0
    //   282: astore_1
    //   283: aload 6
    //   285: invokevirtual 166	java/io/FileNotFoundException:printStackTrace	()V
    //   288: aload_0
    //   289: ifnull +7 -> 296
    //   292: aload_0
    //   293: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   296: iconst_0
    //   297: ireturn
    //   298: aload 6
    //   300: ifnull +8 -> 308
    //   303: aload 6
    //   305: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   308: aload_0
    //   309: athrow
    //   310: iconst_0
    //   311: ireturn
    //   312: astore_1
    //   313: goto -119 -> 194
    //   316: astore_0
    //   317: iconst_0
    //   318: ireturn
    //   319: astore_0
    //   320: iconst_0
    //   321: ireturn
    //   322: astore_1
    //   323: goto -15 -> 308
    //   326: astore_0
    //   327: goto -149 -> 178
    //   330: astore_0
    //   331: aload 7
    //   333: astore_1
    //   334: goto -156 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramArrayOfFile	File[]
    //   0	337	1	paramString	String
    //   0	337	2	paramBoolean	boolean
    //   22	196	3	i	int
    //   1	198	4	j	int
    //   129	6	5	k	int
    //   93	157	6	localObject1	Object
    //   254	8	6	localIOException	IOException
    //   276	28	6	localFileNotFoundException	FileNotFoundException
    //   104	228	7	localObject2	Object
    //   98	159	8	localFileChannel	java.nio.channels.FileChannel
    //   101	178	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   118	125	223	finally
    //   127	131	223	finally
    //   167	171	223	finally
    //   178	184	223	finally
    //   184	189	223	finally
    //   118	125	227	java/io/IOException
    //   127	131	227	java/io/IOException
    //   167	171	227	java/io/IOException
    //   178	184	227	java/io/IOException
    //   184	189	227	java/io/IOException
    //   118	125	237	java/io/FileNotFoundException
    //   127	131	237	java/io/FileNotFoundException
    //   167	171	237	java/io/FileNotFoundException
    //   178	184	237	java/io/FileNotFoundException
    //   184	189	237	java/io/FileNotFoundException
    //   106	118	247	finally
    //   261	266	247	finally
    //   283	288	247	finally
    //   106	118	254	java/io/IOException
    //   106	118	276	java/io/FileNotFoundException
    //   189	194	312	java/io/IOException
    //   270	274	316	java/io/IOException
    //   292	296	319	java/io/IOException
    //   303	308	322	java/io/IOException
    //   151	167	326	finally
    //   137	151	330	finally
  }
  
  public static boolean mergeFiles(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 1))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      File[] arrayOfFile = new File[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (TextUtils.isEmpty(paramArrayOfString[i])) {
          return false;
        }
        arrayOfFile[i] = new File(paramArrayOfString[i]);
        i += 1;
      }
      return mergeFiles(arrayOfFile, paramString, false);
    }
    return false;
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = new File(paramString1);
      bool1 = bool2;
      if (!paramString1.exists()) {}
    }
    try
    {
      copyFile(paramString1, createFile(paramString2));
      paramString1.delete();
      bool1 = true;
      return bool1;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  /* Error */
  public static String printStack()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 477
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: invokestatic 829	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   12: invokestatic 833	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokeinterface 839 2 0
    //   20: checkcast 841	[Ljava/lang/StackTraceElement;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_3
    //   27: aload 4
    //   29: arraylength
    //   30: istore_1
    //   31: iconst_0
    //   32: istore_0
    //   33: aload_2
    //   34: astore_3
    //   35: iload_0
    //   36: iload_1
    //   37: if_icmpge +90 -> 127
    //   40: aload 4
    //   42: iload_0
    //   43: aaload
    //   44: astore 5
    //   46: aload_2
    //   47: astore_3
    //   48: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +17 -> 68
    //   54: aload_2
    //   55: astore_3
    //   56: ldc_w 631
    //   59: iconst_1
    //   60: aload 5
    //   62: invokevirtual 844	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   65: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: aload_2
    //   69: astore_3
    //   70: new 100	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   77: astore 6
    //   79: aload_2
    //   80: astore_3
    //   81: aload 6
    //   83: aload_2
    //   84: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: astore_3
    //   90: aload 6
    //   92: aload 5
    //   94: invokevirtual 844	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   97: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: astore_3
    //   103: aload 6
    //   105: ldc_w 846
    //   108: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_2
    //   113: astore_3
    //   114: aload 6
    //   116: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_2
    //   120: iload_0
    //   121: iconst_1
    //   122: iadd
    //   123: istore_0
    //   124: goto -91 -> 33
    //   127: ldc 2
    //   129: monitorexit
    //   130: aload_3
    //   131: areturn
    //   132: astore_2
    //   133: ldc 2
    //   135: monitorexit
    //   136: goto +5 -> 141
    //   139: aload_2
    //   140: athrow
    //   141: goto -2 -> 139
    //   144: astore_2
    //   145: goto -18 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	92	0	i	int
    //   30	8	1	j	int
    //   6	114	2	str1	String
    //   132	8	2	localObject	Object
    //   144	1	2	localException	Exception
    //   8	123	3	str2	String
    //   23	18	4	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   44	49	5	localStackTraceElement	java.lang.StackTraceElement
    //   77	38	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	25	132	finally
    //   27	31	132	finally
    //   48	54	132	finally
    //   56	68	132	finally
    //   70	79	132	finally
    //   81	88	132	finally
    //   90	101	132	finally
    //   103	112	132	finally
    //   114	120	132	finally
    //   9	25	144	java/lang/Exception
    //   27	31	144	java/lang/Exception
    //   48	54	144	java/lang/Exception
    //   56	68	144	java/lang/Exception
    //   70	79	144	java/lang/Exception
    //   81	88	144	java/lang/Exception
    //   90	101	144	java/lang/Exception
    //   103	112	144	java/lang/Exception
    //   114	120	144	java/lang/Exception
  }
  
  /* Error */
  public static boolean pushData2File(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ifnull +304 -> 307
    //   6: aload_0
    //   7: invokevirtual 440	java/lang/String:length	()I
    //   10: ifeq +297 -> 307
    //   13: aload_1
    //   14: ifnull +293 -> 307
    //   17: aload_1
    //   18: arraylength
    //   19: ifne +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: astore 4
    //   27: iload_2
    //   28: ifeq +71 -> 99
    //   31: new 850	java/text/SimpleDateFormat
    //   34: dup
    //   35: ldc_w 852
    //   38: getstatic 858	java/util/Locale:CHINA	Ljava/util/Locale;
    //   41: invokespecial 861	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   44: new 863	java/util/Date
    //   47: dup
    //   48: invokestatic 868	java/lang/System:currentTimeMillis	()J
    //   51: invokespecial 871	java/util/Date:<init>	(J)V
    //   54: invokevirtual 874	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   57: astore 4
    //   59: new 100	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: aload_0
    //   71: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 5
    //   77: ldc_w 598
    //   80: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: aload 4
    //   88: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 5
    //   94: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 4
    //   99: new 128	java/io/File
    //   102: dup
    //   103: aload 4
    //   105: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore 7
    //   110: aconst_null
    //   111: astore 5
    //   113: aconst_null
    //   114: astore 6
    //   116: aconst_null
    //   117: astore 4
    //   119: aload 4
    //   121: astore_0
    //   122: aload 7
    //   124: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   127: astore 8
    //   129: aload 4
    //   131: astore_0
    //   132: aload 8
    //   134: invokevirtual 133	java/io/File:exists	()Z
    //   137: ifne +12 -> 149
    //   140: aload 4
    //   142: astore_0
    //   143: aload 8
    //   145: invokevirtual 224	java/io/File:mkdirs	()Z
    //   148: pop
    //   149: aload 4
    //   151: astore_0
    //   152: aload 7
    //   154: invokevirtual 133	java/io/File:exists	()Z
    //   157: ifeq +12 -> 169
    //   160: aload 4
    //   162: astore_0
    //   163: aload 7
    //   165: invokevirtual 283	java/io/File:delete	()Z
    //   168: pop
    //   169: aload 4
    //   171: astore_0
    //   172: new 229	java/io/FileOutputStream
    //   175: dup
    //   176: aload 7
    //   178: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   181: astore 4
    //   183: aload 4
    //   185: aload_1
    //   186: invokevirtual 876	java/io/FileOutputStream:write	([B)V
    //   189: aload 4
    //   191: invokevirtual 334	java/io/FileOutputStream:flush	()V
    //   194: iconst_1
    //   195: istore_2
    //   196: aload 4
    //   198: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   201: iconst_1
    //   202: ireturn
    //   203: astore_0
    //   204: aload_0
    //   205: invokevirtual 588	java/lang/Exception:printStackTrace	()V
    //   208: iload_2
    //   209: ireturn
    //   210: astore_1
    //   211: aload 4
    //   213: astore_0
    //   214: goto +75 -> 289
    //   217: astore_0
    //   218: aload 4
    //   220: astore_1
    //   221: aload_0
    //   222: astore 4
    //   224: goto +22 -> 246
    //   227: astore_0
    //   228: aload 4
    //   230: astore_1
    //   231: aload_0
    //   232: astore 4
    //   234: goto +36 -> 270
    //   237: astore_1
    //   238: goto +51 -> 289
    //   241: astore 4
    //   243: aload 5
    //   245: astore_1
    //   246: aload_1
    //   247: astore_0
    //   248: aload 4
    //   250: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   253: aload_1
    //   254: ifnull +33 -> 287
    //   257: iload_3
    //   258: istore_2
    //   259: aload_1
    //   260: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   263: iconst_0
    //   264: ireturn
    //   265: astore 4
    //   267: aload 6
    //   269: astore_1
    //   270: aload_1
    //   271: astore_0
    //   272: aload 4
    //   274: invokevirtual 166	java/io/FileNotFoundException:printStackTrace	()V
    //   277: aload_1
    //   278: ifnull +9 -> 287
    //   281: iload_3
    //   282: istore_2
    //   283: aload_1
    //   284: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   287: iconst_0
    //   288: ireturn
    //   289: aload_0
    //   290: ifnull +15 -> 305
    //   293: aload_0
    //   294: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   297: goto +8 -> 305
    //   300: astore_0
    //   301: aload_0
    //   302: invokevirtual 588	java/lang/Exception:printStackTrace	()V
    //   305: aload_1
    //   306: athrow
    //   307: iconst_0
    //   308: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   0	309	1	paramArrayOfByte	byte[]
    //   0	309	2	paramBoolean	boolean
    //   1	281	3	bool	boolean
    //   25	208	4	localObject1	Object
    //   241	8	4	localIOException	IOException
    //   265	8	4	localFileNotFoundException	FileNotFoundException
    //   66	178	5	localStringBuilder	StringBuilder
    //   114	154	6	localObject2	Object
    //   108	69	7	localFile1	File
    //   127	17	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   196	201	203	java/lang/Exception
    //   259	263	203	java/lang/Exception
    //   283	287	203	java/lang/Exception
    //   183	194	210	finally
    //   183	194	217	java/io/IOException
    //   183	194	227	java/io/FileNotFoundException
    //   122	129	237	finally
    //   132	140	237	finally
    //   143	149	237	finally
    //   152	160	237	finally
    //   163	169	237	finally
    //   172	183	237	finally
    //   248	253	237	finally
    //   272	277	237	finally
    //   122	129	241	java/io/IOException
    //   132	140	241	java/io/IOException
    //   143	149	241	java/io/IOException
    //   152	160	241	java/io/IOException
    //   163	169	241	java/io/IOException
    //   172	183	241	java/io/IOException
    //   122	129	265	java/io/FileNotFoundException
    //   132	140	265	java/io/FileNotFoundException
    //   143	149	265	java/io/FileNotFoundException
    //   152	160	265	java/io/FileNotFoundException
    //   163	169	265	java/io/FileNotFoundException
    //   172	183	265	java/io/FileNotFoundException
    //   293	297	300	java/lang/Exception
  }
  
  public static int quickMove(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if ((!paramString1.exists()) && (paramString2.exists())) {
      return 1;
    }
    if ((!paramString2.getParentFile().exists()) && (!paramString2.getParentFile().mkdirs())) {
      return 2;
    }
    if (paramString1.renameTo(paramString2)) {
      return 0;
    }
    return 3;
  }
  
  public static String readFile(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static byte[] readFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 10
    //   9: iload 4
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 128	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 133	java/io/File:exists	()Z
    //   31: ifne +5 -> 36
    //   34: aconst_null
    //   35: areturn
    //   36: aload 5
    //   38: invokevirtual 137	java/io/File:length	()J
    //   41: l2i
    //   42: istore_2
    //   43: new 893	java/io/ByteArrayOutputStream
    //   46: dup
    //   47: iload_2
    //   48: invokespecial 896	java/io/ByteArrayOutputStream:<init>	(I)V
    //   51: astore_0
    //   52: new 144	java/io/FileInputStream
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore 7
    //   63: iload_2
    //   64: sipush 4096
    //   67: if_icmpge +24 -> 91
    //   70: aload_0
    //   71: astore 6
    //   73: aload 7
    //   75: astore 5
    //   77: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   80: sipush 4096
    //   83: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   86: astore 8
    //   88: goto +21 -> 109
    //   91: aload_0
    //   92: astore 6
    //   94: aload 7
    //   96: astore 5
    //   98: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   101: sipush 12288
    //   104: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   107: astore 8
    //   109: iconst_0
    //   110: istore_1
    //   111: goto +35 -> 146
    //   114: astore 9
    //   116: aload_0
    //   117: astore 8
    //   119: aload 7
    //   121: astore_0
    //   122: goto +255 -> 377
    //   125: aload_0
    //   126: astore 6
    //   128: aload 7
    //   130: astore 5
    //   132: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   135: sipush 4096
    //   138: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   141: astore 8
    //   143: goto -34 -> 109
    //   146: iload_1
    //   147: iload_2
    //   148: if_icmpge +40 -> 188
    //   151: aload_0
    //   152: astore 6
    //   154: aload 7
    //   156: astore 5
    //   158: aload 7
    //   160: aload 8
    //   162: invokevirtual 463	java/io/FileInputStream:read	([B)I
    //   165: istore_3
    //   166: aload_0
    //   167: astore 6
    //   169: aload 7
    //   171: astore 5
    //   173: aload_0
    //   174: aload 8
    //   176: iconst_0
    //   177: iload_3
    //   178: invokevirtual 897	java/io/ByteArrayOutputStream:write	([BII)V
    //   181: iload_1
    //   182: iload_3
    //   183: iadd
    //   184: istore_1
    //   185: goto -39 -> 146
    //   188: aload_0
    //   189: astore 6
    //   191: aload 7
    //   193: astore 5
    //   195: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   198: aload 8
    //   200: invokevirtual 338	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   203: aload_0
    //   204: astore 6
    //   206: aload 7
    //   208: astore 5
    //   210: aload_0
    //   211: invokevirtual 900	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   214: astore 8
    //   216: aload 8
    //   218: astore 5
    //   220: aload_0
    //   221: invokevirtual 901	java/io/ByteArrayOutputStream:close	()V
    //   224: aload 8
    //   226: astore 5
    //   228: aload 7
    //   230: invokevirtual 474	java/io/FileInputStream:close	()V
    //   233: aload 8
    //   235: areturn
    //   236: astore_0
    //   237: ldc 63
    //   239: iconst_1
    //   240: ldc_w 903
    //   243: aload_0
    //   244: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload 5
    //   249: areturn
    //   250: astore 9
    //   252: aload_0
    //   253: astore 8
    //   255: aload 7
    //   257: astore_0
    //   258: goto +57 -> 315
    //   261: astore 7
    //   263: aconst_null
    //   264: astore 5
    //   266: goto +157 -> 423
    //   269: astore 9
    //   271: aconst_null
    //   272: astore 5
    //   274: aload_0
    //   275: astore 8
    //   277: aload 5
    //   279: astore_0
    //   280: goto +35 -> 315
    //   283: astore 9
    //   285: aconst_null
    //   286: astore 5
    //   288: aload_0
    //   289: astore 8
    //   291: aload 5
    //   293: astore_0
    //   294: goto +83 -> 377
    //   297: astore 7
    //   299: aconst_null
    //   300: astore_0
    //   301: aload_0
    //   302: astore 5
    //   304: goto +119 -> 423
    //   307: astore 9
    //   309: aconst_null
    //   310: astore 8
    //   312: aload 8
    //   314: astore_0
    //   315: aload 8
    //   317: astore 6
    //   319: aload_0
    //   320: astore 5
    //   322: ldc 63
    //   324: iconst_1
    //   325: ldc_w 905
    //   328: aload 9
    //   330: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   333: aload 8
    //   335: ifnull +12 -> 347
    //   338: aload 10
    //   340: astore 5
    //   342: aload 8
    //   344: invokevirtual 901	java/io/ByteArrayOutputStream:close	()V
    //   347: aload_0
    //   348: ifnull +73 -> 421
    //   351: aload 10
    //   353: astore 5
    //   355: aload_0
    //   356: invokevirtual 474	java/io/FileInputStream:close	()V
    //   359: aconst_null
    //   360: areturn
    //   361: astore 7
    //   363: aload 6
    //   365: astore_0
    //   366: goto +57 -> 423
    //   369: astore 9
    //   371: aconst_null
    //   372: astore 8
    //   374: aload 8
    //   376: astore_0
    //   377: aload 8
    //   379: astore 6
    //   381: aload_0
    //   382: astore 5
    //   384: ldc 63
    //   386: iconst_1
    //   387: ldc_w 903
    //   390: aload 9
    //   392: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload 8
    //   397: ifnull +12 -> 409
    //   400: aload 10
    //   402: astore 5
    //   404: aload 8
    //   406: invokevirtual 901	java/io/ByteArrayOutputStream:close	()V
    //   409: aload_0
    //   410: ifnull +11 -> 421
    //   413: aload 10
    //   415: astore 5
    //   417: aload_0
    //   418: invokevirtual 474	java/io/FileInputStream:close	()V
    //   421: aconst_null
    //   422: areturn
    //   423: aload_0
    //   424: ifnull +10 -> 434
    //   427: aload_0
    //   428: invokevirtual 901	java/io/ByteArrayOutputStream:close	()V
    //   431: goto +3 -> 434
    //   434: aload 5
    //   436: ifnull +21 -> 457
    //   439: aload 5
    //   441: invokevirtual 474	java/io/FileInputStream:close	()V
    //   444: goto +13 -> 457
    //   447: ldc 63
    //   449: iconst_1
    //   450: ldc_w 903
    //   453: aload_0
    //   454: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   457: goto +6 -> 463
    //   460: aload 7
    //   462: athrow
    //   463: goto -3 -> 460
    //   466: astore 5
    //   468: goto -343 -> 125
    //   471: astore_0
    //   472: goto -25 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramString	String
    //   110	75	1	i	int
    //   42	107	2	j	int
    //   165	19	3	k	int
    //   4	6	4	bool	boolean
    //   24	416	5	localObject1	Object
    //   466	1	5	localOutOfMemoryError1	OutOfMemoryError
    //   71	309	6	localObject2	Object
    //   61	195	7	localFileInputStream	java.io.FileInputStream
    //   261	1	7	localObject3	Object
    //   297	1	7	localObject4	Object
    //   361	100	7	localObject5	Object
    //   86	319	8	localObject6	Object
    //   114	1	9	localException1	Exception
    //   250	1	9	localOutOfMemoryError2	OutOfMemoryError
    //   269	1	9	localOutOfMemoryError3	OutOfMemoryError
    //   283	1	9	localException2	Exception
    //   307	22	9	localOutOfMemoryError4	OutOfMemoryError
    //   369	22	9	localException3	Exception
    //   7	407	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   77	88	114	java/lang/Exception
    //   98	109	114	java/lang/Exception
    //   132	143	114	java/lang/Exception
    //   158	166	114	java/lang/Exception
    //   173	181	114	java/lang/Exception
    //   195	203	114	java/lang/Exception
    //   210	216	114	java/lang/Exception
    //   220	224	236	java/io/IOException
    //   228	233	236	java/io/IOException
    //   342	347	236	java/io/IOException
    //   355	359	236	java/io/IOException
    //   404	409	236	java/io/IOException
    //   417	421	236	java/io/IOException
    //   132	143	250	java/lang/OutOfMemoryError
    //   158	166	250	java/lang/OutOfMemoryError
    //   173	181	250	java/lang/OutOfMemoryError
    //   195	203	250	java/lang/OutOfMemoryError
    //   210	216	250	java/lang/OutOfMemoryError
    //   52	63	261	finally
    //   52	63	269	java/lang/OutOfMemoryError
    //   52	63	283	java/lang/Exception
    //   36	52	297	finally
    //   36	52	307	java/lang/OutOfMemoryError
    //   77	88	361	finally
    //   98	109	361	finally
    //   132	143	361	finally
    //   158	166	361	finally
    //   173	181	361	finally
    //   195	203	361	finally
    //   210	216	361	finally
    //   322	333	361	finally
    //   384	395	361	finally
    //   36	52	369	java/lang/Exception
    //   77	88	466	java/lang/OutOfMemoryError
    //   98	109	466	java/lang/OutOfMemoryError
    //   427	431	471	java/io/IOException
    //   439	444	471	java/io/IOException
  }
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: invokevirtual 137	java/io/File:length	()J
    //   10: l2i
    //   11: istore_2
    //   12: new 893	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: iload_2
    //   17: invokespecial 896	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore 4
    //   22: new 232	java/io/BufferedInputStream
    //   25: dup
    //   26: new 144	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_0
    //   38: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   41: sipush 12288
    //   44: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   47: astore 5
    //   49: iconst_0
    //   50: istore_1
    //   51: goto +30 -> 81
    //   54: astore 6
    //   56: aload 4
    //   58: astore 5
    //   60: aload 6
    //   62: astore 4
    //   64: goto +127 -> 191
    //   67: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   70: sipush 4096
    //   73: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   76: astore 5
    //   78: goto -29 -> 49
    //   81: iload_1
    //   82: iload_2
    //   83: if_icmpge +26 -> 109
    //   86: aload_0
    //   87: aload 5
    //   89: invokevirtual 907	java/io/InputStream:read	([B)I
    //   92: istore_3
    //   93: aload 4
    //   95: aload 5
    //   97: iconst_0
    //   98: iload_3
    //   99: invokevirtual 897	java/io/ByteArrayOutputStream:write	([BII)V
    //   102: iload_1
    //   103: iload_3
    //   104: iadd
    //   105: istore_1
    //   106: goto -25 -> 81
    //   109: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   112: aload 5
    //   114: invokevirtual 338	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   117: aload 4
    //   119: ldc_w 909
    //   122: invokevirtual 911	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 4
    //   129: invokevirtual 901	java/io/ByteArrayOutputStream:close	()V
    //   132: aload_0
    //   133: invokevirtual 531	java/io/InputStream:close	()V
    //   136: aload 5
    //   138: areturn
    //   139: astore_0
    //   140: aload 5
    //   142: astore 4
    //   144: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +137 -> 284
    //   150: ldc 63
    //   152: iconst_2
    //   153: ldc_w 903
    //   156: aload_0
    //   157: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload 5
    //   162: areturn
    //   163: astore 6
    //   165: aconst_null
    //   166: astore_0
    //   167: aload 4
    //   169: astore 5
    //   171: aload 6
    //   173: astore 4
    //   175: goto +16 -> 191
    //   178: aconst_null
    //   179: astore_0
    //   180: goto +60 -> 240
    //   183: astore 4
    //   185: aconst_null
    //   186: astore 5
    //   188: aload 5
    //   190: astore_0
    //   191: aload 5
    //   193: ifnull +11 -> 204
    //   196: aload 5
    //   198: invokevirtual 901	java/io/ByteArrayOutputStream:close	()V
    //   201: goto +3 -> 204
    //   204: aload_0
    //   205: ifnull +26 -> 231
    //   208: aload_0
    //   209: invokevirtual 531	java/io/InputStream:close	()V
    //   212: goto +19 -> 231
    //   215: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +13 -> 231
    //   221: ldc 63
    //   223: iconst_2
    //   224: ldc_w 903
    //   227: aload_0
    //   228: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload 4
    //   233: athrow
    //   234: aconst_null
    //   235: astore 4
    //   237: aload 4
    //   239: astore_0
    //   240: aload 4
    //   242: ifnull +11 -> 253
    //   245: aload 4
    //   247: invokevirtual 901	java/io/ByteArrayOutputStream:close	()V
    //   250: goto +3 -> 253
    //   253: aload 7
    //   255: astore 4
    //   257: aload_0
    //   258: ifnull +26 -> 284
    //   261: aload_0
    //   262: invokevirtual 531	java/io/InputStream:close	()V
    //   265: aconst_null
    //   266: areturn
    //   267: aload 7
    //   269: astore 4
    //   271: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +10 -> 284
    //   277: aload 6
    //   279: astore 5
    //   281: goto -131 -> 150
    //   284: aload 4
    //   286: areturn
    //   287: astore_0
    //   288: goto -54 -> 234
    //   291: astore_0
    //   292: goto -114 -> 178
    //   295: astore 5
    //   297: goto -230 -> 67
    //   300: astore 5
    //   302: goto -62 -> 240
    //   305: astore_0
    //   306: goto -91 -> 215
    //   309: astore_0
    //   310: goto -43 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramFile	File
    //   50	56	1	i	int
    //   11	73	2	j	int
    //   92	13	3	k	int
    //   20	154	4	localObject1	Object
    //   183	49	4	localObject2	Object
    //   235	50	4	localObject3	Object
    //   47	233	5	localObject4	Object
    //   295	1	5	localOutOfMemoryError	OutOfMemoryError
    //   300	1	5	localThrowable	java.lang.Throwable
    //   4	1	6	localObject5	Object
    //   54	7	6	localObject6	Object
    //   163	115	6	localObject7	Object
    //   1	267	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   38	49	54	finally
    //   67	78	54	finally
    //   86	102	54	finally
    //   109	127	54	finally
    //   127	136	139	java/io/IOException
    //   22	38	163	finally
    //   6	22	183	finally
    //   6	22	287	java/lang/Throwable
    //   22	38	291	java/lang/Throwable
    //   38	49	295	java/lang/OutOfMemoryError
    //   38	49	300	java/lang/Throwable
    //   67	78	300	java/lang/Throwable
    //   86	102	300	java/lang/Throwable
    //   109	127	300	java/lang/Throwable
    //   196	201	305	java/io/IOException
    //   208	212	305	java/io/IOException
    //   245	250	309	java/io/IOException
    //   261	265	309	java/io/IOException
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 133	java/io/File:exists	()Z
    //   13: ifeq +291 -> 304
    //   16: aload_0
    //   17: invokevirtual 274	java/io/File:isDirectory	()Z
    //   20: ifne +242 -> 262
    //   23: aload_0
    //   24: invokevirtual 915	java/io/File:canRead	()Z
    //   27: ifeq +193 -> 220
    //   30: new 144	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: new 883	java/io/InputStreamReader
    //   42: dup
    //   43: aload_3
    //   44: ldc_w 917
    //   47: invokespecial 920	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 137	java/io/File:length	()J
    //   55: l2i
    //   56: istore_1
    //   57: iload_1
    //   58: sipush 12288
    //   61: if_icmple +53 -> 114
    //   64: sipush 4096
    //   67: newarray char
    //   69: astore_0
    //   70: new 100	java/lang/StringBuilder
    //   73: dup
    //   74: sipush 12288
    //   77: invokespecial 921	java/lang/StringBuilder:<init>	(I)V
    //   80: astore 5
    //   82: aload_2
    //   83: aload_0
    //   84: invokevirtual 924	java/io/InputStreamReader:read	([C)I
    //   87: istore_1
    //   88: iconst_m1
    //   89: iload_1
    //   90: if_icmpeq +15 -> 105
    //   93: aload 5
    //   95: aload_0
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 927	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: goto -20 -> 82
    //   105: aload 5
    //   107: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_0
    //   111: goto +22 -> 133
    //   114: iload_1
    //   115: newarray char
    //   117: astore_0
    //   118: new 94	java/lang/String
    //   121: dup
    //   122: aload_0
    //   123: iconst_0
    //   124: aload_2
    //   125: aload_0
    //   126: invokevirtual 924	java/io/InputStreamReader:read	([C)I
    //   129: invokespecial 930	java/lang/String:<init>	([CII)V
    //   132: astore_0
    //   133: aload_3
    //   134: invokevirtual 474	java/io/FileInputStream:close	()V
    //   137: aload_0
    //   138: astore_3
    //   139: aload_2
    //   140: invokevirtual 931	java/io/InputStreamReader:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: astore_0
    //   146: goto +24 -> 170
    //   149: aload_2
    //   150: astore_0
    //   151: goto +44 -> 195
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_2
    //   157: goto +13 -> 170
    //   160: aconst_null
    //   161: astore_0
    //   162: goto +33 -> 195
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore_2
    //   170: aload_3
    //   171: ifnull +10 -> 181
    //   174: aload_3
    //   175: invokevirtual 474	java/io/FileInputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 931	java/io/InputStreamReader:close	()V
    //   189: aload_0
    //   190: athrow
    //   191: aconst_null
    //   192: astore_3
    //   193: aload_3
    //   194: astore_0
    //   195: aload_3
    //   196: ifnull +10 -> 206
    //   199: aload_3
    //   200: invokevirtual 474	java/io/FileInputStream:close	()V
    //   203: goto +3 -> 206
    //   206: aload_0
    //   207: ifnull +11 -> 218
    //   210: aload 4
    //   212: astore_3
    //   213: aload_0
    //   214: astore_2
    //   215: goto -76 -> 139
    //   218: aconst_null
    //   219: areturn
    //   220: new 100	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   227: astore_2
    //   228: aload_2
    //   229: ldc_w 933
    //   232: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_2
    //   243: ldc_w 935
    //   246: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: new 203	java/io/IOException
    //   253: dup
    //   254: aload_2
    //   255: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokespecial 936	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   261: athrow
    //   262: new 100	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   269: astore_2
    //   270: aload_2
    //   271: ldc_w 933
    //   274: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: aload_0
    //   280: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: ldc_w 938
    //   288: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: new 203	java/io/IOException
    //   295: dup
    //   296: aload_2
    //   297: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokespecial 936	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   303: athrow
    //   304: new 100	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   311: astore_2
    //   312: aload_2
    //   313: ldc_w 933
    //   316: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: aload_0
    //   322: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc_w 940
    //   330: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: new 142	java/io/FileNotFoundException
    //   337: dup
    //   338: aload_2
    //   339: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 941	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   345: astore_0
    //   346: goto +5 -> 351
    //   349: aload_0
    //   350: athrow
    //   351: goto -2 -> 349
    //   354: astore_0
    //   355: goto -164 -> 191
    //   358: astore_0
    //   359: goto -199 -> 160
    //   362: astore_0
    //   363: goto -214 -> 149
    //   366: astore_3
    //   367: aload_0
    //   368: astore_3
    //   369: goto -230 -> 139
    //   372: astore_0
    //   373: aload_3
    //   374: areturn
    //   375: astore_3
    //   376: goto -195 -> 181
    //   379: astore_2
    //   380: goto -191 -> 189
    //   383: astore_2
    //   384: goto -178 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramFile	File
    //   56	59	1	i	int
    //   50	289	2	localObject1	Object
    //   379	1	2	localException1	Exception
    //   383	1	2	localException2	Exception
    //   38	175	3	localObject2	Object
    //   366	1	3	localException3	Exception
    //   368	6	3	localFile	File
    //   375	1	3	localException4	Exception
    //   1	210	4	localObject3	Object
    //   80	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	57	145	finally
    //   64	82	145	finally
    //   82	88	145	finally
    //   93	102	145	finally
    //   105	111	145	finally
    //   114	133	145	finally
    //   39	51	154	finally
    //   30	39	165	finally
    //   30	39	354	java/lang/Exception
    //   39	51	358	java/lang/Exception
    //   51	57	362	java/lang/Exception
    //   64	82	362	java/lang/Exception
    //   82	88	362	java/lang/Exception
    //   93	102	362	java/lang/Exception
    //   105	111	362	java/lang/Exception
    //   114	133	362	java/lang/Exception
    //   133	137	366	java/lang/Exception
    //   139	143	372	java/lang/Exception
    //   174	178	375	java/lang/Exception
    //   185	189	379	java/lang/Exception
    //   199	203	383	java/lang/Exception
  }
  
  /* Error */
  public static String readFileToStringEx(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 9
    //   9: aload_0
    //   10: ifnonnull +14 -> 24
    //   13: ldc 63
    //   15: iconst_1
    //   16: ldc_w 945
    //   19: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: invokevirtual 133	java/io/File:exists	()Z
    //   28: ifeq +601 -> 629
    //   31: aload_0
    //   32: invokevirtual 915	java/io/File:canRead	()Z
    //   35: ifne +6 -> 41
    //   38: goto +591 -> 629
    //   41: new 232	java/io/BufferedInputStream
    //   44: dup
    //   45: new 144	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore 5
    //   58: new 883	java/io/InputStreamReader
    //   61: dup
    //   62: aload 5
    //   64: ldc_w 917
    //   67: invokespecial 920	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   70: astore 8
    //   72: aload 5
    //   74: astore 6
    //   76: aload 8
    //   78: astore 7
    //   80: iload_1
    //   81: istore_3
    //   82: aload_0
    //   83: invokevirtual 137	java/io/File:length	()J
    //   86: l2i
    //   87: istore 4
    //   89: iload 4
    //   91: sipush 12288
    //   94: if_icmple +150 -> 244
    //   97: iload_1
    //   98: istore_2
    //   99: iload_1
    //   100: iconst_m1
    //   101: if_icmpne +32 -> 133
    //   104: aload 5
    //   106: astore 6
    //   108: aload 8
    //   110: astore 7
    //   112: iload_1
    //   113: istore_3
    //   114: iload 4
    //   116: sipush 6144
    //   119: idiv
    //   120: istore_1
    //   121: iload_1
    //   122: bipush 12
    //   124: if_icmpge +620 -> 744
    //   127: bipush 12
    //   129: istore_2
    //   130: goto +3 -> 133
    //   133: aload 5
    //   135: astore 6
    //   137: aload 8
    //   139: astore 7
    //   141: iload_2
    //   142: istore_3
    //   143: sipush 4096
    //   146: newarray char
    //   148: astore 12
    //   150: aload 5
    //   152: astore 6
    //   154: aload 8
    //   156: astore 7
    //   158: iload_2
    //   159: istore_3
    //   160: new 100	java/lang/StringBuilder
    //   163: dup
    //   164: iload_2
    //   165: sipush 1024
    //   168: imul
    //   169: invokespecial 921	java/lang/StringBuilder:<init>	(I)V
    //   172: astore 13
    //   174: aload 5
    //   176: astore 6
    //   178: aload 8
    //   180: astore 7
    //   182: iload_2
    //   183: istore_3
    //   184: aload 8
    //   186: aload 12
    //   188: invokevirtual 924	java/io/InputStreamReader:read	([C)I
    //   191: istore_1
    //   192: iconst_m1
    //   193: iload_1
    //   194: if_icmpeq +26 -> 220
    //   197: aload 5
    //   199: astore 6
    //   201: aload 8
    //   203: astore 7
    //   205: iload_2
    //   206: istore_3
    //   207: aload 13
    //   209: aload 12
    //   211: iconst_0
    //   212: iload_1
    //   213: invokevirtual 927	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: goto -43 -> 174
    //   220: aload 5
    //   222: astore 6
    //   224: aload 8
    //   226: astore 7
    //   228: iload_2
    //   229: istore_3
    //   230: aload 13
    //   232: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 12
    //   237: aload 12
    //   239: astore 6
    //   241: goto +52 -> 293
    //   244: aload 5
    //   246: astore 6
    //   248: aload 8
    //   250: astore 7
    //   252: iload_1
    //   253: istore_3
    //   254: iload 4
    //   256: newarray char
    //   258: astore 12
    //   260: aload 5
    //   262: astore 6
    //   264: aload 8
    //   266: astore 7
    //   268: iload_1
    //   269: istore_3
    //   270: new 94	java/lang/String
    //   273: dup
    //   274: aload 12
    //   276: iconst_0
    //   277: aload 8
    //   279: aload 12
    //   281: invokevirtual 924	java/io/InputStreamReader:read	([C)I
    //   284: invokespecial 930	java/lang/String:<init>	([CII)V
    //   287: astore 12
    //   289: aload 12
    //   291: astore 6
    //   293: aload 5
    //   295: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   298: aload 8
    //   300: astore_0
    //   301: aload_0
    //   302: invokevirtual 931	java/io/InputStreamReader:close	()V
    //   305: aload 6
    //   307: areturn
    //   308: astore 6
    //   310: aload 8
    //   312: astore_0
    //   313: aload 6
    //   315: astore 8
    //   317: goto +183 -> 500
    //   320: astore_0
    //   321: aconst_null
    //   322: astore 7
    //   324: goto +280 -> 604
    //   327: aconst_null
    //   328: astore 6
    //   330: aload 5
    //   332: astore 9
    //   334: aload 6
    //   336: astore 5
    //   338: goto +28 -> 366
    //   341: astore 8
    //   343: aconst_null
    //   344: astore_0
    //   345: goto +155 -> 500
    //   348: astore_0
    //   349: aconst_null
    //   350: astore 5
    //   352: aload 5
    //   354: astore 7
    //   356: goto +248 -> 604
    //   359: aconst_null
    //   360: astore 9
    //   362: aload 9
    //   364: astore 5
    //   366: aload 9
    //   368: astore 6
    //   370: aload 5
    //   372: astore 7
    //   374: new 100	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   381: astore 8
    //   383: aload 9
    //   385: astore 6
    //   387: aload 5
    //   389: astore 7
    //   391: aload 8
    //   393: ldc_w 947
    //   396: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 9
    //   402: astore 6
    //   404: aload 5
    //   406: astore 7
    //   408: aload 8
    //   410: aload_0
    //   411: invokevirtual 280	java/io/File:getName	()Ljava/lang/String;
    //   414: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 9
    //   420: astore 6
    //   422: aload 5
    //   424: astore 7
    //   426: ldc 63
    //   428: iconst_1
    //   429: aload 8
    //   431: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 11
    //   439: astore 6
    //   441: iload_1
    //   442: iconst_m1
    //   443: if_icmpne +21 -> 464
    //   446: aload 9
    //   448: astore 6
    //   450: aload 5
    //   452: astore 7
    //   454: aload_0
    //   455: bipush 6
    //   457: invokestatic 949	com/tencent/mobileqq/utils/FileUtils:readFileToStringEx	(Ljava/io/File;I)Ljava/lang/String;
    //   460: astore_0
    //   461: aload_0
    //   462: astore 6
    //   464: aload 9
    //   466: ifnull +11 -> 477
    //   469: aload 9
    //   471: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   474: goto +3 -> 477
    //   477: aload 6
    //   479: astore 7
    //   481: aload 5
    //   483: ifnull +113 -> 596
    //   486: aload 5
    //   488: astore_0
    //   489: goto -188 -> 301
    //   492: astore 8
    //   494: aconst_null
    //   495: astore 5
    //   497: aload 5
    //   499: astore_0
    //   500: aload 5
    //   502: astore 6
    //   504: aload_0
    //   505: astore 7
    //   507: new 100	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   514: astore 11
    //   516: aload 5
    //   518: astore 6
    //   520: aload_0
    //   521: astore 7
    //   523: aload 11
    //   525: ldc_w 951
    //   528: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 5
    //   534: astore 6
    //   536: aload_0
    //   537: astore 7
    //   539: aload 11
    //   541: aload 8
    //   543: invokevirtual 952	java/lang/Exception:toString	()Ljava/lang/String;
    //   546: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload 5
    //   552: astore 6
    //   554: aload_0
    //   555: astore 7
    //   557: ldc 63
    //   559: iconst_1
    //   560: aload 11
    //   562: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: aload 5
    //   570: ifnull +11 -> 581
    //   573: aload 5
    //   575: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   578: goto +3 -> 581
    //   581: aload 10
    //   583: astore 7
    //   585: aload_0
    //   586: ifnull +10 -> 596
    //   589: aload 9
    //   591: astore 6
    //   593: goto -292 -> 301
    //   596: aload 7
    //   598: areturn
    //   599: astore_0
    //   600: aload 6
    //   602: astore 5
    //   604: aload 5
    //   606: ifnull +11 -> 617
    //   609: aload 5
    //   611: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   614: goto +3 -> 617
    //   617: aload 7
    //   619: ifnull +8 -> 627
    //   622: aload 7
    //   624: invokevirtual 931	java/io/InputStreamReader:close	()V
    //   627: aload_0
    //   628: athrow
    //   629: new 100	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   636: astore 5
    //   638: aload 5
    //   640: ldc_w 954
    //   643: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload 5
    //   649: aload_0
    //   650: invokevirtual 133	java/io/File:exists	()Z
    //   653: invokevirtual 686	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 5
    //   659: ldc_w 956
    //   662: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 5
    //   668: aload_0
    //   669: invokevirtual 915	java/io/File:canRead	()Z
    //   672: invokevirtual 686	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: ldc 63
    //   678: iconst_1
    //   679: aload 5
    //   681: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: aconst_null
    //   688: areturn
    //   689: astore 5
    //   691: goto -332 -> 359
    //   694: astore 6
    //   696: goto -369 -> 327
    //   699: astore 6
    //   701: aload 5
    //   703: astore 9
    //   705: aload 8
    //   707: astore 5
    //   709: iload_3
    //   710: istore_1
    //   711: goto -345 -> 366
    //   714: astore_0
    //   715: aload 8
    //   717: astore_0
    //   718: goto -417 -> 301
    //   721: astore_0
    //   722: aload 6
    //   724: areturn
    //   725: astore_0
    //   726: goto -249 -> 477
    //   729: astore 5
    //   731: goto -150 -> 581
    //   734: astore 5
    //   736: goto -119 -> 617
    //   739: astore 5
    //   741: goto -114 -> 627
    //   744: iload_1
    //   745: istore_2
    //   746: iload_1
    //   747: bipush 60
    //   749: if_icmple -616 -> 133
    //   752: bipush 60
    //   754: istore_2
    //   755: goto -622 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramFile	File
    //   0	758	1	paramInt	int
    //   98	657	2	i	int
    //   81	629	3	j	int
    //   87	168	4	k	int
    //   56	624	5	localObject1	Object
    //   689	13	5	localOutOfMemoryError1	OutOfMemoryError
    //   707	1	5	localObject2	Object
    //   729	1	5	localException1	Exception
    //   734	1	5	localException2	Exception
    //   739	1	5	localException3	Exception
    //   74	232	6	localObject3	Object
    //   308	6	6	localException4	Exception
    //   328	273	6	localObject4	Object
    //   694	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   699	24	6	localOutOfMemoryError3	OutOfMemoryError
    //   78	545	7	localObject5	Object
    //   70	246	8	localObject6	Object
    //   341	1	8	localException5	Exception
    //   381	49	8	localStringBuilder1	StringBuilder
    //   492	224	8	localException6	Exception
    //   7	697	9	localObject7	Object
    //   4	578	10	localObject8	Object
    //   1	560	11	localStringBuilder2	StringBuilder
    //   148	142	12	localObject9	Object
    //   172	59	13	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   82	89	308	java/lang/Exception
    //   114	121	308	java/lang/Exception
    //   143	150	308	java/lang/Exception
    //   160	174	308	java/lang/Exception
    //   184	192	308	java/lang/Exception
    //   207	217	308	java/lang/Exception
    //   230	237	308	java/lang/Exception
    //   254	260	308	java/lang/Exception
    //   270	289	308	java/lang/Exception
    //   58	72	320	finally
    //   58	72	341	java/lang/Exception
    //   41	58	348	finally
    //   41	58	492	java/lang/Exception
    //   82	89	599	finally
    //   114	121	599	finally
    //   143	150	599	finally
    //   160	174	599	finally
    //   184	192	599	finally
    //   207	217	599	finally
    //   230	237	599	finally
    //   254	260	599	finally
    //   270	289	599	finally
    //   374	383	599	finally
    //   391	400	599	finally
    //   408	418	599	finally
    //   426	437	599	finally
    //   454	461	599	finally
    //   507	516	599	finally
    //   523	532	599	finally
    //   539	550	599	finally
    //   557	568	599	finally
    //   41	58	689	java/lang/OutOfMemoryError
    //   58	72	694	java/lang/OutOfMemoryError
    //   82	89	699	java/lang/OutOfMemoryError
    //   114	121	699	java/lang/OutOfMemoryError
    //   143	150	699	java/lang/OutOfMemoryError
    //   160	174	699	java/lang/OutOfMemoryError
    //   184	192	699	java/lang/OutOfMemoryError
    //   207	217	699	java/lang/OutOfMemoryError
    //   230	237	699	java/lang/OutOfMemoryError
    //   254	260	699	java/lang/OutOfMemoryError
    //   270	289	699	java/lang/OutOfMemoryError
    //   293	298	714	java/lang/Exception
    //   301	305	721	java/lang/Exception
    //   469	474	725	java/lang/Exception
    //   573	578	729	java/lang/Exception
    //   609	614	734	java/lang/Exception
    //   622	627	739	java/lang/Exception
  }
  
  /* Error */
  public static Object readObject(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 959	java/io/ObjectInputStream
    //   12: dup
    //   13: new 232	java/io/BufferedInputStream
    //   16: dup
    //   17: invokestatic 965	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: aload_0
    //   21: invokevirtual 969	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   24: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: invokespecial 970	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 973	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_2
    //   39: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   42: aload_3
    //   43: areturn
    //   44: astore_3
    //   45: goto +12 -> 57
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_1
    //   51: goto +92 -> 143
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +70 -> 132
    //   65: aload_2
    //   66: astore_1
    //   67: new 100	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   74: astore 4
    //   76: aload_2
    //   77: astore_1
    //   78: aload 4
    //   80: ldc_w 976
    //   83: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: astore_1
    //   89: aload 4
    //   91: aload_0
    //   92: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_2
    //   97: astore_1
    //   98: aload 4
    //   100: ldc_w 978
    //   103: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_2
    //   108: astore_1
    //   109: aload 4
    //   111: aload_3
    //   112: invokevirtual 952	java/lang/Exception:toString	()Ljava/lang/String;
    //   115: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: astore_1
    //   121: ldc 63
    //   123: iconst_2
    //   124: aload 4
    //   126: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 980	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: aload_3
    //   155: areturn
    //   156: astore_0
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: goto -9 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramString	String
    //   32	116	1	localObjectInputStream1	java.io.ObjectInputStream
    //   159	1	1	localIOException	IOException
    //   30	107	2	localObjectInputStream2	java.io.ObjectInputStream
    //   37	6	3	localObject	Object
    //   44	1	3	localException1	Exception
    //   54	101	3	localException2	Exception
    //   74	51	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   33	38	44	java/lang/Exception
    //   9	31	48	finally
    //   9	31	54	java/lang/Exception
    //   33	38	142	finally
    //   59	65	142	finally
    //   67	76	142	finally
    //   78	87	142	finally
    //   89	96	142	finally
    //   98	107	142	finally
    //   109	119	142	finally
    //   121	132	142	finally
    //   38	42	153	java/io/IOException
    //   136	140	156	java/io/IOException
    //   147	151	159	java/io/IOException
  }
  
  /* Error */
  public static Object[] readObjectList(String paramString, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: new 959	java/io/ObjectInputStream
    //   8: dup
    //   9: new 232	java/io/BufferedInputStream
    //   12: dup
    //   13: invokestatic 965	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: aload_0
    //   17: invokevirtual 969	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   20: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: invokespecial 970	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore 5
    //   28: aload 5
    //   30: astore 4
    //   32: aload_1
    //   33: arraylength
    //   34: anewarray 4	java/lang/Object
    //   37: astore 7
    //   39: iconst_0
    //   40: istore_2
    //   41: aload 5
    //   43: astore 4
    //   45: iload_2
    //   46: aload_1
    //   47: arraylength
    //   48: if_icmpge +136 -> 184
    //   51: aload_1
    //   52: iload_2
    //   53: aaload
    //   54: astore 4
    //   56: aload 4
    //   58: ldc_w 984
    //   61: if_acmpne +22 -> 83
    //   64: aload 5
    //   66: astore 4
    //   68: aload 7
    //   70: iload_2
    //   71: aload 5
    //   73: invokevirtual 988	java/io/ObjectInputStream:readByte	()B
    //   76: invokestatic 991	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   79: aastore
    //   80: goto +97 -> 177
    //   83: aload 4
    //   85: ldc_w 792
    //   88: if_acmpne +22 -> 110
    //   91: aload 5
    //   93: astore 4
    //   95: aload 7
    //   97: iload_2
    //   98: aload 5
    //   100: invokevirtual 994	java/io/ObjectInputStream:readBoolean	()Z
    //   103: invokestatic 997	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   106: aastore
    //   107: goto +70 -> 177
    //   110: aload 4
    //   112: ldc_w 481
    //   115: if_acmpne +22 -> 137
    //   118: aload 5
    //   120: astore 4
    //   122: aload 7
    //   124: iload_2
    //   125: aload 5
    //   127: invokevirtual 1000	java/io/ObjectInputStream:readInt	()I
    //   130: invokestatic 1003	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: goto +43 -> 177
    //   137: aload 4
    //   139: ldc_w 1005
    //   142: if_acmpne +22 -> 164
    //   145: aload 5
    //   147: astore 4
    //   149: aload 7
    //   151: iload_2
    //   152: aload 5
    //   154: invokevirtual 1008	java/io/ObjectInputStream:readLong	()J
    //   157: invokestatic 1011	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   160: aastore
    //   161: goto +16 -> 177
    //   164: aload 5
    //   166: astore 4
    //   168: aload 7
    //   170: iload_2
    //   171: aload 5
    //   173: invokevirtual 973	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   176: aastore
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: istore_2
    //   181: goto -140 -> 41
    //   184: aload 5
    //   186: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   189: iconst_1
    //   190: istore_2
    //   191: aload 7
    //   193: astore_0
    //   194: goto +122 -> 316
    //   197: astore 4
    //   199: aload 5
    //   201: astore_1
    //   202: aload 4
    //   204: astore 5
    //   206: goto +14 -> 220
    //   209: astore_0
    //   210: aconst_null
    //   211: astore 4
    //   213: goto +115 -> 328
    //   216: astore 5
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_1
    //   221: astore 4
    //   223: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +78 -> 304
    //   229: aload_1
    //   230: astore 4
    //   232: new 100	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   239: astore 7
    //   241: aload_1
    //   242: astore 4
    //   244: aload 7
    //   246: ldc_w 1013
    //   249: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: astore 4
    //   256: aload 7
    //   258: aload_0
    //   259: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_1
    //   264: astore 4
    //   266: aload 7
    //   268: ldc_w 1015
    //   271: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_1
    //   276: astore 4
    //   278: aload 7
    //   280: aload 5
    //   282: invokevirtual 1016	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   285: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_1
    //   290: astore 4
    //   292: ldc_w 1018
    //   295: iconst_2
    //   296: aload 7
    //   298: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload_1
    //   305: ifnull +7 -> 312
    //   308: aload_1
    //   309: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   312: aconst_null
    //   313: astore_0
    //   314: iload_3
    //   315: istore_2
    //   316: aload 6
    //   318: astore_1
    //   319: iload_2
    //   320: ifeq +5 -> 325
    //   323: aload_0
    //   324: astore_1
    //   325: aload_1
    //   326: areturn
    //   327: astore_0
    //   328: aload 4
    //   330: ifnull +8 -> 338
    //   333: aload 4
    //   335: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   338: goto +5 -> 343
    //   341: aload_0
    //   342: athrow
    //   343: goto -2 -> 341
    //   346: astore_0
    //   347: goto -158 -> 189
    //   350: astore_0
    //   351: goto -39 -> 312
    //   354: astore_1
    //   355: goto -17 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramString	String
    //   0	358	1	paramArrayOfClass	Class[]
    //   40	280	2	i	int
    //   1	314	3	j	int
    //   30	137	4	localObject1	Object
    //   197	6	4	localException1	Exception
    //   211	123	4	arrayOfClass	Class[]
    //   26	179	5	localObject2	Object
    //   216	65	5	localException2	Exception
    //   3	314	6	localObject3	Object
    //   37	260	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   32	39	197	java/lang/Exception
    //   45	51	197	java/lang/Exception
    //   68	80	197	java/lang/Exception
    //   95	107	197	java/lang/Exception
    //   122	134	197	java/lang/Exception
    //   149	161	197	java/lang/Exception
    //   168	177	197	java/lang/Exception
    //   5	28	209	finally
    //   5	28	216	java/lang/Exception
    //   32	39	327	finally
    //   45	51	327	finally
    //   68	80	327	finally
    //   95	107	327	finally
    //   122	134	327	finally
    //   149	161	327	finally
    //   168	177	327	finally
    //   223	229	327	finally
    //   232	241	327	finally
    //   244	253	327	finally
    //   256	263	327	finally
    //   266	275	327	finally
    //   278	289	327	finally
    //   292	304	327	finally
    //   184	189	346	java/io/IOException
    //   308	312	350	java/io/IOException
    //   333	338	354	java/io/IOException
  }
  
  /* Error */
  public static String readStringFromAsset(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 965	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 1020	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_0
    //   11: invokevirtual 236	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: astore_1
    //   17: aload_0
    //   18: astore_2
    //   19: aload_0
    //   20: invokestatic 1022	com/tencent/mobileqq/utils/FileUtils:readFile	(Ljava/io/InputStream;)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_1
    //   26: aload_0
    //   27: ifnull +69 -> 96
    //   30: aload_0
    //   31: invokevirtual 531	java/io/InputStream:close	()V
    //   34: aload_3
    //   35: areturn
    //   36: astore_0
    //   37: aload_3
    //   38: astore_1
    //   39: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +54 -> 96
    //   45: aload_0
    //   46: invokevirtual 588	java/lang/Exception:printStackTrace	()V
    //   49: aload_3
    //   50: areturn
    //   51: astore_0
    //   52: goto +46 -> 98
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +9 -> 70
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   70: aload_2
    //   71: ifnull +21 -> 92
    //   74: aload_2
    //   75: invokevirtual 531	java/io/InputStream:close	()V
    //   78: goto +14 -> 92
    //   81: astore_0
    //   82: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 588	java/lang/Exception:printStackTrace	()V
    //   92: ldc_w 477
    //   95: astore_1
    //   96: aload_1
    //   97: areturn
    //   98: aload_1
    //   99: ifnull +21 -> 120
    //   102: aload_1
    //   103: invokevirtual 531	java/io/InputStream:close	()V
    //   106: goto +14 -> 120
    //   109: astore_1
    //   110: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 588	java/lang/Exception:printStackTrace	()V
    //   120: aload_0
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramString	String
    //   3	100	1	localObject	Object
    //   109	8	1	localException	Exception
    //   1	74	2	str1	String
    //   23	27	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   30	34	36	java/lang/Exception
    //   4	15	51	finally
    //   19	24	51	finally
    //   58	64	51	finally
    //   66	70	51	finally
    //   4	15	55	java/io/IOException
    //   19	24	55	java/io/IOException
    //   74	78	81	java/lang/Exception
    //   102	106	109	java/lang/Exception
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = new File(paramString1);
      bool1 = bool2;
      if (paramString1.exists()) {
        bool1 = paramString1.renameTo(new File(paramString2));
      }
    }
    return bool1;
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2)
  {
    boolean bool1;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  /* Error */
  public static boolean saveBitmapToFile(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +132 -> 133
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: new 1028	java/io/BufferedOutputStream
    //   18: dup
    //   19: new 229	java/io/FileOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 230	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   27: ldc_w 1029
    //   30: invokespecial 1032	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   33: astore_1
    //   34: aload_0
    //   35: getstatic 1035	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   38: bipush 70
    //   40: aload_1
    //   41: invokevirtual 402	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   44: istore_2
    //   45: aload_1
    //   46: invokevirtual 1036	java/io/OutputStream:flush	()V
    //   49: aload_1
    //   50: invokevirtual 251	java/io/OutputStream:close	()V
    //   53: iload_2
    //   54: ireturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   60: iload_2
    //   61: ireturn
    //   62: astore_0
    //   63: aload_1
    //   64: astore_3
    //   65: goto +46 -> 111
    //   68: astore_3
    //   69: aload_1
    //   70: astore_0
    //   71: aload_3
    //   72: astore_1
    //   73: goto +11 -> 84
    //   76: astore_0
    //   77: goto +34 -> 111
    //   80: astore_1
    //   81: aload 4
    //   83: astore_0
    //   84: aload_0
    //   85: astore_3
    //   86: aload_1
    //   87: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   90: aload_0
    //   91: ifnull +18 -> 109
    //   94: aload_0
    //   95: invokevirtual 1036	java/io/OutputStream:flush	()V
    //   98: aload_0
    //   99: invokevirtual 251	java/io/OutputStream:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: aload_3
    //   112: ifnull +19 -> 131
    //   115: aload_3
    //   116: invokevirtual 1036	java/io/OutputStream:flush	()V
    //   119: aload_3
    //   120: invokevirtual 251	java/io/OutputStream:close	()V
    //   123: goto +8 -> 131
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   131: aload_0
    //   132: athrow
    //   133: iconst_0
    //   134: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramBitmap	android.graphics.Bitmap
    //   0	135	1	paramString	String
    //   44	17	2	bool	boolean
    //   14	51	3	str	String
    //   68	4	3	localIOException	IOException
    //   85	35	3	localBitmap	android.graphics.Bitmap
    //   11	71	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   45	53	55	java/io/IOException
    //   34	45	62	finally
    //   34	45	68	java/io/IOException
    //   15	34	76	finally
    //   86	90	76	finally
    //   15	34	80	java/io/IOException
    //   94	102	104	java/io/IOException
    //   115	123	126	java/io/IOException
  }
  
  /* Error */
  public static boolean saveBitmapToFile(android.graphics.Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +136 -> 137
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 4
    //   16: new 1028	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 229	java/io/FileOutputStream
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 230	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   28: ldc_w 1029
    //   31: invokespecial 1032	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   34: astore_1
    //   35: aload_0
    //   36: aload_2
    //   37: bipush 70
    //   39: aload_1
    //   40: invokevirtual 402	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   43: istore_3
    //   44: aload_1
    //   45: invokevirtual 1036	java/io/OutputStream:flush	()V
    //   48: aload_1
    //   49: invokevirtual 251	java/io/OutputStream:close	()V
    //   52: iload_3
    //   53: ireturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   59: iload_3
    //   60: ireturn
    //   61: astore_0
    //   62: aload_1
    //   63: astore 4
    //   65: goto +47 -> 112
    //   68: astore_2
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: astore_1
    //   73: goto +11 -> 84
    //   76: astore_0
    //   77: goto +35 -> 112
    //   80: astore_1
    //   81: aload 5
    //   83: astore_0
    //   84: aload_0
    //   85: astore 4
    //   87: aload_1
    //   88: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   91: aload_0
    //   92: ifnull +18 -> 110
    //   95: aload_0
    //   96: invokevirtual 1036	java/io/OutputStream:flush	()V
    //   99: aload_0
    //   100: invokevirtual 251	java/io/OutputStream:close	()V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   110: iconst_0
    //   111: ireturn
    //   112: aload 4
    //   114: ifnull +21 -> 135
    //   117: aload 4
    //   119: invokevirtual 1036	java/io/OutputStream:flush	()V
    //   122: aload 4
    //   124: invokevirtual 251	java/io/OutputStream:close	()V
    //   127: goto +8 -> 135
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   135: aload_0
    //   136: athrow
    //   137: iconst_0
    //   138: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramBitmap	android.graphics.Bitmap
    //   0	139	1	paramString	String
    //   0	139	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   43	17	3	bool	boolean
    //   14	109	4	localObject1	Object
    //   11	71	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	52	54	java/io/IOException
    //   35	44	61	finally
    //   35	44	68	java/io/IOException
    //   16	35	76	finally
    //   87	91	76	finally
    //   16	35	80	java/io/IOException
    //   95	103	105	java/io/IOException
    //   117	127	130	java/io/IOException
  }
  
  /* Error */
  public static String saveFileUriToFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iload 5
    //   11: ifne +695 -> 706
    //   14: aload_0
    //   15: ifnonnull +6 -> 21
    //   18: goto +688 -> 706
    //   21: aload_1
    //   22: invokestatic 1045	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: astore 7
    //   27: aload_0
    //   28: invokevirtual 1049	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload 7
    //   33: ldc_w 1051
    //   36: invokevirtual 1057	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   39: astore 8
    //   41: goto +19 -> 60
    //   44: astore 7
    //   46: ldc 63
    //   48: iconst_1
    //   49: ldc_w 1059
    //   52: aload 7
    //   54: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   57: aconst_null
    //   58: astore 8
    //   60: aload 8
    //   62: ifnonnull +14 -> 76
    //   65: ldc 63
    //   67: iconst_1
    //   68: ldc_w 1061
    //   71: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aconst_null
    //   75: areturn
    //   76: aload_1
    //   77: getstatic 218	java/io/File:separator	Ljava/lang/String;
    //   80: invokevirtual 601	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   83: istore_3
    //   84: iload_3
    //   85: iconst_m1
    //   86: if_icmpne +14 -> 100
    //   89: iload_3
    //   90: aload_1
    //   91: invokevirtual 440	java/lang/String:length	()I
    //   94: if_icmpge +6 -> 100
    //   97: goto +11 -> 108
    //   100: aload_1
    //   101: iload_3
    //   102: iconst_1
    //   103: iadd
    //   104: invokevirtual 604	java/lang/String:substring	(I)Ljava/lang/String;
    //   107: astore_1
    //   108: new 100	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   115: astore 7
    //   117: aload 7
    //   119: aload_0
    //   120: aconst_null
    //   121: invokevirtual 1064	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   124: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 7
    //   130: getstatic 218	java/io/File:separator	Ljava/lang/String;
    //   133: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 7
    //   139: aload_2
    //   140: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: getstatic 218	java/io/File:separator	Ljava/lang/String;
    //   149: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 7
    //   155: aload_1
    //   156: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 7
    //   162: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: iconst_0
    //   168: istore 4
    //   170: ldc 63
    //   172: iconst_1
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: ldc_w 1066
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload 9
    //   187: aastore
    //   188: invokestatic 1068	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   191: new 128	java/io/File
    //   194: dup
    //   195: aload 9
    //   197: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 133	java/io/File:exists	()Z
    //   205: ifeq +8 -> 213
    //   208: aload_0
    //   209: invokevirtual 283	java/io/File:delete	()Z
    //   212: pop
    //   213: aload_0
    //   214: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   217: ifnull +21 -> 238
    //   220: aload_0
    //   221: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   224: invokevirtual 133	java/io/File:exists	()Z
    //   227: ifne +11 -> 238
    //   230: aload_0
    //   231: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   234: invokevirtual 224	java/io/File:mkdirs	()Z
    //   237: pop
    //   238: new 229	java/io/FileOutputStream
    //   241: dup
    //   242: aload_0
    //   243: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   246: astore_0
    //   247: new 232	java/io/BufferedInputStream
    //   250: dup
    //   251: new 144	java/io/FileInputStream
    //   254: dup
    //   255: aload 8
    //   257: invokevirtual 1074	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   260: invokespecial 1077	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   263: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   266: astore_1
    //   267: ldc_w 1078
    //   270: newarray byte
    //   272: astore_2
    //   273: aload_1
    //   274: aload_2
    //   275: invokevirtual 243	java/io/BufferedInputStream:read	([B)I
    //   278: istore_3
    //   279: iload_3
    //   280: iconst_m1
    //   281: if_icmpeq +17 -> 298
    //   284: aload_0
    //   285: aload_2
    //   286: iconst_0
    //   287: iload_3
    //   288: invokevirtual 331	java/io/FileOutputStream:write	([BII)V
    //   291: aload_0
    //   292: invokevirtual 334	java/io/FileOutputStream:flush	()V
    //   295: goto -22 -> 273
    //   298: aload 8
    //   300: ifnull +22 -> 322
    //   303: aload 8
    //   305: invokevirtual 1079	android/os/ParcelFileDescriptor:close	()V
    //   308: goto +14 -> 322
    //   311: astore_2
    //   312: ldc 63
    //   314: iconst_1
    //   315: ldc_w 1081
    //   318: aload_2
    //   319: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   322: aload_0
    //   323: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   326: goto +14 -> 340
    //   329: astore_0
    //   330: ldc 63
    //   332: iconst_1
    //   333: ldc_w 1081
    //   336: aload_0
    //   337: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_1
    //   341: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   344: goto +14 -> 358
    //   347: astore_0
    //   348: ldc 63
    //   350: iconst_1
    //   351: ldc_w 1081
    //   354: aload_0
    //   355: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: iconst_1
    //   359: istore_3
    //   360: goto +259 -> 619
    //   363: astore 6
    //   365: aload_0
    //   366: astore_2
    //   367: aload 6
    //   369: astore_0
    //   370: goto +264 -> 634
    //   373: astore 7
    //   375: aload_0
    //   376: astore_2
    //   377: aload_1
    //   378: astore_0
    //   379: goto +62 -> 441
    //   382: astore 7
    //   384: aload_0
    //   385: astore_2
    //   386: aload_1
    //   387: astore_0
    //   388: goto +138 -> 526
    //   391: astore 7
    //   393: aload 6
    //   395: astore_1
    //   396: aload_0
    //   397: astore_2
    //   398: aload 7
    //   400: astore_0
    //   401: goto +233 -> 634
    //   404: astore 7
    //   406: aconst_null
    //   407: astore_1
    //   408: aload_0
    //   409: astore_2
    //   410: aload_1
    //   411: astore_0
    //   412: goto +29 -> 441
    //   415: astore 7
    //   417: aconst_null
    //   418: astore_1
    //   419: aload_0
    //   420: astore_2
    //   421: aload_1
    //   422: astore_0
    //   423: goto +103 -> 526
    //   426: astore_0
    //   427: aconst_null
    //   428: astore_2
    //   429: aload 6
    //   431: astore_1
    //   432: goto +202 -> 634
    //   435: astore 7
    //   437: aconst_null
    //   438: astore_2
    //   439: aload_2
    //   440: astore_0
    //   441: aload_2
    //   442: astore_1
    //   443: aload_0
    //   444: astore 6
    //   446: ldc 63
    //   448: iconst_1
    //   449: ldc_w 1083
    //   452: aload 7
    //   454: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   457: aload 8
    //   459: ifnull +22 -> 481
    //   462: aload 8
    //   464: invokevirtual 1079	android/os/ParcelFileDescriptor:close	()V
    //   467: goto +14 -> 481
    //   470: astore_1
    //   471: ldc 63
    //   473: iconst_1
    //   474: ldc_w 1081
    //   477: aload_1
    //   478: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: aload_2
    //   482: ifnull +21 -> 503
    //   485: aload_2
    //   486: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   489: goto +14 -> 503
    //   492: astore_1
    //   493: ldc 63
    //   495: iconst_1
    //   496: ldc_w 1081
    //   499: aload_1
    //   500: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   503: iload 4
    //   505: istore_3
    //   506: aload_0
    //   507: ifnull +112 -> 619
    //   510: aload_0
    //   511: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   514: iload 4
    //   516: istore_3
    //   517: goto +102 -> 619
    //   520: astore 7
    //   522: aconst_null
    //   523: astore_2
    //   524: aload_2
    //   525: astore_0
    //   526: aload_2
    //   527: astore_1
    //   528: aload_0
    //   529: astore 6
    //   531: ldc 63
    //   533: iconst_1
    //   534: ldc_w 1085
    //   537: aload 7
    //   539: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   542: aload 8
    //   544: ifnull +22 -> 566
    //   547: aload 8
    //   549: invokevirtual 1079	android/os/ParcelFileDescriptor:close	()V
    //   552: goto +14 -> 566
    //   555: astore_1
    //   556: ldc 63
    //   558: iconst_1
    //   559: ldc_w 1081
    //   562: aload_1
    //   563: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   566: aload_2
    //   567: ifnull +21 -> 588
    //   570: aload_2
    //   571: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   574: goto +14 -> 588
    //   577: astore_1
    //   578: ldc 63
    //   580: iconst_1
    //   581: ldc_w 1081
    //   584: aload_1
    //   585: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: iload 4
    //   590: istore_3
    //   591: aload_0
    //   592: ifnull +27 -> 619
    //   595: aload_0
    //   596: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   599: iload 4
    //   601: istore_3
    //   602: goto +17 -> 619
    //   605: astore_0
    //   606: ldc 63
    //   608: iconst_1
    //   609: ldc_w 1081
    //   612: aload_0
    //   613: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   616: iload 4
    //   618: istore_3
    //   619: iload_3
    //   620: ifeq +6 -> 626
    //   623: aload 9
    //   625: areturn
    //   626: aconst_null
    //   627: areturn
    //   628: astore_0
    //   629: aload_1
    //   630: astore_2
    //   631: aload 6
    //   633: astore_1
    //   634: aload 8
    //   636: ifnull +24 -> 660
    //   639: aload 8
    //   641: invokevirtual 1079	android/os/ParcelFileDescriptor:close	()V
    //   644: goto +16 -> 660
    //   647: astore 6
    //   649: ldc 63
    //   651: iconst_1
    //   652: ldc_w 1081
    //   655: aload 6
    //   657: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   660: aload_2
    //   661: ifnull +21 -> 682
    //   664: aload_2
    //   665: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   668: goto +14 -> 682
    //   671: astore_2
    //   672: ldc 63
    //   674: iconst_1
    //   675: ldc_w 1081
    //   678: aload_2
    //   679: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   682: aload_1
    //   683: ifnull +21 -> 704
    //   686: aload_1
    //   687: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   690: goto +14 -> 704
    //   693: astore_1
    //   694: ldc 63
    //   696: iconst_1
    //   697: ldc_w 1081
    //   700: aload_1
    //   701: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   704: aload_0
    //   705: athrow
    //   706: ldc 63
    //   708: iconst_1
    //   709: ldc_w 1087
    //   712: invokestatic 449	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: aconst_null
    //   716: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	paramContext	Context
    //   0	717	1	paramString1	String
    //   0	717	2	paramString2	String
    //   83	537	3	i	int
    //   168	449	4	j	int
    //   4	6	5	bool	boolean
    //   7	1	6	localObject1	Object
    //   363	67	6	localObject2	Object
    //   444	188	6	localContext	Context
    //   647	9	6	localIOException1	IOException
    //   25	7	7	localUri	android.net.Uri
    //   44	9	7	localException	Exception
    //   115	46	7	localStringBuilder	StringBuilder
    //   373	1	7	localOutOfMemoryError1	OutOfMemoryError
    //   382	1	7	localIOException2	IOException
    //   391	8	7	localObject3	Object
    //   404	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   415	1	7	localIOException3	IOException
    //   435	18	7	localOutOfMemoryError3	OutOfMemoryError
    //   520	18	7	localIOException4	IOException
    //   39	601	8	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   165	459	9	str	String
    // Exception table:
    //   from	to	target	type
    //   27	41	44	java/lang/Exception
    //   303	308	311	java/io/IOException
    //   322	326	329	java/io/IOException
    //   340	344	347	java/io/IOException
    //   267	273	363	finally
    //   273	279	363	finally
    //   284	295	363	finally
    //   267	273	373	java/lang/OutOfMemoryError
    //   273	279	373	java/lang/OutOfMemoryError
    //   284	295	373	java/lang/OutOfMemoryError
    //   267	273	382	java/io/IOException
    //   273	279	382	java/io/IOException
    //   284	295	382	java/io/IOException
    //   247	267	391	finally
    //   247	267	404	java/lang/OutOfMemoryError
    //   247	267	415	java/io/IOException
    //   201	213	426	finally
    //   213	238	426	finally
    //   238	247	426	finally
    //   201	213	435	java/lang/OutOfMemoryError
    //   213	238	435	java/lang/OutOfMemoryError
    //   238	247	435	java/lang/OutOfMemoryError
    //   462	467	470	java/io/IOException
    //   485	489	492	java/io/IOException
    //   201	213	520	java/io/IOException
    //   213	238	520	java/io/IOException
    //   238	247	520	java/io/IOException
    //   547	552	555	java/io/IOException
    //   570	574	577	java/io/IOException
    //   510	514	605	java/io/IOException
    //   595	599	605	java/io/IOException
    //   446	457	628	finally
    //   531	542	628	finally
    //   639	644	647	java/io/IOException
    //   664	668	671	java/io/IOException
    //   686	690	693	java/io/IOException
  }
  
  public static void uncompressZip(String paramString1, String paramString2, boolean paramBoolean)
  {
    uncompressZip(paramString1, paramString2, paramBoolean, null);
  }
  
  public static void uncompressZip(String paramString1, String paramString2, boolean paramBoolean, @NonNull Pattern paramPattern)
  {
    uncompressZip(paramString1, paramString2, paramBoolean, paramPattern, null);
  }
  
  /* Error */
  public static void uncompressZip(String paramString1, String paramString2, boolean paramBoolean, @NonNull Pattern paramPattern, @NonNull List<File> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: iconst_0
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 7
    //   12: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: istore 10
    //   17: iload 10
    //   19: ifeq +55 -> 74
    //   22: new 100	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   29: astore 11
    //   31: aload 11
    //   33: ldc_w 1099
    //   36: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 11
    //   42: aload_0
    //   43: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 11
    //   49: ldc_w 1101
    //   52: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 11
    //   58: aload_1
    //   59: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 63
    //   65: iconst_2
    //   66: aload 11
    //   68: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: new 144	java/io/FileInputStream
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 145	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   82: astore 11
    //   84: new 232	java/io/BufferedInputStream
    //   87: dup
    //   88: aload 11
    //   90: invokespecial 239	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore 15
    //   95: new 1103	com/tencent/commonsdk/zip/QZipInputStream
    //   98: dup
    //   99: aload 15
    //   101: invokespecial 1104	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: astore 17
    //   106: new 128	java/io/File
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 224	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   121: sipush 8192
    //   124: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   127: astore 18
    //   129: aconst_null
    //   130: astore_0
    //   131: aload 13
    //   133: astore 12
    //   135: aload 17
    //   137: invokevirtual 1108	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   140: astore 13
    //   142: aload 13
    //   144: ifnonnull +48 -> 192
    //   147: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   150: aload 18
    //   152: invokevirtual 338	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   155: aload 17
    //   157: invokevirtual 1109	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   160: aload 15
    //   162: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   165: aload 11
    //   167: invokevirtual 474	java/io/FileInputStream:close	()V
    //   170: aload 12
    //   172: ifnull +11 -> 183
    //   175: aload 12
    //   177: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   180: goto +3 -> 183
    //   183: aload_0
    //   184: ifnull +7 -> 191
    //   187: aload_0
    //   188: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   191: return
    //   192: aload 13
    //   194: invokevirtual 1113	java/util/zip/ZipEntry:isDirectory	()Z
    //   197: ifeq +6 -> 203
    //   200: goto +587 -> 787
    //   203: aload 13
    //   205: invokevirtual 1114	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   208: astore 14
    //   210: aload 14
    //   212: ifnull +575 -> 787
    //   215: aload 14
    //   217: ldc_w 1116
    //   220: invokevirtual 1119	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   223: ifeq +6 -> 229
    //   226: goto +561 -> 787
    //   229: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +40 -> 272
    //   235: new 100	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   242: astore 13
    //   244: aload 13
    //   246: ldc_w 1121
    //   249: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 13
    //   255: aload 14
    //   257: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: ldc 63
    //   263: iconst_2
    //   264: aload 13
    //   266: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_3
    //   273: ifnull +61 -> 334
    //   276: aload_3
    //   277: aload 14
    //   279: invokevirtual 1127	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   282: invokevirtual 1132	java/util/regex/Matcher:matches	()Z
    //   285: ifne +49 -> 334
    //   288: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +496 -> 787
    //   294: new 100	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   301: astore 13
    //   303: aload 13
    //   305: ldc_w 1134
    //   308: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 13
    //   314: aload 14
    //   316: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc 63
    //   322: iconst_2
    //   323: aload 13
    //   325: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: goto +456 -> 787
    //   334: aload 14
    //   336: getstatic 1138	java/io/File:separatorChar	C
    //   339: invokevirtual 639	java/lang/String:lastIndexOf	(I)I
    //   342: istore 5
    //   344: iload 5
    //   346: aload 14
    //   348: invokevirtual 440	java/lang/String:length	()I
    //   351: iconst_1
    //   352: isub
    //   353: if_icmpeq +399 -> 752
    //   356: iload 5
    //   358: ifgt +22 -> 380
    //   361: iload 5
    //   363: ifge +6 -> 369
    //   366: goto +603 -> 969
    //   369: aload 14
    //   371: iconst_1
    //   372: invokevirtual 604	java/lang/String:substring	(I)Ljava/lang/String;
    //   375: astore 14
    //   377: goto +592 -> 969
    //   380: aload 14
    //   382: iconst_0
    //   383: iload 5
    //   385: invokevirtual 628	java/lang/String:substring	(II)Ljava/lang/String;
    //   388: astore 13
    //   390: aload 13
    //   392: iconst_0
    //   393: invokevirtual 1142	java/lang/String:charAt	(I)C
    //   396: getstatic 1138	java/io/File:separatorChar	C
    //   399: if_icmpne +37 -> 436
    //   402: new 100	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   409: astore 16
    //   411: aload 16
    //   413: aload_1
    //   414: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 16
    //   420: aload 13
    //   422: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 16
    //   428: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: astore 13
    //   433: goto +43 -> 476
    //   436: new 100	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   443: astore 16
    //   445: aload 16
    //   447: aload_1
    //   448: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 16
    //   454: getstatic 1138	java/io/File:separatorChar	C
    //   457: invokevirtual 1145	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 16
    //   463: aload 13
    //   465: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 16
    //   471: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: astore 13
    //   476: aload 14
    //   478: iload 5
    //   480: iconst_1
    //   481: iadd
    //   482: invokevirtual 604	java/lang/String:substring	(I)Ljava/lang/String;
    //   485: astore 14
    //   487: aload 14
    //   489: astore 16
    //   491: iload_2
    //   492: ifeq +32 -> 524
    //   495: aload 14
    //   497: ldc_w 598
    //   500: invokevirtual 601	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   503: istore 5
    //   505: aload 14
    //   507: astore 16
    //   509: iload 5
    //   511: ifle +13 -> 524
    //   514: aload 14
    //   516: iconst_0
    //   517: iload 5
    //   519: invokevirtual 628	java/lang/String:substring	(II)Ljava/lang/String;
    //   522: astore 16
    //   524: new 128	java/io/File
    //   527: dup
    //   528: aload 13
    //   530: aload 16
    //   532: invokespecial 1148	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: astore 14
    //   537: aload 14
    //   539: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   542: invokevirtual 133	java/io/File:exists	()Z
    //   545: ifne +12 -> 557
    //   548: aload 14
    //   550: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   553: invokevirtual 224	java/io/File:mkdirs	()Z
    //   556: pop
    //   557: aload 14
    //   559: invokevirtual 133	java/io/File:exists	()Z
    //   562: ifeq +9 -> 571
    //   565: aload 14
    //   567: invokevirtual 283	java/io/File:delete	()Z
    //   570: pop
    //   571: new 229	java/io/FileOutputStream
    //   574: dup
    //   575: aload 14
    //   577: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   580: astore 13
    //   582: new 1028	java/io/BufferedOutputStream
    //   585: dup
    //   586: aload 13
    //   588: aload 18
    //   590: arraylength
    //   591: invokespecial 1032	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   594: astore 12
    //   596: iconst_0
    //   597: istore 5
    //   599: aload 17
    //   601: aload 18
    //   603: iconst_0
    //   604: aload 18
    //   606: arraylength
    //   607: invokevirtual 1149	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   610: istore 9
    //   612: iload 9
    //   614: iconst_m1
    //   615: if_icmpeq +66 -> 681
    //   618: iload 5
    //   620: istore 6
    //   622: iload 9
    //   624: ifne +40 -> 664
    //   627: iload 5
    //   629: iconst_1
    //   630: iadd
    //   631: istore 6
    //   633: iload 6
    //   635: bipush 10
    //   637: if_icmpgt +6 -> 643
    //   640: goto +24 -> 664
    //   643: new 203	java/io/IOException
    //   646: dup
    //   647: ldc_w 1151
    //   650: invokespecial 936	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   653: athrow
    //   654: astore_1
    //   655: aload 12
    //   657: astore_0
    //   658: iconst_1
    //   659: istore 5
    //   661: goto +76 -> 737
    //   664: aload 12
    //   666: aload 18
    //   668: iconst_0
    //   669: iload 9
    //   671: invokevirtual 1152	java/io/BufferedOutputStream:write	([BII)V
    //   674: iload 6
    //   676: istore 5
    //   678: goto -79 -> 599
    //   681: aload 12
    //   683: invokevirtual 1153	java/io/BufferedOutputStream:flush	()V
    //   686: aload 12
    //   688: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   691: aload 13
    //   693: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   696: aload 4
    //   698: ifnull +13 -> 711
    //   701: aload 4
    //   703: aload 14
    //   705: invokeinterface 1156 2 0
    //   710: pop
    //   711: aload 12
    //   713: astore_0
    //   714: aload 13
    //   716: astore 12
    //   718: goto -583 -> 135
    //   721: astore_1
    //   722: aload 12
    //   724: astore_0
    //   725: iload 7
    //   727: istore 5
    //   729: goto +8 -> 737
    //   732: astore_1
    //   733: iload 7
    //   735: istore 5
    //   737: aload 13
    //   739: astore 12
    //   741: aload 15
    //   743: astore 4
    //   745: aload 17
    //   747: astore 13
    //   749: goto +109 -> 858
    //   752: new 100	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   759: astore_1
    //   760: aload_1
    //   761: ldc_w 1158
    //   764: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload_1
    //   769: aload 14
    //   771: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: new 737	java/lang/IllegalArgumentException
    //   778: dup
    //   779: aload_1
    //   780: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokespecial 1159	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   786: athrow
    //   787: goto -652 -> 135
    //   790: astore_1
    //   791: iload 8
    //   793: istore 5
    //   795: aload 15
    //   797: astore 4
    //   799: aload 17
    //   801: astore 13
    //   803: goto +55 -> 858
    //   806: astore_1
    //   807: aconst_null
    //   808: astore_0
    //   809: iload 8
    //   811: istore 5
    //   813: aload 15
    //   815: astore 4
    //   817: aload 17
    //   819: astore 13
    //   821: goto +37 -> 858
    //   824: astore_3
    //   825: aconst_null
    //   826: astore_1
    //   827: aload 15
    //   829: astore 4
    //   831: goto +16 -> 847
    //   834: astore_3
    //   835: goto +7 -> 842
    //   838: astore_3
    //   839: aconst_null
    //   840: astore 11
    //   842: aconst_null
    //   843: astore 4
    //   845: aconst_null
    //   846: astore_1
    //   847: aload_1
    //   848: astore_0
    //   849: aload_1
    //   850: astore 13
    //   852: iload 8
    //   854: istore 5
    //   856: aload_3
    //   857: astore_1
    //   858: aload 13
    //   860: ifnull +16 -> 876
    //   863: iload 5
    //   865: ifne +11 -> 876
    //   868: aload 13
    //   870: invokevirtual 1109	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   873: goto +3 -> 876
    //   876: aload 4
    //   878: ifnull +11 -> 889
    //   881: aload 4
    //   883: invokevirtual 250	java/io/BufferedInputStream:close	()V
    //   886: goto +3 -> 889
    //   889: aload 11
    //   891: ifnull +11 -> 902
    //   894: aload 11
    //   896: invokevirtual 474	java/io/FileInputStream:close	()V
    //   899: goto +3 -> 902
    //   902: aload 12
    //   904: ifnull +11 -> 915
    //   907: aload 12
    //   909: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   912: goto +3 -> 915
    //   915: aload_0
    //   916: ifnull +7 -> 923
    //   919: aload_0
    //   920: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   923: goto +5 -> 928
    //   926: aload_1
    //   927: athrow
    //   928: goto -2 -> 926
    //   931: astore_1
    //   932: goto -772 -> 160
    //   935: astore_1
    //   936: goto -771 -> 165
    //   939: astore_1
    //   940: goto -770 -> 170
    //   943: astore_1
    //   944: goto -761 -> 183
    //   947: astore_0
    //   948: return
    //   949: astore_3
    //   950: goto -74 -> 876
    //   953: astore_3
    //   954: goto -65 -> 889
    //   957: astore_3
    //   958: goto -56 -> 902
    //   961: astore_3
    //   962: goto -47 -> 915
    //   965: astore_0
    //   966: goto -43 -> 923
    //   969: aload_1
    //   970: astore 13
    //   972: goto -485 -> 487
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	975	0	paramString1	String
    //   0	975	1	paramString2	String
    //   0	975	2	paramBoolean	boolean
    //   0	975	3	paramPattern	Pattern
    //   0	975	4	paramList	List<File>
    //   342	522	5	i	int
    //   620	55	6	j	int
    //   10	724	7	k	int
    //   7	846	8	m	int
    //   610	60	9	n	int
    //   15	3	10	bool	boolean
    //   29	866	11	localObject1	Object
    //   1	907	12	localObject2	Object
    //   4	967	13	localObject3	Object
    //   208	562	14	localObject4	Object
    //   93	735	15	localBufferedInputStream	java.io.BufferedInputStream
    //   409	122	16	localObject5	Object
    //   104	714	17	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   127	540	18	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   643	654	654	finally
    //   599	612	721	finally
    //   664	674	721	finally
    //   681	696	721	finally
    //   701	711	721	finally
    //   582	596	732	finally
    //   135	142	790	finally
    //   147	155	790	finally
    //   192	200	790	finally
    //   203	210	790	finally
    //   215	226	790	finally
    //   229	272	790	finally
    //   276	331	790	finally
    //   334	356	790	finally
    //   369	377	790	finally
    //   380	433	790	finally
    //   436	476	790	finally
    //   476	487	790	finally
    //   495	505	790	finally
    //   514	524	790	finally
    //   524	557	790	finally
    //   557	571	790	finally
    //   571	582	790	finally
    //   752	787	790	finally
    //   106	129	806	finally
    //   95	106	824	finally
    //   84	95	834	finally
    //   12	17	838	finally
    //   22	74	838	finally
    //   74	84	838	finally
    //   155	160	931	java/io/IOException
    //   160	165	935	java/io/IOException
    //   165	170	939	java/io/IOException
    //   175	180	943	java/io/IOException
    //   187	191	947	java/io/IOException
    //   868	873	949	java/io/IOException
    //   881	886	953	java/io/IOException
    //   894	899	957	java/io/IOException
    //   907	912	961	java/io/IOException
    //   919	923	965	java/io/IOException
  }
  
  /* Error */
  public static boolean uncompressZipEntry(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: new 128	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 6
    //   21: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokevirtual 133	java/io/File:exists	()Z
    //   27: ifne +12 -> 39
    //   30: aload 6
    //   32: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   35: invokevirtual 224	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: new 1163	com/tencent/commonsdk/zip/QZipFile
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 1164	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   47: astore 7
    //   49: new 100	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   56: astore_0
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_0
    //   64: ldc_w 1166
    //   67: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: new 128	java/io/File
    //   74: dup
    //   75: aload_0
    //   76: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore 9
    //   84: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   87: sipush 8192
    //   90: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   93: astore 10
    //   95: new 229	java/io/FileOutputStream
    //   98: dup
    //   99: aload 9
    //   101: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: astore 6
    //   106: new 1028	java/io/BufferedOutputStream
    //   109: dup
    //   110: aload 6
    //   112: aload 10
    //   114: arraylength
    //   115: invokespecial 1032	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   118: astore 8
    //   120: aload 5
    //   122: astore_0
    //   123: aload 7
    //   125: invokevirtual 1170	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   128: astore 11
    //   130: aload 4
    //   132: astore_0
    //   133: aload 11
    //   135: invokeinterface 1175 1 0
    //   140: ifeq +82 -> 222
    //   143: aload 4
    //   145: astore_0
    //   146: aload 11
    //   148: invokeinterface 1178 1 0
    //   153: checkcast 1112	java/util/zip/ZipEntry
    //   156: astore 5
    //   158: aload 4
    //   160: ifnull +11 -> 171
    //   163: aload 4
    //   165: astore_0
    //   166: aload 4
    //   168: invokevirtual 531	java/io/InputStream:close	()V
    //   171: aload 4
    //   173: astore_0
    //   174: aload 7
    //   176: aload 5
    //   178: invokevirtual 1182	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   181: astore 5
    //   183: aload 5
    //   185: astore_0
    //   186: aload 5
    //   188: aload 10
    //   190: iconst_0
    //   191: aload 10
    //   193: arraylength
    //   194: invokevirtual 528	java/io/InputStream:read	([BII)I
    //   197: istore_2
    //   198: aload 5
    //   200: astore 4
    //   202: iload_2
    //   203: iconst_m1
    //   204: if_icmpeq -74 -> 130
    //   207: aload 5
    //   209: astore_0
    //   210: aload 8
    //   212: aload 10
    //   214: iconst_0
    //   215: iload_2
    //   216: invokevirtual 1152	java/io/BufferedOutputStream:write	([BII)V
    //   219: goto -36 -> 183
    //   222: aload 4
    //   224: astore_0
    //   225: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   228: aload 10
    //   230: invokevirtual 338	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   233: aload 4
    //   235: astore_0
    //   236: aload 9
    //   238: new 128	java/io/File
    //   241: dup
    //   242: aload_1
    //   243: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 815	java/io/File:renameTo	(Ljava/io/File;)Z
    //   249: istore_3
    //   250: aload 6
    //   252: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   255: aload 8
    //   257: invokevirtual 1153	java/io/BufferedOutputStream:flush	()V
    //   260: aload 8
    //   262: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   265: aload 4
    //   267: ifnull +8 -> 275
    //   270: aload 4
    //   272: invokevirtual 531	java/io/InputStream:close	()V
    //   275: aload 7
    //   277: invokevirtual 1183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   280: iload_3
    //   281: ireturn
    //   282: astore 5
    //   284: aload_0
    //   285: astore_1
    //   286: aload 8
    //   288: astore 4
    //   290: aload 5
    //   292: astore_0
    //   293: goto +9 -> 302
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_1
    //   299: aload_1
    //   300: astore 4
    //   302: aload 7
    //   304: astore 5
    //   306: goto +34 -> 340
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_1
    //   312: aload_1
    //   313: astore 4
    //   315: aload 8
    //   317: astore 6
    //   319: aload 7
    //   321: astore 5
    //   323: goto +17 -> 340
    //   326: astore_0
    //   327: aconst_null
    //   328: astore_1
    //   329: aload_1
    //   330: astore 5
    //   332: aload 5
    //   334: astore 4
    //   336: aload 8
    //   338: astore 6
    //   340: aload 6
    //   342: ifnull +11 -> 353
    //   345: aload 6
    //   347: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   350: goto +3 -> 353
    //   353: aload 4
    //   355: ifnull +16 -> 371
    //   358: aload 4
    //   360: invokevirtual 1153	java/io/BufferedOutputStream:flush	()V
    //   363: aload 4
    //   365: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   368: goto +3 -> 371
    //   371: aload_1
    //   372: ifnull +10 -> 382
    //   375: aload_1
    //   376: invokevirtual 531	java/io/InputStream:close	()V
    //   379: goto +3 -> 382
    //   382: aload 5
    //   384: ifnull +8 -> 392
    //   387: aload 5
    //   389: invokevirtual 1183	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   392: goto +5 -> 397
    //   395: aload_0
    //   396: athrow
    //   397: goto -2 -> 395
    //   400: astore_0
    //   401: goto -230 -> 171
    //   404: astore_0
    //   405: goto -150 -> 255
    //   408: astore_0
    //   409: goto -144 -> 265
    //   412: astore_0
    //   413: goto -138 -> 275
    //   416: astore_0
    //   417: iload_3
    //   418: ireturn
    //   419: astore 6
    //   421: goto -68 -> 353
    //   424: astore 4
    //   426: goto -55 -> 371
    //   429: astore_1
    //   430: goto -48 -> 382
    //   433: astore_1
    //   434: goto -42 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	paramString1	String
    //   0	437	1	paramString2	String
    //   197	19	2	i	int
    //   249	169	3	bool	boolean
    //   7	357	4	localObject1	Object
    //   424	1	4	localIOException1	IOException
    //   1	207	5	localObject2	Object
    //   282	9	5	localObject3	Object
    //   304	84	5	localObject4	Object
    //   17	329	6	localObject5	Object
    //   419	1	6	localIOException2	IOException
    //   47	273	7	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   4	333	8	localBufferedOutputStream	java.io.BufferedOutputStream
    //   82	155	9	localFile	File
    //   93	136	10	arrayOfByte	byte[]
    //   128	19	11	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   123	130	282	finally
    //   133	143	282	finally
    //   146	158	282	finally
    //   166	171	282	finally
    //   174	183	282	finally
    //   186	198	282	finally
    //   210	219	282	finally
    //   225	233	282	finally
    //   236	250	282	finally
    //   106	120	296	finally
    //   49	106	309	finally
    //   9	39	326	finally
    //   39	49	326	finally
    //   166	171	400	java/io/IOException
    //   250	255	404	java/io/IOException
    //   255	265	408	java/io/IOException
    //   270	275	412	java/io/IOException
    //   275	280	416	java/io/IOException
    //   345	350	419	java/io/IOException
    //   358	368	424	java/io/IOException
    //   375	379	429	java/io/IOException
    //   387	392	433	java/io/IOException
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    return writeFile(paramString1, paramString2, true);
  }
  
  public static boolean writeFile(String paramString1, String paramString2, InputStream paramInputStream)
  {
    return writeFile(paramString1, new StringBuffer(paramString2), paramInputStream);
  }
  
  public static boolean writeFile(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(paramString1);
    String str = paramString2;
    if (paramString2 != null) {
      str = paramString2.replaceAll("[\\\\/*?<>:\"|]", "");
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(str);
    paramString1 = new File(paramString2.toString());
    boolean bool1 = true;
    if (!localFile.exists()) {
      bool1 = localFile.mkdirs();
    }
    boolean bool3 = bool1;
    if (localFile.exists())
    {
      bool2 = bool1;
      if (paramString1.exists()) {}
    }
    try
    {
      paramString1.createNewFile();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      label110:
      break label110;
    }
    boolean bool2 = false;
    label179:
    label181:
    label198:
    label216:
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label126:
      break label126;
    }
    paramString1 = null;
    bool2 = false;
    try
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString3);
      paramString2.append("\r\n");
      paramString2 = paramString2.toString();
      bool1 = bool2;
      if (paramString1 == null) {
        break label181;
      }
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException|OutOfMemoryError paramString2)
    {
      break label179;
    }
    bool1 = false;
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      break label198;
    }
    bool2 = false;
    bool3 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      return bool2;
    }
    catch (IOException paramString1)
    {
      break label216;
    }
    bool3 = false;
    return bool3;
  }
  
  public static boolean writeFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    try
    {
      if (!paramString1.getParentFile().exists()) {
        paramString1.getParentFile().mkdirs();
      }
      paramString1.createNewFile();
    }
    catch (IOException localIOException)
    {
      label42:
      boolean bool;
      break label42;
    }
    bool = false;
    break label49;
    bool = true;
    try
    {
      label49:
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label62:
      Object localObject;
      break label62;
    }
    paramString1 = null;
    bool = false;
    localObject = paramString2;
    if (paramBoolean) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("\r\n");
      localObject = ((StringBuilder)localObject).toString();
      paramBoolean = bool;
      if (paramString1 == null) {
        break label127;
      }
      paramString1.write(((String)localObject).getBytes());
      paramBoolean = bool;
    }
    catch (IOException paramString2)
    {
      label125:
      break label125;
    }
    paramBoolean = false;
    label127:
    bool = paramBoolean;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool = paramBoolean;
    }
    catch (IOException paramString2)
    {
      label142:
      break label142;
    }
    bool = false;
    paramBoolean = bool;
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      return bool;
    }
    catch (IOException paramString1)
    {
      label156:
      break label156;
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  /* Error */
  public static boolean writeFile(String paramString, StringBuffer paramStringBuffer, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 128	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: invokevirtual 711	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   20: ldc_w 1195
    //   23: ldc_w 477
    //   26: invokevirtual 609	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_1
    //   30: new 100	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   37: astore 7
    //   39: aload 7
    //   41: aload_0
    //   42: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: aload_1
    //   49: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: new 128	java/io/File
    //   56: dup
    //   57: aload 7
    //   59: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore_0
    //   66: iconst_1
    //   67: istore 4
    //   69: aload 6
    //   71: invokevirtual 133	java/io/File:exists	()Z
    //   74: ifne +21 -> 95
    //   77: aload 6
    //   79: invokevirtual 224	java/io/File:mkdirs	()Z
    //   82: istore 5
    //   84: iload 5
    //   86: istore 4
    //   88: iload 5
    //   90: ifne +5 -> 95
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 6
    //   97: invokevirtual 133	java/io/File:exists	()Z
    //   100: ifeq +128 -> 228
    //   103: aload_0
    //   104: invokevirtual 133	java/io/File:exists	()Z
    //   107: ifne +11 -> 118
    //   110: aload_0
    //   111: invokevirtual 292	java/io/File:createNewFile	()Z
    //   114: pop
    //   115: goto +3 -> 118
    //   118: new 229	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: iconst_0
    //   124: invokespecial 818	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   127: astore_0
    //   128: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   131: sipush 4096
    //   134: invokevirtual 330	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   137: astore_1
    //   138: aload_2
    //   139: aload_1
    //   140: invokevirtual 907	java/io/InputStream:read	([B)I
    //   143: istore_3
    //   144: iload_3
    //   145: iconst_m1
    //   146: if_icmpeq +13 -> 159
    //   149: aload_0
    //   150: aload_1
    //   151: iconst_0
    //   152: iload_3
    //   153: invokevirtual 331	java/io/FileOutputStream:write	([BII)V
    //   156: goto -18 -> 138
    //   159: invokestatic 326	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   162: aload_1
    //   163: invokevirtual 338	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   166: aload_0
    //   167: invokevirtual 334	java/io/FileOutputStream:flush	()V
    //   170: aload_0
    //   171: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   174: iload 4
    //   176: ireturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   182: iload 4
    //   184: ireturn
    //   185: astore_1
    //   186: goto +21 -> 207
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   194: aload_0
    //   195: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   205: iconst_0
    //   206: ireturn
    //   207: aload_0
    //   208: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   211: goto +8 -> 219
    //   214: astore_0
    //   215: aload_0
    //   216: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 166	java/io/FileNotFoundException:printStackTrace	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: iload 4
    //   230: ireturn
    //   231: astore_0
    //   232: iconst_0
    //   233: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramString	String
    //   0	234	1	paramStringBuffer	StringBuffer
    //   0	234	2	paramInputStream	InputStream
    //   143	10	3	i	int
    //   67	162	4	bool1	boolean
    //   82	7	5	bool2	boolean
    //   8	88	6	localFile	File
    //   37	21	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   170	174	177	java/io/IOException
    //   128	138	185	finally
    //   138	144	185	finally
    //   149	156	185	finally
    //   159	170	185	finally
    //   190	194	185	finally
    //   128	138	189	java/io/IOException
    //   138	144	189	java/io/IOException
    //   149	156	189	java/io/IOException
    //   159	170	189	java/io/IOException
    //   194	198	200	java/io/IOException
    //   207	211	214	java/io/IOException
    //   118	128	221	java/io/FileNotFoundException
    //   110	115	231	java/io/IOException
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    return writeFile(paramArrayOfByte, paramString, false);
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    return writeFile(paramArrayOfByte, paramString, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 128	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_1
    //   16: invokevirtual 133	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 133	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 224	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 292	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 229	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 818	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 331	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 334	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_0
    //   73: goto +10 -> 83
    //   76: goto +17 -> 93
    //   79: astore_0
    //   80: aload 4
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   91: aload_0
    //   92: athrow
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: aload 5
    //   106: astore_1
    //   107: goto -14 -> 93
    //   110: astore_0
    //   111: goto -35 -> 76
    //   114: astore_0
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_1
    //   118: goto -27 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramArrayOfByte	byte[]
    //   0	121	1	paramString	String
    //   0	121	2	paramBoolean	boolean
    //   0	121	3	paramInt	int
    //   13	68	4	localObject1	Object
    //   10	95	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	72	finally
    //   15	40	79	finally
    //   40	45	79	finally
    //   45	55	79	finally
    //   15	40	103	java/io/IOException
    //   40	45	103	java/io/IOException
    //   45	55	103	java/io/IOException
    //   55	66	110	java/io/IOException
    //   66	70	114	java/io/IOException
    //   97	101	114	java/io/IOException
    //   87	91	117	java/io/IOException
  }
  
  /* Error */
  public static void writeObject(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 163	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_2
    //   13: new 1211	java/io/ObjectOutputStream
    //   16: dup
    //   17: new 1028	java/io/BufferedOutputStream
    //   20: dup
    //   21: invokestatic 965	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   24: aload_0
    //   25: iconst_0
    //   26: invokevirtual 1215	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   29: invokespecial 1218	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: invokespecial 1219	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore_3
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual 1222	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload_3
    //   42: invokevirtual 1223	java/io/ObjectOutputStream:flush	()V
    //   45: aload_3
    //   46: invokevirtual 1224	java/io/ObjectOutputStream:close	()V
    //   49: return
    //   50: astore_0
    //   51: aload_3
    //   52: astore_2
    //   53: goto +109 -> 162
    //   56: astore_2
    //   57: aload_3
    //   58: astore_1
    //   59: aload_2
    //   60: astore_3
    //   61: goto +11 -> 72
    //   64: astore_0
    //   65: goto +97 -> 162
    //   68: astore_3
    //   69: aload 4
    //   71: astore_1
    //   72: aload_1
    //   73: astore_2
    //   74: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +70 -> 147
    //   80: aload_1
    //   81: astore_2
    //   82: new 100	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   89: astore 4
    //   91: aload_1
    //   92: astore_2
    //   93: aload 4
    //   95: ldc_w 1226
    //   98: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: astore_2
    //   104: aload 4
    //   106: aload_0
    //   107: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: astore_2
    //   113: aload 4
    //   115: ldc_w 978
    //   118: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: astore_2
    //   124: aload 4
    //   126: aload_3
    //   127: invokevirtual 952	java/lang/Exception:toString	()Ljava/lang/String;
    //   130: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: astore_2
    //   136: ldc 63
    //   138: iconst_2
    //   139: aload 4
    //   141: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 980	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_1
    //   148: ifnull +13 -> 161
    //   151: aload_1
    //   152: invokevirtual 1224	java/io/ObjectOutputStream:close	()V
    //   155: return
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   161: return
    //   162: aload_2
    //   163: ifnull +15 -> 178
    //   166: aload_2
    //   167: invokevirtual 1224	java/io/ObjectOutputStream:close	()V
    //   170: goto +8 -> 178
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   178: aload_0
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString	String
    //   0	180	1	paramObject	Object
    //   12	41	2	localObject1	Object
    //   56	4	2	localException1	Exception
    //   73	94	2	localObject2	Object
    //   35	26	3	localObject3	Object
    //   68	59	3	localException2	Exception
    //   9	131	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	45	50	finally
    //   36	45	56	java/lang/Exception
    //   13	36	64	finally
    //   74	80	64	finally
    //   82	91	64	finally
    //   93	102	64	finally
    //   104	111	64	finally
    //   113	122	64	finally
    //   124	134	64	finally
    //   136	147	64	finally
    //   13	36	68	java/lang/Exception
    //   45	49	156	java/io/IOException
    //   151	155	156	java/io/IOException
    //   166	170	173	java/io/IOException
  }
  
  /* Error */
  public static void writeObjectList(String paramString, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +341 -> 342
    //   4: aload_0
    //   5: invokevirtual 440	java/lang/String:length	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 5
    //   18: aload 5
    //   20: astore 4
    //   22: invokestatic 965	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: astore 7
    //   27: iconst_0
    //   28: istore_2
    //   29: aload 5
    //   31: astore 4
    //   33: new 1211	java/io/ObjectOutputStream
    //   36: dup
    //   37: new 1028	java/io/BufferedOutputStream
    //   40: dup
    //   41: aload 7
    //   43: aload_0
    //   44: iconst_0
    //   45: invokevirtual 1215	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   48: invokespecial 1218	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   51: invokespecial 1219	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore 5
    //   56: aload_1
    //   57: arraylength
    //   58: istore_3
    //   59: iload_2
    //   60: iload_3
    //   61: if_icmpge +114 -> 175
    //   64: aload_1
    //   65: iload_2
    //   66: aaload
    //   67: astore 4
    //   69: aload 4
    //   71: instanceof 792
    //   74: ifeq +19 -> 93
    //   77: aload 5
    //   79: aload 4
    //   81: checkcast 792	java/lang/Boolean
    //   84: invokevirtual 795	java/lang/Boolean:booleanValue	()Z
    //   87: invokevirtual 1231	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   90: goto +253 -> 343
    //   93: aload 4
    //   95: instanceof 984
    //   98: ifeq +19 -> 117
    //   101: aload 5
    //   103: aload 4
    //   105: checkcast 984	java/lang/Byte
    //   108: invokevirtual 1234	java/lang/Byte:byteValue	()B
    //   111: invokevirtual 1237	java/io/ObjectOutputStream:writeByte	(I)V
    //   114: goto +229 -> 343
    //   117: aload 4
    //   119: instanceof 481
    //   122: ifeq +19 -> 141
    //   125: aload 5
    //   127: aload 4
    //   129: checkcast 481	java/lang/Integer
    //   132: invokevirtual 1240	java/lang/Integer:intValue	()I
    //   135: invokevirtual 1243	java/io/ObjectOutputStream:writeInt	(I)V
    //   138: goto +205 -> 343
    //   141: aload 4
    //   143: instanceof 1005
    //   146: ifeq +19 -> 165
    //   149: aload 5
    //   151: aload 4
    //   153: checkcast 1005	java/lang/Long
    //   156: invokevirtual 1246	java/lang/Long:longValue	()J
    //   159: invokevirtual 1249	java/io/ObjectOutputStream:writeLong	(J)V
    //   162: goto +181 -> 343
    //   165: aload 5
    //   167: aload 4
    //   169: invokevirtual 1222	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   172: goto +171 -> 343
    //   175: aload 5
    //   177: invokevirtual 1223	java/io/ObjectOutputStream:flush	()V
    //   180: aload 5
    //   182: invokevirtual 1224	java/io/ObjectOutputStream:close	()V
    //   185: return
    //   186: astore_0
    //   187: aload 5
    //   189: astore 4
    //   191: goto +131 -> 322
    //   194: astore 4
    //   196: aload 5
    //   198: astore_1
    //   199: aload 4
    //   201: astore 5
    //   203: goto +12 -> 215
    //   206: astore_0
    //   207: goto +115 -> 322
    //   210: astore 5
    //   212: aload 6
    //   214: astore_1
    //   215: aload_1
    //   216: astore 4
    //   218: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +78 -> 299
    //   224: aload_1
    //   225: astore 4
    //   227: new 100	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   234: astore 6
    //   236: aload_1
    //   237: astore 4
    //   239: aload 6
    //   241: ldc_w 1251
    //   244: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: astore 4
    //   251: aload 6
    //   253: aload_0
    //   254: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_1
    //   259: astore 4
    //   261: aload 6
    //   263: ldc_w 1015
    //   266: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload_1
    //   271: astore 4
    //   273: aload 6
    //   275: aload 5
    //   277: invokevirtual 1016	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_1
    //   285: astore 4
    //   287: ldc_w 1018
    //   290: iconst_2
    //   291: aload 6
    //   293: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_1
    //   300: astore 4
    //   302: aload 5
    //   304: invokevirtual 588	java/lang/Exception:printStackTrace	()V
    //   307: aload_1
    //   308: ifnull +13 -> 321
    //   311: aload_1
    //   312: invokevirtual 1224	java/io/ObjectOutputStream:close	()V
    //   315: return
    //   316: astore_0
    //   317: aload_0
    //   318: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   321: return
    //   322: aload 4
    //   324: ifnull +16 -> 340
    //   327: aload 4
    //   329: invokevirtual 1224	java/io/ObjectOutputStream:close	()V
    //   332: goto +8 -> 340
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   340: aload_0
    //   341: athrow
    //   342: return
    //   343: iload_2
    //   344: iconst_1
    //   345: iadd
    //   346: istore_2
    //   347: goto -288 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramString	String
    //   0	350	1	paramVarArgs	Object[]
    //   28	319	2	i	int
    //   58	4	3	j	int
    //   20	170	4	localObject1	Object
    //   194	6	4	localException1	Exception
    //   216	112	4	arrayOfObject	Object[]
    //   16	186	5	localObject2	Object
    //   210	93	5	localException2	Exception
    //   13	279	6	localStringBuilder	StringBuilder
    //   25	17	7	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   56	59	186	finally
    //   69	90	186	finally
    //   93	114	186	finally
    //   117	138	186	finally
    //   141	162	186	finally
    //   165	172	186	finally
    //   175	180	186	finally
    //   56	59	194	java/lang/Exception
    //   69	90	194	java/lang/Exception
    //   93	114	194	java/lang/Exception
    //   117	138	194	java/lang/Exception
    //   141	162	194	java/lang/Exception
    //   165	172	194	java/lang/Exception
    //   175	180	194	java/lang/Exception
    //   22	27	206	finally
    //   33	56	206	finally
    //   218	224	206	finally
    //   227	236	206	finally
    //   239	248	206	finally
    //   251	258	206	finally
    //   261	270	206	finally
    //   273	284	206	finally
    //   287	299	206	finally
    //   302	307	206	finally
    //   22	27	210	java/lang/Exception
    //   33	56	210	java/lang/Exception
    //   180	185	316	java/io/IOException
    //   311	315	316	java/io/IOException
    //   327	332	335	java/io/IOException
  }
  
  /* Error */
  public static boolean zipFiles(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: new 229	java/io/FileOutputStream
    //   9: dup
    //   10: new 128	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore_1
    //   22: new 1028	java/io/BufferedOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 1218	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 5
    //   32: aload_1
    //   33: astore 6
    //   35: aload 5
    //   37: astore 8
    //   39: new 1254	java/util/zip/ZipOutputStream
    //   42: dup
    //   43: aload 5
    //   45: invokespecial 1255	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore 7
    //   50: new 128	java/io/File
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: invokevirtual 271	java/io/File:listFiles	()[Ljava/io/File;
    //   61: astore 6
    //   63: aload 6
    //   65: arraylength
    //   66: istore_3
    //   67: iconst_0
    //   68: istore_2
    //   69: iload_2
    //   70: iload_3
    //   71: if_icmpge +134 -> 205
    //   74: aload 6
    //   76: iload_2
    //   77: aaload
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull +118 -> 198
    //   83: aload_0
    //   84: invokevirtual 428	java/io/File:isFile	()Z
    //   87: ifeq +111 -> 198
    //   90: aload 7
    //   92: new 1112	java/util/zip/ZipEntry
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 280	java/io/File:getName	()Ljava/lang/String;
    //   100: invokespecial 1256	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 1260	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   106: aload 7
    //   108: bipush 9
    //   110: invokevirtual 1263	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   113: new 144	java/io/FileInputStream
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   121: astore_0
    //   122: sipush 20480
    //   125: newarray byte
    //   127: astore 8
    //   129: aload_0
    //   130: aload 8
    //   132: iconst_0
    //   133: sipush 20480
    //   136: invokevirtual 1264	java/io/FileInputStream:read	([BII)I
    //   139: istore 4
    //   141: iload 4
    //   143: iconst_m1
    //   144: if_icmpeq +16 -> 160
    //   147: aload 7
    //   149: aload 8
    //   151: iconst_0
    //   152: iload 4
    //   154: invokevirtual 1265	java/util/zip/ZipOutputStream:write	([BII)V
    //   157: goto -28 -> 129
    //   160: aload_0
    //   161: invokevirtual 474	java/io/FileInputStream:close	()V
    //   164: aload 7
    //   166: invokevirtual 1266	java/util/zip/ZipOutputStream:flush	()V
    //   169: aload 7
    //   171: invokevirtual 1269	java/util/zip/ZipOutputStream:closeEntry	()V
    //   174: goto +24 -> 198
    //   177: aload_0
    //   178: ifnull +7 -> 185
    //   181: aload_0
    //   182: invokevirtual 474	java/io/FileInputStream:close	()V
    //   185: aload 7
    //   187: invokevirtual 1266	java/util/zip/ZipOutputStream:flush	()V
    //   190: aload 7
    //   192: invokevirtual 1269	java/util/zip/ZipOutputStream:closeEntry	()V
    //   195: aload 6
    //   197: athrow
    //   198: iload_2
    //   199: iconst_1
    //   200: iadd
    //   201: istore_2
    //   202: goto -133 -> 69
    //   205: aload 7
    //   207: invokevirtual 1270	java/util/zip/ZipOutputStream:close	()V
    //   210: goto +20 -> 230
    //   213: astore_0
    //   214: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +13 -> 230
    //   220: ldc 63
    //   222: iconst_2
    //   223: ldc_w 1272
    //   226: aload_0
    //   227: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload 5
    //   232: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   235: goto +20 -> 255
    //   238: astore_0
    //   239: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +13 -> 255
    //   245: ldc 63
    //   247: iconst_2
    //   248: ldc_w 1272
    //   251: aload_0
    //   252: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload_1
    //   256: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   259: goto +20 -> 279
    //   262: astore_0
    //   263: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +13 -> 279
    //   269: ldc 63
    //   271: iconst_2
    //   272: ldc_w 1272
    //   275: aload_0
    //   276: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   279: iconst_1
    //   280: ireturn
    //   281: astore_0
    //   282: aload_1
    //   283: astore 6
    //   285: aload 7
    //   287: astore_1
    //   288: goto +214 -> 502
    //   291: astore_0
    //   292: aload 7
    //   294: astore 9
    //   296: aload_1
    //   297: astore 7
    //   299: aload 5
    //   301: astore_1
    //   302: goto +65 -> 367
    //   305: astore_0
    //   306: aload_1
    //   307: astore 7
    //   309: aload 5
    //   311: astore_1
    //   312: goto +55 -> 367
    //   315: astore 7
    //   317: aconst_null
    //   318: astore 5
    //   320: aload 5
    //   322: astore_0
    //   323: aload_1
    //   324: astore 6
    //   326: aload_0
    //   327: astore_1
    //   328: aload 7
    //   330: astore_0
    //   331: goto +171 -> 502
    //   334: astore_0
    //   335: aconst_null
    //   336: astore 5
    //   338: aload_1
    //   339: astore 7
    //   341: aload 5
    //   343: astore_1
    //   344: goto +23 -> 367
    //   347: astore_0
    //   348: aconst_null
    //   349: astore 5
    //   351: aload 5
    //   353: astore 6
    //   355: aload 6
    //   357: astore_1
    //   358: goto +144 -> 502
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_1
    //   364: aload_1
    //   365: astore 7
    //   367: aload 9
    //   369: astore 10
    //   371: aload 7
    //   373: astore 6
    //   375: aload_1
    //   376: astore 8
    //   378: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +24 -> 405
    //   384: aload 9
    //   386: astore 10
    //   388: aload 7
    //   390: astore 6
    //   392: aload_1
    //   393: astore 8
    //   395: ldc 63
    //   397: iconst_2
    //   398: ldc_w 1274
    //   401: aload_0
    //   402: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   405: aload 9
    //   407: ifnull +28 -> 435
    //   410: aload 9
    //   412: invokevirtual 1270	java/util/zip/ZipOutputStream:close	()V
    //   415: goto +20 -> 435
    //   418: astore_0
    //   419: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +13 -> 435
    //   425: ldc 63
    //   427: iconst_2
    //   428: ldc_w 1272
    //   431: aload_0
    //   432: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   435: aload_1
    //   436: ifnull +27 -> 463
    //   439: aload_1
    //   440: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   443: goto +20 -> 463
    //   446: astore_0
    //   447: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +13 -> 463
    //   453: ldc 63
    //   455: iconst_2
    //   456: ldc_w 1272
    //   459: aload_0
    //   460: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   463: aload 7
    //   465: ifnull +27 -> 492
    //   468: aload 7
    //   470: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   473: iconst_0
    //   474: ireturn
    //   475: astore_0
    //   476: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +13 -> 492
    //   482: ldc 63
    //   484: iconst_2
    //   485: ldc_w 1272
    //   488: aload_0
    //   489: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: iconst_0
    //   493: ireturn
    //   494: astore_0
    //   495: aload 10
    //   497: astore_1
    //   498: aload 8
    //   500: astore 5
    //   502: aload_1
    //   503: ifnull +27 -> 530
    //   506: aload_1
    //   507: invokevirtual 1270	java/util/zip/ZipOutputStream:close	()V
    //   510: goto +20 -> 530
    //   513: astore_1
    //   514: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +13 -> 530
    //   520: ldc 63
    //   522: iconst_2
    //   523: ldc_w 1272
    //   526: aload_1
    //   527: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   530: aload 5
    //   532: ifnull +28 -> 560
    //   535: aload 5
    //   537: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   540: goto +20 -> 560
    //   543: astore_1
    //   544: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +13 -> 560
    //   550: ldc 63
    //   552: iconst_2
    //   553: ldc_w 1272
    //   556: aload_1
    //   557: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   560: aload 6
    //   562: ifnull +28 -> 590
    //   565: aload 6
    //   567: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   570: goto +20 -> 590
    //   573: astore_1
    //   574: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +13 -> 590
    //   580: ldc 63
    //   582: iconst_2
    //   583: ldc_w 1272
    //   586: aload_1
    //   587: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   590: goto +5 -> 595
    //   593: aload_0
    //   594: athrow
    //   595: goto -2 -> 593
    //   598: astore 6
    //   600: goto -423 -> 177
    //   603: astore 6
    //   605: aconst_null
    //   606: astore_0
    //   607: goto -430 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	paramString1	String
    //   0	610	1	paramString2	String
    //   68	134	2	i	int
    //   66	6	3	j	int
    //   139	14	4	k	int
    //   30	506	5	localObject1	Object
    //   33	533	6	localObject2	Object
    //   598	1	6	localObject3	Object
    //   603	1	6	localObject4	Object
    //   48	260	7	localObject5	Object
    //   315	14	7	localObject6	Object
    //   339	130	7	str	String
    //   37	462	8	localObject7	Object
    //   4	407	9	localObject8	Object
    //   1	495	10	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   205	210	213	java/io/IOException
    //   230	235	238	java/io/IOException
    //   255	259	262	java/io/IOException
    //   50	67	281	finally
    //   83	113	281	finally
    //   160	174	281	finally
    //   181	185	281	finally
    //   185	198	281	finally
    //   50	67	291	java/lang/Exception
    //   83	113	291	java/lang/Exception
    //   160	174	291	java/lang/Exception
    //   181	185	291	java/lang/Exception
    //   185	198	291	java/lang/Exception
    //   39	50	305	java/lang/Exception
    //   22	32	315	finally
    //   22	32	334	java/lang/Exception
    //   6	22	347	finally
    //   6	22	361	java/lang/Exception
    //   410	415	418	java/io/IOException
    //   439	443	446	java/io/IOException
    //   468	473	475	java/io/IOException
    //   39	50	494	finally
    //   378	384	494	finally
    //   395	405	494	finally
    //   506	510	513	java/io/IOException
    //   535	540	543	java/io/IOException
    //   565	570	573	java/io/IOException
    //   122	129	598	finally
    //   129	141	598	finally
    //   147	157	598	finally
    //   113	122	603	finally
  }
  
  /* Error */
  public static boolean zipFiles(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 10
    //   12: new 229	java/io/FileOutputStream
    //   15: dup
    //   16: new 128	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: astore_1
    //   28: new 1028	java/io/BufferedOutputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 1218	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: astore 6
    //   38: aload_1
    //   39: astore 7
    //   41: aload 6
    //   43: astore 9
    //   45: new 1254	java/util/zip/ZipOutputStream
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 1255	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore 8
    //   56: aload_0
    //   57: invokeinterface 1279 1 0
    //   62: astore 7
    //   64: aload 7
    //   66: invokeinterface 1284 1 0
    //   71: ifeq +133 -> 204
    //   74: new 128	java/io/File
    //   77: dup
    //   78: aload 7
    //   80: invokeinterface 1287 1 0
    //   85: checkcast 94	java/lang/String
    //   88: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 133	java/io/File:exists	()Z
    //   96: ifeq -32 -> 64
    //   99: aload 8
    //   101: new 1112	java/util/zip/ZipEntry
    //   104: dup
    //   105: aload_0
    //   106: invokevirtual 280	java/io/File:getName	()Ljava/lang/String;
    //   109: invokespecial 1256	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   112: invokevirtual 1260	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   115: aload 8
    //   117: bipush 9
    //   119: invokevirtual 1263	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   122: new 144	java/io/FileInputStream
    //   125: dup
    //   126: aload_0
    //   127: invokespecial 320	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   130: astore_0
    //   131: sipush 20480
    //   134: newarray byte
    //   136: astore 9
    //   138: aload_0
    //   139: aload 9
    //   141: iconst_0
    //   142: sipush 20480
    //   145: invokevirtual 1264	java/io/FileInputStream:read	([BII)I
    //   148: istore_2
    //   149: iload_2
    //   150: iconst_m1
    //   151: if_icmpeq +15 -> 166
    //   154: aload 8
    //   156: aload 9
    //   158: iconst_0
    //   159: iload_2
    //   160: invokevirtual 1265	java/util/zip/ZipOutputStream:write	([BII)V
    //   163: goto -25 -> 138
    //   166: aload_0
    //   167: invokevirtual 474	java/io/FileInputStream:close	()V
    //   170: aload 8
    //   172: invokevirtual 1266	java/util/zip/ZipOutputStream:flush	()V
    //   175: aload 8
    //   177: invokevirtual 1269	java/util/zip/ZipOutputStream:closeEntry	()V
    //   180: goto -116 -> 64
    //   183: aload_0
    //   184: ifnull +7 -> 191
    //   187: aload_0
    //   188: invokevirtual 474	java/io/FileInputStream:close	()V
    //   191: aload 8
    //   193: invokevirtual 1266	java/util/zip/ZipOutputStream:flush	()V
    //   196: aload 8
    //   198: invokevirtual 1269	java/util/zip/ZipOutputStream:closeEntry	()V
    //   201: aload 7
    //   203: athrow
    //   204: iconst_1
    //   205: istore_3
    //   206: iconst_1
    //   207: istore 4
    //   209: aload 8
    //   211: invokevirtual 1270	java/util/zip/ZipOutputStream:close	()V
    //   214: goto +20 -> 234
    //   217: astore_0
    //   218: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +13 -> 234
    //   224: ldc 63
    //   226: iconst_2
    //   227: ldc_w 1272
    //   230: aload_0
    //   231: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload 6
    //   236: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   239: goto +20 -> 259
    //   242: astore_0
    //   243: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +13 -> 259
    //   249: ldc 63
    //   251: iconst_2
    //   252: ldc_w 1272
    //   255: aload_0
    //   256: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload_1
    //   260: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   263: iconst_1
    //   264: ireturn
    //   265: astore_0
    //   266: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +231 -> 500
    //   272: iload 4
    //   274: istore_3
    //   275: ldc 63
    //   277: iconst_2
    //   278: ldc_w 1272
    //   281: aload_0
    //   282: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: iload_3
    //   286: ireturn
    //   287: astore_0
    //   288: aload_1
    //   289: astore 7
    //   291: aload 8
    //   293: astore_1
    //   294: goto +216 -> 510
    //   297: astore_0
    //   298: aload 8
    //   300: astore 10
    //   302: aload_1
    //   303: astore 8
    //   305: aload 6
    //   307: astore_1
    //   308: goto +65 -> 373
    //   311: astore_0
    //   312: aload_1
    //   313: astore 8
    //   315: aload 6
    //   317: astore_1
    //   318: goto +55 -> 373
    //   321: astore 8
    //   323: aconst_null
    //   324: astore 6
    //   326: aload 6
    //   328: astore_0
    //   329: aload_1
    //   330: astore 7
    //   332: aload_0
    //   333: astore_1
    //   334: aload 8
    //   336: astore_0
    //   337: goto +173 -> 510
    //   340: astore_0
    //   341: aconst_null
    //   342: astore 6
    //   344: aload_1
    //   345: astore 8
    //   347: aload 6
    //   349: astore_1
    //   350: goto +23 -> 373
    //   353: astore_0
    //   354: aconst_null
    //   355: astore 6
    //   357: aload 6
    //   359: astore 7
    //   361: aload 7
    //   363: astore_1
    //   364: goto +146 -> 510
    //   367: astore_0
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_1
    //   371: astore 8
    //   373: aload 10
    //   375: astore 11
    //   377: aload 8
    //   379: astore 7
    //   381: aload_1
    //   382: astore 9
    //   384: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +24 -> 411
    //   390: aload 10
    //   392: astore 11
    //   394: aload 8
    //   396: astore 7
    //   398: aload_1
    //   399: astore 9
    //   401: ldc 63
    //   403: iconst_2
    //   404: ldc_w 1274
    //   407: aload_0
    //   408: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   411: aload 10
    //   413: ifnull +28 -> 441
    //   416: aload 10
    //   418: invokevirtual 1270	java/util/zip/ZipOutputStream:close	()V
    //   421: goto +20 -> 441
    //   424: astore_0
    //   425: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +13 -> 441
    //   431: ldc 63
    //   433: iconst_2
    //   434: ldc_w 1272
    //   437: aload_0
    //   438: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload_1
    //   442: ifnull +27 -> 469
    //   445: aload_1
    //   446: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   449: goto +20 -> 469
    //   452: astore_0
    //   453: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +13 -> 469
    //   459: ldc 63
    //   461: iconst_2
    //   462: ldc_w 1272
    //   465: aload_0
    //   466: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   469: iload 5
    //   471: istore_3
    //   472: aload 8
    //   474: ifnull +26 -> 500
    //   477: aload 8
    //   479: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   482: iconst_0
    //   483: ireturn
    //   484: astore_0
    //   485: iload 5
    //   487: istore_3
    //   488: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +9 -> 500
    //   494: iload 4
    //   496: istore_3
    //   497: goto -222 -> 275
    //   500: iload_3
    //   501: ireturn
    //   502: astore_0
    //   503: aload 11
    //   505: astore_1
    //   506: aload 9
    //   508: astore 6
    //   510: aload_1
    //   511: ifnull +27 -> 538
    //   514: aload_1
    //   515: invokevirtual 1270	java/util/zip/ZipOutputStream:close	()V
    //   518: goto +20 -> 538
    //   521: astore_1
    //   522: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +13 -> 538
    //   528: ldc 63
    //   530: iconst_2
    //   531: ldc_w 1272
    //   534: aload_1
    //   535: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   538: aload 6
    //   540: ifnull +28 -> 568
    //   543: aload 6
    //   545: invokevirtual 1110	java/io/BufferedOutputStream:close	()V
    //   548: goto +20 -> 568
    //   551: astore_1
    //   552: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +13 -> 568
    //   558: ldc 63
    //   560: iconst_2
    //   561: ldc_w 1272
    //   564: aload_1
    //   565: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   568: aload 7
    //   570: ifnull +28 -> 598
    //   573: aload 7
    //   575: invokevirtual 339	java/io/FileOutputStream:close	()V
    //   578: goto +20 -> 598
    //   581: astore_1
    //   582: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +13 -> 598
    //   588: ldc 63
    //   590: iconst_2
    //   591: ldc_w 1272
    //   594: aload_1
    //   595: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   598: goto +5 -> 603
    //   601: aload_0
    //   602: athrow
    //   603: goto -2 -> 601
    //   606: astore 7
    //   608: goto -425 -> 183
    //   611: astore 7
    //   613: aconst_null
    //   614: astore_0
    //   615: goto -432 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	paramList	List<String>
    //   0	618	1	paramString	String
    //   148	12	2	i	int
    //   205	296	3	bool1	boolean
    //   4	491	4	bool2	boolean
    //   1	485	5	bool3	boolean
    //   36	508	6	localObject1	Object
    //   39	535	7	localObject2	Object
    //   606	1	7	localObject3	Object
    //   611	1	7	localObject4	Object
    //   54	260	8	localObject5	Object
    //   321	14	8	localObject6	Object
    //   345	133	8	str	String
    //   43	464	9	localObject7	Object
    //   10	407	10	localObject8	Object
    //   7	497	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   209	214	217	java/io/IOException
    //   234	239	242	java/io/IOException
    //   259	263	265	java/io/IOException
    //   56	64	287	finally
    //   64	122	287	finally
    //   166	180	287	finally
    //   187	191	287	finally
    //   191	204	287	finally
    //   56	64	297	java/lang/Exception
    //   64	122	297	java/lang/Exception
    //   166	180	297	java/lang/Exception
    //   187	191	297	java/lang/Exception
    //   191	204	297	java/lang/Exception
    //   45	56	311	java/lang/Exception
    //   28	38	321	finally
    //   28	38	340	java/lang/Exception
    //   12	28	353	finally
    //   12	28	367	java/lang/Exception
    //   416	421	424	java/io/IOException
    //   445	449	452	java/io/IOException
    //   477	482	484	java/io/IOException
    //   45	56	502	finally
    //   384	390	502	finally
    //   401	411	502	finally
    //   514	518	521	java/io/IOException
    //   543	548	551	java/io/IOException
    //   573	578	581	java/io/IOException
    //   131	138	606	finally
    //   138	149	606	finally
    //   154	163	606	finally
    //   122	131	611	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */