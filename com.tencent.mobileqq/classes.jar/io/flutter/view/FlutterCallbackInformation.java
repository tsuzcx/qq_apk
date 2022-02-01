package io.flutter.view;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterJNI;

@Keep
public final class FlutterCallbackInformation
{
  public final String callbackClassName;
  public final String callbackLibraryPath;
  public final String callbackName;
  
  private FlutterCallbackInformation(String paramString1, String paramString2, String paramString3)
  {
    this.callbackName = paramString1;
    this.callbackClassName = paramString2;
    this.callbackLibraryPath = paramString3;
  }
  
  @NonNull
  public static FlutterCallbackInformation lookupCallbackInformation(long paramLong)
  {
    return FlutterJNI.nativeLookupCallbackInformation(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.view.FlutterCallbackInformation
 * JD-Core Version:    0.7.0.1
 */