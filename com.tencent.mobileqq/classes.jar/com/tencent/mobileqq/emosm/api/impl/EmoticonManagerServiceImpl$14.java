package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;

class EmoticonManagerServiceImpl$14
  implements Runnable
{
  EmoticonManagerServiceImpl$14(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, String paramString) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.em.find(EmoticonTab.class, this.a);
    if (localEmoticonTab != null)
    {
      localEmoticonTab.aioHave = true;
    }
    else
    {
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.epId = this.a;
      localEmoticonTab.aioHave = true;
    }
    EmoticonManagerServiceImpl.access$100(this.this$0, localEmoticonTab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.14
 * JD-Core Version:    0.7.0.1
 */