package com.tencent.mobileqq.flutter.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import auev;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate;
import com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Map;

public class QFlutterFragment
  extends PublicBaseFragment
  implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host
{
  @NonNull
  private LifecycleRegistry jdField_a_of_type_AndroidxLifecycleLifecycleRegistry;
  private FlutterActivityAndFragmentDelegate jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate;
  private SplashScreen jdField_a_of_type_IoFlutterEmbeddingAndroidSplashScreen;
  
  public QFlutterFragment()
  {
    setArguments(new Bundle());
    this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  }
  
  public void a(SplashScreen paramSplashScreen)
  {
    this.jdField_a_of_type_IoFlutterEmbeddingAndroidSplashScreen = paramSplashScreen;
  }
  
  public void cleanUpFlutterEngine(@NonNull FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof FlutterEngineConfigurator)) {
      ((FlutterEngineConfigurator)localFragmentActivity).configureFlutterEngine(paramFlutterEngine);
    }
  }
  
  public String getContainerUrl()
  {
    return getArguments().getString("url");
  }
  
  public Map getContainerUrlParams()
  {
    return ((BoostFlutterActivity.SerializableMap)getArguments().getSerializable("params")).getMap();
  }
  
  @NonNull
  public Context getContext()
  {
    return getActivity();
  }
  
  @NonNull
  public FlutterShellArgs getFlutterShellArgs()
  {
    String[] arrayOfString = getArguments().getStringArray("initialization_args");
    if (arrayOfString != null) {}
    for (;;)
    {
      return new FlutterShellArgs(arrayOfString);
      arrayOfString = new String[0];
    }
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public FlutterView.RenderMode getRenderMode()
  {
    return FlutterView.RenderMode.valueOf(getArguments().getString("flutterview_render_mode", FlutterView.RenderMode.surface.name()));
  }
  
  @NonNull
  public FlutterView.TransparencyMode getTransparencyMode()
  {
    return FlutterView.TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.TransparencyMode.transparent.name()));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate = new FlutterActivityAndFragmentDelegate(this);
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onDetach();
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.release();
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onPause();
      return;
    }
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onResume();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onLowMemory();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    if (!isHidden()) {
      this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    if (!isHidden()) {
      this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    if (!isHidden()) {
      this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (!isHidden()) {
      this.jdField_a_of_type_ComIdlefishFlutterboostContainersFlutterActivityAndFragmentDelegate.onStop();
    }
  }
  
  @Nullable
  public FlutterEngine provideFlutterEngine(@NonNull Context paramContext)
  {
    return FlutterBoost.instance().engineProvider();
  }
  
  @Nullable
  public PlatformPlugin providePlatformPlugin(@Nullable Activity paramActivity, @NonNull FlutterEngine paramFlutterEngine)
  {
    if (paramActivity != null) {
      return new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel());
    }
    return null;
  }
  
  @Nullable
  public SplashScreen provideSplashScreen()
  {
    if (this.jdField_a_of_type_IoFlutterEmbeddingAndroidSplashScreen != null) {
      return this.jdField_a_of_type_IoFlutterEmbeddingAndroidSplashScreen;
    }
    return new auev(null);
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterFragment
 * JD-Core Version:    0.7.0.1
 */