package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class EmoticonManagerServiceImpl$18
  implements Runnable
{
  EmoticonManagerServiceImpl$18(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, String paramString) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      this.this$0.em.drop(EmoticonTab.class.getSimpleName());
      Object localObject2 = this.this$0.em.getTransaction();
      try
      {
        ((EntityTransaction)localObject2).begin();
        Object localObject4 = this.this$0.tabCache.iterator();
        String str;
        while (((Iterator)localObject4).hasNext())
        {
          str = (String)((Iterator)localObject4).next();
          EmoticonManagerServiceImpl.access$300(this.this$0, str, true, false);
        }
        localObject4 = this.this$0.kanDianTabCache.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          str = (String)((Iterator)localObject4).next();
          EmoticonManagerServiceImpl.access$300(this.this$0, str, false, true);
        }
        ((EntityTransaction)localObject2).commit();
        ((EntityTransaction)localObject2).end();
        localObject2 = this.this$0.syncGetSubEmoticonsByPackageId(this.a);
        if (localObject2 == null) {
          return;
        }
        ??? = new HashSet();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Emoticon)((Iterator)localObject2).next();
          if (((Emoticon)localObject4).name != null) {
            ((HashSet)???).add(((Emoticon)localObject4).name);
          }
        }
        StickerRecManagerImpl.get(this.this$0.app).syncAddLocalEmoticonKeywords((Collection)???);
        this.this$0.addKeywordEmoticonsCache(this.a);
        return;
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.18
 * JD-Core Version:    0.7.0.1
 */