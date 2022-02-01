package com.tencent.mobileqq.cmshow.engine.resource;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import kotlin.Deprecated;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader;", "", "apolloResManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "getApolloResManager", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "checkDownloadFaceData", "", "app", "Lmqq/app/AppRuntime;", "url", "", "faceDataDownloadListener", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnFaceDataDownloadListener;", "downLoadCmShowRes", "path", "params", "Landroid/os/Bundle;", "listener", "Lcom/tencent/mobileqq/vip/DownloadListener;", "downLoadSpecialAction", "downloadApolloAudio", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnAudioDownloadListener;", "audioId", "", "forceUpdate", "", "downloadApolloRes", "uin", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "roleId", "dressIds", "", "actionId", "actiontype", "downloadApolloResOrder", "outRoleId", "outDressIds", "downloadApolloResOrderWithDefaultListener", "actionType", "OnApolloDownLoadListener", "OnAudioDownloadListener", "OnFaceDataDownloadListener", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloResDownloader
{
  @NotNull
  public abstract IApolloResManager a();
  
  public abstract void a(@Nullable AppInterface paramAppInterface, @Nullable IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener, int paramInt, boolean paramBoolean);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, @Nullable IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, @Nullable IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle, @Nullable DownloadListener paramDownloadListener);
  
  @Deprecated(message="请使用{@link ApolloResDownloader#downloadApolloResOrder(AppInterface, Context, OnApolloDownLoadListener,\n      int, int[], boolean)} 该方法不能解压角色里的默认装扮，如需先下载角色再下载装扮，请使用order")
  public abstract void b(@Nullable AppRuntime paramAppRuntime, @Nullable String paramString, @Nullable IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader
 * JD-Core Version:    0.7.0.1
 */