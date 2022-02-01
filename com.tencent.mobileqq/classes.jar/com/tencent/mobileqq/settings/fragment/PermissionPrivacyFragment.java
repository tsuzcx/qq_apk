package com.tencent.mobileqq.settings.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.phonecontact.permission.PermissionListener;
import com.tencent.mobileqq.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
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
  implements View.OnClickListener, IPhoneContactListener, PermissionListener, Observer
{
  private int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new PermissionPrivacyFragment.1(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PermissionPrivacyFragment.7(this);
  View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new PermissionPrivacyFragment.9(this);
  protected TextView a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new PermissionPrivacyFragment.6(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new PermissionPrivacyFragment.10(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IntimateInfoObserver jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver = new PermissionPrivacyFragment.11(this);
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
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
    int i1 = 0;
    int n = 0;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        i1 = n;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        n += this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType());
      }
    }
    return i1;
  }
  
  private Activity a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      return localBaseActivity;
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoFriendSettingBrowser context:");
      localStringBuilder.append(paramContext);
      QLog.d("PermissionPrivacyFragment", 2, localStringBuilder.toString());
    }
    if (paramContext == null) {
      return;
    }
    if (WebViewComUtils.a(1000L)) {
      paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (SimpleUIUtil.a())
    {
      int n = SimpleUIUtil.d();
      if (n != 0)
      {
        str = String.format("%08x", new Object[] { Integer.valueOf(n) }).substring(2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("?mode_color=");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
        break label73;
      }
    }
    String str = "?mode_color=ffffff";
    label73:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://qun.qq.com/interactive/usersetting");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("&showLuckyWord=");
    if (this.jdField_a_of_type_Boolean) {
      str = "1";
    } else {
      str = "0";
    }
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("&_wv=3");
    paramIntent.putExtra("url", localStringBuilder.toString());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void b()
  {
    this.g = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374309));
    ReportController.b(null, "dc00898", "", "", "0X800B7EC", "0X800B7EC", 0, 0, "", "", "", "");
    this.h = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374314));
    ReportController.b(null, "dc00898", "", "", "0X800B7ED", "0X800B7ED", 0, 0, "", "", "", "");
    this.e = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374325));
    ReportController.b(null, "dc00898", "", "", "0X800B7EE", "0X800B7EE", 0, 0, "", "", "", "");
    this.i = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374318));
    ReportController.b(null, "dc00898", "", "", "0X800B7EF", "0X800B7EF", 0, 0, "", "", "", "");
    this.j = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374315));
    ReportController.b(null, "dc00898", "", "", "0X800B7F0", "0X800B7F0", 0, 0, "", "", "", "");
    this.m = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374328));
    ReportController.b(null, "dc00898", "", "", "0X800B7F1", "0X800B7F1", 0, 0, "", "", "", "");
    d();
    this.f = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374317));
    ReportController.b(null, "dc00898", "", "", "0X800B7F2", "0X800B7F2", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374322));
    ReportController.b(null, "dc00898", "", "", "0X800B7F3", "0X800B7F3", 0, 0, "", "", "", "");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374324));
    ReportController.b(null, "dc00898", "", "", "0X800B7F4", "0X800B7F4", 0, 0, "", "0", "0", "");
    this.c = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374319));
    ReportController.b(null, "dc00898", "", "", "0X800B7F5", "0X800B7F5", 0, 0, "", "", "", "");
    this.d = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374320));
    ReportController.b(null, "dc00898", "", "", "0X800B7F6", "0X800B7F6", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374323));
    ReportController.b(null, "dc00898", "", "", "0X800B7F7", "0X800B7F7", 0, 0, "", "", "", "");
    FormSwitchItem localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    StatusManager localStatusManager = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    boolean bool;
    if ((localStatusManager != null) && (localStatusManager.b())) {
      bool = true;
    } else {
      bool = false;
    }
    localFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374326));
    ReportController.b(null, "dc00898", "", "", "0X800B7F8", "0X800B7F8", 0, 0, "", "", "", "");
    c();
    this.l = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374311));
    ReportController.b(null, "dc00898", "", "", "0X800B7F9", "0X800B7F9", 0, 0, "", "", "", "");
    this.k = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131374310));
    ReportController.b(null, "dc00898", "", "", "0X800B7FA", "0X800B7FA", 0, 0, "", "", "", "");
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoFriendFindMeSettingBrowser context:");
      localStringBuilder.append(paramContext);
      QLog.d("PermissionPrivacyFragment", 2, localStringBuilder.toString());
    }
    if (paramContext == null) {
      return;
    }
    if (WebViewComUtils.a(1000L)) {
      paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", "https://ti.qq.com/friendshipauth/find?_wv=3&_bid=173"));
    }
  }
  
  private void c()
  {
    IContactSyncService localIContactSyncService = (IContactSyncService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IContactSyncService.class);
    if (localIContactSyncService.isSyncSupportForTheDevice())
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localIContactSyncService.isSyncContactAllowed());
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
      if (this.jdField_a_of_type_Boolean)
      {
        this.m.setLeftText(getString(2131719893));
        return;
      }
      this.m.setLeftText(getString(2131719894));
    }
  }
  
  private void d(int paramInt)
  {
    QQToast.a(getBaseActivity(), paramInt, 0).b(getBaseActivity().getTitleBarHeight());
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.f.findViewById(2131380207));
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
      this.h.setContentDescription(HardCodeUtil.a(2131707928));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131699254));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131707922));
      this.k.setContentDescription(getString(2131690123));
    }
  }
  
  private void f()
  {
    Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (!localCard.allowCalInteractive) {
      this.j.setRightText(HardCodeUtil.a(2131699255));
    } else {
      this.j.setRightText(HardCodeUtil.a(2131699256));
    }
    if (localCard.troopHonorSwitch)
    {
      this.m.setRightText(HardCodeUtil.a(2131699255));
      return;
    }
    this.m.setRightText(HardCodeUtil.a(2131699256));
  }
  
  private void g()
  {
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getBaseActivity()))
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
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(n);
      localStringBuilder.append("");
      localTextView.setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void h()
  {
    ArrayList localArrayList = ((IArkModuleAPIAuthority)QRoute.api(IArkModuleAPIAuthority.class)).getArkAuthorityAppList(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface != null) && (FriendIntimateRelationshipHelper.a(localQQAppInterface.getCurrentUin())))
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
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).edit().putBoolean("spcial_care_qq_setting", false).commit();
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
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt) {}
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getBaseActivity().getTitleBarHeight());
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
    this.jdField_b_of_type_Int = getBaseActivity().getIntent().getIntExtra("kSrouce", -1);
    this.jdField_a_of_type_AndroidViewView = this.mContentView;
    setTitle(getBaseActivity().getString(2131699252));
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, ""));
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.addListener(this);
      b();
      e();
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilitySwitches();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getZanSwitches();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilityForNetWorkStatus(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getVisibilityForInputStatus(true);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561462;
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
    HiddenChatHelper.b(getBaseActivity(), QQSettingSettingActivity.class);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131374325: 
      startActivityForResult(new Intent(getBaseActivity(), SpecailCareListActivity.class), 2);
      m();
      ReportController.b(null, "dc00898", "", "", "0X800B852", "0X800B852", 0, 0, "", "", "", "");
      break;
    case 2131374324: 
      localObject = new Intent(getBaseActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
      startActivity((Intent)localObject);
      ReportController.b(null, "dc00898", "", "", "0X800B858", "0X800B858", 0, 0, "", "0", "0", "");
      break;
    case 2131374318: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B853", "0X800B853", 0, 0, "", "", "", "");
      localObject = FriendIntimateRelationshipHelper.a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("click qq_setting_intimate_relationship url:");
        localStringBuilder.append((String)localObject);
        QLog.d("PermissionPrivacyFragment", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        startActivity(new Intent(getBaseActivity(), QQBrowserActivity.class).putExtra("url", (String)localObject));
      }
      break;
    case 2131374317: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800B856", "0X800B856", 0, 0, "", "", "", "");
      HiddenChatFragment.a(getBaseActivity(), 1, 0, new Intent());
      break;
    case 2131374315: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800B854", "0X800B854", 0, 0, "", "", "", "");
      MutualMarkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), 1);
      break;
    case 2131374314: 
      a(getBaseActivity());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B851", "0X800B851", 0, 0, "", "", "", "");
      break;
    case 2131374311: 
      ReportController.b(null, "dc00898", "", "", "0X800B85D", "0X800B85D", 0, 0, "", "0", "0", "");
      AuthorityControlFragment.a(getBaseActivity());
      break;
    case 2131374309: 
      b(getBaseActivity());
      ReportController.b(null, "dc00898", "", "", "0X800B850", "0X800B850", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimateInfoObserver);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
    if (localObject != null)
    {
      ((QQProgressNotifier)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
    if (localObject != null) {
      ((IPhoneContactService)localObject).removeListener(this);
    }
  }
  
  public void onResume()
  {
    g();
    super.onResume();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getBaseActivity())) {
      return;
    }
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment
 * JD-Core Version:    0.7.0.1
 */