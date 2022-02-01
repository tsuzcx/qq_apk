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
    if (NetworkUtil.isNetSupport(this.a.getActivity()))
    {
      UniformDownloadActivity.a(this.a).setVisibility(8);
      if (FileManagerUtil.b())
      {
        FMDialogUtil.a(this.a.getActivity(), 2131889584, 2131917699, new UniformDownloadActivity.1.1(this));
      }
      else
      {
        UniformDownloadActivity.b(this.a);
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
      }
    }
    else
    {
      FMToastUtil.a(2131889577);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */