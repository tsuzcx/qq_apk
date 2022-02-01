package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;

public class VsGuidInfo
{
  private static VsGuidInfo instance;
  private String OSVersion = "";
  private String androidId = "";
  private String brand = "";
  private final Context context;
  private String ethernetMac = "";
  private String imei = "";
  private String imsi = "";
  private boolean isRooted = false;
  private String mac = "";
  private String mmcid = "";
  private String model = "";
  private String networkType = "";
  
  private VsGuidInfo(Context paramContext)
  {
    this.context = paramContext;
    paramContext = VsDeviceInfo.getVsDeviceInfo(paramContext);
    this.imei = paramContext.getImei();
    this.androidId = paramContext.getAndroidId();
    VsLog.debug("[vsguid] vsguidinfo init", new Object[0]);
  }
  
  public static VsGuidInfo getInstance(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new VsGuidInfo(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    finally {}
  }
  
  public String getAndroidId()
  {
    return this.androidId;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getVsGuid()
  {
    String str = this.androidId + "-" + this.imei;
    VsLog.debug("[vsguid] get guid info %s", new Object[] { str });
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsGuidInfo
 * JD-Core Version:    0.7.0.1
 */