package com.tencent.mobileqq.kandian.biz.flutter.offline;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoader;", "", "()V", "CONFIG_FILE_NAME", "", "CONFIG_VERSION", "MX_FLUTTER_APP_VERSION_KEY", "MX_FLUTTER_DOWNLOAD_DIR", "MX_FLUTTER_SP_KEY", "QQ_MX_FLUTTER_APP_VERSION", "TAG", "preCopyApkSourceToFile", "", "getPreCopyApkSourceToFile", "()Z", "setPreCopyApkSourceToFile", "(Z)V", "checkMxFlutterBundleUpdate", "bid", "checkMxFlutterBundleUpdateAsync", "", "mxFlutterResourceLoadListener", "Lcom/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoadListener;", "compareConfigVersion", "sourcePath", "targetPath", "copyApkResourceToMxFlutterDir", "qFlutterInstallDir", "copyBizZipToMxFlutterDir", "copyMainZipToMxFlutterDir", "copyResourceToMxFlutterDir", "mxFlutterDirPath", "downLoadResource", "copyToMxFlutterDir", "downloadSuccess", "ensureResApkAddToAsset", "getAndDownloadResource", "widgetName", "getMxFlutterCopyPath", "getMxFlutterOffLineDownloadPath", "getMxFlutterRootPath", "isKdPersonLikeUseMxFlutter", "realDownLoadResource", "app", "Lmqq/app/AppRuntime;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class MxFlutterResourceLoader
{
  public static final MxFlutterResourceLoader a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFlutterOfflineMxFlutterResourceLoader = new MxFlutterResourceLoader();
  }
  
  private final String a()
  {
    Object localObject = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.sApplication");
    localObject = ((BaseApplicationImpl)localObject).getCacheDir();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.sApplication.cacheDir");
    localObject = ((File)localObject).getPath();
    if (localObject == null) {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("mxflutter_js_bundle");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private final String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.a(paramString));
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getMxFlutterDownloadPath], bid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", path = ");
    localStringBuilder.append((String)localObject);
    QLog.i("MxFlutterResourceLoader", 1, localStringBuilder.toString());
    return localObject;
  }
  
  private final void a(String paramString, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    ThreadManager.post((Runnable)new MxFlutterResourceLoader.checkMxFlutterBundleUpdateAsync.1(paramString, paramMxFlutterResourceLoadListener), 8, null, true);
  }
  
  private final void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    ThreadManager.post((Runnable)new MxFlutterResourceLoader.realDownLoadResource.1(paramString, paramAppRuntime, paramBoolean, paramMxFlutterResourceLoadListener, System.currentTimeMillis()), 8, null, true);
  }
  
  private final boolean a(String paramString)
  {
    try
    {
      localObject1 = b(paramString);
      Object localObject2;
      if (FileUtils.fileExists((String)localObject1))
      {
        localObject2 = a(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(File.separator);
        if (a(localStringBuilder.toString(), (String)localObject1))
        {
          QLog.d("MxFlutterResourceLoader", 1, "checkMxFlutterBundleUpdate compare version and update");
          return b(paramString, (String)localObject1);
        }
        QLog.d("MxFlutterResourceLoader", 1, "checkMxFlutterBundleUpdate compare version not update");
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkMxFlutterBundleUpdate mxFlutterDirPath not exist need update ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject2).toString());
        boolean bool = b(paramString, (String)localObject1);
        return bool;
      }
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkMxFlutterBundleUpdate error ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  private final boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("config.json");
      if (!FileUtils.fileExists(localStringBuilder.toString())) {
        return false;
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("config.json");
      paramString2 = paramString1.toString();
      if (FileUtils.fileExists(paramString2))
      {
        paramString1 = FileUtils.readFileContent(new File(paramString2));
        paramString2 = FileUtils.readFileContent(new File(paramString2));
        paramString1 = new JSONObject(paramString1);
        paramString2 = new JSONObject(paramString2);
        int i = paramString1.getInt("version");
        int j = paramString2.getInt("version");
        if (i > j) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("compareConfigVersion error ");
      paramString2.append(paramString1.getMessage());
      QLog.d("MxFlutterResourceLoader", 1, paramString2.toString());
    }
    return false;
  }
  
  private final String b(String paramString)
  {
    Object localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  private final void b(String paramString, boolean paramBoolean, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    if (paramBoolean)
    {
      a(paramString, paramMxFlutterResourceLoadListener);
      return;
    }
    if (paramMxFlutterResourceLoadListener != null) {
      paramMxFlutterResourceLoadListener.a();
    }
  }
  
  private final boolean b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(paramString1);
      boolean bool = false;
      int i = FileUtils.copyDirectory(paramString1, paramString2, false);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public final void a(@NotNull String paramString, boolean paramBoolean, @Nullable MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bid");
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      a(paramString, localAppRuntime, paramBoolean, paramMxFlutterResourceLoadListener);
      return;
    }
    if (paramMxFlutterResourceLoadListener != null) {
      paramMxFlutterResourceLoadListener.a("Get App Runtime is null");
    }
    QLog.d("MxFlutterResourceLoader", 1, "Get App Runtime is null");
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public final boolean b()
  {
    try
    {
      Object localObject = Aladdin.getConfig(321).getString("mqq_kandian_user_center_config", "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "res");
      localObject = (CharSequence)localObject;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("target=");
      localStringBuilder.append("12");
      boolean bool = StringsKt.contains$default((CharSequence)localObject, (CharSequence)localStringBuilder.toString(), false, 2, null);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isKdPersonLikeUseMxFlutter error:");
      localStringBuilder.append(localException.getMessage());
      QLog.d("MxFlutterResourceLoader", 1, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader
 * JD-Core Version:    0.7.0.1
 */