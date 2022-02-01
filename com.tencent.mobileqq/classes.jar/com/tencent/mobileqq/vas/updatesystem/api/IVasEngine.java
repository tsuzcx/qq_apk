package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IVasEngine
  extends IRuntimeService
{
  public abstract void cancelDwonloadItem(long paramLong, String paramString);
  
  public abstract void cancelQuery(QueryItemVersionCallback paramQueryItemVersionCallback);
  
  public abstract void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2);
  
  public abstract void downloadItem(long paramLong, String paramString1, String paramString2);
  
  public abstract BaseUpdateBusiness getBusinessCallback(long paramLong);
  
  public abstract <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass);
  
  public abstract void onPbMsgRecv(int paramInt, String paramString1, String paramString2);
  
  public abstract void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, QueryItemVersionCallback paramQueryItemVersionCallback);
  
  public abstract void setRequestHandler(IVasApolloExtensionHandler paramIVasApolloExtensionHandler);
  
  public abstract void startUpdateAllItem();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.IVasEngine
 * JD-Core Version:    0.7.0.1
 */