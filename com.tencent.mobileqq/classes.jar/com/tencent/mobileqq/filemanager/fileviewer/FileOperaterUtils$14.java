package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$14
  implements View.OnClickListener
{
  FileOperaterUtils$14(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    ((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList(this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.14
 * JD-Core Version:    0.7.0.1
 */