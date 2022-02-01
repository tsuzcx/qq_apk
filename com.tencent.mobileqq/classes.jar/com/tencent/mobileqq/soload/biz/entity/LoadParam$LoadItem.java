package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.soload.util.SoDataUtil;
import java.io.Serializable;

public class LoadParam$LoadItem
  implements Serializable
{
  public LoadOptions lops;
  public String name;
  public String soFileName;
  
  public LoadParam$LoadItem(String paramString)
  {
    this(paramString, null);
  }
  
  public LoadParam$LoadItem(String paramString, LoadOptions paramLoadOptions)
  {
    this.name = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    this.soFileName = localStringBuilder.toString();
    if (paramLoadOptions != null)
    {
      this.lops = paramLoadOptions;
      return;
    }
    this.lops = new LoadOptions.LoadOptionsBuilder().build();
  }
  
  public boolean isSame(LoadItem paramLoadItem)
  {
    if (paramLoadItem == null) {
      return false;
    }
    if (!SoDataUtil.a(paramLoadItem.name, this.name)) {
      return false;
    }
    return this.lops.isSame(paramLoadItem.lops);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadItem{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lops=");
    localStringBuilder.append(this.lops);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem
 * JD-Core Version:    0.7.0.1
 */