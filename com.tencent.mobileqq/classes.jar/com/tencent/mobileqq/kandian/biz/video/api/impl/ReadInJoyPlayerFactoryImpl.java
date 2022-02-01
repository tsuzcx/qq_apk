package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/ReadInJoyPlayerFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "()V", "createPlayer", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayer;", "sceneType", "", "token", "", "autoAttachVideoView", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyPlayerFactoryImpl
  implements IReadInJoyPlayerFactory
{
  @NotNull
  public IReadInJoyPlayer createPlayer(int paramInt)
  {
    return this.$$delegate_0.createPlayer(paramInt);
  }
  
  @NotNull
  public IReadInJoyPlayer createPlayer(int paramInt, @Nullable String paramString, boolean paramBoolean)
  {
    return this.$$delegate_0.createPlayer(paramInt, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.ReadInJoyPlayerFactoryImpl
 * JD-Core Version:    0.7.0.1
 */