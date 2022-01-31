package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class QbSdk$1
  extends Thread
{
  QbSdk$1(Context paramContext, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(this.val$context, null);
    boolean bool = false;
    if (localX5CoreEngine.isX5Core()) {
      bool = localX5CoreEngine.wizard().canOpenFile(this.val$context, this.val$filePath);
    }
    new Handler(Looper.getMainLooper()).post(new QbSdk.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.1
 * JD-Core Version:    0.7.0.1
 */