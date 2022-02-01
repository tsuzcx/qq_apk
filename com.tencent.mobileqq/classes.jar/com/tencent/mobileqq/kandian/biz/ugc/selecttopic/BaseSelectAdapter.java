package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter;", "BEAN", "HOLDER", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "dataList", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "mDataList", "", "bindViewHolder", "", "bean", "holder", "(Ljava/lang/Object;Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;)V", "createView", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "createViewHolder", "itemView", "(Landroid/content/Context;Landroid/view/View;)Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "convertView", "parent", "BaseSelectViewHolder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseSelectAdapter<BEAN, HOLDER extends BaseSelectAdapter.BaseSelectViewHolder>
  extends BaseAdapter
{
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private List<BEAN> jdField_a_of_type_JavaUtilList;
  
  public BaseSelectAdapter(@NotNull Context paramContext)
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
  public abstract HOLDER a(@NotNull Context paramContext, @NotNull View paramView);
  
  @NotNull
  public final List<BEAN> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public abstract void a(BEAN paramBEAN, @NotNull HOLDER paramHOLDER);
  
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
    if (localObject != null) {
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @NotNull
  public View getView(int paramInt, @Nullable View paramView, @Nullable ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      paramViewGroup = this.jdField_a_of_type_AndroidContentContext;
      if (paramView != null)
      {
        paramViewGroup = a(paramViewGroup, (View)paramView);
        paramView.setTag(paramViewGroup);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    else
    {
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null) {
        break label85;
      }
      paramViewGroup = (BaseSelectAdapter.BaseSelectViewHolder)paramViewGroup;
    }
    a(this.jdField_a_of_type_JavaUtilList.get(paramInt), paramViewGroup);
    return paramView;
    label85:
    throw new TypeCastException("null cannot be cast to non-null type HOLDER");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.BaseSelectAdapter
 * JD-Core Version:    0.7.0.1
 */