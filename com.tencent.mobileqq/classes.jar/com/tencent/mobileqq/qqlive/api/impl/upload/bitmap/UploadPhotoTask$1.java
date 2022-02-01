package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

class UploadPhotoTask$1
  implements Callback
{
  UploadPhotoTask$1(UploadPhotoTask paramUploadPhotoTask, String paramString, UploadCallback paramUploadCallback) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    if (QLog.isColorLevel())
    {
      paramCall = new StringBuilder();
      paramCall.append("url = ");
      paramCall.append(this.val$url);
      paramCall.append(", onFailure e = ");
      paramCall.append(paramIOException);
      QLog.d("UploadPhotoTask", 1, paramCall.toString());
    }
    this.val$uploadCallback.onResponse(-1, null);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (QLog.isColorLevel())
    {
      paramCall = new StringBuilder();
      paramCall.append("url = ");
      paramCall.append(this.val$url);
      paramCall.append(", onResponse code = ");
      paramCall.append(paramResponse.code());
      QLog.d("UploadPhotoTask", 1, paramCall.toString());
    }
    if (paramResponse == null)
    {
      this.val$uploadCallback.onResponse(-2, null);
      return;
    }
    if (!paramResponse.isSuccessful())
    {
      this.val$uploadCallback.onResponse(paramResponse.code(), null);
      return;
    }
    if (paramResponse.body() != null) {
      paramCall = paramResponse.body().string();
    } else {
      paramCall = "";
    }
    if (QLog.isColorLevel())
    {
      paramResponse = new StringBuilder();
      paramResponse.append("url = ");
      paramResponse.append(this.val$url);
      paramResponse.append(", body = ");
      paramResponse.append(paramCall);
      QLog.d("UploadPhotoTask", 1, paramResponse.toString());
    }
    try
    {
      paramCall = new JSONObject(paramCall);
      this.val$uploadCallback.onResponse(0, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      QLog.e("UploadPhotoTask", 1, "httpUplod error, ", paramCall);
      this.val$uploadCallback.onResponse(-3, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.UploadPhotoTask.1
 * JD-Core Version:    0.7.0.1
 */