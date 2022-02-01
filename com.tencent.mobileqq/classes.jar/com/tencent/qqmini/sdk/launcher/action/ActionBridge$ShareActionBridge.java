package com.tencent.qqmini.sdk.launcher.action;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class ActionBridge$ShareActionBridge
  extends ActionBridge<Boolean>
{
  public static final int SHARE_OTHER = 6;
  public static final int SHARE_QQ = 1;
  public static final int SHARE_QQ_CHAT = 5;
  public static final int SHARE_QZONE = 2;
  public static final int SHARE_WX_FRIEND = 3;
  public static final int SHARE_WX_MOMENT = 4;
  
  public static ShareActionBridge obtain(int paramInt, Bundle paramBundle)
  {
    HashMap localHashMap = null;
    if (paramBundle != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("data", paramBundle);
    }
    paramBundle = new ShareActionBridge();
    paramBundle.setRealAction(obtain("ShareAction", paramInt, localHashMap));
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.ShareActionBridge
 * JD-Core Version:    0.7.0.1
 */