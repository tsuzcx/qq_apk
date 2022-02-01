package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnMMApkSafeCheckListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ApkSimpleFilePresenter
  extends SimpleFilePresenter
  implements FileBrowserModelBase.OnMMApkSafeCheckListener
{
  public ApkSimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = apk simple");
    }
    String str = BaseApplicationImpl.getContext().getString(2131889785);
    this.k.a(str, true);
    this.k.c(false);
    if ((this.c.ak() != 0) && (this.c.ak() != 4) && (!TextUtils.isEmpty(this.c.al())))
    {
      this.k.a(str, false);
      if (!TextUtils.isEmpty(this.c.am()))
      {
        str = this.c.am();
        this.k.a(true, this.c.al(), 0, new ApkSimpleFilePresenter.1(this, str));
      }
      else
      {
        this.k.a(true, this.c.al(), 0, null);
      }
    }
    this.k.d(2130845642);
    this.k.e(this.c.E());
    this.c.a(this);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramInt != 0) && (paramInt != 4) && (!TextUtils.isEmpty(paramString1)))
    {
      paramBundle = BaseApplicationImpl.getContext().getString(2131889785);
      this.k.a(paramBundle, false);
      if (!TextUtils.isEmpty(paramString2))
      {
        this.k.a(true, paramString1, 0, new ApkSimpleFilePresenter.3(this, paramString2));
        return;
      }
      this.k.a(true, paramString1, 0, null);
    }
  }
  
  protected void h()
  {
    super.h();
    if (this.c.R() == 2) {
      this.k.a(HardCodeUtil.a(2131898545), new ApkSimpleFilePresenter.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.ApkSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */