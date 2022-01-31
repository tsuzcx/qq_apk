package com.tencent.tissue.miniapp.hdasync;

public class BaseResult
{
  protected boolean needNext = false;
  protected Object value;
  
  protected BaseResult(boolean paramBoolean, Object paramObject)
  {
    this.needNext = paramBoolean;
    this.value = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.hdasync.BaseResult
 * JD-Core Version:    0.7.0.1
 */