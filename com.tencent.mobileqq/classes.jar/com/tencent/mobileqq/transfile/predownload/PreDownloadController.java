package com.tencent.mobileqq.transfile.predownload;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class PreDownloadController
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PreDownloadScheduler jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadScheduler;
  private boolean jdField_a_of_type_Boolean;
  
  public PreDownloadController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("serializePreDownload", true);
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadScheduler = ((PreDownloadScheduler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(232));
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadScheduler.b(this.jdField_a_of_type_Boolean);
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    return PreDownloadScheduler.a(paramInt, paramString, paramBoolean);
  }
  
  public static ArrayList a(int paramInt1, int paramInt2)
  {
    return new ArrayList(5);
  }
  
  public AbsPreDownloadTask a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadScheduler.a(paramString);
  }
  
  void a(AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Controller", 2, "onTaskEnd: " + paramAbsPreDownloadTask);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadScheduler.a(paramAbsPreDownloadTask);
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadScheduler.a(paramString, paramLong);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadSchedulePreDownloadScheduler.a(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramBoolean, paramAbsPreDownloadTask);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.PreDownloadController
 * JD-Core Version:    0.7.0.1
 */