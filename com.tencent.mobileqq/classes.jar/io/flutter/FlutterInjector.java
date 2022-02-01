package io.flutter;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.loader.FlutterLoader;

public final class FlutterInjector
{
  private static boolean accessed;
  private static FlutterInjector instance;
  private FlutterLoader flutterLoader;
  private boolean shouldLoadNative;
  
  private FlutterInjector(boolean paramBoolean, @NonNull FlutterLoader paramFlutterLoader)
  {
    this.shouldLoadNative = paramBoolean;
    this.flutterLoader = paramFlutterLoader;
  }
  
  public static FlutterInjector instance()
  {
    accessed = true;
    if (instance == null) {
      instance = new FlutterInjector.Builder().build();
    }
    return instance;
  }
  
  @VisibleForTesting
  public static void reset()
  {
    accessed = false;
    instance = null;
  }
  
  @VisibleForTesting
  public static void setInstance(@NonNull FlutterInjector paramFlutterInjector)
  {
    if (!accessed)
    {
      instance = paramFlutterInjector;
      return;
    }
    throw new IllegalStateException("Cannot change the FlutterInjector instance once it's been read. If you're trying to dependency inject, be sure to do so at the beginning of the program");
  }
  
  @NonNull
  public FlutterLoader flutterLoader()
  {
    return this.flutterLoader;
  }
  
  public boolean shouldLoadNative()
  {
    return this.shouldLoadNative;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.FlutterInjector
 * JD-Core Version:    0.7.0.1
 */