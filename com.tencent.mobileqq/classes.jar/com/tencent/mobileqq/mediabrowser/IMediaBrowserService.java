package com.tencent.mobileqq.mediabrowser;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMediaBrowserService
  extends QRouteApi
{
  public static final String STRING_BROWSE_ID = "browseId";
  
  public abstract void browserFile(Context paramContext, IMediaBrowserService.BrowserInfo paramBrowserInfo);
  
  public abstract IMediaBrowserService.BrowserInfo getBrowserInfo(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.IMediaBrowserService
 * JD-Core Version:    0.7.0.1
 */