package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter;
import java.util.Map;

public class TPProxyAdapterManager
{
  private ITPProxyAdapter mAdapter = null;
  
  public static TPProxyAdapterManager getInstance()
  {
    return TPProxyAdapterManager.SingletonHolder.access$100();
  }
  
  public String checkVideoStatus(String paramString1, String paramString2)
  {
    if (this.mAdapter != null) {
      return this.mAdapter.checkVideoStatus(paramString1, paramString2);
    }
    return "";
  }
  
  public long getCurrentFilesize(int paramInt)
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getFilesize(paramInt);
    }
    return 0L;
  }
  
  public long getCurrentOffset(int paramInt)
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getCurrentOffset(paramInt);
    }
    return 0L;
  }
  
  public String getProxyClipUrl(int paramInt1, int paramInt2)
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getProxyClipUrl(paramInt1, paramInt2);
    }
    return "";
  }
  
  public int getRecordDuration(String paramString1, String paramString2)
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getRecordDuration(paramString1, paramString2);
    }
    return 0;
  }
  
  public void setProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    this.mAdapter = paramITPProxyAdapter;
  }
  
  public int startOnlineOrOfflinePlay(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if (this.mAdapter != null) {
      return this.mAdapter.startOnlineOrOfflinePlay(paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2, paramInt2, paramMap1, paramMap2);
    }
    return -1;
  }
  
  public void stopPlay(int paramInt)
  {
    if (this.mAdapter != null) {
      this.mAdapter.stopPlay(paramInt);
    }
  }
  
  public void updateProxyMessage(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    TPListenerManager.getInstance().handleCallbackMessage(101, ((Integer)paramObject1).intValue(), null, null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPProxyAdapterManager
 * JD-Core Version:    0.7.0.1
 */