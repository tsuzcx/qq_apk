package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ExtendFriendSendMsgHelper
{
  private static volatile ExtendFriendSendMsgHelper jdField_a_of_type_ComTencentMobileqqQqexpandChatExtendFriendSendMsgHelper;
  private long jdField_a_of_type_Long;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private ISendMsgInterface jdField_a_of_type_ComTencentMobileqqQqexpandChatISendMsgInterface;
  ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExtendFriendSendMsgHelper.1(this);
  
  private ExtendFriendSendMsgHelper(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    }
  }
  
  public static ExtendFriendSendMsgHelper a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqQqexpandChatExtendFriendSendMsgHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQqexpandChatExtendFriendSendMsgHelper == null) {
          jdField_a_of_type_ComTencentMobileqqQqexpandChatExtendFriendSendMsgHelper = new ExtendFriendSendMsgHelper(paramBaseQQAppInterface);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQqexpandChatExtendFriendSendMsgHelper;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> mExtendFriendManager is null then return 0");
      }
      return "";
    }
    if (paramQQAppInterface.a() != null)
    {
      paramQQAppInterface = paramQQAppInterface.j();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSchoolName-> schoolName = ");
        localStringBuilder.append(paramQQAppInterface);
        QLog.d("ExtendFriendSendMsgHelper", 2, localStringBuilder.toString());
      }
      return paramQQAppInterface;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> has not school schoolName ");
    }
    return "";
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showMatchCountDialog() activity is null just return");
      return;
    }
    DialogUtil.a(paramActivity, 230).setMessage(paramActivity.getString(2131698894)).setPositiveButton(paramActivity.getString(2131698893), new ExtendFriendSendMsgHelper.2()).show();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "enterAio() context is null just return");
      return;
    }
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("entrance", 23);
    localIntent.putExtra("uintype", 1045);
    localIntent.putExtra("key_limitchat_enter_type", 2);
    localIntent.putExtras(new Bundle());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, MatchInfo paramMatchInfo)
  {
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).resetMatchChatAIOData(paramBaseQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString);
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).addTopicMessage(paramBaseQQAppInterface, paramMatchInfo, paramMatchInfo.jdField_a_of_type_Long, 2, paramInt);
    if (paramInt == 1045) {
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).addExtendFriendUserInfo(paramBaseQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_b_of_type_Int, paramMatchInfo.f, TextUtils.isEmpty(paramMatchInfo.c) ^ true, 1);
    } else {
      ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).addExtendFriendUserInfo(paramBaseQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString, paramMatchInfo.jdField_b_of_type_Int, paramMatchInfo.f, TextUtils.isEmpty(paramMatchInfo.c) ^ true, 3);
    }
    if (paramMatchInfo.jdField_b_of_type_Int >= 2)
    {
      paramBaseQQAppInterface = (IceBreakingMng)paramBaseQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
      paramBaseQQAppInterface.b(paramMatchInfo.jdField_b_of_type_JavaLangString);
      paramBaseQQAppInterface.d();
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((IExpandManager)paramBaseQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramString1, paramString2, paramInt);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (paramQBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showToast() activity is null just return");
      return;
    }
    QQToast.a(paramQBaseActivity, paramString, 0).b(paramQBaseActivity.getTitleBarHeight());
  }
  
  public static void a(QBaseActivity paramQBaseActivity, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (paramQBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialog() activity is null just return");
      return;
    }
    DialogUtil.a(paramQBaseActivity, 230).setMessage(paramQBaseActivity.getString(2131698892)).setNegativeButton(paramQBaseActivity.getString(2131698890), new ExtendFriendSendMsgHelper.4()).setPositiveButton(paramQBaseActivity.getString(2131698891), new ExtendFriendSendMsgHelper.3(paramBoolean, paramQBaseActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public void a()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
    if (localBaseQQAppInterface != null)
    {
      localBaseQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandChatISendMsgInterface = null;
    jdField_a_of_type_ComTencentMobileqqQqexpandChatExtendFriendSendMsgHelper = null;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = null;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, AllInOne paramAllInOne, ISendMsgInterface paramISendMsgInterface)
  {
    if (paramAllInOne != null)
    {
      String str1 = paramAllInOne.uin;
      String str2 = paramAllInOne.nickname;
      byte[] arrayOfByte = paramAllInOne.extendFriendVoiceCode;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, String.format("sendMsg uin=%s nickName=%s voiceCode=%s", new Object[] { str1, str2, arrayOfByte }));
      }
      a(paramBaseQQAppInterface, str1, str2, arrayOfByte, ExpandUserInfo.subIDToFromType(paramAllInOne.subSourceId), paramISendMsgInterface);
      int i = ExtendFriendReport.a();
      if ((i == 1) || (i == 2))
      {
        if (i == 1) {
          i = 2;
        } else {
          i = 4;
        }
        ExtendFriendReport.a().a(i, str1, "", ExtendFriendReport.a(), ExtendFriendReport.b(), ExtendFriendReport.c());
      }
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, ISendMsgInterface paramISendMsgInterface)
  {
    if ((paramBaseQQAppInterface != null) && (paramISendMsgInterface != null))
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg is fast Click");
        }
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandChatISendMsgInterface = paramISendMsgInterface;
      ((IExpandHandler)paramBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramBaseQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
      ThreadManager.getSubThreadHandler().post(new ExtendFriendSendMsgHelper.9(this, paramInt, paramString1));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("sendMsg appInterface = ");
      paramString1.append(paramBaseQQAppInterface);
      paramString1.append(" sendMsgInterface = ");
      paramString1.append(paramISendMsgInterface);
      QLog.d("ExtendFriendSendMsgHelper", 2, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper
 * JD-Core Version:    0.7.0.1
 */