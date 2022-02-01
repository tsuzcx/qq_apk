package com.tencent.tkd.topicsdk.framework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import com.tencent.tkd.topicsdk.interfaces.IPageOpener;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.interfaces.IToast;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.interfaces.IWebViewOpener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"account", "Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "getAccount", "()Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "baseFileDir", "", "kotlin.jvm.PlatformType", "getBaseFileDir", "()Ljava/lang/String;", "baseSDCardDir", "getBaseSDCardDir", "fileProviderAuthority", "getFileProviderAuthority", "isDebugVersion", "", "()Z", "isKingCard", "isNightMode", "publishTempDir", "getPublishTempDir", "userActionHandler", "Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "getUserActionHandler", "()Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "getAppDrawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "openPage", "", "FRAGMENT", "Lcom/tencent/tkd/topicsdk/framework/BasePage;", "context", "Landroid/content/Context;", "clazz", "Ljava/lang/Class;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "pageOpener", "Lcom/tencent/tkd/topicsdk/interfaces/IPageOpener;", "openPageForResult", "activity", "Landroid/app/Activity;", "requestCode", "openUrl", "url", "bundle", "openUserProtocolPage", "title", "report", "action", "Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter$ACTION;", "values", "", "reporter", "Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter;", "showDebugToast", "msg", "showRichToast", "linkMsg", "link", "isLong", "toast", "Lcom/tencent/tkd/topicsdk/interfaces/IToast;", "showToast", "topicsdk_release"}, k=2, mv={1, 1, 16})
public final class TopicSDKHelperKt
{
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
    return TopicSDK.a.a().a().a().b();
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
  
  public static final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    if (a()) {
      a(paramString, false, null, 4, null);
    }
  }
  
  public static final void a(@NotNull String paramString, boolean paramBoolean, @Nullable IToast paramIToast)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static final boolean a()
  {
    return TopicSDK.a.a().a().a();
  }
  
  public static final String b()
  {
    return TopicSDK.a.a().a().a().d();
  }
  
  public static final boolean b()
  {
    return TopicSDK.a.a().a().a().a();
  }
  
  @NotNull
  public static final String c()
  {
    String str = TopicSDK.a.a().a().a().c();
    Intrinsics.checkExpressionValueIsNotNull(str, "TopicSDK.instance().topi…rageConfig.publishTempDir");
    return str;
  }
  
  public static final String d()
  {
    return TopicSDK.a.a().a().a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt
 * JD-Core Version:    0.7.0.1
 */