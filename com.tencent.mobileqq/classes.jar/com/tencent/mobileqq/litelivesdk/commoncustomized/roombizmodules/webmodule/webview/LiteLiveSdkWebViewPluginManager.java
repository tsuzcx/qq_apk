package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.common.app.BaseApplicationImpl;

public class LiteLiveSdkWebViewPluginManager
{
  private static LiteLiveSdkWebViewPluginManager jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewPluginManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private LiteLiveSdkWebViewRuntime jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewRuntime;
  
  public static LiteLiveSdkWebViewPluginManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewPluginManager == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewPluginManager == null) {
          jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewPluginManager = new LiteLiveSdkWebViewPluginManager();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewPluginManager;
  }
  
  public LiteLiveSdkWebViewRuntime a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewRuntime == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewRuntime == null)
        {
          LiteLiveSdkWebViewRuntime localLiteLiveSdkWebViewRuntime = new LiteLiveSdkWebViewRuntime(BaseApplicationImpl.getApplication(), "LiteLiveSdk");
          localLiteLiveSdkWebViewRuntime.onCreate(null);
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewRuntime = localLiteLiveSdkWebViewRuntime;
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewRuntime;
  }
  
  public void a(LiteLiveSdkWebViewRuntime paramLiteLiveSdkWebViewRuntime)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewRuntime = paramLiteLiveSdkWebViewRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewPluginManager
 * JD-Core Version:    0.7.0.1
 */