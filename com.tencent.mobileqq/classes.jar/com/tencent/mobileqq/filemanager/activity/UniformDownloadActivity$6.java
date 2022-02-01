package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class UniformDownloadActivity$6
  implements View.OnClickListener
{
  UniformDownloadActivity$6(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    if (UniformDownloadActivity.a(this.a)) {
      OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3009", false);
    }
    for (;;)
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3006", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.6
 * JD-Core Version:    0.7.0.1
 */