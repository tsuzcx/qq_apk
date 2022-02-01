package com.tencent.mobileqq.studymode.pwdverify;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.mobileqq.widget.container.AdaptiveKeyboardLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public abstract class StudyPwdBaseFragment
  extends QPublicBaseFragment
{
  protected Dialog a;
  private ViewGroup b;
  private TextView c;
  private TextView d;
  private VerifyCodeView e;
  private AdaptiveKeyboardLayout f;
  private View g;
  private boolean h;
  private InputMethodManager i;
  private Runnable j;
  private boolean k;
  private boolean l;
  private SharedPreferences m;
  private int n;
  private Runnable o = new StudyPwdBaseFragment.5(this);
  
  private void a(int paramInt)
  {
    if (paramInt != this.n)
    {
      this.m.edit().putInt("study_pwd_keyboard_height", paramInt).apply();
      this.n = paramInt;
    }
  }
  
  private void b(@NonNull View paramView)
  {
    this.e = ((VerifyCodeView)paramView.findViewById(2131449880));
    this.e.a(new StudyPwdBaseFragment.3(this));
    this.e.setContextMenuEnable(false);
    this.e.setTheme(p());
  }
  
  private void m()
  {
    String str;
    if ((this instanceof StudyPwdSetFragment)) {
      str = "0X800BD40";
    }
    for (;;)
    {
      break;
      if ((this instanceof StudyPwdSetConfirmFragment))
      {
        str = "0X800BD43";
      }
      else
      {
        if (!(this instanceof StudyPwdVerifyFragment)) {
          return;
        }
        str = "0X800BD47";
      }
    }
    ReportController.b(f(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
  }
  
  private void n()
  {
    o();
  }
  
  private void o()
  {
    this.e.removeCallbacks(this.j);
    this.j = new StudyPwdBaseFragment.2(this);
    this.e.postDelayed(this.j, 300L);
  }
  
  private boolean p()
  {
    return ThemeUtil.isNowThemeIsNight(f(), true, null);
  }
  
  private void q()
  {
    boolean bool = p();
    int i1 = ImmersiveUtils.isSupporImmersive();
    int i3 = -16777216;
    int i2 = -1;
    if ((i1 == 1) && (getActivity() != null))
    {
      ImmersiveUtils.setStatusTextColor(bool ^ true, getActivity().getWindow());
      localObject = this.b.findViewById(2131446329);
      if (bool) {
        i1 = -16777216;
      } else {
        i1 = -1;
      }
      ((View)localObject).setBackgroundColor(i1);
    }
    Object localObject = this.b;
    if (bool) {
      i1 = i3;
    } else {
      i1 = -1;
    }
    ((ViewGroup)localObject).setBackgroundColor(i1);
    localObject = this.c;
    if (bool) {
      i1 = i2;
    } else {
      i1 = getResources().getColor(2131165778);
    }
    ((TextView)localObject).setTextColor(i1);
  }
  
  private int r()
  {
    this.n = this.m.getInt("study_pwd_keyboard_height", 0);
    return this.n;
  }
  
  @Nullable
  protected abstract View a(ViewGroup paramViewGroup);
  
  protected abstract String a();
  
  protected void a(View paramView)
  {
    this.g = a(this.f);
    this.f.setKeyboardLayoutEnable(false);
    this.f.a(this.b, true);
    this.f.setKeyboardListener(new StudyPwdBaseFragment.4(this));
    paramView = this.g;
    if (paramView == null) {
      return;
    }
    this.f.addView(paramView);
  }
  
  protected void a(String paramString)
  {
    this.e.a();
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.makeText(getContext(), 1, paramString, 0).show();
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramInt = 4;
        } else {
          paramInt = 2;
        }
      }
      else {
        paramInt = 1;
      }
    }
    else {
      paramInt = 3;
    }
    ReportController.b(f(), "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  protected abstract void a(boolean paramBoolean, String paramString);
  
  protected abstract String b();
  
  protected void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(BaseApplication.getContext(), 0, getString(2131892074), 0).show();
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, paramString, 0).show();
  }
  
  protected void c()
  {
    o();
  }
  
  protected void c(String paramString)
  {
    b(paramString);
    k();
  }
  
  protected String d()
  {
    return this.e.getCode();
  }
  
  protected void e()
  {
    this.e.b();
  }
  
  protected AppRuntime f()
  {
    if (getQBaseActivity() != null) {
      return getQBaseActivity().getAppRuntime();
    }
    return null;
  }
  
  protected boolean g()
  {
    if (NetworkUtil.isNetworkAvailable()) {
      return true;
    }
    b(null);
    return false;
  }
  
  protected void h()
  {
    j();
  }
  
  protected void i()
  {
    k();
  }
  
  protected void j()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (this.k) {
        return;
      }
      if (this.a == null) {
        this.a = DialogUtil.b(getActivity(), 2131891376);
      }
      if (!this.a.isShowing())
      {
        this.k = true;
        ThreadManager.getUIHandler().postDelayed(this.o, 400L);
      }
    }
  }
  
  protected void k()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.o);
    this.k = false;
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public void l()
  {
    if ((this.i != null) && (getActivity() != null)) {
      this.i.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
    this.f.a();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131627863, paramViewGroup, false);
    if ((getActivity() != null) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      paramViewGroup = getActivity().getWindow();
      paramViewGroup.addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(paramViewGroup, true);
      this.h = true;
    }
    this.i = ((InputMethodManager)getActivity().getSystemService("input_method"));
    this.m = PreferenceManager.getDefaultSharedPreferences(getContext());
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.removeCallbacks(this.j);
    k();
  }
  
  public void onFinish()
  {
    super.onFinish();
    l();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    q();
    this.e.setTheme(p());
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.l)
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin += r();
        this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label59;
      }
    }
    this.f.a();
    label59:
    this.l = false;
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((ImageView)paramView.findViewById(2131436275)).setOnClickListener(new StudyPwdBaseFragment.1(this));
    this.l = true;
    this.c = ((TextView)paramView.findViewById(2131448814));
    this.d = ((TextView)paramView.findViewById(2131448375));
    this.c.setText(a());
    this.d.setText(b());
    this.f = ((AdaptiveKeyboardLayout)paramView.findViewById(2131431294));
    this.b = ((ViewGroup)paramView.findViewById(2131445148));
    q();
    b(paramView);
    a(paramView);
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdBaseFragment
 * JD-Core Version:    0.7.0.1
 */