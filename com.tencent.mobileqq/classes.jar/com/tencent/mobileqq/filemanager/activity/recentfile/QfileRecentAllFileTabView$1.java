package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

class QfileRecentAllFileTabView$1
  extends IClickListenerVer51
{
  QfileRecentAllFileTabView$1(QfileRecentAllFileTabView paramQfileRecentAllFileTabView) {}
  
  public void a()
  {
    this.a.a.a().b();
  }
  
  public void b()
  {
    this.a.a.a().o();
  }
  
  public void c()
  {
    this.a.a.a().p();
  }
  
  public void d()
  {
    this.a.a.a().q();
    Object localObject = FMDataCache.b();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (FMConstants.a(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          ReportController.b(QfileRecentAllFileTabView.b(this.a), "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void e()
  {
    this.a.a.a().r();
  }
  
  public void f()
  {
    this.a.a.a().E();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView.1
 * JD-Core Version:    0.7.0.1
 */