package com.tencent.tkd.topicsdk.framework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.events.PosPermissionEvent;
import com.tencent.tkd.topicsdk.framework.events.StoragePermissionEvent;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter.ACTION;
import com.tencent.tkd.topicsdk.interfaces.IPageOpener;
import com.tencent.tkd.topicsdk.interfaces.IPermission;
import com.tencent.tkd.topicsdk.interfaces.IPermission.Callback;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.interfaces.IToast;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.interfaces.IWebViewOpener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"account", "Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "getAccount", "()Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "baseFileDir", "", "kotlin.jvm.PlatformType", "getBaseFileDir", "()Ljava/lang/String;", "baseSDCardDir", "getBaseSDCardDir", "fileProviderAuthority", "getFileProviderAuthority", "isDebugVersion", "", "()Z", "isKingCard", "isNightMode", "publishTempDir", "getPublishTempDir", "userActionHandler", "Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "getUserActionHandler", "()Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "checkPermission", "", "activity", "Landroid/app/Activity;", "permission", "permissionImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission;", "checkPosPermission", "checkStoragePermission", "openPage", "", "FRAGMENT", "Lcom/tencent/tkd/topicsdk/framework/BasePage;", "context", "Landroid/content/Context;", "clazz", "Ljava/lang/Class;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "pageOpener", "Lcom/tencent/tkd/topicsdk/interfaces/IPageOpener;", "openPageForResult", "requestCode", "openUrl", "url", "bundle", "openUserProtocolPage", "title", "report", "action", "Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter$ACTION;", "values", "", "reporter", "Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter;", "requestPermission", "permissions", "", "callback", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;", "(Landroid/app/Activity;[Ljava/lang/String;ILcom/tencent/tkd/topicsdk/interfaces/IPermission$Callback;)V", "requestPosPermission", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "requestStoragePermission", "showRichToast", "msg", "linkMsg", "link", "isLong", "toast", "Lcom/tencent/tkd/topicsdk/interfaces/IToast;", "showToast", "topicsdk_release"}, k=2, mv={1, 1, 16})
public final class TopicSDKHelperKt
{
  public static final int a(@NotNull Activity paramActivity, @NotNull String paramString, @NotNull IPermission paramIPermission)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "permission");
    Intrinsics.checkParameterIsNotNull(paramIPermission, "permissionImpl");
    return paramIPermission.a(paramActivity, paramString);
  }
  
  @NotNull
  public static final IAccount a()
  {
    return TopicSDK.a.a().a().a();
  }
  
  @NotNull
  public static final IUserActionHandler a()
  {
    return TopicSDK.a.a().a().a();
  }
  
  public static final String a()
  {
    return TopicSDK.a.a().a().a().d();
  }
  
  public static final <FRAGMENT extends BasePage> void a(@NotNull Activity paramActivity, @NotNull Class<FRAGMENT> paramClass, int paramInt, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2, @NotNull IPageOpener paramIPageOpener)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Intrinsics.checkParameterIsNotNull(paramIPageOpener, "pageOpener");
    Bundle localBundle = new Bundle();
    if (paramBundle1 != null) {
      localBundle.putBundle("key_base_bundle", paramBundle1);
    }
    localBundle.putString("pageId", paramClass.getName());
    if (paramBundle2 != null) {
      localBundle.putAll(paramBundle2);
    }
    paramIPageOpener.a(paramActivity, localBundle, paramInt);
  }
  
  public static final void a(@NotNull Activity paramActivity, @Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (a(paramActivity))
    {
      if (paramFunction1 != null) {
        paramActivity = (Unit)paramFunction1.invoke(Boolean.valueOf(true));
      }
      DispatchManager.a.a((IEvent)new StoragePermissionEvent(true));
      return;
    }
    paramFunction1 = (IPermission.Callback)new TopicSDKHelperKt.requestStoragePermission.1(paramFunction1);
    a(paramActivity, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" }, 1, paramFunction1);
  }
  
  public static final void a(@NotNull Activity paramActivity, @NotNull String[] paramArrayOfString, int paramInt, @NotNull IPermission.Callback paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "permissions");
    Intrinsics.checkParameterIsNotNull(paramCallback, "callback");
    TopicSDK.a.a().a().a().a(paramActivity, paramArrayOfString, paramInt, paramCallback);
  }
  
  public static final <FRAGMENT extends BasePage> void a(@NotNull Context paramContext, @NotNull Class<FRAGMENT> paramClass, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2, @NotNull IPageOpener paramIPageOpener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Intrinsics.checkParameterIsNotNull(paramIPageOpener, "pageOpener");
    Bundle localBundle = new Bundle();
    if (paramBundle1 != null) {
      localBundle.putBundle("key_base_bundle", paramBundle1);
    }
    localBundle.putString("pageId", paramClass.getName());
    if (paramBundle2 != null) {
      localBundle.putAll(paramBundle2);
    }
    paramIPageOpener.a(paramContext, localBundle);
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull String paramString, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    TopicSDK.a.a().a().a().a(paramContext, paramString, paramBundle);
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "title");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    IWebViewOpener localIWebViewOpener = TopicSDK.a.a().a().a();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showLeftBtn", true);
    localBundle.putString("title", paramString1);
    localIWebViewOpener.a(paramContext, paramString2, localBundle);
  }
  
  public static final void a(@NotNull IDataReporter.ACTION paramACTION, @NotNull Map<String, String> paramMap, @Nullable IDataReporter paramIDataReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramACTION, "action");
    Intrinsics.checkParameterIsNotNull(paramMap, "values");
    if (paramIDataReporter != null)
    {
      paramIDataReporter.a(paramACTION, paramMap);
      return;
    }
    TLog.a("dataReport", "no implement, action=" + paramACTION);
  }
  
  public static final void a(@NotNull String paramString, boolean paramBoolean, @Nullable IToast paramIToast)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    if (paramIToast != null)
    {
      paramIToast.a(paramString, paramBoolean);
      return;
    }
    paramIToast = AppContext.a.a();
    paramString = (CharSequence)paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Toast.makeText(paramIToast, paramString, i).show();
      return;
    }
  }
  
  public static final boolean a()
  {
    return TopicSDK.a.a().a().a();
  }
  
  public static final boolean a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return (a(paramActivity, "android.permission.READ_EXTERNAL_STORAGE", null, 4, null) == 0) && (a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE", null, 4, null) == 0);
  }
  
  @NotNull
  public static final String b()
  {
    String str = TopicSDK.a.a().a().a().c();
    Intrinsics.checkExpressionValueIsNotNull(str, "TopicSDK.instance().topi…rageConfig.publishTempDir");
    return str;
  }
  
  public static final void b(@NotNull Activity paramActivity, @Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (b(paramActivity))
    {
      if (paramFunction1 != null) {
        paramActivity = (Unit)paramFunction1.invoke(Boolean.valueOf(true));
      }
      DispatchManager.a.a((IEvent)new PosPermissionEvent(true));
      return;
    }
    paramFunction1 = (IPermission.Callback)new TopicSDKHelperKt.requestPosPermission.1(paramFunction1);
    a(paramActivity, new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 2, paramFunction1);
  }
  
  public static final boolean b()
  {
    return TopicSDK.a.a().a().a().a();
  }
  
  public static final boolean b(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return a(paramActivity, "android.permission.ACCESS_FINE_LOCATION", null, 4, null) == 0;
  }
  
  public static final String c()
  {
    return TopicSDK.a.a().a().a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt
 * JD-Core Version:    0.7.0.1
 */