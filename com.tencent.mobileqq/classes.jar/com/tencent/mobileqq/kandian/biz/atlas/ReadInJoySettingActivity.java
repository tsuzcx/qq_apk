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
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingFragment;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity;
import com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.RIJUserInfoSp;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
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
  public static final String a;
  protected int a;
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new ReadInJoySettingActivity.20(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private KandianMergeManager jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  protected boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  private View jdField_b_of_type_AndroidViewView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private ActionSheet jdField_c_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131713040);
  protected boolean c;
  private Switch jdField_d_of_type_ComTencentWidgetSwitch;
  private final String jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private Switch jdField_e_of_type_ComTencentWidgetSwitch;
  private final String jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131712839);
  private boolean jdField_e_of_type_Boolean;
  private Switch jdField_f_of_type_ComTencentWidgetSwitch;
  private final String jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131712796);
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131712727);
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = HardCodeUtil.a(2131712707);
  private boolean jdField_i_of_type_Boolean;
  private final String jdField_j_of_type_JavaLangString = HardCodeUtil.a(2131712705);
  private boolean jdField_j_of_type_Boolean;
  private final String jdField_k_of_type_JavaLangString = HardCodeUtil.a(2131712853);
  private boolean jdField_k_of_type_Boolean;
  private final String l = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.NEW_KANDIAN_UIN;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localPublicAccountConfigFolder != null) && (localPublicAccountConfigFolder.a() != null)) {
      return localPublicAccountConfigFolder.a();
    }
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(this.jdField_a_of_type_AndroidContentContext, 3);
  }
  
  private void b()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "createVideoActionSheet");
    }
    if (this.jdField_c_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    this.jdField_c_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addRadioButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131699889), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addRadioButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131699891), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addRadioButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131699890), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.setRadioButtonChecked(paramInt);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoySettingActivity.18(this));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoySettingActivity.19(this));
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
          break label154;
        }
        m = 1;
        localJSONObject2.put("state", m);
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
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(localQQAppInterface, "", "0X800AB85", "0X800AB85", 0, 0, localJSONObject1.toString(), localJSONObject2.toString(), "", "");
      return;
      label154:
      int m = 0;
    }
  }
  
  private void c()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyProteusFamilyFragment.class);
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
    localFlagInfo.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(((ReadInJoyNewFeedsTopGestureLayout)localObject).a());
    }
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
    setTitle(HardCodeUtil.a(2131712730));
    this.leftView.setContentDescription(HardCodeUtil.a(2131712655));
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.c();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.d();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_j_of_type_Boolean = RIJShowKanDianTabSp.c();
    this.jdField_i_of_type_Boolean = true;
    try
    {
      if (RIJAppSetting.a() != null) {
        this.jdField_c_of_type_Int = Integer.parseInt(RIJAppSetting.a());
      }
      label197:
      this.jdField_b_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
      localObject = a();
      ((ImageView)findViewById(2131368343)).setImageDrawable((Drawable)localObject);
      localObject = (TextView)findViewById(2131371708);
      ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
      ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
      localObject = (TextView)findViewById(2131365532);
      ((TextView)localObject).setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
      ((TextView)localObject).setContentDescription(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
      g(this.jdField_i_of_type_Boolean);
      localObject = (TextView)findViewById(2131376210);
      ((TextView)localObject).setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
      ((TextView)localObject).setContentDescription(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
      n();
      m();
      b(this.jdField_c_of_type_Int);
      e();
      f();
      this.jdField_e_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131380308));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370334));
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      int m;
      if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1) {
        m = 0;
      } else {
        m = 8;
      }
      ((LinearLayout)localObject).setVisibility(m);
      localObject = this.jdField_e_of_type_ComTencentWidgetSwitch;
      boolean bool;
      if (RIJUserInfoSp.b() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((Switch)localObject).setChecked(bool);
      this.jdField_e_of_type_ComTencentWidgetSwitch.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718093)));
      ((TextView)findViewById(2131379596)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718093)));
      this.jdField_e_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.2(this));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
      l();
      i();
      this.jdField_b_of_type_AndroidViewView = findViewById(2131368915);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      findViewById(2131380739).setOnClickListener(this);
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131699889), this.jdField_a_of_type_AndroidContentResResources.getString(2131699891), this.jdField_a_of_type_AndroidContentResResources.getString(2131699890) };
      ((TextView)findViewById(2131372737)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      g();
      h();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
      k();
      o();
      return;
    }
    catch (Exception localException)
    {
      break label197;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    a(2131699875);
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
    localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
    ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new ReadInJoySettingActivity.3(this));
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void f()
  {
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131372739));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.4(this));
  }
  
  private void f(boolean paramBoolean)
  {
    ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean ^ true);
    this.jdField_d_of_type_Boolean = paramBoolean;
    d(this.jdField_d_of_type_Boolean);
    if (paramBoolean)
    {
      g(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      ReportController.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80067F9", "", "", "", "", RIJTransMergeKanDianReport.a());
    g(paramBoolean);
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374032);
    View localView;
    if (bool)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377324);
    TextView localTextView = (TextView)findViewById(2131377864);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(HardCodeUtil.a(2131712842));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(HardCodeUtil.a(2131713031));
  }
  
  private void h()
  {
    if (ReadInJoyHelper.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject = findViewById(2131376101);
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(new ReadInJoySettingActivity.5(this));
      return;
    }
    findViewById(2131376209).setVisibility(0);
    Object localObject = (TextView)findViewById(2131376211);
    ((TextView)localObject).setText(this.jdField_f_of_type_JavaLangString);
    ((TextView)localObject).setContentDescription(this.jdField_f_of_type_JavaLangString);
    j();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369617));
    this.jdField_d_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377498));
    this.jdField_d_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_j_of_type_Boolean);
    this.jdField_d_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.6(this));
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718051);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718054);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131369619));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.7(this));
  }
  
  private void k()
  {
    View localView1 = findViewById(2131361808);
    View localView2 = findViewById(2131366265);
    View localView3 = findViewById(2131372137);
    View localView4 = findViewById(2131365370);
    View localView5 = findViewById(2131362660);
    View localView6 = findViewById(2131378128);
    View localView7 = findViewById(2131365849);
    View localView8 = findViewById(2131366843);
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    localView3.setVisibility(8);
    localView4.setVisibility(8);
    localView5.setVisibility(8);
    localView6.setVisibility(8);
    localView7.setVisibility(8);
    localView8.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ReadInJoySettingActivity.12(this);
    boolean bool = false;
    if (((Integer)RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {
      bool = true;
    }
    this.jdField_g_of_type_Boolean = bool;
    this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
    this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131381314));
    this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_g_of_type_Boolean);
    this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showConfirmDialog");
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format(this.jdField_c_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(str);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_h_of_type_JavaLangString, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoySettingActivity.14(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoySettingActivity.15(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format(this.jdField_k_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setMainTitle(str);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(String.format(this.jdField_j_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoySettingActivity.16(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoySettingActivity.17(this));
  }
  
  private void o()
  {
    this.jdField_f_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131364980));
    p();
    this.jdField_f_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.21(this));
  }
  
  private void p()
  {
    boolean bool = ReadInJoyHelper.C();
    this.jdField_f_of_type_ComTencentWidgetSwitch.setChecked(bool);
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
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        else
        {
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
        }
      }
      else if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.d())
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
    this.leftView.setBackgroundResource(2130849814);
    if (this.centerView != null) {
      this.centerView.setTextColor(-16777216);
    }
    this.vg.setBackgroundColor(-1);
  }
  
  protected void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.postDelayed(new ReadInJoySettingActivity.13(this, paramInt), 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean ^ true);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    RIJDtReportHelper.a.a(getActivity(), "44");
    setContentView(2131560284);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(new ReadInJoySettingActivity.1(this));
    d();
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      a();
    }
    this.jdField_k_of_type_Boolean = false;
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    localObject = this.jdField_b_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    }
    localObject = this.jdField_c_of_type_ComTencentWidgetActionSheet;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      this.jdField_c_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_c_of_type_ComTencentWidgetActionSheet = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_g_of_type_Boolean != this.jdField_h_of_type_Boolean) {
      RIJSPUtils.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(true));
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_k_of_type_Boolean)
    {
      QLog.d("ReadInJoySettingActivity", 1, "refresh channel list while leave interest label");
      this.jdField_k_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380739: 
      this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
      return;
    case 2131372137: 
      ViolaAccessHelper.a(this.mContentView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
      return;
    case 2131368915: 
      this.jdField_k_of_type_Boolean = true;
      ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchInterestActivity(this);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      return;
    case 2131366265: 
      ReadInJoySelfActivity.a(this);
      return;
    case 2131365370: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */