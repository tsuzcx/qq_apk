package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class NearbyMomentManager$4$1
  implements Runnable
{
  NearbyMomentManager$4$1(NearbyMomentManager.4 param4, List paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    List localList = NearbyMomentManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentManager$4.a, this.jdField_a_of_type_JavaUtilList);
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