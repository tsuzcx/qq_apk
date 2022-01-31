package com.tencent.mobileqq.model;

import aufn;
import awgf;
import com.tencent.mobileqq.data.EmoticonTab;

public class EmoticonManager$13
  implements Runnable
{
  public EmoticonManager$13(aufn paramaufn, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.a.a(EmoticonTab.class, this.a);
    if (localEmoticonTab != null) {}
    for (localEmoticonTab.kandianHave = true;; localEmoticonTab.kandianHave = true)
    {
      aufn.a(this.this$0, localEmoticonTab);
      return;
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.13
 * JD-Core Version:    0.7.0.1
 */