package com.tencent.mobileqq.vas.adv.base.support.app;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.adv.web.VasAdvWebPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasAdvAppImpl$initJsEnvironment$1
  implements Runnable
{
  VasAdvAppImpl$initJsEnvironment$1(VasAdvAppImpl paramVasAdvAppImpl, TouchWebView paramTouchWebView) {}
  
  public final void run()
  {
    TouchWebView localTouchWebView = this.a;
    if (localTouchWebView != null)
    {
      Object localObject;
      if (WebViewPluginEngine.a != null)
      {
        localObject = WebViewPluginEngine.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "WebViewPluginEngine.sPreloadEngine");
        WebViewPluginEngine.a = (WebViewPluginEngine)null;
      }
      else
      {
        localObject = VasAdvAppImpl.a(this.this$0);
        if (localObject == null) {
          break label116;
        }
        localObject = (AppInterface)localObject;
        VasAdvAppImpl.initJsEnvironment.1.1.commonJs.1 local1 = new VasAdvAppImpl.initJsEnvironment.1.1.commonJs.1();
        List localList = CollectionsKt.mutableListOf(new WebViewPlugin[] { (WebViewPlugin)new VasAdvWebPlugin() });
        localObject = WebAccelerateHelper.getInstance().createWebViewPluginEngine((AppRuntime)localObject, null, (CustomWebView)localTouchWebView, (CommonJsPluginFactory)local1, localList);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "WebAccelerateHelper.getI…is, commonJs, bizPlugins)");
      }
      localTouchWebView.setPluginEngine((WebViewPluginEngine)localObject);
      return;
      label116:
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppImpl.initJsEnvironment.1
 * JD-Core Version:    0.7.0.1
 */