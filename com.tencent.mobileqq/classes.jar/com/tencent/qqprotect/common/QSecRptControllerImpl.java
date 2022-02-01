package com.tencent.qqprotect.common;

import android.os.Handler.Callback;
import android.os.Message;
import bksv;
import bksx;
import bksz;
import bkyc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.app.MobileQQ;
import ntb;

public class QSecRptControllerImpl
  extends bksv
  implements Handler.Callback
{
  private static volatile bksv jdField_a_of_type_Bksv;
  private final long jdField_a_of_type_Long = 300000L;
  private bkyc jdField_a_of_type_Bkyc = new bkyc(ThreadManager.getSubThreadLooper(), this);
  private QSecRptControllerImpl.ReportRunnable jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable;
  private final Vector<bksz> jdField_a_of_type_JavaUtilVector = new Vector();
  
  private QSecRptControllerImpl()
  {
    this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(12315, 300000L);
  }
  
  public static bksv a()
  {
    if (jdField_a_of_type_Bksv == null) {}
    try
    {
      if (jdField_a_of_type_Bksv == null) {
        jdField_a_of_type_Bksv = new QSecRptControllerImpl();
      }
      return jdField_a_of_type_Bksv;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bkyc.removeMessages(12315);
    b();
    this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(12315, this.jdField_a_of_type_Long);
  }
  
  private void a(bksz parambksz)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(parambksz);
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("add report: totally %d items in cache", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()) }));
      }
      if ((parambksz.c == 2) || (this.jdField_a_of_type_JavaUtilVector.size() >= 40)) {
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
    ntb.a((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), new bksx(this), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  private void b()
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication)) {}
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
    bksz localbksz = new bksz();
    localbksz.jdField_a_of_type_Int = paramInt1;
    localbksz.b = paramInt2;
    localbksz.jdField_a_of_type_JavaLangString = paramString;
    localbksz.c = paramInt3;
    this.jdField_a_of_type_Bkyc.obtainMessage(12316, localbksz).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12316) {
      a((bksz)paramMessage.obj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl
 * JD-Core Version:    0.7.0.1
 */