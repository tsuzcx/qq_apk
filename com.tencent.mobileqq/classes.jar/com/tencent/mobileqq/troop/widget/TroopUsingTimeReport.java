package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportTask;
import java.lang.ref.WeakReference;

public class TroopUsingTimeReport
  extends BaseUsingTimeReport
{
  private WeakReference<QQAppInterface> a;
  private String d;
  
  public TroopUsingTimeReport(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString2, paramString3, paramString4);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.d = paramString1;
  }
  
  public UsingTimeReportManager a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return null;
    }
    return (UsingTimeReportManager)localQQAppInterface.getManager(QQManagerFactory.USING_TIME_REPORT_MANAGER);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      return;
      localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    ReportTask localReportTask = new ReportTask((QQAppInterface)localObject).a("dc00899").b(this.jdField_a_of_type_JavaLangString).c(this.b).d(this.c);
    if (this.d != null) {}
    for (Object localObject = this.d;; localObject = "")
    {
      localReportTask.a(new String[] { localObject, String.valueOf(paramLong) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopUsingTimeReport
 * JD-Core Version:    0.7.0.1
 */