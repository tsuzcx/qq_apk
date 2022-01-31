package com.tencent.mobileqq.flutter.container;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import arxi;
import arxj;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class QFlutterContainerFragment
  extends PublicBaseFragment
  implements arxi
{
  private arxj a;
  
  public Activity a()
  {
    return getActivity();
  }
  
  public Bundle a()
  {
    return getArguments();
  }
  
  public FragmentManager a()
  {
    return getChildFragmentManager();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new arxj(this);
    this.a.a(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.a != null) {
      this.a.e();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */