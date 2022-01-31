package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TaskStatus
{
  private float jdField_a_of_type_Float;
  private final DownloadTask jdField_a_of_type_ComTencentMobileqqVipDownloadTask;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  
  public TaskStatus(String paramString, DownloadTask paramDownloadTask)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = paramDownloadTask;
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask != null) {
      return this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.jdField_a_of_type_Float;
    }
    return this.jdField_a_of_type_Float;
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask != null) {
      return this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a();
    }
    return (Bundle)((VasExtensionManager)paramQQAppInterface.getManager(234)).a.a.get(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a(true);
    }
    String str;
    do
    {
      return;
      str = "bqmall.android.h5magic." + this.jdField_a_of_type_JavaLangString + ".zip";
      paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(183);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(1004L, str);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.TaskStatus
 * JD-Core Version:    0.7.0.1
 */