package io.flutter.embedding.engine.dart;

import android.support.annotation.NonNull;
import io.flutter.view.FlutterMain;

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
    return new DartEntrypoint(FlutterMain.findAppBundlePath(), "main");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (DartEntrypoint)paramObject;
      bool1 = bool2;
    } while (!this.pathToBundle.equals(paramObject.pathToBundle));
    return this.dartEntrypointFunctionName.equals(paramObject.dartEntrypointFunctionName);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint
 * JD-Core Version:    0.7.0.1
 */