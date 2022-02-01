package com.tencent.mobileqq.profile.upload.task;

import android.graphics.Bitmap;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.config.VipUploadConfigImpl;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;

class VipImageUploadManager$1
  extends VipUploadConfigImpl
{
  VipImageUploadManager$1(VipImageUploadManager paramVipImageUploadManager, long paramLong)
  {
    super(paramLong);
  }
  
  public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize paramUploadImageSize, int paramInt, AbstractUploadTask paramAbstractUploadTask)
  {
    paramUploadImageSize = VipUploadUtils.a(paramAbstractUploadTask.uploadFilePath);
    if (paramUploadImageSize != null)
    {
      paramAbstractUploadTask = new IUploadConfig.UploadImageSize(paramUploadImageSize.getWidth(), paramUploadImageSize.getHeight(), 100);
      paramUploadImageSize.recycle();
      return paramAbstractUploadTask;
    }
    return new IUploadConfig.UploadImageSize(640, 1136, 100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipImageUploadManager.1
 * JD-Core Version:    0.7.0.1
 */