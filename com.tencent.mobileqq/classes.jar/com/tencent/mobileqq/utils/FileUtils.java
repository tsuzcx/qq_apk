package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import bhea;
import com.qq.taf.jce.HexUtil;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import nwo;

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
  public static Runnable sCheckFolderTask = new FileUtils.1();
  public static boolean sNeedReportFailure = true;
  public static String unKnownFileTypeMark = "unknown_";
  
  public static String byteCountToDisplaySize(int paramInt, long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      if (paramInt == 0) {
        str = "0.0B";
      }
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "0.0K";
      }
      str = null;
      DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
      float f;
      if (paramLong / 1073741824L > 0L)
      {
        f = (float)paramLong / 1.073742E+009F;
        str = localDecimalFormat.format(f);
        if (str.endsWith(".0")) {
          return (int)f + "G";
        }
        return str + "G";
      }
      if (paramLong / 1048576L > 0L)
      {
        f = (float)paramLong / 1048576.0F;
        str = localDecimalFormat.format(f);
        if (str.endsWith(".0")) {
          return (int)f + "M";
        }
        return str + "M";
      }
      if (paramLong / 1024L > 0L)
      {
        paramInt = (int)(paramLong / 1024L);
        return paramInt + "K";
      }
      if (paramInt == 0) {
        return localDecimalFormat.format(paramLong) + "B";
      }
    } while (paramInt != 1);
    paramInt = (int)(paramLong / 1024L);
    return paramInt + "K";
  }
  
  public static String calcMd5(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    long l;
    do
    {
      return null;
      l = localFile.length();
    } while (l == 0L);
    return calcMd5(paramString, l);
  }
  
  public static String calcMd5(String paramString, long paramLong)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      if (paramString == null) {
        break label81;
      }
      String str = HexUtil.bytes2HexStr(MD5.toMD5Byte(paramString, paramLong));
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        break label58;
      }
    }
    catch (FileNotFoundException paramString)
    {
      do
      {
        paramString.printStackTrace();
        if (0 == 0) {
          break;
        }
        paramString = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, paramLong));
      } while (TextUtils.isEmpty(paramString));
      label58:
      return paramString;
    }
    finally
    {
      do
      {
        if (0 == 0) {
          break;
        }
      } while (TextUtils.isEmpty(HexUtil.bytes2HexStr(MD5.toMD5Byte(null, paramLong))));
    }
    return null;
    for (;;)
    {
      label81:
      paramString = null;
    }
  }
  
  public static boolean checkDiskCacheExist()
  {
    return fileExists(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/" + "diskcache");
  }
  
  public static boolean checkFolder(Context paramContext)
  {
    return checkFolder(paramContext, true);
  }
  
  /* Error */
  public static boolean checkFolder(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 208
    //   2: invokestatic 213	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   5: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +61 -> 71
    //   13: new 141	java/io/File
    //   16: dup
    //   17: getstatic 185	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   20: invokestatic 190	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 4
    //   28: new 141	java/io/File
    //   31: dup
    //   32: aload 4
    //   34: ldc 194
    //   36: invokespecial 220	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 146	java/io/File:exists	()Z
    //   46: ifeq +36 -> 82
    //   49: iconst_1
    //   50: istore_3
    //   51: iload_3
    //   52: ireturn
    //   53: astore_0
    //   54: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +12 -> 69
    //   60: ldc 63
    //   62: iconst_2
    //   63: ldc 227
    //   65: aload_0
    //   66: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: getstatic 237	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   74: invokevirtual 241	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   77: astore 4
    //   79: goto -51 -> 28
    //   82: aload 4
    //   84: invokevirtual 244	java/io/File:mkdirs	()Z
    //   87: istore_2
    //   88: getstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   91: ifne +7 -> 98
    //   94: iconst_1
    //   95: putstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   98: iload_2
    //   99: ifne +36 -> 135
    //   102: invokestatic 247	com/tencent/mobileqq/utils/FileUtils:checkTencentFolderExist	()Z
    //   105: ifeq +15 -> 120
    //   108: invokestatic 250	com/tencent/mobileqq/utils/FileUtils:checkMobileQQFolderExist	()Z
    //   111: ifeq +9 -> 120
    //   114: invokestatic 252	com/tencent/mobileqq/utils/FileUtils:checkDiskCacheExist	()Z
    //   117: ifne +18 -> 135
    //   120: invokestatic 258	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   123: new 260	com/tencent/mobileqq/utils/FileUtils$2
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 263	com/tencent/mobileqq/utils/FileUtils$2:<init>	(Landroid/content/Context;)V
    //   131: invokevirtual 269	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   134: pop
    //   135: iload_2
    //   136: istore_3
    //   137: iload_1
    //   138: ifeq -87 -> 51
    //   141: iload_2
    //   142: ifne +11 -> 153
    //   145: iload_2
    //   146: istore_3
    //   147: getstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   150: ifeq -99 -> 51
    //   153: iload_2
    //   154: invokestatic 275	azkd:a	(Z)V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_2
    //   160: ifne -109 -> 51
    //   163: iconst_0
    //   164: putstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   167: iload_2
    //   168: ireturn
    //   169: astore 4
    //   171: invokestatic 247	com/tencent/mobileqq/utils/FileUtils:checkTencentFolderExist	()Z
    //   174: ifeq +15 -> 189
    //   177: invokestatic 250	com/tencent/mobileqq/utils/FileUtils:checkMobileQQFolderExist	()Z
    //   180: ifeq +9 -> 189
    //   183: invokestatic 252	com/tencent/mobileqq/utils/FileUtils:checkDiskCacheExist	()Z
    //   186: ifne +18 -> 204
    //   189: invokestatic 258	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   192: new 260	com/tencent/mobileqq/utils/FileUtils$2
    //   195: dup
    //   196: aload_0
    //   197: invokespecial 263	com/tencent/mobileqq/utils/FileUtils$2:<init>	(Landroid/content/Context;)V
    //   200: invokevirtual 269	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   203: pop
    //   204: iload_1
    //   205: ifeq +94 -> 299
    //   208: getstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   211: ifeq +88 -> 299
    //   214: iconst_0
    //   215: invokestatic 275	azkd:a	(Z)V
    //   218: iconst_0
    //   219: putstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   222: iconst_0
    //   223: ireturn
    //   224: astore 4
    //   226: iconst_0
    //   227: istore_2
    //   228: iload_2
    //   229: ifne +36 -> 265
    //   232: invokestatic 247	com/tencent/mobileqq/utils/FileUtils:checkTencentFolderExist	()Z
    //   235: ifeq +15 -> 250
    //   238: invokestatic 250	com/tencent/mobileqq/utils/FileUtils:checkMobileQQFolderExist	()Z
    //   241: ifeq +9 -> 250
    //   244: invokestatic 252	com/tencent/mobileqq/utils/FileUtils:checkDiskCacheExist	()Z
    //   247: ifne +18 -> 265
    //   250: invokestatic 258	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   253: new 260	com/tencent/mobileqq/utils/FileUtils$2
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 263	com/tencent/mobileqq/utils/FileUtils$2:<init>	(Landroid/content/Context;)V
    //   261: invokevirtual 269	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   264: pop
    //   265: iload_1
    //   266: ifeq +25 -> 291
    //   269: iload_2
    //   270: ifne +9 -> 279
    //   273: getstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   276: ifeq +15 -> 291
    //   279: iload_2
    //   280: invokestatic 275	azkd:a	(Z)V
    //   283: iload_2
    //   284: ifne +7 -> 291
    //   287: iconst_0
    //   288: putstatic 72	com/tencent/mobileqq/utils/FileUtils:sNeedReportFailure	Z
    //   291: aload 4
    //   293: athrow
    //   294: astore 4
    //   296: goto -68 -> 228
    //   299: iconst_0
    //   300: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramBoolean	boolean
    //   8	276	2	bool1	boolean
    //   50	109	3	bool2	boolean
    //   26	57	4	localFile	File
    //   169	1	4	localException	Exception
    //   224	68	4	localObject1	Object
    //   294	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/lang/NullPointerException
    //   82	88	169	java/lang/Exception
    //   88	98	169	java/lang/Exception
    //   82	88	224	finally
    //   88	98	294	finally
  }
  
  public static boolean checkMobileQQFolderExist()
  {
    return fileExists(AppConstants.SDCARD_PATH);
  }
  
  public static boolean checkTencentFolderExist()
  {
    return fileExists(AppConstants.SDCARD_ROOT + "/Tencent/");
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
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        AssetManager localAssetManager = paramContext.getAssets();
        String[] arrayOfString = localAssetManager.list(paramString1);
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          Object localObject = arrayOfString[i];
          String str1 = paramString1 + File.separator + (String)localObject;
          String str2 = paramString2 + File.separator + (String)localObject;
          if (localAssetManager.list(str1).length == 0)
          {
            copyAssetToFile(paramContext, str1, str2);
          }
          else
          {
            localObject = new File(paramString2 + File.separator + (String)localObject);
            if (!((File)localObject).exists()) {
              ((File)localObject).mkdirs();
            }
            copyAssetDirsToSdcard(paramContext, str1, str2);
          }
        }
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      return true;
      i += 1;
    }
  }
  
  /* Error */
  public static boolean copyAssetToFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: iconst_0
    //   10: istore 5
    //   12: new 313	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 314	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore 6
    //   24: aload 9
    //   26: astore 7
    //   28: new 316	java/io/BufferedInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokevirtual 296	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   36: aload_1
    //   37: invokevirtual 320	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: sipush 8192
    //   47: newarray byte
    //   49: astore_1
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 327	java/io/BufferedInputStream:read	([B)I
    //   55: istore_3
    //   56: iload_3
    //   57: iconst_m1
    //   58: if_icmpeq +57 -> 115
    //   61: aload_2
    //   62: aload_1
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 333	java/io/OutputStream:write	([BII)V
    //   68: goto -18 -> 50
    //   71: astore 6
    //   73: aload_0
    //   74: astore_1
    //   75: aload 6
    //   77: astore_0
    //   78: aload_2
    //   79: astore 6
    //   81: aload_1
    //   82: astore 7
    //   84: aload_0
    //   85: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   96: iload 5
    //   98: istore 4
    //   100: aload_2
    //   101: ifnull +11 -> 112
    //   104: aload_2
    //   105: invokevirtual 335	java/io/OutputStream:close	()V
    //   108: iload 5
    //   110: istore 4
    //   112: iload 4
    //   114: ireturn
    //   115: iconst_1
    //   116: istore 4
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   126: aload_2
    //   127: ifnull -15 -> 112
    //   130: aload_2
    //   131: invokevirtual 335	java/io/OutputStream:close	()V
    //   134: iconst_1
    //   135: ireturn
    //   136: astore_0
    //   137: iconst_1
    //   138: ireturn
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_2
    //   142: aload 7
    //   144: ifnull +8 -> 152
    //   147: aload 7
    //   149: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 335	java/io/OutputStream:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -37 -> 126
    //   166: astore_0
    //   167: goto -71 -> 96
    //   170: astore_0
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_1
    //   174: goto -22 -> 152
    //   177: astore_1
    //   178: goto -18 -> 160
    //   181: astore_0
    //   182: aload 6
    //   184: astore_2
    //   185: goto -43 -> 142
    //   188: astore_1
    //   189: aload_0
    //   190: astore 7
    //   192: aload_1
    //   193: astore_0
    //   194: goto -52 -> 142
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_2
    //   200: aload 8
    //   202: astore_1
    //   203: goto -125 -> 78
    //   206: astore_0
    //   207: aload 8
    //   209: astore_1
    //   210: goto -132 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramContext	Context
    //   0	213	1	paramString1	String
    //   0	213	2	paramString2	String
    //   55	10	3	i	int
    //   98	19	4	bool1	boolean
    //   10	99	5	bool2	boolean
    //   22	1	6	str1	String
    //   71	5	6	localIOException	IOException
    //   79	104	6	str2	String
    //   1	190	7	localObject1	Object
    //   7	201	8	localObject2	Object
    //   4	21	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	71	java/io/IOException
    //   50	56	71	java/io/IOException
    //   61	68	71	java/io/IOException
    //   130	134	136	java/io/IOException
    //   12	21	139	finally
    //   122	126	162	java/io/IOException
    //   92	96	166	java/io/IOException
    //   104	108	170	java/io/IOException
    //   147	152	173	java/io/IOException
    //   156	160	177	java/io/IOException
    //   28	44	181	finally
    //   84	88	181	finally
    //   44	50	188	finally
    //   50	56	188	finally
    //   61	68	188	finally
    //   12	21	197	java/io/IOException
    //   28	44	206	java/io/IOException
  }
  
  public static int copyDirectory(String paramString1, String paramString2, boolean paramBoolean)
  {
    return copyDirectory(paramString1, paramString2, paramBoolean, false, false);
  }
  
  public static int copyDirectory(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    paramString1 = new File(paramString1);
    int i;
    if (!paramString1.exists()) {
      i = -1;
    }
    File localFile1;
    int j;
    do
    {
      return i;
      paramString1 = paramString1.listFiles();
      if (paramString1 == null) {
        return -1;
      }
      localFile1 = new File(paramString2);
      if (!localFile1.exists()) {
        localFile1.mkdirs();
      }
      j = 0;
      i = k;
    } while (j >= paramString1.length);
    if (paramString1[j].isDirectory()) {
      copyDirectory(paramString1[j].getPath() + "/", paramString2 + paramString1[j].getName() + "/", paramBoolean1);
    }
    for (;;)
    {
      j += 1;
      break;
      localFile1 = new File(paramString1[j].getPath());
      File localFile2 = new File(paramString2 + paramString1[j].getName());
      if ((localFile1 != null) && (localFile2 != null) && (localFile1.exists()))
      {
        if ((paramBoolean2) && (localFile2.exists()) && (!localFile2.delete()) && (paramBoolean3)) {
          QLog.d("FileUtils", 1, new Object[] { "copyDirectory fail, delete file name:", localFile1.getPath() });
        }
        if (localFile2.exists()) {}
      }
      try
      {
        localFile2.createNewFile();
        if ((!copyFile(localFile1, localFile2, paramBoolean3)) && (paramBoolean3)) {
          QLog.d("FileUtils", 1, new Object[] { "copyDirectory fail, file name:", localFile1.getPath() });
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (paramBoolean3) {
            QLog.e("FileUtils", 1, "copyDirectory error, ", localIOException);
          }
        }
      }
      if (paramBoolean1) {
        localFile1.delete();
      }
    }
  }
  
  public static int copyDocumentItemsToAnotherDocument(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.isDirectory()) {
      return -1;
    }
    File localFile = new File(paramString2);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    paramString1 = paramString1.listFiles();
    if (paramString1.length == 0) {
      return -2;
    }
    int i = 0;
    if (i < paramString1.length)
    {
      if (paramString1[i].isDirectory()) {
        copyDocumentItemsToAnotherDocument(paramString1[i].getPath() + "/" + paramString1[i], paramString2 + "/" + paramString1[i].getName());
      }
      for (;;)
      {
        i += 1;
        break;
        copyFile(new File(paramString1[i].getPath()), new File(paramString2 + "/" + paramString1[i].getName()));
      }
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
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: iconst_1
    //   13: istore 5
    //   15: aload_1
    //   16: invokevirtual 146	java/io/File:exists	()Z
    //   19: ifeq +19 -> 38
    //   22: aload_0
    //   23: invokevirtual 390	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: aload_1
    //   27: invokevirtual 390	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   30: invokestatic 395	bbqk:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokevirtual 358	java/io/File:delete	()Z
    //   37: pop
    //   38: aload_1
    //   39: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   42: ifnull +21 -> 63
    //   45: aload_1
    //   46: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   49: invokevirtual 146	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_1
    //   56: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   59: invokevirtual 244	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: new 313	java/io/FileOutputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: astore_1
    //   72: aload 7
    //   74: astore 6
    //   76: aload_1
    //   77: astore 7
    //   79: new 316	java/io/BufferedInputStream
    //   82: dup
    //   83: new 157	java/io/FileInputStream
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_0
    //   95: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   98: sipush 4096
    //   101: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   104: astore 6
    //   106: aload_0
    //   107: aload 6
    //   109: invokevirtual 327	java/io/BufferedInputStream:read	([B)I
    //   112: istore_3
    //   113: iload_3
    //   114: iconst_m1
    //   115: if_icmpeq +66 -> 181
    //   118: aload_1
    //   119: aload 6
    //   121: iconst_0
    //   122: iload_3
    //   123: invokevirtual 413	java/io/FileOutputStream:write	([BII)V
    //   126: aload_1
    //   127: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   130: goto -24 -> 106
    //   133: astore 7
    //   135: aload_0
    //   136: astore 6
    //   138: aload_1
    //   139: astore_0
    //   140: aload 7
    //   142: astore_1
    //   143: iload_2
    //   144: ifeq +13 -> 157
    //   147: ldc 63
    //   149: iconst_1
    //   150: ldc_w 418
    //   153: aload_1
    //   154: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   165: aload 6
    //   167: ifnull +331 -> 498
    //   170: aload 6
    //   172: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   175: iconst_0
    //   176: istore 4
    //   178: iload 4
    //   180: ireturn
    //   181: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   184: aload 6
    //   186: invokevirtual 423	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   197: iload 5
    //   199: istore 4
    //   201: aload_0
    //   202: ifnull -24 -> 178
    //   205: aload_0
    //   206: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   209: iconst_1
    //   210: ireturn
    //   211: astore_0
    //   212: iload 5
    //   214: istore 4
    //   216: iload_2
    //   217: ifeq -39 -> 178
    //   220: ldc 63
    //   222: iconst_1
    //   223: ldc_w 418
    //   226: aload_0
    //   227: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: iconst_1
    //   231: ireturn
    //   232: astore_1
    //   233: iload_2
    //   234: ifeq -37 -> 197
    //   237: ldc 63
    //   239: iconst_1
    //   240: ldc_w 418
    //   243: aload_1
    //   244: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: goto -50 -> 197
    //   250: astore_0
    //   251: iload_2
    //   252: ifeq -87 -> 165
    //   255: ldc 63
    //   257: iconst_1
    //   258: ldc_w 418
    //   261: aload_0
    //   262: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: goto -100 -> 165
    //   268: astore_0
    //   269: iload_2
    //   270: ifeq +13 -> 283
    //   273: ldc 63
    //   275: iconst_1
    //   276: ldc_w 418
    //   279: aload_0
    //   280: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: iconst_0
    //   284: ireturn
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_1
    //   288: aload 9
    //   290: astore 8
    //   292: iload_2
    //   293: ifeq +20 -> 313
    //   296: aload 8
    //   298: astore 6
    //   300: aload_1
    //   301: astore 7
    //   303: ldc 63
    //   305: iconst_1
    //   306: ldc_w 418
    //   309: aload_0
    //   310: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   313: aload_1
    //   314: ifnull +7 -> 321
    //   317: aload_1
    //   318: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   321: aload 8
    //   323: ifnull +175 -> 498
    //   326: aload 8
    //   328: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   331: iconst_0
    //   332: ireturn
    //   333: astore_0
    //   334: iload_2
    //   335: ifeq -14 -> 321
    //   338: ldc 63
    //   340: iconst_1
    //   341: ldc_w 418
    //   344: aload_0
    //   345: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   348: goto -27 -> 321
    //   351: astore_0
    //   352: iload_2
    //   353: ifeq +13 -> 366
    //   356: ldc 63
    //   358: iconst_1
    //   359: ldc_w 418
    //   362: aload_0
    //   363: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: iconst_0
    //   367: ireturn
    //   368: astore_0
    //   369: aconst_null
    //   370: astore_1
    //   371: aload_1
    //   372: ifnull +7 -> 379
    //   375: aload_1
    //   376: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   379: aload 6
    //   381: ifnull +8 -> 389
    //   384: aload 6
    //   386: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   389: aload_0
    //   390: athrow
    //   391: astore_1
    //   392: iload_2
    //   393: ifeq -14 -> 379
    //   396: ldc 63
    //   398: iconst_1
    //   399: ldc_w 418
    //   402: aload_1
    //   403: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   406: goto -27 -> 379
    //   409: astore_1
    //   410: iload_2
    //   411: ifeq -22 -> 389
    //   414: ldc 63
    //   416: iconst_1
    //   417: ldc_w 418
    //   420: aload_1
    //   421: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   424: goto -35 -> 389
    //   427: astore_0
    //   428: aload 7
    //   430: astore_1
    //   431: goto -60 -> 371
    //   434: astore 7
    //   436: aload_0
    //   437: astore 6
    //   439: aload 7
    //   441: astore_0
    //   442: goto -71 -> 371
    //   445: astore 7
    //   447: aload_0
    //   448: astore_1
    //   449: aload 7
    //   451: astore_0
    //   452: goto -81 -> 371
    //   455: astore_0
    //   456: aload 9
    //   458: astore 8
    //   460: goto -168 -> 292
    //   463: astore 6
    //   465: aload_0
    //   466: astore 8
    //   468: aload 6
    //   470: astore_0
    //   471: goto -179 -> 292
    //   474: astore_1
    //   475: aconst_null
    //   476: astore_0
    //   477: aload 8
    //   479: astore 6
    //   481: goto -338 -> 143
    //   484: astore 6
    //   486: aload_1
    //   487: astore_0
    //   488: aload 6
    //   490: astore_1
    //   491: aload 8
    //   493: astore 6
    //   495: goto -352 -> 143
    //   498: iconst_0
    //   499: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	paramFile1	File
    //   0	500	1	paramFile2	File
    //   0	500	2	paramBoolean	boolean
    //   112	11	3	i	int
    //   176	39	4	bool1	boolean
    //   13	200	5	bool2	boolean
    //   4	434	6	localObject1	Object
    //   463	6	6	localOutOfMemoryError	OutOfMemoryError
    //   479	1	6	localObject2	Object
    //   484	5	6	localIOException1	IOException
    //   493	1	6	localObject3	Object
    //   7	71	7	localFile1	File
    //   133	8	7	localIOException2	IOException
    //   301	128	7	localFile2	File
    //   434	6	7	localObject4	Object
    //   445	5	7	localObject5	Object
    //   10	482	8	localObject6	Object
    //   1	456	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   95	106	133	java/io/IOException
    //   106	113	133	java/io/IOException
    //   118	130	133	java/io/IOException
    //   181	189	133	java/io/IOException
    //   205	209	211	java/io/IOException
    //   193	197	232	java/io/IOException
    //   161	165	250	java/io/IOException
    //   170	175	268	java/io/IOException
    //   15	38	285	java/lang/OutOfMemoryError
    //   38	63	285	java/lang/OutOfMemoryError
    //   63	72	285	java/lang/OutOfMemoryError
    //   317	321	333	java/io/IOException
    //   326	331	351	java/io/IOException
    //   15	38	368	finally
    //   38	63	368	finally
    //   63	72	368	finally
    //   375	379	391	java/io/IOException
    //   384	389	409	java/io/IOException
    //   79	95	427	finally
    //   303	313	427	finally
    //   95	106	434	finally
    //   106	113	434	finally
    //   118	130	434	finally
    //   181	189	434	finally
    //   147	157	445	finally
    //   79	95	455	java/lang/OutOfMemoryError
    //   95	106	463	java/lang/OutOfMemoryError
    //   106	113	463	java/lang/OutOfMemoryError
    //   118	130	463	java/lang/OutOfMemoryError
    //   181	189	463	java/lang/OutOfMemoryError
    //   15	38	474	java/io/IOException
    //   38	63	474	java/io/IOException
    //   63	72	474	java/io/IOException
    //   79	95	484	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    File localFile = new File(paramString1);
    if (localFile.exists()) {}
    try
    {
      bool = copyFile(localFile, createFile(paramString2));
      return bool;
    }
    catch (IOException localIOException)
    {
      QLog.d("FileUtils", 2, "copy fail from " + paramString1 + " to " + paramString2 + " " + localIOException.getMessage());
    }
    return false;
  }
  
  /* Error */
  public static long copyFileUsingFileChannels(File paramFile1, File paramFile2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: new 157	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokevirtual 446	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore_0
    //   18: aload 9
    //   20: astore 8
    //   22: new 313	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokevirtual 447	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: astore_1
    //   34: iload_2
    //   35: i2l
    //   36: lstore 4
    //   38: iload_3
    //   39: i2l
    //   40: lstore 6
    //   42: aload_1
    //   43: astore 8
    //   45: aload_1
    //   46: aload_0
    //   47: lload 4
    //   49: lload 6
    //   51: invokevirtual 453	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   54: lstore 4
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   64: aload_1
    //   65: ifnull +89 -> 154
    //   68: aload_1
    //   69: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   72: lload 4
    //   74: lreturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   86: aload 8
    //   88: ifnull +64 -> 152
    //   91: aload 8
    //   93: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   96: lconst_0
    //   97: lreturn
    //   98: astore_0
    //   99: aconst_null
    //   100: astore 8
    //   102: aconst_null
    //   103: astore_1
    //   104: aload 8
    //   106: ifnull +8 -> 114
    //   109: aload 8
    //   111: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore 9
    //   126: aload_0
    //   127: astore 8
    //   129: aconst_null
    //   130: astore_1
    //   131: aload 9
    //   133: astore_0
    //   134: goto -30 -> 104
    //   137: astore 9
    //   139: aload_0
    //   140: astore 8
    //   142: aload 9
    //   144: astore_0
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -71 -> 78
    //   152: lconst_0
    //   153: lreturn
    //   154: lload 4
    //   156: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramFile1	File
    //   0	157	1	paramFile2	File
    //   0	157	2	paramInt1	int
    //   0	157	3	paramInt2	int
    //   36	119	4	l1	long
    //   40	10	6	l2	long
    //   4	137	8	localObject1	Object
    //   1	18	9	localObject2	Object
    //   124	8	9	localObject3	Object
    //   137	6	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	75	java/io/FileNotFoundException
    //   6	18	98	finally
    //   22	34	124	finally
    //   45	56	137	finally
    //   22	34	148	java/io/FileNotFoundException
    //   45	56	148	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void copyResToFile(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: iload_1
    //   5: ifeq +10 -> 15
    //   8: aload_2
    //   9: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: invokevirtual 460	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: iload_1
    //   21: invokevirtual 466	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   24: checkcast 468	com/tencent/theme/SkinnableBitmapDrawable
    //   27: astore_3
    //   28: new 141	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokevirtual 146	java/io/File:exists	()Z
    //   41: ifne +16 -> 57
    //   44: aload_0
    //   45: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   48: invokevirtual 244	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_0
    //   53: invokevirtual 367	java/io/File:createNewFile	()Z
    //   56: pop
    //   57: new 313	java/io/FileOutputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_0
    //   66: aload_3
    //   67: invokevirtual 472	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   70: getstatic 478	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_0
    //   76: invokevirtual 484	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload_0
    //   81: ifnull -66 -> 15
    //   84: aload_0
    //   85: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   88: return
    //   89: astore_0
    //   90: return
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   96: goto -39 -> 57
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull -88 -> 15
    //   106: aload_0
    //   107: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   110: return
    //   111: astore_0
    //   112: return
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull -102 -> 15
    //   120: aload_0
    //   121: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   124: return
    //   125: astore_0
    //   126: return
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   138: aload_2
    //   139: athrow
    //   140: astore_0
    //   141: goto -3 -> 138
    //   144: astore_2
    //   145: goto -15 -> 130
    //   148: astore_2
    //   149: goto -33 -> 116
    //   152: astore_2
    //   153: goto -51 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramContext	Context
    //   0	156	1	paramInt	int
    //   0	156	2	paramString	String
    //   27	40	3	localSkinnableBitmapDrawable	com.tencent.theme.SkinnableBitmapDrawable
    // Exception table:
    //   from	to	target	type
    //   84	88	89	java/io/IOException
    //   52	57	91	java/io/IOException
    //   57	66	99	java/io/IOException
    //   106	110	111	java/io/IOException
    //   57	66	113	java/lang/OutOfMemoryError
    //   120	124	125	java/io/IOException
    //   57	66	127	finally
    //   134	138	140	java/io/IOException
    //   66	80	144	finally
    //   66	80	148	java/lang/OutOfMemoryError
    //   66	80	152	java/io/IOException
  }
  
  public static File createDirectory(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.mkdirs();
      }
    }
    return paramString;
    label50:
    paramString.mkdirs();
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
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.mkdirs();
      }
    }
    return paramString;
    label50:
    paramString.mkdirs();
    return paramString;
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
  
  public static void createFileIfNotExits(String paramString)
  {
    if (!fileExists(paramString)) {}
    try
    {
      createFile(paramString);
      return;
    }
    catch (IOException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FileUtils", 2, "createFileIfNotExits", paramString);
    }
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static void deleteDirectory(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    paramString = new File(paramString);
    File[] arrayOfFile = paramString.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i = 0;
      if (i < arrayOfFile.length)
      {
        if (arrayOfFile[i].isDirectory()) {
          deleteDirectory(arrayOfFile[i].getAbsolutePath());
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFile[i].delete();
        }
      }
    }
    paramString.delete();
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
      QLog.e("FileUtils", 1, "deleteFile error");
    }
  }
  
  public static boolean deleteFile(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    do
    {
      return bool;
      bool = true;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return paramString.delete();
  }
  
  public static void deleteFilesInDirectory(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    do
    {
      return;
      paramString = new File(paramString).listFiles();
    } while ((paramString == null) || (paramString.length <= 0));
    int i = 0;
    label38:
    if (i < paramString.length)
    {
      if (!paramString[i].isDirectory()) {
        break label69;
      }
      deleteDirectory(paramString[i].getAbsolutePath());
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label69:
      paramString[i].delete();
    }
  }
  
  public static boolean deleteVFSFile(String paramString)
  {
    boolean bool = true;
    paramString = new VFSFile(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  /* Error */
  public static String encryptFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 141	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +17 -> 29
    //   15: aload_0
    //   16: invokevirtual 146	java/io/File:exists	()Z
    //   19: ifeq +10 -> 29
    //   22: aload_0
    //   23: invokevirtual 510	java/io/File:isFile	()Z
    //   26: ifne +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokestatic 541	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore 4
    //   37: new 157	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   49: sipush 8192
    //   52: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   55: astore 5
    //   57: bipush 16
    //   59: newarray char
    //   61: astore_0
    //   62: aload_0
    //   63: dup
    //   64: iconst_0
    //   65: ldc_w 542
    //   68: castore
    //   69: dup
    //   70: iconst_1
    //   71: ldc_w 543
    //   74: castore
    //   75: dup
    //   76: iconst_2
    //   77: ldc_w 544
    //   80: castore
    //   81: dup
    //   82: iconst_3
    //   83: ldc_w 545
    //   86: castore
    //   87: dup
    //   88: iconst_4
    //   89: ldc_w 546
    //   92: castore
    //   93: dup
    //   94: iconst_5
    //   95: ldc_w 547
    //   98: castore
    //   99: dup
    //   100: bipush 6
    //   102: ldc_w 548
    //   105: castore
    //   106: dup
    //   107: bipush 7
    //   109: ldc_w 549
    //   112: castore
    //   113: dup
    //   114: bipush 8
    //   116: ldc_w 550
    //   119: castore
    //   120: dup
    //   121: bipush 9
    //   123: ldc_w 551
    //   126: castore
    //   127: dup
    //   128: bipush 10
    //   130: ldc_w 552
    //   133: castore
    //   134: dup
    //   135: bipush 11
    //   137: ldc_w 553
    //   140: castore
    //   141: dup
    //   142: bipush 12
    //   144: ldc_w 554
    //   147: castore
    //   148: dup
    //   149: bipush 13
    //   151: ldc_w 555
    //   154: castore
    //   155: dup
    //   156: bipush 14
    //   158: ldc_w 556
    //   161: castore
    //   162: dup
    //   163: bipush 15
    //   165: ldc_w 557
    //   168: castore
    //   169: pop
    //   170: aload_1
    //   171: aload 5
    //   173: invokevirtual 558	java/io/FileInputStream:read	([B)I
    //   176: istore_3
    //   177: iload_3
    //   178: ifle +28 -> 206
    //   181: aload 4
    //   183: aload 5
    //   185: iconst_0
    //   186: iload_3
    //   187: invokevirtual 561	java/security/MessageDigest:update	([BII)V
    //   190: goto -20 -> 170
    //   193: astore_0
    //   194: aload_1
    //   195: ifnull +203 -> 398
    //   198: aload_1
    //   199: invokevirtual 562	java/io/FileInputStream:close	()V
    //   202: aconst_null
    //   203: astore_0
    //   204: aload_0
    //   205: areturn
    //   206: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   209: aload 5
    //   211: invokevirtual 423	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   214: aload 4
    //   216: invokevirtual 566	java/security/MessageDigest:digest	()[B
    //   219: astore 4
    //   221: aload 4
    //   223: ifnull +11 -> 234
    //   226: aload 4
    //   228: arraylength
    //   229: istore_3
    //   230: iload_3
    //   231: ifne +16 -> 247
    //   234: aload_1
    //   235: ifnull -206 -> 29
    //   238: aload_1
    //   239: invokevirtual 562	java/io/FileInputStream:close	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aconst_null
    //   246: areturn
    //   247: aload 4
    //   249: arraylength
    //   250: iconst_2
    //   251: imul
    //   252: newarray char
    //   254: astore 5
    //   256: iload_2
    //   257: aload 4
    //   259: arraylength
    //   260: if_icmpge +44 -> 304
    //   263: aload 4
    //   265: iload_2
    //   266: baload
    //   267: istore_3
    //   268: aload 5
    //   270: iload_2
    //   271: iconst_2
    //   272: imul
    //   273: iconst_1
    //   274: iadd
    //   275: aload_0
    //   276: iload_3
    //   277: bipush 15
    //   279: iand
    //   280: caload
    //   281: castore
    //   282: aload 5
    //   284: iload_2
    //   285: iconst_2
    //   286: imul
    //   287: aload_0
    //   288: iload_3
    //   289: iconst_4
    //   290: iushr
    //   291: i2b
    //   292: bipush 15
    //   294: iand
    //   295: caload
    //   296: castore
    //   297: iload_2
    //   298: iconst_1
    //   299: iadd
    //   300: istore_2
    //   301: goto -45 -> 256
    //   304: new 107	java/lang/String
    //   307: dup
    //   308: aload 5
    //   310: invokespecial 569	java/lang/String:<init>	([C)V
    //   313: astore 4
    //   315: aload 4
    //   317: astore_0
    //   318: aload_1
    //   319: ifnull -115 -> 204
    //   322: aload_1
    //   323: invokevirtual 562	java/io/FileInputStream:close	()V
    //   326: aload 4
    //   328: astore_0
    //   329: goto -125 -> 204
    //   332: astore_0
    //   333: aload 4
    //   335: astore_0
    //   336: goto -132 -> 204
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_0
    //   342: goto -138 -> 204
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_1
    //   348: aload_1
    //   349: ifnull +49 -> 398
    //   352: aload_1
    //   353: invokevirtual 562	java/io/FileInputStream:close	()V
    //   356: aconst_null
    //   357: astore_0
    //   358: goto -154 -> 204
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_0
    //   364: goto -160 -> 204
    //   367: astore_0
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_1
    //   371: ifnull +7 -> 378
    //   374: aload_1
    //   375: invokevirtual 562	java/io/FileInputStream:close	()V
    //   378: aload_0
    //   379: athrow
    //   380: astore_1
    //   381: goto -3 -> 378
    //   384: astore_0
    //   385: goto -15 -> 370
    //   388: astore_0
    //   389: goto -41 -> 348
    //   392: astore_0
    //   393: aconst_null
    //   394: astore_1
    //   395: goto -201 -> 194
    //   398: aconst_null
    //   399: astore_0
    //   400: goto -196 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramString1	String
    //   0	403	1	paramString2	String
    //   1	300	2	i	int
    //   176	115	3	j	int
    //   35	299	4	localObject1	Object
    //   55	254	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	170	193	java/io/IOException
    //   170	177	193	java/io/IOException
    //   181	190	193	java/io/IOException
    //   206	221	193	java/io/IOException
    //   226	230	193	java/io/IOException
    //   247	256	193	java/io/IOException
    //   256	263	193	java/io/IOException
    //   304	315	193	java/io/IOException
    //   238	242	244	java/io/IOException
    //   322	326	332	java/io/IOException
    //   198	202	339	java/io/IOException
    //   31	46	345	java/security/NoSuchAlgorithmException
    //   352	356	361	java/io/IOException
    //   31	46	367	finally
    //   374	378	380	java/io/IOException
    //   46	170	384	finally
    //   170	177	384	finally
    //   181	190	384	finally
    //   206	221	384	finally
    //   226	230	384	finally
    //   247	256	384	finally
    //   256	263	384	finally
    //   304	315	384	finally
    //   46	170	388	java/security/NoSuchAlgorithmException
    //   170	177	388	java/security/NoSuchAlgorithmException
    //   181	190	388	java/security/NoSuchAlgorithmException
    //   206	221	388	java/security/NoSuchAlgorithmException
    //   226	230	388	java/security/NoSuchAlgorithmException
    //   247	256	388	java/security/NoSuchAlgorithmException
    //   256	263	388	java/security/NoSuchAlgorithmException
    //   304	315	388	java/security/NoSuchAlgorithmException
    //   31	46	392	java/io/IOException
  }
  
  /* Error */
  public static String estimateFileType(String paramString)
  {
    // Byte code:
    //   0: new 157	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: iconst_2
    //   12: newarray byte
    //   14: astore_0
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 558	java/io/FileInputStream:read	([B)I
    //   22: iconst_m1
    //   23: if_icmpeq +134 -> 157
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: invokestatic 572	com/tencent/mobileqq/utils/FileUtils:estimateFileType	([B)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 562	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokevirtual 562	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: ldc_w 574
    //   59: astore_0
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 179	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: ifnull -18 -> 51
    //   72: aload_2
    //   73: invokevirtual 562	java/io/FileInputStream:close	()V
    //   76: aload_0
    //   77: areturn
    //   78: astore_1
    //   79: aload_0
    //   80: areturn
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: ldc_w 574
    //   87: astore_0
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: ifnull -46 -> 51
    //   100: aload_2
    //   101: invokevirtual 562	java/io/FileInputStream:close	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 562	java/io/FileInputStream:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: areturn
    //   125: astore_1
    //   126: goto -6 -> 120
    //   129: astore_0
    //   130: goto -18 -> 112
    //   133: astore_3
    //   134: ldc_w 574
    //   137: astore_0
    //   138: goto -50 -> 88
    //   141: astore_3
    //   142: goto -54 -> 88
    //   145: astore_3
    //   146: ldc_w 574
    //   149: astore_0
    //   150: goto -90 -> 60
    //   153: astore_3
    //   154: goto -94 -> 60
    //   157: ldc_w 574
    //   160: astore_0
    //   161: goto -128 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   10	58	1	localObject1	Object
    //   78	1	1	localIOException1	IOException
    //   89	7	1	localObject2	Object
    //   106	1	1	localIOException2	IOException
    //   111	6	1	localObject3	Object
    //   122	1	1	localIOException3	IOException
    //   125	1	1	localIOException4	IOException
    //   8	93	2	localFileInputStream	FileInputStream
    //   53	10	3	localFileNotFoundException1	FileNotFoundException
    //   81	10	3	localIOException5	IOException
    //   133	1	3	localIOException6	IOException
    //   141	1	3	localIOException7	IOException
    //   145	1	3	localFileNotFoundException2	FileNotFoundException
    //   153	1	3	localFileNotFoundException3	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/io/FileNotFoundException
    //   72	76	78	java/io/IOException
    //   0	9	81	java/io/IOException
    //   100	104	106	java/io/IOException
    //   0	9	109	finally
    //   45	49	122	java/io/IOException
    //   116	120	125	java/io/IOException
    //   11	15	129	finally
    //   17	26	129	finally
    //   28	33	129	finally
    //   35	39	129	finally
    //   62	66	129	finally
    //   90	94	129	finally
    //   11	15	133	java/io/IOException
    //   17	26	133	java/io/IOException
    //   28	33	133	java/io/IOException
    //   35	39	141	java/io/IOException
    //   11	15	145	java/io/FileNotFoundException
    //   17	26	145	java/io/FileNotFoundException
    //   28	33	145	java/io/FileNotFoundException
    //   35	39	153	java/io/FileNotFoundException
  }
  
  public static String estimateFileType(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        str = str + Integer.toString(paramArrayOfByte[i] & 0xFF);
        i += 1;
      }
      switch (Integer.parseInt(str))
      {
      default: 
        return unKnownFileTypeMark + str;
      case 7790: 
        return "exe";
      case 7784: 
        return "midi";
      case 8297: 
        return "rar";
      case 8075: 
        return "zip";
      case 255216: 
        return "jpg";
      case 7173: 
        return "gif";
      case 6677: 
        return "bmp";
      case 13780: 
        return "png";
      }
      return "webp";
    }
    return unKnownFileTypeMark + "";
  }
  
  /* Error */
  public static String estimateVideoType(String paramString)
  {
    // Byte code:
    //   0: new 157	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: astore_2
    //   13: bipush 10
    //   15: newarray byte
    //   17: astore_0
    //   18: aload 4
    //   20: astore_2
    //   21: aload 4
    //   23: aload_0
    //   24: invokevirtual 558	java/io/FileInputStream:read	([B)I
    //   27: iconst_m1
    //   28: if_icmpeq +349 -> 377
    //   31: aload 4
    //   33: astore_2
    //   34: new 113	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: iconst_0
    //   43: istore_1
    //   44: aload 4
    //   46: astore_2
    //   47: iload_1
    //   48: aload_0
    //   49: arraylength
    //   50: if_icmpge +25 -> 75
    //   53: aload 4
    //   55: astore_2
    //   56: aload_3
    //   57: aload_0
    //   58: iload_1
    //   59: baload
    //   60: sipush 255
    //   63: iand
    //   64: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -28 -> 44
    //   75: aload 4
    //   77: astore_2
    //   78: aload_3
    //   79: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: ldc_w 594
    //   85: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +19 -> 107
    //   91: aload 4
    //   93: astore_2
    //   94: aload_3
    //   95: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: ldc_w 596
    //   101: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifeq +30 -> 134
    //   107: ldc 29
    //   109: astore_0
    //   110: aload 4
    //   112: astore_2
    //   113: aload 4
    //   115: invokevirtual 562	java/io/FileInputStream:close	()V
    //   118: aload_0
    //   119: astore_2
    //   120: aload 4
    //   122: ifnull +10 -> 132
    //   125: aload 4
    //   127: invokevirtual 562	java/io/FileInputStream:close	()V
    //   130: aload_0
    //   131: astore_2
    //   132: aload_2
    //   133: areturn
    //   134: aload 4
    //   136: astore_2
    //   137: aload_3
    //   138: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: ldc_w 598
    //   144: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   147: ifeq +9 -> 156
    //   150: ldc 11
    //   152: astore_0
    //   153: goto -43 -> 110
    //   156: aload 4
    //   158: astore_2
    //   159: aload_3
    //   160: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: ldc_w 600
    //   166: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +9 -> 178
    //   172: ldc 41
    //   174: astore_0
    //   175: goto -65 -> 110
    //   178: aload 4
    //   180: astore_2
    //   181: aload_3
    //   182: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: ldc_w 602
    //   188: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifeq +9 -> 200
    //   194: ldc 26
    //   196: astore_0
    //   197: goto -87 -> 110
    //   200: aload 4
    //   202: astore_2
    //   203: aload_3
    //   204: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: ldc_w 604
    //   210: invokevirtual 217	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +9 -> 222
    //   216: ldc 17
    //   218: astore_0
    //   219: goto -109 -> 110
    //   222: aload 4
    //   224: astore_2
    //   225: new 113	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   232: getstatic 83	com/tencent/mobileqq/utils/FileUtils:unKnownFileTypeMark	Ljava/lang/String;
    //   235: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_3
    //   239: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore_0
    //   246: goto -136 -> 110
    //   249: astore_3
    //   250: aconst_null
    //   251: astore 4
    //   253: ldc_w 574
    //   256: astore_0
    //   257: aload 4
    //   259: astore_2
    //   260: aload_3
    //   261: invokevirtual 179	java/io/FileNotFoundException:printStackTrace	()V
    //   264: aload_0
    //   265: astore_2
    //   266: aload 4
    //   268: ifnull -136 -> 132
    //   271: aload 4
    //   273: invokevirtual 562	java/io/FileInputStream:close	()V
    //   276: aload_0
    //   277: areturn
    //   278: astore_2
    //   279: aload_0
    //   280: areturn
    //   281: astore_3
    //   282: aconst_null
    //   283: astore 4
    //   285: ldc_w 574
    //   288: astore_0
    //   289: aload 4
    //   291: astore_2
    //   292: aload_3
    //   293: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   296: aload_0
    //   297: astore_2
    //   298: aload 4
    //   300: ifnull -168 -> 132
    //   303: aload 4
    //   305: invokevirtual 562	java/io/FileInputStream:close	()V
    //   308: aload_0
    //   309: areturn
    //   310: astore_2
    //   311: aload_0
    //   312: areturn
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_2
    //   316: aload_2
    //   317: ifnull +7 -> 324
    //   320: aload_2
    //   321: invokevirtual 562	java/io/FileInputStream:close	()V
    //   324: aload_0
    //   325: athrow
    //   326: astore_2
    //   327: aload_0
    //   328: areturn
    //   329: astore_2
    //   330: goto -6 -> 324
    //   333: astore_0
    //   334: goto -18 -> 316
    //   337: astore_3
    //   338: ldc_w 574
    //   341: astore_0
    //   342: goto -53 -> 289
    //   345: astore_3
    //   346: ldc_w 574
    //   349: astore_0
    //   350: goto -61 -> 289
    //   353: astore_3
    //   354: goto -65 -> 289
    //   357: astore_3
    //   358: ldc_w 574
    //   361: astore_0
    //   362: goto -105 -> 257
    //   365: astore_3
    //   366: ldc_w 574
    //   369: astore_0
    //   370: goto -113 -> 257
    //   373: astore_3
    //   374: goto -117 -> 257
    //   377: ldc_w 574
    //   380: astore_0
    //   381: goto -271 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString	String
    //   43	29	1	i	int
    //   12	254	2	localObject1	Object
    //   278	1	2	localIOException1	IOException
    //   291	7	2	localObject2	Object
    //   310	1	2	localIOException2	IOException
    //   315	6	2	localObject3	Object
    //   326	1	2	localIOException3	IOException
    //   329	1	2	localIOException4	IOException
    //   41	198	3	localStringBuilder	java.lang.StringBuilder
    //   249	12	3	localFileNotFoundException1	FileNotFoundException
    //   281	12	3	localIOException5	IOException
    //   337	1	3	localIOException6	IOException
    //   345	1	3	localIOException7	IOException
    //   353	1	3	localIOException8	IOException
    //   357	1	3	localFileNotFoundException2	FileNotFoundException
    //   365	1	3	localFileNotFoundException3	FileNotFoundException
    //   373	1	3	localFileNotFoundException4	FileNotFoundException
    //   8	296	4	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	10	249	java/io/FileNotFoundException
    //   271	276	278	java/io/IOException
    //   0	10	281	java/io/IOException
    //   303	308	310	java/io/IOException
    //   0	10	313	finally
    //   125	130	326	java/io/IOException
    //   320	324	329	java/io/IOException
    //   13	18	333	finally
    //   21	31	333	finally
    //   34	42	333	finally
    //   47	53	333	finally
    //   56	68	333	finally
    //   78	91	333	finally
    //   94	107	333	finally
    //   113	118	333	finally
    //   137	150	333	finally
    //   159	172	333	finally
    //   181	194	333	finally
    //   203	216	333	finally
    //   225	246	333	finally
    //   260	264	333	finally
    //   292	296	333	finally
    //   13	18	337	java/io/IOException
    //   21	31	337	java/io/IOException
    //   34	42	345	java/io/IOException
    //   47	53	345	java/io/IOException
    //   56	68	345	java/io/IOException
    //   78	91	345	java/io/IOException
    //   94	107	345	java/io/IOException
    //   137	150	345	java/io/IOException
    //   159	172	345	java/io/IOException
    //   181	194	345	java/io/IOException
    //   203	216	345	java/io/IOException
    //   225	246	345	java/io/IOException
    //   113	118	353	java/io/IOException
    //   13	18	357	java/io/FileNotFoundException
    //   21	31	357	java/io/FileNotFoundException
    //   34	42	365	java/io/FileNotFoundException
    //   47	53	365	java/io/FileNotFoundException
    //   56	68	365	java/io/FileNotFoundException
    //   78	91	365	java/io/FileNotFoundException
    //   94	107	365	java/io/FileNotFoundException
    //   137	150	365	java/io/FileNotFoundException
    //   159	172	365	java/io/FileNotFoundException
    //   181	194	365	java/io/FileNotFoundException
    //   203	216	365	java/io/FileNotFoundException
    //   225	246	365	java/io/FileNotFoundException
    //   113	118	373	java/io/FileNotFoundException
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  /* Error */
  public static byte[] fileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 146	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 316	java/io/BufferedInputStream
    //   12: dup
    //   13: new 157	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: aload_0
    //   27: invokevirtual 150	java/io/File:length	()J
    //   30: lstore_3
    //   31: lload_3
    //   32: ldc2_w 610
    //   35: lcmp
    //   36: ifgt +9 -> 45
    //   39: lload_3
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +54 -> 96
    //   45: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +29 -> 77
    //   51: ldc 63
    //   53: iconst_2
    //   54: new 113	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 613
    //   64: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload_3
    //   68: invokevirtual 616	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 5
    //   79: ifnull -72 -> 7
    //   82: aload 5
    //   84: invokevirtual 619	java/io/InputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 620	java/lang/Throwable:printStackTrace	()V
    //   94: aconst_null
    //   95: areturn
    //   96: lload_3
    //   97: l2i
    //   98: istore_1
    //   99: iload_1
    //   100: newarray byte
    //   102: astore 6
    //   104: iconst_0
    //   105: istore_1
    //   106: iload_1
    //   107: aload 6
    //   109: arraylength
    //   110: if_icmpge +28 -> 138
    //   113: aload 5
    //   115: aload 6
    //   117: iload_1
    //   118: aload 6
    //   120: arraylength
    //   121: iload_1
    //   122: isub
    //   123: invokevirtual 623	java/io/InputStream:read	([BII)I
    //   126: istore_2
    //   127: iload_2
    //   128: iflt +10 -> 138
    //   131: iload_1
    //   132: iload_2
    //   133: iadd
    //   134: istore_1
    //   135: goto -29 -> 106
    //   138: iload_1
    //   139: aload 6
    //   141: arraylength
    //   142: if_icmpge +35 -> 177
    //   145: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +29 -> 177
    //   151: ldc 63
    //   153: iconst_2
    //   154: new 113	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 625
    //   164: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 5
    //   179: ifnull +8 -> 187
    //   182: aload 5
    //   184: invokevirtual 619	java/io/InputStream:close	()V
    //   187: aload 6
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 620	java/lang/Throwable:printStackTrace	()V
    //   195: goto -8 -> 187
    //   198: astore 5
    //   200: aconst_null
    //   201: astore 5
    //   203: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +29 -> 235
    //   209: ldc 63
    //   211: iconst_2
    //   212: new 113	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 627
    //   222: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload 5
    //   237: ifnull -230 -> 7
    //   240: aload 5
    //   242: invokevirtual 619	java/io/InputStream:close	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 620	java/lang/Throwable:printStackTrace	()V
    //   252: aconst_null
    //   253: areturn
    //   254: astore_0
    //   255: aconst_null
    //   256: astore 5
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 619	java/io/InputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: astore 5
    //   272: aload 5
    //   274: invokevirtual 620	java/lang/Throwable:printStackTrace	()V
    //   277: goto -9 -> 268
    //   280: astore_0
    //   281: goto -23 -> 258
    //   284: astore_0
    //   285: goto -27 -> 258
    //   288: astore 6
    //   290: goto -87 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramFile	File
    //   98	45	1	i	int
    //   126	8	2	j	int
    //   30	67	3	l	long
    //   24	159	5	localBufferedInputStream	java.io.BufferedInputStream
    //   198	1	5	localThrowable1	java.lang.Throwable
    //   201	63	5	localObject	Object
    //   270	3	5	localThrowable2	java.lang.Throwable
    //   102	86	6	arrayOfByte	byte[]
    //   288	1	6	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   82	87	89	java/lang/Throwable
    //   182	187	190	java/lang/Throwable
    //   9	26	198	java/lang/Throwable
    //   240	245	247	java/lang/Throwable
    //   9	26	254	finally
    //   263	268	270	java/lang/Throwable
    //   26	31	280	finally
    //   45	77	280	finally
    //   99	104	280	finally
    //   106	127	280	finally
    //   138	177	280	finally
    //   203	235	284	finally
    //   26	31	288	java/lang/Throwable
    //   45	77	288	java/lang/Throwable
    //   99	104	288	java/lang/Throwable
    //   106	127	288	java/lang/Throwable
    //   138	177	288	java/lang/Throwable
  }
  
  public static float getAvailableExternalMemorySize()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks();
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
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
      return i * f;
    }
    catch (Exception localException) {}
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
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_0
    //   9: ifnull +116 -> 125
    //   12: new 157	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore 4
    //   22: aload 4
    //   24: astore_3
    //   25: aload_0
    //   26: invokevirtual 150	java/io/File:length	()J
    //   29: l2i
    //   30: newarray byte
    //   32: astore 5
    //   34: iconst_0
    //   35: istore_1
    //   36: aload 4
    //   38: astore_3
    //   39: iload_1
    //   40: aload 5
    //   42: arraylength
    //   43: if_icmpge +31 -> 74
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: aload 5
    //   53: iload_1
    //   54: aload 5
    //   56: arraylength
    //   57: iload_1
    //   58: isub
    //   59: invokevirtual 623	java/io/InputStream:read	([BII)I
    //   62: istore_2
    //   63: iload_2
    //   64: iflt +10 -> 74
    //   67: iload_1
    //   68: iload_2
    //   69: iadd
    //   70: istore_1
    //   71: goto -35 -> 36
    //   74: aload 4
    //   76: astore_3
    //   77: iload_1
    //   78: aload 5
    //   80: arraylength
    //   81: if_icmpge +192 -> 273
    //   84: aload 7
    //   86: astore_0
    //   87: aload 4
    //   89: astore_3
    //   90: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +18 -> 111
    //   96: aload 4
    //   98: astore_3
    //   99: ldc 63
    //   101: iconst_2
    //   102: ldc_w 649
    //   105: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: aload 7
    //   110: astore_0
    //   111: aload_0
    //   112: astore_3
    //   113: aload 4
    //   115: ifnull +10 -> 125
    //   118: aload 4
    //   120: invokevirtual 619	java/io/InputStream:close	()V
    //   123: aload_0
    //   124: astore_3
    //   125: aload_3
    //   126: areturn
    //   127: astore 4
    //   129: aload_0
    //   130: astore_3
    //   131: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq -9 -> 125
    //   137: ldc 63
    //   139: iconst_2
    //   140: ldc_w 651
    //   143: aload 4
    //   145: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_0
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 6
    //   157: astore_0
    //   158: aload 4
    //   160: astore_3
    //   161: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +17 -> 181
    //   167: aload 4
    //   169: astore_3
    //   170: ldc 63
    //   172: iconst_2
    //   173: ldc_w 653
    //   176: aload 5
    //   178: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   181: aload_0
    //   182: astore_3
    //   183: aload 4
    //   185: ifnull -60 -> 125
    //   188: aload 4
    //   190: invokevirtual 619	java/io/InputStream:close	()V
    //   193: aload_0
    //   194: areturn
    //   195: astore 4
    //   197: aload_0
    //   198: astore_3
    //   199: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -77 -> 125
    //   205: ldc 63
    //   207: iconst_2
    //   208: ldc_w 651
    //   211: aload 4
    //   213: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_0
    //   217: areturn
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_3
    //   221: aload_3
    //   222: ifnull +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 619	java/io/InputStream:close	()V
    //   229: aload_0
    //   230: athrow
    //   231: astore_3
    //   232: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq -6 -> 229
    //   238: ldc 63
    //   240: iconst_2
    //   241: ldc_w 651
    //   244: aload_3
    //   245: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: goto -19 -> 229
    //   251: astore_0
    //   252: goto -31 -> 221
    //   255: astore 5
    //   257: aload 6
    //   259: astore_0
    //   260: goto -102 -> 158
    //   263: astore_3
    //   264: aload 5
    //   266: astore_0
    //   267: aload_3
    //   268: astore 5
    //   270: goto -112 -> 158
    //   273: aload 5
    //   275: astore_0
    //   276: goto -165 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramFile	File
    //   35	47	1	i	int
    //   62	8	2	j	int
    //   1	225	3	localObject1	Object
    //   231	14	3	localIOException1	IOException
    //   263	5	3	localException1	Exception
    //   20	99	4	localFileInputStream	FileInputStream
    //   127	17	4	localIOException2	IOException
    //   153	36	4	localObject2	Object
    //   195	17	4	localIOException3	IOException
    //   32	47	5	arrayOfByte	byte[]
    //   150	27	5	localException2	Exception
    //   255	10	5	localException3	Exception
    //   268	6	5	localException4	Exception
    //   3	255	6	localObject3	Object
    //   6	103	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   118	123	127	java/io/IOException
    //   12	22	150	java/lang/Exception
    //   188	193	195	java/io/IOException
    //   12	22	218	finally
    //   225	229	231	java/io/IOException
    //   25	34	251	finally
    //   39	46	251	finally
    //   49	63	251	finally
    //   77	84	251	finally
    //   90	96	251	finally
    //   99	108	251	finally
    //   161	167	251	finally
    //   170	181	251	finally
    //   25	34	255	java/lang/Exception
    //   39	46	263	java/lang/Exception
    //   49	63	263	java/lang/Exception
    //   77	84	263	java/lang/Exception
    //   90	96	263	java/lang/Exception
    //   99	108	263	java/lang/Exception
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
    for (;;)
    {
      try
      {
        int j = localObject.length;
        if (i < j) {
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
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramString;
      i += 1;
    }
  }
  
  public static long getFileAmount(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label33;
      }
      l1 = 1L;
    }
    label33:
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            l1 = l2;
          } while (!paramString.isDirectory());
          paramString = paramString.listFiles();
          l1 = l2;
        } while (paramString == null);
        l1 = l2;
      } while (paramString.length <= 0);
      j = paramString.length;
      i = 0;
      l1 = l2;
    } while (i >= j);
    Object localObject = paramString[i];
    l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.exists()) {
        if (!localObject.isDirectory()) {
          break label130;
        }
      }
    }
    label130:
    for (l1 = l2 + getFileAmount(localObject.getAbsolutePath());; l1 = l2 + 1L)
    {
      i += 1;
      l2 = l1;
      break;
    }
  }
  
  public static long getFileOrFolderSize(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label36;
      }
      l1 = paramString.length();
    }
    label36:
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            l1 = l2;
          } while (!paramString.isDirectory());
          paramString = paramString.listFiles();
          l1 = l2;
        } while (paramString == null);
        l1 = l2;
      } while (paramString.length <= 0);
      j = paramString.length;
      i = 0;
      l1 = l2;
    } while (i >= j);
    Object localObject = paramString[i];
    l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.exists())
      {
        if (!localObject.isDirectory()) {
          break label133;
        }
        l1 = l2 + getFileOrFolderSize(localObject.getAbsolutePath());
      }
    }
    for (;;)
    {
      i += 1;
      l2 = l1;
      break;
      label133:
      l1 = l2;
      if (localObject.isFile()) {
        l1 = l2 + localObject.length();
      }
    }
  }
  
  public static String getFileSize(long paramLong)
  {
    return bhea.a(paramLong);
  }
  
  /* Error */
  public static long getFileSizes(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: new 141	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 146	java/io/File:exists	()Z
    //   18: ifeq +37 -> 55
    //   21: new 157	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 691	java/io/FileInputStream:available	()I
    //   34: istore_1
    //   35: iload_1
    //   36: i2l
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: invokevirtual 562	java/io/FileInputStream:close	()V
    //   50: lload 4
    //   52: lstore_2
    //   53: lload_2
    //   54: lreturn
    //   55: iconst_0
    //   56: ifeq -3 -> 53
    //   59: new 204	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 692	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull -21 -> 53
    //   77: aload_0
    //   78: invokevirtual 562	java/io/FileInputStream:close	()V
    //   81: lconst_0
    //   82: lreturn
    //   83: astore_0
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: aload 6
    //   89: ifnull +8 -> 97
    //   92: aload 6
    //   94: invokevirtual 562	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: lload 4
    //   102: lreturn
    //   103: astore 6
    //   105: goto -8 -> 97
    //   108: astore 7
    //   110: aload_0
    //   111: astore 6
    //   113: aload 7
    //   115: astore_0
    //   116: goto -29 -> 87
    //   119: astore 6
    //   121: goto -48 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   34	2	1	i	int
    //   1	53	2	l1	long
    //   37	64	4	l2	long
    //   3	90	6	localObject1	Object
    //   103	1	6	localIOException	IOException
    //   111	1	6	str	String
    //   119	1	6	localException	Exception
    //   108	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   5	30	70	java/lang/Exception
    //   77	81	83	java/io/IOException
    //   5	30	86	finally
    //   46	50	99	java/io/IOException
    //   92	97	103	java/io/IOException
    //   30	35	108	finally
    //   30	35	119	java/lang/Exception
  }
  
  public static float getTotalExternalMemorySize()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getBlockCount();
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
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
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static String getUnitFileName(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!new File(localFile, paramString2).exists()) {
      return paramString2;
    }
    if (paramString2.lastIndexOf('.') < 0) {}
    String str;
    for (paramString1 = "";; paramString1 = str)
    {
      int i = 1;
      for (;;)
      {
        str = paramString2 + "(" + i + ")" + paramString1;
        if (!new File(localFile, str).exists()) {
          break;
        }
        i += 1;
      }
      paramString1 = paramString2.substring(0, paramString2.lastIndexOf('.'));
      str = paramString2.substring(paramString1.length(), paramString2.length());
      paramString2 = paramString1;
    }
    return str;
  }
  
  public static boolean hasSDCardAndWritable()
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      if ((localFile.exists()) && (localFile.canWrite())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileUtils", 2, "existAndCanWrite=" + bool1 + " externalDir.canWrite()= " + localFile.canWrite() + " state=" + Environment.getExternalStorageState().equals("mounted"));
        }
        boolean bool2 = Environment.getExternalStorageState().equals("mounted");
        if ((!bool2) || (!bool1)) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileUtils", 2, "hasSDCardAndWritable", localException);
      }
    }
    return false;
  }
  
  public static boolean isAssetsFileExist(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext.open(paramString).close();
      return true;
    }
    catch (IOException paramContext) {}
    return false;
  }
  
  public static boolean isEmptyFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return false;
  }
  
  public static boolean isLocalPath(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.startsWith(AppConstants.SDCARD_ROOT)) && (!paramString.startsWith("/data/media/")))
      {
        bool1 = bool2;
        if (!new File(paramString).exists()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isPicFile(String paramString)
  {
    boolean bool = false;
    paramString = estimateFileType(paramString);
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isPicFileByExt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("jpg")) && (!paramString.equals("gif")) && (!paramString.equals("bmp")) && (!paramString.equals("png"))) {
      return false;
    }
    return true;
  }
  
  public static boolean justOnExistFileAndAddSuffix(String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    File localFile2 = new File(paramString1);
    File localFile1 = new File(paramString1 + paramStringBuffer.toString());
    boolean bool = true;
    if (!localFile2.exists()) {
      bool = localFile2.mkdirs();
    }
    if ((localFile2.exists()) && (localFile1.exists()))
    {
      paramStringBuffer.insert(paramStringBuffer.indexOf(paramString2), "(0)");
      for (paramString2 = localFile1; paramString2.exists(); paramString2 = new File(paramString1 + paramStringBuffer))
      {
        int i = paramStringBuffer.lastIndexOf("(") + 1;
        int j = paramStringBuffer.lastIndexOf(")");
        paramStringBuffer.replace(i, j, String.valueOf(Integer.parseInt(paramStringBuffer.substring(i, j)) + 1));
      }
    }
    return bool;
  }
  
  @TargetApi(9)
  public static List<FileUtils.StorageInfo> listAvaliableExternalStorage(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      paramContext = (StorageManager)paramContext.getSystemService("storage");
      localObject1 = StorageManager.class.getMethod("getVolumeList", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      localObject1 = (Object[])((Method)localObject1).invoke(paramContext, new Object[0]);
      if (localObject1 == null) {
        break label259;
      }
      i = 0;
    }
    catch (NoSuchMethodException paramContext)
    {
      Object localObject1;
      Object localObject2;
      FileUtils.StorageInfo localStorageInfo;
      Object localObject3;
      paramContext.printStackTrace();
      localArrayList.trimToSize();
      return localArrayList;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        int i;
        paramContext.printStackTrace();
        continue;
        i += 1;
      }
    }
    if (i < localObject1.length)
    {
      localObject2 = localObject1[i];
      localStorageInfo = new FileUtils.StorageInfo((String)localObject2.getClass().getMethod("getPath", new Class[0]).invoke(localObject2, new Object[0]));
      localObject3 = new File(localStorageInfo.path);
      if ((!((File)localObject3).exists()) || (!((File)localObject3).isDirectory()) || (!((File)localObject3).canWrite())) {
        break label289;
      }
      localObject3 = localObject2.getClass().getMethod("isRemovable", new Class[0]);
      try
      {
        localStorageInfo.state = ((String)StorageManager.class.getMethod("getVolumeState", new Class[] { String.class }).invoke(paramContext, new Object[] { localStorageInfo.path }));
        if (localStorageInfo.isMounted())
        {
          localStorageInfo.isRemoveable = ((Boolean)((Method)localObject3).invoke(localObject2, new Object[0])).booleanValue();
          localArrayList.add(localStorageInfo);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
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
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: ifnull +15 -> 22
    //   10: aload_0
    //   11: arraylength
    //   12: ifeq +10 -> 22
    //   15: aload_1
    //   16: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_3
    //   26: iload_3
    //   27: aload_0
    //   28: arraylength
    //   29: if_icmpge +34 -> 63
    //   32: aload_0
    //   33: iload_3
    //   34: aaload
    //   35: ifnull -13 -> 22
    //   38: aload_0
    //   39: iload_3
    //   40: aaload
    //   41: invokevirtual 146	java/io/File:exists	()Z
    //   44: ifeq -22 -> 22
    //   47: aload_0
    //   48: iload_3
    //   49: aaload
    //   50: invokevirtual 510	java/io/File:isFile	()Z
    //   53: ifeq -31 -> 22
    //   56: iload_3
    //   57: iconst_1
    //   58: iadd
    //   59: istore_3
    //   60: goto -34 -> 26
    //   63: aload_0
    //   64: arraylength
    //   65: iconst_1
    //   66: if_icmpne +18 -> 84
    //   69: aload_0
    //   70: iconst_0
    //   71: aaload
    //   72: new 141	java/io/File
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 846	java/io/File:renameTo	(Ljava/io/File;)Z
    //   83: ireturn
    //   84: new 141	java/io/File
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore_1
    //   93: new 313	java/io/FileOutputStream
    //   96: dup
    //   97: aload_1
    //   98: iconst_1
    //   99: invokespecial 849	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   102: astore_1
    //   103: aload_1
    //   104: astore 6
    //   106: aload_1
    //   107: invokevirtual 447	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   110: astore 8
    //   112: iconst_0
    //   113: istore_3
    //   114: aload_1
    //   115: astore 6
    //   117: aload_0
    //   118: arraylength
    //   119: istore 5
    //   121: iload_3
    //   122: iload 5
    //   124: if_icmpge +88 -> 212
    //   127: new 157	java/io/FileInputStream
    //   130: dup
    //   131: aload_0
    //   132: iload_3
    //   133: aaload
    //   134: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: invokevirtual 446	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   140: astore 7
    //   142: aload 8
    //   144: aload 7
    //   146: aload 8
    //   148: invokevirtual 852	java/nio/channels/FileChannel:size	()J
    //   151: aload 7
    //   153: invokevirtual 852	java/nio/channels/FileChannel:size	()J
    //   156: invokevirtual 453	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   159: pop2
    //   160: aload_1
    //   161: astore 6
    //   163: aload 7
    //   165: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   168: iload_3
    //   169: iconst_1
    //   170: iadd
    //   171: istore_3
    //   172: goto -58 -> 114
    //   175: aload_1
    //   176: astore 6
    //   178: aload 7
    //   180: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   183: aload_1
    //   184: astore 6
    //   186: aload_0
    //   187: athrow
    //   188: astore 6
    //   190: aload_1
    //   191: astore_0
    //   192: aload 6
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 179	java/io/FileNotFoundException:printStackTrace	()V
    //   199: aload_0
    //   200: ifnull -178 -> 22
    //   203: aload_0
    //   204: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_0
    //   210: iconst_0
    //   211: ireturn
    //   212: aload_1
    //   213: astore 6
    //   215: aload 8
    //   217: invokevirtual 454	java/nio/channels/FileChannel:close	()V
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   228: iload_2
    //   229: ifeq +65 -> 294
    //   232: iload 4
    //   234: istore_3
    //   235: iload_3
    //   236: aload_0
    //   237: arraylength
    //   238: if_icmpge +56 -> 294
    //   241: aload_0
    //   242: iload_3
    //   243: aaload
    //   244: invokevirtual 358	java/io/File:delete	()Z
    //   247: pop
    //   248: iload_3
    //   249: iconst_1
    //   250: iadd
    //   251: istore_3
    //   252: goto -17 -> 235
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: aload_1
    //   259: astore 6
    //   261: aload_0
    //   262: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   265: aload_1
    //   266: ifnull -244 -> 22
    //   269: aload_1
    //   270: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   273: iconst_0
    //   274: ireturn
    //   275: astore_0
    //   276: iconst_0
    //   277: ireturn
    //   278: astore_0
    //   279: aconst_null
    //   280: astore 6
    //   282: aload 6
    //   284: ifnull +8 -> 292
    //   287: aload 6
    //   289: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   292: aload_0
    //   293: athrow
    //   294: iconst_1
    //   295: ireturn
    //   296: astore_1
    //   297: goto -69 -> 228
    //   300: astore_1
    //   301: goto -9 -> 292
    //   304: astore_0
    //   305: goto -23 -> 282
    //   308: astore_1
    //   309: aload_0
    //   310: astore 6
    //   312: aload_1
    //   313: astore_0
    //   314: goto -32 -> 282
    //   317: astore_0
    //   318: goto -60 -> 258
    //   321: astore_1
    //   322: aload 6
    //   324: astore_0
    //   325: goto -130 -> 195
    //   328: astore_0
    //   329: goto -154 -> 175
    //   332: astore_0
    //   333: aconst_null
    //   334: astore 7
    //   336: goto -161 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramArrayOfFile	File[]
    //   0	339	1	paramString	String
    //   0	339	2	paramBoolean	boolean
    //   25	227	3	i	int
    //   4	229	4	j	int
    //   119	6	5	k	int
    //   1	184	6	str	String
    //   188	5	6	localFileNotFoundException	FileNotFoundException
    //   213	110	6	localObject	Object
    //   140	195	7	localFileChannel1	java.nio.channels.FileChannel
    //   110	106	8	localFileChannel2	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   106	112	188	java/io/FileNotFoundException
    //   117	121	188	java/io/FileNotFoundException
    //   163	168	188	java/io/FileNotFoundException
    //   178	183	188	java/io/FileNotFoundException
    //   186	188	188	java/io/FileNotFoundException
    //   215	220	188	java/io/FileNotFoundException
    //   203	207	209	java/io/IOException
    //   93	103	255	java/io/IOException
    //   269	273	275	java/io/IOException
    //   93	103	278	finally
    //   224	228	296	java/io/IOException
    //   287	292	300	java/io/IOException
    //   106	112	304	finally
    //   117	121	304	finally
    //   163	168	304	finally
    //   178	183	304	finally
    //   186	188	304	finally
    //   215	220	304	finally
    //   261	265	304	finally
    //   195	199	308	finally
    //   106	112	317	java/io/IOException
    //   117	121	317	java/io/IOException
    //   163	168	317	java/io/IOException
    //   178	183	317	java/io/IOException
    //   186	188	317	java/io/IOException
    //   215	220	317	java/io/IOException
    //   93	103	321	java/io/FileNotFoundException
    //   142	160	328	finally
    //   127	142	332	finally
  }
  
  public static boolean mergeFiles(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    File[] arrayOfFile = new File[paramArrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfString.length) {
        break label62;
      }
      if (TextUtils.isEmpty(paramArrayOfString[i])) {
        break;
      }
      arrayOfFile[i] = new File(paramArrayOfString[i]);
      i += 1;
    }
    label62:
    return mergeFiles(arrayOfFile, paramString, false);
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    try
    {
      copyFile(paramString1, createFile(paramString2));
      paramString1.delete();
      return true;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  /* Error */
  public static boolean pushData2File(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_0
    //   7: ifnull +28 -> 35
    //   10: iload 4
    //   12: istore_3
    //   13: aload_0
    //   14: invokevirtual 519	java/lang/String:length	()I
    //   17: ifeq +18 -> 35
    //   20: iload 4
    //   22: istore_3
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_1
    //   28: arraylength
    //   29: ifne +8 -> 37
    //   32: iload 4
    //   34: istore_3
    //   35: iload_3
    //   36: ireturn
    //   37: aload_0
    //   38: astore 5
    //   40: iload_2
    //   41: ifeq +58 -> 99
    //   44: new 858	java/text/SimpleDateFormat
    //   47: dup
    //   48: ldc_w 860
    //   51: getstatic 866	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: invokespecial 869	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   57: new 871	java/util/Date
    //   60: dup
    //   61: invokestatic 876	java/lang/System:currentTimeMillis	()J
    //   64: invokespecial 879	java/util/Date:<init>	(J)V
    //   67: invokevirtual 882	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   70: astore 5
    //   72: new 113	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   79: aload_0
    //   80: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 884
    //   86: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 5
    //   99: new 141	java/io/File
    //   102: dup
    //   103: aload 5
    //   105: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore 8
    //   110: aconst_null
    //   111: astore 7
    //   113: aconst_null
    //   114: astore 5
    //   116: aconst_null
    //   117: astore 6
    //   119: aload 5
    //   121: astore_0
    //   122: aload 8
    //   124: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   127: astore 9
    //   129: aload 5
    //   131: astore_0
    //   132: aload 9
    //   134: invokevirtual 146	java/io/File:exists	()Z
    //   137: ifne +12 -> 149
    //   140: aload 5
    //   142: astore_0
    //   143: aload 9
    //   145: invokevirtual 244	java/io/File:mkdirs	()Z
    //   148: pop
    //   149: aload 5
    //   151: astore_0
    //   152: aload 8
    //   154: invokevirtual 146	java/io/File:exists	()Z
    //   157: ifeq +12 -> 169
    //   160: aload 5
    //   162: astore_0
    //   163: aload 8
    //   165: invokevirtual 358	java/io/File:delete	()Z
    //   168: pop
    //   169: aload 5
    //   171: astore_0
    //   172: new 313	java/io/FileOutputStream
    //   175: dup
    //   176: aload 8
    //   178: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   181: astore 5
    //   183: aload 5
    //   185: aload_1
    //   186: invokevirtual 886	java/io/FileOutputStream:write	([B)V
    //   189: aload 5
    //   191: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   194: iconst_1
    //   195: istore_3
    //   196: aload 5
    //   198: ifnull -163 -> 35
    //   201: aload 5
    //   203: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   206: iconst_1
    //   207: ireturn
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 674	java/lang/Exception:printStackTrace	()V
    //   213: iconst_1
    //   214: ireturn
    //   215: astore 5
    //   217: aload 6
    //   219: astore_1
    //   220: aload_1
    //   221: astore_0
    //   222: aload 5
    //   224: invokevirtual 179	java/io/FileNotFoundException:printStackTrace	()V
    //   227: iload 4
    //   229: istore_3
    //   230: aload_1
    //   231: ifnull -196 -> 35
    //   234: aload_1
    //   235: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   238: iconst_0
    //   239: ireturn
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 674	java/lang/Exception:printStackTrace	()V
    //   245: iconst_0
    //   246: ireturn
    //   247: astore 5
    //   249: aload 7
    //   251: astore_1
    //   252: aload_1
    //   253: astore_0
    //   254: aload 5
    //   256: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   259: iload 4
    //   261: istore_3
    //   262: aload_1
    //   263: ifnull -228 -> 35
    //   266: aload_1
    //   267: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   270: iconst_0
    //   271: ireturn
    //   272: astore_0
    //   273: aload_0
    //   274: invokevirtual 674	java/lang/Exception:printStackTrace	()V
    //   277: iconst_0
    //   278: ireturn
    //   279: astore 5
    //   281: aload_0
    //   282: astore_1
    //   283: aload 5
    //   285: astore_0
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   294: aload_0
    //   295: athrow
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 674	java/lang/Exception:printStackTrace	()V
    //   301: goto -7 -> 294
    //   304: astore_0
    //   305: aload 5
    //   307: astore_1
    //   308: goto -22 -> 286
    //   311: astore_0
    //   312: aload 5
    //   314: astore_1
    //   315: aload_0
    //   316: astore 5
    //   318: goto -66 -> 252
    //   321: astore_0
    //   322: aload 5
    //   324: astore_1
    //   325: aload_0
    //   326: astore 5
    //   328: goto -108 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramString	String
    //   0	331	1	paramArrayOfByte	byte[]
    //   0	331	2	paramBoolean	boolean
    //   5	257	3	bool1	boolean
    //   1	259	4	bool2	boolean
    //   38	164	5	localObject1	Object
    //   215	8	5	localFileNotFoundException	FileNotFoundException
    //   247	8	5	localIOException	IOException
    //   279	34	5	localObject2	Object
    //   316	11	5	str	String
    //   117	101	6	localObject3	Object
    //   111	139	7	localObject4	Object
    //   108	69	8	localFile1	File
    //   127	17	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   201	206	208	java/lang/Exception
    //   122	129	215	java/io/FileNotFoundException
    //   132	140	215	java/io/FileNotFoundException
    //   143	149	215	java/io/FileNotFoundException
    //   152	160	215	java/io/FileNotFoundException
    //   163	169	215	java/io/FileNotFoundException
    //   172	183	215	java/io/FileNotFoundException
    //   234	238	240	java/lang/Exception
    //   122	129	247	java/io/IOException
    //   132	140	247	java/io/IOException
    //   143	149	247	java/io/IOException
    //   152	160	247	java/io/IOException
    //   163	169	247	java/io/IOException
    //   172	183	247	java/io/IOException
    //   266	270	272	java/lang/Exception
    //   122	129	279	finally
    //   132	140	279	finally
    //   143	149	279	finally
    //   152	160	279	finally
    //   163	169	279	finally
    //   172	183	279	finally
    //   222	227	279	finally
    //   254	259	279	finally
    //   290	294	296	java/lang/Exception
    //   183	194	304	finally
    //   183	194	311	java/io/IOException
    //   183	194	321	java/io/FileNotFoundException
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
  
  /* Error */
  public static byte[] readFile(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 141	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 146	java/io/File:exists	()Z
    //   26: ifeq -17 -> 9
    //   29: aload 4
    //   31: invokevirtual 150	java/io/File:length	()J
    //   34: l2i
    //   35: istore_2
    //   36: new 891	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: iload_2
    //   41: invokespecial 894	java/io/ByteArrayOutputStream:<init>	(I)V
    //   44: astore_0
    //   45: new 157	java/io/FileInputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 6
    //   56: iload_2
    //   57: sipush 4096
    //   60: if_icmpge +63 -> 123
    //   63: aload_0
    //   64: astore 5
    //   66: aload 6
    //   68: astore 4
    //   70: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   73: sipush 4096
    //   76: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   79: astore 7
    //   81: iload_1
    //   82: iload_2
    //   83: if_icmpge +84 -> 167
    //   86: aload_0
    //   87: astore 5
    //   89: aload 6
    //   91: astore 4
    //   93: aload 6
    //   95: aload 7
    //   97: invokevirtual 558	java/io/FileInputStream:read	([B)I
    //   100: istore_3
    //   101: aload_0
    //   102: astore 5
    //   104: aload 6
    //   106: astore 4
    //   108: aload_0
    //   109: aload 7
    //   111: iconst_0
    //   112: iload_3
    //   113: invokevirtual 895	java/io/ByteArrayOutputStream:write	([BII)V
    //   116: iload_1
    //   117: iload_3
    //   118: iadd
    //   119: istore_1
    //   120: goto -39 -> 81
    //   123: aload_0
    //   124: astore 5
    //   126: aload 6
    //   128: astore 4
    //   130: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   133: sipush 12288
    //   136: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   139: astore 7
    //   141: goto -60 -> 81
    //   144: astore 4
    //   146: aload_0
    //   147: astore 5
    //   149: aload 6
    //   151: astore 4
    //   153: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   156: sipush 4096
    //   159: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   162: astore 7
    //   164: goto -83 -> 81
    //   167: aload_0
    //   168: astore 5
    //   170: aload 6
    //   172: astore 4
    //   174: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   177: aload 7
    //   179: invokevirtual 423	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   182: aload_0
    //   183: astore 5
    //   185: aload 6
    //   187: astore 4
    //   189: aload_0
    //   190: invokevirtual 898	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   193: astore 7
    //   195: aload 7
    //   197: astore 4
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 899	java/io/ByteArrayOutputStream:close	()V
    //   207: aload 4
    //   209: astore_0
    //   210: aload 6
    //   212: ifnull +11 -> 223
    //   215: aload 6
    //   217: invokevirtual 562	java/io/FileInputStream:close	()V
    //   220: aload 4
    //   222: astore_0
    //   223: aload_0
    //   224: areturn
    //   225: astore_0
    //   226: ldc 63
    //   228: iconst_1
    //   229: ldc_w 901
    //   232: aload_0
    //   233: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload 4
    //   238: astore_0
    //   239: goto -16 -> 223
    //   242: astore 7
    //   244: aconst_null
    //   245: astore 8
    //   247: aconst_null
    //   248: astore_0
    //   249: aload 8
    //   251: astore 5
    //   253: aload_0
    //   254: astore 4
    //   256: ldc 63
    //   258: iconst_1
    //   259: ldc_w 901
    //   262: aload 7
    //   264: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: aload 8
    //   269: ifnull +8 -> 277
    //   272: aload 8
    //   274: invokevirtual 899	java/io/ByteArrayOutputStream:close	()V
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 562	java/io/FileInputStream:close	()V
    //   285: aconst_null
    //   286: astore_0
    //   287: goto -64 -> 223
    //   290: astore_0
    //   291: ldc 63
    //   293: iconst_1
    //   294: ldc_w 901
    //   297: aload_0
    //   298: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aconst_null
    //   302: astore_0
    //   303: goto -80 -> 223
    //   306: astore 7
    //   308: aconst_null
    //   309: astore 8
    //   311: aconst_null
    //   312: astore_0
    //   313: aload 8
    //   315: astore 5
    //   317: aload_0
    //   318: astore 4
    //   320: ldc 63
    //   322: iconst_1
    //   323: ldc_w 903
    //   326: aload 7
    //   328: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   331: aload 8
    //   333: ifnull +8 -> 341
    //   336: aload 8
    //   338: invokevirtual 899	java/io/ByteArrayOutputStream:close	()V
    //   341: aload_0
    //   342: ifnull +7 -> 349
    //   345: aload_0
    //   346: invokevirtual 562	java/io/FileInputStream:close	()V
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -128 -> 223
    //   354: astore_0
    //   355: ldc 63
    //   357: iconst_1
    //   358: ldc_w 901
    //   361: aload_0
    //   362: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   365: aconst_null
    //   366: astore_0
    //   367: goto -144 -> 223
    //   370: astore 6
    //   372: aconst_null
    //   373: astore_0
    //   374: aconst_null
    //   375: astore 4
    //   377: aload_0
    //   378: ifnull +7 -> 385
    //   381: aload_0
    //   382: invokevirtual 899	java/io/ByteArrayOutputStream:close	()V
    //   385: aload 4
    //   387: ifnull +8 -> 395
    //   390: aload 4
    //   392: invokevirtual 562	java/io/FileInputStream:close	()V
    //   395: aload 6
    //   397: athrow
    //   398: astore_0
    //   399: ldc 63
    //   401: iconst_1
    //   402: ldc_w 901
    //   405: aload_0
    //   406: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   409: goto -14 -> 395
    //   412: astore 6
    //   414: aconst_null
    //   415: astore 4
    //   417: goto -40 -> 377
    //   420: astore 6
    //   422: aload 5
    //   424: astore_0
    //   425: goto -48 -> 377
    //   428: astore 7
    //   430: aconst_null
    //   431: astore 4
    //   433: aload_0
    //   434: astore 8
    //   436: aload 4
    //   438: astore_0
    //   439: goto -126 -> 313
    //   442: astore 7
    //   444: aload_0
    //   445: astore 8
    //   447: aload 6
    //   449: astore_0
    //   450: goto -137 -> 313
    //   453: astore 7
    //   455: aconst_null
    //   456: astore 4
    //   458: aload_0
    //   459: astore 8
    //   461: aload 4
    //   463: astore_0
    //   464: goto -215 -> 249
    //   467: astore 7
    //   469: aload_0
    //   470: astore 8
    //   472: aload 6
    //   474: astore_0
    //   475: goto -226 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	paramString	String
    //   1	119	1	i	int
    //   35	49	2	j	int
    //   100	19	3	k	int
    //   19	110	4	localObject1	Object
    //   144	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   151	311	4	localObject2	Object
    //   64	359	5	localObject3	Object
    //   54	162	6	localFileInputStream	FileInputStream
    //   370	26	6	localObject4	Object
    //   412	1	6	localObject5	Object
    //   420	53	6	localObject6	Object
    //   79	117	7	arrayOfByte	byte[]
    //   242	21	7	localException1	Exception
    //   306	21	7	localOutOfMemoryError2	OutOfMemoryError
    //   428	1	7	localOutOfMemoryError3	OutOfMemoryError
    //   442	1	7	localOutOfMemoryError4	OutOfMemoryError
    //   453	1	7	localException2	Exception
    //   467	1	7	localException3	Exception
    //   245	226	8	str	String
    // Exception table:
    //   from	to	target	type
    //   70	81	144	java/lang/OutOfMemoryError
    //   130	141	144	java/lang/OutOfMemoryError
    //   203	207	225	java/io/IOException
    //   215	220	225	java/io/IOException
    //   29	45	242	java/lang/Exception
    //   272	277	290	java/io/IOException
    //   281	285	290	java/io/IOException
    //   29	45	306	java/lang/OutOfMemoryError
    //   336	341	354	java/io/IOException
    //   345	349	354	java/io/IOException
    //   29	45	370	finally
    //   381	385	398	java/io/IOException
    //   390	395	398	java/io/IOException
    //   45	56	412	finally
    //   70	81	420	finally
    //   93	101	420	finally
    //   108	116	420	finally
    //   130	141	420	finally
    //   153	164	420	finally
    //   174	182	420	finally
    //   189	195	420	finally
    //   256	267	420	finally
    //   320	331	420	finally
    //   45	56	428	java/lang/OutOfMemoryError
    //   93	101	442	java/lang/OutOfMemoryError
    //   108	116	442	java/lang/OutOfMemoryError
    //   153	164	442	java/lang/OutOfMemoryError
    //   174	182	442	java/lang/OutOfMemoryError
    //   189	195	442	java/lang/OutOfMemoryError
    //   45	56	453	java/lang/Exception
    //   70	81	467	java/lang/Exception
    //   93	101	467	java/lang/Exception
    //   108	116	467	java/lang/Exception
    //   130	141	467	java/lang/Exception
    //   153	164	467	java/lang/Exception
    //   174	182	467	java/lang/Exception
    //   189	195	467	java/lang/Exception
  }
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aload_0
    //   6: invokevirtual 150	java/io/File:length	()J
    //   9: l2i
    //   10: istore_2
    //   11: new 891	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: iload_2
    //   16: invokespecial 894	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore 4
    //   21: new 316	java/io/BufferedInputStream
    //   24: dup
    //   25: new 157	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore 5
    //   38: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   41: sipush 12288
    //   44: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   47: astore_0
    //   48: iload_1
    //   49: iload_2
    //   50: if_icmpge +39 -> 89
    //   53: aload 5
    //   55: aload_0
    //   56: invokevirtual 905	java/io/InputStream:read	([B)I
    //   59: istore_3
    //   60: aload 4
    //   62: aload_0
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 895	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: iload_1
    //   69: iload_3
    //   70: iadd
    //   71: istore_1
    //   72: goto -24 -> 48
    //   75: astore_0
    //   76: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   79: sipush 4096
    //   82: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   85: astore_0
    //   86: goto -38 -> 48
    //   89: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   92: aload_0
    //   93: invokevirtual 423	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   96: aload 4
    //   98: ldc_w 907
    //   101: invokevirtual 909	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_0
    //   105: aload 4
    //   107: ifnull +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 899	java/io/ByteArrayOutputStream:close	()V
    //   115: aload_0
    //   116: astore 4
    //   118: aload 5
    //   120: ifnull +11 -> 131
    //   123: aload 5
    //   125: invokevirtual 619	java/io/InputStream:close	()V
    //   128: aload_0
    //   129: astore 4
    //   131: aload 4
    //   133: areturn
    //   134: astore 5
    //   136: aload_0
    //   137: astore 4
    //   139: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq -11 -> 131
    //   145: ldc 63
    //   147: iconst_2
    //   148: ldc_w 901
    //   151: aload 5
    //   153: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   156: aload_0
    //   157: areturn
    //   158: astore_0
    //   159: aconst_null
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 899	java/io/ByteArrayOutputStream:close	()V
    //   174: aload 6
    //   176: astore 4
    //   178: aload_0
    //   179: ifnull -48 -> 131
    //   182: aload_0
    //   183: invokevirtual 619	java/io/InputStream:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: aload 6
    //   191: astore 4
    //   193: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq -65 -> 131
    //   199: ldc 63
    //   201: iconst_2
    //   202: ldc_w 901
    //   205: aload_0
    //   206: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_0
    //   212: aconst_null
    //   213: astore 4
    //   215: aconst_null
    //   216: astore 6
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 899	java/io/ByteArrayOutputStream:close	()V
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 619	java/io/InputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore 4
    //   242: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq -7 -> 238
    //   248: ldc 63
    //   250: iconst_2
    //   251: ldc_w 901
    //   254: aload 4
    //   256: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: goto -21 -> 238
    //   262: astore_0
    //   263: aconst_null
    //   264: astore 5
    //   266: aload 4
    //   268: astore 6
    //   270: aload 5
    //   272: astore 4
    //   274: goto -56 -> 218
    //   277: astore_0
    //   278: aload 4
    //   280: astore 6
    //   282: aload 5
    //   284: astore 4
    //   286: goto -68 -> 218
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_0
    //   292: goto -128 -> 164
    //   295: astore_0
    //   296: aload 5
    //   298: astore_0
    //   299: goto -135 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramFile	File
    //   1	71	1	i	int
    //   10	41	2	j	int
    //   59	12	3	k	int
    //   19	215	4	localObject1	Object
    //   240	27	4	localIOException1	IOException
    //   272	13	4	localObject2	Object
    //   36	88	5	localBufferedInputStream	java.io.BufferedInputStream
    //   134	18	5	localIOException2	IOException
    //   264	33	5	localObject3	Object
    //   3	278	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   38	48	75	java/lang/OutOfMemoryError
    //   110	115	134	java/io/IOException
    //   123	128	134	java/io/IOException
    //   5	21	158	java/lang/Throwable
    //   169	174	188	java/io/IOException
    //   182	186	188	java/io/IOException
    //   5	21	211	finally
    //   223	228	240	java/io/IOException
    //   233	238	240	java/io/IOException
    //   21	38	262	finally
    //   38	48	277	finally
    //   53	68	277	finally
    //   76	86	277	finally
    //   89	105	277	finally
    //   21	38	289	java/lang/Throwable
    //   38	48	295	java/lang/Throwable
    //   53	68	295	java/lang/Throwable
    //   76	86	295	java/lang/Throwable
    //   89	105	295	java/lang/Throwable
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 146	java/io/File:exists	()Z
    //   16: ifeq +85 -> 101
    //   19: aload_0
    //   20: invokevirtual 347	java/io/File:isDirectory	()Z
    //   23: ifeq +37 -> 60
    //   26: new 290	java/io/IOException
    //   29: dup
    //   30: new 113	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 912
    //   40: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc_w 914
    //   50: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 915	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 918	java/io/File:canRead	()Z
    //   64: ifne +71 -> 135
    //   67: new 290	java/io/IOException
    //   70: dup
    //   71: new 113	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 912
    //   81: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: ldc_w 920
    //   91: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 915	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   100: athrow
    //   101: new 155	java/io/FileNotFoundException
    //   104: dup
    //   105: new 113	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 912
    //   115: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: ldc_w 922
    //   125: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 923	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   134: athrow
    //   135: new 157	java/io/FileInputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_3
    //   144: new 925	java/io/InputStreamReader
    //   147: dup
    //   148: aload_3
    //   149: ldc_w 927
    //   152: invokespecial 930	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   155: astore_2
    //   156: aload_0
    //   157: invokevirtual 150	java/io/File:length	()J
    //   160: l2i
    //   161: istore_1
    //   162: iload_1
    //   163: sipush 12288
    //   166: if_icmple +100 -> 266
    //   169: sipush 4096
    //   172: newarray char
    //   174: astore_0
    //   175: new 113	java/lang/StringBuilder
    //   178: dup
    //   179: sipush 12288
    //   182: invokespecial 931	java/lang/StringBuilder:<init>	(I)V
    //   185: astore 5
    //   187: aload_2
    //   188: aload_0
    //   189: invokevirtual 934	java/io/InputStreamReader:read	([C)I
    //   192: istore_1
    //   193: iconst_m1
    //   194: iload_1
    //   195: if_icmpeq +42 -> 237
    //   198: aload 5
    //   200: aload_0
    //   201: iconst_0
    //   202: iload_1
    //   203: invokevirtual 937	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: goto -20 -> 187
    //   210: astore_0
    //   211: aload_2
    //   212: astore_0
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 562	java/io/FileInputStream:close	()V
    //   221: aload 4
    //   223: astore_3
    //   224: aload_0
    //   225: ifnull -215 -> 10
    //   228: aload_0
    //   229: invokevirtual 938	java/io/InputStreamReader:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aconst_null
    //   236: areturn
    //   237: aload 5
    //   239: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_0
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 562	java/io/FileInputStream:close	()V
    //   251: aload_0
    //   252: astore_3
    //   253: aload_2
    //   254: ifnull -244 -> 10
    //   257: aload_2
    //   258: invokevirtual 938	java/io/InputStreamReader:close	()V
    //   261: aload_0
    //   262: areturn
    //   263: astore_2
    //   264: aload_0
    //   265: areturn
    //   266: iload_1
    //   267: newarray char
    //   269: astore_0
    //   270: new 107	java/lang/String
    //   273: dup
    //   274: aload_0
    //   275: iconst_0
    //   276: aload_2
    //   277: aload_0
    //   278: invokevirtual 934	java/io/InputStreamReader:read	([C)I
    //   281: invokespecial 941	java/lang/String:<init>	([CII)V
    //   284: astore_0
    //   285: goto -42 -> 243
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_3
    //   294: ifnull +7 -> 301
    //   297: aload_3
    //   298: invokevirtual 562	java/io/FileInputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 938	java/io/InputStreamReader:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_3
    //   312: goto -61 -> 251
    //   315: astore_2
    //   316: goto -95 -> 221
    //   319: astore_3
    //   320: goto -19 -> 301
    //   323: astore_2
    //   324: goto -15 -> 309
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_2
    //   330: goto -37 -> 293
    //   333: astore_0
    //   334: goto -41 -> 293
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_3
    //   342: goto -129 -> 213
    //   345: astore_0
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -135 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFile	File
    //   161	106	1	i	int
    //   155	103	2	localInputStreamReader	java.io.InputStreamReader
    //   263	14	2	localException1	Exception
    //   292	14	2	localObject1	Object
    //   315	1	2	localException2	Exception
    //   323	1	2	localException3	Exception
    //   329	1	2	localObject2	Object
    //   9	289	3	localObject3	Object
    //   311	1	3	localException4	Exception
    //   319	1	3	localException5	Exception
    //   341	1	3	localObject4	Object
    //   1	221	4	localObject5	Object
    //   185	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   156	162	210	java/lang/Exception
    //   169	187	210	java/lang/Exception
    //   187	193	210	java/lang/Exception
    //   198	207	210	java/lang/Exception
    //   237	243	210	java/lang/Exception
    //   266	285	210	java/lang/Exception
    //   228	232	234	java/lang/Exception
    //   257	261	263	java/lang/Exception
    //   135	144	288	finally
    //   247	251	311	java/lang/Exception
    //   217	221	315	java/lang/Exception
    //   297	301	319	java/lang/Exception
    //   305	309	323	java/lang/Exception
    //   144	156	327	finally
    //   156	162	333	finally
    //   169	187	333	finally
    //   187	193	333	finally
    //   198	207	333	finally
    //   237	243	333	finally
    //   266	285	333	finally
    //   135	144	337	java/lang/Exception
    //   144	156	345	java/lang/Exception
  }
  
  /* Error */
  public static String readFileToStringEx(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: ldc 63
    //   12: iconst_1
    //   13: ldc_w 945
    //   16: invokestatic 528	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload 9
    //   21: astore 5
    //   23: aload 5
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 146	java/io/File:exists	()Z
    //   30: ifeq +10 -> 40
    //   33: aload_0
    //   34: invokevirtual 918	java/io/File:canRead	()Z
    //   37: ifne +47 -> 84
    //   40: ldc 63
    //   42: iconst_1
    //   43: new 113	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   50: ldc_w 947
    //   53: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: invokevirtual 146	java/io/File:exists	()Z
    //   60: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   63: ldc_w 949
    //   66: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 918	java/io/File:canRead	()Z
    //   73: invokevirtual 719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   76: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 528	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aconst_null
    //   83: areturn
    //   84: new 316	java/io/BufferedInputStream
    //   87: dup
    //   88: new 157	java/io/FileInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 5
    //   101: new 925	java/io/InputStreamReader
    //   104: dup
    //   105: aload 5
    //   107: ldc_w 927
    //   110: invokespecial 930	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   113: astore 8
    //   115: aload 8
    //   117: astore 7
    //   119: aload 5
    //   121: astore 6
    //   123: iload_1
    //   124: istore_3
    //   125: aload_0
    //   126: invokevirtual 150	java/io/File:length	()J
    //   129: l2i
    //   130: istore 4
    //   132: iload 4
    //   134: sipush 12288
    //   137: if_icmple +259 -> 396
    //   140: iload_1
    //   141: istore_2
    //   142: iload_1
    //   143: iconst_m1
    //   144: if_icmpne +29 -> 173
    //   147: aload 8
    //   149: astore 7
    //   151: aload 5
    //   153: astore 6
    //   155: iload_1
    //   156: istore_3
    //   157: iload 4
    //   159: sipush 6144
    //   162: idiv
    //   163: istore_1
    //   164: iload_1
    //   165: bipush 12
    //   167: if_icmpge +166 -> 333
    //   170: bipush 12
    //   172: istore_2
    //   173: aload 8
    //   175: astore 7
    //   177: aload 5
    //   179: astore 6
    //   181: iload_2
    //   182: istore_3
    //   183: sipush 4096
    //   186: newarray char
    //   188: astore 11
    //   190: aload 8
    //   192: astore 7
    //   194: aload 5
    //   196: astore 6
    //   198: iload_2
    //   199: istore_3
    //   200: new 113	java/lang/StringBuilder
    //   203: dup
    //   204: iload_2
    //   205: sipush 1024
    //   208: imul
    //   209: invokespecial 931	java/lang/StringBuilder:<init>	(I)V
    //   212: astore 12
    //   214: aload 8
    //   216: astore 7
    //   218: aload 5
    //   220: astore 6
    //   222: iload_2
    //   223: istore_3
    //   224: aload 8
    //   226: aload 11
    //   228: invokevirtual 934	java/io/InputStreamReader:read	([C)I
    //   231: istore_1
    //   232: iconst_m1
    //   233: iload_1
    //   234: if_icmpeq +113 -> 347
    //   237: aload 8
    //   239: astore 7
    //   241: aload 5
    //   243: astore 6
    //   245: iload_2
    //   246: istore_3
    //   247: aload 12
    //   249: aload 11
    //   251: iconst_0
    //   252: iload_1
    //   253: invokevirtual 937	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: goto -43 -> 214
    //   260: astore 6
    //   262: aload 8
    //   264: astore_0
    //   265: aload 6
    //   267: astore 8
    //   269: aload_0
    //   270: astore 7
    //   272: aload 5
    //   274: astore 6
    //   276: ldc 63
    //   278: iconst_1
    //   279: new 113	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 951
    //   289: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 8
    //   294: invokevirtual 952	java/lang/Exception:toString	()Ljava/lang/String;
    //   297: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 528	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 5
    //   308: ifnull +8 -> 316
    //   311: aload 5
    //   313: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   316: aload 9
    //   318: astore 5
    //   320: aload_0
    //   321: ifnull -298 -> 23
    //   324: aload_0
    //   325: invokevirtual 938	java/io/InputStreamReader:close	()V
    //   328: aconst_null
    //   329: areturn
    //   330: astore_0
    //   331: aconst_null
    //   332: areturn
    //   333: iload_1
    //   334: istore_2
    //   335: iload_1
    //   336: bipush 60
    //   338: if_icmple -165 -> 173
    //   341: bipush 60
    //   343: istore_2
    //   344: goto -171 -> 173
    //   347: aload 8
    //   349: astore 7
    //   351: aload 5
    //   353: astore 6
    //   355: iload_2
    //   356: istore_3
    //   357: aload 12
    //   359: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: astore 11
    //   364: aload 11
    //   366: astore_0
    //   367: aload 5
    //   369: ifnull +8 -> 377
    //   372: aload 5
    //   374: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   377: aload_0
    //   378: astore 5
    //   380: aload 8
    //   382: ifnull -359 -> 23
    //   385: aload 8
    //   387: invokevirtual 938	java/io/InputStreamReader:close	()V
    //   390: aload_0
    //   391: areturn
    //   392: astore 5
    //   394: aload_0
    //   395: areturn
    //   396: aload 8
    //   398: astore 7
    //   400: aload 5
    //   402: astore 6
    //   404: iload_1
    //   405: istore_3
    //   406: iload 4
    //   408: newarray char
    //   410: astore 11
    //   412: aload 8
    //   414: astore 7
    //   416: aload 5
    //   418: astore 6
    //   420: iload_1
    //   421: istore_3
    //   422: new 107	java/lang/String
    //   425: dup
    //   426: aload 11
    //   428: iconst_0
    //   429: aload 8
    //   431: aload 11
    //   433: invokevirtual 934	java/io/InputStreamReader:read	([C)I
    //   436: invokespecial 941	java/lang/String:<init>	([CII)V
    //   439: astore 11
    //   441: aload 11
    //   443: astore_0
    //   444: goto -77 -> 367
    //   447: astore 5
    //   449: aconst_null
    //   450: astore 8
    //   452: aconst_null
    //   453: astore 5
    //   455: aload 8
    //   457: astore 7
    //   459: aload 5
    //   461: astore 6
    //   463: ldc 63
    //   465: iconst_1
    //   466: new 113	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 954
    //   476: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: invokevirtual 353	java/io/File:getName	()Ljava/lang/String;
    //   483: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aload 10
    //   494: astore 6
    //   496: iload_1
    //   497: iconst_m1
    //   498: if_icmpne +21 -> 519
    //   501: aload 8
    //   503: astore 7
    //   505: aload 5
    //   507: astore 6
    //   509: aload_0
    //   510: bipush 6
    //   512: invokestatic 956	com/tencent/mobileqq/utils/FileUtils:readFileToStringEx	(Ljava/io/File;I)Ljava/lang/String;
    //   515: astore_0
    //   516: aload_0
    //   517: astore 6
    //   519: aload 5
    //   521: ifnull +8 -> 529
    //   524: aload 5
    //   526: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   529: aload 6
    //   531: astore 5
    //   533: aload 8
    //   535: ifnull -512 -> 23
    //   538: aload 8
    //   540: invokevirtual 938	java/io/InputStreamReader:close	()V
    //   543: aload 6
    //   545: areturn
    //   546: astore_0
    //   547: aload 6
    //   549: areturn
    //   550: astore_0
    //   551: aconst_null
    //   552: astore 7
    //   554: aconst_null
    //   555: astore 5
    //   557: aload 5
    //   559: ifnull +8 -> 567
    //   562: aload 5
    //   564: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   567: aload 7
    //   569: ifnull +8 -> 577
    //   572: aload 7
    //   574: invokevirtual 938	java/io/InputStreamReader:close	()V
    //   577: aload_0
    //   578: athrow
    //   579: astore 5
    //   581: goto -204 -> 377
    //   584: astore 5
    //   586: goto -270 -> 316
    //   589: astore_0
    //   590: goto -61 -> 529
    //   593: astore 5
    //   595: goto -28 -> 567
    //   598: astore 5
    //   600: goto -23 -> 577
    //   603: astore_0
    //   604: aconst_null
    //   605: astore 7
    //   607: goto -50 -> 557
    //   610: astore_0
    //   611: aload 6
    //   613: astore 5
    //   615: goto -58 -> 557
    //   618: astore 6
    //   620: aconst_null
    //   621: astore 8
    //   623: goto -168 -> 455
    //   626: astore 6
    //   628: iload_3
    //   629: istore_1
    //   630: goto -175 -> 455
    //   633: astore 8
    //   635: aconst_null
    //   636: astore_0
    //   637: aconst_null
    //   638: astore 5
    //   640: goto -371 -> 269
    //   643: astore 8
    //   645: aconst_null
    //   646: astore_0
    //   647: goto -378 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	paramFile	File
    //   0	650	1	paramInt	int
    //   141	215	2	i	int
    //   124	505	3	j	int
    //   130	277	4	k	int
    //   21	358	5	localObject1	Object
    //   392	25	5	localException1	Exception
    //   447	1	5	localOutOfMemoryError1	OutOfMemoryError
    //   453	110	5	localObject2	Object
    //   579	1	5	localException2	Exception
    //   584	1	5	localException3	Exception
    //   593	1	5	localException4	Exception
    //   598	1	5	localException5	Exception
    //   613	26	5	localObject3	Object
    //   121	123	6	localObject4	Object
    //   260	6	6	localException6	Exception
    //   274	338	6	localObject5	Object
    //   618	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   626	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   117	489	7	localObject6	Object
    //   113	509	8	localObject7	Object
    //   633	1	8	localException7	Exception
    //   643	1	8	localException8	Exception
    //   4	313	9	localObject8	Object
    //   1	492	10	localObject9	Object
    //   188	254	11	localObject10	Object
    //   212	146	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   125	132	260	java/lang/Exception
    //   157	164	260	java/lang/Exception
    //   183	190	260	java/lang/Exception
    //   200	214	260	java/lang/Exception
    //   224	232	260	java/lang/Exception
    //   247	257	260	java/lang/Exception
    //   357	364	260	java/lang/Exception
    //   406	412	260	java/lang/Exception
    //   422	441	260	java/lang/Exception
    //   324	328	330	java/lang/Exception
    //   385	390	392	java/lang/Exception
    //   84	101	447	java/lang/OutOfMemoryError
    //   538	543	546	java/lang/Exception
    //   84	101	550	finally
    //   372	377	579	java/lang/Exception
    //   311	316	584	java/lang/Exception
    //   524	529	589	java/lang/Exception
    //   562	567	593	java/lang/Exception
    //   572	577	598	java/lang/Exception
    //   101	115	603	finally
    //   125	132	610	finally
    //   157	164	610	finally
    //   183	190	610	finally
    //   200	214	610	finally
    //   224	232	610	finally
    //   247	257	610	finally
    //   276	306	610	finally
    //   357	364	610	finally
    //   406	412	610	finally
    //   422	441	610	finally
    //   463	492	610	finally
    //   509	516	610	finally
    //   101	115	618	java/lang/OutOfMemoryError
    //   125	132	626	java/lang/OutOfMemoryError
    //   157	164	626	java/lang/OutOfMemoryError
    //   183	190	626	java/lang/OutOfMemoryError
    //   200	214	626	java/lang/OutOfMemoryError
    //   224	232	626	java/lang/OutOfMemoryError
    //   247	257	626	java/lang/OutOfMemoryError
    //   357	364	626	java/lang/OutOfMemoryError
    //   406	412	626	java/lang/OutOfMemoryError
    //   422	441	626	java/lang/OutOfMemoryError
    //   84	101	633	java/lang/Exception
    //   101	115	643	java/lang/Exception
  }
  
  /* Error */
  public static Object readObject(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 4
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: new 959	java/io/ObjectInputStream
    //   18: dup
    //   19: new 316	java/io/BufferedInputStream
    //   22: dup
    //   23: invokestatic 963	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: aload_0
    //   27: invokevirtual 969	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   30: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 970	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 973	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: astore_3
    //   44: aload_3
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: ifnull -36 -> 13
    //   52: aload_2
    //   53: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_0
    //   59: aload_1
    //   60: areturn
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +44 -> 113
    //   72: aload_2
    //   73: astore_1
    //   74: ldc 63
    //   76: iconst_2
    //   77: new 113	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 976
    //   87: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 978
    //   97: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 952	java/lang/Exception:toString	()Ljava/lang/String;
    //   104: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 980	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload 4
    //   115: astore_0
    //   116: aload_2
    //   117: ifnull -104 -> 13
    //   120: aload_2
    //   121: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: astore_1
    //   143: goto -3 -> 140
    //   146: astore_0
    //   147: goto -15 -> 132
    //   150: astore_3
    //   151: goto -87 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   38	99	1	localObject1	Object
    //   142	1	1	localIOException	IOException
    //   36	85	2	localObjectInputStream	java.io.ObjectInputStream
    //   43	2	3	localObject2	Object
    //   61	40	3	localException1	Exception
    //   150	1	3	localException2	Exception
    //   1	113	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	58	java/io/IOException
    //   15	37	61	java/lang/Exception
    //   120	124	126	java/io/IOException
    //   15	37	129	finally
    //   136	140	142	java/io/IOException
    //   39	44	146	finally
    //   66	72	146	finally
    //   74	113	146	finally
    //   39	44	150	java/lang/Exception
  }
  
  /* Error */
  public static Object[] readObjectList(String paramString, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: new 959	java/io/ObjectInputStream
    //   3: dup
    //   4: new 316	java/io/BufferedInputStream
    //   7: dup
    //   8: invokestatic 963	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: aload_0
    //   12: invokevirtual 969	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: invokespecial 970	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload_1
    //   27: arraylength
    //   28: anewarray 4	java/lang/Object
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_2
    //   35: aload 4
    //   37: astore_3
    //   38: iload_2
    //   39: aload_1
    //   40: arraylength
    //   41: if_icmpge +209 -> 250
    //   44: aload_1
    //   45: iload_2
    //   46: aaload
    //   47: astore_3
    //   48: aload_3
    //   49: ldc_w 984
    //   52: if_acmpne +21 -> 73
    //   55: aload 4
    //   57: astore_3
    //   58: aload 5
    //   60: iload_2
    //   61: aload 4
    //   63: invokevirtual 988	java/io/ObjectInputStream:readByte	()B
    //   66: invokestatic 991	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   69: aastore
    //   70: goto +234 -> 304
    //   73: aload_3
    //   74: ldc_w 824
    //   77: if_acmpne +97 -> 174
    //   80: aload 4
    //   82: astore_3
    //   83: aload 5
    //   85: iload_2
    //   86: aload 4
    //   88: invokevirtual 994	java/io/ObjectInputStream:readBoolean	()Z
    //   91: invokestatic 997	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: goto +209 -> 304
    //   98: astore_3
    //   99: aload 4
    //   101: astore_1
    //   102: aload_3
    //   103: astore 4
    //   105: aload_1
    //   106: astore_3
    //   107: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +46 -> 156
    //   113: aload_1
    //   114: astore_3
    //   115: ldc_w 999
    //   118: iconst_2
    //   119: new 113	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 1001
    //   129: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 1003
    //   139: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 4
    //   144: invokevirtual 1004	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   164: aconst_null
    //   165: astore_0
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: ifeq +116 -> 285
    //   172: aload_0
    //   173: areturn
    //   174: aload_3
    //   175: ldc_w 576
    //   178: if_acmpne +32 -> 210
    //   181: aload 4
    //   183: astore_3
    //   184: aload 5
    //   186: iload_2
    //   187: aload 4
    //   189: invokevirtual 1007	java/io/ObjectInputStream:readInt	()I
    //   192: invokestatic 1010	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: aastore
    //   196: goto +108 -> 304
    //   199: astore_0
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   208: aload_0
    //   209: athrow
    //   210: aload_3
    //   211: ldc_w 1012
    //   214: if_acmpne +21 -> 235
    //   217: aload 4
    //   219: astore_3
    //   220: aload 5
    //   222: iload_2
    //   223: aload 4
    //   225: invokevirtual 1015	java/io/ObjectInputStream:readLong	()J
    //   228: invokestatic 1018	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   231: aastore
    //   232: goto +72 -> 304
    //   235: aload 4
    //   237: astore_3
    //   238: aload 5
    //   240: iload_2
    //   241: aload 4
    //   243: invokevirtual 973	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   246: aastore
    //   247: goto +57 -> 304
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 974	java/io/ObjectInputStream:close	()V
    //   260: iconst_1
    //   261: istore_2
    //   262: aload 5
    //   264: astore_0
    //   265: goto -97 -> 168
    //   268: astore_0
    //   269: iconst_1
    //   270: istore_2
    //   271: aload 5
    //   273: astore_0
    //   274: goto -106 -> 168
    //   277: astore_0
    //   278: aconst_null
    //   279: astore_0
    //   280: iconst_0
    //   281: istore_2
    //   282: goto -114 -> 168
    //   285: aconst_null
    //   286: areturn
    //   287: astore_1
    //   288: goto -80 -> 208
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_3
    //   294: goto -94 -> 200
    //   297: astore 4
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -196 -> 105
    //   304: iload_2
    //   305: iconst_1
    //   306: iadd
    //   307: istore_2
    //   308: goto -273 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramString	String
    //   0	311	1	paramArrayOfClass	Class[]
    //   34	274	2	i	int
    //   25	58	3	localObject1	Object
    //   98	5	3	localException1	Exception
    //   106	188	3	localObject2	Object
    //   21	235	4	localObject3	Object
    //   297	1	4	localException2	Exception
    //   31	241	5	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   26	33	98	java/lang/Exception
    //   38	44	98	java/lang/Exception
    //   58	70	98	java/lang/Exception
    //   83	95	98	java/lang/Exception
    //   184	196	98	java/lang/Exception
    //   220	232	98	java/lang/Exception
    //   238	247	98	java/lang/Exception
    //   26	33	199	finally
    //   38	44	199	finally
    //   58	70	199	finally
    //   83	95	199	finally
    //   107	113	199	finally
    //   115	156	199	finally
    //   184	196	199	finally
    //   220	232	199	finally
    //   238	247	199	finally
    //   255	260	268	java/io/IOException
    //   160	164	277	java/io/IOException
    //   204	208	287	java/io/IOException
    //   0	23	291	finally
    //   0	23	297	java/lang/Exception
  }
  
  public static String readStringFromAsset(String paramString)
  {
    String str1 = "";
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getAssets().open(paramString);
        localObject1 = paramString;
        localObject2 = paramString;
        String str2 = nwo.a(paramString);
        localObject1 = str2;
        localObject2 = localObject1;
      }
      catch (IOException paramString)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject1;
        paramString.printStackTrace();
        localObject2 = str1;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          return "";
        }
        catch (Exception paramString)
        {
          localObject2 = str1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString.printStackTrace();
        return "";
      }
      finally
      {
        if (localObject2 == null) {
          break label116;
        }
      }
      try
      {
        paramString.close();
        localObject2 = localObject1;
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString.printStackTrace();
        return localObject1;
      }
    }
    return localObject2;
    try
    {
      ((InputStream)localObject2).close();
      label116:
      throw paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean renameFile(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
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
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_3
    //   3: istore_2
    //   4: aload_0
    //   5: ifnull +9 -> 14
    //   8: aload_1
    //   9: ifnonnull +7 -> 16
    //   12: iload_3
    //   13: istore_2
    //   14: iload_2
    //   15: ireturn
    //   16: aconst_null
    //   17: astore 5
    //   19: new 1032	java/io/BufferedOutputStream
    //   22: dup
    //   23: new 313	java/io/FileOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 314	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   31: ldc_w 1033
    //   34: invokespecial 1036	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_1
    //   42: aload_0
    //   43: getstatic 1039	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   46: bipush 70
    //   48: aload 4
    //   50: invokevirtual 484	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   53: istore_2
    //   54: iload_2
    //   55: istore_3
    //   56: iload_3
    //   57: istore_2
    //   58: aload 4
    //   60: ifnull -46 -> 14
    //   63: aload 4
    //   65: invokevirtual 1040	java/io/OutputStream:flush	()V
    //   68: aload 4
    //   70: invokevirtual 335	java/io/OutputStream:close	()V
    //   73: iload_3
    //   74: ireturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   80: iload_3
    //   81: ireturn
    //   82: astore 5
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: astore_1
    //   88: aload 5
    //   90: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   93: iload_3
    //   94: istore_2
    //   95: aload_0
    //   96: ifnull -82 -> 14
    //   99: aload_0
    //   100: invokevirtual 1040	java/io/OutputStream:flush	()V
    //   103: aload_0
    //   104: invokevirtual 335	java/io/OutputStream:close	()V
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_0
    //   117: aload 5
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +11 -> 132
    //   124: aload_1
    //   125: invokevirtual 1040	java/io/OutputStream:flush	()V
    //   128: aload_1
    //   129: invokevirtual 335	java/io/OutputStream:close	()V
    //   132: aload_0
    //   133: athrow
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_0
    //   143: goto -23 -> 120
    //   146: astore 5
    //   148: aload 4
    //   150: astore_0
    //   151: goto -65 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramBitmap	android.graphics.Bitmap
    //   0	154	1	paramString	String
    //   3	92	2	bool1	boolean
    //   1	93	3	bool2	boolean
    //   37	112	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   17	1	5	localObject	Object
    //   82	36	5	localIOException1	IOException
    //   146	1	5	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   63	73	75	java/io/IOException
    //   19	39	82	java/io/IOException
    //   99	107	109	java/io/IOException
    //   19	39	116	finally
    //   124	132	134	java/io/IOException
    //   42	54	142	finally
    //   88	93	142	finally
    //   42	54	146	java/io/IOException
  }
  
  /* Error */
  public static boolean saveBitmapToFile(android.graphics.Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: ifnonnull +8 -> 19
    //   14: iload 4
    //   16: istore_3
    //   17: iload_3
    //   18: ireturn
    //   19: aconst_null
    //   20: astore 6
    //   22: new 1032	java/io/BufferedOutputStream
    //   25: dup
    //   26: new 313	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 314	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   34: ldc_w 1033
    //   37: invokespecial 1036	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   40: astore 5
    //   42: aload 5
    //   44: astore_1
    //   45: aload_0
    //   46: aload_2
    //   47: bipush 70
    //   49: aload 5
    //   51: invokevirtual 484	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   54: istore_3
    //   55: iload_3
    //   56: istore 4
    //   58: iload 4
    //   60: istore_3
    //   61: aload 5
    //   63: ifnull -46 -> 17
    //   66: aload 5
    //   68: invokevirtual 1040	java/io/OutputStream:flush	()V
    //   71: aload 5
    //   73: invokevirtual 335	java/io/OutputStream:close	()V
    //   76: iload 4
    //   78: ireturn
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   84: iload 4
    //   86: ireturn
    //   87: astore_2
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_0
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   96: iload 4
    //   98: istore_3
    //   99: aload_0
    //   100: ifnull -83 -> 17
    //   103: aload_0
    //   104: invokevirtual 1040	java/io/OutputStream:flush	()V
    //   107: aload_0
    //   108: invokevirtual 335	java/io/OutputStream:close	()V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_0
    //   121: aload 6
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +11 -> 136
    //   128: aload_1
    //   129: invokevirtual 1040	java/io/OutputStream:flush	()V
    //   132: aload_1
    //   133: invokevirtual 335	java/io/OutputStream:close	()V
    //   136: aload_0
    //   137: athrow
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   143: goto -7 -> 136
    //   146: astore_0
    //   147: goto -23 -> 124
    //   150: astore_2
    //   151: aload 5
    //   153: astore_0
    //   154: goto -64 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramBitmap	android.graphics.Bitmap
    //   0	157	1	paramString	String
    //   0	157	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   5	94	3	bool1	boolean
    //   1	96	4	bool2	boolean
    //   40	112	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   20	102	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	76	79	java/io/IOException
    //   22	42	87	java/io/IOException
    //   103	111	113	java/io/IOException
    //   22	42	120	finally
    //   128	136	138	java/io/IOException
    //   45	55	146	finally
    //   92	96	146	finally
    //   45	55	150	java/io/IOException
  }
  
  /* Error */
  public static String saveFileUriToFile(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +7 -> 14
    //   10: aload_0
    //   11: ifnonnull +13 -> 24
    //   14: ldc 63
    //   16: ldc_w 1045
    //   19: invokestatic 1049	ykq:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_1
    //   25: invokestatic 1055	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   28: astore 4
    //   30: aload_0
    //   31: invokevirtual 1059	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   34: aload 4
    //   36: ldc_w 1061
    //   39: invokevirtual 1067	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   42: astore 6
    //   44: aload 6
    //   46: ifnonnull +31 -> 77
    //   49: ldc 63
    //   51: ldc_w 1069
    //   54: invokestatic 1049	ykq:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aconst_null
    //   58: areturn
    //   59: astore 4
    //   61: ldc 63
    //   63: ldc_w 1071
    //   66: aload 4
    //   68: invokestatic 1075	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aconst_null
    //   72: astore 6
    //   74: goto -30 -> 44
    //   77: aload_1
    //   78: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   81: invokevirtual 1076	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   84: istore_3
    //   85: iload_3
    //   86: iconst_m1
    //   87: if_icmpne +260 -> 347
    //   90: iload_3
    //   91: aload_1
    //   92: invokevirtual 519	java/lang/String:length	()I
    //   95: if_icmpge +252 -> 347
    //   98: new 113	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   105: aload_0
    //   106: aconst_null
    //   107: invokevirtual 1079	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   110: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   116: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 305	java/io/File:separator	Ljava/lang/String;
    //   126: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore 7
    //   138: ldc 63
    //   140: iconst_1
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc_w 1081
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: aload 7
    //   155: aastore
    //   156: invokestatic 1083	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   159: new 141	java/io/File
    //   162: dup
    //   163: aload 7
    //   165: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 146	java/io/File:exists	()Z
    //   173: ifeq +8 -> 181
    //   176: aload_0
    //   177: invokevirtual 358	java/io/File:delete	()Z
    //   180: pop
    //   181: aload_0
    //   182: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   185: ifnull +21 -> 206
    //   188: aload_0
    //   189: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   192: invokevirtual 146	java/io/File:exists	()Z
    //   195: ifne +11 -> 206
    //   198: aload_0
    //   199: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   202: invokevirtual 244	java/io/File:mkdirs	()Z
    //   205: pop
    //   206: new 313	java/io/FileOutputStream
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   214: astore_0
    //   215: new 316	java/io/BufferedInputStream
    //   218: dup
    //   219: new 157	java/io/FileInputStream
    //   222: dup
    //   223: aload 6
    //   225: invokevirtual 1089	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   228: invokespecial 1092	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   231: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   234: astore 4
    //   236: aload 4
    //   238: astore_2
    //   239: aload_0
    //   240: astore_1
    //   241: ldc_w 1093
    //   244: newarray byte
    //   246: astore 5
    //   248: aload 4
    //   250: astore_2
    //   251: aload_0
    //   252: astore_1
    //   253: aload 4
    //   255: aload 5
    //   257: invokevirtual 327	java/io/BufferedInputStream:read	([B)I
    //   260: istore_3
    //   261: iload_3
    //   262: iconst_m1
    //   263: if_icmpeq +95 -> 358
    //   266: aload 4
    //   268: astore_2
    //   269: aload_0
    //   270: astore_1
    //   271: aload_0
    //   272: aload 5
    //   274: iconst_0
    //   275: iload_3
    //   276: invokevirtual 413	java/io/FileOutputStream:write	([BII)V
    //   279: aload 4
    //   281: astore_2
    //   282: aload_0
    //   283: astore_1
    //   284: aload_0
    //   285: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   288: goto -40 -> 248
    //   291: astore 5
    //   293: aload 4
    //   295: astore_2
    //   296: aload_0
    //   297: astore_1
    //   298: ldc 63
    //   300: ldc_w 1095
    //   303: aload 5
    //   305: invokestatic 1075	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 6
    //   310: ifnull +8 -> 318
    //   313: aload 6
    //   315: invokevirtual 1096	android/os/ParcelFileDescriptor:close	()V
    //   318: aload_0
    //   319: ifnull +7 -> 326
    //   322: aload_0
    //   323: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   326: aload 4
    //   328: ifnull +384 -> 712
    //   331: aload 4
    //   333: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   336: iconst_0
    //   337: istore_3
    //   338: iload_3
    //   339: ifeq +318 -> 657
    //   342: aload 7
    //   344: astore_0
    //   345: aload_0
    //   346: areturn
    //   347: aload_1
    //   348: iload_3
    //   349: iconst_1
    //   350: iadd
    //   351: invokevirtual 1098	java/lang/String:substring	(I)Ljava/lang/String;
    //   354: astore_1
    //   355: goto -257 -> 98
    //   358: aload 6
    //   360: ifnull +8 -> 368
    //   363: aload 6
    //   365: invokevirtual 1096	android/os/ParcelFileDescriptor:close	()V
    //   368: aload_0
    //   369: ifnull +7 -> 376
    //   372: aload_0
    //   373: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   376: aload 4
    //   378: ifnull +339 -> 717
    //   381: aload 4
    //   383: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   386: iconst_1
    //   387: istore_3
    //   388: goto -50 -> 338
    //   391: astore_1
    //   392: ldc 63
    //   394: iconst_1
    //   395: ldc_w 1100
    //   398: aload_1
    //   399: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: goto -34 -> 368
    //   405: astore_0
    //   406: ldc 63
    //   408: iconst_1
    //   409: ldc_w 1100
    //   412: aload_0
    //   413: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: goto -40 -> 376
    //   419: astore_0
    //   420: ldc 63
    //   422: iconst_1
    //   423: ldc_w 1100
    //   426: aload_0
    //   427: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: iconst_1
    //   431: istore_3
    //   432: goto -94 -> 338
    //   435: astore_1
    //   436: ldc 63
    //   438: iconst_1
    //   439: ldc_w 1100
    //   442: aload_1
    //   443: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   446: goto -128 -> 318
    //   449: astore_0
    //   450: ldc 63
    //   452: iconst_1
    //   453: ldc_w 1100
    //   456: aload_0
    //   457: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   460: goto -134 -> 326
    //   463: astore_0
    //   464: ldc 63
    //   466: iconst_1
    //   467: ldc_w 1100
    //   470: aload_0
    //   471: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   474: iconst_0
    //   475: istore_3
    //   476: goto -138 -> 338
    //   479: astore 5
    //   481: aconst_null
    //   482: astore 4
    //   484: aconst_null
    //   485: astore_0
    //   486: aload 4
    //   488: astore_2
    //   489: aload_0
    //   490: astore_1
    //   491: ldc 63
    //   493: ldc_w 1102
    //   496: aload 5
    //   498: invokestatic 1075	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   501: aload 6
    //   503: ifnull +8 -> 511
    //   506: aload 6
    //   508: invokevirtual 1096	android/os/ParcelFileDescriptor:close	()V
    //   511: aload_0
    //   512: ifnull +7 -> 519
    //   515: aload_0
    //   516: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   519: aload 4
    //   521: ifnull +191 -> 712
    //   524: aload 4
    //   526: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   529: iconst_0
    //   530: istore_3
    //   531: goto -193 -> 338
    //   534: astore_1
    //   535: ldc 63
    //   537: iconst_1
    //   538: ldc_w 1100
    //   541: aload_1
    //   542: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: goto -34 -> 511
    //   548: astore_0
    //   549: ldc 63
    //   551: iconst_1
    //   552: ldc_w 1100
    //   555: aload_0
    //   556: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   559: goto -40 -> 519
    //   562: astore_0
    //   563: ldc 63
    //   565: iconst_1
    //   566: ldc_w 1100
    //   569: aload_0
    //   570: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   573: iconst_0
    //   574: istore_3
    //   575: goto -237 -> 338
    //   578: astore_2
    //   579: aconst_null
    //   580: astore_0
    //   581: aload 5
    //   583: astore 4
    //   585: aload 6
    //   587: ifnull +8 -> 595
    //   590: aload 6
    //   592: invokevirtual 1096	android/os/ParcelFileDescriptor:close	()V
    //   595: aload_0
    //   596: ifnull +7 -> 603
    //   599: aload_0
    //   600: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   603: aload 4
    //   605: ifnull +8 -> 613
    //   608: aload 4
    //   610: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   613: aload_2
    //   614: athrow
    //   615: astore_1
    //   616: ldc 63
    //   618: iconst_1
    //   619: ldc_w 1100
    //   622: aload_1
    //   623: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: goto -31 -> 595
    //   629: astore_0
    //   630: ldc 63
    //   632: iconst_1
    //   633: ldc_w 1100
    //   636: aload_0
    //   637: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   640: goto -37 -> 603
    //   643: astore_0
    //   644: ldc 63
    //   646: iconst_1
    //   647: ldc_w 1100
    //   650: aload_0
    //   651: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   654: goto -41 -> 613
    //   657: aconst_null
    //   658: astore_0
    //   659: goto -314 -> 345
    //   662: astore_2
    //   663: aload 5
    //   665: astore 4
    //   667: goto -82 -> 585
    //   670: astore_0
    //   671: aload_2
    //   672: astore 4
    //   674: aload_0
    //   675: astore_2
    //   676: aload_1
    //   677: astore_0
    //   678: goto -93 -> 585
    //   681: astore 5
    //   683: aconst_null
    //   684: astore 4
    //   686: goto -200 -> 486
    //   689: astore 5
    //   691: goto -205 -> 486
    //   694: astore 5
    //   696: aconst_null
    //   697: astore 4
    //   699: aconst_null
    //   700: astore_0
    //   701: goto -408 -> 293
    //   704: astore 5
    //   706: aconst_null
    //   707: astore 4
    //   709: goto -416 -> 293
    //   712: iconst_0
    //   713: istore_3
    //   714: goto -376 -> 338
    //   717: iconst_1
    //   718: istore_3
    //   719: goto -381 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	paramContext	Context
    //   0	722	1	paramString1	String
    //   0	722	2	paramString2	String
    //   84	635	3	i	int
    //   28	7	4	localUri	android.net.Uri
    //   59	8	4	localException	Exception
    //   234	474	4	localObject	Object
    //   1	272	5	arrayOfByte	byte[]
    //   291	13	5	localIOException1	IOException
    //   479	185	5	localOutOfMemoryError1	OutOfMemoryError
    //   681	1	5	localOutOfMemoryError2	OutOfMemoryError
    //   689	1	5	localOutOfMemoryError3	OutOfMemoryError
    //   694	1	5	localIOException2	IOException
    //   704	1	5	localIOException3	IOException
    //   42	549	6	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   136	207	7	str	String
    // Exception table:
    //   from	to	target	type
    //   30	44	59	java/lang/Exception
    //   241	248	291	java/io/IOException
    //   253	261	291	java/io/IOException
    //   271	279	291	java/io/IOException
    //   284	288	291	java/io/IOException
    //   363	368	391	java/io/IOException
    //   372	376	405	java/io/IOException
    //   381	386	419	java/io/IOException
    //   313	318	435	java/io/IOException
    //   322	326	449	java/io/IOException
    //   331	336	463	java/io/IOException
    //   169	181	479	java/lang/OutOfMemoryError
    //   181	206	479	java/lang/OutOfMemoryError
    //   206	215	479	java/lang/OutOfMemoryError
    //   506	511	534	java/io/IOException
    //   515	519	548	java/io/IOException
    //   524	529	562	java/io/IOException
    //   169	181	578	finally
    //   181	206	578	finally
    //   206	215	578	finally
    //   590	595	615	java/io/IOException
    //   599	603	629	java/io/IOException
    //   608	613	643	java/io/IOException
    //   215	236	662	finally
    //   241	248	670	finally
    //   253	261	670	finally
    //   271	279	670	finally
    //   284	288	670	finally
    //   298	308	670	finally
    //   491	501	670	finally
    //   215	236	681	java/lang/OutOfMemoryError
    //   241	248	689	java/lang/OutOfMemoryError
    //   253	261	689	java/lang/OutOfMemoryError
    //   271	279	689	java/lang/OutOfMemoryError
    //   284	288	689	java/lang/OutOfMemoryError
    //   169	181	694	java/io/IOException
    //   181	206	694	java/io/IOException
    //   206	215	694	java/io/IOException
    //   215	236	704	java/io/IOException
  }
  
  public static void uncompressZip(String paramString1, String paramString2, boolean paramBoolean)
  {
    uncompressZip(paramString1, paramString2, paramBoolean, null);
  }
  
  /* Error */
  public static void uncompressZip(String paramString1, String paramString2, boolean paramBoolean, @androidx.annotation.Nullable java.util.regex.Pattern paramPattern)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: ldc 63
    //   11: iconst_2
    //   12: new 113	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1110
    //   22: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 1112
    //   32: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: new 157	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: new 316	java/io/BufferedInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 323	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore 9
    //   64: new 1114	com/tencent/commonsdk/zip/QZipInputStream
    //   67: dup
    //   68: aload 9
    //   70: invokespecial 1115	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   73: astore 10
    //   75: new 141	java/io/File
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokevirtual 244	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   90: sipush 8192
    //   93: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   96: astore 16
    //   98: aconst_null
    //   99: astore 11
    //   101: aconst_null
    //   102: astore 13
    //   104: aload 10
    //   106: invokevirtual 1119	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   109: astore 12
    //   111: aload 12
    //   113: ifnonnull +88 -> 201
    //   116: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   119: aload 16
    //   121: invokevirtual 423	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   124: invokestatic 1125	java/lang/Math:random	()D
    //   127: ldc2_w 1126
    //   130: dcmpg
    //   131: ifge +21 -> 152
    //   134: invokestatic 1131	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   137: invokestatic 1136	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   140: aconst_null
    //   141: ldc_w 1138
    //   144: iconst_1
    //   145: lconst_0
    //   146: lconst_0
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokevirtual 1142	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   152: aload 10
    //   154: ifnull +8 -> 162
    //   157: aload 10
    //   159: invokevirtual 1143	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   162: aload 9
    //   164: ifnull +8 -> 172
    //   167: aload 9
    //   169: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   172: aload_0
    //   173: ifnull +7 -> 180
    //   176: aload_0
    //   177: invokevirtual 562	java/io/FileInputStream:close	()V
    //   180: aload 13
    //   182: ifnull +8 -> 190
    //   185: aload 13
    //   187: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   190: aload 11
    //   192: ifnull +8 -> 200
    //   195: aload 11
    //   197: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   200: return
    //   201: aload 12
    //   203: invokevirtual 1147	java/util/zip/ZipEntry:isDirectory	()Z
    //   206: ifne -102 -> 104
    //   209: aload 12
    //   211: invokevirtual 1148	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   214: astore 12
    //   216: aload 12
    //   218: ifnull -114 -> 104
    //   221: aload 12
    //   223: ldc_w 1150
    //   226: invokevirtual 1153	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   229: ifne -125 -> 104
    //   232: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +30 -> 265
    //   238: ldc 63
    //   240: iconst_2
    //   241: new 113	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 1155
    //   251: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 12
    //   256: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_3
    //   266: ifnull +176 -> 442
    //   269: aload_3
    //   270: aload 12
    //   272: invokevirtual 1161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   275: invokevirtual 1166	java/util/regex/Matcher:matches	()Z
    //   278: ifne +164 -> 442
    //   281: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq -180 -> 104
    //   287: ldc 63
    //   289: iconst_2
    //   290: new 113	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 1168
    //   300: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 12
    //   305: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: goto -210 -> 104
    //   317: astore 14
    //   319: aload_0
    //   320: astore 12
    //   322: aload 13
    //   324: astore_3
    //   325: aload 10
    //   327: astore 13
    //   329: aload 11
    //   331: astore_1
    //   332: iconst_0
    //   333: istore 4
    //   335: aload 14
    //   337: astore_0
    //   338: aload 12
    //   340: astore 11
    //   342: aload 9
    //   344: astore 10
    //   346: aload 13
    //   348: astore 9
    //   350: invokestatic 1125	java/lang/Math:random	()D
    //   353: ldc2_w 1126
    //   356: dcmpg
    //   357: ifge +32 -> 389
    //   360: invokestatic 1131	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   363: invokestatic 1136	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   366: astore 12
    //   368: iload 4
    //   370: ifne +489 -> 859
    //   373: iconst_1
    //   374: istore_2
    //   375: aload 12
    //   377: aconst_null
    //   378: ldc_w 1138
    //   381: iload_2
    //   382: lconst_0
    //   383: lconst_0
    //   384: aconst_null
    //   385: aconst_null
    //   386: invokevirtual 1142	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   389: aload 9
    //   391: ifnull +13 -> 404
    //   394: iload 4
    //   396: ifne +8 -> 404
    //   399: aload 9
    //   401: invokevirtual 1143	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   404: aload 10
    //   406: ifnull +8 -> 414
    //   409: aload 10
    //   411: invokevirtual 334	java/io/BufferedInputStream:close	()V
    //   414: aload 11
    //   416: ifnull +8 -> 424
    //   419: aload 11
    //   421: invokevirtual 562	java/io/FileInputStream:close	()V
    //   424: aload_3
    //   425: ifnull +7 -> 432
    //   428: aload_3
    //   429: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   432: aload_1
    //   433: ifnull +7 -> 440
    //   436: aload_1
    //   437: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   440: aload_0
    //   441: athrow
    //   442: aload 12
    //   444: getstatic 1172	java/io/File:separatorChar	C
    //   447: invokevirtual 702	java/lang/String:lastIndexOf	(I)I
    //   450: istore 4
    //   452: iload 4
    //   454: aload 12
    //   456: invokevirtual 519	java/lang/String:length	()I
    //   459: iconst_1
    //   460: isub
    //   461: if_icmpne +591 -> 1052
    //   464: new 770	java/lang/IllegalArgumentException
    //   467: dup
    //   468: new 113	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   475: ldc_w 1174
    //   478: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload 12
    //   483: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokespecial 1175	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   492: athrow
    //   493: aload 12
    //   495: astore 15
    //   497: iload_2
    //   498: ifeq +32 -> 530
    //   501: aload 12
    //   503: ldc_w 884
    //   506: invokevirtual 1076	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   509: istore 4
    //   511: aload 12
    //   513: astore 15
    //   515: iload 4
    //   517: ifle +13 -> 530
    //   520: aload 12
    //   522: iconst_0
    //   523: iload 4
    //   525: invokevirtual 710	java/lang/String:substring	(II)Ljava/lang/String;
    //   528: astore 15
    //   530: new 141	java/io/File
    //   533: dup
    //   534: aload 14
    //   536: aload 15
    //   538: invokespecial 1177	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: astore 12
    //   543: aload 12
    //   545: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   548: invokevirtual 146	java/io/File:exists	()Z
    //   551: ifne +12 -> 563
    //   554: aload 12
    //   556: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   559: invokevirtual 244	java/io/File:mkdirs	()Z
    //   562: pop
    //   563: aload 12
    //   565: invokevirtual 146	java/io/File:exists	()Z
    //   568: ifeq +9 -> 577
    //   571: aload 12
    //   573: invokevirtual 358	java/io/File:delete	()Z
    //   576: pop
    //   577: new 313	java/io/FileOutputStream
    //   580: dup
    //   581: aload 12
    //   583: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   586: astore 12
    //   588: new 1032	java/io/BufferedOutputStream
    //   591: dup
    //   592: aload 12
    //   594: aload 16
    //   596: arraylength
    //   597: invokespecial 1036	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   600: astore 13
    //   602: iconst_0
    //   603: istore 6
    //   605: iload 7
    //   607: istore 4
    //   609: aload 10
    //   611: aload 16
    //   613: iconst_0
    //   614: aload 16
    //   616: arraylength
    //   617: invokevirtual 1178	com/tencent/commonsdk/zip/QZipInputStream:read	([BII)I
    //   620: istore 8
    //   622: iload 8
    //   624: iconst_m1
    //   625: if_icmpeq +196 -> 821
    //   628: iload 6
    //   630: istore 5
    //   632: iload 8
    //   634: ifne +166 -> 800
    //   637: iload 6
    //   639: iconst_1
    //   640: iadd
    //   641: istore 4
    //   643: iload 4
    //   645: istore 5
    //   647: iload 4
    //   649: bipush 10
    //   651: if_icmple +149 -> 800
    //   654: iconst_1
    //   655: istore 4
    //   657: new 290	java/io/IOException
    //   660: dup
    //   661: ldc_w 1180
    //   664: invokespecial 915	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   667: athrow
    //   668: astore_1
    //   669: aload 9
    //   671: astore 11
    //   673: aload_0
    //   674: astore 14
    //   676: aload 10
    //   678: astore 9
    //   680: aload 12
    //   682: astore_3
    //   683: aload_1
    //   684: astore_0
    //   685: aload 13
    //   687: astore_1
    //   688: aload 11
    //   690: astore 10
    //   692: aload 14
    //   694: astore 11
    //   696: goto -346 -> 350
    //   699: aload 12
    //   701: iconst_1
    //   702: invokevirtual 1098	java/lang/String:substring	(I)Ljava/lang/String;
    //   705: astore 12
    //   707: aload_1
    //   708: astore 14
    //   710: goto -217 -> 493
    //   713: aload 12
    //   715: iconst_0
    //   716: iload 4
    //   718: invokevirtual 710	java/lang/String:substring	(II)Ljava/lang/String;
    //   721: astore 14
    //   723: aload 14
    //   725: iconst_0
    //   726: invokevirtual 1184	java/lang/String:charAt	(I)C
    //   729: getstatic 1172	java/io/File:separatorChar	C
    //   732: if_icmpne +38 -> 770
    //   735: new 113	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   742: aload_1
    //   743: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload 14
    //   748: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: astore 14
    //   756: aload 12
    //   758: iload 4
    //   760: iconst_1
    //   761: iadd
    //   762: invokevirtual 1098	java/lang/String:substring	(I)Ljava/lang/String;
    //   765: astore 12
    //   767: goto -274 -> 493
    //   770: new 113	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   777: aload_1
    //   778: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: getstatic 1172	java/io/File:separatorChar	C
    //   784: invokevirtual 1187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   787: aload 14
    //   789: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: astore 14
    //   797: goto -41 -> 756
    //   800: iload 7
    //   802: istore 4
    //   804: aload 13
    //   806: aload 16
    //   808: iconst_0
    //   809: iload 8
    //   811: invokevirtual 1188	java/io/BufferedOutputStream:write	([BII)V
    //   814: iload 5
    //   816: istore 6
    //   818: goto -213 -> 605
    //   821: iload 7
    //   823: istore 4
    //   825: aload 13
    //   827: invokevirtual 1189	java/io/BufferedOutputStream:flush	()V
    //   830: iload 7
    //   832: istore 4
    //   834: aload 13
    //   836: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   839: iload 7
    //   841: istore 4
    //   843: aload 12
    //   845: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   848: aload 13
    //   850: astore 11
    //   852: aload 12
    //   854: astore 13
    //   856: goto -752 -> 104
    //   859: iconst_0
    //   860: istore_2
    //   861: goto -486 -> 375
    //   864: astore_1
    //   865: goto -703 -> 162
    //   868: astore_1
    //   869: goto -697 -> 172
    //   872: astore_0
    //   873: goto -693 -> 180
    //   876: astore_0
    //   877: goto -687 -> 190
    //   880: astore_0
    //   881: return
    //   882: astore 9
    //   884: goto -480 -> 404
    //   887: astore 9
    //   889: goto -475 -> 414
    //   892: astore 9
    //   894: goto -470 -> 424
    //   897: astore_3
    //   898: goto -466 -> 432
    //   901: astore_1
    //   902: goto -462 -> 440
    //   905: astore_0
    //   906: iconst_0
    //   907: istore 4
    //   909: aconst_null
    //   910: astore_1
    //   911: aconst_null
    //   912: astore_3
    //   913: aconst_null
    //   914: astore 9
    //   916: aconst_null
    //   917: astore 10
    //   919: aconst_null
    //   920: astore 11
    //   922: goto -572 -> 350
    //   925: astore_1
    //   926: iconst_0
    //   927: istore 4
    //   929: aconst_null
    //   930: astore 12
    //   932: aconst_null
    //   933: astore_3
    //   934: aconst_null
    //   935: astore 10
    //   937: aload_0
    //   938: astore 11
    //   940: aconst_null
    //   941: astore 9
    //   943: aload_1
    //   944: astore_0
    //   945: aload 12
    //   947: astore_1
    //   948: goto -598 -> 350
    //   951: astore_1
    //   952: iconst_0
    //   953: istore 4
    //   955: aconst_null
    //   956: astore_3
    //   957: aload 9
    //   959: astore 10
    //   961: aload_0
    //   962: astore 11
    //   964: aconst_null
    //   965: astore 12
    //   967: aconst_null
    //   968: astore 9
    //   970: aload_1
    //   971: astore_0
    //   972: aload_3
    //   973: astore_1
    //   974: aload 12
    //   976: astore_3
    //   977: goto -627 -> 350
    //   980: astore_1
    //   981: iconst_0
    //   982: istore 4
    //   984: aload 9
    //   986: astore 11
    //   988: aload_0
    //   989: astore 12
    //   991: aload 10
    //   993: astore 9
    //   995: aconst_null
    //   996: astore_3
    //   997: aconst_null
    //   998: astore 10
    //   1000: aload_1
    //   1001: astore_0
    //   1002: aload 10
    //   1004: astore_1
    //   1005: aload 11
    //   1007: astore 10
    //   1009: aload 12
    //   1011: astore 11
    //   1013: goto -663 -> 350
    //   1016: astore 15
    //   1018: iconst_0
    //   1019: istore 4
    //   1021: aload 9
    //   1023: astore 13
    //   1025: aload_0
    //   1026: astore 14
    //   1028: aload 12
    //   1030: astore_3
    //   1031: aload 10
    //   1033: astore 9
    //   1035: aload 11
    //   1037: astore_1
    //   1038: aload 15
    //   1040: astore_0
    //   1041: aload 13
    //   1043: astore 10
    //   1045: aload 14
    //   1047: astore 11
    //   1049: goto -699 -> 350
    //   1052: iload 4
    //   1054: ifgt -341 -> 713
    //   1057: iload 4
    //   1059: ifge -360 -> 699
    //   1062: aload_1
    //   1063: astore 14
    //   1065: goto -572 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1068	0	paramString1	String
    //   0	1068	1	paramString2	String
    //   0	1068	2	paramBoolean	boolean
    //   0	1068	3	paramPattern	java.util.regex.Pattern
    //   333	725	4	i	int
    //   630	185	5	j	int
    //   603	214	6	k	int
    //   1	839	7	m	int
    //   620	190	8	n	int
    //   62	617	9	localObject1	Object
    //   882	1	9	localIOException1	IOException
    //   887	1	9	localIOException2	IOException
    //   892	1	9	localIOException3	IOException
    //   914	120	9	localObject2	Object
    //   73	971	10	localObject3	Object
    //   99	949	11	localObject4	Object
    //   109	920	12	localObject5	Object
    //   102	940	13	localObject6	Object
    //   317	218	14	str1	String
    //   674	390	14	str2	String
    //   495	42	15	localObject7	Object
    //   1016	23	15	localObject8	Object
    //   96	711	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   104	111	317	finally
    //   116	124	317	finally
    //   201	216	317	finally
    //   221	265	317	finally
    //   269	314	317	finally
    //   442	493	317	finally
    //   501	511	317	finally
    //   520	530	317	finally
    //   530	563	317	finally
    //   563	577	317	finally
    //   577	588	317	finally
    //   699	707	317	finally
    //   713	756	317	finally
    //   756	767	317	finally
    //   770	797	317	finally
    //   609	622	668	finally
    //   657	668	668	finally
    //   804	814	668	finally
    //   825	830	668	finally
    //   834	839	668	finally
    //   843	848	668	finally
    //   157	162	864	java/io/IOException
    //   167	172	868	java/io/IOException
    //   176	180	872	java/io/IOException
    //   185	190	876	java/io/IOException
    //   195	200	880	java/io/IOException
    //   399	404	882	java/io/IOException
    //   409	414	887	java/io/IOException
    //   419	424	892	java/io/IOException
    //   428	432	897	java/io/IOException
    //   436	440	901	java/io/IOException
    //   3	45	905	finally
    //   45	54	905	finally
    //   54	64	925	finally
    //   64	75	951	finally
    //   75	98	980	finally
    //   588	602	1016	finally
  }
  
  /* Error */
  public static boolean uncompressZipEntry(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 141	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: aload 6
    //   18: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   21: invokevirtual 146	java/io/File:exists	()Z
    //   24: ifne +12 -> 36
    //   27: aload 6
    //   29: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   32: invokevirtual 244	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 1193	com/tencent/commonsdk/zip/QZipFile
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 1194	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: new 141	java/io/File
    //   48: dup
    //   49: new 113	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   56: aload_1
    //   57: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 1196
    //   63: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 9
    //   74: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   77: sipush 8192
    //   80: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   83: astore 10
    //   85: new 313	java/io/FileOutputStream
    //   88: dup
    //   89: aload 9
    //   91: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore 4
    //   96: new 1032	java/io/BufferedOutputStream
    //   99: dup
    //   100: aload 4
    //   102: aload 10
    //   104: arraylength
    //   105: invokespecial 1036	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   108: astore 7
    //   110: aload_0
    //   111: invokevirtual 1200	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   114: astore 11
    //   116: aload 5
    //   118: astore 6
    //   120: aload 11
    //   122: invokeinterface 1205 1 0
    //   127: ifeq +146 -> 273
    //   130: aload 5
    //   132: astore 6
    //   134: aload 11
    //   136: invokeinterface 1208 1 0
    //   141: checkcast 1146	java/util/zip/ZipEntry
    //   144: astore 8
    //   146: aload 5
    //   148: ifnull +12 -> 160
    //   151: aload 5
    //   153: astore 6
    //   155: aload 5
    //   157: invokevirtual 619	java/io/InputStream:close	()V
    //   160: aload 5
    //   162: astore 6
    //   164: aload_0
    //   165: aload 8
    //   167: invokevirtual 1212	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   170: astore 8
    //   172: aload 8
    //   174: astore 6
    //   176: aload 8
    //   178: aload 10
    //   180: iconst_0
    //   181: aload 10
    //   183: arraylength
    //   184: invokevirtual 623	java/io/InputStream:read	([BII)I
    //   187: istore_2
    //   188: aload 8
    //   190: astore 5
    //   192: iload_2
    //   193: iconst_m1
    //   194: if_icmpeq -78 -> 116
    //   197: aload 8
    //   199: astore 6
    //   201: aload 7
    //   203: aload 10
    //   205: iconst_0
    //   206: iload_2
    //   207: invokevirtual 1188	java/io/BufferedOutputStream:write	([BII)V
    //   210: goto -38 -> 172
    //   213: astore 8
    //   215: aload 4
    //   217: astore 5
    //   219: aload 7
    //   221: astore 4
    //   223: aload_0
    //   224: astore_1
    //   225: aload 8
    //   227: astore_0
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   238: aload 4
    //   240: ifnull +13 -> 253
    //   243: aload 4
    //   245: invokevirtual 1189	java/io/BufferedOutputStream:flush	()V
    //   248: aload 4
    //   250: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   253: aload 6
    //   255: ifnull +8 -> 263
    //   258: aload 6
    //   260: invokevirtual 619	java/io/InputStream:close	()V
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 1213	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   271: aload_0
    //   272: athrow
    //   273: aload 5
    //   275: astore 6
    //   277: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   280: aload 10
    //   282: invokevirtual 423	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   285: aload 5
    //   287: astore 6
    //   289: aload 9
    //   291: new 141	java/io/File
    //   294: dup
    //   295: aload_1
    //   296: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   299: invokevirtual 846	java/io/File:renameTo	(Ljava/io/File;)Z
    //   302: istore_3
    //   303: aload 4
    //   305: ifnull +8 -> 313
    //   308: aload 4
    //   310: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   313: aload 7
    //   315: ifnull +13 -> 328
    //   318: aload 7
    //   320: invokevirtual 1189	java/io/BufferedOutputStream:flush	()V
    //   323: aload 7
    //   325: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   328: aload 5
    //   330: ifnull +8 -> 338
    //   333: aload 5
    //   335: invokevirtual 619	java/io/InputStream:close	()V
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 1213	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   346: iload_3
    //   347: ireturn
    //   348: astore 6
    //   350: goto -190 -> 160
    //   353: astore_1
    //   354: goto -41 -> 313
    //   357: astore_1
    //   358: goto -20 -> 338
    //   361: astore_0
    //   362: iload_3
    //   363: ireturn
    //   364: astore 5
    //   366: goto -128 -> 238
    //   369: astore 4
    //   371: goto -108 -> 263
    //   374: astore_1
    //   375: goto -104 -> 271
    //   378: astore 4
    //   380: goto -127 -> 253
    //   383: astore_0
    //   384: aconst_null
    //   385: astore 7
    //   387: aconst_null
    //   388: astore 5
    //   390: aconst_null
    //   391: astore 6
    //   393: aload 4
    //   395: astore_1
    //   396: aload 7
    //   398: astore 4
    //   400: goto -172 -> 228
    //   403: astore 7
    //   405: aconst_null
    //   406: astore 5
    //   408: aconst_null
    //   409: astore 6
    //   411: aconst_null
    //   412: astore 4
    //   414: aload_0
    //   415: astore_1
    //   416: aload 7
    //   418: astore_0
    //   419: goto -191 -> 228
    //   422: astore 7
    //   424: aload 4
    //   426: astore 5
    //   428: aconst_null
    //   429: astore 6
    //   431: aconst_null
    //   432: astore 4
    //   434: aload_0
    //   435: astore_1
    //   436: aload 7
    //   438: astore_0
    //   439: goto -211 -> 228
    //   442: astore 8
    //   444: aload 4
    //   446: astore 5
    //   448: aconst_null
    //   449: astore 6
    //   451: aload_0
    //   452: astore_1
    //   453: aload 8
    //   455: astore_0
    //   456: aload 7
    //   458: astore 4
    //   460: goto -232 -> 228
    //   463: astore_1
    //   464: goto -136 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramString1	String
    //   0	467	1	paramString2	String
    //   187	20	2	i	int
    //   302	61	3	bool	boolean
    //   1	308	4	localObject1	Object
    //   369	1	4	localIOException1	IOException
    //   378	16	4	localIOException2	IOException
    //   398	61	4	localObject2	Object
    //   4	330	5	localObject3	Object
    //   364	1	5	localIOException3	IOException
    //   388	59	5	localObject4	Object
    //   14	274	6	localObject5	Object
    //   348	1	6	localIOException4	IOException
    //   391	59	6	localObject6	Object
    //   108	289	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   403	14	7	localObject7	Object
    //   422	35	7	localObject8	Object
    //   144	54	8	localObject9	Object
    //   213	13	8	localObject10	Object
    //   442	12	8	localObject11	Object
    //   72	218	9	localFile	File
    //   83	198	10	arrayOfByte	byte[]
    //   114	21	11	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   120	130	213	finally
    //   134	146	213	finally
    //   155	160	213	finally
    //   164	172	213	finally
    //   176	188	213	finally
    //   201	210	213	finally
    //   277	285	213	finally
    //   289	303	213	finally
    //   155	160	348	java/io/IOException
    //   308	313	353	java/io/IOException
    //   333	338	357	java/io/IOException
    //   342	346	361	java/io/IOException
    //   233	238	364	java/io/IOException
    //   258	263	369	java/io/IOException
    //   267	271	374	java/io/IOException
    //   243	253	378	java/io/IOException
    //   6	36	383	finally
    //   36	45	383	finally
    //   45	96	403	finally
    //   96	110	422	finally
    //   110	116	442	finally
    //   318	328	463	java/io/IOException
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
    paramString1 = new File(paramString1 + str);
    bool1 = true;
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
      return false;
    }
    catch (IOException paramString2)
    {
      try
      {
        for (;;)
        {
          paramString1 = new FileOutputStream(paramString1, false);
          try
          {
            paramString2 = paramString3 + "\r\n";
            bool1 = bool2;
            if (paramString1 != null)
            {
              paramString1.write(paramString2.getBytes());
              bool1 = bool2;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          catch (OutOfMemoryError paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool2 = bool1;
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool2 = false;
            }
          }
          bool3 = bool2;
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            bool3 = bool2;
            return bool3;
          }
          catch (IOException paramString1) {}
          paramString2 = paramString2;
          bool2 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool2 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  public static boolean writeFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      if (!paramString1.getParentFile().exists()) {
        paramString1.getParentFile().mkdirs();
      }
      paramString1.createNewFile();
      bool1 = bool2;
      String str;
      return false;
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          paramString1 = new FileOutputStream(paramString1, false);
          str = paramString2;
          if (paramBoolean) {}
          try
          {
            str = paramString2 + "\r\n";
            paramBoolean = bool1;
            if (paramString1 != null)
            {
              paramString1.write(str.getBytes());
              paramBoolean = bool1;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              paramBoolean = false;
            }
          }
          bool1 = paramBoolean;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool1 = paramBoolean;
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            return bool1;
          }
          catch (IOException paramString1) {}
          localIOException = localIOException;
          bool1 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool1 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  /* Error */
  public static boolean writeFile(String paramString, StringBuffer paramStringBuffer, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 141	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload_1
    //   11: ifnonnull +9 -> 20
    //   14: iconst_0
    //   15: istore 5
    //   17: iload 5
    //   19: ireturn
    //   20: aload_1
    //   21: invokevirtual 742	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   24: ldc_w 1225
    //   27: ldc_w 574
    //   30: invokevirtual 1228	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_1
    //   34: new 141	java/io/File
    //   37: dup
    //   38: new 113	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_0
    //   60: iconst_1
    //   61: istore 4
    //   63: aload 6
    //   65: invokevirtual 146	java/io/File:exists	()Z
    //   68: ifne +21 -> 89
    //   71: aload 6
    //   73: invokevirtual 244	java/io/File:mkdirs	()Z
    //   76: istore 5
    //   78: iload 5
    //   80: istore 4
    //   82: iload 5
    //   84: ifne +5 -> 89
    //   87: iconst_0
    //   88: ireturn
    //   89: iload 4
    //   91: istore 5
    //   93: aload 6
    //   95: invokevirtual 146	java/io/File:exists	()Z
    //   98: ifeq -81 -> 17
    //   101: aload_0
    //   102: invokevirtual 146	java/io/File:exists	()Z
    //   105: ifne +8 -> 113
    //   108: aload_0
    //   109: invokevirtual 367	java/io/File:createNewFile	()Z
    //   112: pop
    //   113: new 313	java/io/FileOutputStream
    //   116: dup
    //   117: aload_0
    //   118: iconst_0
    //   119: invokespecial 849	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   122: astore_0
    //   123: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   126: sipush 4096
    //   129: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   132: astore_1
    //   133: aload_2
    //   134: aload_1
    //   135: invokevirtual 905	java/io/InputStream:read	([B)I
    //   138: istore_3
    //   139: iload_3
    //   140: iconst_m1
    //   141: if_icmpeq +38 -> 179
    //   144: aload_0
    //   145: aload_1
    //   146: iconst_0
    //   147: iload_3
    //   148: invokevirtual 413	java/io/FileOutputStream:write	([BII)V
    //   151: goto -18 -> 133
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_0
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 179	java/io/FileNotFoundException:printStackTrace	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: invokestatic 408	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   182: aload_1
    //   183: invokevirtual 423	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   186: aload_0
    //   187: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   190: iload 4
    //   192: istore 5
    //   194: aload_0
    //   195: ifnull -178 -> 17
    //   198: aload_0
    //   199: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   202: iload 4
    //   204: ireturn
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   210: iload 4
    //   212: ireturn
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   218: goto -51 -> 167
    //   221: astore_1
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   237: goto -7 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramStringBuffer	StringBuffer
    //   0	240	2	paramInputStream	InputStream
    //   138	10	3	i	int
    //   61	150	4	bool1	boolean
    //   15	178	5	bool2	boolean
    //   8	86	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   123	133	154	java/io/IOException
    //   133	139	154	java/io/IOException
    //   144	151	154	java/io/IOException
    //   179	190	154	java/io/IOException
    //   108	113	169	java/io/IOException
    //   113	123	172	java/io/FileNotFoundException
    //   198	202	205	java/io/IOException
    //   163	167	213	java/io/IOException
    //   123	133	221	finally
    //   133	139	221	finally
    //   144	151	221	finally
    //   155	159	221	finally
    //   179	190	221	finally
    //   226	230	232	java/io/IOException
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
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 141	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 146	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 146	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 398	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 244	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 367	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 313	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 849	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 413	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 416	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   74: iconst_1
    //   75: istore_2
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: ifnull -9 -> 76
    //   88: aload_0
    //   89: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore_0
    //   119: goto -18 -> 101
    //   122: astore_0
    //   123: aload_1
    //   124: astore_0
    //   125: goto -44 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramArrayOfByte	byte[]
    //   0	128	1	paramString	String
    //   0	128	2	paramBoolean	boolean
    //   0	128	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	78	java/io/IOException
    //   40	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   88	92	94	java/io/IOException
    //   15	40	97	finally
    //   40	45	97	finally
    //   45	55	97	finally
    //   70	74	111	java/io/IOException
    //   105	109	114	java/io/IOException
    //   55	66	118	finally
    //   55	66	122	java/io/IOException
  }
  
  /* Error */
  public static void writeObject(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 1244	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 1032	java/io/BufferedOutputStream
    //   15: dup
    //   16: invokestatic 963	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: iconst_0
    //   21: invokevirtual 1248	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   24: invokespecial 1251	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 1252	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 1255	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: invokevirtual 1256	java/io/ObjectOutputStream:flush	()V
    //   44: aload_3
    //   45: ifnull -38 -> 7
    //   48: aload_3
    //   49: invokevirtual 1257	java/io/ObjectOutputStream:close	()V
    //   52: return
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   58: return
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_2
    //   65: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +45 -> 113
    //   71: aload_1
    //   72: astore_2
    //   73: ldc 63
    //   75: iconst_2
    //   76: new 113	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 1259
    //   86: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 978
    //   96: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 4
    //   101: invokevirtual 952	java/lang/Exception:toString	()Ljava/lang/String;
    //   104: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 980	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: ifnull -107 -> 7
    //   117: aload_1
    //   118: invokevirtual 1257	java/io/ObjectOutputStream:close	()V
    //   121: return
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   127: return
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 1257	java/io/ObjectOutputStream:close	()V
    //   139: aload_0
    //   140: athrow
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   146: goto -7 -> 139
    //   149: astore_0
    //   150: goto -19 -> 131
    //   153: astore 4
    //   155: aload_3
    //   156: astore_1
    //   157: goto -94 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString	String
    //   0	160	1	paramObject	Object
    //   32	104	2	localObject	Object
    //   30	126	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   59	41	4	localException1	Exception
    //   153	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/io/IOException
    //   8	31	59	java/lang/Exception
    //   117	121	122	java/io/IOException
    //   8	31	128	finally
    //   135	139	141	java/io/IOException
    //   33	38	149	finally
    //   40	44	149	finally
    //   65	71	149	finally
    //   73	113	149	finally
    //   33	38	153	java/lang/Exception
    //   40	44	153	java/lang/Exception
  }
  
  /* Error */
  public static void writeObjectList(String paramString, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 519	java/lang/String:length	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: new 1244	java/io/ObjectOutputStream
    //   15: dup
    //   16: new 1032	java/io/BufferedOutputStream
    //   19: dup
    //   20: invokestatic 963	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: aload_0
    //   24: iconst_0
    //   25: invokevirtual 1248	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   28: invokespecial 1251	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: invokespecial 1252	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload_1
    //   41: arraylength
    //   42: istore_3
    //   43: iconst_0
    //   44: istore_2
    //   45: iload_2
    //   46: iload_3
    //   47: if_icmpge +248 -> 295
    //   50: aload_1
    //   51: iload_2
    //   52: aaload
    //   53: astore 6
    //   55: aload 5
    //   57: astore 4
    //   59: aload 6
    //   61: instanceof 824
    //   64: ifeq +23 -> 87
    //   67: aload 5
    //   69: astore 4
    //   71: aload 5
    //   73: aload 6
    //   75: checkcast 824	java/lang/Boolean
    //   78: invokevirtual 827	java/lang/Boolean:booleanValue	()Z
    //   81: invokevirtual 1264	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   84: goto +259 -> 343
    //   87: aload 5
    //   89: astore 4
    //   91: aload 6
    //   93: instanceof 984
    //   96: ifeq +108 -> 204
    //   99: aload 5
    //   101: astore 4
    //   103: aload 5
    //   105: aload 6
    //   107: checkcast 984	java/lang/Byte
    //   110: invokevirtual 1267	java/lang/Byte:byteValue	()B
    //   113: invokevirtual 1270	java/io/ObjectOutputStream:writeByte	(I)V
    //   116: goto +227 -> 343
    //   119: astore 4
    //   121: aload 5
    //   123: astore_1
    //   124: aload 4
    //   126: astore 5
    //   128: aload_1
    //   129: astore 4
    //   131: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +47 -> 181
    //   137: aload_1
    //   138: astore 4
    //   140: ldc_w 999
    //   143: iconst_2
    //   144: new 113	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 1272
    //   154: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 1003
    //   164: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 1004	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 440	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_1
    //   182: astore 4
    //   184: aload 5
    //   186: invokevirtual 674	java/lang/Exception:printStackTrace	()V
    //   189: aload_1
    //   190: ifnull -179 -> 11
    //   193: aload_1
    //   194: invokevirtual 1257	java/io/ObjectOutputStream:close	()V
    //   197: return
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   203: return
    //   204: aload 5
    //   206: astore 4
    //   208: aload 6
    //   210: instanceof 576
    //   213: ifeq +36 -> 249
    //   216: aload 5
    //   218: astore 4
    //   220: aload 5
    //   222: aload 6
    //   224: checkcast 576	java/lang/Integer
    //   227: invokevirtual 1275	java/lang/Integer:intValue	()I
    //   230: invokevirtual 1278	java/io/ObjectOutputStream:writeInt	(I)V
    //   233: goto +110 -> 343
    //   236: astore_0
    //   237: aload 4
    //   239: ifnull +8 -> 247
    //   242: aload 4
    //   244: invokevirtual 1257	java/io/ObjectOutputStream:close	()V
    //   247: aload_0
    //   248: athrow
    //   249: aload 5
    //   251: astore 4
    //   253: aload 6
    //   255: instanceof 1012
    //   258: ifeq +23 -> 281
    //   261: aload 5
    //   263: astore 4
    //   265: aload 5
    //   267: aload 6
    //   269: checkcast 1012	java/lang/Long
    //   272: invokevirtual 1281	java/lang/Long:longValue	()J
    //   275: invokevirtual 1284	java/io/ObjectOutputStream:writeLong	(J)V
    //   278: goto +65 -> 343
    //   281: aload 5
    //   283: astore 4
    //   285: aload 5
    //   287: aload 6
    //   289: invokevirtual 1255	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   292: goto +51 -> 343
    //   295: aload 5
    //   297: astore 4
    //   299: aload 5
    //   301: invokevirtual 1256	java/io/ObjectOutputStream:flush	()V
    //   304: aload 5
    //   306: ifnull -295 -> 11
    //   309: aload 5
    //   311: invokevirtual 1257	java/io/ObjectOutputStream:close	()V
    //   314: return
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   320: return
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   326: goto -79 -> 247
    //   329: astore_0
    //   330: aconst_null
    //   331: astore 4
    //   333: goto -96 -> 237
    //   336: astore 5
    //   338: aconst_null
    //   339: astore_1
    //   340: goto -212 -> 128
    //   343: iload_2
    //   344: iconst_1
    //   345: iadd
    //   346: istore_2
    //   347: goto -302 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramString	String
    //   0	350	1	paramVarArgs	Object[]
    //   44	303	2	i	int
    //   42	6	3	j	int
    //   38	64	4	localObject1	Object
    //   119	6	4	localException1	Exception
    //   129	203	4	localObject2	Object
    //   34	276	5	localObject3	Object
    //   336	1	5	localException2	Exception
    //   53	235	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   40	43	119	java/lang/Exception
    //   59	67	119	java/lang/Exception
    //   71	84	119	java/lang/Exception
    //   91	99	119	java/lang/Exception
    //   103	116	119	java/lang/Exception
    //   208	216	119	java/lang/Exception
    //   220	233	119	java/lang/Exception
    //   253	261	119	java/lang/Exception
    //   265	278	119	java/lang/Exception
    //   285	292	119	java/lang/Exception
    //   299	304	119	java/lang/Exception
    //   193	197	198	java/io/IOException
    //   40	43	236	finally
    //   59	67	236	finally
    //   71	84	236	finally
    //   91	99	236	finally
    //   103	116	236	finally
    //   131	137	236	finally
    //   140	181	236	finally
    //   184	189	236	finally
    //   208	216	236	finally
    //   220	233	236	finally
    //   253	261	236	finally
    //   265	278	236	finally
    //   285	292	236	finally
    //   299	304	236	finally
    //   309	314	315	java/io/IOException
    //   242	247	321	java/io/IOException
    //   12	36	329	finally
    //   12	36	336	java/lang/Exception
  }
  
  /* Error */
  public static boolean zipFiles(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore 6
    //   6: new 313	java/io/FileOutputStream
    //   9: dup
    //   10: new 141	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore 7
    //   23: new 1032	java/io/BufferedOutputStream
    //   26: dup
    //   27: aload 7
    //   29: invokespecial 1251	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: new 1287	java/util/zip/ZipOutputStream
    //   37: dup
    //   38: aload 8
    //   40: invokespecial 1288	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: astore_1
    //   44: new 141	java/io/File
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 344	java/io/File:listFiles	()[Ljava/io/File;
    //   55: astore_0
    //   56: aload_0
    //   57: arraylength
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: iload_3
    //   63: if_icmpge +221 -> 284
    //   66: aload_0
    //   67: iload_2
    //   68: aaload
    //   69: astore 9
    //   71: aload 9
    //   73: ifnull +204 -> 277
    //   76: aload 9
    //   78: invokevirtual 510	java/io/File:isFile	()Z
    //   81: ifeq +196 -> 277
    //   84: aload_1
    //   85: new 1146	java/util/zip/ZipEntry
    //   88: dup
    //   89: aload 9
    //   91: invokevirtual 353	java/io/File:getName	()Ljava/lang/String;
    //   94: invokespecial 1289	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 1293	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   100: aload_1
    //   101: bipush 9
    //   103: invokevirtual 1296	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   106: new 157	java/io/FileInputStream
    //   109: dup
    //   110: aload 9
    //   112: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: astore 9
    //   117: sipush 20480
    //   120: newarray byte
    //   122: astore 10
    //   124: aload 9
    //   126: aload 10
    //   128: iconst_0
    //   129: sipush 20480
    //   132: invokevirtual 1297	java/io/FileInputStream:read	([BII)I
    //   135: istore 4
    //   137: iload 4
    //   139: iconst_m1
    //   140: if_icmpeq +115 -> 255
    //   143: aload_1
    //   144: aload 10
    //   146: iconst_0
    //   147: iload 4
    //   149: invokevirtual 1298	java/util/zip/ZipOutputStream:write	([BII)V
    //   152: goto -28 -> 124
    //   155: astore_0
    //   156: aload 9
    //   158: ifnull +8 -> 166
    //   161: aload 9
    //   163: invokevirtual 562	java/io/FileInputStream:close	()V
    //   166: aload_1
    //   167: ifnull +11 -> 178
    //   170: aload_1
    //   171: invokevirtual 1299	java/util/zip/ZipOutputStream:flush	()V
    //   174: aload_1
    //   175: invokevirtual 1302	java/util/zip/ZipOutputStream:closeEntry	()V
    //   178: aload_0
    //   179: athrow
    //   180: astore 10
    //   182: aload_1
    //   183: astore_0
    //   184: aload 8
    //   186: astore 9
    //   188: aload 7
    //   190: astore_1
    //   191: aload_0
    //   192: astore 8
    //   194: aload 9
    //   196: astore_0
    //   197: aload 10
    //   199: astore 7
    //   201: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +14 -> 218
    //   207: ldc 63
    //   209: iconst_2
    //   210: ldc_w 1304
    //   213: aload 7
    //   215: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload 8
    //   220: ifnull +8 -> 228
    //   223: aload 8
    //   225: invokevirtual 1305	java/util/zip/ZipOutputStream:close	()V
    //   228: aload_0
    //   229: ifnull +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   236: iload 6
    //   238: istore 5
    //   240: aload_1
    //   241: ifnull +11 -> 252
    //   244: aload_1
    //   245: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   248: iload 6
    //   250: istore 5
    //   252: iload 5
    //   254: ireturn
    //   255: aload 9
    //   257: ifnull +8 -> 265
    //   260: aload 9
    //   262: invokevirtual 562	java/io/FileInputStream:close	()V
    //   265: aload_1
    //   266: ifnull +11 -> 277
    //   269: aload_1
    //   270: invokevirtual 1299	java/util/zip/ZipOutputStream:flush	()V
    //   273: aload_1
    //   274: invokevirtual 1302	java/util/zip/ZipOutputStream:closeEntry	()V
    //   277: iload_2
    //   278: iconst_1
    //   279: iadd
    //   280: istore_2
    //   281: goto -220 -> 61
    //   284: iconst_1
    //   285: istore 6
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 1305	java/util/zip/ZipOutputStream:close	()V
    //   295: aload 8
    //   297: ifnull +8 -> 305
    //   300: aload 8
    //   302: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   305: iload 6
    //   307: istore 5
    //   309: aload 7
    //   311: ifnull -59 -> 252
    //   314: aload 7
    //   316: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   319: iconst_1
    //   320: ireturn
    //   321: astore_0
    //   322: iload 6
    //   324: istore 5
    //   326: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq -77 -> 252
    //   332: ldc 63
    //   334: iconst_2
    //   335: ldc_w 1307
    //   338: aload_0
    //   339: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: iconst_1
    //   343: ireturn
    //   344: astore_0
    //   345: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq -53 -> 295
    //   351: ldc 63
    //   353: iconst_2
    //   354: ldc_w 1307
    //   357: aload_0
    //   358: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: goto -66 -> 295
    //   364: astore_0
    //   365: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq -63 -> 305
    //   371: ldc 63
    //   373: iconst_2
    //   374: ldc_w 1307
    //   377: aload_0
    //   378: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   381: goto -76 -> 305
    //   384: astore 7
    //   386: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq -161 -> 228
    //   392: ldc 63
    //   394: iconst_2
    //   395: ldc_w 1307
    //   398: aload 7
    //   400: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: goto -175 -> 228
    //   406: astore_0
    //   407: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -174 -> 236
    //   413: ldc 63
    //   415: iconst_2
    //   416: ldc_w 1307
    //   419: aload_0
    //   420: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   423: goto -187 -> 236
    //   426: astore_0
    //   427: iload 6
    //   429: istore 5
    //   431: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq -182 -> 252
    //   437: ldc 63
    //   439: iconst_2
    //   440: ldc_w 1307
    //   443: aload_0
    //   444: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   447: iconst_0
    //   448: ireturn
    //   449: astore_0
    //   450: aconst_null
    //   451: astore_1
    //   452: aconst_null
    //   453: astore 8
    //   455: aconst_null
    //   456: astore 7
    //   458: aload_1
    //   459: ifnull +7 -> 466
    //   462: aload_1
    //   463: invokevirtual 1305	java/util/zip/ZipOutputStream:close	()V
    //   466: aload 8
    //   468: ifnull +8 -> 476
    //   471: aload 8
    //   473: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   476: aload 7
    //   478: ifnull +8 -> 486
    //   481: aload 7
    //   483: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   486: aload_0
    //   487: athrow
    //   488: astore_1
    //   489: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq -26 -> 466
    //   495: ldc 63
    //   497: iconst_2
    //   498: ldc_w 1307
    //   501: aload_1
    //   502: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: goto -39 -> 466
    //   508: astore_1
    //   509: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq -36 -> 476
    //   515: ldc 63
    //   517: iconst_2
    //   518: ldc_w 1307
    //   521: aload_1
    //   522: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   525: goto -49 -> 476
    //   528: astore_1
    //   529: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -46 -> 486
    //   535: ldc 63
    //   537: iconst_2
    //   538: ldc_w 1307
    //   541: aload_1
    //   542: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: goto -59 -> 486
    //   548: astore_0
    //   549: aconst_null
    //   550: astore_1
    //   551: aconst_null
    //   552: astore 8
    //   554: goto -96 -> 458
    //   557: astore_0
    //   558: aconst_null
    //   559: astore_1
    //   560: goto -102 -> 458
    //   563: astore_0
    //   564: goto -106 -> 458
    //   567: astore 10
    //   569: aload_0
    //   570: astore 7
    //   572: aload_1
    //   573: astore 9
    //   575: aload 8
    //   577: astore_1
    //   578: aload 10
    //   580: astore_0
    //   581: aload 7
    //   583: astore 8
    //   585: aload 9
    //   587: astore 7
    //   589: goto -131 -> 458
    //   592: astore 7
    //   594: aconst_null
    //   595: astore_0
    //   596: aconst_null
    //   597: astore_1
    //   598: aload 9
    //   600: astore 8
    //   602: goto -401 -> 201
    //   605: astore 8
    //   607: aconst_null
    //   608: astore_0
    //   609: aload 7
    //   611: astore_1
    //   612: aload 8
    //   614: astore 7
    //   616: aload 9
    //   618: astore 8
    //   620: goto -419 -> 201
    //   623: astore 10
    //   625: aload 8
    //   627: astore_0
    //   628: aload 7
    //   630: astore_1
    //   631: aload 10
    //   633: astore 7
    //   635: aload 9
    //   637: astore 8
    //   639: goto -438 -> 201
    //   642: astore_0
    //   643: aconst_null
    //   644: astore 9
    //   646: goto -490 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	paramString1	String
    //   0	649	1	paramString2	String
    //   60	221	2	i	int
    //   58	6	3	j	int
    //   135	13	4	k	int
    //   238	192	5	bool1	boolean
    //   4	424	6	bool2	boolean
    //   21	294	7	localObject1	Object
    //   384	15	7	localIOException	IOException
    //   456	132	7	localObject2	Object
    //   592	18	7	localException1	Exception
    //   614	20	7	localObject3	Object
    //   32	569	8	localObject4	Object
    //   605	8	8	localException2	Exception
    //   618	20	8	localObject5	Object
    //   1	644	9	localObject6	Object
    //   122	23	10	arrayOfByte	byte[]
    //   180	18	10	localException3	Exception
    //   567	12	10	localObject7	Object
    //   623	9	10	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   117	124	155	finally
    //   124	137	155	finally
    //   143	152	155	finally
    //   44	59	180	java/lang/Exception
    //   76	106	180	java/lang/Exception
    //   161	166	180	java/lang/Exception
    //   170	178	180	java/lang/Exception
    //   178	180	180	java/lang/Exception
    //   260	265	180	java/lang/Exception
    //   269	277	180	java/lang/Exception
    //   314	319	321	java/io/IOException
    //   291	295	344	java/io/IOException
    //   300	305	364	java/io/IOException
    //   223	228	384	java/io/IOException
    //   232	236	406	java/io/IOException
    //   244	248	426	java/io/IOException
    //   6	23	449	finally
    //   462	466	488	java/io/IOException
    //   471	476	508	java/io/IOException
    //   481	486	528	java/io/IOException
    //   23	34	548	finally
    //   34	44	557	finally
    //   44	59	563	finally
    //   76	106	563	finally
    //   161	166	563	finally
    //   170	178	563	finally
    //   178	180	563	finally
    //   260	265	563	finally
    //   269	277	563	finally
    //   201	218	567	finally
    //   6	23	592	java/lang/Exception
    //   23	34	605	java/lang/Exception
    //   34	44	623	java/lang/Exception
    //   106	117	642	finally
  }
  
  /* Error */
  public static boolean zipFiles(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 313	java/io/FileOutputStream
    //   6: dup
    //   7: new 141	java/io/File
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 401	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   18: astore 5
    //   20: new 1032	java/io/BufferedOutputStream
    //   23: dup
    //   24: aload 5
    //   26: invokespecial 1251	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: astore 6
    //   31: new 1287	java/util/zip/ZipOutputStream
    //   34: dup
    //   35: aload 6
    //   37: invokespecial 1288	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_1
    //   41: aload_0
    //   42: invokeinterface 1314 1 0
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 1319 1 0
    //   54: ifeq +251 -> 305
    //   57: new 141	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: invokeinterface 1322 1 0
    //   67: checkcast 107	java/lang/String
    //   70: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 7
    //   77: ifnull -29 -> 48
    //   80: aload 7
    //   82: invokevirtual 146	java/io/File:exists	()Z
    //   85: ifeq -37 -> 48
    //   88: aload_1
    //   89: new 1146	java/util/zip/ZipEntry
    //   92: dup
    //   93: aload 7
    //   95: invokevirtual 353	java/io/File:getName	()Ljava/lang/String;
    //   98: invokespecial 1289	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 1293	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   104: aload_1
    //   105: bipush 9
    //   107: invokevirtual 1296	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   110: new 157	java/io/FileInputStream
    //   113: dup
    //   114: aload 7
    //   116: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   119: astore 7
    //   121: sipush 20480
    //   124: newarray byte
    //   126: astore 8
    //   128: aload 7
    //   130: aload 8
    //   132: iconst_0
    //   133: sipush 20480
    //   136: invokevirtual 1297	java/io/FileInputStream:read	([BII)I
    //   139: istore_2
    //   140: iload_2
    //   141: iconst_m1
    //   142: if_icmpeq +107 -> 249
    //   145: aload_1
    //   146: aload 8
    //   148: iconst_0
    //   149: iload_2
    //   150: invokevirtual 1298	java/util/zip/ZipOutputStream:write	([BII)V
    //   153: goto -25 -> 128
    //   156: astore_0
    //   157: aload 7
    //   159: ifnull +8 -> 167
    //   162: aload 7
    //   164: invokevirtual 562	java/io/FileInputStream:close	()V
    //   167: aload_1
    //   168: ifnull +11 -> 179
    //   171: aload_1
    //   172: invokevirtual 1299	java/util/zip/ZipOutputStream:flush	()V
    //   175: aload_1
    //   176: invokevirtual 1302	java/util/zip/ZipOutputStream:closeEntry	()V
    //   179: aload_0
    //   180: athrow
    //   181: astore 8
    //   183: aload_1
    //   184: astore_0
    //   185: aload 6
    //   187: astore 7
    //   189: aload 5
    //   191: astore_1
    //   192: aload_0
    //   193: astore 6
    //   195: aload 7
    //   197: astore_0
    //   198: aload 8
    //   200: astore 5
    //   202: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +14 -> 219
    //   208: ldc 63
    //   210: iconst_2
    //   211: ldc_w 1304
    //   214: aload 5
    //   216: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload 6
    //   221: ifnull +8 -> 229
    //   224: aload 6
    //   226: invokevirtual 1305	java/util/zip/ZipOutputStream:close	()V
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   237: aload_1
    //   238: ifnull +395 -> 633
    //   241: aload_1
    //   242: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   245: iconst_0
    //   246: istore_3
    //   247: iload_3
    //   248: ireturn
    //   249: aload 7
    //   251: ifnull +8 -> 259
    //   254: aload 7
    //   256: invokevirtual 562	java/io/FileInputStream:close	()V
    //   259: aload_1
    //   260: ifnull -212 -> 48
    //   263: aload_1
    //   264: invokevirtual 1299	java/util/zip/ZipOutputStream:flush	()V
    //   267: aload_1
    //   268: invokevirtual 1302	java/util/zip/ZipOutputStream:closeEntry	()V
    //   271: goto -223 -> 48
    //   274: astore_0
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 1305	java/util/zip/ZipOutputStream:close	()V
    //   283: aload 6
    //   285: ifnull +8 -> 293
    //   288: aload 6
    //   290: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   293: aload 5
    //   295: ifnull +8 -> 303
    //   298: aload 5
    //   300: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: iconst_1
    //   306: istore 4
    //   308: aload_1
    //   309: ifnull +7 -> 316
    //   312: aload_1
    //   313: invokevirtual 1305	java/util/zip/ZipOutputStream:close	()V
    //   316: aload 6
    //   318: ifnull +8 -> 326
    //   321: aload 6
    //   323: invokevirtual 1144	java/io/BufferedOutputStream:close	()V
    //   326: iload 4
    //   328: istore_3
    //   329: aload 5
    //   331: ifnull -84 -> 247
    //   334: aload 5
    //   336: invokevirtual 419	java/io/FileOutputStream:close	()V
    //   339: iconst_1
    //   340: ireturn
    //   341: astore_0
    //   342: iload 4
    //   344: istore_3
    //   345: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq -101 -> 247
    //   351: ldc 63
    //   353: iconst_2
    //   354: ldc_w 1307
    //   357: aload_0
    //   358: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: iconst_1
    //   362: ireturn
    //   363: astore_0
    //   364: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq -51 -> 316
    //   370: ldc 63
    //   372: iconst_2
    //   373: ldc_w 1307
    //   376: aload_0
    //   377: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   380: goto -64 -> 316
    //   383: astore_0
    //   384: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -61 -> 326
    //   390: ldc 63
    //   392: iconst_2
    //   393: ldc_w 1307
    //   396: aload_0
    //   397: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: goto -74 -> 326
    //   403: astore 5
    //   405: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq -179 -> 229
    //   411: ldc 63
    //   413: iconst_2
    //   414: ldc_w 1307
    //   417: aload 5
    //   419: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: goto -193 -> 229
    //   425: astore_0
    //   426: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq -192 -> 237
    //   432: ldc 63
    //   434: iconst_2
    //   435: ldc_w 1307
    //   438: aload_0
    //   439: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -205 -> 237
    //   445: astore_0
    //   446: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +13 -> 462
    //   452: ldc 63
    //   454: iconst_2
    //   455: ldc_w 1307
    //   458: aload_0
    //   459: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: iconst_0
    //   463: ireturn
    //   464: astore_1
    //   465: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq -185 -> 283
    //   471: ldc 63
    //   473: iconst_2
    //   474: ldc_w 1307
    //   477: aload_1
    //   478: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -198 -> 283
    //   484: astore_1
    //   485: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq -195 -> 293
    //   491: ldc 63
    //   493: iconst_2
    //   494: ldc_w 1307
    //   497: aload_1
    //   498: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   501: goto -208 -> 293
    //   504: astore_1
    //   505: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq -205 -> 303
    //   511: ldc 63
    //   513: iconst_2
    //   514: ldc_w 1307
    //   517: aload_1
    //   518: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: goto -218 -> 303
    //   524: astore_0
    //   525: aconst_null
    //   526: astore_1
    //   527: aconst_null
    //   528: astore 6
    //   530: aconst_null
    //   531: astore 5
    //   533: goto -258 -> 275
    //   536: astore_0
    //   537: aconst_null
    //   538: astore_1
    //   539: aconst_null
    //   540: astore 6
    //   542: goto -267 -> 275
    //   545: astore_0
    //   546: aconst_null
    //   547: astore_1
    //   548: goto -273 -> 275
    //   551: astore 8
    //   553: aload_0
    //   554: astore 5
    //   556: aload_1
    //   557: astore 7
    //   559: aload 6
    //   561: astore_1
    //   562: aload 8
    //   564: astore_0
    //   565: aload 5
    //   567: astore 6
    //   569: aload 7
    //   571: astore 5
    //   573: goto -298 -> 275
    //   576: astore 5
    //   578: aconst_null
    //   579: astore_0
    //   580: aconst_null
    //   581: astore_1
    //   582: aload 7
    //   584: astore 6
    //   586: goto -384 -> 202
    //   589: astore 6
    //   591: aconst_null
    //   592: astore_0
    //   593: aload 5
    //   595: astore_1
    //   596: aload 6
    //   598: astore 5
    //   600: aload 7
    //   602: astore 6
    //   604: goto -402 -> 202
    //   607: astore 8
    //   609: aload 6
    //   611: astore_0
    //   612: aload 5
    //   614: astore_1
    //   615: aload 8
    //   617: astore 5
    //   619: aload 7
    //   621: astore 6
    //   623: goto -421 -> 202
    //   626: astore_0
    //   627: aconst_null
    //   628: astore 7
    //   630: goto -473 -> 157
    //   633: iconst_0
    //   634: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	paramList	List<String>
    //   0	635	1	paramString	String
    //   139	11	2	i	int
    //   246	99	3	bool1	boolean
    //   306	37	4	bool2	boolean
    //   18	317	5	localObject1	Object
    //   403	15	5	localIOException	IOException
    //   531	41	5	localObject2	Object
    //   576	18	5	localException1	Exception
    //   598	20	5	localObject3	Object
    //   29	556	6	localObject4	Object
    //   589	8	6	localException2	Exception
    //   602	20	6	localObject5	Object
    //   1	628	7	localObject6	Object
    //   126	21	8	arrayOfByte	byte[]
    //   181	18	8	localException3	Exception
    //   551	12	8	localObject7	Object
    //   607	9	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   121	128	156	finally
    //   128	140	156	finally
    //   145	153	156	finally
    //   41	48	181	java/lang/Exception
    //   48	75	181	java/lang/Exception
    //   80	110	181	java/lang/Exception
    //   162	167	181	java/lang/Exception
    //   171	179	181	java/lang/Exception
    //   179	181	181	java/lang/Exception
    //   254	259	181	java/lang/Exception
    //   263	271	181	java/lang/Exception
    //   41	48	274	finally
    //   48	75	274	finally
    //   80	110	274	finally
    //   162	167	274	finally
    //   171	179	274	finally
    //   179	181	274	finally
    //   254	259	274	finally
    //   263	271	274	finally
    //   334	339	341	java/io/IOException
    //   312	316	363	java/io/IOException
    //   321	326	383	java/io/IOException
    //   224	229	403	java/io/IOException
    //   233	237	425	java/io/IOException
    //   241	245	445	java/io/IOException
    //   279	283	464	java/io/IOException
    //   288	293	484	java/io/IOException
    //   298	303	504	java/io/IOException
    //   3	20	524	finally
    //   20	31	536	finally
    //   31	41	545	finally
    //   202	219	551	finally
    //   3	20	576	java/lang/Exception
    //   20	31	589	java/lang/Exception
    //   31	41	607	java/lang/Exception
    //   110	121	626	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */