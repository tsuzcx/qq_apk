package io.flutter.app;

import android.content.Context;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

public abstract interface FlutterActivityDelegate$ViewFactory
{
  public abstract FlutterNativeView createFlutterNativeView();
  
  public abstract FlutterView createFlutterView(Context paramContext);
  
  public abstract boolean retainFlutterNativeView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.app.FlutterActivityDelegate.ViewFactory
 * JD-Core Version:    0.7.0.1
 */