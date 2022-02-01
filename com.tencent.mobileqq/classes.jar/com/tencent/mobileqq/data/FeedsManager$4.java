package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class FeedsManager$4
  implements Runnable
{
  FeedsManager$4(FeedsManager paramFeedsManager, FeedInfo paramFeedInfo, String paramString) {}
  
  public void run()
  {
    try
    {
      if (FeedsManager.access$000(this.this$0) != null)
      {
        boolean bool = FeedsManager.access$000(this.this$0).update(this.jdField_a_of_type_ComTencentMobileqqDataQzoneFeedInfo);
        if (QLog.isColorLevel()) {
          QLog.e("FeedsManager", 2, "setFeedInfoRead  :" + this.jdField_a_of_type_JavaLangString + " ,success:" + bool);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FeedsManager", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager.4
 * JD-Core Version:    0.7.0.1
 */