package com.tencent.timi.game.userinfo.impl.loader;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "CallBacakData", "run"}, k=3, mv={1, 1, 16})
final class BaseAutoLoader$updateData$runnable$1
  implements Runnable
{
  BaseAutoLoader$updateData$runnable$1(BaseAutoLoader paramBaseAutoLoader, List paramList) {}
  
  public final void run()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      long l;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        l = ((Number)localObject3).longValue();
        int i;
        if ((!BaseAutoLoader.a(this.this$0).contains(Long.valueOf(l))) && (l != 0L)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        l = ((Number)((Iterator)localObject1).next()).longValue();
        BaseAutoLoader.a(this.this$0).add(Long.valueOf(l));
      }
    }
    if (BaseAutoLoader.b(this.this$0)) {
      return;
    }
    BaseAutoLoader.a(this.this$0, true);
    new Handler().postDelayed((Runnable)new BaseAutoLoader.updateData.runnable.1.3(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.BaseAutoLoader.updateData.runnable.1
 * JD-Core Version:    0.7.0.1
 */