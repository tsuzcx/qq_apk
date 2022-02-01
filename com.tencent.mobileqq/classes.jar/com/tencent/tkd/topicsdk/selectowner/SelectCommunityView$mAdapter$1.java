package com.tencent.tkd.topicsdk.selectowner;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/selectowner/SelectCommunityView$mAdapter$1", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "Lcom/tencent/tkd/topicsdk/selectowner/SelectCommunityView$CommunityViewHolder;", "bindViewHolder", "", "position", "", "bean", "holder", "itemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "createView", "context", "Landroid/content/Context;", "viewGroup", "createViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectCommunityView$mAdapter$1
  extends CommonListAdapter<CommunityInfo, SelectCommunityView.CommunityViewHolder>
{
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.l, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…      false\n            )");
    return paramContext;
  }
  
  public void a(int paramInt, @NotNull CommunityInfo paramCommunityInfo, @NotNull SelectCommunityView.CommunityViewHolder paramCommunityViewHolder, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramCommunityInfo, "bean");
    Intrinsics.checkParameterIsNotNull(paramCommunityViewHolder, "holder");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramView = b().getResources().getDrawable(R.drawable.c);
    paramView.setBounds(0, 0, DisplayUtils.a.a(b(), 15.0F), DisplayUtils.a.a(b(), 15.0F));
    paramViewGroup = paramCommunityViewHolder.a();
    paramViewGroup.setText((CharSequence)paramCommunityInfo.getTitle());
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramViewGroup.setCompoundDrawablePadding(localDisplayUtils.a(localContext, 3.0F));
    paramViewGroup.setCompoundDrawables(paramView, null, null, null);
    paramCommunityViewHolder.b().setText((CharSequence)paramCommunityInfo.getIntro());
    com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a.a(b()).a(paramCommunityViewHolder.c()).a(paramCommunityInfo.getCoverUrl());
    if (Intrinsics.areEqual(this.a.getSelectedCommunityId(), paramCommunityInfo.getCommunityId()))
    {
      paramCommunityViewHolder.d().setVisibility(0);
      return;
    }
    paramCommunityViewHolder.d().setVisibility(4);
  }
  
  @NotNull
  public SelectCommunityView.CommunityViewHolder b(@NotNull Context paramContext, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramContext = (TextView)paramView.findViewById(R.id.aI);
    paramViewGroup = (TextView)paramView.findViewById(R.id.au);
    ImageView localImageView = (ImageView)paramView.findViewById(R.id.C);
    paramView = (ImageView)paramView.findViewById(R.id.E);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "titleText");
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "introView");
    Intrinsics.checkExpressionValueIsNotNull(paramView, "coverImageView");
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "checkView");
    return new SelectCommunityView.CommunityViewHolder(paramContext, paramViewGroup, paramView, localImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectCommunityView.mAdapter.1
 * JD-Core Version:    0.7.0.1
 */