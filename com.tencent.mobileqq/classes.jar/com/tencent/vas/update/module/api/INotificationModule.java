package com.tencent.vas.update.module.api;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessUpdateParams;

public abstract interface INotificationModule
{
  public abstract IBusinessCallback a(long paramLong);
  
  public abstract void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams);
  
  public abstract void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams, long paramLong1, long paramLong2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.api.INotificationModule
 * JD-Core Version:    0.7.0.1
 */