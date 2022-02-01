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
    if (this.val$callBackListener != null)
    {
      int i;
      if (bool) {
        i = 0;
      } else {
        i = -1;
      }
      postMainUI(this.val$callBackListener, i);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TBSOneCallback:onError:");
    localStringBuilder.append(paramInt);
    Log.e("ReaderEngine", localStringBuilder.toString());
    paramString = String.format("tbs:onError,code=%d, des=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.this$0.report(1000, paramString, null);
    paramString = this.val$callBackListener;
    if (paramString != null) {
      postMainUI(paramString, paramInt);
    }
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2) {}
  
  void postMainUI(ITbsReaderCallback paramITbsReaderCallback, int paramInt)
  {
    this.handler.post(new ReaderEngine.1.1(this, paramITbsReaderCallback, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine.1
 * JD-Core Version:    0.7.0.1
 */