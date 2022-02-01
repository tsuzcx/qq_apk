package com.tencent.mobileqq.troop.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ITroopSPUtilApi
  extends QRouteApi
{
  public static final String KEY_ALBUM_MESSAGE = "troop_photo_message";
  public static final String KEY_ALBUM_NEW_PHOTOES = "troop_photo_new";
  public static final String KEY_FILE_NEW = "troop_file_new";
  public static final String KEY_GROUP_ACTIVITY_NEW = "group_activity_new_message";
  public static final String KEY_GROUP_FILE_INNER_REDDOT_TIM = "group_file_inner_reddot_tim";
  public static final String KEY_GROUP_FILE_REDDOT_TIM = "group_file_reddot_tim";
  public static final String KEY_GROUP_PAD_TEMPLATE_TIPS = "group_pad_template_tips";
  public static final String KEY_TROOP_LUCKY_CHARACTER_STATUS = "troop_lucky_character_status";
  public static final String KEY_TROOP_NOTIFICATION_NEW = "troop_notification_new";
  public static final String TROOP_NEWS_NOTIFY = "troop_news_notify";
  
  public abstract boolean getAIOTroopMiniAppEntranceRedPoint(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean getGroupTIMFileNewsInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract Object[] getKeyTroopLuckyCharacterStatus(String paramString1, String paramString2, String paramString3);
  
  public abstract int getTroopAioKeyWordVersion(Context paramContext, String paramString);
  
  public abstract boolean getTroopHasNewApp(AppRuntime paramAppRuntime, String paramString);
  
  public abstract int groupGroupNewsInfo(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean hasShowTroopGameCardRedPoint(String paramString1, String paramString2);
  
  public abstract boolean isShowTroopGameCardRedPoint(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void setAIOTroopMiniAppEntranceRedPoint(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
  
  public abstract void setGroupGroupNewsInfo(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void setGroupPadTemplateNewsInfoTips(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract void setGroupTIMFileNewsInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract void setTroopGameCardRedPoint(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void setTroopGameCardRedPointHasShowed(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void setTroopHasNewApp(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
  
  public abstract void updateTroopAioKeyWordVersion(Context paramContext, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi
 * JD-Core Version:    0.7.0.1
 */