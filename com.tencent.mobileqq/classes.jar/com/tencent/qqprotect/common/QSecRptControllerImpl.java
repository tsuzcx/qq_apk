package com.tencent.qqprotect.common;

import android.os.Handler.Callback;
import android.os.Message;
import bdee;
import bhin;
import bhip;
import bhir;
import bhoe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.app.MobileQQ;
import mzy;

public class QSecRptControllerImpl
  extends bhin
  implements Handler.Callback
{
  private static volatile bhin jdField_a_of_type_Bhin;
  private final long jdField_a_of_type_Long = 300000L;
  private bhoe jdField_a_of_type_Bhoe = new bhoe(ThreadManager.getSubThreadLooper(), this);
  private QSecRptControllerImpl.ReportRunnable jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable;
  private final Vector<bhir> jdField_a_of_type_JavaUtilVector = new Vector();
  
  private QSecRptControllerImpl()
  {
    this.jdField_a_of_type_Bhoe.sendEmptyMessageDelayed(12315, 300000L);
  }
  
  public static bhin a()
  {
    if (jdField_a_of_type_Bhin == null) {}
    try
    {
      if (jdField_a_of_type_Bhin == null) {
        jdField_a_of_type_Bhin = new QSecRptControllerImpl();
      }
      return jdField_a_of_type_Bhin;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bhoe.removeMessages(12315);
    b();
    this.jdField_a_of_type_Bhoe.sendEmptyMessageDelayed(12315, this.jdField_a_of_type_Long);
  }
  
  private void a(bhir parambhir)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(parambhir);
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("add report: totally %d items in cache", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()) }));
      }
      if ((parambhir.c == 2) || (this.jdField_a_of_type_JavaUtilVector.size() >= 40)) {
        b();
      }
      return;
    }
  }
  
  private void a(SafeReport.ReqBody paramReqBody)
  {
    if (paramReqBody == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSRPT", 2, String.format("totally sending report: %d items", new Object[] { Integer.valueOf(paramReqBody.LogItem_reportdata.size()) }));
    }
    mzy.a((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), new bhip(this), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  private void b()
  {
    if (!bdee.d(BaseApplicationImpl.sApplication)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable = new QSecRptControllerImpl.ReportRunnable(this, null);
    } while (this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable == null);
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      QSecRptControllerImpl.ReportRunnable.a(this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable).addAll(this.jdField_a_of_type_JavaUtilVector);
      this.jdField_a_of_type_JavaUtilVector.removeAllElements();
      ThreadManager.post(this.jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable, 5, null, true);
      return;
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    bhir localbhir = new bhir();
    localbhir.jdField_a_of_type_Int = paramInt1;
    localbhir.b = paramInt2;
    localbhir.jdField_a_of_type_JavaLangString = paramString;
    localbhir.c = paramInt3;
    this.jdField_a_of_type_Bhoe.obtainMessage(12316, localbhir).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12316) {
      a((bhir)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 12315) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl
 * JD-Core Version:    0.7.0.1
 */