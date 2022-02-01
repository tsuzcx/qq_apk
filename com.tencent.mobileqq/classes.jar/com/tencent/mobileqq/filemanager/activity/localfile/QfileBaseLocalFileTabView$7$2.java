package com.tencent.mobileqq.filemanager.activity.localfile;

import atdq;
import atlj;
import auea;
import bmuf;
import com.tencent.mobileqq.app.QQAppInterface;

public class QfileBaseLocalFileTabView$7$2
  implements Runnable
{
  public QfileBaseLocalFileTabView$7$2(atdq paramatdq, long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Atdq.a.f();
    QfileBaseLocalFileTabView.d(this.jdField_a_of_type_Atdq.a).getFileManagerRSCenter().a(this.jdField_a_of_type_Long);
    if (!this.jdField_a_of_type_Boolean)
    {
      auea.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      bmuf.a(this.jdField_a_of_type_Atdq.a.a, this.jdField_a_of_type_Int);
      return;
    }
    auea.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2
 * JD-Core Version:    0.7.0.1
 */