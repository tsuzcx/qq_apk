package com.tencent.open.appcommon.js;

import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInterface$JsCheckUpdateCallback
  implements UpdateManager.OnCheckUpdateListener
{
  protected String a;
  
  public DownloadInterface$JsCheckUpdateCallback(DownloadInterface paramDownloadInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.hasRight()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsCheckUpdateCallback onException >>> ");
    localStringBuilder.append(paramString);
    LogUtility.e("DownloadInterface", localStringBuilder.toString());
    paramString = new StringBuilder();
    paramString.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    paramString.append("\",\"r\":\"-1\"});}void(0);");
    paramString = paramString.toString();
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramString);
  }
  
  public void a(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if (!this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.hasRight()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("JsCheckUpdateCallback onResult >>> ");
    ((StringBuilder)localObject).append(paramArrayList.size());
    LogUtility.a("DownloadInterface", ((StringBuilder)localObject).toString());
    JSONObject localJSONObject1 = new JSONObject();
    localObject = new JSONArray();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        ApkUpdateDetail localApkUpdateDetail = (ApkUpdateDetail)paramArrayList.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("packageName", localApkUpdateDetail.packageName);
        localJSONObject2.put("newapksize", localApkUpdateDetail.newapksize);
        localJSONObject2.put("patchsize", localApkUpdateDetail.patchsize);
        localJSONObject2.put("updatemethod", localApkUpdateDetail.updatemethod);
        localJSONObject2.put("versioncode", localApkUpdateDetail.versioncode);
        localJSONObject2.put("versionname", localApkUpdateDetail.versionname);
        localJSONObject2.put("fileMd5", localApkUpdateDetail.fileMd5);
        localJSONObject2.put("sigMd5", localApkUpdateDetail.sigMd5);
        localJSONObject2.put("url", localApkUpdateDetail.url);
        ((JSONArray)localObject).put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("guid", this.jdField_a_of_type_JavaLangString);
      localJSONObject1.put("content", ((JSONArray)localObject).toString());
      localJSONObject1.put("resultCode", "0");
      paramArrayList = new StringBuilder();
      paramArrayList.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'");
      paramArrayList.append(this.jdField_a_of_type_JavaLangString);
      paramArrayList.append("','r':'0','data':'");
      paramArrayList.append(((JSONArray)localObject).toString());
      paramArrayList.append("'});}void(0);");
      paramArrayList = paramArrayList.toString();
    }
    catch (JSONException paramArrayList)
    {
      label310:
      break label310;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"");
    paramArrayList.append(this.jdField_a_of_type_JavaLangString);
    paramArrayList.append("\",\"r\":\"-1\"});}void(0);");
    paramArrayList = paramArrayList.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">>checkUpdate jsUrl:");
    ((StringBuilder)localObject).append(paramArrayList);
    LogUtility.b("DownloadInterface", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramArrayList);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface.JsCheckUpdateCallback
 * JD-Core Version:    0.7.0.1
 */