package com.tencent.mobileqq.studyroom.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin.OnOpenResultListener;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.mobileqq.qroute.module.QRoutePluginActivityParams.Builder;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginUpdater.OnPluginInfoUpdateListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studyroom/utils/StudyRoomQShadowLauncher;", "", "context", "Landroid/content/Context;", "data", "Landroid/os/Bundle;", "preload", "", "callback", "Lcom/tencent/mobileqq/studyroom/utils/PluginUtils$PluginCallback;", "(Landroid/content/Context;Landroid/os/Bundle;ZLcom/tencent/mobileqq/studyroom/utils/PluginUtils$PluginCallback;)V", "actionButton", "Landroid/widget/Button;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "confirmedDataCost", "currentProgress", "", "currentStep", "enterFuture", "Ljava/util/concurrent/Future;", "hasDownload", "hasReported", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mainTextView", "Landroid/widget/TextView;", "plugin", "Lcom/tencent/mobileqq/qroute/module/IQRoutePlugin;", "progressBar", "Landroid/widget/ProgressBar;", "qqAbility", "Lcom/tencent/mobileqq/studyroom/pluginimpl/QQBaseAbilityInterfaceImpl;", "getQqAbility", "()Lcom/tencent/mobileqq/studyroom/pluginimpl/QQBaseAbilityInterfaceImpl;", "qqAbility$delegate", "Lkotlin/Lazy;", "retryNotifier", "Ljava/util/concurrent/CountDownLatch;", "startTime", "", "subTextView", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "uiHandler$delegate", "uiTimer", "Lcom/tencent/mobileqq/studyroom/utils/UITimer;", "checkInterrupt", "", "msg", "", "enter", "getDownloadSize", "initLoadingView", "initPlugin", "installPlugin", "isDone", "isNew", "loadPlugin", "needWarnDataCost", "needWarnNetwork", "reportLoadPluginResult", "type", "restartProgress", "updateLaunchStep", "step", "mainText", "subText", "btnText", "onClick", "Lkotlin/Function0;", "updateProgress", "progress", "waitRetry", "Companion", "qqstudyroom_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyRoomQShadowLauncher
{
  public static final StudyRoomQShadowLauncher.Companion a;
  private static final Lazy jdField_c_of_type_KotlinLazy = LazyKt.lazy((Function0)StudyRoomQShadowLauncher.Companion.executor.2.INSTANCE);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IQRoutePlugin jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
  private final PluginUtils.PluginCallback jdField_a_of_type_ComTencentMobileqqStudyroomUtilsPluginUtils$PluginCallback;
  private UITimer jdField_a_of_type_ComTencentMobileqqStudyroomUtilsUITimer;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  private Future<?> jdField_a_of_type_JavaUtilConcurrentFuture;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private final Lazy jdField_a_of_type_KotlinLazy;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final Lazy jdField_b_of_type_KotlinLazy;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqStudyroomUtilsStudyRoomQShadowLauncher$Companion = new StudyRoomQShadowLauncher.Companion(null);
  }
  
  public StudyRoomQShadowLauncher(@NotNull Context paramContext, @NotNull Bundle paramBundle, boolean paramBoolean, @NotNull PluginUtils.PluginCallback paramPluginCallback)
  {
    Object localObject = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.sApplication");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsPluginUtils$PluginCallback = paramPluginCallback;
      this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)StudyRoomQShadowLauncher.uiHandler.2.INSTANCE);
      this.jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)StudyRoomQShadowLauncher.qqAbility.2.INSTANCE);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      this.jdField_a_of_type_Int = -1;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  private final long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("plugin");
    }
    localObject = ((IQRoutePlugin)localObject).queryPluginInfo();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return ((QRoutePluginInfo)localObject).getLength();
  }
  
  private final Handler a()
  {
    return (Handler)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final QQBaseAbilityInterfaceImpl a()
  {
    return (QQBaseAbilityInterfaceImpl)this.jdField_b_of_type_KotlinLazy.getValue();
  }
  
  private final void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("studyroom.QShadowLauncher", 1, "init view");
    a().post((Runnable)new StudyRoomQShadowLauncher.initLoadingView.1(this));
  }
  
  @UiThread
  private final void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (((StudyRoomQShadowLauncher)this).jdField_a_of_type_AndroidWidgetProgressBar == null) {
        return;
      }
      if (paramInt > this.jdField_b_of_type_Int)
      {
        this.jdField_b_of_type_Int = paramInt;
        Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("actionButton");
        }
        ((Button)localObject).setVisibility(8);
        localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        ((ProgressBar)localObject).setProgress(paramInt);
        localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        ((ProgressBar)localObject).setVisibility(0);
      }
    }
  }
  
  private final void a(int paramInt, String paramString1, String paramString2, String paramString3, Function0<Unit> paramFunction0)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update step ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(paramInt);
    QLog.i("studyroom.QShadowLauncher", 1, localStringBuilder.toString());
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    a().post((Runnable)new StudyRoomQShadowLauncher.updateLaunchStep.1(this, paramInt, i, paramString1, paramString2, paramString3, paramFunction0));
  }
  
  private final void a(String paramString)
  {
    if (!Thread.interrupted()) {
      return;
    }
    throw ((Throwable)new InterruptedException(paramString));
  }
  
  private final boolean a()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  private final void b()
  {
    this.jdField_b_of_type_Int = 0;
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = (StudyRoomQShadowLauncher)this;
      if (((StudyRoomQShadowLauncher)localObject).jdField_a_of_type_AndroidWidgetProgressBar == null) {
        return;
      }
      QLog.i("studyroom.QShadowLauncher", 1, "reset progress");
      if (((StudyRoomQShadowLauncher)localObject).jdField_a_of_type_ComTencentMobileqqStudyroomUtilsUITimer == null) {
        this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsUITimer = new UITimer();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqStudyroomUtilsUITimer;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("uiTimer");
      }
      ((UITimer)localObject).a((Runnable)new StudyRoomQShadowLauncher.restartProgress.3(this), StudyRoomQShadowLauncher.Companion.a(jdField_a_of_type_ComTencentMobileqqStudyroomUtilsStudyRoomQShadowLauncher$Companion, this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private final void b(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportLoadPluginResult, type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" cost = ");
      ((StringBuilder)localObject).append(l);
      QLog.i("studyroom.QShadowLauncher", 2, ((StringBuilder)localObject).toString());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "in_room");
    localBundle.putString("page", "study_room");
    localBundle.putString("module", "fail");
    localBundle.putString("fail_reason", String.valueOf(paramInt));
    localBundle.putString("download_times", String.valueOf(l));
    boolean bool = this.jdField_c_of_type_Boolean;
    String str = "1";
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localBundle.putString("if_download", (String)localObject);
    if (this.jdField_a_of_type_Boolean) {
      localObject = str;
    } else {
      localObject = "0";
    }
    localBundle.putString("is_preload", (String)localObject);
    a().reportData(localBundle);
  }
  
  private final boolean b()
  {
    return this.jdField_a_of_type_Int == 5;
  }
  
  private final void c()
  {
    Object localObject2 = new CountDownLatch(1);
    Object localObject4 = new StudyRoomQShadowLauncher.initPlugin.listener.1((CountDownLatch)localObject2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
    if (localObject1 != null)
    {
      localObject1 = (IPluginManager)localObject1;
      localObject4 = (PluginUpdater.OnPluginInfoUpdateListener)localObject4;
      ((IPluginManager)localObject1).a((PluginUpdater.OnPluginInfoUpdateListener)localObject4);
      try
      {
        IQRoutePlugin localIQRoutePlugin = QRoute.plugin("StudyRoom.apk");
        Intrinsics.checkExpressionValueIsNotNull(localIQRoutePlugin, "QRoute.plugin(PLUGIN_ID)");
        this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin = localIQRoutePlugin;
        localIQRoutePlugin = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
        if (localIQRoutePlugin == null) {
          Intrinsics.throwUninitializedPropertyAccessException("plugin");
        }
        if (localIQRoutePlugin.exist())
        {
          localIQRoutePlugin = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
          if (localIQRoutePlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("plugin");
          }
          if (!StudyRoomQShadowLauncherKt.a(localIQRoutePlugin.queryPluginInfo()))
          {
            QLog.i("studyroom.QShadowLauncher", 1, "plugin info not valid, wait update");
            ((CountDownLatch)localObject2).await(5L, TimeUnit.SECONDS);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
            if (localObject2 == null) {
              Intrinsics.throwUninitializedPropertyAccessException("plugin");
            }
            if (!StudyRoomQShadowLauncherKt.a(((IQRoutePlugin)localObject2).queryPluginInfo()))
            {
              a(this, 4, null, null, null, null, 30, null);
              throw ((Throwable)new RuntimeException("plugin info not valid"));
            }
          }
          return;
        }
        a(this, 4, null, null, null, null, 30, null);
        throw ((Throwable)new RuntimeException("plugin not exist"));
      }
      finally
      {
        ((IPluginManager)localObject1).b((PluginUpdater.OnPluginInfoUpdateListener)localObject4);
      }
    }
    throw new TypeCastException("null cannot be cast to non-null type cooperation.plugin.IPluginManager");
  }
  
  private final boolean c()
  {
    a(this, 1, null, null, null, null, 30, null);
    if (((StudyRoomQShadowLauncher)this).jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin == null) {
      c();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("plugin");
    }
    if (((IQRoutePlugin)localObject).isInstalled())
    {
      QLog.i("studyroom.QShadowLauncher", 1, "plugin has installed");
      this.jdField_c_of_type_Boolean = false;
      return true;
    }
    if (d())
    {
      QLog.i("studyroom.QShadowLauncher", 1, "no network error");
      a(this, 4, "加载失败，请重试!", "请检查网络设置后重试", "重新加载", null, 16, null);
      return false;
    }
    if (e())
    {
      QLog.i("studyroom.QShadowLauncher", 1, "no wifi error");
      long l = a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("立即更新(");
      ((StringBuilder)localObject).append(StudyRoomQShadowLauncher.Companion.a(jdField_a_of_type_ComTencentMobileqqStudyroomUtilsStudyRoomQShadowLauncher$Companion, l));
      ((StringBuilder)localObject).append(')');
      a(4, "请进行更新", "当前处于移动网络环境下,是否继续？", ((StringBuilder)localObject).toString(), (Function0)new StudyRoomQShadowLauncher.installPlugin.2(this));
      return false;
    }
    QLog.i("studyroom.QShadowLauncher", 1, "install plugin");
    localObject = new CountDownLatch(1);
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((Boolean)null);
    this.jdField_c_of_type_Boolean = true;
    IQRoutePlugin localIQRoutePlugin = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
    if (localIQRoutePlugin == null) {
      Intrinsics.throwUninitializedPropertyAccessException("plugin");
    }
    localIQRoutePlugin.install((IQRoutePluginInstallListener)new StudyRoomQShadowLauncher.installPlugin.3(this, localObjectRef, (CountDownLatch)localObject));
    ((CountDownLatch)localObject).await();
    localObject = (Boolean)localObjectRef.element;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  private final void d()
  {
    QLog.i("studyroom.QShadowLauncher", 1, "load plugin");
    a(this, 2, null, null, null, null, 30, null);
    Object localObject3 = (Bundle)a().getAccessToken("StudyRoom", "101854111").get();
    if (!((Bundle)localObject3).getBoolean("isSuccess", false))
    {
      QLog.i("studyroom.QShadowLauncher", 1, "get ticket fail");
      a(this, 4, "加载失败，请重试!", "请检查网络设置后重试", "重新加载", null, 16, null);
      b(2);
      return;
    }
    a(this, 3, null, null, null, null, 30, null);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject2 = new QRoutePluginActivityParams.Builder(this.jdField_a_of_type_AndroidContentContext).setSubModule("StudyRoom-main").setActivityName("com.tencent.od.app.newloginprocess.LoginActivity");
    Object localObject1 = new Intent().putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localObject3 = ((Bundle)localObject3).getBundle("data");
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    localObject3 = ((Intent)localObject1).putExtras((Bundle)localObject3).putExtra("ClickEnterRoom", this.jdField_a_of_type_Long);
    if (this.jdField_c_of_type_Boolean) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localObject1 = ((QRoutePluginActivityParams.Builder)localObject2).setIntent(((Intent)localObject3).putExtra("if_download", (String)localObject1)).setOpenResultListener((IQRoutePlugin.OnOpenResultListener)new StudyRoomQShadowLauncher.loadPlugin.param.1(this, localCountDownLatch));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("open activity preload:");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
    QLog.i("studyroom.QShadowLauncher", 1, ((StringBuilder)localObject2).toString());
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("plugin");
    }
    ((IQRoutePlugin)localObject2).startActivityForResult(((QRoutePluginActivityParams.Builder)localObject1).build());
    localCountDownLatch.await();
  }
  
  private final boolean d()
  {
    boolean bool2 = NetworkUtil.isNetworkAvailable();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("plugin");
    }
    localObject = ((IQRoutePlugin)localObject).queryPluginInfo();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    if ((((QRoutePluginInfo)localObject).getState() == 0) || (((QRoutePluginInfo)localObject).getState() == 1)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private final boolean e()
  {
    boolean bool3 = NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (this.jdField_b_of_type_Boolean) {
        return false;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQrouteModuleIQRoutePlugin;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
      }
      localObject = ((IQRoutePlugin)localObject).queryPluginInfo();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      bool1 = bool2;
      if (((QRoutePluginInfo)localObject).getState() == 0)
      {
        bool1 = bool2;
        if (((QRoutePluginInfo)localObject).getLength() > 2097152) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final boolean f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    CountDownLatch localCountDownLatch = this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
    if (localCountDownLatch != null) {
      localCountDownLatch.await();
    }
    return b() ^ true;
  }
  
  @NotNull
  public final Future<?> a()
  {
    if (a())
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      a();
      Future localFuture = StudyRoomQShadowLauncher.Companion.a(jdField_a_of_type_ComTencentMobileqqStudyroomUtilsStudyRoomQShadowLauncher$Companion).submit((Runnable)new StudyRoomQShadowLauncher.enter.1(this));
      Intrinsics.checkExpressionValueIsNotNull(localFuture, "executor.submit {\n      …e=${isDone()}\")\n        }");
      this.jdField_a_of_type_JavaUtilConcurrentFuture = localFuture;
      localFuture = this.jdField_a_of_type_JavaUtilConcurrentFuture;
      if (localFuture == null) {
        Intrinsics.throwUninitializedPropertyAccessException("enterFuture");
      }
      return localFuture;
    }
    throw ((Throwable)new IllegalStateException("duplicate enter same launcher"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomQShadowLauncher
 * JD-Core Version:    0.7.0.1
 */