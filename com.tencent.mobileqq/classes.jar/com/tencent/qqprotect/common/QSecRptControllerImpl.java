package com.tencent.qqprotect.common;

import android.os.Handler.Callback;
import android.os.Message;
import bbev;
import bfhc;
import bfhe;
import bfhg;
import bfmt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.app.MobileQQ;
import mxi;

public class QSecRptControllerImpl
  extends bfhc
  implements Handler.Callback
{
  private static volatile bfhc jdField_a_of_type_Bfhc;
  private final long jdField_a_of_type_Long = 300000L;
  private bfmt jdField_a_of_type_Bfmt = new bfmt(ThreadManager.getSubThreadLooper(), this);
  private QSecRptControllerImpl.ReportRunnable jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable;
  private final Vector<bfhg> jdField_a_of_type_JavaUtilVector = new Vector();
  
  private QSecRptControllerImpl()
  {
    this.jdField_a_of_type_Bfmt.sendEmptyMessageDelayed(12315, 300000L);
  }
  
  public static bfhc a()
  {
    if (jdField_a_of_type_Bfhc == null) {}
    try
    {
      if (jdField_a_of_type_Bfhc == null) {
        jdField_a_of_type_Bfhc = new QSecRptControllerImpl();
      }
      return jdField_a_of_type_Bfhc;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bfmt.removeMessages(12315);
    b();
    this.jdField_a_of_type_Bfmt.sendEmptyMessageDelayed(12315, this.jdField_a_of_type_Long);
  }
  
  private void a(bfhg parambfhg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(parambfhg);
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("add report: totally %d items in cache", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()) }));
      }
      if ((parambfhg.c == 2) || (this.jdField_a_of_type_JavaUtilVector.size() >= 40)) {
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
    mxi.a((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), new bfhe(this), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  private void b()
  {
    if (!bbev.d(BaseApplicationImpl.sApplication)) {}
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
    bfhg localbfhg = new bfhg();
    localbfhg.jdField_a_of_type_Int = paramInt1;
    localbfhg.b = paramInt2;
    localbfhg.jdField_a_of_type_JavaLangString = paramString;
    localbfhg.c = paramInt3;
    this.jdField_a_of_type_Bfmt.obtainMessage(12316, localbfhg).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12316) {
      a((bfhg)paramMessage.obj);
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