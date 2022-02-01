package com.tencent.qqmini.sdk.auth;

import java.util.Map;

public abstract interface PermissionParser
{
  public abstract Map<String, EventInfo> getEventsMap();
  
  public abstract Map<String, PermissionInfo> getScopePermissionMap();
  
  public abstract Map<String, PermissionInfo> getSystemPermissionMap();
  
  public abstract boolean parse();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.PermissionParser
 * JD-Core Version:    0.7.0.1
 */