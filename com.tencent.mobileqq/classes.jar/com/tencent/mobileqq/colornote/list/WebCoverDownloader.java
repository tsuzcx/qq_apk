package com.tencent.mobileqq.colornote.list;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.HttpDownloader;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class WebCoverDownloader
  extends HttpDownloader
{
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = paramDownloadParams.url.getHost();
    String str = "";
    try
    {
      localObject = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { BaseApplicationImpl.getApplication().getRuntime().getAccount(), localObject });
      HttpResponse localHttpResponse = HttpUtil.openRequest(BaseApplicationImpl.getApplication(), (String)localObject, null, "GET", null, null, 5000, 5000);
      localObject = str;
      if (localHttpResponse != null)
      {
        localObject = str;
        if (localHttpResponse.getStatusLine().getStatusCode() == 200) {
          localObject = HttpUtil.readHttpResponse(localHttpResponse);
        }
      }
      localObject = new JSONObject((String)localObject);
      if (Integer.parseInt(((JSONObject)localObject).getString("ret")) == 0)
      {
        localObject = ((JSONObject)localObject).getString("thumbUrl");
        paramDownloadParams.url = new URL((String)localObject);
        paramDownloadParams.urlStr = ((String)localObject);
        localObject = super.downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.WebCoverDownloader
 * JD-Core Version:    0.7.0.1
 */