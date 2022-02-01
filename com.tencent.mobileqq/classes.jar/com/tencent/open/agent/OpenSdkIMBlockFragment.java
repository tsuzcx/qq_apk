package com.tencent.open.agent;

import aeow;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bjey;
import bjfa;
import bjhg;
import bjhh;
import bjmq;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class OpenSdkIMBlockFragment
  extends PublicBaseFragment
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private String a()
  {
    Object localObject;
    if (getActivity() == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      localObject = getActivity().getIntent();
      if (localObject == null) {
        return "";
      }
      str = ((Intent)localObject).getStringExtra("uin");
      localObject = str;
    } while (str != null);
    return "";
  }
  
  private void a()
  {
    bjmq.d(this.jdField_a_of_type_JavaLangString);
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
    {
      QLog.d("IMBlockOpenSDKFragment", 1, "-->exitImBlock--getActivity() == null");
      return;
    }
    if ((localFragmentActivity.getIntent() != null) && (!localFragmentActivity.getIntent().getBooleanExtra("is_from_login", false)))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(localFragmentActivity, LoginActivity.class);
      localIntent.putExtra("logout_intent", true);
      localIntent.putExtra("tab_index", MainFragment.b);
      localFragmentActivity.startActivity(localIntent);
    }
    localFragmentActivity.finish();
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    QLog.d("IMBlockOpenSDKFragment", 1, new Object[] { "-->startFragment--uin=", bjhh.a(paramString), ", isFromLogin=", Boolean.valueOf(paramBoolean) });
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramActivity == null)
    {
      QLog.d("IMBlockOpenSDKFragment", 1, "-->startFragment fail null == currentActivity--");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("is_from_login", paramBoolean);
    aeow.a(paramActivity, localIntent, PublicFragmentActivity.class, OpenSdkIMBlockFragment.class, 0);
  }
  
  private void a(View paramView)
  {
    int i = paramView.getResources().getDisplayMetrics().heightPixels;
    float f1 = paramView.getResources().getDisplayMetrics().density * 194.5F + 0.5F;
    float f2 = i - f1;
    QLog.d("IMBlockOpenSDKFragment", 1, new Object[] { "screenHeight=", Integer.valueOf(i), ", viewPX=", Float.valueOf(f1), ", space=", Float.valueOf(f2) });
    Object localObject = paramView.findViewById(2131361896);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin = ((int)(0.2608237F * f2));
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramView = paramView.findViewById(2131372243);
    localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(f2 * 0.2914467F));
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public boolean onBackEvent()
  {
    QLog.d("IMBlockOpenSDKFragment", 1, "onBackEvent");
    a();
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("IMBlockOpenSDKFragment", 1, "-->onCreateView--");
    this.jdField_a_of_type_JavaLangString = a();
    paramLayoutInflater = paramLayoutInflater.inflate(2131559710, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131368380).setOnClickListener(new bjey(this));
    ((TextView)paramLayoutInflater.findViewById(2131371977)).setText(this.jdField_a_of_type_JavaLangString);
    a(paramLayoutInflater);
    paramLayoutInflater.findViewById(2131372243).setOnClickListener(new bjfa(this));
    bjhg.a(this.jdField_a_of_type_JavaLangString, "0X800B659");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("IMBlockOpenSDKFragment", 1, "-->onDestroy--");
  }
  
  public void onResume()
  {
    QLog.d("IMBlockOpenSDKFragment", 1, new Object[] { "-->onResume--mUpdatedStatusBar=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    super.onResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      bjhh.a(getActivity());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onStart()
  {
    QLog.d("IMBlockOpenSDKFragment", 1, "-->onStart");
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkIMBlockFragment
 * JD-Core Version:    0.7.0.1
 */