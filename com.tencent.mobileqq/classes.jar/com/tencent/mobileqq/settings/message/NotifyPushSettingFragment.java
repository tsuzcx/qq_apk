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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131368066);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131378985));
    this.j = ((FormSwitchItem)this.mContentView.findViewById(2131372217));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem = ((NewFormSwitchItem)this.mContentView.findViewById(2131379676));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.getLayoutParams().height = getResources().getDimensionPixelSize(2131296786);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131372419));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingFragment.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379412));
    this.i = ((FormSwitchItem)this.mContentView.findViewById(2131363157));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131364207));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378058));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)this.mContentView.findViewById(2131372307));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem = ((SimpleFormSimpleItem)this.mContentView.findViewById(2131372308));
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.getLayoutParams().height = getResources().getDimensionPixelSize(2131296786);
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setOnClickListener(new NotifyPushSettingFragment.3(this));
    int k = SharedPreUtils.a(getActivity(), "open_don_disturb", this.jdField_a_of_type_JavaLangString);
    label512:
    boolean bool1;
    boolean bool3;
    int m;
    if ((k != 1) && (!FriendsStatusUtil.a(getActivity())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(8);
      this.mContentView.findViewById(2131365959).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 4, " showOpen DISTURB=" + k);
      }
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131378308);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378059));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378055));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378061));
      this.h = ((FormSwitchItem)this.mContentView.findViewById(2131378080));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131370815));
      this.g = ((FormSwitchItem)this.mContentView.findViewById(2131372821));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label1787;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      if (PushMsgBtnConfProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()) != 1) {
        break label1782;
      }
      k = 1;
      bool1 = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_JavaLangString, getString(2131718682), "qqsetting_notify_showcontent_key", true);
      this.jdField_d_of_type_Boolean = FriendsStatusUtil.a(getActivity());
      bool3 = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_JavaLangString, getString(2131718680), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(getActivity(), null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.getBool(getString(2131718678) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool2 = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_JavaLangString, getString(2131693883), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool6 = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_JavaLangString, null, "qqsetting_kandian_key", true);
      Object localObject = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      if (localObject != null)
      {
        bool7 = ((BubbleManager)localObject).a.b();
        if (bool7)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((BubbleManager)localObject).a.a());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.4(this, (BubbleManager)localObject));
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!bool7) {
          break label1801;
        }
        m = 0;
        label797:
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
      if (!this.j.a()) {
        break label1807;
      }
      m = 0;
      label912:
      ((NewFormSwitchItem)localObject).setVisibility(m);
      if (this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.b());
        this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem));
        if (this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.h()) {
          this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setVisibility(8);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(getActivity(), this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NotifyPushSettingFragment.5(this);
      this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.6(this));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707632));
      }
      a(this.jdField_d_of_type_Boolean, false);
      if (Build.VERSION.SDK_INT < 26) {
        break label1813;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      label1086:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool4);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.8(this));
      if (!BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
        break label1848;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E9");
      label1141:
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool5);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.9(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      this.g.setChecked(bool6);
      this.g.setOnCheckedChangeListener(new NotifyPushSettingFragment.10(this, (CardHandler)localObject));
      localObject = (CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (k == 0) {
        break label1860;
      }
      this.h.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_JavaLangString, null, "qqsetting_show_push_message", true);
      this.h.setChecked(bool3);
      this.h.setContentDescription(getString(2131719417));
      this.h.setOnCheckedChangeListener(new NotifyPushSettingFragment.11(this, (CardHandler)localObject));
      label1303:
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getPCActiveState();
      }
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false)) {
        break label1872;
      }
      this.g.setVisibility(0);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7EB");
      label1371:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      if (!a()) {
        break label1884;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.12(this));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707640));
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingFragment.13(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new NotifyPushSettingFragment.14(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new NotifyPushSettingFragment.15(this));
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707637));
        this.j.setContentDescription(getString(2131694481));
        this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setContentDescription(getString(2131719991));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694553) + getString(2131719085));
        this.i.setContentDescription(HardCodeUtil.a(2131707636));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707628));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131718680));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707626));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694993));
        this.g.setContentDescription("PC离线时自动启动QQ手机版");
        this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131707634));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719861));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getString(2131694993));
        this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setContentDescription(getString(2131694994));
      }
      ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
      b();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(0);
      if (!this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = true;
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E6");
      }
      this.mContentView.findViewById(2131365959).setVisibility(0);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E5");
      break;
      label1782:
      k = 0;
      break label512;
      label1787:
      QLog.d("IphoneTitleBarFragment", 1, "App is null, can't display 'new' flag for SpecialCare");
      k = 0;
      break label512;
      label1801:
      m = 8;
      break label797;
      label1807:
      m = 8;
      break label912;
      label1813:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new NotifyPushSettingFragment.7(this));
      break label1086;
      label1848:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label1141;
      label1860:
      this.h.setVisibility(8);
      break label1303;
      label1872:
      this.g.setVisibility(8);
      break label1371;
      label1884:
      if (bool1)
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      else
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + paramString2;
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  private void a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramView.setVisibility(0);
    paramView = a(paramView, 0, getResources().getDimensionPixelSize(2131296786));
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
      boolean bool = SettingCloneUtil.readValue(getActivity(), paramString, null, "qqsetting_pcactive_key", false);
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
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    Object localObject;
    int k;
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
        this.jdField_d_of_type_Boolean = paramBoolean1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem;
        if (!this.j.a()) {
          break label322;
        }
        k = 0;
        label122:
        ((NewFormSwitchItem)localObject).setVisibility(k);
        localObject = this.j;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
          break label328;
        }
        paramBoolean1 = true;
        label146:
        a((FormSwitchItem)localObject, paramBoolean1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
          break label333;
        }
        paramBoolean1 = true;
        label171:
        a((FormSwitchItem)localObject, paramBoolean1);
        localObject = this.i;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
          break label338;
        }
      }
    }
    label322:
    label328:
    label333:
    label338:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      a((FormSwitchItem)localObject, paramBoolean1);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.h())) {
        this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
      a(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a());
      break;
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(2);
        this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(0);
        if (this.jdField_f_of_type_Boolean) {
          break;
        }
        this.jdField_f_of_type_Boolean = true;
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B7E6");
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setBgType(3);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.setVisibility(8);
      break;
      k = 8;
      break label122;
      paramBoolean1 = false;
      break label146;
      paramBoolean1 = false;
      break label171;
    }
  }
  
  public static boolean a()
  {
    return new File(Environment.getRootDirectory() + "/etc/permissions", "com.lenovo.keyguard.xml").exists();
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
    DialogUtil.a(getActivity(), 230).setMessage(2131694501).setPositiveButton(2131691883, new NotifyPushSettingFragment.27(this)).setNegativeButton(2131720698, new NotifyPushSettingFragment.26(this)).show();
  }
  
  public boolean b()
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarFragment", 2, new Object[] { "systemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getResources().getString(2131719120));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager = NewMsgNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a();
    paramLayoutInflater = new IntentFilter();
    paramLayoutInflater.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramLayoutInflater.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
  }
  
  public int getContentLayoutId()
  {
    return 2131559635;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      if (BadgeUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
        BadgeUtils.c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppForegroundNotifyManager.a();
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
      int m = SettingCloneUtil.readValueForInt(getActivity().getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageSimpleFormSimpleItem.a().setText(HardCodeUtil.a(2131707627) + NotifyPushSettingActivity.TimePickDialog.a((m - k) * 1000));
    }
    this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a(this.j, this.jdField_a_of_type_AndroidWidgetTextView, this.i, this.jdField_a_of_type_ComTencentMobileqqSettingsMessageNewFormSwitchItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment
 * JD-Core Version:    0.7.0.1
 */