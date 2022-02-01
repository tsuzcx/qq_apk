package com.tencent.mobileqq.qqexpand.chat.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qqexpand.chat.ISendMsgInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/impl/ExpandMsgSendHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IExpandMsgSendHelper;", "()V", "enterAio", "", "context", "Landroid/content/Context;", "uin", "", "nickName", "getUnLimitMatchUserInfo", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "selfUin", "matchUin", "uinType", "", "handleUnLimitMatchUserInfo", "info", "Lcom/tencent/mobileqq/qqexpand/bean/match/MatchInfo;", "sendMsg", "appInterface", "allInOne", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "iSendMsgInterface", "Lcom/tencent/mobileqq/qqexpand/chat/ISendMsgInterface;", "sendMsgDirectly", "friendUin", "friendNickName", "code", "", "from", "sendMsgInterface", "showCampusVerifyDialog", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "hasWriteSchoolName", "", "idx", "schoolName", "schoolID", "showMatchCountDialog", "Landroid/app/Activity;", "showToast", "text", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandMsgSendHelperImpl
  implements IExpandMsgSendHelper
{
  public void enterAio(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2)
  {
    ExtendFriendSendMsgHelper.a(paramContext, paramString1, paramString2);
  }
  
  public void getUnLimitMatchUserInfo(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    ExtendFriendSendMsgHelper.a(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public void handleUnLimitMatchUserInfo(@Nullable BaseQQAppInterface paramBaseQQAppInterface, int paramInt, @Nullable MatchInfo paramMatchInfo)
  {
    ExtendFriendSendMsgHelper.a(paramBaseQQAppInterface, paramInt, paramMatchInfo);
  }
  
  public void sendMsg(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable AllInOne paramAllInOne, @Nullable ISendMsgInterface paramISendMsgInterface)
  {
    ExtendFriendSendMsgHelper.a(paramBaseQQAppInterface).a(paramBaseQQAppInterface, paramAllInOne, paramISendMsgInterface);
  }
  
  public void sendMsgDirectly(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable byte[] paramArrayOfByte, int paramInt, @Nullable ISendMsgInterface paramISendMsgInterface)
  {
    ExtendFriendSendMsgHelper.a(paramBaseQQAppInterface).a(paramBaseQQAppInterface, paramString1, paramString2, paramArrayOfByte, paramInt, paramISendMsgInterface);
  }
  
  public void showCampusVerifyDialog(@Nullable QBaseActivity paramQBaseActivity, boolean paramBoolean, int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    ExtendFriendSendMsgHelper.a(paramQBaseActivity, paramBoolean, paramInt, paramString1, paramString2);
  }
  
  public void showMatchCountDialog(@Nullable Activity paramActivity)
  {
    ExtendFriendSendMsgHelper.a(paramActivity);
  }
  
  public void showToast(@Nullable QBaseActivity paramQBaseActivity, @Nullable String paramString)
  {
    ExtendFriendSendMsgHelper.a(paramQBaseActivity, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.impl.ExpandMsgSendHelperImpl
 * JD-Core Version:    0.7.0.1
 */