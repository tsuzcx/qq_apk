package com.tencent.mobileqq.troop.homework.entry.ui;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.util.InputMethodUtil;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

class PublishHomeWorkFragment$10
  implements QQPermissionCallback
{
  PublishHomeWorkFragment$10(PublishHomeWorkFragment paramPublishHomeWorkFragment, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = TroopHWJsPlugin.a(10 - this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.a.getCurrentAccountUin());
    paramArrayOfString.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.startActivityForResult(paramArrayOfString, 259);
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.10
 * JD-Core Version:    0.7.0.1
 */