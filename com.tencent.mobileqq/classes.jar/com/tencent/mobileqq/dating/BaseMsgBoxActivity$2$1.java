package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.Iterator;
import java.util.List;

class BaseMsgBoxActivity$2$1
  implements Runnable
{
  BaseMsgBoxActivity$2$1(BaseMsgBoxActivity.2 param2, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDatingBaseMsgBoxActivity$2.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingBaseMsgBoxActivity$2.a.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDatingBaseMsgBoxActivity$2.a.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData.getRecentUserUin().equals(this.jdField_a_of_type_JavaLangString))
        {
          localRecentBaseData.mTitleName = this.b;
          this.jdField_a_of_type_ComTencentMobileqqDatingBaseMsgBoxActivity$2.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDatingBaseMsgBoxActivity$2.a.jdField_a_of_type_Int);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.2.1
 * JD-Core Version:    0.7.0.1
 */