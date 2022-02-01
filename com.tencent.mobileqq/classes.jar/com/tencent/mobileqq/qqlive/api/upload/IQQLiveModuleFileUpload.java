package com.tencent.mobileqq.qqlive.api.upload;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;

public abstract interface IQQLiveModuleFileUpload
  extends IQQLiveModule
{
  public abstract void uploadBitmap(Bitmap paramBitmap, QQLiveUploadBitmapParams paramQQLiveUploadBitmapParams, IQQLiveUploadBitmapCallback paramIQQLiveUploadBitmapCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload
 * JD-Core Version:    0.7.0.1
 */