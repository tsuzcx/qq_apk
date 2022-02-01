package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnAppStorePromoteListener;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AppStoreApkFilePresenter
  extends SimpleFilePresenter
  implements View.OnClickListener
{
  private final IFileBrowserModel.OnAppStorePromoteListener a = new AppStoreApkFilePresenter.1(this);
  
  public AppStoreApkFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    a(new SimpleFileBrowserView(paramActivity));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("AppStoreApkFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
    }
    String str = this.c.q();
    this.b.e(2130845642);
    if (!TextUtils.isEmpty(str)) {
      this.b.g(str);
    } else {
      this.b.f(this.d.j());
    }
    if ((!TextUtils.isEmpty(this.c.i())) && (16 != this.d.g())) {
      this.b.h(this.c.i());
    } else {
      this.b.g(false);
    }
    if ((!TextUtils.isEmpty(this.c.i())) && (16 != this.d.g())) {
      this.b.h(this.c.i());
    } else {
      this.b.g(false);
    }
    if (this.d.g() == 16) {
      this.b.d(this.f.getString(2131889341));
    } else if (this.c.p()) {
      this.b.d(this.f.getString(2131889582));
    }
    this.b.e(true ^ this.c.n());
    str = this.c.s();
    if (!TextUtils.isEmpty(str)) {
      this.b.e(str);
    }
  }
  
  protected void ce_()
  {
    String str = this.c.a(this.f);
    if (str != null)
    {
      this.b.b(str, this);
      ReportController.b(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
    }
  }
  
  protected void f()
  {
    super.f();
    int i = this.c.k();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      this.i = true;
      SimpleFileBrowserView localSimpleFileBrowserView = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f.getString(2131889775));
      localStringBuilder.append("(");
      localStringBuilder.append(FileSizeFormat.a(this.d.b()));
      localStringBuilder.append(")");
      localSimpleFileBrowserView.a(localStringBuilder.toString(), new AppStoreApkFilePresenter.2(this));
    }
  }
  
  protected void h() {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
    this.c.b(this.e);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.AppStoreApkFilePresenter
 * JD-Core Version:    0.7.0.1
 */