package com.tencent.tavcut.render.cover;

import com.tencent.tavcut.render.builder.IMediaBuilderListener;
import com.tencent.tavcut.render.builder.MediaBuilderOutput;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/cover/CoverProviderAccessor$CoverProvider$buildRenderChainManager$1", "Lcom/tencent/tavcut/render/builder/IMediaBuilderListener;", "buildCompleted", "", "errorCode", "", "output", "Lcom/tencent/tavcut/render/builder/MediaBuilderOutput;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class CoverProviderAccessor$CoverProvider$buildRenderChainManager$1
  implements IMediaBuilderListener
{
  CoverProviderAccessor$CoverProvider$buildRenderChainManager$1(Ref.ObjectRef paramObjectRef, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt, @Nullable MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.a.element = paramMediaBuilderOutput;
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.cover.CoverProviderAccessor.CoverProvider.buildRenderChainManager.1
 * JD-Core Version:    0.7.0.1
 */