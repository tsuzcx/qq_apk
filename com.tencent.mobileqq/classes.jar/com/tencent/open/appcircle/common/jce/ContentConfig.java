package com.tencent.open.appcircle.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.HashMap;
import java.util.Map;

public final class ContentConfig
  extends JceStruct
  implements Cloneable
{
  static Map cache_interfaceMap;
  static Map cache_pageExtMap;
  public String appNewsUrl = "";
  public Map interfaceMap;
  public int interval;
  public int logInterval;
  public Map pageExtMap;
  public int resourceVersion;
  public int totalConfig;
  
  static
  {
    if (!ContentConfig.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_interfaceMap = new HashMap();
      cache_interfaceMap.put("", Integer.valueOf(0));
      cache_pageExtMap = new HashMap();
      cache_pageExtMap.put("", "");
      return;
    }
  }
  
  public ContentConfig() {}
  
  public ContentConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Map paramMap1, Map paramMap2, String paramString)
  {
    this.totalConfig = paramInt1;
    this.resourceVersion = paramInt2;
    this.interval = paramInt3;
    this.logInterval = paramInt4;
    this.interfaceMap = paramMap1;
    this.pageExtMap = paramMap2;
    this.appNewsUrl = paramString;
  }
  
  public String className()
  {
    return "jce.ContentConfig";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.totalConfig, "totalConfig");
    paramStringBuilder.display(this.resourceVersion, "resourceVersion");
    paramStringBuilder.display(this.interval, "interval");
    paramStringBuilder.display(this.logInterval, "logInterval");
    paramStringBuilder.display(this.interfaceMap, "interfaceMap");
    paramStringBuilder.display(this.pageExtMap, "pageExtMap");
    paramStringBuilder.display(this.appNewsUrl, "appNewsUrl");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.totalConfig, true);
    paramStringBuilder.displaySimple(this.resourceVersion, true);
    paramStringBuilder.displaySimple(this.interval, true);
    paramStringBuilder.displaySimple(this.logInterval, true);
    paramStringBuilder.displaySimple(this.interfaceMap, true);
    paramStringBuilder.displaySimple(this.pageExtMap, true);
    paramStringBuilder.displaySimple(this.appNewsUrl, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ContentConfig)paramObject;
    } while ((!JceUtil.equals(this.totalConfig, paramObject.totalConfig)) || (!JceUtil.equals(this.resourceVersion, paramObject.resourceVersion)) || (!JceUtil.equals(this.interval, paramObject.interval)) || (!JceUtil.equals(this.logInterval, paramObject.logInterval)) || (!JceUtil.equals(this.interfaceMap, paramObject.interfaceMap)) || (!JceUtil.equals(this.pageExtMap, paramObject.pageExtMap)) || (!JceUtil.equals(this.appNewsUrl, paramObject.appNewsUrl)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.open.appcircle.common.jce.ContentConfig";
  }
  
  public String getAppNewsUrl()
  {
    return this.appNewsUrl;
  }
  
  public Map getInterfaceMap()
  {
    return this.interfaceMap;
  }
  
  public int getInterval()
  {
    return this.interval;
  }
  
  public int getLogInterval()
  {
    return this.logInterval;
  }
  
  public Map getPageExtMap()
  {
    return this.pageExtMap;
  }
  
  public int getResourceVersion()
  {
    return this.resourceVersion;
  }
  
  public int getTotalConfig()
  {
    return this.totalConfig;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.totalConfig = paramJceInputStream.read(this.totalConfig, 0, true);
    this.resourceVersion = paramJceInputStream.read(this.resourceVersion, 1, true);
    this.interval = paramJceInputStream.read(this.interval, 2, true);
    this.logInterval = paramJceInputStream.read(this.logInterval, 3, false);
    this.interfaceMap = ((Map)paramJceInputStream.read(cache_interfaceMap, 4, false));
    this.pageExtMap = ((Map)paramJceInputStream.read(cache_pageExtMap, 5, false));
    this.appNewsUrl = paramJceInputStream.readString(6, false);
  }
  
  public void setAppNewsUrl(String paramString)
  {
    this.appNewsUrl = paramString;
  }
  
  public void setInterfaceMap(Map paramMap)
  {
    this.interfaceMap = paramMap;
  }
  
  public void setInterval(int paramInt)
  {
    this.interval = paramInt;
  }
  
  public void setLogInterval(int paramInt)
  {
    this.logInterval = paramInt;
  }
  
  public void setPageExtMap(Map paramMap)
  {
    this.pageExtMap = paramMap;
  }
  
  public void setResourceVersion(int paramInt)
  {
    this.resourceVersion = paramInt;
  }
  
  public void setTotalConfig(int paramInt)
  {
    this.totalConfig = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.totalConfig, 0);
    paramJceOutputStream.write(this.resourceVersion, 1);
    paramJceOutputStream.write(this.interval, 2);
    paramJceOutputStream.write(this.logInterval, 3);
    if (this.interfaceMap != null) {
      paramJceOutputStream.write(this.interfaceMap, 4);
    }
    if (this.pageExtMap != null) {
      paramJceOutputStream.write(this.pageExtMap, 5);
    }
    if (this.appNewsUrl != null) {
      paramJceOutputStream.write(this.appNewsUrl, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcircle.common.jce.ContentConfig
 * JD-Core Version:    0.7.0.1
 */