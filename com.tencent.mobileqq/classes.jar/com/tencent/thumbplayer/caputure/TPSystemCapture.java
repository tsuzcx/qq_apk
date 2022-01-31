package com.tencent.thumbplayer.caputure;

import android.graphics.Bitmap;
import com.tencent.thumbplayer.adapter.player.ITPCapture;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

public class TPSystemCapture
  implements ITPCapture, TPSysPlayerImageCapture.CaptureMediaImageListener
{
  private Map<Integer, TPCaptureCallBack> mCallBackMap = new HashMap();
  private FileDescriptor mFileDescriptor;
  private String mUrl;
  
  public TPSystemCapture(FileDescriptor paramFileDescriptor)
  {
    this.mFileDescriptor = paramFileDescriptor;
  }
  
  public TPSystemCapture(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public void generateImageAsyncAtTime(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    int i = TPSysPlayerImageCapture.GetImageCaptureInstance().captureImageWithPosition(this.mUrl, this.mFileDescriptor, paramLong, paramTPImageGeneratorParams.width, paramTPImageGeneratorParams.height, this);
    this.mCallBackMap.put(Integer.valueOf(i), paramTPCaptureCallBack);
  }
  
  public void onCaptureFailed(int paramInt1, int paramInt2)
  {
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt1));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoFailed(paramInt2);
    }
  }
  
  public void onCaptureSucceed(int paramInt1, long paramLong1, int paramInt2, int paramInt3, Bitmap paramBitmap, long paramLong2)
  {
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Integer.valueOf(paramInt1));
    if (localTPCaptureCallBack != null) {
      localTPCaptureCallBack.onCaptureVideoSuccess(paramBitmap);
    }
  }
  
  public void release()
  {
    this.mCallBackMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPSystemCapture
 * JD-Core Version:    0.7.0.1
 */