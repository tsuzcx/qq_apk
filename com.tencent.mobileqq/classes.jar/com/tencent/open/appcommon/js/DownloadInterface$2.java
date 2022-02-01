package com.tencent.open.appcommon.js;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DownloadInterface$2
  implements DownloadQueryListener
{
  DownloadInterface$2(DownloadInterface paramDownloadInterface, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    LogUtility.e("DownloadInterface", "innerQueryDownloadInfoByViaInfo ERROR");
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    LogUtility.c("DownloadInterface", "innerQueryDownloadInfoByVia onResult = " + paramList.size());
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
          localJSONObject.put("pro", localDownloadInfo.f);
          localJSONObject.put("state", localDownloadInfo.a());
          localJSONObject.put("ismyapp", localDownloadInfo.jdField_c_of_type_Int);
          localJSONObject.put("download_from", localDownloadInfo.h);
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
    paramList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadActionByVia',{\"guid\": " + this.jdField_a_of_type_JavaLangString + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);";
    LogUtility.c("DownloadInterface", "innerQueryDownloadInfoByVia querySucess : " + paramList);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appcommon.js.DownloadInterface.2
 * JD-Core Version:    0.7.0.1
 */