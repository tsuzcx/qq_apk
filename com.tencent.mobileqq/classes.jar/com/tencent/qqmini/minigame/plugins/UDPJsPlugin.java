package com.tencent.qqmini.minigame.plugins;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class UDPJsPlugin
  extends BaseJsPlugin
{
  private static final Pattern IPV4_ADDRESS_REGEX = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.\\d{1,3}");
  private static final Pattern IPV6_ADDRESS_REGEX;
  private static final String TAG = "UDPPlugin";
  private static final AtomicInteger UDP_TASK_ID_COUNTER = new AtomicInteger();
  private final SparseArray<UDPJsPlugin.UDPTask> mTaskRegistry = new SparseArray();
  private volatile Set<String> mUdpIpWhiteSet;
  
  static
  {
    IPV6_ADDRESS_REGEX = Pattern.compile("\\[?(([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]+|::(ffff(:0{1,4})?:)?((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9]))]?");
  }
  
  private void callbackError(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", paramInt);
      localJSONObject.put("event", "error");
      localJSONObject.put("errMsg", paramString);
      sendSubscribeEvent("onUDPTaskEventCallback", localJSONObject.toString());
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private boolean getEnableDebug(String paramString)
  {
    return StorageUtil.getPreference().getBoolean(paramString + "_debug", false);
  }
  
  private void handleTaskOperation(IJsService paramIJsService, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString, int paramInt, UDPJsPlugin.UDPTask paramUDPTask)
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
    performSend(paramIJsService, paramJSONObject1, paramJSONObject2, paramUDPTask);
  }
  
  private void performSend(IJsService paramIJsService, JSONObject paramJSONObject1, JSONObject paramJSONObject2, UDPJsPlugin.UDPTask paramUDPTask)
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
        paramIJsService = ((String)localObject1).getBytes("UTF-8");
        j = 0;
        i = paramIJsService.length;
      }
      for (;;)
      {
        paramJSONObject2 = validAddress(str);
        if (paramJSONObject2 != null) {
          break;
        }
        paramJSONObject1.put("errMsg", "invalid address :[" + str + "]");
        QMLog.d("UDPPlugin", "invalid address :[" + str + "]");
        return;
        localObject1 = NativeBuffer.unpackNativeBuffer(paramIJsService, paramJSONObject2, "message");
        int k = paramJSONObject2.optInt("offset");
        int m = paramJSONObject2.optInt("length", -1);
        i = m;
        j = k;
        paramIJsService = localObject2;
        if (localObject1 != null)
        {
          paramJSONObject2 = ((NativeBuffer)localObject1).buf;
          i = m;
          j = k;
          paramIJsService = paramJSONObject2;
          if (m == -1)
          {
            i = paramJSONObject2.length;
            j = k;
            paramIJsService = paramJSONObject2;
          }
        }
      }
      if (n < 0)
      {
        paramJSONObject1.put("errMsg", "invalid port");
        return;
      }
      if (paramIJsService == null)
      {
        paramJSONObject1.put("errMsg", "undefined message");
        return;
      }
      if ((j < 0) || (j >= i))
      {
        paramJSONObject1.put("errMsg", "invalid offset");
        return;
      }
      if (i > paramIJsService.length)
      {
        paramJSONObject1.put("errMsg", "invalid length");
        return;
      }
      paramUDPTask.send(paramIJsService, j, i, new InetSocketAddress(paramJSONObject2, n));
      return;
    }
  }
  
  @JsEvent({"createUDPTask"})
  public String createUDPTask(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramRequestEvent = new UDPJsPlugin.UDPTask(this, paramRequestEvent.jsService);
      this.mTaskRegistry.put(paramRequestEvent.taskId, paramRequestEvent);
      localJSONObject.put("udpTaskId", paramRequestEvent.taskId);
      return localJSONObject.toString();
    }
    catch (IOException paramRequestEvent)
    {
      for (;;)
      {
        try
        {
          localJSONObject.put("errMsg", paramRequestEvent.getMessage());
        }
        catch (JSONException paramRequestEvent) {}
      }
    }
    catch (JSONException paramRequestEvent)
    {
      for (;;)
      {
        try
        {
          localJSONObject.put("errMsg", paramRequestEvent.getMessage());
        }
        catch (JSONException paramRequestEvent) {}
      }
    }
  }
  
  @VisibleForTesting
  public boolean isUdpIpValid(String paramString)
  {
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if (localMiniAppInfo == null) {
      return false;
    }
    if (localMiniAppInfo.skipDomainCheck == 1)
    {
      QMLog.d("[mini] http.udp", "udp ip检查 skip: " + paramString);
      return true;
    }
    if ((localMiniAppInfo.verType != 3) && (getEnableDebug(localMiniAppInfo.appId)))
    {
      QMLog.d("[mini] http.udp", "debug opened and not online version, skip:" + paramString);
      return true;
    }
    if (this.mUdpIpWhiteSet == null) {}
    try
    {
      if (this.mUdpIpWhiteSet == null) {
        this.mUdpIpWhiteSet = new HashSet(localMiniAppInfo.udpIpList);
      }
      return this.mUdpIpWhiteSet.contains(paramString);
    }
    finally {}
  }
  
  public void onDestroy()
  {
    this.mUdpIpWhiteSet = null;
    super.onDestroy();
  }
  
  @JsEvent({"operateUDPTask"})
  public String operateUDPTask(RequestEvent paramRequestEvent)
  {
    localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject(paramRequestEvent.jsonParams);
        String str = localJSONObject2.optString("operation");
        int i = localJSONObject2.optInt("udpTaskId");
        UDPJsPlugin.UDPTask localUDPTask = (UDPJsPlugin.UDPTask)this.mTaskRegistry.get(i);
        if (localUDPTask == null) {
          continue;
        }
        handleTaskOperation(paramRequestEvent.jsService, localJSONObject1, localJSONObject2, str, i, localUDPTask);
        paramRequestEvent = localJSONObject1.optString("errMsg", null);
        if (paramRequestEvent != null) {
          callbackError(paramRequestEvent, i);
        }
      }
      catch (IOException paramRequestEvent)
      {
        try
        {
          localJSONObject1.put("errMsg", paramRequestEvent.getMessage());
        }
        catch (JSONException paramRequestEvent) {}
        continue;
      }
      catch (JSONException paramRequestEvent)
      {
        try
        {
          localJSONObject1.put("errMsg", paramRequestEvent.getMessage());
        }
        catch (JSONException paramRequestEvent) {}
        continue;
      }
      return localJSONObject1.toString();
      localJSONObject1.put("errMsg", "task already closed");
    }
  }
  
  @VisibleForTesting
  public InetAddress validAddress(String paramString)
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
            boolean bool = isUdpIpValid(paramString);
            if (bool) {
              return localInetAddress;
            }
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          QMLog.d("UDPPlugin", "valid address [" + paramString + "]", localUnknownHostException);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UDPJsPlugin
 * JD-Core Version:    0.7.0.1
 */