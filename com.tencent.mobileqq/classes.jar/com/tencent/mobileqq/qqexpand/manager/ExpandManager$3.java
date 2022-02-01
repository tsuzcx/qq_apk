package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;

class ExpandManager$3
  implements Runnable
{
  ExpandManager$3(ExpandManager paramExpandManager) {}
  
  public void run()
  {
    ExpandChatUtil.b(ExpandManager.b(this.this$0));
    ExpandChatUtil.a(ExpandManager.b(this.this$0), false);
    this.this$0.j();
    ExpandManager.c(this.this$0);
    ExpandManager.d(this.this$0);
    ExpandManager.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.3
 * JD-Core Version:    0.7.0.1
 */