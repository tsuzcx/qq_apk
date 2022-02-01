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
    if (paramEventInfo == null) {
      return false;
    }
    Object localObject = this.mEventsMap;
    if (localObject == null) {
      return false;
    }
    if (((Map)localObject).containsKey(paramEventInfo.name))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Ignore duplicated event entry ");
      ((StringBuilder)localObject).append(paramEventInfo.name);
      Log.w("PermissionParser", ((StringBuilder)localObject).toString());
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
    StringBuilder localStringBuilder;
    if (paramPermissionInfo.builtIn)
    {
      if (this.mSystemPermissionMap.containsKey(paramPermissionInfo.id))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Ignore duplicated system permission entry ");
        localStringBuilder.append(paramPermissionInfo.id);
        Log.w("PermissionParser", localStringBuilder.toString());
        return false;
      }
      this.mSystemPermissionMap.put(paramPermissionInfo.id, paramPermissionInfo);
    }
    else
    {
      if (this.mScopePermissionMap.containsKey(paramPermissionInfo.id))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Ignore duplicated scope permission entry ");
        localStringBuilder.append(paramPermissionInfo.id);
        Log.w("PermissionParser", localStringBuilder.toString());
        return false;
      }
      this.mScopePermissionMap.put(paramPermissionInfo.id, paramPermissionInfo);
    }
    return true;
  }
  
  public void clear()
  {
    Map localMap = this.mSystemPermissionMap;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.mScopePermissionMap;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.mEventsMap;
    if (localMap != null) {
      localMap.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.parser.AbstractPermissionParser
 * JD-Core Version:    0.7.0.1
 */