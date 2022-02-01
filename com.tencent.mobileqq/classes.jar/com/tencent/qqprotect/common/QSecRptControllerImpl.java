package com.tencent.qqprotect.common;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.SafeReport.ReqBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Vector;
import mqq.app.MobileQQ;

public class QSecRptControllerImpl
  extends QSecRptController
  implements Handler.Callback
{
  private static volatile QSecRptController jdField_a_of_type_ComTencentQqprotectCommonQSecRptController = null;
  private final long jdField_a_of_type_Long = 300000L;
  private QSecRptControllerImpl.ReportRunnable jdField_a_of_type_ComTencentQqprotectCommonQSecRptControllerImpl$ReportRunnable = null;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  private final Vector<QSecRptItem> jdField_a_of_type_JavaUtilVector = new Vector();
  
  private QSecRptControllerImpl()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(12315, 300000L);
  }
  
  public static QSecRptController a()
  {
    if (jdField_a_of_type_ComTencentQqprotectCommonQSecRptController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqprotectCommonQSecRptController == null) {
        jdField_a_of_type_ComTencentQqprotectCommonQSecRptController = new QSecRptControllerImpl();
      }
      return jdField_a_of_type_ComTencentQqprotectCommonQSecRptController;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(12315);
    b();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(12315, this.jdField_a_of_type_Long);
  }
  
  private void a(SafeReport.ReqBody paramReqBody)
  {
    if (paramReqBody == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSRPT", 2, String.format("totally sending report: %d items", new Object[] { Integer.valueOf(paramReqBody.LogItem_reportdata.size()) }));
    }
    ProtoUtils.a((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), new QSecRptControllerImpl.1(this), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  private void a(QSecRptItem paramQSecRptItem)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramQSecRptItem);
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("add report: totally %d items in cache", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilVector.size()) }));
      }
      if ((paramQSecRptItem.c == 2) || (this.jdField_a_of_type_JavaUtilVector.size() >= 40)) {
        b();
      }
      return;
    }
  }
  
  private void b()
  {
    if (!NetworkUtil.d(BaseApplicationImpl.sApplication)) {}
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
  
  protected void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QSecRptItem localQSecRptItem = new QSecRptItem();
    localQSecRptItem.jdField_a_of_type_Int = paramInt1;
    localQSecRptItem.b = paramInt2;
    localQSecRptItem.jdField_a_of_type_JavaLangString = paramString;
    localQSecRptItem.c = paramInt3;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(12316, localQSecRptItem).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12316) {
      a((QSecRptItem)paramMessage.obj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl
 * JD-Core Version:    0.7.0.1
 */