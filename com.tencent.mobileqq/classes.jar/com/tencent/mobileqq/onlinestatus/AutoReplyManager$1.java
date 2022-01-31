package com.tencent.mobileqq.onlinestatus;

import awad;
import awbw;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class AutoReplyManager$1
  implements Runnable
{
  public AutoReplyManager$1(awad paramawad) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (awad.a(this.this$0))
      {
        if (awad.a(this.this$0) == null)
        {
          List localList = awad.a(this.this$0).a(AutoReplyText.class);
          if ((localList != null) && (localList.size() > 0))
          {
            if (awad.a(this.this$0) == null)
            {
              awad.a(this.this$0, new ArrayList());
              awad.a(this.this$0).addAll(localList);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("AutoReplyManager", 2, String.format("initAutoReplyListCache, textList: %s", new Object[] { localList }));
            }
            return;
          }
          awad.a(this.this$0).clear();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoReplyManager", 2, "initAutoReplyListCache, but it had init");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyManager.1
 * JD-Core Version:    0.7.0.1
 */