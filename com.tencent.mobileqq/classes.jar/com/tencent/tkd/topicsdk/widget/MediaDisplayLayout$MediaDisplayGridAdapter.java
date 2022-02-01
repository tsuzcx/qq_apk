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
    Object localObject = this.a.a().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "displayItems[position]");
    return (DisplayItem)localObject;
  }
  
  public int getCount()
  {
    return this.a.a().size();
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
      paramView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.t, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "LayoutInflater.from(cont…ay_layout, parent, false)");
      paramViewGroup = this.a;
      if (paramView == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      paramViewGroup = new MediaDisplayLayout.DisplayViewHolder(paramViewGroup, (ViewGroup)paramView);
      ((ViewGroup)paramView).setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a(a(paramInt));
      paramViewGroup.a().setOnClickListener((View.OnClickListener)new MediaDisplayLayout.MediaDisplayGridAdapter.getView.2(this, paramInt));
      paramViewGroup.a().setOnClickListener((View.OnClickListener)new MediaDisplayLayout.MediaDisplayGridAdapter.getView.3(this, paramInt));
      if (!this.a.a()) {
        break;
      }
      paramViewGroup.b().setOnClickListener((View.OnClickListener)new MediaDisplayLayout.MediaDisplayGridAdapter.getView.4(this, paramInt));
      return paramView;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.DisplayViewHolder");
      }
      paramViewGroup = (MediaDisplayLayout.DisplayViewHolder)paramViewGroup;
    }
    paramViewGroup.b().setVisibility(8);
    paramViewGroup.b().setOnClickListener(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.MediaDisplayLayout.MediaDisplayGridAdapter
 * JD-Core Version:    0.7.0.1
 */