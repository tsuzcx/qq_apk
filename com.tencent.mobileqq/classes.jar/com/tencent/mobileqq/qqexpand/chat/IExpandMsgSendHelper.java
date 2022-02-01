package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/IExpandMsgSendHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterAio", "", "context", "Landroid/content/Context;", "uin", "", "nickName", "getUnLimitMatchUserInfo", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "selfUin", "matchUin", "uinType", "", "handleUnLimitMatchUserInfo", "info", "Lcom/tencent/mobileqq/qqexpand/bean/match/MatchInfo;", "sendMsg", "appInterface", "allInOne", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "iSendMsgInterface", "Lcom/tencent/mobileqq/qqexpand/chat/ISendMsgInterface;", "sendMsgDirectly", "friendUin", "friendNickName", "code", "", "from", "sendMsgInterface", "showCampusVerifyDialog", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "hasWriteSchoolName", "", "idx", "schoolName", "schoolID", "showMatchCountDialog", "Landroid/app/Activity;", "showToast", "text", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandMsgSendHelper
  extends QRouteApi
{
  public abstract void enterAio(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void getUnLimitMatchUserInfo(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, @Nullable String paramString2, int paramInt);
  
  public abstract void handleUnLimitMatchUserInfo(@Nullable BaseQQAppInterface paramBaseQQAppInterface, int paramInt, @Nullable MatchInfo paramMatchInfo);
  
  public abstract void sendMsg(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable AllInOne paramAllInOne, @Nullable ISendMsgInterface paramISendMsgInterface);
  
  public abstract void sendMsgDirectly(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, @Nullable String paramString2, @Nullable byte[] paramArrayOfByte, int paramInt, @Nullable ISendMsgInterface paramISendMsgInterface);
  
  public abstract void showCampusVerifyDialog(@Nullable QBaseActivity paramQBaseActivity, boolean paramBoolean, int paramInt, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void showMatchCountDialog(@Nullable Activity paramActivity);
  
  public abstract void showToast(@Nullable QBaseActivity paramQBaseActivity, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper
 * JD-Core Version:    0.7.0.1
 */