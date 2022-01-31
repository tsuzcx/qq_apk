package com.tencent.proxyinner.plugin.Downloader;

import com.tencent.proxyinner.log.XLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateParam
{
  public static int TYPE_LOADER = 1;
  public int curSdkVersion;
  public boolean curVersionExit;
  private HashMap<Integer, ApkParam> curVersionParam = new HashMap();
  public int errorCode;
  public int lazyTime;
  public int loadRetry = 1;
  public int newSdkVersion;
  public boolean newVersionExit;
  private HashMap<Integer, ApkParam> tagVersionParam = new HashMap();
  
  public UpdateParam()
  {
    XLog.i("XProxy|UpdateParam", "new UpdateParam");
  }
  
  private JSONObject buildApkParam(ApkParam paramApkParam)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", Integer.toString(paramApkParam.type));
    localJSONObject.put("packagename", paramApkParam.name);
    localJSONObject.put("url", paramApkParam.apkZipUrl);
    localJSONObject.put("hash", paramApkParam.apkZipHash);
    localJSONObject.put("size", Integer.toString(paramApkParam.size));
    localJSONObject.put("enablepreload", paramApkParam.enablePreload);
    localJSONObject.put("downloadengine", Integer.toString(paramApkParam.downloadEngine));
    localJSONObject.put("loadtimeoutinterval", Integer.toString(paramApkParam.loadTimeoutInterval));
    return localJSONObject;
  }
  
  private String buildJson()
  {
    try
    {
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("errCode", this.errorCode);
      JSONObject localJSONObject1 = new JSONObject();
      ((JSONObject)localObject1).put("data", localJSONObject1);
      localJSONObject1.put("curversionexist", this.curVersionExit);
      localJSONObject1.put("newversionexist", this.newVersionExit);
      localJSONObject1.put("lazytime", this.lazyTime);
      String str = Integer.toString(this.newSdkVersion);
      localJSONObject1.put("newversionno", str);
      Object localObject2 = Integer.toString(this.curSdkVersion);
      localJSONObject1.put("curversionno", localObject2);
      if (this.curVersionExit)
      {
        JSONObject localJSONObject2 = new JSONObject();
        buildVersionArray(localJSONObject2, this.curVersionParam);
        localJSONObject1.put("curversion", localJSONObject2);
        localJSONObject2.put("versionno", localObject2);
      }
      if (this.newVersionExit)
      {
        localObject2 = new JSONObject();
        buildVersionArray((JSONObject)localObject2, this.tagVersionParam);
        localJSONObject1.put("targetversion", localObject2);
        ((JSONObject)localObject2).put("versionno", str);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (Exception localException)
    {
      return localException.toString();
    }
  }
  
  private void buildVersionArray(JSONObject paramJSONObject, HashMap<Integer, ApkParam> paramHashMap)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext()) {
      localJSONArray.put(buildApkParam((ApkParam)paramHashMap.next()));
    }
    paramJSONObject.put("content", localJSONArray);
  }
  
  private ApkParam parseApkParam(JSONObject paramJSONObject)
    throws JSONException
  {
    ApkParam localApkParam = new ApkParam();
    localApkParam.type = Integer.parseInt(paramJSONObject.getString("type"));
    localApkParam.name = paramJSONObject.getString("packageName");
    localApkParam.apkZipUrl = paramJSONObject.getString("url");
    localApkParam.apkZipHash = paramJSONObject.getString("hash");
    localApkParam.size = Integer.parseInt(paramJSONObject.getString("size"));
    localApkParam.enablePreload = paramJSONObject.getBoolean("enablepreload");
    localApkParam.downloadEngine = Integer.parseInt(paramJSONObject.getString("downloadengine"));
    return localApkParam;
  }
  
  private void parseVersionArray(HashMap<Integer, ApkParam> paramHashMap, JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONArray("content");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      ApkParam localApkParam = parseApkParam(paramJSONObject.getJSONObject(i));
      paramHashMap.put(Integer.valueOf(localApkParam.type), localApkParam);
      i += 1;
    }
  }
  
  public boolean fromJson(String paramString)
  {
    return update(paramString) == null;
  }
  
  public ApkParam getCurApkParam(int paramInt)
  {
    return (ApkParam)this.curVersionParam.get(Integer.valueOf(paramInt));
  }
  
  public int getCurSdkVersion()
  {
    return this.curSdkVersion;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public ApkParam getFirstCurParam()
  {
    Object localObject = (ApkParam)this.curVersionParam.get(Integer.valueOf(1));
    if (localObject != null) {
      return localObject;
    }
    localObject = this.curVersionParam.values().iterator();
    if (((Iterator)localObject).hasNext()) {
      return (ApkParam)((Iterator)localObject).next();
    }
    return null;
  }
  
  public ApkParam getFirstTagParam()
  {
    Object localObject = (ApkParam)this.tagVersionParam.get(Integer.valueOf(1));
    if (localObject != null) {
      return localObject;
    }
    localObject = this.tagVersionParam.values().iterator();
    if (((Iterator)localObject).hasNext()) {
      return (ApkParam)((Iterator)localObject).next();
    }
    return null;
  }
  
  public int getLazyTime()
  {
    return this.lazyTime;
  }
  
  public int getNewSdkVersion()
  {
    return this.newSdkVersion;
  }
  
  public ApkParam getTagApkParam(int paramInt)
  {
    return (ApkParam)this.tagVersionParam.get(Integer.valueOf(paramInt));
  }
  
  public boolean isCurVersionExit()
  {
    return this.curVersionExit;
  }
  
  public boolean isNewVersionExit()
  {
    return this.newVersionExit;
  }
  
  public void setCurSdkVersion(int paramInt)
  {
    this.curSdkVersion = paramInt;
  }
  
  public void setCurVersionExit(boolean paramBoolean)
  {
    this.curVersionExit = paramBoolean;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setLazyTime(int paramInt)
  {
    this.lazyTime = paramInt;
  }
  
  public void setNewSdkVersion(int paramInt)
  {
    this.newSdkVersion = paramInt;
  }
  
  public void setNewVersionExit(boolean paramBoolean)
  {
    this.newVersionExit = paramBoolean;
  }
  
  public String toJson()
  {
    return buildJson();
  }
  
  public String update(String paramString)
  {
    XLog.i("XProxy|UpdateParam", "updateParam,strJson = " + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.errorCode = paramString.getInt("errCode");
      paramString = paramString.getJSONObject("data");
      this.curVersionExit = paramString.getBoolean("curversionexist");
      this.newVersionExit = paramString.getBoolean("newversionexist");
      this.lazyTime = paramString.getInt("lazytime");
      try
      {
        this.loadRetry = paramString.getInt("load_retry");
        XLog.i("XProxy|UpdateParam", "load retry: " + this.loadRetry);
        JSONObject localJSONObject;
        if (this.curVersionExit)
        {
          localJSONObject = paramString.getJSONObject("curversion");
          parseVersionArray(this.curVersionParam, localJSONObject);
          this.curSdkVersion = Integer.parseInt(paramString.getString("curversionno"));
        }
        if (this.newVersionExit)
        {
          localJSONObject = paramString.getJSONObject("targetversion");
          parseVersionArray(this.tagVersionParam, localJSONObject);
          this.newSdkVersion = Integer.parseInt(paramString.getString("newversionno"));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      return paramString.toString();
    }
  }
  
  public class ApkParam
  {
    public String apkZipHash;
    public String apkZipUrl;
    public int downloadEngine;
    public boolean enablePreload;
    public int loadTimeoutInterval;
    public String name;
    public int size;
    public int type;
    
    public ApkParam() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.Downloader.UpdateParam
 * JD-Core Version:    0.7.0.1
 */