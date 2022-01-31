package com.tencent.tgpa.vendorpd.a;

import android.os.Environment;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.tgpa.vendorpd.GameCallback;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class d$1
  implements Callback
{
  d$1(d paramd) {}
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    g.b("onFailure: request version failed.");
    if (d.a(this.a) != null)
    {
      paramRequest = new StringBuilder();
      paramRequest.append("{\"ret\": 1,\"data\":{},\"msg\": \"network is not available.\"}");
      d.a(this.a).getPreDownloadVersionInfo(paramRequest.toString());
    }
  }
  
  public void onResponse(Response paramResponse)
  {
    g.b("onResponse: request version response code: " + paramResponse.code());
    Object localObject1 = paramResponse.body().string();
    if (!paramResponse.isSuccessful())
    {
      if (d.a(this.a) != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("{\"ret\": 2,\"data\":{},\"msg\": \"network request exception. code: ").append(paramResponse.code()).append("\"}");
        d.a(this.a).getPreDownloadVersionInfo(((StringBuilder)localObject1).toString());
      }
      return;
    }
    JSONObject localJSONObject;
    Iterator localIterator;
    try
    {
      g.b("onResponse: request version response: " + String.valueOf(localObject1));
      paramResponse = new JSONObject((String)localObject1);
      if ((!paramResponse.has("ret")) || (paramResponse.getInt("ret") != 0) || (!paramResponse.has("data"))) {
        break label457;
      }
      localJSONObject = paramResponse.getJSONObject("data");
      localIterator = localJSONObject.keys();
      ArrayList localArrayList = new ArrayList();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        try
        {
          Object localObject2 = localJSONObject.getJSONObject(str1);
          String str2 = ((JSONObject)localObject2).getString("path");
          ((JSONObject)localObject2).put("path", Environment.getExternalStorageDirectory() + File.separator + str2 + File.separator);
          localObject2 = ((JSONObject)localObject2).getJSONArray("pkgList");
          if (e.a(str1, d.b(this.a), (JSONArray)localObject2)) {
            localArrayList.add(str1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          g.c("onResponse: check game predownload info exception. game: " + str1);
          localArrayList.add(str1);
        }
      }
      localIterator = localArrayList.iterator();
    }
    catch (Exception paramResponse)
    {
      paramResponse.printStackTrace();
      g.c("onResponse: response content parse to json exception: " + String.valueOf(localObject1));
      paramResponse = new StringBuilder();
      paramResponse.append("{\"ret\": 3,\"data\":{},\"msg\": \"network request content parse json exception.").append("\"}");
      d.a(this.a).getPreDownloadVersionInfo(paramResponse.toString());
      return;
    }
    while (localIterator.hasNext()) {
      localJSONObject.remove((String)localIterator.next());
    }
    d.a(this.a).getPreDownloadVersionInfo(paramResponse.toString());
    return;
    label457:
    g.b("OnResponse: request failed, please check.");
    d.a(this.a).getPreDownloadVersionInfo(String.valueOf(localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.d.1
 * JD-Core Version:    0.7.0.1
 */