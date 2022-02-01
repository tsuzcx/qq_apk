package com.tencent.qqprotect.common;

import android.os.Handler.Callback;
import android.os.Message;
import bhnv;
import blbg;
import blbi;
import blbk;
import blha;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.app.MobileQQ;
import nkm;

public class QSecRptControllerImpl
  extends blbg
  implements Handler.Callback
{
  private static volatile blbg jdField_a_of_type_Blbg;
  private final long jdField_a_of_type_Long = 300000L;
  private blha jdField_a_of_type_Blha = new blha(ThreadManager.getSubThreadLooper(), this);
  private QSecRptControllerImpl.ReportRunnable jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable;
  private final Vector<blbk> jdField_a_of_type_JavaUtilVector = new Vector();
  
  private QSecRptControllerImpl()
  {
    this.jdField_a_of_type_Blha.sendEmptyMessageDelayed(12315, 300000L);
  }
  
  public static blbg a()
  {
    if (jdField_a_of_type_Blbg == null) {}
    try
    {
      if (jdField_a_of_type_Blbg == null) {
        jdField_a_of_type_Blbg = new QSecRptControllerImpl();
      }
      return jdField_a_of_type_Blbg;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_Blha.removeMessages(12315);
    b();
    this.jdField_a_of_type_Blha.sendEmptyMessageDelayed(12315, this.jdField_a_of_type_Long);
  }
  
  private void a(blbk paramblbk)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramblbk);
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("add report: totally %d items in cache", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()) }));
      }
      if ((paramblbk.c == 2) || (this.jdField_a_of_type_JavaUtilVector.size() >= 40)) {
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
    nkm.a((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), new blbi(this), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  private void b()
  {
    if (!bhnv.d(BaseApplicationImpl.sApplication)) {}
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
    blbk localblbk = new blbk();
    localblbk.jdField_a_of_type_Int = paramInt1;
    localblbk.b = paramInt2;
    localblbk.jdField_a_of_type_JavaLangString = paramString;
    localblbk.c = paramInt3;
    this.jdField_a_of_type_Blha.obtainMessage(12316, localblbk).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12316) {
      a((blbk)paramMessage.obj);
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