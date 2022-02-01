package com.tencent.mobileqq.matchchat;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class MatchChatMsgUtil$1$1
  implements Runnable
{
  MatchChatMsgUtil$1$1(MatchChatMsgUtil.1 param1, int paramInt) {}
  
  public void run()
  {
    if (this.a <= 0)
    {
      this.this$0.a.d();
      return;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    this.this$0.a.setMaxNum(99);
    localRedTypeInfo.red_content.set(String.valueOf(this.a));
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    localRedTypeInfo.red_type.set(5);
    this.this$0.a.a(localRedTypeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgUtil.1.1
 * JD-Core Version:    0.7.0.1
 */