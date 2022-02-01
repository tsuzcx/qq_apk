package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;

public class ReadInJoySubChannelFragment
  extends ReadInJoyBaseFragment
{
  public static final String a = "com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment";
  private static long o;
  protected ReadInJoyChannelViewController b = null;
  protected View c;
  protected int d = -1;
  protected int m;
  protected String n;
  
  public static ReadInJoySubChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoySubChannelFragment localReadInJoySubChannelFragment = new ReadInJoySubChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoySubChannelFragment.setArguments(localBundle);
    return localReadInJoySubChannelFragment;
  }
  
  private void a()
  {
    Object localObject = a;
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d((String)localObject, 2, new Object[] { "initUI, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d) });
    localObject = (ViewGroup)this.c.findViewById(2131444326);
    this.b = new ReadInJoyChannelViewController(v());
    this.b.a(this.d);
    this.b.b(this.m);
    this.b.a((ViewGroup)localObject);
    this.b.cT_();
    localObject = (ViewGroup)this.b.q();
    int i = b();
    if ((!this.l) && (i > 0)) {
      ((ViewGroup)localObject).setPadding(0, i, 0, 0);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.b;
    if (localReadInJoyChannelViewController != null)
    {
      localReadInJoyChannelViewController.a(true);
      return;
    }
    ReadInJoyChannelViewPagerController.d(d());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    paramActivity = this.b;
    if (paramActivity != null)
    {
      paramActivity.i();
      if (u() != null)
      {
        paramActivity = u().getKandianLockScreenRedPntInfo();
        if ((u().hasKandianOrSubscribePush()) && (paramActivity != null)) {
          this.b.a(true);
        }
      }
    }
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void k()
  {
    super.k();
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.b;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.h();
    }
  }
  
  public void l()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.b;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(true);
    }
  }
  
  public void n()
  {
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.b;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.cR_();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ReadInJoyChannelViewController localReadInJoyChannelViewController = this.b;
    if (localReadInJoyChannelViewController != null) {
      localReadInJoyChannelViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.d = ((Bundle)localObject).getInt("channel_id");
      this.m = ((Bundle)localObject).getInt("channel_type");
      this.n = ((Bundle)localObject).getString("channel_name");
    }
    localObject = a;
    boolean bool = false;
    if (this.b != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onCreate, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d) });
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = LayoutInflater.from(v());
    paramLayoutInflater = this.e;
    boolean bool = false;
    this.c = paramLayoutInflater.inflate(2131626246, paramViewGroup, false);
    a();
    VideoReport.setPageId(this.c, "14");
    VideoReport.setPageParams(this.c, new RIJDtParamBuilder().a(Integer.valueOf(this.d)).b());
    paramLayoutInflater = a;
    if (this.b != null) {
      bool = true;
    }
    QLog.d(paramLayoutInflater, 2, new Object[] { "onCreateView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d) });
    return this.c;
  }
  
  public void onDestroy()
  {
    Object localObject = a;
    boolean bool = false;
    if (this.b != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onDestroy, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d) });
    super.onDestroy();
    localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).e();
    }
    this.b = null;
  }
  
  public void onDestroyView()
  {
    String str = a;
    boolean bool = false;
    if (this.b != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onDestroyView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d) });
    super.onDestroyView();
    this.c = null;
  }
  
  public void onPause()
  {
    String str = a;
    boolean bool = false;
    if (this.b != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onPause, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d), ", mIsShowingSelf = ", Boolean.valueOf(this.g) });
    super.onPause();
    if ((this.b != null) && (this.g)) {
      this.b.h();
    }
  }
  
  public void onResume()
  {
    String str = a;
    boolean bool = false;
    if (this.b != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onResume, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d), ", mIsShowingSelf = ", Boolean.valueOf(this.g) });
    super.onResume();
    if ((this.b != null) && (this.g)) {
      this.b.i();
    }
  }
  
  public void onStart()
  {
    Object localObject = a;
    boolean bool = false;
    if (this.b != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onStart, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d) });
    super.onStart();
    localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).f();
    }
  }
  
  public void onStop()
  {
    Object localObject = a;
    boolean bool = false;
    if (this.b != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onStop, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.d) });
    super.onStop();
    localObject = this.b;
    if (localObject != null) {
      ((ReadInJoyChannelViewController)localObject).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment
 * JD-Core Version:    0.7.0.1
 */