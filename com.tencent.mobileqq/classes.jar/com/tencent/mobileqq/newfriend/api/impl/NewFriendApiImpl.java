package com.tencent.mobileqq.newfriend.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfProcessor;
import com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController;
import com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity;
import com.tencent.mobileqq.newfriend.ui.activity.NewFriendMoreSysMsgActivity;
import com.tencent.mobileqq.newfriend.ui.builder.NewFriendBaseBuilder;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.newfriend.utils.SystemMessageHelper;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class NewFriendApiImpl
  implements INewFriendApi
{
  public void clearStructMsgMap()
  {
    FriendSystemMsgController.a().b();
  }
  
  public void clearSystemMsgData()
  {
    FriendSystemMsgController.a().a();
  }
  
  public long getCurrStructMsgKey()
  {
    return FriendSystemMsgController.a().b();
  }
  
  public long getCurrentUniseq()
  {
    return FriendSystemMsgController.a().a();
  }
  
  public Intent getNewFriendJumpIntent(Context paramContext)
  {
    return new Intent(paramContext, NewFriendActivity.class);
  }
  
  public String getNewFriendTag()
  {
    return NewFriendServiceImpl.NEW_FRIEND_TAG;
  }
  
  public long getOldestSysMsgTime(AppInterface paramAppInterface)
  {
    return FriendSystemMsgController.a().a(paramAppInterface);
  }
  
  public Intent getStartNewFriendMoreSysMsgActivityIntent(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, NewFriendMoreSysMsgActivity.class);
    paramContext.putExtra("first_visible_index", paramInt);
    return paramContext;
  }
  
  public structmsg.StructMsg getStructMsgFromMap(Long paramLong)
  {
    return FriendSystemMsgController.a().a(paramLong);
  }
  
  public boolean getSysMsgOverValue(AppInterface paramAppInterface)
  {
    return FriendSystemMsgController.a().b(paramAppInterface);
  }
  
  public int getUiBuilderExposeCnt()
  {
    return NewFriendVerificationServiceImpl.getUiBuilderExposeCnt();
  }
  
  public int getUnReadFriendSystemMsgNum(AppInterface paramAppInterface)
  {
    return FriendSystemMsgController.a().a(paramAppInterface);
  }
  
  public boolean isHasNoMoreMsg(AppInterface paramAppInterface)
  {
    return FriendSystemMsgController.a().a(paramAppInterface);
  }
  
  public boolean isSuspiciousSysMsg(MessageRecord paramMessageRecord)
  {
    return NewFriendServiceImpl.isSuspiciousSysMsg(paramMessageRecord);
  }
  
  public void jumpToNewFriendVerifyListAct(Activity paramActivity)
  {
    NewFriendUtil.a(paramActivity);
  }
  
  public NewFriendContactGuideConfBean loadNewFriendContactGuideConfig()
  {
    return NewFriendContactGuideConfProcessor.a();
  }
  
  public void logMsg(String paramString, List<? extends MessageRecord> paramList)
  {
    NewFriendServiceImpl.logMsg(paramString, paramList);
  }
  
  public boolean openProfileCard(AppRuntime paramAppRuntime, Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent)
  {
    return SystemMessageHelper.a(paramAppRuntime, paramContext, paramString, paramLong, paramInt1, paramInt2, paramIntent);
  }
  
  public void openProfileCardNeedTrackBack(Context paramContext, String paramString)
  {
    SystemMessageHelper.a(paramContext, paramString);
  }
  
  public void putStructMsgToMap(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    FriendSystemMsgController.a().a(paramLong, paramStructMsg);
  }
  
  public void report(AppRuntime paramAppRuntime, String paramString)
  {
    NewFriendActivity.a(paramAppRuntime, paramString);
  }
  
  public void setCurrStructMsgKey(long paramLong)
  {
    FriendSystemMsgController.a().b(paramLong);
  }
  
  public void setCurrentUniseq(long paramLong)
  {
    FriendSystemMsgController.a().a(paramLong);
  }
  
  public void setFromSysSubMsgType(int paramInt)
  {
    NewFriendActivity.a(paramInt);
  }
  
  public void setHasNoMoreMsg(boolean paramBoolean, AppInterface paramAppInterface)
  {
    FriendSystemMsgController.a().a(paramBoolean, paramAppInterface);
  }
  
  public void setOldestSysMsgTime(AppInterface paramAppInterface, long paramLong)
  {
    FriendSystemMsgController.a().a(paramAppInterface, paramLong);
  }
  
  public void setSysMsgOverValue(AppInterface paramAppInterface, boolean paramBoolean)
  {
    FriendSystemMsgController.a().a(paramAppInterface, paramBoolean);
  }
  
  public void setUiBuilderExposeCnt(int paramInt)
  {
    NewFriendVerificationServiceImpl.setUiBuilderExposeCnt(paramInt);
  }
  
  public void setUnReadFriendSystemMsgNum(AppInterface paramAppInterface, int paramInt)
  {
    FriendSystemMsgController.a().a(paramAppInterface, paramInt);
  }
  
  public boolean shouldMergeNewFriendContact(AppInterface paramAppInterface, String paramString)
  {
    return NewFriendServiceImpl.shouldMergeNewFriendContact(paramAppInterface, paramString);
  }
  
  public void showGenderAge(TextView paramTextView, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    NewFriendUtil.a(paramTextView, paramInt1, paramInt2, paramStringBuilder);
  }
  
  public void startActivity(Context paramContext, Intent paramIntent, int paramInt)
  {
    NewFriendActivity.a(paramContext, paramIntent, paramInt);
  }
  
  public void startNewFriendMoreSysMsgActivityForResult(Activity paramActivity, int paramInt1, int paramInt2)
  {
    NewFriendMoreSysMsgActivity.a(paramActivity, paramInt1, paramInt2);
  }
  
  public void updateItemBg(View paramView, boolean paramBoolean)
  {
    NewFriendUtil.a(paramView, paramBoolean);
  }
  
  public void updateItemBgKeepPadding(View paramView, boolean paramBoolean)
  {
    NewFriendBaseBuilder.a(paramView, paramBoolean);
  }
  
  public void updateItemViewHeightForList(View paramView, int paramInt)
  {
    NewFriendBaseBuilder.b(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendApiImpl
 * JD-Core Version:    0.7.0.1
 */