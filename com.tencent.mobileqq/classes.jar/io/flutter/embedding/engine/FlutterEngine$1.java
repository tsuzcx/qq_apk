package io.flutter.embedding.engine;

import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.Iterator;
import java.util.Set;

class FlutterEngine$1
  implements FlutterEngine.EngineLifecycleListener
{
  FlutterEngine$1(FlutterEngine paramFlutterEngine) {}
  
  public void onPreEngineRestart()
  {
    Log.v("FlutterEngine", "onPreEngineRestart()");
    Iterator localIterator = FlutterEngine.access$000(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((FlutterEngine.EngineLifecycleListener)localIterator.next()).onPreEngineRestart();
    }
    FlutterEngine.access$100(this.this$0).onPreEngineRestart();
    FlutterEngine.access$200(this.this$0).clearData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngine.1
 * JD-Core Version:    0.7.0.1
 */