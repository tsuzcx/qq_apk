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
    this.soFileName = ("lib" + paramString + ".so");
    if (paramLoadOptions != null)
    {
      this.lops = paramLoadOptions;
      return;
    }
    this.lops = new LoadOptions.LoadOptionsBuilder().a();
  }
  
  public boolean isSame(LoadItem paramLoadItem)
  {
    if (paramLoadItem == null) {}
    while (!SoDataUtil.a(paramLoadItem.name, this.name)) {
      return false;
    }
    return this.lops.isSame(paramLoadItem.lops);
  }
  
  public String toString()
  {
    return "LoadItem{name='" + this.name + '\'' + ", lops=" + this.lops + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem
 * JD-Core Version:    0.7.0.1
 */