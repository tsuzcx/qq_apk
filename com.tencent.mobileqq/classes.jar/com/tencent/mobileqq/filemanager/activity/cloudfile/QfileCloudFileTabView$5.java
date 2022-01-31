package com.tencent.mobileqq.filemanager.activity.cloudfile;

import apvw;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class QfileCloudFileTabView$5
  implements Runnable
{
  public void run()
  {
    Object localObject = apvw.a(this.a.b);
    if (!this.this$0.a.containsKey(localObject)) {
      this.this$0.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.this$0.a.get(localObject);
    if (((List)localObject).contains(this.a) == true) {
      return;
    }
    ((List)localObject).add(0, this.a);
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.5
 * JD-Core Version:    0.7.0.1
 */