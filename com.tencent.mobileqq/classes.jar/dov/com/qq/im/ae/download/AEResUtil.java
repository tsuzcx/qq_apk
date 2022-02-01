package dov.com.qq.im.ae.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.PendantVersionManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCClient;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.AEPath.CAMERA.INTERNAL_FILES;
import dov.com.qq.im.ae.AEPathBase.TMP;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import eipc.EIPCClient;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEResUtil
{
  public static final String a;
  public static final Map<String, AEResInfo> a;
  private static final Map<AEResInfo, String> b;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = b();
    b = c();
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131708711);
  }
  
  public static int a(int paramInt)
  {
    return AECameraPrefsUtil.a().a("key_ae_light_res_" + paramInt, 0, 4);
  }
  
  public static int a(VideoMaterial paramVideoMaterial)
  {
    int j = 0;
    int i = j;
    if (paramVideoMaterial.needHandDetect())
    {
      i = j;
      if (!b(AEResInfo.d)) {
        i = 1;
      }
    }
    j = i;
    if (paramVideoMaterial.needDetectGender())
    {
      j = i;
      if (!b(AEResInfo.e)) {
        j = i | 0x2;
      }
    }
    i = j;
    if (paramVideoMaterial.needDetectCat())
    {
      i = j;
      if (!b(AEResInfo.f)) {
        i = j | 0x4;
      }
    }
    j = i;
    if (paramVideoMaterial.needRGBDepth())
    {
      j = i;
      if (!b(AEResInfo.g)) {
        j = i | 0x8;
      }
    }
    i = j;
    if (paramVideoMaterial.needHairSegment())
    {
      i = j;
      if (!b(AEResInfo.h)) {
        i = j | 0x20;
      }
    }
    j = i;
    if (paramVideoMaterial.needSkySegment())
    {
      j = i;
      if (!b(AEResInfo.i)) {
        j = i | 0x10;
      }
    }
    i = j;
    if (paramVideoMaterial.needAce3D())
    {
      i = j;
      if (!b(AEResInfo.j)) {
        i = j | 0x40;
      }
    }
    j = i;
    if (paramVideoMaterial.need3DMM())
    {
      j = i;
      if (!b(AEResInfo.k)) {
        j = i | 0x80;
      }
    }
    i = j;
    if (paramVideoMaterial.needHeadSegment())
    {
      i = j;
      if (!b(AEResInfo.l)) {
        i = j | 0x100;
      }
    }
    return i;
  }
  
  public static int a(AEResInfo paramAEResInfo)
  {
    int i;
    if (PtvFilterSoLoad.a()) {
      if (b(paramAEResInfo)) {
        i = 1;
      }
    }
    for (;;)
    {
      AEQLog.a("AEResUtil", "getFilterSoState " + i);
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    AEQLog.a("AEResUtil", paramString1 + "|verifyResource() lResMd5=" + paramString2 + ", filepath=" + paramString3);
    if (TextUtils.isEmpty(paramString3))
    {
      AEQLog.d("AEResUtil", "[verifyResource] filePath :null");
      return -105;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      AEQLog.d("AEResUtil", "[verifyResource] lResMd5 :null");
      return -106;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      AEQLog.d("AEResUtil", paramString1 + "|verifyResource() file[" + paramString3 + "] not exist..");
      return -107;
    }
    Object localObject = null;
    try
    {
      paramString3 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString3));
      AEQLog.a("AEResUtil", paramString1 + "|verifyResource()  lResMd5=" + paramString2 + ",md5=" + paramString3);
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
      AEQLog.d("AEResUtil", "[verifyResource] equalsIgnoreCase :false");
    }
    return -108;
  }
  
  public static int a(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = -103;
    while (localIterator.hasNext())
    {
      ShortVideoResourceManager.SVConfigItem localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)localIterator.next();
      if ((localSVConfigItem != null) && (!TextUtils.isEmpty(localSVConfigItem.name)))
      {
        AEResInfo[] arrayOfAEResInfo = AEResInfo.jdField_b_of_type_ArrayOfDovComQqImAeDownloadAEResInfo;
        int k = arrayOfAEResInfo.length;
        int j = 0;
        if (j < k)
        {
          paramList = arrayOfAEResInfo[j];
          if ((paramList == null) || (TextUtils.isEmpty(paramList.jdField_b_of_type_JavaLangString))) {}
          while (!localSVConfigItem.name.startsWith(paramList.jdField_b_of_type_JavaLangString))
          {
            j += 1;
            break;
          }
        }
        for (;;)
        {
          if (paramList != null) {
            if (localSVConfigItem.versionCode != paramList.jdField_c_of_type_Int) {
              break label202;
            }
          }
          label197:
          label202:
          for (;;)
          {
            try
            {
              j = Integer.parseInt(localSVConfigItem.name.substring(paramList.jdField_b_of_type_JavaLangString.length()));
              if (j < paramList.jdField_b_of_type_Int) {
                break label202;
              }
              i = 0;
              j = i;
              if (i == 0) {
                break label197;
              }
              return i;
            }
            catch (Throwable localThrowable)
            {
              AEQLog.d("AEResUtil", "[checkConfigUsable] String2int error :" + localSVConfigItem.name);
              j = 0;
              continue;
            }
            j = i;
            i = j;
            break;
          }
          paramList = null;
        }
      }
    }
    return i;
  }
  
  public static String a()
  {
    return AEPath.CAMERA.INTERNAL_FILES.jdField_a_of_type_JavaLangString;
  }
  
  @NonNull
  public static String a(@NonNull AEResInfo paramAEResInfo)
  {
    if (!paramAEResInfo.jdField_a_of_type_Boolean) {
      return "";
    }
    return b();
  }
  
  public static String a(String paramString)
  {
    return ShortVideoResourceManager.a(paramString);
  }
  
  public static Map<AEResInfo, String> a()
  {
    return b;
  }
  
  public static void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_RES_PREFIX", AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString);
    QIPCClientHelper.getInstance().getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", localBundle);
    localBundle = new Bundle();
    localBundle.putString("KEY_RES_PREFIX", AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString);
    QIPCClientHelper.getInstance().getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", localBundle);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AECameraPrefsUtil.a().a("key_ae_light_res_" + paramInt1, paramInt2, 4);
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (a(paramLong, 1))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载HAND");
      b(paramContext, AEResInfo.d.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 2))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载GENDER");
      b(paramContext, AEResInfo.e.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 4))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载CAT");
      b(paramContext, AEResInfo.f.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 8))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载DEPT");
      b(paramContext, AEResInfo.g.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 32))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载HAIR");
      b(paramContext, AEResInfo.h.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 16))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载SKY");
      b(paramContext, AEResInfo.i.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 64))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载3D");
      b(paramContext, AEResInfo.j.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 128))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载3DMM");
      b(paramContext, AEResInfo.k.jdField_b_of_type_JavaLangString);
    }
    if (a(paramLong, 256))
    {
      AEQLog.a("PreCheckAERes", "[fetchBundles] 需要下载HEAD");
      b(paramContext, AEResInfo.l.jdField_b_of_type_JavaLangString);
    }
  }
  
  public static void a(AEResInfo paramAEResInfo, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEResInfo.jdField_b_of_type_JavaLangString);
    AEQLog.a("AEResUtil", "下载完成 发送广播" + paramAEResInfo.jdField_b_of_type_JavaLangString);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("ae_camera_res_downloadfinish_path", paramString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static boolean a()
  {
    return FeatureManager.isBasicFeaturesFunctionReady();
  }
  
  private static boolean a(long paramLong, int paramInt)
  {
    AEQLog.a("AEResUtil", "status:" + paramLong + " bundle:" + paramInt);
    return (paramInt & paramLong) == paramInt;
  }
  
  public static boolean a(@NonNull AEResInfo paramAEResInfo)
  {
    int i = a(paramAEResInfo.jdField_a_of_type_Int);
    AEQLog.d("PreCheckAERes", "[checkAEResVersionOK] packageVersion:" + i);
    AEQLog.d("PreCheckAERes", "[checkAEResVersionOK] aeResInfo.resVersionLimit:" + paramAEResInfo.jdField_b_of_type_Int);
    return i >= paramAEResInfo.jdField_b_of_type_Int;
  }
  
  public static boolean a(@NonNull String paramString)
  {
    paramString = AEPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString + paramString + File.separator;
    AECameraPrefsUtil.a().a("aeres_copy_final_path_key", paramString, 4);
    if (AECameraPrefsUtil.a().a("aeres_copy_final_path_key", AEPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString, 4).equals(paramString))
    {
      AEQLog.a("AEResUtil", "[saveAEResUnzipFinalPath] success");
      return true;
    }
    AEQLog.d("AEResUtil", "[saveAEResUnzipFinalPath] error");
    return false;
  }
  
  public static boolean a(@NonNull String paramString, @NonNull AEResInfo paramAEResInfo)
  {
    AECameraPrefsUtil.a().a(paramAEResInfo.jdField_b_of_type_JavaLangString + paramAEResInfo.jdField_c_of_type_Int + "aeres_unzip_path_key", paramString, 4);
    if (paramString.equals(AECameraPrefsUtil.a().a(paramAEResInfo.jdField_b_of_type_JavaLangString + paramAEResInfo.jdField_c_of_type_Int + "aeres_unzip_path_key", "", 4)))
    {
      AEQLog.a("AEResUtil", "[saveAEResUnzipPath] success");
      return true;
    }
    AEQLog.d("AEResUtil", "[saveAEResUnzipPath] error");
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
      i = FileUtils.a(paramString2, AEPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString + paramString1 + File.separator, false, true, true);
      AEQLog.d("AEResUtil", "copyResFileToFinalDir errorcode:" + i + ", fromPath:" + paramString2);
    } while (i == 0);
    return false;
  }
  
  public static String b()
  {
    return h();
  }
  
  public static String b(@NonNull AEResInfo paramAEResInfo)
  {
    String str = d(paramAEResInfo);
    if (TextUtils.isEmpty(str))
    {
      AEQLog.d("AEResUtil", "[getAEResPath] pathVersion null");
      return null;
    }
    if (!PendantVersionManager.a(str, paramAEResInfo.jdField_b_of_type_Int))
    {
      AEQLog.d("AEResUtil", "[getAEResPath] pathVersion is not > limitVersion");
      return null;
    }
    return a() + str + File.separator;
  }
  
  private static Map<String, AEResInfo> b()
  {
    HashMap localHashMap = new HashMap();
    AEResInfo[] arrayOfAEResInfo = AEResInfo.jdField_b_of_type_ArrayOfDovComQqImAeDownloadAEResInfo;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo = arrayOfAEResInfo[i];
      localHashMap.put(localAEResInfo.jdField_b_of_type_JavaLangString, localAEResInfo);
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private static void b(Context paramContext, String paramString)
  {
    if (!NetworkUtil.h(paramContext))
    {
      ThreadManager.getUIHandler().post(new AEResUtil.1(paramContext, paramString));
      return;
    }
    AEQLog.d("PreCheckAERes", "【tryDownloadLightAdditionBundle】wifi网络 : request download --> prefix:" + paramString);
    b(paramString);
  }
  
  private static void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_RES_PREFIX", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("AECameraGetInfoServer", "ACTION_DOWNLOAD_AE_RES", localBundle);
  }
  
  public static boolean b()
  {
    return (b(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo)) && (b(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo));
  }
  
  public static boolean b(AEResInfo paramAEResInfo)
  {
    int i = a(paramAEResInfo.jdField_a_of_type_Int);
    if (i < paramAEResInfo.jdField_b_of_type_Int) {
      AEQLog.d("AEResUtil", "[isAEResExist] savedVersion=" + i + "aeResInfo=" + paramAEResInfo);
    }
    do
    {
      do
      {
        return false;
        localObject = b();
        if (localObject == null)
        {
          AEQLog.d("AEResUtil", "[isAEResExist] soRootPath=null, aeResInfo=" + paramAEResInfo);
          return false;
        }
        if (!new File((String)localObject).exists())
        {
          AEQLog.d("AEResUtil", "[isAEResExist] exists=false, aeResInfo=" + paramAEResInfo);
          return false;
        }
        if (paramAEResInfo != AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo) {
          break;
        }
      } while ((!FeatureManager.Features.YT_COMMON.isSoReadyInDirectory((String)localObject)) || (!FeatureManager.Features.PTU_ALGO.isSoReadyInDirectory((String)localObject)) || (!FeatureManager.Features.PTU_TOOLS.isSoReadyInDirectory((String)localObject)));
      return true;
      if (paramAEResInfo == AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo) {
        return FeatureManager.Features.LIGHT_SDK.isSoReadyInDirectory((String)localObject);
      }
    } while ((paramAEResInfo != AEResInfo.d) && (paramAEResInfo != AEResInfo.e) && (paramAEResInfo != AEResInfo.f) && (paramAEResInfo != AEResInfo.g) && (paramAEResInfo != AEResInfo.h) && (paramAEResInfo != AEResInfo.i) && (paramAEResInfo != AEResInfo.j) && (paramAEResInfo != AEResInfo.k) && (paramAEResInfo != AEResInfo.l));
    Object localObject = new File((String)localObject + (String)b.get(paramAEResInfo));
    AEQLog.a("AEResUtil", "[isAEResExist] exists=" + ((File)localObject).exists() + ", aeResInfo=" + paramAEResInfo);
    return ((File)localObject).exists();
  }
  
  public static String c()
  {
    return AEPathBase.TMP.jdField_a_of_type_JavaLangString + File.separator;
  }
  
  public static String c(@NonNull AEResInfo paramAEResInfo)
  {
    if (!b(paramAEResInfo))
    {
      AEQLog.d("AEResUtil", "getLightBundleDir:" + paramAEResInfo.jdField_b_of_type_JavaLangString + "资源不存在，返回空path");
      return "";
    }
    return b() + (String)b.get(paramAEResInfo);
  }
  
  private static Map<AEResInfo, String> c()
  {
    HashMap localHashMap = new HashMap();
    String str1 = "assets" + File.separator;
    String str2 = str1 + "models" + File.separator;
    localHashMap.put(AEResInfo.d, str2 + "hand_model" + File.separator);
    localHashMap.put(AEResInfo.e, str2 + "gender_model" + File.separator);
    localHashMap.put(AEResInfo.f, str2 + "cat_model" + File.separator);
    localHashMap.put(AEResInfo.g, str2 + "depth_model" + File.separator);
    localHashMap.put(AEResInfo.h, str2 + "segment_hair_model" + File.separator);
    localHashMap.put(AEResInfo.i, str2 + "segment_sky_model" + File.separator);
    localHashMap.put(AEResInfo.j, str1 + "ace3d");
    localHashMap.put(AEResInfo.k, str2 + "3dmm_model" + File.separator);
    localHashMap.put(AEResInfo.l, str2 + "segment_head_model" + File.separator);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private static void c(@NonNull Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("VALUE_MSG_LIGHT_BUNDLE_PREFIX", paramString);
    localBundle = VideoPlayIPCClient.a().a("CMD_QUERY_STATUS_PTU_RES", localBundle);
    int i = 0;
    if (localBundle != null)
    {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
      AEQLog.a("PreCheckAERes", "【showLightBundleDownloadDialog】query bundle file status: " + i);
    }
    if ((i == 0) || (!a(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo)))
    {
      DialogUtil.a(paramContext, 230).setMessage(jdField_a_of_type_JavaLangString).setPositiveButton(paramContext.getString(2131693935), new AEResUtil.3(paramString)).setNegativeButton(paramContext.getString(2131693931), new AEResUtil.2(paramString)).show();
      return;
    }
    AEQLog.a("PreCheckAERes", "[showLightBundleDownloadDialog] is already downloading, prefix = " + paramString);
    QQToast.a(paramContext, 2131689675, 1).a();
  }
  
  public static boolean c()
  {
    return (a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo) != 1) || (a(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo) != 1);
  }
  
  public static String d()
  {
    if (!b(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo))
    {
      AEQLog.d("AEResUtil", "[getLightAssetsDir]: LightBasePackage not exist, return empty path!");
      return "";
    }
    return b() + "assets" + File.separator;
  }
  
  private static String d(@NonNull AEResInfo paramAEResInfo)
  {
    return AECameraPrefsUtil.a().a(paramAEResInfo.jdField_b_of_type_JavaLangString + paramAEResInfo.jdField_c_of_type_Int + "aeres_unzip_path_key", "", 4);
  }
  
  public static boolean d()
  {
    return FeatureManager.Features.FACE_DETECT.isAllSoVersionOk();
  }
  
  public static String e()
  {
    if (!b(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo)) {
      return "";
    }
    return b() + "assets" + File.separator + "material" + File.separator + "video_empty" + File.separator + "template.json";
  }
  
  public static boolean e()
  {
    try
    {
      if ((!a()) && (AEKitForQQ.a()))
      {
        bool = FeatureManager.loadBasicFeatures();
        AEQLog.d("AEResUtil", "SoLoader.loadSvFilterSo success:" + bool);
      }
      boolean bool = a();
      return bool;
    }
    finally {}
  }
  
  public static String f()
  {
    if (!b(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo)) {
      return "";
    }
    return b() + "assets" + File.separator + "material" + File.separator + "video_empty_segmentation";
  }
  
  public static String g()
  {
    if (!b(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo)) {
      return "";
    }
    return b() + "assets" + File.separator + "models" + File.separator;
  }
  
  private static String h()
  {
    return AECameraPrefsUtil.a().a("aeres_copy_final_path_key", AEPath.CAMERA.INTERNAL_FILES.jdField_b_of_type_JavaLangString, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResUtil
 * JD-Core Version:    0.7.0.1
 */