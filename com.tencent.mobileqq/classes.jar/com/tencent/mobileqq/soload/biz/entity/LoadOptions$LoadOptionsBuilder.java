package com.tencent.mobileqq.soload.biz.entity;

public class LoadOptions$LoadOptionsBuilder
{
  private LoadOptions a = new LoadOptions();
  
  public LoadOptionsBuilder a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x1;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFFE;
    return this;
  }
  
  public LoadOptions a()
  {
    return this.a;
  }
  
  public LoadOptionsBuilder b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x8;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFF7;
    return this;
  }
  
  public LoadOptionsBuilder c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x10;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFEF;
    return this;
  }
  
  public LoadOptionsBuilder d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLoadOptions = this.a;
      localLoadOptions.flag |= 0x20;
      return this;
    }
    LoadOptions localLoadOptions = this.a;
    localLoadOptions.flag &= 0xFFFFFFDF;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.LoadOptions.LoadOptionsBuilder
 * JD-Core Version:    0.7.0.1
 */