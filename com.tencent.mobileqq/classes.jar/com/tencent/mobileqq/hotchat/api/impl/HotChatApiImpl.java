package com.tencent.mobileqq.hotchat.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import com.tencent.mobileqq.hotchat.HotChatSCHelper;
import com.tencent.mobileqq.hotchat.HotChatSCMng;
import com.tencent.mobileqq.hotchat.adapter.HotChatPostListAdapter;
import com.tencent.mobileqq.hotchat.aio.HotChatMsgListRefresher;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.hotchat.api.IHotChatShare;
import com.tencent.mobileqq.hotchat.app.HotChatHandler;
import com.tencent.mobileqq.hotchat.app.HotChatObserverImpl;
import com.tencent.mobileqq.hotchat.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.hotchat.app.HotChatShare;
import com.tencent.mobileqq.hotchat.app.step.GetJoinedHotChatListStep;
import com.tencent.mobileqq.hotchat.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.hotchat.widget.HotChatAnnounceDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppActivity;
import org.json.JSONArray;

public class HotChatApiImpl
  implements IHotChatApi
{
  public void delHotChatRecentUserNotNotifyUi(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    HotChatRecentUserMgr.a((QQAppInterface)paramAppInterface, paramString, paramInt);
  }
  
  public Class getGetJoinedHotChatListStepClass()
  {
    return GetJoinedHotChatListStep.class;
  }
  
  public QQCustomDialog getHotChatAnnounceDialog(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    return new HotChatAnnounceDialog((QQAppInterface)paramAppInterface, paramContext, paramString1, paramString2);
  }
  
  public Class getHotChatFlashPicActivityClass()
  {
    return HotChatFlashPicActivity.class;
  }
  
  public String getHotChatHandlerClassName()
  {
    return HotChatHandler.class.getName();
  }
  
  public String getHotChatHandlerClassSimpleName()
  {
    return HotChatHandler.class.getSimpleName();
  }
  
  public Object getHotChatMsgListRefresher(Object paramObject)
  {
    return new HotChatMsgListRefresher((AIOContext)paramObject);
  }
  
  public BusinessObserver getHotChatObserverImpl(Object paramObject)
  {
    return new HotChatObserverImpl((HotChatPie)paramObject);
  }
  
  public IHotChatPostListAdapter getHotChatPostListAdapter(Context paramContext, JSONArray paramJSONArray)
  {
    return new HotChatPostListAdapter(paramContext, paramJSONArray, null);
  }
  
  public IHotChatSCHelper getHotChatSCHelper(AppInterface paramAppInterface, IHotChatSCHelper.OnShowNoteListener paramOnShowNoteListener, String paramString)
  {
    return new HotChatSCHelper((QQAppInterface)paramAppInterface, paramOnShowNoteListener, paramString);
  }
  
  public Class getHotChatSCMngClass()
  {
    return HotChatSCMng.class;
  }
  
  public IHotChatShare getHotChatShare(AppActivity paramAppActivity, AppInterface paramAppInterface, IHotChatInfo paramIHotChatInfo)
  {
    return new HotChatShare((BaseActivity)paramAppActivity, paramAppInterface, paramIHotChatInfo);
  }
  
  public MessageRecord getShareHotChatGrayTips()
  {
    return new ShareHotChatGrayTips();
  }
  
  public Class getShareHotChatGrayTipsClass()
  {
    return ShareHotChatGrayTips.class;
  }
  
  public void invokeRecentUserChangedToConversation(AppInterface paramAppInterface)
  {
    HotChatRecentUserMgr.a((QQAppInterface)paramAppInterface);
  }
  
  public String makeShareGrayTip(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return ShareHotChatGrayTips.makeShareGrayTip(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.impl.HotChatApiImpl
 * JD-Core Version:    0.7.0.1
 */