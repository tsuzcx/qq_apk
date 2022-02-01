package com.tencent.upload.impl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.upload.image.ImageProcessProxy.ImageCompressorCallback;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

class ImageUploadService$2
  implements ImageProcessProxy.ImageCompressorCallback
{
  ImageUploadService$2(ImageUploadService paramImageUploadService) {}
  
  public void onCompressFinish(int paramInt, String paramString1, String paramString2)
  {
    paramString2 = (AbstractUploadTask)ImageUploadService.access$100(this.this$0).get(paramInt);
    if (paramString2 != null)
    {
      if ((paramString2 instanceof ImageUploadTask)) {
        ((ImageUploadTask)paramString2).compressEndTime = System.currentTimeMillis();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Image compress complete,  originPath: ");
      ((StringBuilder)localObject).append(paramString2.getFilePath());
      ((StringBuilder)localObject).append(" tmpPath: ");
      ((StringBuilder)localObject).append(paramString1);
      UploadLog.d("ImageUploadService", ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(paramString1))
      {
        UploadLog.d("ImageUploadService", "targetFilePath is empty !");
        paramString1 = paramString2.getFilePath();
      }
      else
      {
        localObject = new File(paramString1);
        if (!((File)localObject).exists())
        {
          UploadLog.d("ImageUploadService", "targetFilePath file invalid !");
          paramString1 = paramString2.getFilePath();
        }
        else if (((File)localObject).length() <= 0L)
        {
          UploadLog.d("ImageUploadService", "targetFilePath file size == 0 !");
          paramString1 = paramString2.getFilePath();
        }
      }
      paramString2.setTmpFilePath(paramString1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("taskId:");
      ((StringBuilder)localObject).append(paramString2.flowId);
      ((StringBuilder)localObject).append(", final upload targetFilePath:");
      ((StringBuilder)localObject).append(paramString1);
      UploadLog.d("ImageUploadService", ((StringBuilder)localObject).toString());
      if (paramString2.needWaitBatch())
      {
        ImageUploadService.access$100(this.this$0).remove(paramInt);
        ImageUploadService.access$200(this.this$0).add(paramString2);
        if ((ImageUploadService.access$200(this.this$0).size() >= BaseUploadService.getBatchControlNumber()) || (ImageUploadService.access$100(this.this$0).size() == 0)) {
          ImageUploadService.access$000(this.this$0);
        }
        return;
      }
      this.this$0.mTaskManager.sendAsync(paramString2);
      ImageUploadService.access$100(this.this$0).remove(paramInt);
    }
  }
  
  public void onPidObtained(int paramInt)
  {
    ImageUploadService.access$302(this.this$0, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageProcessProxy Service return Pid: ");
    localStringBuilder.append(paramInt);
    UploadLog.d("ImageUploadService", localStringBuilder.toString());
  }
  
  public void onServiceConnected()
  {
    UploadLog.d("ImageUploadService", "ImageProcessProxy Service Connectted!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.impl.ImageUploadService.2
 * JD-Core Version:    0.7.0.1
 */