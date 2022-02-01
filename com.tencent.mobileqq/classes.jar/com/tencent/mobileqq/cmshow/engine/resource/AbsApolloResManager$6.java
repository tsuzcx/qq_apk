package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

class AbsApolloResManager$6
  implements Runnable
{
  AbsApolloResManager$6(AbsApolloResManager paramAbsApolloResManager, ArrayList paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new HashMap();
    int i = 0;
    while (i < this.a.size())
    {
      int j = ((Integer)this.a.get(i)).intValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getApolloDressInfo dressId : ");
      localStringBuilder.append(j);
      QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
      if (j < 0)
      {
        localObject1 = this.b;
        if (localObject1 != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("dressId illegal ");
          ((StringBuilder)localObject2).append(j);
          ((IApolloResManager.ApolloDressInfoListener)localObject1).a(null, ((StringBuilder)localObject2).toString(), -5002);
        }
        return;
      }
      if (!this.this$0.a(j)) {
        ((ArrayList)localObject2).add(Integer.valueOf(j));
      } else {
        ((HashMap)localObject1).put(Integer.valueOf(j), this.this$0.c(j));
      }
      i += 1;
    }
    if (((ArrayList)localObject2).size() == 0)
    {
      localObject2 = this.b;
      if (localObject2 != null) {
        ((IApolloResManager.ApolloDressInfoListener)localObject2).a((HashMap)localObject1, "success", 0);
      }
    }
    else
    {
      this.this$0.a().b(this.c, null, new AbsApolloResManager.6.1(this, (HashMap)localObject1), -1, AbsApolloResManager.a(this.this$0, (List)localObject2), -1, -1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.6
 * JD-Core Version:    0.7.0.1
 */