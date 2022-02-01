package io.flutter.embedding.engine.loader;

import io.flutter.FlutterInjector;
import io.flutter.util.PathUtils;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FlutterLoader$1
  implements Callable<FlutterLoader.InitResult>
{
  public FlutterLoader.InitResult call()
  {
    ResourceExtractor localResourceExtractor = FlutterLoader.access$000(this.this$0, this.val$appContext);
    if (FlutterInjector.instance().shouldLoadNative()) {
      if (FlutterLoader.access$100() == null)
      {
        System.loadLibrary("flutter");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FlutterLoader.access$100());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("libflutter.so");
        System.load(localStringBuilder.toString());
      }
    }
    Executors.newSingleThreadExecutor().execute(new FlutterLoader.1.1(this));
    if (localResourceExtractor != null) {
      localResourceExtractor.waitForCompletion();
    }
    return new FlutterLoader.InitResult(PathUtils.getFilesDir(this.val$appContext), PathUtils.getCacheDirectory(this.val$appContext), PathUtils.getDataDirectory(this.val$appContext), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.FlutterLoader.1
 * JD-Core Version:    0.7.0.1
 */