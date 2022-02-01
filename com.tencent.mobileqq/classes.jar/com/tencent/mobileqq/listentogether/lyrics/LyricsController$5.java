package com.tencent.mobileqq.listentogether.lyrics;

import android.text.TextUtils;
import avuv;
import com.tencent.qphone.base.util.QLog;

public class LyricsController$5
  implements Runnable
{
  public LyricsController$5(avuv paramavuv) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onActivityResumed: mHoldByPermissionType:" + this.this$0.jdField_a_of_type_Int + " mHoldByPermissionUin:" + this.this$0.jdField_a_of_type_JavaLangString);
    }
    avuv localavuv = this.this$0;
    localavuv.h += 1;
    if ((avuv.a(this.this$0)) && (this.this$0.jdField_a_of_type_Int != -1) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString))) {
      this.this$0.a(this.this$0.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_JavaLangString);
    }
    if (this.this$0.h >= 3)
    {
      this.this$0.c = false;
      this.this$0.h = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.5
 * JD-Core Version:    0.7.0.1
 */