package com.tencent.mobileqq.fts.api;

import com.tencent.mobileqq.fts.interfaces.IFTSConfig;
import com.tencent.mobileqq.fts.interfaces.IFTSOperator;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IFTSDBRuntimeService
  extends IRuntimeService
{
  public abstract void clearFTS();
  
  public abstract void clearFTS(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean);
  
  public abstract long getDBSize();
  
  public abstract boolean getEnable();
  
  public abstract IFTSConfig getIFTSConfig();
  
  public abstract IFTSOperator getOperator(int paramInt);
  
  public abstract boolean hasInit();
  
  public abstract void initWithDPC();
  
  public abstract void refreshFTS(int paramInt);
  
  public abstract void setDPCFlag(int paramInt);
  
  public abstract void setENABLE(boolean paramBoolean);
  
  public abstract void setIFTSConfig(IFTSConfig paramIFTSConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.api.IFTSDBRuntimeService
 * JD-Core Version:    0.7.0.1
 */