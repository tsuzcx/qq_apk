package com.tencent.mobileqq.vip.lianghao;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.register.QueryAccount;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoPayFailData;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.Locale;
import mqq.os.MqqHandler;

public class RegisterLHAssistant
{
  public static int a = 0;
  public static String a = "RegisterLHAssistant";
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private final View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private final RegisterNewBaseActivity jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity;
  public QueryAccount a;
  private RegisterLHAssistant.MyLayoutChangeListener jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant$MyLayoutChangeListener = null;
  private RegisterLiangHaoHelper jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = null;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new RegisterLHAssistant.1(this);
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private String c = null;
  private String d = null;
  private String e;
  private String f;
  
  public RegisterLHAssistant(RegisterNewBaseActivity paramRegisterNewBaseActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity = paramRegisterNewBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = new RegisterLiangHaoHelper(paramRegisterNewBaseActivity, this);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376828));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380944));
    jdField_a_of_type_Int = paramInt;
    e();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Intent paramIntent)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (paramIntent == null) {
        return;
      }
      String str;
      if (jdField_a_of_type_Int == 1)
      {
        if (paramBoolean) {
          str = "1";
        } else {
          str = "2";
        }
        ReportController.a(null, "new_reg", "setting_page_yes", "result", "", 1, "", "", str, "", "", "", "", "", "");
      }
      else
      {
        if (paramBoolean) {
          str = "1";
        } else {
          str = "2";
        }
        ReportController.a(null, "new_reg", "setting_page_no", "result", "", 1, "", "", str, "", "", "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        a("gotoNextAfterPaidLH-register", paramIntent);
      }
      boolean bool = paramIntent.getBooleanExtra("key_register_chose_bind_phone", false);
      paramIntent = new Intent(paramIntent);
      if (paramBoolean)
      {
        paramIntent.setComponent(new ComponentName(paramContext, RegisterQQNumberActivity.class));
        paramIntent.putExtra("uin", paramString1);
        paramIntent.putExtra("key_register_is_lh", true);
      }
      else
      {
        if (bool) {
          paramIntent.setComponent(new ComponentName(paramContext, RegisterPersonalInfoActivity.class));
        } else {
          paramIntent.setComponent(new ComponentName(paramContext, RegisterByNicknameAndPwdActivity.class));
        }
        paramIntent.putExtra("key_register_from_fail_pay_lh", true);
        paramIntent.putExtra("key_register_fail_paid_lh", paramString1);
        paramIntent.putExtra("lh_uin", paramString1);
        paramIntent.putExtra("lh_light", paramString2);
      }
      paramContext.startActivity(paramIntent);
      if (QLog.isColorLevel()) {
        a("gotoNextAfterPaidLH-intent", paramIntent);
      }
    }
  }
  
  public static void a(String paramString, Intent paramIntent)
  {
    if ((QLog.isColorLevel()) && (paramIntent != null)) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(500);
        localStringBuilder.append("--------------");
        localStringBuilder.append(paramString);
        localStringBuilder.append("---------------------\r\n");
        boolean bool = paramIntent.hasExtra("phonenum");
        if (bool)
        {
          localStringBuilder.append("phoneNum: ");
          localStringBuilder.append(PhoneCodeUtils.a(paramIntent.getStringExtra("phonenum")));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key"))
        {
          localStringBuilder.append("countryCode: ");
          localStringBuilder.append(paramIntent.getStringExtra("key"));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("uin"))
        {
          localStringBuilder.append("uin: ");
          localStringBuilder.append(paramIntent.getStringExtra("uin"));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("invite_code"))
        {
          localStringBuilder.append("inviteCode: ");
          localStringBuilder.append(paramIntent.getStringExtra("uin"));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_sign"))
        {
          localStringBuilder.append("sign: ");
          localStringBuilder.append(MD5.toMD5(paramIntent.getByteArrayExtra("key_register_sign")));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_smscode"))
        {
          localStringBuilder.append("smsCode: ");
          localStringBuilder.append(paramIntent.getStringExtra("key_register_smscode"));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_nick"))
        {
          localStringBuilder.append("nick: ");
          localStringBuilder.append(paramIntent.getStringExtra("key_register_nick"));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_is_phone_num_registered"))
        {
          localStringBuilder.append("isPhoneNumRegistered: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_is_phone_num_registered", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_chose_bind_phone"))
        {
          localStringBuilder.append("isChooseBindPhoneNum: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_chose_bind_phone", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_unbind"))
        {
          localStringBuilder.append("unbind: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_unbind", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_has_pwd"))
        {
          localStringBuilder.append("hasPwd: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_has_pwd", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_from_send_sms"))
        {
          localStringBuilder.append("fromSendSmsCode: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_from_send_sms", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_from_quick_register"))
        {
          localStringBuilder.append("quickRegister: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_from_quick_register", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_is_lh"))
        {
          localStringBuilder.append("isLH: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_is_lh", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_from_fail_pay_lh"))
        {
          localStringBuilder.append("isFromFailPayLh: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_from_fail_pay_lh", false));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_fail_paid_lh"))
        {
          localStringBuilder.append("failPayLH: ");
          localStringBuilder.append(paramIntent.getStringExtra("key_register_fail_paid_lh"));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_result"))
        {
          localStringBuilder.append("registerResult: ");
          localStringBuilder.append(paramIntent.getBooleanExtra("key_register_result", true));
          localStringBuilder.append("\r\n");
        }
        if (paramIntent.hasExtra("key_register_password"))
        {
          localStringBuilder.append("pwd: ");
          localStringBuilder.append(MD5.toMD5(paramIntent.getStringExtra("key_register_password")));
          localStringBuilder.append("\r\n");
        }
        localStringBuilder.append("-------------------------end---------------------------------\r\n");
        QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void e()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent();
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent());
    this.e = localIntent.getStringExtra("phonenum");
    this.f = localIntent.getStringExtra("key");
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("key_register_from_fail_pay_lh", false);
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("key_register_fail_paid_lh");
    this.c = localIntent.getStringExtra("key_register_nick");
    this.d = localIntent.getStringExtra("key_register_password");
    if (QLog.isColorLevel()) {
      a("RegisterLHAssistant init-from", localIntent);
    }
    int i = jdField_a_of_type_Int;
    if (i == 1)
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_unbind", true);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_chose_bind_phone", false);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364032));
    }
    else if (i == 2)
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_unbind", false);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_chose_bind_phone", true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363935));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131716604);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeAllActs(false);
      i = jdField_a_of_type_Int;
      ClearableEditText localClearableEditText1;
      if (i == 1)
      {
        ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372347)).setVisibility(0);
        localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371880);
        ClearableEditText localClearableEditText2 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131372346);
        localClearableEditText1.setText(this.c);
        localClearableEditText1.setEnabled(false);
        localClearableEditText2.setText(this.d);
        localClearableEditText2.setEnabled(false);
      }
      else if (i == 2)
      {
        localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371880);
        localClearableEditText1.setText(this.c);
        localClearableEditText1.setEnabled(false);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a(new LiangHaoPayFailData(localIntent)));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      d();
    }
    LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
  }
  
  public Intent a()
  {
    int i = jdField_a_of_type_Int;
    ClearableEditText localClearableEditText1;
    if (i == 1)
    {
      localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371880);
      ClearableEditText localClearableEditText2 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131372346);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_nick", localClearableEditText1.getText().toString());
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_password", localClearableEditText2.getText().toString());
    }
    else if (i == 2)
    {
      localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371880);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_nick", localClearableEditText1.getText().toString());
    }
    if (QLog.isColorLevel()) {
      a("getRegisterData-registerData", this.jdField_a_of_type_AndroidContentIntent);
    }
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public void a()
  {
    b();
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount = new QueryAccount(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_register_from_fail_pay_lh", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_register_fail_paid_lh", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_register_nick", this.c);
      localIntent.putExtra("key_register_password", this.d);
      boolean bool;
      if (jdField_a_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localIntent.putExtra("key_register_chose_bind_phone", bool);
      localIntent.putExtra("key_register_phonenum_bindnewqq", paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount.a(localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount.b();
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRegisterQueryAccount;
    if (localObject != null) {
      ((QueryAccount)localObject).a();
    }
    LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass());
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null)
    {
      RegisterLHAssistant.MyLayoutChangeListener localMyLayoutChangeListener = this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant$MyLayoutChangeListener;
      if (localMyLayoutChangeListener != null) {
        ((FrameLayout)localObject).removeOnLayoutChangeListener(localMyLayoutChangeListener);
      }
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant$MyLayoutChangeListener = null;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility();
    if (!this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY() != 0) {
        this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      return;
    }
    if ((i == 0) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a().a(true);
      return;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a().a(false);
      return;
    }
    if ((i == 8) && (paramBoolean))
    {
      int[] arrayOfInt = new int[2];
      int j = this.jdField_a_of_type_AndroidWidgetButton.getContext().getResources().getDisplayMetrics().heightPixels;
      this.jdField_a_of_type_AndroidWidgetButton.getLocationOnScreen(arrayOfInt);
      i = j - (arrayOfInt[1] + this.jdField_a_of_type_AndroidWidgetButton.getHeight());
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, String.format(Locale.getDefault(), "screen: %d, top: %d, height: %d, left: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_AndroidWidgetButton.getHeight()), Integer.valueOf(i) }));
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131374671).getLocationOnScreen(arrayOfInt);
      j = arrayOfInt[1];
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371880).getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[1];
      this.jdField_b_of_type_Int = (k - j);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, String.format(Locale.getDefault(), "lineA: %d, lineB: %d, scrollHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      i += this.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight(i);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a());
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, String.format(Locale.getDefault(), "miniHeight: %d", new Object[] { Integer.valueOf(i) }));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant$MyLayoutChangeListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant$MyLayoutChangeListener = new RegisterLHAssistant.MyLayoutChangeListener(this.jdField_a_of_type_ComTencentWidgetScrollView, this.jdField_b_of_type_Int, null);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLHAssistant$MyLayoutChangeListener);
    }
  }
  
  public void c()
  {
    int i = jdField_a_of_type_Int;
    if (i == 1)
    {
      ReportController.a(null, "new_reg", "setting_page_yes", "lianghao_clk", "", 1, "");
      return;
    }
    if (i == 2) {
      ReportController.a(null, "new_reg", "setting_page_no", "lianghao_clk", "", 1, "");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_quick_register", false))
    {
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "checkVipQQStatus isQuickRegister = true");
      }
      return;
    }
    ThreadManager.excute(new RegisterLHAssistant.2(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant
 * JD-Core Version:    0.7.0.1
 */