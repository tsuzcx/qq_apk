package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VasFontSwitchProcessor
  extends BaseQVipConfigProcessor<VasFontSwitchConfig>
{
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.apply();
  }
  
  @NonNull
  public VasFontSwitchConfig a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    FontManagerConstants.resetFontSwitch();
    a(localAppRuntime.getApp(), localAppRuntime.getCurrentUin(), "vas_font_switch_config", "reset");
    return new VasFontSwitchConfig();
  }
  
  @NonNull
  public VasFontSwitchConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    FontManagerConstants.updateFontSwitch(paramArrayOfQConfItem[0].a);
    a(localAppRuntime.getApp(), localAppRuntime.getCurrentUin(), "vas_font_switch_config", paramArrayOfQConfItem[0].a);
    return new VasFontSwitchConfig();
  }
  
  @NonNull
  public VasFontSwitchConfig b()
  {
    return new VasFontSwitchConfig();
  }
  
  public Class<VasFontSwitchConfig> clazz()
  {
    return VasFontSwitchConfig.class;
  }
  
  public int type()
  {
    return 359;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.VasFontSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */