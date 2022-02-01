package com.tencent.mobileqq.subaccount.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService.SubAccountUnReadItem;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class SubAccountControllUtilImpl
  implements ISubAccountControllUtil
{
  public void bindRecentItem(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    SubAccountControllUtil.a(paramAppInterface, paramString, paramInt);
  }
  
  public void bindRecentItem(AppInterface paramAppInterface, ArrayList<String> paramArrayList, int paramInt)
  {
    SubAccountControllUtil.a(paramAppInterface, paramArrayList, paramInt);
  }
  
  public Pair<Boolean, Boolean> checkSubAccountLoginStatus(AppInterface paramAppInterface, String paramString)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString);
  }
  
  public void cleanAllSubAccountMessageUnread(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    SubAccountControllUtil.a(paramAppInterface, paramBoolean, paramString);
  }
  
  public boolean cleanAllThirdQQUnreadMsgNum(AppInterface paramAppInterface)
  {
    return SubAccountControllUtil.c(paramAppInterface);
  }
  
  public void cleanOneSubAccountMessageUnread(AppInterface paramAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    SubAccountControllUtil.a(paramAppInterface, paramBoolean, paramString1, paramString2);
  }
  
  public void cleanReqSubAccountSpecialCareListSysTime(AppInterface paramAppInterface)
  {
    SubAccountControllUtil.b(paramAppInterface);
  }
  
  public boolean cleanThirdQQUnreadMsgNum(AppInterface paramAppInterface, SimpleAccount paramSimpleAccount)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramSimpleAccount);
  }
  
  public void clearAllData(AppInterface paramAppInterface, String paramString)
  {
    SubAccountControllUtil.a(paramAppInterface, paramString);
  }
  
  public int getAllSubAccountMsgUnreadNum(AppInterface paramAppInterface, IConversationFacade paramIConversationFacade)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramIConversationFacade);
  }
  
  public int getAllSubAccountTroopMsgUnreadNum(AppInterface paramAppInterface, IConversationFacade paramIConversationFacade)
  {
    return SubAccountControllUtil.b(paramAppInterface, paramIConversationFacade);
  }
  
  public int getAllThirdQQMsgUnreadLastTime(AppInterface paramAppInterface)
  {
    return SubAccountControllUtil.a(paramAppInterface);
  }
  
  public int getLocalThirdUnreadMsgNum(AppInterface paramAppInterface, String paramString)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString);
  }
  
  public String getShowName(AppInterface paramAppInterface, SimpleAccount paramSimpleAccount)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramSimpleAccount);
  }
  
  public void getSubAccountSpecialCareListFromService(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    SubAccountControllUtil.b(paramAppInterface, paramBoolean, paramString);
  }
  
  public ISubAccountControlService.SubAccountUnReadItem getUnreadCount(AppInterface paramAppInterface, String paramString)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString);
  }
  
  public void initAllData(AppInterface paramAppInterface)
  {
    SubAccountControllUtil.a(paramAppInterface);
  }
  
  public boolean isAnyAccountBind(AppInterface paramAppInterface)
  {
    return SubAccountControllUtil.b(paramAppInterface);
  }
  
  public boolean isHeadIconLongClickFunc(AppInterface paramAppInterface, boolean paramBoolean)
  {
    return SubAccountControllUtil.c(paramAppInterface, paramBoolean);
  }
  
  public boolean isThirdAccountDisplayFunc(AppInterface paramAppInterface, boolean paramBoolean)
  {
    return SubAccountControllUtil.b(paramAppInterface, paramBoolean);
  }
  
  public boolean loadServerMessage(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString, paramBoolean);
  }
  
  public boolean needShowHintDialog(AppInterface paramAppInterface, String paramString)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramString);
  }
  
  public void onTimeFormatChange(AppInterface paramAppInterface, String paramString)
  {
    SubAccountControllUtil.b(paramAppInterface, paramString);
  }
  
  public void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, String paramString)
  {
    SubAccountControllUtil.a(paramAppInterface, paramByte, paramString);
  }
  
  public void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, ArrayList<String> paramArrayList)
  {
    SubAccountControllUtil.a(paramAppInterface, paramByte, paramArrayList);
  }
  
  public void setDisplayThirdQQChecked(AppInterface paramAppInterface, boolean paramBoolean)
  {
    SubAccountControllUtil.a(paramAppInterface, paramBoolean);
  }
  
  public void setRecentItemSubAccountContentAndUnread(AppInterface paramAppInterface, Context paramContext, RecentItemSubAccount paramRecentItemSubAccount, MsgSummary paramMsgSummary)
  {
    SubAccountControllUtil.a(paramAppInterface, paramContext, paramRecentItemSubAccount, paramMsgSummary);
  }
  
  public void setTopInRecentList(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    SubAccountControllUtil.a(paramAppInterface, paramString, paramBoolean);
  }
  
  public void showMaxHintDialog(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    SubAccountControllUtil.a(paramAppRuntime, paramQBaseActivity);
  }
  
  public boolean startGetThirdQQUnreadNum(AppInterface paramAppInterface, boolean paramBoolean)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramBoolean);
  }
  
  public void unbindAllRecentItem(AppInterface paramAppInterface, int paramInt)
  {
    SubAccountControllUtil.a(paramAppInterface, paramInt);
  }
  
  public void unbindRecentItem(AppInterface paramAppInterface, String paramString)
  {
    SubAccountControllUtil.c(paramAppInterface, paramString);
  }
  
  public boolean updateAllThirdQQMsgUnreadLastTime(AppInterface paramAppInterface, int paramInt)
  {
    return SubAccountControllUtil.a(paramAppInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountControllUtilImpl
 * JD-Core Version:    0.7.0.1
 */