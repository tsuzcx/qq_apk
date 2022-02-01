package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PendantInfo$2
  implements Runnable
{
  PendantInfo$2(PendantInfo paramPendantInfo, int paramInt, long paramLong, Drawable paramDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getDrawable, Runnable in");
    }
    String str = AvatarPendantUtil.b(this.this$0.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    if (2 == this.jdField_a_of_type_Int) {
      str = AvatarPendantUtil.b(this.this$0.jdField_a_of_type_Long, 8);
    }
    if (FileUtils.fileExists(str))
    {
      if (2 == this.jdField_a_of_type_Int)
      {
        this.this$0.a();
        if (this.this$0.jdField_a_of_type_ArrayOfJavaLangString == null)
        {
          this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
          return;
        }
        PendantInfo.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
        return;
      }
      this.this$0.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false, this.jdField_a_of_type_Long);
      return;
    }
    this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo.2
 * JD-Core Version:    0.7.0.1
 */