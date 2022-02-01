package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$1", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaSelectorPanel$1
  implements AbsListView.OnScrollListener
{
  public void onScroll(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    paramAbsListView = MediaSelectorPanel.a(this.a).getChildAt(MediaSelectorPanel.a(this.a).getChildCount() - 1);
    if (paramAbsListView != null)
    {
      localObject = paramAbsListView.getTag();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.ListPhotoViewHolder");
      }
      localObject = (MediaSelectorPanel.ListPhotoViewHolder)localObject;
      localMediaSelectorPanel = this.a;
      if ((((MediaSelectorPanel.ListPhotoViewHolder)localObject).a() != this.a.a().size() - 1) || (paramAbsListView.getBottom() > this.a.getHeight())) {
        break label145;
      }
    }
    label145:
    for (boolean bool1 = true;; bool1 = false)
    {
      localMediaSelectorPanel.setScrollToBottom(bool1);
      paramAbsListView = MediaSelectorPanel.a(this.a).getChildAt(0);
      if (paramAbsListView == null) {
        break label190;
      }
      localObject = paramAbsListView.getTag();
      if (localObject != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.ListPhotoViewHolder");
    }
    Object localObject = (MediaSelectorPanel.ListPhotoViewHolder)localObject;
    MediaSelectorPanel localMediaSelectorPanel = this.a;
    if ((((MediaSelectorPanel.ListPhotoViewHolder)localObject).a() == 0) && (paramAbsListView.getTop() == 0)) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localMediaSelectorPanel.setScrollToTop(bool1);
      label190:
      return;
    }
  }
  
  public void onScrollStateChanged(@NotNull AbsListView paramAbsListView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.1
 * JD-Core Version:    0.7.0.1
 */