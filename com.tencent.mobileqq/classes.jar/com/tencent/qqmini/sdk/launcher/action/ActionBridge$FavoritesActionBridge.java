package com.tencent.qqmini.sdk.launcher.action;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class ActionBridge$FavoritesActionBridge
  extends ActionBridge<Boolean>
{
  public static final int ADD_FAVORITES = 1;
  
  public static FavoritesActionBridge obtain(int paramInt, Bundle paramBundle)
  {
    HashMap localHashMap = null;
    if (paramBundle != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("data", paramBundle);
    }
    paramBundle = new FavoritesActionBridge();
    paramBundle.setRealAction(obtain("FavoritesAction", paramInt, localHashMap));
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.FavoritesActionBridge
 * JD-Core Version:    0.7.0.1
 */