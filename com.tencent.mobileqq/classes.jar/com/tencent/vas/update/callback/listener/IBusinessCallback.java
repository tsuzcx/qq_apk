package com.tencent.vas.update.callback.listener;

import androidx.annotation.NonNull;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;

public abstract interface IBusinessCallback
  extends IUpdateListener
{
  public abstract void deleteFile(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo);
  
  public abstract long getBid();
  
  public abstract BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString);
  
  public abstract String getFrom();
  
  public abstract boolean isFileExist(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.callback.listener.IBusinessCallback
 * JD-Core Version:    0.7.0.1
 */