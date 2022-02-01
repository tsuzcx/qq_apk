package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ForwardBaseOption$17
  extends DiscussionObserver
{
  ForwardBaseOption$17(ForwardBaseOption paramForwardBaseOption) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "updateDiscussionInfo start: isSuccess=" + paramBoolean);
    }
    String str = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
    paramObject = (ArrayList)paramObject;
    int i = paramObject.indexOf(str);
    if (i != -1)
    {
      paramObject = (Boolean)paramObject.get(i + 1);
      if ((paramBoolean) && (paramObject.booleanValue()))
      {
        paramObject = ((DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(str);
        if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.discussionName)) && (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(HardCodeUtil.a(2131704759) + ForwardConstants.g + paramObject.discussionName);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.17
 * JD-Core Version:    0.7.0.1
 */