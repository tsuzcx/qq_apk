package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class QfileBaseRecentFileTabView$8
  implements Runnable
{
  QfileBaseRecentFileTabView$8(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if ((this.this$0.C.D()) && (this.this$0.c != null) && (this.this$0.c.size() > 0))
    {
      Iterator localIterator = this.this$0.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ((List)this.this$0.c.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((FileManagerEntity)((Iterator)localObject).next()).sendCloudUnsuccessful()) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.8
 * JD-Core Version:    0.7.0.1
 */