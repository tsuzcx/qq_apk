package com.tencent.qqmini.sdk.plugins;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.DomainUtil;
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
  
  @Nullable
  private InetAddress getInetAddress(@NonNull String paramString)
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(paramString);
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      QMLog.d("UDPPlugin", "getInetAddress address:" + paramString, localUnknownHostException);
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        QMLog.d("UDPPlugin", "getInetAddress address:" + paramString, localSecurityException);
      }
    }
  }
  
  @Nullable
  private InetAddress getInetAddressByDomain(@NonNull String paramString, int paramInt, boolean paramBoolean)
  {
    String str = paramString + ":" + paramInt;
    if (DomainUtil.isDomainValid(getMiniAppInfo(), paramBoolean, str, 5)) {
      return getInetAddress(paramString);
    }
    return null;
  }
  
  @Nullable
  private InetAddress getInetAddressByIp(@NonNull String paramString, boolean paramBoolean)
  {
    InetAddress localInetAddress = getInetAddress(paramString);
    if (localInetAddress == null) {}
    do
    {
      do
      {
        return null;
      } while ((localInetAddress.isLoopbackAddress()) || (localInetAddress.isAnyLocalAddress()) || (localInetAddress.isMulticastAddress()));
      if (localInetAddress.isSiteLocalAddress()) {
        return localInetAddress;
      }
    } while ((!paramBoolean) && (!isUdpIpValid(paramString)));
    return localInetAddress;
  }
  
  private void performSend(IJsService paramIJsService, JSONObject paramJSONObject, UDPJsPlugin.UDPTask paramUDPTask)
  {
    int j = 0;
    Object localObject2 = null;
    String str = paramJSONObject.optString("address");
    int n = paramJSONObject.optInt("port", -1);
    boolean bool = paramJSONObject.optBoolean("__skipDomainCheck__", false);
    if (!paramJSONObject.isNull("message")) {}
    for (Object localObject1 = paramJSONObject.optString("message", null);; localObject1 = null)
    {
      int i;
      if (localObject1 != null)
      {
        paramIJsService = ((String)localObject1).getBytes("UTF-8");
        i = paramIJsService.length;
      }
      while (n < 0)
      {
        callbackError("invalid port", paramUDPTask.taskId);
        return;
        localObject1 = NativeBuffer.unpackNativeBuffer(paramIJsService, paramJSONObject, "message");
        int k = paramJSONObject.optInt("offset");
        int m = paramJSONObject.optInt("length", -1);
        i = m;
        j = k;
        paramIJsService = localObject2;
        if (localObject1 != null)
        {
          paramJSONObject = ((NativeBuffer)localObject1).buf;
          i = m;
          j = k;
          paramIJsService = paramJSONObject;
          if (m == -1)
          {
            i = paramJSONObject.length;
            j = k;
            paramIJsService = paramJSONObject;
          }
        }
      }
      paramJSONObject = validAddress(str, n, bool);
      if (paramJSONObject == null)
      {
        paramIJsService = "invalid address :[" + str + "]";
        QMLog.d("UDPPlugin", paramIJsService);
        callbackError(paramIJsService, paramUDPTask.taskId);
        return;
      }
      if (paramIJsService == null)
      {
        callbackError("undefined message", paramUDPTask.taskId);
        return;
      }
      if ((j < 0) || (j >= i))
      {
        callbackError("invalid offset", paramUDPTask.taskId);
        return;
      }
      if (i > paramIJsService.length)
      {
        callbackError("invalid length", paramUDPTask.taskId);
        return;
      }
      paramUDPTask.send(paramIJsService, j, i, new InetSocketAddress(paramJSONObject, n));
      return;
    }
  }
  
  @JsEvent({"createUDPTask"})
  public String createUDPTask(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      UDPJsPlugin.UDPTask localUDPTask = new UDPJsPlugin.UDPTask(this, paramRequestEvent.jsService);
      this.mTaskRegistry.put(localUDPTask.taskId, localUDPTask);
      localJSONObject.put("udpTaskId", localUDPTask.taskId);
      return ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
    }
    catch (Exception localException)
    {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject, localException.getMessage()).toString();
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
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = ((JSONObject)localObject).optString("operation");
      int i = ((JSONObject)localObject).optInt("udpTaskId");
      UDPJsPlugin.UDPTask localUDPTask = (UDPJsPlugin.UDPTask)this.mTaskRegistry.get(i);
      if (localUDPTask != null)
      {
        if ("bind".equals(str))
        {
          localJSONObject.put("port", localUDPTask.bind());
          return ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
        }
        if ("close".equals(str))
        {
          localUDPTask.close();
          this.mTaskRegistry.remove(i);
          return ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
        }
        if ("send".equals(str)) {
          ThreadManager.executeOnNetworkIOThreadPool(new UDPJsPlugin.1(this, paramRequestEvent, (JSONObject)localObject, localUDPTask));
        }
        return "";
      }
      localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject, "task already closed").toString();
      return localObject;
    }
    catch (Exception localException)
    {
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject, localException.getMessage()).toString();
    }
  }
  
  @Nullable
  @VisibleForTesting
  public InetAddress validAddress(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((IPV4_ADDRESS_REGEX.matcher(paramString).matches()) || (IPV6_ADDRESS_REGEX.matcher(paramString).matches())) {
      return getInetAddressByIp(paramString, paramBoolean);
    }
    return getInetAddressByDomain(paramString, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UDPJsPlugin
 * JD-Core Version:    0.7.0.1
 */