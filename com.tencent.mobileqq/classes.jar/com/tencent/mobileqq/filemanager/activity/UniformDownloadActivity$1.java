package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UniformDownloadActivity$1
  implements View.OnClickListener
{
  UniformDownloadActivity$1(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.d(this.a.getActivity()))
    {
      UniformDownloadActivity.a(this.a).setVisibility(8);
      if (FileManagerUtil.a()) {
        FMDialogUtil.a(this.a.getActivity(), 2131692609, 2131720338, new UniformDownloadActivity.1.1(this));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UniformDownloadActivity.a(this.a);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      continue;
      FMToastUtil.a(2131692602);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */