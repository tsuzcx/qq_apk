package com.tencent.upload.image;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.upload.utils.UploadLog;

@SuppressLint({"HandlerLeak"})
class ImageProcessProxy$IncomingHandler
  extends Handler
{
  public ImageProcessProxy$IncomingHandler(ImageProcessProxy paramImageProcessProxy)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 102: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("receive MSG_OBTAIN_PID_RESPONSE pid:");
      ((StringBuilder)localObject1).append(paramMessage.arg1);
      UploadLog.v("ImageProcessProxy", ((StringBuilder)localObject1).toString());
      if (this.this$0.mProcessCallback != null) {
        this.this$0.mProcessCallback.onPidObtained(paramMessage.arg1);
      }
      ImageProcessProxy.access$300(this.this$0);
      return;
    case 101: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST response flowId=");
      ((StringBuilder)localObject1).append(paramMessage.arg1);
      UploadLog.v("ImageProcessProxy", ((StringBuilder)localObject1).toString());
      paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
      localObject1 = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
      boolean bool = localObject1 instanceof ImageProcessData;
      localObject2 = null;
      if (bool)
      {
        ImageProcessData localImageProcessData = (ImageProcessData)localObject1;
        String str = localImageProcessData.originalFilePath;
        localObject1 = str;
        if (!TextUtils.isEmpty(localImageProcessData.msg))
        {
          UploadLog.d("ImageProcessProxy", localImageProcessData.msg);
          localObject2 = localImageProcessData.msg;
          localObject1 = str;
        }
      }
      else
      {
        localObject1 = null;
      }
      i = paramMessage.arg1;
      if ((ImageCompressRecord)ImageProcessProxy.access$000(this.this$0).get(i) != null)
      {
        removeMessages(100);
        ImageProcessProxy.access$100(this.this$0, paramMessage.arg1);
        ImageProcessProxy.access$202(this.this$0, false);
        if (this.this$0.mProcessCallback != null) {
          this.this$0.mProcessCallback.onCompressFinish(i, (String)localObject1, (String)localObject2);
        }
        ImageProcessProxy.access$300(this.this$0);
        return;
      }
      paramMessage = new StringBuilder();
      paramMessage.append("removed task flowId: ");
      paramMessage.append(i);
      UploadLog.v("ImageProcessProxy", paramMessage.toString());
      return;
    }
    int i = paramMessage.arg1;
    Object localObject2 = (ImageCompressRecord)ImageProcessProxy.access$000(this.this$0).get(i);
    if (localObject2 != null)
    {
      paramMessage = new StringBuilder();
      paramMessage.append("MSG_PROCESS_TIMEOUT ");
      paramMessage.append("timeout flowId:");
      paramMessage.append(i);
      paramMessage.append(" path:");
      paramMessage.append(((ImageCompressRecord)localObject2).path);
      localObject1 = paramMessage.toString();
      ImageProcessProxy.access$100(this.this$0, i);
      paramMessage = (Message)localObject1;
      if (this.this$0.mProcessCallback != null)
      {
        this.this$0.mProcessCallback.onCompressFinish(i, ((ImageCompressRecord)localObject2).path, "original path");
        paramMessage = (Message)localObject1;
      }
    }
    else
    {
      paramMessage = new StringBuilder();
      paramMessage.append("MSG_PROCESS_TIMEOUT ");
      paramMessage.append("removed time out task flowId: ");
      paramMessage.append(i);
      paramMessage = paramMessage.toString();
    }
    UploadLog.v("ImageProcessProxy", paramMessage);
    ImageProcessProxy.access$202(this.this$0, false);
    ImageProcessProxy.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessProxy.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */