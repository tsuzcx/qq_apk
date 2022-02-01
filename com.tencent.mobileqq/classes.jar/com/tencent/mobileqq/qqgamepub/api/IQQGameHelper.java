package com.tencent.mobileqq.qqgamepub.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.util.Pair;
import java.util.List;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IQQGameHelper
  extends QRouteApi
{
  public abstract Pair<String, JSONObject> addQQGameArkField(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject);
  
  public abstract int canOpenHippyByModuleName(String paramString);
  
  public abstract void dispatchVideoEvent(int paramInt);
  
  public abstract void enterAIO(Activity paramActivity);
  
  public abstract void enterAIO(Activity paramActivity, boolean paramBoolean);
  
  public abstract void enterGameCenter(String paramString);
  
  public abstract ActivityURIRequest getAIOURIRequest(Context paramContext);
  
  public abstract String getAccount();
  
  public abstract long getClickAioTime();
  
  public abstract String getDebugGamePubAccountType();
  
  public abstract IHeaderView getGameArkView(Activity paramActivity);
  
  public abstract String getGamePaHippyModuleName();
  
  public abstract IHeaderView getMoreMsgHeaderView(Activity paramActivity);
  
  public abstract QQGameMsgInfo getMsgInfoByHippyMap(HippyMap paramHippyMap);
  
  public abstract int getMsgPosByHippyMap(HippyMap paramHippyMap);
  
  public abstract QIPCModule getQQGameIPCModule();
  
  public abstract String getQQGameIPCModuleName();
  
  public abstract void initClickAioTime();
  
  public abstract boolean isGamePubAccountDebugOpen();
  
  public abstract boolean isInValidGameAppId(String paramString);
  
  public abstract boolean isNewPubStyle(Context paramContext, String paramString);
  
  public abstract boolean isQQGamePubAccount(String paramString);
  
  public abstract void notiftyQQGameNewMsg(List<MessageRecord> paramList);
  
  public abstract void openQQGameCenterByHippy(Context paramContext, String paramString1, String paramString2);
  
  public abstract void preloadQQGameCenterByHippy();
  
  public abstract void preloadSw();
  
  public abstract void publicAccountTianshuReport(int paramInt1, QQGameMsgInfo paramQQGameMsgInfo, int paramInt2);
  
  public abstract void reportArkExposure(Context paramContext, MessageRecord paramMessageRecord);
  
  public abstract void reportStructClick(Context paramContext, MessageRecord paramMessageRecord);
  
  public abstract void reportStructExposure(Context paramContext, MessageRecord paramMessageRecord);
  
  public abstract void setDebugGamePubAccountType(String paramString);
  
  public abstract void setGamePubAccountMode(boolean paramBoolean);
  
  public abstract void showGameEnterCacheInfo(View paramView, GmpEnterInfoRsp paramGmpEnterInfoRsp);
  
  public abstract void startGameCenterActivity(Context paramContext, String paramString);
  
  public abstract void startQQGameFlutter(Context paramContext, PageRouter paramPageRouter, Bundle paramBundle);
  
  public abstract void startQQGamePubAccount(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameHelper
 * JD-Core Version:    0.7.0.1
 */