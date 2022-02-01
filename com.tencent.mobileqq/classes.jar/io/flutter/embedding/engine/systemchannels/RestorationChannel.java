package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class RestorationChannel
{
  private static final String TAG = "RestorationChannel";
  private MethodChannel channel;
  private boolean engineHasProvidedData = false;
  private boolean frameworkHasRequestedData = false;
  private final MethodChannel.MethodCallHandler handler = new RestorationChannel.2(this);
  private MethodChannel.Result pendingFrameworkRestorationChannelRequest;
  private byte[] restorationData;
  public final boolean waitForRestorationData;
  
  public RestorationChannel(@NonNull DartExecutor paramDartExecutor, @NonNull boolean paramBoolean)
  {
    this(new MethodChannel(paramDartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), paramBoolean);
  }
  
  RestorationChannel(MethodChannel paramMethodChannel, @NonNull boolean paramBoolean)
  {
    this.channel = paramMethodChannel;
    this.waitForRestorationData = paramBoolean;
    paramMethodChannel.setMethodCallHandler(this.handler);
  }
  
  private Map<String, Object> packageData(byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("enabled", Boolean.valueOf(true));
    localHashMap.put("data", paramArrayOfByte);
    return localHashMap;
  }
  
  public void clearData()
  {
    this.restorationData = null;
  }
  
  public byte[] getRestorationData()
  {
    return this.restorationData;
  }
  
  public void setRestorationData(byte[] paramArrayOfByte)
  {
    this.engineHasProvidedData = true;
    MethodChannel.Result localResult = this.pendingFrameworkRestorationChannelRequest;
    if (localResult != null)
    {
      localResult.success(packageData(paramArrayOfByte));
      this.pendingFrameworkRestorationChannelRequest = null;
    }
    while (!this.frameworkHasRequestedData)
    {
      this.restorationData = paramArrayOfByte;
      return;
    }
    this.channel.invokeMethod("push", packageData(paramArrayOfByte), new RestorationChannel.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.RestorationChannel
 * JD-Core Version:    0.7.0.1
 */