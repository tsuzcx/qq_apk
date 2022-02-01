package com.tencent.mobileqq.qrscan.minicode;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minicode.Utils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class MiniCodeUtil
{
  private static Boolean a;
  public static String a = "sp_file_minirecog";
  public static boolean a = false;
  public static String b = "sp_key_detect_init_error_";
  public static volatile boolean b = false;
  private static boolean c = false;
  
  static
  {
    if (jdField_a_of_type_Boolean)
    {
      String str1 = d();
      String str2 = e();
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(str2);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      a("libQMCF_qr.so", "so_debug/", str1);
      a("libyuvutil.so", "so_debug/", str1);
      a("libminicode.so", "so_debug/", str1);
      a("qr_detection_model.bin", "model_debug/", str2);
      a("qr_detection_model.txt", "model_debug/", str2);
      a("qr_anchor.bin", "model_debug/", str2);
    }
  }
  
  public static int a()
  {
    if (a(false) >= 3) {
      return -1;
    }
    int k = ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).getQmcfGpuSupportType();
    int j = ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).getQmcfGpuSupportTypeWithoutGPURule();
    boolean bool = c;
    int i = 1;
    if (!bool)
    {
      MiniScanReport.c(k, j);
      c = true;
    }
    bool = ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).isQmcfSupport(j);
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog", 2, String.format("getSupportDetectType supportType[loose,strict]=[%d,%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
    }
    if (bool)
    {
      if (((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).isQmcfSupportGLElseCL(j)) {
        i = 2;
      }
      return i;
    }
    return 0;
  }
  
  public static int a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    if (paramBoolean) {
      str = "qq.android.minidecode.so_v8.2.0";
    } else {
      str = "qq.android.minidetect.so_v8.6.0";
    }
    localStringBuilder.append(str);
    String str = localStringBuilder.toString();
    int i = MobileQQ.sMobileQQ.getSharedPreferences(jdField_a_of_type_JavaLangString, 4).getInt(str, 0);
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog", 2, String.format("getMiniScanErrorCnt errorCnt=%d bDecodeElseDetect=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) }));
    }
    return i;
  }
  
  public static String a()
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication.getFilesDir() == null)
    {
      QLog.i("MiniRecog", 2, "getAppDir is null.");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localBaseApplication.getFilesDir());
    localStringBuilder.append("/minirecog/");
    return localStringBuilder.toString();
  }
  
  public static void a(Bitmap paramBitmap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".png");
    Utils.saveBitmapToFile(paramBitmap, localStringBuilder.toString(), Bitmap.CompressFormat.PNG, 100, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH_MINICODERECOG);
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString1);
    paramString2 = ((StringBuilder)localObject).toString();
    localObject = new File(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    boolean bool;
    if (((File)localObject).exists()) {
      bool = a(paramString1, paramString2);
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog", 2, String.format("copy %s %b", new Object[] { paramString1, Boolean.valueOf(bool) }));
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      boolean bool2 = DeviceInfoUtil.e();
      boolean bool1;
      if (bool2) {
        try
        {
          Class localClass = Class.forName("android.os.SystemProperties");
          if (((Integer)localClass.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { new String("ro.kernel.qemu"), new Integer(0) })).intValue() == 1) {
            if (!"tencent".equals(Build.MANUFACTURER))
            {
              bool1 = "unknown".equals(Build.MANUFACTURER);
              if (!bool1) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("MiniRecog", 2, "RecogUtil.isX86()", localThrowable);
        }
      } else {
        bool1 = false;
      }
      QLog.i("MiniRecog", 1, String.format("RecogUtil isX86 [%b,%b,%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Build.MANUFACTURER }));
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: new 28	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore 5
    //   18: new 28	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload 5
    //   29: invokevirtual 36	java/io/File:exists	()Z
    //   32: ifeq +9 -> 41
    //   35: aload 5
    //   37: invokevirtual 276	java/io/File:delete	()Z
    //   40: pop
    //   41: new 278	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 281	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: astore_0
    //   50: aload 4
    //   52: astore_1
    //   53: aload_0
    //   54: astore_3
    //   55: new 283	java/io/FileOutputStream
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 284	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore 4
    //   66: sipush 2048
    //   69: newarray byte
    //   71: astore_1
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 288	java/io/FileInputStream:read	([B)I
    //   77: istore_2
    //   78: iload_2
    //   79: iconst_m1
    //   80: if_icmpeq +14 -> 94
    //   83: aload 4
    //   85: aload_1
    //   86: iconst_0
    //   87: iload_2
    //   88: invokevirtual 292	java/io/FileOutputStream:write	([BII)V
    //   91: goto -19 -> 72
    //   94: aload 4
    //   96: invokevirtual 295	java/io/FileOutputStream:flush	()V
    //   99: aload 4
    //   101: invokevirtual 298	java/io/FileOutputStream:close	()V
    //   104: goto +8 -> 112
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   112: aload_0
    //   113: invokevirtual 302	java/io/FileInputStream:close	()V
    //   116: iconst_1
    //   117: ireturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   123: iconst_1
    //   124: ireturn
    //   125: astore_3
    //   126: aload 4
    //   128: astore_1
    //   129: goto +89 -> 218
    //   132: astore 5
    //   134: goto +32 -> 166
    //   137: astore 5
    //   139: aload 6
    //   141: astore 4
    //   143: goto +23 -> 166
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_0
    //   150: aload_3
    //   151: astore_1
    //   152: aload 4
    //   154: astore_3
    //   155: goto +63 -> 218
    //   158: astore 5
    //   160: aconst_null
    //   161: astore_0
    //   162: aload 6
    //   164: astore 4
    //   166: aload 4
    //   168: astore_1
    //   169: aload_0
    //   170: astore_3
    //   171: aload 5
    //   173: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   176: aload 4
    //   178: ifnull +16 -> 194
    //   181: aload 4
    //   183: invokevirtual 298	java/io/FileOutputStream:close	()V
    //   186: goto +8 -> 194
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   194: aload_0
    //   195: ifnull +14 -> 209
    //   198: aload_0
    //   199: invokevirtual 302	java/io/FileInputStream:close	()V
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: astore 4
    //   213: aload_3
    //   214: astore_0
    //   215: aload 4
    //   217: astore_3
    //   218: aload_1
    //   219: ifnull +15 -> 234
    //   222: aload_1
    //   223: invokevirtual 298	java/io/FileOutputStream:close	()V
    //   226: goto +8 -> 234
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   234: aload_0
    //   235: ifnull +15 -> 250
    //   238: aload_0
    //   239: invokevirtual 302	java/io/FileInputStream:close	()V
    //   242: goto +8 -> 250
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   250: goto +5 -> 255
    //   253: aload_3
    //   254: athrow
    //   255: goto -2 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramString1	String
    //   0	258	1	paramString2	String
    //   77	11	2	i	int
    //   4	51	3	str	String
    //   125	26	3	localObject1	Object
    //   154	100	3	localObject2	Object
    //   1	141	4	localObject3	Object
    //   146	7	4	localObject4	Object
    //   164	18	4	localObject5	Object
    //   211	5	4	localObject6	Object
    //   16	44	5	localFile	File
    //   132	1	5	localException1	java.lang.Exception
    //   137	1	5	localException2	java.lang.Exception
    //   158	14	5	localException3	java.lang.Exception
    //   6	157	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   99	104	107	java/lang/Exception
    //   112	116	118	java/lang/Exception
    //   66	72	125	finally
    //   72	78	125	finally
    //   83	91	125	finally
    //   94	99	125	finally
    //   66	72	132	java/lang/Exception
    //   72	78	132	java/lang/Exception
    //   83	91	132	java/lang/Exception
    //   94	99	132	java/lang/Exception
    //   55	66	137	java/lang/Exception
    //   8	41	146	finally
    //   41	50	146	finally
    //   8	41	158	java/lang/Exception
    //   41	50	158	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   198	202	204	java/lang/Exception
    //   55	66	211	finally
    //   171	176	211	finally
    //   222	226	229	java/lang/Exception
    //   238	242	245	java/lang/Exception
  }
  
  public static final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("kernal_path/");
    return localStringBuilder.toString();
  }
  
  public static void b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
    if (paramBoolean) {
      str = "qq.android.minidecode.so_v8.2.0";
    } else {
      str = "qq.android.minidetect.so_v8.6.0";
    }
    ((StringBuilder)localObject).append(str);
    String str = ((StringBuilder)localObject).toString();
    localObject = MobileQQ.sMobileQQ.getSharedPreferences(jdField_a_of_type_JavaLangString, 4);
    int i = ((SharedPreferences)localObject).getInt(str, 0);
    localObject = ((SharedPreferences)localObject).edit();
    int j = i + 1;
    ((SharedPreferences.Editor)localObject).putInt(str, j).apply();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog", 2, String.format("markMiniScanError bDecodeElseDetect=%b old_errorCnt=%d new_errorCnt=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j) }));
    }
  }
  
  public static final String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH_MINICODERECOG);
    localStringBuilder.append("tmp/");
    return localStringBuilder.toString();
  }
  
  public static void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    if (paramBoolean) {
      str = "qq.android.minidecode.so_v8.2.0";
    } else {
      str = "qq.android.minidetect.so_v8.6.0";
    }
    localStringBuilder.append(str);
    String str = localStringBuilder.toString();
    MobileQQ.sMobileQQ.getSharedPreferences(jdField_a_of_type_JavaLangString, 4).edit().remove(str).apply();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog", 2, String.format("clearMiniScanError bDecodeElseDetect=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
  
  public static final String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("so_debug/");
    return localStringBuilder.toString();
  }
  
  public static final String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("model_debug/");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeUtil
 * JD-Core Version:    0.7.0.1
 */