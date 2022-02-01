package com.tencent.mobileqq.qqgamepub.api;

import android.os.Bundle;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigBean;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.DownloadListener;
import java.util.List;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IQQGamePreDownloadService
  extends QRouteApi
{
  public abstract void checkAndCleanExpireCache();
  
  public abstract String getActivityUrl(String paramString);
  
  public abstract QQGamePreDownloadConfigBean getConfig();
  
  public abstract boolean interceptJumpHippy(String paramString);
  
  public abstract void preDownloadPubPushRes(List<QQGameMsgInfo> paramList);
  
  public abstract void setArkResNameToMeta(String paramString, JSONObject paramJSONObject);
  
  public abstract void startDownload(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle);
  
  public abstract void startPreDownload(DownloadParam paramDownloadParam, DownloadListener paramDownloadListener, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService
 * JD-Core Version:    0.7.0.1
 */