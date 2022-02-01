package com.tencent.open.appstore.js;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DINewForCommonWebView$1
  implements DownloadQueryListener
{
  DINewForCommonWebView$1(DINewForCommonWebView paramDINewForCommonWebView, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[innerQuery] [onException] errorCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMsg=");
    localStringBuilder.append(paramString);
    LogUtility.e("DINewForCommonWebView", localStringBuilder.toString());
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[innerQuery] onResult = ");
    ((StringBuilder)localObject).append(paramList.size());
    LogUtility.c("DINewForCommonWebView", ((StringBuilder)localObject).toString());
    localObject = new JSONArray();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = new JSONObject();
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
      try
      {
        localJSONObject.put("appid", localDownloadInfo.c);
        localJSONObject.put("packagename", localDownloadInfo.e);
        localJSONObject.put("versioncode", localDownloadInfo.n);
        localJSONObject.put("url", localDownloadInfo.d);
        localJSONObject.put("pro", localDownloadInfo.t);
        localJSONObject.put("state", localDownloadInfo.a());
        localJSONObject.put("ismyapp", localDownloadInfo.o);
        localJSONObject.put("download_from", localDownloadInfo.z);
        localJSONObject.put("writecodestate", localDownloadInfo.D);
        boolean bool = TextUtils.isEmpty(localDownloadInfo.q);
        if (bool) {
          localJSONObject.put("final_file_exits", "false");
        } else {
          localJSONObject.put("final_file_exits", new File(localDownloadInfo.q).exists());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((JSONArray)localObject).put(localJSONObject);
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("javascript:");
    paramList.append(this.a);
    paramList.append("(");
    paramList.append(((JSONArray)localObject).toString());
    paramList.append(")");
    paramList = paramList.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[innerQuery] querySucess : ");
    ((StringBuilder)localObject).append(paramList);
    LogUtility.c("DINewForCommonWebView", ((StringBuilder)localObject).toString());
    DINewForCommonWebView.a(this.b, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView.1
 * JD-Core Version:    0.7.0.1
 */