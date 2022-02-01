package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.falco.base.libapi.http.DownloadCallback;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.http.HttpInterface.HttpComponentAdapter;
import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.falco.base.libapi.http.UploadCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.mobileqq.now.netchannel.okhttp.OkHttpClientFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONObject;

public class CustomHttpService
  implements HttpInterface
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HttpInterface.HttpComponentAdapter jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface$HttpComponentAdapter;
  
  private void a(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface$HttpComponentAdapter.getLog().i("HttpComponent", "post url = " + paramString, new Object[0]);
    Request.Builder localBuilder = new Request.Builder().url(paramString);
    Iterator localIterator;
    String str1;
    String str2;
    if (paramMap1 != null)
    {
      localIterator = paramMap1.keySet().iterator();
      while (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        str2 = (String)paramMap1.get(str1);
        if (str2 != null) {
          localBuilder.addHeader(str1, str2);
        }
      }
    }
    localBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
    paramMap1 = new FormBody.Builder();
    if (paramMap2 != null)
    {
      localIterator = paramMap2.keySet().iterator();
      while (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        str2 = (String)paramMap2.get(str1);
        if (str2 != null) {
          paramMap1.add(str1, str2);
        }
      }
    }
    paramMap1 = localBuilder.post(paramMap1.build()).build();
    OkHttpClientFactory.a().newCall(paramMap1).enqueue(new CustomHttpService.4(this, paramString, paramCallback));
  }
  
  private void a(String paramString, Map<String, String> paramMap, Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface$HttpComponentAdapter.getLog().i("HttpComponent", "get url = " + paramString, new Object[0]);
    Request.Builder localBuilder = new Request.Builder().url(paramString);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        if (str2 != null) {
          localBuilder.addHeader(str1, str2);
        }
      }
    }
    paramMap = localBuilder.build();
    OkHttpClientFactory.a().newCall(paramMap).enqueue(new CustomHttpService.3(this, paramString, paramCallback));
  }
  
  public void clearEventOutput() {}
  
  public void download(String paramString1, Map<String, String> paramMap, String paramString2, DownloadCallback paramDownloadCallback)
  {
    a(paramString1, paramMap, new CustomHttpService.2(this, paramDownloadCallback, paramString2));
  }
  
  public void get(String paramString, HttpResponse paramHttpResponse)
  {
    get(paramString, null, paramHttpResponse);
  }
  
  public void get(String paramString, Map<String, String> paramMap, HttpResponse paramHttpResponse)
  {
    a(paramString, paramMap, new CommonCallback(paramHttpResponse, this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface$HttpComponentAdapter.getLog()));
  }
  
  public void init(HttpInterface.HttpComponentAdapter paramHttpComponentAdapter)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface$HttpComponentAdapter = paramHttpComponentAdapter;
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void post(String paramString, Map<String, String> paramMap, HttpResponse paramHttpResponse)
  {
    post(paramString, null, paramMap, paramHttpResponse);
  }
  
  public void post(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, HttpResponse paramHttpResponse)
  {
    a(paramString, paramMap1, paramMap2, new CommonCallback(paramHttpResponse, this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface$HttpComponentAdapter.getLog()));
  }
  
  public void post(String paramString, JSONObject paramJSONObject, HttpResponse paramHttpResponse)
  {
    paramJSONObject = new Request.Builder().url(paramString).post(RequestBody.create(MediaType.parse("application/json"), paramJSONObject.toString())).build();
    OkHttpClientFactory.a().newCall(paramJSONObject).enqueue(new CustomHttpService.1(this, paramString, paramHttpResponse));
  }
  
  public void upload(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, UploadCallback paramUploadCallback)
  {
    a(paramString, paramMap1, paramMap2, new CommonCallback(paramUploadCallback, this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface$HttpComponentAdapter.getLog()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpService
 * JD-Core Version:    0.7.0.1
 */