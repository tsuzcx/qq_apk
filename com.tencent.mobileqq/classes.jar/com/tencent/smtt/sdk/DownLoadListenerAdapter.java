package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.tencent.smtt.sdk.stat.MttLoader;

class DownLoadListenerAdapter
  implements com.tencent.smtt.export.external.interfaces.DownloadListener
{
  private DownloadListener mListener;
  private WebView mWebView;
  
  public DownLoadListenerAdapter(WebView paramWebView, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    this.mListener = paramDownloadListener;
    this.mWebView = paramWebView;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    onDownloadStart(paramString1, null, null, paramString2, paramString3, paramString4, paramLong, null, null);
  }
  
  public void onDownloadStart(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    if (this.mListener == null)
    {
      if (QbSdk.canOpenMimeFileType(this.mWebView.getContext(), paramString5))
      {
        paramString2 = new Intent("com.tencent.QQBrowser.action.sdk.document");
        paramString2.setFlags(268435456);
        paramString2.putExtra("key_reader_sdk_url", paramString1);
        paramString2.putExtra("key_reader_sdk_type", 1);
        paramString2.setData(Uri.parse(paramString1));
        this.mWebView.getContext().startActivity(paramString2);
      }
      do
      {
        return;
        paramString2 = this.mWebView.getContext().getApplicationInfo();
      } while ((paramString2 != null) && ("com.tencent.mm".equals(paramString2.packageName)));
      MttLoader.loadUrl(this.mWebView.getContext(), paramString1, null, null);
      return;
    }
    this.mListener.onDownloadStart(paramString1, paramString3, paramString4, paramString5, paramLong);
  }
  
  public void onDownloadVideo(String paramString, long paramLong, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.DownLoadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */