package com.tencent.mobileqq.studymode.pwdverify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class StudyPwdSetFragment
  extends StudyPwdBaseFragment
{
  private int b;
  
  private void d(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_previous_pwd", paramString);
    localIntent.putExtra("ExtraTargetAction", this.b);
    QPublicFragmentActivity.startForResult(getActivity(), localIntent, StudyPwdSetConfirmFragment.class, 1);
  }
  
  @androidx.annotation.Nullable
  protected View a(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  protected String a()
  {
    return BaseApplicationImpl.getContext().getString(2131897401);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      d(paramString);
    }
  }
  
  protected String b()
  {
    return BaseApplicationImpl.getContext().getString(2131897399);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @androidx.annotation.Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if (paramInt1 == 1)
    {
      if (paramIntent == null)
      {
        e();
        c();
        return;
      }
      if (paramIntent.getBooleanExtra("key_is_jump_to_next", false))
      {
        if (this.b == 1)
        {
          KidModeAdvanceSettingFragment.a(localFragmentActivity);
          localFragmentActivity.finish();
          return;
        }
        localFragmentActivity.setResult(paramInt2, new Intent());
        localFragmentActivity.finish();
        return;
      }
      e();
      c();
    }
  }
  
  public void onCreate(@androidx.annotation.Nullable @org.jetbrains.annotations.Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getActivity() != null) {
      this.b = getActivity().getIntent().getIntExtra("ExtraTargetAction", -1);
    }
    a("0X800BD3F", this.b);
  }
  
  public void onViewCreated(@NonNull View paramView, @androidx.annotation.Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.pwdverify.StudyPwdSetFragment
 * JD-Core Version:    0.7.0.1
 */