package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.EmptyThumbnailProvider;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.IThumbnailProvider;
import com.tencent.videocut.utils.DensityUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "adapter", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$SpacingAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$SpacingAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dragUUID", "dragViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemTouchHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ItemTouchHelper;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "reorderListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderListener;", "getReorderListener", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderListener;", "setReorderListener", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderListener;)V", "targetIndex", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "initial", "", "provider", "scrollToTarget", "uuid", "point", "Landroid/graphics/Point;", "startDrag", "index", "submitList", "data", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "Companion", "SpacingAdapter", "SpacingVH", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderContainerView
  extends RecyclerView
{
  public static final ReorderContainerView.Companion a = new ReorderContainerView.Companion(null);
  private final String b = "ReorderContainerView";
  private IThumbnailProvider c = (IThumbnailProvider)new EmptyThumbnailProvider();
  private final Lazy d = LazyKt.lazy((Function0)new ReorderContainerView.adapter.2(this));
  private final LinearLayoutManager e;
  @Nullable
  private ReorderListener f;
  private ItemTouchHelper g;
  private int h;
  private String i;
  private RecyclerView.ViewHolder j;
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public ReorderContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = new LinearLayoutManager(paramContext, 0, false);
    this.h = -1;
  }
  
  private final ReorderContainerView.SpacingAdapter getAdapter()
  {
    return (ReorderContainerView.SpacingAdapter)this.d.getValue();
  }
  
  public final int a(@NotNull String paramString, @NotNull Point paramPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Intrinsics.checkParameterIsNotNull(paramPoint, "point");
    this.i = paramString;
    int k = getAdapter().a(paramString);
    this.e.scrollToPosition(k + 1);
    post((Runnable)new ReorderContainerView.scrollToTarget.1(this, k, paramPoint));
    return k;
  }
  
  public final void a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = findViewHolderForLayoutPosition(paramInt + 1);
    if (localViewHolder != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localViewHolder, "this.findViewHolderForLa…tion(index + 1) ?: return");
      ItemTouchHelper localItemTouchHelper = this.g;
      if (localItemTouchHelper != null) {
        localItemTouchHelper.b(localViewHolder);
      }
    }
  }
  
  public final void a(@NotNull IThumbnailProvider paramIThumbnailProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramIThumbnailProvider, "provider");
    this.c = paramIThumbnailProvider;
    setLayoutManager((RecyclerView.LayoutManager)this.e);
    setAdapter((RecyclerView.Adapter)getAdapter());
    addItemDecoration((RecyclerView.ItemDecoration)new SpacesItemDecoration(DensityUtils.a.a(2.0F)));
    this.g = new ItemTouchHelper((ItemTouchHelper.Callback)new ReorderContainerView.initial.itemTouchCallback.1(this, 51, 0));
    paramIThumbnailProvider = this.g;
    if (paramIThumbnailProvider != null) {
      paramIThumbnailProvider.a((RecyclerView)this);
    }
  }
  
  public final void a(@NotNull List<ClipModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    getAdapter().a(paramList);
  }
  
  @Nullable
  public final ReorderListener getReorderListener()
  {
    return this.f;
  }
  
  public final void setReorderListener(@Nullable ReorderListener paramReorderListener)
  {
    this.f = paramReorderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView
 * JD-Core Version:    0.7.0.1
 */