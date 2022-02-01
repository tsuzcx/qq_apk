package com.tencent.qqmini.nativePlugins;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CMShowJsPlugin$3$1
  implements Downloader.DownloadListener
{
  CMShowJsPlugin$3$1(CMShowJsPlugin.3 param3, JSONObject paramJSONObject) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.i("CMShowJsPlugin", 1, "get res from local failed.");
    this.jdField_a_of_type_ComTencentQqminiNativePluginsCMShowJsPlugin$3.a.fail();
    CMShowJsPlugin.a(false);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    try
    {
      QLog.i("CMShowJsPlugin", 1, "get res from local succeed.");
      if ((this.jdField_a_of_type_OrgJsonJSONObject != null) && (this.jdField_a_of_type_OrgJsonJSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject("avatar3D").get("local_face_data") != null) && (this.jdField_a_of_type_OrgJsonJSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject("avatar3D").getJSONArray("local_dress_res") != null) && (this.jdField_a_of_type_OrgJsonJSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject("avatar3D").getJSONArray("local_dress_res").length() != 0))
      {
        this.jdField_a_of_type_ComTencentQqminiNativePluginsCMShowJsPlugin$3.a.ok(this.jdField_a_of_type_OrgJsonJSONObject);
      }
      else
      {
        QLog.e("CMShowJsPlugin", 1, "invalid callback resultData!");
        this.jdField_a_of_type_ComTencentQqminiNativePluginsCMShowJsPlugin$3.a.fail();
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      this.jdField_a_of_type_ComTencentQqminiNativePluginsCMShowJsPlugin$3.a.fail();
    }
    CMShowJsPlugin.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.CMShowJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */