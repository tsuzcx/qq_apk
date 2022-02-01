package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportTask;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class TroopUsingTimeReport
  extends BaseUsingTimeReport
{
  private WeakReference<QQAppInterface> a;
  private String e;
  
  public TroopUsingTimeReport(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString2, paramString3, paramString4);
    this.a = new WeakReference(paramQQAppInterface);
    this.e = paramString1;
  }
  
  public UsingTimeReportManager a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if (localObject == null) {
      return null;
    }
    return (UsingTimeReportManager)((QQAppInterface)localObject).getManager(QQManagerFactory.USING_TIME_REPORT_MANAGER);
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ReportTask localReportTask = new ReportTask((AppRuntime)localObject).a("dc00899").b(this.b).c(this.c).d(this.d);
    localObject = this.e;
    if (localObject == null) {
      localObject = "";
    }
    localReportTask.a(new String[] { localObject, String.valueOf(paramLong) }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopUsingTimeReport
 * JD-Core Version:    0.7.0.1
 */