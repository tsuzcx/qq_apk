package com.tencent.mobileqq.dating;

import ajit;
import aphs;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.Iterator;
import java.util.List;

public class BaseMsgBoxActivity$1$2
  implements Runnable
{
  public BaseMsgBoxActivity$1$2(aphs paramaphs, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aphs.a.jdField_a_of_type_Ajit != null) && (this.jdField_a_of_type_Aphs.a.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_Aphs.a.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData.a().equals(this.jdField_a_of_type_JavaLangString))
        {
          localRecentBaseData.mTitleName = this.b;
          this.jdField_a_of_type_Aphs.a.jdField_a_of_type_Ajit.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aphs.a.jdField_a_of_type_Int);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.1.2
 * JD-Core Version:    0.7.0.1
 */