package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Future;

class FlutterLoader$2
  implements Runnable
{
  FlutterLoader$2(FlutterLoader paramFlutterLoader, Context paramContext, String[] paramArrayOfString, Handler paramHandler, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      FlutterLoader.InitResult localInitResult = (FlutterLoader.InitResult)this.this$0.initResultFuture.get();
      new Handler(Looper.getMainLooper()).post(new FlutterLoader.2.1(this));
      return;
    }
    catch (Exception localException)
    {
      Log.e("FlutterLoader", "Flutter initialization failed.", localException);
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader.2
 * JD-Core Version:    0.7.0.1
 */