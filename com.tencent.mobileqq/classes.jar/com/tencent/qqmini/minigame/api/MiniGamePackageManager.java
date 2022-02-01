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
    label82:
    Object localObject1;
    HashMap localHashMap;
    Object localObject2;
    Object localObject3;
    boolean bool;
    label440:
    String str1;
    Object localObject4;
    if (Intrinsics.areEqual(localMiniGamePkg.mGameConfigJson.optString("deviceOrientation"), "landscape"))
    {
      localOrientation = GamePackage.Orientation.LANDSCAPE;
      paramIMiniAppContext = localMiniAppInfo.getVerTypeStr();
      if (paramIMiniAppContext != null) {
        break label670;
      }
      paramIMiniAppContext = GamePackage.Environment.RELEASE;
      localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localHashMap = new HashMap();
      ((Map)localHashMap).put("accountInfo", MapsKt.mapOf(new Pair[] { TuplesKt.to("appId", localMiniAppInfo.appId), TuplesKt.to("icon", localMiniAppInfo.iconUrl) }));
      localObject2 = (Map)localHashMap;
      localObject3 = MiniAppEnv.g();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "MiniAppEnv.g()");
      localObject3 = QUAUtil.getSimpleDeviceInfo(((MiniAppEnv)localObject3).getContext());
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "QUAUtil.getSimpleDeviceI…o(MiniAppEnv.g().context)");
      ((Map)localObject2).put("deviceinfo", localObject3);
      localObject2 = (Map)localHashMap;
      localObject3 = localMiniAppInfo.version;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "info.version");
      ((Map)localObject2).put("miniapp_version", localObject3);
      localObject2 = (Map)localHashMap;
      localObject3 = QUAUtil.getQUA();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "QUAUtil.getQUA()");
      ((Map)localObject2).put("sdk_version", localObject3);
      localObject2 = (Map)localHashMap;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "proxy");
      localObject3 = ((MiniAppProxy)localObject1).getAppName();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "proxy.appName");
      ((Map)localObject2).put("source_app", localObject3);
      localObject2 = (Map)localHashMap;
      localObject3 = LoginManager.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "LoginManager.getInstance()");
      localObject3 = ((LoginManager)localObject3).getAccount();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "LoginManager.getInstance().account");
      ((Map)localObject2).put("source_uin", localObject3);
      localObject2 = (Map)localHashMap;
      localObject1 = ((MiniAppProxy)localObject1).getAppVersion();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "proxy.appVersion");
      ((Map)localObject2).put("source_version", localObject1);
      localObject1 = (Map)localHashMap;
      localObject2 = QUAUtil.getLoginType();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "QUAUtil.getLoginType()");
      ((Map)localObject1).put("source_uin_platform", localObject2);
      localObject1 = (Map)localHashMap;
      if ((localMiniAppInfo.debugInfo == null) || (!localMiniAppInfo.debugInfo.valid()) || (localMiniAppInfo.launchParam.scene != 1011)) {
        break label737;
      }
      bool = true;
      ((Map)localObject1).put("enableFrameProfile", Boolean.valueOf(bool));
      localObject1 = localMiniAppInfo.miniGamePluginInfo;
      if (localObject1 == null) {
        break label742;
      }
      localObject2 = GamePluginPackage.Companion;
      localObject3 = ((MiniGamePluginInfo)localObject1).name;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.name");
      str1 = ((MiniGamePluginInfo)localObject1).id;
      Intrinsics.checkExpressionValueIsNotNull(str1, "it.id");
      localObject4 = ((MiniGamePluginInfo)localObject1).version;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.version");
      localObject1 = CollectionsKt.listOf(((GamePluginPackage.Companion)localObject2).create((String)localObject3, str1, (String)localObject4, new File(ApkgManager.getGpkgPluginFolderPath((MiniGamePluginInfo)localObject1))));
      if (localObject1 == null) {
        break label742;
      }
    }
    for (;;)
    {
      localObject2 = GamePackage.Companion;
      localObject3 = localMiniAppInfo.appId;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "info.appId");
      str1 = localMiniAppInfo.name;
      Intrinsics.checkExpressionValueIsNotNull(str1, "info.name");
      localObject4 = new File(ApkgManager.getApkgFolderPath(localMiniAppInfo));
      String str2 = localMiniGamePkg.mConfigStr;
      Intrinsics.checkExpressionValueIsNotNull(str2, "pkg.mConfigStr");
      String str3 = localMiniAppInfo.version;
      Intrinsics.checkExpressionValueIsNotNull(str3, "info.version");
      return new MiniGamePackage(((GamePackage.Companion)localObject2).create((String)localObject3, str1, (File)localObject4, str2, localOrientation, str3, paramIMiniAppContext, (Map)localHashMap, (List)localObject1, (Function2)new MiniGamePackageManager.createGamePackage.gamePackage.1(localMiniGamePkg, localMiniAppInfo)));
      localOrientation = GamePackage.Orientation.PORTRAIT;
      break;
      label670:
      switch (paramIMiniAppContext.hashCode())
      {
      default: 
        break;
      case 110628630: 
        if (!paramIMiniAppContext.equals("trial")) {
          break;
        }
        paramIMiniAppContext = GamePackage.Environment.TRIAL;
        break;
      case 1559690845: 
        if (!paramIMiniAppContext.equals("develop")) {
          break;
        }
        paramIMiniAppContext = GamePackage.Environment.DEVELOP;
        break label82;
        label737:
        bool = false;
        break label440;
        label742:
        localObject1 = CollectionsKt.emptyList();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniGamePackageManager
 * JD-Core Version:    0.7.0.1
 */