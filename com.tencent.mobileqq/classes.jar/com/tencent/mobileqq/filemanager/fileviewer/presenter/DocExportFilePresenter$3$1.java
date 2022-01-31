package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import apoo;
import apoq;
import axqw;
import bbjc;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class DocExportFilePresenter$3$1
  implements Runnable
{
  public DocExportFilePresenter$3$1(apoq paramapoq) {}
  
  public void run()
  {
    if (((FileBrowserActivity)this.a.a.a).a != null)
    {
      axqw.b(null, "dc00898", "", "", "0X800A3B7", "0X800A3B7", 0, 0, "", "", "", "");
      ((FileBrowserActivity)this.a.a.a).a.a();
      ((FileBrowserActivity)this.a.a.a).a.a(apoq.a(this.a));
      ((FileBrowserActivity)this.a.a.a).a.a("export_auto_open");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3.1
 * JD-Core Version:    0.7.0.1
 */