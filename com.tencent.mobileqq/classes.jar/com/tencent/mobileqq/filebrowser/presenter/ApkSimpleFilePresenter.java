package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnMMApkSafeCheckListener;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ApkSimpleFilePresenter
  extends SimpleFilePresenter
  implements IFileBrowserModel.OnMMApkSafeCheckListener
{
  public ApkSimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    a(new SimpleFileBrowserView(paramActivity));
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 0) && (paramInt != 4) && (!TextUtils.isEmpty(paramString1)))
    {
      String str = BaseApplication.getContext().getString(2131889785);
      this.b.a(str, false);
      if (!TextUtils.isEmpty(paramString2))
      {
        this.b.a(paramString1, 0, new ApkSimpleFilePresenter.2(this, paramString2));
        return;
      }
      this.b.a(paramString1, 0, null);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
    }
    String str = this.f.getString(2131889785);
    this.b.a(str, true);
    this.b.e(false);
    a(this.d.k(), this.d.l(), this.d.m());
    this.b.e(2130845642);
    this.b.f(this.d.j());
    this.c.a(this);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramInt, paramString1, paramString2);
  }
  
  protected void f()
  {
    super.f();
    if (this.c.k() == 2) {
      this.b.a(this.f.getString(2131889781), new ApkSimpleFilePresenter.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.ApkSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */