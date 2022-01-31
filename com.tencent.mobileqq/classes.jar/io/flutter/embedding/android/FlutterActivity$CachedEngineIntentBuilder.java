package io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

public class FlutterActivity$CachedEngineIntentBuilder
{
  private final Class<? extends FlutterActivity> activityClass;
  private String backgroundMode = FlutterActivity.DEFAULT_BACKGROUND_MODE;
  private final String cachedEngineId;
  private boolean destroyEngineWithActivity = false;
  
  protected FlutterActivity$CachedEngineIntentBuilder(@NonNull Class<? extends FlutterActivity> paramClass, @NonNull String paramString)
  {
    this.activityClass = paramClass;
    this.cachedEngineId = paramString;
  }
  
  @NonNull
  public CachedEngineIntentBuilder backgroundMode(@NonNull FlutterActivity.BackgroundMode paramBackgroundMode)
  {
    this.backgroundMode = paramBackgroundMode.name();
    return this;
  }
  
  @NonNull
  public Intent build(@NonNull Context paramContext)
  {
    return new Intent(paramContext, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra("background_mode", this.backgroundMode);
  }
  
  public CachedEngineIntentBuilder destroyEngineWithActivity(boolean paramBoolean)
  {
    this.destroyEngineWithActivity = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity.CachedEngineIntentBuilder
 * JD-Core Version:    0.7.0.1
 */