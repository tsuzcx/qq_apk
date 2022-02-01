package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.CallSuper;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;

public class FlutterApplication
  extends Application
{
  private Activity mCurrentActivity = null;
  
  public Activity getCurrentActivity()
  {
    return this.mCurrentActivity;
  }
  
  @CallSuper
  public void onCreate()
  {
    super.onCreate();
    FlutterInjector.instance().flutterLoader().startInitialization(this);
  }
  
  public void setCurrentActivity(Activity paramActivity)
  {
    this.mCurrentActivity = paramActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.app.FlutterApplication
 * JD-Core Version:    0.7.0.1
 */