package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IVasQuickUpdateService
  extends IRuntimeService
{
  public abstract void addCallBacker(CallBacker paramCallBacker);
  
  public abstract void addWeakCallback(CallBacker paramCallBacker);
  
  public abstract void callBackToAll(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void cancelDwonloadItem(long paramLong, String paramString);
  
  public abstract void cleanCache();
  
  public abstract void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2);
  
  public abstract void downloadItem(long paramLong, String paramString1, String paramString2);
  
  public abstract BaseUpdateBusiness getBusinessCallback(long paramLong);
  
  public abstract <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass);
  
  public abstract void onProgressToAll(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3);
  
  public abstract void queryItemVersion(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, QueryItemCallback paramQueryItemCallback);
  
  public abstract void removeCallBacker(CallBacker paramCallBacker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
 * JD-Core Version:    0.7.0.1
 */