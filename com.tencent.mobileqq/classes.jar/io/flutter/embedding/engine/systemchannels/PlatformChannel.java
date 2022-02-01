package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlatformChannel
{
  private static final String TAG = "PlatformChannel";
  @NonNull
  public final MethodChannel channel;
  @NonNull
  @VisibleForTesting
  final MethodChannel.MethodCallHandler parsingMethodCallHandler = new PlatformChannel.1(this);
  @Nullable
  private PlatformChannel.PlatformMessageHandler platformMessageHandler;
  
  public PlatformChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingMethodCallHandler);
  }
  
  @NonNull
  private PlatformChannel.AppSwitcherDescription decodeAppSwitcherDescription(@NonNull JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("primaryColor");
    int i = j;
    if (j != 0) {
      i = j | 0xFF000000;
    }
    return new PlatformChannel.AppSwitcherDescription(i, paramJSONObject.getString("label"));
  }
  
  private int decodeOrientations(@NonNull JSONArray paramJSONArray)
  {
    int k = 0;
    int i = 0;
    int m;
    for (int j = 0; k < paramJSONArray.length(); j = m)
    {
      PlatformChannel.DeviceOrientation localDeviceOrientation = PlatformChannel.DeviceOrientation.fromValue(paramJSONArray.getString(k));
      m = PlatformChannel.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[localDeviceOrientation.ordinal()];
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m == 4) {
              i |= 0x8;
            }
          }
          else {
            i |= 0x2;
          }
        }
        else {
          i |= 0x4;
        }
      }
      else {
        i |= 0x1;
      }
      m = j;
      if (j == 0) {
        m = i;
      }
      k += 1;
    }
    k = 9;
    switch (i)
    {
    default: 
      return 1;
    case 15: 
      return 13;
    case 11: 
      return 2;
    case 10: 
      return 11;
    case 8: 
      return 8;
    case 5: 
      k = 12;
    case 4: 
      return k;
    case 3: 
    case 6: 
    case 7: 
    case 9: 
    case 12: 
    case 13: 
    case 14: 
      if (j != 4)
      {
        if (j != 8)
        {
          if (j != 1)
          {
            if (j != 2) {
              return 1;
            }
            return 0;
          }
          return 1;
        }
        return 8;
      }
      return 9;
    case 2: 
      return 0;
    case 1: 
      return 1;
    }
    return -1;
  }
  
  @NonNull
  private PlatformChannel.SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.isNull("systemNavigationBarIconBrightness");
    Integer localInteger3 = null;
    PlatformChannel.Brightness localBrightness1;
    if (!bool) {
      localBrightness1 = PlatformChannel.Brightness.fromValue(paramJSONObject.getString("systemNavigationBarIconBrightness"));
    } else {
      localBrightness1 = null;
    }
    Integer localInteger1;
    if (!paramJSONObject.isNull("systemNavigationBarColor")) {
      localInteger1 = Integer.valueOf(paramJSONObject.getInt("systemNavigationBarColor"));
    } else {
      localInteger1 = null;
    }
    PlatformChannel.Brightness localBrightness2;
    if (!paramJSONObject.isNull("statusBarIconBrightness")) {
      localBrightness2 = PlatformChannel.Brightness.fromValue(paramJSONObject.getString("statusBarIconBrightness"));
    } else {
      localBrightness2 = null;
    }
    Integer localInteger2;
    if (!paramJSONObject.isNull("statusBarColor")) {
      localInteger2 = Integer.valueOf(paramJSONObject.getInt("statusBarColor"));
    } else {
      localInteger2 = null;
    }
    if (!paramJSONObject.isNull("systemNavigationBarDividerColor")) {
      localInteger3 = Integer.valueOf(paramJSONObject.getInt("systemNavigationBarDividerColor"));
    }
    return new PlatformChannel.SystemChromeStyle(localInteger2, localBrightness2, localInteger1, localBrightness1, localInteger3);
  }
  
  @NonNull
  private List<PlatformChannel.SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      PlatformChannel.SystemUiOverlay localSystemUiOverlay = PlatformChannel.SystemUiOverlay.fromValue(paramJSONArray.getString(i));
      int j = PlatformChannel.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[localSystemUiOverlay.ordinal()];
      if (j != 1)
      {
        if (j != 2) {
          break label75;
        }
        localSystemUiOverlay = PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS;
      }
      else
      {
        localSystemUiOverlay = PlatformChannel.SystemUiOverlay.TOP_OVERLAYS;
      }
      localArrayList.add(localSystemUiOverlay);
      label75:
      i += 1;
    }
    return localArrayList;
  }
  
  public void setPlatformMessageHandler(@Nullable PlatformChannel.PlatformMessageHandler paramPlatformMessageHandler)
  {
    this.platformMessageHandler = paramPlatformMessageHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel
 * JD-Core Version:    0.7.0.1
 */