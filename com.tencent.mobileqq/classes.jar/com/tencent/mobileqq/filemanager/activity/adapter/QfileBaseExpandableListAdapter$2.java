package com.tencent.mobileqq.filemanager.activity.adapter;

import com.tencent.biz.qrcode.CustomAccessibilityDelegate.CallBack;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.QQTextToSpeechHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;

class QfileBaseExpandableListAdapter$2
  implements CustomAccessibilityDelegate.CallBack
{
  QfileBaseExpandableListAdapter$2(QfileBaseExpandableListAdapter paramQfileBaseExpandableListAdapter, int paramInt) {}
  
  public void a()
  {
    String str = (String)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroup(this.jdField_a_of_type_Int);
    if (QfileBaseExpandableListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).isGroupExpanded(this.jdField_a_of_type_Int))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131698204));
      QQTextToSpeechHelper.a(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(HardCodeUtil.a(2131698203));
    QQTextToSpeechHelper.a(localStringBuilder.toString());
  }
  
  public void b()
  {
    QLog.e("ACCESS_SILAS", 1, "onViewFocusClear");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.2
 * JD-Core Version:    0.7.0.1
 */