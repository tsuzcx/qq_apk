package com.tencent.open.export.js;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VipDownloadInterface$2
  implements DownloadQueryListener
{
  VipDownloadInterface$2(VipDownloadInterface paramVipDownloadInterface) {}
  
  public void a(int paramInt, String paramString)
  {
    LogUtility.e(this.a.a, "getQueryDownloadAction onException code = " + paramInt + " msg= ");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", paramString);
      paramString = "javascript:publicAccountDownload.queryProcess(" + localJSONObject.toString() + ")";
      this.a.a(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    LogUtility.a(this.a.a, "getQueryDownloadAction onResult = " + paramList.size());
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
    paramList = "javascript:publicAccountDownload.queryProcess(" + localJSONArray.toString() + ")";
    LogUtility.a(this.a.a, "getQueryDownloadAction callback url = " + paramList);
    this.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface.2
 * JD-Core Version:    0.7.0.1
 */