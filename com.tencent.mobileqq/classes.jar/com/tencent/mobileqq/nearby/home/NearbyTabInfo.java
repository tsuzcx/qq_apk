package com.tencent.mobileqq.nearby.home;

import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyTabInfo
  implements INearbyTabInfo, Serializable, Comparable<NearbyTabInfo>
{
  public static final int TAB_HOT_CHAT = 3;
  public static final int TAB_NEARBY_HYBRID = 5;
  public static final int TAB_NEARBY_MATCH_MAKER = 7;
  public static final int TAB_NEARBY_MSG = 6;
  public static final int TAB_NEARBY_YULIAO = 8;
  public static final int TAB_NOW = 2;
  public static final int TAB_WEB = 4;
  private int autoEnter;
  private int disableScroll;
  private INearbyTabInfoDelegate nearbyTabInfoDelegate = (INearbyTabInfoDelegate)QRoute.api(INearbyTabInfoDelegate.class);
  private int needLoc;
  private int reportId;
  private boolean showRedRot;
  private int tabIndex;
  private String tabName;
  private int tabType;
  private String tabUrl;
  
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
  
  public int getAutoEnter()
  {
    return this.autoEnter;
  }
  
  public int getDisableScroll()
  {
    return this.disableScroll;
  }
  
  public int getNeedLoc()
  {
    return this.needLoc;
  }
  
  public int getReportId()
  {
    return this.reportId;
  }
  
  public int getTabIndex()
  {
    return this.tabIndex;
  }
  
  public String getTabName()
  {
    return this.tabName;
  }
  
  public String getTabTag()
  {
    int i = this.nearbyTabInfoDelegate.getVpContentViewId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android:switcher:");
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(this.tabIndex);
    return localStringBuilder.toString();
  }
  
  public int getTabType()
  {
    return this.tabType;
  }
  
  public String getTabUrl()
  {
    return this.tabUrl;
  }
  
  public boolean isShowRedRot()
  {
    return this.showRedRot;
  }
  
  public void setAutoEnter(int paramInt)
  {
    this.autoEnter = paramInt;
  }
  
  public void setDisableScroll(int paramInt)
  {
    this.disableScroll = paramInt;
  }
  
  public void setNeedLoc(int paramInt)
  {
    this.needLoc = paramInt;
  }
  
  public void setReportId(int paramInt)
  {
    this.reportId = paramInt;
  }
  
  public void setShowRedRot(boolean paramBoolean)
  {
    this.showRedRot = paramBoolean;
  }
  
  public void setTabIndex(int paramInt)
  {
    this.tabIndex = paramInt;
  }
  
  public void setTabName(String paramString)
  {
    this.tabName = paramString;
  }
  
  public void setTabType(int paramInt)
  {
    this.tabType = paramInt;
  }
  
  public void setTabUrl(String paramString)
  {
    this.tabUrl = paramString;
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
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.home.NearbyTabInfo
 * JD-Core Version:    0.7.0.1
 */