package com.tencent.mobileqq.profilecard.bussiness.anonymous.handler;

import com.tencent.mobileqq.app.BusinessObserver;

public class AnonymousObserver
  implements BusinessObserver
{
  public void onBrowseAskAnonymouslyReport(boolean paramBoolean) {}
  
  public void onGetLatestAnonymousInfo(boolean paramBoolean, Object paramObject) {}
  
  public void onLikeAnonymousAnswer(boolean paramBoolean) {}
  
  public void onReplyTroopAskAnonymously(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      onLikeAnonymousAnswer(paramBoolean);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        onBrowseAskAnonymouslyReport(paramBoolean);
        return;
      }
      if (paramInt == 3)
      {
        onGetLatestAnonymousInfo(paramBoolean, paramObject);
        return;
      }
    } while (paramInt != 4);
    onReplyTroopAskAnonymously(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver
 * JD-Core Version:    0.7.0.1
 */