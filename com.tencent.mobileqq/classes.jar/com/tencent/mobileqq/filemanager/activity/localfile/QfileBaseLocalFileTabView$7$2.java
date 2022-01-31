package com.tencent.mobileqq.filemanager.activity.localfile;

import aosl;
import aoze;
import apue;
import bifs;
import com.tencent.mobileqq.app.QQAppInterface;

public class QfileBaseLocalFileTabView$7$2
  implements Runnable
{
  public QfileBaseLocalFileTabView$7$2(aosl paramaosl, long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aosl.a.f();
    QfileBaseLocalFileTabView.d(this.jdField_a_of_type_Aosl.a).a().a(this.jdField_a_of_type_Long);
    if (!this.jdField_a_of_type_Boolean)
    {
      apue.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      bifs.a(this.jdField_a_of_type_Aosl.a.a, this.jdField_a_of_type_Int);
      return;
    }
    apue.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2
 * JD-Core Version:    0.7.0.1
 */