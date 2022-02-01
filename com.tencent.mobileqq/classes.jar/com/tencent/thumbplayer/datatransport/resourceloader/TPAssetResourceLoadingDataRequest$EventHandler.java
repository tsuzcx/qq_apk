package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class TPAssetResourceLoadingDataRequest$EventHandler
  extends Handler
{
  TPAssetResourceLoadingDataRequest$EventHandler(TPAssetResourceLoadingDataRequest paramTPAssetResourceLoadingDataRequest, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 256) {
      return;
    }
    Object localObject = (TPAssetResourceLoadingDataRequest.DataWriteParams)paramMessage.obj;
    long l = ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).writeOffset;
    localObject = ((TPAssetResourceLoadingDataRequest.DataWriteParams)localObject).data;
    int i = paramMessage.arg1;
    paramMessage = this.this$0;
    if (!TPAssetResourceLoadingDataRequest.access$200(paramMessage, l, (byte[])localObject, TPAssetResourceLoadingDataRequest.access$100(paramMessage)))
    {
      TPLogUtil.e(TPAssetResourceLoadingDataRequest.access$300(), "write data failed");
      return;
    }
    TPAssetResourceLoadingDataRequest.access$400(this.this$0).writeLock().lock();
    TPAssetResourceLoadingDataRequest.access$502(this.this$0, i + l);
    TPAssetResourceLoadingDataRequest.access$400(this.this$0).writeLock().unlock();
    paramMessage = TPAssetResourceLoadingDataRequest.access$300();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("write data from ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" , with dataLength");
    ((StringBuilder)localObject).append(i);
    TPLogUtil.i(paramMessage, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoadingDataRequest.EventHandler
 * JD-Core Version:    0.7.0.1
 */