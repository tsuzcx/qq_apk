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
  private static volatile QSecRptController a;
  private MqqWeakReferenceHandler b = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
  private final Vector<QSecRptItem> c = new Vector();
  private QSecRptControllerImpl.ReportRunnable d = null;
  private final long e = 300000L;
  
  private QSecRptControllerImpl()
  {
    this.b.sendEmptyMessageDelayed(12315, 300000L);
  }
  
  public static QSecRptController a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QSecRptControllerImpl();
        }
      }
      finally {}
    }
    return a;
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
    synchronized (this.c)
    {
      this.c.add(paramQSecRptItem);
      if (QLog.isColorLevel()) {
        QLog.d("QSRPT", 2, String.format("add report: totally %d items in cache", new Object[] { Integer.valueOf(this.c.size()) }));
      }
      if ((paramQSecRptItem.d == 2) || (this.c.size() >= 40)) {
        c();
      }
      return;
    }
  }
  
  private void b()
  {
    this.b.removeMessages(12315);
    c();
    this.b.sendEmptyMessageDelayed(12315, this.e);
  }
  
  private void c()
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication)) {
      return;
    }
    this.d = new QSecRptControllerImpl.ReportRunnable(this, null);
    if (this.d != null) {
      synchronized (this.c)
      {
        QSecRptControllerImpl.ReportRunnable.a(this.d).addAll(this.c);
        this.c.removeAllElements();
        ThreadManager.post(this.d, 5, null, true);
        return;
      }
    }
  }
  
  protected void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QSecRptItem localQSecRptItem = new QSecRptItem();
    localQSecRptItem.a = paramInt1;
    localQSecRptItem.b = paramInt2;
    localQSecRptItem.c = paramString;
    localQSecRptItem.d = paramInt3;
    this.b.obtainMessage(12316, localQSecRptItem).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 12316) {
      a((QSecRptItem)paramMessage.obj);
    } else if (paramMessage.what == 12315) {
      b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptControllerImpl
 * JD-Core Version:    0.7.0.1
 */