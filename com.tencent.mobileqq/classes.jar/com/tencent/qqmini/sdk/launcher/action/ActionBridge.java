package com.tencent.qqmini.sdk.launcher.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ActionBridge<T>
  implements Action
{
  public static final Map<String, String> ACTION_CLASS = new HashMap();
  private static final String ACTION_NAME_GET_APP_PAGE_ROUTER = "GetAppPageRouterAction";
  private static final String TAG = "ActionBridge";
  private Action<T> realAction;
  
  static
  {
    ACTION_CLASS.put("ShareAction", "com.tencent.qqmini.sdk.action.ShareAction");
    ACTION_CLASS.put("FavoritesAction", "com.tencent.qqmini.sdk.action.FavoritesAction");
    ACTION_CLASS.put("UpdateUIAction", "com.tencent.qqmini.sdk.action.UpdateUIAction");
    ACTION_CLASS.put("PageAction", "com.tencent.qqmini.sdk.action.PageAction");
    ACTION_CLASS.put("RestartAction", "com.tencent.qqmini.sdk.action.RestartAction");
    ACTION_CLASS.put("GetShareState", "com.tencent.qqmini.sdk.action.GetShareState");
    ACTION_CLASS.put("GetLastClickAction", "com.tencent.qqmini.minigame.action.GetLastClickAction");
    ACTION_CLASS.put("GetTheLastClickInfoAction", "com.tencent.qqmini.minigame.action.GetTheLastClickInfoAction");
    ACTION_CLASS.put("GetAppPageRouterAction", "com.tencent.qqmini.miniapp.action.GetAppPageRouterAction");
  }
  
  public static Action obtain(String paramString, int paramInt, Map<String, Object> paramMap)
  {
    try
    {
      localObject1 = (String)ACTION_CLASS.get(paramString);
      localObject1 = (Action)MiniAppDexLoader.g().create((String)localObject1);
      try
      {
        Field localField = localObject1.getClass().getDeclaredField("what");
        if (localField != null)
        {
          localField.setAccessible(true);
          localField.set(localObject1, Integer.valueOf(paramInt));
        }
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      if (paramMap != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("set action field:");
          ((StringBuilder)localObject2).append((String)localEntry.getKey());
          ((StringBuilder)localObject2).append(" valud:");
          ((StringBuilder)localObject2).append(localEntry.getValue());
          QMLog.i("ActionBridge", ((StringBuilder)localObject2).toString());
          try
          {
            localObject2 = localObject1.getClass().getDeclaredField((String)localEntry.getKey());
            if (localObject2 != null)
            {
              ((Field)localObject2).setAccessible(true);
              ((Field)localObject2).set(localObject1, localEntry.getValue());
            }
          }
          catch (Throwable localThrowable2)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getField exception! actionName=");
            ((StringBuilder)localObject2).append(paramString);
            QMLog.e("ActionBridge", ((StringBuilder)localObject2).toString(), localThrowable2);
          }
        }
      }
      return localObject1;
    }
    catch (Throwable paramMap)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("obtain action exception! actionName=");
      ((StringBuilder)localObject1).append(paramString);
      QMLog.e("ActionBridge", ((StringBuilder)localObject1).toString(), paramMap);
    }
    return null;
  }
  
  public T perform(BaseRuntime paramBaseRuntime)
  {
    Action localAction = this.realAction;
    if (localAction != null) {
      return localAction.perform(paramBaseRuntime);
    }
    return null;
  }
  
  public void setRealAction(Action<T> paramAction)
  {
    this.realAction = paramAction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge
 * JD-Core Version:    0.7.0.1
 */