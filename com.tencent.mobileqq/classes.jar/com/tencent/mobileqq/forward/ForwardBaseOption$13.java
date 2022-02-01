package com.tencent.mobileqq.forward;

import android.os.Bundle;
import aupt;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ForwardBaseOption$13
  implements Runnable
{
  public ForwardBaseOption$13(aupt paramaupt, String paramString, QQCustomDialog paramQQCustomDialog) {}
  
  public void run()
  {
    Object localObject1;
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      localObject2 = aupt.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label83;
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView getNormalDrawable null");
      }
    }
    do
    {
      return;
      localObject2 = aupt.a(this.this$0);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardBaseOption", 2, "updateImageView getURLDrawable null");
    return;
    label83:
    this.this$0.a(localObject1, this.this$0.jdField_a_of_type_Boolean);
    Object localObject2 = (ArrayList)this.this$0.jdField_a_of_type_AndroidOsBundle.get("PhotoConst.PHOTO_PATHS");
    aupt localaupt = this.this$0;
    if (localObject2 != null) {}
    for (int i = ((ArrayList)localObject2).size();; i = 0)
    {
      localaupt.a(localObject1, true, i, this.this$0.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.13
 * JD-Core Version:    0.7.0.1
 */