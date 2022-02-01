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
  public IVasEmojiManager b;
  public VasFaceManager c;
  public IEmoticonFromGroupManager d;
  public ProfileCardManager e;
  public ColorNickManager f;
  public FontBubbleManager g;
  public TroopKeywordManager h;
  private VasExtensionManager.NetHandler i;
  
  public VasExtensionManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = ((IVasEmojiManagerService)QRoute.api(IVasEmojiManagerService.class)).createVasEmojiManager(paramQQAppInterface);
    this.c = new VasFaceManager(paramQQAppInterface);
    this.d = ((IEmoticonFromGroupManagerService)QRoute.api(IEmoticonFromGroupManagerService.class)).createEmoticonFromGroupManager(paramQQAppInterface);
    this.e = new ProfileCardManager(paramQQAppInterface);
    this.f = new ColorNickManager(paramQQAppInterface);
    this.g = new FontBubbleManager(paramQQAppInterface);
    this.h = new TroopKeywordManager(paramQQAppInterface, paramQQAppInterface.getEntityManagerFactory().createEntityManager());
    this.i = new VasExtensionManager.NetHandler();
    a(paramQQAppInterface);
  }
  
  public static boolean a()
  {
    if (TMSManager.a().c())
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
    int j = paramInt >> 4;
    paramInt &= 0xF;
    String str;
    if (paramInt == 1) {
      str = QQLevelIconProcessor.e().mNotifyPaymentText;
    } else if (paramInt == 2) {
      str = QQLevelIconProcessor.e().mExpiredNotifyPaymentText;
    } else {
      str = null;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramInt = 0;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            paramInt = 2131887547;
          }
        }
        else {
          paramInt = 2131916948;
        }
      }
      else {
        paramInt = 2131892864;
      }
      if (paramInt != 0) {
        return str.replace("[vip]", BaseApplicationImpl.getContext().getResources().getString(paramInt));
      }
    }
    return "";
  }
  
  public static String c(int paramInt)
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
  
  public static String d(int paramInt)
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
  
  public void a(int paramInt)
  {
    String str = this.a.getCurrentAccountUin();
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
      AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.i);
      return;
    }
    catch (Error paramQQAppInterface) {}
  }
  
  public int b()
  {
    String str = this.a.getCurrentAccountUin();
    return BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).getInt("is_show_qq_level_notice", 0);
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.i);
    this.c.onDestroy();
    this.h.b();
    this.f.onDestroy();
    this.g.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionManager
 * JD-Core Version:    0.7.0.1
 */