package com.tencent.open.appcommon.js;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DownloadInterface$1
  implements DownloadQueryListener
{
  DownloadInterface$1(DownloadInterface paramDownloadInterface, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    LogUtility.e("DownloadInterface", "innerQueryDownloadInfo ERROR");
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("innerQueryDownloadInfo onResult = ");
    ((StringBuilder)localObject).append(paramList.size());
    LogUtility.c("DownloadInterface", ((StringBuilder)localObject).toString());
    localObject = new JSONArray();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = new JSONObject();
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
      try
      {
        localJSONObject.put("appid", localDownloadInfo.jdField_c_of_type_JavaLangString);
        localJSONObject.put("pro", localDownloadInfo.f);
        localJSONObject.put("state", localDownloadInfo.a());
        localJSONObject.put("ismyapp", localDownloadInfo.jdField_c_of_type_Int);
        localJSONObject.put("download_from", localDownloadInfo.h);
        localJSONObject.put("writecodestate", localDownloadInfo.j);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((JSONArray)localObject).put(localJSONObject);
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": ");
    paramList.append(this.jdField_a_of_type_JavaLangString);
    paramList.append(", \"r\" : 0, \"data\":");
    paramList.append(((JSONArray)localObject).toString());
    paramList.append("});}void(0);");
    paramList = paramList.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("querySucess : ");
    ((StringBuilder)localObject).append(paramList);
    LogUtility.c("DownloadInterface", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface.1
 * JD-Core Version:    0.7.0.1
 */