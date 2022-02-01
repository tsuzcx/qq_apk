package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class BuddyFileDataLineMsgTips$1
  implements Runnable
{
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(this.this$0.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ThreadManager.post(new BuddyFileDataLineMsgTips.1.1(this, (List)localObject), 8, null, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current AIO has not File,peerType[");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("]");
      QLog.i("BuddyFileDataLineMsgTips", 1, ((StringBuilder)localObject).toString());
    }
    this.a.a(new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileDataLineMsgTips.1
 * JD-Core Version:    0.7.0.1
 */