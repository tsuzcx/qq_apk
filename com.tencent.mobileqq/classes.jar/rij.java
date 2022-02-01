import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter;", "BEAN", "HOLDER", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "dataList", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "mDataList", "", "bindViewHolder", "", "bean", "holder", "(Ljava/lang/Object;Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;)V", "createView", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "createViewHolder", "itemView", "(Landroid/content/Context;Landroid/view/View;)Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "convertView", "parent", "BaseSelectViewHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class rij<BEAN, HOLDER extends rik>
  extends BaseAdapter
{
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private List<BEAN> jdField_a_of_type_JavaUtilList;
  
  public rij(@NotNull Context paramContext)
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
  public final List<BEAN> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @NotNull
  public abstract HOLDER a(@NotNull Context paramContext, @NotNull View paramView);
  
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
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if (localView == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      localObject = a((Context)localObject, (View)localView);
      localView.setTag(localObject);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilList.get(paramInt), (rik)localObject);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = paramView.getTag();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type HOLDER");
      }
      localObject = (rik)localObject;
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rij
 * JD-Core Version:    0.7.0.1
 */