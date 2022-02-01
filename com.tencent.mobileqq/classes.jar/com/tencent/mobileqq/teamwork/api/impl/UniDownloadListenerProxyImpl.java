package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload.UniDownloadListener;
import com.tencent.mobileqq.teamwork.api.IUniDownloadListenerProxy;

public class UniDownloadListenerProxyImpl
  implements IUniDownloadListenerProxy
{
  private UniformDownload.UniDownloadListener mListener;
  
  public void onCreate(AppInterface paramAppInterface, Activity paramActivity, TouchWebView paramTouchWebView, boolean paramBoolean)
  {
    this.mListener = new UniformDownload.UniDownloadListener(paramAppInterface, paramActivity, paramTouchWebView);
    this.mListener.a(paramBoolean);
  }
  
  public void onDestroy()
  {
    this.mListener = null;
  }
  
  public void setDownloadListener(TouchWebView paramTouchWebView)
  {
    UniformDownload.UniDownloadListener localUniDownloadListener = this.mListener;
    if ((localUniDownloadListener != null) && (paramTouchWebView != null)) {
      paramTouchWebView.setDownloadListener(localUniDownloadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.UniDownloadListenerProxyImpl
 * JD-Core Version:    0.7.0.1
 */