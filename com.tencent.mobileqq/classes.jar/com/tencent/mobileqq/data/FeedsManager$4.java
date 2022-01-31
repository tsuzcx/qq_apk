package com.tencent.mobileqq.data;

import atmp;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.qphone.base.util.QLog;

class FeedsManager$4
  implements Runnable
{
  FeedsManager$4(FeedsManager paramFeedsManager, FeedInfo paramFeedInfo, String paramString) {}
  
  public void run()
  {
    if (FeedsManager.access$000(this.this$0) != null)
    {
      boolean bool = FeedsManager.access$000(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqDataQzoneFeedInfo);
      if (QLog.isColorLevel()) {
        QLog.e("FeedsManager", 2, "setFeedInfoRead  :" + this.jdField_a_of_type_JavaLangString + " ,success:" + bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager.4
 * JD-Core Version:    0.7.0.1
 */