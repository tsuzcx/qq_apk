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
    Object localObject = new FavoritesActionBridge();
    ((FavoritesActionBridge)localObject).setRealAction(obtain("FavoritesAction", paramInt, paramBundle));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.FavoritesActionBridge
 * JD-Core Version:    0.7.0.1
 */