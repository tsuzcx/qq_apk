package cooperation.vip.web;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import cooperation.vip.VasAdvAppInterface.DefaultImpls;
import cooperation.vip.VasAdvSupport;
import cooperation.vip.VasAdvSupport.Companion;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/web/VasAdvWebManager;", "Lcooperation/vip/web/VasAdvWebEvent$Publisher;", "()V", "TAG", "", "eventSubscribers", "", "", "Ljava/lang/ref/WeakReference;", "Lcooperation/vip/web/VasAdvWebEvent$Subscriber;", "webViewRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/biz/ui/TouchWebView;", "getWebView", "activity", "Landroid/app/Activity;", "initWebView", "", "publishEvent", "businessId", "eventKey", "callback", "Lcooperation/vip/web/VasAdvWebEvent$Callback;", "params", "", "", "(Ljava/lang/String;Ljava/lang/String;Lcooperation/vip/web/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "removeWebView", "subscribe", "subscriber", "unsubscribe", "unsubscribeAll", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvWebManager
  implements VasAdvWebEvent.Publisher
{
  public static final VasAdvWebManager a;
  private static SoftReference<TouchWebView> jdField_a_of_type_JavaLangRefSoftReference;
  private static final Map<String, List<WeakReference<VasAdvWebEvent.Subscriber>>> jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_CooperationVipWebVasAdvWebManager = new VasAdvWebManager();
  }
  
  @Nullable
  public final TouchWebView a(@NotNull Activity paramActivity)
  {
    Object localObject1 = null;
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject2 = jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject2 != null)
    {
      localObject2 = (TouchWebView)((SoftReference)localObject2).get();
      if (localObject2 != null)
      {
        WebViewPluginEngine localWebViewPluginEngine = ((TouchWebView)localObject2).getPluginEngine();
        if (localWebViewPluginEngine != null) {
          localWebViewPluginEngine.a(null, paramActivity, null);
        }
        paramActivity = ((TouchWebView)localObject2).getParent();
        if ((paramActivity instanceof ViewGroup)) {
          break label82;
        }
        paramActivity = localObject1;
      }
    }
    label82:
    for (;;)
    {
      paramActivity = (ViewGroup)paramActivity;
      if (paramActivity != null) {
        paramActivity.removeView((View)localObject2);
      }
      return localObject2;
      return null;
    }
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
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    paramString = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public void a(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber)
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
          localSubscriber.a(paramString2, paramCallback, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        }
      }
    }
  }
  
  public final void b()
  {
    VasAdvAppInterface.DefaultImpls.a(VasAdvSupport.a.a(), (Runnable)VasAdvWebManager.initWebView.1.a, 0L, 2, null);
  }
  
  public void b(@NotNull String paramString, @NotNull VasAdvWebEvent.Subscriber paramSubscriber)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    Intrinsics.checkParameterIsNotNull(paramSubscriber, "subscriber");
    paramString = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      CollectionsKt.removeAll(paramString, (Function1)new VasAdvWebManager.unsubscribe.1(paramSubscriber));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.web.VasAdvWebManager
 * JD-Core Version:    0.7.0.1
 */