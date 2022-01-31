package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.BeaconAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class CKeyBeaconReport
{
  private static BeaconInterface mBeaconInterface;
  private String mChannel;
  protected Properties mProperties = null;
  private String mVersion;
  
  public CKeyBeaconReport(String paramString1, String paramString2, BeaconInterface paramBeaconInterface)
  {
    this.mVersion = paramString1;
    this.mChannel = paramString2;
    mBeaconInterface = paramBeaconInterface;
    if (BeaconAdapter.isBeaconEnable()) {
      BeaconAdapter.registerTunnel("000002ZJF83HCA7I", this.mVersion, this.mChannel);
    }
  }
  
  public static String getQIMEI()
  {
    if (BeaconAdapter.isBeaconEnable()) {
      return BeaconAdapter.getQIMEI();
    }
    return mBeaconInterface.getQIMEI();
  }
  
  private static Map<String, String> propertyToMap(Properties paramProperties)
  {
    HashMap localHashMap = new HashMap();
    paramProperties = paramProperties.entrySet().iterator();
    while (paramProperties.hasNext())
    {
      Object localObject2 = (Map.Entry)paramProperties.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 == null) {
        localHashMap.put(localObject1.toString(), "");
      } else {
        localHashMap.put(localObject1.toString(), localObject2.toString());
      }
    }
    return localHashMap;
  }
  
  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    if (BeaconAdapter.isBeaconEnable()) {
      BeaconAdapter.onUserAction(paramString, true, -1L, -1L, propertyToMap(paramProperties), true, false);
    }
    if (mBeaconInterface != null) {
      mBeaconInterface.trackCustomKVEvent(paramString, propertyToMap(paramProperties));
    }
  }
  
  public Properties getProperties()
  {
    return this.mProperties;
  }
  
  public void put(String paramString1, String paramString2)
  {
    if (this.mProperties == null) {
      this.mProperties = new Properties();
    }
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.mProperties.put(paramString1, paramString2);
      }
    }
    else {
      return;
    }
    this.mProperties.put(paramString1, "");
  }
  
  public void setRequiredReportValue()
  {
    this.mProperties = mBeaconInterface.getRequiredReportValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyBeaconReport
 * JD-Core Version:    0.7.0.1
 */