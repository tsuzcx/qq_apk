package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer;
import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "()V", "createPlayer", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayer;", "sceneType", "", "token", "", "autoAttachVideoView", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyPlayerFactory
  implements IReadInJoyPlayerFactory
{
  public static final ReadInJoyPlayerFactory.Companion Companion = new ReadInJoyPlayerFactory.Companion(null);
  private static final Lazy factory$delegate = LazyKt.lazy((Function0)ReadInJoyPlayerFactory.Companion.factory.2.INSTANCE);
  
  @JvmStatic
  @NotNull
  public static final IReadInJoyPlayerFactory get()
  {
    return Companion.a();
  }
  
  @NotNull
  public IReadInJoyPlayer createPlayer(int paramInt)
  {
    return (IReadInJoyPlayer)new ReadInJoyPlayer(paramInt);
  }
  
  @NotNull
  public IReadInJoyPlayer createPlayer(int paramInt, @Nullable String paramString, boolean paramBoolean)
  {
    return (IReadInJoyPlayer)new ReadInJoyPlayer(paramInt, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory
 * JD-Core Version:    0.7.0.1
 */