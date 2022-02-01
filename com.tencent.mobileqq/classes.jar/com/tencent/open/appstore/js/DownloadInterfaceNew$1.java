package com.tencent.open.appstore.js;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DownloadInterfaceNew$1
  implements DownloadQueryListener
{
  DownloadInterfaceNew$1(DownloadInterfaceNew paramDownloadInterfaceNew, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    LogUtility.e("DownloadInterfaceNew", "[innerQuery] [onException] errorCode=" + paramInt + ", errorMsg=" + paramString);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    LogUtility.c("DownloadInterfaceNew", "[innerQuery] onResult = " + paramList.size());
    JSONArray localJSONArray = new JSONArray();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
        try
        {
          localJSONObject.put("appid", localDownloadInfo.jdField_c_of_type_JavaLangString);
          localJSONObject.put("packagename", localDownloadInfo.e);
          localJSONObject.put("versioncode", localDownloadInfo.b);
          localJSONObject.put("url", localDownloadInfo.d);
          localJSONObject.put("pro", localDownloadInfo.f);
          localJSONObject.put("state", localDownloadInfo.a());
          localJSONObject.put("ismyapp", localDownloadInfo.jdField_c_of_type_Int);
          localJSONObject.put("download_from", localDownloadInfo.h);
          localJSONObject.put("writecodestate", localDownloadInfo.j);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + this.jdField_a_of_type_JavaLangString + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);";
    LogUtility.c("DownloadInterfaceNew", "[innerQuery] querySucess : " + paramList);
    DownloadInterfaceNew.a(this.jdField_a_of_type_ComTencentOpenAppstoreJsDownloadInterfaceNew, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.js.DownloadInterfaceNew.1
 * JD-Core Version:    0.7.0.1
 */