package com.tencent.weseevideo.composition.image;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public class AssetImageGenerator$ImageGeneratorThread
  extends HandlerThread
  implements Handler.Callback
{
  private Handler handler;
  
  public AssetImageGenerator$ImageGeneratorThread(String paramString)
  {
    super(paramString);
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void initHandler()
  {
    this.handler = new Handler(getLooper(), this);
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread
 * JD-Core Version:    0.7.0.1
 */