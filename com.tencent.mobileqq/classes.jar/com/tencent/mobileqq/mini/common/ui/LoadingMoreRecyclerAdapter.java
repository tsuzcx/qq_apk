package com.tencent.mobileqq.mini.common.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter;", "()V", "mHasMore", "", "mLoadMoreListener", "Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter$OnLoadMoreListener;", "mLoadSuccess", "mLoadingMoreFooter", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "layoutInflater", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "Lcom/tencent/mobileqq/mini/common/ui/ViewFactory;", "mLoadingMoreFooter$annotations", "mPendingBindingLoadMoreStateToLoadMoreFooterView", "mShowLoadingMore", "canLoadMore", "view", "createLoadingMoreFooterView", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindLoadStatusToLoadMoreView", "success", "hasMore", "onCustomizeLoadLayout", "loadLayout", "Lcom/tencent/mobileqq/mini/common/ui/LoadLayout;", "onLoadFooterShown", "onLoadFooterShown$qqmini_impl_release", "onLoadMore", "performSetLoadingMoreVisible", "show", "setLoadMoreListener", "listener", "setLoadingComplete", "setShowLoadingMore", "Companion", "OnLoadMoreListener", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public abstract class LoadingMoreRecyclerAdapter<T extends RecyclerView.ViewHolder>
  extends RecyclerWrapperAdapter<T>
{
  public static final LoadingMoreRecyclerAdapter.Companion Companion = new LoadingMoreRecyclerAdapter.Companion(null);
  private static final String TAG = "LoadingMoreRecyclerAdapter";
  public static final int VIEW_TYPE_LOAD_MORE = -2147482623;
  private boolean mHasMore;
  private LoadingMoreRecyclerAdapter.OnLoadMoreListener mLoadMoreListener;
  private boolean mLoadSuccess = true;
  private final Function2<LayoutInflater, ViewGroup, View> mLoadingMoreFooter = (Function2)new LoadingMoreRecyclerAdapter.mLoadingMoreFooter.1((LoadingMoreRecyclerAdapter)this);
  private boolean mPendingBindingLoadMoreStateToLoadMoreFooterView;
  private boolean mShowLoadingMore = true;
  
  private final void performSetLoadingMoreVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!isFooterAdded(-2147482623)) {
        addFooter(this.mLoadingMoreFooter, -2147482623, (RecyclerWrapperAdapter.OnShowListener)new LoadingMoreRecyclerAdapter.performSetLoadingMoreVisible.1(this));
      }
    }
    else {
      removeFooter(-2147482623);
    }
  }
  
  protected boolean canLoadMore(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if ((paramView instanceof LoadLayout))
    {
      int i = ((LoadLayout)paramView).getState();
      if ((i != 4) && (i != 0)) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  protected View createLoadingMoreFooterView(@NotNull LayoutInflater paramLayoutInflater, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "layoutInflater");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    paramLayoutInflater = new Ref.ObjectRef();
    paramLayoutInflater.element = ((LoadLayout)null);
    paramViewGroup = paramViewGroup.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "parent.context");
    paramViewGroup = new LoadLayout(paramViewGroup, (Runnable)new LoadingMoreRecyclerAdapter.createLoadingMoreFooterView.loadLayout.1(this, paramLayoutInflater));
    paramLayoutInflater.element = paramViewGroup;
    paramViewGroup.setState(1);
    onCustomizeLoadLayout(paramViewGroup);
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    return (View)paramViewGroup;
  }
  
  public void onAttachedToRecyclerView(@NotNull RecyclerView paramRecyclerView)
  {
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "recyclerView");
    super.onAttachedToRecyclerView(paramRecyclerView);
    performSetLoadingMoreVisible(this.mShowLoadingMore);
  }
  
  protected void onBindLoadStatusToLoadMoreView(boolean paramBoolean1, boolean paramBoolean2, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if ((paramView instanceof LoadLayout))
    {
      int j = 3;
      int i = j;
      if (paramBoolean1) {
        if (paramBoolean2) {
          i = j;
        } else {
          i = 4;
        }
      }
      ((LoadLayout)paramView).setState(i);
    }
  }
  
  public void onCustomizeLoadLayout(@NotNull LoadLayout paramLoadLayout)
  {
    Intrinsics.checkParameterIsNotNull(paramLoadLayout, "loadLayout");
  }
  
  public final void onLoadFooterShown$qqmini_impl_release(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (this.mPendingBindingLoadMoreStateToLoadMoreFooterView)
    {
      onBindLoadStatusToLoadMoreView(this.mLoadSuccess, this.mHasMore, paramView);
      this.mPendingBindingLoadMoreStateToLoadMoreFooterView = false;
    }
    if (canLoadMore(paramView)) {
      onLoadMore(paramView);
    }
  }
  
  public void onLoadMore(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if ((paramView instanceof LoadLayout)) {
      ((LoadLayout)paramView).setState(2);
    }
    paramView = this.mLoadMoreListener;
    if (paramView != null) {
      paramView.onNeedLoadMore();
    }
  }
  
  public final void setLoadMoreListener(@Nullable LoadingMoreRecyclerAdapter.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.mLoadMoreListener = paramOnLoadMoreListener;
  }
  
  public final void setLoadingComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mLoadSuccess = paramBoolean1;
    this.mHasMore = paramBoolean2;
    int j = findFooterIndex(-2147482623);
    if (j != -1)
    {
      RecyclerView localRecyclerView = getAttachedRecyclerView();
      if ((localRecyclerView != null) && (localRecyclerView.getChildCount() > 0))
      {
        int i = localRecyclerView.getChildCount() - 1;
        while (i <= 0)
        {
          View localView = localRecyclerView.getChildAt(i);
          RecyclerView.ViewHolder localViewHolder = localRecyclerView.getChildViewHolder(localView);
          Intrinsics.checkExpressionValueIsNotNull(localViewHolder, "rv.getChildViewHolder(child)");
          if (localViewHolder.getAdapterPosition() == j)
          {
            Intrinsics.checkExpressionValueIsNotNull(localView, "child");
            onBindLoadStatusToLoadMoreView(paramBoolean1, paramBoolean2, localView);
            return;
          }
          i += 1;
        }
      }
    }
    this.mPendingBindingLoadMoreStateToLoadMoreFooterView = true;
    notifyItemChanged(j);
  }
  
  public final void setShowLoadingMore(boolean paramBoolean)
  {
    this.mShowLoadingMore = paramBoolean;
    if (getAttachedRecyclerView() != null) {
      performSetLoadingMoreVisible(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */