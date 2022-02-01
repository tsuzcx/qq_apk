package com.tencent.qqmini.sdk.auth.parser;

import android.util.Log;
import com.tencent.qqmini.sdk.auth.EventInfo;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionParser;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractPermissionParser
  implements PermissionParser
{
  public static final String TAG = "PermissionParser";
  protected Map<String, EventInfo> mEventsMap = new HashMap();
  protected Map<String, PermissionInfo> mScopePermissionMap = new HashMap();
  protected Map<String, PermissionInfo> mSystemPermissionMap = new HashMap();
  
  public boolean addEvent(EventInfo paramEventInfo)
  {
    if (paramEventInfo == null) {}
    while (this.mEventsMap == null) {
      return false;
    }
    if (this.mEventsMap.containsKey(paramEventInfo.name))
    {
      Log.w("PermissionParser", "Ignore duplicated event entry " + paramEventInfo.name);
      return false;
    }
    this.mEventsMap.put(paramEventInfo.name, paramEventInfo);
    return true;
  }
  
  public boolean addPermission(PermissionInfo paramPermissionInfo)
  {
    if (paramPermissionInfo == null) {
      return false;
    }
    if (paramPermissionInfo.builtIn)
    {
      if (this.mSystemPermissionMap.containsKey(paramPermissionInfo.id))
      {
        Log.w("PermissionParser", "Ignore duplicated system permission entry " + paramPermissionInfo.id);
        return false;
      }
      this.mSystemPermissionMap.put(paramPermissionInfo.id, paramPermissionInfo);
    }
    for (;;)
    {
      return true;
      if (this.mScopePermissionMap.containsKey(paramPermissionInfo.id))
      {
        Log.w("PermissionParser", "Ignore duplicated scope permission entry " + paramPermissionInfo.id);
        return false;
      }
      this.mScopePermissionMap.put(paramPermissionInfo.id, paramPermissionInfo);
    }
  }
  
  public void clear()
  {
    if (this.mSystemPermissionMap != null) {
      this.mSystemPermissionMap.clear();
    }
    if (this.mScopePermissionMap != null) {
      this.mScopePermissionMap.clear();
    }
    if (this.mEventsMap != null) {
      this.mEventsMap.clear();
    }
  }
  
  public Map<String, EventInfo> getEventsMap()
  {
    return this.mEventsMap;
  }
  
  public Map<String, PermissionInfo> getScopePermissionMap()
  {
    return this.mScopePermissionMap;
  }
  
  public Map<String, PermissionInfo> getSystemPermissionMap()
  {
    return this.mSystemPermissionMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser
 * JD-Core Version:    0.7.0.1
 */