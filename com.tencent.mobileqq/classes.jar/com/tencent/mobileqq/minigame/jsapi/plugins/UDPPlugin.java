package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class UDPPlugin
  extends BaseJsPlugin
{
  private static final String CALLBACK_NAME = "onUDPTaskEventCallback";
  private static final Set<String> EVENT_MAP = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "createUDPTask", "operateUDPTask" })));
  private static final Pattern IPV4_ADDRESS_REGEX = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.\\d{1,3}");
  private static final Pattern IPV6_ADDRESS_REGEX = Pattern.compile("\\[?(([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]+|::(ffff(:0{1,4})?:)?((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9]))]?");
  private static final String OPERATION_CREATE_UDP_TASK = "createUDPTask";
  private static final String OPERATION_OPERATE_UDP_TASK = "operateUDPTask";
  private static final String TAG = "UDPPlugin";
  private static final AtomicInteger UDP_TASK_ID_COUNTER = new AtomicInteger();
  private JsRuntime mJsRuntime;
  private final SparseArray<UDPPlugin.UDPTask> mTaskRegistry = new SparseArray();
  
  private void callbackError(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", paramInt);
      localJSONObject.put("event", "error");
      localJSONObject.put("errMsg", paramString);
      this.mJsRuntime.evaluateSubcribeJS("onUDPTaskEventCallback", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void handleTaskOperation(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString, int paramInt, UDPPlugin.UDPTask paramUDPTask)
  {
    if ("bind".equals(paramString)) {
      paramJSONObject1.put("port", paramUDPTask.bind());
    }
    do
    {
      return;
      if ("close".equals(paramString))
      {
        paramUDPTask.close();
        this.mTaskRegistry.remove(paramInt);
        return;
      }
    } while (!"send".equals(paramString));
    performSend(paramJSONObject1, paramJSONObject2, paramUDPTask);
  }
  
  private void performSend(JSONObject paramJSONObject1, JSONObject paramJSONObject2, UDPPlugin.UDPTask paramUDPTask)
  {
    Object localObject2 = null;
    String str = paramJSONObject2.optString("address");
    int n = paramJSONObject2.optInt("port", -1);
    if (!paramJSONObject2.isNull("message")) {}
    for (Object localObject1 = paramJSONObject2.optString("message", null);; localObject1 = null)
    {
      int j;
      int i;
      if (localObject1 != null)
      {
        paramJSONObject2 = ((String)localObject1).getBytes("UTF-8");
        j = 0;
        i = paramJSONObject2.length;
      }
      for (;;)
      {
        localObject1 = validAddress(str);
        if (localObject1 != null) {
          break;
        }
        paramJSONObject1.put("errMsg", "invalid address :[" + str + "]");
        QLog.d("UDPPlugin", 1, "invalid address :[" + str + "]");
        return;
        localObject1 = NativeBuffer.unpackNativeBuffer(paramJSONObject2, "message", (ITNativeBufferPool)this.jsPluginEngine.getNativeBufferPool());
        int k = paramJSONObject2.optInt("offset");
        int m = paramJSONObject2.optInt("length", -1);
        i = m;
        j = k;
        paramJSONObject2 = localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((NativeBuffer)localObject1).buf;
          i = m;
          j = k;
          paramJSONObject2 = (JSONObject)localObject1;
          if (m == -1)
          {
            i = localObject1.length;
            j = k;
            paramJSONObject2 = (JSONObject)localObject1;
          }
        }
      }
      if (n < 0)
      {
        paramJSONObject1.put("errMsg", "invalid port");
        return;
      }
      if (paramJSONObject2 == null)
      {
        paramJSONObject1.put("errMsg", "undefined message");
        return;
      }
      if ((j < 0) || (j >= i))
      {
        paramJSONObject1.put("errMsg", "invalid offset");
        return;
      }
      if (i > paramJSONObject2.length)
      {
        paramJSONObject1.put("errMsg", "invalid length");
        return;
      }
      paramUDPTask.send(paramJSONObject2, j, i, new InetSocketAddress((InetAddress)localObject1, n));
      return;
    }
  }
  
  @Nullable
  private InetAddress validAddress(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      if ((IPV4_ADDRESS_REGEX.matcher(paramString).matches()) || (IPV6_ADDRESS_REGEX.matcher(paramString).matches())) {
        try
        {
          InetAddress localInetAddress = InetAddress.getByName(paramString);
          if ((!localInetAddress.isLoopbackAddress()) && (!localInetAddress.isAnyLocalAddress()) && (!localInetAddress.isMulticastAddress()))
          {
            if (localInetAddress.isSiteLocalAddress()) {
              return localInetAddress;
            }
            boolean bool = this.jsPluginEngine.appBrandRuntime.getApkgInfo().isUdpIpValid(paramString);
            if (bool) {
              return localInetAddress;
            }
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          QLog.d("UDPPlugin", 1, "valid address [" + paramString + "]", localUnknownHostException);
        }
      }
    }
    return null;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    this.mJsRuntime = paramJsRuntime;
    paramJsRuntime = new JSONObject();
    try
    {
      if ("createUDPTask".equals(paramString1))
      {
        paramString1 = new UDPPlugin.UDPTask(this);
        this.mTaskRegistry.put(paramString1.taskId, paramString1);
        paramJsRuntime.put("udpTaskId", paramString1.taskId);
      }
      for (;;)
      {
        return paramJsRuntime.toString();
        if ("operateUDPTask".equals(paramString1))
        {
          paramString1 = new JSONObject(paramString2);
          paramString2 = paramString1.optString("operation");
          paramInt = paramString1.optInt("udpTaskId");
          UDPPlugin.UDPTask localUDPTask = (UDPPlugin.UDPTask)this.mTaskRegistry.get(paramInt);
          if (localUDPTask == null) {
            break;
          }
          handleTaskOperation(paramJsRuntime, paramString1, paramString2, paramInt, localUDPTask);
          paramString1 = paramJsRuntime.optString("errMsg", null);
          if (paramString1 != null) {
            callbackError(paramString1, paramInt);
          }
        }
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        try
        {
          paramJsRuntime.put("errMsg", paramString1.getMessage());
        }
        catch (JSONException paramString1) {}
        continue;
        paramJsRuntime.put("errMsg", "task already closed");
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        try
        {
          paramJsRuntime.put("errMsg", paramString1.getMessage());
        }
        catch (JSONException paramString1) {}
      }
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.UDPPlugin
 * JD-Core Version:    0.7.0.1
 */