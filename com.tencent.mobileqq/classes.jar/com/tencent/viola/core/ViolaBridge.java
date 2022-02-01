package com.tencent.viola.core;

import com.tencent.viola.adapter.ILogAdapter;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.commons.JSParam;
import com.tencent.viola.module.DomModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaBridge
  implements IViolaBridge
{
  public static final String TAG = "ViolaBridge";
  private static ViolaBridge violaBridge;
  
  public static void callError(int paramInt, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("callError info: type: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(";info: \n");
    ((StringBuilder)localObject1).append(paramString);
    ViolaLogUtils.e("ViolaBridge", ((StringBuilder)localObject1).toString());
    localObject1 = ViolaSDKManager.getInstance().getReportDelegate();
    if (localObject1 != null)
    {
      if (ViolaSDKManager.getInstance().isRenderJsEnd())
      {
        ViolaSDKManager.getInstance().addRunningJsErrorCount();
      }
      else
      {
        ViolaSDKManager.getInstance().addJsErrorCount();
        ((IReportDelegate)localObject1).addReportData(ViolaEnvironment.JS_ERROR_BEFORE_RENDER, Integer.toString(ViolaSDKManager.getInstance().getJsErrorCount()));
      }
      ((IReportDelegate)localObject1).reportJsError(ViolaSDKManager.getInstance().isRenderJsEnd(), paramInt, paramString);
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        if (!ViolaSDKManager.getInstance().isRenderJsEnd()) {
          break label268;
        }
        paramInt = 1;
        localJSONObject.put("ifOpen", paramInt);
        ((JSONObject)localObject2).put("error", paramString);
        ((JSONObject)localObject2).put("tags", localJSONObject);
        ((JSONObject)localObject1).put("data", localObject2);
        ((JSONObject)localObject1).put("type", "error");
        ViolaSDKManager.getInstance().updateInstance(ViolaSDKManager.getInstance().getCurrentViolaInstance(), ((JSONObject)localObject1).toString());
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("callError JSONException e:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        ViolaLogUtils.e("ViolaBridge", ((StringBuilder)localObject2).toString());
      }
      ViolaLogUtils.setLogText(paramString);
      ILogAdapter localILogAdapter = ViolaSDKManager.getInstance().getLogAdapter();
      if (localILogAdapter != null) {
        localILogAdapter.onJSError(paramString);
      }
      return;
      label268:
      paramInt = 0;
    }
  }
  
  public static ViolaBridge getInstance()
  {
    if (violaBridge == null) {
      violaBridge = new ViolaBridge();
    }
    return violaBridge;
  }
  
  public int callJS(String paramString1, String paramString2)
  {
    paramString2 = paramString2.getBytes();
    return callJS(paramString1, paramString2, paramString2.length);
  }
  
  public native int callJS(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public void callSerializableNative(String paramString, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        JSONArray localJSONArray = new JSONArray(paramArrayOfByte);
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          Object localObject = localJSONObject.get("args");
          boolean bool = localJSONObject.has("module");
          if (bool)
          {
            if ("dom".equals(localJSONObject.getString("module")))
            {
              DomModule localDomModule = ViolaModuleManager.getDomModule(paramString);
              if (localDomModule != null) {
                localDomModule.invokeDomMethod(localJSONObject.getString("method"), localObject);
              }
            }
            else
            {
              ViolaBridgeManager.getInstance().callNativeModule(paramString, localJSONObject.getString("module"), localJSONObject.getString("method"), (JSONArray)localObject, null);
            }
          }
          else if (localJSONObject.has("component")) {
            ViolaBridgeManager.getInstance().callNativeComponent(paramString, localJSONObject.getString("component"), localJSONObject.getString("method"), (JSONArray)localObject);
          }
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("callSerializableNative params :");
          paramString.append(paramArrayOfByte);
          ViolaLogUtils.d("ViolaBridge", paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("callSerializableNative Exception e:");
        paramArrayOfByte.append(paramString.getMessage());
        ViolaLogUtils.e("ViolaBridge", paramArrayOfByte.toString());
        return;
      }
      catch (JSONException paramString)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("callSerializableNative JSONException e:");
        paramArrayOfByte.append(paramString.getMessage());
        ViolaLogUtils.e("ViolaBridge", paramArrayOfByte.toString());
        return;
      }
      i += 1;
    }
  }
  
  public int createInstance(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = paramString2.getBytes();
    return createInstance(paramString1, paramString2, paramString2.length, paramString3, paramString4);
  }
  
  public native int createInstance(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3);
  
  public native int destroy();
  
  public native int destroyInstance(String paramString);
  
  public int execJSFunc(String paramString1, String paramString2)
  {
    paramString2 = paramString2.getBytes();
    return execJSFunc(paramString1, paramString2, paramString2.length);
  }
  
  public native int execJSFunc(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public native JSParam execJSFuncWithResult(String paramString, List<JSParam> paramList);
  
  public native int init();
  
  public int initJsFramework(String paramString1, String paramString2)
  {
    paramString1 = paramString1.getBytes();
    return initJsFramework(paramString1, paramString1.length, paramString2);
  }
  
  public native int initJsFramework(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  public void preloadTest(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString2);
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          Object localObject = localJSONObject.get("args");
          boolean bool = localJSONObject.has("module");
          if (bool)
          {
            if ("dom".equals(localJSONObject.getString("module")))
            {
              DomModule localDomModule = ViolaModuleManager.getDomModule(paramString1);
              if (localDomModule != null)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("preloadTest  invokeDomMethod: ");
                localStringBuilder.append(System.currentTimeMillis());
                ViolaLogUtils.d("debugForTimeCost", localStringBuilder.toString());
                localDomModule.invokeDomMethod(localJSONObject.getString("method"), localObject);
              }
            }
            else
            {
              ViolaBridgeManager.getInstance().callNativeModule(paramString1, localJSONObject.getString("module"), localJSONObject.getString("method"), (JSONArray)localObject, null);
            }
          }
          else if (localJSONObject.has("component")) {
            ViolaBridgeManager.getInstance().callNativeComponent(paramString1, localJSONObject.getString("component"), localJSONObject.getString("method"), (JSONArray)localObject);
          }
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append("callSerializableNative params :");
          paramString1.append(paramString2);
          ViolaLogUtils.d("ViolaBridge", paramString1.toString());
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("callSerializableNative Exception e:");
        paramString2.append(paramString1.getMessage());
        ViolaLogUtils.e("ViolaBridge", paramString2.toString());
        return;
      }
      catch (JSONException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("callSerializableNative JSONException e:");
        paramString2.append(paramString1.getMessage());
        ViolaLogUtils.e("ViolaBridge", paramString2.toString());
        return;
      }
      i += 1;
    }
  }
  
  public void setTimeoutNative(String paramString, int paramInt)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      localJSONArray.put(paramInt);
      ViolaModuleManager.callModuleMethod(ViolaSDKManager.getCurInstanceId(), "jsTimer", "setTimeout", localJSONArray);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public native int updateInstance(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaBridge
 * JD-Core Version:    0.7.0.1
 */