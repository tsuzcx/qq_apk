package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class PreviewSimpleFilePresenter
  extends DocFilePresenter
{
  public PreviewSimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
  }
  
  private boolean a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = ((IFMConfig)QRoute.api(IFMConfig.class)).getPreviewConfig(paramContext, paramString, "FileMaxSize");
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (Integer.parseInt(paramContext) * 1048576 >= paramLong) {
      bool = true;
    }
    return bool;
  }
  
  private boolean t()
  {
    boolean bool2 = this.c.o();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((a(this.f, this.d.a(), this.d.b())) || (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDoc(TencentDocPreviewConfigProcessor.a().a(), this.d.c(), this.d.a(), this.d.b()))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("DocFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
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
    h();
    this.b.e(true ^ this.c.n());
  }
  
  protected void h()
  {
    if (this.d.g() != 16)
    {
      if (this.c.p()) {
        return;
      }
      if (FileUtils.fileExistsAndNotEmpty(this.d.c()))
      {
        super.h();
        return;
      }
      if ((NetworkUtil.isNetSupport(this.f)) && (t()))
      {
        String str = this.f.getString(2131889789);
        this.b.b(str, new PreviewSimpleFilePresenter.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.PreviewSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */