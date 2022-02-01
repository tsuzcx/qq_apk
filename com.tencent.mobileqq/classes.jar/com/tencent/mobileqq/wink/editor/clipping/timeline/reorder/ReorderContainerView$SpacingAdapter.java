package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IThumbnailProvider;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$SpacingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;)V", "data", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "getThumbnailProvider", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "getItemCount", "", "getItemViewType", "position", "indexOf", "uuid", "", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "screenWidth", "context", "Landroid/content/Context;", "submitList", "", "swapItem", "src", "dest", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView$SpacingAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static final ReorderContainerView.SpacingAdapter.Companion a = new ReorderContainerView.SpacingAdapter.Companion(null);
  private List<ClipModel> b;
  @NotNull
  private final IThumbnailProvider c;
  
  public ReorderContainerView$SpacingAdapter(@NotNull IThumbnailProvider paramIThumbnailProvider)
  {
    this.c = paramIThumbnailProvider;
    this.b = ((List)new ArrayList());
  }
  
  private final int a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    return paramContext.getDisplayMetrics().widthPixels;
  }
  
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (Intrinsics.areEqual(((ClipModel)localIterator.next()).b(), paramString)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    ClipModel localClipModel = (ClipModel)this.b.get(paramInt1);
    List localList = this.b;
    localList.set(paramInt1, localList.get(paramInt2));
    this.b.set(paramInt2, localClipModel);
  }
  
  public final void a(@NotNull List<ClipModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    this.b.clear();
    this.b.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != this.b.size() + 1)) {
      return 11;
    }
    return 12;
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    if ((paramViewHolder instanceof ReorderVH))
    {
      ClipModel localClipModel = (ClipModel)this.b.get(paramInt - 1);
      paramViewHolder = (ReorderVH)paramViewHolder;
      paramViewHolder.a().setClipUrl(localClipModel.b(), localClipModel.c(), localClipModel.d().g());
      paramInt = ReorderViewIdManager.a.a(localClipModel.b());
      if (paramInt != -1) {
        paramViewHolder.a().setId(paramInt);
      }
    }
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    if (paramInt != 12)
    {
      paramViewGroup = paramViewGroup.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
      paramViewGroup = new ThumbClipView(paramViewGroup, null, 0, 6, null);
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramInt = DensityUtils.a.a(56.0F);
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt));
      paramViewGroup.setThumbnailProvider(this.c);
      return (RecyclerView.ViewHolder)new ReorderVH(paramViewGroup);
    }
    View localView = new View(paramViewGroup.getContext());
    paramInt = DensityUtils.a.a(56.0F);
    paramViewGroup = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
    localView.setLayoutParams(new ViewGroup.LayoutParams(a(paramViewGroup) - DensityUtils.a.a(5.0F), paramInt));
    return (RecyclerView.ViewHolder)new ReorderContainerView.SpacingVH(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView.SpacingAdapter
 * JD-Core Version:    0.7.0.1
 */