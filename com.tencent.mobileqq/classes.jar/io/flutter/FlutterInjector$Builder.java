package io.flutter;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.loader.FlutterLoader;
import java.io.PrintStream;

public final class FlutterInjector$Builder
{
  private FlutterLoader flutterLoader;
  private boolean shouldLoadNative = true;
  
  private void fillDefaults()
  {
    if (this.flutterLoader == null) {
      this.flutterLoader = new FlutterLoader();
    }
  }
  
  public FlutterInjector build()
  {
    fillDefaults();
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("should load native is ");
    localStringBuilder.append(this.shouldLoadNative);
    localPrintStream.println(localStringBuilder.toString());
    return new FlutterInjector(this.shouldLoadNative, this.flutterLoader, null);
  }
  
  public Builder setFlutterLoader(@NonNull FlutterLoader paramFlutterLoader)
  {
    this.flutterLoader = paramFlutterLoader;
    return this;
  }
  
  public Builder setShouldLoadNative(boolean paramBoolean)
  {
    this.shouldLoadNative = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.FlutterInjector.Builder
 * JD-Core Version:    0.7.0.1
 */