package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class OnlineSimpleFilePresenter
  extends SimpleFilePresenter
{
  public OnlineSimpleFilePresenter(IFileBrowserModel paramIFileBrowserModel, Activity paramActivity)
  {
    super(paramIFileBrowserModel, paramActivity);
    a(new SimpleFileBrowserView(paramActivity));
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      this.b.d(this.f.getString(2131889462));
      return;
    }
    this.b.d(this.f.getString(2131889461));
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 1)) {
      switch (paramInt)
      {
      default: 
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFileTips: opType[");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("not implemented");
          QLog.e("SimpleFilePresenter<FileAssistant>", 2, localStringBuilder.toString());
          return;
        }
        break;
      case 11: 
        c(this.d.g());
        return;
      case 10: 
        this.b.c(false);
        this.b.b(false);
        this.b.d(this.f.getString(2131892287));
        return;
      case 9: 
        d(this.d.g());
      }
    }
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFileTips: opType[OPERATION_TYPE_OLFILE_BE_PC_HANDLED] status[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("not implemented");
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, localStringBuilder.toString());
      }
      break;
    case 8: 
    case 9: 
      this.b.d(this.f.getString(2131892287));
      break;
    case 6: 
      this.b.d(this.f.getString(2131892286));
      break;
    case 5: 
    case 7: 
      this.b.d(this.f.getString(2131892283));
    }
    this.b.e(true);
    this.b.b(false);
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFileTips: opType[OPERATION_TYPE_OLFILE_GOTO_UPLOAD] status[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("not implemented");
        QLog.e("SimpleFilePresenter<FileAssistant>", 2, localStringBuilder.toString());
        return;
      }
      break;
    case 10: 
    case 11: 
    case 12: 
      this.b.d(this.f.getString(2131892282));
      this.b.b(false);
    }
  }
  
  private void i()
  {
    int i = this.d.e();
    a(this.d.d());
    b(i);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
    }
    this.b.h(FileUtil.a(this.d.b()));
    i();
  }
  
  public void e()
  {
    q();
    i();
  }
  
  protected void f()
  {
    super.f();
    int i = this.d.g();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.b.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.OnlineSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */