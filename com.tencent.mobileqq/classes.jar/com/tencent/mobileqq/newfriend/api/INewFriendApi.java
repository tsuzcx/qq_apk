package com.tencent.mobileqq.newfriend.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;

@QAPI(process={"all"})
public abstract interface INewFriendApi
  extends QRouteApi
{
  public abstract void clearStructMsgMap();
  
  public abstract void clearSystemMsgData();
  
  public abstract long getCurrStructMsgKey();
  
  public abstract long getCurrentUniseq();
  
  public abstract Intent getNewFriendJumpIntent(Context paramContext);
  
  public abstract String getNewFriendTag();
  
  public abstract long getOldestSysMsgTime(AppInterface paramAppInterface);
  
  public abstract Intent getStartNewFriendMoreSysMsgActivityIntent(Context paramContext, int paramInt);
  
  public abstract structmsg.StructMsg getStructMsgFromMap(Long paramLong);
  
  public abstract boolean getSysMsgOverValue(AppInterface paramAppInterface);
  
  public abstract int getUiBuilderExposeCnt();
  
  public abstract int getUnReadFriendSystemMsgNum(AppInterface paramAppInterface);
  
  public abstract boolean isHasNoMoreMsg(AppInterface paramAppInterface);
  
  public abstract boolean isSuspiciousSysMsg(MessageRecord paramMessageRecord);
  
  public abstract void jumpToNewFriendVerifyListAct(Activity paramActivity);
  
  public abstract NewFriendContactGuideConfBean loadNewFriendContactGuideConfig();
  
  public abstract void logMsg(String paramString, List<? extends MessageRecord> paramList);
  
  public abstract boolean openProfileCard(AppRuntime paramAppRuntime, Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void openProfileCardNeedTrackBack(Context paramContext, String paramString);
  
  public abstract void putStructMsgToMap(Long paramLong, structmsg.StructMsg paramStructMsg);
  
  public abstract void report(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void setCurrStructMsgKey(long paramLong);
  
  public abstract void setCurrentUniseq(long paramLong);
  
  public abstract void setFromSysSubMsgType(int paramInt);
  
  public abstract void setHasNoMoreMsg(boolean paramBoolean, AppInterface paramAppInterface);
  
  public abstract void setOldestSysMsgTime(AppInterface paramAppInterface, long paramLong);
  
  public abstract void setSysMsgOverValue(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void setUiBuilderExposeCnt(int paramInt);
  
  public abstract void setUnReadFriendSystemMsgNum(AppInterface paramAppInterface, int paramInt);
  
  public abstract boolean shouldMergeNewFriendContact(AppInterface paramAppInterface, String paramString);
  
  public abstract void showGenderAge(TextView paramTextView, int paramInt1, int paramInt2, StringBuilder paramStringBuilder);
  
  public abstract void startActivity(Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract void startNewFriendMoreSysMsgActivityForResult(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void updateItemBg(View paramView, boolean paramBoolean);
  
  public abstract void updateItemBgKeepPadding(View paramView, boolean paramBoolean);
  
  public abstract void updateItemViewHeightForList(View paramView, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.INewFriendApi
 * JD-Core Version:    0.7.0.1
 */