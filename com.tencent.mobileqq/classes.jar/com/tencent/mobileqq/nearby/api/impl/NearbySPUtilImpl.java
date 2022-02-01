package com.tencent.mobileqq.nearby.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.NearbySPUtil;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import org.json.JSONObject;

public class NearbySPUtilImpl
  implements INearbySPUtil
{
  public boolean checkMode(int paramInt)
  {
    return NearbySPUtil.a(paramInt);
  }
  
  public boolean checkPreload(String paramString)
  {
    return NearbySPUtil.e(paramString);
  }
  
  public void clearCornerRedDot(String paramString)
  {
    NearbySPUtil.a(paramString);
  }
  
  public boolean contains(String paramString1, String paramString2)
  {
    return NearbySPUtil.a(paramString1, paramString2);
  }
  
  public boolean contains(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return NearbySPUtil.a(paramString1, paramString2, paramInt, paramString3);
  }
  
  public void enterNearbyProcess(String paramString)
  {
    NearbySPUtil.d(paramString);
  }
  
  public boolean getDatingSessionSwitch(String paramString)
  {
    return NearbySPUtil.d(paramString);
  }
  
  public String getLiveTabWebViewUrlByJson()
  {
    return NearbySPUtil.b();
  }
  
  public boolean getLocVisiblityForPeople(String paramString)
  {
    return NearbySPUtil.b(paramString);
  }
  
  public SosoLbsInfo getNearbyLastLocation(String paramString)
  {
    return NearbySPUtil.a(paramString);
  }
  
  public String getNearbyTabUrlParams()
  {
    return NearbySPUtil.a();
  }
  
  public boolean getNotifySwitchState(String paramString)
  {
    return NearbySPUtil.c(paramString);
  }
  
  public SharedPreferences getSharedPreferences(String paramString1, String paramString2, int paramInt)
  {
    return NearbySPUtil.a(paramString1, paramString2, paramInt);
  }
  
  public int getUnreadCount(String paramString1, String paramString2)
  {
    return NearbySPUtil.a(paramString1, paramString2);
  }
  
  public String getUrlJsonToStr(String paramString)
  {
    return NearbySPUtil.a(paramString);
  }
  
  public Object getValue(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    return NearbySPUtil.a(paramSharedPreferences, paramString, paramObject);
  }
  
  public Object getValue(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    return NearbySPUtil.a(paramString1, paramString2, paramInt, paramString3, paramObject);
  }
  
  public Object getValue(String paramString1, String paramString2, Object paramObject)
  {
    return NearbySPUtil.a(paramString1, paramString2, paramObject);
  }
  
  public Object[] getVoteInfo(String paramString)
  {
    return NearbySPUtil.a(paramString);
  }
  
  public boolean isNeedNearbyShowGuide(String paramString)
  {
    return NearbySPUtil.f(paramString);
  }
  
  public boolean isObtainLocAllowed(String paramString)
  {
    return NearbySPUtil.a(paramString);
  }
  
  public JSONObject mergeJson(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    return NearbySPUtil.a(paramJSONObject1, paramJSONObject2);
  }
  
  public void preloadNearbyProcessStart(String paramString)
  {
    NearbySPUtil.b(paramString);
  }
  
  public void preloadNearbyProcessSuc(String paramString)
  {
    NearbySPUtil.c(paramString);
  }
  
  public void saveLiveTabWebViewUrlParam(String paramString)
  {
    NearbySPUtil.f(paramString);
  }
  
  public void saveNearbyTabUrlParams(String paramString)
  {
    NearbySPUtil.e(paramString);
  }
  
  public void setNearbyLastLocation(String paramString, SosoLbsInfo paramSosoLbsInfo)
  {
    NearbySPUtil.a(paramString, paramSosoLbsInfo);
  }
  
  public void setNotifySwitchState(String paramString, boolean paramBoolean)
  {
    NearbySPUtil.a(paramString, paramBoolean);
  }
  
  public boolean setObtainLocAllowed(String paramString, boolean paramBoolean)
  {
    return NearbySPUtil.a(paramString, paramBoolean);
  }
  
  public boolean setValue(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    return NearbySPUtil.a(paramSharedPreferences, paramString, paramObject);
  }
  
  public boolean setValue(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    return NearbySPUtil.a(paramString1, paramString2, paramInt, paramString3, paramObject);
  }
  
  public boolean setValue(String paramString1, String paramString2, Object paramObject)
  {
    return NearbySPUtil.a(paramString1, paramString2, paramObject);
  }
  
  public boolean setVisibilityForPeople(String paramString, boolean paramBoolean)
  {
    return NearbySPUtil.b(paramString, paramBoolean);
  }
  
  public boolean setVoteInfo(String paramString, long paramLong, int paramInt)
  {
    return NearbySPUtil.a(paramString, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbySPUtilImpl
 * JD-Core Version:    0.7.0.1
 */