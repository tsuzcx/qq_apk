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
  private AtomicBoolean A = new AtomicBoolean(false);
  private boolean B = false;
  private boolean C = true;
  private boolean D = true;
  private boolean E = false;
  private boolean F = false;
  private boolean G = false;
  private CompoundButton.OnCheckedChangeListener H = new NotifyPushSettingFragment.1(this);
  private CardObserver I = new NotifyPushSettingFragment.21(this);
  private MqqWeakReferenceHandler J = new MqqWeakReferenceHandler(new NotifyPushSettingFragment.22(this));
  private View.OnClickListener K = new NotifyPushSettingFragment.25(this);
  String a = "";
  CompoundButton.OnCheckedChangeListener b;
  CompoundButton.OnCheckedChangeListener c = new NotifyPushSettingFragment.16(this);
  public BroadcastReceiver d = new NotifyPushSettingFragment.23(this);
  private QQAppInterface e;
  private View f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  private FormSwitchItem l;
  private FormSwitchItem m;
  private FormSwitchItem n;
  private FormSwitchItem o;
  private FormSwitchItem p;
  private NewFormSwitchItem q;
  private FormSimpleItem r;
  private TextView s;
  private FormSwitchSimpleItem t;
  private SimpleFormSimpleItem u;
  private View v;
  private FormSimpleItem w;
  private NotifyPushSettingFragment.TimePickDialog x;
  private NewMsgNotificationManager y;
  private ForegroundNotifyManager z;
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private ValueAnimator a(View paramView, int paramInt1, int paramInt2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new NotifyPushSettingFragment.17(this, paramView));
    return localValueAnimator;
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
    paramView = a(paramView, 0, getResources().getDimensionPixelSize(2131297097));
    paramView.addListener(paramAnimatorListenerAdapter);
    paramView.start();
  }
  
  private void a(View paramView1, View paramView2)
  {
    ValueAnimator localValueAnimator = a(paramView1, paramView1.getHeight(), 0);
    localValueAnimator.addListener(new NotifyPushSettingFragment.19(this, paramView1, paramView2));
    localValueAnimator.start();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.execute(new NotifyPushSettingFragment.20(paramQQAppInterface, paramString));
  }
  
  private void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    if (paramFormSwitchItem.getTextView() != null) {
      paramFormSwitchItem.getTextView().setEnabled(paramBoolean);
    }
    if (paramFormSwitchItem.getSwitch() != null) {
      paramFormSwitchItem.getSwitch().setEnabled(paramBoolean);
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(getBaseActivity(), paramString, null, "qqsetting_pcactive_key", false);
      this.B = true;
      this.m.setChecked(bool);
      this.B = false;
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
    this.t.setOnCheckedChangeListener(null);
    this.t.setChecked(paramBoolean1);
    this.t.setOnCheckedChangeListener(this.H);
    int i1 = 0;
    if (paramBoolean2)
    {
      this.t.getSwitch().setClickable(false);
      if (paramBoolean1)
      {
        this.t.setBgType(2);
        localObject = new NotifyPushSettingFragment.24(this);
        a(this.u, (AnimatorListenerAdapter)localObject);
        if (!this.G)
        {
          this.G = true;
          ReportController.a(this.e, "0X800B7E6");
        }
      }
      else
      {
        this.t.setBgType(3);
        a(this.u, this.t.getSwitch());
      }
    }
    else if (paramBoolean1)
    {
      this.t.setBgType(2);
      this.u.setVisibility(0);
      if (!this.G)
      {
        this.G = true;
        ReportController.a(this.e, "0X800B7E6");
      }
    }
    else
    {
      this.t.setBgType(3);
      this.u.setVisibility(8);
    }
    this.E = paramBoolean1;
    Object localObject = this.q;
    if (!this.p.a()) {
      i1 = 8;
    }
    ((NewFormSwitchItem)localObject).setVisibility(i1);
    a(this.p, this.t.a() ^ true);
    a(this.q, this.t.a() ^ true);
    a(this.o, this.t.a() ^ true);
    localObject = this.z;
    if ((localObject != null) && (((ForegroundNotifyManager)localObject).f())) {
      this.q.setVisibility(8);
    }
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getRootDirectory());
    localStringBuilder.append("/etc/permissions");
    return new File(localStringBuilder.toString(), "com.lenovo.keyguard.xml").exists();
  }
  
  private void c()
  {
    this.f = this.mContentView.findViewById(2131434397);
    this.w = ((FormSimpleItem)this.mContentView.findViewById(2131446961));
    this.p = ((FormSwitchItem)this.mContentView.findViewById(2131439236));
    this.q = ((NewFormSwitchItem)this.mContentView.findViewById(2131447738));
    this.q.getLayoutParams().height = getResources().getDimensionPixelSize(2131297097);
    this.r = ((FormSimpleItem)this.mContentView.findViewById(2131439459));
    this.r.setOnClickListener(new NotifyPushSettingFragment.2(this));
    this.s = ((TextView)this.mContentView.findViewById(2131447438));
    this.o = ((FormSwitchItem)this.mContentView.findViewById(2131428950));
    this.g = ((FormSwitchItem)this.mContentView.findViewById(2131430091));
    this.h = ((FormSwitchItem)this.mContentView.findViewById(2131445884));
    this.h.setVisibility(8);
    this.t = ((FormSwitchSimpleItem)this.mContentView.findViewById(2131439335));
    this.u = ((SimpleFormSimpleItem)this.mContentView.findViewById(2131439336));
    this.u.getLayoutParams().height = getResources().getDimensionPixelSize(2131297097);
    this.u.setOnClickListener(new NotifyPushSettingFragment.3(this));
    int i1 = SharedPreUtils.c(getBaseActivity(), "open_don_disturb", this.a);
    if ((i1 != 1) && (!FriendsStatusUtil.a(getBaseActivity())))
    {
      this.t.setVisibility(8);
      this.u.setVisibility(8);
      this.mContentView.findViewById(2131432053).setVisibility(8);
    }
    else
    {
      this.t.setVisibility(0);
      this.u.setVisibility(0);
      if (!this.G)
      {
        this.G = true;
        ReportController.a(this.e, "0X800B7E6");
      }
      this.mContentView.findViewById(2131432053).setVisibility(0);
      ReportController.a(this.e, "0X800B7E5");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" showOpen DISTURB=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("IphoneTitleBarFragment", 4, ((StringBuilder)localObject).toString());
    }
    this.v = this.mContentView.findViewById(2131446172);
    this.v.setVisibility(8);
    this.i = ((FormSwitchItem)this.mContentView.findViewById(2131445885));
    this.j = ((FormSwitchItem)this.mContentView.findViewById(2131445879));
    this.k = ((FormSwitchItem)this.mContentView.findViewById(2131445887));
    this.n = ((FormSwitchItem)this.mContentView.findViewById(2131445910));
    this.l = ((FormSwitchItem)this.mContentView.findViewById(2131437714));
    this.m = ((FormSwitchItem)this.mContentView.findViewById(2131439921));
    Object localObject = this.e;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      if (PushMsgBtnConfProcessor.a(this.e.getApp(), this.e.getAccount()) == 1)
      {
        i1 = 1;
        break label619;
      }
    }
    else
    {
      QLog.d("IphoneTitleBarFragment", 1, "App is null, can't display 'new' flag for SpecialCare");
    }
    i1 = 0;
    label619:
    boolean bool1 = SettingCloneUtil.readValue(getBaseActivity(), this.a, getString(2131915892), "qqsetting_notify_showcontent_key", true);
    this.E = FriendsStatusUtil.a(getBaseActivity());
    boolean bool3 = SettingCloneUtil.readValue(getBaseActivity(), this.a, getString(2131915890), "qqsetting_notify_blncontrol_key", true);
    boolean bool4 = SettingCloneUtil.readValue(getBaseActivity(), null, null, "qqsetting_show_badgeunread_key", true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getString(2131915888));
    ((StringBuilder)localObject).append(this.a);
    boolean bool5 = LocalMultiProcConfig.getBool(((StringBuilder)localObject).toString(), true);
    boolean bool2 = SettingCloneUtil.readValue(getBaseActivity(), this.a, getString(2131891413), "qqsetting_lock_screen_whenexit_key", true);
    boolean bool6 = SettingCloneUtil.readValue(getBaseActivity(), this.a, null, "qqsetting_pcactive_key", false);
    SettingCloneUtil.readValue(getBaseActivity(), this.a, null, "qqsetting_kandian_key", true);
    localObject = (BubbleManager)this.e.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    int i2;
    if (localObject != null)
    {
      bool7 = ((BubbleManager)localObject).m.b();
      if (bool7)
      {
        this.g.setChecked(((BubbleManager)localObject).m.a());
        this.g.setOnCheckedChangeListener(new NotifyPushSettingFragment.4(this, (BubbleManager)localObject));
        VasWebviewUtil.a(this.e.getCurrentAccountUin(), "bubble_new", "show", "0", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      localObject = this.g;
      if (bool7) {
        i2 = 0;
      } else {
        i2 = 8;
      }
      ((FormSwitchItem)localObject).setVisibility(i2);
    }
    boolean bool7 = AVUtil.a(this.e.getCurrentAccountUin());
    this.o.setVisibility(0);
    this.o.setChecked(bool7);
    bool7 = this.y.b();
    this.p.setChecked(bool7);
    this.p.setOnCheckedChangeListener(this.c);
    this.p.setOnClickListener(this.K);
    this.q.setOnClickListener(this.K);
    this.o.setOnClickListener(this.K);
    localObject = this.q;
    if (this.p.a()) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    ((NewFormSwitchItem)localObject).setVisibility(i2);
    localObject = this.z;
    if (localObject != null)
    {
      this.q.setChecked(((ForegroundNotifyManager)localObject).b());
      this.q.setOnCheckedChangeListener(this.z.a(getBaseActivity(), this.q));
      if (this.z.f()) {
        this.q.setVisibility(8);
      }
    }
    this.y.a(getBaseActivity(), this.s);
    this.b = new NotifyPushSettingFragment.5(this);
    this.o.setOnCheckedChangeListener(this.b);
    this.h.setChecked(bool1);
    this.h.setOnCheckedChangeListener(new NotifyPushSettingFragment.6(this));
    if (AppSetting.e) {
      this.h.setContentDescription(HardCodeUtil.a(2131905471));
    }
    a(this.E, false);
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.i.setVisibility(8);
    }
    else
    {
      this.i.setVisibility(0);
      this.i.setChecked(bool3);
      this.i.setOnCheckedChangeListener(new NotifyPushSettingFragment.7(this));
    }
    this.j.setChecked(bool4);
    this.j.setOnCheckedChangeListener(new NotifyPushSettingFragment.8(this));
    if (BadgeUtils.a(this.e.getApplication()))
    {
      this.j.setVisibility(0);
      ReportController.a(this.e, "0X800B7E9");
    }
    else
    {
      this.j.setVisibility(8);
    }
    this.k.setChecked(bool5);
    this.k.setOnCheckedChangeListener(new NotifyPushSettingFragment.9(this));
    this.e.addObserver(this.I, true);
    localObject = (CardHandler)this.e.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    this.m.setChecked(bool6);
    this.m.setOnCheckedChangeListener(new NotifyPushSettingFragment.10(this, (CardHandler)localObject));
    localObject = (CardHandler)this.e.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (i1 != 0)
    {
      this.n.setVisibility(0);
      bool3 = SettingCloneUtil.readValue(getBaseActivity(), this.a, null, "qqsetting_show_push_message", true);
      this.n.setChecked(bool3);
      this.n.setContentDescription(getString(2131916671));
      this.n.setOnCheckedChangeListener(new NotifyPushSettingFragment.11(this, (CardHandler)localObject));
    }
    else
    {
      this.n.setVisibility(8);
    }
    localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.e, TempGetProfileDetailProcessor.class);
    if (localObject != null) {
      ((TempGetProfileDetailProcessor)localObject).getPCActiveState();
    }
    if (SettingCloneUtil.readValue(this.e.getApplication(), this.e.getAccount(), null, "pcactive_config", false))
    {
      this.m.setVisibility(0);
      ReportController.a(this.e, "0X800B7EB");
    }
    else
    {
      this.m.setVisibility(8);
    }
    this.l.setChecked(bool2);
    if (a())
    {
      this.l.setChecked(false);
      this.l.setVisibility(8);
    }
    else if (bool1)
    {
      this.l.setVisibility(0);
      this.l.setVisibility(8);
    }
    else
    {
      this.l.setVisibility(8);
    }
    this.l.setOnCheckedChangeListener(new NotifyPushSettingFragment.12(this));
    if (AppSetting.e) {
      this.l.setContentDescription(HardCodeUtil.a(2131905479));
    }
    this.f.setOnClickListener(new NotifyPushSettingFragment.13(this));
    this.w.setOnClickListener(new NotifyPushSettingFragment.14(this));
    this.v.setOnClickListener(new NotifyPushSettingFragment.15(this));
    if (AppSetting.e)
    {
      this.v.setContentDescription(HardCodeUtil.a(2131905476));
      this.p.setContentDescription(getString(2131892126));
      this.q.setContentDescription(getString(2131917326));
      localObject = this.r;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131892201));
      localStringBuilder.append(getString(2131916310));
      ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
      this.o.setContentDescription(HardCodeUtil.a(2131905475));
      this.h.setContentDescription(HardCodeUtil.a(2131905468));
      this.i.setContentDescription(HardCodeUtil.a(2131915890));
      this.k.setContentDescription(HardCodeUtil.a(2131905466));
      this.t.setContentDescription(getString(2131892710));
      this.m.setContentDescription("PC离线时自动启动QQ手机版");
      this.f.setContentDescription(HardCodeUtil.a(2131905473));
      this.w.setContentDescription(getString(2131917156));
      this.t.setContentDescription(getString(2131892710));
      this.u.setContentDescription(getString(2131892711));
    }
    ((ConfigHandler)this.e.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).m();
    d();
  }
  
  private void d()
  {
    ReportController.a(this.e, "0X800B7E0");
    ReportController.a(this.e, "0X800B7E2");
    ReportController.a(this.e, "0X800B7E4");
    ReportController.a(this.e, "0X800B7E7");
    ReportController.a(this.e, "0X800B7E8");
    ReportController.a(this.e, "0X800B7EA");
    if ((!this.F) && (this.q.getVisibility() == 0))
    {
      this.F = true;
      ReportController.a(this.e, "0X800B7E1");
    }
  }
  
  private void e()
  {
    if (!this.t.a()) {
      return;
    }
    DialogUtil.a(getBaseActivity(), 230).setMessage(2131892147).setPositiveButton(2131888768, new NotifyPushSettingFragment.27(this)).setNegativeButton(2131918093, new NotifyPushSettingFragment.26(this)).show();
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
    setTitle(getResources().getString(2131916370));
    paramLayoutInflater = this.e;
    if (paramLayoutInflater != null) {
      this.a = paramLayoutInflater.getCurrentAccountUin();
    }
    this.y = NewMsgNotificationManager.a(this.e);
    this.z = ForegroundNotifyManager.a(this.e);
    c();
    paramLayoutInflater = new IntentFilter();
    paramLayoutInflater.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramLayoutInflater.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    getBaseActivity().registerReceiver(this.d, paramLayoutInflater);
  }
  
  protected int getContentLayoutId()
  {
    return 2131625534;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.e;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.I);
      if (BadgeUtils.a(this.e.getApplication())) {
        BadgeUtils.c();
      }
    }
    this.y.d();
    this.z.g();
    getBaseActivity().unregisterReceiver(this.d);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.e.getApp().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.E)
    {
      int i1 = (int)NetConnInfoCenter.getServerTime();
      int i2 = SettingCloneUtil.readValueForInt(getBaseActivity().getApplicationContext(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
      TextView localTextView = this.u.getRightTextView();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131905467));
      localStringBuilder.append(NotifyPushSettingFragment.TimePickDialog.b((i2 - i1) * 1000));
      localTextView.setText(localStringBuilder.toString());
    }
    this.y.a(this.p, this.s, this.o, this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment
 * JD-Core Version:    0.7.0.1
 */