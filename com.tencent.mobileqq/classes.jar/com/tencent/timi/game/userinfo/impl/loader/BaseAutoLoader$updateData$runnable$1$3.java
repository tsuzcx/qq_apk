package com.tencent.timi.game.userinfo.impl.loader;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "CallBacakData", "run"}, k=3, mv={1, 1, 16})
final class BaseAutoLoader$updateData$runnable$1$3
  implements Runnable
{
  BaseAutoLoader$updateData$runnable$1$3(BaseAutoLoader.updateData.runnable.1 param1) {}
  
  public final void run()
  {
    List localList = BaseAutoLoader.a(this.this$0.this$0, BaseAutoLoader.a(this.this$0.this$0));
    if (localList.size() == 0)
    {
      BaseAutoLoader.a(this.this$0.this$0, false);
      return;
    }
    String str = this.this$0.this$0.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateData - start ");
    localStringBuilder.append(localList.size());
    Logger.a(str, localStringBuilder.toString());
    this.this$0.this$0.a(localList, (IResultListener)new BaseAutoLoader.updateData.runnable.1.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.BaseAutoLoader.updateData.runnable.1.3
 * JD-Core Version:    0.7.0.1
 */