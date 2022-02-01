package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;

class EmoticonManager$14
  implements Runnable
{
  EmoticonManager$14(EmoticonManager paramEmoticonManager, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.a.find(EmoticonTab.class, this.a);
    if (localEmoticonTab != null) {}
    for (localEmoticonTab.kandianHave = true;; localEmoticonTab.kandianHave = true)
    {
      EmoticonManager.a(this.this$0, localEmoticonTab);
      return;
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.14
 * JD-Core Version:    0.7.0.1
 */