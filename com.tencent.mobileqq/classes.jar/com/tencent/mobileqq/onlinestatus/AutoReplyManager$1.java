package com.tencent.mobileqq.onlinestatus;

import auja;
import aukp;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class AutoReplyManager$1
  implements Runnable
{
  public AutoReplyManager$1(auja paramauja) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (auja.a(this.this$0))
      {
        if (auja.a(this.this$0) == null)
        {
          List localList = auja.a(this.this$0).a(AutoReplyText.class);
          if ((localList != null) && (localList.size() > 0))
          {
            if (auja.a(this.this$0) == null)
            {
              auja.a(this.this$0, new ArrayList());
              auja.a(this.this$0).addAll(localList);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("AutoReplyManager", 2, String.format("initAutoReplyListCache, textList: %s", new Object[] { localList }));
            }
            return;
          }
          auja.a(this.this$0).clear();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoReplyManager", 2, "initAutoReplyListCache, but it had init");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AutoReplyManager.1
 * JD-Core Version:    0.7.0.1
 */