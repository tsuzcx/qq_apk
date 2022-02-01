package com.tencent.qqmini.sdk.launcher.action;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import java.util.HashMap;
import java.util.Map;

public class ActionBridge$PageActionBridge
  extends ActionBridge<AppPageInfo>
{
  public static int getPageId(IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext = (AppPageInfo)paramIMiniAppContext.performAction(obtain(1));
    if (paramIMiniAppContext != null) {
      return paramIMiniAppContext.pageId;
    }
    return -1;
  }
  
  public static String getPageUrl(IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext = (AppPageInfo)paramIMiniAppContext.performAction(obtain(2));
    if (paramIMiniAppContext != null) {
      return paramIMiniAppContext.pageUrl;
    }
    return null;
  }
  
  public static PageActionBridge obtain(int paramInt)
  {
    PageActionBridge localPageActionBridge = new PageActionBridge();
    HashMap localHashMap = new HashMap();
    localHashMap.put("flag", Integer.valueOf(paramInt));
    localPageActionBridge.setRealAction(obtain("PageAction", 0, localHashMap));
    return localPageActionBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge
 * JD-Core Version:    0.7.0.1
 */