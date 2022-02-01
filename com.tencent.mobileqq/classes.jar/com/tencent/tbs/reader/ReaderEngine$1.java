package com.tencent.tbs.reader;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneManager;

class ReaderEngine$1
  extends TBSOneCallback<TBSOneComponent>
{
  Handler handler = new Handler(this.val$context.getMainLooper());
  
  ReaderEngine$1(ReaderEngine paramReaderEngine, Context paramContext, TBSOneManager paramTBSOneManager, ITbsReaderCallback paramITbsReaderCallback) {}
  
  public void onCompleted(TBSOneComponent paramTBSOneComponent)
  {
    Log.d("ReaderEngine", "TBSOneCallback:onCompleted");
    boolean bool = ReaderEngine.access$000(this.this$0, this.val$manager, paramTBSOneComponent);
    if (this.val$callBackListener != null) {
      if (!bool) {
        break label44;
      }
    }
    label44:
    for (int i = 0;; i = -1)
    {
      postMainUI(this.val$callBackListener, i);
      return;
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    Log.e("ReaderEngine", "TBSOneCallback:onError:" + paramInt);
    paramString = String.format("tbs:onError,code=%d, des=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.this$0.report(1000, paramString, null);
    if (this.val$callBackListener != null) {
      postMainUI(this.val$callBackListener, paramInt);
    }
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2) {}
  
  void postMainUI(ITbsReaderCallback paramITbsReaderCallback, int paramInt)
  {
    this.handler.post(new ReaderEngine.1.1(this, paramITbsReaderCallback, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine.1
 * JD-Core Version:    0.7.0.1
 */