package com.tencent.qqprotect.common;

import amdw;
import amdx;
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
  private static volatile QSecRptController jdField_a_of_type_ComTencentQqprotectCommonQSecRptController;
  private final long jdField_a_of_type_Long;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
  private final Vector jdField_a_of_type_JavaUtilVector = new Vector(2);
  private boolean jdField_a_of_type_Boolean;
  private Integer b = Integer.valueOf(1);
  
  private QSecRptControllerImpl()
  {
    this.jdField_a_of_type_JavaUtilVector.add(new Vector(40));
    this.jdField_a_of_type_JavaUtilVector.add(new Vector(40));
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Long = 300000L;
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
    int j = 1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangInteger)
      {
        if (this.jdField_a_of_type_JavaLangInteger.intValue() == 0)
        {
          i = 1;
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i);
          if (this.jdField_a_of_type_JavaLangInteger.intValue() != 0) {
            break label99;
          }
          i = j;
          this.b = Integer.valueOf(i);
          if (QLog.isColorLevel()) {
            QLog.d("QSRPT", 2, String.format("switch reporting and caching vector: using %d, reporting %d", new Object[] { this.jdField_a_of_type_JavaLangInteger, this.b }));
          }
          return;
        }
      }
      int i = 0;
      continue;
      label99:
      i = 0;
    }
  }
  
  private void a(SafeReport.ReqBody paramReqBody)
  {
    if (paramReqBody == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QSRPT", 2, String.format("report status: cached(%d): %d items, reporting(%d): %d items, sending: %d items", new Object[] { this.jdField_a_of_type_JavaLangInteger, Integer.valueOf(((Vector)this.jdField_a_of_type_JavaUtilVector.get(this.jdField_a_of_type_JavaLangInteger.intValue())).size()), this.b, Integer.valueOf(((Vector)this.jdField_a_of_type_JavaUtilVector.get(this.b.intValue())).size()), Integer.valueOf(paramReqBody.LogItem_reportdata.size()) }));
    }
    ProtoUtils.a((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), new amdx(this), paramReqBody.toByteArray(), "MqqSafeDataRpt.MQDun");
  }
  
  private void a(QSecRptItem paramQSecRptItem)
  {
    ((Vector)this.jdField_a_of_type_JavaUtilVector.get(this.jdField_a_of_type_JavaLangInteger.intValue())).add(paramQSecRptItem);
    if (QLog.isColorLevel()) {
      QLog.d("QSRPT", 2, String.format("add report: cached(%d): %d items, reporting(%d): %d items", new Object[] { this.jdField_a_of_type_JavaLangInteger, Integer.valueOf(((Vector)this.jdField_a_of_type_JavaUtilVector.get(this.jdField_a_of_type_JavaLangInteger.intValue())).size()), this.b, Integer.valueOf(((Vector)this.jdField_a_of_type_JavaUtilVector.get(this.b.intValue())).size()) }));
    }
    if ((!this.jdField_a_of_type_Boolean) && ((paramQSecRptItem.c == 2) || (((Vector)this.jdField_a_of_type_JavaUtilVector.get(this.jdField_a_of_type_JavaLangInteger.intValue())).size() >= 40)))
    {
      a();
      c();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(12315);
    a();
    c();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(12315, this.jdField_a_of_type_Long);
  }
  
  private void c()
  {
    if (!NetworkUtil.d(BaseApplicationImpl.sApplication)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new amdw(this), 5, null, true);
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
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl
 * JD-Core Version:    0.7.0.1
 */