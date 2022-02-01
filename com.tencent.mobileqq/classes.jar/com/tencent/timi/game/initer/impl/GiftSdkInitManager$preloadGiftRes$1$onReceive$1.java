package com.tencent.timi.game.initer.impl;

import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/initer/impl/GiftSdkInitManager$preloadGiftRes$1$onReceive$1", "Lcom/tencent/mobileqq/qqgift/callback/IQQGiftResourceDownloadCallback;", "onAllFinished", "", "totalCount", "", "successCount", "onSingleFinished", "success", "", "id", "msg", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftSdkInitManager$preloadGiftRes$1$onReceive$1
  implements IQQGiftResourceDownloadCallback
{
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadAnimationResources# totalCount: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" successCount: ");
    localStringBuilder.append(paramInt2);
    Logger.c("GiftSdkInitManager", localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.GiftSdkInitManager.preloadGiftRes.1.onReceive.1
 * JD-Core Version:    0.7.0.1
 */