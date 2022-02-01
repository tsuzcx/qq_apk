package com.tencent.mobileqq.settings.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.inputstatus.InputStatusConfig.Config;
import com.tencent.mobileqq.inputstatus.InputStatusObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class PrivacyShowSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  QQAppInterface a;
  CompoundButton.OnCheckedChangeListener b = new PrivacyShowSettingFragment.6(this);
  FriendListObserver c = new PrivacyShowSettingFragment.7(this);
  InputStatusObserver d = new PrivacyShowSettingFragment.8(this);
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSimpleItem g;
  private FormSwitchItem h;
  private FormSimpleItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  private FormSwitchItem l;
  private FormSwitchItem m;
  private TextView n;
  private StatusManager o;
  private View p;
  private CardObserver q = new PrivacyShowSettingFragment.9(this);
  
  private void a()
  {
    boolean bool1 = SimpleUIUtil.e();
    this.e = ((FormSwitchItem)this.p.findViewById(2131445886));
    Object localObject1 = this.e;
    Object localObject2 = this.a;
    int i1 = 0;
    ((FormSwitchItem)localObject1).setChecked(((QQAppInterface)localObject2).getVisibilityForNetWorkStatus(false));
    ReportController.b(this.a, "dc00898", "", "", "0X800B7FE", "0X800B7FE", 0, 0, "", "", "", "");
    this.f = ((FormSwitchItem)this.p.findViewById(2131445882));
    this.f.setChecked(this.a.getVisibilityForInputStatus(false));
    ReportController.b(this.a, "dc00898", "", "", "0X800B7FF", "0X800B7FF", 0, 0, "", "", "", "");
    this.l = ((FormSwitchItem)this.p.findViewById(2131438029));
    ReportController.b(this.a, "dc00898", "", "", "0X800B800", "0X800B800", 0, 0, "", "", "", "");
    b();
    this.g = ((FormSimpleItem)this.p.findViewById(2131440363));
    ReportController.b(this.a, "dc00898", "", "", "0X800B801", "0X800B801", 0, 0, "", "", "", "");
    e();
    localObject1 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject2 = ((FriendsManager)localObject1).g(this.a.getCurrentAccountUin());
    this.h = ((FormSwitchItem)this.p.findViewById(2131445904));
    ReportController.b(this.a, "dc00898", "", "", "0X800B802", "0X800B802", 0, 0, "", "", "", "");
    a((Card)localObject2);
    this.j = ((FormSwitchItem)this.p.findViewById(2131442512));
    ReportController.b(this.a, "dc00898", "", "", "0X800B803", "0X800B803", 0, 0, "", "", "", "");
    this.i = ((FormSimpleItem)this.p.findViewById(2131442510));
    ReportController.b(this.a, "dc00898", "", "", "0X800B804", "0X800B804", 0, 0, "", "", "", "");
    c();
    this.m = ((FormSwitchItem)this.p.findViewById(2131442511));
    ReportController.b(this.a, "dc00898", "", "", "0X800B805", "0X800B805", 0, 0, "", "", "", "");
    this.k = ((FormSwitchItem)this.p.findViewById(2131439959));
    this.n = ((TextView)this.p.findViewById(2131439960));
    ReportController.b(this.a, "dc00898", "", "", "0X800B806", "0X800B806", 0, 0, "", "", "", "");
    ((CardHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).d();
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.a, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getLoginDaysSwitch();
    }
    this.k.setChecked(((Card)localObject2).allowPeopleSee);
    if (((Card)localObject2).allowClick)
    {
      this.k.setVisibility(0);
      this.n.setVisibility(0);
    }
    else
    {
      this.k.setVisibility(8);
      this.n.setVisibility(8);
    }
    this.e.setOnCheckedChangeListener(this.b);
    this.f.setOnCheckedChangeListener(this.b);
    localObject2 = this.f;
    if (!d()) {
      i1 = 8;
    }
    ((FormSwitchItem)localObject2).setVisibility(i1);
    this.k.setOnCheckedChangeListener(this.b);
    boolean bool2 = ((FriendsManager)localObject1).y();
    if (bool1)
    {
      this.j.setVisibility(8);
    }
    else
    {
      this.j.setChecked(bool2);
      this.j.setOnCheckedChangeListener(new PrivacyShowSettingFragment.1(this, (FriendsManager)localObject1));
    }
    localObject1 = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    bool2 = ((TroopManager)localObject1).o();
    if (bool1)
    {
      this.m.setVisibility(8);
    }
    else
    {
      this.m.setChecked(bool2);
      this.m.setOnCheckedChangeListener(new PrivacyShowSettingFragment.2(this, (TroopManager)localObject1));
    }
    if (AppSetting.e)
    {
      this.e.setContentDescription(HardCodeUtil.a(2131905737));
      this.f.setContentDescription(HardCodeUtil.a(2131905735));
      this.k.setContentDescription(HardCodeUtil.a(2131905738));
    }
  }
  
  private void a(int paramInt)
  {
    QQToast.makeText(getBaseActivity(), paramInt, 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.b);
  }
  
  private void a(Card paramCard)
  {
    this.h.setChecked(paramCard.isHidePrettyGroutIdentity ^ true);
    this.h.setOnCheckedChangeListener(new PrivacyShowSettingFragment.4(this));
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new PrivacyShowSettingFragment.10(this, paramBoolean));
  }
  
  private void b()
  {
    if (SharedPreUtils.am(getBaseActivity().getApplication(), this.a.getCurrentAccountUin()) == 1)
    {
      this.l.setVisibility(0);
      ThreadManager.post(new PrivacyShowSettingFragment.3(this), 5, null, true);
      this.l.setOnCheckedChangeListener(this.b);
    }
  }
  
  private void c()
  {
    if (VasUtil.b(this.a).getVipStatus().isBigClub())
    {
      this.i.setVisibility(0);
      this.i.setRightText(this.a.getApp().getResources().getString(2131897293));
      this.i.setOnClickListener(new PrivacyShowSettingFragment.5(this));
      return;
    }
    this.i.setVisibility(8);
  }
  
  private boolean d()
  {
    try
    {
      InputStatusConfig.Config localConfig = (InputStatusConfig.Config)QConfigManager.b().b(445);
      if (localConfig != null)
      {
        boolean bool = localConfig.a;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("IphoneTitleBarFragment", 1, localException, new Object[0]);
    }
    return false;
  }
  
  private void e()
  {
    Card localCard = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.a.getCurrentUin());
    if (localCard == null)
    {
      this.g.setRightText(this.a.getApp().getResources().getString(2131892646));
    }
    else
    {
      boolean bool = VasUtil.a().getGameCardManager().checkGameCardAble(localCard.namePlateOfKingDanDisplatSwitch, localCard.gameCardId);
      if ((!localCard.namePlateOfKingDanDisplatSwitch) && (!bool)) {
        this.g.setRightText(this.a.getApp().getResources().getString(2131892646));
      } else {
        this.g.setRightText(this.a.getApp().getResources().getString(2131892645));
      }
    }
    this.g.setOnClickListener(new PrivacyShowSettingFragment.11(this));
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getBaseActivity().getString(2131897276));
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    this.p = this.mContentView;
    a();
    getBaseActivity().addObserver(this.d);
    getBaseActivity().addObserver(this.c);
    getBaseActivity().addObserver(this.q);
  }
  
  protected int getContentLayoutId()
  {
    return 2131627821;
  }
  
  public void onClick(View paramView) {}
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.q != null) {
      getBaseActivity().removeObserver(this.q);
    }
    getBaseActivity().removeObserver(this.d);
    getBaseActivity().removeObserver(this.c);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment
 * JD-Core Version:    0.7.0.1
 */