package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class AutoReplyManagerImpl$1
  implements Runnable
{
  AutoReplyManagerImpl$1(AutoReplyManagerImpl paramAutoReplyManagerImpl) {}
  
  public void run()
  {
    synchronized (AutoReplyManagerImpl.a(this.this$0))
    {
      if (AutoReplyManagerImpl.b(this.this$0) == null)
      {
        List localList = AutoReplyManagerImpl.c(this.this$0).query(AutoReplyText.class);
        if ((localList != null) && (localList.size() > 0))
        {
          if (AutoReplyManagerImpl.b(this.this$0) == null) {
            AutoReplyManagerImpl.a(this.this$0, new ArrayList());
          } else {
            AutoReplyManagerImpl.b(this.this$0).clear();
          }
          AutoReplyManagerImpl.b(this.this$0).addAll(localList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AutoReplyManager", 2, String.format("initAutoReplyListCache, textList: %s", new Object[] { localList }));
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("AutoReplyManager", 2, "initAutoReplyListCache, but it had init");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */