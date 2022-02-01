package com.tencent.mobileqq.qassistant.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QAssistantTempApiImpl
  implements IQAssistantTempApi
{
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public boolean checkIsSupportJump(Context paramContext, String paramString)
  {
    paramContext = getAppInterface();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        if (paramString.equalsIgnoreCase("ecchat"))
        {
          int i = SharedPreUtils.a(paramContext.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
          paramContext = (IExpandManager)paramContext.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
          return (i == 1) && (paramContext.x());
        }
        bool1 = bool2;
        if (paramString.equalsIgnoreCase("confessmsg"))
        {
          if (((ConfessManager)paramContext.getManager(QQManagerFactory.CONFESS_MANAGER)).a() != null) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void configWebItemCloseDrawer()
  {
    if (FrameHelperActivity.G())
    {
      if (QLog.isColorLevel()) {
        QLog.d("WakeManager", 2, "QAssistantConfigMainItem isDrawerFrameOpenOrMoving");
      }
      FrameHelperActivity.c(true);
      FrameHelperActivity.H();
    }
  }
  
  public String configWebItemJumpUrl(String paramString)
  {
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      if (paramString.equalsIgnoreCase("qqgame")) {
        return IndividuationUrlHelper.a("vipGameCenter");
      }
      if (paramString.equalsIgnoreCase("confessmsg"))
      {
        paramString = ((ConfessManager)localQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).d();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.s))) {
          return paramString.s;
        }
        return "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
      }
      if (paramString.equalsIgnoreCase("qinterest"))
      {
        paramString = SharedPreUtils.af(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin());
        if (!TextUtils.isEmpty(paramString)) {
          return paramString.trim();
        }
        return LebaConstant.a;
      }
    }
    return "";
  }
  
  public JumpAction createJumpAction(Context paramContext)
  {
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface != null) {
      return new JumpActionLegacy(localQQAppInterface, paramContext);
    }
    return null;
  }
  
  public void extendJumpIntentExtra1(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.putInt("tab_index", FrameControllerUtil.a);
      paramBundle.putInt("fragment_id", 1);
    }
  }
  
  public void extendJumpIntentExtra2(Bundle paramBundle, String paramString)
  {
    if ((paramString != null) && (paramString.equals("contact"))) {
      paramBundle.putInt("tab_index", FrameControllerUtil.c);
    } else if ((paramString != null) && (paramString.equals("leba"))) {
      paramBundle.putInt("tab_index", FrameControllerUtil.d);
    } else {
      paramBundle.putInt("tab_index", FrameControllerUtil.a);
    }
    paramBundle.putInt("fragment_id", 1);
  }
  
  public int getChatFragmentCurrentType()
  {
    return ChatFragment.a().c.ah.a;
  }
  
  public String getIpcConstants_ACTION_VOICE_RECORD_OFF()
  {
    return "tencent.avgame.notify.voice.record.off";
  }
  
  public String getIpcConstants_ACTION_VOICE_RECORD_ON()
  {
    return "tencent.avgame.notify.voice.record.on";
  }
  
  public String getMainFragmentClassName()
  {
    return MainFragment.class.getName();
  }
  
  public int getMainFragmentCurrentTab()
  {
    return MainFragment.a().w();
  }
  
  public boolean isSpecialCareFriend(String paramString)
  {
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface == null) {
      return false;
    }
    paramString = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).y(paramString);
    return (paramString != null) && (paramString.globalSwitch == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.impl.QAssistantTempApiImpl
 * JD-Core Version:    0.7.0.1
 */