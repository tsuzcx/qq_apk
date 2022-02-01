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
    String str = (String)this.b.getGroup(this.a);
    if (QfileBaseExpandableListAdapter.a(this.b).isGroupExpanded(this.a))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131896105));
      QQTextToSpeechHelper.a(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(HardCodeUtil.a(2131896104));
    QQTextToSpeechHelper.a(localStringBuilder.toString());
  }
  
  public void b()
  {
    QLog.e("ACCESS_SILAS", 1, "onViewFocusClear");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.2
 * JD-Core Version:    0.7.0.1
 */