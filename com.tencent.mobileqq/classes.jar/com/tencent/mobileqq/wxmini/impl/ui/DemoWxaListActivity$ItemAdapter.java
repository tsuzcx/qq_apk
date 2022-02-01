package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$WxaInfo;", "(Landroid/content/Context;Ljava/util/List;)V", "TAG", "", "getContext", "()Landroid/content/Context;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "Lcom/tencent/mobileqq/wxmini/impl/ui/DemoWxaListActivity$ItemAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "wxmini_impl_release"}, k=1, mv={1, 1, 16})
public final class DemoWxaListActivity$ItemAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final String a;
  @NotNull
  private final Context b;
  @NotNull
  private List<DemoWxaListActivity.WxaInfo> c;
  
  public DemoWxaListActivity$ItemAdapter(@NotNull Context paramContext, @NotNull List<DemoWxaListActivity.WxaInfo> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
    this.a = "WMPF.ItemAdapter";
  }
  
  @NotNull
  public final Context a()
  {
    return this.b;
  }
  
  @NotNull
  public DemoWxaListActivity.ItemAdapter.ViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(1862467586, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "v");
    return new DemoWxaListActivity.ItemAdapter.ViewHolder(paramViewGroup);
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    DemoWxaListActivity.WxaInfo localWxaInfo = (DemoWxaListActivity.WxaInfo)this.c.get(paramInt);
    DemoWxaListActivity.ItemAdapter.ViewHolder localViewHolder = (DemoWxaListActivity.ItemAdapter.ViewHolder)paramViewHolder;
    AppBrandSimpleImageLoader.instance().attach(localViewHolder.a(), localWxaInfo.c(), WxaDefaultIcon.get(), (AppBrandSimpleImageLoader.h)WxaIconTransformation.INSTANCE);
    localViewHolder.b().setText((CharSequence)localWxaInfo.b());
    localViewHolder.itemView.setOnClickListener((View.OnClickListener)new DemoWxaListActivity.ItemAdapter.onBindViewHolder..inlined.let.lambda.1(localWxaInfo, this, paramViewHolder));
    View localView = localViewHolder.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localView, "itemView");
    localView.setLongClickable(true);
    localViewHolder.itemView.setOnLongClickListener((View.OnLongClickListener)new DemoWxaListActivity.ItemAdapter.onBindViewHolder..inlined.let.lambda.2(localWxaInfo, this, paramViewHolder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.DemoWxaListActivity.ItemAdapter
 * JD-Core Version:    0.7.0.1
 */