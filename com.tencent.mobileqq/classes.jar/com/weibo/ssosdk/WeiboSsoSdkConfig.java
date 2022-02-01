package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiboSsoSdkConfig
  implements Cloneable
{
  private Context appContext;
  private String appKey = "";
  private HashMap<String, String> extra = new HashMap();
  private String from = "";
  private String oldwm = "";
  private String smApiKey = "";
  private String smid = "";
  private String sub = "";
  private String wm = "";
  
  private String urlEncode(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label9:
      break label9;
    }
    return "";
  }
  
  public void addExtra(String paramString1, String paramString2)
  {
    this.extra.put(paramString1, paramString2);
  }
  
  public Object clone()
  {
    try
    {
      WeiboSsoSdkConfig localWeiboSsoSdkConfig = (WeiboSsoSdkConfig)super.clone();
      HashMap localHashMap = new HashMap();
      Iterator localIterator = localWeiboSsoSdkConfig.extra.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      localWeiboSsoSdkConfig.extra = localHashMap;
      return localWeiboSsoSdkConfig;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label78:
      break label78;
    }
    return null;
  }
  
  public String getAppKey(boolean paramBoolean)
  {
    if (paramBoolean) {
      return urlEncode(this.appKey);
    }
    return this.appKey;
  }
  
  public Context getApplicationContext()
  {
    return this.appContext;
  }
  
  public String getExtraString(boolean paramBoolean)
  {
    if (this.extra.isEmpty()) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = this.extra.entrySet().iterator();
    for (;;)
    {
      Map.Entry localEntry;
      if (localIterator.hasNext()) {
        localEntry = (Map.Entry)localIterator.next();
      }
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException) {}
    }
    if (paramBoolean) {
      return urlEncode(localJSONObject.toString());
    }
    return localJSONObject.toString();
    return "";
  }
  
  public String getFrom(boolean paramBoolean)
  {
    if (paramBoolean) {
      return urlEncode(this.from);
    }
    return this.from;
  }
  
  public String getOldWm(boolean paramBoolean)
  {
    if (paramBoolean) {
      return urlEncode(this.oldwm);
    }
    return this.oldwm;
  }
  
  public String getSmApiKey()
  {
    return this.smApiKey;
  }
  
  public String getSmid(boolean paramBoolean)
  {
    if (paramBoolean) {
      return urlEncode(this.smid);
    }
    return this.smid;
  }
  
  public String getSub(boolean paramBoolean)
  {
    if (paramBoolean) {
      return urlEncode(this.sub);
    }
    return this.sub;
  }
  
  public String getWm(boolean paramBoolean)
  {
    if (paramBoolean) {
      return urlEncode(this.wm);
    }
    return this.wm;
  }
  
  public void setAppKey(String paramString)
  {
    this.appKey = paramString;
  }
  
  public void setContext(Context paramContext)
  {
    this.appContext = paramContext.getApplicationContext();
  }
  
  public void setFrom(String paramString)
  {
    this.from = paramString;
  }
  
  public void setOldWm(String paramString)
  {
    this.oldwm = paramString;
  }
  
  public void setSmApiKey(String paramString)
  {
    this.smApiKey = paramString;
  }
  
  public void setSmid(String paramString)
  {
    this.smid = paramString;
  }
  
  public void setSub(String paramString)
  {
    this.sub = paramString;
  }
  
  public void setWm(String paramString)
  {
    this.wm = paramString;
  }
  
  public boolean verify()
  {
    return (this.appContext != null) && (!TextUtils.isEmpty(this.appKey)) && (!TextUtils.isEmpty(this.from)) && (!TextUtils.isEmpty(this.wm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdkConfig
 * JD-Core Version:    0.7.0.1
 */