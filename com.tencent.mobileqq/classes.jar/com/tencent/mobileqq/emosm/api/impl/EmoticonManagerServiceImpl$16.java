package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;

class EmoticonManagerServiceImpl$16
  implements Runnable
{
  EmoticonManagerServiceImpl$16(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.this$0.em.find(EmoticonTab.class, this.jdField_a_of_type_JavaLangString);
    if (localEmoticonTab != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        localEmoticonTab.aioHave = false;
      }
      if (this.b) {
        localEmoticonTab.kandianHave = false;
      }
      if ((!localEmoticonTab.aioHave) && (!localEmoticonTab.kandianHave)) {
        this.this$0.em.remove(localEmoticonTab);
      } else {
        EmoticonManagerServiceImpl.access$100(this.this$0, localEmoticonTab);
      }
      this.this$0.removeKeywordEmoticonsCache(this.jdField_a_of_type_JavaLangString);
      EmotionSharedPreUtils.a(this.this$0.app.getApp(), this.this$0.app.getCurrentUin(), System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.16
 * JD-Core Version:    0.7.0.1
 */