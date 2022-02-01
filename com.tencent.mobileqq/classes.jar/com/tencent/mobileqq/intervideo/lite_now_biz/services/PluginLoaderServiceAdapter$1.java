package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IGetInstallPlugins;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import org.json.JSONObject;

class PluginLoaderServiceAdapter$1
  implements HttpResponse
{
  PluginLoaderServiceAdapter$1(PluginLoaderServiceAdapter paramPluginLoaderServiceAdapter, IGetInstallPlugins paramIGetInstallPlugins) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (String str = "";; str = paramJSONObject.toString())
    {
      str = String.format("onResponse: code[%d] jsonObject[%s]", new Object[] { Integer.valueOf(paramInt), str });
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesPluginLoaderServiceAdapter.a().i("PluginLoaderService", str, new Object[0]);
      if ((paramInt == 0) && (paramJSONObject != null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIGetInstallPlugins.a(null);
      DataReport.b(str);
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesIGetInstallPlugins.a(PluginLoaderServiceAdapter.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesPluginLoaderServiceAdapter, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.PluginLoaderServiceAdapter.1
 * JD-Core Version:    0.7.0.1
 */