package com.tencent.thumbplayer.datatransport.resourceloader;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (TPAssetResourceLoader.access$800(this.this$0) > 0L)
    {
      bool1 = bool2;
      if (paramLong2 + paramLong1 >= TPAssetResourceLoader.access$800(this.this$0)) {
        bool1 = true;
      }
    }
    if (bool1) {
      TPAssetResourceLoader.access$900(this.this$0);
    }
    return bool1;
  }
  
  private void handleRequestToLoad(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    TPAssetResourceLoadingRequest localTPAssetResourceLoadingRequest = new TPAssetResourceLoadingRequest(paramLong1, paramLong2, paramInt2, handleIsRequestToEnd(paramLong1, paramLong2));
    localTPAssetResourceLoadingRequest.setDataWriteThreadLooper(TPAssetResourceLoader.access$500(this.this$0).getLooper());
    localTPAssetResourceLoadingRequest.setDataWritePath(this.this$0.getDataFilePath(paramInt1, paramString));
    localTPAssetResourceLoadingRequest.setContentInformation(TPAssetResourceLoader.access$600(this.this$0));
    if (TPAssetResourceLoader.access$200(this.this$0).shouldWaitForLoadingOfRequestedResource(localTPAssetResourceLoadingRequest))
    {
      TPAssetResourceLoader.access$700(this.this$0, localTPAssetResourceLoadingRequest);
      TPLogUtil.i(TPAssetResourceLoader.access$100(), "add to mLoadingRequests, requestId: " + paramInt2);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    TPLogUtil.d(TPAssetResourceLoader.access$100(), "mCallbackForResourceLoaderHandler msg : " + paramMessage.what);
    if (TPAssetResourceLoader.access$200(this.this$0) == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 256: 
      TPLogUtil.i(TPAssetResourceLoader.access$100(), "start read data");
      Object localObject = (TPAssetResourceLoader.StartReadDataParams)paramMessage.obj;
      long l1 = ((TPAssetResourceLoader.StartReadDataParams)localObject).requestStart;
      long l2 = ((TPAssetResourceLoader.StartReadDataParams)localObject).requestEnd;
      localObject = ((TPAssetResourceLoader.StartReadDataParams)localObject).fileKey;
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      TPLogUtil.i(TPAssetResourceLoader.access$100(), "start read data, requestStart: " + l1 + " requestEnd:" + l2 + " requestId:" + j);
      l2 = TPAssetResourceLoader.access$300(this.this$0, l1, l2);
      if (l2 <= 0L)
      {
        TPLogUtil.e(TPAssetResourceLoader.access$100(), "requestLength invalid, check requestStart and requestEnd");
        return;
      }
      handleRequestToLoad(l1, l2, (String)localObject, i, j);
      return;
    }
    TPLogUtil.i(TPAssetResourceLoader.access$100(), "stop read data");
    TPAssetResourceLoader.access$400(this.this$0, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoader.EventHandler
 * JD-Core Version:    0.7.0.1
 */