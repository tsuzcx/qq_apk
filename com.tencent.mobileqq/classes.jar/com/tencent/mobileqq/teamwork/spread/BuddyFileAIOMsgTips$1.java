package com.tencent.mobileqq.teamwork.spread;

import aper;
import ayha;
import ayhd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class BuddyFileAIOMsgTips$1
  implements Runnable
{
  public BuddyFileAIOMsgTips$1(ayhd paramayhd, ayha paramayha) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_JavaLangString);
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileAIOMsgTips", 1, "current AIO has not File,peerType[" + this.this$0.jdField_a_of_type_Int + "]");
      }
      this.a.a(new ArrayList());
      return;
    }
    ThreadManager.post(new BuddyFileAIOMsgTips.1.1(this, localList), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1
 * JD-Core Version:    0.7.0.1
 */