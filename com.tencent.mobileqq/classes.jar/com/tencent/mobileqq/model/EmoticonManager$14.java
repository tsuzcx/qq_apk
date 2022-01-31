package com.tencent.mobileqq.model;

import aube;
import awbw;
import com.tencent.mobileqq.data.EmoticonTab;

public class EmoticonManager$14
  implements Runnable
{
  public EmoticonManager$14(aube paramaube, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.a.a(EmoticonTab.class, this.a);
    if (localEmoticonTab != null) {}
    for (localEmoticonTab.aioHave = true;; localEmoticonTab.aioHave = true)
    {
      aube.a(this.this$0, localEmoticonTab);
      return;
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.14
 * JD-Core Version:    0.7.0.1
 */