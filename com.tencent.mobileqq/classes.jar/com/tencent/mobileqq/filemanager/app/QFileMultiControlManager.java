package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.multisave.QFileControlReq;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class QFileMultiControlManager
{
  private boolean a = false;
  private QQAppInterface b;
  private ConcurrentHashMap<String, QFileControlReq> c;
  private FMObserver d = new QFileMultiControlManager.1(this);
  private BizTroopObserver e = new QFileMultiControlManager.2(this);
  private DataLineObserver f = new QFileMultiControlManager.3(this);
  
  public QFileMultiControlManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private void c()
  {
    if (this.d != null) {
      this.b.getFileManagerNotifyCenter().addObserver(this.d);
    }
    BizTroopObserver localBizTroopObserver = this.e;
    if (localBizTroopObserver != null) {
      this.b.addObserver(localBizTroopObserver);
    }
    if (this.f != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.f);
    }
  }
  
  private void d()
  {
    if (this.d != null) {
      this.b.getFileManagerNotifyCenter().deleteObserver(this.d);
    }
    BizTroopObserver localBizTroopObserver = this.e;
    if (localBizTroopObserver != null) {
      this.b.removeObserver(localBizTroopObserver);
    }
    if (this.f != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.f);
    }
  }
  
  public QFileControlReq a(String paramString1, String paramString2, String paramString3)
  {
    if (this.c == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return null;
    }
    paramString1 = QFileControlReq.a(paramString1, paramString2, paramString3);
    return (QFileControlReq)this.c.get(paramString1);
  }
  
  public void a()
  {
    if (this.a) {
      return;
    }
    QLog.i("QFileMultiControlManager<QFile>", 1, "initFileControlManager");
    this.a = true;
    c();
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.c = new ConcurrentHashMap();
  }
  
  public void a(QFileControlReq paramQFileControlReq)
  {
    if (this.c == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    if (paramQFileControlReq == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req is null.");
      return;
    }
    String str = paramQFileControlReq.a();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "controlKey is null.");
      return;
    }
    this.c.put(paramQFileControlReq.a(), paramQFileControlReq);
    paramQFileControlReq = new StringBuilder();
    paramQFileControlReq.append("addFileControlReq: controlKey[");
    paramQFileControlReq.append(str);
    paramQFileControlReq.append("]");
    QLog.e("QFileMultiControlManager<QFile>", 1, paramQFileControlReq.toString());
  }
  
  public void b()
  {
    QLog.i("QFileMultiControlManager<QFile>", 1, "clearFileControlManager");
    this.a = false;
    d();
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.c = null;
  }
  
  public void b(QFileControlReq paramQFileControlReq)
  {
    if (this.c == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    paramQFileControlReq = paramQFileControlReq.a();
    this.c.remove(paramQFileControlReq);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeFileContolReq: controlKey[");
    localStringBuilder.append(paramQFileControlReq);
    localStringBuilder.append("]");
    QLog.e("QFileMultiControlManager<QFile>", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMultiControlManager
 * JD-Core Version:    0.7.0.1
 */