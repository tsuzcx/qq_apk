package com.tencent.tgpa.vendorpd;

import android.content.Context;
import com.tencent.tgpa.vendorpd.a.b;
import com.tencent.tgpa.vendorpd.a.b.b;
import com.tencent.tgpa.vendorpd.b.d;
import com.tencent.tgpa.vendorpd.b.f;
import java.util.ArrayList;
import java.util.HashMap;

class GamePredownloaderImpl
  implements GamePredownloader
{
  private static String appChannel = "default";
  private static boolean enableDebug = false;
  private String apiKey;
  private String apiSecret;
  private String deviceId;
  
  private b getRequester()
  {
    b.b localb = new b.b();
    if (enableDebug)
    {
      f.c("sdk will request the test env, make sure don't do this in the release app!");
      localb.a(enableDebug);
    }
    String str = this.apiKey;
    if ((str != null) && (this.apiSecret != null))
    {
      localb.c(str).d(this.apiSecret);
    }
    else
    {
      f.d("request params error, ple check the apiKey & apiSecret!");
      localb.c("").d("");
    }
    str = this.deviceId;
    if (str == null)
    {
      f.c("request params error, ple check the device id!");
      localb.e("");
    }
    else
    {
      localb.e(str);
    }
    str = appChannel;
    if (str == null)
    {
      f.d("request params error, ple check the channel!");
      localb.b("");
    }
    else
    {
      localb.b(str);
    }
    if (com.tencent.tgpa.vendorpd.b.a.a() == null)
    {
      f.d("request params error, ple check the context!");
      localb.a("");
    }
    else
    {
      localb.a(com.tencent.tgpa.vendorpd.b.a.a().getPackageName());
    }
    return localb.a();
  }
  
  public int combinePackage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return combinePackage(paramContext, paramString1, new CombinationInfo(paramString2, paramString3, paramString4, paramString5, paramString6)).getCode();
  }
  
  public GamePredownloader.CombinationError combinePackage(Context paramContext, String paramString, CombinationInfo paramCombinationInfo)
  {
    f.a("Start to combine predownloaded package.");
    if (paramContext == null) {
      return GamePredownloader.CombinationError.ContextIsNULL;
    }
    if (paramString == null) {
      return GamePredownloader.CombinationError.ChannelIsNULL;
    }
    if (paramCombinationInfo.cdnUrl == null) {
      return GamePredownloader.CombinationError.CDNUrlOrMD5IsNULL;
    }
    if (paramCombinationInfo.gamePackageName == null) {
      return GamePredownloader.CombinationError.GamePackageNameIsNULL;
    }
    if (paramCombinationInfo.predownFilePath == null) {
      return GamePredownloader.CombinationError.PredownFilePathIsNULL;
    }
    if (!d.b(paramCombinationInfo.predownFilePath)) {
      return GamePredownloader.CombinationError.PredownFilePathNotExsit;
    }
    com.tencent.tgpa.vendorpd.a.a locala = new com.tencent.tgpa.vendorpd.a.a(paramCombinationInfo);
    locala.a();
    com.tencent.tgpa.vendorpd.b.a.a(paramContext);
    appChannel = paramString;
    paramString = getRequester().a(paramContext.getPackageName(), paramCombinationInfo);
    locala.c();
    paramContext = locala.a(paramString);
    if (paramContext == GamePredownloader.CombinationError.Success)
    {
      f.a("request combine info success!");
      paramContext = locala.a(paramString, paramCombinationInfo);
    }
    else
    {
      f.b("request combine info failed. error code: %d", new Object[] { Integer.valueOf(paramContext.getCode()) });
    }
    if (paramContext == GamePredownloader.CombinationError.Success) {
      f.a("combine apk success.");
    } else {
      f.b("combine apk failed. error code: %d", new Object[] { Integer.valueOf(paramContext.getCode()) });
    }
    locala.b();
    paramCombinationInfo = locala.d();
    if (paramContext == GamePredownloader.CombinationError.Success) {
      paramString = "0";
    } else {
      paramString = "1";
    }
    paramCombinationInfo.put("status", paramString);
    paramCombinationInfo.put("error_code", String.valueOf(paramContext.getCode()));
    getRequester().a(paramCombinationInfo);
    return paramContext;
  }
  
  public void enableDebug(boolean paramBoolean)
  {
    enableDebug = paramBoolean;
  }
  
  public void getGameVersionUpdateInfo(Context paramContext, String paramString, ArrayList<String> paramArrayList, GameCallback paramGameCallback)
  {
    f.a("Start to get game version predownload info.");
    com.tencent.tgpa.vendorpd.b.a.a(paramContext);
    appChannel = paramString;
    getRequester().a(paramGameCallback).a(paramContext, paramArrayList);
    f.b("Start to get game version update info , wait for callback.");
  }
  
  public void reportPreDownladInfo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    com.tencent.tgpa.vendorpd.b.a.a(paramContext);
    if (paramHashMap.containsKey("channel"))
    {
      paramContext = (String)paramHashMap.get("channel");
      if (paramContext != null) {
        appChannel = paramContext;
      }
    }
    paramHashMap.put("event_name", "PreDownloadFile");
    paramHashMap.put("load_time", String.valueOf(System.currentTimeMillis() / 1000L));
    getRequester().a(paramHashMap);
  }
  
  public void setApiKey(String paramString)
  {
    this.apiKey = paramString;
  }
  
  public void setApiSecret(String paramString)
  {
    this.apiSecret = paramString;
  }
  
  public void setDeviceIdentifier(String paramString)
  {
    this.deviceId = paramString;
  }
  
  public void setLogAble(boolean paramBoolean)
  {
    f.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.GamePredownloaderImpl
 * JD-Core Version:    0.7.0.1
 */