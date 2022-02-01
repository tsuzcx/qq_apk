package com.tencent.mobileqq.jsp;

import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.io.File;
import org.json.JSONObject;

class AECameraPlugin$3
  implements INetEngineListener
{
  AECameraPlugin$3(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2, String paramString3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mErrCode == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 2);
      paramNetResp = AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading succeeded");
      this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { paramNetResp.toString() });
      if (AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.mRuntime.a())) {
        FileUtils.a(BaseApplicationImpl.getApplication(), new File(this.c));
      }
      return;
    }
    AECameraPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, 3);
    paramNetResp = AECameraPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin, this.jdField_a_of_type_JavaLangString, "downloading failed");
    this.jdField_a_of_type_ComTencentMobileqqJspAECameraPlugin.callJs(this.b, new String[] { paramNetResp.toString() });
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AECameraPlugin.3
 * JD-Core Version:    0.7.0.1
 */