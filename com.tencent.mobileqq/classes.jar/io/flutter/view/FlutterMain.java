package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.loader.FlutterLoader.Settings;

public class FlutterMain
{
  private static boolean isRunningInRobolectricTest;
  
  public static void ensureInitializationComplete(@NonNull Context paramContext, @Nullable String[] paramArrayOfString)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.getInstance().ensureInitializationComplete(paramContext, paramArrayOfString);
  }
  
  public static void ensureInitializationCompleteAsync(@NonNull Context paramContext, @Nullable String[] paramArrayOfString, @NonNull Handler paramHandler, @NonNull Runnable paramRunnable)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.getInstance().ensureInitializationCompleteAsync(paramContext, paramArrayOfString, paramHandler, paramRunnable);
  }
  
  @NonNull
  public static String findAppBundlePath()
  {
    return FlutterLoader.getInstance().findAppBundlePath();
  }
  
  @Deprecated
  @Nullable
  public static String findAppBundlePath(@NonNull Context paramContext)
  {
    return FlutterLoader.getInstance().findAppBundlePath();
  }
  
  @NonNull
  public static String getLookupKeyForAsset(@NonNull String paramString)
  {
    return FlutterLoader.getInstance().getLookupKeyForAsset(paramString);
  }
  
  @NonNull
  public static String getLookupKeyForAsset(@NonNull String paramString1, @NonNull String paramString2)
  {
    return FlutterLoader.getInstance().getLookupKeyForAsset(paramString1, paramString2);
  }
  
  @Deprecated
  @VisibleForTesting
  public static void setIsRunningInRobolectricTest(boolean paramBoolean)
  {
    isRunningInRobolectricTest = paramBoolean;
  }
  
  public static void setNativeLibDir(String paramString)
  {
    FlutterLoader.setNativeLibDir(paramString);
  }
  
  public static void startInitialization(@NonNull Context paramContext)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.getInstance().startInitialization(paramContext);
  }
  
  public static void startInitialization(@NonNull Context paramContext, @NonNull FlutterMain.Settings paramSettings)
  {
    if (isRunningInRobolectricTest) {
      return;
    }
    FlutterLoader.Settings localSettings = new FlutterLoader.Settings();
    localSettings.setLogTag(paramSettings.getLogTag());
    FlutterLoader.getInstance().startInitialization(paramContext, localSettings);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */