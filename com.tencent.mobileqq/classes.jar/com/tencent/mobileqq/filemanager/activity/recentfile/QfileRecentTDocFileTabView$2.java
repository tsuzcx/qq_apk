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

class QfileRecentTDocFileTabView$2
  extends IClickListenerVer51
{
  QfileRecentTDocFileTabView$2(QfileRecentTDocFileTabView paramQfileRecentTDocFileTabView) {}
  
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    Object localObject = FMDataCache.h();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (FMConstants.a(((FileManagerEntity)((Iterator)localObject).next()).Uuid)) {
          ReportController.b(QfileRecentTDocFileTabView.b(this.a), "dc00898", "", "", "0X800A08C", "0X800A08C", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void e() {}
  
  public void f()
  {
    this.a.C.A().E();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView.2
 * JD-Core Version:    0.7.0.1
 */