package com.yolo.esports.download;

import com.tencent.timi.game.router.IService;
import com.yolo.esports.download.cb.DownloadTaskListener;
import com.yolo.esports.download.common.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/yolo/esports/download/IDownloadService;", "Lcom/tencent/timi/game/router/IService;", "addCommonTaskListener", "", "listener", "Lcom/yolo/esports/download/cb/DownloadTaskListener;", "bindListener", "info", "Lcom/yolo/esports/download/common/DownloadInfo;", "deleteDownload", "url", "", "destroy", "getAllDownloadInfos", "", "getDownloadInfosByState", "stateList", "", "getDownloadTaskInfo", "pauseDownload", "removeBindListener", "removeCommonTaskListener", "startDownload", "onlyCreateInfo", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IDownloadService
  extends IService
{
  public abstract int a(@NotNull DownloadInfo paramDownloadInfo);
  
  @Nullable
  public abstract DownloadInfo a(@NotNull String paramString);
  
  public abstract void a(@NotNull DownloadTaskListener paramDownloadTaskListener);
  
  public abstract void b(@NotNull DownloadTaskListener paramDownloadTaskListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.IDownloadService
 * JD-Core Version:    0.7.0.1
 */