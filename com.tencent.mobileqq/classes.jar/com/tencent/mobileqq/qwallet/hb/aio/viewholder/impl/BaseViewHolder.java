package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qwallet.temp.IQWalletMsgHolder;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.ScrollPlayer;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory.OnCustomizeListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.aio.viewholder.IFBaseViewHolder;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class BaseViewHolder
  implements IFBaseViewHolder
{
  public IQWalletMsgHolder a;
  public MessageForQQWalletMsg b = null;
  public QQWalletRedPacketMsg c = null;
  public QQWalletBaseMsgElem d = null;
  protected Context e;
  protected BaseQQAppInterface f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected RedPacketInfo p;
  protected RedPacketInfo q;
  protected int r = R.drawable.M;
  protected int s;
  protected boolean t = false;
  protected ICustomizeStrategyFactory.OnCustomizeListener u;
  protected long v = DeviceInfoUtil.D();
  boolean w;
  protected BaseSessionInfo x;
  
  public BaseViewHolder(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    this.f = paramBaseQQAppInterface;
    this.a = paramIQWalletMsgHolder;
    this.e = paramIQWalletMsgHolder.b().getContext();
    this.d = paramQQWalletBaseMsgElem;
    this.b = paramIQWalletMsgHolder.a();
    this.c = this.b.mQQWalletRedPacketMsg;
    this.s = paramInt;
    this.x = paramBaseSessionInfo;
    this.u = paramOnCustomizeListener;
    float f1 = this.e.getResources().getDisplayMetrics().density;
    this.g = ((int)(160.0F * f1 + 0.5F));
    this.h = ((int)(240.0F * f1 + 0.5F));
    this.i = ((int)(90.0F * f1 + 0.5F));
    this.j = ((int)(17.0F * f1 + 0.5F));
    this.k = ((int)(40.0F * f1 + 0.5F));
    this.m = ((int)(f1 * 24.0F + 0.5F));
    this.l = (this.g - this.j);
    this.n = paramQQWalletBaseMsgElem.v;
    this.o = paramQQWalletBaseMsgElem.w;
    this.w = l();
    if (this.w) {
      this.o = 0;
    }
    this.t = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isRiskSwitchOpen();
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("isRedPacketOpened=");
      paramBaseQQAppInterface.append(this.w);
      paramBaseQQAppInterface.append(",isRiskWritchOpen=");
      paramBaseQQAppInterface.append(this.t);
      paramBaseQQAppInterface.append(",skinId=");
      paramBaseQQAppInterface.append(this.n);
      paramBaseQQAppInterface.append(",effectsId=");
      paramBaseQQAppInterface.append(this.o);
      paramBaseQQAppInterface.append(",elem=");
      paramBaseQQAppInterface.append(paramQQWalletBaseMsgElem);
      paramBaseQQAppInterface.append(",qqWalletMsg=");
      paramBaseQQAppInterface.append(this.b);
      QLog.d("BaseViewHolder", 2, paramBaseQQAppInterface.toString());
    }
  }
  
  public void a()
  {
    if (this.t)
    {
      this.n = 0;
      this.o = 0;
      return;
    }
    RedPacketInfo localRedPacketInfo;
    if (this.n > 0)
    {
      localRedPacketInfo = new RedPacketInfo();
      MessageForQQWalletMsg localMessageForQQWalletMsg = this.b;
      localRedPacketInfo.a = localMessageForQQWalletMsg;
      localRedPacketInfo.type = 5;
      localRedPacketInfo.skinId = this.n;
      localRedPacketInfo.skinType = 1;
      localRedPacketInfo.isHideTitle = localMessageForQQWalletMsg.getIsHideTitleDefault();
      this.p = CustomizeStrategyFactory.d().a(this.f, localRedPacketInfo, this.u);
    }
    if ((this.o > 0) && (this.v > 720L))
    {
      localRedPacketInfo = new RedPacketInfo();
      localRedPacketInfo.b = System.currentTimeMillis();
      localRedPacketInfo.a = this.b;
      localRedPacketInfo.type = 5;
      localRedPacketInfo.bigAnimId = this.o;
      localRedPacketInfo.skinType = 3;
      this.q = CustomizeStrategyFactory.d().a(this.f, localRedPacketInfo, this.u);
    }
  }
  
  protected boolean a(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    if (this.b != null)
    {
      if (this.c == null) {
        return true;
      }
      if (paramPasswdRedBagInfo == null) {
        return false;
      }
      if (paramPasswdRedBagInfo.f) {
        return true;
      }
      return (this.b.istroop == 1) && (NotifyMsgApiImpl.queryNotifyMsgRecord(2, paramPasswdRedBagInfo.a, this.b) != null);
    }
    return true;
  }
  
  public void b()
  {
    Object localObject1 = this.a;
    if (localObject1 != null) {
      if (((IQWalletMsgHolder)localObject1).d() == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = (RelativeLayout.LayoutParams)this.a.d().getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = this.g;
        ((RelativeLayout.LayoutParams)localObject1).height = this.h;
        Object localObject3 = this.a.d().getChildAt(0);
        localObject1 = MobileQQ.getContext().getResources().getDrawable(R.drawable.E);
        long l1 = 0L;
        localObject2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQWalletMsgItemBuilder$mlastReportMap();
        boolean bool = localObject3 instanceof RoundImageView;
        long l2;
        StringBuilder localStringBuilder;
        if (bool)
        {
          localObject3 = (RoundImageView)localObject3;
          if ((this.p != null) && (this.p.background != null))
          {
            ((RoundImageView)localObject3).setmRadius(0, false);
            ((RoundImageView)localObject3).setImageDrawable(QWalletPicHelper.getDrawableForAIO(this.p.background, (Drawable)localObject1));
            l2 = l1;
            if (localObject2 != null)
            {
              l2 = l1;
              if (!((Map)localObject2).isEmpty())
              {
                l2 = l1;
                if (((Map)localObject2).containsKey(Integer.valueOf(this.n))) {
                  l2 = ((Long)((Map)localObject2).get(Integer.valueOf(this.n))).longValue();
                }
              }
            }
            if ((NetConnInfoCenter.getServerTimeMillis() - l2 > 500L) && (this.n > 0) && ((this.b.messageType == 2) || (this.b.messageType == 3)))
            {
              if (this.b.istroop != 10014) {
                break label756;
              }
              localObject1 = "2";
              localObject3 = this.f;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(this.n);
              ReportController.b((AppRuntime)localObject3, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.show", 0, 0, localStringBuilder.toString(), (String)localObject1, "", "");
              if (localObject2 != null) {
                ((Map)localObject2).put(this.b, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
              }
            }
          }
          else
          {
            if (Build.VERSION.SDK_INT >= 18) {
              ((RoundImageView)localObject3).setmRadius(DisplayUtil.a(this.e, 4.0F), false);
            }
            ((RoundImageView)localObject3).setImageDrawable((Drawable)localObject1);
          }
        }
        else if ((this.p != null) && (this.p.background != null))
        {
          localObject1 = QWalletPicHelper.getDrawableForAIO(this.p.background, (Drawable)localObject1);
          if (Build.VERSION.SDK_INT < 16) {
            this.a.d().setBackgroundDrawable((Drawable)localObject1);
          } else {
            this.a.d().setBackground((Drawable)localObject1);
          }
          l2 = l1;
          if (localObject2 != null)
          {
            l2 = l1;
            if (!((Map)localObject2).isEmpty())
            {
              l2 = l1;
              if (((Map)localObject2).containsKey(Integer.valueOf(this.n))) {
                l2 = ((Long)((Map)localObject2).get(this.b)).longValue();
              }
            }
          }
          if ((NetConnInfoCenter.getServerTimeMillis() - l2 > 500L) && (this.n > 0) && ((this.b.messageType == 2) || (this.b.messageType == 3)))
          {
            if (this.b.istroop != 10014) {
              break label764;
            }
            localObject1 = "2";
            localObject3 = this.f;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(this.n);
            ReportController.b((AppRuntime)localObject3, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.show", 0, 0, localStringBuilder.toString(), (String)localObject1, "", "");
            if (localObject2 != null) {
              ((Map)localObject2).put(this.b, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
            }
          }
        }
        else
        {
          this.a.d().setBackgroundResource(R.drawable.E);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleBackgroud throw exception: ");
          ((StringBuilder)localObject2).append(localThrowable.getLocalizedMessage());
          QLog.e("BaseViewHolder", 1, ((StringBuilder)localObject2).toString());
        }
      }
      return;
      label756:
      String str = "1";
      continue;
      label764:
      str = "1";
    }
  }
  
  public void c()
  {
    j();
    if (!k())
    {
      int i1 = this.k;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i1, i1);
      localLayoutParams.gravity = 17;
      ImageView localImageView = new ImageView(this.e);
      localImageView.setImageResource(this.r);
      this.a.f().addView(localImageView, localLayoutParams);
    }
  }
  
  public void d()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.a;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.g() == null) {
        return;
      }
      this.a.g().setVisibility(8);
    }
  }
  
  public void e()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((IQWalletMsgHolder)localObject).h() == null) {
        return;
      }
      this.a.h().setVisibility(0);
      localObject = this.d;
      if ((localObject != null) && (!TextUtils.isEmpty(((QQWalletBaseMsgElem)localObject).c)))
      {
        localObject = this.p;
        if ((localObject != null) && (((RedPacketInfo)localObject).isHideTitle == 1) && (!this.t))
        {
          this.a.h().setText("");
          return;
        }
        int i2 = StringUtil.getWordCount(this.d.c);
        int i1 = 18;
        if (i2 <= 8)
        {
          i2 = this.l / 4;
          int i3 = this.m;
          i1 = i2;
          if (i2 > i3) {
            i1 = i3;
          }
          i1 = DisplayUtil.b(this.e, i1);
        }
        this.a.h().setTextSize(i1);
        this.a.h().setText(this.d.c);
        return;
      }
      this.a.h().setText("");
    }
  }
  
  public void f()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((IQWalletMsgHolder)localObject).k() != null))
    {
      if (this.a.l() == null) {
        return;
      }
      this.a.k().stop();
      this.a.l().stop();
      if (this.a.i() != null) {
        this.a.i().setVisibility(8);
      }
      this.a.k().setVisibility(8);
      this.a.l().setVisibility(8);
      localObject = this.a.k().getPlayer();
      if ((localObject instanceof ScrollPlayer)) {
        ((ScrollPlayer)localObject).a(this.a.k());
      }
      localObject = this.a.l().getPlayer();
      if ((localObject instanceof ScrollPlayer)) {
        ((ScrollPlayer)localObject).a(this.a.l());
      }
      localObject = this.p;
      if ((localObject != null) && (((RedPacketInfo)localObject).animInfo != null))
      {
        this.a.k().setVisibility(0);
        this.a.k().setAnimationFromInfo(this.p.animInfo);
        this.a.k().play();
      }
      localObject = this.q;
      if ((localObject != null) && (((RedPacketInfo)localObject).specailBackgroundAnimInfo != null))
      {
        this.a.l().setVisibility(0);
        this.a.l().setAnimationFromInfo(this.q.specailBackgroundAnimInfo);
        this.a.l().play();
      }
    }
  }
  
  public boolean g()
  {
    Object localObject1 = this.a;
    String str;
    Object localObject2;
    if (localObject1 != null)
    {
      if (((IQWalletMsgHolder)localObject1).c() == null) {
        return false;
      }
      this.a.c().setVisibility(0);
      localObject1 = this.x;
      if ((localObject1 != null) && (((BaseSessionInfo)localObject1).a != 10014)) {
        this.a.c().setTextColor(-8947849);
      } else {
        this.a.c().setTextColor(-6710887);
      }
      localObject1 = this.a.c();
      str = null;
      ((TextView)localObject1).setTag(null);
      if (!this.t)
      {
        localObject1 = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getTail(this.n, this.b.messageType);
        if (localObject1 != null)
        {
          str = ((JSONObject)localObject1).optString("word", "");
          localObject2 = ((JSONObject)localObject1).optString("color", "");
          localObject1 = ((JSONObject)localObject1).optString("url", "");
        }
        else
        {
          localObject1 = null;
          localObject2 = localObject1;
        }
        if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
      }
    }
    try
    {
      i1 = Color.parseColor((String)localObject2);
      if ((this.x != null) && (this.x.a != 10014)) {
        this.a.c().setTextColor(i1);
      } else {
        this.a.c().setTextColor(-6710887);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      int i1;
      label255:
      break label255;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.a.c().setTag(localObject1);
    }
    this.a.c().setText(str);
    i1 = 1;
    break label295;
    i1 = 0;
    label295:
    if (i1 != 0) {
      return true;
    }
    this.a.c().setText("QQ红包");
    return false;
  }
  
  public void h()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.a;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.j() == null) {
        return;
      }
      if (this.a.j().getChildCount() != 0) {
        this.a.j().removeAllViews();
      }
    }
  }
  
  public void i()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.a;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.e() == null) {
        return;
      }
      if (!l())
      {
        this.a.e().setVisibility(8);
        return;
      }
      this.a.e().setVisibility(0);
    }
  }
  
  protected void j()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.a;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.f() == null) {
        return;
      }
      this.a.f().setVisibility(0);
      ((RelativeLayout.LayoutParams)this.a.f().getLayoutParams()).topMargin = this.k;
      if (this.a.f().getChildCount() != 0) {
        this.a.f().removeAllViews();
      }
    }
  }
  
  protected boolean k()
  {
    Object localObject = this.p;
    if ((localObject != null) && (((RedPacketInfo)localObject).icon != null))
    {
      int i1 = this.k;
      localObject = new LinearLayout.LayoutParams(i1, i1);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      ImageView localImageView = new ImageView(this.e);
      localImageView.setImageBitmap(this.p.icon);
      this.a.f().addView(localImageView, (ViewGroup.LayoutParams)localObject);
      return true;
    }
    return false;
  }
  
  protected boolean l()
  {
    if (this.b != null)
    {
      QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.c;
      if (localQQWalletRedPacketMsg == null) {
        return true;
      }
      if (localQQWalletRedPacketMsg.isOpened) {
        return true;
      }
      return (this.b.istroop == 1) && (NotifyMsgApiImpl.queryNotifyMsgRecord(2, this.c.redPacketId, this.b) != null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */