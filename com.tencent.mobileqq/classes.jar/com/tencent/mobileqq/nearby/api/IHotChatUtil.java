package com.tencent.mobileqq.nearby.api;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.MessageCacheItem;

@QAPI(process={"all"})
public abstract interface IHotChatUtil
  extends QRouteApi
{
  public static final int ROLE_ADMIN = 1;
  public static final int ROLE_OWNER = 0;
  public static final String TAG_ADD_ADMIN_RESULT = "ADD_ADMIN_RESULT";
  public static final String TAG_CREATE_TYPE = "HC_CREATE_TYPE";
  public static final String TAG_HC_MEMBER_ACTION = "HC_MEMBER_ACTION";
  public static final String TAG_HC_MEMBER_SEATID = "HC_MEMBER_SEATID";
  public static final String TAG_PTT_SHOW = "PttShow";
  public static final String TAG_SEL_MEMBER_RESULT = "SEL_MEMBER_UIN";
  public static final int USER_DEFAULT = 0;
  public static final int USER_GUEST = 2;
  public static final int USER_ROOM_OWNER = 1;
  
  public abstract void addLocalMaxMsgSeq(MessageCacheItem paramMessageCacheItem, long paramLong, String paramString, int paramInt);
  
  public abstract boolean checkIsHCRecentUser(Object paramObject, RecentUser paramRecentUser);
  
  public abstract Drawable getHotChatRoleBgDrawable(Resources paramResources, int paramInt);
  
  public abstract String getJoinHotChatFailTip(int paramInt);
  
  public abstract boolean isHotChatMsg(int paramInt, String paramString);
  
  public abstract boolean isHotChatMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isSeatOccupied(int paramInt);
  
  public abstract void openHotChatMemberProfileCard(Context paramContext, Object paramObject, String paramString1, String paramString2);
  
  public abstract void setHotChatRoleBg(TextView paramTextView, int paramInt);
  
  public abstract void setReadedForHCTopic(Object paramObject, String paramString);
  
  public abstract void startTroopMemberChooseForFlowerActivity(Object paramObject1, Object paramObject2, Activity paramActivity, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.IHotChatUtil
 * JD-Core Version:    0.7.0.1
 */