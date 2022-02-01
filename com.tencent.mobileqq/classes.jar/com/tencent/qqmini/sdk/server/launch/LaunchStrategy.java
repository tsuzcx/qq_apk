package com.tencent.qqmini.sdk.server.launch;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy;", "", "killAllProcess", "", "killMiniAppProcess", "", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "onAppBackground", "processName", "", "appConfig", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppBaseInfo;", "bundle", "Landroid/os/Bundle;", "onAppForeground", "onAppStart", "onAppStop", "onPreloaded", "onReceiveProcessRunningAppInfos", "runningApps", "", "preloadProcess", "registerProcessMessenger", "messenger", "Landroid/os/Messenger;", "sendMessageToMiniProcess", "message", "Landroid/os/Message;", "startMiniApp", "Lcom/tencent/qqmini/sdk/server/launch/LaunchStrategy$LaunchData;", "LaunchData", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public abstract interface LaunchStrategy
{
  public abstract void killAllProcess();
  
  public abstract boolean killMiniAppProcess(@NotNull MiniAppInfo paramMiniAppInfo);
  
  public abstract void onAppBackground(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @Nullable Bundle paramBundle);
  
  public abstract void onAppForeground(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @Nullable Bundle paramBundle);
  
  public abstract void onAppStart(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @NotNull Bundle paramBundle);
  
  public abstract void onAppStop(@NotNull String paramString, @NotNull MiniAppBaseInfo paramMiniAppBaseInfo, @Nullable Bundle paramBundle);
  
  public abstract void onPreloaded(@NotNull String paramString, @NotNull Bundle paramBundle);
  
  public abstract void onReceiveProcessRunningAppInfos(@NotNull String paramString, @NotNull List<? extends MiniAppInfo> paramList);
  
  public abstract boolean preloadProcess(@Nullable Bundle paramBundle);
  
  public abstract void registerProcessMessenger(@NotNull String paramString, @NotNull Messenger paramMessenger);
  
  public abstract void sendMessageToMiniProcess(@NotNull MiniAppInfo paramMiniAppInfo, @NotNull Message paramMessage);
  
  @NotNull
  public abstract LaunchStrategy.LaunchData startMiniApp(@NotNull MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.LaunchStrategy
 * JD-Core Version:    0.7.0.1
 */