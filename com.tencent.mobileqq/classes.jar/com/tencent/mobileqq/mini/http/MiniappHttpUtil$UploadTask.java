package com.tencent.mobileqq.mini.http;

import android.text.TextUtils;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.json.JSONObject;

public class MiniappHttpUtil$UploadTask
  implements Runnable
{
  Call call;
  HttpCallBack callBack;
  String filePath;
  JSONObject formDataObj;
  JSONObject headerObj;
  volatile boolean isCanceled = false;
  String method;
  String name;
  String uploadFileName;
  String url;
  
  MiniappHttpUtil$UploadTask(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, HttpCallBack paramHttpCallBack)
  {
    this.method = paramString1;
    this.url = paramString2;
    this.filePath = paramString3;
    this.headerObj = paramJSONObject1;
    this.formDataObj = paramJSONObject2;
    this.name = paramString4;
    this.uploadFileName = paramString5;
    this.callBack = paramHttpCallBack;
  }
  
  private RequestBody buildMultiPartBody(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    MultipartBody.Builder localBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    if (paramJSONObject != null)
    {
      localObject1 = paramJSONObject.keys();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localBuilder.addFormDataPart((String)localObject2, paramJSONObject.optString((String)localObject2));
      }
    }
    Object localObject2 = new File(this.filePath);
    Object localObject1 = new ProgressRequestBody(RequestBody.create(MediaType.parse(MiniappHttpUtil.access$000(this.filePath)), (File)localObject2), new MiniappHttpUtil.UploadTask.2(this));
    paramJSONObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramJSONObject = ((File)localObject2).getName();
    }
    localBuilder.addFormDataPart(paramString1, paramJSONObject, (RequestBody)localObject1);
    return localBuilder.build();
  }
  
  public void abort()
  {
    this.isCanceled = true;
    if (this.call != null) {
      this.call.cancel();
    }
  }
  
  public void run()
  {
    Request.Builder localBuilder;
    try
    {
      OkHttpClient localOkHttpClient = MiniOkHttpClientFactory.getUploadClient();
      localBuilder = new Request.Builder();
      localBuilder.tag(localOkHttpClient).url(this.url).addHeader("Charset", "utf-8").addHeader("connection", "keep-alive");
      if (this.headerObj != null)
      {
        Iterator localIterator = this.headerObj.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBuilder.addHeader(str, this.headerObj.optString(str));
        }
      }
      localBuilder.method(this.method, buildMultiPartBody(this.formDataObj, this.name, this.uploadFileName));
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      QLog.e("MiniappHttpUtil", 1, "upload err", localThrowable);
      this.callBack.httpCallBack(MiniappHttpUtil.getRetCodeFrom(localThrowable, -1), null, null);
      return;
      if (this.isCanceled)
      {
        this.callBack.httpCallBack(-5, null, null);
        return;
      }
    }
    finally {}
    this.call = localObject.newCall(localBuilder.build());
    this.call.enqueue(new MiniappHttpUtil.UploadTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.MiniappHttpUtil.UploadTask
 * JD-Core Version:    0.7.0.1
 */