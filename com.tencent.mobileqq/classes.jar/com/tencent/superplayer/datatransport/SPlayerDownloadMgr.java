package com.tencent.superplayer.datatransport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.superplayer.utils.SPlayerUtils;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.datatransport.ITPProxyManagerAdapter;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import com.tencent.thumbplayer.datatransport.TPProxyUtils;

public class SPlayerDownloadMgr
{
  private ITPDownloadProxy mTPDownloadProxy;
  
  public SPlayerDownloadMgr(Context paramContext, int paramInt)
  {
    SPlayerUtils.initDataTransportDataFolder(paramInt);
    paramContext = TPProxyGlobalManager.getInstance().getPlayerProxy(paramInt);
    if ((paramContext != null) && (paramContext.getDownloadProxy() != null)) {
      this.mTPDownloadProxy = paramContext.getDownloadProxy();
    }
  }
  
  public int startOfflineDownload(String paramString1, String paramString2, String paramString3, SPlayerDownloadMgr.ISPlayerOfflineDownloadListener paramISPlayerOfflineDownloadListener)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = SPlayerUtils.calculateFileID(paramString1);
    }
    paramString2 = new TPDownloadParamData();
    paramString2.setUrl(paramString1);
    paramString2.setSavePath(paramString3);
    paramString2.setDownloadFileID(str);
    paramString2.setDlType(1);
    int i = this.mTPDownloadProxy.startOfflineDownload(str, TPProxyUtils.convertProxyDownloadParams(null, paramString2), new SPlayerDownloadMgr.1(this, paramISPlayerOfflineDownloadListener));
    this.mTPDownloadProxy.startTask(i);
    return i;
  }
  
  public void stopOfflineDownload(int paramInt)
  {
    this.mTPDownloadProxy.stopOfflineDownload(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerDownloadMgr
 * JD-Core Version:    0.7.0.1
 */