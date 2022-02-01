package com.tencent.tbs.reader;

import android.util.Log;
import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

class ReaderEngine$2
  extends TBSOneCallback<File>
{
  ReaderEngine$2(ReaderEngine paramReaderEngine, TBSOneCallback paramTBSOneCallback) {}
  
  public void onCompleted(File paramFile)
  {
    Log.d("ReaderEngine", "TBSOneCallback:onCompleted");
    this.this$0.report(1003, "tbs:onCompleted", null);
    TBSOneCallback localTBSOneCallback = this.val$callback;
    if (localTBSOneCallback != null) {
      localTBSOneCallback.onCompleted(paramFile);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TBSOneCallback:onError:");
    ((StringBuilder)localObject).append(paramInt);
    Log.e("ReaderEngine", ((StringBuilder)localObject).toString());
    localObject = String.format("tbs:onError,code=%d, des=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.this$0.report(1004, (String)localObject, null);
    localObject = this.val$callback;
    if (localObject != null) {
      ((TBSOneCallback)localObject).onError(paramInt, paramString);
    }
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    TBSOneCallback localTBSOneCallback = this.val$callback;
    if (localTBSOneCallback != null) {
      localTBSOneCallback.onProgressChanged(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine.2
 * JD-Core Version:    0.7.0.1
 */