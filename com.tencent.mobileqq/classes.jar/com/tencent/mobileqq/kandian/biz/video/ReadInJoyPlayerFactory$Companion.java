package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayerFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory$Companion;", "", "()V", "factory", "Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory;", "getFactory", "()Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyPlayerFactory;", "factory$delegate", "Lkotlin/Lazy;", "get", "Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayerFactory;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyPlayerFactory$Companion
{
  private final ReadInJoyPlayerFactory b()
  {
    Lazy localLazy = ReadInJoyPlayerFactory.access$getFactory$cp();
    Companion localCompanion = ReadInJoyPlayerFactory.Companion;
    return (ReadInJoyPlayerFactory)localLazy.getValue();
  }
  
  @JvmStatic
  @NotNull
  public final IReadInJoyPlayerFactory a()
  {
    return (IReadInJoyPlayerFactory)((Companion)this).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyPlayerFactory.Companion
 * JD-Core Version:    0.7.0.1
 */