package com.tencent.mobileqq.login.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.widget.AlphaClickableTextView;
import java.util.Locale;
import mqq.app.AppRuntime;

public class AddAccountBaseUI
{
  protected TextView a;
  protected ConfigClearableEditText b;
  protected PastablePwdEditText c;
  protected Button d;
  protected ImageView e;
  protected TextView f;
  protected TextView g;
  protected ImageView h;
  protected LinearLayout i;
  protected InputMethodManager j;
  protected boolean k;
  protected boolean l;
  protected int m;
  protected QBaseActivity n;
  protected AddAccountBaseUI.OnInteractionListener o;
  private ViewTreeObserver.OnGlobalLayoutListener p;
  private Runnable q;
  private int r;
  private int s;
  private Handler t = new Handler();
  private AddAccountBaseUI.SetHelpLayoutRunnable u;
  
  public AddAccountBaseUI(QBaseActivity paramQBaseActivity, AddAccountBaseUI.OnInteractionListener paramOnInteractionListener)
  {
    this.n = paramQBaseActivity;
    this.o = paramOnInteractionListener;
    this.n.registerActivityLifecycleCallbacks(new AddAccountBaseUI.AddAccountLifeCycle(this));
    a(true, 1);
  }
  
  private void v()
  {
    this.i = ((LinearLayout)b(2131436933));
    if (!u()) {
      return;
    }
    this.i.post(new AddAccountBaseUI.7(this));
  }
  
  private Resources w()
  {
    return this.n.getResources();
  }
  
  private AppRuntime x()
  {
    return this.n.getAppRuntime();
  }
  
  protected View a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = new View(this.n);
    localView.setLayoutParams(new LinearLayout.LayoutParams(paramInt1, paramInt2, paramInt3));
    return localView;
  }
  
  public AlphaClickableTextView a(String paramString, View.OnClickListener paramOnClickListener)
  {
    AlphaClickableTextView localAlphaClickableTextView = new AlphaClickableTextView(this.n);
    if (paramOnClickListener != null) {
      localAlphaClickableTextView.setOnClickListener(paramOnClickListener);
    }
    TextViewCompat.setTextAppearance(localAlphaClickableTextView, 2131953424);
    int i1 = w().getDimensionPixelOffset(2131299064);
    localAlphaClickableTextView.setPadding(i1, i1, i1, i1);
    localAlphaClickableTextView.setText(paramString);
    Object localObject = a(0, 0, 54);
    paramOnClickListener = a(ViewUtils.dip2px(1.0F), ViewUtils.dip2px(10.0F), 0);
    paramOnClickListener.setBackgroundColor(w().getColor(2131167276));
    paramString = a(0, 0, 54);
    LinearLayout localLinearLayout = this.i;
    localLinearLayout.addView((View)localObject, localLinearLayout.getChildCount() - 1);
    localObject = this.i;
    ((LinearLayout)localObject).addView(paramOnClickListener, ((LinearLayout)localObject).getChildCount() - 1);
    paramOnClickListener = this.i;
    paramOnClickListener.addView(paramString, paramOnClickListener.getChildCount() - 1);
    paramString = this.i;
    paramString.addView(localAlphaClickableTextView, paramString.getChildCount() - 1);
    return localAlphaClickableTextView;
  }
  
  protected void a()
  {
    AddAccountBaseUI.1 local1 = new AddAccountBaseUI.1(this);
    this.a = ((TextView)b(2131427779));
    this.h = ((ImageView)b(2131430169));
    this.h.setOnClickListener(local1);
    this.f = ((TextView)b(2131440045));
    this.f.setOnClickListener(local1);
    this.g = ((TextView)b(2131433175));
    this.g.setOnClickListener(local1);
    this.d = ((Button)b(2131439600));
    this.d.setOnClickListener(local1);
    b(2131439602).setOnClickListener(local1);
    b();
    d();
    e();
    v();
    f();
  }
  
  public void a(int paramInt)
  {
    String str = this.n.getString(paramInt);
    this.a.setText(str);
    this.a.setContentDescription(str);
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = this.n;
    paramBundle.mNeedStatusTrans = false;
    paramBundle.mActNeedImmersive = false;
  }
  
  protected void a(View paramView)
  {
    t();
    int i1 = paramView.getId();
    if (i1 == 2131430169)
    {
      paramView = this.o;
      if (paramView != null) {
        paramView.onBackClick();
      }
      i();
      return;
    }
    if (i1 == 2131439600)
    {
      paramView = this.o;
      if (paramView != null) {
        paramView.doLogin();
      }
    }
    else if (i1 == 2131440045)
    {
      paramView = this.o;
      if (paramView != null) {
        paramView.doPhoneLogin();
      }
    }
    else if (i1 == 2131433175)
    {
      paramView = this.o;
      if (paramView != null) {
        paramView.onFindPwdClick();
      }
      j();
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    InputMethodManager localInputMethodManager = this.j;
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(paramView, paramInt);
    }
  }
  
  public void a(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.l = paramBoolean;
    this.m = paramInt;
  }
  
  protected <T extends View> T b(int paramInt)
  {
    return this.n.findViewById(paramInt);
  }
  
  protected void b()
  {
    this.e = ((ImageView)b(2131439862));
    this.e.setVisibility(4);
    this.k = false;
    this.e.setContentDescription(HardCodeUtil.a(2131897882));
    this.e.setOnClickListener(new AddAccountBaseUI.2(this));
  }
  
  public void b(Bundle paramBundle)
  {
    this.n.getWindow().addFlags(1024);
    this.j = ((InputMethodManager)this.n.getSystemService("input_method"));
    this.n.setContentView(2131627508);
    a();
  }
  
  public void b(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void c()
  {
    this.k ^= true;
    if (this.k)
    {
      this.c.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      this.e.setImageResource(2130848791);
      this.e.setContentDescription(HardCodeUtil.a(2131897882));
    }
    else
    {
      this.c.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.e.setImageResource(2130848790);
      this.e.setContentDescription(HardCodeUtil.a(2131897879));
    }
    PastablePwdEditText localPastablePwdEditText = this.c;
    localPastablePwdEditText.setSelection(localPastablePwdEditText.length());
  }
  
  protected void c(int paramInt)
  {
    AddAccountBaseUI.SetHelpLayoutRunnable localSetHelpLayoutRunnable = this.u;
    if (localSetHelpLayoutRunnable != null) {
      this.t.removeCallbacks(localSetHelpLayoutRunnable);
    }
    if (paramInt == 0) {
      this.r = 0;
    }
    this.u = new AddAccountBaseUI.SetHelpLayoutRunnable(this, paramInt);
    this.t.postDelayed(this.u, 100L);
  }
  
  protected void d()
  {
    this.b = ((ConfigClearableEditText)b(2131427416));
    this.b.setTextClearedListener(new AddAccountBaseUI.3(this));
    this.b.setNeedContextMenu(true);
  }
  
  protected void e()
  {
    this.c = ((PastablePwdEditText)b(2131439858));
    this.c.setOnFocusChangeListener(new AddAccountBaseUI.4(this));
    this.c.setOnEditorActionListener(new AddAccountBaseUI.5(this));
    this.c.setTextClearedListener(new AddAccountBaseUI.6(this));
  }
  
  protected void f()
  {
    if (!this.l) {
      return;
    }
    this.q = new AddAccountBaseUI.8(this);
    this.b.postDelayed(this.q, 300L);
  }
  
  public void g()
  {
    c(0);
  }
  
  public void h()
  {
    Runnable localRunnable = this.q;
    if (localRunnable != null) {
      this.b.removeCallbacks(localRunnable);
    }
    if ((this.p != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.i.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
    }
  }
  
  protected void i()
  {
    this.n.setResult(0);
    this.n.finish();
  }
  
  public void j()
  {
    Object localObject = this.b.getText().toString();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    String str = "https://ti.qq.com/safe/forgetpw?source_id=2756";
    if (!bool) {
      str = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject });
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("uin", x().getCurrentAccountUin());
    ((Intent)localObject).putExtra("reqType", 3);
    ((Intent)localObject).putExtra("url", str);
    RouteUtils.a(this.n, (Intent)localObject, "/base/browser");
  }
  
  public EditText k()
  {
    return this.b;
  }
  
  public EditText l()
  {
    return this.c;
  }
  
  public String m()
  {
    return this.b.getText().toString();
  }
  
  public String n()
  {
    return this.c.getText().toString();
  }
  
  public boolean o()
  {
    return this.k;
  }
  
  public Button p()
  {
    return this.d;
  }
  
  public void q()
  {
    this.b.getInputExtras(true).putInt("INPUT_TYPE_ON_START", 1);
  }
  
  public void r()
  {
    this.b.requestFocus();
    a(this.b, 2);
  }
  
  public void s()
  {
    this.c.requestFocus();
    a(this.c, 2);
  }
  
  public void t()
  {
    InputMethodManager localInputMethodManager = this.j;
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(this.n.getWindow().getDecorView().getWindowToken(), 0);
    }
    c(0);
  }
  
  protected boolean u()
  {
    return ((IFeatureRuntimeService)x().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("Login_AddAccountHelpAdjust_864549333");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI
 * JD-Core Version:    0.7.0.1
 */