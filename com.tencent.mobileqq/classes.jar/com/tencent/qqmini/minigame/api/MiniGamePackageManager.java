package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Companion;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Environment;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage.Companion;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/MiniGamePackageManager;", "", "()V", "createGamePackage", "Lcom/tencent/qqmini/minigame/api/MiniGamePackage;", "miniAppContext", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniGamePackageManager
{
  public static final MiniGamePackageManager INSTANCE = new MiniGamePackageManager();
  
  @JvmStatic
  @NotNull
  public static final MiniGamePackage createGamePackage(@NotNull IMiniAppContext paramIMiniAppContext)
  {
    Intrinsics.checkParameterIsNotNull(paramIMiniAppContext, "miniAppContext");
    paramIMiniAppContext = GetGameInfoManager.obtain(paramIMiniAppContext);
    if (paramIMiniAppContext == null) {
      Intrinsics.throwNpe();
    }
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    if (localMiniAppInfo == null) {
      Intrinsics.throwNpe();
    }
    MiniGamePkg localMiniGamePkg = paramIMiniAppContext.getMiniGamePkg();
    if (localMiniGamePkg == null) {
      Intrinsics.throwNpe();
    }
    GamePackage.Orientation localOrientation;
    if (Intrinsics.areEqual(localMiniGamePkg.mGameConfigJson.optString("deviceOrientation"), "landscape")) {
      localOrientation = GamePackage.Orientation.LANDSCAPE;
    } else {
      localOrientation = GamePackage.Orientation.PORTRAIT;
    }
    paramIMiniAppContext = localMiniAppInfo.getVerTypeStr();
    if (paramIMiniAppContext != null)
    {
      int i = paramIMiniAppContext.hashCode();
      if (i != 110628630)
      {
        if ((i == 1559690845) && (paramIMiniAppContext.equals("develop")))
        {
          paramIMiniAppContext = GamePackage.Environment.DEVELOP;
          break label146;
        }
      }
      else if (paramIMiniAppContext.equals("trial"))
      {
        paramIMiniAppContext = GamePackage.Environment.TRIAL;
        break label146;
      }
    }
    paramIMiniAppContext = GamePackage.Environment.RELEASE;
    label146:
    Object localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    Map localMap = (Map)new HashMap();
    Object localObject2 = TuplesKt.to("appId", localMiniAppInfo.appId);
    boolean bool2 = false;
    localMap.put("accountInfo", MapsKt.mapOf(new Pair[] { localObject2, TuplesKt.to("icon", localMiniAppInfo.iconUrl) }));
    localObject2 = MiniAppEnv.g();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "MiniAppEnv.g()");
    localObject2 = QUAUtil.getSimpleDeviceInfo(((MiniAppEnv)localObject2).getContext());
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "QUAUtil.getSimpleDeviceI…o(MiniAppEnv.g().context)");
    localMap.put("deviceinfo", localObject2);
    localObject2 = localMiniAppInfo.version;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "info.version");
    localMap.put("miniapp_version", localObject2);
    localObject2 = QUAUtil.getQUA();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "QUAUtil.getQUA()");
    localMap.put("sdk_version", localObject2);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "proxy");
    localObject2 = ((MiniAppProxy)localObject1).getAppName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "proxy.appName");
    localMap.put("source_app", localObject2);
    localObject2 = LoginManager.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "LoginManager.getInstance()");
    localObject2 = ((LoginManager)localObject2).getAccount();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "LoginManager.getInstance().account");
    localMap.put("source_uin", localObject2);
    localObject1 = ((MiniAppProxy)localObject1).getAppVersion();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "proxy.appVersion");
    localMap.put("source_version", localObject1);
    localObject1 = QUAUtil.getLoginType();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QUAUtil.getLoginType()");
    localMap.put("source_uin_platform", localObject1);
    boolean bool1 = bool2;
    if (localMiniAppInfo.debugInfo != null)
    {
      bool1 = bool2;
      if (localMiniAppInfo.debugInfo.valid())
      {
        bool1 = bool2;
        if (localMiniAppInfo.launchParam.scene == 1011) {
          bool1 = true;
        }
      }
    }
    localMap.put("enableFrameProfile", Boolean.valueOf(bool1));
    localObject1 = localMiniAppInfo.miniGamePluginInfo;
    if (localObject1 != null)
    {
      localObject2 = GamePluginPackage.Companion;
      str1 = ((MiniGamePluginInfo)localObject1).name;
      Intrinsics.checkExpressionValueIsNotNull(str1, "it.name");
      str2 = ((MiniGamePluginInfo)localObject1).id;
      Intrinsics.checkExpressionValueIsNotNull(str2, "it.id");
      localObject3 = ((MiniGamePluginInfo)localObject1).version;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.version");
      localObject1 = CollectionsKt.listOf(((GamePluginPackage.Companion)localObject2).create(str1, str2, (String)localObject3, new File(ApkgManager.getGpkgPluginFolderPath((MiniGamePluginInfo)localObject1))));
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = CollectionsKt.emptyList();
    }
    localObject2 = GamePackage.Companion;
    String str1 = localMiniAppInfo.appId;
    Intrinsics.checkExpressionValueIsNotNull(str1, "info.appId");
    String str2 = localMiniAppInfo.name;
    Intrinsics.checkExpressionValueIsNotNull(str2, "info.name");
    Object localObject3 = new File(ApkgManager.getApkgFolderPath(localMiniAppInfo));
    String str3 = localMiniGamePkg.mConfigStr;
    Intrinsics.checkExpressionValueIsNotNull(str3, "pkg.mConfigStr");
    String str4 = localMiniAppInfo.version;
    Intrinsics.checkExpressionValueIsNotNull(str4, "info.version");
    return new MiniGamePackage(((GamePackage.Companion)localObject2).create(str1, str2, (File)localObject3, str3, localOrientation, str4, paramIMiniAppContext, localMap, (List)localObject1, (Function2)new MiniGamePackageManager.createGamePackage.gamePackage.1(localMiniGamePkg, localMiniAppInfo)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniGamePackageManager
 * JD-Core Version:    0.7.0.1
 */