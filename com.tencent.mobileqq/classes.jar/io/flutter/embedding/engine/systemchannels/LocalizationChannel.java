package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class LocalizationChannel
{
  private static final String TAG = "LocalizationChannel";
  @NonNull
  public final MethodChannel channel;
  
  public LocalizationChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
  }
  
  public void sendLocales(@NonNull List<Locale> paramList)
  {
    Log.v("LocalizationChannel", "Sending Locales to Flutter.");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Locale localLocale = (Locale)localIterator.next();
      paramList = new StringBuilder();
      paramList.append("Locale (Language: ");
      paramList.append(localLocale.getLanguage());
      paramList.append(", Country: ");
      paramList.append(localLocale.getCountry());
      paramList.append(", Variant: ");
      paramList.append(localLocale.getVariant());
      paramList.append(")");
      Log.v("LocalizationChannel", paramList.toString());
      localArrayList.add(localLocale.getLanguage());
      localArrayList.add(localLocale.getCountry());
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramList = localLocale.getScript();; paramList = "")
      {
        localArrayList.add(paramList);
        localArrayList.add(localLocale.getVariant());
        break;
      }
    }
    this.channel.invokeMethod("setLocale", localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.LocalizationChannel
 * JD-Core Version:    0.7.0.1
 */