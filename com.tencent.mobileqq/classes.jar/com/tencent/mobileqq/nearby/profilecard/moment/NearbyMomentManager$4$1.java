package com.tencent.mobileqq.nearby.profilecard.moment;

import axen;
import axer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class NearbyMomentManager$4$1
  implements Runnable
{
  public NearbyMomentManager$4$1(axer paramaxer, List paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    List localList = axen.a(this.jdField_a_of_type_Axer.a, this.jdField_a_of_type_JavaUtilList);
    Object localObject;
    if (localList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyMomentManager", 2, "momentFeedInfoList is null");
      }
      localObject = new ArrayList();
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.4.1.1(this, (List)localObject));
      return;
      localObject = localList;
      if (QLog.isColorLevel())
      {
        QLog.i("NearbyMomentManager", 2, "momentFeedInfoList, size=" + this.jdField_a_of_type_JavaUtilList.size());
        localObject = localList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.4.1
 * JD-Core Version:    0.7.0.1
 */