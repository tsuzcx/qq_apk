package com.tencent.mobileqq.flutter.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import io.flutter.embedding.engine.FlutterShellArgs;

public class QFlutterContainerFragment
  extends QPublicBaseFragment
  implements LifecycleOwner, IQFlutterContainerHost
{
  private LifecycleRegistry a;
  protected QFlutterContainerDelegate b;
  
  public QFlutterContainerFragment()
  {
    setArguments(new Bundle());
    this.a = new LifecycleRegistry(this);
  }
  
  @Nullable
  public View a()
  {
    return null;
  }
  
  @NonNull
  public FlutterShellArgs c()
  {
    String[] arrayOfString = getArguments().getStringArray("initialization_args");
    if (arrayOfString == null) {
      arrayOfString = new String[0];
    }
    return new FlutterShellArgs(arrayOfString);
  }
  
  @Nullable
  public Bundle d()
  {
    return getArguments();
  }
  
  public boolean e()
  {
    return false;
  }
  
  @NonNull
  public Context getContext()
  {
    return getQBaseActivity();
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.a;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.b.a(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.b.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = new QFlutterContainerDelegate(this);
    this.b.a();
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = this.b.a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b.f();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.b.g();
    this.b.h();
    this.b = null;
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.b.j();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.b.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.b.d();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    this.b.k();
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.c();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.b.b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.b.b();
  }
  
  public void onStop()
  {
    super.onStop();
    this.b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */