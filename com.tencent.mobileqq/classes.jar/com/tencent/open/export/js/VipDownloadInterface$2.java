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
    Object localObject = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getQueryDownloadAction onException code = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg= ");
    LogUtility.e((String)localObject, localStringBuilder.toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("errCode", paramInt);
      ((JSONObject)localObject).put("errMsg", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = new StringBuilder();
    paramString.append("javascript:publicAccountDownload.queryProcess(");
    paramString.append(((JSONObject)localObject).toString());
    paramString.append(")");
    paramString = paramString.toString();
    this.a.a(paramString);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    Object localObject1 = this.a.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getQueryDownloadAction onResult = ");
    ((StringBuilder)localObject2).append(paramList.size());
    LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new JSONArray();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localObject2 = new JSONObject();
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
      try
      {
        ((JSONObject)localObject2).put("appid", localDownloadInfo.jdField_c_of_type_JavaLangString);
        ((JSONObject)localObject2).put("pro", localDownloadInfo.f);
        ((JSONObject)localObject2).put("state", localDownloadInfo.a());
        ((JSONObject)localObject2).put("ismyapp", localDownloadInfo.jdField_c_of_type_Int);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((JSONArray)localObject1).put(localObject2);
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("javascript:publicAccountDownload.queryProcess(");
    paramList.append(((JSONArray)localObject1).toString());
    paramList.append(")");
    paramList = paramList.toString();
    localObject1 = this.a.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getQueryDownloadAction callback url = ");
    ((StringBuilder)localObject2).append(paramList);
    LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
    this.a.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface.2
 * JD-Core Version:    0.7.0.1
 */