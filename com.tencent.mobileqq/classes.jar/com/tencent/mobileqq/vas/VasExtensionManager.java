package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.IVasEmojiManager;
import com.tencent.mobileqq.emoticon.api.IEmoticonFromGroupManagerService;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.hiboom.FontBubbleManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QQLevelIconProcessor;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class VasExtensionManager
  implements Manager
{
  public QQAppInterface a;
  public IEmoticonFromGroupManager a;
  public IVasEmojiManager a;
  public FontBubbleManager a;
  public ProfileCardManager a;
  public ColorNickManager a;
  private VasExtensionManager.NetHandler a;
  public VasFaceManager a;
  public TroopKeywordManager a;
  
  public VasExtensionManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonIVasEmojiManager = ((IVasEmojiManagerService)QRoute.api(IVasEmojiManagerService.class)).createVasEmojiManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager = ((IEmoticonFromGroupManagerService)QRoute.api(IEmoticonFromGroupManagerService.class)).createEmoticonFromGroupManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager = new ProfileCardManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager = new ColorNickManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager = new FontBubbleManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasTroopkeywordTroopKeywordManager = new TroopKeywordManager(paramQQAppInterface, paramQQAppInterface.getEntityManagerFactory().createEntityManager());
    this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionManager$NetHandler = new VasExtensionManager.NetHandler();
    a(paramQQAppInterface);
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt >> 4;
    paramInt &= 0xF;
    String str;
    if (paramInt == 1) {
      str = QQLevelIconProcessor.c().mNotifyPaymentText;
    } else if (paramInt == 2) {
      str = QQLevelIconProcessor.c().mExpiredNotifyPaymentText;
    } else {
      str = null;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramInt = 0;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            paramInt = 2131690636;
          }
        }
        else {
          paramInt = 2131719393;
        }
      }
      else {
        paramInt = 2131695136;
      }
      if (paramInt != 0) {
        return str.replace("[vip]", BaseApplicationImpl.getContext().getResources().getString(paramInt));
      }
    }
    return "";
  }
  
  public static boolean a()
  {
    if (TMSManager.a().a())
    {
      if (NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 0)
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
    if (paramInt != 17)
    {
      if (paramInt != 18)
      {
        if (paramInt == 33) {
          break label48;
        }
        if (paramInt != 34)
        {
          if (paramInt != 49)
          {
            if (paramInt != 50) {
              return "";
            }
            return "jhan_qlevel_guoqi";
          }
          return "jhan_qlevel_cuifei";
        }
      }
      return "mvip.n.a.qlevel_guoqi";
    }
    label48:
    return "mvip.n.a.qlevel_cuifei";
  }
  
  public static String c(int paramInt)
  {
    if ((paramInt != 17) && (paramInt != 18))
    {
      if ((paramInt != 33) && (paramInt != 34))
      {
        if ((paramInt != 49) && (paramInt != 50)) {
          return "";
        }
        return "SVHHZLH";
      }
      return "CJCLUBT";
    }
    return "LTMCLUB";
  }
  
  public int a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).getInt("is_show_qq_level_notice", 0);
  }
  
  public void a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setShowQQLevelNoticeValue: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(str);
    QLog.e("QQLevelNotice", 1, localStringBuilder.toString());
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
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasTroopkeywordTroopKeywordManager.a();
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionManager
 * JD-Core Version:    0.7.0.1
 */