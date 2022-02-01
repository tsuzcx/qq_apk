package com.tencent.mobileqq.minigame.api;

import bmsv;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Companion;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Environment;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Orientation;
import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage.Companion;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQMiniGamePackageManager;", "", "()V", "createGamePackage", "Lcom/tencent/mobileqq/minigame/api/QQMiniGamePackage;", "miniGamePkg", "Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;", "performDownloadSubPackage", "", "name", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQMiniGamePackageManager
{
  public static final QQMiniGamePackageManager INSTANCE = new QQMiniGamePackageManager();
  
  @JvmStatic
  @NotNull
  public static final QQMiniGamePackage createGamePackage(@NotNull MiniGamePkg paramMiniGamePkg)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramMiniGamePkg, "miniGamePkg");
    MiniAppConfig localMiniAppConfig = paramMiniGamePkg.appConfig;
    Object localObject2 = localMiniAppConfig.config;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "info");
    GamePackage.Orientation localOrientation;
    GamePackage.Environment localEnvironment;
    label72:
    HashMap localHashMap;
    Object localObject1;
    Object localObject3;
    label245:
    String str1;
    String str2;
    Object localObject4;
    if (((MiniAppInfo)localObject2).isLandScape())
    {
      localOrientation = GamePackage.Orientation.LANDSCAPE;
      switch (((MiniAppInfo)localObject2).verType)
      {
      default: 
        localEnvironment = GamePackage.Environment.RELEASE;
        localHashMap = new HashMap();
        ((Map)localHashMap).put("accountInfo", MapsKt.mapOf(new Pair[] { TuplesKt.to("appId", ((MiniAppInfo)localObject2).appId), TuplesKt.to("icon", ((MiniAppInfo)localObject2).iconUrl) }));
        localObject1 = (Map)localHashMap;
        localObject3 = bmsv.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "PlatformInfor.g()");
        localObject3 = ((bmsv)localObject3).f();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "PlatformInfor.g().simpleDeviceInfor");
        ((Map)localObject1).put("deviceinfo", localObject3);
        localObject1 = (Map)localHashMap;
        localObject3 = ((MiniAppInfo)localObject2).version;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "info.version");
        ((Map)localObject1).put("miniapp_version", localObject3);
        localObject1 = (Map)localHashMap;
        if ((((MiniAppInfo)localObject2).debugInfo != null) && (((MiniAppInfo)localObject2).debugInfo.valid()) && (localMiniAppConfig.launchParam.scene == 1011))
        {
          ((Map)localObject1).put("enableFrameProfile", Boolean.valueOf(bool));
          localObject1 = ((MiniAppInfo)localObject2).miniGamePluginInfo;
          if (localObject1 == null) {
            break label505;
          }
          localObject3 = GamePluginPackage.Companion;
          str1 = ((MiniGamePluginInfo)localObject1).name;
          Intrinsics.checkExpressionValueIsNotNull(str1, "it.name");
          str2 = ((MiniGamePluginInfo)localObject1).id;
          Intrinsics.checkExpressionValueIsNotNull(str2, "it.id");
          localObject4 = ((MiniGamePluginInfo)localObject1).version;
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.version");
          localObject1 = CollectionsKt.listOf(((GamePluginPackage.Companion)localObject3).create(str1, str2, (String)localObject4, new File(ApkgManager.getGpkgPluginFolderPath((MiniGamePluginInfo)localObject1))));
          if (localObject1 == null) {
            break label505;
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject3 = GamePackage.Companion;
      str1 = ((MiniAppInfo)localObject2).appId;
      Intrinsics.checkExpressionValueIsNotNull(str1, "info.appId");
      str2 = ((MiniAppInfo)localObject2).name;
      Intrinsics.checkExpressionValueIsNotNull(str2, "info.name");
      localObject4 = new File(ApkgManager.getApkgFolderPath((MiniAppInfo)localObject2));
      String str3 = paramMiniGamePkg.mConfigStr;
      Intrinsics.checkExpressionValueIsNotNull(str3, "miniGamePkg.mConfigStr");
      localObject2 = ((MiniAppInfo)localObject2).version;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "info.version");
      paramMiniGamePkg = ((GamePackage.Companion)localObject3).create(str1, str2, (File)localObject4, str3, localOrientation, (String)localObject2, localEnvironment, (Map)localHashMap, (List)localObject1, (Function2)new QQMiniGamePackageManager.createGamePackage.gamePackage.1(paramMiniGamePkg));
      Intrinsics.checkExpressionValueIsNotNull(localMiniAppConfig, "config");
      return new QQMiniGamePackage(localMiniAppConfig, paramMiniGamePkg);
      localOrientation = GamePackage.Orientation.PORTRAIT;
      break;
      localEnvironment = GamePackage.Environment.DEVELOP;
      break label72;
      localEnvironment = GamePackage.Environment.TRIAL;
      break label72;
      bool = false;
      break label245;
      label505:
      localObject1 = CollectionsKt.emptyList();
    }
  }
  
  private final void performDownloadSubPackage(MiniGamePkg paramMiniGamePkg, String paramString, GamePackage.SubpackageListener paramSubpackageListener)
  {
    paramMiniGamePkg.downloadSubPack(paramString, (GpkgManager.OnInitGpkgListener)new QQMiniGamePackageManager.performDownloadSubPackage.1(paramMiniGamePkg, paramString, paramSubpackageListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniGamePackageManager
 * JD-Core Version:    0.7.0.1
 */