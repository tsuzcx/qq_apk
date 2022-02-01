package com.tencent.mobileqq.onlinestatus.manager;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.mobileqq.onlinestatus.auto.location.LocationBaseStateDetector;
import com.tencent.mobileqq.utils.ProcessUtil;
import java.util.List;
import mqq.app.MobileQQ;

class AutoStatusManager$3
  implements Runnable
{
  AutoStatusManager$3(AutoStatusManager paramAutoStatusManager) {}
  
  public void run()
  {
    if (!ProcessUtil.a(MobileQQ.sMobileQQ))
    {
      this.this$0.d("schedule");
      return;
    }
    this.this$0.a.b();
    if ((Constant.jdField_a_of_type_AndroidUtilSparseArray == null) || (Constant.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {
      AutoStatusManager.a(this.this$0);
    }
    if ((Constant.jdField_a_of_type_JavaUtilList == null) || (Constant.jdField_a_of_type_JavaUtilList.isEmpty())) {
      AutoStatusManager.b(this.this$0);
    }
    if ((Constant.jdField_a_of_type_AndroidUtilSparseArray != null) && (Constant.jdField_a_of_type_AndroidUtilSparseArray.size() > 0) && (Constant.jdField_a_of_type_JavaUtilList != null) && (!Constant.jdField_a_of_type_JavaUtilList.isEmpty())) {
      AutoStatusManager.c(this.this$0);
    }
    AutoStatusManager.a(this.this$0).postDelayed(this, Constant.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager.3
 * JD-Core Version:    0.7.0.1
 */