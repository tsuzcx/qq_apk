package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyTextView$1$1
  implements Runnable
{
  ReadInjoyTextView$1$1(ReadInjoyTextView.1 param1, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setContentWithNickName callback, nick = ", this.a.nick });
    this.b.c.setText(ReadInjoyTextView.a(this.b.c, this.b.b, RIJStringUtils.a(this.a.nick)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.1.1
 * JD-Core Version:    0.7.0.1
 */