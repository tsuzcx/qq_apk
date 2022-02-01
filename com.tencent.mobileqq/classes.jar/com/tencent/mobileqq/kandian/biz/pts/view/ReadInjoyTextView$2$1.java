package com.tencent.mobileqq.kandian.biz.pts.view;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyTextView$2$1
  implements Runnable
{
  ReadInjoyTextView$2$1(ReadInjoyTextView.2 param2, ReadInJoyUserInfo paramReadInJoyUserInfo) {}
  
  public void run()
  {
    QLog.d("ReadInjoyTextView", 2, new Object[] { "setDecorationName callback, nick = ", this.a.decorationName });
    ReadInjoyTextView localReadInjoyTextView = this.b.c;
    String str;
    if (TextUtils.isEmpty(this.a.decorationName)) {
      str = this.b.b;
    } else {
      str = this.a.decorationName;
    }
    localReadInjoyTextView.setText(RIJStringUtils.a(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.2.1
 * JD-Core Version:    0.7.0.1
 */