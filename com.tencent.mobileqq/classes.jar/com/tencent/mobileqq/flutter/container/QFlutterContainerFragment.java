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
  protected QFlutterContainerDelegate a;
  
  public QFlutterContainerFragment()
  {
    setArguments(new Bundle());
    this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  }
  
  @Nullable
  public Bundle a()
  {
    return getArguments();
  }
  
  @Nullable
  public View a()
  {
    return null;
  }
  
  @NonNull
  public FlutterShellArgs a()
  {
    String[] arrayOfString = getArguments().getStringArray("initialization_args");
    if (arrayOfString == null) {
      arrayOfString = new String[0];
    }
    return new FlutterShellArgs(arrayOfString);
  }
  
  public boolean a()
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
    return this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.a(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate = new QFlutterContainerDelegate(this);
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.a();
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.f();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.g();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.h();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate = null;
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.i();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.d();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.j();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.c();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.b(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.b();
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */