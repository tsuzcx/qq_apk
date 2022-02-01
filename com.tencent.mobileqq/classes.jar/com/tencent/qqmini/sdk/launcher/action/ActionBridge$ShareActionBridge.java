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
    if (paramBundle != null)
    {
      localObject = new HashMap();
      ((Map)localObject).put("data", paramBundle);
      paramBundle = (Bundle)localObject;
    }
    else
    {
      paramBundle = null;
    }
    Object localObject = new ShareActionBridge();
    ((ShareActionBridge)localObject).setRealAction(obtain("ShareAction", paramInt, paramBundle));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.ShareActionBridge
 * JD-Core Version:    0.7.0.1
 */