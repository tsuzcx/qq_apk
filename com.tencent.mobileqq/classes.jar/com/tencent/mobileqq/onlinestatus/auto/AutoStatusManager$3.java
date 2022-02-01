package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Handler;
import android.util.SparseArray;
import axwc;
import axwj;
import axwu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;

public class AutoStatusManager$3
  implements Runnable
{
  public AutoStatusManager$3(axwc paramaxwc) {}
  
  public void run()
  {
    if (!AppInterface.isAppOnForeground(BaseApplicationImpl.getApplication()))
    {
      this.this$0.d("schedule");
      return;
    }
    axwc.a(this.this$0).b();
    if ((axwj.jdField_a_of_type_AndroidUtilSparseArray == null) || (axwj.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {
      axwc.a(this.this$0);
    }
    if ((axwj.jdField_a_of_type_JavaUtilList == null) || (axwj.jdField_a_of_type_JavaUtilList.isEmpty())) {
      axwc.b(this.this$0);
    }
    if ((axwj.jdField_a_of_type_AndroidUtilSparseArray != null) && (axwj.jdField_a_of_type_AndroidUtilSparseArray.size() > 0) && (axwj.jdField_a_of_type_JavaUtilList != null) && (!axwj.jdField_a_of_type_JavaUtilList.isEmpty())) {
      axwc.c(this.this$0);
    }
    axwc.a(this.this$0).postDelayed(this, axwj.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.3
 * JD-Core Version:    0.7.0.1
 */