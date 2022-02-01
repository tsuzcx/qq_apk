package com.tencent.open.filedownload;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApkFileDownloadFragment$4
  implements View.OnClickListener
{
  ApkFileDownloadFragment$4(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void onClick(View paramView)
  {
    ApkFileDownloadFragment.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment.4
 * JD-Core Version:    0.7.0.1
 */