package com.tencent.mobileqq.settings.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import javax.annotation.Nullable;

public class PrivacyPermissionSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  QQAppInterface a;
  FormSwitchItem b;
  FormSwitchItem c;
  View d;
  View e;
  CompoundButton.OnCheckedChangeListener f = new PrivacyPermissionSettingFragment.2(this);
  private CardObserver g = new PrivacyPermissionSettingFragment.1(this);
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.f);
  }
  
  private void b()
  {
    this.d = this.e.findViewById(2131439976);
    ReportController.b(null, "dc00898", "", "", "0X800B7FB", "0X800B7FB", 0, 0, "", "", "", "");
    this.b = ((FormSwitchItem)this.e.findViewById(2131439974));
    ReportController.b(null, "dc00898", "", "", "0X800B7FC", "0X800B7FC", 0, 0, "", "", "", "");
    this.c = ((FormSwitchItem)this.e.findViewById(2131439965));
    ReportController.b(null, "dc00898", "", "", "0X800B7FD", "0X800B7FD", 0, 0, "", "", "", "");
    this.d.setOnClickListener(this);
    Card localCard = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.a.getCurrentAccountUin());
    boolean bool = this.a.getLocZanAllowedForPeople();
    a(this.b.getSwitch(), bool);
    a(this.c.getSwitch(), localCard.strangerInviteMeGroupOpen);
    this.b.setOnCheckedChangeListener(this.f);
    this.c.setOnCheckedChangeListener(this.f);
    if (AppSetting.e)
    {
      this.d.setContentDescription(getResources().getString(2131897236));
      this.b.setContentDescription(getResources().getString(2131892101));
      this.c.setContentDescription(getResources().getString(2131886628));
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(a());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e = this.mContentView;
    setTitle(getBaseActivity().getString(2131897275));
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    getBaseActivity().addObserver(this.g);
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131627820;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131439976)
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = this.a.getCurrentAccountUin();
      localUserInfo.nickname = this.a.getCurrentNickname();
      QZoneHelper.forwardToPermissionSetting(getBaseActivity(), localUserInfo, -1);
      ReportController.b(this.a, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B85F", "0X800B85F", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateCenterView()
  {
    setTitle(getBaseActivity().getString(2131897275));
    return this.e;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.g != null) {
      getBaseActivity().removeObserver(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyPermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */