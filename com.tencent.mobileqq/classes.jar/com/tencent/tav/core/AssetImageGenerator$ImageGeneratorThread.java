package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
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
    Object localObject1 = AssetImageGenerator.access$500(this.this$0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("generatorCover() called, times = ");
    ((StringBuilder)localObject2).append(this.requestedTimes);
    Logger.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.requestedTimes.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CMTime)((Iterator)localObject1).next();
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = localObject2;
      this.handler.sendMessage(localMessage);
    }
  }
  
  private void generatorCover(CMTime paramCMTime)
  {
    Bitmap localBitmap2;
    try
    {
      Bitmap localBitmap1 = this.this$0.copyCGImageAtTimeAndActualTime(paramCMTime, null);
    }
    catch (Exception localException)
    {
      Logger.e(AssetImageGenerator.access$500(this.this$0), "handleMessage: ", localException);
      localBitmap2 = null;
    }
    AssetImageGenerator.ImageGeneratorListener localImageGeneratorListener = this.generatorListener;
    if (localImageGeneratorListener != null)
    {
      AssetImageGenerator.AssetImageGeneratorResult localAssetImageGeneratorResult;
      if (localBitmap2 != null) {
        localAssetImageGeneratorResult = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded;
      } else {
        localAssetImageGeneratorResult = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorFailed;
      }
      localImageGeneratorListener.onCompletion(paramCMTime, localBitmap2, null, localAssetImageGeneratorResult);
      return;
    }
    Logger.e(AssetImageGenerator.access$500(this.this$0), "generatorCover: generatorListener is null!");
  }
  
  private void initHandler()
  {
    this.handler = new Handler(getLooper(), this);
  }
  
  private void release(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.handler.removeCallbacksAndMessages(null);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    this.handler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        this.handler.removeCallbacksAndMessages(null);
        AssetImageGenerator.access$400(this.this$0);
        quit();
      }
    }
    else {
      generatorCover((CMTime)paramMessage.obj);
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetImageGenerator.ImageGeneratorThread
 * JD-Core Version:    0.7.0.1
 */