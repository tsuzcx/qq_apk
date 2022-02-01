package com.tencent.mobileqq.wink.editor.transition;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.videocut.model.TransitionModel;
import java.util.Collection;
import java.util.Iterator;
import mqq.os.MqqHandler;

class TransitionResourceManager$2
  implements Runnable
{
  TransitionResourceManager$2(TransitionResourceManager paramTransitionResourceManager, Collection paramCollection, Context paramContext, Runnable paramRunnable) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Object localObject1 = (TransitionModel)localIterator.next();
      String str = TransitionResourceManager.a(this.b, ((TransitionModel)localObject1).resId);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((TransitionModel)localObject1).resId);
      ((StringBuilder)localObject2).append(".pag");
      localObject2 = ((StringBuilder)localObject2).toString();
      if ((localObject1 != null) && (!TransitionResourceManager.a(this.this$0, str)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadLocalTransResource, pagFilePath = ");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("not exists, need reload.");
        WinkQLog.a("TransitionResourceManager", ((StringBuilder)localObject1).toString());
        bool = TransitionResourceManager.a(this.this$0, this.b, (String)localObject2);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadLocalTransResource, pagFilePath = ");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("exists, not need reload.");
        WinkQLog.a("TransitionResourceManager", ((StringBuilder)localObject1).toString());
      }
    }
    if (bool) {
      ThreadManager.getUIHandler().post(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager.2
 * JD-Core Version:    0.7.0.1
 */