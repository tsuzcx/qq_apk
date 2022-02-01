package io.flutter.view;

import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate;

public class VsyncWaiter
{
  private static VsyncWaiter instance;
  private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new VsyncWaiter.1(this);
  @NonNull
  private final WindowManager windowManager;
  
  private VsyncWaiter(@NonNull WindowManager paramWindowManager)
  {
    this.windowManager = paramWindowManager;
  }
  
  @NonNull
  public static VsyncWaiter getInstance(@NonNull WindowManager paramWindowManager)
  {
    if (instance == null) {
      instance = new VsyncWaiter(paramWindowManager);
    }
    return instance;
  }
  
  public void init()
  {
    FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    FlutterJNI.setRefreshRateFPS(this.windowManager.getDefaultDisplay().getRefreshRate());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.view.VsyncWaiter
 * JD-Core Version:    0.7.0.1
 */