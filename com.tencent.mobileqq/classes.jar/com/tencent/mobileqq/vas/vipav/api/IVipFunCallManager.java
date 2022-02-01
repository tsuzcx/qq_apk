package com.tencent.mobileqq.vas.vipav.api;

import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface IVipFunCallManager
  extends IVasManager
{
  public abstract boolean downloadFCSuit(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, IPCDownloadListener paramIPCDownloadListener);
  
  public abstract void setFunCallData(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2, int paramInt3, List<Long> paramList, long paramLong);
  
  public abstract void startDownload(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager
 * JD-Core Version:    0.7.0.1
 */