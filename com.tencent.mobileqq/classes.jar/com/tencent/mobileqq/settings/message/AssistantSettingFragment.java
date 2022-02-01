package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HeightAdaptableListView;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;

public class AssistantSettingFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AssistantSettingFragment.5(this);
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingFragment.37(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CTEntryListener jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener = new AssistantSettingFragment.39(this);
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
  private CompoundButton.OnCheckedChangeListener jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new AssistantSettingFragment.38(this);
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
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
  
  private void A()
  {
    QVipConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_show_ptt_tip", true);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getBaseActivity(), 0, null, HardCodeUtil.a(2131701004), 0, 2131719065, new AssistantSettingFragment.42(this), null);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getBaseActivity().getTitleBarHeight());
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        if (paramContext == null) {
          paramContext = "context ";
        } else {
          paramContext = "";
        }
        paramBundle.append(paramContext);
        paramBundle.append("is null");
        com.tencent.TMG.utils.QLog.d("AssistantSettingFragment", 0, paramBundle.toString());
      }
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AA7E", "0X800AA7E", paramBundle.getInt("start_from", 1), 0, "", "", "", "");
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).startColorNoteSettingPage(paramContext, paramBundle);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(new AssistantSettingFragment.36(this));
  }
  
  private void a(List<CTEntry> paramList)
  {
    if (StudyModeManager.a()) {
      return;
    }
    boolean bool = true;
    if (paramList != null)
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CTEntry localCTEntry = (CTEntry)((Iterator)localObject).next();
        if (localCTEntry.a == 3) {
          if (localCTEntry.e)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
          }
          else
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(0);
            b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c() ^ true);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter;
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.getVisibility() != 0) {
      bool = false;
    }
    ((AssistantSettingFragment.EntryListAdapter)localObject).a(bool);
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter.a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131381341));
    if ((RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!paramBoolean))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      paramBoolean = RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131700997));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.19(this));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B81A");
      return;
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    FormSwitchItem localFormSwitchItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FormMultiLineSwitchItem localFormMultiLineSwitchItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem;
    if (localFormMultiLineSwitchItem != null)
    {
      localFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setChecked(paramBoolean);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    }
  }
  
  private void b(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    FormSwitchItem localFormSwitchItem = this.i;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      x();
      this.i.setChecked(paramBoolean);
      this.i.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void c()
  {
    boolean bool = SimpleUIUtil.a();
    Object localObject = this.mContentView.findViewById(2131373014);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131362939));
    g();
    h();
    i();
    v();
    s();
    this.i = ((FormSwitchItem)this.mContentView.findViewById(2131373311));
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerEnable())
    {
      if (getBaseActivity().getIntent().getBooleanExtra("need_open_tips", false)) {
        this.i.setBackgroundColor(getResources().getColor(2131167385));
      }
      b(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getCanOpenInSp(), this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B821");
    }
    else
    {
      this.i.setVisibility(8);
      if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131373312));
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    r();
    w();
    q();
    f();
    m();
    p();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    l();
    k();
    ((View)localObject).setOnClickListener(new AssistantSettingFragment.8(this));
    d();
    j();
    a(bool);
    o();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365108));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131365097));
    b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c() ^ true);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView = ((HeightAdaptableListView)this.mContentView.findViewById(2131365115));
    this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setHeightAdaptMode(2, 0);
    this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter = new AssistantSettingFragment.EntryListAdapter(getBaseActivity(), this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (localObject != null) {
      a(((CTEntryMng)localObject).c());
    }
    this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSettingsMessageAssistantSettingFragment$EntryListAdapter);
    y();
    e();
    n();
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setContentDescription(HardCodeUtil.a(2131700995));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131701005));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131690920));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131376812));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new AssistantSettingFragment.9(this));
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("businessinfo_ptt_auto_change_text_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("businessinfo_ptt_auto_change_time_");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("businessinfo_ptt_auto_change_guide_has_show_");
    ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject2, paramBoolean);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      ((SharedPreferences.Editor)localObject1).putLong((String)localObject3, l1);
      ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject4, true);
      PttConstants.d = true;
    }
    else
    {
      ((SharedPreferences.Editor)localObject1).putLong((String)localObject3, 9223372036854775807L);
    }
    ((SharedPreferences.Editor)localObject1).commit();
    PttConstants.c = paramBoolean;
    PttConstants.a = l1;
  }
  
  private void d()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366179));
    boolean bool = ((IStickerRecManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131691946));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B819");
  }
  
  private void e()
  {
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131364845));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.10(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B822");
  }
  
  private void f()
  {
    this.l = ((FormSwitchItem)this.mContentView.findViewById(2131362009));
    this.l.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true));
    this.l.setOnCheckedChangeListener(new AssistantSettingFragment.11(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B827");
  }
  
  private void g()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131367384));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.12(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B818");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131691341));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131367383));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.13(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B817");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694684));
  }
  
  private void i()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131364800));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.14(this));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690179));
  }
  
  private void j()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131365818));
    IDoutuService localIDoutuService = (IDoutuService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IDoutuService.class, "");
    localIDoutuService.setApp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localIDoutuService.isDoutuConfigOpen()) && (localIDoutuService.checkLocalResFiles()))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      boolean bool = localIDoutuService.isDoutuSettingOpen();
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131700993));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.15(this, localIDoutuService));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B81B");
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  private void k()
  {
    this.m = ((FormSwitchItem)this.mContentView.findViewById(2131371610));
    if (((MultiAIOManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("AssistantSettingFragment", 2, "MultiAio switch is open, so switch is visible");
      }
      this.m.setVisibility(0);
      boolean bool = MultiAIOHelper.a();
      this.m.setChecked(bool);
      this.m.setOnCheckedChangeListener(new AssistantSettingFragment.16(this));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B823");
    }
  }
  
  private void l()
  {
    this.g = ((FormSwitchItem)this.mContentView.findViewById(2131369616));
    boolean bool = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab();
    this.g.setChecked(bool);
    this.g.setOnCheckedChangeListener(new AssistantSettingFragment.17(this));
    t();
  }
  
  private void m()
  {
    this.f = ((FormSwitchItem)this.mContentView.findViewById(2131372020));
    this.f.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean);
    this.f.setText(getText(2131694549));
    FormSwitchItem localFormSwitchItem = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131700998));
    localStringBuilder.append(QQStoryConstant.a);
    localStringBuilder.append(HardCodeUtil.a(2131701002));
    localFormSwitchItem.setContentDescription(localStringBuilder.toString());
    this.f.setOnCheckedChangeListener(new AssistantSettingFragment.18(this));
    this.f.setBackgroundResource(2130839433);
    this.f.setVisibility(0);
    if ((QQStoryManager.i()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Char != '0') && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Char != '1'))
    {
      StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      return;
    }
    this.f.setVisibility(8);
  }
  
  private void n()
  {
    try
    {
      FormMultiLineSwitchItem localFormMultiLineSwitchItem = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131377800);
      TextView localTextView = (TextView)this.mContentView.findViewById(2131379838);
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (localSpringFestivalEntryManager.a())
      {
        localTextView.setVisibility(0);
        localFormMultiLineSwitchItem.setVisibility(0);
        localFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.20(this, localSpringFestivalEntryManager));
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
  
  private void o() {}
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131376966));
    boolean bool = SettingCloneUtil.readValue(getBaseActivity(), null, super.getString(2131694975), "qqsetting_screenshot_key", false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.29(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B825");
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131362719));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
  }
  
  private void r()
  {
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377905));
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sticker_pref", 0);
    if (EmojiStickerManager.a())
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      FormSwitchItem localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sticker_switch_");
      localStringBuilder.append(str);
      localFormSwitchItem.setChecked(localSharedPreferences.getBoolean(localStringBuilder.toString(), true));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.31(this, localSharedPreferences, str));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B81C");
      return;
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  private void s()
  {
    Object localObject1 = (PttAutoChangeBean)QConfigManager.a().a(442);
    boolean bool;
    if (localObject1 != null)
    {
      bool = ((PttAutoChangeBean)localObject1).a();
      if (com.tencent.qphone.base.util.QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("is Open:");
        ((StringBuilder)localObject2).append(bool);
        com.tencent.qphone.base.util.QLog.i("PttAutoChangeProcessor", 2, ((StringBuilder)localObject2).toString());
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131373185));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.h = ((FormSwitchItem)this.mContentView.findViewById(2131373184));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_ptt_auto_change_text_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false);
    if (((localObject1 != null) && (((PttAutoChangeBean)localObject1).a())) || (PttConstants.c))
    {
      this.h.setVisibility(0);
      if (QVipAutoPttProcessor.c().a > 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.h.setRightIcon(getResources().getDrawable(2130847662));
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_text_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bool = ((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject1).toString(), false);
      this.h.setChecked(bool);
      this.h.setOnCheckedChangeListener(new AssistantSettingFragment.32(this));
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B820");
      return;
    }
    com.tencent.qphone.base.util.QLog.e("vip_ptt.AssistantSettingFragment", 1, "disable the ptt check box");
    c(false);
    this.h.setVisibility(8);
  }
  
  private void t()
  {
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131363769));
    Object localObject;
    if (QzoneConfig.isShowBottomTabSwitch())
    {
      localObject = this.g;
      if (localObject != null) {
        ((FormSwitchItem)localObject).setVisibility(8);
      }
      if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "entrance_exp", 0, 0, "", "", "", "");
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AssistantSettingFragment.33(this));
      }
    }
    else
    {
      if (this.g != null) {
        if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).hideKandianTab())
        {
          this.g.setVisibility(8);
        }
        else
        {
          this.g.setVisibility(0);
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B826");
        }
      }
      localObject = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (localObject != null) {
        ((FormSimpleItem)localObject).setVisibility(8);
      }
    }
  }
  
  private void u()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (localFormSimpleItem != null) {
      localFormSimpleItem.setRightText(BottomTabSettingFragment.a(getResources()));
    }
  }
  
  private void v()
  {
    this.k = ((FormSwitchItem)this.mContentView.findViewById(2131376986));
    boolean bool = ScreenShotDetector.b();
    this.k.setVisibility(0);
    this.k.setChecked(bool);
    this.k.setOnCheckedChangeListener(new AssistantSettingFragment.34(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800B824");
  }
  
  private void w()
  {
    this.j = ((FormSwitchItem)this.mContentView.findViewById(2131371587));
    boolean bool = C2CShortcutBarSwitcher.b();
    FormSwitchItem localFormSwitchItem = this.j;
    int n;
    if (bool) {
      n = 0;
    } else {
      n = 8;
    }
    localFormSwitchItem.setVisibility(n);
    if (bool)
    {
      this.j.setChecked(C2CShortcutBarSwitcher.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      this.j.setOnCheckedChangeListener(new AssistantSettingFragment.35(this));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B81D", "0X800B81D", 0, 0, "", "", "", "");
    }
  }
  
  private void x()
  {
    int n;
    if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      n = 0;
    } else {
      n = 1;
    }
    boolean bool = ((IFloatingWrapperManager)QRoute.api(IFloatingWrapperManager.class)).checkPermission(getBaseActivity());
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131373312));
    }
    if (((n != 0) && (bool)) || (!((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getCanOpenInSp()))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695311)));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      if (n != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695316)));
      } else if (bool) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695314)));
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(Html.fromHtml(getResources().getString(2131695312)));
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    u();
  }
  
  private void y()
  {
    if (StudyModeManager.a())
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.setVisibility(8);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (localObject != null)
    {
      localObject = ((CTEntryMng)localObject).c();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCTEntrySetting visible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getVisibility());
      com.tencent.qphone.base.util.QLog.i("AssistantSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getBaseActivity(), 0, HardCodeUtil.a(2131700999), HardCodeUtil.a(2131701003), 2131695068, 2131695069, new AssistantSettingFragment.40(this), new AssistantSettingFragment.41(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  protected void b()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getBaseActivity().getResources().getString(2131694949));
    getBaseActivity().setVolumeControlStream(3);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng = ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG));
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.d(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a();
    }
    c();
    paramLayoutInflater = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.getEmotionRecSwitch();
    }
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getAssistantImplSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561434;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(getBaseActivity(), paramBundle, "/base/login");
      getBaseActivity().finish();
    }
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      getBaseActivity().dismissDialog(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver != null) {
      getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver != null) {
      getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecommonObserverProfileCommonObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng;
    if (localObject != null) {
      ((CTEntryMng)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryListener);
    }
    b();
    a();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment
 * JD-Core Version:    0.7.0.1
 */