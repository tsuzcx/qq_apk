package com.tencent.xweb.xwalk;

import android.content.Context;
import android.webkit.DownloadListener;
import org.xwalk.core.XWalkDownloadListener;

public class g$f
  extends XWalkDownloadListener
{
  DownloadListener a;
  
  public g$f(Context paramContext, DownloadListener paramDownloadListener)
  {
    super(paramContext);
    this.a = paramDownloadListener;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    DownloadListener localDownloadListener = this.a;
    if (localDownloadListener != null) {
      localDownloadListener.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.f
 * JD-Core Version:    0.7.0.1
 */