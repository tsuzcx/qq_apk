package com.tencent.upload.image;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;

class ImageProcessService$IncomingHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        super.handleMessage(paramMessage);
        return;
      }
      UploadLog.i("ImageProcessService", "receive MSG_OBTAIN_PID_REQUEST");
      try
      {
        localObject = Message.obtain(null, 102);
        ((Message)localObject).arg1 = Process.myPid();
        paramMessage.replyTo.send((Message)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send MSG_OBTAIN_PID_RESPONSE flowId=");
        ((StringBuilder)localObject).append(paramMessage.arg1);
        UploadLog.v("ImageProcessService", ((StringBuilder)localObject).toString());
        return;
      }
      catch (RemoteException paramMessage)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send MSG_OBTAIN_PID_RESPONSE:");
        ((StringBuilder)localObject).append(paramMessage);
        UploadLog.e("ImageProcessService", ((StringBuilder)localObject).toString());
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST request flowId=");
    ((StringBuilder)localObject).append(paramMessage.arg1);
    UploadLog.d("ImageProcessService", ((StringBuilder)localObject).toString());
    ImageProcessService.MILESTONE.reset();
    ImageProcessService.sMsg = null;
    Message localMessage = Message.obtain(null, 101);
    localMessage.arg1 = paramMessage.arg1;
    paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
    localObject = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
    if ((localObject instanceof ImageProcessData))
    {
      ImageProcessData localImageProcessData = (ImageProcessData)localObject;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("compressFile start. ");
      ((StringBuilder)localObject).append(localImageProcessData.toString());
      UploadLog.d("ImageProcessService", ((StringBuilder)localObject).toString());
      if (!FileUtils.isFileExist(localImageProcessData.targetFilePath))
      {
        UploadLog.d("ImageProcessService", "targetFilePath not exist begin compress");
        localObject = ImageProcessUtil.compressFile(localImageProcessData.originalFilePath, localImageProcessData.targetFilePath, localImageProcessData.targetWidth, localImageProcessData.targetHeight, localImageProcessData.targetQuality, localImageProcessData.autoRotate, localImageProcessData.compressToWebp);
      }
      else
      {
        UploadLog.d("ImageProcessService", "compressFile exist no need compress");
        localObject = localImageProcessData.targetFilePath;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("compressFile end. targetFile=");
      localStringBuilder.append((String)localObject);
      UploadLog.d("ImageProcessService", localStringBuilder.toString());
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists())) {
        localImageProcessData.originalFilePath = ((String)localObject);
      }
      if (TextUtils.isEmpty(ImageProcessService.sMsg))
      {
        localImageProcessData.msg = null;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("imageCompressCode=");
        ((StringBuilder)localObject).append(ImageProcessService.MILESTONE.getMilestoneValue());
        ((StringBuilder)localObject).append(" errorMsg=");
        ((StringBuilder)localObject).append(ImageProcessService.sMsg);
        localImageProcessData.msg = ((StringBuilder)localObject).toString();
      }
      localMessage.getData().putParcelable("KEY_MSG_COMPRESS", localImageProcessData);
    }
    try
    {
      paramMessage.replyTo.send(localMessage);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE flowId=");
      ((StringBuilder)localObject).append(paramMessage.arg1);
      UploadLog.v("ImageProcessService", ((StringBuilder)localObject).toString());
    }
    catch (RemoteException paramMessage)
    {
      UploadLog.e("ImageProcessService", "ImageProcessService", paramMessage);
    }
    try
    {
      Thread.sleep(300L);
      return;
    }
    catch (InterruptedException paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */