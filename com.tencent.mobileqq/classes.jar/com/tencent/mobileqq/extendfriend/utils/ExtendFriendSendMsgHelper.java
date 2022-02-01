package com.tencent.mobileqq.extendfriend.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ExtendFriendSendMsgHelper
{
  private static volatile ExtendFriendSendMsgHelper jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendSendMsgHelper.1(this);
  private ExtendFriendSendMsgHelper.ISendMsgInterface jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper$ISendMsgInterface;
  
  private ExtendFriendSendMsgHelper(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    }
  }
  
  public static ExtendFriendSendMsgHelper a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper == null) {
        jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper = new ExtendFriendSendMsgHelper(paramQQAppInterface);
      }
      return jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper;
    }
    finally {}
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> mExtendFriendManager is null then return 0");
      }
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      if (paramQQAppInterface.a() == null) {
        break;
      }
      str = paramQQAppInterface.i();
      paramQQAppInterface = str;
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> schoolName = " + str);
    return str;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> has not school schoolName ");
    }
    return "";
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
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showMatchCountDialog() activity is null just return");
      return;
    }
    DialogUtil.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698818)).setPositiveButton(paramBaseActivity.getString(2131698817), new ExtendFriendSendMsgHelper.3()).show();
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showToast() activity is null just return");
      return;
    }
    QQToast.a(paramBaseActivity, paramString, 0).b(paramBaseActivity.getTitleBarHeight());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, MatchInfo paramMatchInfo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    LimitChatUtil.b(paramQQAppInterface, paramMatchInfo.jdField_b_of_type_JavaLangString);
    LimitChatUtil.a(paramQQAppInterface, paramMatchInfo, paramMatchInfo.jdField_a_of_type_Long, 2, paramInt);
    String str1;
    String str2;
    if (paramInt == 1045)
    {
      str1 = paramMatchInfo.jdField_b_of_type_JavaLangString;
      paramInt = paramMatchInfo.jdField_b_of_type_Int;
      str2 = paramMatchInfo.f;
      if (!TextUtils.isEmpty(paramMatchInfo.c)) {
        bool1 = true;
      }
      LimitChatUtil.a(paramQQAppInterface, str1, paramInt, str2, bool1, 1);
    }
    for (;;)
    {
      if (paramMatchInfo.jdField_b_of_type_Int >= 2)
      {
        paramQQAppInterface = (IceBreakingMng)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        paramQQAppInterface.b(paramMatchInfo.jdField_b_of_type_JavaLangString);
        paramQQAppInterface.d();
      }
      return;
      str1 = paramMatchInfo.jdField_b_of_type_JavaLangString;
      paramInt = paramMatchInfo.jdField_b_of_type_Int;
      str2 = paramMatchInfo.f;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMatchInfo.c)) {
        bool1 = true;
      }
      LimitChatUtil.a(paramQQAppInterface, str1, paramInt, str2, bool1, 3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramString1, paramString2, paramInt);
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialogForPublish() activity is null just return");
    }
    while (!a(paramBaseActivity.app)) {
      return false;
    }
    SchoolInfo localSchoolInfo = ((ExtendFriendManager)paramBaseActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    boolean bool = c(paramBaseActivity.app);
    DialogUtil.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131698769)).setNegativeButton(paramBaseActivity.getString(2131698814), new ExtendFriendSendMsgHelper.7()).setPositiveButton(paramBaseActivity.getString(2131698815), new ExtendFriendSendMsgHelper.6(paramBaseActivity, bool, localSchoolInfo)).show();
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogBySendMsg-> currentUin = " + paramQQAppInterface.getCurrentAccountUin());
    }
    if ((b(paramQQAppInterface)) && (!d(paramQQAppInterface))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogBySendMsg-> false ");
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> return " + paramQQAppInterface.c());
    }
    return paramQQAppInterface.c();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (!TextUtils.isEmpty(paramQQAppInterface.i()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> return true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> return false");
    }
    return false;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (paramQQAppInterface.f() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> return true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> return false");
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper$ISendMsgInterface = null;
    jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper = null;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, ExtendFriendSendMsgHelper.ISendMsgInterface paramISendMsgInterface)
  {
    String str1;
    if (paramAllInOne != null)
    {
      str1 = paramAllInOne.a;
      String str2 = paramAllInOne.h;
      byte[] arrayOfByte = paramAllInOne.c;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, String.format("sendMsg uin=%s nickName=%s voiceCode=%s", new Object[] { str1, str2, arrayOfByte }));
      }
      a(paramQQAppInterface, str1, str2, arrayOfByte, ExtendFriendUserInfo.subIDToFromType(paramAllInOne.l), paramISendMsgInterface);
      i = ExtendFriendReport.a();
      if ((i == 1) || (i == 2)) {
        if (i != 1) {
          break label126;
        }
      }
    }
    label126:
    for (int i = 2;; i = 4)
    {
      ExtendFriendReport.a().a(i, str1, "", ExtendFriendReport.a(), ExtendFriendReport.b(), ExtendFriendReport.c());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, ExtendFriendSendMsgHelper.ISendMsgInterface paramISendMsgInterface)
  {
    if ((paramQQAppInterface == null) || (paramISendMsgInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + paramQQAppInterface + " sendMsgInterface = " + paramISendMsgInterface);
      }
    }
    do
    {
      return;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg is fast Click");
    return;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendSendMsgHelper$ISendMsgInterface = paramISendMsgInterface;
    ((ExtendFriendHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSendMsgHelper.2(this, paramInt, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper
 * JD-Core Version:    0.7.0.1
 */