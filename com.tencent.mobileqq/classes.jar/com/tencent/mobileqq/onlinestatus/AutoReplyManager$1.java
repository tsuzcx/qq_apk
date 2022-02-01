package com.tencent.mobileqq.onlinestatus;

import axuo;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class AutoReplyManager$1
  implements Runnable
{
  public AutoReplyManager$1(axuo paramaxuo) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (axuo.a(this.this$0))
      {
        if (axuo.a(this.this$0) == null)
        {
          List localList = axuo.a(this.this$0).query(AutoReplyText.class);
          if ((localList != null) && (localList.size() > 0))
          {
            if (axuo.a(this.this$0) == null)
            {
              axuo.a(this.this$0, new ArrayList());
              axuo.a(this.this$0).addAll(localList);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("AutoReplyManager", 2, String.format("initAutoReplyListCache, textList: %s", new Object[] { localList }));
            }
            return;
          }
          axuo.a(this.this$0).clear();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoReplyManager", 2, "initAutoReplyListCache, but it had init");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyManager.1
 * JD-Core Version:    0.7.0.1
 */