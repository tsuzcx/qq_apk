package com.tencent.viola.bridge;

import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.VReflectionUtils;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONObject;

public final class NativeInvokeHelper
{
  private Object[] prepareArguments(Type[] paramArrayOfType, JSONArray paramJSONArray)
  {
    Object[] arrayOfObject = new Object[paramArrayOfType.length];
    int i = 0;
    while (i < paramArrayOfType.length)
    {
      Type localType = paramArrayOfType[i];
      if (i >= paramJSONArray.length())
      {
        if (!localType.getClass().isPrimitive()) {
          arrayOfObject[i] = null;
        } else {
          throw new Exception("[prepareArguments] method argument list not match.");
        }
      }
      else
      {
        Object localObject = paramJSONArray.get(i);
        if (localType == JSONObject.class)
        {
          if ((!(localObject instanceof JSONObject)) && (localObject != null))
          {
            if ((localObject instanceof String)) {
              arrayOfObject[i] = new JSONObject(localObject.toString());
            }
          }
          else {
            arrayOfObject[i] = localObject;
          }
        }
        else {
          arrayOfObject[i] = VReflectionUtils.parseArgument(localType, localObject);
        }
      }
      i += 1;
    }
    return arrayOfObject;
  }
  
  public Object invoke(Object paramObject, Invoker paramInvoker, JSONArray paramJSONArray)
  {
    paramJSONArray = prepareArguments(paramInvoker.getParameterTypes(), paramJSONArray);
    if (paramInvoker.isRunOnUIThread())
    {
      ViolaSDKManager.getInstance().postOnUiThread(new NativeInvokeHelper.1(this, paramInvoker, paramObject, paramJSONArray));
      return null;
    }
    return paramInvoker.invoke(paramObject, paramJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.bridge.NativeInvokeHelper
 * JD-Core Version:    0.7.0.1
 */