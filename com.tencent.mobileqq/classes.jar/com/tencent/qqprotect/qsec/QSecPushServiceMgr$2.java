package com.tencent.qqprotect.qsec;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class QSecPushServiceMgr$2
  implements QSecLibMgr.LibEventListener
{
  QSecPushServiceMgr$2(QSecPushServiceMgr paramQSecPushServiceMgr) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      synchronized (QSecPushServiceMgr.a(this.a))
      {
        Object localObject2 = (List)QSecPushServiceMgr.b(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          QSecPushServiceMgr.b(this.a).remove(Integer.valueOf(paramInt2));
          QSecPushServiceMgr.c(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (QSecPushServiceMgr.PushCmdData)((Iterator)???).next();
            QSecPushServiceMgr.d(this.a).a(((QSecPushServiceMgr.PushCmdData)localObject2).a, ((QSecPushServiceMgr.PushCmdData)localObject2).b, ((QSecPushServiceMgr.PushCmdData)localObject2).c, new Object[] { ((QSecPushServiceMgr.PushCmdData)localObject2).e }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecPushServiceMgr.2
 * JD-Core Version:    0.7.0.1
 */