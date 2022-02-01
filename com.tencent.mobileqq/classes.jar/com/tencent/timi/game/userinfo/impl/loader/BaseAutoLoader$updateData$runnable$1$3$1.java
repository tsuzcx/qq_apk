package com.tencent.timi.game.userinfo.impl.loader;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/loader/BaseAutoLoader$updateData$runnable$1$3$1", "Lcom/tencent/timi/game/utils/IResultListener;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "(Ljava/lang/Object;)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseAutoLoader$updateData$runnable$1$3$1
  implements IResultListener<CallBacakData>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    Logger.a(this.a.this$0.this$0.a(), "updateData - onError");
    ThreadManagerV2.executeOnSubThread((Runnable)new BaseAutoLoader.updateData.runnable.1.3.1.onError.1(this));
  }
  
  public void a(@Nullable CallBacakData paramCallBacakData)
  {
    Logger.a(this.a.this$0.this$0.a(), "updateData - onSuccess");
    ThreadManagerV2.executeOnSubThread((Runnable)new BaseAutoLoader.updateData.runnable.1.3.1.onSuccess.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.BaseAutoLoader.updateData.runnable.1.3.1
 * JD-Core Version:    0.7.0.1
 */