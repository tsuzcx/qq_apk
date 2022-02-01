package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Handler;
import android.util.SparseArray;
import aziu;
import azjb;
import azjm;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;

public class AutoStatusManager$3
  implements Runnable
{
  public AutoStatusManager$3(aziu paramaziu) {}
  
  public void run()
  {
    if (!AppInterface.isAppOnForeground(BaseApplicationImpl.getApplication()))
    {
      this.this$0.d("schedule");
      return;
    }
    aziu.a(this.this$0).b();
    if ((azjb.jdField_a_of_type_AndroidUtilSparseArray == null) || (azjb.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {
      aziu.a(this.this$0);
    }
    if ((azjb.jdField_a_of_type_JavaUtilList == null) || (azjb.jdField_a_of_type_JavaUtilList.isEmpty())) {
      aziu.b(this.this$0);
    }
    if ((azjb.jdField_a_of_type_AndroidUtilSparseArray != null) && (azjb.jdField_a_of_type_AndroidUtilSparseArray.size() > 0) && (azjb.jdField_a_of_type_JavaUtilList != null) && (!azjb.jdField_a_of_type_JavaUtilList.isEmpty())) {
      aziu.c(this.this$0);
    }
    aziu.a(this.this$0).postDelayed(this, azjb.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.3
 * JD-Core Version:    0.7.0.1
 */