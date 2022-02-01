package com.tencent.mobileqq.nearby;

import android.os.Handler;
import axpw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class NearbyRedDotFaceController$2
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyRedDotFaceController", 2, "run, mCurIndex=" + this.this$0.jdField_a_of_type_Int);
      }
      if (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return;
      }
      if (this.this$0.jdField_a_of_type_Int >= this.this$0.jdField_a_of_type_JavaUtilArrayList.size()) {
        this.this$0.jdField_a_of_type_Int = 0;
      }
      this.this$0.a((String)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.this$0.jdField_a_of_type_Int));
      axpw localaxpw2 = this.this$0;
      localaxpw2.jdField_a_of_type_Int += 1;
      if (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 3000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRedDotFaceController.2
 * JD-Core Version:    0.7.0.1
 */