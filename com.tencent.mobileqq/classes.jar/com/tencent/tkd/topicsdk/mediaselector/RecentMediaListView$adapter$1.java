package com.tencent.tkd.topicsdk.mediaselector;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.framework.ImageLoader;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$adapter$1", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$Album;", "Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView$RecentMediaListHolder;", "Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;", "bindViewHolder", "", "position", "", "bean", "holder", "itemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "createView", "context", "Landroid/content/Context;", "viewGroup", "createViewHolder", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RecentMediaListView$adapter$1
  extends CommonListAdapter<RecentMediaListView.Album, RecentMediaListView.RecentMediaListHolder>
{
  RecentMediaListView$adapter$1(Context paramContext1, Context paramContext2)
  {
    super(localContext);
  }
  
  @NotNull
  public View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.o, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…      false\n            )");
    return paramContext;
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(int paramInt, @NotNull RecentMediaListView.Album paramAlbum, @NotNull RecentMediaListView.RecentMediaListHolder paramRecentMediaListHolder, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramAlbum, "bean");
    Intrinsics.checkParameterIsNotNull(paramRecentMediaListHolder, "holder");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramView = paramAlbum.c().get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "bean.medias[0]");
    if (((Media)paramView).getType() == MediaType.PHOTO) {
      paramRecentMediaListHolder.c().a(((Media)paramAlbum.c().get(0)).getFilePath());
    } else {
      paramRecentMediaListHolder.c().a(((Media)paramAlbum.c().get(0)).getFilePath());
    }
    paramRecentMediaListHolder.a().setText((CharSequence)paramAlbum.a());
    paramRecentMediaListHolder = paramRecentMediaListHolder.b();
    paramView = new StringBuilder();
    paramView.append('(');
    paramView.append(paramAlbum.c().size());
    paramView.append(')');
    paramRecentMediaListHolder.setText((CharSequence)paramView.toString());
  }
  
  @NotNull
  public RecentMediaListView.RecentMediaListHolder b(@NotNull Context paramContext, @NotNull View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    return new RecentMediaListView.RecentMediaListHolder(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.RecentMediaListView.adapter.1
 * JD-Core Version:    0.7.0.1
 */