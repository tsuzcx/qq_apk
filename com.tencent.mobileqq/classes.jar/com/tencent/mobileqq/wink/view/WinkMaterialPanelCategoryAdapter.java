package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.utils.AdapterUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class WinkMaterialPanelCategoryAdapter
  extends RecyclerView.Adapter<WinkMaterialPanelCategoryAdapter.CategoryItemVH>
{
  private RecyclerView a;
  private final List<MetaCategory> b;
  private final WinkMaterialPanelCategoryAdapter.ItemListener c;
  private int d = 0;
  
  public WinkMaterialPanelCategoryAdapter(List<MetaCategory> paramList, WinkMaterialPanelCategoryAdapter.ItemListener paramItemListener)
  {
    this.b = paramList;
    this.c = paramItemListener;
  }
  
  public WinkMaterialPanelCategoryAdapter.CategoryItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WinkMaterialPanelCategoryAdapter.CategoryItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628259, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      AdapterUtils.a(this.a, this.d, paramInt);
    }
    this.d = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(WinkMaterialPanelCategoryAdapter.CategoryItemVH paramCategoryItemVH, int paramInt)
  {
    MetaCategory localMetaCategory = (MetaCategory)this.b.get(paramInt);
    this.c.a(paramInt, localMetaCategory);
    if (localMetaCategory != null) {
      paramCategoryItemVH.a.setText(localMetaCategory.name);
    }
    if (this.d == paramInt)
    {
      paramCategoryItemVH.a.setTextColor(paramCategoryItemVH.itemView.getContext().getResources().getColor(2131165865));
      paramCategoryItemVH.a.setTypeface(Typeface.defaultFromStyle(1));
    }
    else
    {
      paramCategoryItemVH.a.setTextColor(paramCategoryItemVH.itemView.getContext().getResources().getColor(2131165866));
      paramCategoryItemVH.a.setTypeface(Typeface.defaultFromStyle(0));
    }
    paramCategoryItemVH.a.setOnClickListener(new WinkMaterialPanelCategoryAdapter.1(this, paramInt, localMetaCategory));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramCategoryItemVH, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.a = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanelCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */