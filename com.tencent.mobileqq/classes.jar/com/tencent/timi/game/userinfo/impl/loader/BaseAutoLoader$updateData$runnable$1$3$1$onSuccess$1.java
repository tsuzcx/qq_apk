package com.tencent.timi.game.userinfo.impl.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "CallBacakData", "run"}, k=3, mv={1, 1, 16})
final class BaseAutoLoader$updateData$runnable$1$3$1$onSuccess$1
  implements Runnable
{
  BaseAutoLoader$updateData$runnable$1$3$1$onSuccess$1(BaseAutoLoader.updateData.runnable.1.3.1 param1) {}
  
  public final void run()
  {
    BaseAutoLoader.a(this.this$0.a.this$0.this$0, false);
    if (BaseAutoLoader.a(this.this$0.a.this$0.this$0).size() > 0) {
      this.this$0.a.this$0.this$0.a((List)new ArrayList((Collection)BaseAutoLoader.a(this.this$0.a.this$0.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.BaseAutoLoader.updateData.runnable.1.3.1.onSuccess.1
 * JD-Core Version:    0.7.0.1
 */