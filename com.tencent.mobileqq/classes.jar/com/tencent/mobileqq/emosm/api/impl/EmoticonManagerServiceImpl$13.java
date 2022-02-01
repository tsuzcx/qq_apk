package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;

class EmoticonManagerServiceImpl$13
  implements Runnable
{
  EmoticonManagerServiceImpl$13(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.em.find(EmoticonTab.class, this.a);
    if (localEmoticonTab != null)
    {
      localEmoticonTab.kandianHave = true;
    }
    else
    {
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.a;
      localEmoticonTab.kandianHave = true;
    }
    EmoticonManagerServiceImpl.access$100(this.this$0, localEmoticonTab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.13
 * JD-Core Version:    0.7.0.1
 */