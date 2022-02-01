package com.tencent.qqmini.sdk.plugins.engine;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.widget.AuthDialog;
import com.tencent.qqmini.sdk.widget.AuthDialog.AuthDialogResBuilder;

class BaseJsPluginEngine$13$1
  implements Runnable
{
  BaseJsPluginEngine$13$1(BaseJsPluginEngine.13 param13, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine.authDialog == null) {
      return;
    }
    AuthDialog.AuthDialogResBuilder localAuthDialogResBuilder = new AuthDialog.AuthDialogResBuilder();
    Object localObject1 = this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMiniAppProxy;
    Object localObject2 = this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_AndroidContentContext;
    Object localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    localObject1 = localAuthDialogResBuilder.setMiniAppIconUrl(((MiniAppProxy)localObject1).getDrawable((Context)localObject2, (String)localObject3, i, i, null)).setMiniAppName(this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_b_of_type_JavaLangString).setAuthTitle(this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.c);
    localObject2 = this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMiniAppProxy;
    localObject3 = this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_JavaLangString;
    i = this.jdField_b_of_type_Int;
    ((AuthDialog.AuthDialogResBuilder)localObject1).setUserIconUrl(((MiniAppProxy)localObject2).getDrawable((Context)localObject3, str, i, i, null)).setUserName(this.jdField_b_of_type_JavaLangString).setAuthDesc(this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.d).setReportSubAction(this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.e).setMiniAppInfo(this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine.mMiniAppContext.getMiniAppInfo()).setLeftBtnText("取消").setLeftBtnClickListener(new BaseJsPluginEngine.13.1.2(this)).setRightBtnText("允许").setRightBtnClickListener(new BaseJsPluginEngine.13.1.1(this));
    this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine.authDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine$13.jdField_a_of_type_ComTencentQqminiSdkPluginsEngineBaseJsPluginEngine.authDialog.show(localAuthDialogResBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.13.1
 * JD-Core Version:    0.7.0.1
 */