package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.pluginloaderservice.Plugin.Builder;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IGetInstallPlugins;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPlugin;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderServiceAdapter;
import com.tencent.ilivesdk.pluginloaderservice.report.DataReport;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginLoaderServiceAdapter
  implements IPluginLoaderServiceAdapter
{
  private static final String[] a = { "com.tencent.ilive.opensdk.plugin.OpenSdkImpl" };
  private final String b;
  private final ServiceAccessor c;
  private long d;
  
  public PluginLoaderServiceAdapter(ServiceAccessor paramServiceAccessor, String paramString)
  {
    this.b = paramString;
    this.c = paramServiceAccessor;
    this.d = ((LoginServiceInterface)paramServiceAccessor.getService(LoginServiceInterface.class)).getLoginInfo().uid;
  }
  
  private List<IPlugin> a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("data").optJSONObject("targetversion");
      if (paramJSONObject == null)
      {
        d().i("PluginLoaderService", "getToInstallPlugins: not new version.", new Object[0]);
        return localArrayList;
      }
      int j = paramJSONObject.optInt("versionno");
      paramJSONObject = paramJSONObject.optJSONArray("content");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        Plugin.Builder localBuilder = new Plugin.Builder().d("iLiveOpenSdk").a(localJSONObject.optString("url"));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append("/iLiveOpenSdk");
        localArrayList.add(localBuilder.b(localStringBuilder.toString()).c("/data/local/tmp/iLiveOpenSdk.zip").b(6).a(j).e(localJSONObject.optString("hash")).a(new String[] { "lib/armeabi/" }).b(a).a());
        i += 1;
      }
      DataReport.c(String.valueOf(j));
      return localArrayList;
    }
    catch (NullPointerException paramJSONObject)
    {
      paramJSONObject = String.format("getToInstallPlugins: NullPointerException[%s]", new Object[] { paramJSONObject.getMessage() });
      DataReport.b(paramJSONObject);
      d().i("PluginLoaderService", paramJSONObject, new Object[0]);
      return localArrayList;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject = String.format("getToInstallPlugins: JSONException[%s]", new Object[] { paramJSONObject.getMessage() });
      DataReport.b(paramJSONObject);
      d().i("PluginLoaderService", paramJSONObject, new Object[0]);
    }
    return localArrayList;
  }
  
  public DownLoaderInterface a()
  {
    return (DownLoaderInterface)this.c.getService(DownLoaderInterface.class);
  }
  
  public void a(IGetInstallPlugins paramIGetInstallPlugins)
  {
    if (paramIGetInstallPlugins == null)
    {
      d().e("PluginLoaderService", "getInstallPlugins: iGetInstallPlugins is null.", new Object[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("apptype", "opensdk");
    localHashMap.put("platform", "2");
    localHashMap.put("mode", "1");
    localHashMap.put("frameversion", String.valueOf(6));
    localHashMap.put("cursdkversion", "0");
    localHashMap.put("uin", String.valueOf(this.d));
    e().post("https://now.qq.com/cgi-bin/now/web/version/now_ver", localHashMap, new PluginLoaderServiceAdapter.1(this, paramIGetInstallPlugins));
  }
  
  public ExecutorService b()
  {
    return null;
  }
  
  public DataReportInterface c()
  {
    return (DataReportInterface)this.c.getService(DataReportInterface.class);
  }
  
  public LogInterface d()
  {
    return (LogInterface)this.c.getService(LogInterface.class);
  }
  
  public HttpInterface e()
  {
    return (HttpInterface)this.c.getService(HttpInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.PluginLoaderServiceAdapter
 * JD-Core Version:    0.7.0.1
 */