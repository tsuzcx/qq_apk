package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnTransEventListener;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import mqq.os.MqqHandler;

public class DocExportFilePresenter
  extends FileBrowserPresenterBase
  implements IFileBrowserModel.OnTransEventListener
{
  protected boolean a = true;
  protected DocFileBrowserView b = new DocFileBrowserView(this.e);
  private SpannableString k;
  private boolean l = false;
  private LocalTbsViewManager.LocalTbsViewManagerCallback m = new DocExportFilePresenter.3(this);
  
  public DocExportFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    a(this.b);
  }
  
  private void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_export_file_is_first_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_export_file_is_first_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.b.e(this.d.a());
    if (FileUtil.b(this.d.c())) {
      h();
    } else {
      i();
    }
    this.c.a(this);
    View localView1 = this.b.h();
    if (localView1 != null)
    {
      View localView2 = localView1.findViewById(2131447805);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      localView2 = localView1.findViewById(2131433120);
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      localView1 = localView1.findViewById(2131433111);
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void b()
  {
    this.b.b(false);
    this.b.c(true);
    b(this.c.l());
  }
  
  protected void b(float paramFloat)
  {
    DocFileBrowserView localDocFileBrowserView = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getString(2131889269));
    int i = (int)paramFloat;
    localStringBuilder.append(i);
    localStringBuilder.append("%");
    localDocFileBrowserView.b(localStringBuilder.toString());
    this.b.c(i);
  }
  
  public void c()
  {
    this.b.b(true);
    this.b.c(false);
    f();
  }
  
  public void d()
  {
    this.b.b(true);
    this.b.c(false);
    f();
    if (this.g != null) {
      this.g.a();
    }
  }
  
  public void e()
  {
    this.b.c(false);
    f();
  }
  
  public boolean g()
  {
    return this.a;
  }
  
  protected void h()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SimpleFilePresenter handleLocalFile: fileName[");
      ((StringBuilder)localObject).append(this.d.a());
      ((StringBuilder)localObject).append("] filePath[");
      ((StringBuilder)localObject).append(this.d.c());
      ((StringBuilder)localObject).append("]");
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.h();
    if ((localObject != null) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null) && (this.c.f() != null) && (a(this.f, this.c.f())) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null))
    {
      localObject = ((ViewGroup)((View)localObject).getParent().getParent()).findViewById(2131445540);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        a(this.f, this.c.f(), false);
        new MqqHandler().postDelayed(new DocExportFilePresenter.1(this, (View)localObject), 5000L);
      }
    }
    if (this.c.k() == 2) {
      LocalTbsViewManager.a().a(this.e, this.d.c(), this.m, true);
    }
    this.b.d(QQFileManagerUtil.q(this.d.a()));
    this.b.h(this.c.h());
    this.f.getString(2131889341);
    if (this.d.g() == 16)
    {
      localObject = BaseApplication.getContext().getString(2131889341);
      this.b.d((String)localObject);
      this.b.e(true);
      return;
    }
    if (QbSdk.isSuportOpenFile(QQFileManagerUtil.y(this.d.a()), 2))
    {
      this.k = QQFileManagerUtil.a(BaseApplication.getContext().getString(2131889787), BaseApplication.getContext().getString(2131892336), new DocExportFilePresenter.2(this));
      this.b.a(this.k);
    }
    else
    {
      localObject = BaseApplication.getContext().getString(2131889786);
      this.b.d((String)localObject);
    }
    this.b.e(true);
  }
  
  protected void i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SimpleFilePresenter handleCloudFile: fileName[");
      localStringBuilder.append(this.d.a());
      localStringBuilder.append("]");
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, localStringBuilder.toString());
    }
    int i = this.d.d();
    if (i == 5)
    {
      this.b.e(2130845642);
      this.b.f(this.d.j());
    }
    else
    {
      this.b.d(QQFileManagerUtil.q(this.d.a()));
    }
    if ((!TextUtils.isEmpty(this.c.i())) && (16 != this.d.g())) {
      this.b.h(this.c.i());
    } else {
      this.b.g(false);
    }
    if (i == 1) {
      this.b.d(BaseApplication.getContext().getString(2131889767));
    } else {
      this.b.d(BaseApplication.getContext().getString(2131889768));
    }
    if (this.d.g() == 16)
    {
      this.b.d(BaseApplication.getContext().getString(2131889341));
      return;
    }
    if (this.c.p())
    {
      this.b.d(BaseApplication.getContext().getString(2131889582));
      return;
    }
    if (this.c.j())
    {
      this.b.d(BaseApplication.getContext().getString(2131889341));
      return;
    }
    if (this.c.n())
    {
      this.c.y();
      this.b.c(true);
      this.b.b(false);
      b(0.0F);
    }
  }
  
  public void j()
  {
    DocFileBrowserView localDocFileBrowserView = this.b;
    if (localDocFileBrowserView != null) {
      localDocFileBrowserView.f();
    }
    super.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter
 * JD-Core Version:    0.7.0.1
 */