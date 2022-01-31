package com.tencent.upload.image;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.tencent.upload.utils.UploadLog;

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
  static final Milestone MILESTONE = new Milestone();
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
  static String sMsg;
  ImageProcessService.IncomingHandler mIncomingHandler;
  Messenger mMessenger;
  
  public IBinder onBind(Intent paramIntent)
  {
    UploadLog.d("ImageProcessService", "onBind");
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    this.mIncomingHandler = new ImageProcessService.IncomingHandler();
    this.mMessenger = new Messenger(this.mIncomingHandler);
  }
  
  public void onDestroy()
  {
    UploadLog.d("ImageProcessService", "onDestroy");
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    UploadLog.v("ImageProcessService", "onRebind");
    super.onRebind(paramIntent);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    UploadLog.d("ImageProcessService", "onUnbind");
    this.mIncomingHandler.removeMessages(1);
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.image.ImageProcessService
 * JD-Core Version:    0.7.0.1
 */