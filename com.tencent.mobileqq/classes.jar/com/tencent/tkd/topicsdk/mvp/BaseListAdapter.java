package com.tencent.tkd.topicsdk.mvp;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "BEAN", "Landroid/widget/BaseAdapter;", "()V", "value", "", "dataList", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "mList", "", "getCount", "", "getItem", "position", "(I)Ljava/lang/Object;", "getItemId", "", "Companion", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public abstract class BaseListAdapter<BEAN>
  extends BaseAdapter
{
  public static final BaseListAdapter.Companion a = new BaseListAdapter.Companion(null);
  private List<BEAN> b = (List)new ArrayList();
  
  @NotNull
  public final List<BEAN> a()
  {
    return this.b;
  }
  
  public final void a(@NotNull List<? extends BEAN> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    this.b.clear();
    this.b.addAll((Collection)paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return a().size();
  }
  
  public BEAN getItem(int paramInt)
  {
    return a().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.BaseListAdapter
 * JD-Core Version:    0.7.0.1
 */