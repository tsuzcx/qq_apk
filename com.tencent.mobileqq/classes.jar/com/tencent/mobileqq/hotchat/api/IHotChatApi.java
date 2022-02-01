package com.tencent.mobileqq.hotchat.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppActivity;
import org.json.JSONArray;

@QAPI(process={"all"})
public abstract interface IHotChatApi
  extends QRouteApi
{
  public abstract void delHotChatRecentUserNotNotifyUi(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract Class getGetJoinedHotChatListStepClass();
  
  public abstract QQCustomDialog getHotChatAnnounceDialog(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2);
  
  public abstract Class getHotChatFlashPicActivityClass();
  
  public abstract String getHotChatHandlerClassName();
  
  public abstract String getHotChatHandlerClassSimpleName();
  
  public abstract Object getHotChatMsgListRefresher(Object paramObject);
  
  public abstract BusinessObserver getHotChatObserverImpl(Object paramObject);
  
  public abstract IHotChatPostListAdapter getHotChatPostListAdapter(Context paramContext, JSONArray paramJSONArray);
  
  public abstract IHotChatSCHelper getHotChatSCHelper(AppInterface paramAppInterface, IHotChatSCHelper.OnShowNoteListener paramOnShowNoteListener, String paramString);
  
  public abstract Class getHotChatSCMngClass();
  
  public abstract IHotChatShare getHotChatShare(AppActivity paramAppActivity, AppInterface paramAppInterface, IHotChatInfo paramIHotChatInfo);
  
  public abstract MessageRecord getShareHotChatGrayTips();
  
  public abstract Class getShareHotChatGrayTipsClass();
  
  public abstract void invokeRecentUserChangedToConversation(AppInterface paramAppInterface);
  
  public abstract String makeShareGrayTip(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IHotChatApi
 * JD-Core Version:    0.7.0.1
 */