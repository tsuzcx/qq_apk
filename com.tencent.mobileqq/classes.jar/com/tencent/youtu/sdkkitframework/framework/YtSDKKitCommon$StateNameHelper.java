package com.tencent.youtu.sdkkitframework.framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class YtSDKKitCommon$StateNameHelper
{
  private static HashMap<YtSDKKitCommon.StateNameHelper.StateClassName, String> _stateNameMap = new YtSDKKitCommon.StateNameHelper.1();
  
  public static String classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName paramStateClassName)
  {
    return (String)_stateNameMap.get(paramStateClassName);
  }
  
  public static YtSDKKitCommon.StateNameHelper.StateClassName typeOfClassName(String paramString)
  {
    Iterator localIterator = _stateNameMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getValue()).equals(paramString)) {
        return (YtSDKKitCommon.StateNameHelper.StateClassName)localEntry.getKey();
      }
    }
    return YtSDKKitCommon.StateNameHelper.StateClassName.UNKNOWN_STATE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper
 * JD-Core Version:    0.7.0.1
 */