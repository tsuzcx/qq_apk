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
    if (this.a.n != null)
    {
      this.a.n.dismiss();
      this.a.n = null;
    }
    if (UniformDownloadActivity.c(this.a)) {
      OpenSdkStatic.a().a(UniformDownloadActivity.d(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3009", false);
    } else {
      OpenSdkStatic.a().a(UniformDownloadActivity.d(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3006", false);
    }
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.6
 * JD-Core Version:    0.7.0.1
 */