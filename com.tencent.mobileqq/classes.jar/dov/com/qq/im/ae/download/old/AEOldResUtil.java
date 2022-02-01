package dov.com.qq.im.ae.download.old;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class AEOldResUtil
{
  public static final String a = HardCodeUtil.a(2131708711);
  
  public static int a(int paramInt)
  {
    return AECameraPrefsUtil.a().a("key_ae_res_" + paramInt, 0, 4);
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    AEQLog.a("AEOldResUtil", paramString1 + "|verifyResource() lResMd5=" + paramString2 + ", filepath=" + paramString3);
    if (TextUtils.isEmpty(paramString3))
    {
      AEQLog.d("AEOldResUtil", "[verifyResource] filePath :null");
      return -105;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      AEQLog.d("AEOldResUtil", "[verifyResource] lResMd5 :null");
      return -106;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      AEQLog.d("AEOldResUtil", paramString1 + "|verifyResource() file[" + paramString3 + "] not exist..");
      return -107;
    }
    Object localObject = null;
    try
    {
      paramString3 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString3));
      AEQLog.a("AEOldResUtil", paramString1 + "|verifyResource()  lResMd5=" + paramString2 + ",md5=" + paramString3);
      if (paramString2.equalsIgnoreCase(paramString3)) {
        return 0;
      }
    }
    catch (UnsatisfiedLinkError paramString3)
    {
      for (;;)
      {
        try
        {
          paramString3 = MD5FileUtil.a(localFile);
        }
        catch (Exception paramString3)
        {
          paramString3.printStackTrace();
          paramString3 = localObject;
        }
      }
      AEQLog.d("AEOldResUtil", "[verifyResource] equalsIgnoreCase :false");
    }
    return -108;
  }
  
  public static int a(List<AEOldShortVideoResManager.SVConfigItem> paramList)
  {
    paramList = paramList.iterator();
    AEOldShortVideoResManager.SVConfigItem localSVConfigItem;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localSVConfigItem = (AEOldShortVideoResManager.SVConfigItem)paramList.next();
    } while ((!localSVConfigItem.name.startsWith(AEOldResInfo.jdField_b_of_type_DovComQqImAeDownloadOldAEOldResInfo.jdField_b_of_type_JavaLangString)) || (localSVConfigItem.versionCode != AEOldResInfo.jdField_b_of_type_DovComQqImAeDownloadOldAEOldResInfo.c));
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localSVConfigItem.name.substring(AEOldResInfo.jdField_b_of_type_DovComQqImAeDownloadOldAEOldResInfo.jdField_b_of_type_JavaLangString.length())).intValue();
        if (i < AEOldResInfo.jdField_b_of_type_DovComQqImAeDownloadOldAEOldResInfo.jdField_b_of_type_Int) {
          break;
        }
        i = 0;
        if (i != 0)
        {
          AEQLog.d("AEOldResUtil", "[checkConfigUsable] status:" + i);
          return i;
        }
      }
      catch (Exception localException)
      {
        AEQLog.d("AEOldResUtil", "[checkConfigUsable] String2int error :" + localSVConfigItem.name);
        i = 0;
        continue;
      }
      return -103;
      int i = -103;
    }
  }
  
  public static String a()
  {
    return AEOldPath.CAMERA.INTERNAL_FILES.a;
  }
  
  @NonNull
  public static String a(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    if (!paramAEOldResInfo.a) {
      return "";
    }
    if (AEOldResInfo.jdField_b_of_type_DovComQqImAeDownloadOldAEOldResInfo.jdField_b_of_type_JavaLangString.equals(paramAEOldResInfo.jdField_b_of_type_JavaLangString)) {
      return b();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    return AEOldShortVideoResManager.a(paramString);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AECameraPrefsUtil.a().a("key_ae_res_" + paramInt1, paramInt2, 4);
  }
  
  public static void a(AEOldResInfo paramAEOldResInfo, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEOldResInfo.jdField_b_of_type_JavaLangString);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("ae_camera_res_downloadfinish_path", paramString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static boolean a(@NonNull String paramString)
  {
    paramString = AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString + paramString + File.separator;
    AECameraPrefsUtil.a().a("aeres_copy_old_final_path_key", paramString, 4);
    if (AECameraPrefsUtil.a().a("aeres_copy_old_final_path_key", AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString, 4).equals(paramString))
    {
      AEQLog.a("AEOldResUtil", "[saveAEResUnzipFinalPath] success");
      return true;
    }
    AEQLog.d("AEOldResUtil", "[saveAEResUnzipFinalPath] error");
    return false;
  }
  
  public static boolean a(@NonNull String paramString, @NonNull AEOldResInfo paramAEOldResInfo)
  {
    AECameraPrefsUtil.a().a(paramAEOldResInfo.jdField_b_of_type_JavaLangString + paramAEOldResInfo.c + "aeres_unzip_old_path_key", paramString, 4);
    if (paramString.equals(AECameraPrefsUtil.a().a(paramAEOldResInfo.jdField_b_of_type_JavaLangString + paramAEOldResInfo.c + "aeres_unzip_old_path_key", "", 4)))
    {
      AEQLog.a("AEOldResUtil", "[saveAEResUnzipPath] success");
      return true;
    }
    AEQLog.d("AEOldResUtil", "[saveAEResUnzipPath] error");
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    File localFile = new File(paramString2);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = FileUtils.a(paramString2, AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString + paramString1 + File.separator, false, true, true);
      AEQLog.d("AEOldResUtil", "copyResFileToFinalDir errorcode:" + i + ", fromPath:" + paramString2);
    } while (i == 0);
    return false;
  }
  
  public static String b()
  {
    return d();
  }
  
  @NonNull
  public static String b(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    if (!paramAEOldResInfo.a) {
      return "";
    }
    return b();
  }
  
  public static String c()
  {
    return AEOldPathBase.TMP.a + File.separator;
  }
  
  public static String c(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    String str = d(paramAEOldResInfo);
    if (TextUtils.isEmpty(str))
    {
      AEQLog.d("AEOldResUtil", "[getAEResPath] pathVersion null");
      return null;
    }
    if (!AEOldPendantVersionManager.a(str, paramAEOldResInfo.jdField_b_of_type_Int))
    {
      AEQLog.d("AEOldResUtil", "[getAEResPath] pathVersion is not > limitVersion");
      return null;
    }
    return a() + str + File.separator;
  }
  
  private static String d()
  {
    return AECameraPrefsUtil.a().a("aeres_copy_old_final_path_key", AEOldPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString, 4);
  }
  
  private static String d(@NonNull AEOldResInfo paramAEOldResInfo)
  {
    return AECameraPrefsUtil.a().a(paramAEOldResInfo.jdField_b_of_type_JavaLangString + paramAEOldResInfo.c + "aeres_unzip_old_path_key", "", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldResUtil
 * JD-Core Version:    0.7.0.1
 */