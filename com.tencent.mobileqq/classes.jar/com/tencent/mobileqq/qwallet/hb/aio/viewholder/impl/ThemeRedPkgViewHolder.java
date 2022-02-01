package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
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
  int A = 0;
  ThemeRedPkgConfig y = null;
  int z = 0;
  
  public ThemeRedPkgViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    super(paramBaseQQAppInterface, paramBaseSessionInfo, paramIQWalletMsgHolder, paramQQWalletBaseMsgElem, paramInt, paramOnCustomizeListener);
    this.n = 0;
    this.A = paramQQWalletBaseMsgElem.z;
  }
  
  public void a()
  {
    super.a();
    if ((this.A > 1) && (this.p == null))
    {
      this.y = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getThemeRedPkgConfById(this.A);
      Object localObject = this.y;
      if ((localObject != null) && (!TextUtils.isEmpty(((ThemeRedPkgConfig)localObject).f)))
      {
        localObject = this.y.f;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_");
        ((StringBuilder)localObject).append(this.A);
        localObject = ((StringBuilder)localObject).toString();
      }
      RedPacketInfo localRedPacketInfo = new RedPacketInfo();
      localRedPacketInfo.a = this.b;
      int i;
      if (this.d.u == 1) {
        i = 4;
      } else {
        i = 1;
      }
      localRedPacketInfo.type = i;
      localRedPacketInfo.templateId = ((String)localObject);
      this.p = CustomizeStrategyFactory.d().a(this.f, localRedPacketInfo, this.u);
    }
    if (this.p != null)
    {
      if (this.p.animInfo != null)
      {
        this.z = 2;
        return;
      }
      if (this.p.background != null) {
        this.z = 1;
      }
    }
  }
  
  public void c()
  {
    if (this.z == 1)
    {
      j();
      return;
    }
    super.c();
  }
  
  public void e()
  {
    if (this.z > 0)
    {
      this.a.h().setVisibility(8);
      return;
    }
    super.e();
  }
  
  public boolean g()
  {
    this.a.c().setVisibility(0);
    ThemeRedPkgConfig localThemeRedPkgConfig = this.y;
    if ((localThemeRedPkgConfig != null) && (!TextUtils.isEmpty(localThemeRedPkgConfig.h)) && (!TextUtils.isEmpty(this.y.g)) && (!TextUtils.isEmpty(this.y.i))) {}
    try
    {
      int i = Color.parseColor(this.y.h);
      this.a.c().setTextColor(i);
      label82:
      this.a.c().setText(this.y.g);
      this.a.c().setTag(this.y.i);
      break label137;
      this.a.c().setText("主题红包");
      label137:
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label82;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.ThemeRedPkgViewHolder
 * JD-Core Version:    0.7.0.1
 */