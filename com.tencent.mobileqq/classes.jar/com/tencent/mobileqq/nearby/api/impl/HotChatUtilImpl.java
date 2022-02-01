package com.tencent.mobileqq.nearby.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.nearby.api.HotChatUtil;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.service.message.MessageCacheItem;

public class HotChatUtilImpl
  implements IHotChatUtil
{
  public void addLocalMaxMsgSeq(MessageCacheItem paramMessageCacheItem, long paramLong, String paramString, int paramInt)
  {
    HotChatUtil.a(paramMessageCacheItem, paramLong, paramString, paramInt);
  }
  
  public boolean checkIsHCRecentUser(Object paramObject, RecentUser paramRecentUser)
  {
    return HotChatUtil.a((QQAppInterface)paramObject, paramRecentUser);
  }
  
  public Drawable getHotChatRoleBgDrawable(Resources paramResources, int paramInt)
  {
    return HotChatUtil.a(paramResources, paramInt);
  }
  
  public String getJoinHotChatFailTip(int paramInt)
  {
    return HotChatUtil.a(paramInt);
  }
  
  public boolean isHotChatMsg(int paramInt, String paramString)
  {
    return HotChatUtil.a(paramInt, paramString);
  }
  
  public boolean isHotChatMsg(MessageRecord paramMessageRecord)
  {
    return HotChatUtil.a(paramMessageRecord);
  }
  
  public boolean isSeatOccupied(int paramInt)
  {
    return HotChatUtil.a(paramInt);
  }
  
  public void openHotChatMemberProfileCard(Context paramContext, Object paramObject, String paramString1, String paramString2)
  {
    HotChatUtil.a(paramContext, (QQAppInterface)paramObject, paramString1, paramString2);
  }
  
  public void setHotChatRoleBg(TextView paramTextView, int paramInt)
  {
    HotChatUtil.a(paramTextView, paramInt);
  }
  
  public void setReadedForHCTopic(Object paramObject, String paramString)
  {
    HotChatUtil.a((QQAppInterface)paramObject, paramString);
  }
  
  public void startTroopMemberChooseForFlowerActivity(Object paramObject1, Object paramObject2, Activity paramActivity, int paramInt)
  {
    HotChatUtil.a((HotChatInfo)paramObject1, (QQAppInterface)paramObject2, paramActivity, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.HotChatUtilImpl
 * JD-Core Version:    0.7.0.1
 */