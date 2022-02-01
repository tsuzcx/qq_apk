package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

class FlutterLoader$2$1
  implements Runnable
{
  FlutterLoader$2$1(FlutterLoader.2 param2) {}
  
  public void run()
  {
    this.this$1.this$0.ensureInitializationComplete(this.this$1.val$applicationContext.getApplicationContext(), this.this$1.val$args);
    this.this$1.val$callbackHandler.post(this.this$1.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader.2.1
 * JD-Core Version:    0.7.0.1
 */