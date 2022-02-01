package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/KDFragmentFrame;", "Lcom/tencent/mobileqq/app/Frame;", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "getFrameFragment", "()Lcom/tencent/mobileqq/app/FrameFragment;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class KDFragmentFrame
  extends Frame
{
  @NotNull
  private final FrameFragment a;
  
  public KDFragmentFrame(@NotNull FrameFragment paramFrameFragment)
  {
    this.a = paramFrameFragment;
  }
  
  @NotNull
  public final FrameFragment n()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.KDFragmentFrame
 * JD-Core Version:    0.7.0.1
 */