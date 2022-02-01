package com.tencent.mobileqq.studymode.pwdverify;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.KidModeUtils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class StudyPwdVerifyFragment
  extends StudyPwdBaseFragment
{
  public boolean b = false;
  private StudyPwdVerifyFragment.AppealResultBroadcastReceiver c = null;
  private View d;
  private QQAppInterface e;
  private int f = -1;
  private KidModeObserver g = new StudyPwdVerifyFragment.2(this);
  
  private void p()
  {
    if (this.c == null)
    {
      this.c = new StudyPwdVerifyFragment.AppealResultBroadcastReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.studymode.pwdverify.studyidentify");
      getActivity().registerReceiver(this.c, localIntentFilter);
    }
  }
  
  private void q()
  {
    if (this.c != null)
    {
      getActivity().unregisterReceiver(this.c);
      this.c = null;
    }
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(getActivity()).inflate(2131627865, paramViewGroup, false);
      paramViewGroup = this.d;
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.findViewById(2131448916);
        if (paramViewGroup != null) {
          paramViewGroup.setOnClickListener(new StudyPwdVerifyFragment.1(this));
        }
      }
    }
    return this.d;
  }
  
  protected String a()
  {
    return BaseApplicationImpl.getContext().getString(2131897407);
  }
  
  protected void a(boolean paramBoolean)
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      this.f = m();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAppealSuccess isJumpPwdSet=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",action");
      ((StringBuilder)localObject).append(this.f);
      QLog.i("StudyPwdVerifyFragment", 1, ((StringBuilder)localObject).toString());
      if (this.f == -1) {
        return;
      }
      if (paramBoolean)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("ExtraTargetAction", this.f);
        if (this.f == 1)
        {
          QPublicFragmentActivity.start(localQBaseActivity, (Intent)localObject, StudyPwdSetFragment.class);
          localQBaseActivity.finish();
          return;
        }
        QPublicFragmentActivity.startForResult(localQBaseActivity, (Intent)localObject, StudyPwdSetFragment.class, 2);
        return;
      }
      localQBaseActivity.finish();
      return;
    }
    QLog.i("StudyPwdVerifyFragment", 1, "onAppealSuccess activity == null || activity.isFinishing()");
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      return;
    }
    if (this.e == null)
    {
      QLog.i("StudyPwdSetFragment", 1, "onVerifyCodeComplete mApp == null");
      return;
    }
    if (!g()) {
      return;
    }
    String str = StudyModeManager.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("verifyPassword pwd=");
    localStringBuilder.append(KidModeUtils.a(paramString));
    localStringBuilder.append(",salt=");
    localStringBuilder.append(KidModeUtils.a(str));
    QLog.i("StudyPwdSetFragment", 1, localStringBuilder.toString());
    KidModeServlet.b(this.e, paramString, str);
    h();
  }
  
  protected String b()
  {
    return BaseApplicationImpl.getContext().getString(2131897404);
  }
  
  public int m()
  {
    int i = this.f;
    if (i != -1) {
      return i;
    }
    Object localObject = getQBaseActivity();
    if (localObject == null)
    {
      QLog.i("StudyPwdVerifyFragment", 1, "getAction activity == null");
      return -1;
    }
    localObject = ((QBaseActivity)localObject).getIntent();
    if (localObject == null)
    {
      QLog.i("StudyPwdVerifyFragment", 1, "getAction intent == null");
      return -1;
    }
    this.f = ((Intent)localObject).getIntExtra("ExtraTargetAction", -1);
    return this.f;
  }
  
  protected void n()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      this.f = m();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpToNextActivity mAction=");
      localStringBuilder.append(this.f);
      QLog.i("StudyPwdVerifyFragment", 1, localStringBuilder.toString());
      int i = this.f;
      if (i == -1)
      {
        b(null);
        return;
      }
      if (i == 1)
      {
        KidModeAdvanceSettingFragment.a(localQBaseActivity);
        localQBaseActivity.finish();
        return;
      }
      localQBaseActivity.setResult(-1, new Intent());
      localQBaseActivity.finish();
      return;
    }
    QLog.i("StudyPwdVerifyFragment", 1, "jumpToNextActivity activity == null || activity.isFinishing()");
  }
  
  protected void o()
  {
    QLog.i("StudyPwdVerifyFragment", 1, "getToAppeal");
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(getActivity(), "/base/browser");
    localActivityURIRequest.extra().putString("url", "https://accounts.qq.com/teenager/psw/reset");
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @androidx.annotation.Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append("doOnActivityResult requestCode=");
    paramIntent.append(paramInt1);
    paramIntent.append(",resultCode=");
    paramIntent.append(paramInt2);
    QLog.i("StudyPwdVerifyFragment", 1, paramIntent.toString());
    paramIntent = getQBaseActivity();
    if ((paramIntent != null) && (!paramIntent.isFinishing()))
    {
      if (paramInt1 == 2)
      {
        paramIntent.setResult(paramInt2, new Intent());
        paramIntent.finish();
      }
      return;
    }
    QLog.i("StudyPwdVerifyFragment", 1, "onActivityResult activity == null || activity.isFinishing()");
  }
  
  public void onCreate(@androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    p();
    a("0X800BD45", m());
  }
  
  @androidx.annotation.Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @androidx.annotation.Nullable ViewGroup paramViewGroup, @androidx.annotation.Nullable Bundle paramBundle)
  {
    Object localObject = f();
    if ((localObject instanceof QQAppInterface)) {
      this.e = ((QQAppInterface)localObject);
    }
    localObject = this.e;
    if (localObject != null) {
      ((QQAppInterface)localObject).registObserver(this.g);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateView mAction=");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(",mApp=");
    boolean bool;
    if (this.e == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("StudyPwdVerifyFragment", 1, ((StringBuilder)localObject).toString());
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.e;
    if (localObject != null) {
      ((QQAppInterface)localObject).unRegistObserver(this.g);
    }
    q();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroy mApp=");
    boolean bool;
    if (this.e == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("StudyPwdVerifyFragment", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdVerifyFragment
 * JD-Core Version:    0.7.0.1
 */