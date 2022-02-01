package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Handler;
import android.util.SparseArray;
import ayqb;
import ayqi;
import ayqt;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;

public class AutoStatusManager$3
  implements Runnable
{
  public AutoStatusManager$3(ayqb paramayqb) {}
  
  public void run()
  {
    if (!AppInterface.isAppOnForeground(BaseApplicationImpl.getApplication()))
    {
      this.this$0.d("schedule");
      return;
    }
    ayqb.a(this.this$0).b();
    if ((ayqi.jdField_a_of_type_AndroidUtilSparseArray == null) || (ayqi.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {
      ayqb.a(this.this$0);
    }
    if ((ayqi.jdField_a_of_type_JavaUtilList == null) || (ayqi.jdField_a_of_type_JavaUtilList.isEmpty())) {
      ayqb.b(this.this$0);
    }
    if ((ayqi.jdField_a_of_type_AndroidUtilSparseArray != null) && (ayqi.jdField_a_of_type_AndroidUtilSparseArray.size() > 0) && (ayqi.jdField_a_of_type_JavaUtilList != null) && (!ayqi.jdField_a_of_type_JavaUtilList.isEmpty())) {
      ayqb.c(this.this$0);
    }
    ayqb.a(this.this$0).postDelayed(this, ayqi.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.3
 * JD-Core Version:    0.7.0.1
 */