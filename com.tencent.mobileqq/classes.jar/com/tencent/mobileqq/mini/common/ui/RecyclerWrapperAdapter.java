package com.tencent.mobileqq.mini.common.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "<set-?>", "Landroidx/recyclerview/widget/RecyclerView;", "attachedRecyclerView", "getAttachedRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "footerCount", "", "getFooterCount", "()I", "headerCount", "getHeaderCount", "mFooters", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "layoutInflater", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "Lcom/tencent/mobileqq/mini/common/ui/ViewFactory;", "Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$OnShowListener;", "Lkotlin/collections/ArrayList;", "mHeaders", "addFooter", "", "viewFactory", "viewType", "showHideListener", "addFooterAt", "position", "addHeader", "addHeaderAt", "createDecorViewHolder", "list", "", "pos", "doGetItemCount", "doGetItemViewType", "doOnBindViewHolder", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "doOnCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "doOnViewRecycled", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "findFooterIndex", "headerViewType", "findHeaderIndex", "getItemCount", "getItemViewType", "isFooterAdded", "", "footerViewType", "isFooterPosition", "isHeaderAdded", "isHeaderPosition", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onViewRecycled", "removeFooter", "removeHeader", "Companion", "OnShowListener", "SimpleViewHolder", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public abstract class RecyclerWrapperAdapter<T extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static final RecyclerWrapperAdapter.Companion Companion = new RecyclerWrapperAdapter.Companion(null);
  private static final int HEADER_FOOTER_MAX_COUNT = 1024;
  public static final int VIEW_TYPE_FOOTER_BEGIN = -2147482623;
  public static final int VIEW_TYPE_FOOTER_END = -2147481599;
  public static final int VIEW_TYPE_HEADER_BEGIN = -2147483648;
  public static final int VIEW_TYPE_HEADER_END = -2147482624;
  @Nullable
  private RecyclerView attachedRecyclerView;
  private final ArrayList<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, RecyclerWrapperAdapter.OnShowListener>> mFooters = new ArrayList();
  private final ArrayList<Triple<Function2<LayoutInflater, ViewGroup, View>, Integer, RecyclerWrapperAdapter.OnShowListener>> mHeaders = new ArrayList();
  
  private final RecyclerView.ViewHolder createDecorViewHolder(List<? extends Triple<? extends Function2<? super LayoutInflater, ? super ViewGroup, ? extends View>, Integer, ? extends RecyclerWrapperAdapter.OnShowListener>> paramList, int paramInt, ViewGroup paramViewGroup)
  {
    paramList = (Triple)paramList.get(paramInt);
    Function2 localFunction2 = (Function2)paramList.getFirst();
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    Intrinsics.checkExpressionValueIsNotNull(localLayoutInflater, "LayoutInflater.from(parent.context)");
    return (RecyclerView.ViewHolder)new RecyclerWrapperAdapter.SimpleViewHolder((View)localFunction2.invoke(localLayoutInflater, paramViewGroup), (RecyclerWrapperAdapter.OnShowListener)paramList.getThird());
  }
  
  public final void addFooter(@NotNull Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> paramFunction2, int paramInt, @Nullable RecyclerWrapperAdapter.OnShowListener paramOnShowListener)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "viewFactory");
    addFooterAt(paramFunction2, paramInt, paramOnShowListener, getFooterCount());
  }
  
  public final void addFooterAt(@NotNull Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> paramFunction2, int paramInt1, @Nullable RecyclerWrapperAdapter.OnShowListener paramOnShowListener, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "viewFactory");
    if ((-2147482623 <= paramInt1) && (-2147481599 >= paramInt1))
    {
      RecyclerWrapperAdapter.Companion.access$checkAdd(Companion, (List)this.mFooters, paramInt1);
      this.mFooters.add(paramInt2, new Triple(paramFunction2, Integer.valueOf(paramInt1), paramOnShowListener));
      notifyItemInserted(getHeaderCount() + doGetItemCount() + paramInt2);
      return;
    }
    throw ((Throwable)new IllegalArgumentException("footer view type must in [VIEW_TYPE_FOOTER_BEGIN, VIEW_TYPE_FOOTER_END]"));
  }
  
  public final int addHeader(@NotNull Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> paramFunction2, int paramInt, @Nullable RecyclerWrapperAdapter.OnShowListener paramOnShowListener)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "viewFactory");
    addHeaderAt(paramFunction2, paramInt, paramOnShowListener, getHeaderCount());
    return getHeaderCount();
  }
  
  public final void addHeaderAt(@NotNull Function2<? super LayoutInflater, ? super ViewGroup, ? extends View> paramFunction2, int paramInt1, @Nullable RecyclerWrapperAdapter.OnShowListener paramOnShowListener, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "viewFactory");
    if ((-2147483648 <= paramInt1) && (-2147482624 >= paramInt1))
    {
      RecyclerWrapperAdapter.Companion.access$checkAdd(Companion, (List)this.mHeaders, paramInt1);
      this.mHeaders.add(paramInt2, new Triple(paramFunction2, Integer.valueOf(paramInt1), paramOnShowListener));
      notifyItemInserted(paramInt2);
      return;
    }
    throw ((Throwable)new IllegalArgumentException("header view type must in [VIEW_TYPE_HEADER_BEGIN, VIEW_TYPE_HEADER_END]"));
  }
  
  public abstract int doGetItemCount();
  
  public int doGetItemViewType(int paramInt)
  {
    return 0;
  }
  
  public abstract void doOnBindViewHolder(@NotNull T paramT, int paramInt);
  
  @NotNull
  public abstract T doOnCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt);
  
  public void doOnViewRecycled(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "holder");
  }
  
  public final int findFooterIndex(int paramInt)
  {
    Object localObject = Companion;
    localObject = ((List)this.mFooters).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt))) {
        break label62;
      }
      i += 1;
    }
    i = -1;
    label62:
    if (i == -1) {
      return -1;
    }
    return getHeaderCount() + doGetItemCount() + i;
  }
  
  public final int findHeaderIndex(int paramInt)
  {
    Object localObject = Companion;
    localObject = ((List)this.mHeaders).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @Nullable
  public final RecyclerView getAttachedRecyclerView()
  {
    return this.attachedRecyclerView;
  }
  
  public final int getFooterCount()
  {
    return this.mFooters.size();
  }
  
  public final int getHeaderCount()
  {
    return this.mHeaders.size();
  }
  
  public final int getItemCount()
  {
    return getHeaderCount() + getFooterCount() + doGetItemCount();
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (paramInt < getHeaderCount()) {
      return ((Number)((Triple)this.mHeaders.get(paramInt)).getSecond()).intValue();
    }
    if (paramInt >= getHeaderCount() + doGetItemCount()) {
      return ((Number)((Triple)this.mFooters.get(paramInt - (getHeaderCount() + doGetItemCount()))).getSecond()).intValue();
    }
    paramInt = doGetItemViewType(paramInt - getHeaderCount());
    if (paramInt > -2147481599) {
      return paramInt;
    }
    throw ((Throwable)new IllegalStateException("view type ranged in [-2147483648, -2147481599] are reserved for footer and header!"));
  }
  
  public final boolean isFooterAdded(int paramInt)
  {
    Object localObject = Companion;
    localObject = ((List)this.mFooters).iterator();
    boolean bool = false;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt))) {
        break label68;
      }
      i += 1;
    }
    i = -1;
    label68:
    if (i != -1) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean isFooterPosition(int paramInt)
  {
    return paramInt >= getHeaderCount() + doGetItemCount();
  }
  
  public final boolean isHeaderAdded(int paramInt)
  {
    Object localObject = Companion;
    localObject = ((List)this.mHeaders).iterator();
    boolean bool = false;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt))) {
        break label68;
      }
      i += 1;
    }
    i = -1;
    label68:
    if (i != -1) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean isHeaderPosition(int paramInt)
  {
    int i = getHeaderCount();
    return (paramInt >= 0) && (i - 1 >= paramInt);
  }
  
  @CallSuper
  public void onAttachedToRecyclerView(@NotNull RecyclerView paramRecyclerView)
  {
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "recyclerView");
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.attachedRecyclerView = paramRecyclerView;
  }
  
  public final void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    if ((!isHeaderPosition(paramInt)) && (!isFooterPosition(paramInt)))
    {
      doOnBindViewHolder(paramViewHolder, paramInt - getHeaderCount());
      return;
    }
    ((RecyclerWrapperAdapter.SimpleViewHolder)paramViewHolder).onShow();
  }
  
  @NotNull
  public final RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    int j = -1;
    int k = 0;
    int i = 0;
    Object localObject;
    if ((-2147483648 <= paramInt) && (-2147482624 >= paramInt))
    {
      localObject = Companion;
      localObject = ((List)this.mHeaders).iterator();
      for (;;)
      {
        k = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt)))
        {
          k = i;
          break;
        }
        i += 1;
      }
      if (k >= 0) {
        return createDecorViewHolder((List)this.mHeaders, k, paramViewGroup);
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("can't find header for type:");
      paramViewGroup.append(paramInt);
      throw ((Throwable)new IllegalStateException(paramViewGroup.toString()));
    }
    if ((-2147482623 <= paramInt) && (-2147481599 >= paramInt))
    {
      localObject = Companion;
      localObject = ((List)this.mFooters).iterator();
      i = k;
      for (;;)
      {
        k = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt)))
        {
          k = i;
          break;
        }
        i += 1;
      }
      if (k >= 0) {
        return createDecorViewHolder((List)this.mFooters, k, paramViewGroup);
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("can't find footer for type:");
      paramViewGroup.append(paramInt);
      throw ((Throwable)new IllegalStateException(paramViewGroup.toString()));
    }
    return doOnCreateViewHolder(paramViewGroup, paramInt);
  }
  
  @CallSuper
  public void onDetachedFromRecyclerView(@NotNull RecyclerView paramRecyclerView)
  {
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "recyclerView");
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.attachedRecyclerView = ((RecyclerView)null);
  }
  
  public final void onViewRecycled(@NotNull RecyclerView.ViewHolder paramViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "holder");
    if (paramViewHolder.getItemViewType() > -2147481599) {
      doOnViewRecycled(paramViewHolder);
    }
  }
  
  public final void removeFooter(int paramInt)
  {
    Object localObject = Companion;
    localObject = ((List)this.mFooters).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt))) {
        break label62;
      }
      i += 1;
    }
    i = -1;
    label62:
    if (i != -1)
    {
      this.mFooters.remove(i);
      notifyItemRemoved(getHeaderCount() + doGetItemCount() + i);
    }
  }
  
  public final void removeHeader(int paramInt)
  {
    Object localObject = Companion;
    localObject = ((List)this.mHeaders).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt))) {
        break label62;
      }
      i += 1;
    }
    i = -1;
    label62:
    if (i != -1)
    {
      this.mHeaders.remove(i);
      notifyItemRemoved(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter
 * JD-Core Version:    0.7.0.1
 */