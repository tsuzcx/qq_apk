package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPAssetResourceLoadingDataRequest$EventHandler
  extends Handler
{
  TPAssetResourceLoadingDataRequest$EventHandler(TPAssetResourceLoadingDataRequest paramTPAssetResourceLoadingDataRequest, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    Object localObject = (TPAssetResourceLoadingDataRequest.DataWriteParams)paramMessage.obj;
    long l = ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).writeOffset;
    localObject = ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).data;
    int i = paramMessage.arg1;
    if (!TPAssetResourceLoadingDataRequest.access$200(this.this$0, l, (byte[])localObject, TPAssetResourceLoadingDataRequest.access$100(this.this$0)))
    {
      TPLogUtil.e(TPAssetResourceLoadingDataRequest.access$300(), "write data failed");
      return;
    }
    TPAssetResourceLoadingDataRequest.access$402(this.this$0, i + l);
    TPLogUtil.i(TPAssetResourceLoadingDataRequest.access$300(), "write data from " + l + " , with dataLength" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoadingDataRequest.EventHandler
 * JD-Core Version:    0.7.0.1
 */