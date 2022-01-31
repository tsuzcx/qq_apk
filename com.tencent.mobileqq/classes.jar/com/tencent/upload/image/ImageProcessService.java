package com.tencent.upload.image;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.b;

public class ImageProcessService
  extends Service
{
  public static final int BITMAP_TO_FILE_FAIL = 16777216;
  public static final int BITMAP_TO_FILE_SUCCESS = 8388608;
  public static final int CLOSE_EXCEPTION = 4194304;
  public static final int COMPRESS_EXCEPTION = 2097152;
  public static final int CREATE_BITMAP = 16384;
  public static final int CREATE_BITMAP2 = 65536;
  public static final int CREATE_BITMAP2_OOM = 131072;
  public static final int CREATE_BITMAP_OOM = 32768;
  public static final int DECODE_BITMAP_SIZE = 4;
  public static final int DECODE_BITMAP_SIZE_0 = 2;
  public static final int DECODE_FILE2 = 32;
  public static final int DECODE_FILE2_OOM = 64;
  public static final int DECODE_FILE_OOM = 16;
  public static final int DECODE_FILE_WITH_RETRY = 256;
  public static final int DECODE_FILE_WITH_RETRY_FAIL = 512;
  public static final int EMPTY_SAVE_PATH = 1048576;
  public static final int EXIF_NULL = 2048;
  public static final String KEY_MSG_COMPRESS = "KEY_MSG_COMPRESS";
  public static final int MSG_COPY_AND_COMPRESS_IMAGE_REQUEST = 1;
  public static final int MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE = 101;
  public static final int MSG_OBTAIN_PID_REQUEST = 2;
  public static final int MSG_OBTAIN_PID_RESPONSE = 102;
  public static final int MSG_PROCESS_TIMEOUT = 100;
  public static final int POST_ROTATE = 4096;
  public static final int START_COMPRESS_FILE = 1;
  public static final int START_DECODE_FILE_WITH_RETRY = 8;
  public static final int START_DECODE_FILE_WITH_RETRY2 = 128;
  public static final int START_ROTATE = 1024;
  public static final int START_TRANSFORM_BITMAP = 8192;
  public static final String TAG = "ImageProcessService";
  public static final int TRANSFORM_BITMAP_END = 262144;
  public static final int TRANSFORM_BITMAP_FAIL = 524288;
  static final Milestone a = new Milestone();
  static String b;
  Messenger c;
  a d;
  
  public IBinder onBind(Intent paramIntent)
  {
    b.b("ImageProcessService", "onBind");
    return this.c.getBinder();
  }
  
  public void onCreate()
  {
    this.d = new a();
    this.c = new Messenger(this.d);
  }
  
  public void onDestroy()
  {
    b.b("ImageProcessService", "onDestroy");
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    b.a("ImageProcessService", "onRebind");
    super.onRebind(paramIntent);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    b.b("ImageProcessService", "onUnbind");
    this.d.removeMessages(1);
    return super.onUnbind(paramIntent);
  }
  
  static class a
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
        b.b("ImageProcessService", "receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST request flowId=" + paramMessage.arg1);
        ImageProcessService.a.reset();
        ImageProcessService.b = null;
        Message localMessage = Message.obtain(null, 101);
        localMessage.arg1 = paramMessage.arg1;
        paramMessage.getData().setClassLoader(ImageProcessData.class.getClassLoader());
        localObject = paramMessage.getData().getParcelable("KEY_MSG_COMPRESS");
        ImageProcessData localImageProcessData;
        if ((localObject instanceof ImageProcessData))
        {
          localImageProcessData = (ImageProcessData)localObject;
          b.b("ImageProcessService", "compressFile start. " + localImageProcessData.toString());
          if (FileUtils.isFileExist(localImageProcessData.targetFilePath)) {
            break label306;
          }
          b.b("ImageProcessService", "targetFilePath not exist begin compress");
          localObject = ImageProcessUtil.compressFile(localImageProcessData.originalFilePath, localImageProcessData.targetFilePath, localImageProcessData.targetWidth, localImageProcessData.targetHeight, localImageProcessData.targetQuality, localImageProcessData.autoRotate, localImageProcessData.compressToWebp);
        }
        for (;;)
        {
          b.b("ImageProcessService", "compressFile end. targetFile=" + (String)localObject);
          localImageProcessData.originalFilePath = ((String)localObject);
          if (TextUtils.isEmpty(ImageProcessService.b))
          {
            localImageProcessData.msg = null;
            localMessage.getData().putParcelable("KEY_MSG_COMPRESS", localImageProcessData);
          }
          try
          {
            paramMessage.replyTo.send(localMessage);
            b.a("ImageProcessService", "send MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE flowId=" + paramMessage.arg1);
            try
            {
              Thread.sleep(300L);
              return;
            }
            catch (InterruptedException paramMessage)
            {
              return;
            }
            label306:
            b.b("ImageProcessService", "compressFile exist no need compress");
            localObject = localImageProcessData.targetFilePath;
            continue;
            localImageProcessData.msg = ("imageCompressCode=" + ImageProcessService.a.getMilestoneValue() + " errorMsg=" + ImageProcessService.b);
          }
          catch (RemoteException paramMessage)
          {
            for (;;)
            {
              b.c("ImageProcessService", "ImageProcessService", paramMessage);
            }
          }
        }
      }
      b.c("ImageProcessService", "receive MSG_OBTAIN_PID_REQUEST");
      try
      {
        localObject = Message.obtain(null, 102);
        ((Message)localObject).arg1 = Process.myPid();
        paramMessage.replyTo.send((Message)localObject);
        b.a("ImageProcessService", "send MSG_OBTAIN_PID_RESPONSE flowId=" + paramMessage.arg1);
        return;
      }
      catch (RemoteException paramMessage)
      {
        b.e("ImageProcessService", "send MSG_OBTAIN_PID_RESPONSE:" + paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessService
 * JD-Core Version:    0.7.0.1
 */