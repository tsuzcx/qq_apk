package com.tencent.mobileqq.qqlive.api.impl.upload;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask;
import com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QQLiveModuleFileUploadImpl
  implements IQQLiveModuleFileUpload
{
  private static final String TAG = "QQLiveModuleFileUploadImpl";
  private File appCacheFile;
  private ConcurrentHashMap<Integer, QQLiveUploadBitmapParams> doingTask = new ConcurrentHashMap();
  private boolean isDestroyed = false;
  private IQQLiveSDK liveSDK;
  
  private void errorCallback(int paramInt, String paramString, IQQLiveUploadBitmapCallback paramIQQLiveUploadBitmapCallback)
  {
    if (paramIQQLiveUploadBitmapCallback != null)
    {
      paramIQQLiveUploadBitmapCallback.a(new QQLiveUploadBitmapResult(6501, false, paramString));
      if (paramInt != -1) {
        this.doingTask.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  public void destroy()
  {
    this.isDestroyed = true;
    this.doingTask.clear();
    this.appCacheFile = null;
    this.liveSDK = null;
  }
  
  public String getTargetPath(int paramInt, QQLiveUploadBitmapParams paramQQLiveUploadBitmapParams)
  {
    File localFile = this.appCacheFile;
    if (localFile == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramQQLiveUploadBitmapParams.format);
    localStringBuilder.append(".jpg");
    return new File(localFile, localStringBuilder.toString()).getAbsolutePath();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.liveSDK = paramIQQLiveSDK;
    try
    {
      this.appCacheFile = paramIQQLiveSDK.getAppRuntime().getApp().getCacheDir();
      return;
    }
    catch (Throwable paramIQQLiveSDK)
    {
      QLog.e("QQLiveModuleFileUploadImpl", 1, "getCacheDir error, ", paramIQQLiveSDK);
      this.appCacheFile = null;
    }
  }
  
  public void reset() {}
  
  public void uploadBitmap(Bitmap paramBitmap, QQLiveUploadBitmapParams paramQQLiveUploadBitmapParams, IQQLiveUploadBitmapCallback paramIQQLiveUploadBitmapCallback)
  {
    if ((paramBitmap != null) && (paramQQLiveUploadBitmapParams != null))
    {
      if ((!TextUtils.isEmpty(paramQQLiveUploadBitmapParams.roomId)) && (!TextUtils.isEmpty(paramQQLiveUploadBitmapParams.format)))
      {
        int i = paramBitmap.hashCode();
        Object localObject = (QQLiveUploadBitmapParams)this.doingTask.get(Integer.valueOf(i));
        if ((localObject != null) && (((QQLiveUploadBitmapParams)localObject).equals(paramQQLiveUploadBitmapParams)))
        {
          errorCallback(-1, "already uploading...", paramIQQLiveUploadBitmapCallback);
          return;
        }
        localObject = getTargetPath(i, paramQQLiveUploadBitmapParams);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("targetPath is null or empty:");
          paramBitmap.append((String)localObject);
          errorCallback(-1, paramBitmap.toString(), paramIQQLiveUploadBitmapCallback);
          return;
        }
        this.doingTask.put(Integer.valueOf(i), paramQQLiveUploadBitmapParams);
        new StoreFileTask(paramBitmap, (String)localObject).start(new QQLiveModuleFileUploadImpl.QQLiveFileOnStorePhotoCallback(this, i, paramQQLiveUploadBitmapParams, paramIQQLiveUploadBitmapCallback));
        return;
      }
      errorCallback(-1, "params invalid", paramIQQLiveUploadBitmapCallback);
      return;
    }
    errorCallback(-1, "check param null", paramIQQLiveUploadBitmapCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.QQLiveModuleFileUploadImpl
 * JD-Core Version:    0.7.0.1
 */