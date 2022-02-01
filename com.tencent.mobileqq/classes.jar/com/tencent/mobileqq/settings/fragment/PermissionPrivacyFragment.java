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
  private FormSimpleItem A;
  private FormSimpleItem B;
  private IPhoneContactService C;
  private CardObserver D = new PermissionPrivacyFragment.6(this);
  private IStatusListener E = new PermissionPrivacyFragment.8(this);
  private QQProgressDialog F;
  protected QQProgressNotifier a;
  protected FormSwitchItem b;
  protected FormSwitchItem c;
  protected FormSimpleItem d;
  protected FormSimpleItem e;
  protected FormSimpleItem f;
  protected FormSimpleItem g;
  protected FormSimpleItem h;
  protected FormSimpleItem i;
  protected FormSimpleItem j;
  protected FormSimpleItem k;
  protected FormSimpleItem l;
  protected FormSimpleItem m;
  protected FormSimpleItem n;
  protected TextView o;
  View p;
  Handler q = new PermissionPrivacyFragment.1(this);
  View.OnClickListener r = new PermissionPrivacyFragment.7(this);
  CompoundButton.OnCheckedChangeListener s = new PermissionPrivacyFragment.9(this);
  LBSObserver t = new PermissionPrivacyFragment.10(this);
  IntimateInfoObserver u = new PermissionPrivacyFragment.11(this);
  private QQAppInterface v;
  private boolean w = false;
  private int x = 0;
  private int y = -1;
  private StatusManager z;
  
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
    if (SimpleUIUtil.e())
    {
      int i1 = SimpleUIUtil.f();
      if (i1 != 0)
      {
        str = String.format("%08x", new Object[] { Integer.valueOf(i1) }).substring(2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("?mode_color=");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
        break label71;
      }
    }
    String str = "?mode_color=ffffff";
    label71:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://qun.qq.com/interactive/usersetting");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("&showLuckyWord=");
    if (this.w) {
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
    paramCompoundButton.setOnCheckedChangeListener(this.s);
  }
  
  private void b()
  {
    this.j = ((FormSimpleItem)this.p.findViewById(2131442472));
    ReportController.b(null, "dc00898", "", "", "0X800B7EC", "0X800B7EC", 0, 0, "", "", "", "");
    this.k = ((FormSimpleItem)this.p.findViewById(2131442477));
    ReportController.b(null, "dc00898", "", "", "0X800B7ED", "0X800B7ED", 0, 0, "", "", "", "");
    this.h = ((FormSimpleItem)this.p.findViewById(2131442488));
    ReportController.b(null, "dc00898", "", "", "0X800B7EE", "0X800B7EE", 0, 0, "", "", "", "");
    this.l = ((FormSimpleItem)this.p.findViewById(2131442481));
    ReportController.b(null, "dc00898", "", "", "0X800B7EF", "0X800B7EF", 0, 0, "", "", "", "");
    this.m = ((FormSimpleItem)this.p.findViewById(2131442478));
    ReportController.b(null, "dc00898", "", "", "0X800B7F0", "0X800B7F0", 0, 0, "", "", "", "");
    this.B = ((FormSimpleItem)this.p.findViewById(2131442491));
    ReportController.b(null, "dc00898", "", "", "0X800B7F1", "0X800B7F1", 0, 0, "", "", "", "");
    d();
    this.i = ((FormSimpleItem)this.p.findViewById(2131442480));
    ReportController.b(null, "dc00898", "", "", "0X800B7F2", "0X800B7F2", 0, 0, "", "", "", "");
    this.d = ((FormSimpleItem)this.p.findViewById(2131442485));
    ReportController.b(null, "dc00898", "", "", "0X800B7F3", "0X800B7F3", 0, 0, "", "", "", "");
    this.e = ((FormSimpleItem)this.p.findViewById(2131442487));
    ReportController.b(null, "dc00898", "", "", "0X800B7F4", "0X800B7F4", 0, 0, "", "0", "0", "");
    this.f = ((FormSimpleItem)this.p.findViewById(2131442482));
    ReportController.b(null, "dc00898", "", "", "0X800B7F5", "0X800B7F5", 0, 0, "", "", "", "");
    this.g = ((FormSimpleItem)this.p.findViewById(2131442483));
    ReportController.b(null, "dc00898", "", "", "0X800B7F6", "0X800B7F6", 0, 0, "", "", "", "");
    this.b = ((FormSwitchItem)this.p.findViewById(2131442486));
    ReportController.b(null, "dc00898", "", "", "0X800B7F7", "0X800B7F7", 0, 0, "", "", "", "");
    FormSwitchItem localFormSwitchItem = this.b;
    StatusManager localStatusManager = this.z;
    boolean bool;
    if ((localStatusManager != null) && (localStatusManager.d())) {
      bool = true;
    } else {
      bool = false;
    }
    localFormSwitchItem.setChecked(bool);
    this.c = ((FormSwitchItem)this.p.findViewById(2131442489));
    ReportController.b(null, "dc00898", "", "", "0X800B7F8", "0X800B7F8", 0, 0, "", "", "", "");
    c();
    this.A = ((FormSimpleItem)this.p.findViewById(2131442474));
    ReportController.b(null, "dc00898", "", "", "0X800B7F9", "0X800B7F9", 0, 0, "", "", "", "");
    this.n = ((FormSimpleItem)this.p.findViewById(2131442473));
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
    IContactSyncService localIContactSyncService = (IContactSyncService)this.v.getRuntimeService(IContactSyncService.class);
    if (localIContactSyncService.isSyncSupportForTheDevice())
    {
      this.c.setChecked(localIContactSyncService.isSyncContactAllowed());
      this.c.setOnCheckedChangeListener(this.s);
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void d()
  {
    TroopLuckyCharacterConfig localTroopLuckyCharacterConfig = (TroopLuckyCharacterConfig)QConfigManager.b().b(696);
    if (this.B != null)
    {
      this.w = localTroopLuckyCharacterConfig.a();
      if (this.w)
      {
        this.B.setLeftText(getString(2131917498));
        return;
      }
      this.B.setLeftText(getString(2131917499));
    }
  }
  
  private void d(int paramInt)
  {
    QQToast.makeText(getBaseActivity(), paramInt, 0).show(getBaseActivity().getTitleBarHeight());
  }
  
  private void e()
  {
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.h.setOnClickListener(this);
    k();
    this.l.setOnClickListener(this);
    l();
    this.m.setOnClickListener(this);
    this.B.setOnClickListener(this.r);
    f();
    this.i.setOnClickListener(this);
    this.o = ((TextView)this.i.findViewById(2131449123));
    this.o.setVisibility(8);
    this.d.setOnClickListener(this.r);
    j();
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this.r);
    this.g.setOnClickListener(this.r);
    this.A.setOnClickListener(this);
    i();
    this.b.setOnCheckedChangeListener(this.s);
    TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.v, TempGetProfileDetailProcessor.class);
    if (localTempGetProfileDetailProcessor != null) {
      localTempGetProfileDetailProcessor.getCalReactiveSwitch();
    }
    if (AppSetting.e)
    {
      this.k.setContentDescription(HardCodeUtil.a(2131905742));
      this.c.setContentDescription(getString(2131897270));
      this.b.setContentDescription(HardCodeUtil.a(2131905736));
      this.n.setContentDescription(getString(2131887022));
    }
  }
  
  private void f()
  {
    Card localCard = ((FriendsManager)this.v.getManager(QQManagerFactory.FRIENDS_MANAGER)).g(this.v.getCurrentAccountUin());
    if (!localCard.allowCalInteractive) {
      this.m.setRightText(HardCodeUtil.a(2131897271));
    } else {
      this.m.setRightText(HardCodeUtil.a(2131897272));
    }
    if (localCard.troopHonorSwitch)
    {
      this.B.setRightText(HardCodeUtil.a(2131897271));
      return;
    }
    this.B.setRightText(HardCodeUtil.a(2131897272));
  }
  
  private void g()
  {
    if (!HiddenChatUtil.a(this.v.getCurrentUin(), getBaseActivity()))
    {
      this.o.setVisibility(8);
      return;
    }
    int i1 = h();
    if (i1 > 99)
    {
      this.o.setText("99+");
      this.o.setVisibility(0);
      return;
    }
    if (i1 > 0)
    {
      TextView localTextView = this.o;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i1);
      localStringBuilder.append("");
      localTextView.setText(localStringBuilder.toString());
      this.o.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
  }
  
  private int h()
  {
    Object localObject = HiddenChatFragment.a(this.v.getProxyManager().g().c(), TroopAssistantManager.a().o(this.v));
    int i2 = 0;
    int i1 = 0;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        i2 = i1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        i1 += this.v.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType());
      }
    }
    return i2;
  }
  
  private void i()
  {
    ArrayList localArrayList = ((IArkModuleAPIAuthority)QRoute.api(IArkModuleAPIAuthority.class)).getArkAuthorityAppList(this.v.getCurrentAccountUin());
    if (localArrayList.size() > 0)
    {
      this.n.setVisibility(0);
      this.n.setOnClickListener(new PermissionPrivacyFragment.2(this, localArrayList));
    }
  }
  
  private void j()
  {
    ThreadManager.excute(new PermissionPrivacyFragment.3(this), 16, null, true);
  }
  
  private void k()
  {
    ThreadManager.excute(new PermissionPrivacyFragment.4(this), 16, null, true);
  }
  
  private void l()
  {
    QQAppInterface localQQAppInterface = this.v;
    if ((localQQAppInterface != null) && (FriendIntimateRelationshipHelper.a(localQQAppInterface.getCurrentUin())))
    {
      this.l.setOnClickListener(this);
      this.l.setVisibility(0);
      ReportController.b(this.v, "dc00898", "", "", "0X8009F73", "0X8009F73", 0, 0, "", "", "", "");
      m();
      return;
    }
    this.l.setVisibility(8);
  }
  
  private void m()
  {
    if (this.l.getVisibility() != 0) {
      return;
    }
    ThreadManager.excute(new PermissionPrivacyFragment.5(this), 16, null, true);
  }
  
  private Activity n()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      return localBaseActivity;
    }
    return null;
  }
  
  private void o()
  {
    ReportController.b(this.v, "CliOper", "", "", "0X80050E3", "0X80050E3", 0, 0, "1", "", "", "");
    ReportController.b(this.v, "CliOper", "", "", "Special_remind", "Clk_special_remind", 80, 0, "", "", "", "");
    QQAppInterface localQQAppInterface = this.v;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).edit().putBoolean("spcial_care_qq_setting", false).commit();
      this.h.setRightIcon(null);
      return;
    }
    QLog.d("PermissionPrivacyFragment", 1, "App is null, can't display 'new' flag for SpecialCare(onClick)");
  }
  
  void a()
  {
    try
    {
      if (this.F != null)
      {
        this.F.dismiss();
        this.F.cancel();
        this.F = null;
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
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getBaseActivity().getTitleBarHeight());
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
    this.y = getBaseActivity().getIntent().getIntExtra("kSrouce", -1);
    this.p = this.mContentView;
    setTitle(getBaseActivity().getString(2131897268));
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.v = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    if (this.v != null)
    {
      this.a = new QQProgressNotifier(getBaseActivity());
      this.z = ((StatusManager)this.v.getManager(QQManagerFactory.STATUS_MANAGER));
      paramLayoutInflater = this.z;
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(this.E);
      }
      this.C = ((IPhoneContactService)this.v.getRuntimeService(IPhoneContactService.class, ""));
      this.C.addListener(this);
      b();
      e();
      getBaseActivity().addObserver(this.t);
      getBaseActivity().addObserver(this.u);
      getBaseActivity().addObserver(this.D);
      this.v.getMessageFacade().addObserver(this);
      this.v.getVisibilitySwitches();
      this.v.getZanSwitches();
      this.v.getVisibilityForNetWorkStatus(true);
      this.v.getVisibilityForInputStatus(true);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627819;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      j();
    }
    if (paramInt1 == 2) {
      k();
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
    case 2131442488: 
      startActivityForResult(new Intent(getBaseActivity(), SpecailCareListActivity.class), 2);
      o();
      ReportController.b(null, "dc00898", "", "", "0X800B852", "0X800B852", 0, 0, "", "", "", "");
      break;
    case 2131442487: 
      localObject = new Intent(getBaseActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
      startActivity((Intent)localObject);
      ReportController.b(null, "dc00898", "", "", "0X800B858", "0X800B858", 0, 0, "", "0", "0", "");
      break;
    case 2131442481: 
      ReportController.b(this.v, "dc00898", "", "", "0X800B853", "0X800B853", 0, 0, "", "", "", "");
      localObject = FriendIntimateRelationshipHelper.b();
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
    case 2131442480: 
      ReportController.b(this.v, "CliOper", "", "", "0X800B856", "0X800B856", 0, 0, "", "", "", "");
      HiddenChatFragment.a(getBaseActivity(), 1, 0, new Intent());
      break;
    case 2131442478: 
      ReportController.b(this.v, "CliOper", "", "", "0X800B854", "0X800B854", 0, 0, "", "", "", "");
      MutualMarkUtils.a(this.v, getBaseActivity(), 1);
      break;
    case 2131442477: 
      a(getBaseActivity());
      ReportController.b(this.v, "CliOper", "", "", "Setting_tab", "Vfc_method_clk", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B851", "0X800B851", 0, 0, "", "", "", "");
      break;
    case 2131442474: 
      ReportController.b(null, "dc00898", "", "", "0X800B85D", "0X800B85D", 0, 0, "", "0", "0", "");
      AuthorityControlFragment.a(getBaseActivity());
      break;
    case 2131442472: 
      b(getBaseActivity());
      ReportController.b(null, "dc00898", "", "", "0X800B850", "0X800B850", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    if (this.D != null) {
      getBaseActivity().removeObserver(this.D);
    }
    Object localObject = this.z;
    if (localObject != null) {
      ((StatusManager)localObject).b(this.E);
    }
    this.v.getMessageFacade().deleteObserver(this);
    getBaseActivity().removeObserver(this.t);
    getBaseActivity().removeObserver(this.u);
    localObject = this.a;
    if (localObject != null)
    {
      ((QQProgressNotifier)localObject).b();
      this.a = null;
    }
    localObject = this.C;
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
    if (!HiddenChatUtil.a(this.v.getCurrentUin(), getBaseActivity())) {
      return;
    }
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.v)) {
        return;
      }
      this.q.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment
 * JD-Core Version:    0.7.0.1
 */