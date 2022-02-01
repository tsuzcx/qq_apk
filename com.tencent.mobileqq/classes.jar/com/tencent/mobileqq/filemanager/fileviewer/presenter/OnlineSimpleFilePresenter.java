package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class OnlineSimpleFilePresenter
  extends SimpleFilePresenter
{
  public OnlineSimpleFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
  }
  
  private void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        this.k.c(this.d.getString(2131889462));
        return;
      }
      this.k.c(this.d.getString(2131889463));
      return;
    }
    this.k.c(this.d.getString(2131889461));
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
        c(this.c.b());
        return;
      case 10: 
        this.k.b(false);
        this.k.a(false);
        this.k.c(this.d.getString(2131892287));
        return;
      case 9: 
        d(this.c.b());
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
      this.k.c(this.d.getString(2131892287));
      break;
    case 6: 
      this.k.c(this.d.getString(2131892286));
      break;
    case 5: 
    case 7: 
      this.k.c(this.d.getString(2131892283));
    }
    this.k.c(true);
    this.k.a(false);
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
      this.k.c(this.d.getString(2131892282));
      this.k.a(false);
    }
  }
  
  private void v()
  {
    int i = this.c.L();
    a(this.c.z());
    b(i);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = online simple");
    }
    this.k.g(FileUtil.a(this.c.x()));
    v();
  }
  
  public void g()
  {
    p();
    v();
  }
  
  protected void h()
  {
    super.h();
    int i = this.c.b();
    if ((i == 8) || (i == 9) || (i == 5) || (i == 7) || (i == 12) || (i == 6) || (i == 16)) {
      this.k.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.OnlineSimpleFilePresenter
 * JD-Core Version:    0.7.0.1
 */