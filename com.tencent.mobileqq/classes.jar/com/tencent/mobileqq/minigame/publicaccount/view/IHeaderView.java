package com.tencent.mobileqq.minigame.publicaccount.view;

import android.app.Activity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;

public abstract interface IHeaderView
{
  public abstract String getAppName();
  
  public abstract void init(MessageRecord paramMessageRecord, Activity paramActivity);
  
  public abstract void init(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt, String paramString);
  
  public abstract void onDestory();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView
 * JD-Core Version:    0.7.0.1
 */