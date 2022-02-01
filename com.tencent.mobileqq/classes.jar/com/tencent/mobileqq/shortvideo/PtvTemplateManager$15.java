package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class PtvTemplateManager$15
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.a != null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.i("PtvTemplateManager", 2, String.format("initBlessSpecialPendantConfigInfo, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.this$0.D), Integer.valueOf(hashCode()) }));
    }
    if (this.this$0.D) {
      return;
    }
    Object localObject1 = PtvTemplateManager.a(this.b);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    localObject1 = PtvTemplateManager.a(this.this$0, (String)localObject1);
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return;
      }
      ??? = ((List)localObject1).iterator();
      while (((Iterator)???).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
        if (localPtvTemplateInfo != null)
        {
          localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
          localPtvTemplateInfo.businessID = 1;
        }
      }
      synchronized (this.this$0.C)
      {
        if (this.this$0.D) {
          return;
        }
        this.this$0.C.clear();
        this.this$0.C.addAll((Collection)localObject1);
        this.this$0.E = true;
        PtvTemplateManager.a(this.this$0);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.15
 * JD-Core Version:    0.7.0.1
 */