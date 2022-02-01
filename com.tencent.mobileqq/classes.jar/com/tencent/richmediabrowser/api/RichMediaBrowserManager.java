package com.tencent.richmediabrowser.api;

import android.content.Intent;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.IBrowserBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.List;

public class RichMediaBrowserManager
{
  public void a(Intent paramIntent, IBrowserBuilder paramIBrowserBuilder, List<RichMediaBrowserInfo> paramList, int paramInt)
  {
    new BrowserDirector().construct(paramIBrowserBuilder, paramIntent);
    paramIntent = paramIBrowserBuilder.getPresenter();
    if ((paramIntent instanceof MainBrowserPresenter))
    {
      paramIntent = (MainBrowserPresenter)paramIntent;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramIntent.notifyImageListChanged(paramList, paramInt);
        return;
      }
      BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "lunchRichMediaBrowser dataList is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.api.RichMediaBrowserManager
 * JD-Core Version:    0.7.0.1
 */