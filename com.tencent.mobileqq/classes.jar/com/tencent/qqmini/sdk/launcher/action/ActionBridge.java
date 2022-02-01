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
  private static final String TAG = "ActionBridge";
  private Action<T> realAction;
  
  static
  {
    ACTION_CLASS.put("ShareAction", "com.tencent.qqmini.sdk.action.ShareAction");
    ACTION_CLASS.put("UpdateUIAction", "com.tencent.qqmini.sdk.action.UpdateUIAction");
    ACTION_CLASS.put("PageAction", "com.tencent.qqmini.sdk.action.PageAction");
    ACTION_CLASS.put("RestartAction", "com.tencent.qqmini.sdk.action.RestartAction");
    ACTION_CLASS.put("GetShareState", "com.tencent.qqmini.sdk.action.GetShareState");
    ACTION_CLASS.put("GetLastClickAction", "com.tencent.qqmini.minigame.action.GetLastClickAction");
    ACTION_CLASS.put("GetTheLastClickInfoAction", "com.tencent.qqmini.minigame.action.GetTheLastClickInfoAction");
  }
  
  public static Action obtain(String paramString, int paramInt, Map<String, Object> paramMap)
  {
    try
    {
      localObject = (String)ACTION_CLASS.get(paramString);
      localAction2 = (Action)MiniAppDexLoader.g().create((String)localObject);
    }
    catch (Throwable paramMap)
    {
      Object localObject;
      Action localAction2;
      label55:
      QMLog.e("ActionBridge", "obtain action exception! actionName=" + paramString, paramMap);
      Action localAction1 = null;
      return localAction1;
    }
    try
    {
      localObject = localAction2.getClass().getDeclaredField("what");
      if (localObject != null)
      {
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).set(localAction2, Integer.valueOf(paramInt));
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
      break label55;
    }
    localObject = localAction2;
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      for (;;)
      {
        localObject = localAction2;
        if (!paramMap.hasNext()) {
          break;
        }
        localObject = (Map.Entry)paramMap.next();
        QMLog.i("ActionBridge", "set action field:" + (String)((Map.Entry)localObject).getKey() + " valud:" + ((Map.Entry)localObject).getValue());
        try
        {
          Field localField = localAction2.getClass().getDeclaredField((String)((Map.Entry)localObject).getKey());
          if (localField != null)
          {
            localField.setAccessible(true);
            localField.set(localAction2, ((Map.Entry)localObject).getValue());
          }
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("ActionBridge", "getField exception! actionName=" + paramString, localThrowable1);
        }
      }
    }
  }
  
  public T perform(BaseRuntime paramBaseRuntime)
  {
    if (this.realAction != null) {
      return this.realAction.perform(paramBaseRuntime);
    }
    return null;
  }
  
  public void setRealAction(Action<T> paramAction)
  {
    this.realAction = paramAction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge
 * JD-Core Version:    0.7.0.1
 */