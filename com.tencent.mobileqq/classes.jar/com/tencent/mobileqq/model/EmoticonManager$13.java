package com.tencent.mobileqq.model;

import askd;
import aukn;
import com.tencent.mobileqq.data.EmoticonTab;

public class EmoticonManager$13
  implements Runnable
{
  public EmoticonManager$13(askd paramaskd, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.a.a(EmoticonTab.class, this.a);
    if (localEmoticonTab != null) {}
    for (localEmoticonTab.kandianHave = true;; localEmoticonTab.kandianHave = true)
    {
      askd.a(this.this$0, localEmoticonTab);
      return;
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.13
 * JD-Core Version:    0.7.0.1
 */