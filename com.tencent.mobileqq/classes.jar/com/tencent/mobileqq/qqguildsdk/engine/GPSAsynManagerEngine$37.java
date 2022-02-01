package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.mobileqq.qqguildsdk.manager.AppChannelMgr;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchAppInfoListCallback;
import java.util.List;

class GPSAsynManagerEngine$37
  implements IFetchAppInfoListCallback
{
  GPSAsynManagerEngine$37(GPSAsynManagerEngine paramGPSAsynManagerEngine) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean, List<IAppInfo> paramList)
  {
    if ((paramInt == 0) && (paramBoolean))
    {
      this.a.h().a(paramList);
      this.a.a(51, "refreshAppInfoList", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.37
 * JD-Core Version:    0.7.0.1
 */