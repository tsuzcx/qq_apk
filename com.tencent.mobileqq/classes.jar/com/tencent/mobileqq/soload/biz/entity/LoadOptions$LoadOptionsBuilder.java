package com.tencent.mobileqq.soload.biz.entity;

public class LoadOptions$LoadOptionsBuilder
{
  private LoadOptions mLoadOptions = new LoadOptions();
  
  public LoadOptions build()
  {
    return this.mLoadOptions;
  }
  
  public LoadOptionsBuilder setCloseReport(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.mLoadOptions;
      localLoadOptions.flag |= 0x20;
      return this;
    }
    LoadOptions localLoadOptions = this.mLoadOptions;
    localLoadOptions.flag &= 0xFFFFFFDF;
    return this;
  }
  
  public LoadOptionsBuilder setCloseRetry(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.mLoadOptions;
      localLoadOptions.flag |= 0x10;
      return this;
    }
    LoadOptions localLoadOptions = this.mLoadOptions;
    localLoadOptions.flag &= 0xFFFFFFEF;
    return this;
  }
  
  @Deprecated
  public LoadOptionsBuilder setExtFlag(int paramInt)
  {
    LoadOptions localLoadOptions = this.mLoadOptions;
    localLoadOptions.flag = (paramInt | localLoadOptions.flag);
    return this;
  }
  
  public LoadOptionsBuilder setIsLoadLastSuccWhenFail(boolean paramBoolean)
  {
    this.mLoadOptions.isLoadLastSuccWhenFail = paramBoolean;
    return this;
  }
  
  public LoadOptionsBuilder setIsNoNeedCRC(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.mLoadOptions;
      localLoadOptions.flag |= 0x8;
      return this;
    }
    LoadOptions localLoadOptions = this.mLoadOptions;
    localLoadOptions.flag &= 0xFFFFFFF7;
    return this;
  }
  
  public LoadOptionsBuilder setIsNoNeedLoad(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.mLoadOptions;
      localLoadOptions.flag |= 0x1;
      return this;
    }
    LoadOptions localLoadOptions = this.mLoadOptions;
    localLoadOptions.flag &= 0xFFFFFFFE;
    return this;
  }
  
  public LoadOptionsBuilder setOldSoPathFor32Bit(String paramString)
  {
    this.mLoadOptions.oldSoPathFor32Bit = paramString;
    return this;
  }
  
  public LoadOptionsBuilder setOldSoPathFor64Bit(String paramString)
  {
    this.mLoadOptions.oldSoPathFor64Bit = paramString;
    return this;
  }
  
  public LoadOptionsBuilder setWeakRelated(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.mLoadOptions;
      localLoadOptions.flag |= 0x4;
      return this;
    }
    LoadOptions localLoadOptions = this.mLoadOptions;
    localLoadOptions.flag &= 0xFFFFFFFB;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.LoadOptions.LoadOptionsBuilder
 * JD-Core Version:    0.7.0.1
 */