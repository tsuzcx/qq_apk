package com.tencent.mobileqq.filemanager.data.search;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import mqq.os.MqqHandler;

class ChatFileSearchFragment$1
  implements Runnable
{
  ChatFileSearchFragment$1(ChatFileSearchFragment paramChatFileSearchFragment) {}
  
  public void run()
  {
    if (!ChatFileSearchFragment.a(this.this$0))
    {
      this.this$0.o.a();
      ChatFileSearchFragment.a(this.this$0, true);
      ThreadManager.getUIHandler().post(new ChatFileSearchFragment.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */