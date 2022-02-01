package com.tencent.mobileqq.studymode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class KidModeVerifyFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener
{
  public static int a = 1;
  public static long b;
  public boolean c = false;
  private QQAppInterface d;
  private ClearableEditText e;
  private Button f;
  private TextView g;
  private TextView h;
  private KidModeObserver i = new KidModeVerifyFragment.1(this);
  private Runnable j = new KidModeVerifyFragment.2(this);
  private Handler k = new Handler(Looper.getMainLooper(), new KidModeVerifyFragment.3(this));
  
  private void a(int paramInt)
  {
    this.h = ((TextView)this.mContentView.findViewById(2131448962));
    this.e = ((ClearableEditText)this.mContentView.findViewById(2131439507));
    this.e.addTextChangedListener(this);
    this.e.setHint(2131891115);
    this.f = ((Button)this.mContentView.findViewById(2131431227));
    this.f.setText(2131891111);
    this.f.setOnClickListener(this);
    this.h.setText(getString(2131891100, new Object[] { StudyModeManager.f() }));
    this.g = ((TextView)this.mContentView.findViewById(2131429992));
    this.g.setOnClickListener(this);
    if ((paramInt != 0) && (paramInt != 84)) {
      this.g.setText(getString(2131891120));
    } else {
      this.g.setText(getString(2131891122));
    }
    if (AppSetting.e)
    {
      this.f.setContentDescription(getString(2131892267));
      this.g.setContentDescription(getString(2131891122));
    }
  }
  
  private void b()
  {
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      KidModeUtils.a(getBaseActivity(), getString(2131889169), 1);
      return;
    }
    QLog.i("KidModeVerifyFragment", 1, "startGetVerifyCode");
    KidModeServlet.a(this.d, null);
  }
  
  private void b(int paramInt)
  {
    this.g.setEnabled(false);
    this.g.setClickable(false);
    a = paramInt;
    b = System.currentTimeMillis();
    this.g.setText(c(paramInt));
    this.k.postDelayed(this.j, 1000L);
  }
  
  private String c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131891122));
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void c()
  {
    if (!NetworkUtil.isNetSupport(getBaseActivity()))
    {
      KidModeUtils.a(getBaseActivity(), getString(2131889169), 1);
      return;
    }
    Object localObject = this.e.getText();
    if (localObject != null) {
      localObject = localObject.toString().trim();
    } else {
      localObject = "";
    }
    if (((String)localObject).length() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("commitSmsCode smsCode=");
      localStringBuilder.append((String)localObject);
      QLog.i("KidModeVerifyFragment", 1, localStringBuilder.toString());
      KidModeServlet.a(this.d, (String)localObject);
      return;
    }
    KidModeUtils.a(getBaseActivity(), HardCodeUtil.a(2131914033), 0);
  }
  
  protected void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null)
    {
      QLog.i("KidModeVerifyFragment", 1, "jumpToKidModelSetPwd activity == null");
      return;
    }
    Object localObject = localBaseActivity.getIntent();
    if (localObject == null)
    {
      QLog.i("KidModeVerifyFragment", 1, "jumpToKidModelSetPwd intent == null");
      return;
    }
    int m = ((Intent)localObject).getIntExtra("ExtraTargetAction", -1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jumpToKidModelSetPwd action=");
    ((StringBuilder)localObject).append(m);
    QLog.i("KidModeVerifyFragment", 1, ((StringBuilder)localObject).toString());
    if (m == -1) {
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("ExtraTargetAction", m);
    if (m == 1)
    {
      QPublicFragmentActivity.start(localBaseActivity, (Intent)localObject, StudyPwdSetFragment.class);
      localBaseActivity.finish();
      return;
    }
    QPublicFragmentActivity.startForResult(localBaseActivity, (Intent)localObject, StudyPwdSetFragment.class, 2);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.f.setEnabled(true);
      return;
    }
    this.f.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @android.support.annotation.Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.d != null)
    {
      paramLayoutInflater = getBaseActivity().getIntent();
      int m = paramLayoutInflater.getIntExtra("FIRST_TIME_RES", 0);
      a(m);
      if ((m == 0) || (m == 84)) {
        b(paramLayoutInflater.getIntExtra("COUNT_TIME", 0));
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627398;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @androidx.annotation.Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append("doOnActivityResult requestCode=");
    paramIntent.append(paramInt1);
    paramIntent.append(",resultCode=");
    paramIntent.append(paramInt2);
    QLog.i("KidModeVerifyFragment", 1, paramIntent.toString());
    paramIntent = getBaseActivity();
    if ((paramIntent != null) && (!paramIntent.isFinishing()))
    {
      if (paramInt1 == 2)
      {
        paramIntent.setResult(paramInt2, new Intent());
        paramIntent.finish();
      }
      return;
    }
    QLog.i("KidModeVerifyFragment", 1, "onActivityResult activity == null || activity.isFinishing()");
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131429992)
    {
      if (m == 2131431227) {
        c();
      }
    }
    else if (a <= 1) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getBaseActivity().getIntent();
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.d = ((QQAppInterface)getBaseActivity().getAppRuntime());
      this.d.registObserver(this.i);
    }
    long l1 = ((Long)SharedPreUtils.c("sp_key_count_time", Long.valueOf(-1L))).longValue();
    long l2 = NetConnInfoCenter.getServerTime();
    if (l1 != -1L)
    {
      l1 = l2 - l1;
      if (l1 < 60L)
      {
        a = 60 - (int)l1;
        paramBundle.putExtra("COUNT_TIME", a);
        paramBundle.putExtra("FIRST_TIME_RES", 84);
        break label132;
      }
    }
    a = 0;
    label132:
    ReportController.b(this.d, "dc00898", "", "", "0X800B3D3", "0X800B3D3", 0, 0, "", "", "", "");
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(HardCodeUtil.a(2131891124));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d.unRegistObserver(this.i);
  }
  
  public void onResume()
  {
    super.onResume();
    this.k.postDelayed(new KidModeVerifyFragment.4(this), 100L);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeVerifyFragment
 * JD-Core Version:    0.7.0.1
 */