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
import android.text.TextUtils;
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
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendCardUtils;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.model.MultiAIOManager;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AssistantSettingFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  private boolean A;
  private QQAppInterface B;
  private ActivateFriendsManager C;
  private FormSwitchItem D;
  private TextView E;
  private TextView F;
  private CardObserver G = new AssistantSettingFragment.1(this);
  private ProfileCommonObserver H = new AssistantSettingFragment.2(this);
  private CompoundButton.OnCheckedChangeListener I = new AssistantSettingFragment.3(this);
  private CompoundButton.OnCheckedChangeListener J = new AssistantSettingFragment.4(this);
  private View.OnClickListener K = new AssistantSettingFragment.5(this);
  private View.OnClickListener L = new AssistantSettingFragment.6(this);
  private FormSwitchItem M;
  private FormSimpleItem N;
  private FormSimpleItem O;
  private FormMultiLineSwitchItem P;
  private CompoundButton.OnCheckedChangeListener Q = new AssistantSettingFragment.41(this);
  private CTEntryListener R = new AssistantSettingFragment.42(this);
  QQProgressDialog a;
  BounceScrollView b;
  FormSwitchItem c;
  C2CShortcutBarObserver d = new AssistantSettingFragment.7(this);
  CompoundButton.OnCheckedChangeListener e = new AssistantSettingFragment.40(this);
  TextView f;
  HeightAdaptableListView g;
  AssistantSettingFragment.EntryListAdapter h;
  CTEntryMng i;
  protected QQCustomDialog j = null;
  protected QQCustomDialog k = null;
  private FormSwitchItem l;
  private FormSwitchItem m;
  private FormSwitchItem n;
  private FormSwitchItem o;
  private FormMultiLineSwitchItem p;
  private FormSwitchItem q;
  private FormMultiLineSwitchItem r;
  private FormSwitchItem s;
  private FormSwitchItem t;
  private FormSimpleItem u;
  private FormSimpleItem v;
  private FormSwitchItem w;
  private FormSwitchItem x;
  private FormSimpleItem y;
  private FormSwitchItem z;
  
  private void A()
  {
    QVipConfigManager.b(this.B, "have_show_ptt_tip", true);
    if (this.k == null) {
      this.k = DialogUtil.a(getBaseActivity(), 0, null, HardCodeUtil.a(2131899026), 0, 2131916601, new AssistantSettingFragment.45(this), null);
    }
    this.k.show();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getBaseActivity().getTitleBarHeight());
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
    paramCompoundButton.setOnCheckedChangeListener(new AssistantSettingFragment.39(this));
  }
  
  private void a(List<CTEntry> paramList)
  {
    if (StudyModeManager.h()) {
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
          if (localCTEntry.m)
          {
            this.P.setVisibility(8);
          }
          else
          {
            this.P.setVisibility(0);
            b(this.i.e() ^ true);
          }
        }
      }
    }
    Object localObject = this.h;
    if (this.P.getVisibility() != 0) {
      bool = false;
    }
    ((AssistantSettingFragment.EntryListAdapter)localObject).a(bool);
    this.h.a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    this.n = ((FormSwitchItem)this.mContentView.findViewById(2131450394));
    if ((RichTextChatManager.a(this.B).b(this.B)) && (!paramBoolean))
    {
      this.n.setVisibility(0);
      paramBoolean = RichTextChatManager.a(this.B).a();
      this.n.setChecked(paramBoolean);
      this.n.setContentDescription(HardCodeUtil.a(2131899019));
      this.n.setChecked(paramBoolean);
      this.n.setOnCheckedChangeListener(new AssistantSettingFragment.22(this));
      ReportController.a(this.B, "0X800B81A");
      return;
    }
    this.n.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    FormSwitchItem localFormSwitchItem = this.l;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      this.l.setChecked(paramBoolean);
      this.l.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FormMultiLineSwitchItem localFormMultiLineSwitchItem = this.P;
    if (localFormMultiLineSwitchItem != null)
    {
      localFormMultiLineSwitchItem.setOnCheckedChangeListener(null);
      this.P.setChecked(paramBoolean);
      this.P.setOnCheckedChangeListener(this.Q);
    }
  }
  
  private void b(boolean paramBoolean, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    FormSwitchItem localFormSwitchItem = this.t;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      x();
      this.t.setChecked(paramBoolean);
      this.t.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject1 = this.B.getApp().getSharedPreferences("check_update_sp_key", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("businessinfo_ptt_auto_change_text_");
    ((StringBuilder)localObject2).append(this.B.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("businessinfo_ptt_auto_change_time_");
    ((StringBuilder)localObject3).append(this.B.getCurrentAccountUin());
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("businessinfo_ptt_auto_change_guide_has_show_");
    ((StringBuilder)localObject4).append(this.B.getCurrentAccountUin());
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject2, paramBoolean);
    long l1 = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      ((SharedPreferences.Editor)localObject1).putLong((String)localObject3, l1);
      ((SharedPreferences.Editor)localObject1).putBoolean((String)localObject4, true);
      PttConstants.h = true;
    }
    else
    {
      ((SharedPreferences.Editor)localObject1).putLong((String)localObject3, 9223372036854775807L);
    }
    ((SharedPreferences.Editor)localObject1).commit();
    PttConstants.f = paramBoolean;
    PttConstants.g = l1;
  }
  
  private void d()
  {
    boolean bool = SimpleUIUtil.e();
    Object localObject = this.mContentView.findViewById(2131440586);
    this.r = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131428738));
    h();
    i();
    j();
    k();
    v();
    t();
    this.t = ((FormSwitchItem)this.mContentView.findViewById(2131440980));
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerEnable())
    {
      if (getBaseActivity().getIntent().getBooleanExtra("need_open_tips", false)) {
        this.t.setBackgroundColor(getResources().getColor(2131168441));
      }
      b(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getCanOpenInSp(), this.J);
      ReportController.a(this.B, "0X800B821");
    }
    else
    {
      this.t.setVisibility(8);
      if (this.F == null) {
        this.F = ((TextView)this.mContentView.findViewById(2131440981));
      }
      this.F.setVisibility(8);
    }
    s();
    w();
    r();
    g();
    n();
    q();
    this.r.setVisibility(8);
    u();
    m();
    ((View)localObject).setOnClickListener(new AssistantSettingFragment.8(this));
    e();
    l();
    a(bool);
    p();
    this.f = ((TextView)this.mContentView.findViewById(2131431255));
    this.P = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131431243));
    b(this.i.e() ^ true);
    this.P.setVisibility(8);
    this.g = ((HeightAdaptableListView)this.mContentView.findViewById(2131431262));
    this.g.setHeightAdaptMode(2, 0);
    this.h = new AssistantSettingFragment.EntryListAdapter(getBaseActivity(), this.e);
    localObject = this.i;
    if (localObject != null) {
      a(((CTEntryMng)localObject).g());
    }
    this.g.setAdapter(this.h);
    y();
    f();
    o();
    if (AppSetting.e)
    {
      this.p.setContentDescription(HardCodeUtil.a(2131899017));
      this.c.setContentDescription(HardCodeUtil.a(2131899027));
      this.N.setContentDescription(HardCodeUtil.a(2131887859));
    }
    this.b = ((BounceScrollView)this.mContentView.findViewById(2131445142));
    this.b.post(new AssistantSettingFragment.9(this));
  }
  
  private void e()
  {
    this.l = ((FormSwitchItem)this.mContentView.findViewById(2131432466));
    boolean bool = ((IStickerRecManager)this.B.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen();
    this.l.setChecked(bool);
    this.l.setContentDescription(getResources().getString(2131888913));
    this.l.setOnCheckedChangeListener(this.I);
    ReportController.a(this.B, "0X800B819");
  }
  
  private void f()
  {
    this.N = ((FormSimpleItem)this.mContentView.findViewById(2131430970));
    this.N.setVisibility(0);
    this.N.setOnClickListener(new AssistantSettingFragment.10(this));
    ReportController.a(this.B, "0X800B822");
  }
  
  private void g()
  {
    this.D = ((FormSwitchItem)this.mContentView.findViewById(2131427587));
    this.D.setChecked(this.C.a(true));
    this.D.setOnCheckedChangeListener(new AssistantSettingFragment.11(this));
    ReportController.a(this.B, "0X800B827");
  }
  
  private void h()
  {
    this.v = ((FormSimpleItem)this.mContentView.findViewById(2131433883));
    this.v.setOnClickListener(new AssistantSettingFragment.12(this));
    ReportController.a(this.B, "0X800B818");
    this.v.setContentDescription(getString(2131888296));
  }
  
  private void i()
  {
    this.u = ((FormSimpleItem)this.mContentView.findViewById(2131433882));
    this.u.setOnClickListener(new AssistantSettingFragment.13(this));
    ReportController.a(this.B, "0X800B817");
    this.u.setContentDescription(getString(2131892376));
  }
  
  private void j()
  {
    this.y = ((FormSimpleItem)this.mContentView.findViewById(2131430908));
    this.y.setOnClickListener(new AssistantSettingFragment.14(this));
    this.y.setContentDescription(getString(2131887078));
  }
  
  private void k()
  {
    this.z = ((FormSwitchItem)this.mContentView.findViewById(2131432683));
    if (!ExtendFriendCardUtils.a(this.B))
    {
      this.z.setVisibility(8);
      return;
    }
    this.z.setChecked(((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getExtendFriendUserSwitch(this.B));
    this.z.setText(((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getExtendFriendUserSwitchText());
    ILimitChatUtils localILimitChatUtils = (ILimitChatUtils)QRoute.api(ILimitChatUtils.class);
    QQAppInterface localQQAppInterface = this.B;
    localILimitChatUtils.getExtendFriendSwitch(localQQAppInterface, Long.valueOf(localQQAppInterface.getCurrentUin()), new -..Lambda.AssistantSettingFragment.eIEpes0comvo0_r2zWCH8HwAyzQ(this));
    this.z.setOnCheckedChangeListener(new AssistantSettingFragment.18(this));
    this.z.setContentDescription(getString(2131896868));
  }
  
  private void l()
  {
    this.m = ((FormSwitchItem)this.mContentView.findViewById(2131432076));
    IDoutuService localIDoutuService = (IDoutuService)this.B.getRuntimeService(IDoutuService.class, "");
    localIDoutuService.setApp(this.B);
    if ((localIDoutuService.isDoutuConfigOpen()) && (localIDoutuService.checkLocalResFiles()))
    {
      this.m.setVisibility(0);
      boolean bool = localIDoutuService.isDoutuSettingOpen();
      this.m.setChecked(bool);
      this.m.setContentDescription(HardCodeUtil.a(2131899015));
      this.m.setOnCheckedChangeListener(new AssistantSettingFragment.19(this, localIDoutuService));
      ReportController.a(this.B, "0X800B81B");
      return;
    }
    this.m.setVisibility(8);
  }
  
  private void m()
  {
    this.M = ((FormSwitchItem)this.mContentView.findViewById(2131439022));
    if (((MultiAIOManager)this.B.getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).c())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("AssistantSettingFragment", 2, "MultiAio switch is open, so switch is visible");
      }
      this.M.setVisibility(0);
      boolean bool = MultiAIOHelper.a();
      this.M.setChecked(bool);
      this.M.setOnCheckedChangeListener(new AssistantSettingFragment.20(this));
      ReportController.a(this.B, "0X800B823");
    }
  }
  
  private void n()
  {
    this.q = ((FormSwitchItem)this.mContentView.findViewById(2131439479));
    this.q.setChecked(this.B.getNowLiveManager().d);
    this.q.setText(getText(2131892233));
    FormSwitchItem localFormSwitchItem = this.q;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131899020));
    localStringBuilder.append(QQStoryConstant.a);
    localStringBuilder.append(HardCodeUtil.a(2131899024));
    localFormSwitchItem.setContentDescription(localStringBuilder.toString());
    this.q.setOnCheckedChangeListener(new AssistantSettingFragment.21(this));
    this.q.setBackgroundResource(2130839622);
    this.q.setVisibility(0);
    if ((QQStoryManager.o()) && (this.B.getNowLiveManager().i != '0') && (this.B.getNowLiveManager().i != '1'))
    {
      StoryReportor.a("dynamic_more", "exp_storyset", 0, 0, new String[0]);
      return;
    }
    this.q.setVisibility(8);
  }
  
  private void o()
  {
    try
    {
      FormMultiLineSwitchItem localFormMultiLineSwitchItem = (FormMultiLineSwitchItem)this.mContentView.findViewById(2131446266);
      TextView localTextView = (TextView)this.mContentView.findViewById(2131448691);
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.B.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (localSpringFestivalEntryManager.g())
      {
        localTextView.setVisibility(0);
        localFormMultiLineSwitchItem.setVisibility(0);
        localFormMultiLineSwitchItem.setOnCheckedChangeListener(new AssistantSettingFragment.23(this, localSpringFestivalEntryManager));
        localFormMultiLineSwitchItem.setChecked(localSpringFestivalEntryManager.h());
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
  
  private void p() {}
  
  private void q()
  {
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131445330));
    boolean bool = SettingCloneUtil.readValue(getBaseActivity(), null, super.getString(2131892702), "qqsetting_screenshot_key", false);
    this.c.setChecked(bool);
    this.c.setOnCheckedChangeListener(new AssistantSettingFragment.32(this));
    ReportController.a(this.B, "0X800B825");
  }
  
  private void r()
  {
    this.p = ((FormMultiLineSwitchItem)this.mContentView.findViewById(2131428405));
    this.p.setVisibility(8);
  }
  
  private void s()
  {
    this.o = ((FormSwitchItem)this.mContentView.findViewById(2131446388));
    SharedPreferences localSharedPreferences = this.B.getApp().getSharedPreferences("sticker_pref", 0);
    if (EmojiStickerManager.d())
    {
      String str = this.B.getCurrentUin();
      FormSwitchItem localFormSwitchItem = this.o;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sticker_switch_");
      localStringBuilder.append(str);
      localFormSwitchItem.setChecked(localSharedPreferences.getBoolean(localStringBuilder.toString(), true));
      this.o.setOnCheckedChangeListener(new AssistantSettingFragment.34(this, localSharedPreferences, str));
      ReportController.a(this.B, "0X800B81C");
      return;
    }
    this.o.setVisibility(8);
  }
  
  private void t()
  {
    Object localObject1 = (PttAutoChangeBean)QConfigManager.b().b(442);
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
    this.E = ((TextView)this.mContentView.findViewById(2131440794));
    this.E.setVisibility(8);
    this.s = ((FormSwitchItem)this.mContentView.findViewById(2131440793));
    Object localObject2 = this.B.getApp().getSharedPreferences("check_update_sp_key", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessinfo_ptt_auto_change_text_");
    localStringBuilder.append(this.B.getCurrentAccountUin());
    ((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false);
    if (((localObject1 != null) && (((PttAutoChangeBean)localObject1).a())) || (PttConstants.f))
    {
      this.s.setVisibility(0);
      if (QVipAutoPttProcessor.e().a > 1)
      {
        this.E.setVisibility(0);
        this.s.setRightIcon(getResources().getDrawable(2130849322));
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_text_");
      ((StringBuilder)localObject1).append(this.B.getCurrentAccountUin());
      bool = ((SharedPreferences)localObject2).getBoolean(((StringBuilder)localObject1).toString(), false);
      this.s.setChecked(bool);
      this.s.setOnCheckedChangeListener(new AssistantSettingFragment.35(this));
      ReportController.a(this.B, "0X800B820");
      return;
    }
    com.tencent.qphone.base.util.QLog.e("vip_ptt.AssistantSettingFragment", 1, "disable the ptt check box");
    c(false);
    this.s.setVisibility(8);
  }
  
  private void u()
  {
    this.O = ((FormSimpleItem)this.mContentView.findViewById(2131429700));
    if (this.O != null)
    {
      ReportController.b(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "entrance_exp", 0, 0, "", "", "", "");
      if (a())
      {
        this.O.setVisibility(0);
        this.O.setOnClickListener(new AssistantSettingFragment.36(this));
        return;
      }
      this.O.setVisibility(8);
    }
  }
  
  private void v()
  {
    this.x = ((FormSwitchItem)this.mContentView.findViewById(2131445350));
    boolean bool = ScreenShotDetector.d();
    this.x.setVisibility(0);
    this.x.setChecked(bool);
    this.x.setOnCheckedChangeListener(new AssistantSettingFragment.37(this));
    ReportController.a(this.B, "0X800B824");
  }
  
  private void w()
  {
    this.w = ((FormSwitchItem)this.mContentView.findViewById(2131438991));
    boolean bool = C2CShortcutBarSwitcher.b();
    FormSwitchItem localFormSwitchItem = this.w;
    int i1;
    if (bool) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localFormSwitchItem.setVisibility(i1);
    if (bool)
    {
      this.w.setChecked(C2CShortcutBarSwitcher.a(this.B));
      this.w.setOnCheckedChangeListener(new AssistantSettingFragment.38(this));
      ReportController.b(this.B, "dc00898", "", "", "0X800B81D", "0X800B81D", 0, 0, "", "", "", "");
    }
  }
  
  private void x()
  {
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool = ((IFloatingWrapperManager)QRoute.api(IFloatingWrapperManager.class)).checkPermission(getBaseActivity());
    if (this.F == null) {
      this.F = ((TextView)this.mContentView.findViewById(2131440981));
    }
    if (((i1 != 0) && (bool)) || (!((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getCanOpenInSp()))
    {
      this.F.setText(Html.fromHtml(getResources().getString(2131893046)));
      this.F.setOnClickListener(this.K);
      return;
    }
    if (i1 != 0) {
      this.F.setText(Html.fromHtml(getResources().getString(2131893051)));
    } else if (bool) {
      this.F.setText(Html.fromHtml(getResources().getString(2131893049)));
    } else {
      this.F.setText(Html.fromHtml(getResources().getString(2131893047)));
    }
    this.F.setOnClickListener(this.L);
  }
  
  private void y()
  {
    if (StudyModeManager.h())
    {
      this.g.setVisibility(8);
      this.f.setVisibility(8);
      this.P.setVisibility(8);
      return;
    }
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((CTEntryMng)localObject).g();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        this.g.setVisibility(0);
        this.f.setVisibility(0);
      }
      else
      {
        this.g.setVisibility(8);
        this.f.setVisibility(8);
      }
    }
    else
    {
      this.g.setVisibility(8);
      this.f.setVisibility(8);
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCTEntrySetting visible: ");
      ((StringBuilder)localObject).append(this.g.getVisibility());
      com.tencent.qphone.base.util.QLog.i("AssistantSettingFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void z()
  {
    if (this.j == null) {
      this.j = DialogUtil.a(getBaseActivity(), 0, HardCodeUtil.a(2131899021), HardCodeUtil.a(2131899025), 2131892796, 2131892797, new AssistantSettingFragment.43(this), new AssistantSettingFragment.44(this));
    }
    this.j.show();
  }
  
  protected boolean a()
  {
    int i1 = TabDataHelper.getModelType();
    String str = TabDataHelper.getTabRuleList(this.B.getApplicationContext(), this.B.getCurrentUin(), i1);
    Map localMap = TabDataHelper.getTabSwitch(this.B.getApplicationContext(), this.B.getCurrentUin());
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[AssistantSettingFragment][getLocalTabCache]  allTabListCacheString: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" tabSwitchMap: ");
      localStringBuilder.append(localMap);
      com.tencent.qphone.base.util.QLog.d("AssistantSettingFragment", 2, localStringBuilder.toString());
    }
    if ((localMap != null) && (!TextUtils.isEmpty(str))) {
      return true;
    }
    ThreadManager.excute(new -..Lambda.AssistantSettingFragment.Jirc8-kKG_h_T1tojyJM83MaDAs(this), 160, null, true);
    return false;
  }
  
  protected void b()
  {
    QQCustomDialog localQQCustomDialog = this.k;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  protected void c()
  {
    QQCustomDialog localQQCustomDialog = this.j;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getBaseActivity().getResources().getString(2131892676));
    getBaseActivity().setVolumeControlStream(3);
    this.C = ((ActivateFriendsManager)this.B.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    getBaseActivity().addObserver(this.G);
    getBaseActivity().addObserver(this.d);
    getBaseActivity().addObserver(this.H);
    this.i = ((CTEntryMng)this.B.getManager(QQManagerFactory.CTENTRY_MNG));
    paramLayoutInflater = this.i;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.a(this.R);
      this.i.d(false);
      this.i.h();
    }
    d();
    paramLayoutInflater = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.B, TempGetProfileDetailProcessor.class);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.getEmotionRecSwitch();
    }
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getAssistantImplSwitch(this.B);
  }
  
  protected int getContentLayoutId()
  {
    return 2131627790;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.B = getBaseActivity().app;
    if (!this.B.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(getBaseActivity(), paramBundle, "/base/login");
      getBaseActivity().finish();
    }
  }
  
  public void onDestroy()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      getBaseActivity().dismissDialog(1);
    }
    if (this.G != null) {
      getBaseActivity().removeObserver(this.G);
    }
    if (this.d != null) {
      getBaseActivity().removeObserver(this.d);
    }
    if (this.H != null) {
      getBaseActivity().removeObserver(this.H);
    }
    localObject = this.i;
    if (localObject != null) {
      ((CTEntryMng)localObject).b(this.R);
    }
    c();
    b();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment
 * JD-Core Version:    0.7.0.1
 */