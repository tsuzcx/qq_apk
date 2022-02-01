package com.tencent.mobileqq.profilecard.bussiness.anonymous.handler;

import com.tencent.mobileqq.app.BusinessObserver;

public class AnonymousObserver
  implements BusinessObserver
{
  protected static final int NOTIFY_BROWSE_ASK_ANONYMOUSLY_REPORT = 2;
  protected static final int NOTIFY_GET_LATEST_ANONYMOUS_INFO = 3;
  protected static final int NOTIFY_LIKE_ANONYMOUS_ANSWER = 1;
  protected static final int NOTIFY_REPLY_TROOP_ASK_ANONYMOUSLY = 4;
  public static final int TYPE_ANONYMOUS_SETTING_ME_RED_POINT = 5;
  
  private void onUpdate_onAnonymousSettingMeRedPoint(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 5) {
      return;
    }
    boolean bool = false;
    if ((paramObject instanceof Boolean)) {
      bool = ((Boolean)paramObject).booleanValue();
    }
    onAnonymousSettingMeRedPoint(paramBoolean, bool);
  }
  
  public void onAnonymousSettingMeRedPoint(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onBrowseAskAnonymouslyReport(boolean paramBoolean) {}
  
  public void onGetLatestAnonymousInfo(boolean paramBoolean, Object paramObject) {}
  
  public void onLikeAnonymousAnswer(boolean paramBoolean) {}
  
  public void onReplyTroopAskAnonymously(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      onLikeAnonymousAnswer(paramBoolean);
    } else if (paramInt == 2) {
      onBrowseAskAnonymouslyReport(paramBoolean);
    } else if (paramInt == 3) {
      onGetLatestAnonymousInfo(paramBoolean, paramObject);
    } else if (paramInt == 4) {
      onReplyTroopAskAnonymously(paramBoolean, paramObject);
    }
    onUpdate_onAnonymousSettingMeRedPoint(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver
 * JD-Core Version:    0.7.0.1
 */