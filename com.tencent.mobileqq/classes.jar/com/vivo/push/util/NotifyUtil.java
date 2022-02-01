package com.vivo.push.util;

import android.content.Context;

public class NotifyUtil
{
  private static BaseNotifyDataAdapter sNotifyData;
  private static String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
  private static BaseNotifyLayoutAdapter sNotifyLayout;
  private static String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";
  
  public static BaseNotifyDataAdapter getNotifyDataAdapter(Context paramContext)
  {
    initAdapter(paramContext);
    return sNotifyData;
  }
  
  public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context paramContext)
  {
    initAdapter(paramContext);
    return sNotifyLayout;
  }
  
  private static Object getObjectByReflect(String paramString, Object paramObject)
  {
    try
    {
      paramString = Class.forName(paramString);
    }
    catch (Exception paramString)
    {
      label8:
      label22:
      break label8;
    }
    paramString = null;
    if (paramString != null) {}
    try
    {
      paramString = paramString.newInstance();
    }
    catch (Exception paramString)
    {
      Object localObject;
      break label22;
    }
    paramString = null;
    localObject = paramString;
    if (paramString == null) {
      localObject = paramObject;
    }
    return localObject;
  }
  
  private static void initAdapter(Context paramContext)
  {
    try
    {
      Object localObject;
      if (sNotifyData == null)
      {
        localObject = (BaseNotifyDataAdapter)getObjectByReflect(sNotifyDataAdapter, new h());
        sNotifyData = (BaseNotifyDataAdapter)localObject;
        ((BaseNotifyDataAdapter)localObject).init(paramContext);
      }
      if (sNotifyLayout == null)
      {
        localObject = (BaseNotifyLayoutAdapter)getObjectByReflect(sNotifyLayoutAdapter, new i());
        sNotifyLayout = (BaseNotifyLayoutAdapter)localObject;
        ((BaseNotifyLayoutAdapter)localObject).init(paramContext);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.NotifyUtil
 * JD-Core Version:    0.7.0.1
 */