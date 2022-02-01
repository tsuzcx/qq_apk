package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApkSimpleFilePresenter$3
  implements View.OnClickListener
{
  ApkSimpleFilePresenter$3(ApkSimpleFilePresenter paramApkSimpleFilePresenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.b.d, QQBrowserActivity.class);
    localIntent.putExtra("url", this.a);
    this.b.d.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkSimpleFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */