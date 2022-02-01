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
        Object localObject2 = (List)QSecPushServiceMgr.a(this.a).get(Integer.valueOf(paramInt2));
        if (localObject2 != null)
        {
          QSecPushServiceMgr.a(this.a).remove(Integer.valueOf(paramInt2));
          QSecPushServiceMgr.a(this.a);
        }
        if (localObject2 != null)
        {
          ??? = ((List)localObject2).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject2 = (QSecPushServiceMgr.PushCmdData)((Iterator)???).next();
            QSecPushServiceMgr.a(this.a).a(((QSecPushServiceMgr.PushCmdData)localObject2).jdField_a_of_type_Int, ((QSecPushServiceMgr.PushCmdData)localObject2).b, ((QSecPushServiceMgr.PushCmdData)localObject2).c, new Object[] { ((QSecPushServiceMgr.PushCmdData)localObject2).jdField_a_of_type_ArrayOfByte }, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecPushServiceMgr.2
 * JD-Core Version:    0.7.0.1
 */