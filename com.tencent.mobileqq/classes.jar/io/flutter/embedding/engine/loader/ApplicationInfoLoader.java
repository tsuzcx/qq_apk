package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import androidx.annotation.NonNull;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

final class ApplicationInfoLoader
{
  static final String NETWORK_POLICY_METADATA_KEY = "io.flutter.network-policy";
  static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
  static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
  static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
  static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("aot-shared-library-name");
    PUBLIC_AOT_SHARED_LIBRARY_NAME = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("vm-snapshot-data");
    PUBLIC_VM_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("isolate-snapshot-data");
    PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FlutterLoader.class.getName());
    localStringBuilder.append('.');
    localStringBuilder.append("flutter-assets-dir");
    PUBLIC_FLUTTER_ASSETS_DIR_KEY = localStringBuilder.toString();
  }
  
  @NonNull
  private static ApplicationInfo getApplicationInfo(@NonNull Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
  }
  
  private static String getNetworkPolicy(ApplicationInfo paramApplicationInfo, Context paramContext)
  {
    paramApplicationInfo = paramApplicationInfo.metaData;
    if (paramApplicationInfo == null) {
      return null;
    }
    int i = paramApplicationInfo.getInt("io.flutter.network-policy", 0);
    if (i <= 0) {
      return null;
    }
    paramApplicationInfo = new JSONArray();
    try
    {
      paramContext = paramContext.getResources().getXml(i);
      paramContext.next();
      for (i = paramContext.getEventType(); i != 1; i = paramContext.next()) {
        if ((i == 2) && (paramContext.getName().equals("domain-config"))) {
          parseDomainConfig(paramContext, paramApplicationInfo, false);
        }
      }
      return paramApplicationInfo.toString();
    }
    catch (IOException|XmlPullParserException paramApplicationInfo) {}
    return null;
  }
  
  private static String getString(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString(paramString, null);
  }
  
  @NonNull
  public static FlutterApplicationInfo load(@NonNull Context paramContext)
  {
    ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    } else {
      bool = true;
    }
    return new FlutterApplicationInfo(getString(localApplicationInfo.metaData, PUBLIC_AOT_SHARED_LIBRARY_NAME), getString(localApplicationInfo.metaData, PUBLIC_VM_SNAPSHOT_DATA_KEY), getString(localApplicationInfo.metaData, PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY), getString(localApplicationInfo.metaData, PUBLIC_FLUTTER_ASSETS_DIR_KEY), getNetworkPolicy(localApplicationInfo, paramContext), localApplicationInfo.nativeLibraryDir, bool);
  }
  
  private static void parseDomain(XmlResourceParser paramXmlResourceParser, JSONArray paramJSONArray, boolean paramBoolean)
  {
    boolean bool = paramXmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
    paramXmlResourceParser.next();
    if (paramXmlResourceParser.getEventType() == 4)
    {
      String str = paramXmlResourceParser.getText().trim();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(str);
      localJSONArray.put(bool);
      localJSONArray.put(paramBoolean);
      paramJSONArray.put(localJSONArray);
      paramXmlResourceParser.next();
      if (paramXmlResourceParser.getEventType() == 3) {
        return;
      }
      throw new IllegalStateException("Expected end of domain tag");
    }
    throw new IllegalStateException("Expected text");
  }
  
  private static void parseDomainConfig(XmlResourceParser paramXmlResourceParser, JSONArray paramJSONArray, boolean paramBoolean)
  {
    paramBoolean = paramXmlResourceParser.getAttributeBooleanValue(null, "cleartextTrafficPermitted", paramBoolean);
    int i;
    do
    {
      for (;;)
      {
        i = paramXmlResourceParser.next();
        if (i != 2) {
          break;
        }
        if (paramXmlResourceParser.getName().equals("domain")) {
          parseDomain(paramXmlResourceParser, paramJSONArray, paramBoolean);
        } else if (paramXmlResourceParser.getName().equals("domain-config")) {
          parseDomainConfig(paramXmlResourceParser, paramJSONArray, paramBoolean);
        } else {
          skipTag(paramXmlResourceParser);
        }
      }
    } while (i != 3);
  }
  
  private static void skipTag(XmlResourceParser paramXmlResourceParser)
  {
    String str = paramXmlResourceParser.getName();
    for (int i = paramXmlResourceParser.getEventType();; i = paramXmlResourceParser.next()) {
      if ((i == 3) && (paramXmlResourceParser.getName() == str)) {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.loader.ApplicationInfoLoader
 * JD-Core Version:    0.7.0.1
 */