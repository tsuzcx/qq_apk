package com.tencent.mobileqq.minigame.publicaccount.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfBean;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfProcessor;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAApiProvider;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MiniGamePublicAccountApiImpl
  implements IMiniGamePublicAccountApi
{
  private static final String TAG = "MiniGamePublicAccountApiImpl";
  
  private boolean hasUnReadMsg()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    boolean bool = false;
    if (localAppRuntime == null) {
      return false;
    }
    if (((IConversationFacade)localAppRuntime.getRuntimeService(IConversationFacade.class, "")).getUnreadCount("1983141935", 1008) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean canPreloadHippy()
  {
    MiniGamePAConfBean localMiniGamePAConfBean = MiniGamePAConfProcessor.loadConfig();
    boolean bool1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isFollowUin((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), "1983141935");
    boolean bool2 = hasUnReadMsg();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canPreloadHippy enable=");
      localStringBuilder.append(localMiniGamePAConfBean.getEnable());
      localStringBuilder.append(" isFollowPA=");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" hasUnReadMsg=");
      localStringBuilder.append(bool2);
      QLog.d("MiniGamePublicAccountApiImpl", 2, localStringBuilder.toString());
    }
    return (localMiniGamePAConfBean.getEnable() == 1) && (bool1) && (bool2);
  }
  
  public HippyAPIProvider createHippyProvider()
  {
    return new MiniGamePAApiProvider();
  }
  
  public Class<? extends QPublicBaseFragment> getMiniGamePAHippyClass()
  {
    return MiniGamePAHippyFragment.class;
  }
  
  public boolean hasNewMessage()
  {
    boolean bool = hasUnReadMsg();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasNewMessage hasNewMsg=");
      localStringBuilder.append(bool);
      QLog.d("MiniGamePublicAccountApiImpl", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean isMiniGamePAModule(String paramString)
  {
    return TextUtils.equals(paramString, "qqMiniGame");
  }
  
  public boolean isUseHippy()
  {
    return MiniGamePublicAccountHelper.isOpenHippy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.api.impl.MiniGamePublicAccountApiImpl
 * JD-Core Version:    0.7.0.1
 */