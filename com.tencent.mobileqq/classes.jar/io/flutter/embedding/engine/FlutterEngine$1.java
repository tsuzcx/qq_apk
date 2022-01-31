package io.flutter.embedding.engine;

import io.flutter.Log;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngine.1
 * JD-Core Version:    0.7.0.1
 */