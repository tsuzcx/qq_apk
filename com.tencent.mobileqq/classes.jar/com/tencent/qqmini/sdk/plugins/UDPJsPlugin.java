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
    SharedPreferences localSharedPreferences = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_debug");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  @Nullable
  private InetAddress getInetAddress(@NonNull String paramString)
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(paramString);
      return localInetAddress;
    }
    catch (SecurityException localSecurityException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInetAddress address:");
      localStringBuilder.append(paramString);
      QMLog.d("UDPPlugin", localStringBuilder.toString(), localSecurityException);
    }
    catch (UnknownHostException localUnknownHostException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInetAddress address:");
      localStringBuilder.append(paramString);
      QMLog.d("UDPPlugin", localStringBuilder.toString(), localUnknownHostException);
    }
    return null;
  }
  
  @Nullable
  private InetAddress getInetAddressByDomain(@NonNull String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (DomainUtil.isDomainValid(getMiniAppInfo(), paramBoolean, (String)localObject, 5)) {
      return getInetAddress(paramString);
    }
    return null;
  }
  
  @Nullable
  private InetAddress getInetAddressByIp(@NonNull String paramString, boolean paramBoolean)
  {
    InetAddress localInetAddress = getInetAddress(paramString);
    if (localInetAddress == null) {
      return null;
    }
    if (localInetAddress.isLoopbackAddress()) {
      return null;
    }
    if (localInetAddress.isAnyLocalAddress()) {
      return null;
    }
    if (localInetAddress.isMulticastAddress()) {
      return null;
    }
    if (localInetAddress.isSiteLocalAddress()) {
      return localInetAddress;
    }
    if (!paramBoolean)
    {
      if (isUdpIpValid(paramString)) {
        return localInetAddress;
      }
      return null;
    }
    return localInetAddress;
  }
  
  private void performSend(IJsService paramIJsService, JSONObject paramJSONObject, UDPJsPlugin.UDPTask paramUDPTask)
  {
    int k = paramJSONObject.optInt("port", -1);
    boolean bool = paramJSONObject.isNull("message");
    Object localObject2 = null;
    if (!bool) {
      localObject1 = paramJSONObject.optString("message", null);
    } else {
      localObject1 = null;
    }
    int i;
    int j;
    if (localObject1 != null)
    {
      paramIJsService = ((String)localObject1).getBytes("UTF-8");
      i = paramIJsService.length;
      j = 0;
    }
    else
    {
      localObject1 = NativeBuffer.unpackNativeBuffer(paramIJsService, paramJSONObject, "message");
      j = paramJSONObject.optInt("offset");
      i = paramJSONObject.optInt("length", -1);
      paramIJsService = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((NativeBuffer)localObject1).buf;
        paramIJsService = (IJsService)localObject1;
        if (i == -1)
        {
          i = localObject1.length;
          paramIJsService = (IJsService)localObject1;
        }
      }
    }
    if (k < 0)
    {
      callbackError("invalid port", paramUDPTask.taskId);
      return;
    }
    Object localObject1 = paramJSONObject.optString("address");
    paramJSONObject = validAddress((String)localObject1, k, paramJSONObject.optBoolean("__skipDomainCheck__", false));
    if (paramJSONObject == null)
    {
      paramIJsService = new StringBuilder();
      paramIJsService.append("invalid address :[");
      paramIJsService.append((String)localObject1);
      paramIJsService.append("]");
      paramIJsService = paramIJsService.toString();
      QMLog.d("UDPPlugin", paramIJsService);
      callbackError(paramIJsService, paramUDPTask.taskId);
      return;
    }
    if (paramIJsService == null)
    {
      callbackError("undefined message", paramUDPTask.taskId);
      return;
    }
    if ((j >= 0) && (j < i))
    {
      if (i > paramIJsService.length)
      {
        callbackError("invalid length", paramUDPTask.taskId);
        return;
      }
      paramUDPTask.send(paramIJsService, j, i, new InetSocketAddress(paramJSONObject, k));
      return;
    }
    callbackError("invalid offset", paramUDPTask.taskId);
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
    Object localObject = getMiniAppInfo();
    if (localObject == null) {
      return false;
    }
    if (((MiniAppInfo)localObject).skipDomainCheck == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("udp ip检查 skip: ");
      ((StringBuilder)localObject).append(paramString);
      QMLog.d("[mini] http.udp", ((StringBuilder)localObject).toString());
      return true;
    }
    if ((((MiniAppInfo)localObject).verType != 3) && (getEnableDebug(((MiniAppInfo)localObject).appId)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("debug opened and not online version, skip:");
      ((StringBuilder)localObject).append(paramString);
      QMLog.d("[mini] http.udp", ((StringBuilder)localObject).toString());
      return true;
    }
    if (this.mUdpIpWhiteSet == null) {
      try
      {
        if (this.mUdpIpWhiteSet == null) {
          this.mUdpIpWhiteSet = new HashSet(((MiniAppInfo)localObject).udpIpList);
        }
      }
      finally {}
    }
    return this.mUdpIpWhiteSet.contains(paramString);
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
    if ((!IPV4_ADDRESS_REGEX.matcher(paramString).matches()) && (!IPV6_ADDRESS_REGEX.matcher(paramString).matches())) {
      return getInetAddressByDomain(paramString, paramInt, paramBoolean);
    }
    return getInetAddressByIp(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UDPJsPlugin
 * JD-Core Version:    0.7.0.1
 */