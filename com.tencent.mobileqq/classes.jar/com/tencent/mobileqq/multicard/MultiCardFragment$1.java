package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

class MultiCardFragment$1
  implements Runnable
{
  MultiCardFragment$1(MultiCardFragment paramMultiCardFragment, List paramList, Map paramMap1, Map paramMap2) {}
  
  public void run()
  {
    Object localObject1 = MultiCardFragment.a(this.this$0);
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      if (this.a != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateData uinlist: ");
        ((StringBuilder)localObject2).append(this.a.size());
        ((StringBuilder)localObject2).append("  ");
        localObject3 = this.a.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next());
          ((StringBuilder)localObject2).append(" ");
        }
        QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.b != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateData intimateinfo map: ");
        ((StringBuilder)localObject2).append(this.b.size());
        ((StringBuilder)localObject2).append("  ");
        localObject3 = this.b.entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ((StringBuilder)localObject2).append(((Map.Entry)((Iterator)localObject3).next()).getKey());
          ((StringBuilder)localObject2).append(" ");
        }
        QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.c != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateData name map: ");
        ((StringBuilder)localObject2).append(this.c.size());
        ((StringBuilder)localObject2).append("  ");
        localObject3 = this.c.entrySet().iterator();
      }
    }
    for (;;)
    {
      Map.Entry localEntry;
      if (((Iterator)localObject3).hasNext()) {
        localEntry = (Map.Entry)((Iterator)localObject3).next();
      }
      try
      {
        ((StringBuilder)localObject2).append(String.valueOf((Long)localEntry.getKey()));
        label317:
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append((String)localEntry.getValue());
        ((StringBuilder)localObject2).append(" ");
        continue;
        QLog.d("MultiCardFragment", 2, ((StringBuilder)localObject2).toString());
        localObject2 = ((MultiCardContext)localObject1).a(this.a);
        localObject3 = ((MultiCardContext)localObject1).a(this.b);
        localObject1 = ((MultiCardContext)localObject1).b(this.c);
        if ((localObject2 != null) && (localObject3 == null))
        {
          MultiCardFragment.a(this.this$0, -1);
          ThreadManager.getUIHandler().post(new MultiCardFragment.1.1(this, (List)localObject2, (Map)localObject3, (Map)localObject1));
          return;
        }
        if ((localObject2 == null) && (localObject3 != null))
        {
          ThreadManager.getUIHandler().post(new MultiCardFragment.1.2(this, (List)localObject2, (Map)localObject3, (Map)localObject1));
          return;
        }
        if ((localObject2 == null) && (localObject3 == null))
        {
          ThreadManager.getUIHandler().post(new MultiCardFragment.1.3(this, (Map)localObject1));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardFragment", 2, "updatedata err");
        }
        return;
      }
      catch (Exception localException)
      {
        break label317;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.1
 * JD-Core Version:    0.7.0.1
 */