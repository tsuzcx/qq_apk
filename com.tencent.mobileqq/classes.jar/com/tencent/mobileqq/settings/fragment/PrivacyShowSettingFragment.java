package com.tencent.mobileqq.settings.fragment;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
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
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
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
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new PrivacyShowSettingFragment.6(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new PrivacyShowSettingFragment.9(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PrivacyShowSettingFragment.7(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  InputStatusObserver jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver = new PrivacyShowSettingFragment.8(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  
  private void a()
  {
    boolean bool1 = SimpleUIUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377487));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = 0;
    ((FormSwitchItem)localObject1).setChecked(((QQAppInterface)localObject2).getVisibilityForNetWorkStatus(false));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B7FE", "0X800B7FE", 0, 0, "", "", "", "");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377483));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilityForInputStatus(false));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B7FF", "0X800B7FF", 0, 0, "", "", "", "");
    this.f = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131370729));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B800", "0X800B800", 0, 0, "", "", "", "");
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131372814));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B801", "0X800B801", 0, 0, "", "", "", "");
    d();
    localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject2 = ((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.c = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377502));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B802", "0X800B802", 0, 0, "", "", "", "");
    a((Card)localObject2);
    this.d = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374350));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B803", "0X800B803", 0, 0, "", "", "", "");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374348));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B804", "0X800B804", 0, 0, "", "", "", "");
    c();
    this.g = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374349));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B805", "0X800B805", 0, 0, "", "", "", "");
    this.e = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131372437));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372438));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B806", "0X800B806", 0, 0, "", "", "", "");
    ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).d();
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getLoginDaysSwitch();
    }
    this.e.setChecked(((Card)localObject2).allowPeopleSee);
    if (((Card)localObject2).allowClick)
    {
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.e.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (!a()) {
      i = 8;
    }
    ((FormSwitchItem)localObject2).setVisibility(i);
    this.e.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    boolean bool2 = ((FriendsManager)localObject1).f();
    if (bool1)
    {
      this.d.setVisibility(8);
    }
    else
    {
      this.d.setChecked(bool2);
      this.d.setOnCheckedChangeListener(new PrivacyShowSettingFragment.1(this, (FriendsManager)localObject1));
    }
    localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    bool2 = ((TroopManager)localObject1).e();
    if (bool1)
    {
      this.g.setVisibility(8);
    }
    else
    {
      this.g.setChecked(bool2);
      this.g.setOnCheckedChangeListener(new PrivacyShowSettingFragment.2(this, (TroopManager)localObject1));
    }
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707923));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707921));
      this.e.setContentDescription(HardCodeUtil.a(2131707924));
    }
  }
  
  private void a(int paramInt)
  {
    QQToast.a(getBaseActivity(), paramInt, 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void a(Card paramCard)
  {
    this.c.setChecked(paramCard.isHidePrettyGroutIdentity ^ true);
    this.c.setOnCheckedChangeListener(new PrivacyShowSettingFragment.4(this));
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new PrivacyShowSettingFragment.10(this, paramBoolean));
  }
  
  private boolean a()
  {
    try
    {
      InputStatusConfig.Config localConfig = (InputStatusConfig.Config)QConfigManager.a().a(445);
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
  
  private void b()
  {
    if (SharedPreUtils.U(getBaseActivity().getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 1)
    {
      this.f.setVisibility(0);
      ThreadManager.post(new PrivacyShowSettingFragment.3(this), 5, null, true);
      this.f.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
  }
  
  private void c()
  {
    if (VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().isBigClub())
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131699277));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new PrivacyShowSettingFragment.5(this));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void d()
  {
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (localObject != null) {
      localObject = VipGrayConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), ((Card)localObject).namePlateOfKingGameId, ((Card)localObject).namePlateOfKingDan, ((Card)localObject).namePlateOfKingDanDisplatSwitch, true);
    } else {
      localObject = "";
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0);
    if (!bool)
    {
      localObject = URLDrawable.getDrawable((String)localObject, new ColorDrawable(), new ColorDrawable());
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        ((URLDrawable)localObject).setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 47.0F), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 14.0F));
      }
      else
      {
        ((URLDrawable)localObject).restartDownload();
        ((URLDrawable)localObject).setBounds(0, 0, 1, 1);
      }
      ((URLDrawable)localObject).setURLDrawableListener(new PrivacyShowSettingFragment.11(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 47.0F), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 14.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131694919));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new PrivacyShowSettingFragment.12(this, localSharedPreferences, bool));
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getBaseActivity().getString(2131699260));
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    this.jdField_a_of_type_AndroidViewView = this.mContentView;
    a();
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561464;
  }
  
  public void onClick(View paramView) {}
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqInputstatusInputStatusObserver);
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment
 * JD-Core Version:    0.7.0.1
 */