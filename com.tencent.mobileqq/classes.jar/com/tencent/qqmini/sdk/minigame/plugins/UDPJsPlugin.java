package com.tencent.qqmini.sdk.minigame.plugins;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import bgok;
import bgpi;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.StorageUtil;
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
  
  private void handleTaskOperation(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString, int paramInt, UDPJsPlugin.UDPTask paramUDPTask)
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
  
  private void performSend(JSONObject paramJSONObject1, JSONObject paramJSONObject2, UDPJsPlugin.UDPTask paramUDPTask)
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
        QMLog.d("UDPPlugin", "invalid address :[" + str + "]");
        return;
        localObject1 = bgpi.a(this.mMiniAppContext, paramJSONObject2, "message");
        int k = paramJSONObject2.optInt("offset");
        int m = paramJSONObject2.optInt("length", -1);
        i = m;
        j = k;
        paramJSONObject2 = localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((bgpi)localObject1).a;
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
  
  public String createUDPTask(bgok parambgok)
  {
    parambgok = new JSONObject();
    try
    {
      UDPJsPlugin.UDPTask localUDPTask = new UDPJsPlugin.UDPTask(this);
      this.mTaskRegistry.put(localUDPTask.taskId, localUDPTask);
      parambgok.put("udpTaskId", localUDPTask.taskId);
      return parambgok.toString();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          parambgok.put("errMsg", localIOException.getMessage());
        }
        catch (JSONException localJSONException1) {}
      }
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        try
        {
          parambgok.put("errMsg", localJSONException2.getMessage());
        }
        catch (JSONException localJSONException3) {}
      }
    }
  }
  
  public boolean isUdpIpValid(String paramString)
  {
    if (this.mMiniAppInfo == null) {
      return false;
    }
    if (this.mMiniAppInfo.skipDomainCheck == 1)
    {
      QMLog.d("[mini] http.udp", "udp ip检查 skip: " + paramString);
      return true;
    }
    if ((this.mMiniAppInfo.verType != 3) && (getEnableDebug(this.mMiniAppInfo.appId)))
    {
      QMLog.d("[mini] http.udp", "debug opened and not online version, skip:" + paramString);
      return true;
    }
    if (this.mUdpIpWhiteSet == null) {}
    try
    {
      if (this.mUdpIpWhiteSet == null) {
        this.mUdpIpWhiteSet = new HashSet(this.mMiniAppInfo.udpIpList);
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
  
  public String operateUDPTask(bgok parambgok)
  {
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        parambgok = new JSONObject(parambgok.b);
        String str = parambgok.optString("operation");
        int i = parambgok.optInt("udpTaskId");
        UDPJsPlugin.UDPTask localUDPTask = (UDPJsPlugin.UDPTask)this.mTaskRegistry.get(i);
        if (localUDPTask == null) {
          continue;
        }
        handleTaskOperation(localJSONObject, parambgok, str, i, localUDPTask);
        parambgok = localJSONObject.optString("errMsg", null);
        if (parambgok != null) {
          callbackError(parambgok, i);
        }
      }
      catch (IOException parambgok)
      {
        try
        {
          localJSONObject.put("errMsg", parambgok.getMessage());
        }
        catch (JSONException parambgok) {}
        continue;
      }
      catch (JSONException parambgok)
      {
        try
        {
          localJSONObject.put("errMsg", parambgok.getMessage());
        }
        catch (JSONException parambgok) {}
        continue;
      }
      return localJSONObject.toString();
      localJSONObject.put("errMsg", "task already closed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.UDPJsPlugin
 * JD-Core Version:    0.7.0.1
 */