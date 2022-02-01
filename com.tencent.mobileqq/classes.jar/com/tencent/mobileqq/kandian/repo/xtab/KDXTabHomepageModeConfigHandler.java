package com.tencent.mobileqq.kandian.repo.xtab;

import android.os.Handler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/KDXTabHomepageModeConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabHomepageModeConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)KDXTabHomepageModeConfigHandler.onReceiveConfig.1.a);
    return super.onReceiveConfig(paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.KDXTabHomepageModeConfigHandler
 * JD-Core Version:    0.7.0.1
 */