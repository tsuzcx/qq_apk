package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class PtvTemplateManager$5
  implements Runnable
{
  PtvTemplateManager$5(PtvTemplateManager paramPtvTemplateManager, Runnable paramRunnable) {}
  
  public void run()
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.i("PtvTemplateManager", 2, String.format("双人挂件加载 start, rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    Object localObject1 = QAVConfig.b(106).a;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    ??? = PtvTemplateManager.a(this.this$0, (String)localObject1);
    if (??? != null)
    {
      if (((List)???).isEmpty()) {
        return;
      }
      localObject1 = new ArrayList();
      int i = UITools.getQQVersion();
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("cur version:");
        ((StringBuilder)localObject4).append(i);
        QLog.d("PtvTemplateManager", 2, ((StringBuilder)localObject4).toString());
      }
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateManager", 2, String.format("the pandent[%s], platform[%s]", new Object[] { ((PtvTemplateManager.PtvTemplateInfo)localObject4).id, Integer.valueOf(((PtvTemplateManager.PtvTemplateInfo)localObject4).platform) }));
        }
        if ((((PtvTemplateManager.PtvTemplateInfo)localObject4).platform != 0) && (i < ((PtvTemplateManager.PtvTemplateInfo)localObject4).platform))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("PtvTemplateManager", 4, String.format("双人挂件加载, platform不符合, %s", new Object[] { localObject4 }));
          }
        }
        else
        {
          ((PtvTemplateManager.PtvTemplateInfo)localObject4).usable = this.this$0.a((PtvTemplateManager.PtvTemplateInfo)localObject4);
          ((List)localObject1).add(localObject4);
        }
      }
      if (QLog.isDevelopLevel())
      {
        i = ((List)localObject1).size();
        if (this.a != null) {
          bool1 = true;
        }
        QLog.d("PtvTemplateManager", 2, String.format("双人挂件加载 size[%s], onInitFinishSink[%s], mVersion[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), this.this$0.f }));
      }
      synchronized (this.this$0.c)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("initLocalTemplateConfigInfoWithExtra, isEmpty[");
        ((StringBuilder)localObject4).append(this.this$0.c.isEmpty());
        ((StringBuilder)localObject4).append("], size[");
        ((StringBuilder)localObject4).append(((List)localObject1).size());
        ((StringBuilder)localObject4).append("]");
        QLog.w("PtvTemplateManager", 1, ((StringBuilder)localObject4).toString());
        this.this$0.c.clear();
        this.this$0.c.addAll((Collection)localObject1);
        localObject1 = this.a;
        if (localObject1 != null) {
          ((Runnable)localObject1).run();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */