package com.tencent.mobileqq.emosm.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IEmotionSearchManagerService
  extends IRuntimeService
{
  public static final String EMOTION_SEARCH_REQUEST_KEYWORDS = "EmoSearch_reqKeywords";
  public static final String EMOTION_SEARCH_REQUEST_TYPE = "EmoSearch_reqType";
  public static final String IS_FROM_EMOTION_SEARCH = "isFrom_EmoSearch";
  public static final int REQUEST_COUNT = 16;
  
  public abstract IEmotionSearchManagerService.IEmotionSearchCallBack getSearchCallBack();
  
  public abstract void handleResonpse(Intent paramIntent, FromServiceMsg paramFromServiceMsg);
  
  public abstract void loadMore();
  
  public abstract void pushEmotionSearchTask(IEmotionSearchManagerService.EmotionSearchTask paramEmotionSearchTask);
  
  public abstract void reportEmoSearchCatchUseMonitor(boolean paramBoolean);
  
  public abstract void reportEmoSearchMonitor(int paramInt1, int paramInt2, String paramString);
  
  public abstract void resetData();
  
  public abstract void setSearchCallBack(IEmotionSearchManagerService.IEmotionSearchCallBack paramIEmotionSearchCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService
 * JD-Core Version:    0.7.0.1
 */