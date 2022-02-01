package com.tencent.mobileqq.qqlive.api.impl.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask.OnStorePhotoCallback;
import com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.UploadParms;
import com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.UploadPhotoTask;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.qphone.base.util.QLog;

class QQLiveModuleFileUploadImpl$QQLiveFileOnStorePhotoCallback
  implements StoreFileTask.OnStorePhotoCallback
{
  private int bitmapHashCode;
  private IQQLiveUploadBitmapCallback callback;
  private QQLiveUploadBitmapParams params;
  
  public QQLiveModuleFileUploadImpl$QQLiveFileOnStorePhotoCallback(QQLiveModuleFileUploadImpl paramQQLiveModuleFileUploadImpl, int paramInt, QQLiveUploadBitmapParams paramQQLiveUploadBitmapParams, IQQLiveUploadBitmapCallback paramIQQLiveUploadBitmapCallback)
  {
    this.bitmapHashCode = paramInt;
    this.callback = paramIQQLiveUploadBitmapCallback;
    this.params = paramQQLiveUploadBitmapParams;
  }
  
  public void onFail(String paramString)
  {
    QQLiveModuleFileUploadImpl localQQLiveModuleFileUploadImpl = this.this$0;
    int i = this.bitmapHashCode;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("store failed:");
    localStringBuilder.append(paramString);
    QQLiveModuleFileUploadImpl.access$100(localQQLiveModuleFileUploadImpl, i, localStringBuilder.toString(), this.callback);
  }
  
  public void onSuccess(String paramString)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("store success:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("QQLiveModuleFileUploadImpl", 1, ((StringBuilder)localObject1).toString());
    }
    if (QQLiveModuleFileUploadImpl.access$000(this.this$0))
    {
      QQLiveModuleFileUploadImpl.access$100(this.this$0, this.bitmapHashCode, "stored, module destroyed", this.callback);
      return;
    }
    Object localObject1 = null;
    try
    {
      LoginInfo localLoginInfo = QQLiveModuleFileUploadImpl.access$200(this.this$0).getLoginModule().getLoginInfo();
      localObject1 = localLoginInfo;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLiveModuleFileUploadImpl", 1, "getLoginInfo error, ", localThrowable);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((LoginInfo)localObject1).a2)))
    {
      localObject2 = new UploadParms();
      ((UploadParms)localObject2).localPhotoPath = paramString;
      ((UploadParms)localObject2).flag = this.params.flag;
      ((UploadParms)localObject2).format = this.params.format;
      ((UploadParms)localObject2).loginInfo = ((LoginInfo)localObject1);
      ((UploadParms)localObject2).roomId = this.params.roomId;
      ((UploadParms)localObject2).useTestEnv = this.params.useTestEnv;
      new UploadPhotoTask().upload((UploadParms)localObject2, new QQLiveModuleFileUploadImpl.QQLiveFileUploadCallback(this.this$0, this.bitmapHashCode, this.params, this.callback));
      return;
    }
    paramString = this.this$0;
    int i = this.bitmapHashCode;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("check login failed:");
    if (localObject1 != null) {
      bool1 = false;
    }
    ((StringBuilder)localObject2).append(bool1);
    QQLiveModuleFileUploadImpl.access$100(paramString, i, ((StringBuilder)localObject2).toString(), this.callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.QQLiveModuleFileUploadImpl.QQLiveFileOnStorePhotoCallback
 * JD-Core Version:    0.7.0.1
 */