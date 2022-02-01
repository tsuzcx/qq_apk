package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebArticlePreloadUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.injector.ISwiftWebAcceleratorInjector;
import mqq.app.MobileQQ;

public class SwiftWebAcceleratorInjectorImpl
  implements ISwiftWebAcceleratorInjector
{
  public void a(Bundle paramBundle)
  {
    ((IRIJWebArticlePreloadUtil)QRoute.api(IRIJWebArticlePreloadUtil.class)).warmUpTemplateInWebProcess();
  }
  
  public void b(Bundle paramBundle)
  {
    IndividuationUrlHelper.a(MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAcceleratorInjectorImpl
 * JD-Core Version:    0.7.0.1
 */