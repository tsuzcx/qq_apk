package com.tencent.mobileqq.kandian.biz.flutter.offline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ZipUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoader;", "", "()V", "CONFIG_FILE_NAME", "", "CONFIG_VERSION", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "MX_FLUTTER_APP_VERSION_KEY", "MX_FLUTTER_DOWNLOAD_DIR", "MX_FLUTTER_SP_KEY", "QQ_MX_FLUTTER_APP_VERSION", "TAG", "downloadCallbacks", "", "Lcom/tencent/biz/common/offline/AsyncBack;", "getDownloadCallbacks", "()Ljava/util/List;", "preCopyApkSourceToFile", "getPreCopyApkSourceToFile", "setPreCopyApkSourceToFile", "checkMxFlutterBundleUpdate", "bid", "checkMxFlutterBundleUpdateAsync", "", "mxFlutterResourceLoadListener", "Lcom/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoadListener;", "compareConfigVersion", "sourcePath", "targetPath", "copyApkResourceToMxFlutterDir", "copyBizZipToMxFlutterDir", "copyBizZipToMxFlutterDirInner", "copyMainZipToMxFlutterDir", "copyMainZipToMxFlutterDirInner", "copyResourceToMxFlutterDir", "mxFlutterDirPath", "downLoadResource", "copyToMxFlutterDir", "downloadSuccess", "ensureResApkAddToAsset", "qFlutterInstallDir", "getAndDownloadResource", "widgetName", "getMxFlutterCopyPath", "getMxFlutterOffLineDownloadPath", "getMxFlutterRootPath", "isKdPersonLikeUseMxFlutter", "realDownLoadResource", "app", "Lmqq/app/AppRuntime;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class MxFlutterResourceLoader
{
  public static final MxFlutterResourceLoader a = new MxFlutterResourceLoader();
  private static volatile boolean b;
  @NotNull
  private static final List<AsyncBack> c = (List)new ArrayList();
  private static boolean d;
  
  private final void a(String paramString, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    QLog.d("MxFlutterResourceLoader", 1, "#checkMxFlutterBundleUpdateAsync: begin");
    ThreadManager.executeOnFileThread((Runnable)new MxFlutterResourceLoader.checkMxFlutterBundleUpdateAsync.1(paramString, paramMxFlutterResourceLoadListener));
  }
  
  private final void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#realDownLoadResource: begin bid=");
    localStringBuilder.append(paramString);
    QLog.d("MxFlutterResourceLoader", 1, localStringBuilder.toString());
    ThreadManager.executeOnFileThread((Runnable)new MxFlutterResourceLoader.realDownLoadResource.1(paramString, paramMxFlutterResourceLoadListener, paramBoolean, paramAppRuntime));
  }
  
  private final boolean a(String paramString)
  {
    boolean bool = true;
    try
    {
      QLog.d("MxFlutterResourceLoader", 1, "#checkMxFlutterBundleUpdate: begin");
      try
      {
        localObject1 = c(paramString);
        Object localObject2;
        if (FileUtils.fileExists((String)localObject1))
        {
          localObject2 = b(paramString);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(File.separator);
          if (a(localStringBuilder.toString(), (String)localObject1))
          {
            QLog.d("MxFlutterResourceLoader", 1, "#checkMxFlutterBundleUpdate: need update");
            bool = b(paramString, (String)localObject1);
          }
          else
          {
            QLog.d("MxFlutterResourceLoader", 1, "#checkMxFlutterBundleUpdate: no update");
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("#checkMxFlutterBundleUpdate: ");
          ((StringBuilder)localObject2).append(" mxFlutterDirPath not exist need update ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject2).toString());
          bool = b(paramString, (String)localObject1);
        }
      }
      catch (Exception paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkMxFlutterBundleUpdate error ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject1).toString());
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  private final boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("config.json");
      paramString1 = ((StringBuilder)localObject1).toString();
      if (!FileUtils.fileExists(paramString1)) {
        return false;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("config.json");
      paramString2 = ((StringBuilder)localObject1).toString();
      if (FileUtils.fileExists(paramString2))
      {
        localObject1 = FileUtils.readFileContent(new File(paramString1));
        String str = FileUtils.readFileContent(new File(paramString2));
        Object localObject2 = new JSONObject((String)localObject1);
        JSONObject localJSONObject = new JSONObject(str);
        int i = ((JSONObject)localObject2).getInt("version");
        int j = localJSONObject.getInt("version");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("#compareConfigVersion: sourceConfigPath=");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(", targetConfigPath=");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(", sourceContent=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", targetContent=");
        ((StringBuilder)localObject2).append(str);
        QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject2).toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.b(paramString));
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
  
  private final void b(String paramString, boolean paramBoolean, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#downloadSuccess: bid=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", copyToMxFlutterDir=");
    localStringBuilder.append(paramBoolean);
    QLog.d("MxFlutterResourceLoader", 1, localStringBuilder.toString());
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
      QLog.d("MxFlutterResourceLoader", 1, "#copyResourceToMxFlutterDir: begin");
      paramString1 = b(paramString1);
      boolean bool = false;
      int i = FileUtils.copyDirectory(paramString1, paramString2, false, true, true);
      paramString1 = new StringBuilder();
      paramString1.append("#copyResourceToMxFlutterDir: copy finished, result=");
      paramString1.append(i);
      QLog.d("MxFlutterResourceLoader", 1, paramString1.toString());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  private final String c(String paramString)
  {
    Object localObject = f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  @SuppressLint({"PrivateApi"})
  private final boolean d(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("res.apk");
    paramString = ((StringBuilder)localObject1).toString();
    if (FileUtils.fileExists(paramString)) {}
    for (;;)
    {
      try
      {
        localObject1 = BaseApplicationImpl.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getContext()");
        localObject1 = ((BaseApplication)localObject1).getAssets();
        Object localObject2 = ((AssetManager)localObject1).list("flutter_assets");
        if (localObject2 == null) {
          break label183;
        }
        i = localObject2.length;
        if (i <= 0)
        {
          localObject2 = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "addAssetPathMethod");
          ((Method)localObject2).setAccessible(true);
          ((Method)localObject2).invoke(localObject1, new Object[] { paramString });
        }
        return true;
      }
      catch (Exception paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ensureResApkAddToAsset ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.e("MxFlutterResourceLoader", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      QLog.d("MxFlutterResourceLoader", 1, "ensureResApkAddToAsset: res.apk not found");
      return false;
      label183:
      int i = 0;
    }
  }
  
  private final String f()
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
  
  private final boolean g()
  {
    String str1 = DeviceInfoUtil.e();
    Object localObject = BaseApplicationImpl.context.getSharedPreferences("mx_flutter_sp_key", 0);
    String str2 = ((SharedPreferences)localObject).getString("mx_flutter_app_version_key", "");
    String str3 = f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append("main");
    str3 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append(File.separator);
    str3 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append("main.js");
    str3 = localStringBuilder.toString();
    if ((!(Intrinsics.areEqual(str1, str2) ^ true)) && (new File(str3).exists()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("copyMainZipToMxFlutterDir same version:");
      ((StringBuilder)localObject).append(str1);
      QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    boolean bool = h();
    if (bool)
    {
      QLog.d("MxFlutterResourceLoader", 1, "copyApkResourceToMxFlutterDir copy main unzip success");
      ((SharedPreferences)localObject).edit().putString("mx_flutter_app_version_key", str1).apply();
    }
    return bool;
  }
  
  private final boolean h()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("copyMainZipToMxFlutterDirInner ");
      ((StringBuilder)localObject1).append("flutter_assets/packages/mxflutter/js_lib/main.zip");
      QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject1).toString());
      localObject1 = (Context)BaseApplicationImpl.context;
      localObject2 = f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("main");
      localStringBuilder.append(File.separator);
      boolean bool = ZipUtil.a((Context)localObject1, "flutter_assets/packages/mxflutter/js_lib/main.zip", localStringBuilder.toString());
      return bool;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyMainZipToMxFlutterDirInner copy main unzip failed:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject2).toString());
    }
    return false;
  }
  
  private final boolean i()
  {
    String str = DeviceInfoUtil.e();
    Object localObject = BaseApplicationImpl.context.getSharedPreferences("mx_flutter_sp_key", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_mx_flutter_app_version_");
    localStringBuilder.append(str);
    boolean bool1;
    if (TextUtils.isEmpty((CharSequence)((SharedPreferences)localObject).getString(localStringBuilder.toString(), "")))
    {
      boolean bool2 = j();
      bool1 = bool2;
      if (bool2)
      {
        QLog.d("MxFlutterResourceLoader", 1, "copyBizZipToMxFlutterDir copy biz unzip success");
        localObject = ((SharedPreferences)localObject).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("qq_mx_flutter_app_version_");
        localStringBuilder.append(str);
        ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "true").apply();
        return bool2;
      }
    }
    else
    {
      QLog.d("MxFlutterResourceLoader", 1, "copyBizZipToMxFlutterDir already copied");
      bool1 = true;
    }
    return bool1;
  }
  
  private final boolean j()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("copyBizZipToMxFlutterDirInner ");
        ((StringBuilder)localObject1).append("flutter_assets/packages/qq_mxflutter/mxflutter_js_bundle/bizBundle.zip");
        QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject1).toString());
        localObject1 = f();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("tempMXBizBundle");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separator);
        localObject1 = ((StringBuilder)localObject2).toString();
        if (ZipUtil.a((Context)BaseApplicationImpl.context, "flutter_assets/packages/qq_mxflutter/mxflutter_js_bundle/bizBundle.zip", (String)localObject1))
        {
          localObject2 = new File((String)localObject1).listFiles();
          int j = localObject2.length;
          i = 0;
          if (i < j)
          {
            Object localObject3 = localObject2[i];
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "tempFile");
            String str = ((File)localObject3).getName();
            localObject3 = ((File)localObject3).getPath();
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append(File.separator);
            localObject3 = ((StringBuilder)localObject4).toString();
            localObject4 = f();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject4);
            localStringBuilder.append(str);
            localObject4 = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject4);
            localStringBuilder.append(File.separator);
            localObject4 = localStringBuilder.toString();
            if (!a((String)localObject3, (String)localObject4)) {
              break label381;
            }
            FileUtils.copyDirectory((String)localObject3, (String)localObject4, false);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("copyBizZipToMxFlutterDirInner copy biz File :");
            ((StringBuilder)localObject3).append(str);
            QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject3).toString());
            break label381;
          }
          FileUtils.deleteDirectory((String)localObject1);
          return true;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("copyBizZipToMxFlutterDir copy biz unzip failed:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject2).toString());
      }
      return false;
      label381:
      i += 1;
    }
  }
  
  public final void a(@NotNull String paramString, boolean paramBoolean, @Nullable MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bid");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("#downLoadResource: begin bid=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("MxFlutterResourceLoader", 1, ((StringBuilder)localObject).toString());
    localObject = RIJQQAppInterfaceUtil.e();
    if ((localObject instanceof QQAppInterface))
    {
      a(paramString, (AppRuntime)localObject, paramBoolean, paramMxFlutterResourceLoadListener);
      return;
    }
    QLog.d("MxFlutterResourceLoader", 1, "Get App Runtime is null");
    if (paramMxFlutterResourceLoadListener != null) {
      paramMxFlutterResourceLoadListener.a("Get App Runtime is null");
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public final boolean a()
  {
    return b;
  }
  
  @NotNull
  public final List<AsyncBack> b()
  {
    return c;
  }
  
  public final boolean c()
  {
    return d;
  }
  
  public final boolean d()
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
  
  public final void e()
  {
    QLog.d("MxFlutterResourceLoader", 1, "copyApkResourceToMxFlutterDir: begin");
    if (b)
    {
      QLog.d("MxFlutterResourceLoader", 1, "copyApkResourceToMxFlutterDir: already copy");
      return;
    }
    try
    {
      Object localObject1 = a;
      String str = QFlutterInstaller.b();
      Intrinsics.checkExpressionValueIsNotNull(str, "QFlutterInstaller.getInstallDir()");
      if (!((MxFlutterResourceLoader)localObject1).d(str))
      {
        QLog.d("MxFlutterResourceLoader", 1, "copyApkResourceToMxFlutterDir: res.apk error");
        return;
      }
      ThreadManager.executeOnFileThread((Runnable)MxFlutterResourceLoader.copyApkResourceToMxFlutterDir.1.1.a);
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader
 * JD-Core Version:    0.7.0.1
 */