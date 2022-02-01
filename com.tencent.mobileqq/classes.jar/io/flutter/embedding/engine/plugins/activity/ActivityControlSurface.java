package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

public abstract interface ActivityControlSurface
{
  public abstract void attachToActivity(@NonNull Activity paramActivity, @NonNull Lifecycle paramLifecycle);
  
  public abstract void detachFromActivity();
  
  public abstract void detachFromActivityForConfigChanges();
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent);
  
  public abstract void onNewIntent(@NonNull Intent paramIntent);
  
  public abstract boolean onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt);
  
  public abstract void onRestoreInstanceState(@Nullable Bundle paramBundle);
  
  public abstract void onSaveInstanceState(@NonNull Bundle paramBundle);
  
  public abstract void onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.activity.ActivityControlSurface
 * JD-Core Version:    0.7.0.1
 */