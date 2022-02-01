package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyListViewGroup$8
  extends FriendListObserver
{
  ReadInJoyListViewGroup$8(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((this.a.a == 0) || (this.a.a == 70)) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFriendInfo uin:");
      localStringBuilder.append(paramString);
      QLog.d("ReadInJoyListViewGroup", 1, localStringBuilder.toString());
      this.a.n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup.8
 * JD-Core Version:    0.7.0.1
 */