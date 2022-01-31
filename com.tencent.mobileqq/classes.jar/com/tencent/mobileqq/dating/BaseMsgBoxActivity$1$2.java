package com.tencent.mobileqq.dating;

import ahai;
import amvp;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.Iterator;
import java.util.List;

public class BaseMsgBoxActivity$1$2
  implements Runnable
{
  public BaseMsgBoxActivity$1$2(amvp paramamvp, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Amvp.a.jdField_a_of_type_Ahai != null) && (this.jdField_a_of_type_Amvp.a.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_Amvp.a.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData.a().equals(this.jdField_a_of_type_JavaLangString))
        {
          localRecentBaseData.mTitleName = this.b;
          this.jdField_a_of_type_Amvp.a.jdField_a_of_type_Ahai.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Amvp.a.jdField_a_of_type_Int);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.1.2
 * JD-Core Version:    0.7.0.1
 */