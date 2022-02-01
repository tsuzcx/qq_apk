package com.tencent.vas.update.module.api;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.ICmdListener;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.DownloadResultParams;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import java.util.HashMap;

public abstract interface IVasUpdateSystem
  extends ICmdListener, ITimerListener
{
  public abstract IBusinessCallback a(long paramLong);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, HashMap<String, ItemUpdateVerPtr> paramHashMap);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(BusinessUpdateParams paramBusinessUpdateParams);
  
  public abstract void a(BusinessUpdateParams paramBusinessUpdateParams, long paramLong1, long paramLong2, int paramInt);
  
  public abstract void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams, DownloadResultParams paramDownloadResultParams, DLReportInfo paramDLReportInfo);
  
  public abstract void a(INotificationModule paramINotificationModule);
  
  public abstract IDownloadModule b();
  
  public abstract void b(BusinessUpdateParams paramBusinessUpdateParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.api.IVasUpdateSystem
 * JD-Core Version:    0.7.0.1
 */