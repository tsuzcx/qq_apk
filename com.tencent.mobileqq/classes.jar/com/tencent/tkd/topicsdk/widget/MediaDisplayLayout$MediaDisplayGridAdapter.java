package com.tencent.tkd.topicsdk.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout$MediaDisplayGridAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/tkd/topicsdk/widget/MediaDisplayLayout;)V", "getCount", "", "getItem", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaDisplayLayout$MediaDisplayGridAdapter
  extends BaseAdapter
{
  @NotNull
  public DisplayItem a(int paramInt)
  {
    Object localObject = this.a.getDisplayItems().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "displayItems[position]");
    return (DisplayItem)localObject;
  }
  
  public int getCount()
  {
    return this.a.getDisplayItems().size();
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
      paramView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.n, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "LayoutInflater.from(cont…ay_layout, parent, false)");
      paramViewGroup = this.a;
      if (paramView != null)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        paramViewGroup = new MediaDisplayLayout.DisplayViewHolder(paramViewGroup, localViewGroup);
        localViewGroup.setTag(paramViewGroup);
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
        break label193;
      }
      paramViewGroup = (MediaDisplayLayout.DisplayViewHolder)paramViewGroup;
    }
    paramViewGroup.a(a(paramInt));
    paramViewGroup.a().setOnClickListener((View.OnClickListener)new MediaDisplayLayout.MediaDisplayGridAdapter.getView.1(this, paramInt));
    paramViewGroup.c().setOnClickListener((View.OnClickListener)new MediaDisplayLayout.MediaDisplayGridAdapter.getView.2(this, paramInt));
    if (this.a.getShowDelImage())
    {
      paramViewGroup.b().setVisibility(0);
      paramViewGroup.b().setOnClickListener((View.OnClickListener)new MediaDisplayLayout.MediaDisplayGridAdapter.getView.3(this, paramInt));
      return paramView;
    }
    paramViewGroup.b().setVisibility(8);
    paramViewGroup.b().setOnClickListener(null);
    return paramView;
    label193:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.DisplayViewHolder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.MediaDisplayGridAdapter
 * JD-Core Version:    0.7.0.1
 */