package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;

public abstract interface PlatformView
{
  public abstract void dispose();
  
  public abstract View getView();
  
  @SuppressLint({"NewApi"})
  public abstract void onFlutterViewAttached(@NonNull View paramView);
  
  @SuppressLint({"NewApi"})
  public abstract void onFlutterViewDetached();
  
  @SuppressLint({"NewApi"})
  public abstract void onInputConnectionLocked();
  
  @SuppressLint({"NewApi"})
  public abstract void onInputConnectionUnlocked();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformView
 * JD-Core Version:    0.7.0.1
 */