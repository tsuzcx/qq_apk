package com.tencent.mobileqq.leba.business.redtouch;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class LebaSpecificRedTouchBiz$2$1
  implements Runnable
{
  LebaSpecificRedTouchBiz$2$1(LebaSpecificRedTouchBiz.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.a <= 0)
    {
      this.b.b.g();
      this.b.this$0.a(this.b.a, this.b.b, this.b.c, this.b.d, this.b.e);
    }
    else
    {
      this.b.b.b();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      this.b.b.setMaxNum(99);
      this.b.b.setUseNewStyle(true);
      localRedTypeInfo.red_content.set(String.valueOf(this.a));
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      localRedTypeInfo.red_type.set(5);
      this.b.b.a(localRedTypeInfo);
      LebaSpecificRedTouchBiz.b(this.b.this$0, this.b.e, this.b.b);
    }
    this.b.b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.2.1
 * JD-Core Version:    0.7.0.1
 */