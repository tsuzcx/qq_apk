package com.tencent.mobileqq.jsbridge;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Deprecated
public class JsBridge$JsHandler
{
  public void call(String paramString, List<String> paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    Object localObject2 = getClass().getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = localObject2[i];
      if ((((Method)localObject1).getName().equals(paramString)) && (((Method)localObject1).getParameterTypes().length == paramList.size())) {
        break label73;
      }
      i += 1;
    }
    Object localObject1 = null;
    label73:
    if (localObject1 != null) {}
    try
    {
      if (paramList.size() == 0) {
        localObject2 = ((Method)localObject1).invoke(this, new Object[0]);
      } else {
        localObject2 = ((Method)localObject1).invoke(this, paramList.toArray());
      }
      localObject1 = ((Method)localObject1).getReturnType();
      if ((localObject1 != Void.TYPE) && (localObject1 != Void.class))
      {
        if (paramJsBridgeListener != null)
        {
          if (customCallback())
          {
            paramJsBridgeListener.a(localObject2.toString());
            return;
          }
          paramJsBridgeListener.a(localObject2);
        }
      }
      else if (paramJsBridgeListener != null) {
        paramJsBridgeListener.a(null);
      }
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label212;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label201;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label190;
    }
    catch (Exception localException)
    {
      label179:
      label190:
      label201:
      label212:
      break label179;
    }
    if (paramJsBridgeListener != null)
    {
      paramJsBridgeListener.a();
      break label220;
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.a();
        break label220;
        if (paramJsBridgeListener != null)
        {
          paramJsBridgeListener.a();
          break label220;
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.a();
          }
        }
      }
    }
    label220:
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cannot found match method,maybe your method using args type is NO String? request method:class:");
      ((StringBuilder)localObject1).append(getClass().getSimpleName());
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" args:");
      ((StringBuilder)localObject1).append(paramList);
      QLog.d("JB", 4, ((StringBuilder)localObject1).toString());
    }
    if (paramJsBridgeListener != null) {
      paramJsBridgeListener.a();
    }
  }
  
  public boolean customCallback()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsbridge.JsBridge.JsHandler
 * JD-Core Version:    0.7.0.1
 */