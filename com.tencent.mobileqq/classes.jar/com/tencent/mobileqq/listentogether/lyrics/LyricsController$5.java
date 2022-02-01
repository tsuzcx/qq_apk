package com.tencent.mobileqq.listentogether.lyrics;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class LyricsController$5
  implements Runnable
{
  LyricsController$5(LyricsController paramLyricsController) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResumed: mHoldByPermissionType:");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" mHoldByPermissionUin:");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangString);
      QLog.d("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    ((LyricsController)localObject).h += 1;
    if ((LyricsController.a(this.this$0)) && (this.this$0.jdField_a_of_type_Int != -1) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)))
    {
      localObject = this.this$0;
      ((LyricsController)localObject).a(((LyricsController)localObject).jdField_a_of_type_Int, this.this$0.jdField_a_of_type_JavaLangString);
    }
    if (this.this$0.h >= 3)
    {
      localObject = this.this$0;
      ((LyricsController)localObject).c = false;
      ((LyricsController)localObject).h = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.5
 * JD-Core Version:    0.7.0.1
 */