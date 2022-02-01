package com.tencent.qqmini.sdk.auth.parser;

import android.content.Context;
import com.tencent.qqmini.sdk.auth.EventInfo;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionParser;
import java.util.Map;

public class RemotePermissionParser
  implements PermissionParser
{
  public RemotePermissionParser(Context paramContext) {}
  
  public Map<String, EventInfo> getEventsMap()
  {
    return null;
  }
  
  public Map<String, PermissionInfo> getScopePermissionMap()
  {
    return null;
  }
  
  public Map<String, PermissionInfo> getSystemPermissionMap()
  {
    return null;
  }
  
  public boolean parse()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.parser.RemotePermissionParser
 * JD-Core Version:    0.7.0.1
 */