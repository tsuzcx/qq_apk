package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQBaseServiceImpl
  implements IQQBaseService
{
  private static final String TAG = "QQBaseServiceImpl";
  private ConditionSearchManager mSearchManager;
  
  public void attachConditionSearchManager()
  {
    if (this.mSearchManager == null)
    {
      AppRuntime localAppRuntime = MobileQQ.getMobileQQ().peekAppRuntime();
      if (localAppRuntime == null) {
        return;
      }
      this.mSearchManager = ((ConditionSearchManager)localAppRuntime.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
      this.mSearchManager.a(this);
    }
  }
  
  public int checkSupportMediaCodecFeature()
  {
    return ShortVideoCodec.checkSupportMediaCodecFeature(MobileQQ.sMobileQQ.getApplicationContext());
  }
  
  public String decodeRemoteCode(long paramLong)
  {
    return ProfileCodecUtils.decodeRemoteCode(paramLong);
  }
  
  public void detachConditionSearchManager()
  {
    ConditionSearchManager localConditionSearchManager = this.mSearchManager;
    if (localConditionSearchManager != null)
    {
      localConditionSearchManager.b(this);
      this.mSearchManager = null;
    }
  }
  
  public int encodeLocCode(String paramString)
  {
    return ProfileCodecUtils.encodeLocCode(paramString);
  }
  
  public IEmoticonMainPanelApp getEmotionImpl()
  {
    return ((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
  
  public Class getQCircleHippyFragmentClass()
  {
    return QCircleHippyFragment.class;
  }
  
  public Intent handleQCircleHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void openBottomTabSwitchActivity()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    try
    {
      Intent localIntent1 = new Intent(BaseActivity.sTopActivity, QQSettingSettingActivity.class);
      Intent localIntent2 = new Intent();
      localIntent2.setClass(BaseActivity.sTopActivity, PublicFragmentActivity.class);
      localIntent2.putExtra("public_fragment_class", AssistantSettingFragment.class.getName());
      localIntent2.addFlags(268435456);
      BaseActivity.sTopActivity.startActivities(new Intent[] { localIntent1, localIntent2 });
      localIntent1 = new Intent();
      localIntent1.addFlags(268435456);
      localIntent1.putExtra("KEY_ENTRANCE", "VALUE_QQ_SETTING_FRAGMENT");
      QPublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), localIntent1, QPublicFragmentActivity.class, BottomTabSettingFragment.class);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void openLocationSelectActivity(Context paramContext, Bundle paramBundle)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, LocationSelectActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramBundle = this.mSearchManager;
    if (paramBundle != null)
    {
      int i = paramBundle.d();
      if (i != 0)
      {
        i = this.mSearchManager.a(i, true);
        paramBundle = new StringBuilder();
        paramBundle.append("startLocationSelectActivity | update result = ");
        paramBundle.append(i);
        QLog.d("QQBaseServiceImpl", 1, paramBundle.toString());
      }
    }
    paramContext.startActivity(localIntent);
  }
  
  public void setNewSsoAndRestartApp(String paramString)
  {
    EnvSwitchActivity.buildTestEnvironment(paramString, "-1");
    ConfigManager.saveCustomEnv("", "", "-1");
    Toast.makeText(BaseApplicationImpl.getContext(), "Release版本不生效，请安装Debug版本！", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QQBaseServiceImpl
 * JD-Core Version:    0.7.0.1
 */