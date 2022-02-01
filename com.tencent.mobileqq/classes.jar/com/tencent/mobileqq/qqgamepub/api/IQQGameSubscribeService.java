package com.tencent.mobileqq.qqgamepub.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe.AppSubscribeInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQGameSubscribeService
  extends IRuntimeService
{
  public abstract void enterSingleGameMsgPage(Context paramContext, String paramString, int paramInt);
  
  public abstract boolean enterSubscribeManagePage(Activity paramActivity, String paramString1, String paramString2, String paramString3);
  
  public abstract void filterSingleGameMsgList(Activity paramActivity, List<ChatMessage> paramList);
  
  public abstract View findGameGrayTipsViewInParent(ViewGroup paramViewGroup);
  
  public abstract List<QQGamePubSubscribe.AppSubscribeInfo> getCachedSubscribeList();
  
  public abstract IQQGameSubscribeService.GameBaseInfo getGameInfoFromCacheMap(String paramString);
  
  public abstract void getSubscribeInfo(String paramString);
  
  public abstract void handleGameInfoUiOnRsp(ViewGroup paramViewGroup, String paramString, QQGamePubSubscribe.AppSubscribeInfo paramAppSubscribeInfo, boolean paramBoolean);
  
  public abstract void handleSubscribeGrayTipsUi(String paramString, ChatMessage paramChatMessage, ViewGroup paramViewGroup, int paramInt);
  
  public abstract boolean isFromAllMsgGameSinglePage(Intent paramIntent);
  
  public abstract boolean isGameSinglePage(Intent paramIntent);
  
  public abstract boolean isSubscribed(String paramString);
  
  public abstract void preHandleGameInfoUi(ViewGroup paramViewGroup, String paramString);
  
  public abstract void putToGameInfoMap(String paramString, IQQGameSubscribeService.GameBaseInfo paramGameBaseInfo);
  
  public abstract long reqSetSubscribeStatus(String paramString, int paramInt1, int paramInt2);
  
  public abstract void reqSubscribeList(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService
 * JD-Core Version:    0.7.0.1
 */