package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconProcessor;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.hiboom.FontBubbleManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class VasExtensionManager
  implements Manager
{
  public QQAppInterface a;
  public EmoticonFromGroupManager a;
  public VasEmojiManager a;
  public ColorScreenManager a;
  public FontBubbleManager a;
  public ProfileCardManager a;
  public ColorNickManager a;
  private VasExtensionManager.NetHandler a;
  public VasFaceManager a;
  public TroopKeywordManager a;
  
  public VasExtensionManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonVasEmojiManager = new VasEmojiManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager = new ColorScreenManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager = new EmoticonFromGroupManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager = new ProfileCardManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager = new ColorNickManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager = new FontBubbleManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasTroopkeywordTroopKeywordManager = new TroopKeywordManager(paramQQAppInterface, paramQQAppInterface.getEntityManagerFactory().createEntityManager());
    this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionManager$NetHandler = new VasExtensionManager.NetHandler();
    a(paramQQAppInterface);
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt & 0xF;
    String str = null;
    if (i == 1)
    {
      str = QQLevelIconProcessor.c().mNotifyPaymentText;
      if (TextUtils.isEmpty(str)) {
        break label112;
      }
      i = 0;
      switch (paramInt >> 4)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label112;
      }
      return str.replace("[vip]", BaseApplicationImpl.getContext().getResources().getString(paramInt));
      if (i != 2) {
        break;
      }
      str = QQLevelIconProcessor.c().mExpiredNotifyPaymentText;
      break;
      paramInt = 2131695146;
      continue;
      paramInt = 2131719674;
      continue;
      paramInt = 2131690708;
    }
    label112:
    return "";
  }
  
  public static boolean a()
  {
    if (TMSManager.a().a())
    {
      if (NetworkUtil.b(BaseApplicationImpl.getApplication()) == 0)
      {
        TMSManager.a().a(null, false);
        return true;
      }
      QLog.d("KC.TMSManager", 1, "can only query in mobile connection");
      return true;
    }
    QLog.d("KC.TMSManager", 1, "tms can not work");
    return false;
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 17: 
    case 33: 
      return "mvip.n.a.qlevel_cuifei";
    case 18: 
    case 34: 
      return "mvip.n.a.qlevel_guoqi";
    case 49: 
      return "jhan_qlevel_cuifei";
    }
    return "jhan_qlevel_guoqi";
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 17: 
    case 18: 
      return "LTMCLUB";
    case 33: 
    case 34: 
      return "CJCLUBT";
    }
    return "SVHHZLH";
  }
  
  public int a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).getInt("is_show_qq_level_notice", 0);
  }
  
  public void a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    QLog.e("QQLevelNotice", 1, "setShowQQLevelNoticeValue: " + paramInt + ", " + str);
    BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).edit().putInt("is_show_qq_level_notice", paramInt).commit();
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionManager$NetHandler);
      return;
    }
    catch (Error paramQQAppInterface) {}
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionManager$NetHandler);
    this.jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasTroopkeywordTroopKeywordManager.a();
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionManager
 * JD-Core Version:    0.7.0.1
 */