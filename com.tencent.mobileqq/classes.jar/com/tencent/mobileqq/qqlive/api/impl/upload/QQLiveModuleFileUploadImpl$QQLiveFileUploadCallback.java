package com.tencent.mobileqq.qqlive.api.impl.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.UploadCallback;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class QQLiveModuleFileUploadImpl$QQLiveFileUploadCallback
  implements UploadCallback
{
  private int bitmapHashCode;
  private IQQLiveUploadBitmapCallback callback;
  private QQLiveUploadBitmapParams params;
  
  public QQLiveModuleFileUploadImpl$QQLiveFileUploadCallback(QQLiveModuleFileUploadImpl paramQQLiveModuleFileUploadImpl, int paramInt, QQLiveUploadBitmapParams paramQQLiveUploadBitmapParams, IQQLiveUploadBitmapCallback paramIQQLiveUploadBitmapCallback)
  {
    this.bitmapHashCode = paramInt;
    this.callback = paramIQQLiveUploadBitmapCallback;
    this.params = paramQQLiveUploadBitmapParams;
  }
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("upload result:");
      if (paramJSONObject == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramJSONObject.toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("QQLiveModuleFileUploadImpl", 1, ((StringBuilder)localObject2).toString());
    }
    if (QQLiveModuleFileUploadImpl.access$000(this.this$0))
    {
      QQLiveModuleFileUploadImpl.access$100(this.this$0, this.bitmapHashCode, "uploaded, module destroyed", this.callback);
      return;
    }
    int i;
    if (paramInt != 0)
    {
      paramJSONObject = this.this$0;
      i = this.bitmapHashCode;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("result code failed:");
      ((StringBuilder)localObject1).append(paramInt);
      QQLiveModuleFileUploadImpl.access$100(paramJSONObject, i, ((StringBuilder)localObject1).toString(), this.callback);
      return;
    }
    if (paramJSONObject == null)
    {
      QQLiveModuleFileUploadImpl.access$100(this.this$0, this.bitmapHashCode, "jsonObject is null", this.callback);
      return;
    }
    paramInt = paramJSONObject.optInt("retcode");
    if (paramInt != 0)
    {
      paramJSONObject = this.this$0;
      i = this.bitmapHashCode;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("jsonObject's retCode failed:");
      ((StringBuilder)localObject1).append(paramInt);
      QQLiveModuleFileUploadImpl.access$100(paramJSONObject, i, ((StringBuilder)localObject1).toString(), this.callback);
      return;
    }
    Object localObject2 = paramJSONObject.optJSONObject("result");
    if (localObject2 == null)
    {
      QQLiveModuleFileUploadImpl.access$100(this.this$0, this.bitmapHashCode, "jsonObject's result is null", this.callback);
      return;
    }
    paramJSONObject = ((JSONObject)localObject2).optString("url");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      localObject1 = this.this$0;
      paramInt = this.bitmapHashCode;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("picUrl is null or empty:");
      ((StringBuilder)localObject2).append(paramJSONObject);
      QQLiveModuleFileUploadImpl.access$100((QQLiveModuleFileUploadImpl)localObject1, paramInt, ((StringBuilder)localObject2).toString(), this.callback);
      return;
    }
    Object localObject1 = new QQLiveUploadBitmapResult(0, true, "");
    ((QQLiveUploadBitmapResult)localObject1).reqParams = this.params;
    ((QQLiveUploadBitmapResult)localObject1).url = paramJSONObject;
    ((QQLiveUploadBitmapResult)localObject1).timeStamp = ((JSONObject)localObject2).optInt("timestamp");
    paramJSONObject = this.callback;
    if (paramJSONObject != null) {
      paramJSONObject.a((QQLiveUploadBitmapResult)localObject1);
    }
    QQLiveModuleFileUploadImpl.access$300(this.this$0).remove(Integer.valueOf(this.bitmapHashCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.QQLiveModuleFileUploadImpl.QQLiveFileUploadCallback
 * JD-Core Version:    0.7.0.1
 */