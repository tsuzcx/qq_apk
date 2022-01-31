package com.tencent.qqmini.sdk.runtime.core.page;

import android.content.Context;
import android.os.Build.VERSION;
import bhfy;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

public class BasePageWebview
  extends WebView
{
  public static volatile int a;
  private static final String jdField_a_of_type_JavaLangString = BasePageWebview.class.getSimpleName();
  protected bhfy a;
  private AppBrandPageContainer jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
  protected int b;
  
  public BasePageWebview(Context paramContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer = paramAppBrandPageContainer;
    this.b = a();
    paramContext = getSettings();
    paramContext.setSupportZoom(false);
    paramContext.setJavaScriptEnabled(true);
    paramContext.setCacheMode(2);
    setWebContentsDebuggingEnabled(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramContext.setMixedContentMode(0);
    }
    paramContext.setUserAgent(paramContext.getUserAgentString() + "QQ/MiniApp");
    if (Build.VERSION.SDK_INT >= 11)
    {
      removeJavascriptInterface("searchBoxJavaBridge_");
      removeJavascriptInterface("accessibility");
      removeJavascriptInterface("accessibilityTraversal");
    }
    try
    {
      if (getSettingsExtension() != null) {
        getSettingsExtension().setFirstScreenDetect(false);
      }
      if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer != null)
      {
        paramContext = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
        paramContext.jdField_a_of_type_Int += 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QMLog.e(jdField_a_of_type_JavaLangString, "BasePageWebview init exception!", paramContext);
      }
    }
  }
  
  public static int a()
  {
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    return i;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer != null)
    {
      AppBrandPageContainer localAppBrandPageContainer = this.jdField_a_of_type_ComTencentQqminiSdkRuntimeCorePageAppBrandPageContainer;
      localAppBrandPageContainer.jdField_a_of_type_Int -= 1;
    }
  }
  
  public void setPageEventListener(bhfy parambhfy)
  {
    this.jdField_a_of_type_Bhfy = parambhfy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.BasePageWebview
 * JD-Core Version:    0.7.0.1
 */