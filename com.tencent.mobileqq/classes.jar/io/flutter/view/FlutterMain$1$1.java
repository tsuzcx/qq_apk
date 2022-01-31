package io.flutter.view;

import android.content.Context;
import android.os.Handler;

class FlutterMain$1$1
  implements Runnable
{
  FlutterMain$1$1(FlutterMain.1 param1) {}
  
  public void run()
  {
    FlutterMain.ensureInitializationComplete(this.this$0.val$applicationContext.getApplicationContext(), this.this$0.val$args);
    this.this$0.val$callbackHandler.post(this.this$0.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.view.FlutterMain.1.1
 * JD-Core Version:    0.7.0.1
 */