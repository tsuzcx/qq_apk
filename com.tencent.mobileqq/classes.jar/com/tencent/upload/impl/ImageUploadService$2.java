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
      UploadLog.d("ImageUploadService", "Image compress complete,  originPath: " + paramString2.getFilePath() + " tmpPath: " + paramString1);
      if (!TextUtils.isEmpty(paramString1)) {
        break label200;
      }
      UploadLog.d("ImageUploadService", "targetFilePath is empty !");
      paramString1 = paramString2.getFilePath();
    }
    for (;;)
    {
      paramString2.setTmpFilePath(paramString1);
      UploadLog.d("ImageUploadService", "taskId:" + paramString2.flowId + ", final upload targetFilePath:" + paramString1);
      if (!paramString2.needWaitBatch()) {
        break;
      }
      ImageUploadService.access$100(this.this$0).remove(paramInt);
      ImageUploadService.access$200(this.this$0).add(paramString2);
      if ((ImageUploadService.access$200(this.this$0).size() >= BaseUploadService.getBatchControlNumber()) || (ImageUploadService.access$100(this.this$0).size() == 0)) {
        ImageUploadService.access$000(this.this$0);
      }
      return;
      label200:
      File localFile = new File(paramString1);
      if (!localFile.exists())
      {
        UploadLog.d("ImageUploadService", "targetFilePath file invalid !");
        paramString1 = paramString2.getFilePath();
      }
      else if (localFile.length() <= 0L)
      {
        UploadLog.d("ImageUploadService", "targetFilePath file size == 0 !");
        paramString1 = paramString2.getFilePath();
      }
    }
    this.this$0.mTaskManager.sendAsync(paramString2);
    ImageUploadService.access$100(this.this$0).remove(paramInt);
  }
  
  public void onPidObtained(int paramInt)
  {
    ImageUploadService.access$302(this.this$0, paramInt);
    UploadLog.d("ImageUploadService", "ImageProcessProxy Service return Pid: " + paramInt);
  }
  
  public void onServiceConnected()
  {
    UploadLog.d("ImageUploadService", "ImageProcessProxy Service Connectted!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.impl.ImageUploadService.2
 * JD-Core Version:    0.7.0.1
 */