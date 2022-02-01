package com.tencent.mobileqq.minigame.publicaccount.hippy.module;

import com.tencent.mtt.hippy.modules.Promise;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MiniGamePANativeModule$addShortcut$1$1
  implements Runnable
{
  MiniGamePANativeModule$addShortcut$1$1(MiniGamePANativeModule.addShortcut.1 param1, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.$isSuccess)
    {
      this.this$0.$promise.resolve("");
      return;
    }
    MiniGamePANativeModule localMiniGamePANativeModule = this.this$0.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createShortcut failed, title=");
    localStringBuilder.append(this.this$0.$title);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(this.this$0.$icon);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.this$0.$url);
    MiniGamePANativeModule.access$addShortCutFailed(localMiniGamePANativeModule, Integer.valueOf(-1), localStringBuilder.toString(), this.this$0.$promise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.module.MiniGamePANativeModule.addShortcut.1.1
 * JD-Core Version:    0.7.0.1
 */