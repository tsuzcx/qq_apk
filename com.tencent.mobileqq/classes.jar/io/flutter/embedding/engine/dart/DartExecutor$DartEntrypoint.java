package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;

public class DartExecutor$DartEntrypoint
{
  @NonNull
  public final String dartEntrypointFunctionName;
  @NonNull
  public final String pathToBundle;
  
  public DartExecutor$DartEntrypoint(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.pathToBundle = paramString1;
    this.dartEntrypointFunctionName = paramString2;
  }
  
  @NonNull
  public static DartEntrypoint createDefault()
  {
    FlutterLoader localFlutterLoader = FlutterInjector.instance().flutterLoader();
    if (localFlutterLoader.initialized()) {
      return new DartEntrypoint(localFlutterLoader.findAppBundlePath(), "main");
    }
    throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DartEntrypoint)paramObject;
      if (!this.pathToBundle.equals(paramObject.pathToBundle)) {
        return false;
      }
      return this.dartEntrypointFunctionName.equals(paramObject.dartEntrypointFunctionName);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.pathToBundle.hashCode() * 31 + this.dartEntrypointFunctionName.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DartEntrypoint( bundle path: ");
    localStringBuilder.append(this.pathToBundle);
    localStringBuilder.append(", function: ");
    localStringBuilder.append(this.dartEntrypointFunctionName);
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint
 * JD-Core Version:    0.7.0.1
 */