package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

class PlatformViewsChannel$1
  implements MethodChannel.MethodCallHandler
{
  PlatformViewsChannel$1(PlatformViewsChannel paramPlatformViewsChannel) {}
  
  private void clearFocus(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    int i = ((Integer)paramMethodCall.arguments()).intValue();
    try
    {
      PlatformViewsChannel.access$000(this.this$0).clearFocus(i);
      paramResult.success(null);
      return;
    }
    catch (IllegalStateException paramMethodCall)
    {
      paramResult.error("error", PlatformViewsChannel.access$100(paramMethodCall), null);
    }
  }
  
  private void create(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    double d2 = 0.0D;
    paramMethodCall = (Map)paramMethodCall.arguments();
    int i;
    double d1;
    label49:
    label54:
    int j;
    String str;
    int k;
    if ((paramMethodCall.containsKey("hybrid")) && (((Boolean)paramMethodCall.get("hybrid")).booleanValue()))
    {
      i = 1;
      if (i == 0) {
        break label175;
      }
      d1 = 0.0D;
      if (i == 0) {
        break label193;
      }
      j = ((Integer)paramMethodCall.get("id")).intValue();
      str = (String)paramMethodCall.get("viewType");
      k = ((Integer)paramMethodCall.get("direction")).intValue();
      if (!paramMethodCall.containsKey("params")) {
        break label212;
      }
    }
    label175:
    label193:
    label212:
    for (paramMethodCall = ByteBuffer.wrap((byte[])paramMethodCall.get("params"));; paramMethodCall = null)
    {
      paramMethodCall = new PlatformViewsChannel.PlatformViewCreationRequest(j, str, d1, d2, k, paramMethodCall);
      if (i == 0) {
        break label217;
      }
      try
      {
        PlatformViewsChannel.access$000(this.this$0).createAndroidViewForPlatformView(paramMethodCall);
        paramResult.success(null);
        return;
      }
      catch (IllegalStateException paramMethodCall)
      {
        paramResult.error("error", PlatformViewsChannel.access$100(paramMethodCall), null);
      }
      i = 0;
      break;
      d1 = ((Double)paramMethodCall.get("width")).doubleValue();
      break label49;
      d2 = ((Double)paramMethodCall.get("height")).doubleValue();
      break label54;
    }
    label217:
    paramResult.success(Long.valueOf(PlatformViewsChannel.access$000(this.this$0).createVirtualDisplayForPlatformView(paramMethodCall)));
    return;
  }
  
  private void dispose(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramMethodCall = (Map)paramMethodCall.arguments();
    int j = ((Integer)paramMethodCall.get("id")).intValue();
    if ((paramMethodCall.containsKey("hybrid")) && (((Boolean)paramMethodCall.get("hybrid")).booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      for (;;)
      {
        try
        {
          PlatformViewsChannel.access$000(this.this$0).disposeAndroidViewForPlatformView(j);
          paramResult.success(null);
          return;
        }
        catch (IllegalStateException paramMethodCall)
        {
          paramResult.error("error", PlatformViewsChannel.access$100(paramMethodCall), null);
          return;
        }
        PlatformViewsChannel.access$000(this.this$0).disposeVirtualDisplayForPlatformView(j);
      }
    }
  }
  
  private void resize(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramMethodCall = (Map)paramMethodCall.arguments();
    paramMethodCall = new PlatformViewsChannel.PlatformViewResizeRequest(((Integer)paramMethodCall.get("id")).intValue(), ((Double)paramMethodCall.get("width")).doubleValue(), ((Double)paramMethodCall.get("height")).doubleValue());
    try
    {
      PlatformViewsChannel.access$000(this.this$0).resizePlatformView(paramMethodCall, new PlatformViewsChannel.1.1(this, paramResult));
      return;
    }
    catch (IllegalStateException paramMethodCall)
    {
      paramResult.error("error", PlatformViewsChannel.access$100(paramMethodCall), null);
    }
  }
  
  private void setDirection(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramMethodCall = (Map)paramMethodCall.arguments();
    int i = ((Integer)paramMethodCall.get("id")).intValue();
    int j = ((Integer)paramMethodCall.get("direction")).intValue();
    try
    {
      PlatformViewsChannel.access$000(this.this$0).setDirection(i, j);
      paramResult.success(null);
      return;
    }
    catch (IllegalStateException paramMethodCall)
    {
      paramResult.error("error", PlatformViewsChannel.access$100(paramMethodCall), null);
    }
  }
  
  private void touch(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramMethodCall = (List)paramMethodCall.arguments();
    paramMethodCall = new PlatformViewsChannel.PlatformViewTouch(((Integer)paramMethodCall.get(0)).intValue(), (Number)paramMethodCall.get(1), (Number)paramMethodCall.get(2), ((Integer)paramMethodCall.get(3)).intValue(), ((Integer)paramMethodCall.get(4)).intValue(), paramMethodCall.get(5), paramMethodCall.get(6), ((Integer)paramMethodCall.get(7)).intValue(), ((Integer)paramMethodCall.get(8)).intValue(), (float)((Double)paramMethodCall.get(9)).doubleValue(), (float)((Double)paramMethodCall.get(10)).doubleValue(), ((Integer)paramMethodCall.get(11)).intValue(), ((Integer)paramMethodCall.get(12)).intValue(), ((Integer)paramMethodCall.get(13)).intValue(), ((Integer)paramMethodCall.get(14)).intValue(), ((Number)paramMethodCall.get(15)).longValue());
    try
    {
      PlatformViewsChannel.access$000(this.this$0).onTouch(paramMethodCall);
      try
      {
        paramResult.success(null);
        return;
      }
      catch (IllegalStateException paramMethodCall) {}
    }
    catch (IllegalStateException paramMethodCall)
    {
      label240:
      break label240;
    }
    paramResult.error("error", PlatformViewsChannel.access$100(paramMethodCall), null);
  }
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (PlatformViewsChannel.access$000(this.this$0) == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Received '");
    ((StringBuilder)localObject).append(paramMethodCall.method);
    ((StringBuilder)localObject).append("' message.");
    Log.v("PlatformViewsChannel", ((StringBuilder)localObject).toString());
    localObject = paramMethodCall.method;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        return;
        if (((String)localObject).equals("dispose"))
        {
          i = 1;
          continue;
          if (((String)localObject).equals("setDirection"))
          {
            i = 4;
            continue;
            if (((String)localObject).equals("touch"))
            {
              i = 3;
              continue;
              if (((String)localObject).equals("clearFocus"))
              {
                i = 5;
                continue;
                if (((String)localObject).equals("resize"))
                {
                  i = 2;
                  continue;
                  if (((String)localObject).equals("create")) {
                    i = 0;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    clearFocus(paramMethodCall, paramResult);
    return;
    setDirection(paramMethodCall, paramResult);
    return;
    touch(paramMethodCall, paramResult);
    return;
    resize(paramMethodCall, paramResult);
    return;
    dispose(paramMethodCall, paramResult);
    return;
    create(paramMethodCall, paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.1
 * JD-Core Version:    0.7.0.1
 */