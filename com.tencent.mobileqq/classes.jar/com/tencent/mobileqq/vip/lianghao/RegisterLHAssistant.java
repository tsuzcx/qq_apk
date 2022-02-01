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
  public static String a = "RegisterLHAssistant";
  public static int b;
  public boolean c = false;
  public String d = null;
  public QueryAccount e = null;
  private final RegisterNewBaseActivity f;
  private final View g;
  private Button h;
  private ScrollView i;
  private FrameLayout j;
  private boolean k = false;
  private String l = null;
  private String m = null;
  private String n;
  private String o;
  private int p = 0;
  private RegisterLHAssistant.MyLayoutChangeListener q = null;
  private Intent r = null;
  private RegisterLiangHaoHelper s = null;
  private MqqHandler t = new RegisterLHAssistant.1(this);
  
  public RegisterLHAssistant(RegisterNewBaseActivity paramRegisterNewBaseActivity, View paramView, int paramInt)
  {
    this.f = paramRegisterNewBaseActivity;
    this.s = new RegisterLiangHaoHelper(paramRegisterNewBaseActivity, this);
    this.g = paramView;
    this.i = ((ScrollView)this.g.findViewById(2131445159));
    this.j = ((FrameLayout)this.g.findViewById(2131449934));
    b = paramInt;
    f();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Intent paramIntent)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (paramIntent == null) {
        return;
      }
      String str;
      if (b == 1)
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
        QLog.i(a, 2, localStringBuilder.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void f()
  {
    Intent localIntent = this.f.getIntent();
    this.r = new Intent(this.f.getIntent());
    this.n = localIntent.getStringExtra("phonenum");
    this.o = localIntent.getStringExtra("key");
    this.c = localIntent.getBooleanExtra("key_register_from_fail_pay_lh", false);
    this.d = localIntent.getStringExtra("key_register_fail_paid_lh");
    this.l = localIntent.getStringExtra("key_register_nick");
    this.m = localIntent.getStringExtra("key_register_password");
    if (QLog.isColorLevel()) {
      a("RegisterLHAssistant init-from", localIntent);
    }
    int i1 = b;
    if (i1 == 1)
    {
      this.r.putExtra("key_register_unbind", true);
      this.r.putExtra("key_register_chose_bind_phone", false);
      this.h = ((Button)this.g.findViewById(2131429987));
    }
    else if (i1 == 2)
    {
      this.r.putExtra("key_register_unbind", false);
      this.r.putExtra("key_register_chose_bind_phone", true);
      this.h = ((Button)this.g.findViewById(2131429891));
    }
    this.h.setText(2131914067);
    if (this.c)
    {
      this.f.closeAllActs(false);
      i1 = b;
      ClearableEditText localClearableEditText1;
      if (i1 == 1)
      {
        ((ImageView)this.g.findViewById(2131439862)).setVisibility(0);
        localClearableEditText1 = (ClearableEditText)this.g.findViewById(2131439323);
        ClearableEditText localClearableEditText2 = (ClearableEditText)this.g.findViewById(2131439861);
        localClearableEditText1.setText(this.l);
        localClearableEditText1.setEnabled(false);
        localClearableEditText2.setText(this.m);
        localClearableEditText2.setEnabled(false);
      }
      else if (i1 == 2)
      {
        localClearableEditText1 = (ClearableEditText)this.g.findViewById(2131439323);
        localClearableEditText1.setText(this.l);
        localClearableEditText1.setEnabled(false);
      }
      this.j.setMinimumHeight(0);
      this.j.removeAllViews();
      this.j.scrollTo(0, 0);
      this.j.setVisibility(0);
      this.j.addView(this.s.a(new LiangHaoPayFailData(localIntent)));
    }
    else
    {
      this.j.setMinimumHeight(0);
      this.j.removeAllViews();
      this.i.scrollTo(0, 0);
      this.j.setVisibility(8);
      e();
    }
    LoginUtils.a(this.f.getAppRuntime(), this.f.getClass(), this.t);
  }
  
  public void a()
  {
    b();
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.e == null)
    {
      this.e = new QueryAccount(this.f);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_register_from_fail_pay_lh", this.c);
      localIntent.putExtra("key_register_fail_paid_lh", this.d);
      localIntent.putExtra("key_register_nick", this.l);
      localIntent.putExtra("key_register_password", this.m);
      boolean bool;
      if (b == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localIntent.putExtra("key_register_chose_bind_phone", bool);
      localIntent.putExtra("key_register_phonenum_bindnewqq", paramBoolean);
      this.e.a(localIntent);
    }
    this.e.b();
  }
  
  public void b()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((QueryAccount)localObject).a();
    }
    LoginUtils.b(this.f.getAppRuntime(), this.f.getClass());
    localObject = this.j;
    if (localObject != null)
    {
      RegisterLHAssistant.MyLayoutChangeListener localMyLayoutChangeListener = this.q;
      if (localMyLayoutChangeListener != null) {
        ((FrameLayout)localObject).removeOnLayoutChangeListener(localMyLayoutChangeListener);
      }
      this.q = null;
      this.j.removeAllViews();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.c) {
      return;
    }
    int i1 = this.j.getVisibility();
    if (!this.k)
    {
      if (this.i.getScrollY() != 0) {
        this.i.scrollTo(0, 0);
      }
      if (this.j.getVisibility() != 8) {
        this.j.setVisibility(8);
      }
      return;
    }
    if ((i1 == 0) && (paramBoolean))
    {
      this.s.b().a(true);
      return;
    }
    if (i1 == 0)
    {
      this.s.b().a(false);
      return;
    }
    if ((i1 == 8) && (paramBoolean))
    {
      int[] arrayOfInt = new int[2];
      int i2 = this.h.getContext().getResources().getDisplayMetrics().heightPixels;
      this.h.getLocationOnScreen(arrayOfInt);
      i1 = i2 - (arrayOfInt[1] + this.h.getHeight());
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, String.format(Locale.getDefault(), "screen: %d, top: %d, height: %d, left: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.h.getHeight()), Integer.valueOf(i1) }));
      }
      this.g.findViewById(2131442852).getLocationOnScreen(arrayOfInt);
      i2 = arrayOfInt[1];
      this.g.findViewById(2131439323).getLocationOnScreen(arrayOfInt);
      int i3 = arrayOfInt[1];
      this.p = (i3 - i2);
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, String.format(Locale.getDefault(), "lineA: %d, lineB: %d, scrollHeight: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.p) }));
      }
      i1 += this.p;
      this.j.setVisibility(0);
      this.j.setMinimumHeight(i1);
      this.j.addView(this.s.b());
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, String.format(Locale.getDefault(), "miniHeight: %d", new Object[] { Integer.valueOf(i1) }));
      }
      if (this.q == null) {
        this.q = new RegisterLHAssistant.MyLayoutChangeListener(this.i, this.p, null);
      }
      this.j.addOnLayoutChangeListener(this.q);
    }
  }
  
  public Intent c()
  {
    int i1 = b;
    ClearableEditText localClearableEditText1;
    if (i1 == 1)
    {
      localClearableEditText1 = (ClearableEditText)this.g.findViewById(2131439323);
      ClearableEditText localClearableEditText2 = (ClearableEditText)this.g.findViewById(2131439861);
      this.r.putExtra("key_register_nick", localClearableEditText1.getText().toString());
      this.r.putExtra("key_register_password", localClearableEditText2.getText().toString());
    }
    else if (i1 == 2)
    {
      localClearableEditText1 = (ClearableEditText)this.g.findViewById(2131439323);
      this.r.putExtra("key_register_nick", localClearableEditText1.getText().toString());
    }
    if (QLog.isColorLevel()) {
      a("getRegisterData-registerData", this.r);
    }
    return this.r;
  }
  
  public void d()
  {
    int i1 = b;
    if (i1 == 1)
    {
      ReportController.a(null, "new_reg", "setting_page_yes", "lianghao_clk", "", 1, "");
      return;
    }
    if (i1 == 2) {
      ReportController.a(null, "new_reg", "setting_page_no", "lianghao_clk", "", 1, "");
    }
  }
  
  public void e()
  {
    if (this.f.getIntent().getBooleanExtra("key_register_from_quick_register", false))
    {
      this.k = false;
      if (QLog.isDevelopLevel()) {
        QLog.i(a, 4, "checkVipQQStatus isQuickRegister = true");
      }
      return;
    }
    ThreadManager.excute(new RegisterLHAssistant.2(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant
 * JD-Core Version:    0.7.0.1
 */