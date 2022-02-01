package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.loader.FlutterLoader.Settings;

public class FlutterMain
{
  public static void ensureInitializationComplete(@NonNull Context paramContext, @Nullable String[] paramArrayOfString)
  {
    FlutterInjector.instance().flutterLoader().ensureInitializationComplete(paramContext, paramArrayOfString);
  }
  
  public static void ensureInitializationCompleteAsync(@NonNull Context paramContext, @Nullable String[] paramArrayOfString, @NonNull Handler paramHandler, @NonNull Runnable paramRunnable)
  {
    FlutterInjector.instance().flutterLoader().ensureInitializationCompleteAsync(paramContext, paramArrayOfString, paramHandler, paramRunnable);
  }
  
  @NonNull
  public static String findAppBundlePath()
  {
    return FlutterInjector.instance().flutterLoader().findAppBundlePath();
  }
  
  @Deprecated
  @Nullable
  public static String findAppBundlePath(@NonNull Context paramContext)
  {
    return FlutterInjector.instance().flutterLoader().findAppBundlePath();
  }
  
  @NonNull
  public static String getLookupKeyForAsset(@NonNull String paramString)
  {
    return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(paramString);
  }
  
  @NonNull
  public static String getLookupKeyForAsset(@NonNull String paramString1, @NonNull String paramString2)
  {
    return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public static void setNativeLibDir(String paramString)
  {
    FlutterLoader.setNativeLibDir(paramString);
  }
  
  public static void startInitialization(@NonNull Context paramContext)
  {
    FlutterInjector.instance().flutterLoader().startInitialization(paramContext);
  }
  
  public static void startInitialization(@NonNull Context paramContext, @NonNull FlutterMain.Settings paramSettings)
  {
    FlutterLoader.Settings localSettings = new FlutterLoader.Settings();
    localSettings.setLogTag(paramSettings.getLogTag());
    FlutterInjector.instance().flutterLoader().startInitialization(paramContext, localSettings);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */