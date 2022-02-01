package com.tencent.mobileqq.subaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface ISubAccountControllUtil
  extends QRouteApi
{
  public abstract void bindRecentItem(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void bindRecentItem(AppInterface paramAppInterface, ArrayList<String> paramArrayList, int paramInt);
  
  public abstract Pair<Boolean, Boolean> checkSubAccountLoginStatus(AppInterface paramAppInterface, String paramString);
  
  public abstract void cleanAllSubAccountMessageUnread(AppInterface paramAppInterface, boolean paramBoolean, String paramString);
  
  public abstract boolean cleanAllThirdQQUnreadMsgNum(AppInterface paramAppInterface);
  
  public abstract void cleanOneSubAccountMessageUnread(AppInterface paramAppInterface, boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void cleanReqSubAccountSpecialCareListSysTime(AppInterface paramAppInterface);
  
  public abstract boolean cleanThirdQQUnreadMsgNum(AppInterface paramAppInterface, SimpleAccount paramSimpleAccount);
  
  public abstract void clearAllData(AppInterface paramAppInterface, String paramString);
  
  public abstract int getAllSubAccountMsgUnreadNum(AppInterface paramAppInterface, IConversationFacade paramIConversationFacade);
  
  public abstract int getAllSubAccountTroopMsgUnreadNum(AppInterface paramAppInterface, IConversationFacade paramIConversationFacade);
  
  public abstract int getAllThirdQQMsgUnreadLastTime(AppInterface paramAppInterface);
  
  public abstract int getLocalThirdUnreadMsgNum(AppInterface paramAppInterface, String paramString);
  
  public abstract String getShowName(AppInterface paramAppInterface, SimpleAccount paramSimpleAccount);
  
  public abstract void getSubAccountSpecialCareListFromService(AppInterface paramAppInterface, boolean paramBoolean, String paramString);
  
  public abstract ISubAccountControlService.SubAccountUnReadItem getUnreadCount(AppInterface paramAppInterface, String paramString);
  
  public abstract void initAllData(AppInterface paramAppInterface);
  
  public abstract boolean isAnyAccountBind(AppInterface paramAppInterface);
  
  public abstract boolean isHeadIconLongClickFunc(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract boolean isThirdAccountDisplayFunc(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract boolean loadServerMessage(AppInterface paramAppInterface, String paramString, boolean paramBoolean);
  
  public abstract boolean needShowHintDialog(AppInterface paramAppInterface, String paramString);
  
  public abstract void onTimeFormatChange(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportSubAccountBoxExposure(AppInterface paramAppInterface);
  
  public abstract void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, String paramString);
  
  public abstract void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, ArrayList<String> paramArrayList);
  
  public abstract void setDisplayThirdQQChecked(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void setRecentItemSubAccountContentAndUnread(AppInterface paramAppInterface, Context paramContext, RecentItemSubAccount paramRecentItemSubAccount, MsgSummary paramMsgSummary);
  
  public abstract void setTopInRecentList(AppInterface paramAppInterface, String paramString, boolean paramBoolean);
  
  public abstract void showMaxHintDialog(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity);
  
  public abstract boolean startGetThirdQQUnreadNum(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void unbindAllRecentItem(AppInterface paramAppInterface, int paramInt);
  
  public abstract void unbindRecentItem(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean updateAllThirdQQMsgUnreadLastTime(AppInterface paramAppInterface, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil
 * JD-Core Version:    0.7.0.1
 */