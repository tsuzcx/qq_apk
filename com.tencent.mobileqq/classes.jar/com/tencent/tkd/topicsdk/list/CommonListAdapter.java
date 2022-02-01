package com.tencent.tkd.topicsdk.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/list/CommonListAdapter;", "BEAN", "HOLDER", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "mList", "", "bindViewHolder", "", "position", "", "bean", "holder", "itemView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "(ILjava/lang/Object;Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;Landroid/view/View;Landroid/view/ViewGroup;)V", "createView", "viewGroup", "createViewHolder", "(Landroid/content/Context;Landroid/view/View;Landroid/view/ViewGroup;)Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "getCount", "getItem", "", "getItemId", "", "getView", "convertView", "BaseListViewHolder", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public abstract class CommonListAdapter<BEAN, HOLDER extends CommonListAdapter.BaseListViewHolder>
  extends BaseAdapter
{
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private List<BEAN> jdField_a_of_type_JavaUtilList;
  
  public CommonListAdapter(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
  }
  
  @NotNull
  public final Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  @NotNull
  public abstract View a(@NotNull Context paramContext, @Nullable ViewGroup paramViewGroup);
  
  @NotNull
  public abstract HOLDER a(@NotNull Context paramContext, @NotNull View paramView, @Nullable ViewGroup paramViewGroup);
  
  @NotNull
  public final List<BEAN> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public abstract void a(int paramInt, BEAN paramBEAN, @NotNull HOLDER paramHOLDER, @NotNull View paramView, @Nullable ViewGroup paramViewGroup);
  
  public final void a(@NotNull List<? extends BEAN> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @NotNull
  public Object getItem(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
    }
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      localObject = a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup);
      paramView.setTag(localObject);
    }
    for (;;)
    {
      a(paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), (CommonListAdapter.BaseListViewHolder)localObject, paramView, paramViewGroup);
      return paramView;
      localObject = paramView.getTag();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type HOLDER");
      }
      localObject = (CommonListAdapter.BaseListViewHolder)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.list.CommonListAdapter
 * JD-Core Version:    0.7.0.1
 */