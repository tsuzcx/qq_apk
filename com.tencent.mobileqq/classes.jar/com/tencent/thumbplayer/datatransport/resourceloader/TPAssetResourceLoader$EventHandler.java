package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPAssetResourceLoader$EventHandler
  extends Handler
{
  TPAssetResourceLoader$EventHandler(TPAssetResourceLoader paramTPAssetResourceLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private boolean handleIsRequestToEnd(long paramLong1, long paramLong2)
  {
    boolean bool;
    if ((TPAssetResourceLoader.access$800(this.this$0) > 0L) && (paramLong2 + paramLong1 >= TPAssetResourceLoader.access$800(this.this$0))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      TPAssetResourceLoader.access$900(this.this$0);
    }
    return bool;
  }
  
  private void handleRequestToLoad(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TPAssetResourceLoadingRequest(paramLong1, paramLong2, paramInt2, handleIsRequestToEnd(paramLong1, paramLong2));
    ((TPAssetResourceLoadingRequest)localObject).setDataWriteThreadLooper(TPAssetResourceLoader.access$500(this.this$0).getLooper());
    ((TPAssetResourceLoadingRequest)localObject).setDataWritePath(this.this$0.getDataFilePath(paramInt1, paramString));
    ((TPAssetResourceLoadingRequest)localObject).setContentInformation(TPAssetResourceLoader.access$600(this.this$0));
    if (TPAssetResourceLoader.access$200(this.this$0).shouldWaitForLoadingOfRequestedResource((ITPAssetResourceLoadingRequest)localObject))
    {
      TPAssetResourceLoader.access$700(this.this$0, (TPAssetResourceLoadingRequest)localObject);
      paramString = TPAssetResourceLoader.access$100();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add to mLoadingRequests, requestId: ");
      ((StringBuilder)localObject).append(paramInt2);
      TPLogUtil.i(paramString, ((StringBuilder)localObject).toString());
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = TPAssetResourceLoader.access$100();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCallbackForResourceLoaderHandler msg : ");
    localStringBuilder.append(paramMessage.what);
    TPLogUtil.d((String)localObject, localStringBuilder.toString());
    if (TPAssetResourceLoader.access$200(this.this$0) == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 256)
    {
      if (i != 257) {
        return;
      }
      TPLogUtil.i(TPAssetResourceLoader.access$100(), "stop read data");
      TPAssetResourceLoader.access$400(this.this$0, paramMessage.arg1);
      return;
    }
    TPLogUtil.i(TPAssetResourceLoader.access$100(), "start read data");
    localObject = (TPAssetResourceLoader.StartReadDataParams)paramMessage.obj;
    long l1 = ((TPAssetResourceLoader.StartReadDataParams)localObject).requestStart;
    long l2 = ((TPAssetResourceLoader.StartReadDataParams)localObject).requestEnd;
    localObject = ((TPAssetResourceLoader.StartReadDataParams)localObject).fileKey;
    i = paramMessage.arg1;
    int j = paramMessage.arg2;
    paramMessage = TPAssetResourceLoader.access$100();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("start read data, requestStart: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" requestEnd:");
    localStringBuilder.append(l2);
    localStringBuilder.append(" requestId:");
    localStringBuilder.append(j);
    TPLogUtil.i(paramMessage, localStringBuilder.toString());
    l2 = TPAssetResourceLoader.access$300(this.this$0, l1, l2);
    if (l2 <= 0L)
    {
      TPLogUtil.e(TPAssetResourceLoader.access$100(), "requestLength invalid, check requestStart and requestEnd");
      return;
    }
    handleRequestToLoad(l1, l2, (String)localObject, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoader.EventHandler
 * JD-Core Version:    0.7.0.1
 */