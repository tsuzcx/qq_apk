package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import io.flutter.view.FlutterCallbackInformation;

public class DartExecutor$DartCallback
{
  public final AssetManager androidAssetManager;
  public final FlutterCallbackInformation callbackHandle;
  public final String pathToBundle;
  
  public DartExecutor$DartCallback(@NonNull AssetManager paramAssetManager, @NonNull String paramString, @NonNull FlutterCallbackInformation paramFlutterCallbackInformation)
  {
    this.androidAssetManager = paramAssetManager;
    this.pathToBundle = paramString;
    this.callbackHandle = paramFlutterCallbackInformation;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DartCallback( bundle path: ");
    localStringBuilder.append(this.pathToBundle);
    localStringBuilder.append(", library path: ");
    localStringBuilder.append(this.callbackHandle.callbackLibraryPath);
    localStringBuilder.append(", function: ");
    localStringBuilder.append(this.callbackHandle.callbackName);
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor.DartCallback
 * JD-Core Version:    0.7.0.1
 */