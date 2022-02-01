package com.tencent.mobileqq.vas.adv.web;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface.DefaultImpls;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Callback;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Publisher;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Subscriber;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/VasAdvWebManager;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Publisher;", "()V", "TAG", "", "eventSubscribers", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "webViewRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/biz/ui/TouchWebView;", "getWebView", "activity", "Landroid/app/Activity;", "initWebView", "", "publishEvent", "businessId", "eventKey", "callback", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "params", "", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "removeWebView", "subscribe", "subscriber", "unsubscribe", "unsubscribeAll", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebManager
  implements VasAdvWebEvent.Publisher
{
  public static final VasAdvWebManager a;
  private static SoftReference<TouchWebView> jdField_a_of_type_JavaLangRefSoftReference;
  private static final Map<String, List<WeakReference<VasAdvWebEvent.Subscriber>>> jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasAdvWebVasAdvWebManager = new VasAdvWebManager();
  }
  
  @Nullable
  public final TouchWebView a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject1 = jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject1 != null)
    {
      localObject1 = (TouchWebView)((SoftReference)localObject1).get();
      if (localObject1 != null)
      {
        Object localObject2 = ((TouchWebView)localObject1).getPluginEngine();
        if (localObject2 != null) {
          ((WebViewPluginEngine)localObject2).a(null, paramActivity, null);
        }
        localObject2 = ((TouchWebView)localObject1).getParent();
        paramActivity = (Activity)localObject2;
        if (!(localObject2 instanceof ViewGroup)) {
          paramActivity = null;
        }
        localObject2 = (ViewGroup)paramActivity;
        paramActivity = (Activity)localObject1;
        if (localObject2 == null) {
          return paramActivity;
        }
        ((ViewGroup)localObject2).removeView((View)localObject1);
        return localObject1;
      }
    }
    paramActivity = null;
    return paramActivity;
  }
  
  public final void a()
  {
    Object localObject = jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject != null)
    {
      TouchWebView localTouchWebView = (TouchWebView)((SoftReference)localObject).get();
      if (localTouchWebView != null)
      {
        localObject = localTouchWebView.getPluginEngine();
        if (localObject != null) {
          ((WebViewPluginEngine)localObject).a = ((Activity)null);
        }
        ViewParent localViewParent = localTouchWebView.getParent();
        localObject = localViewParent;
        if (!(localViewParent instanceof ViewGroup)) {
          localObject = null;
        }
        localObject = (ViewGroup)localObject;
        if (localObject != null) {
          ((ViewGroup)localObject).removeView((View)localTouchWebView);
        }
      }
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable VasAdvWebEvent.Callback paramCallback, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "businessId");
    Intrinsics.checkParameterIsNotNull(paramString2, "eventKey");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    paramString1 = (List)jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = ((Iterable)paramString1).iterator();
      while (paramString1.hasNext())
      {
        VasAdvWebEvent.Subscriber localSubscriber = (VasAdvWebEvent.Subscriber)((WeakReference)paramString1.next()).get();
        if (localSubscriber != null) {
          localSubscriber.onVasEvent(paramString2, paramCallback, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        }
      }
    }
  }
  
  public final void b()
  {
    VasAdvAppInterface.DefaultImpls.a(VasAdvSupport.a.a(), (Runnable)VasAdvWebManager.initWebView.1.a, 0L, 2, null);
  }
  
  public void subscribe(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    Intrinsics.checkParameterIsNotNull(paramSubscriber, "subscriber");
    Object localObject = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject != null)
    {
      ((List)localObject).add(new WeakReference(paramSubscriber));
      if (localObject != null) {
        return;
      }
    }
    localObject = (VasAdvWebManager)this;
    jdField_a_of_type_JavaUtilMap.put(paramString, CollectionsKt.mutableListOf(new WeakReference[] { new WeakReference(paramSubscriber) }));
    paramString = Unit.INSTANCE;
  }
  
  public void unsubscribe(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    Intrinsics.checkParameterIsNotNull(paramSubscriber, "subscriber");
    paramString = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      CollectionsKt.removeAll(paramString, (Function1)new VasAdvWebManager.unsubscribe.1(paramSubscriber));
    }
  }
  
  public void unsubscribeAll(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    paramString = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.VasAdvWebManager
 * JD-Core Version:    0.7.0.1
 */