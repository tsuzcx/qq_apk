package com.tencent.mobileqq.kandian.glue.viola.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/event/ViolaChannelVisibilityChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "visiable", "", "violaInstanceId", "", "(ZLjava/lang/String;)V", "getViolaInstanceId", "()Ljava/lang/String;", "getVisiable", "()Z", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaChannelVisibilityChangedEvent
  extends SimpleBaseEvent
{
  @NotNull
  private final String violaInstanceId;
  private final boolean visiable;
  
  public ViolaChannelVisibilityChangedEvent(boolean paramBoolean, @NotNull String paramString)
  {
    this.visiable = paramBoolean;
    this.violaInstanceId = paramString;
  }
  
  @NotNull
  public final String getViolaInstanceId()
  {
    return this.violaInstanceId;
  }
  
  public final boolean getVisiable()
  {
    return this.visiable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.event.ViolaChannelVisibilityChangedEvent
 * JD-Core Version:    0.7.0.1
 */