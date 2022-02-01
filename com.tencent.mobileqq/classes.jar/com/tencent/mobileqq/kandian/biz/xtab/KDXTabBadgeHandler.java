package com.tencent.mobileqq.kandian.biz.xtab;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay;
import com.tencent.mobileqq.kandian.biz.xtab.badge.AvatarBadgeDisplay.IDisplayListener;
import com.tencent.mobileqq.kandian.biz.xtab.badge.EmptyBadgeDisplay;
import com.tencent.mobileqq.kandian.biz.xtab.badge.IRIJXTabBadgeDisplay;
import com.tencent.mobileqq.kandian.biz.xtab.badge.NumBadgeDisplay;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeShowLevel;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/KDXTabBadgeHandler;", "", "()V", "createRedPointDisplay", "Lcom/tencent/mobileqq/kandian/biz/xtab/badge/IRIJXTabBadgeDisplay;", "display", "Ljava/lang/Class;", "redPointContainer", "Landroid/widget/RelativeLayout;", "getRedPointDisplay", "badgeInfo", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "needShowGuideBadge", "", "handleRedPointDisplay", "", "titleView", "Landroid/view/View;", "tabChannelCoverInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "handleTitleView", "showBadge", "itemView", "tabChannelInfo", "showRedPoint", "badgeDisplay", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KDXTabBadgeHandler
{
  private final IRIJXTabBadgeDisplay<?> a(Class<? extends IRIJXTabBadgeDisplay<?>> paramClass, RelativeLayout paramRelativeLayout)
  {
    if (Intrinsics.areEqual(paramClass, AvatarBadgeDisplay.class)) {
      return (IRIJXTabBadgeDisplay)new AvatarBadgeDisplay(paramRelativeLayout);
    }
    if (Intrinsics.areEqual(paramClass, NumBadgeDisplay.class)) {
      return (IRIJXTabBadgeDisplay)new NumBadgeDisplay(paramRelativeLayout);
    }
    if (Intrinsics.areEqual(paramClass, EmptyBadgeDisplay.class)) {
      return (IRIJXTabBadgeDisplay)new EmptyBadgeDisplay(paramRelativeLayout);
    }
    return null;
  }
  
  private final Class<? extends IRIJXTabBadgeDisplay<?>> a(RIJXTabRedDotInfo paramRIJXTabRedDotInfo, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramRIJXTabRedDotInfo == null)
    {
      paramRIJXTabRedDotInfo = localObject;
      if (paramBoolean) {
        paramRIJXTabRedDotInfo = EmptyBadgeDisplay.class;
      }
      return paramRIJXTabRedDotInfo;
    }
    if (!paramRIJXTabRedDotInfo.isBig()) {
      return EmptyBadgeDisplay.class;
    }
    int i = RIJXTabBadgeShowLevel.a();
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return NumBadgeDisplay.class;
    }
    return AvatarBadgeDisplay.class;
  }
  
  private final void a(RelativeLayout paramRelativeLayout, View paramView, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = RIJXTabBadgeStore.b(paramTabChannelCoverInfo.mChannelCoverId);
    boolean bool;
    if ((paramTabChannelCoverInfo.needBadgeGuide) && (RIJXTabBadgeStore.a.d(paramTabChannelCoverInfo.mChannelCoverId))) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject2 = paramRelativeLayout.getTag();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof IRIJXTabBadgeDisplay)) {
      localObject1 = null;
    }
    localObject2 = (IRIJXTabBadgeDisplay)localObject1;
    Class localClass = a(localRIJXTabRedDotInfo, bool);
    if (localClass == null)
    {
      if (localObject2 != null) {
        ((IRIJXTabBadgeDisplay)localObject2).c(true);
      }
      paramRelativeLayout.setTag(null);
      return;
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!(true ^ Intrinsics.areEqual(localObject2.getClass(), localClass))) {}
    }
    else
    {
      if (localObject2 != null) {
        ((IRIJXTabBadgeDisplay)localObject2).c(false);
      }
      localObject2 = a(localClass, paramRelativeLayout);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        paramRelativeLayout.setTag(localObject2);
        a((IRIJXTabBadgeDisplay)localObject2, paramView);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      a(localObject1, localRIJXTabRedDotInfo);
      if (localRIJXTabRedDotInfo != null)
      {
        RIJXTabBadgeReporter.a(localRIJXTabRedDotInfo);
        return;
      }
      if (bool) {
        RIJXTabBadgeReporter.a(paramTabChannelCoverInfo.mChannelCoverId);
      }
    }
  }
  
  private final void a(IRIJXTabBadgeDisplay<?> paramIRIJXTabBadgeDisplay, View paramView)
  {
    if ((paramIRIJXTabBadgeDisplay instanceof AvatarBadgeDisplay)) {
      ((AvatarBadgeDisplay)paramIRIJXTabBadgeDisplay).a((AvatarBadgeDisplay.IDisplayListener)new KDXTabBadgeHandler.handleTitleView.1(paramView));
    }
  }
  
  public final void a(@NotNull View paramView, @NotNull TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    Intrinsics.checkParameterIsNotNull(paramTabChannelCoverInfo, "tabChannelInfo");
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131444529);
    paramView = paramView.findViewById(2131448814);
    if (paramView != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "redPointContainer");
      a(localRelativeLayout, paramView, paramTabChannelCoverInfo);
    }
  }
  
  @VisibleForTesting
  public final void a(@NotNull IRIJXTabBadgeDisplay<?> paramIRIJXTabBadgeDisplay, @Nullable RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIRIJXTabBadgeDisplay, "badgeDisplay");
    if ((paramIRIJXTabBadgeDisplay instanceof AvatarBadgeDisplay))
    {
      paramIRIJXTabBadgeDisplay = (AvatarBadgeDisplay)paramIRIJXTabBadgeDisplay;
      long l;
      if (paramRIJXTabRedDotInfo != null) {
        l = paramRIJXTabRedDotInfo.getUin();
      } else {
        l = 0L;
      }
      paramIRIJXTabBadgeDisplay.a(l, true);
      return;
    }
    if ((paramIRIJXTabBadgeDisplay instanceof NumBadgeDisplay))
    {
      ((NumBadgeDisplay)paramIRIJXTabBadgeDisplay).a(1L, true);
      return;
    }
    if ((paramIRIJXTabBadgeDisplay instanceof EmptyBadgeDisplay)) {
      ((EmptyBadgeDisplay)paramIRIJXTabBadgeDisplay).a(new Object(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.KDXTabBadgeHandler
 * JD-Core Version:    0.7.0.1
 */