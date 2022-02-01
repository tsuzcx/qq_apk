package com.tencent.mobileqq.mediabrowser.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService.BrowserInfo;
import java.util.HashMap;
import java.util.Map;

public class MediaBrowserServiceImpl
  implements IMediaBrowserService
{
  private static Integer browseId = Integer.valueOf(0);
  private final Map<Integer, IMediaBrowserService.BrowserInfo> browserInfoMap = new HashMap();
  
  private void internalBrowserFile(Context paramContext, int paramInt, IMediaBrowserService.BrowserInfo paramBrowserInfo)
  {
    browseId = Integer.valueOf(browseId.intValue() + 1);
    this.browserInfoMap.put(browseId, paramBrowserInfo);
    paramBrowserInfo = new Intent(paramContext, MediaBrowserActivity.class);
    paramBrowserInfo.putExtra("browseId", browseId);
    if (paramInt != -1)
    {
      ((Activity)paramContext).startActivityForResult(paramBrowserInfo, paramInt);
      return;
    }
    paramContext.startActivity(paramBrowserInfo);
  }
  
  public void browserFile(Context paramContext, IMediaBrowserService.BrowserInfo paramBrowserInfo)
  {
    internalBrowserFile(paramContext, -1, paramBrowserInfo);
  }
  
  public IMediaBrowserService.BrowserInfo getBrowserInfo(int paramInt)
  {
    return (IMediaBrowserService.BrowserInfo)this.browserInfoMap.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.impl.MediaBrowserServiceImpl
 * JD-Core Version:    0.7.0.1
 */