package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public class FlutterActivity$NewEngineIntentBuilder
{
  private final Class<? extends FlutterActivity> activityClass;
  private String backgroundMode = FlutterActivityLaunchConfigs.DEFAULT_BACKGROUND_MODE;
  private String initialRoute = "/";
  
  protected FlutterActivity$NewEngineIntentBuilder(@NonNull Class<? extends FlutterActivity> paramClass)
  {
    this.activityClass = paramClass;
  }
  
  @NonNull
  public NewEngineIntentBuilder backgroundMode(@NonNull FlutterActivityLaunchConfigs.BackgroundMode paramBackgroundMode)
  {
    this.backgroundMode = paramBackgroundMode.name();
    return this;
  }
  
  @NonNull
  public Intent build(@NonNull Context paramContext)
  {
    return new Intent(paramContext, this.activityClass).putExtra("initial_route", this.initialRoute).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", true);
  }
  
  @NonNull
  public NewEngineIntentBuilder initialRoute(@NonNull String paramString)
  {
    this.initialRoute = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity.NewEngineIntentBuilder
 * JD-Core Version:    0.7.0.1
 */