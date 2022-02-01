package com.tencent.tkd.topicsdk.kdcommunity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.widget.dialog.SlidingUpDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/SelectKDCommunityView$Companion;", "", "()V", "open", "", "activity", "Landroid/app/Activity;", "selectedCommunityId", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "Lkotlin/ParameterName;", "name", "communityInfo", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectKDCommunityView$Companion
{
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString, @Nullable Function1<? super CommunityInfo, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "selectedCommunityId");
    paramString = new SelectKDCommunityView(paramActivity, paramString, (KDCommunityContract.IPresenter)new KDCommunityPresenter((KDCommunityContract.IModel)new KDCommunityModel()));
    paramActivity = new SlidingUpDialog((Context)paramActivity, (View)paramString, new RelativeLayout.LayoutParams(-1, -2));
    paramString.setOnSelectCallback((Function1)new SelectKDCommunityView.Companion.open.1(paramFunction1, paramActivity));
    paramActivity.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView.Companion
 * JD-Core Version:    0.7.0.1
 */