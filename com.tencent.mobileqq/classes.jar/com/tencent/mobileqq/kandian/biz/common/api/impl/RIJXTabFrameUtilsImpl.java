package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/RIJXTabFrameUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IRIJXTabFrameUtils;", "()V", "getPreFrameClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "kandianFrameStatus", "Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "getTabFrame", "isKandianTabFrame", "", "frame", "className", "", "isNowInKanDianTab", "onTabClickSelf", "", "updateFrameStatus", "isShowKandianTab", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrameUtilsImpl
  implements IRIJXTabFrameUtils
{
  @NotNull
  public Class<? extends Frame> getPreFrameClass(@NotNull KandianFrameStatus paramKandianFrameStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    return this.$$delegate_0.getPreFrameClass(paramKandianFrameStatus);
  }
  
  @NotNull
  public Class<? extends Frame> getTabFrame()
  {
    return this.$$delegate_0.getTabFrame();
  }
  
  public boolean isKandianTabFrame(@Nullable Frame paramFrame)
  {
    return this.$$delegate_0.isKandianTabFrame(paramFrame);
  }
  
  public boolean isKandianTabFrame(@Nullable String paramString)
  {
    return this.$$delegate_0.isKandianTabFrame(paramString);
  }
  
  public boolean isNowInKanDianTab()
  {
    return this.$$delegate_0.isNowInKanDianTab();
  }
  
  public void onTabClickSelf(@Nullable Frame paramFrame)
  {
    this.$$delegate_0.onTabClickSelf(paramFrame);
  }
  
  public void updateFrameStatus(@NotNull KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianFrameStatus, "kandianFrameStatus");
    this.$$delegate_0.updateFrameStatus(paramKandianFrameStatus, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.RIJXTabFrameUtilsImpl
 * JD-Core Version:    0.7.0.1
 */