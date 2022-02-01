package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class PtvTemplateManager$6
  implements Runnable
{
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    List localList = this.this$0.a(this.a, this.b, null);
    if (localList != null) {
      synchronized (this.this$0.n)
      {
        if (this.this$0.x) {
          return;
        }
        this.this$0.i.clear();
        this.this$0.i.addAll(localList);
        this.this$0.z = true;
        ??? = this.a;
        if ((??? != null) && ((??? instanceof QQAppInterface)) && (PtvFilterSoLoad.a()))
        {
          ??? = this.this$0;
          ((PtvTemplateManager)???).a(((PtvTemplateManager)???).i);
        }
        PtvTemplateManager.a(this.this$0);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.6
 * JD-Core Version:    0.7.0.1
 */