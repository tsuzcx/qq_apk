package dov.com.qq.im.ae.download;

import amtj;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bbpt;
import bbwm;
import bbxj;
import bfur;
import bjkf;
import bljd;
import bljn;
import bljw;
import blvk;
import bmbk;
import bmbx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;
import npo;

public class AEResUtil
{
  private static final String AERES_COPY_FINAL_PATH_KEY = "aeres_copy_final_path_key";
  public static final int AERES_EXIST = 1;
  public static final int AERES_MACHINE_NOT_SUPPORT = 0;
  public static final int AERES_NOT_EXIST = 2;
  private static final String AERES_UNZIP_PATH_KEY = "aeres_unzip_path_key";
  public static final String PENDANT_CONFIG_FILE = "pendant_config_file";
  private static final String PTU_CONFIG_FILE = "ptu_config_file";
  public static final String PTU_RES_DOWNLOAD_TIPS = amtj.a(2131707837);
  private static final String TAG = "AEResUtil";
  
  public static boolean checkAEResVersionOK(@NonNull AEResInfo paramAEResInfo)
  {
    int i = getDownloadPackageVersion(paramAEResInfo.index);
    bmbx.d("AEResUtil", "[checkAEResVersionOK] packageVersion:" + i);
    bmbx.d("AEResUtil", "[checkAEResVersionOK] aeResInfo.resVersionLimit:" + paramAEResInfo.resVersionLimit);
    return i >= paramAEResInfo.resVersionLimit;
  }
  
  public static int checkConfigUsable(List<ShortVideoResourceManager.SVConfigItem> paramList)
  {
    Object localObject = paramList.iterator();
    ShortVideoResourceManager.SVConfigItem localSVConfigItem;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSVConfigItem = (ShortVideoResourceManager.SVConfigItem)((Iterator)localObject).next();
    } while ((!localSVConfigItem.name.startsWith(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix)) || (localSVConfigItem.versionCode != AEResInfo.AE_RES_BASE_PACKAGE.resVersion));
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localSVConfigItem.name.substring(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix.length())).intValue();
        if (i < AEResInfo.AE_RES_BASE_PACKAGE.resVersionLimit) {
          break;
        }
        i = 0;
        if (i != 0)
        {
          bmbx.d("AEResUtil", "[checkConfigUsable] status:" + i);
          return i;
        }
      }
      catch (Exception localException2)
      {
        bmbx.d("AEResUtil", "[checkConfigUsable] String2int error :" + localSVConfigItem.name);
        i = 0;
        continue;
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject = (ShortVideoResourceManager.SVConfigItem)paramList.next();
          if ((!((ShortVideoResourceManager.SVConfigItem)localObject).name.startsWith(AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resPrefix)) || (((ShortVideoResourceManager.SVConfigItem)localObject).versionCode != AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resVersion)) {
            continue;
          }
          try
          {
            i = Integer.valueOf(((ShortVideoResourceManager.SVConfigItem)localObject).name.substring(AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resPrefix.length())).intValue();
            if (i < AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resVersionLimit) {
              continue;
            }
            return 0;
          }
          catch (Exception localException1)
          {
            bmbx.d("AEResUtil", "[checkConfigUsable] String2int error :" + ((ShortVideoResourceManager.SVConfigItem)localObject).name);
            i = 0;
            continue;
          }
        }
        return -103;
      }
      int i = -103;
    }
  }
  
  public static boolean checkUnzipFileListSizeIsOK(String paramString1, String paramString2)
  {
    if (!FeatureManager.isBasicFeaturesReadyInDir(paramString1))
    {
      bmbx.d("AEResUtil", "[checkUnzipFileListSizeIsOK] [isFilterSoExist] exists=false");
      return false;
    }
    return bbpt.a(paramString1, paramString2);
  }
  
  public static boolean copyAEResFileToFinalDir(String paramString1, String paramString2)
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
      i = FileUtils.copyDirectory(paramString2, bljn.b + paramString1 + File.separator, false, true, true);
      bmbx.d("AEResUtil", "copyResFileToFinalDir errorcode:" + i + ", fromPath:" + paramString2);
    } while (i == 0);
    return false;
  }
  
  public static String getAEResPath(@NonNull AEResInfo paramAEResInfo)
  {
    String str = getAEResUnzipPathFromSP(paramAEResInfo);
    if (TextUtils.isEmpty(str))
    {
      bmbx.d("AEResUtil", "[getAEResPath] pathVersion null");
      return null;
    }
    if (!bbpt.a(str, paramAEResInfo.resVersionLimit))
    {
      bmbx.d("AEResUtil", "[getAEResPath] pathVersion is not > limitVersion");
      return null;
    }
    return getUnzipFilePathBase() + str + File.separator;
  }
  
  public static int getAEResStatus(AEResInfo paramAEResInfo)
  {
    int i;
    if (bbxj.a()) {
      if (isAEResExist(paramAEResInfo)) {
        i = 1;
      }
    }
    for (;;)
    {
      bmbx.a("AEResUtil", "getFilterSoState " + i);
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  private static String getAEResUnzipFinalPath()
  {
    return bmbk.a().a("aeres_copy_final_path_key", bljn.b, 4);
  }
  
  private static String getAEResUnzipPathFromSP(@NonNull AEResInfo paramAEResInfo)
  {
    return bmbk.a().a(paramAEResInfo.resPrefix + paramAEResInfo.resVersion + "aeres_unzip_path_key", "", 4);
  }
  
  public static int getDownloadPackageVersion(int paramInt)
  {
    return bmbk.a().a("key_ae_res_" + paramInt, 0, 4);
  }
  
  public static String getDownloadTmpPath()
  {
    return bljw.a + File.separator;
  }
  
  public static String getFinalUnzipFilePath()
  {
    return getAEResUnzipFinalPath();
  }
  
  @Nullable
  public static blvk getLocalPackageInfo(@NonNull AEResInfo paramAEResInfo)
  {
    if (!paramAEResInfo.isPackage) {
      return null;
    }
    Object localObject3 = new File(getZipFilePath(""));
    if (!((File)localObject3).exists()) {
      return null;
    }
    File[] arrayOfFile = ((File)localObject3).listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
      return null;
    }
    int m = arrayOfFile.length;
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    if (j < m)
    {
      localObject2 = arrayOfFile[j];
      if (!((File)localObject2).isDirectory()) {}
    }
    for (;;)
    {
      j += 1;
      break;
      String str = ((File)localObject2).getName();
      if (!TextUtils.isEmpty(str)) {
        if (str.startsWith(paramAEResInfo.resPrefix))
        {
          int k = Integer.valueOf(str.substring(paramAEResInfo.resPrefix.length())).intValue();
          if (k > i)
          {
            i = k;
            localObject1 = localObject2;
            continue;
            if (localObject1 == null) {
              return null;
            }
            paramAEResInfo = new File((File)localObject3, "tmp_" + BaseApplicationImpl.sProcessId + "_" + localObject1.getName() + "_" + System.currentTimeMillis());
            if (!paramAEResInfo.exists()) {
              paramAEResInfo.mkdirs();
            }
            npo.a(localObject1, paramAEResInfo.getAbsolutePath() + File.separator);
            localObject2 = paramAEResInfo.listFiles();
            localObject3 = new LinkedList();
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              k = localObject2.length;
              j = 0;
              while (j < k)
              {
                ((List)localObject3).add(localObject2[j].getName());
                j += 1;
              }
            }
            FileUtils.deleteDirectory(paramAEResInfo.getAbsolutePath());
            return new blvk(localObject1.getName(), i, localObject1.getPath(), (List)localObject3);
          }
        }
      }
    }
  }
  
  public static String getUnzipFilePathBase()
  {
    return bljn.a;
  }
  
  @NonNull
  public static String getUnzippedPackageDir(@NonNull AEResInfo paramAEResInfo)
  {
    if (!paramAEResInfo.isPackage) {
      return "";
    }
    if ((AEResInfo.AE_RES_BASE_PACKAGE.resPrefix.equals(paramAEResInfo.resPrefix)) || (AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resPrefix.equals(paramAEResInfo.resPrefix))) {
      return getFinalUnzipFilePath();
    }
    return "";
  }
  
  public static String getZipFilePath(String paramString)
  {
    return ShortVideoResourceManager.a(paramString);
  }
  
  public static boolean isAEBaseSoReady()
  {
    return FeatureManager.isBasicFeaturesFunctionReady();
  }
  
  public static boolean isAEResExist(AEResInfo paramAEResInfo)
  {
    String str = getAEResPath(paramAEResInfo);
    if (str == null)
    {
      bmbx.d("AEResUtil", "[isAEBaseResExist] soRootPath == null");
      return false;
    }
    if (!new File(str).exists())
    {
      bmbx.d("AEResUtil", "[isAEBaseResExist] exists = false");
      return false;
    }
    if (paramAEResInfo.index == AEResInfo.AE_RES_BASE_PACKAGE.index) {
      return FeatureManager.isBasicFeaturesReadyInDir(str);
    }
    return true;
  }
  
  public static boolean isFilterFaceSoVersionOK()
  {
    return FeatureManager.Features.FACE_DETECT.isAllSoVersionOk();
  }
  
  public static boolean loadAEBaseSo()
  {
    try
    {
      if (!isAEBaseSoReady())
      {
        bljd.a();
        bool = FeatureManager.loadBasicFeatures();
        bmbx.d("AEResUtil", "SoLoader.loadSvFilterSo success:" + bool);
      }
      boolean bool = isAEBaseSoReady();
      return bool;
    }
    finally {}
  }
  
  public static void peakRequestAEResAdditionPackage()
  {
    bbwm.a().a("CMD_DOWNLOAD_PTU_ADDITIONAL_RES", new Bundle());
  }
  
  public static void peakRequestAEResBasePackage()
  {
    bbwm.a().a("CMD_DOWNLOAD_PTU_BASE_RES", new Bundle());
  }
  
  public static boolean saveAEResUnzipFinalPath(@NonNull String paramString)
  {
    paramString = bljn.b + paramString + File.separator;
    bmbk.a().a("aeres_copy_final_path_key", paramString, 4);
    if (bmbk.a().a("aeres_copy_final_path_key", bljn.b, 4).equals(paramString))
    {
      bmbx.a("AEResUtil", "[saveAEResUnzipFinalPath] success");
      return true;
    }
    bmbx.d("AEResUtil", "[saveAEResUnzipFinalPath] error");
    return false;
  }
  
  public static boolean saveAEResUnzipPath(@NonNull String paramString, @NonNull AEResInfo paramAEResInfo)
  {
    bmbk.a().a(paramAEResInfo.resPrefix + paramAEResInfo.resVersion + "aeres_unzip_path_key", paramString, 4);
    if (paramString.equals(bmbk.a().a(paramAEResInfo.resPrefix + paramAEResInfo.resVersion + "aeres_unzip_path_key", "", 4)))
    {
      bmbx.a("AEResUtil", "[saveAEResUnzipPath] success");
      return true;
    }
    bmbx.d("AEResUtil", "[saveAEResUnzipPath] error");
    return false;
  }
  
  public static void sendBroadcast(AEResInfo paramAEResInfo, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEResInfo.resPrefix);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("ae_camera_res_downloadfinish_path", paramString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public static void setDownLoadPackageVersion(int paramInt1, int paramInt2)
  {
    bmbk.a().a("key_ae_res_" + paramInt1, paramInt2, 4);
  }
  
  private static void showDialog(@NonNull Context paramContext)
  {
    Bundle localBundle = bbwm.a().a("CMD_QUERY_STATUS_PTU_RES", new Bundle());
    int i = 0;
    if (localBundle != null) {
      i = localBundle.getInt("VALUE_MSG_PTU_RES_STATUS");
    }
    if ((i == 0) || (!checkAEResVersionOK(AEResInfo.AE_RES_ADDITIONAL_PACKAGE)))
    {
      bfur.a(paramContext, 230).setMessage(PTU_RES_DOWNLOAD_TIPS).setPositiveButton(paramContext.getString(2131693580), new AEResUtil.3()).setNegativeButton(paramContext.getString(2131693576), new AEResUtil.2()).show();
      return;
    }
    bmbx.a("AEResUtil", "[showDialog] is downloading");
    QQToast.a(paramContext, 2131689668, 1).a();
  }
  
  public static void tryDownloadAEResAdditionPackage(Context paramContext)
  {
    if (!NetworkUtil.isWifiConnected(paramContext)) {
      ThreadManager.getUIHandler().post(new AEResUtil.1(paramContext));
    }
    for (;;)
    {
      bmbx.d("AEResUtil", "【Camera is in Prepareing】tryDownloadAEResAdditionPackage");
      return;
      bmbx.d("AEResUtil", "【Camera is in Prepareing wifi】prepare to download");
      peakRequestAEResAdditionPackage();
    }
  }
  
  public static int verifyResource(String paramString1, String paramString2, String paramString3)
  {
    bmbx.a("AEResUtil", paramString1 + "|verifyResource() lResMd5=" + paramString2 + ", filepath=" + paramString3);
    if (TextUtils.isEmpty(paramString3))
    {
      bmbx.d("AEResUtil", "[verifyResource] filePath :null");
      return -105;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      bmbx.d("AEResUtil", "[verifyResource] lResMd5 :null");
      return -106;
    }
    File localFile = new File(paramString3);
    if (!localFile.exists())
    {
      bmbx.d("AEResUtil", paramString1 + "|verifyResource() file[" + paramString3 + "] not exist..");
      return -107;
    }
    Object localObject = null;
    try
    {
      paramString3 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString3));
      bmbx.a("AEResUtil", paramString1 + "|verifyResource()  lResMd5=" + paramString2 + ",md5=" + paramString3);
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
          paramString3 = bjkf.a(localFile);
        }
        catch (Exception paramString3)
        {
          paramString3.printStackTrace();
          paramString3 = localObject;
        }
      }
      bmbx.d("AEResUtil", "[verifyResource] equalsIgnoreCase :false");
    }
    return -108;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResUtil
 * JD-Core Version:    0.7.0.1
 */