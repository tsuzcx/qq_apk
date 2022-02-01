package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class OpenSdkIMBlockFragment
  extends QPublicBaseFragment
{
  private boolean a;
  private String b;
  
  private String a()
  {
    if (getQBaseActivity() == null) {
      return "";
    }
    Object localObject = getQBaseActivity().getIntent();
    if (localObject == null) {
      return "";
    }
    String str = ((Intent)localObject).getStringExtra("uin");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    QLog.d("IMBlockOpenSDKFragment", 1, new Object[] { "-->startFragment--uin=", AuthorityUtil.a(paramString), ", isFromLogin=", Boolean.valueOf(paramBoolean) });
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
    QPublicFragmentActivity.Launcher.a(paramActivity, localIntent, QPublicFragmentActivity.class, OpenSdkIMBlockFragment.class, 0);
  }
  
  private void a(View paramView)
  {
    int i = paramView.getResources().getDisplayMetrics().heightPixels;
    float f1 = paramView.getResources().getDisplayMetrics().density * 194.5F + 0.5F;
    float f2 = i - f1;
    QLog.d("IMBlockOpenSDKFragment", 1, new Object[] { "screenHeight=", Integer.valueOf(i), ", viewPX=", Float.valueOf(f1), ", space=", Float.valueOf(f2) });
    Object localObject = paramView.findViewById(2131427456);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin = ((int)(0.2608237F * f2));
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramView = paramView.findViewById(2131439601);
    localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(f2 * 0.2914467F));
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b()
  {
    SharedPrefs.e(this.b);
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null)
    {
      QLog.d("IMBlockOpenSDKFragment", 1, "-->exitImBlock--getActivity() == null");
      return;
    }
    if ((localQBaseActivity.getIntent() != null) && (!localQBaseActivity.getIntent().getBooleanExtra("is_from_login", false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("logout_intent", true);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      RouteUtils.a(localQBaseActivity, localIntent, "/base/login");
    }
    localQBaseActivity.finish();
  }
  
  public boolean onBackEvent()
  {
    QLog.d("IMBlockOpenSDKFragment", 1, "onBackEvent");
    b();
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("IMBlockOpenSDKFragment", 1, "-->onCreateView--");
    this.b = a();
    paramLayoutInflater = paramLayoutInflater.inflate(2131625693, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131435218).setOnClickListener(new OpenSdkIMBlockFragment.1(this));
    ((TextView)paramLayoutInflater.findViewById(2131439313)).setText(this.b);
    a(paramLayoutInflater);
    paramLayoutInflater.findViewById(2131439601).setOnClickListener(new OpenSdkIMBlockFragment.2(this));
    AuthReporter.a(this.b, "0X800B659");
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("IMBlockOpenSDKFragment", 1, "-->onDestroy--");
  }
  
  public void onResume()
  {
    QLog.d("IMBlockOpenSDKFragment", 1, new Object[] { "-->onResume--mUpdatedStatusBar=", Boolean.valueOf(this.a) });
    super.onResume();
    if (!this.a)
    {
      AuthorityUtil.b(getQBaseActivity());
      this.a = true;
    }
  }
  
  public void onStart()
  {
    QLog.d("IMBlockOpenSDKFragment", 1, "-->onStart");
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkIMBlockFragment
 * JD-Core Version:    0.7.0.1
 */