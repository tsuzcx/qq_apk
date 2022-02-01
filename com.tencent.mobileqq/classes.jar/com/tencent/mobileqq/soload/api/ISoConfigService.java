package com.tencent.mobileqq.soload.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import eipc.EIPCResult;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface ISoConfigService
  extends QRouteApi
{
  public abstract int getConfigId();
  
  public abstract Map<String, SoInfo> getSoInfos();
  
  public abstract void getSoLoadInfoAsync(Bundle paramBundle, OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener);
  
  public abstract EIPCResult getSoLoadInfoSync(Bundle paramBundle);
  
  public abstract void notifyNetFailed(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg);
  
  public abstract void removeSoInfo(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.ISoConfigService
 * JD-Core Version:    0.7.0.1
 */