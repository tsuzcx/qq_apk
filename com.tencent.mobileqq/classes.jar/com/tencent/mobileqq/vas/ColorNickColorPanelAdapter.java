package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ColorNickColorPanelAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int = -1;
  public Drawable a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ColorNickColorPanelAdapter.OnColorSelectListener jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener;
  public ColorNickColorPanelAdapter.PureColorAdapter a;
  private ArrayList<ColorNickColorPanelAdapter.ColorItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public ColorNickColorPanelAdapter(Context paramContext, ColorNickColorPanelAdapter.OnColorSelectListener paramOnColorSelectListener)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener = paramOnColorSelectListener;
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter = new ColorNickColorPanelAdapter.PureColorAdapter();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130847441);
    this.jdField_b_of_type_Int = DisplayUtil.a(paramContext, 2.0F);
  }
  
  public ColorNickColorPanelAdapter.ColorItem a(int paramInt)
  {
    return (ColorNickColorPanelAdapter.ColorItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    if (i > 0) {
      notifyItemChanged(i);
    }
    if (this.jdField_a_of_type_Int > 0) {
      notifyItemChanged(this.jdField_a_of_type_Int);
    }
    if (paramInt > 0) {
      this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter.a(-1);
    }
  }
  
  public void a(List<ColorNickColorPanelAdapter.ColorItem> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ColorNickColorPanelAdapter.ColorItem(4, null, 0, null));
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    ColorNickColorPanelAdapter.ColorItem localColorItem = (ColorNickColorPanelAdapter.ColorItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localColorItem.jdField_a_of_type_Int == 3) {
      return localColorItem.jdField_b_of_type_Int;
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ColorNickColorPanelAdapter.ColorItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new ColorNickColorPanelAdapter.1(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1 = (ColorNickColorPanelAdapter.ColorItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    switch (((ColorNickColorPanelAdapter.ColorItem)localObject1).jdField_a_of_type_Int)
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
        return;
        if ((paramViewHolder instanceof ColorNickColorPanelAdapter.TitleViewHolder))
        {
          localObject2 = (ColorNickColorPanelAdapter.TitleViewHolder)paramViewHolder;
          if (((ColorNickColorPanelAdapter.TitleViewHolder)localObject2).jdField_a_of_type_Int == 1) {
            ((ColorNickColorPanelAdapter.TitleViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(((ColorNickColorPanelAdapter.ColorItem)localObject1).jdField_a_of_type_JavaLangString);
          }
        }
      }
    } while (!(paramViewHolder instanceof ColorNickColorPanelAdapter.GradientViewHolder));
    Object localObject2 = (ColorNickColorPanelAdapter.GradientViewHolder)paramViewHolder;
    ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).jdField_a_of_type_Int = paramInt;
    Object localObject3 = (GridLayoutManager.LayoutParams)((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).itemView.getLayoutParams();
    if (paramInt % 3 == 0)
    {
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = 0;
      label139:
      if (paramInt != this.jdField_a_of_type_Int) {
        break label213;
      }
      ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).b.setVisibility(0);
    }
    for (;;)
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localObject1 = URLDrawable.getDrawable(((ColorNickColorPanelAdapter.ColorItem)localObject1).jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject3);
      ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break;
      ((GridLayoutManager.LayoutParams)localObject3).rightMargin = this.jdField_b_of_type_Int;
      break label139;
      label213:
      ((ColorNickColorPanelAdapter.GradientViewHolder)localObject2).b.setVisibility(8);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new ColorNickColorPanelAdapter.TitleViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562046, paramViewGroup, false), 1);
    case 3: 
      return new ColorNickColorPanelAdapter.GradientViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562047, paramViewGroup, false), this, this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener);
    case 2: 
      return new ColorNickColorPanelAdapter.PureColorViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562049, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener, this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter, this);
    }
    return new ColorNickColorPanelAdapter.TitleViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562045, paramViewGroup, false), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter
 * JD-Core Version:    0.7.0.1
 */