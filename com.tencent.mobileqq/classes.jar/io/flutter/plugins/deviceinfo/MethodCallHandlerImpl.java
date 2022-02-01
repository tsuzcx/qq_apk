package io.flutter.plugins.deviceinfo;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MethodCallHandlerImpl
  implements MethodChannel.MethodCallHandler
{
  private static final String[] EMPTY_STRING_LIST = new String[0];
  private final ContentResolver contentResolver;
  private final PackageManager packageManager;
  
  MethodCallHandlerImpl(ContentResolver paramContentResolver, PackageManager paramPackageManager)
  {
    this.contentResolver = paramContentResolver;
    this.packageManager = paramPackageManager;
  }
  
  @SuppressLint({"HardwareIds"})
  private String getAndroidId()
  {
    return Settings.Secure.getString(this.contentResolver, "android_id");
  }
  
  private String[] getSystemFeatures()
  {
    FeatureInfo[] arrayOfFeatureInfo = this.packageManager.getSystemAvailableFeatures();
    if (arrayOfFeatureInfo == null) {
      return EMPTY_STRING_LIST;
    }
    String[] arrayOfString = new String[arrayOfFeatureInfo.length];
    int i = 0;
    while (i < arrayOfFeatureInfo.length)
    {
      arrayOfString[i] = arrayOfFeatureInfo[i].name;
      i += 1;
    }
    return arrayOfString;
  }
  
  private boolean isEmulator()
  {
    return ((Build.BRAND.startsWith("generic")) && (Build.DEVICE.startsWith("generic"))) || (Build.FINGERPRINT.startsWith("generic")) || (Build.FINGERPRINT.startsWith("unknown")) || (Build.HARDWARE.contains("goldfish")) || (Build.HARDWARE.contains("ranchu")) || (Build.MODEL.contains("google_sdk")) || (Build.MODEL.contains("Emulator")) || (Build.MODEL.contains("Android SDK built for x86")) || (Build.MANUFACTURER.contains("Genymotion")) || (Build.PRODUCT.contains("sdk_google")) || (Build.PRODUCT.contains("google_sdk")) || (Build.PRODUCT.contains("sdk")) || (Build.PRODUCT.contains("sdk_x86")) || (Build.PRODUCT.contains("vbox86p")) || (Build.PRODUCT.contains("emulator")) || (Build.PRODUCT.contains("simulator"));
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    if (paramMethodCall.method.equals("getAndroidDeviceInfo"))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("board", Build.BOARD);
      localHashMap.put("bootloader", Build.BOOTLOADER);
      localHashMap.put("brand", Build.BRAND);
      localHashMap.put("device", Build.DEVICE);
      localHashMap.put("display", Build.DISPLAY);
      localHashMap.put("fingerprint", Build.FINGERPRINT);
      localHashMap.put("hardware", Build.HARDWARE);
      localHashMap.put("host", Build.HOST);
      localHashMap.put("id", Build.ID);
      localHashMap.put("manufacturer", Build.MANUFACTURER);
      localHashMap.put("model", Build.MODEL);
      localHashMap.put("product", Build.PRODUCT);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localHashMap.put("supported32BitAbis", Arrays.asList(Build.SUPPORTED_32_BIT_ABIS));
        localHashMap.put("supported64BitAbis", Arrays.asList(Build.SUPPORTED_64_BIT_ABIS));
        paramMethodCall = Arrays.asList(Build.SUPPORTED_ABIS);
      }
      else
      {
        localHashMap.put("supported32BitAbis", Arrays.asList(EMPTY_STRING_LIST));
        localHashMap.put("supported64BitAbis", Arrays.asList(EMPTY_STRING_LIST));
        paramMethodCall = Arrays.asList(EMPTY_STRING_LIST);
      }
      localHashMap.put("supportedAbis", paramMethodCall);
      localHashMap.put("tags", Build.TAGS);
      localHashMap.put("type", Build.TYPE);
      localHashMap.put("isPhysicalDevice", Boolean.valueOf(isEmulator() ^ true));
      localHashMap.put("androidId", getAndroidId());
      localHashMap.put("systemFeatures", Arrays.asList(getSystemFeatures()));
      paramMethodCall = new HashMap();
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramMethodCall.put("baseOS", Build.VERSION.BASE_OS);
        paramMethodCall.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
        paramMethodCall.put("securityPatch", Build.VERSION.SECURITY_PATCH);
      }
      paramMethodCall.put("codename", Build.VERSION.CODENAME);
      paramMethodCall.put("incremental", Build.VERSION.INCREMENTAL);
      paramMethodCall.put("release", Build.VERSION.RELEASE);
      paramMethodCall.put("sdkInt", Integer.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("version", paramMethodCall);
      paramResult.success(localHashMap);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugins.deviceinfo.MethodCallHandlerImpl
 * JD-Core Version:    0.7.0.1
 */