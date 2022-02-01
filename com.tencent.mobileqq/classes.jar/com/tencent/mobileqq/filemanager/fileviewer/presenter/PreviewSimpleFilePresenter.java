package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class PreviewSimpleFilePresenter
  extends SimpleFilePresenter
{
  public PreviewSimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
  }
  
  private boolean v()
  {
    return (w()) && (!this.c.H());
  }
  
  private boolean w()
  {
    return (FileManagerUtil.a(this.d.getBaseContext(), this.c.v(), this.c.x())) || (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForPreview(this.c.y(), this.c.v(), this.c.x()));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
    }
    if ((!TextUtils.isEmpty(this.c.I())) && (16 != this.c.b())) {
      this.k.g(this.c.I());
    } else {
      this.k.e(false);
    }
    if (this.c.b() == 16) {
      this.k.c(this.d.getString(2131889341));
    } else if (this.c.F()) {
      this.k.c(this.d.getString(2131889582));
    }
    i();
    this.k.c(true ^ this.c.P());
  }
  
  protected void i()
  {
    if (this.c.b() != 16)
    {
      if (this.c.F()) {
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(this.c.y()))
      {
        super.i();
        return;
      }
      if ((NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) && (v()))
      {
        String str = this.d.getString(2131889789);
        this.k.b(str, new PreviewSimpleFilePresenter.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PreviewSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */