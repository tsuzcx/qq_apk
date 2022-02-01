package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyProteusFamilyListViewGroup$7
  extends FriendListObserver
{
  ReadInJoyProteusFamilyListViewGroup$7(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (((ReadInJoyProteusFamilyListViewGroup.d(this.a) == 0) || (ReadInJoyProteusFamilyListViewGroup.e(this.a) == 70)) && (paramBoolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFriendInfo uin:");
      localStringBuilder.append(paramString);
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 1, localStringBuilder.toString());
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup.7
 * JD-Core Version:    0.7.0.1
 */