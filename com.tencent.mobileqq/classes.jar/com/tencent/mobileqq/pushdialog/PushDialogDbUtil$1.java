package com.tencent.mobileqq.pushdialog;

import atmp;
import audw;
import audx;
import com.tencent.TMG.utils.QLog;
import java.util.Date;
import java.util.List;

public class PushDialogDbUtil$1
  implements Runnable
{
  public PushDialogDbUtil$1(audw paramaudw, atmp paramatmp, String[] paramArrayOfString, long paramLong1, long paramLong2, audx paramaudx) {}
  
  public void run()
  {
    synchronized (audw.a(this.this$0))
    {
      List localList = this.jdField_a_of_type_Atmp.a(PushDialogTemplate.class, true, "mUin=? AND time>=?", this.jdField_a_of_type_ArrayOfJavaLangString, null, null, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("PushDialogDbUtil", 3, "PushDialogTemplate query: " + this.jdField_a_of_type_Long + ", queryTime: " + new Date(this.b));
      }
      if (this.jdField_a_of_type_Audx != null) {
        this.jdField_a_of_type_Audx.a(localList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1
 * JD-Core Version:    0.7.0.1
 */