package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Handler;
import android.util.SparseArray;
import azco;
import azcv;
import azdg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;

public class AutoStatusManager$3
  implements Runnable
{
  public AutoStatusManager$3(azco paramazco) {}
  
  public void run()
  {
    if (!AppInterface.isAppOnForeground(BaseApplicationImpl.getApplication()))
    {
      this.this$0.d("schedule");
      return;
    }
    azco.a(this.this$0).b();
    if ((azcv.jdField_a_of_type_AndroidUtilSparseArray == null) || (azcv.jdField_a_of_type_AndroidUtilSparseArray.size() == 0)) {
      azco.a(this.this$0);
    }
    if ((azcv.jdField_a_of_type_JavaUtilList == null) || (azcv.jdField_a_of_type_JavaUtilList.isEmpty())) {
      azco.b(this.this$0);
    }
    if ((azcv.jdField_a_of_type_AndroidUtilSparseArray != null) && (azcv.jdField_a_of_type_AndroidUtilSparseArray.size() > 0) && (azcv.jdField_a_of_type_JavaUtilList != null) && (!azcv.jdField_a_of_type_JavaUtilList.isEmpty())) {
      azco.c(this.this$0);
    }
    azco.a(this.this$0).postDelayed(this, azcv.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.3
 * JD-Core Version:    0.7.0.1
 */