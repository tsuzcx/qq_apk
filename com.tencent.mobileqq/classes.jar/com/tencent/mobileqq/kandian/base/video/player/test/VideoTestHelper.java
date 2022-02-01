package com.tencent.mobileqq.kandian.base.video.player.test;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/test/VideoTestHelper;", "", "()V", "TAG", "", "enableTest", "", "getEnableTest", "()Z", "setEnableTest", "(Z)V", "testId", "getTestId", "()Ljava/lang/String;", "setTestId", "(Ljava/lang/String;)V", "enable", "parseTestData", "", "data", "Ljava/util/HashMap;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTestHelper
{
  public static final VideoTestHelper a = new VideoTestHelper();
  @NotNull
  private static String b = "unknow";
  
  @NotNull
  public final String a()
  {
    return b;
  }
  
  public final void a(@NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "data");
  }
  
  public final boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.test.VideoTestHelper
 * JD-Core Version:    0.7.0.1
 */