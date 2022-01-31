package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
  private final MethodChannel.MethodCallHandler parsingMethodCallHandler = new PlatformChannel.1(this);
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
    int n = 0;
    int k = 0;
    int i = 0;
    int j = 0;
    if (j < paramJSONArray.length())
    {
      PlatformChannel.DeviceOrientation localDeviceOrientation = PlatformChannel.DeviceOrientation.fromValue(paramJSONArray.getString(j));
      switch (PlatformChannel.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[localDeviceOrientation.ordinal()])
      {
      }
      for (;;)
      {
        int m = k;
        if (k == 0) {
          m = i;
        }
        j += 1;
        k = m;
        break;
        i |= 0x8;
        continue;
        i |= 0x2;
        continue;
        i |= 0x4;
        continue;
        i |= 0x1;
      }
    }
    j = n;
    switch (i)
    {
    default: 
    case 2: 
    case 15: 
    case 11: 
    case 10: 
    case 8: 
    case 5: 
    case 4: 
    case 3: 
    case 6: 
    case 7: 
    case 9: 
    case 12: 
    case 13: 
    case 14: 
      for (;;)
      {
        j = 1;
        return j;
        return 13;
        return 2;
        return 11;
        return 8;
        return 12;
        return 9;
        if (k == 4) {
          break label272;
        }
        if (k == 8) {
          break;
        }
        j = n;
        switch (k)
        {
        }
      }
      return 1;
      return 8;
      return 9;
    case 1: 
      label272:
      return 1;
    }
    return -1;
  }
  
  @NonNull
  private PlatformChannel.SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject paramJSONObject)
  {
    PlatformChannel.Brightness localBrightness1;
    Integer localInteger1;
    label38:
    PlatformChannel.Brightness localBrightness2;
    label58:
    Integer localInteger2;
    if (!paramJSONObject.isNull("systemNavigationBarIconBrightness"))
    {
      localBrightness1 = PlatformChannel.Brightness.fromValue(paramJSONObject.getString("systemNavigationBarIconBrightness"));
      if (paramJSONObject.isNull("systemNavigationBarColor")) {
        break label117;
      }
      localInteger1 = Integer.valueOf(paramJSONObject.getInt("systemNavigationBarColor"));
      if (paramJSONObject.isNull("statusBarIconBrightness")) {
        break label122;
      }
      localBrightness2 = PlatformChannel.Brightness.fromValue(paramJSONObject.getString("statusBarIconBrightness"));
      if (paramJSONObject.isNull("statusBarColor")) {
        break label128;
      }
      localInteger2 = Integer.valueOf(paramJSONObject.getInt("statusBarColor"));
      label78:
      if (paramJSONObject.isNull("systemNavigationBarDividerColor")) {
        break label134;
      }
    }
    label128:
    label134:
    for (paramJSONObject = Integer.valueOf(paramJSONObject.getInt("systemNavigationBarDividerColor"));; paramJSONObject = null)
    {
      return new PlatformChannel.SystemChromeStyle(localInteger2, localBrightness2, localInteger1, localBrightness1, paramJSONObject);
      localBrightness1 = null;
      break;
      label117:
      localInteger1 = null;
      break label38;
      label122:
      localBrightness2 = null;
      break label58;
      localInteger2 = null;
      break label78;
    }
  }
  
  @NonNull
  private List<PlatformChannel.SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      PlatformChannel.SystemUiOverlay localSystemUiOverlay = PlatformChannel.SystemUiOverlay.fromValue(paramJSONArray.getString(i));
      switch (PlatformChannel.2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[localSystemUiOverlay.ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS);
        continue;
        localArrayList.add(PlatformChannel.SystemUiOverlay.TOP_OVERLAYS);
      }
    }
    return localArrayList;
  }
  
  public void setPlatformMessageHandler(@Nullable PlatformChannel.PlatformMessageHandler paramPlatformMessageHandler)
  {
    this.platformMessageHandler = paramPlatformMessageHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel
 * JD-Core Version:    0.7.0.1
 */