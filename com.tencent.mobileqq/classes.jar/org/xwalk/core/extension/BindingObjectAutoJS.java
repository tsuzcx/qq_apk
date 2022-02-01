package org.xwalk.core.extension;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class BindingObjectAutoJS
  extends BindingObject
{
  public static void dispatchEvent(JsContextInfo paramJsContextInfo, String paramString, Object paramObject)
  {
    if (!paramJsContextInfo.getTargetReflect().isEventSupported(paramString))
    {
      paramJsContextInfo = paramJsContextInfo.getTag();
      paramObject = new StringBuilder();
      paramObject.append("Unsupport event in extension: ");
      paramObject.append(paramString);
      Log.w(paramJsContextInfo, paramObject.toString());
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "dispatchEvent");
      localJSONObject.put("constructorName", paramJsContextInfo.getConstructorName());
      localJSONObject.put("objectId", paramJsContextInfo.getObjectId());
      localJSONObject.put("type", paramString);
      localJSONObject.put("event", ReflectionHelper.toSerializableObject(paramObject));
      paramJsContextInfo.postMessage(localJSONObject);
      return;
    }
    catch (Exception paramJsContextInfo)
    {
      paramJsContextInfo.printStackTrace();
    }
  }
  
  public static void invokeJsCallback(JsContextInfo paramJsContextInfo, String paramString, Object... paramVarArgs)
  {
    Object localObject = (Object[])paramVarArgs;
    if ((localObject.length == 1) && ((localObject[0] instanceof JSONArray))) {
      paramVarArgs = (JSONArray)localObject[0];
    } else {
      paramVarArgs = (JSONArray)ReflectionHelper.toSerializableObject(paramVarArgs);
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "invokeCallback");
      ((JSONObject)localObject).put("callbackId", paramString);
      ((JSONObject)localObject).put("args", paramVarArgs);
      paramJsContextInfo.postMessage((JSONObject)localObject);
      return;
    }
    catch (Exception paramJsContextInfo)
    {
      paramJsContextInfo.printStackTrace();
    }
  }
  
  public static void invokeJsCallback(JsContextInfo paramJsContextInfo, byte[] paramArrayOfByte)
  {
    paramJsContextInfo.postMessage(paramArrayOfByte);
  }
  
  public static void sendEvent(JsContextInfo paramJsContextInfo, String paramString, Object paramObject)
  {
    paramJsContextInfo.getExtensionClient().sendEvent(paramString, paramObject);
  }
  
  public static void updateProperty(JsContextInfo paramJsContextInfo, String paramString)
  {
    Object localObject = paramJsContextInfo.getTargetReflect();
    if (!((ReflectionHelper)localObject).hasProperty(paramString).booleanValue())
    {
      paramJsContextInfo = paramJsContextInfo.getTag();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexposed property in extension: ");
      ((StringBuilder)localObject).append(paramString);
      Log.w(paramJsContextInfo, ((StringBuilder)localObject).toString());
      return;
    }
    boolean bool = ((ReflectionHelper)localObject).getMemberInfo(paramString).isStatic;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "updateProperty");
      if (bool) {
        localObject = "0";
      } else {
        localObject = paramJsContextInfo.getObjectId();
      }
      localJSONObject.put("objectId", localObject);
      localJSONObject.put("constructorName", paramJsContextInfo.getConstructorName());
      localJSONObject.put("name", paramString);
      paramJsContextInfo.postMessage(localJSONObject);
      return;
    }
    catch (Exception paramJsContextInfo)
    {
      paramJsContextInfo.printStackTrace();
    }
  }
  
  public void dispatchEvent(String paramString, Object paramObject)
  {
    dispatchEvent(getJsContextInfo(), paramString, paramObject);
  }
  
  public JsContextInfo getJsContextInfo()
  {
    return new JsContextInfo(this.mInstanceHelper.getId(), this.mInstanceHelper.getExtension(), getClass(), this.mObjectId);
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo)
  {
    ReflectionHelper localReflectionHelper = this.mInstanceHelper.getExtension().getReflection().getReflectionByBindingClass(getClass().getName());
    try
    {
      paramMessageInfo = localReflectionHelper.handleMessage(paramMessageInfo, this);
      return paramMessageInfo;
    }
    catch (Exception paramMessageInfo)
    {
      Log.e("BindingObjectAutoJs", paramMessageInfo.toString());
    }
    return null;
  }
  
  public void invokeJsCallback(String paramString, Object... paramVarArgs)
  {
    invokeJsCallback(getJsContextInfo(), paramString, paramVarArgs);
  }
  
  public void invokeJsCallback(byte[] paramArrayOfByte)
  {
    getJsContextInfo().postMessage(paramArrayOfByte);
  }
  
  public void sendEvent(String paramString, Object paramObject)
  {
    sendEvent(getJsContextInfo(), paramString, paramObject);
  }
  
  public void updateProperty(String paramString)
  {
    updateProperty(getJsContextInfo(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObjectAutoJS
 * JD-Core Version:    0.7.0.1
 */