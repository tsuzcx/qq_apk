package com.tencent.mobileqq.flutter.container;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qflutter.nativeresources.QFlutterSkinEnginePlugin;
import com.qflutter.vistaimage.VistaImagePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.flutter.channel.ChannelRegistrar;
import com.tencent.mobileqq.flutter.launch.LaunchListener;
import com.tencent.mobileqq.flutter.launch.LaunchResult;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher;
import com.tencent.mobileqq.flutter.report.FirstFrameTrace;
import com.tencent.mobileqq.flutter.report.MemoryReporter;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.flutter.vistaimage.VistaImageProxy;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;

public class QFlutterContainerDelegate
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ChannelRegistrar jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar;
  private IQFlutterContainerHost jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost;
  private LaunchListener jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchListener = new QFlutterContainerDelegate.2(this);
  private LaunchResult jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult;
  private FirstFrameTrace jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace;
  private FlutterView jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView;
  private FlutterEngine jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
  private FlutterUiDisplayListener jdField_a_of_type_IoFlutterEmbeddingEngineRendererFlutterUiDisplayListener = new QFlutterContainerDelegate.1(this);
  private PlatformPlugin jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin;
  private boolean jdField_a_of_type_Boolean;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = true;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public QFlutterContainerDelegate(IQFlutterContainerHost paramIQFlutterContainerHost)
  {
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost = paramIQFlutterContainerHost;
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace.b();
    Object localObject = (SerializableMap)this.jdField_a_of_type_AndroidOsBundle.getSerializable("params");
    if (localObject != null) {
      localObject = ((SerializableMap)localObject).toJson();
    } else {
      localObject = "";
    }
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("page_name", "unknown");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("unique_id", "-1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setupFlutterEngine, pageName: ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", uniqueId: ");
    localStringBuilder.append(str2);
    QLog.d("QFlutterContainerDelegate", 1, localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupFlutterEngine, paramsJson: ");
      localStringBuilder.append((String)localObject);
      QLog.d("QFlutterContainerDelegate", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine = new FlutterEngine(BaseApplicationImpl.getContext(), FlutterLoader.getInstance(), new FlutterJNI(), new PlatformViewsController(), this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a().toArray(), true, false, new String[] { str1, localObject, str2 });
    this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin = new PlatformPlugin(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a(), this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getPlatformChannel());
    this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().attachToActivity(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a(), this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.getLifecycle());
    l();
    this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace.c();
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar = new ChannelRegistrar();
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar.a(this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine);
      VistaImagePlugin.init(VistaImageProxy.a());
    }
  }
  
  private void m()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
    if (this.jdField_a_of_type_Boolean) {
      localObject = FlutterView.RenderMode.texture;
    } else {
      localObject = FlutterView.RenderMode.surface;
    }
    FlutterView.TransparencyMode localTransparencyMode;
    if (this.jdField_a_of_type_Boolean) {
      localTransparencyMode = FlutterView.TransparencyMode.transparent;
    } else {
      localTransparencyMode = FlutterView.TransparencyMode.opaque;
    }
    this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView = new FlutterView(localActivity, (FlutterView.RenderMode)localObject, localTransparencyMode);
    this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView.addOnFirstFrameRenderedListener(this.jdField_a_of_type_IoFlutterEmbeddingEngineRendererFlutterUiDisplayListener);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void n()
  {
    QFlutterLauncher.a().a();
    this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView.attachToFlutterEngine(this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine);
    Object localObject = FlutterMain.findAppBundlePath();
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("entry_point", "main");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("init_route");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFlutterView, appBundlePath: ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", entryPoint: ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", initRoute: ");
    localStringBuilder.append(str2);
    QLog.d("QFlutterContainerDelegate", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getNavigationChannel().setInitialRoute(str2);
    }
    localObject = new DartExecutor.DartEntrypoint((String)localObject, str1);
    this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getDartExecutor().executeDartEntrypoint((DartExecutor.DartEntrypoint)localObject);
  }
  
  private void o()
  {
    QLog.d("QFlutterContainerDelegate", 1, "showFlutterView");
    if (!this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a())
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace.a(this.d);
    if (this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult.jdField_b_of_type_Boolean) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.getContext(), 0, 2131698318, 1).a();
    }
    MemoryReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult.jdField_a_of_type_Boolean);
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
    if ((localObject instanceof QBaseActivity))
    {
      localObject = (QBaseActivity)localObject;
      if (this.jdField_b_of_type_Boolean)
      {
        SystemBarCompact localSystemBarCompact = ((QBaseActivity)localObject).mSystemBarComp;
        if (localSystemBarCompact != null)
        {
          localSystemBarCompact.setStatusDrawable(null);
          localSystemBarCompact.setStatusBarColor(0);
          localSystemBarCompact.setStatusColor(0);
        }
      }
      ImmersiveUtils.setStatusTextColor(this.c, ((QBaseActivity)localObject).getWindow());
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onCreateView");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.getContext());
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130850359);
    } else {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    }
    paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, paramLayoutInflater);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.getContext()).inflate(2131560850, null);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, paramLayoutInflater);
    this.f = true;
    if (this.e) {
      m();
    }
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_SETUP_FLUTTER", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAttach, needSetupEngine: ");
    ((StringBuilder)localObject).append(this.h);
    QLog.d("QFlutterContainerDelegate", 1, ((StringBuilder)localObject).toString());
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("preload_process");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("open_page_time");
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString("page_name", "unknown");
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("status_bar_transparent");
    this.c = this.jdField_a_of_type_AndroidOsBundle.getBoolean("status_text_dark");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("background_transparent");
    if (this.h)
    {
      this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace = new FirstFrameTrace((String)localObject, bool, l);
      this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace.a();
      MemoryReporter.a().a((String)localObject);
      QFlutterLauncher.a().a(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchListener, bool, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(@NonNull Intent paramIntent)
  {
    this.d = false;
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onNewIntent(paramIntent);
    }
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onActivityCreated()");
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onRestoreInstanceState(paramBundle);
    }
  }
  
  public boolean a()
  {
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null)
    {
      localFlutterEngine.getNavigationChannel().popRoute();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onResume()");
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      n();
    }
    this.g = true;
  }
  
  public void b(@Nullable Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onSaveInstanceState");
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onSaveInstanceState(paramBundle);
    }
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("KEY_SETUP_FLUTTER", false);
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onResume()");
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null) {
      localFlutterEngine.getLifecycleChannel().appIsResumed();
    }
    p();
  }
  
  public void d()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onPause()");
    this.d = false;
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null)
    {
      localFlutterEngine.getLifecycleChannel().appIsInactive();
      MemoryReporter.a().a();
    }
  }
  
  public void e()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onStop()");
    Object localObject = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localObject != null) {
      ((FlutterEngine)localObject).getLifecycleChannel().appIsPaused();
    }
    localObject = this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView;
    if (localObject != null) {
      ((FlutterView)localObject).detachFromFlutterEngine();
    }
  }
  
  public void f()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onDestroyView()");
    FlutterView localFlutterView = this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView;
    if (localFlutterView != null) {
      localFlutterView.removeOnFirstFrameRenderedListener(this.jdField_a_of_type_IoFlutterEmbeddingEngineRendererFlutterUiDisplayListener);
    }
    QFlutterLauncher.a().a(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchListener);
  }
  
  public void g()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onDetach()");
    Object localObject = this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin;
    if (localObject != null)
    {
      ((PlatformPlugin)localObject).destroy();
      this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar;
    if (localObject != null) {
      ((ChannelRegistrar)localObject).a();
    }
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a().isChangingConfigurations()) {
        this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
      } else {
        this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().detachFromActivity();
      }
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getLifecycleChannel().appIsDetached();
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.destroy();
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult != null) {
      MemoryReporter.a().b(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult.jdField_a_of_type_Boolean);
    }
  }
  
  public void h()
  {
    QLog.d("QFlutterContainerDelegate", 1, "release");
    this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost = null;
    this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView = null;
    this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin = null;
  }
  
  public void i()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onLowMemory");
    FlutterEngine localFlutterEngine = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localFlutterEngine != null) {
      localFlutterEngine.getSystemChannel().sendMemoryPressureWarning();
    }
  }
  
  public void j()
  {
    String str = ThemeUtil.getCurrentThemeId();
    Object localObject = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine;
    if (localObject != null)
    {
      localObject = ((FlutterEngine)localObject).getPlugins().get(QFlutterSkinEnginePlugin.class);
      if ((localObject instanceof QFlutterSkinEnginePlugin))
      {
        ((QFlutterSkinEnginePlugin)localObject).updateTheme(str);
        QLog.d("QFlutterContainerDelegate", 1, "skinPlugin");
        return;
      }
      QLog.e("QFlutterContainerDelegate", 1, "skinPlugin == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate
 * JD-Core Version:    0.7.0.1
 */