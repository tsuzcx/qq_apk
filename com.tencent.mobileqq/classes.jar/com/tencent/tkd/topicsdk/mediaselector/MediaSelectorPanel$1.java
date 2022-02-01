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
    paramAbsListView = MediaSelectorPanel.b(this.a);
    paramInt1 = MediaSelectorPanel.b(this.a).getChildCount();
    boolean bool2 = true;
    paramAbsListView = paramAbsListView.getChildAt(paramInt1 - 1);
    Object localObject;
    MediaSelectorPanel localMediaSelectorPanel;
    boolean bool1;
    if (paramAbsListView != null)
    {
      localObject = paramAbsListView.getTag();
      if (localObject != null)
      {
        localObject = (MediaSelectorPanel.ListPhotoViewHolder)localObject;
        localMediaSelectorPanel = this.a;
        if ((((MediaSelectorPanel.ListPhotoViewHolder)localObject).e() == this.a.getMediaList().size() - 1) && (paramAbsListView.getBottom() <= this.a.getHeight())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localMediaSelectorPanel.setScrollToBottom(bool1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.ListPhotoViewHolder");
      }
    }
    paramAbsListView = MediaSelectorPanel.b(this.a).getChildAt(0);
    if (paramAbsListView != null)
    {
      localObject = paramAbsListView.getTag();
      if (localObject != null)
      {
        localObject = (MediaSelectorPanel.ListPhotoViewHolder)localObject;
        localMediaSelectorPanel = this.a;
        if ((((MediaSelectorPanel.ListPhotoViewHolder)localObject).e() == 0) && (paramAbsListView.getTop() == 0)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localMediaSelectorPanel.setScrollToTop(bool1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.ListPhotoViewHolder");
    }
  }
  
  public void onScrollStateChanged(@NotNull AbsListView paramAbsListView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.1
 * JD-Core Version:    0.7.0.1
 */