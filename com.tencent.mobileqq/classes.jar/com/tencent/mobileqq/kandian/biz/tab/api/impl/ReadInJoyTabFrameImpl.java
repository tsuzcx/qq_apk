package com.tencent.mobileqq.kandian.biz.tab.api.impl;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.biz.tab.api.IReadInJoyTabFrame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/tab/api/impl/ReadInJoyTabFrameImpl;", "Lcom/tencent/mobileqq/kandian/biz/tab/api/IReadInJoyTabFrame;", "()V", "getReadInJoyTabFrameName", "", "isReadInJoyTabFrame", "", "frame", "Lcom/tencent/mobileqq/app/Frame;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTabFrameImpl
  implements IReadInJoyTabFrame
{
  @NotNull
  public String getReadInJoyTabFrameName()
  {
    String str = ReadinjoyTabFrame.class.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "ReadinjoyTabFrame::class.java.name");
    return str;
  }
  
  public boolean isReadInJoyTabFrame(@NotNull Frame paramFrame)
  {
    Intrinsics.checkParameterIsNotNull(paramFrame, "frame");
    return paramFrame instanceof ReadinjoyTabFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.api.impl.ReadInJoyTabFrameImpl
 * JD-Core Version:    0.7.0.1
 */