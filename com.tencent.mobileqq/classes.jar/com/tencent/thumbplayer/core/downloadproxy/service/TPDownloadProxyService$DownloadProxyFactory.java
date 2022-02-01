package com.tencent.thumbplayer.core.downloadproxy.service;

import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import java.util.HashMap;

class TPDownloadProxyService$DownloadProxyFactory
  extends TPDownloadProxyFactoryAidl.Stub
{
  private HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap = new HashMap();
  
  private TPDownloadProxyService$DownloadProxyFactory(TPDownloadProxyService paramTPDownloadProxyService) {}
  
  public String getNativeVersion()
  {
    return TPDownloadProxyFactory.getNativeVersion();
  }
  
  public ITPDownloadProxyAidl getTPDownloadProxy(int paramInt)
  {
    try
    {
      ITPDownloadProxyAidl localITPDownloadProxyAidl = (ITPDownloadProxyAidl)this.mvTPDownloadProxyMap.get(Integer.valueOf(paramInt));
      Object localObject1 = localITPDownloadProxyAidl;
      if (localITPDownloadProxyAidl == null)
      {
        localObject1 = new TPDownloadProxyService.DownloadProxy(this.this$0, paramInt);
        this.mvTPDownloadProxyMap.put(Integer.valueOf(paramInt), localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  public boolean isReadyForDownload()
  {
    return TPDownloadProxyFactory.isReadyForDownload();
  }
  
  public boolean isReadyForPlay()
  {
    return TPDownloadProxyFactory.isReadyForPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService.DownloadProxyFactory
 * JD-Core Version:    0.7.0.1
 */