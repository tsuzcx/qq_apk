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
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 1: 
      UploadLog.d("ImageProcessService", "receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST request flowId=" + paramMessage.arg1);
      ImageProcessService.MILESTONE.reset();
      ImageProcessService.sMsg = null;
      Message localMessage = Message.obtain(null, 101);
      localMessage.arg1 = paramMessage.arg1;
      paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
      localObject = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
      ImageProcessData localImageProcessData;
      if ((localObject instanceof ImageProcessData))
      {
        localImageProcessData = (ImageProcessData)localObject;
        UploadLog.d("ImageProcessService", "compressFile start. " + localImageProcessData.toString());
        if (FileUtils.isFileExist(localImageProcessData.targetFilePath)) {
          break label327;
        }
        UploadLog.d("ImageProcessService", "targetFilePath not exist begin compress");
        localObject = ImageProcessUtil.compressFile(localImageProcessData.originalFilePath, localImageProcessData.targetFilePath, localImageProcessData.targetWidth, localImageProcessData.targetHeight, localImageProcessData.targetQuality, localImageProcessData.autoRotate, localImageProcessData.compressToWebp);
      }
      for (;;)
      {
        UploadLog.d("ImageProcessService", "compressFile end. targetFile=" + (String)localObject);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists())) {
          localImageProcessData.originalFilePath = ((String)localObject);
        }
        if (TextUtils.isEmpty(ImageProcessService.sMsg))
        {
          localImageProcessData.msg = null;
          localMessage.getData().putParcelable("KEY_MSG_COMPRESS", localImageProcessData);
        }
        try
        {
          paramMessage.replyTo.send(localMessage);
          UploadLog.v("ImageProcessService", "send MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE flowId=" + paramMessage.arg1);
          try
          {
            Thread.sleep(300L);
            return;
          }
          catch (InterruptedException paramMessage)
          {
            return;
          }
          label327:
          UploadLog.d("ImageProcessService", "compressFile exist no need compress");
          localObject = localImageProcessData.targetFilePath;
          continue;
          localImageProcessData.msg = ("imageCompressCode=" + ImageProcessService.MILESTONE.getMilestoneValue() + " errorMsg=" + ImageProcessService.sMsg);
        }
        catch (RemoteException paramMessage)
        {
          for (;;)
          {
            UploadLog.e("ImageProcessService", "ImageProcessService", paramMessage);
          }
        }
      }
    }
    UploadLog.i("ImageProcessService", "receive MSG_OBTAIN_PID_REQUEST");
    try
    {
      localObject = Message.obtain(null, 102);
      ((Message)localObject).arg1 = Process.myPid();
      paramMessage.replyTo.send((Message)localObject);
      UploadLog.v("ImageProcessService", "send MSG_OBTAIN_PID_RESPONSE flowId=" + paramMessage.arg1);
      return;
    }
    catch (RemoteException paramMessage)
    {
      UploadLog.e("ImageProcessService", "send MSG_OBTAIN_PID_RESPONSE:" + paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */