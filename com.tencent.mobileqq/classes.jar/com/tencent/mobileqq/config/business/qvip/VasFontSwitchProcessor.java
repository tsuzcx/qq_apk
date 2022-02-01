package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class VasFontSwitchProcessor
  extends BaseQVipConfigProcessor<VasFontSwitchConfig>
{
  @NonNull
  public VasFontSwitchConfig a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FontManager.a();
    SharedPreUtils.a(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin(), "vas_font_switch_config", "reset");
    return new VasFontSwitchConfig();
  }
  
  @NonNull
  public VasFontSwitchConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FontManager.a(paramArrayOfQConfItem[0].a);
    SharedPreUtils.a(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin(), "vas_font_switch_config", paramArrayOfQConfItem[0].a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.VasFontSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */