package com.tencent.mobileqq.mini.ui;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.AppMaterialInfo;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.widget.RoundRectURLImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "data", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "getData", "()LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "setData", "(LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;)V", "ivExpTips", "Landroid/widget/ImageView;", "getIvExpTips", "()Landroid/widget/ImageView;", "ivIcon", "Lcom/tencent/widget/RoundRectURLImageView;", "getIvIcon", "()Lcom/tencent/widget/RoundRectURLImageView;", "tvDesc", "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "tvTitle", "getTvTitle", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialAppListAdapter$ItemViewHolder
  extends RecyclerView.ViewHolder
{
  @NotNull
  public MiniAppFileMaterial.AppMaterialInfo data;
  @NotNull
  private final ImageView ivExpTips;
  @NotNull
  private final RoundRectURLImageView ivIcon;
  @NotNull
  private final TextView tvDesc;
  @NotNull
  private final TextView tvTitle;
  
  public FileMaterialAppListAdapter$ItemViewHolder(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(2030305308);
    RoundRectURLImageView localRoundRectURLImageView = (RoundRectURLImageView)localView;
    localRoundRectURLImageView.setRadius(paramView.getResources().getDimensionPixelSize(2030174209));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById<RoundR…ius).toFloat())\n        }");
    this.ivIcon = localRoundRectURLImageView;
    localView = paramView.findViewById(2030305334);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.tv_title)");
    this.tvTitle = ((TextView)localView);
    localView = paramView.findViewById(2030305330);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.tv_desc)");
    this.tvDesc = ((TextView)localView);
    paramView = paramView.findViewById(2030305310);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.iv_exp_tips)");
    this.ivExpTips = ((ImageView)paramView);
  }
  
  @NotNull
  public final MiniAppFileMaterial.AppMaterialInfo getData()
  {
    MiniAppFileMaterial.AppMaterialInfo localAppMaterialInfo = this.data;
    if (localAppMaterialInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("data");
    }
    return localAppMaterialInfo;
  }
  
  @NotNull
  public final ImageView getIvExpTips()
  {
    return this.ivExpTips;
  }
  
  @NotNull
  public final RoundRectURLImageView getIvIcon()
  {
    return this.ivIcon;
  }
  
  @NotNull
  public final TextView getTvDesc()
  {
    return this.tvDesc;
  }
  
  @NotNull
  public final TextView getTvTitle()
  {
    return this.tvTitle;
  }
  
  public final void setData(@NotNull MiniAppFileMaterial.AppMaterialInfo paramAppMaterialInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAppMaterialInfo, "<set-?>");
    this.data = paramAppMaterialInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.FileMaterialAppListAdapter.ItemViewHolder
 * JD-Core Version:    0.7.0.1
 */