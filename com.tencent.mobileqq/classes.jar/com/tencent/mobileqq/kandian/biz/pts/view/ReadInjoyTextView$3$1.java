package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyTextView$3$1
  implements Runnable
{
  ReadInjoyTextView$3$1(ReadInjoyTextView.3 param3, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setNickName callback, nick = ", this.a.nick });
    this.b.b.setText(RIJStringUtils.a(this.a.nick));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.3.1
 * JD-Core Version:    0.7.0.1
 */