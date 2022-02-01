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
import com.qflutter.vistaimage.VistaImageRegister;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.flutter.channel.ChannelRegistrar;
import com.tencent.mobileqq.flutter.channel.qqgame.DnFlutterPlugin;
import com.tencent.mobileqq.flutter.launch.LaunchListener;
import com.tencent.mobileqq.flutter.launch.LaunchResult;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher;
import com.tencent.mobileqq.flutter.report.FirstFrameTrace;
import com.tencent.mobileqq.flutter.report.MemoryReporter;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.flutter.vistaimage.VistaImageDefaultHandler;
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
  private IQFlutterContainerHost a;
  private FlutterEngine b;
  private FlutterView c;
  private PlatformPlugin d;
  private ChannelRegistrar e;
  private FrameLayout f;
  private FrameLayout g;
  private View h;
  private Bundle i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  private FirstFrameTrace n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private LaunchResult s;
  private FlutterUiDisplayListener t = new QFlutterContainerDelegate.1(this);
  private LaunchListener u = new QFlutterContainerDelegate.2(this);
  
  public QFlutterContainerDelegate(IQFlutterContainerHost paramIQFlutterContainerHost)
  {
    this.a = paramIQFlutterContainerHost;
  }
  
  private void m()
  {
    this.n.b();
    Object localObject = (SerializableMap)this.i.getSerializable("params");
    if (localObject != null) {
      localObject = ((SerializableMap)localObject).toJson();
    } else {
      localObject = "";
    }
    String str1 = this.i.getString("page_name", "unknown");
    String str2 = this.i.getString("unique_id", "-1");
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
    this.b = new FlutterEngine(BaseApplicationImpl.getContext(), FlutterLoader.getInstance(), new FlutterJNI(), new PlatformViewsController(), this.a.c().toArray(), true, false, new String[] { str1, localObject, str2 });
    this.d = new PlatformPlugin(this.a.b(), this.b.getPlatformChannel());
    this.b.getActivityControlSurface().attachToActivity(this.a.b(), this.a.getLifecycle());
    n();
    this.n.c();
  }
  
  private void n()
  {
    if (this.b != null)
    {
      this.e = new ChannelRegistrar();
      this.e.a(this.b);
      this.b.getPlugins().add(new DnFlutterPlugin());
    }
    VistaImageRegister.registerScheme("default", VistaImageDefaultHandler.class);
    VistaImageRegister.registerScheme("QQAvatar", VistaImageDefaultHandler.class);
  }
  
  private void o()
  {
    Activity localActivity = this.a.b();
    if (this.j) {
      localObject = FlutterView.RenderMode.texture;
    } else {
      localObject = FlutterView.RenderMode.surface;
    }
    FlutterView.TransparencyMode localTransparencyMode;
    if (this.j) {
      localTransparencyMode = FlutterView.TransparencyMode.transparent;
    } else {
      localTransparencyMode = FlutterView.TransparencyMode.opaque;
    }
    this.c = new FlutterView(localActivity, (FlutterView.RenderMode)localObject, localTransparencyMode);
    this.c.addOnFirstFrameRenderedListener(this.t);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.g.addView(this.c, (ViewGroup.LayoutParams)localObject);
  }
  
  private void p()
  {
    QFlutterLauncher.a().b();
    this.c.attachToFlutterEngine(this.b);
    Object localObject = FlutterMain.findAppBundlePath();
    String str1 = this.i.getString("entry_point", "main");
    String str2 = this.i.getString("init_route");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFlutterView, appBundlePath: ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", entryPoint: ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", initRoute: ");
    localStringBuilder.append(str2);
    QLog.d("QFlutterContainerDelegate", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(str2)) {
      this.b.getNavigationChannel().setInitialRoute(str2);
    }
    localObject = new DartExecutor.DartEntrypoint((String)localObject, str1);
    this.b.getDartExecutor().executeDartEntrypoint((DartExecutor.DartEntrypoint)localObject);
  }
  
  private void q()
  {
    QLog.d("QFlutterContainerDelegate", 1, "showFlutterView");
    if (!this.a.e())
    {
      this.f.removeView(this.h);
      this.h = null;
    }
    this.n.a(this.m);
    if (this.s.c) {
      QQToast.makeText(this.a.getContext(), 0, 2131896219, 1).show();
    }
    MemoryReporter.a().a(this.s.b);
  }
  
  private void r()
  {
    Object localObject = this.a.b();
    if ((localObject instanceof QBaseActivity))
    {
      localObject = (QBaseActivity)localObject;
      if (this.k)
      {
        SystemBarCompact localSystemBarCompact = ((QBaseActivity)localObject).mSystemBarComp;
        if (localSystemBarCompact != null)
        {
          localSystemBarCompact.setStatusDrawable(null);
          localSystemBarCompact.setStatusBarColor(0);
          localSystemBarCompact.setStatusColor(0);
        }
      }
      ImmersiveUtils.setStatusTextColor(this.l, ((QBaseActivity)localObject).getWindow());
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onCreateView");
    this.f = new FrameLayout(this.a.getContext());
    if (!this.j) {
      this.f.setBackgroundResource(2130852150);
    } else {
      this.f.setBackgroundColor(0);
    }
    paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
    this.g = new FrameLayout(this.a.getContext());
    this.f.addView(this.g, paramLayoutInflater);
    this.h = this.a.a();
    if (this.h == null) {
      this.h = LayoutInflater.from(this.a.getContext()).inflate(2131627108, null);
    }
    this.f.addView(this.h, paramLayoutInflater);
    this.p = true;
    if (this.o) {
      o();
    }
    return this.f;
  }
  
  public void a()
  {
    this.i = this.a.d();
    if (this.i == null) {
      this.i = new Bundle();
    }
    this.r = this.i.getBoolean("KEY_SETUP_FLUTTER", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAttach, needSetupEngine: ");
    ((StringBuilder)localObject).append(this.r);
    QLog.d("QFlutterContainerDelegate", 1, ((StringBuilder)localObject).toString());
    boolean bool = this.i.getBoolean("preload_process");
    long l1 = this.i.getLong("open_page_time");
    localObject = this.i.getString("page_name", "unknown");
    this.k = this.i.getBoolean("status_bar_transparent");
    this.l = this.i.getBoolean("status_text_dark");
    this.j = this.i.getBoolean("background_transparent");
    if (this.r)
    {
      this.n = new FirstFrameTrace((String)localObject, bool, l1);
      this.n.a();
      MemoryReporter.a().a((String)localObject);
      QFlutterLauncher.a().a(this.u, bool, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(@NonNull Intent paramIntent)
  {
    this.m = false;
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onNewIntent(paramIntent);
    }
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onActivityCreated()");
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onRestoreInstanceState(paramBundle);
    }
  }
  
  public void b()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onResume()");
    if (this.b != null) {
      p();
    }
    this.q = true;
  }
  
  public void b(@Nullable Bundle paramBundle)
  {
    QLog.d("QFlutterContainerDelegate", 1, "onSaveInstanceState");
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null) {
      localFlutterEngine.getActivityControlSurface().onSaveInstanceState(paramBundle);
    }
    this.i.putBoolean("KEY_SETUP_FLUTTER", false);
  }
  
  public void c()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onResume()");
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null) {
      localFlutterEngine.getLifecycleChannel().appIsResumed();
    }
    r();
  }
  
  public void d()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onPause()");
    this.m = false;
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null)
    {
      localFlutterEngine.getLifecycleChannel().appIsInactive();
      MemoryReporter.a().b();
    }
  }
  
  public void e()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onStop()");
    Object localObject = this.b;
    if (localObject != null) {
      ((FlutterEngine)localObject).getLifecycleChannel().appIsPaused();
    }
    localObject = this.c;
    if (localObject != null) {
      ((FlutterView)localObject).detachFromFlutterEngine();
    }
  }
  
  public void f()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onDestroyView()");
    FlutterView localFlutterView = this.c;
    if (localFlutterView != null) {
      localFlutterView.removeOnFirstFrameRenderedListener(this.t);
    }
    QFlutterLauncher.a().a(this.u);
  }
  
  public void g()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onDetach()");
    Object localObject = this.d;
    if (localObject != null)
    {
      ((PlatformPlugin)localObject).destroy();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null) {
      ((ChannelRegistrar)localObject).a();
    }
    if (this.b != null)
    {
      if (this.a.b().isChangingConfigurations()) {
        this.b.getActivityControlSurface().detachFromActivityForConfigChanges();
      } else {
        this.b.getActivityControlSurface().detachFromActivity();
      }
      this.b.getLifecycleChannel().appIsDetached();
      this.b.destroy();
      this.b = null;
    }
    if (this.s != null) {
      MemoryReporter.a().b(this.s.b);
    }
  }
  
  public void h()
  {
    QLog.d("QFlutterContainerDelegate", 1, "release");
    this.a = null;
    this.c = null;
    this.d = null;
  }
  
  public boolean i()
  {
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null)
    {
      localFlutterEngine.getNavigationChannel().popRoute();
      return true;
    }
    return false;
  }
  
  public void j()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onLowMemory");
    FlutterEngine localFlutterEngine = this.b;
    if (localFlutterEngine != null) {
      localFlutterEngine.getSystemChannel().sendMemoryPressureWarning();
    }
  }
  
  public void k()
  {
    String str = ThemeUtil.getCurrentThemeId();
    Object localObject = this.b;
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
  
  public boolean l()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate
 * JD-Core Version:    0.7.0.1
 */