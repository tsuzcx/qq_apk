package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

class FlutterLoader$1$1
  implements Runnable
{
  FlutterLoader$1$1(FlutterLoader.1 param1) {}
  
  public void run()
  {
    this.this$1.this$0.ensureInitializationComplete(this.this$1.val$applicationContext.getApplicationContext(), this.this$1.val$args);
    this.this$1.val$callbackHandler.post(this.this$1.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader.1.1
 * JD-Core Version:    0.7.0.1
 */