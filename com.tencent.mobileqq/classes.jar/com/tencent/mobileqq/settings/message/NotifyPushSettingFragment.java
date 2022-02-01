package com.tencent.mobileqq.settings.message;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.av.utils.AVUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity.TimePickDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ForegroundNotifyManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUnRead;
import com.tencent.mobileqq.config.business.PushMsgBtnConfProcessor;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.Switch;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class NotifyPushSettingFragment
  extends IphoneTitleBarFragment
{
  public BroadcastReceiver a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NotifyPushSettingFragment.25(this);
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NotifyPushSettingActivity.TimePickDialog jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity$TimePickDialog;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new NotifyPushSettingFragment.21(this);
  private ForegroundNotifyManager jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NewMsgNotificationManager jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager;
  private NewFormSwitchItem jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem;
  private SimpleFormSimpleItem jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(new NotifyPushSettingFragment.22(this));
  String jdField_a_of_type_JavaLangString = "";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NotifyPushSettingFragment.16(this);
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = true;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NotifyPushSettingFragment.1(this);
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_c_of_type_Boolean = true;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_d_of_type_Boolean = false;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_e_of_type_Boolean = false;
  private FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_f_of_type_Boolean = false;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  
  public NotifyPushSettingFragment()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new NotifyPushSettingFragment.23(this);
  }
  
  private ValueAnimator a(View paramView, int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new NotifyPushSettingFragment.17(this, paramView));
    return localValueAnimator;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131367818);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131378362));
    this.j = ((FormSwitchItem)this.mContentView.findViewById(2131371801));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem = ((NewFormSwitchItem)this.mContentView.findViewById(2131379018));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.getLayoutParams().height = getResources().getDimensionPixelSize(2131296766);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131372001));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingFragment.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378763));
    this.i = ((FormSwitchItem)this.mContentView.findViewById(2131363097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131364124));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377485));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)this.mContentView.findViewById(2131371892));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem = ((SimpleFormSimpleItem)this.mContentView.findViewById(2131371893));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.getLayoutParams().height = getResources().getDimensionPixelSize(2131296766);
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setOnClickListener(new NotifyPushSettingFragment.3(this));
    int k = SharedPreUtils.a(getBaseActivity(), "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    if ((k != 1) && (!FriendsStatusUtil.a(getBaseActivity())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(8);
      this.mContentView.findViewById(2131365796).setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(0);
      if (!this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = true;
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E6");
      }
      this.mContentView.findViewById(2131365796).setVisibility(0);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E5");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" showOpen DISTURB=");
      ((StringBuilder)localObject).append(k);
      QLog.d("IphoneTitleBarFragment", 4, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131377716);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377486));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377480));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377488));
    this.h = ((FormSwitchItem)this.mContentView.findViewById(2131377506));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131370446));
    this.g = ((FormSwitchItem)this.mContentView.findViewById(2131372400));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      if (PushMsgBtnConfProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()) == 1)
      {
        k = 1;
        break label603;
      }
    }
    else
    {
      QLog.d("IphoneTitleBarFragment", 1, "App is null, can't display 'new' flag for SpecialCare");
    }
    k = 0;
    label603:
    boolean bool1 = SettingCloneUtil.readValue(getBaseActivity(), this.jdField_a_of_type_JavaLangString, getString(2131718400), "qqsetting_notify_showcontent_key", true);
    this.jdField_d_of_type_Boolean = FriendsStatusUtil.a(getBaseActivity());
    boolean bool3 = SettingCloneUtil.readValue(getBaseActivity(), this.jdField_a_of_type_JavaLangString, getString(2131718398), "qqsetting_notify_blncontrol_key", true);
    boolean bool4 = SettingCloneUtil.readValue(getBaseActivity(), null, null, "qqsetting_show_badgeunread_key", true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getString(2131718396));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    boolean bool5 = LocalMultiProcConfig.getBool(((StringBuilder)localObject).toString(), true);
    boolean bool2 = SettingCloneUtil.readValue(getBaseActivity(), this.jdField_a_of_type_JavaLangString, getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
    boolean bool6 = SettingCloneUtil.readValue(getBaseActivity(), this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
    SettingCloneUtil.readValue(getBaseActivity(), this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
    localObject = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    int m;
    if (localObject != null)
    {
      bool7 = ((BubbleManager)localObject).a.b();
      if (bool7)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a.a());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.4(this, (BubbleManager)localObject));
        VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (bool7) {
        m = 0;
      } else {
        m = 8;
      }
      ((FormSwitchItem)localObject).setVisibility(m);
    }
    boolean bool7 = AVUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.i.setVisibility(0);
    this.i.setChecked(bool7);
    bool7 = this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.b();
    this.j.setChecked(bool7);
    this.j.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.j.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.i.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem;
    if (this.j.a()) {
      m = 0;
    } else {
      m = 8;
    }
    ((NewFormSwitchItem)localObject).setVisibility(m);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setChecked(((ForegroundNotifyManager)localObject).b());
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem));
      if (this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.h()) {
        this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(getBaseActivity(), this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NotifyPushSettingFragment.5(this);
    this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.6(this));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707657));
    }
    a(this.jdField_d_of_type_Boolean, false);
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.7(this));
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.8(this));
    if (BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E9");
    }
    else
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.9(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    this.g.setChecked(bool6);
    this.g.setOnCheckedChangeListener(new NotifyPushSettingFragment.10(this, (CardHandler)localObject));
    localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (k != 0)
    {
      this.h.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(getBaseActivity(), this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.h.setChecked(bool3);
      this.h.setContentDescription(getString(2131719135));
      this.h.setOnCheckedChangeListener(new NotifyPushSettingFragment.11(this, (CardHandler)localObject));
    }
    else
    {
      this.h.setVisibility(8);
    }
    localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (localObject != null) {
      ((TempGetProfileDetailProcessor)localObject).getPCActiveState();
    }
    if (SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false))
    {
      this.g.setVisibility(0);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7EB");
    }
    else
    {
      this.g.setVisibility(8);
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
    if (a())
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    else if (bool1)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    else
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.12(this));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707665));
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingFragment.13(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingFragment.14(this));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingFragment.15(this));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707662));
      this.j.setContentDescription(getString(2131694446));
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setContentDescription(getString(2131719723));
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131694518));
      localStringBuilder.append(getString(2131718802));
      ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
      this.i.setContentDescription(HardCodeUtil.a(2131707661));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707653));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131718398));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707651));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694983));
      this.g.setContentDescription("PC离线时自动启动QQ手机版");
      this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707659));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719593));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694983));
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setContentDescription(getString(2131694984));
    }
    ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
    b();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  private void a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramView.setVisibility(0);
    paramView = a(paramView, 0, getResources().getDimensionPixelSize(2131296766));
    paramView.addListener(paramAnimatorListenerAdapter);
    paramView.start();
  }
  
  private void a(View paramView1, View paramView2)
  {
    ValueAnimator localValueAnimator = a(paramView1, paramView1.getHeight(), 0);
    localValueAnimator.addListener(new NotifyPushSettingFragment.19(this, paramView1, paramView2));
    localValueAnimator.start();
  }
  
  private void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    if (paramFormSwitchItem.a() != null) {
      paramFormSwitchItem.a().setEnabled(paramBoolean);
    }
    if (paramFormSwitchItem.a() != null) {
      paramFormSwitchItem.a().setEnabled(paramBoolean);
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(getBaseActivity(), paramString, null, "qqsetting_pcactive_key", false);
      this.jdField_a_of_type_Boolean = true;
      this.g.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    int k = 0;
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().setClickable(false);
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(2);
        localObject = new NotifyPushSettingFragment.24(this);
        a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem, (AnimatorListenerAdapter)localObject);
        if (!this.jdField_f_of_type_Boolean)
        {
          this.jdField_f_of_type_Boolean = true;
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E6");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
        a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a());
      }
    }
    else if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(2);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(0);
      if (!this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = true;
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E6");
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(8);
    }
    this.jdField_d_of_type_Boolean = paramBoolean1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem;
    if (!this.j.a()) {
      k = 8;
    }
    ((NewFormSwitchItem)localObject).setVisibility(k);
    a(this.j, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a() ^ true);
    a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a() ^ true);
    a(this.i, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a() ^ true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager;
    if ((localObject != null) && (((ForegroundNotifyManager)localObject).h())) {
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setVisibility(8);
    }
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getRootDirectory());
    localStringBuilder.append("/etc/permissions");
    return new File(localStringBuilder.toString(), "com.lenovo.keyguard.xml").exists();
  }
  
  private void b()
  {
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E0");
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E2");
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E4");
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E7");
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E8");
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7EA");
    if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.getVisibility() == 0))
    {
      this.jdField_e_of_type_Boolean = true;
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E1");
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
      return;
    }
    DialogUtil.a(getBaseActivity(), 230).setMessage(2131694467).setPositiveButton(2131691805, new NotifyPushSettingFragment.27(this)).setNegativeButton(2131720417, new NotifyPushSettingFragment.26(this)).show();
  }
  
  public boolean b()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getString(2131718838));
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramLayoutInflater != null) {
      this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getCurrentAccountUin();
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager = NewMsgNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a();
    paramLayoutInflater = new IntentFilter();
    paramLayoutInflater.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramLayoutInflater.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    getBaseActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
  }
  
  protected int getContentLayoutId()
  {
    return 2131559512;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      if (BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
        BadgeUtils.c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.a();
    getBaseActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_d_of_type_Boolean)
    {
      int k = (int)NetConnInfoCenter.getServerTime();
      int m = SettingCloneUtil.readValueForInt(getBaseActivity().getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707652));
      localStringBuilder.append(NotifyPushSettingActivity.TimePickDialog.a((m - k) * 1000));
      localTextView.setText(localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this.j, this.jdField_a_of_type_AndroidWidgetTextView, this.i, this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment
 * JD-Core Version:    0.7.0.1
 */