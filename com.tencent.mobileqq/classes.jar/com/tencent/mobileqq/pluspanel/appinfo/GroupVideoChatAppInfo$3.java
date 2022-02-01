package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVHrMeeting;

final class GroupVideoChatAppInfo$3
  implements DialogInterface.OnClickListener
{
  GroupVideoChatAppInfo$3(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), null);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo.3
 * JD-Core Version:    0.7.0.1
 */