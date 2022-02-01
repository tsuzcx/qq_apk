package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$6
  implements View.OnClickListener
{
  FileOperaterUtils$6(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.a;
    if ((localActivity instanceof BasePluginActivity)) {
      FileManagerUtil.a(((BasePluginActivity)localActivity).getOutActivity(), this.b);
    } else {
      FileManagerUtil.a(localActivity, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.6
 * JD-Core Version:    0.7.0.1
 */