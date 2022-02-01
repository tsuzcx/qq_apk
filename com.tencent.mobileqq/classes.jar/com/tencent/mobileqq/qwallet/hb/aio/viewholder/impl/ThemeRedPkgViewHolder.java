package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.theme.ThemeRedPkgConfig;

public class ThemeRedPkgViewHolder
  extends BaseViewHolder
{
  ThemeRedPkgConfig a;
  int l = 0;
  int m = 0;
  
  public ThemeRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig = null;
    this.h = 0;
    this.m = paramQQWalletBaseMsgElem.l;
  }
  
  public void a()
  {
    super.a();
    if ((this.m > 1) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getThemeRedPkgConfById(this.m);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig;
      if ((localObject != null) && (!TextUtils.isEmpty(((ThemeRedPkgConfig)localObject).c)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.c;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_");
        ((StringBuilder)localObject).append(this.m);
        localObject = ((StringBuilder)localObject).toString();
      }
      RedPacketInfo localRedPacketInfo = new RedPacketInfo();
      localRedPacketInfo.a = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.h == 1) {
        i = 4;
      } else {
        i = 1;
      }
      localRedPacketInfo.type = i;
      localRedPacketInfo.templateId = ((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.animInfo != null)
      {
        this.l = 2;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.background != null) {
        this.l = 1;
      }
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
    ThemeRedPkgConfig localThemeRedPkgConfig = this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig;
    if ((localThemeRedPkgConfig != null) && (!TextUtils.isEmpty(localThemeRedPkgConfig.e)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.f))) {}
    try
    {
      int i = Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.e);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(i);
      label96:
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText(this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.d);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTag(this.jdField_a_of_type_ComTencentMobileqqQwalletHbThemeThemeRedPkgConfig.f);
      break label151;
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("主题红包");
      label151:
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label96;
    }
  }
  
  public void c()
  {
    if (this.l == 1)
    {
      i();
      return;
    }
    super.c();
  }
  
  public void e()
  {
    if (this.l > 0)
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(8);
      return;
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.ThemeRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */