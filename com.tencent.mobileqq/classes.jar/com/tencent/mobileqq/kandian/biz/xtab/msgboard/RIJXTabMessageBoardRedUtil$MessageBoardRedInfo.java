package com.tencent.mobileqq.kandian.biz.xtab.msgboard;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardRedUtil$MessageBoardRedInfo;", "", "()V", "isShowRed", "", "()Z", "setShowRed", "(Z)V", "updateTimeStamp", "", "getUpdateTimeStamp", "()J", "setUpdateTimeStamp", "(J)V", "toString", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabMessageBoardRedUtil$MessageBoardRedInfo
{
  private boolean a;
  private long b;
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isShowRed = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", updateTimeStamp = ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardRedUtil.MessageBoardRedInfo
 * JD-Core Version:    0.7.0.1
 */