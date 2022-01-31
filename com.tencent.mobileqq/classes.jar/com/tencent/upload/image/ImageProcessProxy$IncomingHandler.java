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
    Object localObject1 = null;
    String str;
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 101: 
      UploadLog.v("ImageProcessProxy", "receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST response flowId=" + paramMessage.arg1);
      paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
      localObject2 = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
      if ((localObject2 instanceof ImageProcessData))
      {
        ImageProcessData localImageProcessData = (ImageProcessData)localObject2;
        str = localImageProcessData.originalFilePath;
        localObject2 = str;
        if (!TextUtils.isEmpty(localImageProcessData.msg))
        {
          UploadLog.d("ImageProcessProxy", localImageProcessData.msg);
          localObject1 = localImageProcessData.msg;
        }
      }
      break;
    }
    for (Object localObject2 = str;; localObject2 = null)
    {
      int i = paramMessage.arg1;
      if ((ImageCompressRecord)ImageProcessProxy.access$000(this.this$0).get(i) != null)
      {
        removeMessages(100);
        ImageProcessProxy.access$100(this.this$0, paramMessage.arg1);
        ImageProcessProxy.access$202(this.this$0, false);
        if (this.this$0.mProcessCallback != null) {
          this.this$0.mProcessCallback.onCompressFinish(i, (String)localObject2, (String)localObject1);
        }
        ImageProcessProxy.access$300(this.this$0);
        return;
      }
      UploadLog.v("ImageProcessProxy", "removed task flowId: " + i);
      return;
      UploadLog.v("ImageProcessProxy", "receive MSG_OBTAIN_PID_RESPONSE pid:" + paramMessage.arg1);
      if (this.this$0.mProcessCallback != null) {
        this.this$0.mProcessCallback.onPidObtained(paramMessage.arg1);
      }
      ImageProcessProxy.access$300(this.this$0);
      return;
      i = paramMessage.arg1;
      localObject1 = (ImageCompressRecord)ImageProcessProxy.access$000(this.this$0).get(i);
      if (localObject1 != null)
      {
        paramMessage = "MSG_PROCESS_TIMEOUT " + "timeout flowId:" + i + " path:" + ((ImageCompressRecord)localObject1).path;
        ImageProcessProxy.access$100(this.this$0, i);
        if (this.this$0.mProcessCallback == null) {
          break label462;
        }
        this.this$0.mProcessCallback.onCompressFinish(i, ((ImageCompressRecord)localObject1).path, "original path");
      }
      label462:
      for (;;)
      {
        UploadLog.v("ImageProcessProxy", paramMessage);
        ImageProcessProxy.access$202(this.this$0, false);
        ImageProcessProxy.access$300(this.this$0);
        return;
        paramMessage = "MSG_PROCESS_TIMEOUT " + "removed time out task flowId: " + i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessProxy.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */