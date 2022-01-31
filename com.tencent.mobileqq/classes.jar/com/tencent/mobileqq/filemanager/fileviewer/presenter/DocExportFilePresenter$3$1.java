package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aoxa;
import aoxc;
import awqx;
import bahv;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class DocExportFilePresenter$3$1
  implements Runnable
{
  public DocExportFilePresenter$3$1(aoxc paramaoxc) {}
  
  public void run()
  {
    if (((FileBrowserActivity)this.a.a.a).a != null)
    {
      awqx.b(null, "dc00898", "", "", "0X800A3B7", "0X800A3B7", 0, 0, "", "", "", "");
      ((FileBrowserActivity)this.a.a.a).a.a();
      ((FileBrowserActivity)this.a.a.a).a.a(aoxc.a(this.a));
      ((FileBrowserActivity)this.a.a.a).a.a("export_auto_open");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3.1
 * JD-Core Version:    0.7.0.1
 */