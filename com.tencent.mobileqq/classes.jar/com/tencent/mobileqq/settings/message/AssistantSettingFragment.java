package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.qassistant.setting.AssistantSwitchImpl;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qqfloatingwindow.impl.FloatingScreenPermission;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HeightAdaptableListView;
import common.config.service.QzoneConfig;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.List;

public class AssistantSettingFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AssistantSettingFragment.5(this);
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingFragment.36(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CTEntryListener jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener = new AssistantSettingFragment.38(this);
  CTEntryMng jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new AssistantSettingFragment.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  C2CShortcutBarObserver jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver = new AssistantSettingFragment.7(this);
  private ProfileCommonObserver jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver = new AssistantSettingFragment.2(this);
  AssistantSettingFragment.EntryListAdapter jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter;
  protected QQCustomDialog a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormMultiLineSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  HeightAdaptableListView jdField_a_of_type_ComTencentWidgetHeightAdaptableListView;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new AssistantSettingFragment.6(this);
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingFragment.3(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected QQCustomDialog b;
  private FormMultiLineSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingFragment.4(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormMultiLineSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingFragment.37(this);
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  private FormSwitchItem l;
  private FormSwitchItem m;
  
  public AssistantSettingFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getActivity().getTitleBarHeight());
  }
  
  public static void a(Context paramContext, Class<? extends ColorNoteSettingFragment> paramClass, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramClass == null))
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        if (paramContext != null) {
          break label62;
        }
        paramContext = "context ";
        paramBundle = paramBundle.append(paramContext);
        if (paramClass != null) {
          break label68;
        }
      }
      label62:
      label68:
      for (paramContext = "fragment ";; paramContext = "")
      {
        com.tencent.TMG.utils.QLog.d("AssistantSettingFragment", 0, paramContext + "is null");
        return;
        paramContext = "";
        break;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800AA7E", "0X800AA7E", paramBundle.getInt("start_from", 1), 0, "", "", "", "");
    PublicFragmentActivity.Launcher.a(paramContext, new Intent(), PublicFragmentActivity.class, paramClass);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new AssistantSettingFragment.35(this));
  }
  
  private void a(List<CTEntry> paramList)
  {
    boolean bool2 = true;
    if (StudyModeManager.a()) {
      return;
    }
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CTEntry localCTEntry = (CTEntry)((Iterator)localObject).next();
        if (localCTEntry.a == 3)
        {
          if (!localCTEntry.e) {
            break label102;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter;
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.getVisibility() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AssistantSettingFragment.EntryListAdapter)localObject).a(bool1);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter.a(paramList);
      return;
      label102:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {}
      for (bool1 = true;; bool1 = false)
      {
        b(bool1);
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131382137));
    if ((RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!paramBoolean))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      paramBoolean = RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131700854));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.18(this));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B81A");
      return;
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(paramBoolean);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
  }
  
  private void b(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    if (this.i != null)
    {
      this.i.setOnCheckedChangeListener(null);
      w();
      this.i.setChecked(paramBoolean);
      this.i.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void c()
  {
    boolean bool = SimpleUIUtil.a();
    View localView = this.mContentView.findViewById(2131373434);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131362990));
    g();
    h();
    u();
    r();
    this.i = ((FormSwitchItem)this.mContentView.findViewById(2131373739));
    if (WakeManager.a().b())
    {
      if (getActivity().getIntent().getBooleanExtra("need_open_tips", false)) {
        this.i.setBackgroundColor(getResources().getColor(2131167364));
      }
      b(WakeManager.a().jdField_a_of_type_Boolean, this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B821");
      q();
      v();
      p();
      f();
      l();
      o();
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      k();
      j();
      localView.setOnClickListener(new AssistantSettingFragment.8(this));
      d();
      i();
      a(bool);
      n();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365231));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131365219));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {
        break label472;
      }
    }
    label472:
    for (bool = true;; bool = false)
    {
      b(bool);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131365238));
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
      this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter = new AssistantSettingFragment.EntryListAdapter(getActivity(), this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c());
      }
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter);
      x();
      e();
      m();
      if (AppSetting.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(HardCodeUtil.a(2131700852));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131700862));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131691000));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377360));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingFragment.9(this));
      return;
      this.i.setVisibility(8);
      if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131373740));
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    String str1 = "businessinfo_ptt_auto_change_text_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str2 = "businessinfo_ptt_auto_change_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str3 = "businessinfo_ptt_auto_change_guide_has_show_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(str1, paramBoolean);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      ((SharedPreferences.Editor)localObject).putLong(str2, l1);
      ((SharedPreferences.Editor)localObject).putBoolean(str3, true);
      PttSlideStateHelper.d = true;
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).commit();
      PttSlideStateHelper.c = paramBoolean;
      PttSlideStateHelper.a = l1;
      return;
      ((SharedPreferences.Editor)localObject).putLong(str2, 9223372036854775807L);
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366291));
    boolean bool = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131692027));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B819");
  }
  
  private void e()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131364961));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.10(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B822");
  }
  
  private void f()
  {
    this.l = ((FormSwitchItem)this.mContentView.findViewById(2131361994));
    this.l.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true));
    this.l.setOnCheckedChangeListener(new AssistantSettingFragment.11(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B827");
  }
  
  private void g()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131367627));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.12(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B818");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691419));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131367626));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.13(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B817");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694708));
  }
  
  private void i()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131365982));
    DoutuManager localDoutuManager = (DoutuManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER);
    if ((localDoutuManager.a()) && (localDoutuManager.d()))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      boolean bool = localDoutuManager.b();
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131700850));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.14(this, localDoutuManager));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B81B");
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  private void j()
  {
    this.m = ((FormSwitchItem)this.mContentView.findViewById(2131372004));
    if (((MultiAIOManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("AssistantSettingFragment", 2, "MultiAio switch is open, so switch is visible");
      }
      this.m.setVisibility(0);
      boolean bool = MultiAIOHelper.a();
      this.m.setChecked(bool);
      this.m.setOnCheckedChangeListener(new AssistantSettingFragment.15(this));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B823");
    }
  }
  
  private void k()
  {
    this.g = ((FormSwitchItem)this.mContentView.findViewById(2131369931));
    boolean bool = ReadInJoyHelper.m();
    this.g.setChecked(bool);
    this.g.setOnCheckedChangeListener(new AssistantSettingFragment.16(this));
    s();
  }
  
  private void l()
  {
    this.f = ((FormSwitchItem)this.mContentView.findViewById(2131372437));
    this.f.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean);
    this.f.setText(getText(2131694581));
    this.f.setContentDescription(HardCodeUtil.a(2131700855) + QQStoryConstant.a + HardCodeUtil.a(2131700859));
    this.f.setOnCheckedChangeListener(new AssistantSettingFragment.17(this));
    this.f.setBackgroundResource(2130839575);
    this.f.setVisibility(0);
    if ((!QQStoryManager.i()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Char == '0') || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Char == '1'))
    {
      this.f.setVisibility(8);
      return;
    }
    StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
  }
  
  private void m()
  {
    try
    {
      FormMultiLineSwitchItem localFormMultiLineSwitchItem = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131378389);
      TextView localTextView = (TextView)this.mContentView.findViewById(2131380547);
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (localSpringFestivalEntryManager.a())
      {
        localTextView.setVisibility(0);
        localFormMultiLineSwitchItem.setVisibility(0);
        localFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.19(this, localSpringFestivalEntryManager));
        localFormMultiLineSwitchItem.setChecked(localSpringFestivalEntryManager.b());
        return;
      }
      localTextView.setVisibility(8);
      localFormMultiLineSwitchItem.setVisibility(8);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.qphone.base.util.QLog.e("AssistantSettingFragment", 1, localThrowable, new Object[0]);
    }
  }
  
  private void n() {}
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377522));
    boolean bool = SettingCloneUtil.readValue(getActivity(), null, super.getString(2131694985), "qqsetting_screenshot_key", false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.28(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B825");
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131362764));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
  }
  
  private void q()
  {
    this.e = ((FormSwitchItem)this.mContentView.findViewById(2131378492));
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sticker_pref", 0);
    if (EmojiStickerManager.a())
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      this.e.setChecked(localSharedPreferences.getBoolean("sticker_switch_" + str, true));
      this.e.setOnCheckedChangeListener(new AssistantSettingFragment.30(this, localSharedPreferences, str));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B81C");
      return;
    }
    this.e.setVisibility(8);
  }
  
  private void r()
  {
    PttAutoChangeBean localPttAutoChangeBean = (PttAutoChangeBean)QConfigManager.a().a(442);
    boolean bool;
    if (localPttAutoChangeBean != null)
    {
      bool = localPttAutoChangeBean.a();
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.i("PttAutoChangeProcessor", 2, "is Open:" + bool);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131373610));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.h = ((FormSwitchItem)this.mContentView.findViewById(2131373609));
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    localSharedPreferences.getBoolean("businessinfo_ptt_auto_change_text_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (((localPttAutoChangeBean != null) && (localPttAutoChangeBean.a())) || (PttSlideStateHelper.c))
    {
      this.h.setVisibility(0);
      if (QVipAutoPttProcessor.c().a > 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.h.setRightIcon(getResources().getDrawable(2130847795));
      }
      bool = localSharedPreferences.getBoolean("businessinfo_ptt_auto_change_text_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      this.h.setChecked(bool);
      this.h.setOnCheckedChangeListener(new AssistantSettingFragment.31(this));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B820");
      return;
    }
    com.tencent.qphone.base.util.QLog.e("vip_ptt.AssistantSettingFragment", 1, "disable the ptt check box");
    c(false);
    this.h.setVisibility(8);
  }
  
  private void s()
  {
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131363842));
    if (QzoneConfig.isShowBottomTabSwitch())
    {
      if (this.g != null) {
        this.g.setVisibility(8);
      }
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.32(this));
      }
    }
    for (;;)
    {
      return;
      if (this.g != null)
      {
        if (!ReadInJoyHelper.j()) {
          break label109;
        }
        this.g.setVisibility(8);
      }
      while (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        return;
        label109:
        this.g.setVisibility(0);
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B826");
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(BottomTabSettingFragment.a(getResources()));
    }
  }
  
  private void u()
  {
    this.k = ((FormSwitchItem)this.mContentView.findViewById(2131377544));
    boolean bool = ScreenShotDetector.b();
    this.k.setVisibility(0);
    this.k.setChecked(bool);
    this.k.setOnCheckedChangeListener(new AssistantSettingFragment.33(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B824");
  }
  
  private void v()
  {
    this.j = ((FormSwitchItem)this.mContentView.findViewById(2131371980));
    boolean bool = C2CShortcutBarSwitcher.b();
    FormSwitchItem localFormSwitchItem = this.j;
    if (bool) {}
    for (int n = 0;; n = 8)
    {
      localFormSwitchItem.setVisibility(n);
      if (bool)
      {
        this.j.setChecked(C2CShortcutBarSwitcher.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        this.j.setOnCheckedChangeListener(new AssistantSettingFragment.34(this));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B81D", "0X800B81D", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void w()
  {
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    boolean bool;
    for (int n = 1;; n = 0)
    {
      bool = FloatingScreenPermission.checkPermission(getActivity());
      if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131373740));
      }
      if (((n == 0) || (!bool)) && (WakeManager.a().jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695302)));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      t();
      return;
    }
    if (n != 0) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695307)));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      break;
      if (bool) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695305)));
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695303)));
      }
    }
  }
  
  private void x()
  {
    if (StudyModeManager.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null)
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c();
        if ((localList != null) && (localList.size() > 0))
        {
          this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      while (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        com.tencent.qphone.base.util.QLog.i("AssistantSettingFragment", 2, "updateCTEntrySetting visible: " + this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getVisibility());
        return;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 0, HardCodeUtil.a(2131700856), HardCodeUtil.a(2131700860), 2131695078, 2131695079, new AssistantSettingFragment.39(this), new AssistantSettingFragment.40(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void z()
  {
    QVipConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 0, null, HardCodeUtil.a(2131700861), 0, 2131719347, new AssistantSettingFragment.41(this), null);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getActivity().getResources().getString(2131694959));
    getActivity().setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng = ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.d(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a();
    }
    c();
    paramLayoutInflater = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.getEmotionRecSwitch();
    }
    AssistantSwitchImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public int getContentLayoutId()
  {
    return 2131561592;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(getActivity(), paramBundle, "/base/login");
      getActivity().finish();
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      getActivity().dismissDialog(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver != null) {
      getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver != null) {
      getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
    }
    b();
    a();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment
 * JD-Core Version:    0.7.0.1
 */