package com.tencent.thumbplayer.caputure;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.FileDescriptor;
import java.util.HashMap;

public class TPSysPlayerImageCapture
{
  private static final int EV_CAP_IMAGE = 1;
  private static final int EV_STOP_CAP_IMAGE = 2;
  private static final String TAG = "TPSysPlayerImageCapture";
  private static TPSysPlayerImageCapture gInstance = null;
  private int mBaseID = 0;
  private TPSysPlayerImageCapture.EventHandler mCapHandler = null;
  private HandlerThread mHandlerThread = null;
  private MediaMetadataRetriever mRetriever = null;
  
  private TPSysPlayerImageCapture()
  {
    try
    {
      this.mHandlerThread = new HandlerThread("TP-SysImgCap");
      this.mHandlerThread.start();
      this.mCapHandler = new TPSysPlayerImageCapture.EventHandler(this, this.mHandlerThread.getLooper());
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPSysPlayerImageCapture", localThrowable);
      this.mCapHandler = new TPSysPlayerImageCapture.EventHandler(this, Looper.getMainLooper());
    }
  }
  
  public static TPSysPlayerImageCapture GetImageCaptureInstance()
  {
    try
    {
      if (gInstance == null) {
        gInstance = new TPSysPlayerImageCapture();
      }
      TPSysPlayerImageCapture localTPSysPlayerImageCapture = gInstance;
      return localTPSysPlayerImageCapture;
    }
    finally {}
  }
  
  private void doRealCaptureImage(TPSysPlayerImageCapture.CaptureMsg paramCaptureMsg)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 14) {
          throw new Exception("os version not support");
        }
      }
      catch (Exception localException)
      {
        TPLogUtil.e("TPSysPlayerImageCapture", localException);
        TPLogUtil.e("TPSysPlayerImageCapture", "doRealCaptureImage, Exception: " + localException.toString());
        paramCaptureMsg.lis.onCaptureFailed(TPSysPlayerImageCapture.CaptureMsg.access$000(paramCaptureMsg), 1000001);
        return;
        long l1 = System.currentTimeMillis();
        if (this.mRetriever != null)
        {
          this.mRetriever.release();
          this.mRetriever = null;
        }
        this.mRetriever = new MediaMetadataRetriever();
        if (Build.VERSION.SDK_INT >= 14)
        {
          if (TPSysPlayerImageCapture.CaptureMsg.access$100(paramCaptureMsg) != null) {
            this.mRetriever.setDataSource(TPSysPlayerImageCapture.CaptureMsg.access$100(paramCaptureMsg));
          }
        }
        else
        {
          Bitmap localBitmap = this.mRetriever.getFrameAtTime(TPSysPlayerImageCapture.CaptureMsg.access$300(paramCaptureMsg) * 1000L, 2);
          long l2 = System.currentTimeMillis();
          if (localBitmap == null) {
            break label272;
          }
          paramCaptureMsg.lis.onCaptureSucceed(TPSysPlayerImageCapture.CaptureMsg.access$000(paramCaptureMsg), TPSysPlayerImageCapture.CaptureMsg.access$300(paramCaptureMsg), TPSysPlayerImageCapture.CaptureMsg.access$400(paramCaptureMsg), TPSysPlayerImageCapture.CaptureMsg.access$500(paramCaptureMsg), localBitmap, l2 - l1);
          return;
        }
        this.mRetriever.setDataSource(TPSysPlayerImageCapture.CaptureMsg.access$200(paramCaptureMsg), new HashMap());
        continue;
      }
      finally
      {
        if (this.mRetriever != null)
        {
          this.mRetriever.release();
          this.mRetriever = null;
        }
      }
      label272:
      paramCaptureMsg.lis.onCaptureFailed(TPSysPlayerImageCapture.CaptureMsg.access$000(paramCaptureMsg), 1000001);
    }
  }
  
  public int captureImageWithPosition(String paramString, FileDescriptor paramFileDescriptor, long paramLong, int paramInt1, int paramInt2, TPSysPlayerImageCapture.CaptureMediaImageListener paramCaptureMediaImageListener)
  {
    TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + paramLong + ", width: " + paramInt1 + ", height: " + paramInt2);
    this.mBaseID += 1;
    if ((!TextUtils.isEmpty(Build.MODEL)) && (Build.MODEL.equals("Lenovo+K900")))
    {
      TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
      return -1;
    }
    TPSysPlayerImageCapture.CaptureMsg localCaptureMsg = new TPSysPlayerImageCapture.CaptureMsg(this);
    TPSysPlayerImageCapture.CaptureMsg.access$002(localCaptureMsg, this.mBaseID);
    TPSysPlayerImageCapture.CaptureMsg.access$102(localCaptureMsg, paramFileDescriptor);
    TPSysPlayerImageCapture.CaptureMsg.access$202(localCaptureMsg, paramString);
    TPSysPlayerImageCapture.CaptureMsg.access$302(localCaptureMsg, paramLong);
    TPSysPlayerImageCapture.CaptureMsg.access$402(localCaptureMsg, paramInt1);
    TPSysPlayerImageCapture.CaptureMsg.access$502(localCaptureMsg, paramInt2);
    localCaptureMsg.lis = paramCaptureMediaImageListener;
    paramString = new Message();
    paramString.what = 1;
    paramString.obj = localCaptureMsg;
    if (!this.mCapHandler.sendMessage(paramString)) {
      TPLogUtil.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
    }
    return this.mBaseID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPSysPlayerImageCapture
 * JD-Core Version:    0.7.0.1
 */