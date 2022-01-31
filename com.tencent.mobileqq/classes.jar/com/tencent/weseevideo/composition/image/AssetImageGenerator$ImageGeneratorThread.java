package com.tencent.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.tav.coremedia.CMTime;
import java.util.Iterator;
import java.util.List;

class AssetImageGenerator$ImageGeneratorThread
  extends HandlerThread
  implements Handler.Callback
{
  private static final int MSG_CREATE_RENDERCONTEXT = 3;
  private static final int MSG_GENERATOR_COVER = 1;
  private static final int MSG_RELEASE = 2;
  private AssetImageGenerator.ImageGeneratorListener generatorListener;
  private Handler handler;
  private List<CMTime> requestedTimes;
  
  public AssetImageGenerator$ImageGeneratorThread(AssetImageGenerator paramAssetImageGenerator, String paramString)
  {
    super(paramString);
  }
  
  private void generatorCover()
  {
    Iterator localIterator = this.requestedTimes.iterator();
    while (localIterator.hasNext())
    {
      CMTime localCMTime = (CMTime)localIterator.next();
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = localCMTime;
      this.handler.sendMessage(localMessage);
    }
  }
  
  private void initHandler()
  {
    this.handler = new Handler(getLooper(), this);
  }
  
  private void release()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    this.handler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      try
      {
        Bitmap localBitmap = this.this$0.copyCGImageAtTimeAndActualTime((CMTime)paramMessage.obj, null);
        if (this.generatorListener == null) {
          continue;
        }
        AssetImageGenerator.ImageGeneratorListener localImageGeneratorListener = this.generatorListener;
        CMTime localCMTime = (CMTime)paramMessage.obj;
        if (localBitmap != null)
        {
          paramMessage = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded;
          localImageGeneratorListener.onCompletion(localCMTime, localBitmap, null, paramMessage);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject = null;
          continue;
          paramMessage = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorFailed;
        }
      }
      this.handler.removeCallbacksAndMessages(null);
      AssetImageGenerator.access$400(this.this$0);
      quit();
    }
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
  }
  
  public void setGeneratorListener(AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    this.generatorListener = paramImageGeneratorListener;
  }
  
  public void setRequestedTimes(List<CMTime> paramList)
  {
    this.requestedTimes = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread
 * JD-Core Version:    0.7.0.1
 */