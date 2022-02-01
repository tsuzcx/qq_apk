package com.tencent.open.export.js;

import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipDownloadInterface$JsCheckUpdateCallback
  implements UpdateManager.OnCheckUpdateListener
{
  protected final String a;
  
  public VipDownloadInterface$JsCheckUpdateCallback(VipDownloadInterface paramVipDownloadInterface, String paramString)
  {
    LogUtility.b(paramVipDownloadInterface.jdField_a_of_type_JavaLangString, "new  JsCheckUpdateCallback");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.hasRight()) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsCheckUpdateCallback onException >>> ");
    localStringBuilder.append(paramString);
    LogUtility.e(str, localStringBuilder.toString());
    paramString = new StringBuilder();
    paramString.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    paramString.append("\",\"r\":\"-1\"});}void(0);");
    paramString = paramString.toString();
    this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.a(paramString);
  }
  
  public void a(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if (!this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.hasRight()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("JsCheckUpdateCallback onResult >>> ");
    ((StringBuilder)localObject2).append(paramArrayList.size());
    LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = new JSONObject();
    localObject1 = new JSONArray();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        ApkUpdateDetail localApkUpdateDetail = (ApkUpdateDetail)paramArrayList.get(i);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("packageName", localApkUpdateDetail.packageName);
        localJSONObject.put("newapksize", localApkUpdateDetail.newapksize);
        localJSONObject.put("patchsize", localApkUpdateDetail.patchsize);
        localJSONObject.put("updatemethod", localApkUpdateDetail.updatemethod);
        localJSONObject.put("versioncode", localApkUpdateDetail.versioncode);
        localJSONObject.put("versionname", localApkUpdateDetail.versionname);
        localJSONObject.put("fileMd5", localApkUpdateDetail.fileMd5);
        localJSONObject.put("sigMd5", localApkUpdateDetail.sigMd5);
        localJSONObject.put("url", localApkUpdateDetail.url);
        ((JSONArray)localObject1).put(localJSONObject);
        i += 1;
      }
      ((JSONObject)localObject2).put("guid", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("content", ((JSONArray)localObject1).toString());
      ((JSONObject)localObject2).put("resultCode", "0");
      paramArrayList = new StringBuilder();
      paramArrayList.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'");
      paramArrayList.append(this.jdField_a_of_type_JavaLangString);
      paramArrayList.append("','r':'0','data':'");
      paramArrayList.append(((JSONArray)localObject1).toString());
      paramArrayList.append("'});}void(0);");
      paramArrayList = paramArrayList.toString();
    }
    catch (JSONException paramArrayList)
    {
      label321:
      break label321;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"");
    paramArrayList.append(this.jdField_a_of_type_JavaLangString);
    paramArrayList.append("\",\"r\":\"-1\"});}void(0);");
    paramArrayList = paramArrayList.toString();
    localObject1 = this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">>checkUpdate jsUrl:");
    ((StringBuilder)localObject2).append(paramArrayList);
    LogUtility.b((String)localObject1, ((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface.JsCheckUpdateCallback
 * JD-Core Version:    0.7.0.1
 */