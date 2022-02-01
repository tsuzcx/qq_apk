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
  protected int a;
  protected long a;
  protected Context a;
  public IQWalletMsgHolder a;
  protected BaseQQAppInterface a;
  public MessageForQQWalletMsg a;
  public QQWalletRedPacketMsg a;
  public QQWalletBaseMsgElem a;
  protected ICustomizeStrategyFactory.OnCustomizeListener a;
  protected RedPacketInfo a;
  protected boolean a;
  protected int b;
  protected RedPacketInfo b;
  boolean b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j = R.drawable.M;
  protected int k;
  
  public BaseViewHolder(BaseQQAppInterface paramBaseQQAppInterface, IQWalletMsgHolder paramIQWalletMsgHolder, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, ICustomizeStrategyFactory.OnCustomizeListener paramOnCustomizeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = null;
    this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg = null;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = DeviceInfoUtil.i();
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder = paramIQWalletMsgHolder;
    this.jdField_a_of_type_AndroidContentContext = paramIQWalletMsgHolder.a().getContext();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem = paramQQWalletBaseMsgElem;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = paramIQWalletMsgHolder.a();
    this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    this.k = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener = paramOnCustomizeListener;
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(160.0F * f1 + 0.5F));
    this.jdField_b_of_type_Int = ((int)(240.0F * f1 + 0.5F));
    this.c = ((int)(90.0F * f1 + 0.5F));
    this.d = ((int)(17.0F * f1 + 0.5F));
    this.e = ((int)(40.0F * f1 + 0.5F));
    this.g = ((int)(f1 * 24.0F + 0.5F));
    this.f = (this.jdField_a_of_type_Int - this.d);
    this.h = paramQQWalletBaseMsgElem.i;
    this.i = paramQQWalletBaseMsgElem.j;
    this.jdField_b_of_type_Boolean = c();
    if (this.jdField_b_of_type_Boolean) {
      this.i = 0;
    }
    this.jdField_a_of_type_Boolean = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isRiskSwitchOpen();
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("isRedPacketOpened=");
      paramBaseQQAppInterface.append(this.jdField_b_of_type_Boolean);
      paramBaseQQAppInterface.append(",isRiskWritchOpen=");
      paramBaseQQAppInterface.append(this.jdField_a_of_type_Boolean);
      paramBaseQQAppInterface.append(",skinId=");
      paramBaseQQAppInterface.append(this.h);
      paramBaseQQAppInterface.append(",effectsId=");
      paramBaseQQAppInterface.append(this.i);
      paramBaseQQAppInterface.append(",elem=");
      paramBaseQQAppInterface.append(paramQQWalletBaseMsgElem);
      paramBaseQQAppInterface.append(",qqWalletMsg=");
      paramBaseQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      QLog.d("BaseViewHolder", 2, paramBaseQQAppInterface.toString());
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.h = 0;
      this.i = 0;
      return;
    }
    RedPacketInfo localRedPacketInfo;
    if (this.h > 0)
    {
      localRedPacketInfo = new RedPacketInfo();
      MessageForQQWalletMsg localMessageForQQWalletMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
      localRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localMessageForQQWalletMsg;
      localRedPacketInfo.type = 5;
      localRedPacketInfo.skinId = this.h;
      localRedPacketInfo.skinType = 1;
      localRedPacketInfo.isHideTitle = localMessageForQQWalletMsg.getIsHideTitleDefault();
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener);
    }
    if ((this.i > 0) && (this.jdField_a_of_type_Long > 720L))
    {
      localRedPacketInfo = new RedPacketInfo();
      localRedPacketInfo.jdField_a_of_type_Long = System.currentTimeMillis();
      localRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
      localRedPacketInfo.type = 5;
      localRedPacketInfo.bigAnimId = this.i;
      localRedPacketInfo.skinType = 3;
      this.jdField_b_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$OnCustomizeListener);
    }
  }
  
  public boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    String str;
    Object localObject2;
    if (localObject1 != null)
    {
      if (((IQWalletMsgHolder)localObject1).a() == null) {
        return false;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(-8947849);
      localObject1 = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a();
      str = null;
      ((TextView)localObject1).setTag(null);
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject1 = ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getTail(this.h, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType);
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
      m = Color.parseColor((String)localObject2);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTextColor(m);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      int m;
      label179:
      break label179;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setTag(localObject1);
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText(str);
    m = 1;
    break label219;
    m = 0;
    label219:
    if (m != 0) {
      return true;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setText("QQ红包");
    return false;
  }
  
  protected boolean a(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg == null) {
        return true;
      }
      if (paramPasswdRedBagInfo == null) {
        return false;
      }
      if (paramPasswdRedBagInfo.jdField_a_of_type_Boolean) {
        return true;
      }
      return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop == 1) && (NotifyMsgApiImpl.queryNotifyMsgRecord(2, paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg) != null);
    }
    return true;
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    if (localObject1 != null)
    {
      if (((IQWalletMsgHolder)localObject1).b() == null) {
        return;
      }
      try
      {
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = this.jdField_a_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject1).height = this.jdField_b_of_type_Int;
        Object localObject3 = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().getChildAt(0);
        localObject2 = MobileQQ.getContext().getResources().getDrawable(R.drawable.E);
        long l1 = 0L;
        localObject1 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QQWalletMsgItemBuilder$mlastReportMap();
        boolean bool = localObject3 instanceof RoundImageView;
        long l2;
        if (bool)
        {
          localObject3 = (RoundImageView)localObject3;
          if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.background != null))
          {
            ((RoundImageView)localObject3).setmRadius(0, false);
            ((RoundImageView)localObject3).setImageDrawable(QWalletPicHelper.getDrawableForAIO(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.background, (Drawable)localObject2));
            l2 = l1;
            if (localObject1 != null)
            {
              l2 = l1;
              if (!((Map)localObject1).isEmpty())
              {
                l2 = l1;
                if (((Map)localObject1).containsKey(Integer.valueOf(this.h))) {
                  l2 = ((Long)((Map)localObject1).get(Integer.valueOf(this.h))).longValue();
                }
              }
            }
            if ((NetConnInfoCenter.getServerTimeMillis() - l2 > 500L) && (this.h > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType == 3)))
            {
              localObject2 = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("");
              ((StringBuilder)localObject3).append(this.h);
              ReportController.b((AppRuntime)localObject2, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.show", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
              if (localObject1 != null) {
                ((Map)localObject1).put(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
              }
            }
          }
          else
          {
            if (Build.VERSION.SDK_INT >= 18) {
              ((RoundImageView)localObject3).setmRadius(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), false);
            }
            ((RoundImageView)localObject3).setImageDrawable((Drawable)localObject2);
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.background != null))
        {
          localObject2 = QWalletPicHelper.getDrawableForAIO(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.background, (Drawable)localObject2);
          if (Build.VERSION.SDK_INT < 16) {
            this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setBackgroundDrawable((Drawable)localObject2);
          } else {
            this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setBackground((Drawable)localObject2);
          }
          l2 = l1;
          if (localObject1 != null)
          {
            l2 = l1;
            if (!((Map)localObject1).isEmpty())
            {
              l2 = l1;
              if (((Map)localObject1).containsKey(Integer.valueOf(this.h))) {
                l2 = ((Long)((Map)localObject1).get(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg)).longValue();
              }
            }
          }
          if ((NetConnInfoCenter.getServerTimeMillis() - l2 > 500L) && (this.h > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType == 2) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType == 3)))
          {
            localObject2 = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(this.h);
            ReportController.b((AppRuntime)localObject2, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aio.show", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
            if (localObject1 != null) {
              ((Map)localObject1).put(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setBackgroundResource(R.drawable.E);
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
    }
  }
  
  protected boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo;
    if ((localObject != null) && (((RedPacketInfo)localObject).icon != null))
    {
      int m = this.e;
      localObject = new LinearLayout.LayoutParams(m, m);
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.icon);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().addView(localImageView, (ViewGroup.LayoutParams)localObject);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    i();
    if (!b())
    {
      int m = this.e;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
      localLayoutParams.gravity = 17;
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setImageResource(this.j);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().addView(localImageView, localLayoutParams);
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null)
    {
      QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg;
      if (localQQWalletRedPacketMsg == null) {
        return true;
      }
      if (localQQWalletRedPacketMsg.isOpened) {
        return true;
      }
      return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop == 1) && (NotifyMsgApiImpl.queryNotifyMsgRecord(2, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg) != null);
    }
    return true;
  }
  
  public void d()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.b() == null) {
        return;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setVisibility(8);
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    if (localObject != null)
    {
      if (((IQWalletMsgHolder)localObject).c() == null) {
        return;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem;
      if ((localObject != null) && (!TextUtils.isEmpty(((QQWalletBaseMsgElem)localObject).jdField_a_of_type_JavaLangString)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo;
        if ((localObject != null) && (((RedPacketInfo)localObject).isHideTitle == 1) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setText("");
          return;
        }
        int n = StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString);
        int m = 18;
        if (n <= 8)
        {
          n = this.f / 4;
          int i1 = this.g;
          m = n;
          if (n > i1) {
            m = i1;
          }
          m = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, m);
        }
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setTextSize(m);
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setText(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioQQWalletBaseMsgElem.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setText("");
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    if ((localObject != null) && (((IQWalletMsgHolder)localObject).a() != null))
    {
      if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b() == null) {
        return;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().stop();
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().stop();
      if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a() != null) {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(8);
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(8);
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setVisibility(8);
      localObject = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().getPlayer();
      if ((localObject instanceof ScrollPlayer)) {
        ((ScrollPlayer)localObject).a(this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a());
      }
      localObject = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().getPlayer();
      if ((localObject instanceof ScrollPlayer)) {
        ((ScrollPlayer)localObject).a(this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo;
      if ((localObject != null) && (((RedPacketInfo)localObject).animInfo != null))
      {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setAnimationFromInfo(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.animInfo);
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().play();
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo;
      if ((localObject != null) && (((RedPacketInfo)localObject).specailBackgroundAnimInfo != null))
      {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setVisibility(0);
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().setAnimationFromInfo(this.jdField_b_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfo.specailBackgroundAnimInfo);
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.b().play();
      }
    }
  }
  
  public void g()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.d() == null) {
        return;
      }
      if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.d().getChildCount() != 0) {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.d().removeAllViews();
      }
    }
  }
  
  public void h()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.c() == null) {
        return;
      }
      if (!c())
      {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.c().setVisibility(0);
    }
  }
  
  protected void i()
  {
    IQWalletMsgHolder localIQWalletMsgHolder = this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder;
    if (localIQWalletMsgHolder != null)
    {
      if (localIQWalletMsgHolder.a() == null) {
        return;
      }
      this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().getLayoutParams()).topMargin = this.e;
      if (this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().getChildCount() != 0) {
        this.jdField_a_of_type_ComQwalletTempIQWalletMsgHolder.a().removeAllViews();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */