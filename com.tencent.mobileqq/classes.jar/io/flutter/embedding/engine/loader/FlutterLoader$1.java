package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

class FlutterLoader$1
  implements Runnable
{
  FlutterLoader$1(FlutterLoader paramFlutterLoader, Context paramContext, String[] paramArrayOfString, Handler paramHandler, Runnable paramRunnable) {}
  
  public void run()
  {
    if (FlutterLoader.access$000(this.this$0) != null) {
      FlutterLoader.access$000(this.this$0).waitForCompletion();
    }
    new Handler(Looper.getMainLooper()).post(new FlutterLoader.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader.1
 * JD-Core Version:    0.7.0.1
 */