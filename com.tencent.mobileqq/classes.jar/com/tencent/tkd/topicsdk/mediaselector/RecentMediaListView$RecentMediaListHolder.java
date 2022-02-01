package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.ImageLoader;
import com.tencent.tkd.topicsdk.framework.ImageLoader.Companion;
import com.tencent.tkd.topicsdk.list.CommonListAdapter.BaseListViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$RecentMediaListHolder;", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;Landroid/view/View;)V", "dirNameView", "Landroid/widget/TextView;", "getDirNameView", "()Landroid/widget/TextView;", "setDirNameView", "(Landroid/widget/TextView;)V", "imageLoader", "Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "getImageLoader", "()Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "setImageLoader", "(Lcom/tencent/tkd/topicsdk/framework/ImageLoader;)V", "imageView", "Landroid/widget/ImageView;", "itemNumView", "getItemNumView", "setItemNumView", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RecentMediaListView$RecentMediaListHolder
  extends CommonListAdapter.BaseListViewHolder
{
  private ImageView b;
  @NotNull
  private TextView c;
  @NotNull
  private TextView d;
  @NotNull
  private ImageLoader e;
  
  public RecentMediaListView$RecentMediaListHolder(View paramView)
  {
    Object localObject2 = ((View)localObject1).findViewById(R.id.E);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.iv_cover)");
    this.b = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "itemView.findViewById(R.id.dirNameView)");
    this.c = ((TextView)localObject2);
    Object localObject1 = ((View)localObject1).findViewById(R.id.z);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "itemView.findViewById(R.id.itemNumView)");
    this.d = ((TextView)localObject1);
    localObject1 = ImageLoader.a;
    localObject2 = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = ((ImageLoader.Companion)localObject1).a((Context)localObject2, TopicSDK.a.a().b().n());
    localObject2 = DisplayUtils.a;
    Context localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject2).a(50.0F, localContext);
    localObject2 = DisplayUtils.a;
    localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject1 = ((ImageLoader)localObject1).a(i, ((DisplayUtils)localObject2).a(50.0F, localContext));
    paramView = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "context");
    this.e = ((ImageLoader)localObject1).a((Drawable)new ColorDrawable(paramView.getResources().getColor(R.color.i))).a(this.b);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.c;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.d;
  }
  
  @NotNull
  public final ImageLoader c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.RecentMediaListView.RecentMediaListHolder
 * JD-Core Version:    0.7.0.1
 */