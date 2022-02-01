package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/CommonConfig;", "", "scrollConfig", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/ScrollConfig;", "layoutConfig", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/LayoutConfig;", "videoTrackConfig", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/VideoTrackConfig;", "timeBarConfig", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/TimeBarConfig;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/ScrollConfig;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/LayoutConfig;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/VideoTrackConfig;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/TimeBarConfig;)V", "getLayoutConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/LayoutConfig;", "getScrollConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/ScrollConfig;", "getTimeBarConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/TimeBarConfig;", "getVideoTrackConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/VideoTrackConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class CommonConfig
{
  @NotNull
  private final ScrollConfig a;
  @NotNull
  private final LayoutConfig b;
  @NotNull
  private final VideoTrackConfig c;
  @NotNull
  private final TimeBarConfig d;
  
  public CommonConfig()
  {
    this(null, null, null, null, 15, null);
  }
  
  public CommonConfig(@NotNull ScrollConfig paramScrollConfig, @NotNull LayoutConfig paramLayoutConfig, @NotNull VideoTrackConfig paramVideoTrackConfig, @NotNull TimeBarConfig paramTimeBarConfig)
  {
    this.a = paramScrollConfig;
    this.b = paramLayoutConfig;
    this.c = paramVideoTrackConfig;
    this.d = paramTimeBarConfig;
  }
  
  @NotNull
  public final ScrollConfig a()
  {
    return this.a;
  }
  
  @NotNull
  public final LayoutConfig b()
  {
    return this.b;
  }
  
  @NotNull
  public final VideoTrackConfig c()
  {
    return this.c;
  }
  
  @NotNull
  public final TimeBarConfig d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CommonConfig))
      {
        paramObject = (CommonConfig)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonConfig(scrollConfig=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", layoutConfig=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", videoTrackConfig=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", timeBarConfig=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig
 * JD-Core Version:    0.7.0.1
 */