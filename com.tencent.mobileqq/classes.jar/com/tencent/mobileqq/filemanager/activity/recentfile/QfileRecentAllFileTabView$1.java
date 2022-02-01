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
    this.a.C.A().b();
  }
  
  public void b()
  {
    this.a.C.A().o();
  }
  
  public void c()
  {
    this.a.C.A().p();
  }
  
  public void d()
  {
    this.a.C.A().q();
    Object localObject = FMDataCache.h();
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
    this.a.C.A().r();
  }
  
  public void f()
  {
    this.a.C.A().E();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView.1
 * JD-Core Version:    0.7.0.1
 */