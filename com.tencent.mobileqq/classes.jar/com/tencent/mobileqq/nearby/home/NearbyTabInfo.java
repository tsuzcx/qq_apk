package com.tencent.mobileqq.nearby.home;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyTabInfo
  implements Serializable, Comparable<NearbyTabInfo>
{
  public static final int TAB_HOT_CHAT = 3;
  public static final int TAB_NEARBY = 1;
  public static final int TAB_NEARBY_HYBRID = 5;
  public static final int TAB_NEARBY_MATCH_MAKER = 7;
  public static final int TAB_NEARBY_MSG = 6;
  public static final int TAB_NEARBY_YULIAO = 8;
  public static final int TAB_NOW = 2;
  public static final int TAB_WEB = 4;
  public int autoEnter;
  public int disableScroll;
  public int needLoc;
  public int reportId;
  public boolean showRedRot;
  public int tabIndex;
  public String tabName;
  public int tabType;
  public String tabUrl;
  
  public static NearbyTabInfo fromJson(String paramString)
  {
    NearbyTabInfo localNearbyTabInfo = new NearbyTabInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localNearbyTabInfo.tabName = paramString.optString("tabName");
      localNearbyTabInfo.tabUrl = paramString.optString("tabUrl");
      localNearbyTabInfo.tabIndex = paramString.optInt("tabIndex");
      localNearbyTabInfo.tabType = paramString.optInt("tabType");
      localNearbyTabInfo.disableScroll = paramString.optInt("disableScroll");
      localNearbyTabInfo.needLoc = paramString.optInt("needLoc");
      localNearbyTabInfo.reportId = paramString.optInt("reportId");
      localNearbyTabInfo.autoEnter = paramString.optInt("autoEnter");
      localNearbyTabInfo.showRedRot = paramString.optBoolean("showRedRot");
      return localNearbyTabInfo;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localNearbyTabInfo;
  }
  
  public int compareTo(NearbyTabInfo paramNearbyTabInfo)
  {
    return this.tabIndex - paramNearbyTabInfo.tabIndex;
  }
  
  public String getTabTag()
  {
    return "android:switcher:" + 2131381782 + ":" + this.tabIndex;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tabName", this.tabName);
      localJSONObject.put("tabUrl", this.tabUrl);
      localJSONObject.put("tabIndex", this.tabIndex);
      localJSONObject.put("tabType", this.tabType);
      localJSONObject.put("disableScroll", this.disableScroll);
      localJSONObject.put("needLoc", this.needLoc);
      localJSONObject.put("reportId", this.reportId);
      localJSONObject.put("autoEnter", this.autoEnter);
      localJSONObject.put("showRedRot", this.showRedRot);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.home.NearbyTabInfo
 * JD-Core Version:    0.7.0.1
 */