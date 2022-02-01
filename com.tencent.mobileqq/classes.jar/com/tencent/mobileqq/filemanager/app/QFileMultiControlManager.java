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
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new QFileMultiControlManager.2(this);
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new QFileMultiControlManager.3(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new QFileMultiControlManager.1(this);
  private ConcurrentHashMap<String, QFileControlReq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QFileMultiControlManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    BizTroopObserver localBizTroopObserver = this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
    if (localBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(localBizTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    BizTroopObserver localBizTroopObserver = this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
    if (localBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localBizTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  public QFileControlReq a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return null;
    }
    paramString1 = QFileControlReq.a(paramString1, paramString2, paramString3);
    return (QFileControlReq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("QFileMultiControlManager<QFile>", 1, "initFileControlManager");
    this.jdField_a_of_type_Boolean = true;
    c();
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public void a(QFileControlReq paramQFileControlReq)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
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
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQFileControlReq.a(), paramQFileControlReq);
    paramQFileControlReq = new StringBuilder();
    paramQFileControlReq.append("addFileControlReq: controlKey[");
    paramQFileControlReq.append(str);
    paramQFileControlReq.append("]");
    QLog.e("QFileMultiControlManager<QFile>", 1, paramQFileControlReq.toString());
  }
  
  public void b()
  {
    QLog.i("QFileMultiControlManager<QFile>", 1, "clearFileControlManager");
    this.jdField_a_of_type_Boolean = false;
    d();
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
  
  public void b(QFileControlReq paramQFileControlReq)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    paramQFileControlReq = paramQFileControlReq.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramQFileControlReq);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeFileContolReq: controlKey[");
    localStringBuilder.append(paramQFileControlReq);
    localStringBuilder.append("]");
    QLog.e("QFileMultiControlManager<QFile>", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMultiControlManager
 * JD-Core Version:    0.7.0.1
 */