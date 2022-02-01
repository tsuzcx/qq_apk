package com.tencent.tencent_richtext_library;

import androidx.annotation.NonNull;
import com.tencent.tencent_richtext_library.richtext.QcircleFlutterTextCellParser;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TencentRichtextLibraryPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "tencent_richtext_library").setMethodCallHandler(new TencentRichtextLibraryPlugin());
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding) {}
  
  public void onMethodCall(MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if ("parseTextBatch".equals(paramMethodCall.method))
    {
      Object localObject = (Map)paramMethodCall.argument("contentMap");
      if (localObject == null) {
        return;
      }
      paramMethodCall = new HashMap();
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramMethodCall.put(localEntry.getKey(), QcircleFlutterTextCellParser.a((CharSequence)localEntry.getValue()));
      }
      localObject = new HashMap();
      ((Map)localObject).put("textListNodes", paramMethodCall);
      paramResult.success(localObject);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencent_richtext_library.TencentRichtextLibraryPlugin
 * JD-Core Version:    0.7.0.1
 */