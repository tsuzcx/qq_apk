package com.tencent.open.export.js;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VipDownloadInterface$1
  implements DownloadQueryListener
{
  VipDownloadInterface$1(VipDownloadInterface paramVipDownloadInterface, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    LogUtility.e(this.b.a, "getQueryDownloadAction ERROR");
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    Object localObject1 = this.b.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getQueryDownloadAction onResult = ");
    ((StringBuilder)localObject2).append(paramList.size());
    LogUtility.c((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new JSONArray();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localObject2 = new JSONObject();
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
      try
      {
        ((JSONObject)localObject2).put("appid", localDownloadInfo.c);
        ((JSONObject)localObject2).put("pro", localDownloadInfo.t);
        ((JSONObject)localObject2).put("state", localDownloadInfo.a());
        ((JSONObject)localObject2).put("ismyapp", localDownloadInfo.o);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((JSONArray)localObject1).put(localObject2);
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": ");
    paramList.append(this.a);
    paramList.append(", \"r\" : 0, \"data\":");
    paramList.append(((JSONArray)localObject1).toString());
    paramList.append("});}void(0);");
    paramList = paramList.toString();
    localObject1 = this.b.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("querySucess : ");
    ((StringBuilder)localObject2).append(paramList);
    LogUtility.c((String)localObject1, ((StringBuilder)localObject2).toString());
    this.b.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.export.js.VipDownloadInterface.1
 * JD-Core Version:    0.7.0.1
 */