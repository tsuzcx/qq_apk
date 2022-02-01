package com.tencent.mobileqq.settings.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionListener;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.annotation.Nullable;

public class PermissionPrivacyFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, PermissionListener, PhoneContactManager.IPhoneContactListener, Observer
{
  private int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new PermissionPrivacyFragment.1(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PermissionPrivacyFragment.7(this);
  View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new PermissionPrivacyFragment.9(this);
  protected TextView a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new PermissionPrivacyFragment.6(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new PermissionPrivacyFragment.10(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopHandler a;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new PermissionPrivacyFragment.11(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new PermissionPrivacyFragment.8(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  protected FormSimpleItem a;
  protected FormSwitchItem a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected QQProgressNotifier a;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  protected FormSimpleItem b;
  protected FormSwitchItem b;
  protected FormSimpleItem c;
  protected FormSimpleItem d;
  protected FormSimpleItem e;
  protected FormSimpleItem f;
  protected FormSimpleItem g;
  protected FormSimpleItem h;
  protected FormSimpleItem i;
  protected FormSimpleItem j;
  protected FormSimpleItem k;
  private FormSimpleItem l;
  private FormSimpleItem m;
  
  public PermissionPrivacyFragment()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  private int a()
  {
    Object localObject = HiddenChatFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(), TroopAssistantManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    int i1;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      i1 = 0;
      return i1;
    }
    localObject = ((List)localObject).iterator();
    RecentUser localRecentUser;
    for (int n = 0;; n = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType()) + n)
    {
      i1 = n;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localRecentUser = (RecentUser)((Iterator)localObject).next();
    }
  }
  
  private Activity a()
  {
    FragmentActivity localFragmentActivity2 = getActivity();
    FragmentActivity localFragmentActivity1;
    if (localFragmentActivity2 != null)
    {
      localFragmentActivity1 = localFragmentActivity2;
      if (!localFragmentActivity2.isFinishing()) {}
    }
    else
    {
      localFragmentActivity1 = null;
    }
    return localFragmentActivity1;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PermissionPrivacyFragment", 2, "gotoFriendSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {}
    while (!QQBrowserActivity.checkNotFrequentlyThenEnter(1000L)) {
      return;
    }
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject2 = "?mode_color=ffffff";
    Object localObject1 = localObject2;
    if (SimpleUIUtil.a())
    {
      int n = SimpleUIUtil.d();
      localObject1 = localObject2;
      if (n != 0)
      {
        localObject1 = String.format("%08x", new Object[] { Integer.valueOf(n) }).substring(2);
        localObject1 = "?mode_color=" + (String)localObject1;
      }
    }
    localObject1 = "https://qun.qq.com/interactive/usersetting" + (String)localObject1;
    localObject2 = new StringBuilder().append((String)localObject1).append("&showLuckyWord=");
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      localObject1 = (String)localObject1;
      paramIntent.putExtra("url", (String)localObject1 + "&_wv=3");
      return;
    }
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void b()
  {
    this.g = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374773));
    ReportController.b(null, "dc00898", "", "", "0X800B7EC", "0X800B7EC", 0, 0, "", "", "", "");
    this.h = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374778));
    ReportController.b(null, "dc00898", "", "", "0X800B7ED", "0X800B7ED", 0, 0, "", "", "", "");
    this.e = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374790));
    ReportController.b(null, "dc00898", "", "", "0X800B7EE", "0X800B7EE", 0, 0, "", "", "", "");
    this.i = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374782));
    ReportController.b(null, "dc00898", "", "", "0X800B7EF", "0X800B7EF", 0, 0, "", "", "", "");
    this.j = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374779));
    ReportController.b(null, "dc00898", "", "", "0X800B7F0", "0X800B7F0", 0, 0, "", "", "", "");
    this.m = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374793));
    ReportController.b(null, "dc00898", "", "", "0X800B7F1", "0X800B7F1", 0, 0, "", "", "", "");
    d();
    this.f = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374781));
    ReportController.b(null, "dc00898", "", "", "0X800B7F2", "0X800B7F2", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374787));
    ReportController.b(null, "dc00898", "", "", "0X800B7F3", "0X800B7F3", 0, 0, "", "", "", "");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374789));
    ReportController.b(null, "dc00898", "", "", "0X800B7F4", "0X800B7F4", 0, 0, "", "0", "0", "");
    this.c = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374783));
    ReportController.b(null, "dc00898", "", "", "0X800B7F5", "0X800B7F5", 0, 0, "", "", "", "");
    this.d = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374784));
    ReportController.b(null, "dc00898", "", "", "0X800B7F6", "0X800B7F6", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374788));
    ReportController.b(null, "dc00898", "", "", "0X800B7F7", "0X800B7F7", 0, 0, "", "", "", "");
    FormSwitchItem localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b())) {}
    for (boolean bool = true;; bool = false)
    {
      localFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374791));
      ReportController.b(null, "dc00898", "", "", "0X800B7F8", "0X800B7F8", 0, 0, "", "", "", "");
      c();
      this.l = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374775));
      ReportController.b(null, "dc00898", "", "", "0X800B7F9", "0X800B7F9", 0, 0, "", "", "", "");
      this.k = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374774));
      ReportController.b(null, "dc00898", "", "", "0X800B7FA", "0X800B7FA", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PermissionPrivacyFragment", 2, "gotoFriendFindMeSettingBrowser context:" + paramContext);
    }
    if (paramContext == null) {}
    while (!QQBrowserActivity.checkNotFrequentlyThenEnter(1000L)) {
      return;
    }
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendshipauth/find?_wv=3&_bid=173"));
  }
  
  private void c()
  {
    ContactSyncManager localContactSyncManager = (ContactSyncManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_SYNC_CONTACT);
    if (localContactSyncManager.b())
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localContactSyncManager.a());
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
  }
  
  private void d()
  {
    TroopLuckyCharacterConfig localTroopLuckyCharacterConfig = (TroopLuckyCharacterConfig)QConfigManager.a().a(696);
    if (this.m != null)
    {
      this.jdField_a_of_type_Boolean = localTroopLuckyCharacterConfig.a();
      if (this.jdField_a_of_type_Boolean) {
        this.m.setLeftText(getString(2131720160));
      }
    }
    else
    {
      return;
    }
    this.m.setLeftText(getString(2131720161));
  }
  
  private void d(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getActivity().getTitleBarHeight());
  }
  
  private void e()
  {
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.e.setOnClickListener(this);
    j();
    this.i.setOnClickListener(this);
    k();
    this.j.setOnClickListener(this);
    this.m.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    f();
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.f.findViewById(2131380941));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    i();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.l.setOnClickListener(this);
    h();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getCalReactiveSwitch();
    }
    if (AppSetting.d)
    {
      this.h.setContentDescription(HardCodeUtil.a(2131707905));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699150));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707899));
      this.k.setContentDescription(getString(2131690207));
    }
  }
  
  private void f()
  {
    Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!localCard.allowCalInteractive) {
      this.j.setRightText(HardCodeUtil.a(2131699151));
    }
    while (localCard.troopHonorSwitch)
    {
      this.m.setRightText(HardCodeUtil.a(2131699151));
      return;
      this.j.setRightText(HardCodeUtil.a(2131699152));
    }
    this.m.setRightText(HardCodeUtil.a(2131699152));
  }
  
  private void g()
  {
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getActivity()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    int n = a();
    if (n > 99)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("99+");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    if (n > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(n + "");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void h()
  {
    ArrayList localArrayList = ArkAppModuleBase.APIAuthority.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (localArrayList.size() > 0)
    {
      this.k.setVisibility(0);
      this.k.setOnClickListener(new PermissionPrivacyFragment.2(this, localArrayList));
    }
  }
  
  private void i()
  {
    ThreadManager.excute(new PermissionPrivacyFragment.3(this), 16, null, true);
  }
  
  private void j()
  {
    ThreadManager.excute(new PermissionPrivacyFragment.4(this), 16, null, true);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (FriendIntimateRelationshipHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
    {
      this.i.setOnClickListener(this);
      this.i.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
      l();
      return;
    }
    this.i.setVisibility(8);
  }
  
  private void l()
  {
    if (this.i.getVisibility() != 0) {
      return;
    }
    ThreadManager.excute(new PermissionPrivacyFragment.5(this), 16, null, true);
  }
  
  private void m()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050E3", "0X80050E3", 0, 0, "1", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Special_remind", "Clk_special_remind", 80, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).edit().putBoolean("spcial_care_qq_setting", false).commit();
      this.e.setRightIcon(null);
      return;
    }
    QLog.d("PermissionPrivacyFragment", 1, "App is null, can't display 'new' flag for SpecialCare(onClick)");
  }
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt) {}
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getActivity().getTitleBarHeight());
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, PermissionParam paramPermissionParam)
  {
    paramPermissionParam.a(paramBoolean);
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_Int = getActivity().getIntent().getIntExtra("kSrouce", -1);
    this.jdField_a_of_type_AndroidViewView = this.mContentView;
    setTitle(getActivity().getString(2131699148));
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
      b();
      e();
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      getActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilitySwitches();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getZanSwitches();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilityForNetWorkStatus(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilityForInputStatus(true);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561620;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      i();
    }
    if (paramInt1 == 2) {
      j();
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    HiddenChatHelper.b(getActivity(), QQSettingSettingActivity.class);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(getActivity());
      ReportController.b(null, "dc00898", "", "", "0X800B850", "0X800B850", 0, 0, "", "", "", "");
      continue;
      a(getActivity());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B851", "0X800B851", 0, 0, "", "", "", "");
      continue;
      startActivityForResult(new Intent(getActivity(), SpecailCareListActivity.class), 2);
      m();
      ReportController.b(null, "dc00898", "", "", "0X800B852", "0X800B852", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B853", "0X800B853", 0, 0, "", "", "", "");
      Object localObject = FriendIntimateRelationshipHelper.a();
      if (QLog.isColorLevel()) {
        QLog.d("PermissionPrivacyFragment", 2, "click qq_setting_intimate_relationship url:" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        startActivity(new Intent(getActivity(), QQBrowserActivity.class).putExtra("url", (String)localObject));
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800B854", "0X800B854", 0, 0, "", "", "", "");
        MutualMarkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), 1);
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800B856", "0X800B856", 0, 0, "", "", "", "");
        HiddenChatFragment.a(getActivity(), 1, 0, new Intent());
        continue;
        localObject = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        startActivity((Intent)localObject);
        ReportController.b(null, "dc00898", "", "", "0X800B858", "0X800B858", 0, 0, "", "0", "0", "");
        continue;
        ReportController.b(null, "dc00898", "", "", "0X800B85D", "0X800B85D", 0, 0, "", "0", "0", "");
        AuthorityControlFragment.a(getActivity());
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this);
    }
  }
  
  public void onResume()
  {
    g();
    super.onResume();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getActivity())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      paramObservable = (MessageRecord)paramObject;
    } while (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment
 * JD-Core Version:    0.7.0.1
 */