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
import com.qflutter.tencent_vista_image.TencentVistaImagePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.flutter.channel.ChannelRegistrar;
import com.tencent.mobileqq.flutter.launch.LaunchListener;
import com.tencent.mobileqq.flutter.launch.LaunchResult;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher;
import com.tencent.mobileqq.flutter.report.FirstFrameTrace;
import com.tencent.mobileqq.flutter.report.MemoryReporter;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.flutter.vistaimage.VistaImageProxy;
import com.tencent.mobileqq.theme.ThemeUtil;
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
import io.flutter.embedding.engine.plugins.FlutterPlugin;
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
    if (localObject != null) {}
    for (localObject = ((SerializableMap)localObject).toJson();; localObject = "")
    {
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("page_name", "unknown");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("unique_id", "-1");
      QLog.d("QFlutterContainerDelegate", 1, "setupFlutterEngine, pageName: " + str1 + ", uniqueId: " + str2 + ", paramsJson: " + (String)localObject);
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine = new FlutterEngine(BaseApplicationImpl.getContext(), FlutterLoader.getInstance(), new FlutterJNI(), new PlatformViewsController(), this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a().toArray(), true, false, new String[] { str1, localObject, str2 });
      this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin = new PlatformPlugin(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a(), this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getPlatformChannel());
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().attachToActivity(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a(), this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.getLifecycle());
      l();
      this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace.c();
      return;
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar = new ChannelRegistrar();
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar.a(this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine);
      TencentVistaImagePlugin.init(VistaImageProxy.a());
    }
  }
  
  private void m()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = FlutterView.RenderMode.texture;
      if (!this.jdField_a_of_type_Boolean) {
        break label87;
      }
    }
    label87:
    for (FlutterView.TransparencyMode localTransparencyMode = FlutterView.TransparencyMode.transparent;; localTransparencyMode = FlutterView.TransparencyMode.opaque)
    {
      this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView = new FlutterView(localActivity, (FlutterView.RenderMode)localObject, localTransparencyMode);
      this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView.addOnFirstFrameRenderedListener(this.jdField_a_of_type_IoFlutterEmbeddingEngineRendererFlutterUiDisplayListener);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView, (ViewGroup.LayoutParams)localObject);
      return;
      localObject = FlutterView.RenderMode.surface;
      break;
    }
  }
  
  private void n()
  {
    QFlutterLauncher.a().a();
    this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView.attachToFlutterEngine(this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine);
    Object localObject = FlutterMain.findAppBundlePath();
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("entry_point", "main");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("init_route");
    QLog.d("QFlutterContainerDelegate", 1, "initFlutterView, appBundlePath: " + (String)localObject + ", entryPoint: " + str1 + ", initRoute: " + str2);
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a(), 0, 2131698253, 1).a();
    }
    MemoryReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult.jdField_a_of_type_Boolean);
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
    if ((localObject instanceof BaseActivity))
    {
      localObject = (BaseActivity)localObject;
      if (this.jdField_b_of_type_Boolean)
      {
        SystemBarCompact localSystemBarCompact = ((BaseActivity)localObject).mSystemBarComp;
        if (localSystemBarCompact != null)
        {
          localSystemBarCompact.setStatusDrawable(null);
          localSystemBarCompact.setStatusBarColor(0);
          localSystemBarCompact.setStatusColor(0);
        }
      }
      ImmersiveUtils.setStatusTextColor(this.c, ((BaseActivity)localObject).getWindow());
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onCreateView");
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a());
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130850432);
    }
    for (;;)
    {
      paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, paramLayoutInflater);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a()).inflate(2131560975, null);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, paramLayoutInflater);
      this.f = true;
      if (this.e) {
        m();
      }
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_SETUP_FLUTTER", true);
    QLog.d("QFlutterContainerDelegate", 1, "onAttach, needSetupEngine: " + this.h);
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("preload_process");
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("open_page_time");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("page_name", "unknown");
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("status_bar_transparent");
    this.c = this.jdField_a_of_type_AndroidOsBundle.getBoolean("status_text_dark");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("background_transparent");
    if (this.h)
    {
      this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace = new FirstFrameTrace(str, bool, l);
      this.jdField_a_of_type_ComTencentMobileqqFlutterReportFirstFrameTrace.a();
      MemoryReporter.a().a(str);
      QFlutterLauncher.a().a(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchListener, bool, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(@NonNull Intent paramIntent)
  {
    this.d = false;
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().onNewIntent(paramIntent);
    }
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onActivityCreated()");
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().onRestoreInstanceState(paramBundle);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null)
    {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getNavigationChannel().popRoute();
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
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().onSaveInstanceState(paramBundle);
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
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getLifecycleChannel().appIsResumed();
    }
    p();
  }
  
  public void d()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onPause()");
    this.d = false;
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null)
    {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getLifecycleChannel().appIsInactive();
      MemoryReporter.a().a();
    }
  }
  
  public void e()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onStop()");
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getLifecycleChannel().appIsPaused();
    }
    if (this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView.detachFromFlutterEngine();
    }
  }
  
  public void f()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onDestroyView()");
    if (this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingAndroidFlutterView.removeOnFirstFrameRenderedListener(this.jdField_a_of_type_IoFlutterEmbeddingEngineRendererFlutterUiDisplayListener);
    }
    QFlutterLauncher.a().a(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchListener);
  }
  
  public void g()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onDetach()");
    if (this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin != null)
    {
      this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin.destroy();
      this.jdField_a_of_type_IoFlutterPluginPlatformPlatformPlugin = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelChannelRegistrar.a();
    }
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqFlutterContainerIQFlutterContainerHost.a().isChangingConfigurations()) {
        break label119;
      }
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
    }
    for (;;)
    {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getLifecycleChannel().appIsDetached();
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.destroy();
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine = null;
      if (this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult != null) {
        MemoryReporter.a().b(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchResult.jdField_a_of_type_Boolean);
      }
      return;
      label119:
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getActivityControlSurface().detachFromActivity();
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
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null) {
      this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getSystemChannel().sendMemoryPressureWarning();
    }
  }
  
  public void j()
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine != null)
    {
      FlutterPlugin localFlutterPlugin = this.jdField_a_of_type_IoFlutterEmbeddingEngineFlutterEngine.getPlugins().get(QFlutterSkinEnginePlugin.class);
      if ((localFlutterPlugin instanceof QFlutterSkinEnginePlugin))
      {
        ((QFlutterSkinEnginePlugin)localFlutterPlugin).updateTheme(str);
        QLog.d("QFlutterContainerDelegate", 1, "skinPlugin");
      }
    }
    else
    {
      return;
    }
    QLog.e("QFlutterContainerDelegate", 1, "skinPlugin == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate
 * JD-Core Version:    0.7.0.1
 */