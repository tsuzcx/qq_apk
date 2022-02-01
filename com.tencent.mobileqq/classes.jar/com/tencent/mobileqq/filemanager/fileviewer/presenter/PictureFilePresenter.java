package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.List;

public class PictureFilePresenter
  extends FileBrowserPresenterBase
  implements FileBrowserModelBase.OnThumbEventListener, FileBrowserModelBase.OnTransEventListener
{
  protected PictureFileViewer a;
  boolean b = false;
  private int j = 0;
  private List<FileBrowserModelBase.ImageFileInfo> k = this.c.S();
  private boolean l = false;
  private int m = 0;
  private View.OnClickListener n = new PictureFilePresenter.2(this);
  private AdapterView.OnItemClickListener o = new PictureFilePresenter.3(this);
  private AdapterView.OnItemSelectedListener p = new PictureFilePresenter.4(this);
  
  public PictureFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.a = new PictureFileViewer(paramActivity);
    a(this.a);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String i()
  {
    FileBrowserModelBase.ImageFileInfo localImageFileInfo = (FileBrowserModelBase.ImageFileInfo)this.k.get(this.c.s());
    if (localImageFileInfo == null) {
      return null;
    }
    String str2 = localImageFileInfo.c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localImageFileInfo.g();
    }
    return str1;
  }
  
  private void j()
  {
    Object localObject = i();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("PictureFilePresenter<QFile>", 1, "startEditPicture. but file path is null.");
      return;
    }
    localObject = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.d, (String)localObject, true, true, true, true, true, 2, 130, 7);
    ((Intent)localObject).putExtra("open_chatfragment", true);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
    ((Intent)localObject).putExtra("key_enable_edit_title_bar", true);
    ((Intent)localObject).putExtra("key_help_forward_pic", true);
    ((Intent)localObject).putExtra("key_allow_multiple_forward_from_limit", false);
    this.d.startActivity((Intent)localObject);
    int i = this.c.ao();
    if ((i != 3) && (i != 4))
    {
      if ((i != 7) && (i != 8) && (i != 9))
      {
        if (i != 11) {
          i = 0;
        } else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 3;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
    this.d.overridePendingTransition(2130772090, 2130772092);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    List localList = this.k;
    if ((localList != null) && (localList.get(this.j) != null) && (this.c.G()))
    {
      this.a.c(a(i()));
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131889341));
    }
    this.a.a(this.k);
    this.a.a(this.o);
    this.a.a(new PictureFilePresenter.1(this));
    this.a.a(this.p);
    this.a.b(this.n);
    this.a.c(this.c.s());
    h();
    this.c.a(this);
    this.c.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.c.c(paramInt);
    if ((this.c.P()) && (this.c.f() != null))
    {
      this.a.b(true);
      this.a.a(false);
      b(0.0F);
      this.c.f().a();
    }
    h();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture fileid is null!");
      }
      return;
    }
    FileBrowserModelBase.ImageFileInfo localImageFileInfo = (FileBrowserModelBase.ImageFileInfo)this.k.get(this.c.s());
    if (!localImageFileInfo.c(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localImageFileInfo.a(3);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PictureFilePresenter onThumbDownload suc : fileId[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("] thumbPath[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("]");
      QLog.e("PictureFilePresenter<QFile>", 1, localStringBuilder.toString());
    }
    localImageFileInfo.a(paramString2);
    localImageFileInfo.a(2);
    this.a.e();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    this.a.a(false);
    this.a.b(true);
    b(this.c.J());
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
    ((FileBrowserModelBase.ImageFileInfo)this.k.get(this.c.s())).b(this.c.y());
    this.a.e();
    this.a.f();
    if (this.e != null) {
      this.e.h();
    }
  }
  
  public void g()
  {
    this.a.a(true);
    this.a.b(false);
    h();
  }
  
  protected void h()
  {
    int i = this.c.R();
    if ((i != 2) && (i != 5))
    {
      if (i == 6)
      {
        this.a.a(true);
        this.a.b(false);
      }
      super.h();
      if (this.c.B() == 9501) {
        this.a.c();
      }
      return;
    }
    this.a.a(false);
    this.a.b(false);
  }
  
  public String q()
  {
    return this.c.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.PictureFilePresenter
 * JD-Core Version:    0.7.0.1
 */