package com.tencent.mobileqq.kandian.biz.atlas;

import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingFragment;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity;
import com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.RIJUserInfoSp;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoReq;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = AppConstants.NEW_KANDIAN_UIN;
  private boolean A;
  private boolean B;
  private CompoundButton.OnCheckedChangeListener C;
  private boolean D;
  private boolean E;
  private KandianMergeManager F;
  private int G = 2;
  private String[] H;
  private ActionSheet I;
  private ActionSheet J;
  private ActionSheet K;
  private String L = "QQ看点";
  private final String M = HardCodeUtil.a(2131910601);
  private final String N = this.M;
  private final String O = HardCodeUtil.a(2131910411);
  private final String P = HardCodeUtil.a(2131910369);
  private final String Q = HardCodeUtil.a(2131910302);
  private final String R = this.P;
  private final String S = HardCodeUtil.a(2131910283);
  private final String T = HardCodeUtil.a(2131910281);
  private final String U = HardCodeUtil.a(2131910425);
  private final String V = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  private boolean W;
  private Switch X;
  private IPublicAccountObserver Y;
  private DialogInterface.OnKeyListener Z = new ReadInJoySettingActivity.20(this);
  QQAppInterface b;
  Intent c;
  View d;
  QQProgressDialog e;
  protected int f = 0;
  protected boolean g = false;
  protected boolean h = false;
  protected boolean i = false;
  protected int j = 0;
  public Handler k = new Handler();
  public Context l;
  public Resources m;
  Calendar n = Calendar.getInstance();
  private Switch o;
  private Switch p;
  private Switch q;
  private Switch r;
  private View s;
  private TextView t;
  private TextView u;
  private Switch v;
  private LinearLayout w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  private void a(String paramString)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.addStringNotThrow("uin", RIJQQAppInterfaceUtil.d());
    localReportR5Builder.addStringNotThrow("enter_page", "1");
    PublicAccountReportUtils.a(null, RIJQQAppInterfaceUtil.d(), paramString, paramString, 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "createVideoActionSheet");
    }
    if (this.K != null) {
      return;
    }
    this.K = ((ActionSheet)ActionSheetHelper.b(this, null));
    this.K.addRadioButton(this.m.getString(2131897942), 5, false);
    this.K.addRadioButton(this.m.getString(2131897944), 5, false);
    this.K.addRadioButton(this.m.getString(2131897943), 5, false);
    this.K.setRadioButtonChecked(paramInt);
    this.K.addCancelButton(2131887648);
    this.K.setOnButtonClickListener(new ReadInJoySettingActivity.18(this));
    this.K.setOnDismissListener(new ReadInJoySettingActivity.19(this));
  }
  
  private void b(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("uin", localQQAppInterface.getCurrentAccountUin());
        if (!paramBoolean) {
          break label139;
        }
        i1 = 1;
        localJSONObject2.put("state", i1);
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("report youngster switch click");
          localStringBuilder.append(localJSONException.toString());
          QLog.e("ReadInJoySettingActivity", 2, localStringBuilder.toString());
        }
      }
      PublicAccountReportUtils.a(localQQAppInterface, "", "0X800AB85", "0X800AB85", 0, 0, localJSONObject1.toString(), localJSONObject2.toString(), "", "");
      return;
      label139:
      int i1 = 0;
    }
  }
  
  private void c()
  {
    RIJJumpUtils.a(this, "https://viola.qq.com/js/userSetting.js?_rij_violaUrl=1&v_tid=6&v_bundleName=userSetting&hideNav=1&v_nav_immer=1&v_bid=3740&enter_page=1", null);
    a("0X800BD29");
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestChangeYoungsterMode, value = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.e("ReadInJoySettingActivity", 2, ((StringBuilder)localObject).toString());
    localObject = new oidb_0xe1b.ReqBody();
    ((oidb_0xe1b.ReqBody)localObject).uint32_req_type.set(2);
    oidb_0xe1b.SetFlagInfoReq localSetFlagInfoReq = new oidb_0xe1b.SetFlagInfoReq();
    flag_info.FlagInfo localFlagInfo = new flag_info.FlagInfo();
    localFlagInfo.uint64_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    if (paramBoolean) {
      localFlagInfo.uint32_teenager_flag.set(1);
    } else {
      localFlagInfo.uint32_teenager_flag.set(0);
    }
    localSetFlagInfoReq.rpt_msg_flag_info_list.add(localFlagInfo);
    ((oidb_0xe1b.ReqBody)localObject).msg_set_flag_info_req.set(localSetFlagInfoReq);
    ProtoUtils.a((QQAppInterface)getAppInterface(), new ReadInJoySettingActivity.ChangeYoungsterModeCallback(this, paramBoolean), ((oidb_0xe1b.ReqBody)localObject).toByteArray(), "OidbSvc.0xe1b", 3611, 1);
  }
  
  private void d()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void d(boolean paramBoolean)
  {
    this.j += 1;
    this.h = true;
    this.g = true;
    a(2131897928);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    } else {
      localSetMessageConfigurationRequest.type.set(2);
    }
    localSetMessageConfigurationRequest.versionInfo.set(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getVersionInfo());
    localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
    localNewIntent.putExtra("kandian_seq", this.j);
    ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
    this.f += 1;
    this.b.startServlet(localNewIntent);
  }
  
  private void e()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyProteusFamilyFragment.class);
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    }
    SettingCloneUtil.writeValue(this, this.b.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void f()
  {
    this.b = ((QQAppInterface)super.getAppRuntime());
    if (this.b == null) {
      return;
    }
    Object localObject;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(((ReadInJoyNewFeedsTopGestureLayout)localObject).a());
    }
    this.l = this.b.getApplication().getApplicationContext();
    this.m = this.b.getApplication().getResources();
    setTitle(HardCodeUtil.a(2131910305));
    this.leftView.setContentDescription(HardCodeUtil.a(2131901576));
    this.F = ((KandianMergeManager)this.b.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.x = this.F.j();
    this.y = this.F.k();
    this.z = SettingCloneUtil.readValue(this, this.b.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.E = RIJShowKanDianTabSp.c();
    boolean bool = true;
    this.D = true;
    try
    {
      if (RIJAppSetting.a() != null) {
        this.G = Integer.parseInt(RIJAppSetting.a());
      }
      label199:
      this.L = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getName(this.b, this.l, 3);
      localObject = p();
      ((ImageView)findViewById(2131435219)).setImageDrawable((Drawable)localObject);
      localObject = (TextView)findViewById(2131439134);
      ((TextView)localObject).setText(this.L);
      ((TextView)localObject).setContentDescription(this.L);
      localObject = (TextView)findViewById(2131431750);
      ((TextView)localObject).setText(String.format(this.O, new Object[] { this.L }));
      ((TextView)localObject).setContentDescription(String.format(this.O, new Object[] { this.L }));
      g(this.D);
      localObject = (TextView)findViewById(2131444418);
      ((TextView)localObject).setText(String.format(this.N, new Object[] { this.L }));
      ((TextView)localObject).setContentDescription(String.format(this.N, new Object[] { this.L }));
      r();
      q();
      b(this.G);
      h();
      i();
      this.v = ((Switch)findViewById(2131449238));
      this.w = ((LinearLayout)findViewById(2131437591));
      localObject = this.w;
      int i1;
      if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((LinearLayout)localObject).setVisibility(i1);
      localObject = this.v;
      if (RIJUserInfoSp.b() != 0) {
        bool = false;
      }
      ((Switch)localObject).setChecked(bool);
      this.v.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131915571)));
      ((TextView)findViewById(2131448354)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131915571)));
      this.v.setOnCheckedChangeListener(new ReadInJoySettingActivity.2(this));
      PublicAccountReportUtils.a(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
      o();
      l();
      this.s = findViewById(2131435862);
      this.s.setOnClickListener(this);
      j();
      k();
      this.b.addObserver(this.Y.getBusinessObserver());
      n();
      s();
      findViewById(2131435082).setOnClickListener(this);
      return;
    }
    catch (Exception localException)
    {
      break label199;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    ReadInJoyHelper.a(this.b, paramBoolean ^ true);
    this.x = paramBoolean;
    d(this.x);
    if (paramBoolean)
    {
      g(paramBoolean);
      this.o.setChecked(this.x);
      ReportController.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    PublicAccountReportUtils.a("0X80067F9", "", "", "", "", RIJTransMergeKanDianReport.a());
    g(paramBoolean);
  }
  
  private void g()
  {
    if (StudyModeManager.h())
    {
      QLog.i("ReadInJoySettingActivity", 1, "[initHomeFeedsStyleSetting] is youth mode.");
      findViewById(2131435082).setVisibility(8);
      return;
    }
    int i1;
    if (((Boolean)RIJSPUtils.b("rij_user_setting_has_set_sp_key", Boolean.valueOf(false))).booleanValue()) {
      i1 = ((Integer)RIJSPUtils.b("rij_user_setting_feeds_style_type_sp_key", Integer.valueOf(1))).intValue();
    } else if (RIJXTabConfigHandler.INSTANCE.getDefaultEnterTabId() == 41726) {
      i1 = 3;
    } else {
      i1 = 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initHomeFeedsStyleSetting] feedsStyleType = ");
    ((StringBuilder)localObject).append(i1);
    QLog.i("ReadInJoySettingActivity", 1, ((StringBuilder)localObject).toString());
    if (this.u == null) {
      this.u = ((TextView)findViewById(2131435083));
    }
    if (i1 != 3)
    {
      if (i1 != 4) {
        localObject = HardCodeUtil.a(2131897907);
      } else {
        localObject = HardCodeUtil.a(2131897905);
      }
    }
    else {
      localObject = HardCodeUtil.a(2131897906);
    }
    TextView localTextView = this.u;
    if (localTextView != null) {
      localTextView.setText((CharSequence)localObject);
    }
    a("0X800BD28");
  }
  
  private void g(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131445712);
    TextView localTextView = (TextView)findViewById(2131446341);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(HardCodeUtil.a(2131910414));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(HardCodeUtil.a(2131910593));
  }
  
  private void h()
  {
    this.e = new QQProgressDialog(this, super.getTitleBarHeight());
    this.e.setCanceledOnTouchOutside(true);
    this.e.a(new ReadInJoySettingActivity.3(this));
  }
  
  private void i()
  {
    this.p = ((Switch)findViewById(2131440286));
    this.p.setChecked(this.z);
    this.p.setOnCheckedChangeListener(new ReadInJoySettingActivity.4(this));
  }
  
  private void j()
  {
    boolean bool = ThemeUtil.isInNightMode(this.b);
    this.d = findViewById(2131442126);
    View localView;
    if (bool)
    {
      localView = this.d;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.d;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  private void k()
  {
    if (ReadInJoyHelper.f(this.b))
    {
      localObject = findViewById(2131444304);
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(new ReadInJoySettingActivity.5(this));
      return;
    }
    findViewById(2131444417).setVisibility(0);
    Object localObject = (TextView)findViewById(2131444419);
    ((TextView)localObject).setText(this.P);
    ((TextView)localObject).setContentDescription(this.P);
    m();
  }
  
  private void l()
  {
    this.t = ((TextView)findViewById(2131436725));
    this.r = ((Switch)findViewById(2131445900));
    this.r.setChecked(this.E);
    this.r.setOnCheckedChangeListener(new ReadInJoySettingActivity.6(this));
    if (this.E)
    {
      this.t.setText(2131915528);
      return;
    }
    this.t.setText(2131915531);
  }
  
  private void m()
  {
    this.o = ((Switch)findViewById(2131436727));
    this.o.setChecked(this.x ^ true);
    this.o.setOnCheckedChangeListener(new ReadInJoySettingActivity.7(this));
  }
  
  private void n()
  {
    View localView1 = findViewById(2131427348);
    View localView2 = findViewById(2131432565);
    View localView3 = findViewById(2131439609);
    View localView4 = findViewById(2131431563);
    View localView5 = findViewById(2131428283);
    View localView6 = findViewById(2131446635);
    View localView7 = findViewById(2131432107);
    View localView8 = findViewById(2131433169);
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    localView3.setVisibility(8);
    localView4.setVisibility(8);
    localView5.setVisibility(8);
    localView6.setVisibility(8);
    localView7.setVisibility(8);
    localView8.setVisibility(8);
  }
  
  private void o()
  {
    this.C = new ReadInJoySettingActivity.12(this);
    boolean bool = false;
    if (((Integer)RIJSPUtils.b("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {
      bool = true;
    }
    this.A = bool;
    this.B = this.A;
    this.q = ((Switch)findViewById(2131450366));
    this.q.setChecked(this.A);
    this.q.setOnCheckedChangeListener(this.C);
  }
  
  private Drawable p()
  {
    IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.b, this.l, 3);
    if ((localPublicAccountConfigFolder != null) && (localPublicAccountConfigFolder.c() != null)) {
      return localPublicAccountConfigFolder.c();
    }
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(this.l, 3);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showConfirmDialog");
    }
    if (this.I != null) {
      return;
    }
    String str = String.format(this.M, new Object[] { this.L });
    this.I = ((ActionSheet)ActionSheetHelper.b(this, null));
    this.I.setMainTitle(str);
    this.I.addButton(this.R, 3);
    this.I.addCancelButton(2131887648);
    this.I.setOnButtonClickListener(new ReadInJoySettingActivity.14(this));
    this.I.setOnDismissListener(new ReadInJoySettingActivity.15(this));
    this.I.setOnKeyListener(this.Z);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.J != null) {
      return;
    }
    String str = String.format(this.U, new Object[] { this.L });
    this.J = ((ActionSheet)ActionSheetHelper.b(this, null));
    this.J.setMainTitle(str);
    this.J.addButton(String.format(this.T, new Object[] { this.L }), 3);
    this.J.addCancelButton(2131887648);
    this.J.setOnButtonClickListener(new ReadInJoySettingActivity.16(this));
    this.J.setOnDismissListener(new ReadInJoySettingActivity.17(this));
  }
  
  private void s()
  {
    this.X = ((Switch)findViewById(2131431111));
    t();
    this.X.setOnCheckedChangeListener(new ReadInJoySettingActivity.21(this));
  }
  
  private void t()
  {
    boolean bool = ReadInJoyHelper.Y();
    this.X.setChecked(bool);
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (ThemeUtil.isInNightMode(this.b))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.g())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
    this.leftView.setTextColor(-14408926);
    this.leftView.setTextColor(-14408926);
    this.leftView.setBackgroundResource(2130851519);
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    this.vg.setBackgroundColor(-1);
  }
  
  protected void a(int paramInt)
  {
    this.s.postDelayed(new ReadInJoySettingActivity.13(this, paramInt), 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.o.setChecked(paramBoolean ^ true);
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    RIJDtReportHelper.a.a(getActivity(), "44");
    setContentView(2131626330);
    this.c = getIntent();
    this.Y = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.Y.setOnCallback(new ReadInJoySettingActivity.1(this));
    f();
    if (!ThemeUtil.isInNightMode(this.b)) {
      a();
    }
    this.W = false;
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.I;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      this.I.dismiss();
      this.I = null;
    }
    localObject = this.J;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      this.J.dismiss();
      this.J = null;
    }
    localObject = this.K;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      this.K.dismiss();
      this.K = null;
    }
    super.doOnDestroy();
    this.e = null;
    this.b = ((QQAppInterface)super.getAppRuntime());
    localObject = this.b;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.Y.getBusinessObserver());
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.A != this.B) {
      RIJSPUtils.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(true));
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.W)
    {
      QLog.d("ReadInJoySettingActivity", 1, "refresh channel list while leave interest label");
      this.W = false;
    }
    g();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131449707: 
      this.K.show();
      return;
    case 2131439609: 
      ViolaAccessHelper.a(this.mContentView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
      return;
    case 2131435862: 
      this.W = true;
      ReadInJoyHelper.b(this.b);
      ReadInJoyActivityHelper.INSTANCE.launchInterestActivity(this);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      return;
    case 2131435082: 
      c();
      return;
    case 2131432565: 
      ReadInJoySelfActivity.a(this);
      return;
    case 2131431563: 
      d();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */