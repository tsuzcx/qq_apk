package com.tencent.mobileqq.transfile.predownload;

import aixk;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class AbsPreDownloadTask
{
  protected Handler a;
  public QQAppInterface a;
  protected PreDownloadController a;
  public Object a;
  public String d;
  
  public AbsPreDownloadTask(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.d = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public abstract void a();
  
  public final void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aixk(this));
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.d + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
 * JD-Core Version:    0.7.0.1
 */