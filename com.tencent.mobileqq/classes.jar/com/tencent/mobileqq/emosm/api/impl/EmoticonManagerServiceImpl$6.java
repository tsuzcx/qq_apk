package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class EmoticonManagerServiceImpl$6
  implements Runnable
{
  EmoticonManagerServiceImpl$6(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, String paramString1, String paramString2) {}
  
  public void run()
  {
    Emoticon localEmoticon = (Emoticon)this.this$0.em.find(Emoticon.class, "epId=? and eId=?", new String[] { this.a, this.b });
    if (localEmoticon != null)
    {
      this.this$0.emoticonCache.put(localEmoticon.getMapKey(), localEmoticon);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "hit db, put into cache");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */